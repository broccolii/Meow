//
//  TimeLineInfo.swift
//  Meow
//
//  Created by Broccoli on 2017/7/2.
//  Copyright © 2017年 broccoliii. All rights reserved.
//

import UIKit
import ObjectMapper

struct ImageInfo : Mappable {
    var webpURL: String?
    var gifURL: String?
    var mp4URL: String?
    
    var webpSize: Int!
    var gifSize: Int!
    var mp4Size: Int!
    
    var height: Int!
    var width: Int!
    
    lazy var size: CGSize = {
        return CGSize(width: self.width ?? 0, height: self.height ?? 0)
    }()
    
    init?(map: Map) {
        
    }
  
    
    mutating func mapping(map: Map) {
        webpURL <- map["webp"]
        gifURL <- map["url"]
        mp4URL <- map["mp4"]
        
        
        let transform = TransformOf<Int, String>(fromJSON: { (value: String?) -> Int? in
            return Int(value!)
        }, toJSON: { (value: Int?) -> String? in
            if let value = value {
                return String(value)
            }
            return nil
        })
        
        webpSize <- (map["webp_size"], transform)
        gifSize <- (map["size"], transform)
        mp4Size <- (map["mp4_size"], transform)
        
        height <- (map["height"], transform)
        width <- (map["width"], transform)
    }
}
