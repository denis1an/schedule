//
//  Lesson.swift
//  schedule-app
//
//  Created by Denis Andreev on 24.09.2020.
//

import Foundation

struct Lesson: Hashable,Codable {
    var name: String
    var teacher: String
    var type: String
    var dayOfWeek: String
    var audience: String
    var numOfLesson: Int
    var dates: [String]
    var startOfLesson: String
    var endOfLesson: String
}

