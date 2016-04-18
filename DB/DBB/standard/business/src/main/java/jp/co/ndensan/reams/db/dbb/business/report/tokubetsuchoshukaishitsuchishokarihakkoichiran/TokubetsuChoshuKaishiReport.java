/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.CharacteristicsPhase;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.nonyutsuchichiran.NonyuTsuchIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 帳票設計_DBBRP43002_4_特別徴収開始通知書（本算定）TokubetsuChoshuKaishiReport
 *
 * @reamsid_L DBB-0780-120 yangchenbing
 */
public class TokubetsuChoshuKaishiReport extends Report<TokubetsuChoshuKaishiSource> {

    private final List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報;
    private final NonyuTsuchIchiranBatchParameter バッチパラメータ;
    private final RString 市町村コード;
    private final RString 市町村名;
    private final RString 帳票作成日時;
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM2 = 2;
    private static final int NUM3 = 3;
    private static final int NUM4 = 4;
    private static final int NUM5 = 5;
    private static final int NUM6 = 6;
    private static final int SIZE = 18;
    private final List<TokubetsuChoshuKaishiItem> targets;

    /**
     * コンストラクタです。
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param バッチパラメータ TokubetsuChoshuKaishiParameter
     * @param 帳票作成日時 RString
     * @param 市町村コード RString
     * @param 市町村名 RString
     */
    protected TokubetsuChoshuKaishiReport(List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
            NonyuTsuchIchiranBatchParameter バッチパラメータ,
            RString 帳票作成日時, RString 市町村コード, RString 市町村名) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.バッチパラメータ = バッチパラメータ;
        this.帳票作成日時 = 帳票作成日時;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        targets = new ArrayList<>();
    }

    /**
     * createFormメソッド
     *
     * @param 編集後本算定通知書共通情報 List<EditedHonSanteiTsuchiShoKyotsu>
     * @param バッチパラメータ NonyuTsuchIchiranBatchParameter
     * @param 帳票作成日時 RString
     * @param 市町村コード RString
     * @param 市町村名 RString
     * @return TokubetsuChoshuKaishiReport
     */
    public static TokubetsuChoshuKaishiReport createFrom(@NonNull List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
            @NonNull NonyuTsuchIchiranBatchParameter バッチパラメータ,
            @NonNull RString 帳票作成日時, @NonNull RString 市町村コード, @NonNull RString 市町村名) {
        return new TokubetsuChoshuKaishiReport(編集後本算定通知書共通情報, バッチパラメータ, 帳票作成日時, 市町村コード, 市町村名);
    }

    /**
     *
     * @param reportSourceWriter reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuKaishiSource> reportSourceWriter) {
        makeNonyuTsuchIchiranItemList();
        for (TokubetsuChoshuKaishiItem target : targets) {
            ITokubetsuChoshuKaishiEditor headerEditor = new HeaderEditor(target);
            ITokubetsuChoshuKaishiEditor hyojiIchiranEditor = new BodyEditor(target);
            TokubetsuChoshuKaishiBuilder builder = new TokubetsuChoshuKaishiBuilder(headerEditor, hyojiIchiranEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private void makeNonyuTsuchIchiranItemList() {
        for (int i = 0; i < 編集後本算定通知書共通情報.size(); i++) {
            TokubetsuChoshuKaishiItem item1 = new TokubetsuChoshuKaishiItem();
            item1.setPrintTimeStamp(帳票作成日時);
            item1.setTitle(new RString("特別徴収開始通知書（本算定）発行一覧表"));
            item1.setNendo(バッチパラメータ.get賦課年度());
            item1.setHokenshaNo(市町村コード);
            item1.setHokenshaName(市町村名);
            if (バッチパラメータ.get出力帳票entity() != null) {
                if (バッチパラメータ.get出力帳票entity().size() > NUM0) {
                    item1.setShutsuryokujun1(バッチパラメータ.get出力帳票entity().get(NUM0).get出力順ID());
                    item1.setKaipage1(バッチパラメータ.get出力帳票entity().get(NUM0).get出力順ID());
                }
                if (バッチパラメータ.get出力帳票entity().size() > NUM1) {
                    item1.setShutsuryokujun2(バッチパラメータ.get出力帳票entity().get(NUM1).get出力順ID());
                    item1.setKaipage2(バッチパラメータ.get出力帳票entity().get(NUM1).get出力順ID());
                }
                if (バッチパラメータ.get出力帳票entity().size() > NUM2) {
                    item1.setShutsuryokujun3(バッチパラメータ.get出力帳票entity().get(NUM2).get出力順ID());
                    item1.setKaipage3(バッチパラメータ.get出力帳票entity().get(NUM2).get出力順ID());
                }
                if (バッチパラメータ.get出力帳票entity().size() > NUM3) {
                    item1.setShutsuryokujun4(バッチパラメータ.get出力帳票entity().get(NUM3).get出力順ID());
                    item1.setKaipage4(バッチパラメータ.get出力帳票entity().get(NUM3).get出力順ID());
                }
                if (バッチパラメータ.get出力帳票entity().size() > NUM4) {
                    item1.setShutsuryokujun5(バッチパラメータ.get出力帳票entity().get(NUM4).get出力順ID());
                    item1.setKaipage5(バッチパラメータ.get出力帳票entity().get(NUM4).get出力順ID());
                }
            }
            item1.setTitleChoshugaku(new RString("本徴収額"));
            if ((i + 1) % SIZE != 0) {
                item1.setListUpper_1(new RString(Integer.valueOf((i + 1) % SIZE).toString()));
            } else {
                item1.setListUpper_1(new RString("18"));
            }
            if (編集後本算定通知書共通情報.get(i).get編集後宛先() != null) {
                item1.setListUpper_2(編集後本算定通知書共通情報.get(i).get編集後宛先().get郵便番号());
            }
            if (編集後本算定通知書共通情報.get(i).get編集後宛先() != null) {
                item1.setListUpper_3(編集後本算定通知書共通情報.get(i).get編集後宛先().get町域());
            }
            if (編集後本算定通知書共通情報.get(i).get編集後宛先() != null) {
                item1.setListUpper_4(編集後本算定通知書共通情報.get(i).get編集後宛先().get宛先行政区());
            }
            if (編集後本算定通知書共通情報.get(i).get編集後個人() != null) {
                item1.setListUpper_5(編集後本算定通知書共通情報.get(i).get編集後個人().get生年月日());
            }
            if (編集後本算定通知書共通情報.get(i).get編集後個人() != null) {
                item1.setListUpper_6(編集後本算定通知書共通情報.get(i).get編集後個人().get性別());
            }
            if (編集後本算定通知書共通情報.get(i).get編集後個人() != null && 編集後本算定通知書共通情報.get(i).get編集後個人().get世帯主名() != null) {
                item1.setListUpper_7(new RString(編集後本算定通知書共通情報.get(i).get編集後個人().get世帯主名().toString()));
            }
            listlowers(i, item1);

        }
    }

    private void listlowers(int i, TokubetsuChoshuKaishiItem item1) {
        if (編集後本算定通知書共通情報.get(i).get通知書番号() != null) {
            item1.setListLower_1(new RString(編集後本算定通知書共通情報.get(i).get通知書番号().toString()));
        }
        if (編集後本算定通知書共通情報.get(i).get編集後個人() != null && 編集後本算定通知書共通情報.get(i).get編集後個人().get世帯コード() != null) {
            item1.setListLower_2(new RString(編集後本算定通知書共通情報.get(i).get編集後個人().get世帯コード().toString()));
        }
        if (編集後本算定通知書共通情報.get(i).get編集後個人() != null && 編集後本算定通知書共通情報.get(i).get編集後個人().get名称() != null) {
            item1.setListLower_3(new RString(編集後本算定通知書共通情報.get(i).get編集後個人().get名称().toString()));
        }
        if (編集後本算定通知書共通情報.get(i).get更正後() != null && 編集後本算定通知書共通情報.get(i).get更正後().get特別徴収義務者() != null) {
            item1.setListLower_4(編集後本算定通知書共通情報.get(i).get更正後().get特別徴収義務者());
        }
        if (編集後本算定通知書共通情報.get(i).get更正後() != null && 編集後本算定通知書共通情報.get(i).get更正後().get特別徴収対象年金コード() != null) {
            item1.setListLower_5(new RString(編集後本算定通知書共通情報.get(i).get更正後().get特別徴収対象年金コード().toString()));
        }
        item1.setListLower_6(new RString("10月"));
        for (CharacteristicsPhase entity : 編集後本算定通知書共通情報.get(i).get更正後().get特徴期別金額リスト()) {
            if (Integer.valueOf(entity.get期().toString()) == NUM4) {
                item1.setListLower_7(new RString(entity.get金額().toString()));
            }
            if (Integer.valueOf(entity.get期().toString()) == NUM5) {
                item1.setListLower_9(new RString(entity.get金額().toString()));
            }
            if (Integer.valueOf(entity.get期().toString()) == NUM6) {
                item1.setListLower_11(new RString(entity.get金額().toString()));
            }
        }
        item1.setListLower_8(new RString("12月"));
        item1.setListLower_10(new RString("2月"));
        targets.add(item1);
    }
}
