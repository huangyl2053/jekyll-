/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishohonsanteihakkoichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.nonyutsuchichiran.NonyuTsuchIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.URZCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import lombok.NonNull;

/**
 * 帳票設計_DBBRP43002_2_保険料納入通知書（本算定）NonyuTsuchIchiranReport
 *
 * @reamsid_L DBB-0780-080 yangchenbing
 */
public class NonyuTsuchIchiranReport extends Report<NonyuTsuchIchiranSource> {

    private final List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報;
    private final NonyuTsuchIchiranBatchParameter バッチパラメータ;
    private final List<RString> 改頁項目リスト;
    private final RString 帳票作成日時;
    private final RString 市町村コード;
    private final RString 市町村名;
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM2 = 2;
    private static final int NUM3 = 3;
    private static final int NUM4 = 4;
    private static final int SIZE = 18;
    private final List<NonyuTsuchIchiranItem> targets;

    /**
     * コンストラクタです。
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param バッチパラメータ NonyuTsuchIchiranBatchParameter
     * @param 改頁項目リスト List<RString>
     * @param 帳票作成日時 RString
     * @param 市町村コード RString
     * @param 市町村名 RString
     */
    protected NonyuTsuchIchiranReport(List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
            NonyuTsuchIchiranBatchParameter バッチパラメータ,
            List<RString> 改頁項目リスト,
            RString 帳票作成日時, RString 市町村コード, RString 市町村名) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.バッチパラメータ = バッチパラメータ;
        this.改頁項目リスト = 改頁項目リスト;
        this.帳票作成日時 = 帳票作成日時;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        targets = new ArrayList<>();
    }

    /**
     * createFormメソッド
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param バッチパラメータ NonyuTsuchIchiranBatchParameter
     * @param 改頁項目リスト List<RString>
     * @param 帳票作成日時 RString
     * @param 市町村コード RString
     * @param 市町村名 RString
     * @return NonyuTsuchIchiranReport
     */
    public static NonyuTsuchIchiranReport createFrom(@NonNull List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
            @NonNull NonyuTsuchIchiranBatchParameter バッチパラメータ,
            @NonNull List<RString> 改頁項目リスト,
            @NonNull RString 帳票作成日時,
            @NonNull RString 市町村コード, @NonNull RString 市町村名) {
        return new NonyuTsuchIchiranReport(編集後本算定通知書共通情報, バッチパラメータ, 改頁項目リスト, 帳票作成日時, 市町村コード, 市町村名);
    }

    /**
     *
     * @param reportSourceWriter reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<NonyuTsuchIchiranSource> reportSourceWriter) {
        makeNonyuTsuchIchiranItemList();
        for (NonyuTsuchIchiranItem target : targets) {
            INonyuTsuchIchiranEditor headerEditor = new HeaderEditor(target);
            INonyuTsuchIchiranEditor hyojiIchiranEditor = new BodyEditor(target);
            INonyuTsuchIchiranBuilder builder = new NonyuTsuchIchiranBuilder(headerEditor, hyojiIchiranEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    /**
     * 変数付値、復雑度を簡素化する
     *
     * @param 編集後本算定通知書共通情報
     * @param item
     */
    private void setOtherValue(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報, NonyuTsuchIchiranItem item) {
        if (編集後本算定通知書共通情報.get更正後() != null
                && 編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト() != null) {
            for (UniversalPhase entity : 編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト()) {
                if (entity.get期() == Integer.valueOf(バッチパラメータ.get出力期().toString())) {
                    item.setListUpper_10(new RString(entity.get金額().toString()));
                }
            }
        }
    }

    /**
     * makeNonyuTsuchIchiranItemList
     */
    private void makeNonyuTsuchIchiranItemList() {
        for (int i = 0; i < 編集後本算定通知書共通情報.size(); i++) {
            NonyuTsuchIchiranItem item1 = new NonyuTsuchIchiranItem();
            item1.setPrintTimeStamp(帳票作成日時);
            item1.setNendo(バッチパラメータ.get賦課年度());
            item1.setHokenshaNo(市町村コード);
            item1.setHokenshaName(市町村名);
            出力帳票entityss(item1);
            if (編集後本算定通知書共通情報.get(i).get表示コード() != null) {
                item1.setHyojicodeName1(編集後本算定通知書共通情報.get(i).get表示コード().get表示コード名１());
                item1.setHyojicodeName2(編集後本算定通知書共通情報.get(i).get表示コード().get表示コード名２());
                item1.setHyojicodeName3(編集後本算定通知書共通情報.get(i).get表示コード().get表示コード名３());
            }
            item1.setShotokuDankaiTitle(new RString("所得段階"));
            if ((i + 1) % SIZE != 0) {
                item1.setListUpper_1(new RString(Integer.valueOf((i + 1) % SIZE).toString()));
            } else {
                item1.setListUpper_1(new RString("18"));
            }
            if (編集後本算定通知書共通情報.get(i).get通知書番号() != null) {
                item1.setListUpper_2(new RString(編集後本算定通知書共通情報.get(i).get通知書番号().toString()));
            }
            if (編集後本算定通知書共通情報.get(i).get被保険者番号() != null) {
                item1.setListUpper_3(編集後本算定通知書共通情報.get(i).get被保険者番号().value());
            }
            if (編集後本算定通知書共通情報.get(i).get編集後個人() != null && 編集後本算定通知書共通情報.get(i).
                    get編集後個人().get世帯コード() != null) {
                item1.setListUpper_4(new RString(編集後本算定通知書共通情報.get(i).get編集後個人().get世帯コード().toString()));
            }
            if (編集後本算定通知書共通情報.get(i).get表示コード() != null) {
                item1.setListUpper_5(編集後本算定通知書共通情報.get(i).get表示コード().get表示コード１());
                item1.setListUpper_6(編集後本算定通知書共通情報.get(i).get表示コード().get表示コード２());
                item1.setListUpper_7(編集後本算定通知書共通情報.get(i).get表示コード().get表示コード３());
            }
            if (編集後本算定通知書共通情報.get(i).get編集後宛先() != null) {
                item1.setListUpper_8(編集後本算定通知書共通情報.get(i).get編集後宛先().get宛先行政区());
            }
            if (編集後本算定通知書共通情報.get(i).get更正後() != null
                    && 編集後本算定通知書共通情報.get(i).get更正後().get確定保険料_年額() != null) {
                item1.setListUpper_9(new RString(編集後本算定通知書共通情報.get(i).get更正後().get確定保険料_年額().toString()));
            }
            setOtherValue(編集後本算定通知書共通情報.get(i), item1);
            if ((編集後本算定通知書共通情報.get(i).get編集後宛先() != null) && ((編集後本算定通知書共通情報.get(i).get編集後宛先().get本人名称())
                    != (編集後本算定通知書共通情報.get(i).get編集後宛先().get宛先名称()))) {
                item1.setListUpper_12(new RString("*" + "　" + 編集後本算定通知書共通情報.get(i).get編集後宛先().get宛先名称().toString()));
            }
            if (編集後本算定通知書共通情報.get(i).get更正後() != null
                    && 編集後本算定通知書共通情報.get(i).get更正後().get生保開始日() != null) {
                item1.setListUpper_13(編集後本算定通知書共通情報.get(i).get更正後().get生保開始日());
            }

            RString 生活保護扶助名称 = null;
            if (編集後本算定通知書共通情報.get(i).get更正後() != null
                    && 編集後本算定通知書共通情報.get(i).get更正後().get生活保護扶助種類().toString() != null) {
                生活保護扶助名称 = CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系,
                        URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                        new Code(編集後本算定通知書共通情報.get(i).get更正後().get生活保護扶助種類().toString())).getコード名称();
            }
            item1.setListUpper_14(生活保護扶助名称);
            listlowers(item1, i);

        }
    }

    /**
     * 出力帳票entityss
     *
     * @param item1
     */
    private void 出力帳票entityss(NonyuTsuchIchiranItem item1) {
        RString 並び順の1件目 = 改頁項目リスト.size() <= NUM0 ? RString.EMPTY : 改頁項目リスト.get(NUM0);
        if (並び順の1件目 != null && !並び順の1件目.isEmpty()) {
            item1.setShutsuryokujun1(並び順の1件目);
        }
        RString 並び順の2件目 = 改頁項目リスト.size() <= NUM1 ? RString.EMPTY : 改頁項目リスト.get(NUM1);
        if (並び順の2件目 != null) {
            item1.setShutsuryokujun2(並び順の2件目);
        }
        RString 並び順の3件目 = 改頁項目リスト.size() <= NUM2 ? RString.EMPTY : 改頁項目リスト.get(NUM2);
        if (並び順の3件目 != null) {
            item1.setShutsuryokujun3(並び順の3件目);
        }
        RString 並び順の4件目 = 改頁項目リスト.size() <= NUM3 ? RString.EMPTY : 改頁項目リスト.get(NUM3);
        if (並び順の4件目 != null) {
            item1.setShutsuryokujun4(並び順の4件目);
        }
        RString 並び順の5件目 = 改頁項目リスト.size() <= NUM4 ? RString.EMPTY : 改頁項目リスト.get(NUM4);
        if (並び順の5件目 != null) {
            item1.setShutsuryokujun5(並び順の5件目);
        }
    }

    /**
     * listlowers
     *
     * @param item1
     * @param i
     */
    private void listlowers(NonyuTsuchIchiranItem item1, int i) {
        if (編集後本算定通知書共通情報.get(i).get編集後宛先() != null) {
            item1.setListLower_1(new RString(編集後本算定通知書共通情報.get(i).get編集後宛先().get本人名称().toString()));
        }
        if (編集後本算定通知書共通情報.get(i).get編集後宛先() != null) {
            item1.setListLower_2(編集後本算定通知書共通情報.get(i).get編集後宛先().get郵便番号());
        }
        if (編集後本算定通知書共通情報.get(i).get編集後宛先() != null) {
            item1.setListLower_3(編集後本算定通知書共通情報.get(i).get編集後宛先().get町域());
        }
        if (編集後本算定通知書共通情報.get(i).get更正後() != null
                && 編集後本算定通知書共通情報.get(i).get更正後().get保険料段階() != null) {
            item1.setListLower_4(編集後本算定通知書共通情報.get(i).get更正後().get保険料段階());
        }
        if (編集後本算定通知書共通情報.get(i).get今後納付すべき額() != null) {
            item1.setListLower_5(new RString(編集後本算定通知書共通情報.get(i).get今後納付すべき額().toString()));
        }
        if (編集後本算定通知書共通情報.get(i).get更正後() != null
                && 編集後本算定通知書共通情報.get(i).get更正後().get普徴期別金額リスト() != null) {
            for (UniversalPhase entity : 編集後本算定通知書共通情報.get(i).get更正後().get普徴期別金額リスト()) {
                if (entity.get期() == (Integer.valueOf(バッチパラメータ.get出力期().toString()) + 1)) {
                    item1.setListLower_6(new RString(entity.get金額().toString()));
                }
            }
        }
        //TODO ビジネス設計_DBBBZ43002_本算定通知書一括発行（バッチ）まだ完成していない
        item1.setListLower_8(new RString("口座情報（PSMで取得"));
        targets.add(item1);
    }
}
