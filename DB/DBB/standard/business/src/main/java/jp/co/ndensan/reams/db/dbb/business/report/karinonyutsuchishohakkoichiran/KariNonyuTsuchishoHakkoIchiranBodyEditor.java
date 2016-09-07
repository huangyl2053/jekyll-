 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karinonyutsuchishohakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsuAfterCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.entity.report.karinonyutsuchishohakkoichiran.KariNonyuTsuchishoHakkoIchiranSource;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AtesakiShubetsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.URZCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 保険料納入通知書（仮算定）発行一覧表帳票クラスです。
 *
 * @reamsid_L DBB-0710-050 yebangqiang
 */
class KariNonyuTsuchishoHakkoIchiranBodyEditor implements IKariNonyuTsuchishoHakkoIchiranEditor {

    private final List<KariSanteiNonyuTsuchiShoJoho> entityList;
    private final List<RString> 並び順List;
    private final int 出力期;
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_7 = 7;
    private static final RString ゆうちょ銀行 = new RString("9900");
    private static final RString HYPHEN = new RString("-");
    private final Association association;

    protected KariNonyuTsuchishoHakkoIchiranBodyEditor(List<KariSanteiNonyuTsuchiShoJoho> entityList,
            List<RString> 並び順List, int 出力期, Association association) {
        this.entityList = entityList;
        this.並び順List = 並び順List;
        this.出力期 = 出力期;
        this.association = association;
    }

    @Override
    public KariNonyuTsuchishoHakkoIchiranSource edit(KariNonyuTsuchishoHakkoIchiranSource source) {
        int 連番 = 1;
        source.hokenshaNo = association.get地方公共団体コード().value();
        source.hokenshaName = association.get市町村名();
        for (KariSanteiNonyuTsuchiShoJoho item : entityList) {
            source.hokenshaNo = association.get地方公共団体コード().value();
            source.hokenshaName = association.get市町村名();
            出力帳票entities(source);
            final EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報 = item.get編集後仮算定通知書共通情報();
            if (!isNull(編集後仮算定通知書共通情報)) {
                source.hdrTytle1 = 表示コード編集(編集後仮算定通知書共通情報.get表示コード１名());
                source.hdrTytle2 = 表示コード編集(編集後仮算定通知書共通情報.get表示コード２名());
                source.hdrTytle3 = 表示コード編集(編集後仮算定通知書共通情報.get表示コード３名());
                source.listUpper_1 = new RString(連番);
                連番++;
                source.listUpper_2 = isNull(編集後仮算定通知書共通情報.get通知書番号()) ? RString.EMPTY
                        : 編集後仮算定通知書共通情報.get通知書番号().value();
                source.listUpper_3 = isNull(編集後仮算定通知書共通情報.get被保険者番号()) ? RString.EMPTY
                        : 編集後仮算定通知書共通情報.get被保険者番号().value();
                if (isNull(編集後仮算定通知書共通情報.get編集後個人())
                        || isNull(編集後仮算定通知書共通情報.get編集後個人().get世帯コード())) {
                    source.listUpper_4 = RString.EMPTY;
                } else {
                    source.listUpper_4 = 編集後仮算定通知書共通情報.get編集後個人().get世帯コード().value();
                }
                source.listUpper_5 = 表示コード編集(編集後仮算定通知書共通情報.get表示コード1());
                source.listUpper_6 = 表示コード編集(編集後仮算定通知書共通情報.get表示コード２());
                source.listUpper_7 = 表示コード編集(編集後仮算定通知書共通情報.get表示コード３());
                if (isNull(編集後仮算定通知書共通情報.get更正後())) {
                    source.listUpper_9 = RString.EMPTY;
                    source.listUpper_12 = RString.EMPTY;
                    source.listUpper_13 = RString.EMPTY;
                    source.listLower_5 = RString.EMPTY;
                } else {
                    編集後仮算定通知書共通情報設定(source, 編集後仮算定通知書共通情報);
                    編集後宛先相関項目編集(編集後仮算定通知書共通情報, source);
                    source.listLower_4 = isNull(編集後仮算定通知書共通情報.get前年度情報()) ? RString.EMPTY
                            : 編集後仮算定通知書共通情報.get前年度情報().get前年度保険料段階();
                    set編集後口座(編集後仮算定通知書共通情報, source);
                }
            } else {
                source.hdrTytle1 = RString.EMPTY;
                source.hdrTytle2 = RString.EMPTY;
                source.hdrTytle3 = RString.EMPTY;
                source.listUpper_1 = RString.EMPTY;
                連番++;
                source.listUpper_2 = RString.EMPTY;
                source.listUpper_3 = RString.EMPTY;
                source.listUpper_4 = RString.EMPTY;
                source.listUpper_5 = RString.EMPTY;
                source.listUpper_6 = RString.EMPTY;
                source.listUpper_7 = RString.EMPTY;
                source.listUpper_8 = RString.EMPTY;
                source.listUpper_9 = RString.EMPTY;
                source.listUpper_10 = RString.EMPTY;
                source.listUpper_11 = RString.EMPTY;
                source.listUpper_12 = RString.EMPTY;
                source.listUpper_13 = RString.EMPTY;
                source.listLower_1 = RString.EMPTY;
                source.listLower_2 = RString.EMPTY;
                source.listLower_3 = RString.EMPTY;
                source.listLower_4 = RString.EMPTY;
                source.listLower_5 = RString.EMPTY;
                source.listLower_6 = RString.EMPTY;
                source.listLower_7 = RString.EMPTY;
            }
        }
        return source;
    }

    private void 編集後仮算定通知書共通情報設定(KariNonyuTsuchishoHakkoIchiranSource source,
            final EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報) {
        final EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後 = 編集後仮算定通知書共通情報.get更正後();
        if (更正後.get保険料率() != null) {
            source.listUpper_9 = DecimalFormatter.toコンマ区切りRString(new Decimal(更正後.get保険料率().toString()), 0);
        }
        List<UniversalPhase> 普徴期別金額リスト = 更正後.get更正後普徴期別金額リスト();
        if (普徴期別金額リスト != null) {
            当期編集(普徴期別金額リスト, source);
        }
        if (更正後.get生保開始日_西暦() != null) {
            source.listUpper_12 = new FlexibleDate(new RDate(更正後.get生保開始日_西暦().toString()).toDateString()).wareki().toDateString();
        }
        source.listUpper_13 = RString.EMPTY;
        if (!RString.isNullOrEmpty(更正後.get生活保護扶助種類())) {
            source.listUpper_13 = CodeMaster.getCodeMeisho(SubGyomuCode.URZ業務共通_共通系,
                    URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                    new Code(更正後.get生活保護扶助種類()));
        }
        if (isNull(更正後.get更正後特徴期別金額合計())) {
            source.listLower_5 = RString.EMPTY;
        } else {
            source.listLower_5 = DecimalFormatter.toコンマ区切りRString(更正後.get更正後特徴期別金額合計(), 0);
        }
        if (普徴期別金額リスト != null) {
            次期以降編集(source, 普徴期別金額リスト);
        }
    }

    private void 編集後宛先相関項目編集(final EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報,
            KariNonyuTsuchishoHakkoIchiranSource source) {
        final EditedAtesaki 編集後宛先 = 編集後仮算定通知書共通情報.get編集後宛先();
        if (isNull(編集後宛先)) {
            source.listUpper_11 = RString.EMPTY;
            source.listLower_1 = RString.EMPTY;
            source.listLower_2 = RString.EMPTY;
            source.listLower_3 = RString.EMPTY;
            source.listUpper_8 = RString.EMPTY;
        } else {
            if (isNull(編集後宛先.get宛先種別()) || isNull(編集後宛先.get宛先名称())
                    || (!AtesakiShubetsu.本人.equals(編集後宛先.get宛先種別()))) {
                source.listUpper_11 = RString.EMPTY;
            } else {
                source.listUpper_11 = isNull(編集後宛先.get宛先名称().getName()) ? RString.EMPTY
                        : 編集後宛先.get宛先名称().getName().value();
            }
            if (isNull(編集後宛先.get行政区())) {
                source.listUpper_8 = RString.EMPTY;
            } else {
                source.listUpper_8 = 編集後宛先.get行政区().get名称();
            }
            if (isNull(編集後宛先.get本人名称())) {
                source.listLower_1 = RString.EMPTY;
            } else {
                source.listLower_1 = isNull(編集後宛先.get本人名称().getName()) ? RString.EMPTY
                        : 編集後宛先.get本人名称().getName().value();
            }
            source.listLower_2 = 編集後宛先.get郵便番号();
            source.listLower_3 = 編集後宛先.get編集後住所();
        }
    }

    private void 当期編集(List<UniversalPhase> 普徴期別金額リスト, KariNonyuTsuchishoHakkoIchiranSource source) {
        for (UniversalPhase 普徴期別金額 : 普徴期別金額リスト) {
            if (出力期 == 普徴期別金額.get期()) {
                source.listUpper_10 = DecimalFormatter.toコンマ区切りRString(普徴期別金額.get金額(), 0);
                break;
            }
        }
    }

    private void 次期以降編集(KariNonyuTsuchishoHakkoIchiranSource source, List<UniversalPhase> 普徴期別金額リスト) {
        if (出力期 == 1) {
            source.listLower_6 = new RString(0);
        } else {
            for (UniversalPhase 普徴期別金額 : 普徴期別金額リスト) {
                if ((出力期 + 1) == 普徴期別金額.get期()) {
                    source.listLower_6 = isNull(普徴期別金額.get金額()) ? new RString(0)
                            : DecimalFormatter.toコンマ区切りRString(普徴期別金額.get金額(), 0);
                    break;
                }
            }
        }
    }

    private RString 表示コード編集(final RString 表示コード) {
        return isNull(表示コード) ? RString.EMPTY : 表示コード;
    }

    private void set編集後口座(final EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報,
            KariNonyuTsuchishoHakkoIchiranSource source) {
        EditedKoza 編集後口座 = 編集後仮算定通知書共通情報.get編集後口座();
        if (!isNull(編集後口座)) {
            RString 口座種別略称 = 編集後口座.get口座種別略称();
            if (!isNull(口座種別略称) && 口座種別略称.length() >= NUM_2) {
                口座種別略称 = 口座種別略称.substring(NUM_0, NUM_2);
            } else {
                口座種別略称 = RString.EMPTY;
            }
            RString 口座番号 = 編集後口座.get口座番号Or通帳記号番号();
            if (!isNull(口座番号) && 口座番号.length() >= NUM_7) {
                口座番号 = 口座番号.substring(NUM_0, NUM_7);
            } else {
                口座番号 = RString.EMPTY;
            }
            RString 口座名義人漢字優先 = isNull(編集後口座.get口座名義人漢字優先()) ? RString.EMPTY
                    : 編集後口座.get口座名義人漢字優先();
            RString 金融機関コード = isNull(編集後口座.get金融機関コードCombinedWith支店コード()) ? RString.EMPTY
                    : 編集後口座.get金融機関コードCombinedWith支店コード();
            source.listLower_7 = 金融機関コード.concat(RString.HALF_SPACE).concat(口座種別略称)
                    .concat(HYPHEN).concat(口座番号).concat(RString.HALF_SPACE).concat(口座名義人漢字優先);
            if (金融機関コード.length() >= NUM_4 && ゆうちょ銀行.equals(金融機関コード.subSequence(NUM_0, NUM_4))) {
                source.listLower_7 = 金融機関コード.concat(RString.HALF_SPACE)
                        .concat(口座番号).concat(RString.HALF_SPACE).concat(口座名義人漢字優先);
            }
        } else {
            source.listLower_7 = RString.EMPTY;
        }
    }

    /**
     * 出力帳票entityss
     *
     * @param source KariNonyuTsuchishoHakkoIchiranSource
     */
    private void 出力帳票entities(KariNonyuTsuchishoHakkoIchiranSource source) {
        source.shutsuryokujun1 = 並び順List.size() <= NUM_0 ? RString.EMPTY : 並び順List.get(NUM_0);
        source.shutsuryokujun2 = 並び順List.size() <= NUM_1 ? RString.EMPTY : 並び順List.get(NUM_1);
        source.shutsuryokujun3 = 並び順List.size() <= NUM_2 ? RString.EMPTY : 並び順List.get(NUM_2);
        source.shutsuryokujun4 = 並び順List.size() <= NUM_3 ? RString.EMPTY : 並び順List.get(NUM_3);
        source.shutsuryokujun5 = 並び順List.size() <= NUM_4 ? RString.EMPTY : 並び順List.get(NUM_4);
    }

    private boolean isNull(Object object) {
        return object == null;
    }
}
