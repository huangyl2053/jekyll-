/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimushinsakaishiryoa3;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuTuikaSiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimushinsakaishiryoa3.JimuShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.Layouts;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 追加資料鑑A3版Editorです。
 *
 * @reamsid_L DBE-0150-200 lishengli
 */
public class JimuShinsakaishiryoA3Group6Editor implements IJimuShinsakaishiryoA3Editor {

    private final JimuTuikaSiryoBusiness business;
    private static final int INT_2 = 2;
    private static final int INT_4 = 4;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link JimuTuikaSiryoBusiness}
     */
    protected JimuShinsakaishiryoA3Group6Editor(JimuTuikaSiryoBusiness business) {
        this.business = business;
    }

    @Override
    public JimuShinsakaishiryoA3ReportSource edit(JimuShinsakaishiryoA3ReportSource source) {
        source.five_shinsakaiNo = business.get審査会開催番号().substring(
                business.get審査会開催番号().length() - INT_4, business.get審査会開催番号().length());
        source.five_tsuchibun = business.get通知文1();
        source.five_shinsainName1 = business.get審査員1();
        source.five_shinsainName2 = business.get審査員2();
        source.five_shinsainName3 = business.get審査員3();
        source.five_shinsainName4 = business.get審査員4();
        source.five_shinsainName5 = business.get審査員5();
        source.five_shinsainName6 = business.get審査員6();
        source.five_shinsainName7 = business.get審査員7();
        source.five_shinsainName8 = business.get審査員8();
        source.five_shinsakaiKaisaiYMD = business.get審査会開催年月日();
        source.five_gogitaiNo = business.get合議体番号();
        source.five_shinsakaiTsuikasha = business.get追加審査対象者数();
        source.five_listShinsei_1 = business.get審査会審査順().padZeroToLeft(INT_2);
        source.five_listShinsei_2 = business.get保険者();
        source.five_listShinsei_3 = business.get被保険者番号();
        source.five_listShinsei_4 = business.get被保険者氏名();
        source.five_listShinsei_5 = business.get性別();
        source.five_listShinsei_6 = business.get年齢();
        source.five_listShinsei_7 = business.get前回二次();
        source.five_listShinsei_8 = business.get前回期間();
        source.five_listShinsei_9 = business.get一次判定();
        source.five_listShinsei_10 = RString.EMPTY;
        source.five_listShinsei_11 = RString.EMPTY;
        source.five_listZenkaiｙukokikan_1 = business.get前回期間_下();
        source.five_listYukokikan_1 = RString.EMPTY;
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (!RString.isNullOrEmpty(business.get申請書管理番号())) {
            source.shinseishoKanriNo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                    business.get申請書管理番号());
        }
        source.layout = Layouts.六頁目;
        return source;
    }
}
