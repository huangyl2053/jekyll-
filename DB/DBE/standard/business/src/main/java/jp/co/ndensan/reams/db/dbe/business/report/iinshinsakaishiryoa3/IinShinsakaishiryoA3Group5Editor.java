/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinshinsakaishiryoa3;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuSonotashiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinshinsakaishiryoa3.IinShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.Layouts;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * その他資料A3版Editorです。
 *
 * @reamsid_L DBE-0150-200 zhaoyao
 */
public class IinShinsakaishiryoA3Group5Editor implements IIinShinsakaishiryoA3Editor {

    private final JimuSonotashiryoBusiness business;
    private final int index;
    private static final int INT_4 = 4;

    /**
     * コンストラクタです。
     *
     * @param business {@link JimuSonotashiryoBusiness}
     * @param index index
     */
    protected IinShinsakaishiryoA3Group5Editor(JimuSonotashiryoBusiness business, int index) {
        this.business = business;
        this.index = index;
    }

    /**
     * その他資料（A3版）を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public IinShinsakaishiryoA3ReportSource edit(IinShinsakaishiryoA3ReportSource source) {
        source.seven_hokenshaNo = business.get保険者番号();
        source.seven_hihokenshaNo = business.get被保険者番号();
        source.seven_hihokenshaName = business.get名前();
        source.seven_shinseiGengo = get元号(business.get認定申請年月日());
        source.seven_shinseiYY = get年(business.get認定申請年月日());
        source.seven_shinseiMM = new RString(business.get認定申請年月日().getMonthValue());
        source.seven_shinseiDD = new RString(business.get認定申請年月日().getDayValue());
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        source.seven_sakuseiGengo = get元号(システム日付);
        source.seven_sakuseiYY = get年(システム日付);
        source.seven_sakuseiMM = new RString(システム日付.getMonthValue());
        source.seven_sakuseiDD = new RString(システム日付.getDayValue());
        source.seven_chosaGengo = get元号(business.get認定調査実施年月日());
        source.seven_chosaYY = get年(business.get認定調査実施年月日());
        source.seven_chosaMM = new RString(business.get認定調査実施年月日().getMonthValue());
        source.seven_chosaDD = new RString(business.get認定調査実施年月日().getDayValue());
        source.seven_shinsaGengo = get元号(business.get介護認定審査会開催年月日());
        source.seven_shinsaYY = get年(business.get介護認定審査会開催年月日());
        source.seven_shinsaMM = new RString(business.get介護認定審査会開催年月日().getMonthValue());
        source.seven_shinsaDD = new RString(business.get介護認定審査会開催年月日().getDayValue());
        source.seven_imgSonotashiryo1 = business.get左のその他資料イメージ(2 * index - 2);
        source.seven_imgSonotashiryo2 = business.get右のその他資料イメージ(2 * index - 1);
        source.layout = Layouts.五頁目;
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
