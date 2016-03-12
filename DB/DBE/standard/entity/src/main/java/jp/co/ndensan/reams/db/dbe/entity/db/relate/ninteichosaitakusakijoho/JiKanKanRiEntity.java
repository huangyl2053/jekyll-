/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaitakusakijoho;

import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 時間管理の場合で認定調査スケジュール情報戻るのEntity。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JiKanKanRiEntity {

    private RString ninteiChosaItakusakiCode;
    private RString chosainShimei;
    private RString jigyoshaMeisho;
    private Code yoyakuJokyo;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private TelNo renrakusaki1;
    private TelNo renrakusaki2;
    private RString eightClock;
    private RString halfPastEightClock;
    private RString nineClock;
    private RString halfPastNineClock;
    private RString tenClock;
    private RString halfPastTenClock;
    private RString elevenClock;
    private RString halfPastElevenClock;
    private RString twelveClock;
    private RString halfPastTwelveClock;
    private RString thirteenClock;
    private RString halfPastThirteenClock;
    private RString fourteenClock;
    private RString halfPastFourteenClock;
    private RString fifteenClock;
    private RString halfPastFifteenClock;
    private RString sixteenClock;
    private RString halfPastSixteenClock;
    private RString seventeenClock;
    private RString halfPastSeventeenClock;
    private RString eighteenClock;
    private RString halfPastEighteenClock;
    private RString nineteenClock;
    private RString halfPastNineteenClock;
    private RString twentyClock;
    private RString halfPastTwentyClock;
}
