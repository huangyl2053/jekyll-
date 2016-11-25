/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fukadaichodatahenshu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.fukaatena.FukaAtena;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.FutsuChoshuKi;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.FutsuChoshuTsuki;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.FutsuChoshuZuiji;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.SetaInJoho;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.TokubetsuChoshuKi;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.TokubetsuChoshuTsuki;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HenkoJiyu;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.fucho.FuchokiJohoTsukiShoriKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 賦課台帳データ編集クラスです。
 *
 * @reamsid_L DBB-9100-010 xicongwang
 */
public class FukaDaichoDataHenshuFath {

    private static final int INTNUMBER_1 = 1;
    private static final int INTNUMBER_2 = 2;
    private static final int INTNUMBER_3 = 3;
    private static final int INTNUMBER_4 = 4;
    private static final int INTNUMBER_5 = 5;
    private static final int INTNUMBER_6 = 6;
    private static final int INTNUMBER_7 = 7;
    private static final int INTNUMBER_8 = 8;
    private static final int INTNUMBER_9 = 9;
    private static final int INTNUMBER_10 = 10;
    private static final int INTNUMBER_11 = 11;
    private static final int INTNUMBER_12 = 12;
    private static final int INTNUMBER_13 = 13;
    private static final int INTNUMBER_14 = 14;
    private static final RString 定値期_1 = new RString("1");
    private static final RString 定値期_2 = new RString("2");
    private static final RString 定値期_3 = new RString("3");
    private static final RString 定値期_4 = new RString("4");
    private static final RString 定値期_5 = new RString("5");
    private static final RString 定値期_6 = new RString("6");
    private static final RString 定値期_7 = new RString("7");
    private static final RString 定値期_8 = new RString("8");
    private static final RString 定値期_9 = new RString("9");
    private static final RString 定値期_10 = new RString("10");
    private static final RString 定値期_11 = new RString("11");
    private static final RString 定値期_12 = new RString("12");
    private static final RString 定値期_13 = new RString("13");
    private static final RString 定値期_14 = new RString("14");
    private static final RString FORMAT = new RString("0");

    /**
     * コンストラクタです。
     */
    public FukaDaichoDataHenshuFath() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FukaDaichoDataHenshuFath}のインスタンスを返します。
     *
     * @return FukaDaichoDataHenshuFath
     */
    public static FukaDaichoDataHenshuFath createInstance() {
        return InstanceProvider.create(FukaDaichoDataHenshuFath.class);
    }

    /**
     * 普徴期月情報を作成するメソッドです。
     *
     * @param 普徴期月リスト List<Kitsuki>
     * @param 普徴月情報 FutsuChoshuTsuki
     * @param is本算定 boolean
     * @return FuchoKiInfo 普徴期情報
     */
    public FutsuChoshuKi create普徴期月情報(List<Kitsuki> 普徴期月リスト, FutsuChoshuTsuki 普徴月情報, boolean is本算定) {

        FutsuChoshuKi 普徴期情報 = new FutsuChoshuKi();
        普徴期情報.set普徴期１(RString.EMPTY);
        普徴期情報.set普徴期２(RString.EMPTY);
        普徴期情報.set普徴期３(RString.EMPTY);
        普徴期情報.set普徴期４(RString.EMPTY);
        普徴期情報.set普徴期５(RString.EMPTY);
        普徴期情報.set普徴期６(RString.EMPTY);
        普徴期情報.set普徴期７(RString.EMPTY);
        普徴期情報.set普徴期８(RString.EMPTY);
        普徴期情報.set普徴期９(RString.EMPTY);
        普徴期情報.set普徴期１０(RString.EMPTY);
        普徴期情報.set普徴期１１(RString.EMPTY);
        普徴期情報.set普徴期１２(RString.EMPTY);
        普徴期情報.set普徴期１３(RString.EMPTY);
        普徴期情報.set普徴期１４(RString.EMPTY);
        普徴月情報.set普徴月１(RString.EMPTY);
        普徴月情報.set普徴月２(RString.EMPTY);
        普徴月情報.set普徴月３(RString.EMPTY);
        普徴月情報.set普徴月４(RString.EMPTY);
        普徴月情報.set普徴月５(RString.EMPTY);
        普徴月情報.set普徴月６(RString.EMPTY);
        普徴月情報.set普徴月７(RString.EMPTY);
        普徴月情報.set普徴月８(RString.EMPTY);
        普徴月情報.set普徴月９(RString.EMPTY);
        普徴月情報.set普徴月１０(RString.EMPTY);
        普徴月情報.set普徴月１１(RString.EMPTY);
        普徴月情報.set普徴月１２(RString.EMPTY);
        普徴月情報.set普徴月１３(RString.EMPTY);
        普徴月情報.set普徴月１４(RString.EMPTY);
        for (Kitsuki 普徴期月 : 普徴期月リスト) {
            if (!is本算定 && INTNUMBER_10 <= 普徴期月.get月AsInt()) {
                return 普徴期情報;
            }
            RString 月 = format月(普徴期月.get月().getコード());
            switch (普徴期月.get期AsInt()) {
                case INTNUMBER_1:
                    普徴期情報.set普徴期１(定値期_1);
                    普徴月情報.set普徴月１(月);
                    break;
                case INTNUMBER_2:
                    普徴期情報.set普徴期２(定値期_2);
                    普徴月情報.set普徴月２(月);
                    break;
                case INTNUMBER_3:
                    普徴期情報.set普徴期３(定値期_3);
                    普徴月情報.set普徴月３(月);
                    break;
                case INTNUMBER_4:
                    普徴期情報.set普徴期４(定値期_4);
                    普徴月情報.set普徴月４(月);
                    break;
                case INTNUMBER_5:
                    普徴期情報.set普徴期５(定値期_5);
                    普徴月情報.set普徴月５(月);
                    break;
                case INTNUMBER_6:
                    普徴期情報.set普徴期６(定値期_6);
                    普徴月情報.set普徴月６(月);
                    break;
                case INTNUMBER_7:
                    普徴期情報.set普徴期７(定値期_7);
                    普徴月情報.set普徴月７(月);
                    break;
                case INTNUMBER_8:
                    普徴期情報.set普徴期８(定値期_8);
                    普徴月情報.set普徴月８(月);
                    break;
                case INTNUMBER_9:
                    普徴期情報.set普徴期９(定値期_9);
                    普徴月情報.set普徴月９(月);
                    break;
                case INTNUMBER_10:
                    普徴期情報.set普徴期１０(定値期_10);
                    普徴月情報.set普徴月１０(月);
                    break;
                case INTNUMBER_11:
                    普徴期情報.set普徴期１１(定値期_11);
                    普徴月情報.set普徴月１１(月);
                    break;
                case INTNUMBER_12:
                    普徴期情報.set普徴期１２(定値期_12);
                    普徴月情報.set普徴月１２(月);
                    break;
                case INTNUMBER_13:
                    普徴期情報.set普徴期１３(定値期_13);
                    普徴月情報.set普徴月１３(月);
                    break;
                case INTNUMBER_14:
                    普徴期情報.set普徴期１４(定値期_14);
                    普徴月情報.set普徴月１４(月);
                    break;
                default:
            }
        }
        return 普徴期情報;
    }

    private RString format月(RString コード) {
        if (Integer.parseInt(コード.toString()) < INTNUMBER_10) {
            return コード.replace(FORMAT.toString(), RString.EMPTY.toString());
        }
        if (コード.equals(Tsuki.翌年度4月.getコード())) {
            return Tsuki._4月.getコード().replace(FORMAT.toString(), RString.EMPTY.toString());
        }
        if (コード.equals(Tsuki.翌年度5月.getコード())) {
            return Tsuki._5月.getコード().replace(FORMAT.toString(), RString.EMPTY.toString());
        }
        return コード;
    }

    /**
     * 特徴期情報を作成するメソッドです。
     *
     * @param 年度区分 GennenKanen
     * @param 特徴期月リスト List<Kitsuki>
     * @param 特徴月情報 TokubetsuChoshuTsuki
     * @param is本算定 boolean
     * @return TokubetsuChoshuKi 特徴期情報
     */
    public TokubetsuChoshuKi create特徴期月情報(GennenKanen 年度区分, List<Kitsuki> 特徴期月リスト, TokubetsuChoshuTsuki 特徴月情報, boolean is本算定) {

        TokubetsuChoshuKi 特徴期情報 = new TokubetsuChoshuKi();
        特徴期情報.set特徴期１(RString.EMPTY);
        特徴期情報.set特徴期２(RString.EMPTY);
        特徴期情報.set特徴期３(RString.EMPTY);
        特徴期情報.set特徴期４(RString.EMPTY);
        特徴期情報.set特徴期５(RString.EMPTY);
        特徴期情報.set特徴期６(RString.EMPTY);
        特徴期情報.set特徴期７(RString.EMPTY);
        特徴期情報.set特徴期８(RString.EMPTY);
        特徴期情報.set特徴期９(RString.EMPTY);
        特徴期情報.set特徴期１０(RString.EMPTY);
        特徴期情報.set特徴期１１(RString.EMPTY);
        特徴期情報.set特徴期１２(RString.EMPTY);
        特徴期情報.set特徴期１３(RString.EMPTY);
        特徴期情報.set特徴期１４(RString.EMPTY);
        特徴月情報.set特徴月１(RString.EMPTY);
        特徴月情報.set特徴月２(RString.EMPTY);
        特徴月情報.set特徴月３(RString.EMPTY);
        特徴月情報.set特徴月４(RString.EMPTY);
        特徴月情報.set特徴月５(RString.EMPTY);
        特徴月情報.set特徴月６(RString.EMPTY);
        特徴月情報.set特徴月７(RString.EMPTY);
        特徴月情報.set特徴月８(RString.EMPTY);
        特徴月情報.set特徴月９(RString.EMPTY);
        特徴月情報.set特徴月１０(RString.EMPTY);
        特徴月情報.set特徴月１１(RString.EMPTY);
        特徴月情報.set特徴月１２(RString.EMPTY);
        特徴月情報.set特徴月１３(RString.EMPTY);
        特徴月情報.set特徴月１４(RString.EMPTY);
        if (GennenKanen.過年度.equals(年度区分)) {
            return 特徴期情報;
        }
        for (Kitsuki 特徴期月 : 特徴期月リスト) {
            RString 月 = format月(特徴期月.get月().getコード());
            if (!is本算定 && INTNUMBER_10 <= 特徴期月.get月AsInt()) {
                return 特徴期情報;
            }
            switch (特徴期月.get期AsInt()) {
                case INTNUMBER_1:
                    特徴期情報.set特徴期１(定値期_1);
                    特徴月情報.set特徴月１(月);
                    break;
                case INTNUMBER_2:
                    特徴期情報.set特徴期２(定値期_2);
                    特徴月情報.set特徴月２(月);
                    break;
                case INTNUMBER_3:
                    特徴期情報.set特徴期３(定値期_3);
                    特徴月情報.set特徴月３(月);
                    break;
                case INTNUMBER_4:
                    特徴期情報.set特徴期４(定値期_4);
                    特徴月情報.set特徴月４(月);
                    break;
                case INTNUMBER_5:
                    特徴期情報.set特徴期５(定値期_5);
                    特徴月情報.set特徴月５(月);
                    break;
                case INTNUMBER_6:
                    特徴期情報.set特徴期６(定値期_6);
                    特徴月情報.set特徴月６(月);
                    break;
                default:
            }
        }
        return 特徴期情報;
    }

    /**
     * 随時情報を作成するメソッドです。
     *
     * @param 年度区分 GennenKanen
     * @param 普徴期月リスト List<Kitsuki>
     * @return FutsuChoshuZuiji 随時情報
     */
    public FutsuChoshuZuiji create随時情報(GennenKanen 年度区分, List<Kitsuki> 普徴期月リスト) {

        FutsuChoshuZuiji 随時情報 = new FutsuChoshuZuiji();
        随時情報.set普徴随時１(RString.EMPTY);
        随時情報.set普徴随時２(RString.EMPTY);
        随時情報.set普徴随時３(RString.EMPTY);
        随時情報.set普徴随時４(RString.EMPTY);
        随時情報.set普徴随時５(RString.EMPTY);
        随時情報.set普徴随時６(RString.EMPTY);
        随時情報.set普徴随時７(RString.EMPTY);
        随時情報.set普徴随時８(RString.EMPTY);
        随時情報.set普徴随時９(RString.EMPTY);
        随時情報.set普徴随時１０(RString.EMPTY);
        随時情報.set普徴随時１１(RString.EMPTY);
        随時情報.set普徴随時１２(RString.EMPTY);
        随時情報.set普徴随時１３(RString.EMPTY);
        随時情報.set普徴随時１４(RString.EMPTY);
        if (GennenKanen.現年度.equals(年度区分)) {
            for (Kitsuki 普徴期月 : 普徴期月リスト) {
                set随時情報(年度区分, 普徴期月, 随時情報);
            }
        } else if (GennenKanen.過年度.equals(年度区分)) {
            for (Kitsuki 普徴期月 : 普徴期月リスト) {
                set随時情報(年度区分, 普徴期月, 随時情報);
            }
        }
        return 随時情報;
    }

    private void set随時情報(GennenKanen 年度区分, Kitsuki 普徴期月, FutsuChoshuZuiji 随時情報) {

        if (GennenKanen.現年度.equals(年度区分) && !FuchokiJohoTsukiShoriKubun.随時.get名称().equals(普徴期月.get月処理区分().getName())
                && !FuchokiJohoTsukiShoriKubun.現年随時.get名称().equals(普徴期月.get月処理区分().getName())) {
            return;
        }
        switch (普徴期月.get期AsInt()) {
            case INTNUMBER_1:
                随時情報.set普徴随時１(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INTNUMBER_2:
                随時情報.set普徴随時２(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INTNUMBER_3:
                随時情報.set普徴随時３(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INTNUMBER_4:
                随時情報.set普徴随時４(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INTNUMBER_5:
                随時情報.set普徴随時５(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INTNUMBER_6:
                随時情報.set普徴随時６(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INTNUMBER_7:
                随時情報.set普徴随時７(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INTNUMBER_8:
                随時情報.set普徴随時８(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INTNUMBER_9:
                随時情報.set普徴随時９(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INTNUMBER_10:
                随時情報.set普徴随時１０(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INTNUMBER_11:
                随時情報.set普徴随時１１(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INTNUMBER_12:
                随時情報.set普徴随時１２(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INTNUMBER_13:
                随時情報.set普徴随時１３(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INTNUMBER_14:
                随時情報.set普徴随時１４(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            default:
        }
    }

    /**
     * 世帯員情報リストを作成するメソッドです。
     *
     * @param 世帯員所得情報リスト List<SetaiinShotoku>
     * @return List<SetaInJoho> 世帯員情報リスト
     */
    public List<SetaInJoho> create世帯員情報リスト(List<SetaiinShotoku> 世帯員所得情報リスト) {

        List<SetaInJoho> 世帯員情報リスト = new ArrayList<>();
        if (世帯員所得情報リスト == null || 世帯員所得情報リスト.isEmpty()) {
            return 世帯員情報リスト;
        }
        for (SetaiinShotoku 世帯員所得情報 : 世帯員所得情報リスト) {
            if (定値期_2.equals(世帯員所得情報.get本人区分())) {
                SetaInJoho 世帯員情報 = new SetaInJoho();
                世帯員情報.set世帯員識別コード(世帯員所得情報.get識別コード().getColumnValue());
                世帯員情報.set世帯員氏名(世帯員所得情報.get氏名());
                世帯員情報.set世帯員性別(世帯員所得情報.get性別());
                世帯員情報.set世帯員生年月日(get生年月日(世帯員所得情報.get生年月日()));
                世帯員情報.set世帯員続柄(世帯員所得情報.get続柄());
                世帯員情報.set世帯員合計取得金額(format金額(世帯員所得情報.get合計所得金額()));
                世帯員情報.set世帯員課税区分(世帯員所得情報.get課税区分_住民税減免前());
                世帯員情報リスト.add(世帯員情報);
            }
        }
        return 世帯員情報リスト;
    }

    /**
     * 生年月日を返します。
     *
     * @param 生年月日 FlexibleDate
     * @return RString 生年月日
     */
    private RString get生年月日(FlexibleDate 生年月日) {
        return 生年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).
                fillType(FillType.BLANK).toDateString();
    }

    /**
     * 変更事由リストを作成するメソッドです。
     *
     * @param 賦課の情報_更正後 FukaAtena
     * @param 賦課の情報_更正前 FukaAtena
     * @return List<RString> 変更事由リスト
     */
    public List<RString> create変更事由リスト(FukaAtena 賦課の情報_更正後, FukaAtena 賦課の情報_更正前) {

        List<RString> 変更事由リスト = new ArrayList<>();
        if (賦課の情報_更正前 == null || 賦課の情報_更正後 == null) {
            return 変更事由リスト;
        }
        if ((isNull(賦課の情報_更正後.get賦課情報().get口座区分()) && !isNull(賦課の情報_更正前.get賦課情報().get口座区分()))
                || (賦課の情報_更正後.get賦課情報().get口座区分() != null
                && !賦課の情報_更正後.get賦課情報().get口座区分().equals(賦課の情報_更正前.get賦課情報().get口座区分()))) {
            変更事由リスト.add(HenkoJiyu.口座情報変更.getコード());
        }
        set資格変更事由(賦課の情報_更正後, 賦課の情報_更正前, 変更事由リスト);
        set老齢年金変更事由(賦課の情報_更正後, 賦課の情報_更正前, 変更事由リスト);
        set変更事由(賦課の情報_更正後, 賦課の情報_更正前, 変更事由リスト);
        return 変更事由リスト;
    }

    private void set資格変更事由(FukaAtena 賦課の情報_更正後, FukaAtena 賦課の情報_更正前, List<RString> 変更事由リスト) {
        if (((isNull(賦課の情報_更正後.get賦課情報().get資格取得日()) && !isNull(賦課の情報_更正前.get賦課情報().get資格取得日()))
                || (賦課の情報_更正後.get賦課情報().get資格取得日() != null
                && !賦課の情報_更正後.get賦課情報().get資格取得日().equals(賦課の情報_更正前.get賦課情報().get資格取得日())))
                || ((isNull(賦課の情報_更正後.get賦課情報().get資格取得事由()) && !isNull(賦課の情報_更正前.get賦課情報().get資格取得事由()))
                || (賦課の情報_更正後.get賦課情報().get資格取得事由() != null
                && !賦課の情報_更正後.get賦課情報().get資格取得事由().equals(賦課の情報_更正前.get賦課情報().get資格取得事由())))
                || ((isNull(賦課の情報_更正後.get賦課情報().get資格喪失日()) && !isNull(賦課の情報_更正前.get賦課情報().get資格喪失日()))
                || (賦課の情報_更正後.get賦課情報().get資格喪失日() != null
                && !賦課の情報_更正後.get賦課情報().get資格喪失日().equals(賦課の情報_更正前.get賦課情報().get資格喪失日())))
                || ((isNull(賦課の情報_更正後.get賦課情報().get資格喪失事由()) && !isNull(賦課の情報_更正前.get賦課情報().get資格喪失事由()))
                || (賦課の情報_更正後.get賦課情報().get資格喪失事由() != null
                && !賦課の情報_更正後.get賦課情報().get資格喪失事由().equals(賦課の情報_更正前.get賦課情報().get資格喪失事由())))) {
            変更事由リスト.add(HenkoJiyu.資格変更.getコード());
        }
    }

    private void set老齢年金変更事由(FukaAtena 賦課の情報_更正後, FukaAtena 賦課の情報_更正前, List<RString> 変更事由リスト) {
        if (((isNull(賦課の情報_更正後.get賦課情報().get老年開始日()) && !isNull(賦課の情報_更正前.get賦課情報().get老年開始日()))
                || (賦課の情報_更正後.get賦課情報().get老年開始日() != null
                && !賦課の情報_更正後.get賦課情報().get老年開始日().equals(賦課の情報_更正前.get賦課情報().get老年開始日())))
                || ((isNull(賦課の情報_更正後.get賦課情報().get老年廃止日()) && !isNull(賦課の情報_更正前.get賦課情報().get老年廃止日()))
                || (賦課の情報_更正後.get賦課情報().get老年廃止日() != null
                && !賦課の情報_更正後.get賦課情報().get老年廃止日().equals(賦課の情報_更正前.get賦課情報().get老年廃止日())))) {
            変更事由リスト.add(HenkoJiyu.老齢年金変更.getコード());
        }
    }

    private void set変更事由(FukaAtena 賦課の情報_更正後, FukaAtena 賦課の情報_更正前, List<RString> 変更事由リスト) {

        if (((isNull(賦課の情報_更正後.get賦課情報().get生活保護扶助種類()) && !isNull(賦課の情報_更正前.get賦課情報().get生活保護扶助種類()))
                || (賦課の情報_更正後.get賦課情報().get生活保護扶助種類() != null
                && !賦課の情報_更正後.get賦課情報().get生活保護扶助種類().equals(賦課の情報_更正前.get賦課情報().get生活保護扶助種類())))
                || ((isNull(賦課の情報_更正後.get賦課情報().get生保開始日()) && !isNull(賦課の情報_更正前.get賦課情報().get生保開始日()))
                || (賦課の情報_更正後.get賦課情報().get生保開始日() != null
                && !賦課の情報_更正後.get賦課情報().get生保開始日().equals(賦課の情報_更正前.get賦課情報().get生保開始日())))
                || ((isNull(賦課の情報_更正後.get賦課情報().get生保廃止日()) && !isNull(賦課の情報_更正前.get賦課情報().get生保廃止日()))
                || (賦課の情報_更正後.get賦課情報().get生保廃止日() != null
                && !賦課の情報_更正後.get賦課情報().get生保廃止日().equals(賦課の情報_更正前.get賦課情報().get生保廃止日())))) {
            変更事由リスト.add(HenkoJiyu.生活保護変更.getコード());
        }
        if (賦課の情報_更正後.get賦課情報().get世帯員数() != 賦課の情報_更正前.get賦課情報().get世帯員数()
                || ((isNull(賦課の情報_更正後.get賦課情報().get世帯コード()) && !isNull(賦課の情報_更正前.get賦課情報().get世帯コード()))
                || (賦課の情報_更正後.get賦課情報().get世帯コード() != null
                && !賦課の情報_更正後.get賦課情報().get世帯コード().equals(賦課の情報_更正前.get賦課情報().get世帯コード())))) {
            変更事由リスト.add(HenkoJiyu.世帯員変更.getコード());
        }
    }

    private RString format金額(Decimal 金額) {

        if (金額 == null) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(金額, 0);
    }

    private boolean isNull(Object 項目) {
        return 項目 == null;
    }
}
