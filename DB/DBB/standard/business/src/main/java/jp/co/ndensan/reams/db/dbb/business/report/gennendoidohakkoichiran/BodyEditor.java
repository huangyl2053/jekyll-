/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gennendoidohakkoichiran;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.URZCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 帳票設計_DBBRP44002_1_保険料納入通知書（本算定現年度異動）発行一覧表 BodyEditorです。
 *
 * 帳票項目定義は帳票設計_DBBRP43002_2_保険料納入通知書（本算定）発行一覧表と同じです。
 *
 * @reamsid_L DBB-0880-050 zhangrui
 */
public class BodyEditor implements IHonsanteiGennendoIdoNonyutsuchishoHakkoIchiranEditor {

    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final RString 出力期;
    private final int 連番;

    private static final int 金融機関コード_START = 0;
    private static final int 金融機関コード_END = 4;

    private static final RString 半角ハイフン = new RString("-");
    private static final RString アステリスク = new RString("*");

    /**
     * コンストラクタです。
     *
     * @param inputEntity HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranInputEntity
     */
    public BodyEditor(HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranInputEntity inputEntity) {
        this.編集後本算定通知書共通情報 = inputEntity.get編集後本算定通知書共通情報();
        this.出力期 = inputEntity.get出力期();
        this.連番 = inputEntity.get連番();
    }

    @Override
    public NonyuTsuchIchiranSource edit(NonyuTsuchIchiranSource source) {
        EditedHonSanteiTsuchiShoKyotsu 共通情報 = 編集後本算定通知書共通情報;

        source.listUpper_1 = new RString(Integer.valueOf(連番).toString());
        if (共通情報.get通知書番号() != null) {
            source.listUpper_2 = new RString(共通情報.get通知書番号().toString());
        }
        if (共通情報.get被保険者番号() != null) {
            source.listUpper_3 = 共通情報.get被保険者番号().value();
        }
        if (共通情報.get編集後個人() != null && 共通情報.get編集後個人().get世帯コード() != null) {
            source.listUpper_4 = new RString(共通情報.get編集後個人().get世帯コード().toString());
        }
        if (共通情報.get表示コード() != null) {
            source.listUpper_5 = 共通情報.get表示コード().get表示コード１();
            source.listUpper_6 = 共通情報.get表示コード().get表示コード２();
            source.listUpper_7 = 共通情報.get表示コード().get表示コード３();
        }
        if (共通情報.get編集後宛先() != null) {
            source.listUpper_8 = 共通情報.get編集後宛先().get宛先行政区();
        }
        if (共通情報.get更正後() != null
                && 共通情報.get更正後().get確定保険料_年額() != null) {
            source.listUpper_9 = new RString(共通情報.get更正後().get確定保険料_年額().toString());
        }
        setOtherValue(共通情報, source);
        if ((共通情報.get編集後宛先() != null) && !(共通情報.get編集後宛先().get本人名称().getName().toString()
                .equals(共通情報.get編集後宛先().get宛先名称().getName().toString()))) {
            source.listUpper_12 = new RString(アステリスク.toString() + RString.FULL_SPACE
                    + 共通情報.get編集後宛先().get宛先名称().getName().toString());
        }
        if (共通情報.get更正後() != null
                && 共通情報.get更正後().get生保開始日() != null) {
            source.listUpper_13 = 共通情報.get更正後().get生保開始日();
        }

        RString 生活保護扶助名称 = null;
        if (共通情報.get更正後() != null
                && 共通情報.get更正後().get生活保護扶助種類() != null) {
            生活保護扶助名称 = CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系,
                    URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                    new Code(共通情報.get更正後().get生活保護扶助種類().toString())).getコード名称();
        }
        source.listUpper_14 = 生活保護扶助名称;
        setListLowers(source, 共通情報);
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
                if (entity.get期() == Integer.valueOf(出力期.toString())) {
                    source.listUpper_10 = new RString(entity.get金額().toString());
                }
            }
        }
    }

    private void setListLowers(NonyuTsuchIchiranSource source, EditedHonSanteiTsuchiShoKyotsu 共通情報) {
        if (共通情報.get編集後宛先() != null) {
            source.listLower_1 = new RString(共通情報.get編集後宛先().get本人名称().getName().toString());
        }
        if (共通情報.get編集後宛先() != null) {
            source.listLower_2 = 共通情報.get編集後宛先().get郵便番号();
        }
        if (共通情報.get編集後宛先() != null) {
            source.listLower_3 = 共通情報.get編集後宛先().get町域();
        }
        if (共通情報.get更正後() != null
                && 共通情報.get更正後().get保険料段階() != null) {
            source.listLower_4 = 共通情報.get更正後().get保険料段階();
        }
        if (共通情報.get今後納付すべき額() != null) {
            source.listLower_5 = new RString(共通情報.get今後納付すべき額().toString());
        }
        if (共通情報.get更正後() != null
                && 共通情報.get更正後().get普徴期別金額リスト() != null) {
            for (UniversalPhase entity : 共通情報.get更正後().get普徴期別金額リスト()) {
                if (entity.get期() == (Integer.valueOf(出力期.toString()) + 1)) {
                    source.listLower_6 = new RString(entity.get金額().toString());
                }
            }
        }
        RStringBuilder builder = new RStringBuilder();
        EditedKoza 編集後口座 = 共通情報.get編集後口座();
        if (null != 編集後口座 && 編集後口座.isゆうちょ銀行()) {
            builder.append(編集後口座.get金融機関コードCombinedWith支店コード().substring(
                    金融機関コード_START, 金融機関コード_END));
            builder.append(RString.HALF_SPACE);
            builder.append(編集後口座.get口座番号Or通帳記号番号());
            builder.append(RString.HALF_SPACE);
            builder.append(編集後口座.get口座名義人漢字優先());
        } else if (null != 編集後口座 && !編集後口座.isゆうちょ銀行()) {
            builder.append(編集後口座.get金融機関コードCombinedWith支店コード());
            builder.append(RString.HALF_SPACE);
            builder.append(編集後口座.get口座種別略称());
            builder.append(半角ハイフン);
            builder.append(編集後口座.get口座番号Or通帳記号番号());
            builder.append(RString.HALF_SPACE);
            builder.append(編集後口座.get口座名義人漢字優先());
        }
        source.listLower_8 = builder.toRString();
    }

}
