/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkia4;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkia4.TokkiText2A4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkia4.TokkiText2A4ReportSource;
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
 * 特記事項2枚目以降（A4版）のEditorです。
 *
 * @reamsid_L DBE-0150-350 wangrenze
 */
public class TokkiText2A4Editor implements ITokkiText2A4Editor {

    private final TokkiText2A4Entity item;
    private static final RString 全面 = new RString("1");
    private static final RString 短冊 = new RString("2");
    private final int index;
    private final List<RString> 特記事項List;

    /**
     * インスタンスを生成します。
     *
     * @param item TokkiText2A4Entity
     * @param index Index
     * @param 特記事項List List<RString>
     */
    protected TokkiText2A4Editor(TokkiText2A4Entity item, List<RString> 特記事項List, int index) {
        this.item = item;
        this.index = index;
        this.特記事項List = 特記事項List;
    }

    @Override
    public TokkiText2A4ReportSource edit(TokkiText2A4ReportSource source) {
        if (item.is委員用()) {
            source.hokenshaNo = RString.EMPTY;
            source.hihokenshaNo = RString.EMPTY;
            source.hihokenshaName = RString.EMPTY;
            source.two_hihokenshaName = RString.EMPTY;
            source.two_hihokenshaNo = RString.EMPTY;
            source.two_hokenshaNo = RString.EMPTY;
        } else {
            source.hokenshaNo = item.get保険者番号();
            source.hihokenshaNo = item.get被保険者番号();
            source.hihokenshaName = item.get名前();
            source.two_hihokenshaName = item.get名前();
            source.two_hihokenshaNo = item.get被保険者番号();
            source.two_hokenshaNo = item.get保険者番号();
        }

        source.shinseiGengo = get元号(item.get認定申請年月日());
        source.shinseiYY = get年(item.get認定申請年月日()).replace(get元号(item.get認定申請年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.shinseiMM = new RString(item.get認定申請年月日().getMonthValue());
        source.shinseiDD = new RString(item.get認定申請年月日().getDayValue());
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        source.sakuseiGengo = get元号(システム日付);
        source.sakuseiYY = get年(システム日付).replace(get元号(システム日付), RString.EMPTY)
                .replace(new RString("年"), RString.EMPTY);
        source.sakuseiMM = new RString(システム日付.getMonthValue());
        source.sakuseiDD = new RString(システム日付.getDayValue());
        source.chosaGengo = get元号(item.get認定調査実施年月日());
        source.chosaYY = get年(item.get認定調査実施年月日());
        source.chosaMM = new RString(item.get認定調査実施年月日().getMonthValue());
        source.chosaDD = new RString(item.get認定調査実施年月日().getDayValue());
        source.shinsaGengo = get元号(item.get介護認定審査会開催年月日());
        source.shinsaYY = get年(item.get介護認定審査会開催年月日()).replace(get元号(item.get介護認定審査会開催年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.shinsaMM = new RString(item.get介護認定審査会開催年月日().getMonthValue());
        source.shinsaDD = new RString(item.get介護認定審査会開催年月日().getDayValue());
        source.two_shinseiGengo = get元号(item.get認定申請年月日());
        source.two_shinseiYY = get年(item.get認定申請年月日()).replace(get元号(item.get認定申請年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.two_shinseiMM = new RString(item.get認定申請年月日().getMonthValue());
        source.two_shinseiDD = new RString(item.get認定申請年月日().getDayValue());
        source.two_sakuseiGengo = get元号(システム日付);
        source.two_sakuseiYY = get年(システム日付).replace(get元号(システム日付), RString.EMPTY)
                .replace(new RString("年"), RString.EMPTY);
        source.two_sakuseiMM = new RString(システム日付.getMonthValue());
        source.two_sakuseiDD = new RString(システム日付.getDayValue());
        source.two_chosaGengo = get元号(item.get認定調査実施年月日());
        source.two_chosaYY = get年(item.get認定調査実施年月日());
        source.two_chosaMM = new RString(item.get認定調査実施年月日().getMonthValue());
        source.two_chosaDD = new RString(item.get認定調査実施年月日().getDayValue());
        source.two_shinsaGengo = get元号(item.get介護認定審査会開催年月日());
        source.two_shinsaYY = get年(item.get介護認定審査会開催年月日()).replace(get元号(item.get介護認定審査会開催年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.two_shinsaMM = new RString(item.get介護認定審査会開催年月日().getMonthValue());
        source.two_shinsaDD = new RString(item.get介護認定審査会開催年月日().getDayValue());

        if (TokkijikoTextImageKubun.テキスト.getコード().equals(item.get概況特記テキスト_イメージ区分())) {
            source.gaikyotokkiText = item.get概況調査の特記事項テキスト();
        }

        if (TokkijikoTextImageKubun.イメージ.getコード().equals(item.get概況特記テキスト_イメージ区分())) {
            source.gaikyotokkiImg = item.get概況調査の特記事項イメージ();
        }

        if (TokkijikoTextImageKubun.テキスト.getコード().equals(item.get特記事項テキスト_イメージ区分())) {
            if (全面.equals(item.get特記パターン())) {
                source.tokkiText = item.get特記事項Text();
            } else if (短冊.equals(item.get特記パターン())) {
                editSource1(source);
                source.tokkiText1 = item.get特記Text1();
                source.tokkiText2 = item.get特記Text2();
                source.tokkiText3 = item.get特記Text3();
                source.tokkiText4 = item.get特記Text4();
                source.tokkiText5 = item.get特記Text5();
                source.tokkiText6 = item.get特記Text6();
                source.tokkiText7 = item.get特記Text7();
                source.tokkiText8 = item.get特記Text8();
                source.tokkiText9 = item.get特記Text9();
                source.tokkiText10 = item.get特記Text10();
                source.tokkiText11 = item.get特記Text11();
                source.tokkiText12 = item.get特記Text12();
                source.tokkiText13 = item.get特記Text13();
                source.tokkiText14 = item.get特記Text14();
                source.tokkiText15 = item.get特記Text15();
            }
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(item.get特記事項テキスト_イメージ区分())) {
            if (全面.equals(item.get特記パターン())) {
                source.tokkiImg = item.get特記事項Img();
            } else if (短冊.equals(item.get特記パターン())) {
                editSource2(source);
                source.tokkiImg1 = item.get特記Img1();
                source.tokkiImg2 = item.get特記Img2();
                source.tokkiImg3 = item.get特記Img3();
                source.tokkiImg4 = item.get特記Img4();
                source.tokkiImg5 = item.get特記Img5();
                source.tokkiImg6 = item.get特記Img6();
                source.tokkiImg7 = item.get特記Img7();
                source.tokkiImg8 = item.get特記Img8();
                source.tokkiImg9 = item.get特記Img9();
                source.tokkiImg10 = item.get特記Img10();
                source.tokkiImg11 = item.get特記Img11();
                source.tokkiImg12 = item.get特記Img12();
                source.tokkiImg13 = item.get特記Img13();
                source.tokkiImg14 = item.get特記Img14();
                source.tokkiImg15 = item.get特記Img15();
            }
        }

        source.shikibetuCode = ShikibetsuCode.EMPTY;

        if (!RString.isNullOrEmpty(item.get申請書管理番号())) {
            source.hishokenshaNo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                    item.get申請書管理番号());
        }

        return source;
    }

    private void editSource1(TokkiText2A4ReportSource source) {
        if (index < 特記事項List.size()) {
            source.listChosa1_1 = 特記事項List.get(index);
        }

    }

    private void editSource2(TokkiText2A4ReportSource source) {
        if (index < 特記事項List.size()) {
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
