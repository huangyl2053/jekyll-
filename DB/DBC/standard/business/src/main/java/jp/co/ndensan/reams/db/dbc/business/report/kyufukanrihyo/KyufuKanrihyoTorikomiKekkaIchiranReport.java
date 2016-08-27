/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyo;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufukanrihyo.KyufuKanrihyoTorikomiKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 給付管理票取込結果一覧表帳票Report
 *
 * @reamsid_L DBC-2450-040 zhangrui
 */
public class KyufuKanrihyoTorikomiKekkaIchiranReport extends
        Report<KyufuKanrihyoTorikomiKekkaIchiranSource> {

    private final KyufuKanrihyoTorikomiKekkaIchiranParameter 帳票出力パラメータ;

    /**
     * コンストラクタです。
     *
     * @param 帳票出力パラメータ KyufuKanrihyoTorikomiKekkaIchiranParameter
     */
    public KyufuKanrihyoTorikomiKekkaIchiranReport(KyufuKanrihyoTorikomiKekkaIchiranParameter 帳票出力パラメータ) {
        this.帳票出力パラメータ = 帳票出力パラメータ;
    }

    @Override
    public void writeBy(ReportSourceWriter<KyufuKanrihyoTorikomiKekkaIchiranSource> writer) {
        if (null == 帳票出力パラメータ) {
            return;
        }
        IKyufuKanrihyoTorikomiKekkaIchiranEditor headerEditor = new KyufuKanrihyoTorikomiKekkaIchiranHeaderEditor(
                帳票出力パラメータ.get帳票出力対象(), 帳票出力パラメータ.get出力順Map(), 帳票出力パラメータ.get改頁リスト(),
                帳票出力パラメータ.get処理年月(), 帳票出力パラメータ.get作成日時(), 帳票出力パラメータ.get導入形態コード());
        IKyufuKanrihyoTorikomiKekkaIchiranEditor bodyEditor
                = new KyufuKanrihyoTorikomiKekkaIchiranBodyEditor(帳票出力パラメータ.get帳票出力対象(),
                        帳票出力パラメータ.get導入形態コード(), 帳票出力パラメータ.get集計Flag(),
                        帳票出力パラメータ.get連番(), 帳票出力パラメータ.get件数1(), 帳票出力パラメータ.get件数2(),
                        帳票出力パラメータ.get件数3(), 帳票出力パラメータ.get合計件数());
        IKyufuKanrihyoTorikomiKekkaIchiranBuilder builder
                = new KyufuKanrihyoTorikomiKekkaIchiranBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }

}
