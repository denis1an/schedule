//
//  Lesson.swift
//  schedule-app
//
//  Created by Denis Andreev on 20.09.2020.
//
import SwiftUI
import CoreLocation

struct Lesson: Hashable, Codable {
    var id: String
    var name: String
    var city: String
    var park: String
}
