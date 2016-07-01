/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.gaikyotokkitexta3;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.gaikyotokkitexta3.GaikyotokkiTextA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.gaikyotokkitexta3.GaikyotokkiTextA4ReportSource;
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
 * 事務局用概況特記のEditorです。
 *
 * @reamsid_L DBE-0150-070 wangrenze
 */
public class GaikyotokkiTextA4Editor implements IGaikyotokkiTextA4Editor {

    private final GaikyotokkiTextA4Entity item;

    /**
     * コンストラクタです。
     *
     * @param item {@link GaikyotokkiTextA4Entity}
     */
    protected GaikyotokkiTextA4Editor(GaikyotokkiTextA4Entity item) {
        this.item = item;
    }

    /**
     * 事務局用概況特記を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public GaikyotokkiTextA4ReportSource edit(GaikyotokkiTextA4ReportSource source) {
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
        source.gaikyotokkiImg = item.get概況特記Img();
        source.gaikyotokkiText = item.get概況特記Text();
        source.two_gaikyotokkiImg = item.get概況特記Img();
        source.two_hokenshaNo = item.get保険者番号();
        source.two_hihokenshaNo = item.get被保険者番号();
        source.two_hihokenshaName = item.get名前();
        source.two_shinseiGengo = get元号(item.get認定申請年月日());
        source.two_shinseiYY = get年(item.get認定申請年月日()).replace(get元号(item.get認定申請年月日()), RString.EMPTY)
                .replace(new RString("年"), RString.EMPTY);
        source.two_shinseiMM = new RString(item.get認定申請年月日().getMonthValue());
        source.two_shinseiDD = new RString(item.get認定申請年月日().getDayValue());
        source.two_sakuseiGengo = get元号(システム日付);
        source.two_sakuseiYY = get年(システム日付).replace(get元号(システム日付), RString.EMPTY)
                .replace(new RString("年"), RString.EMPTY);
        source.two_sakuseiMM = new RString(システム日付.getMonthValue());
        source.two_sakuseiDD = new RString(システム日付.getDayValue());
        source.two_chosaGengo = get元号(item.get認定調査実施年月日());
        source.two_chosaYY = get年(item.get認定調査実施年月日()).replace(get元号(item.get認定調査実施年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.two_chosaMM = new RString(item.get認定調査実施年月日().getMonthValue());
        source.two_chosaDD = new RString(item.get認定調査実施年月日().getDayValue());
        source.two_shinsaGengo = get元号(item.get介護認定審査会開催年月日());
        source.two_shinsaYY = get年(item.get介護認定審査会開催年月日()).replace(get元号(item.get介護認定審査会開催年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.two_shinsaMM = new RString(item.get介護認定審査会開催年月日().getMonthValue());
        source.two_shinsaDD = new RString(item.get介護認定審査会開催年月日().getDayValue());
        source.gaikyotokkiImg1 = item.get住宅改修Img();
        source.gaikyotokkiImg2 = item.get市町村特別給付のサービス種類名Img();
        source.gaikyotokkiImg3 = item.get介護保険給付外の在宅サービス種類名Img();
        source.gaikyotokkiImg4 = item.get調査対象者の主訴Img();
        source.gaikyotokkiImg5 = item.get調査対象者の家族状況立会者Img();
        source.gaikyotokkiImg6 = item.get調査対象者の居住環境Img();
        source.gaikyotokkiImg7 = item.getその他Img();
        source.tokkiText1 = item.get住宅改修Text();
        source.tokkiText2 = item.get市町村特別給付のサービス種類名Text();
        source.tokkiText3 = item.get介護保険給付外の在宅サービス種類名Text();
        source.tokkiText4 = item.get調査対象者の主訴Text();
        source.tokkiText5 = item.get調査対象者の家族状況立会者Text();
        source.tokkiText6 = item.get調査対象者の居住環境Text();
        source.tokkiText7 = item.getその他Text();
        source.three_hokenshaNo = item.get保険者番号();
        source.three_hihokenshaNo = item.get被保険者番号();
        source.three_hihokenshaName = item.get名前();
        source.three_shinseiGengo = get元号(item.get認定申請年月日());
        source.three_shinseiYY = get年(item.get認定申請年月日()).replace(get元号(item.get認定申請年月日()), RString.EMPTY)
                .replace(new RString("年"), RString.EMPTY);
        source.three_shinseiMM = new RString(item.get認定申請年月日().getMonthValue());
        source.three_shinseiDD = new RString(item.get認定申請年月日().getDayValue());
        source.three_sakuseiGengo = get元号(システム日付);
        source.three_sakuseiYY = get年(システム日付).replace(get元号(システム日付), RString.EMPTY)
                .replace(new RString("年"), RString.EMPTY);
        source.three_sakuseiMM = new RString(システム日付.getMonthValue());
        source.three_sakuseiDD = new RString(システム日付.getDayValue());
        source.three_chosaGengo = get元号(item.get認定調査実施年月日());
        source.three_chosaYY = get年(item.get認定調査実施年月日()).replace(get元号(item.get認定調査実施年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.three_chosaMM = new RString(item.get認定調査実施年月日().getMonthValue());
        source.three_chosaDD = new RString(item.get認定調査実施年月日().getDayValue());
        source.three_shinsaGengo = get元号(item.get介護認定審査会開催年月日());
        source.three_shinsaYY = get年(item.get介護認定審査会開催年月日()).replace(get元号(item.get介護認定審査会開催年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.three_shinsaMM = new RString(item.get介護認定審査会開催年月日().getMonthValue());
        source.three_shinsaDD = new RString(item.get介護認定審査会開催年月日().getDayValue());
        source.three_imgIkensho1 = item.get主治医意見書イメージ1();
        source.four_hokenshaNo = item.get保険者番号();
        source.four_hihokenshaNo = item.get被保険者番号();
        source.four_hihokenshaName = item.get名前();
        source.four_shinseiGengo = get元号(item.get認定申請年月日());
        source.four_shinseiYY = get年(item.get認定申請年月日()).replace(get元号(item.get認定申請年月日()), RString.EMPTY)
                .replace(new RString("年"), RString.EMPTY);
        source.four_shinseiMM = new RString(item.get認定申請年月日().getMonthValue());
        source.four_shinseiDD = new RString(item.get認定申請年月日().getDayValue());
        source.four_sakuseiGengo = get元号(システム日付);
        source.four_sakuseiYY = get年(システム日付).replace(get元号(システム日付), RString.EMPTY)
                .replace(new RString("年"), RString.EMPTY);
        source.four_sakuseiMM = new RString(システム日付.getMonthValue());
        source.four_sakuseiDD = new RString(システム日付.getDayValue());
        source.four_chosaGengo = get元号(item.get認定調査実施年月日());
        source.four_chosaYY = get年(item.get認定調査実施年月日()).replace(get元号(item.get認定調査実施年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.four_chosaMM = new RString(item.get認定調査実施年月日().getMonthValue());
        source.four_chosaDD = new RString(item.get認定調査実施年月日().getDayValue());
        source.four_shinsaGengo = get元号(item.get介護認定審査会開催年月日());
        source.four_shinsaYY = get年(item.get介護認定審査会開催年月日()).replace(get元号(item.get介護認定審査会開催年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.four_shinsaMM = new RString(item.get介護認定審査会開催年月日().getMonthValue());
        source.four_shinsaDD = new RString(item.get介護認定審査会開催年月日().getDayValue());
        source.four_imgIkensho2 = item.get主治医意見書イメージ2();
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
