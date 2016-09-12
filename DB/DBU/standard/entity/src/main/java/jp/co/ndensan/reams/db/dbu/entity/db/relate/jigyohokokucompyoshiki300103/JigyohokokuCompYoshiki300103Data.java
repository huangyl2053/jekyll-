/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki300103;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護事業状況報告年報（様式1-2）のパラメータクラスです。
 *
 * @reamsid_L DBU-5600-120 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuCompYoshiki300103Data {

    private RString 様式;
    private RDateTime 処理日時;
    private RString 年報月報区分;
    private FlexibleYear 集計年度;
    private FlexibleYearMonth 集計期間FROM;
    private FlexibleYearMonth 集計期間TO;
    private RString 保険者番号;
    private RString 保険者名;
    private RString 表1のタイトル;
    private RString 表2のタイトル1;
    private RString 表2のタイトル2;
    private RString 表3のタイトル;
    private RString 介護老人福祉施設の申請件数;
    private RString 介護老人保健施設の申請件数;
    private RString 介護療養型医療施設の申請件数;
    private RString 地域密着型介護老人福祉施設入居者生活介護の申請件数;
    private RString その他の申請件数;
    private RString 合計の申請件数;
    private RString 特定負担限度額の申請件数;
    private RString 介護老人福祉施設_食費_1;
    private RString 介護老人福祉施設_食費_2;
    private RString 介護老人福祉施設_食費_3;
    private RString 介護老人福祉施設_食費_4;
    private RString 介護老人福祉施設_食費_5;
    private RString 介護老人福祉施設_食費_6;
    private RString 介護老人福祉施設_居住費_1;
    private RString 介護老人福祉施設_居住費_2;
    private RString 介護老人福祉施設_居住費_3;
    private RString 介護老人福祉施設_居住費_4;
    private RString 介護老人福祉施設_居住費_5;
    private RString 介護老人福祉施設_居住費_6;
    private RString 介護老人保健施設_食費_1;
    private RString 介護老人保健施設_食費_2;
    private RString 介護老人保健施設_食費_3;
    private RString 介護老人保健施設_食費_4;
    private RString 介護老人保健施設_食費_5;
    private RString 介護老人保健施設_食費_6;
    private RString 介護老人保健施設_居住費_1;
    private RString 介護老人保健施設_居住費_2;
    private RString 介護老人保健施設_居住費_3;
    private RString 介護老人保健施設_居住費_4;
    private RString 介護老人保健施設_居住費_5;
    private RString 介護老人保健施設_居住費_6;
    private RString 介護療養型医療施設_食費_1;
    private RString 介護療養型医療施設_食費_2;
    private RString 介護療養型医療施設_食費_3;
    private RString 介護療養型医療施設_食費_4;
    private RString 介護療養型医療施設_食費_5;
    private RString 介護療養型医療施設_食費_6;
    private RString 介護療養型医療施設_居住費_1;
    private RString 介護療養型医療施設_居住費_2;
    private RString 介護療養型医療施設_居住費_3;
    private RString 介護療養型医療施設_居住費_4;
    private RString 介護療養型医療施設_居住費_5;
    private RString 介護療養型医療施設_居住費_6;
    private RString 地域密着型介護老人福祉施設入居者生活介護_食費_1;
    private RString 地域密着型介護老人福祉施設入居者生活介護_食費_2;
    private RString 地域密着型介護老人福祉施設入居者生活介護_食費_3;
    private RString 地域密着型介護老人福祉施設入居者生活介護_食費_4;
    private RString 地域密着型介護老人福祉施設入居者生活介護_食費_5;
    private RString 地域密着型介護老人福祉施設入居者生活介護_食費_6;
    private RString 地域密着型介護老人福祉施設入居者生活介護_居住費_1;
    private RString 地域密着型介護老人福祉施設入居者生活介護_居住費_2;
    private RString 地域密着型介護老人福祉施設入居者生活介護_居住費_3;
    private RString 地域密着型介護老人福祉施設入居者生活介護_居住費_4;
    private RString 地域密着型介護老人福祉施設入居者生活介護_居住費_5;
    private RString 地域密着型介護老人福祉施設入居者生活介護_居住費_6;
    private RString その他_食費_1;
    private RString その他_食費_2;
    private RString その他_食費_3;
    private RString その他_食費_4;
    private RString その他_食費_5;
    private RString その他_食費_6;
    private RString その他_居住費_1;
    private RString その他_居住費_2;
    private RString その他_居住費_3;
    private RString その他_居住費_4;
    private RString その他_居住費_5;
    private RString その他_居住費_6;
    private RString 合計_食費_1;
    private RString 合計_食費_2;
    private RString 合計_食費_3;
    private RString 合計_食費_4;
    private RString 合計_食費_5;
    private RString 合計_食費_6;
    private RString 合計_居住費_1;
    private RString 合計_居住費_2;
    private RString 合計_居住費_3;
    private RString 合計_居住費_4;
    private RString 合計_居住費_5;
    private RString 合計_居住費_6;
    private RString 利用者負担減額_免除認定表の利用者負担_1;
    private RString 利用者負担減額_免除認定表の利用者負担_2;
    private RString 利用者負担減額_免除認定表の利用者負担_3;
    private RString 利用者負担減額_免除認定表の利用者負担_4;
    private RString 利用者負担減額_免除認定表の利用者負担_5;
    private RString 利用者負担減額_免除認定表の利用者負担_6;
    private RString 減免認定表の特定負担限度額_食費_1;
    private RString 減免認定表の特定負担限度額_食費_2;
    private RString 減免認定表の特定負担限度額_食費_3;
    private RString 減免認定表の特定負担限度額_食費_4;
    private RString 減免認定表の特定負担限度額_食費_5;
    private RString 減免認定表の特定負担限度額_食費_6;
    private RString 減免認定表の特定負担限度額_居住費_1;
    private RString 減免認定表の特定負担限度額_居住費_2;
    private RString 減免認定表の特定負担限度額_居住費_3;
    private RString 減免認定表の特定負担限度額_居住費_4;
    private RString 減免認定表の特定負担限度額_居住費_5;
    private RString 減免認定表の特定負担限度額_居住費_6;
    private RString 免除認定表の利用者負担_1;
    private RString 免除認定表の利用者負担_2;
    private RString 免除認定表の利用者負担_3;
    private RString 免除認定表の利用者負担_4;
    private RString 免除認定表の利用者負担_5;
    private RString 免除認定表の利用者負担_6;

}
