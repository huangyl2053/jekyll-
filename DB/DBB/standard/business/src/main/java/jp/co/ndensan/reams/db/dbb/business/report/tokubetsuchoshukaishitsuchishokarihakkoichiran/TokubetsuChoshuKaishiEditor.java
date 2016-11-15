/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.CharacteristicsPhase;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBBRP43002_4_特別徴収開始通知書（本算定）TokubetsuChoshuKaishiEditor
 *
 * @reamsid_L DBB-0780-100 yangchenbing
 */
public class TokubetsuChoshuKaishiEditor implements ITokubetsuChoshuKaishiEditor {

    private final RString 生活保護区分;
    private final RString 特徴10月開始者区分;
    private final HonSanteiTsuchiShoKyotsu 本算定通知書情報;
    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final FlexibleYear 賦課年度;
    private final List<RString> 出力項目リスト;
    private final List<RString> 改頁項目リスト;
    private final RDateTime 帳票作成日時;
    private final RString 市町村コード;
    private final RString 市町村名;
    private final int 連番;
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM2 = 2;
    private static final int NUM3 = 3;
    private static final int NUM4 = 4;
    private static final int NUM5 = 5;
    private static final int NUM6 = 6;
    private static final RString 特別徴収開始通知書 = new RString("特別徴収開始通知書（本算定）発行一覧表");
    private static final RString 定値_10月 = new RString("10月");
    private static final RString 定値_12月 = new RString("12月");
    private static final RString 定値_2月 = new RString("2月");
    private static final RString 定値_作成 = new RString("作成");
    private static final RString 本徴収額 = new RString("本徴収額");

    /**
     * インスタンスを生成します。
     *
     * @param 生活保護区分 RString
     * @param 特徴10月開始者区分 RString
     * @param 本算定通知書情報 HonSanteiTsuchiShoKyotsu
     * @param 編集後本算定通知書共通情報 List<EditedHonSanteiTsuchiShoKyotsu>
     * @param 賦課年度 FlexibleYear
     * @param 出力項目リスト List<RString>
     * @param 改頁項目リスト 改頁項目リスト
     * @param 帳票作成日時 RString
     * @param 市町村コード RString
     * @param 市町村名 RString
     * @param 連番 int
     */
    protected TokubetsuChoshuKaishiEditor(RString 生活保護区分, RString 特徴10月開始者区分, HonSanteiTsuchiShoKyotsu 本算定通知書情報,
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            FlexibleYear 賦課年度, List<RString> 出力項目リスト, List<RString> 改頁項目リスト,
            RDateTime 帳票作成日時, RString 市町村コード, RString 市町村名, int 連番) {
        this.生活保護区分 = 生活保護区分;
        this.特徴10月開始者区分 = 特徴10月開始者区分;
        this.本算定通知書情報 = 本算定通知書情報;
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.賦課年度 = 賦課年度;
        this.出力項目リスト = 出力項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
        this.帳票作成日時 = 帳票作成日時;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        this.連番 = 連番;
    }

    @Override
    public TokubetsuChoshuKaishiSource edit(TokubetsuChoshuKaishiSource source) {
        makeNonyuTsuchIchiranItemList(source);
        return source;
    }

    /**
     * makeNonyuTsuchIchiranItemList
     *
     * @param source TokubetsuChoshuKaishiSource
     */
    private void makeNonyuTsuchIchiranItemList(TokubetsuChoshuKaishiSource source) {
        RDate date = 帳票作成日時.getDate();
        RTime time = 帳票作成日時.getTime();
        RString timeFormat = time.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        source.printTimeStamp = date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(RString.HALF_SPACE).concat(timeFormat).
                concat(RString.HALF_SPACE).concat(定値_作成);
        source.title = 特別徴収開始通知書;
        source.hokenshaNo = 市町村コード;
        source.hokenshaName = 市町村名;
        listlowers(source);
        source.listLower_6 = 定値_10月;
        if (編集後本算定通知書共通情報 != null && 編集後本算定通知書共通情報.get更正後() != null && 編集後本算定通知書共通情報.
                get更正後().get特徴期別金額リスト() != null && !編集後本算定通知書共通情報.get更正後().get特徴期別金額リスト().isEmpty()) {
            for (CharacteristicsPhase entity : 編集後本算定通知書共通情報.get更正後().get特徴期別金額リスト()) {
                if (entity != null && entity.get期() != null && Integer.valueOf(entity.get期().toString()) == NUM4) {
                    source.listLower_7 = (entity.get金額() == null ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(entity.get金額(), 0));
                } else if (entity != null && entity.get期() != null && Integer.valueOf(entity.get期().toString()) == NUM5) {
                    source.listLower_9 = (entity.get金額() == null ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(entity.get金額(), 0));
                } else if (entity != null && entity.get期() != null && Integer.valueOf(entity.get期().toString()) == NUM6) {
                    source.listLower_11 = (entity.get金額() == null ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(entity.get金額(), 0));
                }
            }
        }
        source.listLower_8 = 定値_12月;
        source.listLower_10 = 定値_2月;
        if (賦課年度 != null) {
            source.nendo = 賦課年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString();
        }
        set出力改頁(source);
        set改頁(source);
    }

    private void listlowers(TokubetsuChoshuKaishiSource source) {
        source.titleChoshugaku = 本徴収額;
        if (NUM0 <= 連番) {
            source.listUpper_1 = new RString(連番);
        }
        if (編集後本算定通知書共通情報 != null) {
            if (編集後本算定通知書共通情報.get編集後宛先() != null) {
                source.listUpper_2 = 編集後本算定通知書共通情報.get編集後宛先().get郵便番号();
                source.listUpper_3 = 編集後本算定通知書共通情報.get編集後宛先().get町域();
                source.listUpper_4 = 編集後本算定通知書共通情報.get編集後宛先().get宛先行政区();
            }
            if (編集後本算定通知書共通情報.get編集後個人() != null) {
                source.listUpper_5 = 編集後本算定通知書共通情報.get編集後個人().get生年月日For帳票();
                source.listUpper_6 = 編集後本算定通知書共通情報.get編集後個人().get性別();
            }
            if (編集後本算定通知書共通情報.get編集後個人() != null && 編集後本算定通知書共通情報.get編集後個人().get世帯主名() != null) {
                source.listUpper_7 = 編集後本算定通知書共通情報.get編集後個人().get世帯主名().value();
            }
            if (編集後本算定通知書共通情報.get通知書番号() != null) {
                source.listLower_1 = 編集後本算定通知書共通情報.get通知書番号().value();
            }
            if (編集後本算定通知書共通情報.get編集後個人() != null && 編集後本算定通知書共通情報.get編集後個人().get世帯コード() != null) {
                source.listLower_2 = 編集後本算定通知書共通情報.get編集後個人().get世帯コード().value();
            }
            if (編集後本算定通知書共通情報.get編集後個人() != null && 編集後本算定通知書共通情報.get編集後個人().get名称() != null) {
                source.listLower_3 = 編集後本算定通知書共通情報.get編集後個人().get名称().getName().value();
            }
            if (編集後本算定通知書共通情報.get更正後() != null) {
                source.listLower_4 = 編集後本算定通知書共通情報.get更正後().get特別徴収義務者();
                source.listLower_5 = 編集後本算定通知書共通情報.get更正後().get特別徴収対象年金();
            }
        }
    }

    private void set出力改頁(TokubetsuChoshuKaishiSource source) {
        if (NUM0 < 出力項目リスト.size()) {
            source.shutsuryokujun1 = 出力項目リスト.get(NUM0);
        }
        if (NUM0 < 改頁項目リスト.size()) {
            source.kaipage1 = 改頁項目リスト.get(NUM0);
        }
        if (NUM1 < 出力項目リスト.size()) {
            source.shutsuryokujun2 = 出力項目リスト.get(NUM1);
        }
        if (NUM1 < 改頁項目リスト.size()) {
            source.kaipage2 = 改頁項目リスト.get(NUM1);
        }
        if (NUM2 < 出力項目リスト.size()) {
            source.shutsuryokujun3 = 出力項目リスト.get(NUM2);
        }
        if (NUM2 < 改頁項目リスト.size()) {
            source.kaipage3 = 改頁項目リスト.get(NUM2);
        }
        if (NUM3 < 出力項目リスト.size()) {
            source.shutsuryokujun4 = 出力項目リスト.get(NUM3);
        }
        if (NUM3 < 改頁項目リスト.size()) {
            source.kaipage4 = 改頁項目リスト.get(NUM3);
        }
        if (NUM4 < 出力項目リスト.size()) {
            source.shutsuryokujun5 = 出力項目リスト.get(NUM4);
        }
        if (NUM4 < 改頁項目リスト.size()) {
            source.kaipage5 = 改頁項目リスト.get(NUM4);
        }
    }

    private void set改頁(TokubetsuChoshuKaishiSource source) {
        if (編集後本算定通知書共通情報.get編集後宛先() != null) {
            source.choikiCode = 編集後本算定通知書共通情報.get編集後宛先().get町域コード();
            source.choikiCode = 編集後本算定通知書共通情報.get編集後宛先().get行政区コード().getColumnValue();
            source.chikuCode1 = 編集後本算定通知書共通情報.get編集後宛先().get地区１();
            source.chikuCode2 = 編集後本算定通知書共通情報.get編集後宛先().get地区２();
            source.chikuCode3 = 編集後本算定通知書共通情報.get編集後宛先().get地区３();
        }
        if (編集後本算定通知書共通情報.get編集後個人() != null) {
            source.shikibetsuCode = 編集後本算定通知書共通情報.get編集後個人().get識別コード().value();
            source.kanaMeisho = 編集後本算定通知書共通情報.get編集後個人().get氏名５０音カナ();
        }
        source.hihokenshaNo = 編集後本算定通知書共通情報.get被保険者番号().getColumnValue();
        source.nenkinCode = 編集後本算定通知書共通情報.get更正後().get特別徴収対象年金コード();
        if (本算定通知書情報.get納組情報() != null && 本算定通知書情報.get納組情報().getNokumi() != null) {
            source.nokumiCode = 本算定通知書情報.get納組情報().getNokumi().getNokumiCode();
        }
        source.seihoFlag = 生活保護区分;
        source.tokuchoKaishi10 = 特徴10月開始者区分;
    }
}
