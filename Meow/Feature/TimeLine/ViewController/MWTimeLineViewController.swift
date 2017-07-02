//
//  ViewController.swift
//  Meow
//
//  Created by Broccoli on 2017/6/29.
//  Copyright © 2017年 broccoliii. All rights reserved.
//

import UIKit
import RxSwift

class MWTimeLineViewController: UIViewController {
    let disposeBag = DisposeBag()
    override func viewDidLoad() {
        super.viewDidLoad()
        
        searchData()
    }
    
    func searchData() {
        
        
        GiphyProvider.request(.search(query:"cat", limit:2, offset:0))
            .mapImageInfoArray(ImageInfo.self)
            .subscribe(
                onNext: { items in
                    for item in items {
                        print(item)
                    }
            }, onError: { error in
                print(error)
            }, onCompleted: {
                print("complete")
            }
                
            ).addDisposableTo(disposeBag)
    }
}

