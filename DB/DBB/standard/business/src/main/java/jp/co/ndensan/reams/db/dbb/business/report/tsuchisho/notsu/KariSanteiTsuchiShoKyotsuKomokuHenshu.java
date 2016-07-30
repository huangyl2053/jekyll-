package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HyojiCodeResearcher;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.KoseiTsukiHantei;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBBCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.editedatesaki.EditedAtesakiBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ue.uex.definition.core.NenkinCode;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaCode;
import jp.co.ndensan.reams.ue.uex.definition.core.UEXCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 賦課帳票共通項目編集（仮算定）のクラスです。
 *
 * @reamsid_L DBB-9030-030 wangxiaodong
 */
public class KariSanteiTsuchiShoKyotsuKomokuHenshu {

    private static final int 期_2 = 2;
    private static final int 期_3 = 3;
    private static final int 期_4 = 4;
    private static final int 期_5 = 5;
    private static final int 期_6 = 6;
    private static final int 期_7 = 7;
    private static final int 期_8 = 8;
    private static final int 期_9 = 9;
    private static final int 期_10 = 10;
    private static final int 期_11 = 11;
    private static final int 期_12 = 12;
    private static final int 期_13 = 13;
    private static final int 期_14 = 14;
    private static final int INDEX_3 = 3;
    private static final RString 普徴メソッド_収入 = new RString("get普徴収入額");
    private static final RString 特徴メソッド_収入 = new RString("get特徴収入額");
    private static final RString 普徴メソッド_賦課 = new RString("get普徴期別金額");
    private static final RString 特徴メソッド_賦課 = new RString("get特徴期別金額");
    private static final RString 徴収_併用 = new RString("併用徴収");
    private static final RString 徴収_普徴 = new RString("普通徴収");
    private static final RString 徴収_特徴 = new RString("特別徴収");
    private static final RString 徴収_なし = new RString("徴収なし");
    private static final RString 随時 = new RString("随時");
    private static final RString 現年随時 = new RString("現年随時");

    /**
     * 仮算定通知書共通情報を作成します。
     *
     * @param 仮算定通知書情報 仮算定通知書情報
     * @return 編集後仮算定通知書共通情報
     */
    public EditedKariSanteiTsuchiShoKyotsu create仮算定通知書共通情報(KariSanteiTsuchiShoKyotsu 仮算定通知書情報) {
        boolean 前年度情報有無 = 仮算定通知書情報.get前年度賦課情報() != null;
        Decimal 前年度最終期普徴期別介護保険料 = Decimal.ZERO;
        if (前年度情報有無) {
            前年度最終期普徴期別介護保険料 = get前年度最終期普徴期別介護保険料(仮算定通知書情報);
        }
        EditedKojin 編集後個人 = new EditedKojin(仮算定通知書情報.get賦課の情報_更正後().get宛名(), 仮算定通知書情報.get帳票制御共通(), null);
        EditedAtesaki 編集後宛先 = EditedAtesakiBuilder.create編集後宛先(仮算定通知書情報.get宛先情報(), 仮算定通知書情報.get地方公共団体(), 仮算定通知書情報.get帳票制御共通());
        EditedKoza 編集後口座 = new EditedKoza(仮算定通知書情報.get口座情報(), 仮算定通知書情報.get帳票制御共通());
        Decimal 普徴納付済額未到来期含まない = get納付済額未到来期含まない(普徴メソッド_収入, 仮算定通知書情報.get普徴納期情報リスト(), 仮算定通知書情報.get収入情報());
        Decimal 特徴納付済額未到来期含まない = get納付済額未到来期含まない(特徴メソッド_収入, 仮算定通知書情報.get特徴納期情報リスト(), 仮算定通知書情報.get収入情報());
        Decimal 普徴納付済額未到来期含む = get納付済額未到来期含む(普徴メソッド_収入, 仮算定通知書情報.get普徴納期情報リスト(), 仮算定通知書情報.get収入情報());
        Decimal 特徴納付済額未到来期含む = get納付済額未到来期含む(特徴メソッド_収入, 仮算定通知書情報.get特徴納期情報リスト(), 仮算定通知書情報.get収入情報());
        Decimal 普徴既に納付すべき額 = 仮算定通知書情報.get賦課の情報_更正前() == null ? Decimal.ZERO
                : get納付額By賦課情報(普徴メソッド_賦課, 仮算定通知書情報.get賦課の情報_更正前().get賦課情報(),
                        1, new KoseiTsukiHantei().find更正月(RDate.getNowDate()).get期AsInt());
        Decimal 普徴今後納付すべき額 = 仮算定通知書情報.get賦課の情報_更正後() == null ? Decimal.ZERO
                : get納付額By賦課情報(普徴メソッド_賦課, 仮算定通知書情報.get賦課の情報_更正後().get賦課情報(),
                        1, new FuchoKiUtil().get期月リスト().get最終法定納期().get期AsInt());
        Decimal 特徴既に納付すべき額 = 仮算定通知書情報.get賦課の情報_更正前() == null ? Decimal.ZERO
                : get納付額By賦課情報(特徴メソッド_賦課, 仮算定通知書情報.get賦課の情報_更正前().get賦課情報(),
                        1, new TokuchoKiUtil().get期月リスト().get月の期(Tsuki.toValue(
                                        new RString(RDate.getNowDate().getMonthValue()).padZeroToLeft(2))).get期AsInt());
        Decimal 更正後特徴期別金額合計 = 仮算定通知書情報.get賦課の情報_更正後() == null ? Decimal.ZERO
                : get納付額By賦課情報(特徴メソッド_賦課, 仮算定通知書情報.get賦課の情報_更正後().get賦課情報(), 1, 期_3);
        Decimal 特徴今後納付すべき額 = 更正後特徴期別金額合計.subtract(特徴既に納付すべき額);
        EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書 = new EditedKariSanteiTsuchiShoKyotsu();
        編集後仮算定通知書.set編集後宛先(編集後宛先);
        編集後仮算定通知書.set編集後個人(編集後個人);
        HyojiCodes 表示コード = get表示コード(仮算定通知書情報);
        編集後仮算定通知書.set表示コード1(表示コード.get表示コード１());
        編集後仮算定通知書.set表示コード１名(表示コード.get表示コード名１());
        編集後仮算定通知書.set表示コード２(表示コード.get表示コード２());
        編集後仮算定通知書.set表示コード２名(表示コード.get表示コード名２());
        編集後仮算定通知書.set表示コード３(表示コード.get表示コード３());
        編集後仮算定通知書.set表示コード３名(表示コード.get表示コード名３());
        if (仮算定通知書情報.get賦課の情報_更正後() == null || 仮算定通知書情報.get賦課の情報_更正後().get賦課情報() == null) {
            編集後仮算定通知書.set被保険者番号(HihokenshaNo.EMPTY);
            編集後仮算定通知書.set識別コード(ShikibetsuCode.EMPTY);
            編集後仮算定通知書.set調定年度(FlexibleYear.EMPTY);
            編集後仮算定通知書.set調定年度_年度あり(RString.EMPTY);
            編集後仮算定通知書.set調定年度_年度なし(RString.EMPTY);
            編集後仮算定通知書.set賦課年度(FlexibleYear.EMPTY);
            編集後仮算定通知書.set賦課年度_年度あり(RString.EMPTY);
            編集後仮算定通知書.set賦課年度_年度なし(RString.EMPTY);
            編集後仮算定通知書.set通知書番号(TsuchishoNo.EMPTY);
            編集後仮算定通知書.set調定事由１(RString.EMPTY);
            編集後仮算定通知書.set調定事由２(RString.EMPTY);
            編集後仮算定通知書.set調定事由３(RString.EMPTY);
            編集後仮算定通知書.set調定事由４(RString.EMPTY);
        } else {
            編集後仮算定通知書.set被保険者番号(仮算定通知書情報.get賦課の情報_更正後().get賦課情報().get被保険者番号());
            編集後仮算定通知書.set識別コード(仮算定通知書情報.get賦課の情報_更正後().get賦課情報().get識別コード());
            編集後仮算定通知書.set調定年度(仮算定通知書情報.get賦課の情報_更正後().get賦課情報().get調定年度());
            編集後仮算定通知書.set調定年度_年度あり(仮算定通知書情報.get賦課の情報_更正後().get賦課情報().get調定年度()
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString());
            編集後仮算定通知書.set調定年度_年度なし(仮算定通知書情報.get賦課の情報_更正後().get賦課情報().get調定年度()
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString());
            編集後仮算定通知書.set賦課年度(仮算定通知書情報.get賦課の情報_更正後().get賦課情報().get賦課年度());
            編集後仮算定通知書.set賦課年度_年度あり(仮算定通知書情報.get賦課の情報_更正後().get賦課情報().get賦課年度()
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString());
            編集後仮算定通知書.set賦課年度_年度なし(仮算定通知書情報.get賦課の情報_更正後().get賦課情報().get賦課年度()
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString());
            編集後仮算定通知書.set通知書番号(仮算定通知書情報.get賦課の情報_更正後().get賦課情報().get通知書番号());
            編集後仮算定通知書.set調定事由１(get調定事由(仮算定通知書情報.get賦課の情報_更正後().get賦課情報().get調定事由1()));
            編集後仮算定通知書.set調定事由２(get調定事由(仮算定通知書情報.get賦課の情報_更正後().get賦課情報().get調定事由2()));
            編集後仮算定通知書.set調定事由３(get調定事由(仮算定通知書情報.get賦課の情報_更正後().get賦課情報().get調定事由3()));
            編集後仮算定通知書.set調定事由４(get調定事由(仮算定通知書情報.get賦課の情報_更正後().get賦課情報().get調定事由4()));
        }
        編集後仮算定通知書.set前年度情報有無(前年度情報有無);
        編集後仮算定通知書.set前年度情報(get前年度情報(仮算定通知書情報.get前年度賦課情報(), 前年度情報有無, 前年度最終期普徴期別介護保険料));
        編集後仮算定通知書.set更正前(get更正前(仮算定通知書情報, 普徴既に納付すべき額, 特徴既に納付すべき額));
        編集後仮算定通知書.set更正後(get更正後(仮算定通知書情報, 普徴今後納付すべき額, 更正後特徴期別金額合計));
        編集後仮算定通知書.set増減額(普徴既に納付すべき額.add(特徴既に納付すべき額).subtract(普徴今後納付すべき額).subtract(更正後特徴期別金額合計));
        編集後仮算定通知書.set納付済額_未到来期含む(普徴納付済額未到来期含む.add(特徴納付済額未到来期含む));
        編集後仮算定通知書.set納付済額_未到来期含まない(普徴納付済額未到来期含まない.add(特徴納付済額未到来期含まない));
        編集後仮算定通知書.set普徴納付済額_未到来期含む(普徴納付済額未到来期含む);
        編集後仮算定通知書.set普徴納付済額_未到来期含まない(普徴納付済額未到来期含まない);
        編集後仮算定通知書.set特徴納付済額_未到来期含む(特徴納付済額未到来期含む);
        編集後仮算定通知書.set特徴納付済額_未到来期含まない(特徴納付済額未到来期含まない);
        編集後仮算定通知書.set納付済額算出年月日(RDate.getNowDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        編集後仮算定通知書.set既に納付すべき額(普徴既に納付すべき額.add(特徴既に納付すべき額));
        編集後仮算定通知書.set今後納付すべき額(普徴今後納付すべき額.add(特徴今後納付すべき額));
        編集後仮算定通知書.set普徴既に納付すべき額(普徴既に納付すべき額);
        編集後仮算定通知書.set特徴既に納付すべき額(特徴既に納付すべき額);
        編集後仮算定通知書.set普徴今後納付すべき額_調定元に(普徴今後納付すべき額.subtract(普徴既に納付すべき額));
        編集後仮算定通知書.set普徴今後納付すべき額_収入元に(普徴今後納付すべき額.subtract(普徴納付済額未到来期含む));
        編集後仮算定通知書.set特徴今後納付すべき額(特徴今後納付すべき額);
        編集後仮算定通知書.set編集後口座(編集後口座);
        編集後仮算定通知書.set特徴納期情報リスト(get特徴納期情報リスト(仮算定通知書情報.get特徴納期情報リスト()));
        編集後仮算定通知書.set普徴納期情報リスト(get普徴納期情報リスト(仮算定通知書情報.get普徴納期情報リスト()));
        編集後仮算定通知書.set保険者名(仮算定通知書情報.get地方公共団体().get市町村名());
        編集後仮算定通知書.set保険者番号(仮算定通知書情報.get地方公共団体().get地方公共団体コード());
        編集後仮算定通知書.set普徴収入情報リスト(get普徴収入情報リスト(仮算定通知書情報.get普徴納期情報リスト(), 仮算定通知書情報.get収入情報()));
        編集後仮算定通知書.set特徴収入情報リスト(get特徴収入情報リスト(仮算定通知書情報.get収入情報()));
        return 編集後仮算定通知書;
    }

    private RString get調定事由(RString 調定事由) {
        if (RString.isNullOrEmpty(調定事由)) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeRyakusho(DBBCodeShubetsu.調定事由.getコード(), new Code(調定事由), FlexibleDate.getNowDate());
    }

    /**
     * 当前の期は随時期かどうか判断します。
     *
     * @param 期月 Kitsuki
     * @return trueの場合、随時です、falseの場合、随時ではありません
     */
    public boolean is随時期(Kitsuki 期月) {
        if (期月 == null || 期月.get月処理区分() == null) {
            return false;
        }
        return 随時.equals(期月.get月処理区分().getName())
                || 現年随時.equals(期月.get月処理区分().getName());
    }

    private HyojiCodes get表示コード(KariSanteiTsuchiShoKyotsu 仮算定通知書情報) {
        IKojin 宛名 = 仮算定通知書情報.get賦課の情報_更正後().get宛名();
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
            if (宛名.get行政区画().getGyoseiku() != null) {
                行政区コード = 宛名.get行政区画().getGyoseiku().getコード().value();
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
        if (仮算定通知書情報.get納組情報() != null && 仮算定通知書情報.get納組情報().getNokumi() != null) {
            納組コード = 仮算定通知書情報.get納組情報().getNokumi().getNokumiCode();
        }
        return new HyojiCodeResearcher().create表示コード情報(仮算定通知書情報.get帳票制御共通().toEntity(),
                町域コード, 行政区コード, 地区コード１, 地区コード２, 地区コード３, 納組コード);
    }

    private EditedKariSanteiTsuchiShoKyotsuBeforeCorrection get更正前(
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報,
            Decimal 更正前普徴期別金額合計,
            Decimal 更正前特徴期別金額合計) {
        EditedKariSanteiTsuchiShoKyotsuBeforeCorrection 更正前 = new EditedKariSanteiTsuchiShoKyotsuBeforeCorrection();
        if (仮算定通知書情報.get賦課の情報_更正前() == null) {
            return 更正前;
        }
        FukaJoho 賦課情報_更正前 = 仮算定通知書情報.get賦課の情報_更正前().get賦課情報();
        更正前.set更正前介護保険料仮徴収額合計(更正前特徴期別金額合計.add(更正前普徴期別金額合計));
        if (賦課情報_更正前 == null) {
            更正前.set更正前介護保険料減免額(Decimal.ZERO);
            更正前.set更正前特徴期別金額01(Decimal.ZERO);
            更正前.set更正前特徴期別金額02(Decimal.ZERO);
            更正前.set更正前特徴期別金額03(Decimal.ZERO);
            更正前.set更正前特徴期別金額合計(Decimal.ZERO);
            更正前.set更正前普徴期別金額合計(Decimal.ZERO);
            更正前.set更正前資格取得日(RString.EMPTY);
            更正前.set更正前資格取得日_西暦(RString.EMPTY);
            更正前.set更正前資格喪失日(RString.EMPTY);
            更正前.set更正前資格喪失日_西暦(RString.EMPTY);
            更正前.set期間_自(RString.EMPTY);
            更正前.set期間_自_西暦(RString.EMPTY);
            更正前.set期間_至(RString.EMPTY);
            更正前.set期間_至__西暦(RString.EMPTY);
            更正前.set保険料段階(RString.EMPTY);
            更正前.set保険料率(RString.EMPTY);
            更正前.set生保開始日(RString.EMPTY);
            更正前.set生保開始日_西暦(RString.EMPTY);
            更正前.set生活保護扶助種類(RString.EMPTY);
        } else {
            set更正前ByIsNotEmpty(更正前, 賦課情報_更正前);
        }
        更正前.set更正前普徴期別金額リスト(get普徴期別金額リストBy賦課情報(仮算定通知書情報.get普徴納期情報リスト(), 賦課情報_更正前));
        更正前.set更正前特別徴収義務者(仮算定通知書情報.get対象者_追加含む_情報_更正前() == null
                || 仮算定通知書情報.get対象者_追加含む_情報_更正前().getDT特別徴収義務者コード() == null ? RString.EMPTY
                : CodeMaster.getCodeMeisho(UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                        仮算定通知書情報.get対象者_追加含む_情報_更正前().getDT特別徴収義務者コード().value(), FlexibleDate.getNowDate()));
        更正前.set更正前特別徴収対象年金(仮算定通知書情報.get徴収方法情報_更正前() == null
                || 仮算定通知書情報.get徴収方法情報_更正前().get仮徴収_年金コード() == null ? RString.EMPTY
                : CodeMaster.getCodeMeisho(UEXCodeShubetsu.年金コード.getCodeShubetsu(),
                        new Code(仮算定通知書情報.get徴収方法情報_更正前().get仮徴収_年金コード().substring(0, INDEX_3)), FlexibleDate.getNowDate()));
        更正前.set更正前特別徴収義務者コード(new NenkinCode(仮算定通知書情報.get対象者_追加含む_情報_更正前() == null ? Code.EMPTY
                : 仮算定通知書情報.get対象者_追加含む_情報_更正前().getDT特別徴収義務者コード().value()));
        更正前.set更正前特別徴収対象年金コード(new TokubetsuChoshuGimushaCode(
                仮算定通知書情報.get徴収方法情報_更正前() == null ? RString.EMPTY : 仮算定通知書情報.get徴収方法情報_更正前().get仮徴収_年金コード()));
        更正前.set更正前徴収方法(get徴収方法(更正前普徴期別金額合計, 更正前特徴期別金額合計));
        return 更正前;
    }

    private void set更正前ByIsNotEmpty(EditedKariSanteiTsuchiShoKyotsuBeforeCorrection 更正前, FukaJoho 賦課情報_更正前) {
        if (賦課情報_更正前 == null) {
            return;
        }
        更正前.set更正前介護保険料減免額(nullToZero(賦課情報_更正前.get減免額()));
        更正前.set更正前特徴期別金額01(nullToZero(賦課情報_更正前.get特徴期別金額01()));
        更正前.set更正前特徴期別金額02(nullToZero(賦課情報_更正前.get特徴期別金額02()));
        更正前.set更正前特徴期別金額03(nullToZero(賦課情報_更正前.get特徴期別金額03()));
        更正前.set更正前特徴期別金額合計(nullToZero(賦課情報_更正前.get特徴期別金額01()).
                add(nullToZero(賦課情報_更正前.get特徴期別金額02())).add(nullToZero(賦課情報_更正前.get特徴期別金額03())));
        更正前.set更正前普徴期別金額合計(get普徴期別金額合計(賦課情報_更正前));
        更正前.set更正前資格取得日(賦課情報_更正前.get資格取得日() == null ? RString.EMPTY
                : 賦課情報_更正前.get資格取得日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        更正前.set更正前資格取得日_西暦(賦課情報_更正前.get資格取得日() == null ? RString.EMPTY
                : 賦課情報_更正前.get資格取得日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        更正前.set更正前資格喪失日(賦課情報_更正前.get資格喪失日() == null ? RString.EMPTY
                : 賦課情報_更正前.get資格喪失日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        更正前.set更正前資格喪失日_西暦(賦課情報_更正前.get資格喪失日() == null ? RString.EMPTY : 賦課情報_更正前.get資格喪失日().seireki()
                .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        更正前.set期間_自(賦課情報_更正前.get月割開始年月1() == null ? RString.EMPTY : new FlexibleDate(
                賦課情報_更正前.get月割開始年月1().getYearValue(), 賦課情報_更正前.get月割開始年月1().getMonthValue(), 1)
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString());
        更正前.set期間_自_西暦(賦課情報_更正前.get月割開始年月1() == null ? RString.EMPTY : new FlexibleDate(
                賦課情報_更正前.get月割開始年月1().getYearValue(), 賦課情報_更正前.get月割開始年月1().getMonthValue(), 1).seireki()
                .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        if (賦課情報_更正前.get月割終了年月2() != null && !賦課情報_更正前.get月割終了年月2().isEmpty()) {
            更正前.set期間_至(new FlexibleDate(賦課情報_更正前.get月割終了年月2().getYearValue(), 賦課情報_更正前.get月割終了年月2()
                    .getMonthValue(), 賦課情報_更正前.get月割終了年月2().getLastDay()).wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        } else if (賦課情報_更正前.get月割終了年月1() != null && !賦課情報_更正前.get月割終了年月1().isEmpty()) {
            更正前.set期間_至(new FlexibleDate(賦課情報_更正前.get月割終了年月1().getYearValue(), 賦課情報_更正前.get月割終了年月1()
                    .getMonthValue(), 賦課情報_更正前.get月割終了年月1().getLastDay()).wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        if (賦課情報_更正前.get月割終了年月2() != null && !賦課情報_更正前.get月割終了年月2().isEmpty()) {
            更正前.set期間_至__西暦(new FlexibleDate(賦課情報_更正前.get月割終了年月2().getYearValue(), 賦課情報_更正前
                    .get月割終了年月2().getMonthValue(), 賦課情報_更正前.get月割終了年月2().getLastDay()).seireki()
                    .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        } else if (賦課情報_更正前.get月割終了年月1() != null && !賦課情報_更正前.get月割終了年月1().isEmpty()) {
            更正前.set期間_至__西暦(new FlexibleDate(賦課情報_更正前.get月割終了年月1().getYearValue(), 賦課情報_更正前
                    .get月割終了年月1().getMonthValue(), 賦課情報_更正前.get月割終了年月1().getLastDay()).seireki()
                    .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        }
        更正前.set保険料段階(!RString.isNullOrEmpty(賦課情報_更正前.get保険料算定段階2())
                ? 賦課情報_更正前.get保険料算定段階2() : 賦課情報_更正前.get保険料算定段階1());
        更正前.set保険料率(get保険料率(賦課情報_更正前));
        更正前.set更正後口座区分(KozaKubun.toValue(賦課情報_更正前.get口座区分()));
        更正前.set生保開始日(賦課情報_更正前.get生保開始日() == null ? RString.EMPTY : 賦課情報_更正前.get生保開始日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        更正前.set生保開始日_西暦(賦課情報_更正前.get生保開始日() == null ? RString.EMPTY : 賦課情報_更正前.get生保開始日().seireki()
                .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        更正前.set生活保護扶助種類(賦課情報_更正前.get生活保護扶助種類());
    }

    private RString get保険料率(FukaJoho 賦課情報) {
        return 賦課情報.get算定年額保険料2() != null ? new RString(賦課情報.get算定年額保険料2().toString())
                : 賦課情報.get算定年額保険料1() != null ? new RString(賦課情報.get算定年額保険料1().toString()) : RString.EMPTY;
    }

    private EditedKariSanteiTsuchiShoKyotsuAfterCorrection get更正後(
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報,
            Decimal 更正後普徴期別金額合計,
            Decimal 更正後特徴期別金額合計) {
        FukaJoho 賦課情報_更正後 = 仮算定通知書情報.get賦課の情報_更正後().get賦課情報();
        EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後 = new EditedKariSanteiTsuchiShoKyotsuAfterCorrection();
        更正後.set更正後介護保険料仮徴収額合計(更正後特徴期別金額合計.add(更正後普徴期別金額合計));
        if (賦課情報_更正後 == null) {
            更正後.set更正後介護保険料減免額(Decimal.ZERO);
            更正後.set更正後特徴期別金額01(Decimal.ZERO);
            更正後.set更正後特徴期別金額02(Decimal.ZERO);
            更正後.set更正後特徴期別金額03(Decimal.ZERO);
            更正後.set更正後特徴期別金額合計(Decimal.ZERO);
            更正後.set更正後普徴第１期金額(Decimal.ZERO);
            更正後.set更正後普徴第２期金額(Decimal.ZERO);
            更正後.set更正後普徴期別金額合計(Decimal.ZERO);
            更正後.set更正後資格取得日(RString.EMPTY);
            更正後.set更正後資格取得日_西暦(RString.EMPTY);
            更正後.set更正後資格喪失日(RString.EMPTY);
            更正後.set更正後資格喪失日_西暦(RString.EMPTY);
            更正後.set期間_自(RString.EMPTY);
            更正後.set期間_自_西暦(RString.EMPTY);
            更正後.set期間_至(RString.EMPTY);
            更正後.set期間_至_西暦(RString.EMPTY);
            更正後.set保険料段階(RString.EMPTY);
            更正後.set保険料率(RString.EMPTY);
            更正後.set生保開始日(RString.EMPTY);
            更正後.set生保開始日_西暦(RString.EMPTY);
            更正後.set生活保護扶助種類(RString.EMPTY);
        } else {
            set更正後ByIsNotEmpty(更正後, 賦課情報_更正後);
        }
        更正後.set更正後普徴期別金額リスト(get普徴期別金額リストBy賦課情報(仮算定通知書情報.get普徴納期情報リスト(), 賦課情報_更正後));
        更正後.set更正後特別徴収義務者(仮算定通知書情報.get対象者_追加含む_情報_更正後() == null
                || 仮算定通知書情報.get対象者_追加含む_情報_更正後().getDT特別徴収義務者コード() == null ? RString.EMPTY
                : CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                        仮算定通知書情報.get対象者_追加含む_情報_更正後().getDT特別徴収義務者コード().value(), FlexibleDate.getNowDate()));
        更正後.set更正後特別徴収対象年金(仮算定通知書情報.get徴収方法情報_更正後() == null
                || 仮算定通知書情報.get徴収方法情報_更正後().get仮徴収_年金コード() == null ? RString.EMPTY
                : CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.年金コード.getCodeShubetsu(),
                        new Code(仮算定通知書情報.get徴収方法情報_更正後().get仮徴収_年金コード().substring(0, INDEX_3)), FlexibleDate.getNowDate()));
        更正後.set更正後特別徴収義務者コード(仮算定通知書情報.get対象者_追加含む_情報_更正後() == null
                || 仮算定通知書情報.get対象者_追加含む_情報_更正後().getDT特別徴収義務者コード() == null ? RString.EMPTY
                : 仮算定通知書情報.get対象者_追加含む_情報_更正後().getDT特別徴収義務者コード().toRString());
        更正後.set更正後特別徴収対象年金コード(仮算定通知書情報.get徴収方法情報_更正後() == null ? RString.EMPTY
                : 仮算定通知書情報.get徴収方法情報_更正後().get仮徴収_年金コード());
        更正後.set更正後徴収方法(get徴収方法(更正後普徴期別金額合計, 更正後特徴期別金額合計));
        return 更正後;
    }

    private void set更正後ByIsNotEmpty(EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後, FukaJoho 賦課情報_更正後) {
        更正後.set更正後介護保険料減免額(nullToZero(賦課情報_更正後.get減免額()));
        更正後.set更正後特徴期別金額01(nullToZero(賦課情報_更正後.get特徴期別金額01()));
        更正後.set更正後特徴期別金額02(nullToZero(賦課情報_更正後.get特徴期別金額02()));
        更正後.set更正後特徴期別金額03(nullToZero(賦課情報_更正後.get特徴期別金額03()));
        更正後.set更正後特徴期別金額合計(nullToZero(賦課情報_更正後.get特徴期別金額01())
                .add(nullToZero(賦課情報_更正後.get特徴期別金額02())).add(nullToZero(賦課情報_更正後.get特徴期別金額03())));
        更正後.set更正後普徴第１期金額(nullToZero(賦課情報_更正後.get特徴期別金額01()));
        更正後.set更正後普徴第２期金額(nullToZero(賦課情報_更正後.get特徴期別金額02()));
        更正後.set更正後普徴期別金額合計(get普徴期別金額合計(賦課情報_更正後));
        更正後.set更正後資格取得日(賦課情報_更正後.get資格取得日() == null ? RString.EMPTY : 賦課情報_更正後.get資格取得日().wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        更正後.set更正後資格取得日_西暦(賦課情報_更正後.get資格取得日() == null ? RString.EMPTY : 賦課情報_更正後.get資格取得日().seireki()
                .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        更正後.set更正後資格喪失日(賦課情報_更正後.get資格喪失日() == null ? RString.EMPTY : 賦課情報_更正後.get資格喪失日().wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        更正後.set更正後資格喪失日_西暦(賦課情報_更正後.get資格喪失日() == null ? RString.EMPTY : 賦課情報_更正後.get資格喪失日().seireki()
                .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        if (賦課情報_更正後.get月割開始年月1() != null && !賦課情報_更正後.get月割開始年月1().isEmpty()) {
            更正後.set期間_自(new FlexibleDate(賦課情報_更正後.get月割開始年月1().getYearValue(), 賦課情報_更正後.get月割終了年月1()
                    .getMonthValue(), 賦課情報_更正後.get月割開始年月1().getLastDay()).wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            更正後.set期間_自_西暦(new FlexibleDate(賦課情報_更正後.get月割開始年月1().getYearValue(), 賦課情報_更正後.get月割開始年月1()
                    .getMonthValue(), 賦課情報_更正後.get月割開始年月1().getLastDay()).seireki()
                    .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        }
        if (賦課情報_更正後.get月割終了年月2() != null && !賦課情報_更正後.get月割終了年月2().isEmpty()) {
            更正後.set期間_至(new FlexibleDate(賦課情報_更正後.get月割終了年月2().getYearValue(), 賦課情報_更正後.get月割終了年月2().getMonthValue(),
                    賦課情報_更正後.get月割終了年月2().getLastDay()).wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            更正後.set期間_至_西暦(new FlexibleDate(賦課情報_更正後.get月割終了年月2().getYearValue(), 賦課情報_更正後.get月割終了年月2().getMonthValue(),
                    賦課情報_更正後.get月割終了年月2().getLastDay()).seireki()
                    .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        } else if (賦課情報_更正後.get月割終了年月1() != null && !賦課情報_更正後.get月割終了年月1().isEmpty()) {
            更正後.set期間_至(new FlexibleDate(賦課情報_更正後.get月割終了年月1().getYearValue(), 賦課情報_更正後.get月割終了年月1().getMonthValue(),
                    賦課情報_更正後.get月割終了年月1().getLastDay()).wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            更正後.set期間_至_西暦(new FlexibleDate(賦課情報_更正後.get月割終了年月1().getYearValue(), 賦課情報_更正後.get月割終了年月1().getMonthValue(),
                    賦課情報_更正後.get月割終了年月1().getLastDay()).seireki()
                    .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        }
        更正後.set保険料段階(!RString.isNullOrEmpty(賦課情報_更正後.get保険料算定段階2())
                ? 賦課情報_更正後.get保険料算定段階2() : 賦課情報_更正後.get保険料算定段階1());
        更正後.set保険料率(get保険料率(賦課情報_更正後));
        更正後.set更正後口座区分(KozaKubun.toValue(賦課情報_更正後.get口座区分()));
        更正後.set生保開始日(賦課情報_更正後.get生保開始日() == null ? RString.EMPTY : 賦課情報_更正後.get生保開始日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        更正後.set生保開始日_西暦(賦課情報_更正後.get生保開始日() == null ? RString.EMPTY : 賦課情報_更正後.get生保開始日().seireki()
                .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        更正後.set生活保護扶助種類(賦課情報_更正後.get生活保護扶助種類());
    }

    private RString get徴収方法(Decimal 普徴期別金額合計, Decimal 特徴期別金額合計) {

        if (Decimal.ZERO.compareTo(特徴期別金額合計) == -1
                && Decimal.ZERO.compareTo(普徴期別金額合計) == -1) {
            return 徴収_併用;
        }
        if (Decimal.ZERO.compareTo(特徴期別金額合計) == 0
                && Decimal.ZERO.compareTo(普徴期別金額合計) == -1) {
            return 徴収_普徴;
        }
        if (Decimal.ZERO.compareTo(特徴期別金額合計) == -1
                && Decimal.ZERO.compareTo(普徴期別金額合計) == 0) {
            return 徴収_特徴;
        }
        if (Decimal.ZERO.compareTo(特徴期別金額合計) == 0
                && Decimal.ZERO.compareTo(普徴期別金額合計) == 0) {
            return 徴収_なし;
        }
        return RString.EMPTY;
    }

    private PrecedingFiscalYearInformation get前年度情報(
            FukaJoho 前年度賦課情報, boolean 前年度情報有無, Decimal 前年度最終期普徴期別介護保険料) {
        if (前年度賦課情報 == null) {
            return new PrecedingFiscalYearInformation();
        }
        PrecedingFiscalYearInformation 前年度情報 = new PrecedingFiscalYearInformation();
        if (前年度情報有無) {
            前年度情報.set前年度賦課年度(前年度賦課情報.get賦課年度().toDateString());
            前年度情報.set前年度保険料段階(!RString.isNullOrEmpty(前年度賦課情報.get保険料算定段階2())
                    ? 前年度賦課情報.get保険料算定段階2() : 前年度賦課情報.get保険料算定段階1());
            前年度情報.set前年度保険料率(前年度賦課情報.get算定年額保険料2() != null
                    ? 前年度賦課情報.get算定年額保険料2() : 前年度賦課情報.get算定年額保険料1());
            前年度情報.set前年度減免前介護保険料_年額(前年度賦課情報.get減免前介護保険料_年額());
            前年度情報.set前年度確定介護保険料_年額(前年度賦課情報.get確定介護保険料_年額());
            前年度情報.set前年度特徴期別金額01(前年度賦課情報.get特徴期別金額01());
            前年度情報.set前年度特徴期別金額02(前年度賦課情報.get特徴期別金額02());
            前年度情報.set前年度特徴期別金額03(前年度賦課情報.get特徴期別金額03());
            前年度情報.set前年度特徴期別金額04(前年度賦課情報.get特徴期別金額04());
            前年度情報.set前年度特徴期別金額05(前年度賦課情報.get特徴期別金額05());
            前年度情報.set前年度最終期普徴期別介護保険料(前年度賦課情報.get特徴期別金額06());
            前年度情報.set前年度最終期特徴期別介護保険料(前年度最終期普徴期別介護保険料);
        } else {
            前年度情報.set前年度賦課年度(RString.EMPTY);
            前年度情報.set前年度保険料段階(RString.EMPTY);
            前年度情報.set前年度保険料率(Decimal.ZERO);
            前年度情報.set前年度減免前介護保険料_年額(Decimal.ZERO);
            前年度情報.set前年度確定介護保険料_年額(Decimal.ZERO);
            前年度情報.set前年度特徴期別金額01(Decimal.ZERO);
            前年度情報.set前年度特徴期別金額02(Decimal.ZERO);
            前年度情報.set前年度特徴期別金額03(Decimal.ZERO);
            前年度情報.set前年度特徴期別金額04(Decimal.ZERO);
            前年度情報.set前年度特徴期別金額05(Decimal.ZERO);
            前年度情報.set前年度特徴期別金額06(Decimal.ZERO);
            前年度情報.set前年度最終期普徴期別介護保険料(Decimal.ZERO);
            前年度情報.set前年度最終期特徴期別介護保険料(Decimal.ZERO);
        }
        return 前年度情報;
    }

    private Decimal get納付済額未到来期含まない(RString 徴収メソッド, List<NokiJoho> 納期情報リスト, ShunyuJoho 収入情報) {
        int 最初期 = 0;
        int 最大期 = 0;
        if (納期情報リスト == null || 納期情報リスト.isEmpty()) {
            return Decimal.ZERO;
        }
        for (int i = 0; i < 納期情報リスト.size(); i++) {
            最初期 = 納期情報リスト.get(0).get納期().get期別();
            if (納期情報リスト.get(i).get納期().get納期開始日().isBeforeOrEquals(RDate.getNowDate())
                    && RDate.getNowDate().isBeforeOrEquals(納期情報リスト.get(i).get納期().get納期終了日())) {
                最大期 = 納期情報リスト.get(i).get納期().get期別();
            }
        }
        if (最初期 != 0 && 最大期 != 0) {
            return get納付額By収入情報(徴収メソッド, 収入情報, 最初期, 最大期);
        }
        return Decimal.ZERO;
    }

    private Decimal get納付済額未到来期含む(RString メソッド_収入, List<NokiJoho> 納期情報リスト, ShunyuJoho 収入情報) {
        if (納期情報リスト != null && !納期情報リスト.isEmpty()) {
            return get納付額By収入情報(メソッド_収入, 収入情報,
                    納期情報リスト.get(0).get期月().get期AsInt(),
                    納期情報リスト.get(納期情報リスト.size() - 1).get期月().get期AsInt());
        }
        return Decimal.ZERO;
    }

    private Decimal get前年度最終期普徴期別介護保険料(KariSanteiTsuchiShoKyotsu 仮算定通知書情報) {
        if (仮算定通知書情報.get前年度賦課情報() == null) {
            return Decimal.ZERO;
        }
        int 期 = new FuchoKiUtil().get期月リスト().get最終法定納期().get期AsInt();
        switch (期) {
            case 1:
                return 仮算定通知書情報.get前年度賦課情報().get普徴期別金額01();
            case 期_2:
                return 仮算定通知書情報.get前年度賦課情報().get普徴期別金額02();
            case 期_3:
                return 仮算定通知書情報.get前年度賦課情報().get普徴期別金額03();
            case 期_4:
                return 仮算定通知書情報.get前年度賦課情報().get普徴期別金額04();
            case 期_5:
                return 仮算定通知書情報.get前年度賦課情報().get普徴期別金額05();
            case 期_6:
                return 仮算定通知書情報.get前年度賦課情報().get普徴期別金額06();
            case 期_7:
                return 仮算定通知書情報.get前年度賦課情報().get普徴期別金額07();
            case 期_8:
                return 仮算定通知書情報.get前年度賦課情報().get普徴期別金額08();
            case 期_9:
                return 仮算定通知書情報.get前年度賦課情報().get普徴期別金額09();
            case 期_10:
                return 仮算定通知書情報.get前年度賦課情報().get普徴期別金額10();
            case 期_11:
                return 仮算定通知書情報.get前年度賦課情報().get普徴期別金額11();
            case 期_12:
                return 仮算定通知書情報.get前年度賦課情報().get普徴期別金額12();
            case 期_13:
                return 仮算定通知書情報.get前年度賦課情報().get普徴期別金額13();
            case 期_14:
                return 仮算定通知書情報.get前年度賦課情報().get普徴期別金額14();
            default:
                return Decimal.ZERO;
        }
    }

    private Decimal get普徴期別金額合計(FukaJoho 賦課情報) {

        return nullToZero(賦課情報.get普徴期別金額01()).add(nullToZero(賦課情報.get普徴期別金額02())).add(nullToZero(賦課情報.get普徴期別金額03()))
                .add(nullToZero(賦課情報.get普徴期別金額04())).add(nullToZero(賦課情報.get普徴期別金額05())).add(nullToZero(賦課情報.get普徴期別金額06()))
                .add(nullToZero(賦課情報.get普徴期別金額07())).add(nullToZero(賦課情報.get普徴期別金額08())).add(nullToZero(賦課情報.get普徴期別金額09()))
                .add(nullToZero(賦課情報.get普徴期別金額09())).add(nullToZero(賦課情報.get普徴期別金額10())).add(nullToZero(賦課情報.get普徴期別金額11()))
                .add(nullToZero(賦課情報.get普徴期別金額12())).add(nullToZero(賦課情報.get普徴期別金額13())).add(nullToZero(賦課情報.get普徴期別金額14()));
    }

    private List<UniversalPhase> get普徴期別金額リストBy賦課情報(List<NokiJoho> 納期情報リスト, FukaJoho 賦課情報) {
        List<UniversalPhase> 期別金額リスト = new ArrayList<>();
        if (納期情報リスト == null || 納期情報リスト.isEmpty()) {
            return 期別金額リスト;
        }
        int 同期 = -1;
        for (NokiJoho nokiJoho : 納期情報リスト) {
            UniversalPhase 期別金額 = new UniversalPhase();
            if (同期 == nokiJoho.get期月().get期AsInt()) {
                continue;
            }
            期別金額.set期(nokiJoho.get期月().get期AsInt());
            期別金額.set金額(get納付額By賦課期(普徴メソッド_賦課, nokiJoho.get期月().get期AsInt(), 賦課情報));
            期別金額リスト.add(期別金額);
            同期 = nokiJoho.get期月().get期AsInt();
        }
        return 期別金額リスト;
    }

    private Decimal get納付額By収入情報(RString メソッド_収入, ShunyuJoho shunyuJoho, int start, int end) {
        Decimal 納付済額 = Decimal.ZERO;
        for (int i = start; i <= end; i++) {
            納付済額 = 納付済額.add(get納付額By収入期(メソッド_収入, i, shunyuJoho));
        }
        return 納付済額;
    }

    private Decimal get納付額By賦課情報(RString メソッド_賦課, FukaJoho 賦課情報, int start, int end) {
        Decimal 納付済額 = Decimal.ZERO;
        for (int i = start; i <= end; i++) {
            納付済額 = 納付済額.add(get納付額By賦課期(メソッド_賦課, i, 賦課情報));
        }
        return 納付済額;
    }

    private List<Kitsuki> get特徴納期情報リスト(List<NokiJoho> 特徴納期情報リスト) {
        List<Kitsuki> 期月 = new ArrayList<>();
        if (特徴納期情報リスト == null || 特徴納期情報リスト.isEmpty()) {
            return 期月;
        }
        for (NokiJoho nokiJoho : 特徴納期情報リスト) {
            期月.add(nokiJoho.get期月());
        }
        return 期月;
    }

    private List<UniversalSignDeliveryInformation> get普徴納期情報リスト(List<NokiJoho> 普徴納期情報リスト) {
        List<UniversalSignDeliveryInformation> 普徴納期 = new ArrayList<>();
        if (普徴納期情報リスト == null || 普徴納期情報リスト.isEmpty()) {
            return 普徴納期;
        }
        for (NokiJoho nokiJoho : 普徴納期情報リスト) {
            UniversalSignDeliveryInformation information = new UniversalSignDeliveryInformation();
            information.set期月(nokiJoho.get期月());
            information.set随時(随時期判断(nokiJoho.get期月()));
            information.set納期開始日(nokiJoho.get納期().get納期開始日().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            information.set納期終了日(nokiJoho.get納期().get納期終了日().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            information.set納期限(nokiJoho.get納期().get納期限().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            information.set現年過年区分(new RString(nokiJoho.get納期().get現年過年区分().toString()));
            information.set通知書発行日(nokiJoho.get納期().get通知書発行日());
            普徴納期.add(information);
        }
        return 普徴納期;
    }

    private List<OrdinaryIncomeInformation> get普徴収入情報リスト(List<NokiJoho> 普徴納期情報リスト, ShunyuJoho shunyuJoho) {
        List<OrdinaryIncomeInformation> 収入情報リスト = new ArrayList<>();
        if (普徴納期情報リスト == null || 普徴納期情報リスト.isEmpty()) {
            return 収入情報リスト;
        }
        int 同期 = -1;
        for (NokiJoho nokiJoho : 普徴納期情報リスト) {
            if (同期 == nokiJoho.get期月().get期AsInt()) {
                continue;
            }
            OrdinaryIncomeInformation 収入情報 = new OrdinaryIncomeInformation();
            収入情報.set期月(nokiJoho.get期月());
            収入情報.set収入額(get納付額By収入期(普徴メソッド_収入, nokiJoho.get期月().get期AsInt(), shunyuJoho));
            収入情報リスト.add(収入情報);
            同期 = nokiJoho.get期月().get期AsInt();
        }
        return 収入情報リスト;
    }

    private Decimal get納付額By収入期(RString メソッド_収入, int 期, ShunyuJoho 収入情報) {
        if (収入情報 == null) {
            return Decimal.ZERO;
        }
        Decimal 納付額 = Decimal.ZERO;
        RStringBuilder sb = new RStringBuilder(メソッド_収入);
        sb.append(new RString(期).padZeroToLeft(2));
        Class clazz = 収入情報.getClass();
        try {
            Method getMethod = clazz.getDeclaredMethod(sb.toString());
            納付額 = nullToZero((Decimal) getMethod.invoke(収入情報));
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(HonSanteiTsuchiShoKyotsuKomokuHenshu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 納付額;
    }

    private Decimal get納付額By賦課期(RString メソッド_賦課, int 期, FukaJoho 賦課情報) {
        if (賦課情報 == null) {
            return Decimal.ZERO;
        }
        Decimal 納付額 = Decimal.ZERO;
        RStringBuilder sb = new RStringBuilder(メソッド_賦課);
        sb.append(new RString(期).padZeroToLeft(2));
        Class clazz = 賦課情報.getClass();
        try {
            Method getMethod = clazz.getDeclaredMethod(sb.toString());
            納付額 = nullToZero((Decimal) getMethod.invoke(賦課情報));
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(HonSanteiTsuchiShoKyotsuKomokuHenshu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 納付額;
    }

    private List<OrdinaryIncomeInformation> get特徴収入情報リスト(ShunyuJoho shunyuJoho) {
        List<OrdinaryIncomeInformation> 収入情報リスト = new ArrayList<>();

        OrdinaryIncomeInformation 収入情報1 = new OrdinaryIncomeInformation();
        収入情報1.set期月(new TokuchoKiUtil().get期月リスト().get期の最初月(1));
        収入情報1.set収入額(shunyuJoho == null ? Decimal.ZERO : shunyuJoho.get特徴収入額01());
        収入情報リスト.add(収入情報1);

        OrdinaryIncomeInformation 収入情報2 = new OrdinaryIncomeInformation();
        収入情報2.set期月(new TokuchoKiUtil().get期月リスト().get期の最初月(期_2));
        収入情報2.set収入額(shunyuJoho == null ? Decimal.ZERO : shunyuJoho.get特徴収入額02());
        収入情報リスト.add(収入情報2);

        OrdinaryIncomeInformation 収入情報3 = new OrdinaryIncomeInformation();
        収入情報3.set期月(new TokuchoKiUtil().get期月リスト().get期の最初月(期_3));
        収入情報3.set収入額(shunyuJoho == null ? Decimal.ZERO : shunyuJoho.get特徴収入額03());
        収入情報リスト.add(収入情報3);

        return 収入情報リスト;
    }

    private RString 随時期判断(Kitsuki 期月) {
        if (期月 == null || 期月.get月処理区分() == null) {
            return RString.EMPTY;
        }
        return 随時.equals(期月.get月処理区分().getName())
                || 現年随時.equals(期月.get月処理区分().getName()) ? 随時 : RString.EMPTY;
    }

    private Decimal nullToZero(Decimal number) {
        if (number == null) {
            return Decimal.ZERO;
        }
        return number;
    }
}
