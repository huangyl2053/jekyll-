/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.hanteikekkaichirana3;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkaichirana3.HanteiKekkaIchiranA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.hanteikekkaichirana3.HanteiKekkaIchiranA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定判定結果一覧表Ａ３版のReportです。
 *
 * @reamsid_L DBE-0180-050 xuyannan
 */
public class HanteiKekkaIchiranA3Report extends Report<HanteiKekkaIchiranA3ReportSource> {

    private final HanteiKekkaIchiranA3Entity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 要介護認定判定結果一覧表Ａ３版のentity
     */
    public HanteiKekkaIchiranA3Report(HanteiKekkaIchiranA3Entity entity) {
        this.entity = entity;
    }

    /**
     * 要介護認定判定結果一覧表Ａ３版を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<HanteiKekkaIchiranA3ReportSource> reportSourceWriter) {
        IHanteiKekkaIchiranA3Editor editor = new HanteiKekkaIchiranA3EditorImpl(entity);
        IHanteiKekkaIchiranA3Builder builder = new HanteiKekkaIchiranA3BuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }

}
