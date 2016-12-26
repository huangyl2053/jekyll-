/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinshinsakaishiryoa4;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuTuikaSiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.iinshinsakaishiryoa4.IinShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 追加資料鑑（A4版）のEditorです。
 *
 * @author n8449 haoyanchun
 */
public class IinShinsakaishiryoA4Group8Editor implements IIinShinsakaishiryoA4Editor {

    private final JimuTuikaSiryoBusiness business;
    private static final int INT_0 = 0;
    private static final int INT_2 = 2;
    private static final int INT_4 = 4;
    private static final int INT_6 = 6;
    private static final int INT_8 = 8;
    private static final int INT_10 = 10;
    private static final int INT_12 = 12;
    private static final int INT_16 = 16;

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
        source.shinsakaiNo = business.get審査会開催番号().substring(
                business.get審査会開催番号().length() - INT_4, business.get審査会開催番号().length());
        source.tsuchibun = business.get通知文1();
        source.shinsainName1 = business.get審査員1();
        source.shinsainName2 = business.get審査員2();
        source.shinsainName3 = business.get審査員3();
        source.shinsainName4 = business.get審査員4();
        source.shinsainName5 = business.get審査員5();
        source.shinsainName6 = business.get審査員6();
        source.shinsainName7 = business.get審査員7();
        source.shinsainName8 = business.get審査員8();
        source.shinsakaiKaisaiYMD = 日付項目のフォーマット(business.get審査会開催年月日());
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
        source.listShinsei_10 = business.get警告();
        source.listShinsei_11 = business.get基準時間();
        source.listShinsei_12 = RString.EMPTY;
        source.listShinsei_13 = RString.EMPTY;
        source.shikibetuCode = new ShikibetsuCode(business.get識別コード());
        if (!RString.isNullOrEmpty(business.get申請書管理番号())) {
            source.hishokenshaNo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                    business.get申請書管理番号());
        }
        source.layout = INT_16;
        return source;
    }

    private RString 日付項目のフォーマット(RString 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        StringBuilder 年月日Buder = new StringBuilder();
        年月日Buder.append(年月日.substring(INT_0, INT_4));
        年月日Buder.append(年月日.substring(INT_6, INT_8));
        年月日Buder.append(年月日.substring(INT_10, INT_12));
        return new FlexibleDate(new RString(年月日Buder.toString())).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

}
