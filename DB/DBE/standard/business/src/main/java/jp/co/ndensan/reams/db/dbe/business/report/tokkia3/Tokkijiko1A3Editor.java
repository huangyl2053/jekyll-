/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkia3;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkia3.TokkiText1A3Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkia3.TokkiText1A3ReportSource;
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
 * 事務局用特記事項のEditorです。
 *
 * @reamsid_L DBE-0150-060 wangrenze
 */
public class Tokkijiko1A3Editor implements ITokkijiko1A3Editor {

    private final TokkiText1A3Entity item;

    /**
     * インスタンスを生成します。
     *
     * @param item TokkiText1A3Entity
     */
    protected Tokkijiko1A3Editor(TokkiText1A3Entity item) {
        this.item = item;
    }

    @Override
    public TokkiText1A3ReportSource edit(TokkiText1A3ReportSource source) {

        source.hihokenshaName = item.get名前();
        source.hihokenshaNo = item.get被保険者番号();
        source.hokenshaNo = item.get保険者番号();
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
        source.tokkiImg = item.get特記事項Img();
        source.tokkiText = item.get特記事項Text();
        source.two1_tokkiImg = item.getTwo1_特記事項Img();
        source.listChosa_1 = item.getListChosa_1();
        source.listChosa1_1 = item.getListChosa1_1();
        edit2(source);
        source.four_hihokenshaName = item.get名前();
        source.four_hihokenshaNo = item.get被保険者番号();
        source.four_hokenshaNo = item.get保険者番号();
        source.four_shinseiGengo = get元号(item.get認定申請年月日());
        source.four_shinseiYY = get年(item.get認定申請年月日()).replace(get元号(item.get認定申請年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.four_shinseiMM = new RString(item.get認定申請年月日().getMonthValue());
        source.four_shinseiDD = new RString(item.get認定申請年月日().getDayValue());
        source.four_sakuseiGengo = get元号(システム日付);
        source.four_sakuseiYY = get年(システム日付).replace(get元号(システム日付), RString.EMPTY)
                .replace(new RString("年"), RString.EMPTY);
        source.four_sakuseiMM = new RString(システム日付.getMonthValue());
        source.four_sakuseiDD = new RString(システム日付.getDayValue());
        source.four_chosaGengo = get元号(item.get認定調査実施年月日());
        source.four_chosaYY = get年(item.get認定調査実施年月日());
        source.four_chosaMM = new RString(item.get認定調査実施年月日().getMonthValue());
        source.four_chosaDD = new RString(item.get認定調査実施年月日().getDayValue());
        source.four_shinsaGengo = get元号(item.get介護認定審査会開催年月日());
        source.four_shinsaYY = get年(item.get介護認定審査会開催年月日()).replace(get元号(
                item.get介護認定審査会開催年月日()), RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.four_shinsaMM = new RString(item.get介護認定審査会開催年月日().getMonthValue());
        source.four_shinsaDD = new RString(item.get介護認定審査会開催年月日().getDayValue());
        source.four_listChosa_1 = item.getListChosa_1();
        source.four_listChosa1_1 = item.getListChosa1_1();
        source.four_tokkiImg1 = item.getFour_特記Img1();
        source.four_tokkiImg2 = item.getFour_特記Img2();
        source.four_tokkiImg3 = item.getFour_特記Img3();
        source.four_tokkiImg4 = item.getFour_特記Img4();
        source.four_tokkiImg5 = item.getFour_特記Img5();
        source.four_tokkiImg6 = item.getFour_特記Img6();
        source.four_tokkiImg7 = item.getFour_特記Img7();
        source.four_tokkiImg8 = item.getFour_特記Img8();
        source.four_tokkiImg9 = item.getFour_特記Img9();
        source.four_tokkiImg10 = item.getFour_特記Img10();
        source.four_tokkiImg11 = item.getFour_特記Img11();
        source.four_tokkiImg12 = item.getFour_特記Img12();
        source.four_tokkiImg13 = item.getFour_特記Img13();
        source.four_tokkiImg14 = item.getFour_特記Img14();
        source.four_tokkiImg15 = item.getFour_特記Img15();
        source.four_tokkiImg16 = item.getFour_特記Img16();
        source.four_tokkiImg17 = item.getFour_特記Img17();
        source.four_tokkiImg18 = item.getFour_特記Img18();
        source.four_tokkiImg22 = item.getFour_特記Img22();
        source.four_tokkiImg23 = item.getFour_特記Img23();
        source.four_tokkiImg24 = item.getFour_特記Img24();
        source.four_tokkiImg25 = item.getFour_特記Img25();
        source.four_tokkiImg26 = item.getFour_特記Img26();
        source.four_tokkiImg27 = item.getFour_特記Img27();
        source.four_tokkiImg28 = item.getFour_特記Img28();
        source.four_tokkiImg29 = item.getFour_特記Img29();
        source.four_tokkiImg30 = item.getFour_特記Img30();
        source.four_tokkiImg31 = item.getFour_特記Img31();
        source.four_tokkiImg32 = item.getFour_特記Img32();
        source.four_tokkiImg33 = item.getFour_特記Img33();
        source.four_tokkiImg34 = item.getFour_特記Img34();
        source.four_tokkiImg19 = item.getFour_特記Img19();
        source.four_tokkiImg20 = item.getFour_特記Img20();
        source.four_tokkiImg21 = item.getFour_特記Img21();
        source.shikibetuCode = ShikibetsuCode.EMPTY;

        if (!RString.isNullOrEmpty(item.get申請書管理番号())) {
            source.hishokenshaNo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                    item.get申請書管理番号());
        }

        return source;
    }

    /**
     * 事務局用特記事項を編集します。
     *
     * @param source 帳票ソース
     */
    public void edit2(TokkiText1A3ReportSource source) {
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
        source.two_listChosa_1 = item.getTwo_listChosa_1();
        source.two_listChosa1_1 = item.getTwo_listChosa1_1();
        source.two_listChosa2_1 = item.getTwo_listChosa2_1();
        source.two_listChosa3_1 = item.getTwo_listChosa3_1();
        source.two_tokkiImg3 = item.getTwo_特記Img3();
        source.two_tokkiImg4 = item.getTwo_特記Img4();
        source.two_tokkiImg5 = item.getTwo_特記Img5();
        source.two_tokkiImg6 = item.getTwo_特記Img6();
        source.two_tokkiImg7 = item.getTwo_特記Img7();
        source.two_tokkiImg8 = item.getTwo_特記Img8();
        source.two_tokkiImg9 = item.getTwo_特記Img9();
        source.two_tokkiImg10 = item.getTwo_特記Img10();
        source.two_tokkiImg11 = item.getTwo_特記Img11();
        source.two_tokkiImg12 = item.getTwo_特記Img12();
        source.two_tokkiImg13 = item.getTwo_特記Img13();
        source.two_tokkiImg14 = item.getTwo_特記Img14();
        source.two_tokkiImg15 = item.getTwo_特記Img15();
        source.two_tokkiImg16 = item.getTwo_特記Img16();
        source.two_tokkiImg17 = item.getTwo_特記Img17();
        source.two_tokkiImg18 = item.getTwo_特記Img18();
        source.two_tokkiImg19 = item.getTwo_特記Img19();
        source.two_tokkiImg20 = item.getTwo_特記Img20();
        source.two_tokkiImg21 = item.getTwo_特記Img21();
        source.two_tokkiImg22 = item.getTwo_特記Img22();
        source.two_tokkiImg23 = item.getTwo_特記Img23();
        source.two_tokkiImg24 = item.getTwo_特記Img24();
        source.two_tokkiImg25 = item.getTwo_特記Img25();
        source.two_tokkiImg26 = item.getTwo_特記Img26();
        source.two_tokkiImg27 = item.getTwo_特記Img27();
        source.two_tokkiImg28 = item.getTwo_特記Img28();
        source.two_tokkiImg29 = item.getTwo_特記Img29();
        source.two_tokkiImg30 = item.getTwo_特記Img30();
        source.two_tokkiImg31 = item.getTwo_特記Img31();
        source.two_tokkiImg32 = item.getTwo_特記Img32();
        source.two_tokkiImg33 = item.getTwo_特記Img33();
        source.two_tokkiImg34 = item.getTwo_特記Img34();
        source.two_tokkiImg35 = item.getTwo_特記Img35();
        source.two_tokkiImg36 = item.getTwo_特記Img36();
        source.two_tokkiText3 = item.getTwo_特記Text3();
        source.two_tokkiText4 = item.getTwo_特記Text4();
        source.two_tokkiText5 = item.getTwo_特記Text5();
        source.two_tokkiText6 = item.getTwo_特記Text6();
        source.two_tokkiText7 = item.getTwo_特記Text7();
        source.two_tokkiText8 = item.getTwo_特記Text8();
        source.two_tokkiText9 = item.getTwo_特記Text9();
        source.two_tokkiText10 = item.getTwo_特記Text10();
        source.two_tokkiText11 = item.getTwo_特記Text11();
        source.two_tokkiText12 = item.getTwo_特記Text12();
        source.two_tokkiText13 = item.getTwo_特記Text13();
        source.two_tokkiText14 = item.getTwo_特記Text14();
        source.two_tokkiText15 = item.getTwo_特記Text15();
        source.two_tokkiText16 = item.getTwo_特記Text16();
        source.two_tokkiText17 = item.getTwo_特記Text17();
        source.two_tokkiText18 = item.getTwo_特記Text18();
        source.two_tokkiText19 = item.getTwo_特記Text19();
        source.two_tokkiText20 = item.getTwo_特記Text20();
        source.two_tokkiText21 = item.getTwo_特記Text21();
        source.two_tokkiText22 = item.getTwo_特記Text22();
        source.two_tokkiText23 = item.getTwo_特記Text23();
        source.two_tokkiText24 = item.getTwo_特記Text24();
        source.two_tokkiText25 = item.getTwo_特記Text25();
        source.two_tokkiText26 = item.getTwo_特記Text26();
        source.two_tokkiText27 = item.getTwo_特記Text27();
        source.two_tokkiText28 = item.getTwo_特記Text28();
        source.two_tokkiText29 = item.getTwo_特記Text29();
        source.two_tokkiText30 = item.getTwo_特記Text30();
        source.two_tokkiText31 = item.getTwo_特記Text31();
        source.two_tokkiText32 = item.getTwo_特記Text32();
        source.two_tokkiText33 = item.getTwo_特記Text33();
        source.two_tokkiText34 = item.getTwo_特記Text34();
        source.two_tokkiText35 = item.getTwo_特記Text35();
        source.two_tokkiImg1 = item.getTwo_特記Img1();
        source.two_tokkiImg2 = item.getTwo_特記Img2();
        source.two_tokkiText1 = item.getTwo_特記Text1();
        source.two_tokkiText2 = item.getTwo_特記Text2();
        source.two2_tokkiImg1 = item.getTwo2_特記Img1();
        source.two2_tokkiImg2 = item.getTwo2_特記Img2();
        source.three_listChosa_1 = item.getThree_listChosa_1();
        source.three_tokkiImg1 = item.getThree_特記Img1();
        source.three_tokkiImg2 = item.getThree_特記Img2();
        source.three_tokkiImg3 = item.getThree_特記Img3();
        source.three_tokkiImg4 = item.getThree_特記Img4();
        source.three_tokkiImg5 = item.getThree_特記Img5();
        source.three_tokkiImg6 = item.getThree_特記Img6();
        source.three_tokkiImg7 = item.getThree_特記Img7();
        source.three_tokkiImg8 = item.getThree_特記Img8();
        source.three_tokkiImg9 = item.getThree_特記Img9();
        source.three_tokkiImg10 = item.getThree_特記Img10();
        source.three_tokkiImg11 = item.getThree_特記Img11();
        source.three_tokkiImg12 = item.getThree_特記Img12();
        source.three_tokkiImg13 = item.getThree_特記Img13();
        source.three_tokkiImg14 = item.getThree_特記Img14();
        source.three_tokkiImg15 = item.getThree_特記Img15();
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
