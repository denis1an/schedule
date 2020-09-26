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
            HStack(){
                VStack{
                    Text(lesson.startOfLesson)
                        .font(.title3)
                        .fontWeight(.medium)
                    Spacer()
                    Text(lesson.endOfLesson)
                        .font(.subheadline)
                
                }.padding(.vertical)
                VStack(alignment: .leading){
                    HStack(alignment: .top){
                    Text(String(lesson.numOfLesson) + ". " + lesson.name)
                    }.font(.body)
                    
                    VStack(alignment: .leading){
                        Text(lesson.teacher)
                        Text(lesson.type)
                        Text(lesson.audience).foregroundColor(Color.blue)
                    }.font(.subheadline)
                }
            }
        }
    }
}

struct LessonRow_Previews: PreviewProvider {
    static var previews: some View {
        Group {
            LessonRow(lesson: lessonData[0])
            LessonRow(lesson: lessonData[1])
        }.previewLayout(.fixed(width: 450, height: 100))
    }
}
