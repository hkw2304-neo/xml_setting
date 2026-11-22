package com.hkw.a1016_socialservice.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/*
    @Module 바구니안에 @Provides 선언된 반환값(함수)이 등록되어 호출시 힐트가 찾는다
    @Singleton 해당 객체는 공유(재생성 x)
    @InstallIn(SingletonComponent::class) : 앱이 살아있을떄의 존재


    빌드 시(앱이 실행되기전 점검)
    hilt 가 @Module,@Inject 선언 코드를 읽어 자바로 생성하고
    앱이 실행되서 Provoide함수가 호출 시 객체를 Singleton 관리

    컴파일
    코드 문법 확인
    kt -> 바이트코드 변환
 */

@Module
@InstallIn(SingletonComponent::class)
object ApiUtil {

    @Provides
    @Singleton
    fun test(): String{
        return "Eee"
    }

}