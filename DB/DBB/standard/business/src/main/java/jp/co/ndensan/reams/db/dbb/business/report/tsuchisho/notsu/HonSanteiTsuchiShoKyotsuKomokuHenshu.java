/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HyojiCodeResearcher;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.KoseiTsukiHantei;
import jp.co.ndensan.reams.db.dbx.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.fucho.FuchokiJohoTsukiShoriKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.editedatesaki.EditedAtesakiBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ue.uex.business.core.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.ue.uex.definition.core.UEXCodeShubetsu;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Month;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 賦課帳票共通項目編集（本算定）クラスです。
 *
 * @reamsid_L DBB-9020-160 sunhaidi
 */
public class HonSanteiTsuchiShoKyotsuKomokuHenshu {

    private static final RString 文字列_第 = new RString("第");
    private static final RString 文字列_段階 = new RString("段階");
    private static final RString 文字列_ケ月 = new RString("ケ月");
    private static final RString 文字列_SP = new RString(" ");
    private static final RString 期_1 = new RString("1");
    private static final RString 期_2 = new RString("2");
    private static final RString 期_3 = new RString("3");
    private static final RString 期_4 = new RString("4");
    private static final RString 期_5 = new RString("5");
    private static final RString 期_6 = new RString("6");
    private static final RString 期_7 = new RString("7");
    private static final RString 期_8 = new RString("8");
    private static final RString 期_9 = new RString("9");
    private static final RString 期_10 = new RString("10");
    private static final RString 期_11 = new RString("11");
    private static final RString 期_12 = new RString("12");
    private static final RString 期_13 = new RString("13");
    private static final RString 期_14 = new RString("14");
    private static final int SIZE_3 = 3;
    private static final int SIZE_6 = 6;
    private static final int SIZE_14 = 14;

    /**
     * 本算定通知書共通情報を作成する。
     *
     * @param 本算定通知書情報 本算定通知書情報
     * @return 編集後本算定通知書共通情報
     */
    public EditedHonSanteiTsuchiShoKyotsu create本算定通知書共通情報(HonSanteiTsuchiShoKyotsu 本算定通知書情報) {

        GennenKanen 現年度_過年度区分 = 本算定通知書情報.get現年度_過年度区分();
        Decimal 普徴納付済額_未到来期含む;
        Decimal 普徴納付済額_未到来期含まない;
        Decimal 特徴納付済額_未到来期含む;
        Decimal 特徴納付済額_未到来期含まない;
        Decimal 納付済額_未到来期含む;
        Decimal 納付済額_未到来期含まない;
        Decimal 未到来期の納付済額;
        Decimal 普徴既に納付すべき額;
        Decimal 普徴今後納付すべき額_調定元に;
        Decimal 普徴今後納付すべき額_収入元に;
        Decimal 特徴既に納付すべき額;
        Decimal 特徴今後納付すべき額;
        Decimal 既に納付すべき額;
        Decimal 今後納付すべき額;
        if (本算定通知書情報.get普徴納期情報リスト() == null) {
            本算定通知書情報.set普徴納期情報リスト(Collections.EMPTY_LIST);
        }
        if (本算定通知書情報.get特徴納期情報リスト() == null) {
            本算定通知書情報.set特徴納期情報リスト(Collections.EMPTY_LIST);
        }
        if (GennenKanen.現年度.equals(現年度_過年度区分)) {
            List<NokiJoho> 普徴納期情報リスト = 本算定通知書情報.get普徴納期情報リスト();
            int 普徴_最初期 = 0;
            int 普徴_納付済期 = 0;
            int 普徴_最大期 = 0;
            if (!普徴納期情報リスト.isEmpty()) {
                普徴_最初期 = 普徴納期情報リスト.get(0).get納期().get期別();
                普徴_最大期 = 普徴納期情報リスト.get(普徴納期情報リスト.size() - 1).get納期().get期別();
            }
            for (NokiJoho nokiJoho : 普徴納期情報リスト) {
                if (nokiJoho.get納期().get納期開始日().isBeforeOrEquals(本算定通知書情報.get発行日())
                        && 本算定通知書情報.get発行日().isBeforeOrEquals(nokiJoho.get納期().get納期終了日())) {
                    普徴_納付済期 = nokiJoho.get納期().get期別();
                }
            }
            普徴納付済額_未到来期含まない = get普徴納付済額(本算定通知書情報.get収入情報(), 普徴_最初期, 普徴_納付済期);
            普徴納付済額_未到来期含む = get普徴納付済額(本算定通知書情報.get収入情報(), 普徴_最初期, 普徴_最大期);
            List<NokiJoho> 特徴納期情報リスト = 本算定通知書情報.get特徴納期情報リスト();
            int 特徴_最初期 = 0;
            int 特徴_納付済期 = 0;
            int 特徴_最大期 = 0;
            if (!特徴納期情報リスト.isEmpty()) {
                特徴_最初期 = 特徴納期情報リスト.get(0).get納期().get期別();
                特徴_最大期 = 特徴納期情報リスト.get(特徴納期情報リスト.size() - 1).get納期().get期別();
            }
            for (NokiJoho nokiJoho : 特徴納期情報リスト) {
                if (nokiJoho.get納期().get納期開始日().isBeforeOrEquals(本算定通知書情報.get発行日())
                        && 本算定通知書情報.get発行日().isBeforeOrEquals(nokiJoho.get納期().get納期終了日())) {
                    特徴_納付済期 = nokiJoho.get納期().get期別();
                }
            }

            特徴納付済額_未到来期含む = get特徴納付済額(本算定通知書情報.get収入情報(), 特徴_最初期, 特徴_納付済期);
            特徴納付済額_未到来期含まない = get特徴納付済額(本算定通知書情報.get収入情報(), 特徴_最初期, 特徴_最大期);
            納付済額_未到来期含む = 普徴納付済額_未到来期含む.add(特徴納付済額_未到来期含む);
            納付済額_未到来期含まない = 普徴納付済額_未到来期含まない.add(特徴納付済額_未到来期含まない);
            未到来期の納付済額 = 納付済額_未到来期含む.subtract(納付済額_未到来期含まない);
            RString 普徴現在期 = new KoseiTsukiHantei().find更正月(本算定通知書情報.get発行日()).get期();
            if (本算定通知書情報.get賦課の情報_更正前() != null) {
                FukaJoho 賦課情報 = 本算定通知書情報.get賦課の情報_更正前().get賦課情報();
                普徴既に納付すべき額 = get普徴納付済額(賦課情報, 1, Integer.parseInt(普徴現在期.toString()));
                RString 普徴最終期 = new FuchoKiUtil().get期月リスト().get最終法定納期().get期();
                Decimal 納付済額 = get普徴納付済額(賦課情報, 1, Integer.parseInt(普徴最終期.toString()));

                普徴今後納付すべき額_調定元に = 納付済額.subtract(普徴既に納付すべき額);
                普徴今後納付すべき額_収入元に = 納付済額.subtract(普徴納付済額_未到来期含む);
                RString 月 = new RString(本算定通知書情報.get発行日().getMonthValue());
                RString 特徴現在期 = new TokuchoKiUtil().get期月リスト().get月の期(Tsuki.toValue(月.padZeroToLeft(2))).get期();
                特徴既に納付すべき額 = get特徴納付済額(賦課情報, 1, Integer.parseInt(特徴現在期.toString()));
                特徴今後納付すべき額 = get特徴納付済額(賦課情報, 1, SIZE_6).subtract(特徴既に納付すべき額);
            } else {
                普徴既に納付すべき額 = Decimal.ZERO;
                普徴今後納付すべき額_調定元に = Decimal.ZERO;
                普徴今後納付すべき額_収入元に = Decimal.ZERO.subtract(普徴納付済額_未到来期含む);
                特徴既に納付すべき額 = Decimal.ZERO;
                特徴今後納付すべき額 = Decimal.ZERO;
            }

            既に納付すべき額 = 普徴既に納付すべき額.add(特徴既に納付すべき額);
            今後納付すべき額 = 普徴今後納付すべき額_調定元に.add(特徴今後納付すべき額);
        } else {
            Decimal 普徴納付済額 = get普徴納付済額(本算定通知書情報.get収入情報(), 1, SIZE_14);
            Decimal 特徴納付済額 = get特徴納付済額(本算定通知書情報.get収入情報(), 1, SIZE_6);
            Decimal 納付済額 = 普徴納付済額.add(特徴納付済額);

            普徴納付済額_未到来期含まない = 普徴納付済額;
            普徴納付済額_未到来期含む = 普徴納付済額;
            特徴納付済額_未到来期含む = 特徴納付済額;
            特徴納付済額_未到来期含まない = 特徴納付済額;
            納付済額_未到来期含む = 納付済額;
            納付済額_未到来期含まない = 納付済額;
            未到来期の納付済額 = Decimal.ZERO;
            普徴既に納付すべき額 = 普徴納付済額;
            普徴今後納付すべき額_調定元に = 普徴既に納付すべき額.subtract(普徴納付済額);
            普徴今後納付すべき額_収入元に = 普徴既に納付すべき額.subtract(普徴納付済額);
            特徴既に納付すべき額 = 特徴納付済額;
            特徴今後納付すべき額 = Decimal.ZERO;
            既に納付すべき額 = 普徴既に納付すべき額.add(特徴既に納付すべき額);
            今後納付すべき額 = 普徴今後納付すべき額_収入元に;
        }

        FukaJoho 賦課情報 = 本算定通知書情報.get賦課の情報_更正後().get賦課情報();
        EditedHonSanteiTsuchiShoKyotsu shoKyotsu = new EditedHonSanteiTsuchiShoKyotsu();
        shoKyotsu.set被保険者番号(賦課情報.get被保険者番号());
        shoKyotsu.set調定年度(賦課情報.get調定年度());
        shoKyotsu.set調定年度_年度あり(賦課情報.get調定年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                fillType(FillType.BLANK).toDateString());
        shoKyotsu.set調定年度_年度なし(賦課情報.get調定年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                fillType(FillType.BLANK).toDateString());
        shoKyotsu.set賦課年度(賦課情報.get賦課年度());
        shoKyotsu.set賦課年度_年度あり(賦課情報.get賦課年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                fillType(FillType.BLANK).toDateString());
        shoKyotsu.set賦課年度_年度なし(賦課情報.get賦課年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                fillType(FillType.BLANK).toDateString());
        shoKyotsu.set識別コード(賦課情報.get識別コード());
        shoKyotsu.set通知書番号(賦課情報.get通知書番号());
        EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正前 = get更正前(本算定通知書情報);
        shoKyotsu.set更正前(更正前);
        EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正後 = get更正後(本算定通知書情報);
        shoKyotsu.set更正後(更正後);
        shoKyotsu.set減免額(賦課情報.get減免額());
        Decimal 確定保険料_年額 = 更正後.get確定保険料_年額();
        if (確定保険料_年額 == null) {
            確定保険料_年額 = Decimal.ZERO;
        }
        shoKyotsu.set増減額(確定保険料_年額.subtract(nullToZero(更正前.get確定保険料_年額())));
        shoKyotsu.set納付済額_未到来期含む(納付済額_未到来期含む);
        shoKyotsu.set納付済額_未到来期含まない(納付済額_未到来期含まない);
        shoKyotsu.set未到来期の納付済額(未到来期の納付済額);
        shoKyotsu.set普徴納付済額_未到来期含む(普徴納付済額_未到来期含む);
        shoKyotsu.set特徴納付済額_未到来期含む(特徴納付済額_未到来期含む);

        shoKyotsu.set普徴納付済額_未到来期含まない(普徴納付済額_未到来期含まない);
        shoKyotsu.set特徴納付済額_未到来期含まない(特徴納付済額_未到来期含まない);
        shoKyotsu.set納付済額算出年月日(本算定通知書情報.get発行日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        shoKyotsu.set既に納付すべき額(既に納付すべき額);
        shoKyotsu.set今後納付すべき額(今後納付すべき額);
        shoKyotsu.set普徴既に納付すべき額(普徴既に納付すべき額);
        shoKyotsu.set特徴既に納付すべき額(特徴既に納付すべき額);
        shoKyotsu.set普徴今後納付すべき額_調定元に(普徴今後納付すべき額_調定元に);
        shoKyotsu.set普徴今後納付すべき額_収入元に(普徴今後納付すべき額_収入元に);
        shoKyotsu.set特徴今後納付すべき額(特徴今後納付すべき額);
        edit編集後本算定通知書共通情報(本算定通知書情報, shoKyotsu);
        return shoKyotsu;
    }

    private void edit編集後本算定通知書共通情報(HonSanteiTsuchiShoKyotsu 本算定通知書情報, EditedHonSanteiTsuchiShoKyotsu shoKyotsu) {
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(本算定通知書情報.get賦課の情報_更正後().get宛名().toEntity());
        EditedKojin editedKojin = new EditedKojin(kojin, 本算定通知書情報.get帳票制御共通(), 本算定通知書情報.get地方公共団体());

        edit表示コード(本算定通知書情報, shoKyotsu);
        EditedAtesaki editedAtesaki = EditedAtesakiBuilder.create編集後宛先(
                本算定通知書情報.get宛先情報(),
                本算定通知書情報.get地方公共団体(),
                本算定通知書情報.get帳票制御共通());
        EditedKoza editedKoza = new EditedKoza(本算定通知書情報.get口座情報(), 本算定通知書情報.get帳票制御共通());
        shoKyotsu.set編集後宛先(editedAtesaki);
        shoKyotsu.set編集後個人(editedKojin);

        shoKyotsu.set編集後口座(editedKoza);
        FukaJoho 賦課情報 = 本算定通知書情報.get賦課の情報_更正後().get賦課情報();
        if (!RString.isNullOrEmpty(賦課情報.get調定事由1())) {
            shoKyotsu.set調定事由１(ChoteiJiyuCode.toValue(賦課情報.get調定事由1()).get名称());
        }
        if (!RString.isNullOrEmpty(賦課情報.get調定事由2())) {
            shoKyotsu.set調定事由２(ChoteiJiyuCode.toValue(賦課情報.get調定事由2()).get名称());
        }
        if (!RString.isNullOrEmpty(賦課情報.get調定事由3())) {
            shoKyotsu.set調定事由３(ChoteiJiyuCode.toValue(賦課情報.get調定事由3()).get名称());
        }
        if (!RString.isNullOrEmpty(賦課情報.get調定事由4())) {
            shoKyotsu.set調定事由４(ChoteiJiyuCode.toValue(賦課情報.get調定事由4()).get名称());
        }
        shoKyotsu.set普徴納期情報リスト(get納期情報リスト(本算定通知書情報.get普徴納期情報リスト()));
        shoKyotsu.set特徴納期情報リスト(get納期情報リスト(本算定通知書情報.get特徴納期情報リスト()));
        shoKyotsu.set普徴期数_現年度(本算定通知書情報.get普徴納期情報リスト().size());
        shoKyotsu.set保険者名(本算定通知書情報.get地方公共団体().get市町村名());
        shoKyotsu.set保険者番号(new HihokenshaNo(本算定通知書情報.get地方公共団体().get地方公共団体コード().value()));
    }

    private void edit表示コード(HonSanteiTsuchiShoKyotsu 本算定通知書情報, EditedHonSanteiTsuchiShoKyotsu shoKyotsu) {
        IShikibetsuTaisho 宛名 = 本算定通知書情報.get賦課の情報_更正後().get宛名();
        RString 町域コード = RString.EMPTY;
        RString 行政区コード = RString.EMPTY;
        RString 地区コード１ = RString.EMPTY;
        RString 地区コード２ = RString.EMPTY;
        RString 地区コード３ = RString.EMPTY;
        RString 納組コード = RString.EMPTY;

        if (宛名.get住所() != null && 宛名.get住所().get町域コード() != null) {
            町域コード = 宛名.get住所().get町域コード().value();
        }
        if (宛名.get行政区画() != null) {
            if (宛名.get行政区画().getChugakkoku() != null) {
                行政区コード = 宛名.get行政区画().getChugakkoku().getコード().value();
            }
            if (宛名.get行政区画().getChiku1() != null) {
                地区コード１ = 宛名.get行政区画().getChiku1().getコード().value();
            }
            if (宛名.get行政区画().getChiku2() != null) {
                地区コード２ = 宛名.get行政区画().getChiku2().getコード().value();
            }
            if (宛名.get行政区画().getChiku3() != null) {
                地区コード３ = 宛名.get行政区画().getChiku3().getコード().value();
            }
        }

        if (本算定通知書情報.get納組情報() != null && 本算定通知書情報.get納組情報().getNokumi() != null) {
            納組コード = 本算定通知書情報.get納組情報().getNokumi().getNokumiCode();
        }

        if (RString.isNullOrEmpty(町域コード) && RString.isNullOrEmpty(行政区コード)
                && RString.isNullOrEmpty(地区コード１)
                && RString.isNullOrEmpty(地区コード２)
                && RString.isNullOrEmpty(地区コード３)
                && RString.isNullOrEmpty(納組コード)) {
            return;
        }
        HyojiCodeResearcher hyojiCodeResearcher = new HyojiCodeResearcher();
        HyojiCodes 表示コード = hyojiCodeResearcher.create表示コード情報(本算定通知書情報.get帳票制御共通().toEntity(),
                宛名.get住所().get町域コード().value(),
                宛名.get行政区画().getChugakkoku().getコード().value(),
                宛名.get行政区画().getChiku1().getコード().value(),
                宛名.get行政区画().getChiku2().getコード().value(),
                宛名.get行政区画().getChiku3().getコード().value(),
                null == 本算定通知書情報.get納組情報() ? new RString("01") : 本算定通知書情報.get納組情報().getNokumi().getNokumiCode());
        shoKyotsu.set表示コード(表示コード);
    }

    private List<AfterEditInformation> get納期情報リスト(List<NokiJoho> 納期情報リスト) {
        List<AfterEditInformation> 普特徴納期情報リスト = new ArrayList<>();
        for (NokiJoho nokiJoho : 納期情報リスト) {
            AfterEditInformation afterEditInformation = new AfterEditInformation();
            afterEditInformation.set期(nokiJoho.get期月().get期().padLeft(文字列_SP, 2));
            afterEditInformation.set月(new RString(nokiJoho.get期月().get月AsInt()).padLeft(文字列_SP, 2));
            if (is随時期(nokiJoho.get期月())) {
                afterEditInformation.set随時(new RString("随時"));
            } else {
                afterEditInformation.set随時(RString.EMPTY);
            }
            afterEditInformation.set納期開始日(isRDateNullOrEmpty(nokiJoho.get納期().get納期開始日()) ? RString.EMPTY
                    : nokiJoho.get納期().get納期開始日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    fillType(FillType.BLANK).toDateString());
            afterEditInformation.set納期開始日_西暦(isRDateNullOrEmpty(nokiJoho.get納期().get納期開始日()) ? RString.EMPTY
                    : nokiJoho.get納期().get納期開始日().seireki().separator(Separator.SLASH).
                    fillType(FillType.BLANK).toDateString());
            afterEditInformation.set納期終了日(isRDateNullOrEmpty(nokiJoho.get納期().get納期終了日()) ? RString.EMPTY
                    : nokiJoho.get納期().get納期終了日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    fillType(FillType.BLANK).toDateString());
            afterEditInformation.set納期終了日_西暦(nokiJoho.get納期().get納期終了日().seireki().separator(Separator.SLASH).
                    fillType(FillType.BLANK).toDateString());
            afterEditInformation.set納期限(isRDateNullOrEmpty(nokiJoho.get納期().get納期限()) ? RString.EMPTY
                    : nokiJoho.get納期().get納期限().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    fillType(FillType.BLANK).toDateString());
            afterEditInformation.set納期限_西暦(isRDateNullOrEmpty(nokiJoho.get納期().get納期開始日()) ? RString.EMPTY
                    : nokiJoho.get納期().get納期限().seireki().separator(Separator.SLASH).
                    fillType(FillType.BLANK).toDateString());
            afterEditInformation.set現年過年区分(nokiJoho.get納期().get現年過年区分());
            afterEditInformation.set通知書発行日(isRDateNullOrEmpty(nokiJoho.get納期().get通知書発行日()) ? RString.EMPTY
                    : nokiJoho.get納期().get通知書発行日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    fillType(FillType.BLANK).toDateString());
            afterEditInformation.set通知書発行日_西暦(isRDateNullOrEmpty(nokiJoho.get納期().get通知書発行日()) ? RString.EMPTY
                    : nokiJoho.get納期().get通知書発行日().seireki().separator(Separator.SLASH).
                    fillType(FillType.BLANK).toDateString());
            普特徴納期情報リスト.add(afterEditInformation);
        }
        return 普特徴納期情報リスト;
    }

    private RString edit段階(RString 段階数) {
        RStringBuilder 表記SB = new RStringBuilder();
        if (!RString.isNullOrEmpty(段階数)) {
            int 段階数値 = Integer.parseInt(段階数.substring(0, 2).toString());
            表記SB.append(文字列_第);
            表記SB.append(段階数値);
            表記SB.append(文字列_段階);
        }
        return 表記SB.toRString();
    }

    private EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection get更正前(HonSanteiTsuchiShoKyotsu 本算定通知書情報) {
        EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正前 = new EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection();
        if (本算定通知書情報.get賦課の情報_更正前() == null) {
            return 更正前;
        }
        FukaJoho 更正前_賦課情報 = 本算定通知書情報.get賦課の情報_更正前().get賦課情報();

        if (更正前_賦課情報.get算定年額保険料2() != null) {
            更正前.set保険料率(更正前_賦課情報.get算定年額保険料2());
        } else {
            更正前.set保険料率(更正前_賦課情報.get算定年額保険料1());
        }
        更正前.set減免前保険料_年額(更正前_賦課情報.get減免前介護保険料_年額());
        更正前.set減免額(更正前_賦課情報.get減免額());
        更正前.set確定保険料_年額(更正前_賦課情報.get確定介護保険料_年額());
        if (!RString.isNullOrEmpty(更正前_賦課情報.get保険料算定段階2())) {
            更正前.set保険料段階(edit段階(更正前_賦課情報.get保険料算定段階2()));
        } else {
            更正前.set保険料段階(edit段階(更正前_賦課情報.get保険料算定段階1()));
        }
        更正前.set保険料算定段階1(edit段階(更正前_賦課情報.get保険料算定段階1()));
        更正前.set算定年額保険料1(更正前_賦課情報.get算定年額保険料1());
        更正前.set月割開始年月1(isYearMonthNullOrEmpty(更正前_賦課情報.get月割開始年月1()) ? RString.EMPTY
                : 更正前_賦課情報.get月割開始年月1().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                fillType(FillType.BLANK).toDateString());
        更正前.set月割開始年月1_西暦(isYearMonthNullOrEmpty(更正前_賦課情報.get月割開始年月1()) ? RString.EMPTY
                : 更正前_賦課情報.get月割開始年月1().seireki().separator(Separator.SLASH).
                fillType(FillType.BLANK).toDateString());
        更正前.set月割終了年月1(isYearMonthNullOrEmpty(更正前_賦課情報.get月割終了年月1()) ? RString.EMPTY
                : 更正前_賦課情報.get月割終了年月1().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                fillType(FillType.BLANK).toDateString());
        更正前.set月割終了年月1_西暦(isYearMonthNullOrEmpty(更正前_賦課情報.get月割終了年月1()) ? RString.EMPTY
                : 更正前_賦課情報.get月割終了年月1().seireki().separator(Separator.SLASH).
                fillType(FillType.BLANK).toDateString());
        更正前.set保険料算定段階2(edit段階(更正前_賦課情報.get保険料算定段階2()));
        更正前.set算定年額保険料2(更正前_賦課情報.get算定年額保険料2());
        更正前.set月割開始年月2(isYearMonthNullOrEmpty(更正前_賦課情報.get月割開始年月2()) ? RString.EMPTY
                : 更正前_賦課情報.get月割開始年月2().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                fillType(FillType.BLANK).toDateString());
        更正前.set月割開始年月2_西暦(isYearMonthNullOrEmpty(更正前_賦課情報.get月割開始年月2()) ? RString.EMPTY
                : 更正前_賦課情報.get月割開始年月2().seireki().separator(Separator.SLASH).
                fillType(FillType.BLANK).toDateString());
        更正前.set月割終了年月2(isYearMonthNullOrEmpty(更正前_賦課情報.get月割終了年月2()) ? RString.EMPTY
                : 更正前_賦課情報.get月割終了年月2().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                fillType(FillType.BLANK).toDateString());
        更正前.set月割終了年月2_西暦(isYearMonthNullOrEmpty(更正前_賦課情報.get月割終了年月2()) ? RString.EMPTY
                : 更正前_賦課情報.get月割終了年月2().seireki().separator(Separator.SLASH).
                fillType(FillType.BLANK).toDateString());
        edit期間_自と期間_至(更正前, 更正前_賦課情報);
        更正前.set市町村民税課税区分_本人(更正前_賦課情報.get課税区分());
        更正前.set市町村民税課税区分_世帯(更正前_賦課情報.get世帯課税区分());
        更正前.set合計所得金額(更正前_賦課情報.get合計所得金額());
        更正前.set公的年金収入額(更正前_賦課情報.get公的年金収入額());
        更正前.set生活保護扶助種類(更正前_賦課情報.get生活保護扶助種類());
        set更正前開始廃止日(更正前, 更正前_賦課情報);
        List<CharacteristicsPhase> 特徴期別金額リスト = new ArrayList<>();
        List<UniversalPhase> 普徴期別金額リスト = new ArrayList<>();
        if (本算定通知書情報.get賦課の情報_更正前() != null) {
            特徴期別金額リスト = get特徴期別金額リスト(本算定通知書情報.get賦課の情報_更正前().get賦課情報());
            更正前.set特徴期別金額リスト(特徴期別金額リスト);
            更正前.set特別徴収額合計(get特徴納付済額(本算定通知書情報.get賦課の情報_更正前().get賦課情報(), 1, SIZE_6));
            普徴期別金額リスト = get普徴期別金額リスト(本算定通知書情報.get賦課の情報_更正前().get賦課情報());
            更正前.set普徴期別金額リスト(普徴期別金額リスト);
            更正前.set特別徴収額合計(get普徴納付済額(本算定通知書情報.get賦課の情報_更正前().get賦課情報(), 1, SIZE_14));
        }
        NenkinTokuchoKaifuJoho 対象者_追加含む_情報_更正前 = 本算定通知書情報.get対象者_追加含む_情報_更正前();
        FlexibleDate 基準日 = FlexibleDate.getNowDate();
        if (対象者_追加含む_情報_更正前 != null && 対象者_追加含む_情報_更正前.getDT特別徴収義務者コード() != null) {
            RString 特別徴収義務者 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    対象者_追加含む_情報_更正前.getDT特別徴収義務者コード().value(), 基準日);
            更正前.set特別徴収義務者(特別徴収義務者);
            更正前.set特別徴収義務者コード(対象者_追加含む_情報_更正前.getDT特別徴収義務者コード().value().value());
        }

        ChoshuHoho 徴収方法情報_更正前 = 本算定通知書情報.get徴収方法情報_更正前();
        RString 年金コード = 徴収方法情報_更正前.get本徴収_年金コード();
        if (!RString.isNullOrEmpty(年金コード) && SIZE_3 < 年金コード.length()) {
            RString 特別徴収対象年金 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.年金コード.getCodeShubetsu(),
                    new Code(年金コード.substring(0, SIZE_3)), 基準日);
            更正前.set特別徴収対象年金(特別徴収対象年金);
        }
        更正前.set特別徴収対象年金コード(年金コード);
        更正前.set口座区分(KozaKubun.toValue(更正前_賦課情報.get口座区分()));
        set徴収方法(特徴期別金額リスト, 普徴期別金額リスト, 更正前);
        return 更正前;
    }

    private void set更正前開始廃止日(EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正前, FukaJoho 更正前_賦課情報) throws IllegalStateException {
        更正前.set生保開始日(isFlexibleDateNullOrEmpty(更正前_賦課情報.get生保開始日()) ? RString.EMPTY
                : 更正前_賦課情報.get生保開始日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        更正前.set生保開始日_西暦(isFlexibleDateNullOrEmpty(更正前_賦課情報.get生保開始日()) ? RString.EMPTY
                : 更正前_賦課情報.get生保開始日().seireki().separator(Separator.SLASH).
                fillType(FillType.BLANK).toDateString());
        更正前.set生保廃止日(isFlexibleDateNullOrEmpty(更正前_賦課情報.get生保廃止日()) ? RString.EMPTY
                : 更正前_賦課情報.get生保廃止日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        更正前.set生保廃止日_西暦(isFlexibleDateNullOrEmpty(更正前_賦課情報.get生保廃止日()) ? RString.EMPTY
                : 更正前_賦課情報.get生保廃止日().seireki().separator(Separator.SLASH).
                fillType(FillType.BLANK).toDateString());

        更正前.set老齢開始日(isFlexibleDateNullOrEmpty(更正前_賦課情報.get老年開始日()) ? RString.EMPTY
                : 更正前_賦課情報.get老年開始日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        更正前.set老齢開始日_西暦(isFlexibleDateNullOrEmpty(更正前_賦課情報.get老年開始日()) ? RString.EMPTY
                : 更正前_賦課情報.get老年開始日().seireki().separator(Separator.SLASH).
                fillType(FillType.BLANK).toDateString());
        更正前.set老齢廃止日(isFlexibleDateNullOrEmpty(更正前_賦課情報.get老年廃止日()) ? RString.EMPTY
                : 更正前_賦課情報.get老年廃止日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        更正前.set老齢廃止日_西暦(isFlexibleDateNullOrEmpty(更正前_賦課情報.get老年廃止日()) ? RString.EMPTY
                : 更正前_賦課情報.get老年廃止日().seireki().separator(Separator.SLASH).
                fillType(FillType.BLANK).toDateString());
    }

    private void set徴収方法(List<CharacteristicsPhase> 特徴期別金額リスト, List<UniversalPhase> 普徴期別金額リスト,
            EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正前) {
        if (特徴期別金額リスト.isEmpty() && !普徴期別金額リスト.isEmpty()) {
            更正前.set徴収方法(new RString("普通徴収"));
        } else if (!特徴期別金額リスト.isEmpty() && 普徴期別金額リスト.isEmpty()) {
            更正前.set徴収方法(new RString("特別徴収"));
        } else if (!特徴期別金額リスト.isEmpty() && !普徴期別金額リスト.isEmpty()) {
            更正前.set徴収方法(new RString("特別徴収　普通徴収"));
        }
    }

    private EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection get更正後(HonSanteiTsuchiShoKyotsu 本算定通知書情報) {
        FukaJoho 更正後_賦課情報 = 本算定通知書情報.get賦課の情報_更正後().get賦課情報();
        EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正後 = new EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection();
        if (更正後_賦課情報.get算定年額保険料2() != null) {
            更正後.set保険料率(更正後_賦課情報.get算定年額保険料2());
        } else {
            更正後.set保険料率(更正後_賦課情報.get算定年額保険料1());
        }
        更正後.set減免前保険料_年額(更正後_賦課情報.get減免前介護保険料_年額());
        更正後.set減免額(更正後_賦課情報.get減免額());
        更正後.set確定保険料_年額(更正後_賦課情報.get確定介護保険料_年額());
        if (!RString.isNullOrEmpty(更正後_賦課情報.get保険料算定段階2())) {
            更正後.set保険料段階(edit段階(更正後_賦課情報.get保険料算定段階2()));
        } else {
            更正後.set保険料段階(edit段階(更正後_賦課情報.get保険料算定段階1()));
        }
        更正後.set保険料算定段階1(edit段階(更正後_賦課情報.get保険料算定段階1()));
        更正後.set算定年額保険料1(更正後_賦課情報.get算定年額保険料1());
        更正後.set月割開始年月1(isYearMonthNullOrEmpty(更正後_賦課情報.get月割開始年月1()) ? RString.EMPTY
                : 更正後_賦課情報.get月割開始年月1().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                fillType(FillType.BLANK).toDateString());
        更正後.set月割開始年月1_西暦(isYearMonthNullOrEmpty(更正後_賦課情報.get月割開始年月1()) ? RString.EMPTY
                : 更正後_賦課情報.get月割開始年月1().seireki().separator(Separator.SLASH).
                fillType(FillType.BLANK).toDateString());
        更正後.set月割終了年月1(isYearMonthNullOrEmpty(更正後_賦課情報.get月割終了年月1()) ? RString.EMPTY
                : 更正後_賦課情報.get月割終了年月1().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                fillType(FillType.BLANK).toDateString());
        更正後.set月割終了年月1_西暦(isYearMonthNullOrEmpty(更正後_賦課情報.get月割終了年月1()) ? RString.EMPTY
                : 更正後_賦課情報.get月割終了年月1().seireki().separator(Separator.SLASH).
                fillType(FillType.BLANK).toDateString());
        更正後.set保険料算定段階2(edit段階(更正後_賦課情報.get保険料算定段階2()));
        更正後.set算定年額保険料2(更正後_賦課情報.get算定年額保険料2());
        更正後.set月割開始年月2(isYearMonthNullOrEmpty(更正後_賦課情報.get月割開始年月2()) ? RString.EMPTY
                : 更正後_賦課情報.get月割開始年月2().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                fillType(FillType.BLANK).toDateString());
        更正後.set月割開始年月2_西暦(isYearMonthNullOrEmpty(更正後_賦課情報.get月割開始年月2()) ? RString.EMPTY
                : 更正後_賦課情報.get月割開始年月2().seireki().separator(Separator.SLASH).
                fillType(FillType.BLANK).toDateString());
        更正後.set月割終了年月2(isYearMonthNullOrEmpty(更正後_賦課情報.get月割終了年月2()) ? RString.EMPTY
                : 更正後_賦課情報.get月割終了年月2().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                fillType(FillType.BLANK).toDateString());
        更正後.set月割終了年月2_西暦(isYearMonthNullOrEmpty(更正後_賦課情報.get月割終了年月2()) ? RString.EMPTY
                : 更正後_賦課情報.get月割終了年月2().seireki().separator(Separator.SLASH).
                fillType(FillType.BLANK).toDateString());
        edit期間_自と期間_至(更正後, 更正後_賦課情報);
        更正後.set市町村民税課税区分_本人(更正後_賦課情報.get課税区分());
        更正後.set市町村民税課税区分_世帯(更正後_賦課情報.get世帯課税区分());
        更正後.set合計所得金額(更正後_賦課情報.get合計所得金額());
        更正後.set公的年金収入額(更正後_賦課情報.get公的年金収入額());
        更正後.set生活保護扶助種類(更正後_賦課情報.get生活保護扶助種類());
        set更正後開始廃止日(更正後, 更正後_賦課情報);
        List<CharacteristicsPhase> 特徴期別金額リスト = get特徴期別金額リスト(本算定通知書情報.get賦課の情報_更正後().get賦課情報());
        更正後.set特徴期別金額リスト(特徴期別金額リスト);
        更正後.set特別徴収額合計(get特徴納付済額(本算定通知書情報.get賦課の情報_更正後().get賦課情報(), 1, SIZE_6));
        List<UniversalPhase> 普徴期別金額リスト = get普徴期別金額リスト(本算定通知書情報.get賦課の情報_更正後().get賦課情報());
        更正後.set普徴期別金額リスト(普徴期別金額リスト);
        更正後.set特別徴収額合計(get普徴納付済額(本算定通知書情報.get賦課の情報_更正後().get賦課情報(), 1, SIZE_14));
        NenkinTokuchoKaifuJoho 対象者_追加含む_情報_更正後 = 本算定通知書情報.get対象者_追加含む_情報_更正後();
        FlexibleDate 基準日 = FlexibleDate.getNowDate();
        if (対象者_追加含む_情報_更正後 != null && 対象者_追加含む_情報_更正後.getDT特別徴収義務者コード() != null) {
            RString 特別徴収義務者 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    対象者_追加含む_情報_更正後.getDT特別徴収義務者コード().value(), 基準日);
            更正後.set特別徴収義務者(特別徴収義務者);
            更正後.set特別徴収義務者コード(対象者_追加含む_情報_更正後.getDT特別徴収義務者コード().value().value());
        }

        ChoshuHoho 徴収方法情報_更正後 = 本算定通知書情報.get徴収方法情報_更正後();
        RString 年金コード = 徴収方法情報_更正後.get本徴収_年金コード();
        if (!RString.isNullOrEmpty(年金コード) && SIZE_3 < 年金コード.length()) {
            RString 特別徴収対象年金 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.年金コード.getCodeShubetsu(),
                    new Code(年金コード.substring(0, SIZE_3)), 基準日);
            更正後.set特別徴収対象年金(特別徴収対象年金);
        }
        更正後.set特別徴収対象年金コード(年金コード);
        更正後.set口座区分(KozaKubun.toValue(更正後_賦課情報.get口座区分()));
        set徴収方法(特徴期別金額リスト, 普徴期別金額リスト, 更正後);
        return 更正後;
    }

    private void set更正後開始廃止日(EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正後, FukaJoho 更正後_賦課情報) throws IllegalStateException {
        更正後.set生保開始日(isFlexibleDateNullOrEmpty(更正後_賦課情報.get生保開始日()) ? RString.EMPTY
                : 更正後_賦課情報.get生保開始日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        更正後.set生保開始日_西暦(isFlexibleDateNullOrEmpty(更正後_賦課情報.get生保開始日()) ? RString.EMPTY
                : 更正後_賦課情報.get生保開始日().seireki().separator(Separator.SLASH).
                fillType(FillType.BLANK).toDateString());
        更正後.set生保廃止日(isFlexibleDateNullOrEmpty(更正後_賦課情報.get生保廃止日()) ? RString.EMPTY
                : 更正後_賦課情報.get生保廃止日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        更正後.set生保廃止日_西暦(isFlexibleDateNullOrEmpty(更正後_賦課情報.get生保廃止日()) ? RString.EMPTY
                : 更正後_賦課情報.get生保廃止日().seireki().separator(Separator.SLASH).
                fillType(FillType.BLANK).toDateString());

        更正後.set老齢開始日(isFlexibleDateNullOrEmpty(更正後_賦課情報.get老年開始日()) ? RString.EMPTY
                : 更正後_賦課情報.get老年開始日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        更正後.set老齢開始日_西暦(isFlexibleDateNullOrEmpty(更正後_賦課情報.get老年開始日()) ? RString.EMPTY
                : 更正後_賦課情報.get老年開始日().seireki().separator(Separator.SLASH).
                fillType(FillType.BLANK).toDateString());
        更正後.set老齢廃止日(isFlexibleDateNullOrEmpty(更正後_賦課情報.get老年廃止日()) ? RString.EMPTY
                : 更正後_賦課情報.get老年廃止日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        更正後.set老齢廃止日_西暦(isFlexibleDateNullOrEmpty(更正後_賦課情報.get老年廃止日()) ? RString.EMPTY
                : 更正後_賦課情報.get老年廃止日().seireki().separator(Separator.SLASH).
                fillType(FillType.BLANK).toDateString());
    }

    private void edit期間_自と期間_至(EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正前, FukaJoho 更正前_賦課情報) {
        FlexibleYearMonth 月割開始年月1 = 更正前_賦課情報.get月割開始年月1();
        FlexibleYearMonth 月割終了年月2 = 更正前_賦課情報.get月割終了年月2();
        FlexibleYearMonth 月割終了年月1 = 更正前_賦課情報.get月割終了年月1();
        FlexibleDate 期間_自 = FlexibleDate.EMPTY;
        FlexibleDate 期間_至 = null;
        if (月割開始年月1 != null && !月割開始年月1.isEmpty()) {
            期間_自 = getFlexibleDate自(月割開始年月1);
            更正前.set期間_自(期間_自.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString());
            更正前.set期間_自_西暦(期間_自.seireki().separator(Separator.SLASH).
                    fillType(FillType.BLANK).toDateString());
        }
        if (月割終了年月1 != null && !月割終了年月1.isEmpty()) {
            期間_至 = getFlexibleDate至(月割終了年月1);
        }
        if (月割終了年月2 != null && !月割終了年月2.isEmpty()) {
            期間_至 = getFlexibleDate至(月割終了年月2);
        }
        if (期間_至 != null) {
            更正前.set期間_至(期間_至.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString());
            更正前.set期間_至_西暦(期間_至.seireki().separator(Separator.SLASH).
                    fillType(FillType.BLANK).toDateString());
        }
        if (期間_至 != null && !期間_自.isEmpty()) {
            int 月数 = 期間_至.getBetweenMonths(期間_自);
            更正前.set月数(月数);
            更正前.set月数_ケ月(get月数_ケ月(月数));
        }
    }

    private List<CharacteristicsPhase> get特徴期別金額リスト(FukaJoho 賦課情報) {
        List<Kibetsu> kibetsuList = 賦課情報.getKibetsuList();
        List<CharacteristicsPhase> 特徴期別金額リスト = new ArrayList<>();
        for (Kibetsu kibetsu : kibetsuList) {
            RString 期 = new RString(kibetsu.get期());
            if (期_1.equals(期)) {
                CharacteristicsPhase characteristicsPhase1 = new CharacteristicsPhase();
                characteristicsPhase1.set期(期_1);
                characteristicsPhase1.set金額(賦課情報.get特徴期別金額01());
                特徴期別金額リスト.add(characteristicsPhase1);
            } else if (期_2.equals(期)) {
                CharacteristicsPhase characteristicsPhase2 = new CharacteristicsPhase();
                characteristicsPhase2.set期(期_2);
                characteristicsPhase2.set金額(賦課情報.get特徴期別金額02());
                特徴期別金額リスト.add(characteristicsPhase2);
            } else if (期_3.equals(期)) {
                CharacteristicsPhase characteristicsPhase3 = new CharacteristicsPhase();
                characteristicsPhase3.set期(期_3);
                characteristicsPhase3.set金額(賦課情報.get特徴期別金額03());
                特徴期別金額リスト.add(characteristicsPhase3);
            } else if (期_4.equals(期)) {
                CharacteristicsPhase characteristicsPhase4 = new CharacteristicsPhase();
                characteristicsPhase4.set期(期_4);
                characteristicsPhase4.set金額(賦課情報.get特徴期別金額04());
                特徴期別金額リスト.add(characteristicsPhase4);
            } else if (期_5.equals(期)) {
                CharacteristicsPhase characteristicsPhase5 = new CharacteristicsPhase();
                characteristicsPhase5.set期(期_5);
                characteristicsPhase5.set金額(賦課情報.get特徴期別金額05());
                特徴期別金額リスト.add(characteristicsPhase5);
            } else if (期_6.equals(期)) {
                CharacteristicsPhase characteristicsPhase6 = new CharacteristicsPhase();
                characteristicsPhase6.set期(期_6);
                characteristicsPhase6.set金額(賦課情報.get特徴期別金額06());
                特徴期別金額リスト.add(characteristicsPhase6);
            }
        }

        return 特徴期別金額リスト;
    }

    private List<UniversalPhase> get普徴期別金額リスト(FukaJoho 賦課情報) {
        List<Kibetsu> kibetsuList = 賦課情報.getKibetsuList();
        List<UniversalPhase> 普徴期別金額リスト = new ArrayList<>();
        for (Kibetsu kibetsu : kibetsuList) {
            RString 期 = new RString(kibetsu.get期());
            if (期_1.equals(期)) {
                UniversalPhase universalPhase1 = new UniversalPhase();
                universalPhase1.set期(Integer.parseInt(期_1.toString()));
                universalPhase1.set金額(賦課情報.get普徴期別金額01());
                普徴期別金額リスト.add(universalPhase1);
            } else if (期_2.equals(期)) {
                UniversalPhase universalPhase2 = new UniversalPhase();
                universalPhase2.set期(Integer.parseInt(期_2.toString()));
                universalPhase2.set金額(賦課情報.get普徴期別金額02());
                普徴期別金額リスト.add(universalPhase2);
            } else if (期_3.equals(期)) {
                UniversalPhase universalPhase3 = new UniversalPhase();
                universalPhase3.set期(Integer.parseInt(期_3.toString()));
                universalPhase3.set金額(賦課情報.get普徴期別金額03());
                普徴期別金額リスト.add(universalPhase3);
            } else if (期_4.equals(期)) {
                UniversalPhase universalPhase4 = new UniversalPhase();
                universalPhase4.set期(Integer.parseInt(期_4.toString()));
                universalPhase4.set金額(賦課情報.get普徴期別金額04());
                普徴期別金額リスト.add(universalPhase4);
            } else if (期_5.equals(期)) {
                UniversalPhase universalPhase5 = new UniversalPhase();
                universalPhase5.set期(Integer.parseInt(期_5.toString()));
                universalPhase5.set金額(賦課情報.get普徴期別金額05());
                普徴期別金額リスト.add(universalPhase5);
            } else if (期_6.equals(期)) {
                UniversalPhase universalPhase6 = new UniversalPhase();
                universalPhase6.set期(Integer.parseInt(期_6.toString()));
                universalPhase6.set金額(賦課情報.get普徴期別金額06());
                普徴期別金額リスト.add(universalPhase6);
            } else if (期_7.equals(期)) {
                UniversalPhase universalPhase7 = new UniversalPhase();
                universalPhase7.set期(Integer.parseInt(期_7.toString()));
                universalPhase7.set金額(賦課情報.get普徴期別金額07());
                普徴期別金額リスト.add(universalPhase7);
            } else if (期_8.equals(期)) {
                UniversalPhase universalPhase8 = new UniversalPhase();
                universalPhase8.set期(Integer.parseInt(期_8.toString()));
                universalPhase8.set金額(賦課情報.get普徴期別金額08());
                普徴期別金額リスト.add(universalPhase8);
            } else if (期_9.equals(期)) {
                UniversalPhase universalPhase9 = new UniversalPhase();
                universalPhase9.set期(Integer.parseInt(期_9.toString()));
                universalPhase9.set金額(賦課情報.get普徴期別金額09());
                普徴期別金額リスト.add(universalPhase9);
            } else if (期_10.equals(期)) {
                UniversalPhase universalPhase10 = new UniversalPhase();
                universalPhase10.set期(Integer.parseInt(期_10.toString()));
                universalPhase10.set金額(賦課情報.get普徴期別金額10());
                普徴期別金額リスト.add(universalPhase10);
            } else if (期_11.equals(期)) {
                UniversalPhase universalPhase11 = new UniversalPhase();
                universalPhase11.set期(Integer.parseInt(期_11.toString()));
                universalPhase11.set金額(賦課情報.get普徴期別金額11());
                普徴期別金額リスト.add(universalPhase11);
            } else if (期_12.equals(期)) {
                UniversalPhase universalPhase12 = new UniversalPhase();
                universalPhase12.set期(Integer.parseInt(期_12.toString()));
                universalPhase12.set金額(賦課情報.get普徴期別金額12());
                普徴期別金額リスト.add(universalPhase12);
            } else if (期_13.equals(期)) {
                UniversalPhase universalPhase13 = new UniversalPhase();
                universalPhase13.set期(Integer.parseInt(期_13.toString()));
                universalPhase13.set金額(賦課情報.get普徴期別金額13());
                普徴期別金額リスト.add(universalPhase13);
            } else if (期_14.equals(期)) {
                UniversalPhase universalPhase14 = new UniversalPhase();
                universalPhase14.set期(Integer.parseInt(期_14.toString()));
                universalPhase14.set金額(賦課情報.get普徴期別金額14());
                普徴期別金額リスト.add(universalPhase14);
            }
        }

        return 普徴期別金額リスト;
    }

    private RString get月数_ケ月(int 月数) {
        RStringBuilder 月数SB = new RStringBuilder(RStringUtil.convert半角to全角(new RString(月数).padZeroToLeft(2)));
        月数SB.append(文字列_ケ月);
        return 月数SB.toRString();
    }

    private FlexibleDate getFlexibleDate自(FlexibleYearMonth 年月) {
        RStringBuilder 年月SB = new RStringBuilder(年月.toDateString());
        年月SB.append("01");
        return new FlexibleDate(年月SB.toRString());
    }

    private FlexibleDate getFlexibleDate至(FlexibleYearMonth 年月) {
        RStringBuilder 年月SB = new RStringBuilder(年月.toDateString());
        年月SB.append(年月.getLastDay());
        return new FlexibleDate(年月SB.toRString());
    }

    private Decimal get普徴納付済額(FukaJoho fukaJoho, int start, int end) {
        Decimal 普徴納付済額 = Decimal.ZERO;
        if (fukaJoho == null) {
            return 普徴納付済額;
        }
        for (int i = start; i <= end; i++) {
            RStringBuilder sb = new RStringBuilder("get普徴期別金額");
            sb.append(new RString(i).padZeroToLeft(2));
            Class clazz = fukaJoho.getClass();
            try {
                Method getMethod = clazz.getDeclaredMethod(sb.toString());
                普徴納付済額.add(nullToZero((Decimal) getMethod.invoke(fukaJoho)));
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                Logger.getLogger(HonSanteiTsuchiShoKyotsuKomokuHenshu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return 普徴納付済額;
    }

    private Decimal get特徴納付済額(FukaJoho fukaJoho, int start, int end) {
        Decimal 特徴納付済額 = Decimal.ZERO;
        if (fukaJoho == null) {
            return 特徴納付済額;
        }
        for (int i = start; i <= end; i++) {
            RStringBuilder sb = new RStringBuilder("get特徴期別金額");
            sb.append(new RString(i).padZeroToLeft(2));
            Class clazz = fukaJoho.getClass();
            try {
                Method getMethod = clazz.getDeclaredMethod(sb.toString());
                特徴納付済額.add(nullToZero((Decimal) getMethod.invoke(fukaJoho)));
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                Logger.getLogger(HonSanteiTsuchiShoKyotsuKomokuHenshu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return 特徴納付済額;
    }

    private Decimal nullToZero(Decimal number) {
        if (number == null) {
            return Decimal.ZERO;
        }
        return number;
    }

    private Decimal get普徴納付済額(ShunyuJoho shunyuJoho, int start, int end) {
        Decimal 普徴納付済額 = Decimal.ZERO;
        if (shunyuJoho == null) {
            return 普徴納付済額;
        }

        for (int i = start; i <= end; i++) {
            RStringBuilder sb = new RStringBuilder("get普徴収入額");
            sb.append(new RString(i).padZeroToLeft(2));
            Class clazz = shunyuJoho.getClass();
            try {
                Method getMethod = clazz.getDeclaredMethod(sb.toString());
                普徴納付済額.add(nullToZero((Decimal) getMethod.invoke(shunyuJoho)));
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                Logger.getLogger(HonSanteiTsuchiShoKyotsuKomokuHenshu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return 普徴納付済額;
    }

    private Decimal get特徴納付済額(ShunyuJoho shunyuJoho, int start, int end) {
        Decimal 特徴納付済額 = Decimal.ZERO;
        if (shunyuJoho == null) {
            return 特徴納付済額;
        }
        for (int i = start; i <= end; i++) {
            RStringBuilder sb = new RStringBuilder("get特徴収入額");
            sb.append(new RString(i).padZeroToLeft(2));
            Class clazz = shunyuJoho.getClass();
            try {
                Method getMethod = clazz.getDeclaredMethod(sb.toString());
                特徴納付済額.add(nullToZero((Decimal) getMethod.invoke(shunyuJoho)));
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                Logger.getLogger(HonSanteiTsuchiShoKyotsuKomokuHenshu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return 特徴納付済額;
    }

    /**
     * 本算定決定通知書共通情報を作成します。
     *
     * @param 本算定通知書情報 本算定通知書情報
     * @return 本算定決定通知書情報
     */
    public HonSanteiKetteiTsuchiShoJoho create本算定決定通知書情報作成(HonSanteiTsuchiShoKyotsu 本算定通知書情報) {
        HonSanteiKetteiTsuchiShoJoho honSanteiKetteiTsuchiShoJoho = new HonSanteiKetteiTsuchiShoJoho();
        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = create本算定通知書共通情報(本算定通知書情報);
        honSanteiKetteiTsuchiShoJoho.set現年度_過年度区分(本算定通知書情報.get現年度_過年度区分());
        honSanteiKetteiTsuchiShoJoho.set発行日(本算定通知書情報.get発行日());
        honSanteiKetteiTsuchiShoJoho.set帳票分類ID(本算定通知書情報.get帳票分類ID());
        honSanteiKetteiTsuchiShoJoho.set帳票ID(本算定通知書情報.get帳票ID());
        honSanteiKetteiTsuchiShoJoho.set処理区分(本算定通知書情報.get処理区分());
        honSanteiKetteiTsuchiShoJoho.set地方公共団体(本算定通知書情報.get地方公共団体());
        honSanteiKetteiTsuchiShoJoho.set編集後本算定通知書共通情報(編集後本算定通知書共通情報);
        return honSanteiKetteiTsuchiShoJoho;
    }

    /**
     * 普徴期リストを作成します。
     *
     * @return 普徴期リスト
     */
    public List<RString> create普徴期リスト() {
        List<RString> 普徴期リスト = new ArrayList<>();
        List<Kitsuki> kitsukiList = new FuchoKiUtil().get期月リスト().toList();
        for (Kitsuki kitsuki : kitsukiList) {
            普徴期リスト.add(kitsuki.get期());
        }
        return 普徴期リスト;
    }

    /**
     * 普徴月リストを作成します。
     *
     * @param 普徴期リスト 普徴期リスト
     * @return 普徴月リスト
     */
    public List<Tsuki> create普徴月リスト(List<RString> 普徴期リスト) {
        List<Tsuki> tsukiList = new ArrayList<>();
        KitsukiList kitsukiList = new FuchoKiUtil().get期月リスト();
        for (RString 普徴期 : 普徴期リスト) {
            List<Kitsuki> kitsukiのlist = kitsukiList.get期の月(Integer.parseInt(String.valueOf(普徴期)));
            if (!kitsukiのlist.isEmpty()) {
                tsukiList.add(kitsukiのlist.get(0).get月());
            }
        }
        return tsukiList;
    }

    /**
     * 特徴期リストを作成します。
     *
     * @return 特徴期リスト
     */
    public List<RString> create特徴期リスト() {
        List<RString> 特徴期リスト = new ArrayList<>();
        List<Kitsuki> kitsukiList = new TokuchoKiUtil().get期月リスト().toList();
        for (Kitsuki kitsuki : kitsukiList) {
            特徴期リスト.add(kitsuki.get期());
        }
        return 特徴期リスト;
    }

    /**
     * 特徴月リストを作成します。
     *
     * @param 特徴期リスト 特徴期リスト
     * @return 特徴月リスト
     */
    public List<Tsuki> create特徴月リスト(List<RString> 特徴期リスト) {
        List<Tsuki> tsukiList = new ArrayList<>();
        KitsukiList kitsukiList = new FuchoKiUtil().get期月リスト();
        for (RString 特徴期 : 特徴期リスト) {
            List<Kitsuki> kitsukiのlist = kitsukiList.get期の月(Integer.parseInt(String.valueOf(特徴期)));
            if (!kitsukiのlist.isEmpty()) {
                tsukiList.add(kitsukiのlist.get(0).get月());
            }
        }
        return tsukiList;
    }

    /**
     * 所得段階区分リストを作成します。
     *
     * @param shoKyotsu 編集後本算定通知書共通情報
     * @return 所得段階区分リスト
     */
    public List<DankaiKubun> create所得段階区分リスト(EditedHonSanteiTsuchiShoKyotsu shoKyotsu) {
        List<DankaiKubun> dankaiKubunList = createDankaiKubunList();
        edit所得段階区分リスト(shoKyotsu.get更正前(), dankaiKubunList, true);
        edit所得段階区分リスト(shoKyotsu.get更正後(), dankaiKubunList, false);
        return dankaiKubunList;
    }

    private void edit所得段階区分リスト(EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 共通情報, List<DankaiKubun> dankaiKubunList, boolean 更正前) {
        int 月割開始年月1 = RString.isNullOrEmpty(共通情報.get月割開始年月1_西暦()) ? 0
                : new FlexibleDate(共通情報.get月割開始年月1_西暦()).getMonthValue();
        int 月割終了年月1 = RString.isNullOrEmpty(共通情報.get月割終了年月1_西暦()) ? 0
                : new FlexibleDate(共通情報.get月割終了年月1_西暦()).getMonthValue();
        int 月割開始年月2 = 0;
        int 月割終了年月2 = 0;
        boolean 月割終了年月 = false;
        if (!RString.isNullOrEmpty(共通情報.get月割開始年月2_西暦()) && !RString.isNullOrEmpty(共通情報.get月割終了年月2_西暦())) {
            月割開始年月2 = new FlexibleDate(共通情報.get月割開始年月2_西暦()).getMonthValue();
            月割終了年月2 = new FlexibleDate(共通情報.get月割終了年月2_西暦()).getMonthValue();
            月割終了年月 = true;
        }

        for (DankaiKubun dankaiKubun : dankaiKubunList) {
            if (更正前) {
                editDankaiKubunKosinZen(dankaiKubun, 月割開始年月1, 月割終了年月1, 共通情報.get保険料算定段階1());
                if (月割終了年月) {
                    editDankaiKubunKosinZen(dankaiKubun, 月割開始年月2, 月割終了年月2, 共通情報.get保険料算定段階2());
                }
            } else {
                editDankaiKubunKosinGo(dankaiKubun, 月割開始年月1, 月割終了年月1, 共通情報.get保険料算定段階1());
                if (月割終了年月) {
                    editDankaiKubunKosinGo(dankaiKubun, 月割開始年月2, 月割終了年月2, 共通情報.get保険料算定段階2());
                }
            }
        }
    }

    private void editDankaiKubunKosinZen(DankaiKubun dankaiKubun,
            int 月割開始年月1,
            int 月割終了年月1,
            RString 保険料算定段階1) {
        int 月 = Integer.parseInt(dankaiKubun.get月().getコード().toString());
        if ((Month.MARCH.getValue() < 月割開始年月1 && Month.MARCH.getValue() < 月割終了年月1)
                || (月割開始年月1 <= Month.MARCH.getValue() && 月割終了年月1 <= Month.MARCH.getValue())) {
            if (月割開始年月1 <= 月 && 月 <= 月割終了年月1) {
                dankaiKubun.set更正前所得段階(保険料算定段階1);
            }
        } else {
            if ((月割開始年月1 < 月 && 月 <= Month.DECEMBER.getValue())
                    || (1 <= 月 && 月 <= 月割終了年月1)) {
                dankaiKubun.set更正前所得段階(保険料算定段階1);
            }
        }
    }

    private void editDankaiKubunKosinGo(DankaiKubun dankaiKubun,
            int 月割開始年月1,
            int 月割終了年月1,
            RString 保険料算定段階1) {
        int 月 = Integer.parseInt(dankaiKubun.get月().getコード().toString());
        if ((Month.MARCH.getValue() < 月割開始年月1 && Month.MARCH.getValue() < 月割終了年月1)
                || (月割開始年月1 <= Month.MARCH.getValue() && 月割終了年月1 <= Month.MARCH.getValue())) {
            if (月割開始年月1 <= 月 && 月 <= 月割終了年月1) {
                dankaiKubun.set更正後所得段階(保険料算定段階1);
            }
        } else {
            if ((月割開始年月1 < 月 && 月 <= Month.DECEMBER.getValue())
                    || (1 <= 月 && 月 <= 月割終了年月1)) {
                dankaiKubun.set更正後所得段階(保険料算定段階1);
            }
        }
    }

    private List<DankaiKubun> createDankaiKubunList() {
        List<DankaiKubun> dankaiKubunList = new ArrayList<>();
        DankaiKubun dankaiKubun4 = new DankaiKubun();
        dankaiKubun4.set月(Tsuki._4月);
        dankaiKubun4.set更正前所得段階(RString.EMPTY);
        dankaiKubun4.set更正後所得段階(RString.EMPTY);
        dankaiKubunList.add(dankaiKubun4);
        DankaiKubun dankaiKubun5 = new DankaiKubun();
        dankaiKubun5.set月(Tsuki._5月);
        dankaiKubun5.set更正前所得段階(RString.EMPTY);
        dankaiKubun5.set更正後所得段階(RString.EMPTY);
        dankaiKubunList.add(dankaiKubun5);
        DankaiKubun dankaiKubun6 = new DankaiKubun();
        dankaiKubun6.set月(Tsuki._6月);
        dankaiKubun6.set更正前所得段階(RString.EMPTY);
        dankaiKubun6.set更正後所得段階(RString.EMPTY);
        dankaiKubunList.add(dankaiKubun6);
        DankaiKubun dankaiKubun7 = new DankaiKubun();
        dankaiKubun7.set月(Tsuki._7月);
        dankaiKubun7.set更正前所得段階(RString.EMPTY);
        dankaiKubun7.set更正後所得段階(RString.EMPTY);
        dankaiKubunList.add(dankaiKubun7);
        DankaiKubun dankaiKubun8 = new DankaiKubun();
        dankaiKubun8.set月(Tsuki._8月);
        dankaiKubun8.set更正前所得段階(RString.EMPTY);
        dankaiKubun8.set更正後所得段階(RString.EMPTY);
        dankaiKubunList.add(dankaiKubun8);
        DankaiKubun dankaiKubun9 = new DankaiKubun();
        dankaiKubun9.set月(Tsuki._9月);
        dankaiKubun9.set更正前所得段階(RString.EMPTY);
        dankaiKubun9.set更正後所得段階(RString.EMPTY);
        dankaiKubunList.add(dankaiKubun9);
        DankaiKubun dankaiKubun10 = new DankaiKubun();
        dankaiKubun10.set月(Tsuki._10月);
        dankaiKubun10.set更正前所得段階(RString.EMPTY);
        dankaiKubun10.set更正後所得段階(RString.EMPTY);
        dankaiKubunList.add(dankaiKubun10);
        DankaiKubun dankaiKubun11 = new DankaiKubun();
        dankaiKubun11.set月(Tsuki._11月);
        dankaiKubun11.set更正前所得段階(RString.EMPTY);
        dankaiKubun11.set更正後所得段階(RString.EMPTY);
        dankaiKubunList.add(dankaiKubun11);
        DankaiKubun dankaiKubun12 = new DankaiKubun();
        dankaiKubun12.set月(Tsuki._12月);
        dankaiKubun12.set更正前所得段階(RString.EMPTY);
        dankaiKubun12.set更正後所得段階(RString.EMPTY);
        dankaiKubunList.add(dankaiKubun12);
        DankaiKubun dankaiKubun1 = new DankaiKubun();
        dankaiKubun1.set月(Tsuki._1月);
        dankaiKubun1.set更正前所得段階(RString.EMPTY);
        dankaiKubun1.set更正後所得段階(RString.EMPTY);
        dankaiKubunList.add(dankaiKubun1);
        DankaiKubun dankaiKubun2 = new DankaiKubun();
        dankaiKubun2.set月(Tsuki._2月);
        dankaiKubun2.set更正前所得段階(RString.EMPTY);
        dankaiKubun2.set更正後所得段階(RString.EMPTY);
        dankaiKubunList.add(dankaiKubun2);
        DankaiKubun dankaiKubun3 = new DankaiKubun();
        dankaiKubun3.set月(Tsuki._3月);
        dankaiKubun3.set更正前所得段階(RString.EMPTY);
        dankaiKubun3.set更正後所得段階(RString.EMPTY);
        dankaiKubunList.add(dankaiKubun3);
        return dankaiKubunList;
    }

    /**
     * 当前の期は随時期かどうか判断します。
     *
     * @param kitsuki 期月
     * @return 判断結果(trueの場合、随時です。falseの場合、随時ではありません)
     */
    public boolean is随時期(Kitsuki kitsuki) {
        return (FuchokiJohoTsukiShoriKubun.随時.equals(kitsuki.get月処理区分())
                || FuchokiJohoTsukiShoriKubun.現年随時.equals(kitsuki.get月処理区分()));
    }

    private boolean isYearMonthNullOrEmpty(FlexibleYearMonth data) {
        return data == null || RString.EMPTY.equals(data.toDateString());
    }

    private boolean isRDateNullOrEmpty(RDate data) {
        return data == null || RString.EMPTY.equals(data.toDateString());
    }

    private boolean isFlexibleDateNullOrEmpty(FlexibleDate data) {
        return data == null || RString.EMPTY.equals(new RString(data.toString()));
    }
}
