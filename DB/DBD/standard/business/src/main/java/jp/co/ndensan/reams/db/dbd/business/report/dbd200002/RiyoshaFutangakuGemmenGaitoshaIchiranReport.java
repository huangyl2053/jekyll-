/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200002;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00002.NinteishaListSakuseiResultEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd00002.RiyoshaFutangakuGemmenGaitoshaIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 利用者負担額減免認定者リスト発行です。
 *
 * @reamsid_L DBD-3980-060 x_youyj
 */
public class RiyoshaFutangakuGemmenGaitoshaIchiranReport extends Report<RiyoshaFutangakuGemmenGaitoshaIchiranReportSource> {

    private final NinteishaListSakuseiResultEntity target;
    private final IOutputOrder outputOrder;
    private static final int NUM_0 = 0;
    private static final int NUM_4 = 3;

    /**
     * インスタンスを生成します。
     *
     * @param target target
     * @param 帳票作成日時 帳票作成日時
     * @param 出力順 IOutputOrder
     * @param 導入団体コード 導入団体コード
     * @param 導入団体名称 導入団体名称
     * @param 帳票タイトル 帳票タイトル
     * @param 改ページ 改ページ
     */
    public RiyoshaFutangakuGemmenGaitoshaIchiranReport(NinteishaListSakuseiResultEntity target, FlexibleDate 帳票作成日時,
            IOutputOrder 出力順, RString 導入団体コード, RString 導入団体名称, RString 帳票タイトル, RString 改ページ) {
        this.target = target;
        this.target.set帳票作成日時(帳票作成日時);
        this.outputOrder = 出力順;
        this.target.set導入団体コード(導入団体コード);
        this.target.set導入団体名称(導入団体名称);
        this.target.set帳票タイトル(帳票タイトル);
        this.target.set改ページ(改ページ);
    }

    @Override
    public void writeBy(ReportSourceWriter<RiyoshaFutangakuGemmenGaitoshaIchiranReportSource> writer) {

        int index = 0;
        if (target.get世帯員リスト().isEmpty()) {
            IRiyoshaFutangakuGemmenGaitoshaIchiranEditor editor = new RiyoshaFutangakuGemmenGaitoshaIchiranEditorImpl(target,
                    outputOrder, index);
            IRiyoshaFutangakuGemmenGaitoshaIchiranBuilder builder = new RiyoshaFutangakuGemmenGaitoshaIchiranBuilderImpl(editor);
            writer.writeLine(builder);
        } else {
            for (int i = NUM_0; i < target.get世帯員リスト().size(); i += NUM_4) {
                IRiyoshaFutangakuGemmenGaitoshaIchiranEditor editor = new RiyoshaFutangakuGemmenGaitoshaIchiranEditorImpl(target,
                        outputOrder, index);
                IRiyoshaFutangakuGemmenGaitoshaIchiranBuilder builder = new RiyoshaFutangakuGemmenGaitoshaIchiranBuilderImpl(editor);
                writer.writeLine(builder);
                index += NUM_4;
            }
        }
    }
}
