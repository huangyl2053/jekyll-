/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.dbc020080.DBC020080DataUtil;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.DBC020080ProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
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
public class GassanKekkaIchiranReportProcess extends BatchProcessBase<JissekiFutangakuDataTempEntity> {

    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020080."
            + "IJigyobunKogakuGassanJikofutangakuKeisanMapper.get実績負担額データ");
    private DBC020080ProcessParameter parameter;
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private final ReportId reportId = ReportIdDBC.DBC200029.getReportId();
    private DBC020080DataUtil util;
    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private YMDHMS 作成日時;
    private List<RString> 出力順リスト;
    private List<RString> 改頁リスト;
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
        ReportUtil.get出力順項目(subGyomuCode, 帳票出力順ID, reportId);
        RString 出力順 = MyBatisOrderByClauseCreator.create(
                GassanJikofutangakuKeisanKekkaIchiranProperty.DBC200029_GassanJikofutangakuKeisanKekkaIchiran.class, 出力順情報);
        parameter.set出力順(出力順);
        Map<Integer, ISetSortItem> 出力順項目 = ReportUtil.get出力順項目(subGyomuCode, 帳票出力順ID, reportId);
        Map<Integer, RString> 改頁項目 = ReportUtil.get改頁項目(subGyomuCode, 帳票出力順ID, reportId);
        出力順リスト = util.get出力順リスト(出力順項目);
        改頁リスト = util.get改頁リスト(改頁項目);
        出力順1 = 出力順リスト.get(NUM_0);
        出力順2 = 出力順リスト.get(NUM_1);
        出力順3 = 出力順リスト.get(NUM_2);
        出力順4 = 出力順リスト.get(NUM_3);
        出力順5 = 出力順リスト.get(NUM_4);
        改頁1 = 改頁リスト.get(NUM_0);
        改頁2 = 改頁リスト.get(NUM_1);
        改頁3 = 改頁リスト.get(NUM_2);
        改頁4 = 改頁リスト.get(NUM_3);
        改頁5 = 改頁リスト.get(NUM_4);
        作成日時 = new YMDHMS(parameter.get処理日時());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(reportId.getColumnValue()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }

    @Override
    protected void process(JissekiFutangakuDataTempEntity entity) {
        GassanJikofutangakuKeisanKekkaIchiranEntity reportDataEntity = util.toGassanJikofutangakuKeisanKekkaIchiranEntity(entity);
        report = new GassanJikofutangakuKeisanKekkaIchiranReport(reportDataEntity, 市町村コード, 市町村名称, 作成日時, 出力順1,
                出力順2, 出力順3, 出力順4, 出力順5, 改頁1, 改頁2, 改頁3, 改頁4, 改頁5);
        report.writeBy(reportSourceWriter);
    }
}
