/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tsuikashiryokagamia4;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.tsuikashiryokagami.TsuikashiryokagamiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tsuikashiryokagamia4.TsuikashiryokagamiA4ReportSource;

/**
 * 追加資料鑑のEditorです。
 *
 * @reamsid_L DBE-0150-180 wangrenze
 */
public class TsuikashiryokagamiA4Editor implements ITsuikashiryokagamiA4Editor {

    private final TsuikashiryokagamiEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link TsuikashiryokagamiEntity}
     */
    protected TsuikashiryokagamiA4Editor(TsuikashiryokagamiEntity item) {
        this.item = item;
    }

    @Override
    public TsuikashiryokagamiA4ReportSource edit(TsuikashiryokagamiA4ReportSource source) {
        source.shinsakaiNo = item.get審査会開催番号();
        source.tsuchibun1 = item.get通知文1();
        source.tsuchibun2 = item.get通知文2();
        source.tsuchibun3 = item.get通知文3();
        source.tsuchibun4 = item.get通知文4();
        source.tsuchibun5 = item.get通知文5();
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
        source.listNo_1 = item.get審査会審査順();
        source.listNo_2 = item.get保険者();
        source.listhihokenshaNo_1 = item.get被保険者番号();
        source.listhihokenshaName_1 = item.get被保険者氏名();
        source.listSeibetsu_1 = item.get性別();
        source.listSeibetsu_2 = item.get年齢();
        source.listShinseiYMD_1 = item.get申請日();
        source.listShinseiYMD_2 = item.get前回一次();
        source.listShinseiKubun_1 = item.get申請区分();
        source.listShinseiKubun_2 = item.get前回二次();
        source.listZenkaiYukokikan_1 = item.get前回期間();
        source.listZenkaiYukokikan_2 = item.get寝たきり度();
        source.listZenkaiYukokikan_3 = item.get認知度();
        source.listZenkaiYukokikan_4 = item.get基準時間();
        source.listZenkaiYukokikan_5 = item.get一次判定();
        source.listZenkaiYukokikan_6 = item.get警告();
        source.listZenkaiYukokikan_7 = item.get審査結果();
        source.listZenkaiYukokikan_8 = item.get期間();
        return source;
    }
}
