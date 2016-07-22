/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa3;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa3.ShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 介護認定審査対象者一覧表A3のEditorクラスです。
 *
 * @reamsid_L DBE-0150-230 lishengli
 */
public class ShinsakaishiryoA3Editor implements IShinsakaishiryoA3Editor {

    private static final int INT_4 = 4;
    private static final int INT_25 = 25;
    private final JimuShinsakaishiryoBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link JimuShinsakaishiryoBusiness}
     */
    protected ShinsakaishiryoA3Editor(JimuShinsakaishiryoBusiness business) {
        this.business = business;
    }

    /**
     *
     * @param source 事務局用介護認定審査対象者一覧表のReportSourceクラス
     * @return ShinsakaishiryoA3ReportSource 事務局用介護認定審査対象者一覧表のReportSourceクラス
     */
    @Override
    public ShinsakaishiryoA3ReportSource edit(ShinsakaishiryoA3ReportSource source) {
        return editItem(source);
    }

    private ShinsakaishiryoA3ReportSource editItem(ShinsakaishiryoA3ReportSource source) {
        source.shinsakaiNo = get審査会番号(business.get審査会番号());
        source.shinsakaiKaisaiYMD = business.get審査会開催年月日();
        source.gogitaiNo = RStringUtil.convert半角to全角(business.get合議体番号());
        source.listShinsainName_1 = business.get審査員一覧();
        source.shinsaTaishoshaCount = RStringUtil.convert半角to全角(business.get審査対象者数());
        int no = business.getNo();
        if (INT_25 <= no) {
            source.listShinsei2_1 = business.get審査会審査順();
            source.listShinsei2_2 = business.get保険者();
            source.listShinsei2_3 = business.get被保険者();
            source.listShinsei2_4 = business.get氏名();
            source.listShinsei2_5 = business.get性別();
            source.listShinsei2_6 = business.get年齢();
            source.listShinsei2_7 = business.get前回二次();
            source.listShinsei2_8 = business.get前回期間();
            source.listShinsei2_9 = business.get一次判定();
            source.listShinsei2_10 = RString.EMPTY;
            source.listShinsei2_11 = RString.EMPTY;
            source.listZenkaiｙukokikan2_1 = get二時判定認定有効年月日();
            source.listYukokikan2_1 = RString.EMPTY;
        } else {
            source.listShinsei1_1 = business.get審査会審査順();
            source.listShinsei1_2 = business.get保険者();
            source.listShinsei1_3 = business.get被保険者();
            source.listShinsei1_4 = business.get氏名();
            source.listShinsei1_5 = business.get性別();
            source.listShinsei1_6 = business.get年齢();
            source.listShinsei1_7 = business.get前回二次();
            source.listShinsei1_8 = business.get前回期間();
            source.listShinsei1_9 = business.get一次判定();
            source.listShinsei1_10 = RString.EMPTY;
            source.listShinsei1_11 = RString.EMPTY;
            source.listZenkaiｙukokikan1_1 = get二時判定認定有効年月日();
            source.listYukokikan1_1 = RString.EMPTY;
        }
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (business.get申請書管理番号() == null) {
            source.shinseishoKanriNo = null;
        } else {
            source.shinseishoKanriNo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), business.get申請書管理番号().getColumnValue());
        }
        return source;
    }

    private RString get審査会番号(RString 審査会番号) {
        if (!RString.isNullOrEmpty(審査会番号)) {
            if (審査会番号.length() <= INT_4) {
                return 審査会番号;
            } else {
                return 審査会番号.substring(審査会番号.length() - INT_4);
            }
        }
        return RString.EMPTY;
    }

    private RString get二時判定認定有効年月日() {
        RStringBuilder 効開始年月日 = new RStringBuilder();
        効開始年月日.append(getパターン13(business.get二時判定認定有効開始年月日()));
        if (business.get二時判定認定有効開始年月日() != null && !business.get二時判定認定有効開始年月日().isEmpty()) {
            効開始年月日.append(new RString("～"));
        }
        効開始年月日.append(business.get二時判定認定有効開始年月日());
        return 効開始年月日.toRString();
    }

    private RString getパターン13(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return 年月日.wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

}
