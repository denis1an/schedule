//
//  LessonList.swift
//  schedule-app
//
//  Created by Denis Andreev on 26.09.2020.
//

import SwiftUI

struct LessonList: View {
    var body: some View {
        List(lessonData, id: \.numOfLesson){ lesson in
            LessonRow(lesson: lesson)
        }
    }
}

struct LessonList_Previews: PreviewProvider {
    static var previews: some View {
        ForEach(["iPhone SE", "iPhone 8", "iPhone 11"], id: \.self) { deviceName in
                   LessonList()
                        .previewDevice(PreviewDevice(rawValue: deviceName))
                }
    }
}
