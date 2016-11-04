/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinshinsakaishiryoa3;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuTuikaSiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinshinsakaishiryoa3.IinShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.Layouts;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 追加資料鑑A3版Editorです。
 *
 * @reamsid_L DBE-0150-200 zhaoyao
 */
public class IinShinsakaishiryoA3Group6Editor implements IIinShinsakaishiryoA3Editor {

    private final JimuTuikaSiryoBusiness business;
    private static final int INT_2 = 2;
    private static final int INT_4 = 4;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link JimuTuikaSiryoBusiness}
     */
    protected IinShinsakaishiryoA3Group6Editor(JimuTuikaSiryoBusiness business) {
        this.business = business;
    }

    @Override
    public IinShinsakaishiryoA3ReportSource edit(IinShinsakaishiryoA3ReportSource source) {
        source.eight_shinsakaiNo = business.get審査会開催番号().substring(
                business.get審査会開催番号().length() - INT_4, business.get審査会開催番号().length());
        source.eight_tsuchibun = business.get通知文1();
        source.eight_ShinsainName1 = business.get審査員1();
        source.eight_ShinsainName2 = business.get審査員2();
        source.eight_ShinsainName3 = business.get審査員3();
        source.eight_ShinsainName4 = business.get審査員4();
        source.eight_ShinsainName5 = business.get審査員5();
        source.eight_ShinsainName6 = business.get審査員6();
        source.eight_ShinsainName7 = business.get審査員7();
        source.eight_ShinsainName8 = business.get審査員8();
        source.eight_shinsakaiKaisaiYMD = business.get審査会開催年月日();
        source.eight_gogitaiNo = business.get合議体番号();
        source.eight_shinsakaiTsuikasha = business.get追加審査対象者数();
        source.eight_listShinsei_1 = business.get審査会審査順().padZeroToLeft(INT_2);
        source.eight_listShinsei_2 = business.get保険者();
        source.eight_listShinsei_3 = business.get被保険者番号();
        source.eight_listShinsei_4 = business.get被保険者氏名();
        source.eight_listShinsei_5 = business.get性別();
        source.eight_listShinsei_6 = business.get年齢();
        source.eight_listShinsei_7 = business.get前回二次();
        source.eight_listShinsei_8 = business.get前回期間();
        source.eight_listShinsei_9 = business.get一次判定();
        source.eight_listShinsei_10 = RString.EMPTY;
        source.eight_listShinsei_11 = RString.EMPTY;
        source.eight_listZenkaiｙukokikan_1 = business.get前回期間_下();
        source.eight_listYukokikan_1 = RString.EMPTY;
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (!RString.isNullOrEmpty(business.get申請書管理番号())) {
            source.shinseishoKanriNo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                    business.get申請書管理番号());
        }
        source.layout = Layouts.六頁目;
        return source;
    }
}
