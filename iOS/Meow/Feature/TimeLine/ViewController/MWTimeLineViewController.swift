//
//  ViewController.swift
//  Meow
//
//  Created by Broccoli on 2017/6/29.
//  Copyright © 2017年 broccoliii. All rights reserved.
//

import UIKit
import RxSwift
import IGListKit
import MJRefresh

class MWTimeLineViewController: UIViewController {
    
    public var data = [ImageInfo]()
    
    public let disposeBag = DisposeBag()
    
    var pageNum = 0;
    
    lazy var adapter: ListAdapter = {
        return ListAdapter(updater: ListAdapterUpdater(), viewController: self)
    }()
    
    let collectionView: UICollectionView = {
        let layout = UICollectionViewFlowLayout()
        let collectionView = UICollectionView(frame: .zero, collectionViewLayout: layout)
        collectionView.backgroundColor = UIColor(red: 0.831372549, green: 0.945098039, blue: 0.964705882, alpha: 1)
        return collectionView
    }()
   
    override func viewDidLoad() {
        super.viewDidLoad()
        
        view.addSubview(collectionView)
        adapter.collectionView = collectionView
        adapter.dataSource = self
        
        collectionView.mj_header = MJRefreshNormalHeader(refreshingBlock: { 
            self.searchData(for: 0);
        });
        
        collectionView.mj_footer = MJRefreshAutoNormalFooter(refreshingBlock: { 
            self.searchData(for: self.pageNum);
        });
        
        collectionView.mj_header.beginRefreshing()
        
       
    }
    
    override func viewDidLayoutSubviews() {
        super.viewDidLayoutSubviews()
        collectionView.frame = CGRect(x: 0, y: 20, width: view.bounds.size.width, height: view.bounds.size.height)
    }
}

// MARK: ListAdapterDataSource
extension MWTimeLineViewController: ListAdapterDataSource {
    
    func objects(for listAdapter: ListAdapter) -> [ListDiffable] {
        return data as [ListDiffable]
    }
    
    func listAdapter(_ listAdapter: ListAdapter, sectionControllerFor object: Any) -> ListSectionController {
        return MWTimeLineSectionController();
    }
    
    func emptyView(for listAdapter: ListAdapter) -> UIView? { return nil }
}

// MARK: Data
extension MWTimeLineViewController {
    func searchData(for index: Int) {
        let offset = 20 * index
        
        _ = try! GiphyProvider.request(.search(query:"cat", limit:20, offset:offset))
            .mapImageInfoArray()
            .subscribe(onSuccess: { (items) in
                self.data = items
                self.adapter.performUpdates(animated: true, completion: nil)
                self.pageNum += 1;
            }, onError: { (error) in
                
            }).addDisposableTo(disposeBag)
    }
}
