/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200002;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00002.ChohyoShutsuryokuJohoShutokuResultEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd00002.RiyoshaFutangakuGemmenGaitoshaIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 利用者負担額減免認定者リスト発行です。
 *
 * @reamsid_L DBD-3980-050 x_youyj
 */
public class RiyoshaFutangakuGemmenGaitoshaIchiranReport extends Report<RiyoshaFutangakuGemmenGaitoshaIchiranReportSource> {

    private final ChohyoShutsuryokuJohoShutokuResultEntity target;

    /**
     * インスタンスを生成します。
     *
     * @param target target
     * @param 帳票作成日時 帳票作成日時
     * @param 出力順 出力順
     * @param 導入団体コード 導入団体コード
     * @param 導入団体名称 導入団体名称
     * @param 帳票タイトル 帳票タイトル
     * @param 改ページ 改ページ
     */
    public RiyoshaFutangakuGemmenGaitoshaIchiranReport(ChohyoShutsuryokuJohoShutokuResultEntity target, RDateTime 帳票作成日時,
            RString 出力順, RString 導入団体コード, RString 導入団体名称, RString 帳票タイトル, RString 改ページ) {
        this.target = target;
        this.target.set帳票作成日時(帳票作成日時);
        this.target.set出力順(出力順);
        this.target.set導入団体コード(導入団体コード);
        this.target.set導入団体名称(導入団体名称);
        this.target.set帳票タイトル(帳票タイトル);
        this.target.set改ページ(改ページ);
    }

    @Override
    public void writeBy(ReportSourceWriter<RiyoshaFutangakuGemmenGaitoshaIchiranReportSource> writer) {
        IRiyoshaFutangakuGemmenGaitoshaIchiranEditor editor = new RiyoshaFutangakuGemmenGaitoshaIchiranEditorImpl(target);
        IRiyoshaFutangakuGemmenGaitoshaIchiranBuilder builder = new RiyoshaFutangakuGemmenGaitoshaIchiranBuilderImpl(editor);
        writer.writeLine(builder);

    }
}
