/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.report.kaigohokenrenrakuhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenrenrakuhyo.Hokenryo;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenrenrakuhyo.KaigoHokenRenrakuhyoHold;
import jp.co.ndensan.reams.db.dba.service.core.kaigojushoeditor.KaigoJushoEditor;
import jp.co.ndensan.reams.db.dbc.definition.core.riyoshafutandankai.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbu.business.report.kaigohokenrenrakuhyo.KaigohokenRenrakuhyo;
import jp.co.ndensan.reams.db.dbu.business.report.kaigohokenrenrakuhyo.KaigohokenRenrakuhyoProerty;
import jp.co.ndensan.reams.db.dbu.business.report.kaigohokenrenrakuhyo.KaigohokenRenrakuhyoReport;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.kaigohokenrenrakuhyo.KaigohokenRenrakuhyoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.util.kogakukaigoservicehi.KogakuKaigoServiceHiJikoFutanJogenGaku;
import jp.co.ndensan.reams.db.dbz.definition.core.util.tokuteinyushosha.TokuteiNyushoshaFutanGendoNichigakuGetter;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護保険連絡票PrintServiceクラスです。
 *
 * @reamsid_L DBA-1290-070 lishengli
 */
public class KaigohokenRenrakuhyoPrintService {

    private static final RString レ = new RString("ﾚ");
    private static final RString 西暦表示 = new RString("2");
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;
    private static final int INT_11 = 11;
    private static final int INT_12 = 12;
    private boolean 保険料チェックFlg = false;

    /**
     * 広域内転居結果一覧表を印刷します。
     *
     * @param hold KaigoHokenRenrakuhyoHold。
     * @return {@link KaigohokenRenrakuhyoReport}
     */
    public SourceDataCollection print(KaigoHokenRenrakuhyoHold hold) {
        KaigohokenRenrakuhyoProerty property = new KaigohokenRenrakuhyoProerty();
        KaigohokenRenrakuhyo renrakuhyo = getKaigohokenRenrakuhyo(hold);
        return new Printer<KaigohokenRenrakuhyoReportSource>().spool(property, toReports(renrakuhyo));
    }

    private static List<KaigohokenRenrakuhyoReport> toReports(KaigohokenRenrakuhyo renrakuhyo) {
        List<KaigohokenRenrakuhyoReport> list = new ArrayList<>();
        list.add(KaigohokenRenrakuhyoReport.createReport(
                renrakuhyo));
        return list;
    }

    private KaigohokenRenrakuhyo getKaigohokenRenrakuhyo(KaigoHokenRenrakuhyoHold hold) {
        KaigohokenRenrakuhyo renrakuhyo = new KaigohokenRenrakuhyo();

        TokuteiNyushoshaFutanGendoNichigakuGetter gendoNichigakuGetter = new TokuteiNyushoshaFutanGendoNichigakuGetter();
        if (hold == null) {
            return renrakuhyo;
        }
        renrakuhyo.set作成年月日(getパターン12(hold.get連絡票作成日()));
        renrakuhyo.set被保険者番号(get被保険者番号(hold));
        IKojin 個人 = hold.get個人();
        if (個人 == null) {
            renrakuhyo.set氏名フリガナ(RString.EMPTY);
            renrakuhyo.set被保険者氏名(RString.EMPTY);
            renrakuhyo.set生年月日(RString.EMPTY);
            renrakuhyo.set性別(RString.EMPTY);
            renrakuhyo.set住所(RString.EMPTY);
            renrakuhyo.set電話番号(RString.EMPTY);
        } else {
            if (個人.get名称() != null) {
                renrakuhyo.set氏名フリガナ(get氏名フリガナ(個人.get名称().getKana()));
                renrakuhyo.set被保険者氏名(get被保険者氏名(個人.get名称().getName()));
            }
            renrakuhyo.set生年月日(get生年月日(個人));
            renrakuhyo.set性別(getチェック(個人.get性別() != null, 個人.get性別().getCommonName()));
            KaigoJushoEditor kaigoJushoEditor = new KaigoJushoEditor();
            RString 住所 = kaigoJushoEditor.create編集後住所(個人.get住所(), 個人.get行政区画().getGyoseiku(),
                    SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU100002.getReportId().value(), get市町村コード(hold));
            renrakuhyo.set住所(住所);
            renrakuhyo.set電話番号(getチェック(個人.get連絡先１() != null, 個人.get連絡先１().getColumnValue()));
        }
        if (hold.get受給者台帳() != null) {
            renrakuhyo.set要介護チェック(get要介護チェック(hold.get受給者台帳().get要介護認定状態区分コード()));
            renrakuhyo.set要介護度段階(get要介護度段階(hold.get受給者台帳().get要介護認定状態区分コード()));
            renrakuhyo.set要支援チェック(get要支援チェック(hold.get受給者台帳().get要介護認定状態区分コード()));
            renrakuhyo.set要支援段階(get要支援段階(hold.get受給者台帳().get要介護認定状態区分コード()));
            renrakuhyo.set認定非該当チェック(get認定非該当チェック(hold.get受給者台帳().get要介護認定状態区分コード()));
            renrakuhyo.set未認定チェック(get未認定チェック(hold.get受給者台帳().get要介護認定状態区分コード()));
            renrakuhyo.set認定年月日(getパターン12(hold.get受給者台帳().get認定年月日()));
        }
        if (hold.get給付減額などの記載() != null) {
            renrakuhyo.set給付減額の記載チェック(getチェック(hold.get給付減額などの記載().is給付減額等の記載あり()));
            renrakuhyo.set給付減額(getチェック(hold.get給付減額などの記載().is給付減額等の記載あり(),
                    DecimalFormatter.toRString(hold.get給付減額などの記載().get給付減額(), 0)));
        }
        if (hold.get居住費の負担限度額() != null) {
            renrakuhyo.set居住費の負担限度日額記載チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり()));
            renrakuhyo.set第1段階_個室チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり() && is第1段階(hold.get利用者負担段階())));
            renrakuhyo.set第1段階_個室金額(get金額_5(gendoNichigakuGetter.getユニット型個室１(hold.get連絡票作成日(), hold.get旧措置者区分())));
            renrakuhyo.set第2段階_個室チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり() && is第2段階(hold.get利用者負担段階())));
            renrakuhyo.set第2段階_個室金額(get金額_5(gendoNichigakuGetter.getユニット型個室２(hold.get連絡票作成日(), hold.get旧措置者区分())));
            renrakuhyo.set第3段階_個室チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり() && is第3段階(hold.get利用者負担段階())));
            renrakuhyo.set第3段階_個室金額(get金額_5(gendoNichigakuGetter.getユニット型個室３(hold.get連絡票作成日(), hold.get旧措置者区分())));
            renrakuhyo.set基準額_個室チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり()
                    && is課税層第3段階(hold.get利用者負担段階())));
            renrakuhyo.set基準額_個室金額(get金額_5(gendoNichigakuGetter.getユニット型個室_基準費用額(hold.get連絡票作成日())));
            renrakuhyo.set第1段階_準個室チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり()
                    && is第1段階(hold.get利用者負担段階())));
            renrakuhyo.set第1段階_準個室金額(get金額_5(gendoNichigakuGetter.getユニット型準個室１(hold.get連絡票作成日(), hold.get旧措置者区分())));
            renrakuhyo.set第2段階_準個室チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり()
                    && is第2段階(hold.get利用者負担段階())));
            renrakuhyo.set第2段階_準個室金額(get金額_5(gendoNichigakuGetter.getユニット型準個室２(hold.get連絡票作成日(), hold.get旧措置者区分())));
            renrakuhyo.set第3段階_準個室チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり()
                    && is第3段階(hold.get利用者負担段階())));
            renrakuhyo.set第3段階_準個室金額(get金額_5(gendoNichigakuGetter.getユニット型準個室３(hold.get連絡票作成日(), hold.get旧措置者区分())));
        }
        renrakuhyo = getKaigohokenRenrakuhyo1(renrakuhyo, hold);
        renrakuhyo = getKaigohokenRenrakuhyo(renrakuhyo, hold);
        return renrakuhyo;
    }

    private KaigohokenRenrakuhyo getKaigohokenRenrakuhyo1(KaigohokenRenrakuhyo renrakuhyo, KaigoHokenRenrakuhyoHold hold) {
        TokuteiNyushoshaFutanGendoNichigakuGetter gendoNichigakuGetter = new TokuteiNyushoshaFutanGendoNichigakuGetter();
        if (hold.get居住費の負担限度額() != null) {
            renrakuhyo.set基準額_準個室チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり()
                    && is課税層第3段階(hold.get利用者負担段階())));
            renrakuhyo.set基準額_準個室金額(get金額_5(gendoNichigakuGetter.getユニット型準個室_基準費用額(hold.get連絡票作成日())));
            renrakuhyo.set第1段階_従来型個室_特養チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり()
                    && is第1段階(hold.get利用者負担段階())));
            renrakuhyo.set第1段階_従来型個室_特養金額(get金額_5(gendoNichigakuGetter.get従個特養１(hold.get連絡票作成日(), hold.get旧措置者区分())));
            renrakuhyo.set第2段階_従来型個室_特養チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり()
                    && is第2段階(hold.get利用者負担段階())));
            renrakuhyo.set第2段階_従来型個室_特養金額(get金額_5(gendoNichigakuGetter.get従個特養２(hold.get連絡票作成日(), hold.get旧措置者区分())));
            renrakuhyo.set第3段階_従来型個室_特養チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり()
                    && is第3段階(hold.get利用者負担段階())));
            renrakuhyo.set第3段階_従来型個室_特養金額(get金額_5(gendoNichigakuGetter.get従個特養３(hold.get連絡票作成日(), hold.get旧措置者区分())));
            renrakuhyo.set基準額_従来型個室_特養チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり()
                    && is課税層第3段階(hold.get利用者負担段階())));
            renrakuhyo.set基準額_従来型個室_特養金額(get金額_5(gendoNichigakuGetter.get従個特養_基準費用額(hold.get連絡票作成日())));
            renrakuhyo.set第1段階_従来型個室_老健療養型チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり()
                    && is第1段階(hold.get利用者負担段階())));
            renrakuhyo.set第1段階_従来型個室_老健療養型金額(get金額_5(gendoNichigakuGetter.get従個老健１(hold.get連絡票作成日())));
            renrakuhyo.set第2段階_従来型個室_老健療養型チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり()
                    && is第2段階(hold.get利用者負担段階())));
            renrakuhyo.set第2段階_従来型個室_老健療養型金額(get金額_5(gendoNichigakuGetter.get従個老健２(hold.get連絡票作成日())));
            renrakuhyo.set第3段階_従来型個室_老健療養型チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり()
                    && is第3段階(hold.get利用者負担段階())));
            renrakuhyo.set第3段階_従来型個室_老健療養型金額(get金額_5(gendoNichigakuGetter.get従個老健３(hold.get連絡票作成日())));
            renrakuhyo.set基準額_従来型個室_老健療養型チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり()
                    && is課税層第3段階(hold.get利用者負担段階())));
            renrakuhyo.set基準額_従来型個室_老健療養型金額(get金額_5(gendoNichigakuGetter.get従個老健_基準費用額(hold.get連絡票作成日())));
            renrakuhyo.set第1段階_多床室チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり()
                    && is第1段階(hold.get利用者負担段階())));
            renrakuhyo.set第1段階_多床室金額(get金額_5(gendoNichigakuGetter.get多床室１(hold.get連絡票作成日())));
            renrakuhyo.set第2段階_多床室チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり()
                    && is第2段階(hold.get利用者負担段階())));
            renrakuhyo.set第2段階_多床室金額(get金額_5(gendoNichigakuGetter.get多床室２(hold.get連絡票作成日())));
            renrakuhyo.set第3段階_多床室チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり()
                    && is第3段階(hold.get利用者負担段階())));
            renrakuhyo.set第3段階_多床室金額(get金額_5(gendoNichigakuGetter.get多床室３(hold.get連絡票作成日())));
            renrakuhyo.set基準額_多床室チェック(getチェック(hold.get居住費の負担限度額().is居住費の記載あり()
                    && is課税層第3段階(hold.get利用者負担段階())));
            renrakuhyo.set基準額_多床室金額(get金額_5(gendoNichigakuGetter.get多床室_基準費用額(hold.get連絡票作成日())));
        }
        return renrakuhyo;
    }

    private KaigohokenRenrakuhyo getKaigohokenRenrakuhyo(KaigohokenRenrakuhyo renrakuhyo, KaigoHokenRenrakuhyoHold hold) {
        KogakuKaigoServiceHiJikoFutanJogenGaku hiJikoFutanJogenGaku = new KogakuKaigoServiceHiJikoFutanJogenGaku();
        TokuteiNyushoshaFutanGendoNichigakuGetter gendoNichigakuGetter = new TokuteiNyushoshaFutanGendoNichigakuGetter();
        if (hold.get食費の_特定_負担限度額() != null) {
            renrakuhyo.set食費負担限度額記載チェック(getチェック(hold.get食費の_特定_負担限度額().is食費の記載あり()));
        }
        renrakuhyo.set食費チェック1(get食費チェック(gendoNichigakuGetter.get食費１(hold.get連絡票作成日(), hold.get旧措置者区分()), hold));
        renrakuhyo.set食費金額1(get金額_5(gendoNichigakuGetter.get食費１(hold.get連絡票作成日(), hold.get旧措置者区分())));
        renrakuhyo.set食費チェック2(get食費チェック(gendoNichigakuGetter.get食費２(hold.get連絡票作成日(), hold.get旧措置者区分()), hold));
        renrakuhyo.set食費金額2(get金額_5(gendoNichigakuGetter.get食費２(hold.get連絡票作成日(), hold.get旧措置者区分())));
        renrakuhyo.set食費チェック3(get食費チェック(gendoNichigakuGetter.get食費３(hold.get連絡票作成日(), hold.get旧措置者区分()), hold));
        renrakuhyo.set食費金額3(get金額_5(gendoNichigakuGetter.get食費３(hold.get連絡票作成日(), hold.get旧措置者区分())));
        renrakuhyo.set食費チェック4(get食費チェック(gendoNichigakuGetter.get食費_基準費用額(hold.get連絡票作成日()), hold));
        renrakuhyo.set食費金額4(get金額_5(gendoNichigakuGetter.get食費_基準費用額(hold.get連絡票作成日())));
        renrakuhyo.set食費金額その他(get食費金額その他(gendoNichigakuGetter.get食費１(hold.get連絡票作成日(), hold.get旧措置者区分()),
                gendoNichigakuGetter.get食費２(hold.get連絡票作成日(), hold.get旧措置者区分()),
                gendoNichigakuGetter.get食費３(hold.get連絡票作成日(), hold.get旧措置者区分()),
                gendoNichigakuGetter.get食費_基準費用額(hold.get連絡票作成日()), hold));
        if (hold.get高額介護サービス費支給による自己負担限度額() != null) {
            renrakuhyo.set高額介護サービス費の支給による自己負担上限月額記載チェック(
                    getチェック(hold.get高額介護サービス費支給による自己負担限度額().is高額介護サービス費の記載あり()));
        }
        renrakuhyo.set高額介護チェック1(get高額介護チェック(hiJikoFutanJogenGaku.get第1段階(hold.get連絡票作成日()), hold));
        renrakuhyo.set高額介護金額1(get金額_5(hiJikoFutanJogenGaku.get第1段階(hold.get連絡票作成日())));
        renrakuhyo.set高額介護チェック２(get高額介護チェック(hiJikoFutanJogenGaku.get第2段階(hold.get連絡票作成日()), hold));
        renrakuhyo.set高額介護金額2(get金額_5(hiJikoFutanJogenGaku.get第2段階(hold.get連絡票作成日())));
        renrakuhyo.set高額介護チェック3(get高額介護チェック(hiJikoFutanJogenGaku.get第3段階(hold.get連絡票作成日()), hold));
        renrakuhyo.set高額介護金額3(get金額_5(hiJikoFutanJogenGaku.get第3段階(hold.get連絡票作成日())));
        renrakuhyo.set高額介護チェック4(get高額介護チェック(hiJikoFutanJogenGaku.get第4段階(hold.get連絡票作成日()), hold));
        renrakuhyo.set高額介護金額4(get金額_5(hiJikoFutanJogenGaku.get第4段階(hold.get連絡票作成日())));
        renrakuhyo.set高額介護金額その他(get高額介護金額その他(hiJikoFutanJogenGaku.get第1段階(hold.get連絡票作成日()),
                hiJikoFutanJogenGaku.get第2段階(hold.get連絡票作成日()),
                hiJikoFutanJogenGaku.get第3段階(hold.get連絡票作成日()),
                hiJikoFutanJogenGaku.get第4段階(hold.get連絡票作成日()), hold));
        if (hold.get介護保険料() != null) {
            renrakuhyo.set介護保険料記載チェック(getチェック(hold.get介護保険料().is介護保険料の記載あり()));
        }
        renrakuhyo.set保険料チェック1(get保険料チェック(1, hold));
        renrakuhyo.set保険料金額1(get保険料金額(1, hold));
        renrakuhyo.set保険料チェック2(get保険料チェック(2, hold));
        renrakuhyo.set保険料金額2(get保険料金額(2, hold));
        renrakuhyo.set保険料チェック3(get保険料チェック(INT_3, hold));
        renrakuhyo.set保険料金額3(get保険料金額(INT_3, hold));
        renrakuhyo.set保険料チェック4(get保険料チェック(INT_4, hold));
        renrakuhyo.set保険料金額4(get保険料金額(INT_4, hold));
        renrakuhyo.set保険料チェック5(get保険料チェック(INT_5, hold));
        renrakuhyo.set保険料金額5(get保険料金額(INT_5, hold));
        renrakuhyo.set保険料チェック6(get保険料チェック(INT_6, hold));
        renrakuhyo.set保険料金額6(get保険料金額(INT_6, hold));
        renrakuhyo.set保険料チェック7(get保険料チェック(INT_7, hold));
        renrakuhyo.set保険料金額7(get保険料金額(INT_7, hold));
        renrakuhyo.set保険料チェック8(get保険料チェック(INT_8, hold));
        renrakuhyo.set保険料金額8(get保険料金額(INT_8, hold));
        renrakuhyo.set保険料チェック9(get保険料チェック(INT_9, hold));
        renrakuhyo.set保険料金額9(get保険料金額(INT_9, hold));
        renrakuhyo.set保険料チェック10(get保険料チェック(INT_10, hold));
        renrakuhyo.set保険料金額10(get保険料金額(INT_10, hold));
        renrakuhyo.set保険料チェック11(get保険料チェック(INT_11, hold));
        renrakuhyo.set保険料金額11(get保険料金額(INT_11, hold));
        renrakuhyo.set保険料チェックその他(チェックその他(hold));
        renrakuhyo.set保険料金額その他(get金額_5(保険料金額その他(hold)));
        if (is末尾の文字が_0です(1, hold)) {
            renrakuhyo.set保険料段階1(get保険料段階(1, hold));
        } else {
            renrakuhyo.set保険料段階1_上段(get保険料段階(1, hold));
            renrakuhyo.set保険料段階1_下段(get特例表記(1, hold));
        }
        if (is末尾の文字が_0です(2, hold)) {
            renrakuhyo.set保険料段階2(get保険料段階(2, hold));
        } else {
            renrakuhyo.set保険料段階2_上段(get保険料段階(2, hold));
            renrakuhyo.set保険料段階2_下段(get特例表記(2, hold));
        }
        if (is末尾の文字が_0です(INT_3, hold)) {
            renrakuhyo.set保険料段階3(get保険料段階(INT_3, hold));
        } else {
            renrakuhyo.set保険料段階3_上段(get保険料段階(INT_3, hold));
            renrakuhyo.set保険料段階3_下段(get特例表記(INT_3, hold));
        }
        if (is末尾の文字が_0です(INT_4, hold)) {
            renrakuhyo.set保険料段階4(get保険料段階(INT_4, hold));
        } else {
            renrakuhyo.set保険料段階4_上段(get保険料段階(INT_4, hold));
            renrakuhyo.set保険料段階4_下段(get特例表記(INT_4, hold));
        }
        if (is末尾の文字が_0です(INT_5, hold)) {
            renrakuhyo.set保険料段階5(get保険料段階(INT_5, hold));
        } else {
            renrakuhyo.set保険料段階5_上段(get保険料段階(INT_5, hold));
            renrakuhyo.set保険料段階5_下段(get特例表記(INT_5, hold));
        }
        if (is末尾の文字が_0です(INT_6, hold)) {
            renrakuhyo.set保険料段階6(get保険料段階(INT_6, hold));
        } else {
            renrakuhyo.set保険料段階6_上段(get保険料段階(INT_6, hold));
            renrakuhyo.set保険料段階6_下段(get特例表記(INT_6, hold));
        }
        if (is末尾の文字が_0です(INT_7, hold)) {
            renrakuhyo.set保険料段階7(get保険料段階(INT_7, hold));
        } else {
            renrakuhyo.set保険料段階7_上段(get保険料段階(INT_7, hold));
            renrakuhyo.set保険料段階7_下段(get特例表記(INT_7, hold));
        }
        if (is末尾の文字が_0です(INT_8, hold)) {
            renrakuhyo.set保険料段階8(get保険料段階(INT_8, hold));
        } else {
            renrakuhyo.set保険料段階8_上段(get保険料段階(INT_8, hold));
            renrakuhyo.set保険料段階8_下段(get特例表記(INT_8, hold));
        }
        if (is末尾の文字が_0です(INT_9, hold)) {
            renrakuhyo.set保険料段階9(get保険料段階(INT_9, hold));
        } else {
            renrakuhyo.set保険料段階9_上段(get保険料段階(INT_9, hold));
            renrakuhyo.set保険料段階9_下段(get特例表記(INT_9, hold));
        }
        if (is末尾の文字が_0です(INT_10, hold)) {
            renrakuhyo.set保険料段階10(get保険料段階(INT_10, hold));
        } else {
            renrakuhyo.set保険料段階10_上段(get保険料段階(INT_10, hold));
            renrakuhyo.set保険料段階10_下段(get特例表記(INT_10, hold));
        }
        if (is末尾の文字が_0です(INT_11, hold)) {
            renrakuhyo.set保険料段階11(get保険料段階(INT_11, hold));
        } else {
            renrakuhyo.set保険料段階11_上段(get保険料段階(INT_11, hold));
            renrakuhyo.set保険料段階11_下段(get特例表記(INT_11, hold));
        }
        if (is一番最後の末尾の文字が_0です(hold)) {
            renrakuhyo.set保険料段階12(get一番最後の保険料段階(hold));
        } else {
            renrakuhyo.set保険料段階12_上段(get一番最後の保険料段階(hold));
            renrakuhyo.set保険料段階12_下段(get一番最後の特例表記(hold));
        }
        renrakuhyo.set備考(hold.get備考());
        return renrakuhyo;
    }

    private RString チェックその他(KaigoHokenRenrakuhyoHold hold) {
        if (hold.get介護保険料() == null) {
            return RString.EMPTY;
        }
        if (hold.get介護保険料().is介護保険料の記載あり() && !保険料チェックFlg
                && hold.get介護保険料().get保険料段階一覧() != null && !hold.get介護保険料().get保険料段階一覧().isEmpty()
                && INT_12 <= hold.get介護保険料().get保険料段階一覧().size()) {
            return レ;
        }
        return RString.EMPTY;
    }

    private Decimal 保険料金額その他(KaigoHokenRenrakuhyoHold hold) {
        if (hold.get介護保険料() == null) {
            return Decimal.ZERO;
        }
        List<Hokenryo> 保険料段階一覧 = hold.get介護保険料().get保険料段階一覧();
        if (保険料段階一覧 != null && !保険料段階一覧.isEmpty() && !RString.isNullOrEmpty(hold.get介護保険料().get対象者保険料段階区分())) {
            for (Hokenryo hokenryo : 保険料段階一覧) {
                if (!保険料チェックFlg && hold.get介護保険料().get対象者保険料段階区分().equals(hokenryo.get段階区分())) {
                    return hokenryo.get保険料額();
                }
            }
        }
        return Decimal.ZERO;
    }

    private RString getチェック(boolean チェックFlg, RString 保険料段階) {
        return チェックFlg ? 保険料段階 : RString.EMPTY;

    }

    private RString getチェック(boolean チェックFlg) {
        return チェックFlg ? レ : RString.EMPTY;

    }

    private RString get金額_5(RString 金額) {
        if (RString.isNullOrEmpty(金額)) {
            return RString.EMPTY;
        }
        if (金額.contains(",")) {
            金額 = 金額転換(金額.split(","));
        }
        return DecimalFormatter.toRString(new Decimal(金額.toString()), 0);
    }

    private RString 金額転換(List<RString> 金額) {
        RStringBuilder builder = new RStringBuilder();
        for (RString kinkaku : 金額) {
            builder.append(kinkaku);
        }
        return builder.toRString();
    }

    private RString get金額_5(Decimal 金額) {
        return DecimalFormatter.toRString(金額, 0);
    }

    private RString get一番最後の保険料段階(KaigoHokenRenrakuhyoHold hold) {
        if (hold.get介護保険料() == null) {
            return RString.EMPTY;
        }
        List<Hokenryo> hokenryoList = hold.get介護保険料().get保険料段階一覧();
        if (hokenryoList != null && !hokenryoList.isEmpty() && INT_12 <= hokenryoList.size()) {
            return hokenryoList.get(hokenryoList.size() - 1).get保険料段階();
        }
        return RString.EMPTY;
    }

    private RString get一番最後の特例表記(KaigoHokenRenrakuhyoHold hold) {
        if (hold.get介護保険料() == null) {
            return RString.EMPTY;
        }
        List<Hokenryo> hokenryoList = hold.get介護保険料().get保険料段階一覧();
        if (hokenryoList != null && !hokenryoList.isEmpty() && INT_12 <= hokenryoList.size()) {
            return hokenryoList.get(hokenryoList.size() - 1).get特例表記();
        }
        return RString.EMPTY;
    }

    private boolean is一番最後の末尾の文字が_0です(KaigoHokenRenrakuhyoHold hold) {
        if (hold.get介護保険料() == null) {
            return false;
        }
        if (hold.get介護保険料().get保険料段階一覧() != null && !hold.get介護保険料().get保険料段階一覧().isEmpty()) {
            RString 段階区分 = hold.get介護保険料().get保険料段階一覧().get(hold.get介護保険料().get保険料段階一覧().size() - 1).get段階区分();
            if (RString.isNullOrEmpty(段階区分)) {
                return false;
            } else if (1 < 段階区分.length()) {
                return new RString("0").equals(段階区分.substring(段階区分.length() - 1));
            } else {
                return new RString("0").equals(段階区分);
            }
        }
        return false;
    }

    private boolean is末尾の文字が_0です(int i, KaigoHokenRenrakuhyoHold hold) {
        if (hold.get介護保険料() == null) {
            return false;
        }
        if (hold.get介護保険料().get保険料段階一覧() != null && !hold.get介護保険料().get保険料段階一覧().isEmpty()
                && i < hold.get介護保険料().get保険料段階一覧().size()) {
            RString 段階区分 = hold.get介護保険料().get保険料段階一覧().get(i - 1).get段階区分();
            if (RString.isNullOrEmpty(段階区分)) {
                return false;
            } else if (1 < 段階区分.length()) {
                return 段階区分.substring(段階区分.length() - 1).equals(new RString("0"));
            } else {
                return 段階区分.equals(new RString("0"));
            }
        }
        return false;
    }

    private RString get保険料段階(int i, KaigoHokenRenrakuhyoHold hold) {
        if (hold.get介護保険料() == null) {
            return RString.EMPTY;
        }
        if (hold.get介護保険料().get保険料段階一覧() != null && !hold.get介護保険料().get保険料段階一覧().isEmpty()
                && i <= hold.get介護保険料().get保険料段階一覧().size()) {
            return hold.get介護保険料().get保険料段階一覧().get(i - 1).get保険料段階();
        }
        return RString.EMPTY;
    }

    private RString get特例表記(int i, KaigoHokenRenrakuhyoHold hold) {
        if (hold.get介護保険料() == null) {
            return RString.EMPTY;
        }
        if (hold.get介護保険料().get保険料段階一覧() != null && !hold.get介護保険料().get保険料段階一覧().isEmpty()
                && i <= hold.get介護保険料().get保険料段階一覧().size()) {
            return hold.get介護保険料().get保険料段階一覧().get(i - 1).get特例表記();
        }
        return RString.EMPTY;
    }

    private RString get保険料金額(int i, KaigoHokenRenrakuhyoHold hold) {
        RString 保険料額 = RString.EMPTY;
        if (hold.get介護保険料() == null) {
            return 保険料額;
        }
        if (hold.get介護保険料().get保険料段階一覧() != null && !hold.get介護保険料().get保険料段階一覧().isEmpty()
                && i <= hold.get介護保険料().get保険料段階一覧().size()
                && hold.get介護保険料().get保険料段階一覧().get(i - 1).get保険料額() != null) {
            保険料額 = get金額_5(hold.get介護保険料().get保険料段階一覧().get(i - 1).get保険料額());
        }
        return 保険料額;
    }

    private RString get保険料チェック(int i, KaigoHokenRenrakuhyoHold hold) {
        RString 段階区分 = RString.EMPTY;
        if (hold.get介護保険料() == null) {
            return RString.EMPTY;
        }
        if (!hold.get介護保険料().get保険料段階一覧().isEmpty() && i <= hold.get介護保険料().get保険料段階一覧().size()) {
            段階区分 = hold.get介護保険料().get保険料段階一覧().get(i - 1).get段階区分();
        }
        if (hold.get介護保険料().is介護保険料の記載あり() && hold.get介護保険料().get対象者保険料段階区分().compareTo(段階区分) == 0) {
            保険料チェックFlg = true;
            return レ;
        }
        return RString.EMPTY;
    }

    private RString get高額介護金額その他(RString 金額1, RString 金額2, RString 金額3, RString 金額4,
            KaigoHokenRenrakuhyoHold hold) {
        Decimal 対象者自己負担額 = Decimal.ZERO;
        if (hold.get高額介護サービス費支給による自己負担限度額() == null) {
            return RString.EMPTY;
        }
        if (hold.get高額介護サービス費支給による自己負担限度額().get対象者自己負担額() != null) {
            対象者自己負担額 = hold.get高額介護サービス費支給による自己負担限度額().get対象者自己負担額();
        }
        if (toDecimal(金額1).compareTo(対象者自己負担額) != 0 && toDecimal(金額2).compareTo(対象者自己負担額) != 0
                && toDecimal(金額3).compareTo(対象者自己負担額) != 0 && toDecimal(金額4).compareTo(対象者自己負担額) != 0
                && hold.get高額介護サービス費支給による自己負担限度額().is高額介護サービス費の記載あり()) {
            return get金額_5(hold.get高額介護サービス費支給による自己負担限度額().get対象者自己負担額());
        }
        return RString.EMPTY;
    }

    private RString get高額介護チェック(RString 金額, KaigoHokenRenrakuhyoHold hold) {
        Decimal 対象者自己負担額 = Decimal.ZERO;
        if (hold.get高額介護サービス費支給による自己負担限度額() == null) {
            return RString.EMPTY;
        }
        if (hold.get高額介護サービス費支給による自己負担限度額().get対象者自己負担額() != null) {
            対象者自己負担額 = hold.get高額介護サービス費支給による自己負担限度額().get対象者自己負担額();
        }
        if (hold.get高額介護サービス費支給による自己負担限度額().is高額介護サービス費の記載あり()
                && toDecimal(金額).compareTo(対象者自己負担額) == 0) {
            return レ;
        }
        return RString.EMPTY;
    }

    private RString get食費金額その他(RString 食費1, RString 食費2, RString 食費3, RString 食費4, KaigoHokenRenrakuhyoHold hold) {
        Decimal 食費 = Decimal.ZERO;
        if (hold.get食費の_特定_負担限度額() == null) {
            return RString.EMPTY;
        }
        if (hold.get食費の_特定_負担限度額().get対象者食費負担限度額() != null) {
            食費 = hold.get食費の_特定_負担限度額().get対象者食費負担限度額();
        }
        if (toDecimal(食費1).compareTo(食費) != 0 && toDecimal(食費2).compareTo(食費) != 0
                && toDecimal(食費3).compareTo(食費) != 0 && toDecimal(食費4).compareTo(食費) != 0
                && hold.get食費の_特定_負担限度額().is食費の記載あり()) {
            return get金額_5(hold.get食費の_特定_負担限度額().get対象者食費負担限度額());
        }
        return RString.EMPTY;
    }

    private RString get食費チェック(RString 食費1, KaigoHokenRenrakuhyoHold hold) {
        Decimal 食費2 = Decimal.ZERO;
        if (hold.get食費の_特定_負担限度額() == null) {
            return RString.EMPTY;
        }
        if (hold.get食費の_特定_負担限度額().get対象者食費負担限度額() != null) {
            食費2 = hold.get食費の_特定_負担限度額().get対象者食費負担限度額();
        }
        if (hold.get食費の_特定_負担限度額().is食費の記載あり() && toDecimal(食費1).compareTo(食費2) == 0) {
            return レ;
        }
        return RString.EMPTY;
    }

    private boolean is第1段階(Code 利用者負担段階) {
        return RiyoshaFutanDankai.第1段階.getコード().equals(get利用者負担段階(利用者負担段階));
    }

    private boolean is第2段階(Code 利用者負担段階) {
        return RiyoshaFutanDankai.第2段階.getコード().equals(get利用者負担段階(利用者負担段階));
    }

    private boolean is第3段階(Code 利用者負担段階) {
        return RiyoshaFutanDankai.第3段階.getコード().equals(get利用者負担段階(利用者負担段階));
    }

    private boolean is課税層第3段階(Code 利用者負担段階) {
        return RiyoshaFutanDankai.課税層第3段階.getコード().equals(get利用者負担段階(利用者負担段階));
    }

    private RString get利用者負担段階(Code 利用者負担段階) {
        if (利用者負担段階 == null || 利用者負担段階.isEmpty()) {
            return RString.EMPTY;
        }
        return 利用者負担段階.getColumnValue();
    }

    private RString get未認定チェック(Code 要介護認定状態区分コード) {
        if (要介護認定状態区分コード != null && !要介護認定状態区分コード.isEmpty()
                && (YokaigoJotaiKubun09.再調査.getコード().equals(要介護認定状態区分コード.getColumnValue())
                || YokaigoJotaiKubun09.取消.getコード().equals(要介護認定状態区分コード.getColumnValue())
                || YokaigoJotaiKubun09.なし.getコード().equals(要介護認定状態区分コード.getColumnValue()))) {
            return レ;
        }
        return RString.EMPTY;
    }

    private RString get認定非該当チェック(Code 要介護認定状態区分コード) {
        if (要介護認定状態区分コード != null && !要介護認定状態区分コード.isEmpty()
                && YokaigoJotaiKubun09.非該当.getコード().equals(要介護認定状態区分コード.getColumnValue())) {
            return レ;
        }
        return RString.EMPTY;
    }

    private RString get要支援段階(Code 要介護認定状態区分コード) {
        if (要介護認定状態区分コード != null && !要介護認定状態区分コード.isEmpty()) {
            if (YokaigoJotaiKubun09.要支援1.getコード().equals(要介護認定状態区分コード.getColumnValue())) {
                return new RString("1");
            } else if (YokaigoJotaiKubun09.要支援2.getコード().equals(要介護認定状態区分コード.getColumnValue())) {
                return new RString("2");
            }
        }
        return RString.EMPTY;
    }

    private RString get要支援チェック(Code 要介護認定状態区分コード) {
        if (要介護認定状態区分コード != null && !要介護認定状態区分コード.isEmpty()
                && (YokaigoJotaiKubun09.要支援1.getコード().equals(要介護認定状態区分コード.getColumnValue())
                || YokaigoJotaiKubun09.要支援2.getコード().equals(要介護認定状態区分コード.getColumnValue()))) {
            return レ;
        }
        return RString.EMPTY;

    }

    private RString get要介護度段階(Code 要介護認定状態区分コード) {
        if (要介護認定状態区分コード != null && !要介護認定状態区分コード.isEmpty()) {
            if (YokaigoJotaiKubun09.要介護1.getコード().equals(要介護認定状態区分コード.getColumnValue())) {
                return new RString("1");
            } else if (YokaigoJotaiKubun09.要介護2.getコード().equals(要介護認定状態区分コード.getColumnValue())) {
                return new RString("2");
            } else if (YokaigoJotaiKubun09.要介護3.getコード().equals(要介護認定状態区分コード.getColumnValue())) {
                return new RString("3");
            } else if (YokaigoJotaiKubun09.要介護4.getコード().equals(要介護認定状態区分コード.getColumnValue())) {
                return new RString("4");
            } else if (YokaigoJotaiKubun09.要介護5.getコード().equals(要介護認定状態区分コード.getColumnValue())) {
                return new RString("5");
            }
        }
        return RString.EMPTY;
    }

    private RString get要介護チェック(Code 要介護認定状態区分コード) {
        if (要介護認定状態区分コード != null && !要介護認定状態区分コード.isEmpty()
                && (YokaigoJotaiKubun09.要介護1.getコード().equals(要介護認定状態区分コード.getColumnValue())
                || YokaigoJotaiKubun09.要介護2.getコード().equals(要介護認定状態区分コード.getColumnValue())
                || YokaigoJotaiKubun09.要介護3.getコード().equals(要介護認定状態区分コード.getColumnValue())
                || YokaigoJotaiKubun09.要介護4.getコード().equals(要介護認定状態区分コード.getColumnValue())
                || YokaigoJotaiKubun09.要介護5.getコード().equals(要介護認定状態区分コード.getColumnValue()))) {
            return レ;
        }
        return RString.EMPTY;
    }

    private RString get生年月日(IKojin 個人) {
        IDateOfBirth 生年月日 = 個人.get生年月日();
        JuminShubetsu 住民種別 = 個人.get住民種別();
        RString 表示方法 = DbBusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (生年月日 == null) {
            return RString.EMPTY;
        }
        if (JuminShubetsu.外国人.getCode().equals(住民種別.getCode()) && 西暦表示.equals(表示方法)) {
            return getパターン37(生年月日.toFlexibleDate());
        }
        return getパターン12(生年月日.toFlexibleDate());
    }

    private RString get被保険者番号(KaigoHokenRenrakuhyoHold hold) {
        if (hold != null && hold.get被保険者台帳() != null
                && hold.get被保険者台帳().get被保険者番号() != null && !hold.get被保険者台帳().get被保険者番号().isEmpty()) {
            return hold.get被保険者台帳().get被保険者番号().value();
        }
        return RString.EMPTY;
    }

    private RString get市町村コード(KaigoHokenRenrakuhyoHold hold) {
        if (hold != null && hold.get被保険者台帳() != null
                && hold.get被保険者台帳().get市町村コード() != null && hold.get被保険者台帳().get市町村コード().isEmpty()) {
            return hold.get被保険者台帳().get市町村コード().value();
        }
        return RString.EMPTY;
    }

    private RString get氏名フリガナ(AtenaKanaMeisho 氏名フリガナ) {
        if (氏名フリガナ != null && !氏名フリガナ.isEmpty()) {
            return 氏名フリガナ.value();
        }
        return RString.EMPTY;
    }

    private RString get被保険者氏名(AtenaMeisho 被保険者氏名) {
        if (被保険者氏名 != null && !被保険者氏名.isEmpty()) {
            return 被保険者氏名.value();
        }
        return RString.EMPTY;
    }

    private Decimal toDecimal(RString 金額) {
        if (!RString.isNullOrEmpty(金額)) {
            return new Decimal(金額転換(金額.split(",")).toString());
        }
        return Decimal.ZERO;
    }

    private RString getパターン37(FlexibleDate 年月日) {
        return 年月日.seireki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString getパターン12(FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

}
