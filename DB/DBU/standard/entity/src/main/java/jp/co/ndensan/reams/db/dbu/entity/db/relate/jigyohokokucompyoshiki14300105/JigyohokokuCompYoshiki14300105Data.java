/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki14300105;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護事業状況報告年報（様式1-4）のパラメータクラスです。
 *
 * @reamsid_L DBU-5600-140 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuCompYoshiki14300105Data {

    private RString 年報月報区分;
    private RDateTime 処理日時;
    private FlexibleYear 集計年度;
    private FlexibleYearMonth 集計期間FROM;
    private FlexibleYearMonth 集計期間TO;
    private RString 保険者番号;
    private RString 保険者名;

    private RString 介護老人福祉施設の申請件数;
    private RString 介護老人保健施設の申請件数;
    private RString 介護療養型医療施設の申請件数;
    private RString 地域密着型介護老人福祉施設入居者生活介護の申請件数;
    private RString その他の申請件数;
    private RString 合計の申請件数;

    private RString 介護老人福祉施設_食費_1;
    private RString 介護老人福祉施設_食費_2;
    private RString 介護老人福祉施設_食費_3;
    private RString 介護老人福祉施設_食費_4;

    private RString 介護老人福祉施設_居住費_1;
    private RString 介護老人福祉施設_居住費_2;
    private RString 介護老人福祉施設_居住費_3;
    private RString 介護老人福祉施設_居住費_4;

    private RString 介護老人保健施設_食費_1;
    private RString 介護老人保健施設_食費_2;
    private RString 介護老人保健施設_食費_3;
    private RString 介護老人保健施設_食費_4;

    private RString 介護老人保健施設_居住費_1;
    private RString 介護老人保健施設_居住費_2;
    private RString 介護老人保健施設_居住費_3;
    private RString 介護老人保健施設_居住費_4;

    private RString 介護療養型医療施設_食費_1;
    private RString 介護療養型医療施設_食費_2;
    private RString 介護療養型医療施設_食費_3;
    private RString 介護療養型医療施設_食費_4;

    private RString 介護療養型医療施設_居住費_1;
    private RString 介護療養型医療施設_居住費_2;
    private RString 介護療養型医療施設_居住費_3;
    private RString 介護療養型医療施設_居住費_4;

    private RString 地域密着型介護老人福祉施設入居者生活介護_食費_1;
    private RString 地域密着型介護老人福祉施設入居者生活介護_食費_2;
    private RString 地域密着型介護老人福祉施設入居者生活介護_食費_3;
    private RString 地域密着型介護老人福祉施設入居者生活介護_食費_4;

    private RString 地域密着型介護老人福祉施設入居者生活介護_居住費_1;
    private RString 地域密着型介護老人福祉施設入居者生活介護_居住費_2;
    private RString 地域密着型介護老人福祉施設入居者生活介護_居住費_3;
    private RString 地域密着型介護老人福祉施設入居者生活介護_居住費_4;

    private RString その他_食費_1;
    private RString その他_食費_2;
    private RString その他_食費_3;
    private RString その他_食費_4;

    private RString その他_居住費_1;
    private RString その他_居住費_2;
    private RString その他_居住費_3;
    private RString その他_居住費_4;

    private RString 合計_食費_1;
    private RString 合計_食費_2;
    private RString 合計_食費_3;
    private RString 合計_食費_4;

    private RString 合計_居住費_1;
    private RString 合計_居住費_2;
    private RString 合計_居住費_3;
    private RString 合計_居住費_4;

}
