/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tsuikashiryokagamia3;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuTuikaSiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tsuikashiryokagamia3.TsuikashiryokagamiA3ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 追加資料鑑（A3版）のEditorです。
 *
 * @reamsid_L DBE-0150-410 wangrenze
 */
public class TsuikashiryokagamiA3Editor implements ITsuikashiryokagamiA3Editor {

    private final JimuTuikaSiryoBusiness business;
    private static final int INT_2 = 2;

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
        source.tsuchibun = business.get通知文1();
        source.ShinsainName1 = business.get審査員1();
        source.ShinsainName2 = business.get審査員2();
        source.ShinsainName3 = business.get審査員3();
        source.ShinsainName4 = business.get審査員4();
        source.ShinsainName5 = business.get審査員5();
        source.ShinsainName6 = business.get審査員6();
        source.ShinsainName7 = business.get審査員7();
        source.ShinsainName8 = business.get審査員8();
        source.shinsakaiKaisaiYMD = business.get審査会開催年月日();
        source.gogitaiNo = business.get合議体番号();
        source.shinsakaiTsuikasha = business.get追加審査対象者数();
        source.listShinsei_1 = business.get審査会審査順().padZeroToLeft(INT_2);
        source.listShinsei_2 = business.get保険者();
        source.listShinsei_3 = business.get被保険者番号();
        source.listShinsei_4 = business.get被保険者氏名();
        source.listShinsei_5 = business.get性別();
        source.listShinsei_6 = business.get年齢();
        source.listShinsei_7 = business.get前回二次();
        source.listShinsei_8 = business.get前回期間();
        source.listShinsei_9 = business.get一次判定();
        source.listShinsei_10 = RString.EMPTY;
        source.listShinsei_11 = RString.EMPTY;
        source.listZenkaiｙukokikan_1 = business.get前回期間_下();
        source.listYukokikan_1 = RString.EMPTY;
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (!RString.isNullOrEmpty(business.get申請書管理番号())) {
            source.hishokenshaNo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                    business.get申請書管理番号());
        }
        return source;
    }

}
