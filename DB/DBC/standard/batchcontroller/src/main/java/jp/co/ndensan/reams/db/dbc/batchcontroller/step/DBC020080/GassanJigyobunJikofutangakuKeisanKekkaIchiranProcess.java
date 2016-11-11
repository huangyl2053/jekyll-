/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.DBC200029GassanKekkaIchiranReportProcessCore;
import jp.co.ndensan.reams.db.dbc.business.core.dbc040010.DBC040010DataUtil;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunjikofutangakukeisankekkaichiran.GassanJigyobunJikofutangakuKeisanKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.DBC040010ProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanjigyobunjikofutangakukeisankekkaichiran.GassanJigyobunJikofutangakuKeisanKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranEntity;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * バッチ設計_DBCMNN1001_事業高額合算・事業分自己負担額計算（括）の一覧表出力のプロセスです。
 *
 * @reamsid_L DBC-4790-030 pengxingyi
 */
public class GassanJigyobunJikofutangakuKeisanKekkaIchiranProcess extends BatchKeyBreakBase<JissekiFutangakuDataTempEntity> {

    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040010."
            + "IKogakuGassanJikofutangakuKeisanMapper.get帳票データ");
    private static final RString KEY_並び順の1件目 = new RString("KEY_並び順の1件目");
    private static final RString KEY_並び順の2件目 = new RString("KEY_並び順の2件目");
    private static final RString KEY_並び順の3件目 = new RString("KEY_並び順の3件目");
    private static final RString KEY_並び順の4件目 = new RString("KEY_並び順の4件目");
    private static final RString KEY_並び順の5件目 = new RString("KEY_並び順の5件目");
    private static final RString KEY_改頁の1件目 = new RString("KEY_改頁の1件目");
    private static final RString KEY_改頁の2件目 = new RString("KEY_改頁の2件目");
    private static final RString KEY_改頁の3件目 = new RString("KEY_改頁の3件目");
    private static final RString KEY_改頁の4件目 = new RString("KEY_改頁の4件目");
    private static final RString KEY_改頁の5件目 = new RString("KEY_改頁の5件目");
    private DBC040010ProcessParameter parameter;
    private Map<RString, RString> 出力順Map;
    private Map<RString, RString> 改頁Map;
    private final ReportId reportId = ReportIdDBC.DBC200203.getReportId();
    private DBC040010DataUtil util;
    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private RDateTime 作成日時;
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
    private DBC200029GassanKekkaIchiranReportProcessCore processCore;
    @BatchWriter
    private BatchReportWriter<GassanJigyobunJikofutangakuKeisanKekkaIchiranSource> batchReportWriter;
    private ReportSourceWriter<GassanJigyobunJikofutangakuKeisanKekkaIchiranSource> reportSourceWriter;

    @Override
    protected void initialize() {
        SubGyomuCode subGyomuCode = SubGyomuCode.DBC介護給付;
        util = new DBC040010DataUtil();
        市町村コード = parameter.get市町村コード();
        市町村名称 = AssociationFinderFactory.createInstance().getAssociation(市町村コード).get市町村名();
        出力順Map = new HashMap<>();
        改頁Map = new HashMap<>();
        Long 帳票出力順ID = parameter.get帳票出力順ID();
        if (帳票出力順ID != null && 帳票出力順ID != 0L) {
            IOutputOrder 出力順情報 = get出力順ID(subGyomuCode, 帳票出力順ID, reportId);
            RString 出力順 = MyBatisOrderByClauseCreator.create(DBC200203GassanJigyobunJikofutangakuKeisanKekkaIchiranOutputOrder.class,
                    出力順情報);
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
            set出力順改頁();
        }
        作成日時 = parameter.get処理日時();
    }

    private void set出力順改頁() {
        出力順Map.put(KEY_並び順の1件目, 出力順1);
        出力順Map.put(KEY_並び順の2件目, 出力順2);
        出力順Map.put(KEY_並び順の3件目, 出力順3);
        出力順Map.put(KEY_並び順の4件目, 出力順4);
        出力順Map.put(KEY_並び順の5件目, 出力順5);
        改頁Map.put(KEY_改頁の1件目, 改頁1);
        改頁Map.put(KEY_改頁の2件目, 改頁2);
        改頁Map.put(KEY_改頁の3件目, 改頁3);
        改頁Map.put(KEY_改頁の4件目, 改頁4);
        改頁Map.put(KEY_改頁の5件目, 改頁5);

    }

    private IOutputOrder get出力順ID(
            SubGyomuCode subGyomuCode,
            Long shutsuryokujunId,
            ReportId reportId) {
        if (shutsuryokujunId != null) {
            IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
            return chohyoShutsuryokujunFinder.get出力順(subGyomuCode,
                    reportId,
                    Long.valueOf(shutsuryokujunId.toString()));
        }
        return null;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, parameter.toDBC040010MyBatisParameter());

    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(reportId.getColumnValue()).addBreak(
                new DBC200203GassanJigyobunJikofutangakuKeisanKekkaIchiranPageBreak(processCore.改頁項())).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void keyBreakProcess(JissekiFutangakuDataTempEntity t) {

    }

    @Override
    protected void usualProcess(JissekiFutangakuDataTempEntity entity) {
        GassanJikofutangakuKeisanKekkaIchiranEntity reportDataEntity = util.toGassanJikofutangakuKeisanKekkaIchiranEntity(entity);
        reportDataEntity.setShichosonCode(entity.getIchiranShichosonCode());
        GassanJigyobunJikofutangakuKeisanKekkaIchiranReport report
                = new GassanJigyobunJikofutangakuKeisanKekkaIchiranReport(reportDataEntity, 出力順Map, 改頁Map, 作成日時,
                        市町村コード.code市町村RString(), 市町村名称);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {

    }

}
