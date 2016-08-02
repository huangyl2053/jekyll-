/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoa4;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaiWariateJohoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho1a4.ShujiiikenshoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FillTypeFormatted;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 事務局用主治医意見書A3のEditorクラスです。
 *
 * @reamsid_L DBE-0150-090 wangrenze
 */
public class ShujiiikenshoA3Editor implements IShujiiikenshoA3Editor {

    private final JimuShinsakaiWariateJohoBusiness business;
    private static final RString 年 = new RString("年");

    /**
     * インスタンスを生成します。
     *
     * @param business {@link JimuShinsakaiWariateJohoBusiness}
     */
    protected ShujiiikenshoA3Editor(JimuShinsakaiWariateJohoBusiness business) {
        this.business = business;
    }

    /**
     * 事務局用主治医意見書を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public ShujiiikenshoA3ReportSource edit(ShujiiikenshoA3ReportSource source) {

        source.hokenshaNo = business.get保険者番号();
        source.hihokenshaNo = business.get被保険者番号();
        source.hihokenshaName = business.get名前();
        source.shinseiGengo = get元号(business.get今回認定申請年月日());
        source.shinseiYY = get年(business.get今回認定申請年月日()).replace(get元号(business.get今回認定申請年月日()), RString.EMPTY)
                .replace(年, RString.EMPTY);
        source.shinseiMM = new RString(business.get今回認定申請年月日().getMonthValue());
        source.shinseiDD = new RString(business.get今回認定申請年月日().getDayValue());
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        source.sakuseiGengo = get元号(システム日付);
        source.sakuseiYY = get年(システム日付).replace(get元号(システム日付), RString.EMPTY)
                .replace(年, RString.EMPTY);
        source.sakuseiMM = new RString(システム日付.getMonthValue());
        source.sakuseiDD = new RString(システム日付.getDayValue());
        source.chosaGengo = get元号(business.get今回認定調査実施年月日());
        source.chosaYY = get年(business.get今回認定調査実施年月日()).replace(get元号(business.get今回認定調査実施年月日()),
                RString.EMPTY).replace(年, RString.EMPTY);
        source.chosaMM = new RString(business.get今回認定調査実施年月日().getMonthValue());
        source.chosaDD = new RString(business.get今回認定調査実施年月日().getDayValue());
        source.shinsaGengo = get元号(business.get今回認定審査年月日());
        source.shinsaYY = get年(business.get今回認定審査年月日()).replace(get元号(business.get今回認定審査年月日()),
                RString.EMPTY).replace(年, RString.EMPTY);
        source.shinsaMM = new RString(business.get今回認定審査年月日().getMonthValue());
        source.shinsaDD = new RString(business.get今回認定審査年月日().getDayValue());
        source.imgIkensho1 = business.get主治医意見書イメージ１();
        source.imgIkensho2 = business.get主治医意見書イメージ２();

        source.shikibetuCode = ShikibetsuCode.EMPTY;

        if (!RString.isNullOrEmpty(business.get被保険者番号())) {
            source.hishokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                    business.get被保険者番号());
        }
        return source;
    }

    private RString get元号(FlexibleDate 年月日) {

        return パターン12(年月日).getEra();
    }

    private RString get年(FlexibleDate 年月日) {

        return パターン12(年月日).getYear();
    }

    private FillTypeFormatted パターン12(FlexibleDate 年月日) {

        return 年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK);
    }
}
