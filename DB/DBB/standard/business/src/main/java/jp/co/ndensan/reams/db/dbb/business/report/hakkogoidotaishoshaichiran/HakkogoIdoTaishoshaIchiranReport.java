/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hakkogoidotaishoshaichiran;

import jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha.TsuchiShoHakkoGoIdosha;
import jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha.TsuchiShoHakkogoIdoshaListJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.hakkogoidotaishoshaichiran.HakkogoIdoTaishoshaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 通知書発行後異動把握帳票HakkogoIdoTaishoshaIchiranReport
 *
 * @reamsid_L DBB-0690-030 surun
 */
public class HakkogoIdoTaishoshaIchiranReport extends Report<HakkogoIdoTaishoshaIchiranSource> {

    private final TsuchiShoHakkogoIdoshaListJoho 発行後異動者一覧情報;
    private final Association 導入団体クラス;
    private final YMDHMS 帳票作成日時;

    /**
     * コンストラクタです。
     *
     * @param 発行後異動者一覧情報 TsuchiShoHakkogoIdoshaListJoho
     * @param 導入団体クラス Association
     * @param 帳票作成日時 YMDHMS
     */
    public HakkogoIdoTaishoshaIchiranReport(TsuchiShoHakkogoIdoshaListJoho 発行後異動者一覧情報,
            Association 導入団体クラス, YMDHMS 帳票作成日時) {
        this.発行後異動者一覧情報 = 発行後異動者一覧情報;
        this.導入団体クラス = 導入団体クラス;
        this.帳票作成日時 = 帳票作成日時;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter<HakkogoIdoTaishoshaIchiranSource>
     */
    @Override
    public void writeBy(ReportSourceWriter<HakkogoIdoTaishoshaIchiranSource> writer) {
        if (発行後異動者一覧情報 != null && !発行後異動者一覧情報.get異動者リスト().isEmpty()) {
            for (TsuchiShoHakkoGoIdosha tsuchiShoHakkoGoIdosha : 発行後異動者一覧情報.get異動者リスト()) {
                IHakkogoIdoTaishoshaIchiranEditor headerEditor = new HakkogoIdoTaishoshaIchiranHeaderEditor(発行後異動者一覧情報, 導入団体クラス, 帳票作成日時);
                IHakkogoIdoTaishoshaIchiranEditor bodyEditor = new HakkogoIdoTaishoshaIchiranBodyEditor(tsuchiShoHakkoGoIdosha);
                IHakkogoIdoTaishoshaIchiranBuilder builder = new HakkogoIdoTaishoshaIchiranBuilder(headerEditor, bodyEditor);
                writer.writeLine(builder);
            }
        }
    }

}
