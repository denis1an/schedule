//
//  LessonRow.swift
//  schedule-app
//
//  Created by Denis Andreev on 24.09.2020.
//

import SwiftUI

struct LessonRow: View {
    var lesson: Lesson
    var body: some View {
        VStack(alignment: .leading){
            HStack{
                Text(lesson.numOfLesson + ".")
                Text(lesson.name)
            }
            Text(lesson.dayOfWeek);
        }
    }
}

struct LessonRow_Previews: PreviewProvider {
    static var previews: some View {
        Group {
            LessonRow(lesson: lessonData[0])
        }
    }
}
