/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.sonotashiryoa3;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuSonotashiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.sonotashiryoa3.SonotashiryoA3ReportSource;
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
 * その他資料のEditorです。
 *
 * @reamsid_L DBE-0150-080 wangrenze
 */
public class SonotashiryoA3Editor implements ISonotashiryoA3Editor {

    private final JimuSonotashiryoBusiness business;
    private static final int INT_4 = 4;

    /**
     * コンストラクタです。
     *
     * @param business {@link JimuSonotashiryoBusiness}
     */
    protected SonotashiryoA3Editor(JimuSonotashiryoBusiness business) {
        this.business = business;
    }

    /**
     * その他資料を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public SonotashiryoA3ReportSource edit(SonotashiryoA3ReportSource source) {
        source.hokenshaNo = business.get保険者番号();
        source.hihokenshaNo = business.get被保険者番号();
        source.hihokenshaName = business.get名前();
        source.shinseiGengo = get元号(business.get認定申請年月日());
        source.shinseiYY = get年(business.get認定申請年月日());
        source.shinseiMM = new RString(business.get認定申請年月日().getMonthValue());
        source.shinseiDD = new RString(business.get認定申請年月日().getDayValue());
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        source.sakuseiGengo = get元号(システム日付);
        source.sakuseiYY = get年(システム日付);
        source.sakuseiMM = new RString(システム日付.getMonthValue());
        source.sakuseiDD = new RString(システム日付.getDayValue());
        source.chosaGengo = get元号(business.get認定調査実施年月日());
        source.chosaYY = get年(business.get認定調査実施年月日());
        source.chosaMM = new RString(business.get認定調査実施年月日().getMonthValue());
        source.chosaDD = new RString(business.get認定調査実施年月日().getDayValue());
        source.shinsaGengo = get元号(business.get介護認定審査会開催年月日());
        source.shinsaYY = get年(business.get介護認定審査会開催年月日());
        source.shinsaMM = new RString(business.get介護認定審査会開催年月日().getMonthValue());
        source.shinsaDD = new RString(business.get介護認定審査会開催年月日().getDayValue());
        source.imgSonotashiryo1 = business.get左のその他資料イメージ();
        source.imgSonotashiryo2 = business.get右のその他資料イメージ();

        source.shikibetuCode = ShikibetsuCode.EMPTY;

        if (!RString.isNullOrEmpty(business.get被保険者番号())) {
            source.hishokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                    business.get被保険者番号());
        }

        return source;
    }

    private RString get元号(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).substring(0, 2);
        }
        return RString.EMPTY;
    }

    private RString get年(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).substring(2, INT_4);
        }
        return RString.EMPTY;
    }

    private RString パターン12(FlexibleDate 年月日) {
        return 年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

}
