/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki28;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事業状況報告年報（様式１・２　市町村特別給付）の帳票出力用データEntity
 *
 * @reamsid_L DBU-5610-050 yaoyahui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuNenpoYoshiki28Entity {

    private RString 様式;
    private RString 集計区分;
    private RDateTime プリント日時;
    private RString 集計範囲;
    private RString 保険者番号;
    private RString 保険者名;
    private RString タイトル;
    private RString サブタイトル;
    private RString 種類;
    private RString 要支援１;
    private RString 要支援２;
    private RString 要支援計;
    private RString 経過的要介護;
    private RString 要介護１;
    private RString 要介護2;
    private RString 要介護3;
    private RString 要介護4;
    private RString 要介護5;
    private RString 要介護計;
    private RString 合計;
    private RString 縦番号;
    private RString 横番号;
    private RString 集計番号;
    private FlexibleYearMonth 集計期間FROM;
    private FlexibleYearMonth 集計期間TO;
    private FlexibleYear 集計年度;
}
