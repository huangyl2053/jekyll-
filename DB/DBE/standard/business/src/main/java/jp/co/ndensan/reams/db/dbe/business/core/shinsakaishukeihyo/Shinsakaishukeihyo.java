/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyo;

import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会集計表（判定別）のパラメータクラスです。
 *
 * @reamsid_L DBE-1450-070 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class Shinsakaishukeihyo {

    private RString タイトル;
    private RString 審査会開始年月日;
    private RString 審査会終了年月日;
    private RString 開催回数;
    private RString 市町村コード;
    private RString 市町村名;
    private RDateTime 発行日時;
    private RString 二次判定非該当タイトル;
    private RString 二次判定要支援1タイトル;
    private RString 二次判定要支援2タイトル;
    private RString 二次判定要介護1タイトル;
    private RString 二次判定要介護2タイトル;
    private RString 二次判定要介護3タイトル;
    private RString 二次判定要介護4タイトル;
    private RString 二次判定要介護5タイトル;
    private RString 前回二次判定_計タイトル;
    private RString 前回二次判定非該当タイトル;
    private RString 前回二次判定非該当_二次判定非該当;
    private RString 前回二次判定非該当_二次判定要支援1;
    private RString 前回二次判定非該当_二次判定要支援2;
    private RString 前回二次判定非該当_二次判定要介護1;
    private RString 前回二次判定非該当_二次判定要介護2;
    private RString 前回二次判定非該当_二次判定要介護3;
    private RString 前回二次判定非該当_二次判定要介護4;
    private RString 前回二次判定非該当_二次判定要介護5;
    private RString 前回二次判定非該当_計;
    private RString 前回二次判定要支援1タイトル;
    private RString 前回二次判定要支援1_二次判定非該当;
    private RString 前回二次判定要支援1_二次判定要支援1;
    private RString 前回二次判定要支援1_二次判定要支援2;
    private RString 前回二次判定要支援1_二次判定要介護1;
    private RString 前回二次判定要支援1_二次判定要介護2;
    private RString 前回二次判定要支援1_二次判定要介護3;
    private RString 前回二次判定要支援1_二次判定要介護4;
    private RString 前回二次判定要支援1_二次判定要介護5;
    private RString 前回二次判定要支援1_計;
    private RString 前回二次判定要支援2タイトル;
    private RString 前回二次判定要支援2_二次判定非該当;
    private RString 前回二次判定要支援2_二次判定要支援1;
    private RString 前回二次判定要支援2_二次判定要支援2;
    private RString 前回二次判定要支援2_二次判定要介護1;
    private RString 前回二次判定要支援2_二次判定要介護2;
    private RString 前回二次判定要支援2_二次判定要介護3;
    private RString 前回二次判定要支援2_二次判定要介護4;
    private RString 前回二次判定要支援2_二次判定要介護5;
    private RString 前回二次判定要支援2_計;
    private RString 前回二次判定要介護1タイトル;
    private RString 前回二次判定要介護1_二次判定非該当;
    private RString 前回二次判定要介護1_二次判定要支援1;
    private RString 前回二次判定要介護1_二次判定要支援2;
    private RString 前回二次判定要介護1_二次判定要介護1;
    private RString 前回二次判定要介護1_二次判定要介護2;
    private RString 前回二次判定要介護1_二次判定要介護3;
    private RString 前回二次判定要介護1_二次判定要介護4;
    private RString 前回二次判定要介護1_二次判定要介護5;
    private RString 前回二次判定要介護1_計;
    private RString 前回二次判定要介護2タイトル;
    private RString 前回二次判定要介護2_二次判定非該当;
    private RString 前回二次判定要介護2_二次判定要支援1;
    private RString 前回二次判定要介護2_二次判定要支援2;
    private RString 前回二次判定要介護2_二次判定要介護1;
    private RString 前回二次判定要介護2_二次判定要介護2;
    private RString 前回二次判定要介護2_二次判定要介護3;
    private RString 前回二次判定要介護2_二次判定要介護4;
    private RString 前回二次判定要介護2_二次判定要介護5;
    private RString 前回二次判定要介護2_計;
    private RString 前回二次判定要介護3タイトル;
    private RString 前回二次判定要介護3_二次判定非該当;
    private RString 前回二次判定要介護3_二次判定要支援1;
    private RString 前回二次判定要介護3_二次判定要支援2;
    private RString 前回二次判定要介護3_二次判定要介護1;
    private RString 前回二次判定要介護3_二次判定要介護2;
    private RString 前回二次判定要介護3_二次判定要介護3;
    private RString 前回二次判定要介護3_二次判定要介護4;
    private RString 前回二次判定要介護3_二次判定要介護5;
    private RString 前回二次判定要介護3_計;
    private RString 前回二次判定要介護4タイトル;
    private RString 前回二次判定要介護4_二次判定非該当;
    private RString 前回二次判定要介護4_二次判定要支援1;
    private RString 前回二次判定要介護4_二次判定要支援2;
    private RString 前回二次判定要介護4_二次判定要介護1;
    private RString 前回二次判定要介護4_二次判定要介護2;
    private RString 前回二次判定要介護4_二次判定要介護3;
    private RString 前回二次判定要介護4_二次判定要介護4;
    private RString 前回二次判定要介護4_二次判定要介護5;
    private RString 前回二次判定要介護4_計;
    private RString 前回二次判定要介護5タイトル;
    private RString 前回二次判定要介護5_二次判定非該当;
    private RString 前回二次判定要介護5_二次判定要支援1;
    private RString 前回二次判定要介護5_二次判定要支援2;
    private RString 前回二次判定要介護5_二次判定要介護1;
    private RString 前回二次判定要介護5_二次判定要介護2;
    private RString 前回二次判定要介護5_二次判定要介護3;
    private RString 前回二次判定要介護5_二次判定要介護4;
    private RString 前回二次判定要介護5_二次判定要介護5;
    private RString 前回二次判定要介護5_計;
    private RString 計タイトル;
    private RString 計_二次判定非該当;
    private RString 計_二次判定要支援1;
    private RString 計_二次判定要支援2;
    private RString 計_二次判定要介護1;
    private RString 計_二次判定要介護2;
    private RString 計_二次判定要介護3;
    private RString 計_二次判定要介護4;
    private RString 計_二次判定要介護5;
    private RString 計_計;
    private RString 帳票ID;

}
