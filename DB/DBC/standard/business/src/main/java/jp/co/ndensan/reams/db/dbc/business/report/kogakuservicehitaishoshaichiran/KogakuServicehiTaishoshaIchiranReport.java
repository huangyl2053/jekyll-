/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuservicehitaishoshaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuservicehitaishoshaichiran.KogakuServicehiTaishoshaIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuservicehitaishoshaichiran.KogakuServicehiTaishoshaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額介護サービス費対象者一覧表Report
 *
 * @reamsid_L DBC-2010-100 surun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuServicehiTaishoshaIchiranReport extends
        Report<KogakuServicehiTaishoshaIchiranSource> {

    private final KogakuServicehiTaishoshaIchiranEntity 高額介護サービス費対象者一覧表;
    private final YMDHMS システム日時;
    private final Association association;
    private final List<RString> 出力項目リスト;
    private final List<RString> 改頁項目リスト;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param 高額介護サービス費対象者一覧表 KogakuServicehiTaishoshaIchiranEntity
     * @param システム日時 YMDHMS
     * @param association Association
     * @param 出力項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     * @param 連番 int
     */
    public KogakuServicehiTaishoshaIchiranReport(KogakuServicehiTaishoshaIchiranEntity 高額介護サービス費対象者一覧表,
            YMDHMS システム日時,
            Association association,
            List<RString> 出力項目リスト,
            List<RString> 改頁項目リスト,
            int 連番) {
        this.高額介護サービス費対象者一覧表 = 高額介護サービス費対象者一覧表;
        this.システム日時 = システム日時;
        this.association = association;
        this.出力項目リスト = 出力項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
        this.連番 = 連番;
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuServicehiTaishoshaIchiranSource> writer) {
        IKogakuServicehiTaishoshaIchiranEditor editor = new KogakuServicehiTaishoshaIchiranEditor(高額介護サービス費対象者一覧表,
                システム日時, association, 出力項目リスト, 改頁項目リスト, 連番);
        IKogakuServicehiTaishoshaIchiranBuilder builder = new KogakuServicehiTaishoshaIchiranBuilder(editor);
        writer.writeLine(builder);
    }
}
