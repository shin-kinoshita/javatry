/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.javatry.framework;

import org.docksidestage.bizfw.basic.objanimal.Animal;
import org.docksidestage.bizfw.basic.objanimal.Dog;
import org.docksidestage.bizfw.basic.supercar.SupercarDealer;
import org.docksidestage.bizfw.di.container.SimpleDiContainer;
import org.docksidestage.bizfw.di.nondi.NonDiDirectFirstAction;
import org.docksidestage.bizfw.di.nondi.NonDiDirectSecondAction;
import org.docksidestage.bizfw.di.nondi.NonDiFactoryMethodAction;
import org.docksidestage.bizfw.di.nondi.NonDiIndividualFactoryAction;
import org.docksidestage.bizfw.di.usingdi.*;
import org.docksidestage.bizfw.di.usingdi.settings.UsingDiModule;
import org.docksidestage.unit.PlainTestCase;

/**
 * The test of Dependency Injection (DI) as beginner level. <br>
 * Show answer by log() or write answer on comment for question of javadoc.
 * @author jflute
 * @author your_name_here
 */
public class Step41DependencyInjectionBeginnerTest extends PlainTestCase {

    // ===================================================================================
    //                                                                        Precondition
    //                                                                        ============
    /**
     * Search "Dependency Injection" by internet and learn it in thirty minutes. (study only) <br>
     * ("Dependency Injection" をインターネットで検索して、30分ほど学んでみましょう。(勉強のみ))
     */
    public void test_whatis_DependencyInjection() {
        // _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        // What is Dependency Injection?
        // - - - - - (your answer?)
        // 名前の通り、依存性の注入
        // 一つのソフトウェアの設計パターンであり、依存関係を外部の設定ファイルなどから注入する事ができるようになる。
        //
        // _/_/_/_/_/_/_/_/_/_/
    }

    // ===================================================================================
    //                                                                 Non DI Code Reading
    //                                                                 ===================
    /**
     * What is the difference between NonDiDirectFirstAction and NonDiDirectSecondAction? <br>
     * (NonDiDirectFirstAction と NonDiDirectSecondAction の違いは？)
     */
    public void test_nondi_difference_between_first_and_second() {
        // your answer? => NonDiDirectSecondAction は NonDiDirectFirstAction のメソッド処理の前後に特定の別の処理を追加したものである。
        // and your confirmation code here freely
        log("## start NonDiDirectFirstAction methods");
        NonDiDirectFirstAction nonDiDirectFirstAction = new NonDiDirectFirstAction();
        nonDiDirectFirstAction.callFriend();

        log("## start NonDiDirectSecondAction methods");
        NonDiDirectSecondAction nonDiDirectSecondAction = new NonDiDirectSecondAction();
        nonDiDirectSecondAction.callFriend();
    }

    /**
     * What is the difference between NonDiDirectSecondAction and NonDiFactoryMethodAction? <br>
     * (NonDiDirectSecondAction と NonDiFactoryMethodAction の違いは？)
     */
    public void test_nondi_difference_between_second_and_FactoryMethod() {
        // your answer? => NonDiFactoryMethodAction は Factory メソッドパターンを使う事で、別で処理を変更したいときにオーバーライドしやすい実装になっている（Animal, SupercarDealer など）
        // and your confirmation code here freely
        log("## start NonDiDirectSecondAction methods");
        NonDiDirectSecondAction nonDiDirectSecondAction = new NonDiDirectSecondAction();
        nonDiDirectSecondAction.callFriend();

        log("## start nonDiFactoryMethodAction methods");
        NonDiFactoryMethodAction nonDiFactoryMethodAction = new NonDiFactoryMethodAction();
        nonDiFactoryMethodAction.callFriend();
    }

    /**
     * What is the difference between NonDiFactoryMethodAction and NonDiIndividualFactoryAction? <br>
     * (NonDiFactoryMethodAction と NonDiIndividualFactoryAction の違いは？)
     */
    public void test_nondi_difference_between_FactoryMethod_and_IndividualFactory() {
        // your answer? => NonDiIndividualFactoryAction は Factory メソッドを別のクラスにうつす事で NonDiIndividualFactoryAction クラスの肥大化を抑える事ができる
        // and your confirmation code here freely
        log("## start nonDiFactoryMethodAction methods");
        NonDiFactoryMethodAction nonDiFactoryMethodAction = new NonDiFactoryMethodAction();
        nonDiFactoryMethodAction.callFriend();

        log("## start nonDiFactoryMethodAction methods");
        NonDiIndividualFactoryAction nonDiIndividualFactoryAction = new NonDiIndividualFactoryAction();
        nonDiIndividualFactoryAction.callFriend();
    }

    // ===================================================================================
    //                                                               Using DI Code Reading
    //                                                               =====================
    /**
     * What is the difference between UsingDiAccessorAction and UsingDiAnnotationAction? <br>
     * (UsingDiAccessorAction と UsingDiAnnotationAction の違いは？)
     */
    public void test_usingdi_difference_between_Accessor_and_Annotation() {
        // your answer? => UsingDiAccessorAction は setter で必要なオブジェクトをセットしているが、
        // UsingDiAnnotationAction はアノテーションが付与されているフィールドに DiContainer がオブジェクトを注入するようにしている
        // and your confirmation code here freely
        UsingDiAccessorAction usingDiAccessorAction = new UsingDiAccessorAction();
        usingDiAccessorAction.setAnimal(new Dog());
        usingDiAccessorAction.setSupercarDealer(new SupercarDealer());
        usingDiAccessorAction.callFriend();

        SimpleDiContainer diContainer = SimpleDiContainer.getInstance();
        diContainer.registerModule(componentMap -> {
            componentMap.put(UsingDiAnnotationAction.class, new UsingDiAnnotationAction());
            componentMap.put(Animal.class, new Dog());
            componentMap.put(SupercarDealer.class, new SupercarDealer());
        });
        diContainer.resolveDependency();

        UsingDiAnnotationAction usingDiAnnotationAction =
                ((UsingDiAnnotationAction) diContainer.getComponent(UsingDiAnnotationAction.class));
        usingDiAnnotationAction.callFriend();
    }

    /**
     * What is the difference between UsingDiAnnotationAction and UsingDiDelegatingAction? <br>
     * (UsingDiAnnotationAction と UsingDiDelegatingAction の違いは？)
     */
    public void test_usingdi_difference_between_Annotation_and_Delegating() {
        // your answer? => UsingDiDelegatingAction では DiContainer で注入したオブジェクトに関する処理を完全に UsingDiDelegatingLogic に委譲している
        // and your confirmation code here freely
        SimpleDiContainer diContainer = SimpleDiContainer.getInstance();
        diContainer.registerModule(componentMap -> {
            componentMap.put(UsingDiAnnotationAction.class, new UsingDiAnnotationAction());
            componentMap.put(UsingDiDelegatingAction.class, new UsingDiDelegatingAction());
            componentMap.put(UsingDiDelegatingLogic.class, new UsingDiDelegatingLogic());
            componentMap.put(Animal.class, new Dog());
            componentMap.put(SupercarDealer.class, new SupercarDealer());
        });
        diContainer.resolveDependency();

        UsingDiAnnotationAction usingDiAnnotationAction =
                ((UsingDiAnnotationAction) diContainer.getComponent(UsingDiAnnotationAction.class));
        UsingDiDelegatingAction usingDiDelegatingAction =
                ((UsingDiDelegatingAction) diContainer.getComponent(UsingDiDelegatingAction.class));
        usingDiAnnotationAction.callFriend();
        usingDiDelegatingAction.callFriend();
    }

    // ===================================================================================
    //                                                           Execute like WebFramework
    //                                                           =========================
    /**
     * Execute callFriend() of accessor action by UsingDiWebFrameworkProcess. <br>
     * (accessor の Action の callFriend() を UsingDiWebFrameworkProcess 経由で実行してみましょう)
     */
    public void test_usingdi_UsingDiWebFrameworkProcess_callfriend_accessor() {
        // execution code here
        UsingDiAccessorAction action = new UsingDiAccessorAction();
        action.setAnimal(new Dog());
        action.setSupercarDealer(new SupercarDealer());

        SimpleDiContainer diContainer = SimpleDiContainer.getInstance();
        diContainer.registerModule(componentMap -> componentMap.put(UsingDiAccessorAction.class, action));
        diContainer.resolveDependency();

        UsingDiWebFrameworkProcess process = new UsingDiWebFrameworkProcess();
        process.requestAccessorCallFriend();
    }

    /**
     * Execute callFriend() of annotation and delegating actions by UsingDiWebFrameworkProcess.
     * (And you can increase hit-points of sleepy cat in this method) <br>
     * (annotation, delegating の Action の callFriend() を UsingDiWebFrameworkProcess 経由で実行してみましょう。
     * (眠い猫のヒットポイントをこのメソッド内で増やしてもOK))
     */
    public void test_usingdi_UsingDiWebFrameworkProcess_callfriend_annotation_delegating() {
        // execution code here
        SimpleDiContainer diContainer = SimpleDiContainer.getInstance();
        diContainer.registerModule(componentMap -> {
            componentMap.put(UsingDiAnnotationAction.class, new UsingDiAnnotationAction());
            componentMap.put(UsingDiDelegatingAction.class, new UsingDiDelegatingAction());
            componentMap.put(UsingDiDelegatingLogic.class, new UsingDiDelegatingLogic());
            componentMap.put(Animal.class, new Dog());
            componentMap.put(SupercarDealer.class, new SupercarDealer());
        });
        diContainer.resolveDependency();

        UsingDiWebFrameworkProcess process = new UsingDiWebFrameworkProcess();
        process.requestAnnotationCallFriend();
        process.requestDelegatingCallFriend();
    }

    /**
     * What is concrete class of instance variable "animal" of UsingDiAnnotationAction? (when registering UsingDiModule) <br>
     * (UsingDiAnnotationAction のインスタンス変数 "animal" の実体クラスは？ (UsingDiModuleを登録した時))
     */
    public void test_usingdi_whatis_animal() {
        // your answer? => TooLazyDog
        // and your confirmation code here freely
        SimpleDiContainer diContainer = SimpleDiContainer.getInstance();
        diContainer.registerModule(new UsingDiModule());
        diContainer.resolveDependency();

        UsingDiAnnotationAction usingDiAnnotationAction =
                ((UsingDiAnnotationAction) diContainer.getComponent(UsingDiAnnotationAction.class));
        usingDiAnnotationAction.callFriend();
    }

    // ===================================================================================
    //                                                                        DI Container
    //                                                                        ============
    /**
     * What is DI container? <br>
     * (DIコンテナとは？)
     */
    public void test_whatis_DIContainer() {
        // your answer? => 
        // and your confirmation code here freely
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * What is class or file of DI settings that defines MemberBhv class as DI component in the following Lasta Di application? <br>
     * (以下のLasta DiアプリケーションでMemberBhvクラスをDIコンポーネントとして定義しているDI設定クラスもしくはファイルは？) <br>
     *
     * https://github.com/lastaflute/lastaflute-example-harbor
     */
    public void test_zone_search_component_on_LastaDi() {
        // your answer? => 
    }

    /**
     * What is class or file of DI settings that defines MemberBhv class as DI component in the following Spring application? <br>
     * (以下のSpringアプリケーションでMemberBhvクラスをDIコンポーネントとして定義しているDI設定クラスもしくはファイルは？) <br>
     *
     * https://github.com/dbflute-example/dbflute-example-on-springboot
     */
    public void test_zone_search_component_on_Spring() {
        // your answer? => 
    }
}
