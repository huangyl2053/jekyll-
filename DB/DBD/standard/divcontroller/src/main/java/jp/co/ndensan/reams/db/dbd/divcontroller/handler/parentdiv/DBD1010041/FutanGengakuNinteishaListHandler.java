/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010041;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1010041.FutanGendogakuNinteiNinteishaIchiran;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010041.FutanGengakuNinteishaListDiv;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 負担限度額認定者リスト画面のHandlerです。
 *
 * @reamsid_L DBD-3960-010 xuejm
 */
public class FutanGengakuNinteishaListHandler {

    private final FutanGengakuNinteishaListDiv div;
    private static final RString 該当者リスト = new RString("gaitosha");
    private static final RString 基準日 = new RString("kijunYMD");
    private static final RString 対象年度 = new RString("taishoNendo");
    private static final int NO_0 = 0;
    private static final int NO_4 = 4;

    /**
     * 負担限度額認定者リストコンストラクタです。
     *
     * @param div FutanGengakuNinteishaListDiv
     */
    public FutanGengakuNinteishaListHandler(FutanGengakuNinteishaListDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     */
    public void onLoad() {
        div.getCcdChohyoShuturyokujun().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200001.getReportId());
        div.getTxtTaishoYM().setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
        FutanGendogakuNinteiNinteishaIchiran futangendokuninichian = new FutanGendogakuNinteiNinteishaIchiran();
        Range<FlexibleDate> range = futangendokuninichian.estimate対象期間(
                new FlexibleYear(div.getTxtTaishoYM().getValue().toString().substring(NO_0, NO_4)));
        div.getTxtTaishoKikanKaishi().setValue(range.getFrom());
        div.getTxtTaishoKikanShuryo().setValue(range.getTo());
        div.getTxtShotokuNendo().setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
        div.getTxtKijunYMD().setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
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
            div.getTxtTaishoYM().setDisplayNone(false);
            div.getTxtTaishoKikanKaishi().setDisplayNone(false);
            div.getTxtTaishoKikanShuryo().setDisplayNone(false);
            div.getLblTaishoKikan().setDisplayNone(false);
            div.getTxtKazeiHanteiToKijunDate().setDisplayNone(false);
            div.getRadTaishoKikanShitei().setDisplayNone(false);
            div.getRadJukyushaKubun().setDisplayNone(true);
            div.getDdlRiyoshaFutanDankai().setDisplayNone(true);
            div.getTxtKijunYMD().setDisplayNone(true);
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
            div.getTxtKazeiHanteiToKijunDate().setDisplayNone(true);
            div.getTxtKijunYMD().setDisplayNone(false);
        } else {
            div.getTxtTaishoYM().setDisplayNone(false);
            div.getTxtTaishoKikanKaishi().setDisplayNone(false);
            div.getTxtTaishoKikanShuryo().setDisplayNone(false);
            div.getLblTaishoKikan().setDisplayNone(false);
            div.getTxtKazeiHanteiToKijunDate().setDisplayNone(false);
            div.getTxtKijunYMD().setDisplayNone(true);
        }
    }

    /**
     * 「対象年度」の変更」の処理です。
     */
    public void taishoYM_onChange() {
        if (div.getRadTaishoKikanShitei().getSelectedKey().equals(対象年度)) {
            FutanGendogakuNinteiNinteishaIchiran futangendokuninichian = new FutanGendogakuNinteiNinteishaIchiran();
            FlexibleYear taishonendo = new FlexibleYear(div.getTxtTaishoYM().getValue().toString().substring(NO_0, NO_4));
            Range<FlexibleDate> range = futangendokuninichian.estimate対象期間(taishonendo);
            div.getTxtTaishoKikanKaishi().setValue(range.getFrom());
            div.getTxtTaishoKikanShuryo().setValue(range.getTo());
        }
    }

    /**
     * 対象期間指定,対象年度,課税判定等基準日,基準日,受給者区分,利用者負担段階の表示と非表示を設定します。
     *
     */
    public void set表示と非表示() {
        div.getTxtTaishoYM().setDisplayNone(true);
        div.getTxtTaishoKikanKaishi().setDisplayNone(true);
        div.getTxtTaishoKikanShuryo().setDisplayNone(true);
        div.getLblTaishoKikan().setDisplayNone(true);
        div.getTxtKazeiHanteiToKijunDate().setDisplayNone(true);
        div.getRadTaishoKikanShitei().setDisplayNone(true);
        div.getRadJukyushaKubun().setDisplayNone(false);
        div.getDdlRiyoshaFutanDankai().setDisplayNone(false);
        div.getTxtKijunYMD().setDisplayNone(false);
    }
}
