/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsahanteinohenkojokyo;

import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査判定の変更状況のパラメータクラスです。
 *
 * @reamsid_L DBE-1450-060 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsahanteinoHenkojokyo {

    private RString タイトル;
    private RString 合議体番号;
    private RString 合議体名称;
    private RString 審査会開始年月日;
    private RString 審査会終了年月日;
    private RString 開催回数;
    private RString 市町村コード;
    private RString 市町村名;
    private RDateTime 発行日時;
    private RString 更新申請_二次判定非該当;
    private RString 更新申請_二次判定要支援1;
    private RString 更新申請_二次判定要支援2;
    private RString 更新申請_二次判定要介護1;
    private RString 更新申請_二次判定要介護2;
    private RString 更新申請_二次判定要介護3;
    private RString 更新申請_二次判定要介護4;
    private RString 更新申請_二次判定要介護5;
    private RString 更新申請_計;
    private RString 更新_認定有効期間延長件数_二次判定非該当;
    private RString 更新_認定有効期間延長件数_二次判定要支援1;
    private RString 更新_認定有効期間延長件数_二次判定要支援2;
    private RString 更新_認定有効期間延長件数_二次判定要介護1;
    private RString 更新_認定有効期間延長件数_二次判定要介護2;
    private RString 更新_認定有効期間延長件数_二次判定要介護3;
    private RString 更新_認定有効期間延長件数_二次判定要介護4;
    private RString 更新_認定有効期間延長件数_二次判定要介護5;
    private RString 更新_認定有効期間延長件数_計;
    private RString 更新_３ヶ月_二次判定非該当;
    private RString 更新_３ヶ月_二次判定要支援1;
    private RString 更新_３ヶ月_二次判定要支援2;
    private RString 更新_３ヶ月_二次判定要介護1;
    private RString 更新_３ヶ月_二次判定要介護2;
    private RString 更新_３ヶ月_二次判定要介護3;
    private RString 更新_３ヶ月_二次判定要介護4;
    private RString 更新_３ヶ月_二次判定要介護5;
    private RString 更新_３ヶ月_計;
    private RString 更新_６ヶ月_二次判定非該当;
    private RString 更新_６ヶ月_二次判定要支援1;
    private RString 更新_６ヶ月_二次判定要支援2;
    private RString 更新_６ヶ月_二次判定要介護1;
    private RString 更新_６ヶ月_二次判定要介護2;
    private RString 更新_６ヶ月_二次判定要介護3;
    private RString 更新_６ヶ月_二次判定要介護4;
    private RString 更新_６ヶ月_二次判定要介護5;
    private RString 更新_６ヶ月_計;
    private RString 更新_１２ヶ月_二次判定非該当;
    private RString 更新_１２ヶ月_二次判定要支援1;
    private RString 更新_１２ヶ月_二次判定要支援2;
    private RString 更新_１２ヶ月_二次判定要介護1;
    private RString 更新_１２ヶ月_二次判定要介護2;
    private RString 更新_１２ヶ月_二次判定要介護3;
    private RString 更新_１２ヶ月_二次判定要介護4;
    private RString 更新_１２ヶ月_二次判定要介護5;
    private RString 更新_１２ヶ月_計;
    private RString 更新_２４ヶ月_二次判定非該当;
    private RString 更新_２４ヶ月_二次判定要支援1;
    private RString 更新_２４ヶ月_二次判定要支援2;
    private RString 更新_２４ヶ月_二次判定要介護1;
    private RString 更新_２４ヶ月_二次判定要介護2;
    private RString 更新_２４ヶ月_二次判定要介護3;
    private RString 更新_２４ヶ月_二次判定要介護4;
    private RString 更新_２４ヶ月_二次判定要介護5;
    private RString 更新_２４ヶ月_計;
    private RString 更新_その他_二次判定非該当;
    private RString 更新_その他_二次判定要支援1;
    private RString 更新_その他_二次判定要支援2;
    private RString 更新_その他_二次判定要介護1;
    private RString 更新_その他_二次判定要介護2;
    private RString 更新_その他_二次判定要介護3;
    private RString 更新_その他_二次判定要介護4;
    private RString 更新_その他_二次判定要介護5;
    private RString 更新_その他_計;
    private RString 新規申請_二次判定非該当;
    private RString 新規申請_二次判定要支援1;
    private RString 新規申請_二次判定要支援2;
    private RString 新規申請_二次判定要介護1;
    private RString 新規申請_二次判定要介護2;
    private RString 新規申請_二次判定要介護3;
    private RString 新規申請_二次判定要介護4;
    private RString 新規申請_二次判定要介護5;
    private RString 新規申請_計;
    private RString 新規_区分変更申請_二次判定非該当;
    private RString 新規_区分変更申請_二次判定要支援1;
    private RString 新規_区分変更申請_二次判定要支援2;
    private RString 新規_区分変更申請_二次判定要介護1;
    private RString 新規_区分変更申請_二次判定要介護2;
    private RString 新規_区分変更申請_二次判定要介護3;
    private RString 新規_区分変更申請_二次判定要介護4;
    private RString 新規_区分変更申請_二次判定要介護5;
    private RString 新規_区分変更申請_計;
    private RString 新規_認定有効期間延長件数_二次判定非該当;
    private RString 新規_認定有効期間延長件数_二次判定要支援1;
    private RString 新規_認定有効期間延長件数_二次判定要支援2;
    private RString 新規_認定有効期間延長件数_二次判定要介護1;
    private RString 新規_認定有効期間延長件数_二次判定要介護2;
    private RString 新規_認定有効期間延長件数_二次判定要介護3;
    private RString 新規_認定有効期間延長件数_二次判定要介護4;
    private RString 新規_認定有効期間延長件数_二次判定要介護5;
    private RString 新規_認定有効期間延長件数_計;
    private RString 新規_３ヶ月_二次判定非該当;
    private RString 新規_３ヶ月_二次判定要支援1;
    private RString 新規_３ヶ月_二次判定要支援2;
    private RString 新規_３ヶ月_二次判定要介護1;
    private RString 新規_３ヶ月_二次判定要介護2;
    private RString 新規_３ヶ月_二次判定要介護3;
    private RString 新規_３ヶ月_二次判定要介護4;
    private RString 新規_３ヶ月_二次判定要介護5;
    private RString 新規_３ヶ月_計;
    private RString 新規_６ヶ月_二次判定非該当;
    private RString 新規_６ヶ月_二次判定要支援1;
    private RString 新規_６ヶ月_二次判定要支援2;
    private RString 新規_６ヶ月_二次判定要介護1;
    private RString 新規_６ヶ月_二次判定要介護2;
    private RString 新規_６ヶ月_二次判定要介護3;
    private RString 新規_６ヶ月_二次判定要介護4;
    private RString 新規_６ヶ月_二次判定要介護5;
    private RString 新規_６ヶ月_計;
    private RString 新規_１２ヶ月_二次判定非該当;
    private RString 新規_１２ヶ月_二次判定要支援1;
    private RString 新規_１２ヶ月_二次判定要支援2;
    private RString 新規_１２ヶ月_二次判定要介護1;
    private RString 新規_１２ヶ月_二次判定要介護2;
    private RString 新規_１２ヶ月_二次判定要介護3;
    private RString 新規_１２ヶ月_二次判定要介護4;
    private RString 新規_１２ヶ月_二次判定要介護5;
    private RString 新規_１２ヶ月_計;
    private RString 新規_２４ヶ月_二次判定非該当;
    private RString 新規_２４ヶ月_二次判定要支援1;
    private RString 新規_２４ヶ月_二次判定要支援2;
    private RString 新規_２４ヶ月_二次判定要介護1;
    private RString 新規_２４ヶ月_二次判定要介護2;
    private RString 新規_２４ヶ月_二次判定要介護3;
    private RString 新規_２４ヶ月_二次判定要介護4;
    private RString 新規_２４ヶ月_二次判定要介護5;
    private RString 新規_２４ヶ月_計;
    private RString 新規_その他_二次判定非該当;
    private RString 新規_その他_二次判定要支援1;
    private RString 新規_その他_二次判定要支援2;
    private RString 新規_その他_二次判定要介護1;
    private RString 新規_その他_二次判定要介護2;
    private RString 新規_その他_二次判定要介護3;
    private RString 新規_その他_二次判定要介護4;
    private RString 新規_その他_二次判定要介護5;
    private RString 新規_その他_計;
    private RString 新規_帳票ID;

}
