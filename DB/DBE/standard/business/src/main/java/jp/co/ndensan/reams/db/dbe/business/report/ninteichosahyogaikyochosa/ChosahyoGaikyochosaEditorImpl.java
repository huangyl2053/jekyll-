/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyogaikyochosa;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyogaikyochosa.ChosahyoGaikyochosaReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FillTypeFormatted;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;

/**
 * 要介護認定調査票（概況調査）のEditorです。
 */
public class ChosahyoGaikyochosaEditorImpl implements IChosahyoGaikyochosaEditor {

    private static final RString マーク = new RString("✔");
    private static final RString 男 = new RString("1");
    private static final RString 女 = new RString("2");
    private static final RString 年号_明治 = new RString("明治");
    private static final RString 年号_大正 = new RString("大正");
    private static final RString 年号_昭和 = new RString("昭和");
    private static final RString ハイフン = new RString("-");
    private static final RString 要支援詳細_1 = new RString("1");
    private static final RString 要支援詳細_2 = new RString("2");
    private static final RString 要介護詳細_1 = new RString("1");
    private static final RString 要介護詳細_2 = new RString("2");
    private static final RString 要介護詳細_3 = new RString("3");
    private static final RString 要介護詳細_4 = new RString("4");
    private static final RString 要介護詳細_5 = new RString("5");
    private static final int INDEX_3 = 3;
    private static final int INDEX_6 = 6;
    private final ChosahyoGaikyochosaItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosahyoGaikyochosaItem}
     */
    protected ChosahyoGaikyochosaEditorImpl(ChosahyoGaikyochosaItem item) {
        this.item = item;
    }

    /**
     * 要介護認定調査票（概況調査）を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public ChosahyoGaikyochosaReportSource edit(ChosahyoGaikyochosaReportSource source) {
        return editSource(source);
    }

    private ChosahyoGaikyochosaReportSource editSource(ChosahyoGaikyochosaReportSource source) {
        // TODO 内部QA:663 Redmine#75721 (パラメータの整合性が取れてないので、一時item値を設定する。)
        source.hokenshaNo1 = item.getHokenshaNo1();
        source.hokenshaNo2 = item.getHokenshaNo2();
        source.hokenshaNo3 = item.getHokenshaNo3();
        source.hokenshaNo4 = item.getHokenshaNo4();
        source.hokenshaNo5 = item.getHokenshaNo5();
        source.hokenshaNo6 = item.getHokenshaNo6();
        source.shinseiYY1 = item.getShinseiYY1();
        source.shinseiYY2 = item.getShinseiYY2();
        source.shinseiMM1 = item.getShinseiMM1();
        source.shinseiMM2 = item.getShinseiMM2();
        source.shinseiDD1 = item.getShinseiDD1();
        source.shinseiDD2 = item.getShinseiDD2();
        source.hishokenshaNo1 = item.getHishokenshaNo1();
        source.hishokenshaNo2 = item.getHishokenshaNo2();
        source.hishokenshaNo3 = item.getHishokenshaNo3();
        source.hishokenshaNo4 = item.getHishokenshaNo4();
        source.hishokenshaNo5 = item.getHishokenshaNo5();
        source.hishokenshaNo6 = item.getHishokenshaNo6();
        source.hishokenshaNo7 = item.getHishokenshaNo7();
        source.hishokenshaNo8 = item.getHishokenshaNo8();
        source.hishokenshaNo9 = item.getHishokenshaNo9();
        source.hishokenshaNo10 = item.getHishokenshaNo10();
        source.homonChosainNo1 = item.getHomonChosainNo1();
        source.homonChosainNo2 = item.getHomonChosainNo2();
        source.homonChosainNo3 = item.getHomonChosainNo3();
        source.homonChosainNo4 = item.getHomonChosainNo4();
        source.homonChosainNo5 = item.getHomonChosainNo5();
        source.homonChosainNo6 = item.getHomonChosainNo6();
        source.homonChosainNo7 = item.getHomonChosainNo7();
        source.homonChosainNo8 = item.getHomonChosainNo8();
        source.homonChosainName = item.getHomonChosainName();
        source.homonChosasakiNo1 = item.getHomonChosasakiNo1();
        source.homonChosasakiNo2 = item.getHomonChosasakiNo2();
        source.homonChosasakiNo3 = item.getHomonChosasakiNo3();
        source.homonChosasakiNo4 = item.getHomonChosasakiNo4();
        source.homonChosasakiNo5 = item.getHomonChosasakiNo5();
        source.homonChosasakiNo6 = item.getHomonChosasakiNo6();
        source.homonChosasakiNo7 = item.getHomonChosasakiNo7();
        source.homonChosasakiNo8 = item.getHomonChosasakiNo8();
        source.homonChosasakiNo9 = item.getHomonChosasakiNo9();
        source.homonChosasakiNo10 = item.getHomonChosasakiNo10();
        source.homonChosasakiNo11 = item.getHomonChosasakiNo11();
        source.homonChosasakiNo12 = item.getHomonChosasakiNo12();
        // TODO 内部QA:823   所属機関名不存在。
        source.shinseishaNameKana = item.getShinseishaNameKana();
        source.shinseishaName = item.getShinseishaName();
        if (男.equals(item.getSeibetsuMan())) {
            source.seibetsuMan = マーク;
        } else if (女.equals(item.getSeibetsuWoman())) {
            source.seibetsuWoman = マーク;
        }
        source.shinseishaJusho = item.getShinseishaJusho();

        source.shinseishaYubinNo = set郵便番号(item.getShinseishaYubinNo());
        source.shinseishTelNo = set電話番号(item.getShinseishTelNo());
        FlexibleDate birthDate = new FlexibleDate("20160101");
        if (birthDate.isEmpty()) {
            source.meiji = RString.EMPTY;
            source.taisho = RString.EMPTY;
            source.showa = RString.EMPTY;
            source.birthYY = RString.EMPTY;
            source.birthMM = RString.EMPTY;
            source.birthDD = RString.EMPTY;
        } else {
            FillTypeFormatted fillType = birthDate.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.NONE).fillType(FillType.BLANK);
            if (年号_明治.equals(fillType.getEra())) {
                source.meiji = マーク;
            } else if (年号_大正.equals(fillType.getEra())) {
                source.taisho = マーク;
            } else if (年号_昭和.equals(fillType.getEra())) {
                source.showa = マーク;
            }
            source.birthYY = fillType.width(Width.HALF).getYear().replace(fillType.getEra(), RString.EMPTY);
            source.birthMM = fillType.width(Width.HALF).getMonth();
            source.birthDD = fillType.width(Width.HALF).getDay();

        }
        source.age = item.getAge();
        source.kazokuRenrakusakiJusho = item.getKazokuRenrakusakiJusho();
        source.kazokuRenrakusakiYubinNo = set郵便番号(item.getKazokuRenrakusakiYubinNo());
        source.kazokuRenrakusakiTel1 = set電話番号(item.getKazokuRenrakusakiTel1());
        source.kazokuRenrakusakiTel2 = set電話番号(item.getKazokuRenrakusakiTel2());
        source.kazokuRenrakusakiName = item.getKazokuRenrakusakiName();
        // TODO 内部QA:843   Enum（DBD：連絡先続柄コード）不存在。
        source.shinseishatonoKankei = item.getShinseishatonoKankei();
        FlexibleDate date = new FlexibleDate("20160101");
        if (date.isEmpty()) {
            source.shokai = マーク;
        } else {
            source.nikaime = マーク;
            FillTypeFormatted fillType = date.seireki().separator(Separator.NONE).fillType(FillType.ZERO);
            source.zenkaiNinteiYYYY = fillType.width(Width.HALF).getYear();
            source.zenkaiNinteiMM = fillType.width(Width.HALF).getMonth();
            source.zenkaiNinteiDD = fillType.width(Width.HALF).getDay();
        }
        RString zenYokaigoKubunCode = new RString("13");
        if (YokaigoJotaiKubun09.非該当.getコード().equals(zenYokaigoKubunCode)) {
            source.higaito = マーク;
        } else if (YokaigoJotaiKubun09.要支援1.getコード().equals(zenYokaigoKubunCode)) {
            source.yoshien = マーク;
            source.yoshiendo = 要支援詳細_1;
        } else if (YokaigoJotaiKubun09.要支援2.getコード().equals(zenYokaigoKubunCode)) {
            source.yoshien = マーク;
            source.yoshiendo = 要支援詳細_2;
        } else if (YokaigoJotaiKubun09.要介護1.getコード().equals(zenYokaigoKubunCode)) {
            source.yokaigo = マーク;
            source.yokaigodo = 要介護詳細_1;
        } else if (YokaigoJotaiKubun09.要介護2.getコード().equals(zenYokaigoKubunCode)) {
            source.yokaigo = マーク;
            source.yokaigodo = 要介護詳細_2;
        } else if (YokaigoJotaiKubun09.要介護3.getコード().equals(zenYokaigoKubunCode)) {
            source.yokaigo = マーク;
            source.yokaigodo = 要介護詳細_3;
        } else if (YokaigoJotaiKubun09.要介護4.getコード().equals(zenYokaigoKubunCode)) {
            source.yokaigo = マーク;
            source.yokaigodo = 要介護詳細_4;
        } else if (YokaigoJotaiKubun09.要介護5.getコード().equals(zenYokaigoKubunCode)) {
            source.yokaigo = マーク;
            source.yokaigodo = 要介護詳細_5;
        }
        return source;
    }

    private static RString set電話番号(RString 電話番号) {
        if (電話番号 != null && !電話番号.isEmpty()) {
            RStringBuilder builder = new RStringBuilder();
            if (INDEX_6 <= 電話番号.length()) {
                builder.append(電話番号.substring(0, INDEX_3));
                builder.append(ハイフン);
                builder.append(電話番号.substring(INDEX_3, INDEX_6));
                builder.append(ハイフン);
                builder.append(電話番号.substring(INDEX_6));
            } else if (INDEX_3 <= 電話番号.length()) {
                builder.append(電話番号.substring(0, INDEX_3));
                builder.append(ハイフン);
                builder.append(電話番号.substring(INDEX_3));
            } else {
                builder.append(電話番号);
            }
            電話番号 = builder.toRString();
        } else {
            電話番号 = RString.EMPTY;
        }

        return 電話番号;
    }

    private static RString set郵便番号(RString 郵便番号) {
        if (郵便番号 != null && !郵便番号.isEmpty()) {
            RStringBuilder yubinNo = new RStringBuilder();
            if (INDEX_3 <= 郵便番号.length()) {
                yubinNo.append(郵便番号.substring(0, INDEX_3));
                yubinNo.append(ハイフン);
                yubinNo.append(郵便番号.substring(INDEX_3));
            } else {
                yubinNo.append(郵便番号);
            }
            郵便番号 = yubinNo.toRString();
        } else {
            郵便番号 = RString.EMPTY;
        }

        return 郵便番号;
    }
}
