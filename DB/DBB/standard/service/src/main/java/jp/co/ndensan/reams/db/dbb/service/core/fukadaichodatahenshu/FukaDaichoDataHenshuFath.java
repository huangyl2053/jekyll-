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

    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
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
    private static final int INT_13 = 13;
    private static final int INT_14 = 14;
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
     * 普徴期情報を作成するメソッドです。
     *
     * @param 普徴期月リスト List<Kitsuki>
     * @return FuchoKiInfo 普徴期情報
     */
    public FutsuChoshuKi create普徴期情報(List<Kitsuki> 普徴期月リスト) {

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
        for (Kitsuki 普徴期月 : 普徴期月リスト) {
            switch (普徴期月.get期AsInt()) {
                case INT_1:
                    普徴期情報.set普徴期１(期_1);
                    break;
                case INT_2:
                    普徴期情報.set普徴期２(期_2);
                    break;
                case INT_3:
                    普徴期情報.set普徴期３(期_3);
                    break;
                case INT_4:
                    普徴期情報.set普徴期４(期_4);
                    break;
                case INT_5:
                    普徴期情報.set普徴期５(期_5);
                    break;
                case INT_6:
                    普徴期情報.set普徴期６(期_6);
                    break;
                case INT_7:
                    普徴期情報.set普徴期７(期_7);
                    break;
                case INT_8:
                    普徴期情報.set普徴期８(期_8);
                    break;
                case INT_9:
                    普徴期情報.set普徴期９(期_9);
                    break;
                case INT_10:
                    普徴期情報.set普徴期１０(期_10);
                    break;
                case INT_11:
                    普徴期情報.set普徴期１１(期_11);
                    break;
                case INT_12:
                    普徴期情報.set普徴期１２(期_12);
                    break;
                case INT_13:
                    普徴期情報.set普徴期１３(期_13);
                    break;
                case INT_14:
                    普徴期情報.set普徴期１４(期_14);
                    break;
                default:
            }
        }
        return 普徴期情報;
    }

    /**
     * 普徴期情報を作成するメソッドです。
     *
     * @param 普徴期月リスト List<Kitsuki>
     * @return FutsuChoshuTsuki 普徴月情報
     */
    public FutsuChoshuTsuki create普徴月情報(List<Kitsuki> 普徴期月リスト) {

        FutsuChoshuTsuki 普徴月情報 = new FutsuChoshuTsuki();
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
        int index = 0;
        for (Kitsuki 普徴期月 : 普徴期月リスト) {
            index = index + 1;
            RString 月 = format月(普徴期月.get月().getコード());
            switch (index) {
                case INT_1:
                    普徴月情報.set普徴月１(月);
                    break;
                case INT_2:
                    普徴月情報.set普徴月２(月);
                    break;
                case INT_3:
                    普徴月情報.set普徴月３(月);
                    break;
                case INT_4:
                    普徴月情報.set普徴月４(月);
                    break;
                case INT_5:
                    普徴月情報.set普徴月５(月);
                    break;
                case INT_6:
                    普徴月情報.set普徴月６(月);
                    break;
                case INT_7:
                    普徴月情報.set普徴月７(月);
                    break;
                case INT_8:
                    普徴月情報.set普徴月８(月);
                    break;
                case INT_9:
                    普徴月情報.set普徴月９(月);
                    break;
                case INT_10:
                    普徴月情報.set普徴月１０(月);
                    break;
                case INT_11:
                    普徴月情報.set普徴月１１(月);
                    break;
                case INT_12:
                    普徴月情報.set普徴月１２(月);
                    break;
                case INT_13:
                    普徴月情報.set普徴月１３(月);
                    break;
                case INT_14:
                    普徴月情報.set普徴月１４(月);
                    break;
                default:
            }
        }
        return 普徴月情報;
    }

    private RString format月(RString コード) {
        if (Integer.parseInt(コード.toString()) < INT_10) {
            return コード.replace(FORMAT.toString(), RString.EMPTY.toString());
        }
        return コード;
    }

    /**
     * 特徴期情報を作成するメソッドです。
     *
     * @param 年度区分 GennenKanen
     * @param 特徴期月リスト List<Kitsuki>
     * @return TokubetsuChoshuKi 特徴期情報
     */
    public TokubetsuChoshuKi create特徴期情報(GennenKanen 年度区分, List<Kitsuki> 特徴期月リスト) {

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
        if (GennenKanen.過年度.equals(年度区分)) {
            return 特徴期情報;
        }
        for (Kitsuki 特徴期月 : 特徴期月リスト) {
            switch (特徴期月.get期AsInt()) {
                case INT_1:
                    特徴期情報.set特徴期１(期_1);
                    break;
                case INT_2:
                    特徴期情報.set特徴期２(期_2);
                    break;
                case INT_3:
                    特徴期情報.set特徴期３(期_3);
                    break;
                case INT_4:
                    特徴期情報.set特徴期４(期_4);
                    break;
                case INT_5:
                    特徴期情報.set特徴期５(期_5);
                    break;
                case INT_6:
                    特徴期情報.set特徴期６(期_6);
                    break;
                default:
            }
        }
        return 特徴期情報;
    }

    /**
     * 特徴月情報を作成するメソッドです。
     *
     * @param 年度区分 GennenKanen
     * @param 特徴期月リスト List<Kitsuki>
     * @return FutsuChoshuTsuki 特徴月情報
     */
    public TokubetsuChoshuTsuki create特徴月情報(GennenKanen 年度区分, List<Kitsuki> 特徴期月リスト) {

        TokubetsuChoshuTsuki 特徴月情報 = new TokubetsuChoshuTsuki();
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
            return 特徴月情報;
        }
        for (int index = 0; index < 特徴期月リスト.size();) {
            RString 月 = format月(特徴期月リスト.get(index).get月().getコード());
            index = index + 1;
            switch (index) {
                case INT_1:
                    特徴月情報.set特徴月１(月);
                    break;
                case INT_3:
                    特徴月情報.set特徴月２(月);
                    break;
                case INT_5:
                    特徴月情報.set特徴月３(月);
                    break;
                case INT_7:
                    特徴月情報.set特徴月４(月);
                    break;
                case INT_9:
                    特徴月情報.set特徴月５(月);
                    break;
                case INT_11:
                    特徴月情報.set特徴月６(月);
                    break;
                default:
            }
            index = index + 1;
        }
        return 特徴月情報;
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
            case INT_1:
                随時情報.set普徴随時１(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INT_2:
                随時情報.set普徴随時２(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INT_3:
                随時情報.set普徴随時３(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INT_4:
                随時情報.set普徴随時４(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INT_5:
                随時情報.set普徴随時５(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INT_6:
                随時情報.set普徴随時６(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INT_7:
                随時情報.set普徴随時７(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INT_8:
                随時情報.set普徴随時８(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INT_9:
                随時情報.set普徴随時９(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INT_10:
                随時情報.set普徴随時１０(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INT_11:
                随時情報.set普徴随時１１(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INT_12:
                随時情報.set普徴随時１２(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INT_13:
                随時情報.set普徴随時１３(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            case INT_14:
                随時情報.set普徴随時１４(FuchokiJohoTsukiShoriKubun.随時.get名称());
                break;
            default:
        }
    }

    /**
     * 世帯員情報リストを作成するメソッドです。
     *
     * @param 世帯員所得情報リスト List<SetaiinShotoku>
     * @param 住民種別区分 boolean
     * @return List<SetaInJoho> 世帯員情報リスト
     */
    public List<SetaInJoho> create世帯員情報リスト(List<SetaiinShotoku> 世帯員所得情報リスト, boolean 住民種別区分) {

        List<SetaInJoho> 世帯員情報リスト = new ArrayList<>();
        if (世帯員所得情報リスト == null || 世帯員所得情報リスト.isEmpty()) {
            return 世帯員情報リスト;
        }
        List<SetaiinShotoku> new世帯員所得情報リスト = new ArrayList<>();
        for (SetaiinShotoku 世帯員所得情報 : 世帯員所得情報リスト) {
            if (期_2.equals(世帯員所得情報.get本人区分())) {
                new世帯員所得情報リスト.add(世帯員所得情報);
            }
        }
        for (SetaiinShotoku new世帯員所得情報 : new世帯員所得情報リスト) {
            SetaInJoho 世帯員情報 = new SetaInJoho();
            世帯員情報.set世帯員識別コード(new世帯員所得情報.get識別コード().getColumnValue());
            世帯員情報.set世帯員氏名(new世帯員所得情報.get氏名());
            世帯員情報.set世帯員性別(new世帯員所得情報.get性別());
            世帯員情報.set世帯員生年月日(get生年月日(住民種別区分, new世帯員所得情報.get生年月日()));
            世帯員情報.set世帯員続柄(new世帯員所得情報.get続柄());
            世帯員情報.set世帯員合計取得金額(format金額(new世帯員所得情報.get合計所得金額()));
            世帯員情報.set世帯員課税区分(new世帯員所得情報.get課税区分_住民税減免前());
            世帯員情報リスト.add(世帯員情報);
        }
        return 世帯員情報リスト;
    }

    /**
     * 生年月日を返します。
     *
     * @param 住民種別区分 boolean
     * @param 生年月日 FlexibleDate
     * @return RString 生年月日
     */
    private RString get生年月日(boolean 住民種別区分, FlexibleDate 生年月日) {
        if (住民種別区分) {
            return 生年月日.wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
        } else {
            return 生年月日.seireki().toDateString();
        }
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
        if (賦課の情報_更正後.get賦課情報().get口座区分() != null
                && !賦課の情報_更正後.get賦課情報().get口座区分().equals(賦課の情報_更正前.get賦課情報().get口座区分())) {
            変更事由リスト.add(HenkoJiyu.口座情報変更.getコード());
        }
        if ((賦課の情報_更正後.get賦課情報().get資格取得日() != null
                && !賦課の情報_更正後.get賦課情報().get資格取得日().equals(賦課の情報_更正前.get賦課情報().get資格取得日()))
                || (賦課の情報_更正後.get賦課情報().get資格取得事由() != null
                && !賦課の情報_更正後.get賦課情報().get資格取得事由().equals(賦課の情報_更正前.get賦課情報().get資格取得事由()))
                || (賦課の情報_更正後.get賦課情報().get資格喪失日() != null
                && !賦課の情報_更正後.get賦課情報().get資格喪失日().equals(賦課の情報_更正前.get賦課情報().get資格喪失日()))
                || (賦課の情報_更正後.get賦課情報().get資格喪失事由() != null
                && !賦課の情報_更正後.get賦課情報().get資格喪失事由().equals(賦課の情報_更正前.get賦課情報().get資格喪失事由()))) {
            変更事由リスト.add(HenkoJiyu.資格変更.getコード());
        }
        set変更事由(賦課の情報_更正後, 賦課の情報_更正前, 変更事由リスト);
        return 変更事由リスト;
    }

    private void set変更事由(FukaAtena 賦課の情報_更正後, FukaAtena 賦課の情報_更正前, List<RString> 変更事由リスト) {

        if ((賦課の情報_更正後.get賦課情報().get老年開始日() != null
                && !賦課の情報_更正後.get賦課情報().get老年開始日().equals(賦課の情報_更正前.get賦課情報().get老年開始日()))
                || (賦課の情報_更正後.get賦課情報().get老年廃止日() != null
                && !賦課の情報_更正後.get賦課情報().get老年廃止日().equals(賦課の情報_更正前.get賦課情報().get老年廃止日()))) {
            変更事由リスト.add(HenkoJiyu.老齢年金変更.getコード());
        }
        if ((賦課の情報_更正後.get賦課情報().get生活保護扶助種類() != null
                && !賦課の情報_更正後.get賦課情報().get生活保護扶助種類().equals(賦課の情報_更正前.get賦課情報().get生活保護扶助種類()))
                || (賦課の情報_更正後.get賦課情報().get生保開始日() != null
                && !賦課の情報_更正後.get賦課情報().get生保開始日().equals(賦課の情報_更正前.get賦課情報().get生保開始日()))
                || (賦課の情報_更正後.get賦課情報().get生保廃止日() != null
                && !賦課の情報_更正後.get賦課情報().get生保廃止日().equals(賦課の情報_更正前.get賦課情報().get生保廃止日()))) {
            変更事由リスト.add(HenkoJiyu.生活保護変更.getコード());
        }
        if (賦課の情報_更正後.get賦課情報().get世帯員数() != 賦課の情報_更正前.get賦課情報().get世帯員数()
                || (賦課の情報_更正後.get賦課情報().get世帯コード() != null
                && !賦課の情報_更正後.get賦課情報().get世帯コード().equals(賦課の情報_更正前.get賦課情報().get世帯コード()))) {
            変更事由リスト.add(HenkoJiyu.世帯員変更.getコード());
        }
    }

    private RString format金額(Decimal 金額) {

        if (金額 == null) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(金額, 0);
    }
}
