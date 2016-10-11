/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC010020.KogakuServicehiJuryoininKeiyakuShoninKakuninshoPageBreak;
import jp.co.ndensan.reams.db.dbc.business.core.dbc020080.DBC020080DataUtil;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.DBC020080ProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * バッチ設計_DBCMN62006_自己負担額計算（一括）の一覧表出力のプロセスです。
 *
 * @reamsid_L DBC-2060-030 liuyang
 */
public class DBC200029GassanKekkaIchiranReportProcess extends BatchKeyBreakBase<JissekiFutangakuDataTempEntity> {

    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020080."
            + "IJigyobunKogakuGassanJikofutangakuKeisanMapper.get帳票データ");
    private DBC020080ProcessParameter parameter;
    private final ReportId reportId = ReportIdDBC.DBC200029.getReportId();
    private DBC020080DataUtil util;
    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private YMDHMS 作成日時;
    private RString 出力順1;
    private RString 出力順2;
    private RString 出力順3;
    private RString 出力順4;
    private RString 出力順5;
    private RString 改頁1;
    private RString 改頁2;
    private RString 改頁3;
    private RString 改頁4;
    private RString 改頁5;
    private GassanJikofutangakuKeisanKekkaIchiranReport report;
    private DBC200029GassanKekkaIchiranReportProcessCore processCore;
    @BatchWriter
    private BatchReportWriter<GassanJikofutangakuKeisanKekkaIchiranSource> batchReportWriter;
    private ReportSourceWriter<GassanJikofutangakuKeisanKekkaIchiranSource> reportSourceWriter;

    @Override
    protected void initialize() {
        SubGyomuCode subGyomuCode = SubGyomuCode.DBC介護給付;
        util = new DBC020080DataUtil();
        市町村コード = parameter.get市町村コード();
        市町村名称 = AssociationFinderFactory.createInstance().getAssociation(市町村コード).get市町村名();
        Long 帳票出力順ID = parameter.get帳票出力順ID();
        IOutputOrder 出力順情報 = ReportUtil.get出力順ID(subGyomuCode, 帳票出力順ID, reportId);
        RString 出力順 = MyBatisOrderByClauseCreator.create(DBC200029GassanKekkaIchiranOutputOrder.class, 出力順情報);
        parameter.set出力順(出力順);
        processCore = new DBC200029GassanKekkaIchiranReportProcessCore(出力順情報);
        出力順1 = processCore.get出力順1();
        出力順2 = processCore.get出力順2();
        出力順3 = processCore.get出力順3();
        出力順4 = processCore.get出力順4();
        出力順5 = processCore.get出力順5();
        改頁1 = processCore.get改頁1();
        改頁2 = processCore.get改頁2();
        改頁3 = processCore.get改頁3();
        改頁4 = processCore.get改頁4();
        改頁5 = processCore.get改頁5();
        作成日時 = new YMDHMS(parameter.get処理日時());
    }

    @Override
    protected void createWriter() {
        if (!processCore.is改頁()) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(reportId.getColumnValue()).create();
        } else {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(reportId.getColumnValue()).addBreak(
                    new KogakuServicehiJuryoininKeiyakuShoninKakuninshoPageBreak(processCore.改頁項())).create();
        }
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, parameter.toDBC020080MyBatisParameter());
    }

    @Override
    protected void usualProcess(JissekiFutangakuDataTempEntity entity) {
        GassanJikofutangakuKeisanKekkaIchiranEntity reportDataEntity = util.toGassanJikofutangakuKeisanKekkaIchiranEntity(entity);
        report = new GassanJikofutangakuKeisanKekkaIchiranReport(reportDataEntity, 市町村コード, 市町村名称, 作成日時, 出力順1,
                出力順2, 出力順3, 出力順4, 出力順5, 改頁1, 改頁2, 改頁3, 改頁4, 改頁5);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void keyBreakProcess(JissekiFutangakuDataTempEntity t) {
    }

    @Override
    protected void afterExecute() {
        batchReportWriter.close();
    }
}
