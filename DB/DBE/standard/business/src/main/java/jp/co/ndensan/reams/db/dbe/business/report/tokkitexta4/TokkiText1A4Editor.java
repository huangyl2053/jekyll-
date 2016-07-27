/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitexta4;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitexta4.TokkiText1A4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitexta4.TokkiText1A4ReportSource;
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
 * 特記事項（A4版）のEditorです。
 *
 * @reamsid_L DBE-0150-340 wangrenze
 */
public class TokkiText1A4Editor implements ITokkiText1A4Editor {

    private static final RString 全面 = new RString("1");
    private static final RString 短冊 = new RString("2");
    private final TokkiText1A4Entity item;
    private final int index;
    private final List<RString> 特記事項List;

    /**
     * インスタンスを生成します。
     *
     * @param item TokkiText1A4Entity
     * @param index Index
     * @param 特記事項List List<RString>
     */
    protected TokkiText1A4Editor(TokkiText1A4Entity item, List<RString> 特記事項List, int index) {
        this.item = item;
        this.index = index;
        this.特記事項List = 特記事項List;
    }

    @Override
    public TokkiText1A4ReportSource edit(TokkiText1A4ReportSource source) {
        return editSource(source);
    }

    private TokkiText1A4ReportSource editSource(TokkiText1A4ReportSource source) {
        if (item.is委員用()) {
            source.hokenshaNo = RString.EMPTY;
            source.hihokenshaNo = RString.EMPTY;
            source.hihokenshaName = RString.EMPTY;
        } else {
            source.hokenshaNo = item.get保険者番号();
            source.hihokenshaNo = item.get被保険者番号();
            source.hihokenshaName = item.get名前();
        }
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
            source.gaikyotokkiText = item.get概況調査の特記事項テキスト();
        }

        if (TokkijikoTextImageKubun.イメージ.getコード().equals(item.get概況特記テキスト_イメージ区分())) {
            source.gaikyotokkiImg = item.get概況調査の特記事項イメージ();
        }
        if (TokkijikoTextImageKubun.テキスト.getコード().equals(item.get特記事項テキスト_イメージ区分())
                && 全面.equals(item.get特記パターン())) {
            source.tokkiText = item.getTokkiText();
        }
        if (TokkijikoTextImageKubun.テキスト.getコード().equals(item.get特記事項テキスト_イメージ区分())
                && 短冊.equals(item.get特記パターン())) {
            editSource1(source);
            source.tokkiText1 = item.getTokkiText1();
            source.tokkiText2 = item.getTokkiText2();
            source.tokkiText3 = item.getTokkiText3();
            source.tokkiText4 = item.getTokkiText4();
            source.tokkiText5 = item.getTokkiText5();
            source.tokkiText6 = item.getTokkiText6();
            source.tokkiText7 = item.getTokkiText7();
            source.tokkiText8 = item.getTokkiText8();
            source.tokkiText9 = item.getTokkiText9();
            source.tokkiText10 = item.getTokkiText10();
            source.tokkiText11 = item.getTokkiText11();
            source.tokkiText12 = item.getTokkiText12();
            source.tokkiText13 = item.getTokkiText13();
            source.tokkiText14 = item.getTokkiText14();
            source.tokkiText15 = item.getTokkiText15();
        }
        if (TokkijikoTextImageKubun.イメージ.getコード().equals(item.get特記事項テキスト_イメージ区分())
                && 全面.equals(item.get特記パターン())) {
            source.tokkiImg = item.getTokkiImg();
        }

        if (TokkijikoTextImageKubun.イメージ.getコード().equals(item.get特記事項テキスト_イメージ区分())
                && 短冊.equals(item.get特記パターン())) {
            editSource2(source);
            source.tokkiImg1 = item.getTokkiImg1();
            source.tokkiImg2 = item.getTokkiImg2();
            source.tokkiImg3 = item.getTokkiImg3();
            source.tokkiImg4 = item.getTokkiImg4();
            source.tokkiImg5 = item.getTokkiImg5();
            source.tokkiImg6 = item.getTokkiImg6();
            source.tokkiImg7 = item.getTokkiImg7();
            source.tokkiImg8 = item.getTokkiImg8();
            source.tokkiImg9 = item.getTokkiImg9();
            source.tokkiImg10 = item.getTokkiImg10();
            source.tokkiImg11 = item.getTokkiImg11();
            source.tokkiImg12 = item.getTokkiImg12();
            source.tokkiImg13 = item.getTokkiImg13();
            source.tokkiImg14 = item.getTokkiImg14();
            source.tokkiImg15 = item.getTokkiImg15();
        }

        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (!RString.isNullOrEmpty(item.get申請書管理番号())) {
            source.hishokenshaNo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                    item.get申請書管理番号());
        }
        return source;
    }

    private void editSource1(TokkiText1A4ReportSource source) {
        if (index < item.get短冊テキスト情報リスト().size()) {
            source.listChosa1_1 = 特記事項List.get(index);
        }

    }

    private void editSource2(TokkiText1A4ReportSource source) {
        if (index < item.get短冊イメージ情報リスト().size()) {
            source.listChosa_1 = 特記事項List.get(index);
        }
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
