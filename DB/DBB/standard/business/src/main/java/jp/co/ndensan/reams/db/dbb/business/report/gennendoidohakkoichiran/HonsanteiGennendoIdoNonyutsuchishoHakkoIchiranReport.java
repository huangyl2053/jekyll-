/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gennendoidohakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.nonyutsuchichiran.NonyuTsuchIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBRP44002_1_保険料納入通知書（本算定現年度異動）発行一覧表 Reportです。
 *
 * Sourceは帳票設計_DBBRP43002_2_保険料納入通知書（本算定）発行一覧表と同じです。
 *
 * @reamsid_L DBB-0880-050 zhangrui
 */
public class HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranReport extends Report<NonyuTsuchIchiranSource> {

    private final List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報;
    private final NonyuTsuchIchiranBatchParameter バッチパラメータ;
    private final RString 帳票作成日時;
    private final RString 市町村コード;
    private final RString 市町村名;

    /**
     * コンストラクタです。
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsuのListです
     * @param バッチパラメータ NonyuTsuchIchiranBatchParameter
     * @param 帳票作成日時 RString
     * @param 市町村コード RString
     * @param 市町村名 RString
     */
    public HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranReport(
            List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
            NonyuTsuchIchiranBatchParameter バッチパラメータ,
            RString 帳票作成日時, RString 市町村コード, RString 市町村名) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.バッチパラメータ = バッチパラメータ;
        this.帳票作成日時 = 帳票作成日時;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
    }

    @Override
    public void writeBy(ReportSourceWriter<NonyuTsuchIchiranSource> writer) {
        IHonsanteiGennendoIdoNonyutsuchishoHakkoIchiranEditor headerEditor = new HeaderEditor();
        IHonsanteiGennendoIdoNonyutsuchishoHakkoIchiranEditor bodyEditor = new BodyEditor(
                new HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranInputEntity(編集後本算定通知書共通情報,
                        バッチパラメータ, 帳票作成日時, 市町村コード, 市町村名));
        IHonsanteiGennendoIdoNonyutsuchishoHakkoIchiranBuilder builder
                = new HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }

}
