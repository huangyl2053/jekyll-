/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140020;

import jp.co.ndensan.reams.db.dbc.business.core.jukyushakyufujissekiichiran.JukyushaKyufujissekiIchiran;
import jp.co.ndensan.reams.db.dbc.business.core.kyufutsuchigenmenhosei.KyufuhiTsuchiGenmenHosei;
import jp.co.ndensan.reams.db.dbc.business.report.jukyushakyufujissekiichiran.JukyushaKyufuJissekiIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakyufujissekiichiran.JukyushaKyufujissekiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekiichiran.JukyushaKyufuJissekiIchiranData;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekiichiran.JukyushaKyufujissekiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhituchigenmenhoseiichiran.KyufuhiTuchiGenmenhoseiIchiranReportSource;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushakyufujissekiichiran.JukyushaKyufuJissekiIchiranReportSource;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 受給者給付実績一覧表 のパラメータ
 *
 * @reamsid_L DBC-3070-030 dangjingjing
 */
public class TyouhyouSakuseiProcess extends BatchProcessBase<JukyushaKyufujissekiIchiranRelateEntity> {

    private static final RString SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekiichiran."
            + "IJukyushaKyufujissekiIchiranMapper.getSelectAll");
    private JukyushaKyufujissekiIchiranProcessParameter processParameter;

    @BatchWriter
    private BatchReportWriter<JukyushaKyufuJissekiIchiranReportSource> batchReportWriter;
    private ReportSourceWriter<JukyushaKyufuJissekiIchiranReportSource> reportSourceWriter;
    private RString 導入団体コード;
    private RString 市町村名;
    private int index_tmp = 0;
    private ShutsuryokujunRelateEntity 出力順entity;

    @Override
    protected void initialize() {
        出力順entity = ReportUtil.get出力順情報(KyufuhiTsuchiGenmenHosei.ShutsuryokujunEnum.class,
                SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC200002.getReportId(),
                processParameter.get出力順ID());
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = 導入団体クラス.getLasdecCode_().value();
        市町村名 = 導入団体クラス.get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_ID, processParameter.toJukyushaKyufujissekiIchiranMybatisParameter(出力順entity.get出力順OrderBy()));
    }

    @Override
    protected void createWriter() {
        if (!出力順entity.getPageBreakKeys().isEmpty()) {
            batchReportWriter = BatchReportFactory.
                    createBatchReportWriter(ReportIdDBC.DBC200002.getReportId().getColumnValue(), SubGyomuCode.DBC介護給付)
                    .addBreak(new BreakerCatalog<KyufuhiTuchiGenmenhoseiIchiranReportSource>().
                            simplePageBreaker(出力順entity.getPageBreakKeys())).create();
        } else {
            batchReportWriter = BatchReportFactory.
                    createBatchReportWriter(ReportIdDBC.DBC200002.getReportId().getColumnValue(), SubGyomuCode.DBC介護給付).create();
        }
        reportSourceWriter = new ReportSourceWriter(batchReportWriter);
    }

    @Override
    protected void process(JukyushaKyufujissekiIchiranRelateEntity entity) {
        index_tmp++;
        get受給者給付実績一覧表の帳票出力(entity);
    }

    @Override
    protected void afterExecute() {
        if (index_tmp == 0) {
            JukyushaKyufuJissekiIchiranData entity = new JukyushaKyufuJissekiIchiranData();
            entity.set被保険者氏名(new RString("該当データ無し"));
            JukyushaKyufuJissekiIchiranReport report = new JukyushaKyufuJissekiIchiranReport(entity);
            report.writeBy(reportSourceWriter);
        }
    }

    private void get受給者給付実績一覧表の帳票出力(JukyushaKyufujissekiIchiranRelateEntity entity) {
        JukyushaKyufujissekiIchiran business = new JukyushaKyufujissekiIchiran();
        JukyushaKyufuJissekiIchiranData reportEntity = business.get受給者給付実績一覧表の帳票情報(entity,
                導入団体コード,
                市町村名,
                出力順entity);
        JukyushaKyufuJissekiIchiranReport report = new JukyushaKyufuJissekiIchiranReport(reportEntity);
        report.writeBy(reportSourceWriter);
    }
}
