/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.sonotashiryoa3;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.sonotashiryo.SonotashiryoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.sonotashiryoa3.SonotashiryoA3ReportSource;
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
 * 事務局用その他資料のEditorです。
 *
 * @reamsid_L DBE-0150-080 wangrenze
 */
public class SonotashiryoA3Editor implements ISonotashiryoA3Editor {

    private final SonotashiryoEntity item;

    /**
     * コンストラクタです。
     *
     * @param item {@link SonotashiryoEntity}
     */
    protected SonotashiryoA3Editor(SonotashiryoEntity item) {
        this.item = item;
    }

    /**
     * 事務局用その他資料を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public SonotashiryoA3ReportSource edit(SonotashiryoA3ReportSource source) {
        source.hokenshaNo = item.get保険者番号();
        source.hihokenshaNo = item.get被保険者番号();
        source.hihokenshaName = item.get名前();
        source.shinseiGengo = get元号(item.get認定申請年月日());
        source.shinseiYY = get年(item.get認定申請年月日()).replace(get元号(item.get認定申請年月日()), RString.EMPTY)
                .replace(new RString("年"), RString.EMPTY);
        source.shinseiMM = new RString(item.get認定申請年月日().getMonthValue());
        source.shinseiDD = new RString(item.get認定申請年月日().getDayValue());
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        source.sakuseiGengo = get元号(システム日付);
        source.sakuseiYY = get年(システム日付).replace(get元号(システム日付), RString.EMPTY)
                .replace(new RString("年"), RString.EMPTY);
        source.sakuseiMM = new RString(システム日付.getMonthValue());
        source.sakuseiDD = new RString(システム日付.getDayValue());
        source.chosaGengo = get元号(item.get認定調査実施年月日());
        source.chosaYY = get年(item.get認定調査実施年月日()).replace(get元号(item.get認定調査実施年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.chosaMM = new RString(item.get認定調査実施年月日().getMonthValue());
        source.chosaDD = new RString(item.get認定調査実施年月日().getDayValue());
        source.shinsaGengo = get元号(item.get介護認定審査会開催年月日());
        source.shinsaYY = get年(item.get介護認定審査会開催年月日()).replace(get元号(item.get介護認定審査会開催年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.shinsaMM = new RString(item.get介護認定審査会開催年月日().getMonthValue());
        source.shinsaDD = new RString(item.get介護認定審査会開催年月日().getDayValue());
        source.imgSonotashiryo1 = item.get左のその他資料イメージ();
        source.imgSonotashiryo2 = item.get右のその他資料イメージ();

        source.shikibetuCode = ShikibetsuCode.EMPTY;

        if (!RString.isNullOrEmpty(item.get被保険者番号())) {
            source.hishokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                    item.get被保険者番号());
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
