/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.configkeys;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * コンフィグ名称(DBB)を表す列挙型です。
 *
 * @reamsid_L DBE-9999-021 sunhaidi
 */
public enum ConfigNameDBB {

    /**
     * コード:無し 名称:年額計算_端数調整方法_通常 略称:定義なし
     */
    年額計算_端数調整方法_通常("年額計算_端数調整方法_通常"),
    /**
     * コード:無し 名称:年額計算_端数調整単位_通常 略称:定義なし
     */
    年額計算_端数調整単位_通常("年額計算_端数調整単位_通常"),
    /**
     * コード:無し 名称:賦課基準_未申告課税区分 略称:定義なし
     */
    賦課基準_未申告課税区分("賦課基準_未申告課税区分"),
    /**
     * コード:無し 名称:賦課基準_所得調査中課税区分 略称:定義なし
     */
    賦課基準_所得調査中課税区分("賦課基準_所得調査中課税区分"),
    /**
     * コード:無し 名称:賦課基準_課税取消課税区分 略称:定義なし
     */
    賦課基準_課税取消課税区分("賦課基準_課税取消課税区分"),
    /**
     * コード:無し 名称:ランク管理情報_不均一納期期限 略称:定義なし
     */
    ランク管理情報_不均一納期期限("ランク管理情報_不均一納期期限"),
    /**
     * コード:無し 名称:ランク管理情報_ランク有無 略称:定義なし
     */
    ランク管理情報_ランク有無("ランク管理情報_ランク有無"),
    /**
     * コード:無し 名称:ランク管理情報_ランク開始年度 略称:定義なし
     */
    ランク管理情報_ランク開始年度("ランク管理情報_ランク開始年度"),
    /**
     * コード:無し 名称:ランク管理情報_ランク終了年度 略称:定義なし
     */
    ランク管理情報_ランク終了年度("ランク管理情報_ランク終了年度"),
    /**
     * コード:無し 名称:動作関連_特徴分配集約システム 略称:定義なし
     */
    動作関連_特徴分配集約システム("動作関連_特徴分配集約システム"),
    /**
     * コード:無し 名称:普通徴収_期別端数 略称:定義なし
     */
    普通徴収_期別端数("普通徴収_期別端数"),
    /**
     * コード:無し 名称:普通徴収_仮算定賦課方法 略称:定義なし
     */
    普通徴収_仮算定賦課方法("普通徴収_仮算定賦課方法"),
    /**
     * コード:無し 名称:普通徴収_仮算定異動方法 略称:定義なし
     */
    普通徴収_仮算定異動方法("普通徴収_仮算定異動方法"),
    /**
     * コード:無し 名称:普通徴収_仮算定端数調整有無 略称:定義なし
     */
    普通徴収_仮算定端数調整有無("普通徴収_仮算定端数調整有無"),
    /**
     * コード:無し 名称:普通徴収_仮算定併徴者普徴分徴収有無 略称:定義なし
     */
    普通徴収_仮算定併徴者普徴分徴収有無("普通徴収_仮算定併徴者普徴分徴収有無"),
    /**
     * コード:無し 名称:普徴期情報_仮算定期数 略称:定義なし
     */
    普徴期情報_仮算定期数("普徴期情報_仮算定期数"),
    /**
     * コード:無し 名称:普徴期情報_定例納期数 略称:定義なし
     */
    普徴期情報_定例納期数("普徴期情報_定例納期数"),
    /**
     * コード:無し 名称:普徴期情報_設定納期数 略称:定義なし
     */
    普徴期情報_設定納期数("普徴期情報_設定納期数"),
    /**
     * コード:無し 名称:過年度期情報_設定納期数 略称:定義なし
     */
    過年度期情報_設定納期数("過年度期情報_設定納期数"),
    /**
     * コード:無し 名称:日付関連_調定年度 略称:定義なし
     */
    日付関連_調定年度("日付関連_調定年度"),
    /**
     * コード:無し 名称:日付関連_当初年度 略称:定義なし
     */
    日付関連_当初年度("日付関連_当初年度"),
    /**
     * コード:無し 名称:日付関連_遡及年度 略称:定義なし
     */
    日付関連_遡及年度("日付関連_遡及年度"),
    /**
     * コード:無し 名称:日付関連_所得年度 略称:定義なし
     */
    日付関連_所得年度("日付関連_所得年度"),
    /**
     * コード:無し 名称:日付関連_月別テーブル1 略称:定義なし
     */
    日付関連_月別テーブル1("日付関連_月別テーブル1"),
    /**
     * コード:無し 名称:日付関連_月別テーブル2 略称:定義なし
     */
    日付関連_月別テーブル2("日付関連_月別テーブル2"),
    /**
     * コード:無し 名称:日付関連_月別テーブル3 略称:定義なし
     */
    日付関連_月別テーブル3("日付関連_月別テーブル3"),
    /**
     * コード:無し 名称:日付関連_月別テーブル4 略称:定義なし
     */
    日付関連_月別テーブル4("日付関連_月別テーブル4"),
    /**
     * コード:無し 名称:日付関連_月別テーブル5 略称:定義なし
     */
    日付関連_月別テーブル5("日付関連_月別テーブル5"),
    /**
     * コード:無し 名称:日付関連_月別テーブル6 略称:定義なし
     */
    日付関連_月別テーブル6("日付関連_月別テーブル6"),
    /**
     * コード:無し 名称:日付関連_月別テーブル7 略称:定義なし
     */
    日付関連_月別テーブル7("日付関連_月別テーブル7"),
    /**
     * コード:無し 名称:日付関連_月別テーブル8 略称:定義なし
     */
    日付関連_月別テーブル8("日付関連_月別テーブル8"),
    /**
     * コード:無し 名称:日付関連_月別テーブル9 略称:定義なし
     */
    日付関連_月別テーブル9("日付関連_月別テーブル9"),
    /**
     * コード:無し 名称:日付関連_月別テーブル10 略称:定義なし
     */
    日付関連_月別テーブル10("日付関連_月別テーブル10"),
    /**
     * コード:無し 名称:日付関連_月別テーブル11 略称:定義なし
     */
    日付関連_月別テーブル11("日付関連_月別テーブル11"),
    /**
     * コード:無し 名称:日付関連_月別テーブル12 略称:定義なし
     */
    日付関連_月別テーブル12("日付関連_月別テーブル12"),
    /**
     * コード:無し 名称:日付関連_月別テーブル13 略称:定義なし
     */
    日付関連_月別テーブル13("日付関連_月別テーブル13"),
    /**
     * コード:無し 名称:日付関連_月別テーブル14 略称:定義なし
     */
    日付関連_月別テーブル14("日付関連_月別テーブル14"),
    /**
     * コード:無し 名称:日付関連_年度サイクル 略称:定義なし
     */
    日付関連_年度サイクル("日付関連_年度サイクル"),
    /**
     * コード:無し 名称:普徴期情報_月の期1 略称:定義なし
     */
    普徴期情報_月の期1("普徴期情報_月の期1"),
    /**
     * コード:無し 名称:普徴期情報_月の期2 略称:定義なし
     */
    普徴期情報_月の期2("普徴期情報_月の期2"),
    /**
     * コード:無し 名称:普徴期情報_月の期3 略称:定義なし
     */
    普徴期情報_月の期3("普徴期情報_月の期3"),
    /**
     * コード:無し 名称:普徴期情報_月の期4 略称:定義なし
     */
    普徴期情報_月の期4("普徴期情報_月の期4"),
    /**
     * コード:無し 名称:普徴期情報_月の期5 略称:定義なし
     */
    普徴期情報_月の期5("普徴期情報_月の期5"),
    /**
     * コード:無し 名称:普徴期情報_月の期6 略称:定義なし
     */
    普徴期情報_月の期6("普徴期情報_月の期6"),
    /**
     * コード:無し 名称:普徴期情報_月の期7 略称:定義なし
     */
    普徴期情報_月の期7("普徴期情報_月の期7"),
    /**
     * コード:無し 名称:普徴期情報_月の期8 略称:定義なし
     */
    普徴期情報_月の期8("普徴期情報_月の期8"),
    /**
     * コード:無し 名称:普徴期情報_月の期9 略称:定義なし
     */
    普徴期情報_月の期9("普徴期情報_月の期9"),
    /**
     * コード:無し 名称:普徴期情報_月の期10 略称:定義なし
     */
    普徴期情報_月の期10("普徴期情報_月の期10"),
    /**
     * コード:無し 名称:普徴期情報_月の期11 略称:定義なし
     */
    普徴期情報_月の期11("普徴期情報_月の期11"),
    /**
     * コード:無し 名称:普徴期情報_月の期12 略称:定義なし
     */
    普徴期情報_月の期12("普徴期情報_月の期12"),
    /**
     * コード:無し 名称:普徴期情報_月の期13 略称:定義なし
     */
    普徴期情報_月の期13("普徴期情報_月の期13"),
    /**
     * コード:無し 名称:普徴期情報_月の期14 略称:定義なし
     */
    普徴期情報_月の期14("普徴期情報_月の期14"),
    /**
     * コード:無し 名称:普徴期情報_月処理区分1 略称:定義なし
     */
    普徴期情報_月処理区分1("普徴期情報_月処理区分1"),
    /**
     * コード:無し 名称:普徴期情報_月処理区分2 略称:定義なし
     */
    普徴期情報_月処理区分2("普徴期情報_月処理区分2"),
    /**
     * コード:無し 名称:普徴期情報_月処理区分3 略称:定義なし
     */
    普徴期情報_月処理区分3("普徴期情報_月処理区分3"),
    /**
     * コード:無し 名称:普徴期情報_月処理区分4 略称:定義なし
     */
    普徴期情報_月処理区分4("普徴期情報_月処理区分4"),
    /**
     * コード:無し 名称:普徴期情報_月処理区分5 略称:定義なし
     */
    普徴期情報_月処理区分5("普徴期情報_月処理区分5"),
    /**
     * コード:無し 名称:普徴期情報_月処理区分6 略称:定義なし
     */
    普徴期情報_月処理区分6("普徴期情報_月処理区分6"),
    /**
     * コード:無し 名称:普徴期情報_月処理区分7 略称:定義なし
     */
    普徴期情報_月処理区分7("普徴期情報_月処理区分7"),
    /**
     * コード:無し 名称:普徴期情報_月処理区分8 略称:定義なし
     */
    普徴期情報_月処理区分8("普徴期情報_月処理区分8"),
    /**
     * コード:無し 名称:普徴期情報_月処理区分9 略称:定義なし
     */
    普徴期情報_月処理区分9("普徴期情報_月処理区分9"),
    /**
     * コード:無し 名称:普徴期情報_月処理区分10 略称:定義なし
     */
    普徴期情報_月処理区分10("普徴期情報_月処理区分10"),
    /**
     * コード:無し 名称:普徴期情報_月処理区分11 略称:定義なし
     */
    普徴期情報_月処理区分11("普徴期情報_月処理区分11"),
    /**
     * コード:無し 名称:普徴期情報_月処理区分12 略称:定義なし
     */
    普徴期情報_月処理区分12("普徴期情報_月処理区分12"),
    /**
     * コード:無し 名称:普徴期情報_月処理区分13 略称:定義なし
     */
    普徴期情報_月処理区分13("普徴期情報_月処理区分13"),
    /**
     * コード:無し 名称:普徴期情報_月処理区分14 略称:定義なし
     */
    普徴期情報_月処理区分14("普徴期情報_月処理区分14"),
    /**
     * コード:無し 名称:普通徴収_期別テーブル1 略称:定義なし
     */
    普通徴収_期別テーブル1("普通徴収_期別テーブル1"),
    /**
     * コード:無し 名称:普通徴収_期別テーブル2 略称:定義なし
     */
    普通徴収_期別テーブル2("普通徴収_期別テーブル2"),
    /**
     * コード:無し 名称:普通徴収_期別テーブル3 略称:定義なし
     */
    普通徴収_期別テーブル3("普通徴収_期別テーブル3"),
    /**
     * コード:無し 名称:普通徴収_期別テーブル4 略称:定義なし
     */
    普通徴収_期別テーブル4("普通徴収_期別テーブル4"),
    /**
     * コード:無し 名称:普通徴収_期別テーブル5 略称:定義なし
     */
    普通徴収_期別テーブル5("普通徴収_期別テーブル5"),
    /**
     * コード:無し 名称:普通徴収_期別テーブル6 略称:定義なし
     */
    普通徴収_期別テーブル6("普通徴収_期別テーブル6"),
    /**
     * コード:無し 名称:普通徴収_期別テーブル7 略称:定義なし
     */
    普通徴収_期別テーブル7("普通徴収_期別テーブル7"),
    /**
     * コード:無し 名称:普通徴収_期別テーブル8 略称:定義なし
     */
    普通徴収_期別テーブル8("普通徴収_期別テーブル8"),
    /**
     * コード:無し 名称:普通徴収_期別テーブル9 略称:定義なし
     */
    普通徴収_期別テーブル9("普通徴収_期別テーブル9"),
    /**
     * コード:無し 名称:普通徴収_期別テーブル10 略称:定義なし
     */
    普通徴収_期別テーブル10("普通徴収_期別テーブル10"),
    /**
     * コード:無し 名称:普通徴収_期別テーブル11 略称:定義なし
     */
    普通徴収_期別テーブル11("普通徴収_期別テーブル11"),
    /**
     * コード:無し 名称:普通徴収_期別テーブル12 略称:定義なし
     */
    普通徴収_期別テーブル12("普通徴収_期別テーブル12"),
    /**
     * コード:無し 名称:普通徴収_期別テーブル13 略称:定義なし
     */
    普通徴収_期別テーブル13("普通徴収_期別テーブル13"),
    /**
     * コード:無し 名称:普通徴収_期別テーブル14 略称:定義なし
     */
    普通徴収_期別テーブル14("普通徴収_期別テーブル14"),
    /**
     * コード:無し 名称:普徴期情報_処理対象1 略称:定義なし
     */
    普徴期情報_処理対象1("普徴期情報_処理対象1"),
    /**
     * コード:無し 名称:普徴期情報_処理対象2 略称:定義なし
     */
    普徴期情報_処理対象2("普徴期情報_処理対象2"),
    /**
     * コード:無し 名称:普徴期情報_処理対象3 略称:定義なし
     */
    普徴期情報_処理対象3("普徴期情報_処理対象3"),
    /**
     * コード:無し 名称:普徴期情報_処理対象4 略称:定義なし
     */
    普徴期情報_処理対象4("普徴期情報_処理対象4"),
    /**
     * コード:無し 名称:普徴期情報_処理対象5 略称:定義なし
     */
    普徴期情報_処理対象5("普徴期情報_処理対象5"),
    /**
     * コード:無し 名称:普徴期情報_処理対象6 略称:定義なし
     */
    普徴期情報_処理対象6("普徴期情報_処理対象6"),
    /**
     * コード:無し 名称:普徴期情報_処理対象7 略称:定義なし
     */
    普徴期情報_処理対象7("普徴期情報_処理対象7"),
    /**
     * コード:無し 名称:普徴期情報_処理対象8 略称:定義なし
     */
    普徴期情報_処理対象8("普徴期情報_処理対象8"),
    /**
     * コード:無し 名称:普徴期情報_処理対象9 略称:定義なし
     */
    普徴期情報_処理対象9("普徴期情報_処理対象9"),
    /**
     * コード:無し 名称:普徴期情報_処理対象10 略称:定義なし
     */
    普徴期情報_処理対象10("普徴期情報_処理対象10"),
    /**
     * コード:無し 名称:普徴期情報_処理対象11 略称:定義なし
     */
    普徴期情報_処理対象11("普徴期情報_処理対象11"),
    /**
     * コード:無し 名称:普徴期情報_処理対象12 略称:定義なし
     */
    普徴期情報_処理対象12("普徴期情報_処理対象12"),
    /**
     * コード:無し 名称:普徴期情報_処理対象13 略称:定義なし
     */
    普徴期情報_処理対象13("普徴期情報_処理対象13"),
    /**
     * コード:無し 名称:普徴期情報_処理対象14 略称:定義なし
     */
    普徴期情報_処理対象14("普徴期情報_処理対象14"),
    /**
     * コード:無し 名称:普徴期情報_納付書の型1 略称:定義なし
     */
    普徴期情報_納付書の型1("普徴期情報_納付書の型1"),
    /**
     * コード:無し 名称:普徴期情報_納付書の型2 略称:定義なし
     */
    普徴期情報_納付書の型2("普徴期情報_納付書の型2"),
    /**
     * コード:無し 名称:普徴期情報_納付書の型3 略称:定義なし
     */
    普徴期情報_納付書の型3("普徴期情報_納付書の型3"),
    /**
     * コード:無し 名称:普徴期情報_納付書の型4 略称:定義なし
     */
    普徴期情報_納付書の型4("普徴期情報_納付書の型4"),
    /**
     * コード:無し 名称:普徴期情報_納付書の型5 略称:定義なし
     */
    普徴期情報_納付書の型5("普徴期情報_納付書の型5"),
    /**
     * コード:無し 名称:普徴期情報_納付書の型6 略称:定義なし
     */
    普徴期情報_納付書の型6("普徴期情報_納付書の型6"),
    /**
     * コード:無し 名称:普徴期情報_納付書の型１ 略称:定義なし
     */
    普徴期情報_納付書の型7("普徴期情報_納付書の型7"),
    /**
     * コード:無し 名称:普徴期情報_納付書の型8 略称:定義なし
     */
    普徴期情報_納付書の型8("普徴期情報_納付書の型8"),
    /**
     * コード:無し 名称:普徴期情報_納付書の型9 略称:定義なし
     */
    普徴期情報_納付書の型9("普徴期情報_納付書の型9"),
    /**
     * コード:無し 名称:普徴期情報_納付書の型10 略称:定義なし
     */
    普徴期情報_納付書の型10("普徴期情報_納付書の型10"),
    /**
     * コード:無し 名称:普徴期情報_納付書の型11 略称:定義なし
     */
    普徴期情報_納付書の型11("普徴期情報_納付書の型11"),
    /**
     * コード:無し 名称:普徴期情報_納付書の型12 略称:定義なし
     */
    普徴期情報_納付書の型12("普徴期情報_納付書の型12"),
    /**
     * コード:無し 名称:普徴期情報_納付書の型１ 略称:定義なし
     */
    普徴期情報_納付書の型13("普徴期情報_納付書の型13"),
    /**
     * コード:無し 名称:普徴期情報_納付書の型１ 略称:定義なし
     */
    普徴期情報_納付書の型14("普徴期情報_納付書の型14"),
    /**
     * コード:無し 名称:普徴期情報_納通連帳区分1 略称:定義なし
     */
    普徴期情報_納通連帳区分1("普徴期情報_納通連帳区分1"),
    /**
     * コード:無し 名称:普徴期情報_納通連帳区分2 略称:定義なし
     */
    普徴期情報_納通連帳区分2("普徴期情報_納通連帳区分2"),
    /**
     * コード:無し 名称:普徴期情報_納通連帳区分3 略称:定義なし
     */
    普徴期情報_納通連帳区分3("普徴期情報_納通連帳区分3"),
    /**
     * コード:無し 名称:普徴期情報_納通連帳区分4 略称:定義なし
     */
    普徴期情報_納通連帳区分4("普徴期情報_納通連帳区分4"),
    /**
     * コード:無し 名称:普徴期情報_納通連帳区分5 略称:定義なし
     */
    普徴期情報_納通連帳区分5("普徴期情報_納通連帳区分5"),
    /**
     * コード:無し 名称:普徴期情報_納通連帳区分6 略称:定義なし
     */
    普徴期情報_納通連帳区分6("普徴期情報_納通連帳区分6"),
    /**
     * コード:無し 名称:普徴期情報_納通連帳区分7 略称:定義なし
     */
    普徴期情報_納通連帳区分7("普徴期情報_納通連帳区分7"),
    /**
     * コード:無し 名称:普徴期情報_納通連帳区分8 略称:定義なし
     */
    普徴期情報_納通連帳区分8("普徴期情報_納通連帳区分8"),
    /**
     * コード:無し 名称:普徴期情報_納通連帳区分9 略称:定義なし
     */
    普徴期情報_納通連帳区分9("普徴期情報_納通連帳区分9"),
    /**
     * コード:無し 名称:普徴期情報_納通連帳区分10 略称:定義なし
     */
    普徴期情報_納通連帳区分10("普徴期情報_納通連帳区分10"),
    /**
     * コード:無し 名称:普徴期情報_納通連帳区分11 略称:定義なし
     */
    普徴期情報_納通連帳区分11("普徴期情報_納通連帳区分11"),
    /**
     * コード:無し 名称:普徴期情報_納通連帳区分12 略称:定義なし
     */
    普徴期情報_納通連帳区分12("普徴期情報_納通連帳区分12"),
    /**
     * コード:無し 名称:普徴期情報_納通連帳区分13 略称:定義なし
     */
    普徴期情報_納通連帳区分13("普徴期情報_納通連帳区分13"),
    /**
     * コード:無し 名称:普徴期情報_納通連帳区分14 略称:定義なし
     */
    普徴期情報_納通連帳区分14("普徴期情報_納通連帳区分14"),
    /**
     * コード:無し 名称:普徴期情報_通知書プリント条件1 略称:定義なし
     */
    普徴期情報_通知書プリント条件1("普徴期情報_通知書プリント条件1"),
    /**
     * コード:無し 名称:普徴期情報_通知書プリント条件2 略称:定義なし
     */
    普徴期情報_通知書プリント条件2("普徴期情報_通知書プリント条件2"),
    /**
     * コード:無し 名称:普徴期情報_通知書プリント条件3 略称:定義なし
     */
    普徴期情報_通知書プリント条件3("普徴期情報_通知書プリント条件3"),
    /**
     * コード:無し 名称:普徴期情報_通知書プリント条件4 略称:定義なし
     */
    普徴期情報_通知書プリント条件4("普徴期情報_通知書プリント条件4"),
    /**
     * コード:無し 名称:普徴期情報_通知書プリント条件5 略称:定義なし
     */
    普徴期情報_通知書プリント条件5("普徴期情報_通知書プリント条件5"),
    /**
     * コード:無し 名称:普徴期情報_通知書プリント条件6 略称:定義なし
     */
    普徴期情報_通知書プリント条件6("普徴期情報_通知書プリント条件6"),
    /**
     * コード:無し 名称:普徴期情報_通知書プリント条件7 略称:定義なし
     */
    普徴期情報_通知書プリント条件7("普徴期情報_通知書プリント条件7"),
    /**
     * コード:無し 名称:普徴期情報_通知書プリント条件8 略称:定義なし
     */
    普徴期情報_通知書プリント条件8("普徴期情報_通知書プリント条件8"),
    /**
     * コード:無し 名称:普徴期情報_通知書プリント条件9 略称:定義なし
     */
    普徴期情報_通知書プリント条件9("普徴期情報_通知書プリント条件9"),
    /**
     * コード:無し 名称:普徴期情報_通知書プリント条件10 略称:定義なし
     */
    普徴期情報_通知書プリント条件10("普徴期情報_通知書プリント条件10"),
    /**
     * コード:無し 名称:普徴期情報_通知書プリント条件11 略称:定義なし
     */
    普徴期情報_通知書プリント条件11("普徴期情報_通知書プリント条件11"),
    /**
     * コード:無し 名称:普徴期情報_通知書プリント条件12 略称:定義なし
     */
    普徴期情報_通知書プリント条件12("普徴期情報_通知書プリント条件12"),
    /**
     * コード:無し 名称:普徴期情報_通知書プリント条件13 略称:定義なし
     */
    普徴期情報_通知書プリント条件13("普徴期情報_通知書プリント条件13"),
    /**
     * コード:無し 名称:普徴期情報_通知書プリント条件14 略称:定義なし
     */
    普徴期情報_通知書プリント条件14("普徴期情報_通知書プリント条件14"),
    /**
     * コード:無し 名称:普徴期情報_口座対象者プリント条件1 略称:定義なし
     */
    普徴期情報_口座対象者プリント条件1("普徴期情報_口座対象者プリント条件1"),
    /**
     * コード:無し 名称:普徴期情報_口座対象者プリント条件2 略称:定義なし
     */
    普徴期情報_口座対象者プリント条件2("普徴期情報_口座対象者プリント条件2"),
    /**
     * コード:無し 名称:普徴期情報_口座対象者プリント条件3 略称:定義なし
     */
    普徴期情報_口座対象者プリント条件3("普徴期情報_口座対象者プリント条件3"),
    /**
     * コード:無し 名称:普徴期情報_口座対象者プリント条件4 略称:定義なし
     */
    普徴期情報_口座対象者プリント条件4("普徴期情報_口座対象者プリント条件4"),
    /**
     * コード:無し 名称:普徴期情報_口座対象者プリント条件5 略称:定義なし
     */
    普徴期情報_口座対象者プリント条件5("普徴期情報_口座対象者プリント条件5"),
    /**
     * コード:無し 名称:普徴期情報_口座対象者プリント条件6 略称:定義なし
     */
    普徴期情報_口座対象者プリント条件6("普徴期情報_口座対象者プリント条件6"),
    /**
     * コード:無し 名称:普徴期情報_口座対象者プリント条件7 略称:定義なし
     */
    普徴期情報_口座対象者プリント条件7("普徴期情報_口座対象者プリント条件7"),
    /**
     * コード:無し 名称:普徴期情報_口座対象者プリント条件8 略称:定義なし
     */
    普徴期情報_口座対象者プリント条件8("普徴期情報_口座対象者プリント条件8"),
    /**
     * コード:無し 名称:普徴期情報_口座対象者プリント条件9 略称:定義なし
     */
    普徴期情報_口座対象者プリント条件9("普徴期情報_口座対象者プリント条件9"),
    /**
     * コード:無し 名称:普徴期情報_口座対象者プリント条件10 略称:定義なし
     */
    普徴期情報_口座対象者プリント条件10("普徴期情報_口座対象者プリント条件10"),
    /**
     * コード:無し 名称:普徴期情報_口座対象者プリント条件11 略称:定義なし
     */
    普徴期情報_口座対象者プリント条件11("普徴期情報_口座対象者プリント条件11"),
    /**
     * コード:無し 名称:普徴期情報_口座対象者プリント条件12 略称:定義なし
     */
    普徴期情報_口座対象者プリント条件12("普徴期情報_口座対象者プリント条件12"),
    /**
     * コード:無し 名称:普徴期情報_口座対象者プリント条件13 略称:定義なし
     */
    普徴期情報_口座対象者プリント条件13("普徴期情報_口座対象者プリント条件13"),
    /**
     * コード:無し 名称:普徴期情報_口座対象者プリント条件14 略称:定義なし
     */
    普徴期情報_口座対象者プリント条件14("普徴期情報_口座対象者プリント条件14"),
    /**
     * コード:無し 名称:過年度_歳出管理区分 略称:定義なし
     */
    過年度_歳出管理区分("過年度_歳出管理区分"),
    /**
     * コード:無し 名称:期割計算_普徴切替方法 略称:定義なし
     */
    期割計算_普徴切替方法("期割計算_普徴切替方法"),
    /**
     * コード:無し 名称:特別徴収_平準化計算方法_6月分 略称:定義なし
     */
    特別徴収_平準化計算方法_6月分("特別徴収_平準化計算方法_6月分"),
    /**
     * コード:無し 名称:特別徴収_平準化計算方法_8月分 略称:定義なし
     */
    特別徴収_平準化計算方法_8月分("特別徴収_平準化計算方法_8月分"),
    /**
     * コード:無し 名称:特別徴収_平準化計算方法_8月分増額 略称:定義なし
     */
    特別徴収_平準化計算方法_8月分増額("特別徴収_平準化計算方法_8月分増額"),
    /**
     * コード:無し 名称:特別徴収_平準化計算方法_8月分減額 略称:定義なし
     */
    特別徴収_平準化計算方法_8月分減額("特別徴収_平準化計算方法_8月分減額"),
    /**
     * コード:無し 名称:特別徴収_年額基準年度_4月開始 略称:定義なし
     */
    特別徴収_年額基準年度_4月開始("特別徴収_年額基準年度_4月開始"),
    /**
     * コード:無し 名称:特別徴収_年額基準年度_6月開始 略称:定義なし
     */
    特別徴収_年額基準年度_6月開始("特別徴収_年額基準年度_6月開始"),
    /**
     * コード:無し 名称:特別徴収_年額基準年度_8月開始 略称:定義なし
     */
    特別徴収_年額基準年度_8月開始("特別徴収_年額基準年度_8月開始"),
    /**
     * コード:無し 名称:特別徴収_期別テーブル1 略称:定義なし
     */
    特別徴収_期別テーブル1("特別徴収_期別テーブル1"),
    /**
     * コード:無し 名称:特別徴収_期別テーブル2 略称:定義なし
     */
    特別徴収_期別テーブル2("特別徴収_期別テーブル2"),
    /**
     * コード:無し 名称:特別徴収_期別テーブル3 略称:定義なし
     */
    特別徴収_期別テーブル3("特別徴収_期別テーブル3"),
    /**
     * コード:無し 名称:特別徴収_期別テーブル4 略称:定義なし
     */
    特別徴収_期別テーブル4("特別徴収_期別テーブル4"),
    /**
     * コード:無し 名称:特別徴収_期別テーブル5 略称:定義なし
     */
    特別徴収_期別テーブル5("特別徴収_期別テーブル5"),
    /**
     * コード:無し 名称:特別徴収_期別テーブル6 略称:定義なし
     */
    特別徴収_期別テーブル6("特別徴収_期別テーブル6"),
    /**
     * コード:無し 名称:特別徴収_期別端数 略称:定義なし
     */
    特別徴収_期別端数("特別徴収_期別端数"),
    /**
     * コード:無し 名称:特別徴収_特徴開始前普通徴収_6月 略称:定義なし
     */
    特別徴収_特徴開始前普通徴収_6月("特別徴収_特徴開始前普通徴収_6月"),
    /**
     * コード:無し 名称:特別徴収_特徴開始前普通徴収_8月 略称:定義なし
     */
    特別徴収_特徴開始前普通徴収_8月("特別徴収_特徴開始前普通徴収_8月"),
    /**
     * コード:無し 名称:特別徴収_特徴開始前普通徴収_10月 略称:定義なし
     */
    特別徴収_特徴開始前普通徴収_10月("特別徴収_特徴開始前普通徴収_10月"),
    /**
     * コード:無し 名称:特別徴収_特徴開始月_2月捕捉 略称:定義なし
     */
    特別徴収_特徴開始月_2月捕捉("特別徴収_特徴開始月_2月捕捉"),
    /**
     * コード:無し 名称:特別徴収_特徴開始月_4月捕捉 略称:定義なし
     */
    特別徴収_特徴開始月_4月捕捉("特別徴収_特徴開始月_4月捕捉"),
    /**
     * コード:無し 名称:特別徴収_特徴開始月_6月捕捉 略称:定義なし
     */
    特別徴収_特徴開始月_6月捕捉("特別徴収_特徴開始月_6月捕捉"),
    /**
     * コード:無し 名称:特別徴収_特徴開始月_8月捕捉 略称:定義なし
     */
    特別徴収_特徴開始月_8月捕捉("特別徴収_特徴開始月_8月捕捉"),
    /**
     * コード:無し 名称:特別徴収_特徴開始月_10月捕捉 略称:定義なし
     */
    特別徴収_特徴開始月_10月捕捉("特別徴収_特徴開始月_10月捕捉"),
    /**
     * コード:無し 名称:特別徴収_特徴開始月_12月捕捉 略称:定義なし
     */
    特別徴収_特徴開始月_12月捕捉("特別徴収_特徴開始月_12月捕捉"),
    /**
     * コード:無し 名称:特徴期情報_仮算定期数 略称:定義なし
     */
    特徴期情報_仮算定期数("特徴期情報_仮算定期数"),
    /**
     * コード:無し 名称:特徴期情報_設定納期数 略称:定義なし
     */
    特徴期情報_設定納期数("特徴期情報_設定納期数"),
    /**
     * コード:無し 名称:特別徴収_依頼金額計算方法_12月開始 略称:定義なし
     */
    特別徴収_依頼金額計算方法_12月開始("特別徴収_依頼金額計算方法_12月開始"),
    /**
     * コード:無し 名称:特別徴収_依頼金額計算方法_2月開始 略称:定義なし
     */
    特別徴収_依頼金額計算方法_2月開始("特別徴収_依頼金額計算方法_2月開始"),
    /**
     * コード:無し 名称:特別徴収_依頼金額計算方法_4月開始 略称:定義なし
     */
    特別徴収_依頼金額計算方法_4月開始("特別徴収_依頼金額計算方法_4月開始"),
    /**
     * コード:無し 名称:特別徴収_依頼金額計算方法_6月開始 略称:定義なし
     */
    特別徴収_依頼金額計算方法_6月開始("特別徴収_依頼金額計算方法_6月開始"),
    /**
     * コード:無し 名称:特別徴収_依頼金額計算方法_8月開始 略称:定義なし
     */
    特別徴収_依頼金額計算方法_8月開始("特別徴収_依頼金額計算方法_8月開始"),
    /**
     * コード:無し 名称:特徴期情報_月の期1 略称:定義なし
     */
    特徴期情報_月の期1("特徴期情報_月の期1"),
    /**
     * コード:無し 名称:特徴期情報_月の期2 略称:定義なし
     */
    特徴期情報_月の期2("特徴期情報_月の期2"),
    /**
     * コード:無し 名称:特徴期情報_月の期3 略称:定義なし
     */
    特徴期情報_月の期3("特徴期情報_月の期3"),
    /**
     * コード:無し 名称:特徴期情報_月の期4 略称:定義なし
     */
    特徴期情報_月の期4("特徴期情報_月の期4"),
    /**
     * コード:無し 名称:特徴期情報_月の期5 略称:定義なし
     */
    特徴期情報_月の期5("特徴期情報_月の期5"),
    /**
     * コード:無し 名称:特徴期情報_月の期6 略称:定義なし
     */
    特徴期情報_月の期6("特徴期情報_月の期6"),
    /**
     * コード:無し 名称:特徴期情報_月の期7 略称:定義なし
     */
    特徴期情報_月の期7("特徴期情報_月の期7"),
    /**
     * コード:無し 名称:特徴期情報_月の期8 略称:定義なし
     */
    特徴期情報_月の期8("特徴期情報_月の期8"),
    /**
     * コード:無し 名称:特徴期情報_月の期9 略称:定義なし
     */
    特徴期情報_月の期9("特徴期情報_月の期9"),
    /**
     * コード:無し 名称:特徴期情報_月の期10 略称:定義なし
     */
    特徴期情報_月の期10("特徴期情報_月の期10"),
    /**
     * コード:無し 名称:特徴期情報_月の期11 略称:定義なし
     */
    特徴期情報_月の期11("特徴期情報_月の期11"),
    /**
     * コード:無し 名称:特徴期情報_月の期12 略称:定義なし
     */
    特徴期情報_月の期12("特徴期情報_月の期12"),
    /**
     * コード:無し 名称:特徴期情報_月処理区分1 略称:定義なし
     */
    特徴期情報_月処理区分1("特徴期情報_月処理区分1"),
    /**
     * コード:無し 名称:特徴期情報_月処理区分2 略称:定義なし
     */
    特徴期情報_月処理区分2("特徴期情報_月処理区分2"),
    /**
     * コード:無し 名称:特徴期情報_月処理区分3 略称:定義なし
     */
    特徴期情報_月処理区分3("特徴期情報_月処理区分3"),
    /**
     * コード:無し 名称:特徴期情報_月処理区分4 略称:定義なし
     */
    特徴期情報_月処理区分4("特徴期情報_月処理区分4"),
    /**
     * コード:無し 名称:特徴期情報_月処理区分5 略称:定義なし
     */
    特徴期情報_月処理区分5("特徴期情報_月処理区分5"),
    /**
     * コード:無し 名称:特徴期情報_月処理区分6 略称:定義なし
     */
    特徴期情報_月処理区分6("特徴期情報_月処理区分6"),
    /**
     * コード:無し 名称:特徴期情報_月処理区分7 略称:定義なし
     */
    特徴期情報_月処理区分7("特徴期情報_月処理区分7"),
    /**
     * コード:無し 名称:特徴期情報_月処理区分8 略称:定義なし
     */
    特徴期情報_月処理区分8("特徴期情報_月処理区分8"),
    /**
     * コード:無し 名称:特徴期情報_月処理区分9 略称:定義なし
     */
    特徴期情報_月処理区分9("特徴期情報_月処理区分9"),
    /**
     * コード:無し 名称:特徴期情報_月処理区分10 略称:定義なし
     */
    特徴期情報_月処理区分10("特徴期情報_月処理区分10"),
    /**
     * コード:無し 名称:特徴期情報_月処理区分11 略称:定義なし
     */
    特徴期情報_月処理区分11("特徴期情報_月処理区分11"),
    /**
     * コード:無し 名称:特徴期情報_月処理区分12 略称:定義なし
     */
    特徴期情報_月処理区分12("特徴期情報_月処理区分12"),
    /**
     * コード:無し 名称:過年度期情報_月の期1 略称:定義なし
     */
    過年度期情報_月の期1("過年度期情報_月の期1"),
    /**
     * コード:無し 名称:過年度期情報_月の期2 略称:定義なし
     */
    過年度期情報_月の期2("過年度期情報_月の期2"),
    /**
     * コード:無し 名称:過年度期情報_月の期3 略称:定義なし
     */
    過年度期情報_月の期3("過年度期情報_月の期3"),
    /**
     * コード:無し 名称:過年度期情報_月の期4 略称:定義なし
     */
    過年度期情報_月の期4("過年度期情報_月の期4"),
    /**
     * コード:無し 名称:過年度期情報_月の期5 略称:定義なし
     */
    過年度期情報_月の期5("過年度期情報_月の期5"),
    /**
     * コード:無し 名称:過年度期情報_月の期6 略称:定義なし
     */
    過年度期情報_月の期6("過年度期情報_月の期6"),
    /**
     * コード:無し 名称:過年度期情報_月の期7 略称:定義なし
     */
    過年度期情報_月の期7("過年度期情報_月の期7"),
    /**
     * コード:無し 名称:過年度期情報_月の期8 略称:定義なし
     */
    過年度期情報_月の期8("過年度期情報_月の期8"),
    /**
     * コード:無し 名称:過年度期情報_月の期9 略称:定義なし
     */
    過年度期情報_月の期9("過年度期情報_月の期9"),
    /**
     * コード:無し 名称:過年度期情報_月の期10 略称:定義なし
     */
    過年度期情報_月の期10("過年度期情報_月の期10"),
    /**
     * コード:無し 名称:過年度期情報_月の期11 略称:定義なし
     */
    過年度期情報_月の期11("過年度期情報_月の期11"),
    /**
     * コード:無し 名称:過年度期情報_月の期12 略称:定義なし
     */
    過年度期情報_月の期12("過年度期情報_月の期12"),
    /**
     * コード:無し 名称:過年度_期別テーブル1 略称:定義なし
     */
    過年度_期別テーブル1("過年度_期別テーブル1"),
    /**
     * コード:無し 名称:過年度_期別テーブル2 略称:定義なし
     */
    過年度_期別テーブル2("過年度_期別テーブル2"),
    /**
     * コード:無し 名称:過年度_期別テーブル3 略称:定義なし
     */
    過年度_期別テーブル3("過年度_期別テーブル3"),
    /**
     * コード:無し 名称:過年度_期別テーブル4 略称:定義なし
     */
    過年度_期別テーブル4("過年度_期別テーブル4"),
    /**
     * コード:無し 名称:過年度_期別テーブル5 略称:定義なし
     */
    過年度_期別テーブル5("過年度_期別テーブル5"),
    /**
     * コード:無し 名称:過年度_期別テーブル6 略称:定義なし
     */
    過年度_期別テーブル6("過年度_期別テーブル6"),
    /**
     * コード:無し 名称:過年度_期別テーブル7 略称:定義なし
     */
    過年度_期別テーブル7("過年度_期別テーブル7"),
    /**
     * コード:無し 名称:過年度_期別テーブル8 略称:定義なし
     */
    過年度_期別テーブル8("過年度_期別テーブル8"),
    /**
     * コード:無し 名称:過年度_期別テーブル9 略称:定義なし
     */
    過年度_期別テーブル9("過年度_期別テーブル9"),
    /**
     * コード:無し 名称:過年度_期別テーブル10 略称:定義なし
     */
    過年度_期別テーブル10("過年度_期別テーブル10"),
    /**
     * コード:無し 名称:過年度_期別テーブル11 略称:定義なし
     */
    過年度_期別テーブル11("過年度_期別テーブル11"),
    /**
     * コード:無し 名称:過年度_期別テーブル12 略称:定義なし
     */
    過年度_期別テーブル12("過年度_期別テーブル12"),
    /**
     * コード:無し 名称:過年度期情報_納付書の型1 略称:定義なし
     */
    過年度期情報_納付書の型1("過年度期情報_納付書の型1"),
    /**
     * コード:無し 名称:過年度期情報_納付書の型2 略称:定義なし
     */
    過年度期情報_納付書の型2("過年度期情報_納付書の型2"),
    /**
     * コード:無し 名称:過年度期情報_納付書の型3 略称:定義なし
     */
    過年度期情報_納付書の型3("過年度期情報_納付書の型3"),
    /**
     * コード:無し 名称:過年度期情報_納付書の型4 略称:定義なし
     */
    過年度期情報_納付書の型4("過年度期情報_納付書の型4"),
    /**
     * コード:無し 名称:過年度期情報_納付書の型5 略称:定義なし
     */
    過年度期情報_納付書の型5("過年度期情報_納付書の型5"),
    /**
     * コード:無し 名称:過年度期情報_納付書の型6 略称:定義なし
     */
    過年度期情報_納付書の型6("過年度期情報_納付書の型6"),
    /**
     * コード:無し 名称:過年度期情報_納付書の型7 略称:定義なし
     */
    過年度期情報_納付書の型7("過年度期情報_納付書の型7"),
    /**
     * コード:無し 名称:過年度期情報_納付書の型8 略称:定義なし
     */
    過年度期情報_納付書の型8("過年度期情報_納付書の型8"),
    /**
     * コード:無し 名称:過年度期情報_納付書の型9 略称:定義なし
     */
    過年度期情報_納付書の型9("過年度期情報_納付書の型9"),
    /**
     * コード:無し 名称:過年度期情報_納付書の型10 略称:定義なし
     */
    過年度期情報_納付書の型10("過年度期情報_納付書の型10"),
    /**
     * コード:無し 名称:過年度期情報_納付書の型11 略称:定義なし
     */
    過年度期情報_納付書の型11("過年度期情報_納付書の型11"),
    /**
     * コード:無し 名称:過年度期情報_納付書の型12 略称:定義なし
     */
    過年度期情報_納付書の型12("過年度期情報_納付書の型12"),
    /**
     * コード:無し 名称:過年度期情報_通知書プリント条件1 略称:定義なし
     */
    過年度期情報_通知書プリント条件1("過年度期情報_通知書プリント条件1"),
    /**
     * コード:無し 名称:過年度期情報_通知書プリント条件2 略称:定義なし
     */
    過年度期情報_通知書プリント条件2("過年度期情報_通知書プリント条件2"),
    /**
     * コード:無し 名称:過年度期情報_通知書プリント条件3 略称:定義なし
     */
    過年度期情報_通知書プリント条件3("過年度期情報_通知書プリント条件3"),
    /**
     * コード:無し 名称:過年度期情報_通知書プリント条件4 略称:定義なし
     */
    過年度期情報_通知書プリント条件4("過年度期情報_通知書プリント条件4"),
    /**
     * コード:無し 名称:過年度期情報_通知書プリント条件5 略称:定義なし
     */
    過年度期情報_通知書プリント条件5("過年度期情報_通知書プリント条件5"),
    /**
     * コード:無し 名称:過年度期情報_通知書プリント条件6 略称:定義なし
     */
    過年度期情報_通知書プリント条件6("過年度期情報_通知書プリント条件6"),
    /**
     * コード:無し 名称:過年度期情報_通知書プリント条件7 略称:定義なし
     */
    過年度期情報_通知書プリント条件7("過年度期情報_通知書プリント条件7"),
    /**
     * コード:無し 名称:過年度期情報_通知書プリント条件8 略称:定義なし
     */
    過年度期情報_通知書プリント条件8("過年度期情報_通知書プリント条件8"),
    /**
     * コード:無し 名称:過年度期情報_通知書プリント条件9 略称:定義なし
     */
    過年度期情報_通知書プリント条件9("過年度期情報_通知書プリント条件9"),
    /**
     * コード:無し 名称:過年度期情報_通知書プリント条件10 略称:定義なし
     */
    過年度期情報_通知書プリント条件10("過年度期情報_通知書プリント条件10"),
    /**
     * コード:無し 名称:過年度期情報_通知書プリント条件11 略称:定義なし
     */
    過年度期情報_通知書プリント条件11("過年度期情報_通知書プリント条件11"),
    /**
     * コード:無し 名称:過年度期情報_通知書プリント条件12 略称:定義なし
     */
    過年度期情報_通知書プリント条件12("過年度期情報_通知書プリント条件12"),
    /**
     * コード:無し 名称:過年度期情報_口座対象者プリント条件1 略称:定義なし
     */
    過年度期情報_口座対象者プリント条件1("過年度期情報_口座対象者プリント条件1"),
    /**
     * コード:無し 名称:過年度期情報_口座対象者プリント条件2 略称:定義なし
     */
    過年度期情報_口座対象者プリント条件2("過年度期情報_口座対象者プリント条件2"),
    /**
     * コード:無し 名称:過年度期情報_口座対象者プリント条件3 略称:定義なし
     */
    過年度期情報_口座対象者プリント条件3("過年度期情報_口座対象者プリント条件3"),
    /**
     * コード:無し 名称:過年度期情報_口座対象者プリント条件4 略称:定義なし
     */
    過年度期情報_口座対象者プリント条件4("過年度期情報_口座対象者プリント条件4"),
    /**
     * コード:無し 名称:過年度期情報_口座対象者プリント条件5 略称:定義なし
     */
    過年度期情報_口座対象者プリント条件5("過年度期情報_口座対象者プリント条件5"),
    /**
     * コード:無し 名称:過年度期情報_口座対象者プリント条件6 略称:定義なし
     */
    過年度期情報_口座対象者プリント条件6("過年度期情報_口座対象者プリント条件6"),
    /**
     * コード:無し 名称:過年度期情報_口座対象者プリント条件7 略称:定義なし
     */
    過年度期情報_口座対象者プリント条件7("過年度期情報_口座対象者プリント条件7"),
    /**
     * コード:無し 名称:過年度期情報_口座対象者プリント条件8 略称:定義なし
     */
    過年度期情報_口座対象者プリント条件8("過年度期情報_口座対象者プリント条件8"),
    /**
     * コード:無し 名称:過年度期情報_口座対象者プリント条件9 略称:定義なし
     */
    過年度期情報_口座対象者プリント条件9("過年度期情報_口座対象者プリント条件9"),
    /**
     * コード:無し 名称:過年度期情報_口座対象者プリント条件10 略称:定義なし
     */
    過年度期情報_口座対象者プリント条件10("過年度期情報_口座対象者プリント条件10"),
    /**
     * コード:無し 名称:過年度期情報_口座対象者プリント条件11 略称:定義なし
     */
    過年度期情報_口座対象者プリント条件11("過年度期情報_口座対象者プリント条件11"),
    /**
     * コード:無し 名称:過年度期情報_口座対象者プリント条件12 略称:定義なし
     */
    過年度期情報_口座対象者プリント条件12("過年度期情報_口座対象者プリント条件12"),
    /**
     * コード:無し 名称:過年度期情報_過年度の歳出1 略称:定義なし
     */
    過年度期情報_過年度の歳出1("過年度期情報_過年度の歳出1"),
    /**
     * コード:無し 名称:過年度期情報_過年度の歳出2 略称:定義なし
     */
    過年度期情報_過年度の歳出2("過年度期情報_過年度の歳出2"),
    /**
     * コード:無し 名称:日付関連_更正月判定日数 略称:定義なし
     */
    日付関連_更正月判定日数("日付関連_更正月判定日数"),
    /**
     * コード:無し 名称:特別徴収_平準化計算方法_6月分減額 略称:定義なし
     */
    特別徴収_平準化計算方法_6月分減額("特別徴収_平準化計算方法_6月分減額"),
    /**
     * コード:無し 名称:特別徴収_平準化計算方法_6月分増額 略称:定義なし
     */
    特別徴収_平準化計算方法_6月分増額("特別徴収_平準化計算方法_6月分増額"),
    /**
     * コード:無し 名称:普徴期情報_コンビニカット印字位置1 略称:定義なし
     */
    普徴期情報_コンビニカット印字位置1("普徴期情報_コンビニカット印字位置1"),
    /**
     * コード:無し 名称:普徴期情報_コンビニカット印字位置2 略称:定義なし
     */
    普徴期情報_コンビニカット印字位置2("普徴期情報_コンビニカット印字位置2"),
    /**
     * コード:無し 名称:普徴期情報_コンビニカット印字位置3 略称:定義なし
     */
    普徴期情報_コンビニカット印字位置3("普徴期情報_コンビニカット印字位置3"),
    /**
     * コード:無し 名称:普徴期情報_コンビニカット印字位置4 略称:定義なし
     */
    普徴期情報_コンビニカット印字位置4("普徴期情報_コンビニカット印字位置4"),
    /**
     * コード:無し 名称:普徴期情報_コンビニカット印字位置5 略称:定義なし
     */
    普徴期情報_コンビニカット印字位置5("普徴期情報_コンビニカット印字位置5"),
    /**
     * コード:無し 名称:普徴期情報_コンビニカット印字位置6 略称:定義なし
     */
    普徴期情報_コンビニカット印字位置6("普徴期情報_コンビニカット印字位置6"),
    /**
     * コード:無し 名称:普徴期情報_コンビニカット印字位置7 略称:定義なし
     */
    普徴期情報_コンビニカット印字位置7("普徴期情報_コンビニカット印字位置7"),
    /**
     * コード:無し 名称:普徴期情報_コンビニカット印字位置8 略称:定義なし
     */
    普徴期情報_コンビニカット印字位置8("普徴期情報_コンビニカット印字位置8"),
    /**
     * コード:無し 名称:普徴期情報_コンビニカット印字位置9 略称:定義なし
     */
    普徴期情報_コンビニカット印字位置9("普徴期情報_コンビニカット印字位置9"),
    /**
     * コード:無し 名称:普徴期情報_コンビニカット印字位置10 略称:定義なし
     */
    普徴期情報_コンビニカット印字位置10("普徴期情報_コンビニカット印字位置10"),
    /**
     * コード:無し 名称:普徴期情報_コンビニカット印字位置11 略称:定義なし
     */
    普徴期情報_コンビニカット印字位置11("普徴期情報_コンビニカット印字位置11"),
    /**
     * コード:無し 名称:普徴期情報_コンビニカット印字位置12 略称:定義なし
     */
    普徴期情報_コンビニカット印字位置12("普徴期情報_コンビニカット印字位置12"),
    /**
     * コード:無し 名称:普徴期情報_コンビニカット印字位置13 略称:定義なし
     */
    普徴期情報_コンビニカット印字位置13("普徴期情報_コンビニカット印字位置13"),
    /**
     * コード:無し 名称:普徴期情報_コンビニカット印字位置14 略称:定義なし
     */
    普徴期情報_コンビニカット印字位置14("普徴期情報_コンビニカット印字位置14"),
    /**
     * コード:無し 名称:普徴期情報_コンビニ連帳印字位置1 略称:定義なし
     */
    普徴期情報_コンビニ連帳印字位置1("普徴期情報_コンビニ連帳印字位置1"),
    /**
     * コード:無し 名称:普徴期情報_コンビニ連帳印字位置2 略称:定義なし
     */
    普徴期情報_コンビニ連帳印字位置2("普徴期情報_コンビニ連帳印字位置2"),
    /**
     * コード:無し 名称:普徴期情報_コンビニ連帳印字位置3 略称:定義なし
     */
    普徴期情報_コンビニ連帳印字位置3("普徴期情報_コンビニ連帳印字位置3"),
    /**
     * コード:無し 名称:普徴期情報_コンビニ連帳印字位置4 略称:定義なし
     */
    普徴期情報_コンビニ連帳印字位置4("普徴期情報_コンビニ連帳印字位置4"),
    /**
     * コード:無し 名称:普徴期情報_コンビニ連帳印字位置5 略称:定義なし
     */
    普徴期情報_コンビニ連帳印字位置5("普徴期情報_コンビニ連帳印字位置5"),
    /**
     * コード:無し 名称:普徴期情報_コンビニ連帳印字位置6 略称:定義なし
     */
    普徴期情報_コンビニ連帳印字位置6("普徴期情報_コンビニ連帳印字位置6"),
    /**
     * コード:無し 名称:普徴期情報_コンビニ連帳印字位置7 略称:定義なし
     */
    普徴期情報_コンビニ連帳印字位置7("普徴期情報_コンビニ連帳印字位置7"),
    /**
     * コード:無し 名称:普徴期情報_コンビニ連帳印字位置8 略称:定義なし
     */
    普徴期情報_コンビニ連帳印字位置8("普徴期情報_コンビニ連帳印字位置8"),
    /**
     * コード:無し 名称:普徴期情報_コンビニ連帳印字位置9 略称:定義なし
     */
    普徴期情報_コンビニ連帳印字位置9("普徴期情報_コンビニ連帳印字位置9"),
    /**
     * コード:無し 名称:普徴期情報_コンビニ連帳印字位置10 略称:定義なし
     */
    普徴期情報_コンビニ連帳印字位置10("普徴期情報_コンビニ連帳印字位置10"),
    /**
     * コード:無し 名称:普徴期情報_コンビニ連帳印字位置11 略称:定義なし
     */
    普徴期情報_コンビニ連帳印字位置11("普徴期情報_コンビニ連帳印字位置11"),
    /**
     * コード:無し 名称:普徴期情報_コンビニ連帳印字位置12 略称:定義なし
     */
    普徴期情報_コンビニ連帳印字位置12("普徴期情報_コンビニ連帳印字位置12"),
    /**
     * コード:無し 名称:普徴期情報_コンビニ連帳印字位置13 略称:定義なし
     */
    普徴期情報_コンビニ連帳印字位置13("普徴期情報_コンビニ連帳印字位置13"),
    /**
     * コード:無し 名称:普徴期情報_コンビニ連帳印字位置14 略称:定義なし
     */
    普徴期情報_コンビニ連帳印字位置14("普徴期情報_コンビニ連帳印字位置14"),
    /**
     * コード:無し 名称:普徴期情報_納付書の印字位置1 略称:定義なし
     */
    普徴期情報_納付書の印字位置1("普徴期情報_納付書の印字位置1"),
    /**
     * コード:無し 名称:普徴期情報_納付書の印字位置2 略称:定義なし
     */
    普徴期情報_納付書の印字位置2("普徴期情報_納付書の印字位置2"),
    /**
     * コード:無し 名称:普徴期情報_納付書の印字位置3 略称:定義なし
     */
    普徴期情報_納付書の印字位置3("普徴期情報_納付書の印字位置3"),
    /**
     * コード:無し 名称:普徴期情報_納付書の印字位置4 略称:定義なし
     */
    普徴期情報_納付書の印字位置4("普徴期情報_納付書の印字位置4"),
    /**
     * コード:無し 名称:普徴期情報_納付書の印字位置5 略称:定義なし
     */
    普徴期情報_納付書の印字位置5("普徴期情報_納付書の印字位置5"),
    /**
     * コード:無し 名称:普徴期情報_納付書の印字位置6 略称:定義なし
     */
    普徴期情報_納付書の印字位置6("普徴期情報_納付書の印字位置6"),
    /**
     * コード:無し 名称:普徴期情報_納付書の印字位置7 略称:定義なし
     */
    普徴期情報_納付書の印字位置7("普徴期情報_納付書の印字位置7"),
    /**
     * コード:無し 名称:普徴期情報_納付書の印字位置8 略称:定義なし
     */
    普徴期情報_納付書の印字位置8("普徴期情報_納付書の印字位置8"),
    /**
     * コード:無し 名称:普徴期情報_納付書の印字位置9 略称:定義なし
     */
    普徴期情報_納付書の印字位置9("普徴期情報_納付書の印字位置9"),
    /**
     * コード:無し 名称:普徴期情報_納付書の印字位置10 略称:定義なし
     */
    普徴期情報_納付書の印字位置10("普徴期情報_納付書の印字位置10"),
    /**
     * コード:無し 名称:普徴期情報_納付書の印字位置11 略称:定義なし
     */
    普徴期情報_納付書の印字位置11("普徴期情報_納付書の印字位置11"),
    /**
     * コード:無し 名称:普徴期情報_納付書の印字位置12 略称:定義なし
     */
    普徴期情報_納付書の印字位置12("普徴期情報_納付書の印字位置12"),
    /**
     * コード:無し 名称:普徴期情報_納付書の印字位置13 略称:定義なし
     */
    普徴期情報_納付書の印字位置13("普徴期情報_納付書の印字位置13"),
    /**
     * コード:無し 名称:普徴期情報_納付書の印字位置14 略称:定義なし
     */
    普徴期情報_納付書の印字位置14("普徴期情報_納付書の印字位置14"),
    /**
     * コード:無し 名称:普徴期情報_ブック開始位置1 略称:定義なし
     */
    普徴期情報_ブック開始位置1("普徴期情報_ブック開始位置1"),
    /**
     * コード:無し 名称:普徴期情報_ブック開始位置2 略称:定義なし
     */
    普徴期情報_ブック開始位置2("普徴期情報_ブック開始位置2"),
    /**
     * コード:無し 名称:普徴期情報_ブック開始位置3 略称:定義なし
     */
    普徴期情報_ブック開始位置3("普徴期情報_ブック開始位置3"),
    /**
     * コード:無し 名称:普徴期情報_ブック開始位置4 略称:定義なし
     */
    普徴期情報_ブック開始位置4("普徴期情報_ブック開始位置4"),
    /**
     * コード:無し 名称:普徴期情報_ブック開始位置5 略称:定義なし
     */
    普徴期情報_ブック開始位置5("普徴期情報_ブック開始位置5"),
    /**
     * コード:無し 名称:普徴期情報_ブック開始位置6 略称:定義なし
     */
    普徴期情報_ブック開始位置6("普徴期情報_ブック開始位置6"),
    /**
     * コード:無し 名称:普徴期情報_ブック開始位置7 略称:定義なし
     */
    普徴期情報_ブック開始位置7("普徴期情報_ブック開始位置7"),
    /**
     * コード:無し 名称:普徴期情報_ブック開始位置8 略称:定義なし
     */
    普徴期情報_ブック開始位置8("普徴期情報_ブック開始位置8"),
    /**
     * コード:無し 名称:普徴期情報_ブック開始位置9 略称:定義なし
     */
    普徴期情報_ブック開始位置9("普徴期情報_ブック開始位置9"),
    /**
     * コード:無し 名称:普徴期情報_ブック開始位置10 略称:定義なし
     */
    普徴期情報_ブック開始位置10("普徴期情報_ブック開始位置10"),
    /**
     * コード:無し 名称:普徴期情報_ブック開始位置11 略称:定義なし
     */
    普徴期情報_ブック開始位置11("普徴期情報_ブック開始位置11"),
    /**
     * コード:無し 名称:普徴期情報_ブック開始位置12 略称:定義なし
     */
    普徴期情報_ブック開始位置12("普徴期情報_ブック開始位置12"),
    /**
     * コード:無し 名称:普徴期情報_ブック開始位置13 略称:定義なし
     */
    普徴期情報_ブック開始位置13("普徴期情報_ブック開始位置13"),
    /**
     * コード:無し 名称:普徴期情報_ブック開始位置14 略称:定義なし
     */
    普徴期情報_ブック開始位置14("普徴期情報_ブック開始位置14"),
    /**
     * コード:無し 名称:過年度期情報_納付書の印字位置1 略称:定義なし
     */
    過年度期情報_納付書の印字位置1("過年度期情報_納付書の印字位置1"),
    /**
     * コード:無し 名称:過年度期情報_納付書の印字位置2 略称:定義なし
     */
    過年度期情報_納付書の印字位置2("過年度期情報_納付書の印字位置2"),
    /**
     * コード:無し 名称:過年度期情報_納付書の印字位置3 略称:定義なし
     */
    過年度期情報_納付書の印字位置3("過年度期情報_納付書の印字位置3"),
    /**
     * コード:無し 名称:過年度期情報_納付書の印字位置4 略称:定義なし
     */
    過年度期情報_納付書の印字位置4("過年度期情報_納付書の印字位置4"),
    /**
     * コード:無し 名称:過年度期情報_納付書の印字位置5 略称:定義なし
     */
    過年度期情報_納付書の印字位置5("過年度期情報_納付書の印字位置5"),
    /**
     * コード:無し 名称:過年度期情報_納付書の印字位置6 略称:定義なし
     */
    過年度期情報_納付書の印字位置6("過年度期情報_納付書の印字位置6"),
    /**
     * コード:無し 名称:過年度期情報_納付書の印字位置7 略称:定義なし
     */
    過年度期情報_納付書の印字位置7("過年度期情報_納付書の印字位置7"),
    /**
     * コード:無し 名称:過年度期情報_納付書の印字位置8 略称:定義なし
     */
    過年度期情報_納付書の印字位置8("過年度期情報_納付書の印字位置8"),
    /**
     * コード:無し 名称:過年度期情報_納付書の印字位置9 略称:定義なし
     */
    過年度期情報_納付書の印字位置9("過年度期情報_納付書の印字位置9"),
    /**
     * コード:無し 名称:過年度期情報_納付書の印字位置10 略称:定義なし
     */
    過年度期情報_納付書の印字位置10("過年度期情報_納付書の印字位置10"),
    /**
     * コード:無し 名称:過年度期情報_納付書の印字位置11 略称:定義なし
     */
    過年度期情報_納付書の印字位置11("過年度期情報_納付書の印字位置11"),
    /**
     * コード:無し 名称:過年度期情報_納付書の印字位置12 略称:定義なし
     */
    過年度期情報_納付書の印字位置12("過年度期情報_納付書の印字位置12"),
    /**
     * コード:無し 名称:過年度期情報_ブック開始位置1 略称:定義なし
     */
    過年度期情報_ブック開始位置1("過年度期情報_ブック開始位置1"),
    /**
     * コード:無し 名称:過年度期情報_ブック開始位置2 略称:定義なし
     */
    過年度期情報_ブック開始位置2("過年度期情報_ブック開始位置2"),
    /**
     * コード:無し 名称:過年度期情報_ブック開始位置3 略称:定義なし
     */
    過年度期情報_ブック開始位置3("過年度期情報_ブック開始位置3"),
    /**
     * コード:無し 名称:過年度期情報_ブック開始位置4 略称:定義なし
     */
    過年度期情報_ブック開始位置4("過年度期情報_ブック開始位置4"),
    /**
     * コード:無し 名称:過年度期情報_ブック開始位置5 略称:定義なし
     */
    過年度期情報_ブック開始位置5("過年度期情報_ブック開始位置5"),
    /**
     * コード:無し 名称:過年度期情報_ブック開始位置6 略称:定義なし
     */
    過年度期情報_ブック開始位置6("過年度期情報_ブック開始位置6"),
    /**
     * コード:無し 名称:過年度期情報_ブック開始位置7 略称:定義なし
     */
    過年度期情報_ブック開始位置7("過年度期情報_ブック開始位置7"),
    /**
     * コード:無し 名称:過年度期情報_ブック開始位置8 略称:定義なし
     */
    過年度期情報_ブック開始位置8("過年度期情報_ブック開始位置8"),
    /**
     * コード:無し 名称:過年度期情報_ブック開始位置9 略称:定義なし
     */
    過年度期情報_ブック開始位置9("過年度期情報_ブック開始位置9"),
    /**
     * コード:無し 名称:過年度期情報_ブック開始位置10 略称:定義なし
     */
    過年度期情報_ブック開始位置10("過年度期情報_ブック開始位置10"),
    /**
     * コード:無し 名称:過年度期情報_ブック開始位置11 略称:定義なし
     */
    過年度期情報_ブック開始位置11("過年度期情報_ブック開始位置11"),
    /**
     * コード:無し 名称:過年度期情報_ブック開始位置12 略称:定義なし
     */
    過年度期情報_ブック開始位置12("過年度期情報_ブック開始位置12"),
    /**
     * コード:無し 名称:所得引出_所得引出方法 略称:定義なし
     */
    所得引出_所得引出方法("所得引出_所得引出方法"),
    /**
     * コード:無し 名称:所得引出_住民税減免前後表示区分 略称:定義なし
     */
    所得引出_住民税減免前後表示区分("所得引出_住民税減免前後表示区分"),
    /**
     * コード:無し 名称:過年度期情報_コンビニカット印字位置1 略称:定義なし
     */
    過年度期情報_コンビニカット印字位置1("過年度期情報_コンビニカット印字位置1"),
    /**
     * コード:無し 名称:過年度期情報_コンビニカット印字位置2 略称:定義なし
     */
    過年度期情報_コンビニカット印字位置2("過年度期情報_コンビニカット印字位置2"),
    /**
     * コード:無し 名称:過年度期情報_コンビニカット印字位置3 略称:定義なし
     */
    過年度期情報_コンビニカット印字位置3("過年度期情報_コンビニカット印字位置3"),
    /**
     * コード:無し 名称:過年度期情報_コンビニカット印字位置4 略称:定義なし
     */
    過年度期情報_コンビニカット印字位置4("過年度期情報_コンビニカット印字位置4"),
    /**
     * コード:無し 名称:過年度期情報_コンビニカット印字位置5 略称:定義なし
     */
    過年度期情報_コンビニカット印字位置5("過年度期情報_コンビニカット印字位置5"),
    /**
     * コード:無し 名称:過年度期情報_コンビニカット印字位置6 略称:定義なし
     */
    過年度期情報_コンビニカット印字位置6("過年度期情報_コンビニカット印字位置6"),
    /**
     * コード:無し 名称:過年度期情報_コンビニカット印字位置7 略称:定義なし
     */
    過年度期情報_コンビニカット印字位置7("過年度期情報_コンビニカット印字位置7"),
    /**
     * コード:無し 名称:過年度期情報_コンビニカット印字位置8 略称:定義なし
     */
    過年度期情報_コンビニカット印字位置8("過年度期情報_コンビニカット印字位置8"),
    /**
     * コード:無し 名称:過年度期情報_コンビニカット印字位置9 略称:定義なし
     */
    過年度期情報_コンビニカット印字位置9("過年度期情報_コンビニカット印字位置9"),
    /**
     * コード:無し 名称:過年度期情報_コンビニカット印字位置10 略称:定義なし
     */
    過年度期情報_コンビニカット印字位置10("過年度期情報_コンビニカット印字位置10"),
    /**
     * コード:無し 名称:過年度期情報_コンビニカット印字位置11 略称:定義なし
     */
    過年度期情報_コンビニカット印字位置11("過年度期情報_コンビニカット印字位置11"),
    /**
     * コード:無し 名称:過年度期情報_コンビニカット印字位置12 略称:定義なし
     */
    過年度期情報_コンビニカット印字位置12("過年度期情報_コンビニカット印字位置12"),
    /**
     * コード:無し 名称:過年度期情報_コンビニ連帳印字位置1 略称:定義なし
     */
    過年度期情報_コンビニ連帳印字位置1("過年度期情報_コンビニ連帳印字位置1"),
    /**
     * コード:無し 名称:過年度期情報_コンビニ連帳印字位置2 略称:定義なし
     */
    過年度期情報_コンビニ連帳印字位置2("過年度期情報_コンビニ連帳印字位置2"),
    /**
     * コード:無し 名称:過年度期情報_コンビニ連帳印字位置3 略称:定義なし
     */
    過年度期情報_コンビニ連帳印字位置3("過年度期情報_コンビニ連帳印字位置3"),
    /**
     * コード:無し 名称:過年度期情報_コンビニ連帳印字位置4 略称:定義なし
     */
    過年度期情報_コンビニ連帳印字位置4("過年度期情報_コンビニ連帳印字位置4"),
    /**
     * コード:無し 名称:過年度期情報_コンビニ連帳印字位置5 略称:定義なし
     */
    過年度期情報_コンビニ連帳印字位置5("過年度期情報_コンビニ連帳印字位置5"),
    /**
     * コード:無し 名称:過年度期情報_コンビニ連帳印字位置6 略称:定義なし
     */
    過年度期情報_コンビニ連帳印字位置6("過年度期情報_コンビニ連帳印字位置6"),
    /**
     * コード:無し 名称:過年度期情報_コンビニ連帳印字位置7 略称:定義なし
     */
    過年度期情報_コンビニ連帳印字位置7("過年度期情報_コンビニ連帳印字位置7"),
    /**
     * コード:無し 名称:過年度期情報_コンビニ連帳印字位置8 略称:定義なし
     */
    過年度期情報_コンビニ連帳印字位置8("過年度期情報_コンビニ連帳印字位置8"),
    /**
     * コード:無し 名称:過年度期情報_コンビニ連帳印字位置9 略称:定義なし
     */
    過年度期情報_コンビニ連帳印字位置9("過年度期情報_コンビニ連帳印字位置9"),
    /**
     * コード:無し 名称:過年度期情報_コンビニ連帳印字位置10 略称:定義なし
     */
    過年度期情報_コンビニ連帳印字位置10("過年度期情報_コンビニ連帳印字位置10"),
    /**
     * コード:無し 名称:過年度期情報_コンビニ連帳印字位置11 略称:定義なし
     */
    過年度期情報_コンビニ連帳印字位置11("過年度期情報_コンビニ連帳印字位置11"),
    /**
     * コード:無し 名称:過年度期情報_コンビニ連帳印字位置12 略称:定義なし
     */
    過年度期情報_コンビニ連帳印字位置12("過年度期情報_コンビニ連帳印字位置12"),
    /**
     * コード:無し 名称:普通徴収_仮算定異動新規資格賦課 略称:定義なし
     */
    普通徴収_仮算定異動新規資格賦課("普通徴収_仮算定異動新規資格賦課"),
    /**
     * コード:無し 名称:普通徴収_仮算定異動新規賦課方法 略称:定義なし
     */
    普通徴収_仮算定異動新規賦課方法("普通徴収_仮算定異動新規賦課方法"),
    /**
     * コード:無し 名称:普通徴収_仮算定新規資格適用段階 略称:定義なし
     */
    普通徴収_仮算定新規資格適用段階("普通徴収_仮算定新規資格適用段階"),
    /**
     * コード:無し 名称:激変緩和_開始年度 略称:定義なし
     */
    激変緩和_開始年度("激変緩和_開始年度"),
    /**
     * コード:無し 名称:激変緩和_終了年度 略称:定義なし
     */
    激変緩和_終了年度("激変緩和_終了年度"),
    /**
     * コード:無し 名称:賦課基準_課税層保険料段階インデックス 略称:定義なし
     */
    賦課基準_課税層保険料段階インデックス("賦課基準_課税層保険料段階インデックス"),
    /**
     * コード:無し 名称:賦課基準_基準年金収入1 略称:定義なし
     */
    賦課基準_基準年金収入1("賦課基準_基準年金収入1"),
    /**
     * コード:無し 名称:賦課基準_基準年金収入2 略称:定義なし
     */
    賦課基準_基準年金収入2("賦課基準_基準年金収入2"),
    /**
     * コード:無し 名称:賦課基準_基準年金収入3 略称:定義なし
     */
    賦課基準_基準年金収入3("賦課基準_基準年金収入3"),
    /**
     * コード:無し 名称:賦課基準_未申告保険料段階使用 略称:定義なし
     */
    賦課基準_未申告保険料段階使用("賦課基準_未申告保険料段階使用"),
    /**
     * コード:無し 名称:賦課基準_未申告保険料段階インデックス 略称:定義なし
     */
    賦課基準_未申告保険料段階インデックス("賦課基準_未申告保険料段階インデックス"),
    /**
     * コード:無し 名称:賦課基準_所得調査中保険料段階使用 略称:定義なし
     */
    賦課基準_所得調査中保険料段階使用("賦課基準_所得調査中保険料段階使用"),
    /**
     * コード:無し 名称:賦課基準_所得調査中保険料段階インデックス 略称:定義なし
     */
    賦課基準_所得調査中保険料段階インデックス("賦課基準_所得調査中保険料段階インデックス"),
    /**
     * コード:無し 名称:賦課基準_課税取消保険料段階使用 略称:定義なし
     */
    賦課基準_課税取消保険料段階使用("賦課基準_課税取消保険料段階使用"),
    /**
     * コード:無し 名称:賦課基準_課税取消保険料段階インデックス 略称:定義なし
     */
    賦課基準_課税取消保険料段階インデックス("賦課基準_課税取消保険料段階インデックス"),
    /**
     * コード:無し 名称:賦課基準_基準所得金額1 略称:定義なし
     */
    賦課基準_基準所得金額1("賦課基準_基準所得金額1"),
    /**
     * コード:無し 名称:賦課基準_基準所得金額2 略称:定義なし
     */
    賦課基準_基準所得金額2("賦課基準_基準所得金額2"),
    /**
     * コード:無し 名称:賦課基準_基準所得金額3 略称:定義なし
     */
    賦課基準_基準所得金額3("賦課基準_基準所得金額3"),
    /**
     * コード:無し 名称:賦課基準_基準所得金額4 略称:定義なし
     */
    賦課基準_基準所得金額4("賦課基準_基準所得金額4"),
    /**
     * コード:無し 名称:賦課基準_基準所得金額5 略称:定義なし
     */
    賦課基準_基準所得金額5("賦課基準_基準所得金額5"),
    /**
     * コード:無し 名称:賦課基準_基準所得金額6 略称:定義なし
     */
    賦課基準_基準所得金額6("賦課基準_基準所得金額6"),
    /**
     * コード:無し 名称:賦課基準_基準所得金額7 略称:定義なし
     */
    賦課基準_基準所得金額7("賦課基準_基準所得金額7"),
    /**
     * コード:無し 名称:賦課基準_基準所得金額8 略称:定義なし
     */
    賦課基準_基準所得金額8("賦課基準_基準所得金額8"),
    /**
     * コード:無し 名称:賦課基準_基準所得金額9 略称:定義なし
     */
    賦課基準_基準所得金額9("賦課基準_基準所得金額9"),
    /**
     * コード:無し 名称:賦課基準_基準所得金額10 略称:定義なし
     */
    賦課基準_基準所得金額10("賦課基準_基準所得金額10"),
    /**
     * コード:無し 名称:賦課基準_基準所得金額11 略称:定義なし
     */
    賦課基準_基準所得金額11("賦課基準_基準所得金額11"),
    /**
     * コード:無し 名称:賦課基準_基準所得金額12 略称:定義なし
     */
    賦課基準_基準所得金額12("賦課基準_基準所得金額12"),
    /**
     * コード:無し 名称:賦課基準_基準所得金額13 略称:定義なし
     */
    賦課基準_基準所得金額13("賦課基準_基準所得金額13"),
    /**
     * コード:無し 名称:賦課基準_基準所得金額14 略称:定義なし
     */
    賦課基準_基準所得金額14("賦課基準_基準所得金額14"),
    /**
     * コード:無し 名称:賦課基準_基準所得金額15 略称:定義なし
     */
    賦課基準_基準所得金額15("賦課基準_基準所得金額15");
    private final RString fullName;

    private ConfigNameDBB(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * コンフィグ名称(DBB)の名称を返します。
     *
     * @return コンフィグ名称(DBB)の名称
     */
    public RString get名称() {
        return fullName;
    }
}
