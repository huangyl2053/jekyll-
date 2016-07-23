/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukarisanteikekkaIchiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokuchoKariKeisangoFukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukarisanteikekkaIchiran.TokubetsuChoshuKarisanteiKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBBRP33001_2_特別徴収仮算定結果一覧表Editor
 *
 * @reamsid_L DBB-0700-030 xuhao
 */
public class TokubetsuChoshuKarisanteiKekkaIchiranEditor implements ITokubetsuChoshuKarisanteiKekkaIchiranEditor {

    private final TokuchoKariKeisangoFukaEntity 特徴仮算定計算後賦課情報Entity;
    private final RString 市町村コード;
    private final RString 市町村名称;
    private final FlexibleYear 調定年度;
    private final YMDHMS 調定日時;
    private final List<RString> 並び順List;
    private final List<RString> 改頁List;
    private final int 連番;
    private final RString 住所編集;
    private final Decimal 前年度保険料;

    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("2");
    private static final RString RSTRING_3 = new RString("3");
    private static final RString RSTRING_4 = new RString("4");
    private static final RString 作成 = new RString("作成");
    private static final RString 男 = new RString("男");
    private static final RString 女 = new RString("女");
    private static final RString 継続 = new RString("継続");
    private static final RString 特徴中止 = new RString("特徴中止");
    private static final RString FOUR月 = new RString("４月");
    private static final RString SIX月 = new RString("６月");
    private static final RString EIGHT月 = new RString("８月");
    private static final char CHAR_0 = '0';

    /**
     * コンストラクタです
     *
     * @param 市町村コード RString
     * @param 市町村名称 RString
     * @param 特徴仮算定計算後賦課情報Entity TokuchoKariKeisangoFukaEntity
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 並び順List List<RString>
     * @param 改頁List List<RString>
     * @param 連番 int
     * @param 住所編集 RString
     * @param 前年度保険料 RString
     */
    public TokubetsuChoshuKarisanteiKekkaIchiranEditor(
            RString 市町村コード,
            RString 市町村名称,
            TokuchoKariKeisangoFukaEntity 特徴仮算定計算後賦課情報Entity,
            FlexibleYear 調定年度,
            YMDHMS 調定日時,
            List<RString> 並び順List,
            List<RString> 改頁List,
            int 連番,
            RString 住所編集,
            Decimal 前年度保険料) {
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.特徴仮算定計算後賦課情報Entity = 特徴仮算定計算後賦課情報Entity;
        this.調定年度 = 調定年度;
        this.調定日時 = 調定日時;
        this.並び順List = 並び順List;
        this.改頁List = 改頁List;
        this.連番 = 連番;
        this.住所編集 = 住所編集;
        this.前年度保険料 = 前年度保険料;
    }

    @Override
    public TokubetsuChoshuKarisanteiKekkaIchiranSource edit(TokubetsuChoshuKarisanteiKekkaIchiranSource source) {
        RString 帳票作成年月日 = 調定日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 帳票作成時 = 調定日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        source.printTimeStamp = 帳票作成年月日.concat(RString.HALF_SPACE).concat(帳票作成時).concat(RString.HALF_SPACE).concat(作成);
        source.nendo = 調定年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .fillType(FillType.BLANK).toDateString();
        source.hokenshaNo = 市町村コード;
        source.hokenshaName = 市町村名称;
        source.shutsuryokujun1 = 並び順List.size() > NUM_0 ? 並び順List.get(NUM_0) : RString.EMPTY;
        source.shutsuryokujun2 = 並び順List.size() > NUM_1 ? 並び順List.get(NUM_1) : RString.EMPTY;
        source.shutsuryokujun3 = 並び順List.size() > NUM_2 ? 並び順List.get(NUM_2) : RString.EMPTY;
        source.shutsuryokujun4 = 並び順List.size() > NUM_3 ? 並び順List.get(NUM_3) : RString.EMPTY;
        source.shutsuryokujun5 = 並び順List.size() > NUM_4 ? 並び順List.get(NUM_4) : RString.EMPTY;
        source.kaipage1 = 改頁List.size() > NUM_0 ? 並び順List.get(NUM_0) : RString.EMPTY;
        source.kaipage2 = 改頁List.size() > NUM_1 ? 並び順List.get(NUM_1) : RString.EMPTY;
        source.kaipage3 = 改頁List.size() > NUM_2 ? 並び順List.get(NUM_2) : RString.EMPTY;
        source.kaipage4 = 改頁List.size() > NUM_3 ? 並び順List.get(NUM_3) : RString.EMPTY;
        source.kaipage5 = 改頁List.size() > NUM_4 ? 並び順List.get(NUM_4) : RString.EMPTY;
        source.listUpper_1 = new RString(String.valueOf(連番));
        YubinNo 郵便番号 = 特徴仮算定計算後賦課情報Entity.get宛名().getYubinNo();
        if (郵便番号 != null) {
            source.listUpper_2 = 郵便番号.value();
        }
        source.listUpper_3 = 住所編集;
        RString 行政区 = 特徴仮算定計算後賦課情報Entity.get宛名().getGyoseikuName();
        if (行政区 != null) {
            source.listUpper_4 = 行政区;
        }
        RString 住民種別コード = 特徴仮算定計算後賦課情報Entity.get宛名().getJuminShubetsuCode();
        FlexibleDate 生年月日 = 特徴仮算定計算後賦課情報Entity.get宛名().getSeinengappiYMD();
        set生年月日(住民種別コード, 生年月日, source);
        RString 性別 = 特徴仮算定計算後賦課情報Entity.get宛名().getSeibetsuCode();
        set性別(性別, source);
        if (特徴仮算定計算後賦課情報Entity.get特別徴収停止事由コード() == null || 特徴仮算定計算後賦課情報Entity.get特別徴収停止事由コード().isEmpty()) {
            set開始月(source);
        }
        RString 前年度所得段階 = 特徴仮算定計算後賦課情報Entity.get前年度保険料段階().substring(NUM_0, NUM_2).trimStart(CHAR_0);
        source.listUpper_8 = 前年度所得段階;
        source.listUpper_9 = DecimalFormatter.toコンマ区切りRString(前年度保険料, NUM_0);
        if (特徴仮算定計算後賦課情報Entity.get通知書番号() != null) {
            source.listLower_1 = 特徴仮算定計算後賦課情報Entity.get通知書番号().value();
        }
        if (特徴仮算定計算後賦課情報Entity.get世帯コード() != null) {
            source.listLower_2 = 特徴仮算定計算後賦課情報Entity.get世帯コード().value();
        }
        AtenaMeisho 漢字氏名 = 特徴仮算定計算後賦課情報Entity.get宛名().getKanjiShimei();
        if (漢字氏名 != null) {
            source.listLower_3 = 漢字氏名.value();
        }
        set特別徴収業務者(source);
        set特別徴収対象年金(source);
        source.listLower_6 = FOUR月;
        source.listLower_7 = DecimalFormatter.toコンマ区切りRString(特徴仮算定計算後賦課情報Entity.get特徴期期別金額01(), NUM_0);
        source.listLower_8 = SIX月;
        source.listLower_7 = DecimalFormatter.toコンマ区切りRString(特徴仮算定計算後賦課情報Entity.get特徴期期別金額02(), NUM_0);
        source.listLower_8 = EIGHT月;
        source.listLower_7 = DecimalFormatter.toコンマ区切りRString(特徴仮算定計算後賦課情報Entity.get特徴期期別金額03(), NUM_0);
        source.listBiko_1 = 特徴中止;
        set特別徴収停止事由(source);
        return source;

    }

    private void set性別(RString 性別, TokubetsuChoshuKarisanteiKekkaIchiranSource source) {
        if (RSTRING_1.equals(性別)) {
            source.listUpper_6 = 男;
        }
        if (RSTRING_2.equals(性別)) {
            source.listUpper_6 = 女;
        }
    }

    private void set生年月日(RString 住民種別コード, FlexibleDate 生年月日, TokubetsuChoshuKarisanteiKekkaIchiranSource source) {
        if ((RSTRING_1.equals(住民種別コード) || RSTRING_3.equals(住民種別コード)) && 生年月日 != null) {
            source.listUpper_5 = 生年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        if ((RSTRING_2.equals(住民種別コード) || RSTRING_4.equals(住民種別コード)) && 生年月日 != null) {
            source.listUpper_5 = 生年月日.seireki().toDateString();
        }
    }

    private void set特別徴収業務者(TokubetsuChoshuKarisanteiKekkaIchiranSource source) throws NullPointerException, IllegalArgumentException {
        if (特徴仮算定計算後賦課情報Entity.get特別徴収義務者コード() != null) {
            Code 特別徴収義務者コード = 特徴仮算定計算後賦課情報Entity.get特別徴収義務者コード();
            RString 特別徴収業務者 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, new CodeShubetsu("0047"), 特別徴収義務者コード);
            source.listLower_4 = 特別徴収業務者;
        }
    }

    private void set特別徴収対象年金(TokubetsuChoshuKarisanteiKekkaIchiranSource source) throws NullPointerException, IllegalArgumentException {
        if (特徴仮算定計算後賦課情報Entity.get仮徴収_年金コード() != null && 特徴仮算定計算後賦課情報Entity.get仮徴収_年金コード().length() <= NUM_3) {
            Code 仮徴収_年金コード = new Code(特徴仮算定計算後賦課情報Entity.get仮徴収_年金コード());
            RString 特別徴収対象年金 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, new CodeShubetsu("0046"), 仮徴収_年金コード);
            source.listLower_5 = 特別徴収対象年金;
        }
        if (特徴仮算定計算後賦課情報Entity.get仮徴収_年金コード() != null && 特徴仮算定計算後賦課情報Entity.get仮徴収_年金コード().length() > NUM_3) {
            Code 仮徴収_年金コード = new Code(特徴仮算定計算後賦課情報Entity.get仮徴収_年金コード().substring(NUM_0, NUM_3));
            RString 特別徴収対象年金 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, new CodeShubetsu("0046"), 仮徴収_年金コード);
            source.listLower_5 = 特別徴収対象年金;
        }
    }

    private void set特別徴収停止事由(TokubetsuChoshuKarisanteiKekkaIchiranSource source) throws IllegalArgumentException, NullPointerException {
        if (特徴仮算定計算後賦課情報Entity.get特別徴収停止事由コード() != null) {
            Code 特別徴収停止事由コード = new Code(特徴仮算定計算後賦課情報Entity.get特別徴収停止事由コード().toString());
            RString 備考２ = CodeMaster.getCodeRyakusho(SubGyomuCode.DBB介護賦課, new CodeShubetsu("0008"), 特別徴収停止事由コード);
            source.listLower_5 = 備考２;
        }
    }

    private void set開始月(TokubetsuChoshuKarisanteiKekkaIchiranSource source) {
        Decimal 特徴期期別金額01 = 特徴仮算定計算後賦課情報Entity.get特徴期期別金額01();
        Decimal 特徴期期別金額02 = 特徴仮算定計算後賦課情報Entity.get特徴期期別金額02();
        Decimal 特徴期期別金額03 = 特徴仮算定計算後賦課情報Entity.get特徴期期別金額03();
        if (特徴期期別金額01.compareTo(Decimal.ZERO) > NUM_0 && 特徴期期別金額02.compareTo(Decimal.ZERO) > NUM_0
                && 特徴期期別金額03.compareTo(Decimal.ZERO) > NUM_0) {
            source.listUpper_7 = 継続;
        }
        if (Decimal.ZERO.equals(特徴期期別金額01) && 特徴期期別金額02.compareTo(Decimal.ZERO) > NUM_0
                && 特徴期期別金額03.compareTo(Decimal.ZERO) > NUM_0) {
            source.listUpper_7 = SIX月;
        }

    }
}
