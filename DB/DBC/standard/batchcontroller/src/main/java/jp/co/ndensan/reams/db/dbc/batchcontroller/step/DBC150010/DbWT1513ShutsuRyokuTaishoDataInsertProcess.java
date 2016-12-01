/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.RiyojokyoTokeihyo_MeisaiGokeiOutKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc150010.RiyojokyoTokeihyoMeisaiListProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1513RiyoJokyoTokeihyoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.riyojokyotokeihyomeisailistsakusei.RiyoJokyoTokeihyoMeisaiListSakuseiService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 出力対象データ作成のプロセスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class DbWT1513ShutsuRyokuTaishoDataInsertProcess extends BatchProcessBase<DbWT1513RiyoJokyoTokeihyoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.select利用状況一覧表出力対象データ");
    private static final RString TRUE = new RString("1");
    private static final RString なし = new RString("なし");
    private static final RString TABLE_利用状況統計表一時 = new RString("DbWT1513RiyoJokyoTokeihyo");
    private static final RString 出力対象 = new RString("【出力対象】:");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 利用状況統計表一時TBL;
    private RiyojokyoTokeihyoMeisaiListProcessParameter parameter;
    RiyoJokyoTokeihyoMeisaiListSakuseiService service;
    private int count = 0;
    private OutputParameter<Integer> outputCount;

    /**
     * データ検索検索件数を返却
     */
    public static final RString PARAMETER_OUT_COUNT;

    static {
        PARAMETER_OUT_COUNT = new RString("outputCount");
    }

    @Override
    protected void initialize() {
        outputCount = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        service = RiyoJokyoTokeihyoMeisaiListSakuseiService.createInstance();
        利用状況統計表一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_利用状況統計表一時,
                DbWT1513RiyoJokyoTokeihyoEntity.class);
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toCreateRiyojokyoMybatisParameter());
    }

    @Override
    protected void process(DbWT1513RiyoJokyoTokeihyoEntity entity) {
        count++;
        entity.setMeisaiOutFlag(TRUE);
        利用状況統計表一時TBL.update(entity);
    }

    @Override
    protected void afterExecute() {
        outputCount.setValue(count);
        if (0 == count) {
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            List<RString> outputJokenhyoList = service.getOutputJokenhyoParam(parameter);
            RStringBuilder builder = new RStringBuilder();
            builder.append(出力対象);
            builder.append(RiyojokyoTokeihyo_MeisaiGokeiOutKubun.toValue(parameter.get明細合計出力区分()).get名称());
            outputJokenhyoList.add(builder.toRString());
            ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                    ReportIdDBC.DBC200004.getReportId().value(),
                    Association.getLasdecCode().value(),
                    association.get市町村名(),
                    new RString(String.valueOf(JobContextHolder.getJobId())),
                    ReportIdDBC.DBC200004.getReportName(),
                    new RString(String.valueOf(0)),
                    なし,
                    RString.EMPTY,
                    outputJokenhyoList);
            OutputJokenhyoFactory.createInstance(item).print();
        }
    }
}
