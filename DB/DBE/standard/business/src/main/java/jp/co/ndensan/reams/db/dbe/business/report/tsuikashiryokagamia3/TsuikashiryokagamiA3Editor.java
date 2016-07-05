/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tsuikashiryokagamia3;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuTuikaSiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tsuikashiryokagamia3.TsuikashiryokagamiA3ReportSource;

/**
 * 追加資料鑑のEditorです。
 *
 * @reamsid_L DBE-0150-180 wangrenze
 */
public class TsuikashiryokagamiA3Editor implements ITsuikashiryokagamiA3Editor {

    private final JimuTuikaSiryoBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link JimuTuikaSiryoBusiness}
     */
    protected TsuikashiryokagamiA3Editor(JimuTuikaSiryoBusiness business) {
        this.business = business;
    }

    @Override
    public TsuikashiryokagamiA3ReportSource edit(TsuikashiryokagamiA3ReportSource source) {
        source.shinsakaiNo = business.get審査会開催番号();
        source.tsuchibun1 = business.get通知文1();
        source.shinsainName1 = business.get審査員1();
        source.shinsainName2 = business.get審査員2();
        source.shinsainName3 = business.get審査員3();
        source.shinsainName4 = business.get審査員4();
        source.shinsainName5 = business.get審査員5();
        source.shinsainName6 = business.get審査員6();
        source.shinsainName7 = business.get審査員7();
        source.shinsainName8 = business.get審査員8();
        source.shinsakaiKaisaiYMD = business.get審査会開催年月日();
        source.gogitaiNo = business.get合議体番号();
        source.shinsakaiTsuikasha = business.get追加審査対象者数();
        source.listTsuikaIchiran_1 = business.get審査会審査順();
        source.listTsuikaIchiran_2 = business.get保険者();
        source.listTsuikaIchiran_3 = business.get被保険者番号();
        source.listTsuikaIchiran_4 = business.get被保険者氏名();
        source.listTsuikaIchiran_5 = business.get性別();
        source.listTsuikaIchiran_6 = business.get年齢();
        source.listTsuikaIchiran_7 = business.get申請日();
        source.listTsuikaIchiran_8 = business.get申請区分();
        source.listTsuikaIchiran_9 = business.get前回一次();
        source.listTsuikaIchiran_10 = business.get前回二次();
        source.listTsuikaIchiran_11 = business.get前回期間();
        source.listTsuikaIchiran_12 = business.get寝たきり度();
        source.listTsuikaIchiran_13 = business.get認知度();
        source.listTsuikaIchiran_14 = business.get基準時間();
        source.listTsuikaIchiran_15 = business.get一次判定();
        source.listTsuikaIchiran_16 = business.get警告();
        source.listTsuikaIchiran_17 = business.get審査結果();
        source.listTsuikaIchiran_18 = business.get期間();
        return source;
    }

}
