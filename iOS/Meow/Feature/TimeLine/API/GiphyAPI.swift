//
//  GiphyAPI.swift
//  Meow
//
//  Created by Broccoli on 2017/6/29.
//  Copyright © 2017年 broccoliii. All rights reserved.
//

import UIKit
import Moya
import ObjectMapper
import RxSwift
import SwiftyJSON
import RxMoya

let GiphyProvider = RxMoyaProvider<Giphy>()

public enum Giphy {
    case search(query: String, limit: Int, offset: Int)
}

extension Giphy: TargetType {
    public var headers: [String : String]? {
        return nil
    }
    
    public var baseURL: URL {
        return URL(string: "https://api.giphy.com/")!
    }
    
    public var path: String {
        switch self {
        case .search:
            return "v1/gifs/search"
        }
    }
    
    public var method: Moya.Method {
        switch self {
        case .search:
            return .get
        }
    }
    
    public var parameters: [String: Any]? {
        switch self {
        case .search(let query, let limit, let offset):
            return ["api_key": "9dfbfbb0af284a4a8296e568dfd6f3f7",
                    "lang": "en",
                    "rating":"G",
                    "q":query,
                    "limit":limit,
                    "offset":offset]
        }
    }
    
    public var parameterEncoding: ParameterEncoding {
        return URLEncoding.default
    }
    
    public var task: Task {
        switch self {
        case .search:
            return .requestPlain
        }
    }
    
    public var sampleData: Data {
        switch self {
        case .search:
            return Data()
        }
    }
}

extension PrimitiveSequence where TraitType == SingleTrait, ElementType == Response {
    public func mapImageInfoArray() -> Single<[ImageInfo]> {
        return flatMap { response -> Single<[ImageInfo]> in
            let responseDataJSONArray = JSON(data: response.data)["data"]
            var originalImageJSONArray = [Any?]()

            for responseDataJSONObject in responseDataJSONArray.array! {
                originalImageJSONArray.append(responseDataJSONObject["images"]["original"].object)
            }

            let objects = try! Mapper<ImageInfo>().mapArray(JSONObject: originalImageJSONArray) ?? [ImageInfo]()
            
            return Single.just(objects)
        }
    }
}

//extension ObservableType where E == Response {
//    public func mapImageInfoArray<T: BaseMappable>(_ type: T.Type) -> Observable<[T]> {
//        return flatMap { response -> Observable<[T]> in
//            return Observable.just(try response.mapImageInfoArray(T.self))
//        }
//    }
//}

