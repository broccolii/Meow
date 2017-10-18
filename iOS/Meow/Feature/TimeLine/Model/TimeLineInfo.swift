//
//  TimeLineInfo.swift
//  Meow
//
//  Created by Broccoli on 2017/7/2.
//  Copyright © 2017年 broccoliii. All rights reserved.
//

import UIKit
import ObjectMapper
import IGListKit

public class ImageInfo : NSObject, Mappable {
    var webpURL: String?
    var gifURL: String?
    var mp4URL: String?
    
    var webpSize: Int!
    var gifSize: Int!
    var mp4Size: Int!
    
    var height: CGFloat!
    var width: CGFloat!
    
    lazy var size: CGSize = {
        return CGSize(width: self.width ?? 0, height: self.height ?? 0)
    }()
    
    required public init?(map: Map) {
        
    }
  
    
    public func mapping(map: Map) {
        webpURL <- map["webp"]
        gifURL <- map["url"]
        mp4URL <- map["mp4"]
        
        
        let transformOfInt = TransformOf<Int, String>(fromJSON: { (value: String?) -> Int? in
            return Int(value!)
        }, toJSON: { (value: Int?) -> String? in
            if let value = value {
                return String(value)
            }
            return nil
        })
        
        
        let transformOfCGFloat = TransformOf<CGFloat, String>(fromJSON: { (value: String?) -> CGFloat? in
            return CGFloat((value! as NSString).doubleValue)
        }, toJSON: { (value: CGFloat?) -> String? in
            if let value = value {
                return String(describing: value)
            }
            return nil
        })
        
        webpSize <- (map["webp_size"], transformOfInt)
        gifSize <- (map["size"], transformOfInt)
        mp4Size <- (map["mp4_size"], transformOfInt)
        
        height <- (map["height"], transformOfCGFloat)
        width <- (map["width"], transformOfCGFloat)
    }
}

extension ImageInfo: ListDiffable {
    public func diffIdentifier() -> NSObjectProtocol {
        return self
    }
    
    public func isEqual(toDiffableObject object: ListDiffable?) -> Bool {
        return isEqual(object)
    }
}
