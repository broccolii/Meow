//
//  TimeLineGifCell.swift
//  Meow
//
//  Created by Broccoli on 2017/7/31.
//  Copyright © 2017年 broccoliii. All rights reserved.
//

import UIKit
import SnapKit
import Kingfisher
import SwiftGif

class TimeLineCell: UICollectionViewCell {
    
    var imageURL: URL? {
        didSet {
            imageView.kf.setImage(with: imageURL?.downloadURL, placeholder: nil, options: nil, progressBlock: nil) { (image, error, cache, url) in
                self.imageView.image = image
            }
        }
    }
    
    private let imageView: AnimatedImageView = {
       let imageView = AnimatedImageView()
        return imageView
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        
        contentView.backgroundColor = .white
        
        contentView.addSubview(imageView)
        
        imageView.snp.makeConstraints { make in
            make.size.equalTo(contentView)
        }
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
}
