/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishohonsanteihakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.URZCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBBRP43002_2_保険料納入通知書（本算定）NonyuTsuchIchiranEditor
 *
 * @reamsid_L DBB-0780-080 yangchenbing
 */
public class NonyuTsuchIchiranEditor implements INonyuTsuchIchiranEditor {

    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final int 出力期;
    private final RDateTime 帳票作成日時;
    private final Association 地方公共団体;
    private final List<RString> 並び順List;
    private final Decimal 連番;
    private final RString 所得段階 = new RString("所得段階");
    private static final RString STRING_SAKUSEI = new RString("作成");
    private static final RString START = new RString("*");
    private static final RString INDEX = new RString("9900");
    private static final RString 半角ハイフン = new RString("-");
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM2 = 2;
    private static final int NUM3 = 3;
    private static final int NUM4 = 4;
    private static final int NUM5 = 5;
    private static final int NUM7 = 7;
    private static final int NUM8 = 8;

    /**
     * インスタンスを生成します。
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param 出力期 int
     * @param 帳票作成日時 RDateTime
     * @param 地方公共団体 Association
     * @param 並び順List List<RString>
     * @param 連番 Decimal
     */
    protected NonyuTsuchIchiranEditor(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            int 出力期,
            RDateTime 帳票作成日時,
            Association 地方公共団体,
            List<RString> 並び順List,
            Decimal 連番) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.出力期 = 出力期;
        this.帳票作成日時 = 帳票作成日時;
        this.地方公共団体 = 地方公共団体;
        this.並び順List = 並び順List;
        this.連番 = 連番;
    }

    @Override
    public NonyuTsuchIchiranSource edit(NonyuTsuchIchiranSource source) {
        this.makeNonyuTsuchIchiranItemList(source);
        return source;
    }

    /**
     * 変数付値、復雑度を簡素化する
     *
     * @param 編集後本算定通知書共通情報
     * @param item
     */
    private void setOtherValue(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報, NonyuTsuchIchiranSource source) {
        if (編集後本算定通知書共通情報.get更正後() != null
                && 編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト() != null) {
            for (UniversalPhase entity : 編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト()) {
                if (entity.get期() == Integer.valueOf(出力期)) {
                    source.listUpper_10 = DecimalFormatter.toコンマ区切りRString(entity.get金額(), 0);
                }
            }
        }
    }

    /**
     * makeNonyuTsuchIchiranItemList
     *
     * @param source NonyuTsuchIchiranSource
     */
    private void makeNonyuTsuchIchiranItemList(NonyuTsuchIchiranSource source) {
        source.printTimeStamp = get作成日時(帳票作成日時);
        source.nendo = 編集後本算定通知書共通情報.get賦課年度() != null
                ? 編集後本算定通知書共通情報.get賦課年度().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString() : RString.EMPTY;
        source.hokenshaNo = 地方公共団体.get地方公共団体コード().value();
        source.hokenshaName = 地方公共団体.get市町村名();
        出力帳票entityss(source);
        if (編集後本算定通知書共通情報.get表示コード() != null) {
            source.hyojicodeName1 = 編集後本算定通知書共通情報.get表示コード().get表示コード名１();
            source.hyojicodeName2 = 編集後本算定通知書共通情報.get表示コード().get表示コード名２();
            source.hyojicodeName3 = 編集後本算定通知書共通情報.get表示コード().get表示コード名３();
        }
        source.shotokuDankaiTitle = 所得段階;
        source.listUpper_1 = new RString(連番.toString());

        if (編集後本算定通知書共通情報.get通知書番号() != null) {
            source.listUpper_2 = 編集後本算定通知書共通情報.get通知書番号().value();
        }
        if (編集後本算定通知書共通情報.get被保険者番号() != null) {
            source.listUpper_3 = 編集後本算定通知書共通情報.get被保険者番号().value();
        }
        if (編集後本算定通知書共通情報.get編集後個人() != null && 編集後本算定通知書共通情報.
                get編集後個人().get世帯コード() != null) {
            source.listUpper_4 = 編集後本算定通知書共通情報.get編集後個人().get世帯コード().value();
        }
        if (編集後本算定通知書共通情報.get表示コード() != null) {
            source.listUpper_5 = 編集後本算定通知書共通情報.get表示コード().get表示コード１();
            source.listUpper_6 = 編集後本算定通知書共通情報.get表示コード().get表示コード２();
            source.listUpper_7 = 編集後本算定通知書共通情報.get表示コード().get表示コード３();
        }
        if (編集後本算定通知書共通情報.get編集後宛先() != null) {
            source.listUpper_8 = 編集後本算定通知書共通情報.get編集後宛先().get行政区名();
        }
        if (編集後本算定通知書共通情報.get更正後() != null
                && 編集後本算定通知書共通情報.get更正後().get確定保険料_年額() != null) {
            source.listUpper_9 = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get確定保険料_年額(), 0);
        }
        setOtherValue(編集後本算定通知書共通情報, source);
        if ((編集後本算定通知書共通情報.get編集後宛先() != null) && ((編集後本算定通知書共通情報.get編集後宛先().get本人名称().getName())
                != (編集後本算定通知書共通情報.get編集後宛先().get宛先名称().getName()))) {
            source.listUpper_12 = START.concat(RString.FULL_SPACE)
                    .concat(new RString(編集後本算定通知書共通情報.get編集後宛先().get宛先名称().getName().toString()));
        }
        if (編集後本算定通知書共通情報.get更正後() != null
                && 編集後本算定通知書共通情報.get更正後().get生保開始日() != null) {
            source.listUpper_13 = 編集後本算定通知書共通情報.get更正後().get生保開始日();
        }

        RString 生活保護扶助名称 = RString.EMPTY;
        if (編集後本算定通知書共通情報.get更正後() != null
                && 編集後本算定通知書共通情報.get更正後().get生活保護扶助種類() != null) {
            生活保護扶助名称 = CodeMaster.getCodeMeisho(SubGyomuCode.URZ業務共通_共通系,
                    URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                    new Code(編集後本算定通知書共通情報.get更正後().get生活保護扶助種類()), FlexibleDate.getNowDate());
        }
        source.listUpper_14 = 生活保護扶助名称;
        listlowers(source);
    }

    /**
     * 出力帳票entityss
     *
     * @param source NonyuTsuchIchiranSource
     */
    private void 出力帳票entityss(NonyuTsuchIchiranSource source) {
        RString 並び順の1件目 = 並び順List.size() <= NUM0 ? RString.EMPTY : 並び順List.get(NUM0);
        source.shutsuryokujun1 = 並び順の1件目;
        RString 並び順の2件目 = 並び順List.size() <= NUM1 ? RString.EMPTY : 並び順List.get(NUM1);
        source.shutsuryokujun2 = 並び順の2件目;
        RString 並び順の3件目 = 並び順List.size() <= NUM2 ? RString.EMPTY : 並び順List.get(NUM2);
        source.shutsuryokujun3 = 並び順の3件目;
        RString 並び順の4件目 = 並び順List.size() <= NUM3 ? RString.EMPTY : 並び順List.get(NUM3);
        source.shutsuryokujun4 = 並び順の4件目;
        RString 並び順の5件目 = 並び順List.size() <= NUM4 ? RString.EMPTY : 並び順List.get(NUM4);
        source.shutsuryokujun5 = 並び順の5件目;
    }

    private RString get作成日時(RDateTime 帳票作成日時) {
        RStringBuilder builder = new RStringBuilder();
        RString 作成日時 = RString.EMPTY;
        RString 帳票作成日 = 帳票作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
        RString 日時 = 帳票作成日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        作成日時 = builder.append(帳票作成日).append(RString.HALF_SPACE).append(日時)
                .append(RString.HALF_SPACE).append(STRING_SAKUSEI).toRString();
        return 作成日時;
    }

    /**
     * listlowers
     *
     * @param source NonyuTsuchIchiranSource
     * @param i int
     */
    private void listlowers(NonyuTsuchIchiranSource source) {
        if (編集後本算定通知書共通情報.get編集後宛先() != null
                && 編集後本算定通知書共通情報.get編集後宛先().get本人名称() != null) {
            source.listLower_1 = new RString(編集後本算定通知書共通情報.get編集後宛先().get本人名称().getName().toString());
        }
        if (編集後本算定通知書共通情報.get編集後宛先() != null) {
            source.listLower_2 = 編集後本算定通知書共通情報.get編集後宛先().get郵便番号();
        }
        if (編集後本算定通知書共通情報.get編集後宛先() != null) {
            source.listLower_3 = 編集後本算定通知書共通情報.get編集後宛先().get町域();
        }
        if (編集後本算定通知書共通情報.get更正後() != null
                && 編集後本算定通知書共通情報.get更正後().get保険料段階() != null) {
            source.listLower_4 = 編集後本算定通知書共通情報.get更正後().get保険料段階();
        }
        if (編集後本算定通知書共通情報.get今後納付すべき額() != null) {
            source.listLower_5 = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get今後納付すべき額(), 0);
        }
        if (編集後本算定通知書共通情報.get更正後() != null
                && 編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト() != null) {
            for (UniversalPhase entity : 編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト()) {
                if (entity.get期() == (Integer.valueOf(出力期) + 1)) {
                    source.listLower_6 = DecimalFormatter.toコンマ区切りRString(entity.get金額(), 0);
                }
            }
        }

        source.listLower_8 = set口座情報(編集後本算定通知書共通情報);
    }

    private RString set口座情報(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報) {
        RString 口座情報 = RString.EMPTY;
        if (編集後本算定通知書共通情報.get編集後口座() != null) {
            RString 金融機関コード = 編集後本算定通知書共通情報.get編集後口座().get金融機関コード();
            RString 通帳記号 = 編集後本算定通知書共通情報.get編集後口座().getEdited通帳記号();
            RString 通帳番号 = 編集後本算定通知書共通情報.get編集後口座().getEdited通帳番号();
            RString 口座名義人漢字 = 編集後本算定通知書共通情報.get編集後口座().get口座名義人漢字();
            RString 支店コード = 編集後本算定通知書共通情報.get編集後口座().get支店コード();
            RString 口座番号 = 編集後本算定通知書共通情報.get編集後口座().get口座番号();
            RString 口座種別 = 編集後本算定通知書共通情報.get編集後口座().get預金種別略称();
            if (金融機関コード.isEmpty() || 通帳記号.isEmpty() || 通帳番号.isEmpty()
                    || 口座名義人漢字.isEmpty() || 支店コード.isEmpty()
                    || 口座番号.isEmpty() || 口座種別.isEmpty()) {
                return RString.EMPTY;
            }
            if (INDEX.equals(金融機関コード.substring(NUM0, NUM4))) {
                口座情報 = 金融機関コード.substring(NUM0, NUM4).concat(RString.HALF_SPACE)
                        .concat(NUM5 < 通帳記号.length() ? 通帳記号.substring(NUM0, 通帳記号.length())
                                : 通帳記号.substring(NUM0, NUM5))
                        .concat(半角ハイフン)
                        .concat(NUM8 < 通帳番号.length() ? 通帳番号.substring(NUM0, 通帳番号.length())
                                : 通帳番号.substring(NUM0, NUM8))
                        .concat(RString.HALF_SPACE)
                        .concat(口座名義人漢字);
            } else {
                口座情報 = 金融機関コード.substring(NUM0, NUM4).concat(半角ハイフン)
                        .concat(NUM3 < 支店コード.length() ? 支店コード.substring(NUM0, 支店コード.length())
                                : 支店コード.substring(NUM0, NUM3))
                        .concat(RString.HALF_SPACE)
                        .concat(NUM2 < 口座種別.length() ? 口座種別.substring(NUM0, 口座種別.length())
                                : 口座種別.substring(NUM0, NUM2))
                        .concat(半角ハイフン)
                        .concat(NUM7 < 口座番号.length() ? 口座番号.substring(NUM0, 口座番号.length())
                                : 口座番号.substring(NUM0, NUM7))
                        .concat(RString.HALF_SPACE)
                        .concat(口座名義人漢字);

            }
        }
        return 口座情報;
    }
}
