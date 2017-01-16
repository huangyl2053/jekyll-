/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimushinsakaishiryoa3;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaiWariateJohoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakaishiryosakusei.JimuShinsakaiShiryoA3Layouts;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimushinsakaishiryoa3.JimuShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 主治医意見書A3版Editorです。
 *
 * @reamsid_L DBE-0150-190 lishengli
 */
public class JimuShinsakaishiryoA3Group4Editor implements IJimuShinsakaishiryoA3Editor {

    private static final int INT_4 = 4;
    private final JimuShinsakaiWariateJohoBusiness business;
    private final RString reportId;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link JimuShinsakaiWariateJohoBusiness}
     * @param reportId 帳票ＩＤ
     */
    protected JimuShinsakaishiryoA3Group4Editor(JimuShinsakaiWariateJohoBusiness business, RString reportId) {
        this.business = business;
        this.reportId = reportId;
    }

    @Override
    public JimuShinsakaishiryoA3ReportSource edit(JimuShinsakaishiryoA3ReportSource source) {
        return editSource(source);
    }

    private JimuShinsakaishiryoA3ReportSource editSource(JimuShinsakaishiryoA3ReportSource source) {
        source.hokenshaNo = business.get保険者番号();
        source.hihokenshaNo = business.get被保険者番号();
        source.hihokenshaName = business.get名前();
        source.shinseiGengo = get元号(business.get今回認定申請年月日());
        source.shinseiYY = get年(business.get今回認定申請年月日());
        source.shinseiMM = get月(business.get今回認定申請年月日());
        source.shinseiDD = get日(business.get今回認定申請年月日());
        source.sakuseiGengo = get元号(business.get審査会資料作成年月日());
        source.sakuseiYY = get年(business.get審査会資料作成年月日());
        source.sakuseiMM = get月(business.get審査会資料作成年月日());
        source.sakuseiDD = get日(business.get審査会資料作成年月日());
        source.chosaGengo = get元号(business.get今回認定調査実施年月日());
        source.chosaYY = get年(business.get今回認定調査実施年月日());
        source.chosaMM = get月(business.get今回認定調査実施年月日());
        source.chosaDD = get日(business.get今回認定調査実施年月日());
        source.shinsaGengo = get元号(business.get今回認定審査年月日());
        source.shinsaYY = get年(business.get今回認定審査年月日());
        source.shinsaMM = get月(business.get今回認定審査年月日());
        source.shinsaDD = get日(business.get今回認定審査年月日());
        source.imgIkensho1 = business.get左の主治医意見書イメージ();
        source.imgIkensho2 = business.get右の主治医意見書イメージ();
        source.layout = JimuShinsakaiShiryoA3Layouts.事務局用主治医意見書.index();
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

    private RString get月(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return new RString(年月日.getMonthValue());
        }
        return RString.EMPTY;
    }

    private RString get日(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return new RString(年月日.getDayValue());
        }
        return RString.EMPTY;
    }

    private RString パターン12(FlexibleDate 年月日) {
        return 年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }
}
