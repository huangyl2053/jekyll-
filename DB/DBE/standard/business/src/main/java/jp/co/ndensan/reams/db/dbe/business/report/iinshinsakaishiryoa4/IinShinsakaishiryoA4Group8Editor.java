/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinshinsakaishiryoa4;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuTuikaSiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.iinshinsakaishiryoa4.IinShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.Layouts;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 追加資料鑑A4版Editorです。
 *
 * @reamsid_L DBE-0150-200 lishengli
 */
public class IinShinsakaishiryoA4Group8Editor implements IIinShinsakaishiryoA4Editor {

    private final JimuTuikaSiryoBusiness business;
    private static final int INT_2 = 2;
    private static final int INT_4 = 4;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link JimuTuikaSiryoBusiness}
     */
    protected IinShinsakaishiryoA4Group8Editor(JimuTuikaSiryoBusiness business) {
        this.business = business;
    }

    @Override
    public IinShinsakaishiryoA4ReportSource edit(IinShinsakaishiryoA4ReportSource source) {
        source.seven_shinsakaiNo = business.get審査会開催番号().substring(
                business.get審査会開催番号().length() - INT_4, business.get審査会開催番号().length());
        source.seven_tsuchibun = business.get通知文1();
        source.seven_shinsainName1 = business.get審査員1();
        source.seven_shinsainName2 = business.get審査員2();
        source.seven_shinsainName3 = business.get審査員3();
        source.seven_shinsainName4 = business.get審査員4();
        source.seven_shinsainName5 = business.get審査員5();
        source.seven_shinsainName6 = business.get審査員6();
        source.seven_shinsainName7 = business.get審査員7();
        source.seven_shinsainName8 = business.get審査員8();
        source.seven_shinsakaiKaisaiYMD = business.get審査会開催年月日();
        source.seven_gogitaiNo = business.get合議体番号();
        source.seven_shinsakaiTsuikasha = business.get追加審査対象者数();
        source.seven_listShinsei_1 = business.get審査会審査順().padZeroToLeft(INT_2);
        source.seven_listShinsei_2 = business.get保険者();
        source.seven_listShinsei_3 = business.get被保険者番号();
        source.seven_listShinsei_4 = business.get被保険者氏名();
        source.seven_listShinsei_5 = business.get性別();
        source.seven_listShinsei_6 = business.get年齢();
        source.seven_listShinsei_7 = business.get前回二次();
        source.seven_listShinsei_8 = business.get前回期間();
        source.seven_listShinsei_9 = business.get一次判定();
        source.seven_listShinsei_10 = business.get警告();
        source.seven_listShinsei_11 = business.get基準時間();
        source.seven_listShinsei_12 = RString.EMPTY;
        source.seven_listShinsei_13 = RString.EMPTY;
        source.layout = Layouts.空白ページ;
        return source;
    }
}
