/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishohonsanteihakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.nonyutsuchichiran.NonyuTsuchIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.URZCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 帳票設計_DBBRP43002_2_保険料納入通知書（本算定）HeaderEditor
 *
 * @reamsid_L DBB-0780-080 yangchenbing
 */
public class HeaderEditor implements INonyuTsuchIchiranEditor {

    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final NonyuTsuchIchiranBatchParameter バッチパラメータ;
    private final List<RString> 改頁項目リスト;
    private final RString 帳票作成日時;
    private final RString 市町村コード;
    private final RString 市町村名;
    private final int num;
    private final RString 所得段階 = new RString("所得段階");
    private final RString eighteenRS = new RString("18");
    private static final RString START = new RString("*");
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM2 = 2;
    private static final int NUM3 = 3;
    private static final int NUM4 = 4;
    private static final int SIZE = 18;

    /**
     * インスタンスを生成します。
     *
     * @param 編集後本算定通知書共通情報 List<EditedHonSanteiTsuchiShoKyotsu>
     * @param バッチパラメータ NonyuTsuchIchiranBatchParameter
     * @param 改頁項目リスト 改頁項目リスト
     * @param 帳票作成日時 RString
     * @param 市町村コード RString
     * @param 市町村名 RString
     * @param num int
     */
    protected HeaderEditor(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            NonyuTsuchIchiranBatchParameter バッチパラメータ, List<RString> 改頁項目リスト,
            RString 帳票作成日時, RString 市町村コード, RString 市町村名, int num) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.バッチパラメータ = バッチパラメータ;
        this.改頁項目リスト = 改頁項目リスト;
        this.帳票作成日時 = 帳票作成日時;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        this.num = num;
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
                if (entity.get期() == Integer.valueOf(バッチパラメータ.get出力期().toString())) {
                    source.listUpper_10 = new RString(entity.get金額().toString());
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
        source.printTimeStamp = 帳票作成日時;
        source.nendo = バッチパラメータ.get賦課年度();
        source.hokenshaNo = 市町村コード;
        source.hokenshaName = 市町村名;
        出力帳票entityss(source);
        if (編集後本算定通知書共通情報.get表示コード() != null) {
            source.hyojicodeName1 = 編集後本算定通知書共通情報.get表示コード().get表示コード名１();
            source.hyojicodeName2 = 編集後本算定通知書共通情報.get表示コード().get表示コード名２();
            source.hyojicodeName3 = 編集後本算定通知書共通情報.get表示コード().get表示コード名３();
        }
        source.shotokuDankaiTitle = 所得段階;
        if ((num + 1) % SIZE != 0) {
            source.listUpper_1 = new RString(Integer.valueOf((num + 1) % SIZE).toString());
        } else {
            source.listUpper_1 = eighteenRS;
        }
        if (編集後本算定通知書共通情報.get通知書番号() != null) {
            source.listUpper_2 = new RString(編集後本算定通知書共通情報.get通知書番号().toString());
        }
        if (編集後本算定通知書共通情報.get被保険者番号() != null) {
            source.listUpper_3 = 編集後本算定通知書共通情報.get被保険者番号().value();
        }
        if (編集後本算定通知書共通情報.get編集後個人() != null && 編集後本算定通知書共通情報.
                get編集後個人().get世帯コード() != null) {
            source.listUpper_4 = new RString(編集後本算定通知書共通情報.get編集後個人().get世帯コード().toString());
        }
        if (編集後本算定通知書共通情報.get表示コード() != null) {
            source.listUpper_5 = 編集後本算定通知書共通情報.get表示コード().get表示コード１();
            source.listUpper_6 = 編集後本算定通知書共通情報.get表示コード().get表示コード２();
            source.listUpper_7 = 編集後本算定通知書共通情報.get表示コード().get表示コード３();
        }
        if (編集後本算定通知書共通情報.get編集後宛先() != null) {
            source.listUpper_8 = 編集後本算定通知書共通情報.get編集後宛先().get宛先行政区();
        }
        if (編集後本算定通知書共通情報.get更正後() != null
                && 編集後本算定通知書共通情報.get更正後().get確定保険料_年額() != null) {
            source.listUpper_9 = new RString(編集後本算定通知書共通情報.get更正後().get確定保険料_年額().toString());
        }
        setOtherValue(編集後本算定通知書共通情報, source);
        if ((編集後本算定通知書共通情報.get編集後宛先() != null) && ((編集後本算定通知書共通情報.get編集後宛先().get本人名称())
                != (編集後本算定通知書共通情報.get編集後宛先().get宛先名称()))) {
            source.listUpper_12 = START.concat(new RString(RString.FULL_SPACE + 編集後本算定通知書共通情報.get編集後宛先().get宛先名称().toString()));
        }
        if (編集後本算定通知書共通情報.get更正後() != null
                && 編集後本算定通知書共通情報.get更正後().get生保開始日() != null) {
            source.listUpper_13 = 編集後本算定通知書共通情報.get更正後().get生保開始日();
        }

        RString 生活保護扶助名称 = null;
        if (編集後本算定通知書共通情報.get更正後() != null
                && 編集後本算定通知書共通情報.get更正後().get生活保護扶助種類().toString() != null) {
            生活保護扶助名称 = CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系,
                    URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                    new Code(編集後本算定通知書共通情報.get更正後().get生活保護扶助種類().toString())).getコード名称();
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
        RString 並び順の1件目 = 改頁項目リスト.size() <= NUM0 ? RString.EMPTY : 改頁項目リスト.get(NUM0);
        if (並び順の1件目 != null && !並び順の1件目.isEmpty()) {
            source.shutsuryokujun1 = 並び順の1件目;
        }
        RString 並び順の2件目 = 改頁項目リスト.size() <= NUM1 ? RString.EMPTY : 改頁項目リスト.get(NUM1);
        if (並び順の2件目 != null) {
            source.shutsuryokujun2 = 並び順の2件目;
        }
        RString 並び順の3件目 = 改頁項目リスト.size() <= NUM2 ? RString.EMPTY : 改頁項目リスト.get(NUM2);
        if (並び順の3件目 != null) {
            source.shutsuryokujun3 = 並び順の3件目;
        }
        RString 並び順の4件目 = 改頁項目リスト.size() <= NUM3 ? RString.EMPTY : 改頁項目リスト.get(NUM3);
        if (並び順の4件目 != null) {
            source.shutsuryokujun4 = 並び順の4件目;
        }
        RString 並び順の5件目 = 改頁項目リスト.size() <= NUM4 ? RString.EMPTY : 改頁項目リスト.get(NUM4);
        if (並び順の5件目 != null) {
            source.shutsuryokujun5 = 並び順の5件目;
        }
    }

    /**
     * listlowers
     *
     * @param source NonyuTsuchIchiranSource
     * @param i int
     */
    private void listlowers(NonyuTsuchIchiranSource source) {
        if (編集後本算定通知書共通情報.get編集後宛先() != null) {
            source.listLower_1 = new RString(編集後本算定通知書共通情報.get編集後宛先().get本人名称().toString());
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
            source.listLower_5 = new RString(編集後本算定通知書共通情報.get今後納付すべき額().toString());
        }
        if (編集後本算定通知書共通情報.get更正後() != null
                && 編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト() != null) {
            for (UniversalPhase entity : 編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト()) {
                if (entity.get期() == (Integer.valueOf(バッチパラメータ.get出力期().toString()) + 1)) {
                    source.listLower_6 = new RString(entity.get金額().toString());
                }
            }
        }
        //TODO ビジネス設計_DBBBZ43002_本算定通知書一括発行（バッチ）まだ完成していない
        source.listLower_8 = new RString("口座情報（PSMで取得");
    }
}
