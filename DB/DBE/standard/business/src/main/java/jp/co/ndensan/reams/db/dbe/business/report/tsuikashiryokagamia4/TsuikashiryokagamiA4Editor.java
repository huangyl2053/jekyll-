/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tsuikashiryokagamia4;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuTuikaSiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tsuikashiryokagamia4.TsuikashiryokagamiA4ReportSource;

/**
 * 追加資料鑑のEditorです。
 *
 * @reamsid_L DBE-0150-180 wangrenze
 */
public class TsuikashiryokagamiA4Editor implements ITsuikashiryokagamiA4Editor {

    private final JimuTuikaSiryoBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link JimuTuikaSiryoBusiness}
     */
    protected TsuikashiryokagamiA4Editor(JimuTuikaSiryoBusiness business) {
        this.business = business;
    }

    @Override
    public TsuikashiryokagamiA4ReportSource edit(TsuikashiryokagamiA4ReportSource source) {
        source.shinsakaiNo = business.get審査会開催番号();
        source.tsuchibun1 = business.get通知文1();
        source.tsuchibun2 = business.get通知文2();
        source.tsuchibun3 = business.get通知文3();
        source.tsuchibun4 = business.get通知文4();
        source.tsuchibun5 = business.get通知文5();
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
        source.listNo_1 = business.get審査会審査順();
        source.listNo_2 = business.get保険者();
        source.listhihokenshaNo_1 = business.get被保険者番号();
        source.listhihokenshaName_1 = business.get被保険者氏名();
        source.listSeibetsu_1 = business.get性別();
        source.listSeibetsu_2 = business.get年齢();
        source.listShinseiYMD_1 = business.get申請日();
        source.listShinseiYMD_2 = business.get前回一次();
        source.listShinseiKubun_1 = business.get申請区分();
        source.listShinseiKubun_2 = business.get前回二次();
        source.listZenkaiYukokikan_1 = business.get前回期間();
        source.listZenkaiYukokikan_2 = business.get寝たきり度();
        source.listZenkaiYukokikan_3 = business.get認知度();
        source.listZenkaiYukokikan_4 = business.get基準時間();
        source.listZenkaiYukokikan_5 = business.get一次判定();
        source.listZenkaiYukokikan_6 = business.get警告();
        source.listZenkaiYukokikan_7 = business.get審査結果();
        source.listZenkaiYukokikan_8 = business.get期間();
        return source;
    }
}
