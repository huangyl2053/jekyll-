/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.gaikyotokkiimagea4;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuGaikyouBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.gaikyotokkiimagea4.GaikyotokkiImageA4ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
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
 * 事務局概況特記のEditorです。
 *
 * @reamsid_L DBE-0150-370 wangrenze
 */
public class GaikyotokkiImageA4Editor implements IGaikyotokkiImageA4Editor {

    private final JimuGaikyouBusiness item;

    /**
     * コンストラクタです。
     *
     * @param item {@link JimuGaikyouBusiness}
     */
    protected GaikyotokkiImageA4Editor(JimuGaikyouBusiness item) {
        this.item = item;
    }

    /**
     * 事務局概況特記を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public GaikyotokkiImageA4ReportSource edit(GaikyotokkiImageA4ReportSource source) {

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

        if (TokkijikoTextImageKubun.テキスト.getコード().equals(item.get概況特記テキスト_イメージ区分())) {
            source.tokkiText1 = item.get住宅改修テキスト();
            source.tokkiText2 = item.get市町村特別給付のサービス種類名テキスト();
            source.tokkiText3 = item.get介護保険給付外の在宅サービス種類名テキスト();
            source.tokkiText4 = item.get概況特記事項_主訴_テキスト();
            source.tokkiText5 = item.get概況特記事項_家族状況_テキスト();
            source.tokkiText6 = item.get概況特記事項_居住環境_テキスト();
            source.tokkiText7 = item.get概況特記事項_機器_機械_テキスト();

        }

        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (!RString.isNullOrEmpty(item.get申請書管理番号())) {
            source.hishokenshaNo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
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
