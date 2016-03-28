/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kaigohokenryogakuketteihenkotsuchihakkoichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.nonyutsuchichiran.NonyuTsuchIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenryogakuketteihenkotsuchihakkoichiran.KaigoHokenryogakuSource;
import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.URZCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import lombok.NonNull;

/**
 * 帳票設計_DBBRP43002_3_介護保険料額決定通知書発行一覧表KaigoHokenryogakuReport
 */
public class KaigoHokenryogakuReport extends Report<KaigoHokenryogakuSource> {

    private final List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報;
    private final NonyuTsuchIchiranBatchParameter バッチパラメータ;
    private final RString 帳票作成日時;
    private final RString タイトル;
    private final RString 市町村コード;
    private final RString 市町村名;
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM2 = 2;
    private static final int NUM3 = 3;
    private static final int NUM4 = 4;
    private static final int SIZE = 18;
    private final List<KaigoHokenryogakuItem> targets;

    /**
     * コンストラクタです。
     *
     * @param 編集後本算定通知書共通情報 List<EditedHonSanteiTsuchiShoKyotsu>
     * @param バッチパラメータ NonyuTsuchIchiranBatchParameter
     * @param 帳票作成日時 RString
     * @param タイトル RString
     * @param 市町村コード RString
     * @param 市町村名 RString
     */
    protected KaigoHokenryogakuReport(List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
            NonyuTsuchIchiranBatchParameter バッチパラメータ,
            RString 帳票作成日時, RString タイトル, RString 市町村コード, RString 市町村名) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.バッチパラメータ = バッチパラメータ;
        this.帳票作成日時 = 帳票作成日時;
        this.タイトル = タイトル;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        targets = new ArrayList<>();
    }

    /**
     * createFormメソッド
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param バッチパラメータ KaigoHokenryogakuParameter
     * @param 帳票作成日時 RString
     * @param タイトル RString
     * @param 市町村コード RString
     * @param 市町村名 RString
     * @return NonyuTsuchIchiranReport
     */
    public static KaigoHokenryogakuReport createFrom(@NonNull List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
            @NonNull NonyuTsuchIchiranBatchParameter バッチパラメータ,
            @NonNull RString 帳票作成日時, @NonNull RString タイトル,
            @NonNull RString 市町村コード, @NonNull RString 市町村名
    ) {
        return new KaigoHokenryogakuReport(編集後本算定通知書共通情報, バッチパラメータ, 帳票作成日時, タイトル, 市町村コード, 市町村名);
    }

    /**
     *
     * @param reportSourceWriter reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<KaigoHokenryogakuSource> reportSourceWriter) {
        makeNonyuTsuchIchiranItemList();
        for (KaigoHokenryogakuItem target : targets) {
            IKaigoHokenryogakuEditor headerEditor = new HeaderEditor(target);
            IKaigoHokenryogakuEditor hyojiIchiranEditor = new BodyEditor(target);
            IKaigoHokenryogakuBuilder builder = new KaigoHokenryogakuBuilder(headerEditor, hyojiIchiranEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private void makeNonyuTsuchIchiranItemList() {
        for (int i = 0; i < 編集後本算定通知書共通情報.size(); i++) {
            KaigoHokenryogakuItem item1 = new KaigoHokenryogakuItem();
            item1.setPrintTimeStamp(帳票作成日時);
            item1.setTitle(タイトル);
            item1.setHokenshaNo(市町村コード);
            item1.setHokenshaName(市町村名);
            if (バッチパラメータ.get出力帳票entity() != null) {
                if (バッチパラメータ.get出力帳票entity().size() > NUM0) {
                    item1.setShutsuryokujun1(バッチパラメータ.get出力帳票entity().get(NUM0).get改頁出力順ID());
                }
                if (バッチパラメータ.get出力帳票entity().size() > NUM1) {
                    item1.setShutsuryokujun2(バッチパラメータ.get出力帳票entity().get(NUM1).get改頁出力順ID());
                }
                if (バッチパラメータ.get出力帳票entity().size() > NUM2) {
                    item1.setShutsuryokujun3(バッチパラメータ.get出力帳票entity().get(NUM2).get改頁出力順ID());
                }
                if (バッチパラメータ.get出力帳票entity().size() > NUM3) {
                    item1.setShutsuryokujun4(バッチパラメータ.get出力帳票entity().get(NUM3).get改頁出力順ID());
                }
                if (バッチパラメータ.get出力帳票entity().size() > NUM4) {
                    item1.setShutsuryokujun5(バッチパラメータ.get出力帳票entity().get(NUM4).get改頁出力順ID());
                }
            }
            if (編集後本算定通知書共通情報.get(i).get表示コード() != null) {
                item1.setHyojicodeName1(編集後本算定通知書共通情報.get(i).get表示コード().get表示コード名１());
                item1.setHyojicodeName2(編集後本算定通知書共通情報.get(i).get表示コード().get表示コード名２());
                item1.setHyojicodeName3(編集後本算定通知書共通情報.get(i).get表示コード().get表示コード名３());
            }
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
            if (編集後本算定通知書共通情報.get(i).get編集後個人() != null && 編集後本算定通知書共通情報.get(i).get編集後個人().get世帯コード() != null) {
                item1.setListUpper_4(new RString(編集後本算定通知書共通情報.get(i).get編集後個人().get世帯コード().toString()));
            }
            if (編集後本算定通知書共通情報.get(i).get表示コード() != null) {
                item1.setListUpper_5(編集後本算定通知書共通情報.get(i).get表示コード().get表示コード１());
                item1.setListUpper_6(編集後本算定通知書共通情報.get(i).get表示コード().get表示コード２());
                item1.setListUpper_7(編集後本算定通知書共通情報.get(i).get表示コード().get表示コード３());
            }
            item1.setListUpper_8(編集後本算定通知書共通情報.get(i).get更正後().get保険料段階());
            item1.setListUpper_9(new RString(編集後本算定通知書共通情報.get(i).get更正前().get確定保険料_年額().toString()));
            item1.setListUpper_10(編集後本算定通知書共通情報.get(i).get更正前().get徴収方法());
            item1.setListUpper_11(編集後本算定通知書共通情報.get(i).get更正後().get生保開始日());
            RString 生活保護扶助名称 = null;
            if (編集後本算定通知書共通情報.get(i).get更正後().get生活保護扶助種類().toString() != null) {
                生活保護扶助名称 = CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系,
                        URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                        new Code(編集後本算定通知書共通情報.get(i).get更正後().get生活保護扶助種類().toString())).getコード名称();
            }
            item1.setListUpper_12(生活保護扶助名称);
            if (編集後本算定通知書共通情報.get(i).get編集後宛先() != null) {
                item1.setListLower_1(new RString(編集後本算定通知書共通情報.get(i).get編集後宛先().get本人名称().toString()));
            }
            if (編集後本算定通知書共通情報.get(i).get編集後宛先() != null) {
                item1.setListLower_2(編集後本算定通知書共通情報.get(i).get編集後宛先().get郵便番号());
            }
            if (編集後本算定通知書共通情報.get(i).get編集後宛先() != null) {
                item1.setListLower_3(編集後本算定通知書共通情報.get(i).get編集後宛先().get町域());
            }
            item1.setListLower_4(編集後本算定通知書共通情報.get(i).get更正後().get保険料段階());
            item1.setListLower_5(new RString(編集後本算定通知書共通情報.get(i).get更正後().get確定保険料_年額().toString()));
            item1.setListLower_6(編集後本算定通知書共通情報.get(i).get更正後().get徴収方法());
            item1.setListLower_7(new RString("口座情報（PSMで取得"));
            targets.add(item1);
        }
    }
}
