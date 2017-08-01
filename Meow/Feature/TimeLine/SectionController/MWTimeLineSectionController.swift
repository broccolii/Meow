//
//  MWTimeLineSectionController.swift
//  Meow
//
//  Created by Broccoli on 2017/7/31.
//  Copyright © 2017年 broccoliii. All rights reserved.
//

import Foundation
import IGListKit

final class MWTimeLineSectionController: ListSectionController {
    
    private var model: ImageInfo!
    
    override init() {
        super.init()
        inset = UIEdgeInsets(top: 5, left: 10, bottom: 5, right: 10)
        
        minimumLineSpacing = 20
    }
    
    override func sizeForItem(at index: Int) -> CGSize {
       let aspectRatio = model.width / model.height
        
        let cellWidth = collectionContext!.containerSize.width - 20.0
        let cellHeight = cellWidth / aspectRatio
        
        return CGSize(width: cellWidth, height: cellHeight)
    }
    
    override func cellForItem(at index: Int) -> UICollectionViewCell {
        guard let manualCell = collectionContext?.dequeueReusableCell(of: TimeLineCell.self,
                                                                      for: self,
                                                                      at: index) as? TimeLineCell else {
                                                                        fatalError()
        }
        manualCell.imageURL = URL(string: model.gifURL!)
        return manualCell
    }
    
    override func didUpdate(to object: Any) {
        self.model = object as? ImageInfo
    }
}
