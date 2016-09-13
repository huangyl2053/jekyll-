/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.ｇassankyufujissekitorikomiichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.gassankyufujissekitorikomiichiran.GassanKyufujissekiTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額合算給付実績情報取込一覧表Reportクラスです。
 *
 * @reamsid_L DBC-2700-030 wangxingpeng
 */
public class GassanKyufujissekiTorikomiIchiranReport extends
        Report<GassanKyufujissekiTorikomiIchiranSource> {

    private final GassanKyufujissekiTorikomiIchiranParameter 帳票出力パラメータ;

    /**
     * コンストラクタです。
     *
     * @param 帳票出力パラメータ GassanKyufujissekiTorikomiIchiranParameter
     */
    public GassanKyufujissekiTorikomiIchiranReport(GassanKyufujissekiTorikomiIchiranParameter 帳票出力パラメータ) {
        this.帳票出力パラメータ = 帳票出力パラメータ;
    }

    @Override
    public void writeBy(ReportSourceWriter<GassanKyufujissekiTorikomiIchiranSource> writer) {
        if (null == 帳票出力パラメータ) {
            return;
        }
        IGassanKyufujissekiTorikomiIchiranEditor headerEditor
                = new GassanKyufujissekiTorikomiIchiranHeaderEditor(帳票出力パラメータ.get出力順Map(),
                        帳票出力パラメータ.get改頁リスト(), 帳票出力パラメータ.get処理年月(), 帳票出力パラメータ.get作成日時());
        IGassanKyufujissekiTorikomiIchiranEditor bodyEditor
                = new GassanKyufujissekiTorikomiIchiranBodyEditor(帳票出力パラメータ.get帳票出力対象(), 帳票出力パラメータ.get連番());
        IGassanKyufujissekiTorikomiIchiranBuilder builder = new GassanKyufujissekiTorikomiIchiranBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }
}
