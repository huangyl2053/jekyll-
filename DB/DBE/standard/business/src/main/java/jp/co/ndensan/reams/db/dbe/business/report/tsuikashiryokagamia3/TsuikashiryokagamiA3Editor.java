/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tsuikashiryokagamia3;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.tsuikashiryokagami.TsuikashiryokagamiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tsuikashiryokagamia3.TsuikashiryokagamiA3ReportSource;

/**
 * 追加資料鑑のEditorです。
 *
 * @reamsid_L DBE-0150-180 wangrenze
 */
public class TsuikashiryokagamiA3Editor implements ITsuikashiryokagamiA3Editor {

    private final TsuikashiryokagamiEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link TsuikashiryokagamiEntity}
     */
    protected TsuikashiryokagamiA3Editor(TsuikashiryokagamiEntity item) {
        this.item = item;
    }

    @Override
    public TsuikashiryokagamiA3ReportSource edit(TsuikashiryokagamiA3ReportSource source) {
        source.shinsakaiNo = item.get審査会開催番号();
        source.tsuchibun1 = item.get通知文1();
        source.shinsainName1 = item.get審査員1();
        source.shinsainName2 = item.get審査員2();
        source.shinsainName3 = item.get審査員3();
        source.shinsainName4 = item.get審査員4();
        source.shinsainName5 = item.get審査員5();
        source.shinsainName6 = item.get審査員6();
        source.shinsainName7 = item.get審査員7();
        source.shinsainName8 = item.get審査員8();
        source.shinsakaiKaisaiYMD = item.get審査会開催年月日();
        source.gogitaiNo = item.get合議体番号();
        source.shinsakaiTsuikasha = item.get追加審査対象者数();
        source.listTsuikaIchiran_1 = item.get審査会審査順();
        source.listTsuikaIchiran_2 = item.get保険者();
        source.listTsuikaIchiran_3 = item.get被保険者番号();
        source.listTsuikaIchiran_4 = item.get被保険者氏名();
        source.listTsuikaIchiran_5 = item.get性別();
        source.listTsuikaIchiran_6 = item.get年齢();
        source.listTsuikaIchiran_7 = item.get申請日();
        source.listTsuikaIchiran_8 = item.get申請区分();
        source.listTsuikaIchiran_9 = item.get前回一次();
        source.listTsuikaIchiran_10 = item.get前回二次();
        source.listTsuikaIchiran_11 = item.get前回期間();
        source.listTsuikaIchiran_12 = item.get寝たきり度();
        source.listTsuikaIchiran_13 = item.get認知度();
        source.listTsuikaIchiran_14 = item.get基準時間();
        source.listTsuikaIchiran_15 = item.get一次判定();
        source.listTsuikaIchiran_16 = item.get警告();
        source.listTsuikaIchiran_17 = item.get審査結果();
        source.listTsuikaIchiran_18 = item.get期間();
        return source;
    }

}
