/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteitsuchishohakko.TsuchishoDataTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特別徴収開始通知書（仮算定）発行一覧表Report
 *
 * @reamsid_L DBB-0790-060 surun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuKaishiTsuchishoKariHakkoIchirReport extends
        Report<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> {

    private final EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報entity;
    private final FlexibleYear 調定年度;
    private final YMDHMS 帳票作成日時;
    private final Association association;
    private final List<RString> 出力項目リスト;
    private final List<RString> 改頁項目リスト;
    private final int 連番;
    private final TsuchishoDataTempEntity entity;

    /**
     * コンストラクタです
     *
     * @param 編集後仮算定通知書共通情報entity EditedKariSanteiTsuchiShoKyotsu
     * @param 調定年度 FlexibleYear
     * @param 帳票作成日時 YMDHMS
     * @param association Association
     * @param 出力項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     * @param 連番 int
     * @param entity TsuchishoDataTempEntity
     */
    public TokubetsuChoshuKaishiTsuchishoKariHakkoIchirReport(
            EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報entity,
            FlexibleYear 調定年度, YMDHMS 帳票作成日時, Association association,
            List<RString> 出力項目リスト,
            List<RString> 改頁項目リスト,
            int 連番, TsuchishoDataTempEntity entity) {
        this.編集後仮算定通知書共通情報entity = 編集後仮算定通知書共通情報entity;
        this.調定年度 = 調定年度;
        this.帳票作成日時 = 帳票作成日時;
        this.association = association;
        this.出力項目リスト = 出力項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
        this.連番 = 連番;
        this.entity = entity;
    }

    /**
     * コンストラクタです
     *
     * @param 編集後仮算定通知書共通情報entity EditedKariSanteiTsuchiShoKyotsu
     * @param 調定年度 FlexibleYear
     * @param 帳票作成日時 YMDHMS
     * @param association Association
     * @param 出力項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     * @param 連番 int
     * @param entity TsuchishoDataTempEntity
     */
    public TokubetsuChoshuKaishiTsuchishoKariHakkoIchirReport(
            EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報entity,
            FlexibleYear 調定年度, YMDHMS 帳票作成日時, Association association,
            List<RString> 出力項目リスト,
            List<RString> 改頁項目リスト,
            int 連番) {
        this.編集後仮算定通知書共通情報entity = 編集後仮算定通知書共通情報entity;
        this.調定年度 = 調定年度;
        this.帳票作成日時 = 帳票作成日時;
        this.association = association;
        this.出力項目リスト = 出力項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
        this.連番 = 連番;
        this.entity = null;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> writer) {
        ITokubetsuChoshuKaishiTsuchishoKariHakkoIchiranEditor editor
                = new TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranEditor(編集後仮算定通知書共通情報entity,
                        調定年度, 帳票作成日時, 連番, association, 出力項目リスト, 改頁項目リスト, entity);
        ITokubetsuChoshuKaishiTsuchishoKariHakkoIchiranBuilder builder
                = new TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranBuilder(editor);
        writer.writeLine(builder);
    }
}
