/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1070021;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1070021.HomonKaigoRiyoshaFutangakuGengakuNinteishaList;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070021.HomonKaigoRiyoshaFutanGengakuNinteishaListDiv;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 訪問介護利用者負担額減額認定者リスト画面のHandlerです。
 *
 * @reamsid_L DBD-3970-010 xuejm
 */
public class HomonKaigoRiyoshaFutanGengakuNinteishaListHandler {

    private final HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div;
    private static final RString 該当者リスト = new RString("gaitosha");
    private static final RString 対象年度 = new RString("taishoNendo");
    private static final RString 基準日 = new RString("kijunYMD");
    private static final int NO_0 = 0;
    private static final int NO_4 = 4;

    /**
     * 訪問介護利用者負担額減額認定者リストコンストラクタです。
     *
     * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
     */
    public HomonKaigoRiyoshaFutanGengakuNinteishaListHandler(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     */
    public void onLoad() {
        HomonKaigoRiyoshaFutangakuGengakuNinteishaList homokaigoriyosha
                = new HomonKaigoRiyoshaFutangakuGengakuNinteishaList();
        div.getCcdChohyoShuturyokujun().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200003.getReportId());
        div.getTxtTaishoYM().setValue(RDate.getNowDate());
        Range<FlexibleDate> range = homokaigoriyosha.estimate対象期間(
                new FlexibleYear(div.getTxtTaishoYM().getValue().toString().substring(NO_0, NO_4)));
        div.getTxtTaishoKikanKaishi().setValue(range.getFrom());
        div.getTxtTaishoKikanShuryo().setValue(range.getTo());
        div.getTxtShotokuNendo().setValue(RDate.getNowDate());
        div.getTxtKijunYMD().setValue(RDate.getNowDate());
        if (div.getRadTaishoList().getSelectedKey().equals(該当者リスト)) {
            set表示と非表示();
        }
    }

    /**
     * 「該当者リスト」と「認定者リスト」ラジオを操作です。
     *
     */
    public void radTaishoList_onChange() {
        if (div.getRadTaishoList().getSelectedKey().equals(該当者リスト)) {
            set表示と非表示();
        } else {
            div.getRadJukyushaKubun().setDisplayNone(true);
            div.getChkShoriTaisho().setDisplayNone(true);
            div.getDdlHobetsuKubun().setDisplayNone(false);
        }
    }

    /**
     * 「対象年度」と「対象年度」ラジオを操作です。
     *
     */
    public void radTaishoKikanShitei_onChange() {
        if (div.getRadTaishoKikanShitei().getSelectedKey().equals(基準日)) {
            div.getTxtTaishoYM().setDisplayNone(true);
            div.getTxtTaishoKikanKaishi().setDisplayNone(true);
            div.getTxtTaishoKikanShuryo().setDisplayNone(true);
            div.getLblTaishoKikan().setDisplayNone(true);
            div.getTxtKijunYMD().setDisplayNone(false);
            div.getTxtKazeiHanteiToKijunDate().setDisplayNone(true);
            div.getTxtKijunYMD().setValue(RDate.getNowDate());

        } else {
            div.getTxtTaishoYM().setDisplayNone(false);
            div.getTxtTaishoKikanKaishi().setDisplayNone(false);
            div.getTxtTaishoKikanShuryo().setDisplayNone(false);
            div.getLblTaishoKikan().setDisplayNone(false);
            div.getTxtKijunYMD().setDisplayNone(true);
            div.getTxtKazeiHanteiToKijunDate().setDisplayNone(false);

        }
    }

    /**
     * 「対象年度」の変更」の処理です。
     */
    public void taishoYM_onChange() {
        if (div.getRadTaishoKikanShitei().getSelectedKey().equals(対象年度)) {
            HomonKaigoRiyoshaFutangakuGengakuNinteishaList homokaigoriyosha
                    = new HomonKaigoRiyoshaFutangakuGengakuNinteishaList();
            FlexibleYear 年度 = new FlexibleYear(div.getTxtTaishoYM().getValue().toString().substring(NO_0, NO_4));
            Range<FlexibleDate> range = homokaigoriyosha.estimate対象期間(年度);
            div.getTxtTaishoKikanKaishi().setValue(range.getFrom());
            div.getTxtTaishoKikanShuryo().setValue(range.getTo());
        }
    }

    /**
     * 法別区分,受給者区分,世帯非課税等の表示と非表示を設定します。
     *
     */
    public void set表示と非表示() {
        div.getRadJukyushaKubun().setDisplayNone(false);
        div.getChkShoriTaisho().setDisplayNone(false);
        div.getDdlHobetsuKubun().setDisplayNone(true);
    }
}
