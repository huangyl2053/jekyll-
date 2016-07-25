/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fukadaichodatahenshu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.core.fukaatena.FukaAtena;
import jp.co.ndensan.reams.db.dbb.business.core.fukadaichodatahenshu.FukaDaichoInfo;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.EditedHonSanteiFukaDaichoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.EditedKariSanteiFukaDaichoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.FutsuChoshu;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.FutsuChoshuKi;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.FutsuChoshuTsuki;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.FutsuChoshuZuiji;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.HonSanteifukaUchiwakeIchi;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.HonSanteifukaUchiwakeNi;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.Honnin;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.KaliSanteiUchiwake;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.SetaInJoho;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.TokubetsuChoshu;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.TokubetsuChoshuKi;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.TokubetsuChoshuTsuki;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.ShunyuJoho;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HyojiCodeResearcher;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KanendoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBBCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.UEXCodeShubetsu;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 賦課台帳データ編集クラスです。
 *
 * @reamsid_L DBB-9100-010 xicongwang
 */
public class FukaDaichoDataHenshu extends FukaDaichoDataHenshuFath {

    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_6 = 6;
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
    private static final RString 定数_受給者 = new RString("受給者");
    private static final RString 受給者_償還払い化 = new RString("償還払い化");
    private static final RString 受給者_給付額減額 = new RString("給付額減額");
    private static final RString 定数_特徴方法 = new RString("get特徴期別金額");
    private static final RString 定数_普徴方法 = new RString("get普徴期別金額");
    private static final RString 定数_普徴収入 = new RString("get普徴収入額");
    private static final RString 定数_特徴収入 = new RString("get特徴収入額");
    private static final RString 定数_境界層該当 = new RString("境界層該当");
    private static final RString FORMAT_月 = new RString("月");
    private static final RString FORMAT_LEFT = new RString("（");
    private static final RString FORMAT_RIGHT = new RString("期）");
    private static final RString FORMAT_符号 = new RString(",");
    private static final RString FORMAT_ = new RString("-");
    private static final RString 定数_年度 = new RString("年度");
    private static final RString 定値_作成 = new RString("作成");
    private static final RString 定値_仮算定タイトル = new RString("仮算定賦課台帳");
    private static final RString 定値_本算定タイトル = new RString("賦課台帳");
    private static final RString 定数_住特 = new RString("住特");
    private static final RString 公式 = new RString("×　1/12");
    private static final RString 定数_ゼロ = new RString("0");

    /**
     * コンストラクタです。
     */
    public FukaDaichoDataHenshu() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FukaDaichoDataHenshu}のインスタンスを返します。
     *
     * @return FukaDaichoDataHenshu
     */
    public static FukaDaichoDataHenshu createInstance() {
        return InstanceProvider.create(FukaDaichoDataHenshu.class);
    }

    /**
     * 編集後仮算定賦課台帳情報を作成するメソッドです。
     *
     * @param 賦課台帳情報 FukaDaichoInfo
     * @return 編集後仮算定賦課台帳情報 EditedKariSanteiFukaDaichoJoho
     */
    public EditedKariSanteiFukaDaichoJoho create編集後仮算定賦課台帳情報(FukaDaichoInfo 賦課台帳情報) {

        if (賦課台帳情報 == null || 賦課台帳情報.get賦課の情報_更正後() == null) {
            return null;
        }
        EditedKariSanteiFukaDaichoJoho 編集後仮算定賦課台帳情報 = new EditedKariSanteiFukaDaichoJoho();
        EditedKojin 代納人個人 = null;
        if (賦課台帳情報.get代納人情報_更正後() != null) {
            代納人個人 = new EditedKojin(賦課台帳情報.get代納人情報_更正後().to個人(), 賦課台帳情報.get帳票制御共通(), null);
        }
        FukaAtena 賦課の情報_更正後 = 賦課台帳情報.get賦課の情報_更正後();
        FukaAtena 賦課の情報_更正前 = 賦課台帳情報.get賦課の情報_更正前();
        EditedKojin 本人個人 = null;
        if (賦課台帳情報.get帳票制御共通() != null && 賦課の情報_更正後.get宛名() != null) {
            本人個人 = new EditedKojin(賦課の情報_更正後.get宛名(), 賦課台帳情報.get帳票制御共通(), null);
        }

        List<RString> 変更事由リスト = create変更事由リスト(賦課の情報_更正後, 賦課の情報_更正前);

        EditedKoza 編集後口座 = new EditedKoza(賦課台帳情報.get口座情報(), 賦課台帳情報.get帳票制御共通());

        編集後仮算定賦課台帳情報.set口座名義人(編集後口座.get口座名義人カナ優先());
        編集後仮算定賦課台帳情報.set口座NO(編集後口座.get口座番号Or通帳記号番号());
        編集後仮算定賦課台帳情報.set口座種類(編集後口座.get口座種別略称());
        編集後仮算定賦課台帳情報.set金融機関名(編集後口座.get金融機関名CombinedWith支店名());
        編集後仮算定賦課台帳情報.set金融機関番号(編集後口座.get金融機関コードCombinedWith支店コード());
        FukaJoho 賦課情報 = 賦課の情報_更正後.get賦課情報();
        編集後仮算定賦課台帳情報.set調定事由1(get調定事由略称(賦課情報.get調定事由1()));
        編集後仮算定賦課台帳情報.set調定事由2(get調定事由略称(賦課情報.get調定事由2()));
        編集後仮算定賦課台帳情報.set調定事由3(get調定事由略称(賦課情報.get調定事由3()));
        編集後仮算定賦課台帳情報.set調定事由4(get調定事由略称(賦課情報.get調定事由4()));
        編集後仮算定賦課台帳情報.set調定年度(賦課情報.get調定年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .fillType(FillType.BLANK).getYear().concat(定数_年度));
        編集後仮算定賦課台帳情報.set賦課年度(賦課情報.get賦課年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .fillType(FillType.BLANK).getYear().concat(定数_年度));
        if (代納人個人 != null) {
            編集後仮算定賦課台帳情報.set代納人住所(代納人個人.get編集後住所());
            編集後仮算定賦課台帳情報.set代納人名称(代納人個人.get名称().getName().getColumnValue());
            編集後仮算定賦課台帳情報.set代納人名称カナ(代納人個人.get名称().getKana().getColumnValue());
            編集後仮算定賦課台帳情報.set代納人郵便NO(代納人個人.get郵便番号());
        }
        編集後仮算定賦課台帳情報.set代納人連絡先１(賦課台帳情報.get代納人連絡先1().getColumnValue());
        編集後仮算定賦課台帳情報.set代納人連絡先２(賦課台帳情報.get代納人連絡先2().getColumnValue());
        set仮算定変更事由(編集後仮算定賦課台帳情報, 変更事由リスト);
        編集後仮算定賦課台帳情報.set被保険者番号(賦課情報.get被保険者番号().getColumnValue());
        編集後仮算定賦課台帳情報.set保険者名称(賦課台帳情報.get地方公共団体().get市町村名());
        編集後仮算定賦課台帳情報.set保険者番号(賦課台帳情報.get地方公共団体().get地方公共団体コード().getColumnValue());
        if (本人個人 != null) {
            編集後仮算定賦課台帳情報.set本人生年月日(本人個人.get生年月日());
            編集後仮算定賦課台帳情報.set本人住所(本人個人.get編集後住所());
            編集後仮算定賦課台帳情報.set本人名称(本人個人.get名称().getName().getColumnValue());
            編集後仮算定賦課台帳情報.set本人名称カナ(本人個人.get名称().getKana().getColumnValue());
            編集後仮算定賦課台帳情報.set本人性別(本人個人.get性別());
            編集後仮算定賦課台帳情報.set本人郵便番号(本人個人.get郵便番号());
        }
        編集後仮算定賦課台帳情報.set本人連絡先１(賦課台帳情報.get本人連絡先1() != null
                ? 賦課台帳情報.get本人連絡先1().getColumnValue() : RString.EMPTY);
        編集後仮算定賦課台帳情報.set本人連絡先２(賦課台帳情報.get本人連絡先2() != null
                ? 賦課台帳情報.get本人連絡先2().getColumnValue() : RString.EMPTY);
        編集後仮算定賦課台帳情報.set本人所得段階変更(期_1.equals(賦課情報.get境界層区分()) ? 定数_境界層該当 : RString.EMPTY);

        if (賦課台帳情報.get対象者_追加含む_情報() != null && 賦課台帳情報.get対象者_追加含む_情報().getDT特別徴収義務者コード() != null) {
            RString 特別徴収義務者 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    賦課台帳情報.get対象者_追加含む_情報().getDT特別徴収義務者コード().value());
            編集後仮算定賦課台帳情報.set本人特徴義務者(特別徴収義務者);
        }
        RString 年金コード = 賦課台帳情報.get徴収方法情報() != null ? 賦課台帳情報.get徴収方法情報().get仮徴収_年金コード() : RString.EMPTY;
        if (!RString.isNullOrEmpty(年金コード) && INT_3 <= 年金コード.length()) {
            RString 特別徴収対象年金 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.年金コード.getCodeShubetsu(),
                    new Code(年金コード.substring(0, INT_3)));
            編集後仮算定賦課台帳情報.set本人特徴対象年金(特別徴収対象年金);
        }
        set編集後仮算定賦課台帳情報(編集後仮算定賦課台帳情報, 賦課台帳情報);

        return 編集後仮算定賦課台帳情報;
    }

    /**
     * 編集後本算定賦課台帳情報を作成するメソッドです。
     *
     * @param 賦課台帳情報 FukaDaichoInfo
     * @return 編集後本算定賦課台帳情報 EditedHonSanteiFukaDaichoJoho
     */
    public EditedHonSanteiFukaDaichoJoho create編集後本算定賦課台帳情報(FukaDaichoInfo 賦課台帳情報) {

        if (賦課台帳情報 == null || 賦課台帳情報.get賦課の情報_更正後() == null) {
            return null;
        }
        FukaAtena 賦課の情報_更正後 = 賦課台帳情報.get賦課の情報_更正後();
        FukaAtena 賦課の情報_更正前 = 賦課台帳情報.get賦課の情報_更正前();
        EditedHonSanteiFukaDaichoJoho 編集後本算定賦課台帳情報 = new EditedHonSanteiFukaDaichoJoho();
        EditedKojin 代納人個人 = null;
        if (賦課台帳情報.get代納人情報_更正後() != null) {
            代納人個人 = new EditedKojin(賦課台帳情報.get代納人情報_更正後().to個人(), 賦課台帳情報.get帳票制御共通(), null);
        }

        EditedKojin 本人個人 = null;
        if (賦課台帳情報.get帳票制御共通() != null && 賦課の情報_更正後.get宛名() != null) {
            本人個人 = new EditedKojin(賦課の情報_更正後.get宛名(), 賦課台帳情報.get帳票制御共通(), null);
        }

        List<RString> 変更事由リスト = create変更事由リスト(賦課の情報_更正後, 賦課の情報_更正前);

        EditedKoza 編集後口座 = new EditedKoza(賦課台帳情報.get口座情報(), 賦課台帳情報.get帳票制御共通());

        編集後本算定賦課台帳情報.set口座名義人(編集後口座.get口座名義人カナ優先());
        編集後本算定賦課台帳情報.set口座NO(編集後口座.get口座番号Or通帳記号番号());
        編集後本算定賦課台帳情報.set口座種類(編集後口座.get口座種別略称());
        編集後本算定賦課台帳情報.set金融機関名(編集後口座.get金融機関名CombinedWith支店名());
        編集後本算定賦課台帳情報.set金融機関番号(編集後口座.get金融機関コードCombinedWith支店コード());
        FukaJoho 賦課情報 = 賦課の情報_更正後.get賦課情報();
        編集後本算定賦課台帳情報.set調定事由1(get調定事由略称(賦課情報.get調定事由1()));
        編集後本算定賦課台帳情報.set調定事由2(get調定事由略称(賦課情報.get調定事由2()));
        編集後本算定賦課台帳情報.set調定事由3(get調定事由略称(賦課情報.get調定事由3()));
        編集後本算定賦課台帳情報.set調定事由4(get調定事由略称(賦課情報.get調定事由4()));
        編集後本算定賦課台帳情報.set調定年度(賦課情報.get調定年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .fillType(FillType.BLANK).getYear().concat(定数_年度));
        編集後本算定賦課台帳情報.set賦課年度(賦課情報.get賦課年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .fillType(FillType.BLANK).getYear().concat(定数_年度));
        if (代納人個人 != null) {
            編集後本算定賦課台帳情報.set代納人住所(代納人個人.get編集後住所());
            編集後本算定賦課台帳情報.set代納人名称(代納人個人.get名称().getName().getColumnValue());
            編集後本算定賦課台帳情報.set代納人名称カナ(代納人個人.get名称().getKana().getColumnValue());
            編集後本算定賦課台帳情報.set代納人郵便NO(代納人個人.get郵便番号());
        }
        編集後本算定賦課台帳情報.set代納人連絡先１(賦課台帳情報.get代納人連絡先1().getColumnValue());
        編集後本算定賦課台帳情報.set代納人連絡先２(賦課台帳情報.get代納人連絡先2().getColumnValue());
        set本算定変更事由(編集後本算定賦課台帳情報, 変更事由リスト);

        編集後本算定賦課台帳情報.set被保険者番号(賦課情報.get被保険者番号());
        編集後本算定賦課台帳情報.set保険者名称(賦課台帳情報.get地方公共団体().get市町村名());
        編集後本算定賦課台帳情報.set保険者番号(賦課台帳情報.get地方公共団体().get地方公共団体コード());
        if (本人個人 != null) {
            編集後本算定賦課台帳情報.set本人生年月日(本人個人.get生年月日());
            編集後本算定賦課台帳情報.set本人住所(本人個人.get編集後住所());
            編集後本算定賦課台帳情報.set本人名称(本人個人.get名称().getName().getColumnValue());
            編集後本算定賦課台帳情報.set本人名称カナ(本人個人.get名称().getKana().getColumnValue());
            編集後本算定賦課台帳情報.set本人性別(本人個人.get性別());
            編集後本算定賦課台帳情報.set本人郵便番号(本人個人.get郵便番号());
        }
        編集後本算定賦課台帳情報.set本人連絡先１(賦課台帳情報.get本人連絡先1() != null
                ? 賦課台帳情報.get本人連絡先1().getColumnValue() : RString.EMPTY);
        編集後本算定賦課台帳情報.set本人連絡先２(賦課台帳情報.get本人連絡先2() != null
                ? 賦課台帳情報.get本人連絡先2().getColumnValue() : RString.EMPTY);
        編集後本算定賦課台帳情報.set本人所得段階変更(期_1.equals(賦課情報.get境界層区分()) ? 定数_境界層該当 : RString.EMPTY);

        if (賦課台帳情報.get対象者_追加含む_情報() != null && 賦課台帳情報.get対象者_追加含む_情報().getDT特別徴収義務者コード() != null) {
            RString 特別徴収義務者 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    賦課台帳情報.get対象者_追加含む_情報().getDT特別徴収義務者コード().value());
            編集後本算定賦課台帳情報.set本人特徴義務者(特別徴収義務者);
        }
        RString 年金コード = 賦課台帳情報.get徴収方法情報() != null ? 賦課台帳情報.get徴収方法情報().get仮徴収_年金コード() : RString.EMPTY;
        if (!RString.isNullOrEmpty(年金コード) && INT_3 <= 年金コード.length()) {
            RString 特別徴収対象年金 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    UEXCodeShubetsu.年金コード.getCodeShubetsu(), new Code(年金コード.substring(0, INT_3)));
            編集後本算定賦課台帳情報.set本人特徴対象年金(特別徴収対象年金);
        }
        set編集後本算定賦課台帳情報(編集後本算定賦課台帳情報, 賦課台帳情報);

        return 編集後本算定賦課台帳情報;
    }

    private void set編集後本算定賦課台帳情報(EditedHonSanteiFukaDaichoJoho 編集後本算定賦課台帳情報, FukaDaichoInfo 賦課台帳情報) {

        if (賦課台帳情報 == null || 賦課台帳情報.get賦課の情報_更正後() == null) {
            return;
        }
        FukaAtena 賦課の情報_更正後 = 賦課台帳情報.get賦課の情報_更正後();
        FukaAtena 賦課の情報_更正前 = 賦課台帳情報.get賦課の情報_更正前();
        EditedKojin 本人個人 = null;
        if (賦課台帳情報.get帳票制御共通() != null && 賦課の情報_更正後.get宛名() != null) {
            本人個人 = new EditedKojin(賦課の情報_更正後.get宛名(), 賦課台帳情報.get帳票制御共通(), null);
        }
        EditedKojin 本人個人_更正前 = null;
        if (賦課の情報_更正前 != null && 賦課台帳情報.get帳票制御共通() != null && 賦課の情報_更正前.get宛名() != null) {
            本人個人_更正前 = new EditedKojin(賦課の情報_更正前.get宛名(), 賦課台帳情報.get帳票制御共通(), null);
        }

        HyojiCodes 表示コード情報 = get表示コード情報(賦課台帳情報);

        GennenKanen 年度区分 = GennenKanen.過年度;
        if (賦課の情報_更正後.get賦課情報().get調定年度().equals(賦課の情報_更正後.get賦課情報().get賦課年度())) {
            年度区分 = GennenKanen.現年度;
        }
        List<Kitsuki> 普徴期月リスト;
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KanendoKiUtil 月期対応取得_過年度 = new KanendoKiUtil();
        KitsukiList 期月リスト_過年度 = 月期対応取得_過年度.get期月リスト();
        TokuchoKiUtil 月期対応取得_特徴 = new TokuchoKiUtil();
        KitsukiList 期月リスト_特徴 = 月期対応取得_特徴.get期月リスト();
        List<Kitsuki> 特徴期月リスト;
        if (GennenKanen.現年度.equals(年度区分)) {
            普徴期月リスト = 期月リスト_普徴.toList();
            特徴期月リスト = 期月リスト_特徴.toList();
        } else {
            普徴期月リスト = 期月リスト_過年度.toList();
            特徴期月リスト = new ArrayList<>();
        }
        FutsuChoshuKi 普徴期情報 = create普徴期情報(普徴期月リスト);
        FutsuChoshuTsuki 普徴月情報 = create普徴月情報(普徴期月リスト);
        FutsuChoshuZuiji 随時情報 = create随時情報(年度区分, 普徴期月リスト);
        List<SetaInJoho> 世帯員情報リスト = create世帯員情報リスト(賦課台帳情報.get世帯員所得情報(), 賦課の情報_更正後.get宛名().is日本人());
        TokubetsuChoshuKi 特徴期情報 = create特徴期情報(年度区分, 特徴期月リスト);
        TokubetsuChoshuTsuki 特徴月情報 = create特徴月情報(年度区分, 特徴期月リスト);
        RString 受給情報 = create受給情報(賦課台帳情報.get受給者台帳情報(), 賦課台帳情報.get支払方法変更リスト());

        if (表示コード情報 != null) {
            編集後本算定賦課台帳情報.set表示コード１(表示コード情報.get表示コード１());
            編集後本算定賦課台帳情報.set表示コード２(表示コード情報.get表示コード２());
            編集後本算定賦課台帳情報.set表示コード３(表示コード情報.get表示コード３());
            編集後本算定賦課台帳情報.set表示コード名称１(表示コード情報.get表示コード名１());
            編集後本算定賦課台帳情報.set表示コード名称２(表示コード情報.get表示コード名２());
            編集後本算定賦課台帳情報.set表示コード名称３(表示コード情報.get表示コード名３());
        }
        編集後本算定賦課台帳情報.set受給情報(受給情報);
        編集後本算定賦課台帳情報.set課税区分(RString.EMPTY);
        編集後本算定賦課台帳情報.set普徴期(普徴期情報);
        編集後本算定賦課台帳情報.set普徴月(普徴月情報);
        編集後本算定賦課台帳情報.set普徴随時(随時情報);
        set本算定賦課内訳(false, 賦課の情報_更正前, 編集後本算定賦課台帳情報);
        set本算定賦課内訳(true, 賦課の情報_更正後, 編集後本算定賦課台帳情報);
        set本算定賦課内訳_増減額(編集後本算定賦課台帳情報);
        set本算定賦課内訳_年額保険料(false, 賦課台帳情報.get基準日時(), 賦課の情報_更正前, 編集後本算定賦課台帳情報);
        set本算定賦課内訳_所得段階(false, 賦課の情報_更正前, 編集後本算定賦課台帳情報);
        set本算定賦課内訳_年額保険料(true, 賦課台帳情報.get基準日時(), 賦課の情報_更正後, 編集後本算定賦課台帳情報);
        set本算定賦課内訳_所得段階(true, 賦課の情報_更正後, 編集後本算定賦課台帳情報);
        set普通徴収_本算定(false, 賦課の情報_更正前, 賦課台帳情報.get収入情報(), 期月リスト_普徴, 編集後本算定賦課台帳情報);
        set普通徴収_本算定(true, 賦課の情報_更正後, 賦課台帳情報.get収入情報(), 期月リスト_普徴, 編集後本算定賦課台帳情報);
        set普通徴収_増減額(編集後本算定賦課台帳情報);
        set普通徴収_収入額(賦課台帳情報.get収入情報(), 編集後本算定賦課台帳情報);
        set本人_更正前後(false, 賦課の情報_更正前, 賦課台帳情報.get被保険者台帳情報(), 賦課台帳情報.get境界層当該者情報(),
                本人個人_更正前, 編集後本算定賦課台帳情報);
        set本人_更正前後(true, 賦課の情報_更正後, 賦課台帳情報.get被保険者台帳情報(), 賦課台帳情報.get境界層当該者情報(),
                本人個人, 編集後本算定賦課台帳情報);
        編集後本算定賦課台帳情報.set世帯員情報リスト(世帯員情報リスト);
        編集後本算定賦課台帳情報.set特徴期(特徴期情報);
        編集後本算定賦課台帳情報.set特徴月(特徴月情報);
        if (GennenKanen.現年度.equals(年度区分)) {
            set特別徴収_本算定(false, 賦課の情報_更正前, 賦課台帳情報.get収入情報(), 期月リスト_特徴, 編集後本算定賦課台帳情報);
            set特別徴収_本算定(true, 賦課の情報_更正後, 賦課台帳情報.get収入情報(), 期月リスト_特徴, 編集後本算定賦課台帳情報);
            set特別徴収_増減額(編集後本算定賦課台帳情報);
            set特別徴収_収入額(賦課台帳情報.get収入情報(), 編集後本算定賦課台帳情報);
        }
        編集後本算定賦課台帳情報.set印刷日時(RDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(RString.HALF_SPACE)
                .concat(RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒)).
                concat(RString.HALF_SPACE).concat(定値_作成));
        編集後本算定賦課台帳情報.set世帯コード(賦課の情報_更正後.get賦課情報().get世帯コード() != null
                ? 賦課の情報_更正後.get賦課情報().get世帯コード().getColumnValue() : RString.EMPTY);
        編集後本算定賦課台帳情報.setタイトル(定値_本算定タイトル);
        編集後本算定賦課台帳情報.set通知書NO(賦課の情報_更正後.get賦課情報().get通知書番号() != null
                ? 賦課の情報_更正後.get賦課情報().get通知書番号().getColumnValue() : RString.EMPTY);
    }

    private void set本算定賦課内訳(boolean 前後区分, FukaAtena 賦課の情報, EditedHonSanteiFukaDaichoJoho 編集後本算定賦課台帳情報) {

        if (賦課の情報 == null) {
            return;
        }
        HonSanteifukaUchiwakeIchi 本算定賦課内訳 = new HonSanteifukaUchiwakeIchi();
        本算定賦課内訳.set本人合計所得金額(format金額_パターン(前後区分, 賦課の情報.get賦課情報().get合計所得金額()));
        本算定賦課内訳.set本人公的年金収入額(format金額_パターン(前後区分, 賦課の情報.get賦課情報().get公的年金収入額()));
        本算定賦課内訳.set本人課税区分(!RString.isNullOrEmpty(賦課の情報.get賦課情報().get課税区分())
                ? KazeiKubun.toValue(賦課の情報.get賦課情報().get課税区分()).get名称() : RString.EMPTY);
        本算定賦課内訳.set世帯課税区分(!RString.isNullOrEmpty(賦課の情報.get賦課情報().get世帯課税区分())
                ? SetaiKazeiKubun.toValue(賦課の情報.get賦課情報().get世帯課税区分()).get名称() : RString.EMPTY);
        本算定賦課内訳.set本人算出保険料額(format金額_パターン(前後区分, 賦課の情報.get賦課情報().get減免前介護保険料_年額()));
        本算定賦課内訳.set本人減免額(format金額_パターン(前後区分, 賦課の情報.get賦課情報().get減免額()));
        本算定賦課内訳.set確定年額保険料(format金額_パターン(前後区分, 賦課の情報.get賦課情報().get確定介護保険料_年額()));
        本算定賦課内訳.set賦課基準日(賦課の情報.get賦課情報().get賦課期日() != null && !賦課の情報.get賦課情報().get賦課期日().isEmpty()
                ? get年月日(賦課の情報.get賦課情報().get賦課期日()) : RString.EMPTY);
        本算定賦課内訳.set調定年月日(賦課の情報.get賦課情報().get調定日時() != null && !賦課の情報.get賦課情報().get調定日時().isEmpty()
                ? 賦課の情報.get賦課情報().get調定日時().getDate().wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString() : RString.EMPTY);
        if (前後区分) {
            編集後本算定賦課台帳情報.set本算定賦課内訳１更正後(本算定賦課内訳);
        } else {
            編集後本算定賦課台帳情報.set本算定賦課内訳１更正前(本算定賦課内訳);
        }
    }

    private void set本算定賦課内訳_増減額(EditedHonSanteiFukaDaichoJoho 編集後本算定賦課台帳情報) {

        HonSanteifukaUchiwakeIchi 本算定賦課内訳 = new HonSanteifukaUchiwakeIchi();
        HonSanteifukaUchiwakeIchi 本算定賦課内訳_更正後 = 編集後本算定賦課台帳情報.get本算定賦課内訳１更正後();
        HonSanteifukaUchiwakeIchi 本算定賦課内訳_更正前 = 編集後本算定賦課台帳情報.get本算定賦課内訳１更正前();
        if (本算定賦課内訳_更正前 == null) {
            本算定賦課内訳.set本人合計所得金額(本算定賦課内訳_更正後.get本人合計所得金額());
            本算定賦課内訳.set本人公的年金収入額(本算定賦課内訳_更正後.get本人公的年金収入額());
            本算定賦課内訳.set本人算出保険料額(本算定賦課内訳_更正後.get本人算出保険料額());
            本算定賦課内訳.set本人減免額(本算定賦課内訳_更正後.get本人減免額());
            本算定賦課内訳.set年額保険料(本算定賦課内訳_更正後.get確定年額保険料());
        } else {
            本算定賦課内訳.set本人合計所得金額(get増減額(本算定賦課内訳_更正後.get本人合計所得金額(), 本算定賦課内訳_更正前.get本人合計所得金額()));
            本算定賦課内訳.set本人公的年金収入額(get増減額(本算定賦課内訳_更正後.get本人公的年金収入額(),
                    本算定賦課内訳_更正前.get本人公的年金収入額()));
            本算定賦課内訳.set本人算出保険料額(get増減額(本算定賦課内訳_更正後.get本人算出保険料額(), 本算定賦課内訳_更正前.get本人算出保険料額()));
            本算定賦課内訳.set本人減免額(get増減額(本算定賦課内訳_更正後.get本人減免額(), 本算定賦課内訳_更正前.get本人減免額()));
            本算定賦課内訳.set年額保険料(get増減額(本算定賦課内訳_更正後.get確定年額保険料(), 本算定賦課内訳_更正前.get確定年額保険料()));
        }
        本算定賦課内訳.set本人課税区分(RString.EMPTY);
        本算定賦課内訳.set世帯課税区分(RString.EMPTY);
        本算定賦課内訳.set賦課基準日(RString.EMPTY);
        本算定賦課内訳.set調定年月日(RString.EMPTY);
        編集後本算定賦課台帳情報.set本算定賦課内訳１増減額(本算定賦課内訳);
    }

    private void set本算定賦課内訳_年額保険料(boolean 前後区分, YMDHMS 基準日時, FukaAtena 賦課の情報,
            EditedHonSanteiFukaDaichoJoho 編集後本算定賦課台帳情報) {

        if (賦課の情報 == null) {
            return;
        }
        HonSanteifukaUchiwakeNi 年額保険料 = new HonSanteifukaUchiwakeNi();
        年額保険料.set四月分保険料額(get月分保険料額(賦課の情報, 期_4));
        年額保険料.set五月分保険料額(get月分保険料額(賦課の情報, 期_5));
        年額保険料.set六月分保険料額(get月分保険料額(賦課の情報, 期_6));
        年額保険料.set七月分保険料額(get月分保険料額(賦課の情報, 期_7));
        年額保険料.set八月分保険料額(get月分保険料額(賦課の情報, 期_8));
        年額保険料.set九月分保険料額(get月分保険料額(賦課の情報, 期_9));
        年額保険料.set十月分保険料額(get月分保険料額(賦課の情報, 期_10));
        年額保険料.set十一月分保険料額(get月分保険料額(賦課の情報, 期_11));
        年額保険料.set十二月分保険料額(get月分保険料額(賦課の情報, 期_12));
        年額保険料.set一月分保険料額(get保険料額(賦課の情報, 期_1));
        年額保険料.set二月分保険料額(get保険料額(賦課の情報, 期_2));
        年額保険料.set三月分保険料額(get保険料額(賦課の情報, 期_3));
        if (!前後区分 && 賦課の情報.get賦課情報().get調定日時() != null && !賦課の情報.get賦課情報().get調定日時().isEmpty()
                && 基準日時 != null && !基準日時.isEmpty() && 賦課の情報.get賦課情報().get調定日時().isBefore(基準日時)) {
            年額保険料.set十二ヶ月分年度加算額(RString.EMPTY);
            年額保険料.set公式(RString.EMPTY);
            年額保険料.set月割年額保険料額(RString.EMPTY);
        } else {
            年額保険料.set十二ヶ月分年度加算額(get月別年額保険料合計(年額保険料));
            年額保険料.set公式(公式);
            年額保険料.set月割年額保険料額(format金額_パターン(賦課の情報.get賦課情報().get減免前介護保険料_年額()));
        }
        if (前後区分) {
            編集後本算定賦課台帳情報.set本算定賦課内訳２更正後年額保険料(年額保険料);
        } else {
            編集後本算定賦課台帳情報.set本算定賦課内訳２更正前年額保険料(年額保険料);
        }
    }

    private void set本算定賦課内訳_所得段階(boolean 前後区分, FukaAtena 賦課の情報, EditedHonSanteiFukaDaichoJoho 編集後本算定賦課台帳情報) {

        if (賦課の情報 == null) {
            return;
        }
        HonSanteifukaUchiwakeNi 所得段階 = new HonSanteifukaUchiwakeNi();
        所得段階.set四月分所得段階(get月分所得段階(賦課の情報, 期_4));
        所得段階.set五月分所得段階(get月分所得段階(賦課の情報, 期_5));
        所得段階.set六月分所得段階(get月分所得段階(賦課の情報, 期_6));
        所得段階.set七月分所得段階(get月分所得段階(賦課の情報, 期_7));
        所得段階.set八月分所得段階(get月分所得段階(賦課の情報, 期_8));
        所得段階.set九月分所得段階(get月分所得段階(賦課の情報, 期_9));
        所得段階.set十月分所得段階(get月分所得段階(賦課の情報, 期_10));
        所得段階.set十一月分所得段階(get月分所得段階(賦課の情報, 期_11));
        所得段階.set十二月分所得段階(get月分所得段階(賦課の情報, 期_12));
        所得段階.set一月分所得段階(get所得段階(賦課の情報, 期_1));
        所得段階.set二月分所得段階(get所得段階(賦課の情報, 期_2));
        所得段階.set三月分所得段階(get所得段階(賦課の情報, 期_3));
        所得段階.set十二ヶ月分年度加算額(RString.EMPTY);
        所得段階.set公式(RString.EMPTY);
        所得段階.set月割年額保険料額(RString.EMPTY);
        if (前後区分) {
            編集後本算定賦課台帳情報.set本算定賦課内訳２更正後所得段階(所得段階);
        } else {
            編集後本算定賦課台帳情報.set本算定賦課内訳２更正前所得段階(所得段階);
        }
    }

    private RString get月別年額保険料合計(HonSanteifukaUchiwakeNi 年額保険料) {

        return format金額_パターン(get月分保険料額(年額保険料.get一月分保険料額()).add(get月分保険料額(年額保険料.get二月分保険料額()))
                .add(get月分保険料額(年額保険料.get三月分保険料額())).add(get月分保険料額(年額保険料.get四月分保険料額()))
                .add(get月分保険料額(年額保険料.get五月分保険料額())).add(get月分保険料額(年額保険料.get六月分保険料額()))
                .add(get月分保険料額(年額保険料.get七月分保険料額())).add(get月分保険料額(年額保険料.get八月分保険料額()))
                .add(get月分保険料額(年額保険料.get九月分保険料額())).add(get月分保険料額(年額保険料.get十月分保険料額()))
                .add(get月分保険料額(年額保険料.get十一月分保険料額())).add(get月分保険料額(年額保険料.get十二月分保険料額())));
    }

    private Decimal get月分保険料額(RString 月分保険料額) {
        if (RString.isNullOrEmpty(月分保険料額)) {
            return Decimal.ZERO;
        }
        return new Decimal(月分保険料額.replace(FORMAT_符号, RString.EMPTY).toString());
    }

    private RString get月分所得段階(FukaAtena 賦課の情報, RString 月) {

        if (賦課の情報.get賦課情報().get月割開始年月2() != null && !賦課の情報.get賦課情報().get月割開始年月2().isEmpty()
                && 賦課の情報.get賦課情報().get月割開始年月2()
                .isBeforeOrEquals(new FlexibleYearMonth(賦課の情報.get賦課情報().get賦課年度().toDateString().concat(月.padZeroToLeft(2))))) {
            return 賦課の情報.get賦課情報().get保険料算定段階2();
        } else if (賦課の情報.get賦課情報().get月割開始年月1() != null && !賦課の情報.get賦課情報().get月割開始年月1().isEmpty()
                && 賦課の情報.get賦課情報().get月割開始年月1()
                .isBeforeOrEquals(new FlexibleYearMonth(賦課の情報.get賦課情報().get賦課年度().toDateString().concat(月.padZeroToLeft(2))))) {
            return 賦課の情報.get賦課情報().get保険料算定段階1();
        }
        return RString.EMPTY;
    }

    private RString get所得段階(FukaAtena 賦課の情報, RString 月) {

        if (賦課の情報.get賦課情報().get月割開始年月2() != null && !賦課の情報.get賦課情報().get月割開始年月2().isEmpty()
                && 賦課の情報.get賦課情報().get月割開始年月2()
                .isBeforeOrEquals(new FlexibleYearMonth(賦課の情報.get賦課情報().get賦課年度()
                                .plusYear(INT_1).toDateString().concat(月.padZeroToLeft(2))))) {
            return 賦課の情報.get賦課情報().get保険料算定段階2();
        } else if (賦課の情報.get賦課情報().get月割開始年月1() != null && !賦課の情報.get賦課情報().get月割開始年月1().isEmpty()
                && 賦課の情報.get賦課情報().get月割開始年月1()
                .isBeforeOrEquals(new FlexibleYearMonth(賦課の情報.get賦課情報().get賦課年度()
                                .plusYear(INT_1).toDateString().concat(月.padZeroToLeft(2))))) {
            return 賦課の情報.get賦課情報().get保険料算定段階1();
        }
        return RString.EMPTY;
    }

    private RString get月分保険料額(FukaAtena 賦課の情報, RString 月) {

        if (賦課の情報.get賦課情報().get月割開始年月2() != null && !賦課の情報.get賦課情報().get月割開始年月2().isEmpty()
                && 賦課の情報.get賦課情報().get月割開始年月2()
                .isBeforeOrEquals(new FlexibleYearMonth(賦課の情報.get賦課情報().get賦課年度().toDateString().concat(月.padZeroToLeft(2))))) {
            return format金額_パターン(賦課の情報.get賦課情報().get算定年額保険料2());
        } else if (賦課の情報.get賦課情報().get月割開始年月1() != null && !賦課の情報.get賦課情報().get月割開始年月1().isEmpty()
                && 賦課の情報.get賦課情報().get月割開始年月1()
                .isBeforeOrEquals(new FlexibleYearMonth(賦課の情報.get賦課情報().get賦課年度().toDateString().concat(月.padZeroToLeft(2))))) {
            return format金額_パターン(賦課の情報.get賦課情報().get算定年額保険料1());
        }
        return RString.EMPTY;
    }

    private RString get保険料額(FukaAtena 賦課の情報, RString 月) {

        if (賦課の情報.get賦課情報().get月割開始年月2() != null && !賦課の情報.get賦課情報().get月割開始年月2().isEmpty()
                && 賦課の情報.get賦課情報().get月割開始年月2()
                .isBeforeOrEquals(new FlexibleYearMonth(賦課の情報.get賦課情報().get賦課年度()
                                .plusYear(INT_1).toDateString().concat(月.padZeroToLeft(2))))) {
            return format金額_パターン(賦課の情報.get賦課情報().get算定年額保険料2());
        } else if (賦課の情報.get賦課情報().get月割開始年月1() != null && !賦課の情報.get賦課情報().get月割開始年月1().isEmpty()
                && 賦課の情報.get賦課情報().get月割開始年月1()
                .isBeforeOrEquals(new FlexibleYearMonth(賦課の情報.get賦課情報().get賦課年度()
                                .plusYear(INT_1).toDateString().concat(月.padZeroToLeft(2))))) {
            return format金額_パターン(賦課の情報.get賦課情報().get算定年額保険料1());
        }
        return RString.EMPTY;
    }

    private void set編集後仮算定賦課台帳情報(EditedKariSanteiFukaDaichoJoho 編集後仮算定賦課台帳情報, FukaDaichoInfo 賦課台帳情報) {

        if (賦課台帳情報 == null || 賦課台帳情報.get賦課の情報_更正後() == null) {
            return;
        }
        FukaAtena 賦課の情報_更正後 = 賦課台帳情報.get賦課の情報_更正後();
        FukaAtena 賦課の情報_更正前 = 賦課台帳情報.get賦課の情報_更正前();
        EditedKojin 本人個人 = null;
        if (賦課台帳情報.get帳票制御共通() != null && 賦課の情報_更正後.get宛名() != null) {
            本人個人 = new EditedKojin(賦課の情報_更正後.get宛名(), 賦課台帳情報.get帳票制御共通(), null);
        }
        EditedKojin 本人個人_更正前 = null;
        if (賦課の情報_更正前 != null && 賦課台帳情報.get帳票制御共通() != null && 賦課の情報_更正前.get宛名() != null) {
            本人個人_更正前 = new EditedKojin(賦課の情報_更正前.get宛名(), 賦課台帳情報.get帳票制御共通(), null);
        }

        HyojiCodes 表示コード情報 = get表示コード情報(賦課台帳情報);

        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        List<Kitsuki> 普徴期月リスト = 期月リスト_普徴.toList();
        TokuchoKiUtil 月期対応取得_特徴 = new TokuchoKiUtil();
        KitsukiList 期月リスト_特徴 = 月期対応取得_特徴.get期月リスト();
        List<Kitsuki> 特徴期月リスト = 期月リスト_特徴.toList();

        FutsuChoshuKi 普徴期情報 = create普徴期情報(普徴期月リスト);
        FutsuChoshuTsuki 普徴月情報 = create普徴月情報(普徴期月リスト);
        FutsuChoshuZuiji 随時情報 = create随時情報(GennenKanen.現年度, 普徴期月リスト);
        List<SetaInJoho> 世帯員情報リスト = create世帯員情報リスト(賦課台帳情報.get世帯員所得情報(), 賦課の情報_更正後.get宛名().is日本人());
        TokubetsuChoshuKi 特徴期情報 = create特徴期情報(GennenKanen.現年度, 特徴期月リスト);
        TokubetsuChoshuTsuki 特徴月情報 = create特徴月情報(GennenKanen.現年度, 特徴期月リスト);
        Kitsuki 最終法定納期 = 期月リスト_普徴.get最終法定納期();
        Decimal 前年度普通徴収最終期保険料 = get前年度普通徴収最終期保険料(賦課台帳情報.get前年度情報(), 最終法定納期);
        RString 受給情報 = create受給情報(賦課台帳情報.get受給者台帳情報(), 賦課台帳情報.get支払方法変更リスト());

        if (表示コード情報 != null) {
            編集後仮算定賦課台帳情報.set表示コード１(表示コード情報.get表示コード１());
            編集後仮算定賦課台帳情報.set表示コード２(表示コード情報.get表示コード２());
            編集後仮算定賦課台帳情報.set表示コード３(表示コード情報.get表示コード３());
            編集後仮算定賦課台帳情報.set表示コード名称１(表示コード情報.get表示コード名１());
            編集後仮算定賦課台帳情報.set表示コード名称２(表示コード情報.get表示コード名２());
            編集後仮算定賦課台帳情報.set表示コード名称３(表示コード情報.get表示コード名３());
        }
        編集後仮算定賦課台帳情報.set受給情報(受給情報);
        編集後仮算定賦課台帳情報.set普徴期(普徴期情報);
        編集後仮算定賦課台帳情報.set普徴月(普徴月情報);
        編集後仮算定賦課台帳情報.set普徴随時(随時情報);
        set普通徴収_仮算定(false, 賦課の情報_更正前, 賦課台帳情報.get収入情報(), 期月リスト_普徴, 編集後仮算定賦課台帳情報);
        set普通徴収_仮算定(true, 賦課の情報_更正後, 賦課台帳情報.get収入情報(), 期月リスト_普徴, 編集後仮算定賦課台帳情報);
        set普通徴収_増減額(編集後仮算定賦課台帳情報);
        set普通徴収_収入額(賦課台帳情報.get収入情報(), 編集後仮算定賦課台帳情報);
        set本人_更正前後(false, 賦課の情報_更正前, 賦課台帳情報.get被保険者台帳情報(), 本人個人_更正前, 編集後仮算定賦課台帳情報);
        set本人_更正前後(true, 賦課の情報_更正後, 賦課台帳情報.get被保険者台帳情報(), 本人個人, 編集後仮算定賦課台帳情報);
        編集後仮算定賦課台帳情報.set世帯員情報リスト(世帯員情報リスト);
        編集後仮算定賦課台帳情報.set特徴期(特徴期情報);
        編集後仮算定賦課台帳情報.set特徴月(特徴月情報);
        set特別徴収_仮算定(false, 賦課の情報_更正前, 賦課台帳情報.get収入情報(), 期月リスト_特徴, 編集後仮算定賦課台帳情報);
        set特別徴収_仮算定(true, 賦課の情報_更正後, 賦課台帳情報.get収入情報(), 期月リスト_特徴, 編集後仮算定賦課台帳情報);
        set特別徴収_増減額(編集後仮算定賦課台帳情報);
        set特別徴収_収入額(賦課台帳情報.get収入情報(), 編集後仮算定賦課台帳情報);
        set仮算定内訳(false, 賦課の情報_更正前, 編集後仮算定賦課台帳情報);
        set仮算定内訳(true, 賦課の情報_更正後, 編集後仮算定賦課台帳情報);
        編集後仮算定賦課台帳情報.set印刷日時(RDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(RString.HALF_SPACE)
                .concat(RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒)).
                concat(RString.HALF_SPACE).concat(定値_作成));
        編集後仮算定賦課台帳情報.set世帯コード(賦課の情報_更正後.get賦課情報().get世帯コード() != null
                ? 賦課の情報_更正後.get賦課情報().get世帯コード().getColumnValue() : RString.EMPTY);
        編集後仮算定賦課台帳情報.setタイトル(定値_仮算定タイトル);
        編集後仮算定賦課台帳情報.set通知書NO(賦課の情報_更正後.get賦課情報().get通知書番号() != null
                ? 賦課の情報_更正後.get賦課情報().get通知書番号().getColumnValue() : RString.EMPTY);
        編集後仮算定賦課台帳情報.set前年度普通徴収最終期保険料(format金額(前年度普通徴収最終期保険料));
        if (賦課台帳情報.get前年度情報() != null) {
            編集後仮算定賦課台帳情報.set前年度年額保険料(format金額(賦課台帳情報.get前年度情報().get確定介護保険料_年額()));
            編集後仮算定賦課台帳情報.set前年度保険料率(賦課台帳情報.get前年度情報().get算定年額保険料2() != null
                    ? format金額(賦課台帳情報.get前年度情報().get算定年額保険料2())
                    : format金額(賦課台帳情報.get前年度情報().get算定年額保険料1()));
            編集後仮算定賦課台帳情報.set前年度取得段階(!RString.isNullOrEmpty(賦課台帳情報.get前年度情報().get保険料算定段階2())
                    ? 賦課台帳情報.get前年度情報().get保険料算定段階2() : 賦課台帳情報.get前年度情報().get保険料算定段階1());
            編集後仮算定賦課台帳情報.set前年度特別徴収最終期保険料(format金額(賦課台帳情報.get前年度情報().get特徴期別金額06()));
        }
    }

    private HyojiCodes get表示コード情報(FukaDaichoInfo 賦課台帳情報) {

        FukaAtena 賦課の情報_更正後 = 賦課台帳情報.get賦課の情報_更正後();
        HyojiCodeResearcher hyojiCodeResearcher = HyojiCodeResearcher.createInstance();
        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通情報 = null;
        if (賦課台帳情報.get帳票制御共通() != null) {
            帳票制御共通情報 = 賦課台帳情報.get帳票制御共通().toEntity();
        }
        if (帳票制御共通情報 == null) {
            return null;
        }
        return hyojiCodeResearcher.create表示コード情報(帳票制御共通情報,
                賦課の情報_更正後.get宛名() != null && 賦課の情報_更正後.get宛名().toEntity() != null
                ? get町域コード(賦課の情報_更正後.get宛名().toEntity().getChoikiCode()) : RString.EMPTY,
                賦課の情報_更正後.get宛名() != null && 賦課の情報_更正後.get宛名().toEntity() != null
                ? get行政区コード(賦課の情報_更正後.get宛名().toEntity().getGyoseikuCode()) : RString.EMPTY,
                賦課の情報_更正後.get宛名() != null && 賦課の情報_更正後.get宛名().get行政区画() != null
                && 賦課の情報_更正後.get宛名().get行政区画().getChiku1() != null
                ? 賦課の情報_更正後.get宛名().get行政区画().getChiku1().getコード().getColumnValue() : RString.EMPTY,
                賦課の情報_更正後.get宛名() != null && 賦課の情報_更正後.get宛名().get行政区画() != null
                && 賦課の情報_更正後.get宛名().get行政区画().getChiku2() != null
                ? 賦課の情報_更正後.get宛名().get行政区画().getChiku2().getコード().getColumnValue() : RString.EMPTY,
                賦課の情報_更正後.get宛名() != null && 賦課の情報_更正後.get宛名().get行政区画() != null
                && 賦課の情報_更正後.get宛名().get行政区画().getChiku3() != null
                ? 賦課の情報_更正後.get宛名().get行政区画().getChiku3().getコード().getColumnValue() : RString.EMPTY,
                賦課台帳情報.get納組情報() != null && 賦課台帳情報.get納組情報().getNokumi() != null
                ? 賦課台帳情報.get納組情報().getNokumi().getNokumiCode() : RString.EMPTY);
    }

    private void set仮算定変更事由(EditedKariSanteiFukaDaichoJoho 編集後仮算定賦課台帳情報, List<RString> 変更事由リスト) {

        編集後仮算定賦課台帳情報.set変更事由1(RString.EMPTY);
        編集後仮算定賦課台帳情報.set変更事由2(RString.EMPTY);
        編集後仮算定賦課台帳情報.set変更事由3(RString.EMPTY);
        編集後仮算定賦課台帳情報.set変更事由4(RString.EMPTY);

        if (変更事由リスト != null && !変更事由リスト.isEmpty()) {
            int index = 0;
            for (RString 変更事由 : 変更事由リスト) {
                index = index + 1;
                RString 略称 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBB介護賦課, DBBCodeShubetsu.変更事由.getコード(), new Code(変更事由));
                switch (index) {
                    case INT_1:
                        編集後仮算定賦課台帳情報.set変更事由1(略称);
                        break;
                    case INT_2:
                        編集後仮算定賦課台帳情報.set変更事由2(略称);
                        break;
                    case INT_3:
                        編集後仮算定賦課台帳情報.set変更事由3(略称);
                        break;
                    case INT_4:
                        編集後仮算定賦課台帳情報.set変更事由4(略称);
                        break;
                    default:
                }
            }
        }
    }

    private void set本算定変更事由(EditedHonSanteiFukaDaichoJoho 編集後本算定賦課台帳情報, List<RString> 変更事由リスト) {

        編集後本算定賦課台帳情報.set変更事由1(RString.EMPTY);
        編集後本算定賦課台帳情報.set変更事由2(RString.EMPTY);
        編集後本算定賦課台帳情報.set変更事由3(RString.EMPTY);
        編集後本算定賦課台帳情報.set変更事由4(RString.EMPTY);

        if (変更事由リスト != null && !変更事由リスト.isEmpty()) {
            int index = 0;
            for (RString 変更事由 : 変更事由リスト) {
                index = index + 1;
                RString 略称 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBB介護賦課, DBBCodeShubetsu.変更事由.getコード(), new Code(変更事由));
                switch (index) {
                    case INT_1:
                        編集後本算定賦課台帳情報.set変更事由1(略称);
                        break;
                    case INT_2:
                        編集後本算定賦課台帳情報.set変更事由2(略称);
                        break;
                    case INT_3:
                        編集後本算定賦課台帳情報.set変更事由3(略称);
                        break;
                    case INT_4:
                        編集後本算定賦課台帳情報.set変更事由4(略称);
                        break;
                    default:
                }
            }
        }
    }

    private void set仮算定内訳(boolean 前後区分, FukaAtena 賦課の情報, EditedKariSanteiFukaDaichoJoho 編集後仮算定賦課台帳情報) {

        if (賦課の情報 == null) {
            return;
        }
        KaliSanteiUchiwake 仮算定内訳 = new KaliSanteiUchiwake();
        仮算定内訳.set仮算定保険料額(format金額(賦課の情報.get賦課情報().get減免前介護保険料_年額()));
        仮算定内訳.set減免額(format金額(賦課の情報.get賦課情報().get減免額()));
        仮算定内訳.set仮算定確定保険料(format金額(賦課の情報.get賦課情報().get確定介護保険料_年額()));
        仮算定内訳.set賦課基準日(賦課の情報.get賦課情報().get賦課期日() != null && !賦課の情報.get賦課情報().get賦課期日().isEmpty()
                ? get年月日(賦課の情報.get賦課情報().get賦課期日()) : RString.EMPTY);
        仮算定内訳.set調定年月日(賦課の情報.get賦課情報().get調定日時() != null && !賦課の情報.get賦課情報().get調定日時().isEmpty()
                ? 賦課の情報.get賦課情報().get調定日時().getDate().wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString() : RString.EMPTY);
        if (前後区分) {
            編集後仮算定賦課台帳情報.set仮算定内訳更正後(仮算定内訳);
        } else {
            編集後仮算定賦課台帳情報.set仮算定内訳更正前(仮算定内訳);
        }
    }

    private void set本人_更正前後(boolean 前後区分, FukaAtena 賦課の情報, DbT1001HihokenshaDaichoEntity 被保険者台帳情報,
            EditedKojin 本人個人, EditedKariSanteiFukaDaichoJoho 編集後仮算定賦課台帳情報) {

        Honnin 本人 = new Honnin();
        if (賦課の情報 == null) {
            本人.set本人資格取得日(RString.EMPTY);
            本人.set本人取得事由(RString.EMPTY);
            本人.set本人資格喪失日(RString.EMPTY);
            本人.set本人喪失事由(RString.EMPTY);
            本人.set本人住所地特例(RString.EMPTY);
            本人.set本人生活保護開始年月日(RString.EMPTY);
            本人.set本人生活保護終了年月日(RString.EMPTY);
            本人.set本人老齢年金開始年月日(RString.EMPTY);
            本人.set本人老齢年金終了年月日(RString.EMPTY);
            本人.set本人識別コード(RString.EMPTY);
            本人.set本人氏名(RString.EMPTY);
            本人.set本人性別(RString.EMPTY);
            本人.set本人生年月日(RString.EMPTY);
            本人.set本人続柄(RString.EMPTY);
            本人.set本人合計取得金額(RString.EMPTY);
            本人.set本人課税区分(RString.EMPTY);
            編集後仮算定賦課台帳情報.set本人更正前(本人);
            return;
        }
        本人 = get本人_更正前後(賦課の情報, 被保険者台帳情報, 本人個人);
        if (本人個人 != null) {
            本人.set本人生年月日(本人個人.get生年月日_パターン());
        }
        本人.set本人合計取得金額(format金額(賦課の情報.get賦課情報().get合計所得金額()));
        本人.set本人課税区分(!RString.isNullOrEmpty(賦課の情報.get賦課情報().get課税区分())
                ? KazeiKubun.toValue(賦課の情報.get賦課情報().get課税区分()).get名称() : RString.EMPTY);
        if (前後区分) {
            編集後仮算定賦課台帳情報.set本人更正後(本人);
        } else {
            編集後仮算定賦課台帳情報.set本人更正前(本人);
        }
    }

    private void set本人_更正前後(boolean 前後区分, FukaAtena 賦課の情報, DbT1001HihokenshaDaichoEntity 被保険者台帳情報,
            DbT1006KyokaisoGaitoshaEntity 境界層当該者情報, EditedKojin 本人個人, EditedHonSanteiFukaDaichoJoho 編集後本算定賦課台帳情報) {

        Honnin 本人 = new Honnin();
        if (賦課の情報 == null) {
            本人.set本人資格取得日(RString.EMPTY);
            本人.set本人取得事由(RString.EMPTY);
            本人.set本人資格喪失日(RString.EMPTY);
            本人.set本人喪失事由(RString.EMPTY);
            本人.set本人住所地特例(RString.EMPTY);
            本人.set本人生活保護開始年月日(RString.EMPTY);
            本人.set本人生活保護終了年月日(RString.EMPTY);
            本人.set本人老齢年金開始年月日(RString.EMPTY);
            本人.set本人老齢年金終了年月日(RString.EMPTY);
            本人.set本人識別コード(RString.EMPTY);
            本人.set本人氏名(RString.EMPTY);
            本人.set本人性別(RString.EMPTY);
            本人.set本人生年月日(RString.EMPTY);
            本人.set本人続柄(RString.EMPTY);
            本人.set本人合計取得金額(RString.EMPTY);
            本人.set本人課税区分(RString.EMPTY);
            編集後本算定賦課台帳情報.set本人更正前(本人);
            return;
        }
        本人 = get本人_更正前後(賦課の情報, 被保険者台帳情報, 本人個人);
        if (本人個人 != null) {
            本人.set本人生年月日(本人個人.get生年月日For帳票());
        }
        if (境界層当該者情報 != null && 前後区分) {
            本人.set本人限界層該当開始年月日(get年月日(境界層当該者情報.getTekiyoKaishiYMD()));
            本人.set本人限界層該当終了年月日(get年月日(境界層当該者情報.getTekiyoShuryoYMD()));
        }
        if (前後区分) {
            編集後本算定賦課台帳情報.set本人更正後(本人);
        } else {
            編集後本算定賦課台帳情報.set本人更正前(本人);
        }
    }

    private Honnin get本人_更正前後(FukaAtena 賦課の情報, DbT1001HihokenshaDaichoEntity 被保険者台帳情報, EditedKojin 本人個人) {

        Honnin 本人 = new Honnin();
        本人.set本人資格取得日(get年月日(賦課の情報.get賦課情報().get資格取得日()));
        if (賦課の情報.get賦課情報().get資格取得事由() != null && !賦課の情報.get賦課情報().get資格取得事由().isEmpty()) {
            RString 本人取得事由 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格,
                    DBACodeShubetsu.介護資格取得事由_被保険者.getコード(), new Code(賦課の情報.get賦課情報().get資格取得事由()));
            本人.set本人取得事由(本人取得事由);
        }
        本人.set本人資格喪失日(get年月日(賦課の情報.get賦課情報().get資格喪失日()));
        if (賦課の情報.get賦課情報().get資格喪失事由() != null && !賦課の情報.get賦課情報().get資格喪失事由().isEmpty()) {
            RString 本人喪失事由 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格,
                    DBACodeShubetsu.介護資格喪失事由_被保険者.getコード(), new Code(賦課の情報.get賦課情報().get資格喪失事由()));
            本人.set本人喪失事由(本人喪失事由);
        }
        if (被保険者台帳情報 != null) {
            本人.set本人住所地特例(期_1.equals(被保険者台帳情報.getJushochiTokureiFlag()) ? 定数_住特 : RString.EMPTY);
        }
        本人.set本人生活保護開始年月日(get年月日(賦課の情報.get賦課情報().get生保開始日()));
        本人.set本人生活保護終了年月日(get年月日(賦課の情報.get賦課情報().get生保廃止日()));
        本人.set本人老齢年金開始年月日(get年月日(賦課の情報.get賦課情報().get老年開始日()));
        本人.set本人老齢年金終了年月日(get年月日(賦課の情報.get賦課情報().get老年廃止日()));
        if (本人個人 != null) {
            本人.set本人識別コード(本人個人.get識別コード().getColumnValue());
            本人.set本人氏名(本人個人.get名称().getName().getColumnValue());
            本人.set本人性別(本人個人.get性別());
            本人.set本人続柄(本人個人.get続柄());
        }
        return 本人;
    }

    /**
     * 年月日を返します。
     *
     * @return 年月日 RString
     */
    private RString get年月日(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return 年月日.wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private void set特別徴収_仮算定(boolean 前後区分, FukaAtena 賦課の情報, ShunyuJoho 収入情報,
            KitsukiList 期月リスト_特徴, EditedKariSanteiFukaDaichoJoho 編集後仮算定賦課台帳情報) {

        if (賦課の情報 == null) {
            return;
        }
        FukaJoho 賦課情報 = 賦課の情報.get賦課情報();
        TokubetsuChoshu 特別徴収 = get特別徴収(前後区分, 賦課の情報, 収入情報, 期月リスト_特徴, 編集後仮算定賦課台帳情報.get特徴期());
        Decimal 特別期別合計 = get特徴仮算定保険料(賦課情報, INT_1, INT_6);
        特別徴収.set特徴仮算定保険料(DecimalFormatter.toコンマ区切りRString(特別期別合計, 0));
        if (前後区分) {
            編集後仮算定賦課台帳情報.set特別徴収更正後(特別徴収);
        } else {
            編集後仮算定賦課台帳情報.set特別徴収更正前(特別徴収);
        }
    }

    private void set特別徴収_本算定(boolean 前後区分, FukaAtena 賦課の情報, ShunyuJoho 収入情報,
            KitsukiList 期月リスト_特徴, EditedHonSanteiFukaDaichoJoho 編集後本算定賦課台帳情報) {

        if (賦課の情報 == null) {
            return;
        }
        FukaJoho 賦課情報 = 賦課の情報.get賦課情報();
        TokubetsuChoshu 特別徴収 = get特別徴収(前後区分, 賦課の情報, 収入情報, 期月リスト_特徴, 編集後本算定賦課台帳情報.get特徴期());
        Decimal 特別期別合計 = get特徴仮算定保険料(賦課情報, INT_1, INT_6);
        特別徴収.set特徴確定年額保険料(DecimalFormatter.toコンマ区切りRString(特別期別合計, 0));
        特別徴収.set調整額歳出還付(format金額_パターン(賦課情報.get特徴歳出還付額()));
        if (前後区分) {
            編集後本算定賦課台帳情報.set特別徴収更正後(特別徴収);
        } else {
            編集後本算定賦課台帳情報.set特別徴収更正前(特別徴収);
        }
    }

    private TokubetsuChoshu get特別徴収(boolean 前後区分, FukaAtena 賦課の情報, ShunyuJoho 収入情報,
            KitsukiList 期月リスト_特徴, TokubetsuChoshuKi 特徴期) {

        FukaJoho 賦課情報 = 賦課の情報.get賦課情報();
        TokubetsuChoshu 特別徴収 = new TokubetsuChoshu();
        特別徴収.set特徴調定月(new RString(賦課情報.get調定日時().getMonthValue()).concat(FORMAT_月));
        特別徴収.set特徴調定月の期(FORMAT_LEFT.concat(期月リスト_特徴.get月の期(Tsuki.toValue(new RString(賦課情報.get調定日時().getMonthValue())
                .padZeroToLeft(INT_2))).get期()).concat(FORMAT_RIGHT));
        Decimal 特別期別合計 = get特徴仮算定保険料(賦課情報, INT_1, INT_6);
        特別徴収.set特徴仮算定保険料(DecimalFormatter.toコンマ区切りRString(特別期別合計, 0));
        if (前後区分) {
            Decimal 特別収入合計 = get特徴収入済額(収入情報, INT_1, INT_6);
            特別徴収.set特徴納付済額(DecimalFormatter.toコンマ区切りRString(特別収入合計, 0));
            特別徴収.set特徴今後納付すべき額(DecimalFormatter
                    .toコンマ区切りRString(new Decimal(特別期別合計.intValue() - 特別収入合計.intValue()), 0));
        } else {
            特別徴収.set特徴納付済額(RString.EMPTY);
            特別徴収.set特徴今後納付すべき額(RString.EMPTY);
        }
        特別徴収.set特徴金額１(RString.EMPTY);
        特別徴収.set特徴金額２(RString.EMPTY);
        特別徴収.set特徴金額３(RString.EMPTY);
        特別徴収.set特徴金額４(RString.EMPTY);
        特別徴収.set特徴金額５(RString.EMPTY);
        特別徴収.set特徴金額６(RString.EMPTY);
        特別徴収.set特徴金額７(RString.EMPTY);
        特別徴収.set特徴金額８(RString.EMPTY);
        特別徴収.set特徴金額９(RString.EMPTY);
        特別徴収.set特徴金額１０(RString.EMPTY);
        特別徴収.set特徴金額１１(RString.EMPTY);
        特別徴収.set特徴金額１２(RString.EMPTY);
        特別徴収.set特徴金額１３(RString.EMPTY);
        特別徴収.set特徴金額１４(RString.EMPTY);
        if (!RString.isNullOrEmpty(特徴期.get特徴期１())) {
            特別徴収.set特徴金額１(format金額(賦課情報.get特徴期別金額01()));
        }
        if (!RString.isNullOrEmpty(特徴期.get特徴期２())) {
            特別徴収.set特徴金額２(format金額(賦課情報.get特徴期別金額02()));
        }
        if (!RString.isNullOrEmpty(特徴期.get特徴期３())) {
            特別徴収.set特徴金額３(format金額(賦課情報.get特徴期別金額03()));
        }
        if (!RString.isNullOrEmpty(特徴期.get特徴期４())) {
            特別徴収.set特徴金額４(format金額(賦課情報.get特徴期別金額04()));
        }
        if (!RString.isNullOrEmpty(特徴期.get特徴期５())) {
            特別徴収.set特徴金額５(format金額(賦課情報.get特徴期別金額05()));
        }
        if (!RString.isNullOrEmpty(特徴期.get特徴期６())) {
            特別徴収.set特徴金額６(format金額(賦課情報.get特徴期別金額06()));
        }
        return 特別徴収;
    }

    private void set普通徴収_仮算定(boolean 前後区分, FukaAtena 賦課の情報, ShunyuJoho 収入情報,
            KitsukiList 期月リスト_普徴, EditedKariSanteiFukaDaichoJoho 編集後仮算定賦課台帳情報) {

        if (賦課の情報 == null) {
            return;
        }
        FukaJoho 賦課情報 = 賦課の情報.get賦課情報();
        FutsuChoshu 普通徴収 = get普通徴収(前後区分, 賦課の情報, 収入情報, 期月リスト_普徴, 編集後仮算定賦課台帳情報.get普徴期());
        Decimal 普徴期別合計 = get普徴納付済額(賦課情報, INT_1, INT_14);
        普通徴収.set普徴仮算定保険料(DecimalFormatter.toコンマ区切りRString(普徴期別合計, 0));

        if (前後区分) {
            編集後仮算定賦課台帳情報.set普通徴収更正後(普通徴収);
        } else {
            編集後仮算定賦課台帳情報.set普通徴収更正前(普通徴収);
        }
    }

    private void set普通徴収_本算定(boolean 前後区分, FukaAtena 賦課の情報, ShunyuJoho 収入情報,
            KitsukiList 期月リスト_普徴, EditedHonSanteiFukaDaichoJoho 編集後本算定賦課台帳情報) {

        if (賦課の情報 == null) {
            return;
        }
        FukaJoho 賦課情報 = 賦課の情報.get賦課情報();
        FutsuChoshu 普通徴収 = get普通徴収(前後区分, 賦課の情報, 収入情報, 期月リスト_普徴, 編集後本算定賦課台帳情報.get普徴期());
        Decimal 普徴期別合計 = get普徴納付済額(賦課情報, INT_1, INT_14);
        普通徴収.set普徴確定年額保険料(DecimalFormatter.toコンマ区切りRString(普徴期別合計, 0));
        普通徴収.set調整額歳出還付(format金額(賦課情報.get普徴歳出還付額()));
        if (前後区分) {
            編集後本算定賦課台帳情報.set普通徴収更正後(普通徴収);
        } else {
            編集後本算定賦課台帳情報.set普通徴収更正前(普通徴収);
        }
    }

    private FutsuChoshu get普通徴収(boolean 前後区分, FukaAtena 賦課の情報, ShunyuJoho 収入情報,
            KitsukiList 期月リスト_普徴, FutsuChoshuKi 普徴期) {

        FukaJoho 賦課情報 = 賦課の情報.get賦課情報();
        FutsuChoshu 普通徴収 = new FutsuChoshu();
        普通徴収.set普徴調定月(new RString(賦課情報.get調定日時().getMonthValue()).concat(FORMAT_月));
        普通徴収.set普徴調定月の期(FORMAT_LEFT.concat(期月リスト_普徴.get月の期(Tsuki.toValue(new RString(賦課情報.get調定日時().getMonthValue())
                .padZeroToLeft(INT_2))).get期()).concat(FORMAT_RIGHT));
        Decimal 普徴期別合計 = get普徴納付済額(賦課情報, INT_1, INT_14);
        普通徴収.set普徴確定年額保険料(DecimalFormatter.toコンマ区切りRString(普徴期別合計, 0));
        if (前後区分) {
            Decimal 普徴収入合計 = get普徴収入済額(収入情報, INT_1, INT_14);
            普通徴収.set普徴納付済額(DecimalFormatter.toコンマ区切りRString(普徴収入合計, 0));
            普通徴収.set普徴今後納付すべき額(DecimalFormatter
                    .toコンマ区切りRString(new Decimal(普徴期別合計.intValue() - 普徴収入合計.intValue()), 0));
        } else {
            普通徴収.set普徴納付済額(RString.EMPTY);
            普通徴収.set普徴今後納付すべき額(RString.EMPTY);
        }
        普通徴収.set普徴金額１(RString.EMPTY);
        普通徴収.set普徴金額２(RString.EMPTY);
        普通徴収.set普徴金額３(RString.EMPTY);
        普通徴収.set普徴金額４(RString.EMPTY);
        普通徴収.set普徴金額５(RString.EMPTY);
        普通徴収.set普徴金額６(RString.EMPTY);
        普通徴収.set普徴金額７(RString.EMPTY);
        普通徴収.set普徴金額８(RString.EMPTY);
        普通徴収.set普徴金額９(RString.EMPTY);
        普通徴収.set普徴金額１０(RString.EMPTY);
        普通徴収.set普徴金額１１(RString.EMPTY);
        普通徴収.set普徴金額１２(RString.EMPTY);
        普通徴収.set普徴金額１３(RString.EMPTY);
        普通徴収.set普徴金額１４(RString.EMPTY);
        if (!RString.isNullOrEmpty(普徴期.get普徴期１())) {
            普通徴収.set普徴金額１(format金額(賦課情報.get普徴期別金額01()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期２())) {
            普通徴収.set普徴金額２(format金額(賦課情報.get普徴期別金額02()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期３())) {
            普通徴収.set普徴金額３(format金額(賦課情報.get普徴期別金額03()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期４())) {
            普通徴収.set普徴金額４(format金額(賦課情報.get普徴期別金額04()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期５())) {
            普通徴収.set普徴金額５(format金額(賦課情報.get普徴期別金額05()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期６())) {
            普通徴収.set普徴金額６(format金額(賦課情報.get普徴期別金額06()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期７())) {
            普通徴収.set普徴金額７(format金額(賦課情報.get普徴期別金額07()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期８())) {
            普通徴収.set普徴金額８(format金額(賦課情報.get普徴期別金額08()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期９())) {
            普通徴収.set普徴金額９(format金額(賦課情報.get普徴期別金額09()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期１０())) {
            普通徴収.set普徴金額１０(format金額(賦課情報.get普徴期別金額10()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期１１())) {
            普通徴収.set普徴金額１１(format金額(賦課情報.get普徴期別金額11()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期１２())) {
            普通徴収.set普徴金額１２(format金額(賦課情報.get普徴期別金額12()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期１３())) {
            普通徴収.set普徴金額１３(format金額(賦課情報.get普徴期別金額13()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期１４())) {
            普通徴収.set普徴金額１４(format金額(賦課情報.get普徴期別金額14()));
        }
        return 普通徴収;
    }

    private void set特別徴収_増減額(EditedKariSanteiFukaDaichoJoho 編集後仮算定賦課台帳情報) {

        TokubetsuChoshu 特別徴収更正前 = 編集後仮算定賦課台帳情報.get特別徴収更正前();
        TokubetsuChoshu 特別徴収更正後 = 編集後仮算定賦課台帳情報.get特別徴収更正後();
        TokubetsuChoshu 特別徴収増減額 = new TokubetsuChoshu();
        特別徴収増減額.set特徴調定月(RString.EMPTY);
        特別徴収増減額.set特徴調定月の期(RString.EMPTY);
        特別徴収増減額.set特徴納付済額(RString.EMPTY);
        特別徴収増減額.set特徴今後納付すべき額(RString.EMPTY);
        if (特別徴収更正前 == null) {
            特別徴収増減額.set特徴仮算定保険料(特別徴収更正後.get特徴仮算定保険料());
            特別徴収増減額.set特徴金額１(特別徴収更正後.get特徴金額１());
            特別徴収増減額.set特徴金額２(特別徴収更正後.get特徴金額２());
            特別徴収増減額.set特徴金額３(特別徴収更正後.get特徴金額３());
            特別徴収増減額.set特徴金額４(特別徴収更正後.get特徴金額４());
            特別徴収増減額.set特徴金額５(特別徴収更正後.get特徴金額５());
            特別徴収増減額.set特徴金額６(特別徴収更正後.get特徴金額６());
        } else {
            特別徴収増減額.set特徴仮算定保険料(get増減額(特別徴収更正後.get特徴仮算定保険料(), 特別徴収更正前.get特徴仮算定保険料()));
            特別徴収増減額.set特徴金額１(get増減額(特別徴収更正後.get特徴金額１(), 特別徴収更正前.get特徴金額１()));
            特別徴収増減額.set特徴金額２(get増減額(特別徴収更正後.get特徴金額２(), 特別徴収更正前.get特徴金額２()));
            特別徴収増減額.set特徴金額３(get増減額(特別徴収更正後.get特徴金額３(), 特別徴収更正前.get特徴金額３()));
            特別徴収増減額.set特徴金額４(get増減額(特別徴収更正後.get特徴金額４(), 特別徴収更正前.get特徴金額４()));
            特別徴収増減額.set特徴金額５(get増減額(特別徴収更正後.get特徴金額５(), 特別徴収更正前.get特徴金額５()));
            特別徴収増減額.set特徴金額６(get増減額(特別徴収更正後.get特徴金額６(), 特別徴収更正前.get特徴金額６()));
        }
        特別徴収増減額.set特徴金額７(RString.EMPTY);
        特別徴収増減額.set特徴金額８(RString.EMPTY);
        特別徴収増減額.set特徴金額９(RString.EMPTY);
        特別徴収増減額.set特徴金額１０(RString.EMPTY);
        特別徴収増減額.set特徴金額１１(RString.EMPTY);
        特別徴収増減額.set特徴金額１２(RString.EMPTY);
        特別徴収増減額.set特徴金額１３(RString.EMPTY);
        特別徴収増減額.set特徴金額１４(RString.EMPTY);
        編集後仮算定賦課台帳情報.set特別徴収増減額(特別徴収増減額);
    }

    private void set特別徴収_増減額(EditedHonSanteiFukaDaichoJoho 編集後本算定賦課台帳情報) {

        TokubetsuChoshu 特別徴収更正前 = 編集後本算定賦課台帳情報.get特別徴収更正前();
        TokubetsuChoshu 特別徴収更正後 = 編集後本算定賦課台帳情報.get特別徴収更正後();
        TokubetsuChoshu 特別徴収増減額 = new TokubetsuChoshu();
        特別徴収増減額.set特徴調定月(RString.EMPTY);
        特別徴収増減額.set特徴調定月の期(RString.EMPTY);
        特別徴収増減額.set特徴納付済額(RString.EMPTY);
        特別徴収増減額.set特徴今後納付すべき額(RString.EMPTY);
        if (特別徴収更正前 == null) {
            特別徴収増減額.set特徴確定年額保険料(特別徴収更正後.get特徴確定年額保険料());
            特別徴収増減額.set特徴金額１(特別徴収更正後.get特徴金額１());
            特別徴収増減額.set特徴金額２(特別徴収更正後.get特徴金額２());
            特別徴収増減額.set特徴金額３(特別徴収更正後.get特徴金額３());
            特別徴収増減額.set特徴金額４(特別徴収更正後.get特徴金額４());
            特別徴収増減額.set特徴金額５(特別徴収更正後.get特徴金額５());
            特別徴収増減額.set特徴金額６(特別徴収更正後.get特徴金額６());
            特別徴収増減額.set調整額歳出還付(特別徴収更正後.get調整額歳出還付());
        } else {
            特別徴収増減額.set特徴確定年額保険料(get増減額(特別徴収更正後.get特徴確定年額保険料(), 特別徴収更正前.get特徴確定年額保険料()));
            特別徴収増減額.set特徴金額１(get増減額(特別徴収更正後.get特徴金額１(), 特別徴収更正前.get特徴金額１()));
            特別徴収増減額.set特徴金額２(get増減額(特別徴収更正後.get特徴金額２(), 特別徴収更正前.get特徴金額２()));
            特別徴収増減額.set特徴金額３(get増減額(特別徴収更正後.get特徴金額３(), 特別徴収更正前.get特徴金額３()));
            特別徴収増減額.set特徴金額４(get増減額(特別徴収更正後.get特徴金額４(), 特別徴収更正前.get特徴金額４()));
            特別徴収増減額.set特徴金額５(get増減額(特別徴収更正後.get特徴金額５(), 特別徴収更正前.get特徴金額５()));
            特別徴収増減額.set特徴金額６(get増減額(特別徴収更正後.get特徴金額６(), 特別徴収更正前.get特徴金額６()));
            特別徴収増減額.set調整額歳出還付(get増減額(特別徴収更正後.get調整額歳出還付(), 特別徴収更正前.get調整額歳出還付()));
        }
        特別徴収増減額.set特徴金額７(RString.EMPTY);
        特別徴収増減額.set特徴金額８(RString.EMPTY);
        特別徴収増減額.set特徴金額９(RString.EMPTY);
        特別徴収増減額.set特徴金額１０(RString.EMPTY);
        特別徴収増減額.set特徴金額１１(RString.EMPTY);
        特別徴収増減額.set特徴金額１２(RString.EMPTY);
        特別徴収増減額.set特徴金額１３(RString.EMPTY);
        特別徴収増減額.set特徴金額１４(RString.EMPTY);
        編集後本算定賦課台帳情報.set特別徴収増減額(特別徴収増減額);
    }

    private void set普通徴収_増減額(EditedKariSanteiFukaDaichoJoho 編集後仮算定賦課台帳情報) {

        FutsuChoshu 普通徴収更正前 = 編集後仮算定賦課台帳情報.get普通徴収更正前();
        FutsuChoshu 普通徴収更正後 = 編集後仮算定賦課台帳情報.get普通徴収更正後();
        FutsuChoshu 普通徴収 = new FutsuChoshu();
        普通徴収.set普徴調定月(RString.EMPTY);
        普通徴収.set普徴調定月の期(RString.EMPTY);
        普通徴収.set普徴納付済額(RString.EMPTY);
        普通徴収.set普徴今後納付すべき額(RString.EMPTY);
        if (普通徴収更正前 == null) {
            普通徴収.set普徴仮算定保険料(普通徴収更正後.get普徴仮算定保険料());
            普通徴収.set普徴金額１(普通徴収更正後.get普徴金額１());
            普通徴収.set普徴金額２(普通徴収更正後.get普徴金額２());
            普通徴収.set普徴金額３(普通徴収更正後.get普徴金額３());
            普通徴収.set普徴金額４(普通徴収更正後.get普徴金額４());
            普通徴収.set普徴金額５(普通徴収更正後.get普徴金額５());
            普通徴収.set普徴金額６(普通徴収更正後.get普徴金額６());
            普通徴収.set普徴金額７(普通徴収更正後.get普徴金額７());
            普通徴収.set普徴金額８(普通徴収更正後.get普徴金額８());
            普通徴収.set普徴金額９(普通徴収更正後.get普徴金額９());
            普通徴収.set普徴金額１０(普通徴収更正後.get普徴金額１０());
            普通徴収.set普徴金額１１(普通徴収更正後.get普徴金額１１());
            普通徴収.set普徴金額１２(普通徴収更正後.get普徴金額１２());
            普通徴収.set普徴金額１３(普通徴収更正後.get普徴金額１３());
            普通徴収.set普徴金額１４(普通徴収更正後.get普徴金額１４());
        } else {
            普通徴収.set普徴仮算定保険料(get増減額(普通徴収更正後.get普徴仮算定保険料(), 普通徴収更正前.get普徴仮算定保険料()));
            普通徴収.set普徴金額１(get増減額(普通徴収更正後.get普徴金額１(), 普通徴収更正前.get普徴金額１()));
            普通徴収.set普徴金額２(get増減額(普通徴収更正後.get普徴金額２(), 普通徴収更正前.get普徴金額２()));
            普通徴収.set普徴金額３(get増減額(普通徴収更正後.get普徴金額３(), 普通徴収更正前.get普徴金額３()));
            普通徴収.set普徴金額４(get増減額(普通徴収更正後.get普徴金額４(), 普通徴収更正前.get普徴金額４()));
            普通徴収.set普徴金額５(get増減額(普通徴収更正後.get普徴金額５(), 普通徴収更正前.get普徴金額５()));
            普通徴収.set普徴金額６(get増減額(普通徴収更正後.get普徴金額６(), 普通徴収更正前.get普徴金額６()));
            普通徴収.set普徴金額７(get増減額(普通徴収更正後.get普徴金額７(), 普通徴収更正前.get普徴金額７()));
            普通徴収.set普徴金額８(get増減額(普通徴収更正後.get普徴金額８(), 普通徴収更正前.get普徴金額８()));
            普通徴収.set普徴金額９(get増減額(普通徴収更正後.get普徴金額９(), 普通徴収更正前.get普徴金額９()));
            普通徴収.set普徴金額１０(get増減額(普通徴収更正後.get普徴金額１０(), 普通徴収更正前.get普徴金額１０()));
            普通徴収.set普徴金額１１(get増減額(普通徴収更正後.get普徴金額１１(), 普通徴収更正前.get普徴金額１１()));
            普通徴収.set普徴金額１２(get増減額(普通徴収更正後.get普徴金額１２(), 普通徴収更正前.get普徴金額１２()));
            普通徴収.set普徴金額１３(get増減額(普通徴収更正後.get普徴金額１３(), 普通徴収更正前.get普徴金額１３()));
            普通徴収.set普徴金額１４(get増減額(普通徴収更正後.get普徴金額１４(), 普通徴収更正前.get普徴金額１４()));
        }
        編集後仮算定賦課台帳情報.set普通徴収増減額(普通徴収);
    }

    private void set普通徴収_増減額(EditedHonSanteiFukaDaichoJoho 編集後本算定賦課台帳情報) {

        FutsuChoshu 普通徴収更正前 = 編集後本算定賦課台帳情報.get普通徴収更正前();
        FutsuChoshu 普通徴収更正後 = 編集後本算定賦課台帳情報.get普通徴収更正後();
        FutsuChoshu 普通徴収 = new FutsuChoshu();
        普通徴収.set普徴調定月(RString.EMPTY);
        普通徴収.set普徴調定月の期(RString.EMPTY);
        普通徴収.set普徴納付済額(RString.EMPTY);
        普通徴収.set普徴今後納付すべき額(RString.EMPTY);
        if (普通徴収更正前 == null) {
            普通徴収.set普徴確定年額保険料(普通徴収更正後.get普徴確定年額保険料());
            普通徴収.set普徴金額１(普通徴収更正後.get普徴金額１());
            普通徴収.set普徴金額２(普通徴収更正後.get普徴金額２());
            普通徴収.set普徴金額３(普通徴収更正後.get普徴金額３());
            普通徴収.set普徴金額４(普通徴収更正後.get普徴金額４());
            普通徴収.set普徴金額５(普通徴収更正後.get普徴金額５());
            普通徴収.set普徴金額６(普通徴収更正後.get普徴金額６());
            普通徴収.set普徴金額７(普通徴収更正後.get普徴金額７());
            普通徴収.set普徴金額８(普通徴収更正後.get普徴金額８());
            普通徴収.set普徴金額９(普通徴収更正後.get普徴金額９());
            普通徴収.set普徴金額１０(普通徴収更正後.get普徴金額１０());
            普通徴収.set普徴金額１１(普通徴収更正後.get普徴金額１１());
            普通徴収.set普徴金額１２(普通徴収更正後.get普徴金額１２());
            普通徴収.set普徴金額１３(普通徴収更正後.get普徴金額１３());
            普通徴収.set普徴金額１４(普通徴収更正後.get普徴金額１４());
            普通徴収.set調整額歳出還付(普通徴収更正後.get調整額歳出還付());
        } else {
            普通徴収.set普徴確定年額保険料(get増減額(普通徴収更正後.get普徴確定年額保険料(), 普通徴収更正前.get普徴確定年額保険料()));
            普通徴収.set普徴金額１(get増減額(普通徴収更正後.get普徴金額１(), 普通徴収更正前.get普徴金額１()));
            普通徴収.set普徴金額２(get増減額(普通徴収更正後.get普徴金額２(), 普通徴収更正前.get普徴金額２()));
            普通徴収.set普徴金額３(get増減額(普通徴収更正後.get普徴金額３(), 普通徴収更正前.get普徴金額３()));
            普通徴収.set普徴金額４(get増減額(普通徴収更正後.get普徴金額４(), 普通徴収更正前.get普徴金額４()));
            普通徴収.set普徴金額５(get増減額(普通徴収更正後.get普徴金額５(), 普通徴収更正前.get普徴金額５()));
            普通徴収.set普徴金額６(get増減額(普通徴収更正後.get普徴金額６(), 普通徴収更正前.get普徴金額６()));
            普通徴収.set普徴金額７(get増減額(普通徴収更正後.get普徴金額７(), 普通徴収更正前.get普徴金額７()));
            普通徴収.set普徴金額８(get増減額(普通徴収更正後.get普徴金額８(), 普通徴収更正前.get普徴金額８()));
            普通徴収.set普徴金額９(get増減額(普通徴収更正後.get普徴金額９(), 普通徴収更正前.get普徴金額９()));
            普通徴収.set普徴金額１０(get増減額(普通徴収更正後.get普徴金額１０(), 普通徴収更正前.get普徴金額１０()));
            普通徴収.set普徴金額１１(get増減額(普通徴収更正後.get普徴金額１１(), 普通徴収更正前.get普徴金額１１()));
            普通徴収.set普徴金額１２(get増減額(普通徴収更正後.get普徴金額１２(), 普通徴収更正前.get普徴金額１２()));
            普通徴収.set普徴金額１３(get増減額(普通徴収更正後.get普徴金額１３(), 普通徴収更正前.get普徴金額１３()));
            普通徴収.set普徴金額１４(get増減額(普通徴収更正後.get普徴金額１４(), 普通徴収更正前.get普徴金額１４()));
            普通徴収.set調整額歳出還付(get増減額(普通徴収更正後.get調整額歳出還付(), 普通徴収更正前.get調整額歳出還付()));
        }
        編集後本算定賦課台帳情報.set普通徴収増減額(普通徴収);
    }

    private RString get増減額(RString 更正後, RString 更正前) {

        if (RString.isNullOrEmpty(更正前) && RString.isNullOrEmpty(更正後)) {
            return RString.EMPTY;
        } else if (RString.isNullOrEmpty(更正前)) {
            return 更正後;
        } else if (RString.isNullOrEmpty(更正後)) {
            return 定数_ゼロ.equals(更正前) ? 更正前 : FORMAT_.concat(更正前);
        }
        更正後 = 更正後.replace(FORMAT_符号, RString.EMPTY);
        更正前 = 更正前.replace(FORMAT_符号, RString.EMPTY);
        return DecimalFormatter.toコンマ区切りRString(new Decimal(Integer.parseInt(更正後.toString()) - Integer.parseInt(更正前.toString())), 0);
    }

    private Decimal get特徴仮算定保険料(FukaJoho fukaJoho, int start, int end) {
        Decimal 特徴仮算定保険料 = Decimal.ZERO;
        if (fukaJoho == null) {
            return 特徴仮算定保険料;
        }
        for (int i = start; i <= end; i++) {
            RStringBuilder sb = new RStringBuilder(定数_特徴方法.toString());
            sb.append(new RString(i).padZeroToLeft(2));
            Class clazz = fukaJoho.getClass();
            try {
                Method getMethod = clazz.getDeclaredMethod(sb.toString());
                特徴仮算定保険料 = 特徴仮算定保険料.add(get金額((Decimal) getMethod.invoke(fukaJoho)));
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                Logger.getLogger(FukaDaichoDataHenshu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 特徴仮算定保険料;
    }

    private Decimal get普徴納付済額(FukaJoho fukaJoho, int start, int end) {
        Decimal 普徴納付済額 = Decimal.ZERO;
        if (fukaJoho == null) {
            return 普徴納付済額;
        }
        for (int i = start; i <= end; i++) {
            RStringBuilder sb = new RStringBuilder(定数_普徴方法.toString());
            sb.append(new RString(i).padZeroToLeft(2));
            Class clazz = fukaJoho.getClass();
            try {
                Method getMethod = clazz.getDeclaredMethod(sb.toString());
                普徴納付済額 = 普徴納付済額.add(get金額((Decimal) getMethod.invoke(fukaJoho)));
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                Logger.getLogger(FukaDaichoDataHenshu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 普徴納付済額;
    }

    private Decimal get特徴収入済額(ShunyuJoho 収入情報, int start, int end) {

        Decimal 特徴収入済額 = Decimal.ZERO;
        if (収入情報 == null) {
            return 特徴収入済額;
        }
        for (int i = start; i <= end; i++) {
            RStringBuilder sb = new RStringBuilder(定数_特徴収入.toString());
            sb.append(new RString(i).padZeroToLeft(2));
            Class clazz = 収入情報.getClass();
            try {
                Method getMethod = clazz.getDeclaredMethod(sb.toString());
                特徴収入済額 = 特徴収入済額.add(get金額((Decimal) getMethod.invoke(収入情報)));
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                Logger.getLogger(FukaDaichoDataHenshu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 特徴収入済額;
    }

    private Decimal get普徴収入済額(ShunyuJoho 収入情報, int start, int end) {

        Decimal 普徴収入済額 = Decimal.ZERO;
        if (収入情報 == null) {
            return 普徴収入済額;
        }
        for (int i = start; i <= end; i++) {
            RStringBuilder sb = new RStringBuilder(定数_普徴収入.toString());
            sb.append(new RString(i).padZeroToLeft(2));
            Class clazz = 収入情報.getClass();
            try {
                Method getMethod = clazz.getDeclaredMethod(sb.toString());
                普徴収入済額 = 普徴収入済額.add(get金額((Decimal) getMethod.invoke(収入情報)));
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                Logger.getLogger(FukaDaichoDataHenshu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 普徴収入済額;
    }

    private void set特別徴収_収入額(ShunyuJoho 収入情報, EditedKariSanteiFukaDaichoJoho 編集後仮算定賦課台帳情報) {

        if (収入情報 == null) {
            return;
        }
        TokubetsuChoshu 特別徴収収入額 = get特別徴収_収入額(収入情報, 編集後仮算定賦課台帳情報.get特徴期());
        編集後仮算定賦課台帳情報.set特別徴収収入額(特別徴収収入額);
    }

    private void set特別徴収_収入額(ShunyuJoho 収入情報, EditedHonSanteiFukaDaichoJoho 編集後本算定賦課台帳情報) {

        if (収入情報 == null) {
            return;
        }
        TokubetsuChoshu 特別徴収収入額 = get特別徴収_収入額(収入情報, 編集後本算定賦課台帳情報.get特徴期());
        特別徴収収入額.set調整額歳出還付(RString.EMPTY);
        編集後本算定賦課台帳情報.set特別徴収収入額(特別徴収収入額);
    }

    private TokubetsuChoshu get特別徴収_収入額(ShunyuJoho 収入情報, TokubetsuChoshuKi 特徴期) {

        TokubetsuChoshu 特別徴収収入額 = new TokubetsuChoshu();
        特別徴収収入額.set特徴金額１(RString.EMPTY);
        特別徴収収入額.set特徴金額２(RString.EMPTY);
        特別徴収収入額.set特徴金額３(RString.EMPTY);
        特別徴収収入額.set特徴金額４(RString.EMPTY);
        特別徴収収入額.set特徴金額５(RString.EMPTY);
        特別徴収収入額.set特徴金額６(RString.EMPTY);
        特別徴収収入額.set特徴金額７(RString.EMPTY);
        特別徴収収入額.set特徴金額８(RString.EMPTY);
        特別徴収収入額.set特徴金額９(RString.EMPTY);
        特別徴収収入額.set特徴金額１０(RString.EMPTY);
        特別徴収収入額.set特徴金額１１(RString.EMPTY);
        特別徴収収入額.set特徴金額１２(RString.EMPTY);
        特別徴収収入額.set特徴金額１３(RString.EMPTY);
        特別徴収収入額.set特徴金額１４(RString.EMPTY);
        if (!RString.isNullOrEmpty(特徴期.get特徴期１())) {
            特別徴収収入額.set特徴金額１(format金額(収入情報.get特徴収入額01()));
        }
        if (!RString.isNullOrEmpty(特徴期.get特徴期２())) {
            特別徴収収入額.set特徴金額２(format金額(収入情報.get特徴収入額02()));
        }
        if (!RString.isNullOrEmpty(特徴期.get特徴期３())) {
            特別徴収収入額.set特徴金額３(format金額(収入情報.get特徴収入額03()));
        }
        if (!RString.isNullOrEmpty(特徴期.get特徴期４())) {
            特別徴収収入額.set特徴金額４(format金額(収入情報.get特徴収入額04()));
        }
        if (!RString.isNullOrEmpty(特徴期.get特徴期５())) {
            特別徴収収入額.set特徴金額５(format金額(収入情報.get特徴収入額05()));
        }
        if (!RString.isNullOrEmpty(特徴期.get特徴期６())) {
            特別徴収収入額.set特徴金額６(format金額(収入情報.get特徴収入額06()));
        }
        return 特別徴収収入額;
    }

    private void set普通徴収_収入額(ShunyuJoho 収入情報, EditedKariSanteiFukaDaichoJoho 編集後仮算定賦課台帳情報) {

        if (収入情報 == null) {
            return;
        }
        FutsuChoshu 普通徴収 = get普通徴収_収入額(収入情報, 編集後仮算定賦課台帳情報.get普徴期());
        編集後仮算定賦課台帳情報.set普通徴収収入額(普通徴収);
    }

    private void set普通徴収_収入額(ShunyuJoho 収入情報, EditedHonSanteiFukaDaichoJoho 編集後本算定賦課台帳情報) {

        if (収入情報 == null) {
            return;
        }
        FutsuChoshu 普通徴収 = get普通徴収_収入額(収入情報, 編集後本算定賦課台帳情報.get普徴期());
        普通徴収.set調整額歳出還付(RString.EMPTY);
        編集後本算定賦課台帳情報.set普通徴収収入額(普通徴収);
    }

    private FutsuChoshu get普通徴収_収入額(ShunyuJoho 収入情報, FutsuChoshuKi 普徴期) {

        FutsuChoshu 普通徴収 = new FutsuChoshu();
        普通徴収.set普徴金額１(RString.EMPTY);
        普通徴収.set普徴金額２(RString.EMPTY);
        普通徴収.set普徴金額３(RString.EMPTY);
        普通徴収.set普徴金額４(RString.EMPTY);
        普通徴収.set普徴金額５(RString.EMPTY);
        普通徴収.set普徴金額６(RString.EMPTY);
        普通徴収.set普徴金額７(RString.EMPTY);
        普通徴収.set普徴金額８(RString.EMPTY);
        普通徴収.set普徴金額９(RString.EMPTY);
        普通徴収.set普徴金額１０(RString.EMPTY);
        普通徴収.set普徴金額１１(RString.EMPTY);
        普通徴収.set普徴金額１２(RString.EMPTY);
        普通徴収.set普徴金額１３(RString.EMPTY);
        普通徴収.set普徴金額１４(RString.EMPTY);
        if (!RString.isNullOrEmpty(普徴期.get普徴期１())) {
            普通徴収.set普徴金額１(format金額(収入情報.get普徴収入額01()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期２())) {
            普通徴収.set普徴金額２(format金額(収入情報.get普徴収入額02()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期３())) {
            普通徴収.set普徴金額３(format金額(収入情報.get普徴収入額03()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期４())) {
            普通徴収.set普徴金額４(format金額(収入情報.get普徴収入額04()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期５())) {
            普通徴収.set普徴金額５(format金額(収入情報.get普徴収入額05()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期６())) {
            普通徴収.set普徴金額６(format金額(収入情報.get普徴収入額06()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期７())) {
            普通徴収.set普徴金額７(format金額(収入情報.get普徴収入額07()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期８())) {
            普通徴収.set普徴金額８(format金額(収入情報.get普徴収入額08()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期９())) {
            普通徴収.set普徴金額９(format金額(収入情報.get普徴収入額09()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期１０())) {
            普通徴収.set普徴金額１０(format金額(収入情報.get普徴収入額10()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期１１())) {
            普通徴収.set普徴金額１１(format金額(収入情報.get普徴収入額11()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期１２())) {
            普通徴収.set普徴金額１２(format金額(収入情報.get普徴収入額12()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期１３())) {
            普通徴収.set普徴金額１３(format金額(収入情報.get普徴収入額13()));
        }
        if (!RString.isNullOrEmpty(普徴期.get普徴期１４())) {
            普通徴収.set普徴金額１４(format金額(収入情報.get普徴収入額14()));
        }
        return 普通徴収;
    }

    private RString get調定事由略称(RString 調定事由) {

        if (RString.isNullOrEmpty(調定事由)) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBB介護賦課, DBBCodeShubetsu.調定事由.getコード(), new Code(調定事由));
    }

    private Decimal get前年度普通徴収最終期保険料(FukaJoho 前年度情報, Kitsuki 最終法定納期) {

        Decimal 普徴納付済額 = Decimal.ZERO;
        if (前年度情報 == null) {
            return 普徴納付済額;
        }
        RStringBuilder sb = new RStringBuilder(定数_普徴方法.toString());
        sb.append(最終法定納期.get期().padZeroToLeft(INT_2));
        Class clazz = 前年度情報.getClass();
        try {
            Method getMethod = clazz.getDeclaredMethod(sb.toString());
            普徴納付済額 = 普徴納付済額.add(get金額((Decimal) getMethod.invoke(前年度情報)));
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(FukaDaichoDataHenshu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 普徴納付済額;
    }

    private Decimal get金額(Decimal 金額) {
        if (金額 == null) {
            return Decimal.ZERO;
        }
        return 金額;
    }

    private RString create受給情報(DbV4001JukyushaDaichoEntity 受給者台帳情報, List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更リスト) {

        RStringBuilder 受給情報 = new RStringBuilder();
        if (受給者台帳情報 != null) {
            受給情報.append(定数_受給者);
        }
        if (支払方法変更リスト == null || 支払方法変更リスト.isEmpty()) {
            return 受給情報.toRString();
        }
        for (DbT4021ShiharaiHohoHenkoEntity 支払方法変更 : 支払方法変更リスト) {
            RString 受給情報tmp = RString.EMPTY;
            if (ShiharaiHenkoKanriKubun._１号償還払い化.getコード().equals(支払方法変更.getKanriKubun())
                    && ShiharaiHenkoTorokuKubun._１号償還払い化登録.getコード().equals(支払方法変更.getTorokuKubun())) {
                受給情報tmp = 受給者_償還払い化;
            }
            if (ShiharaiHenkoKanriKubun._１号給付額減額.getコード().equals(支払方法変更.getKanriKubun())
                    && ShiharaiHenkoTorokuKubun._１号給付額減額登録.getコード().equals(支払方法変更.getTorokuKubun())) {
                受給情報tmp = 受給者_給付額減額;
            }
            if (!RString.isNullOrEmpty(受給情報tmp)) {
                if (!RString.isNullOrEmpty(受給情報.toRString())) {
                    受給情報.append(RString.FULL_SPACE);
                }
                受給情報.append(受給情報tmp);
            }
        }
        return 受給情報.toRString();
    }

    private RString format金額(Decimal 金額) {

        if (金額 == null) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(金額, 0);
    }

    private RString format金額_パターン(boolean 前後区分, Decimal 金額) {

        if (前後区分) {
            return format金額(金額);
        }
        if (金額 == null || 金額 == Decimal.ZERO) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(金額, 0);
    }

    private RString format金額_パターン(Decimal 金額) {

        if (金額 == null || 金額 == Decimal.ZERO) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(金額, 0);
    }

    private RString get行政区コード(GyoseikuCode 行政区コード) {

        if (行政区コード == null || 行政区コード.isEmpty()) {
            return RString.EMPTY;
        }
        return 行政区コード.getColumnValue();
    }

    private RString get町域コード(ChoikiCode 町域コード) {

        if (町域コード == null || 町域コード.isEmpty()) {
            return RString.EMPTY;
        }
        return 町域コード.getColumnValue();
    }
}
