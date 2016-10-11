/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.dbd519001.PntNinteiShinsaHanteiListManager;
import jp.co.ndensan.reams.db.dbd.business.report.dbd503001.ShinsaHanteiIraiIchiranhyoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519001.PntNinteiShinsaHanteiListProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001.PntNinteiShinsaHanteiListEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd503001.ShinsaHanteiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteishinseiinfoif.IPntNinteiShinsaHanteiListMapper;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定審査判定依頼一覧表発行_process処理クラスです。
 *
 * @reamsid_L DBD-1480-020 liuyl
 */
public class PntNinteiShinsaHanteiListProcess extends BatchProcessBase<PntNinteiShinsaHanteiListEntity> {

    private static final RString 認定申請IF種類 = new RString("【認定申請IF種類】");
    private static final RString 証記載保険者番号 = new RString("【証記載保険者番号】");
    private static final RString 市町村コード = new RString("【市町村コード】");
    private static final RString 被保険者番号 = new RString("【被保険者番号】");
    private static final RString 抽出開始日時 = new RString("【抽出開始日時】");
    private static final RString 抽出終了日時 = new RString("【抽出終了日時】: ");
    private static final RString MYBATIS_MAPPER_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper."
            + "relate.ninteishinseiinfoif.IPntNinteiShinsaHanteiListMapper.select介護認定審査判定データ");
    private PntNinteiShinsaHanteiListProcessParameter parameter;
    @BatchWriter
    private BatchReportWriter<ShinsaHanteiIraiIchiranhyoReportSource> batchReportWriter;
    private ReportSourceWriter<ShinsaHanteiIraiIchiranhyoReportSource> reportSourceWriter;
    private Association 地方公共団体;
    private IPntNinteiShinsaHanteiListMapper mapper;
    private RString 市町村名;
    private int i = 1;

    @Override
    protected void initialize() {
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        mapper = getMapper(IPntNinteiShinsaHanteiListMapper.class);
        List<DbT7051KoseiShichosonMasterEntity> 構成市町村マスタ = mapper.select市町村名(parameter.toMybatisParameter());
        if (!構成市町村マスタ.isEmpty()) {
            市町村名 = 構成市町村マスタ.get(0).getShichosonMeisho();
        } else {
            市町村名 = RString.EMPTY;
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_MAPPER_ID);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBD.DBD503001.getReportId().value(),
                SubGyomuCode.DBD介護受給).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(PntNinteiShinsaHanteiListEntity entity) {
        PntNinteiShinsaHanteiListManager manager = new PntNinteiShinsaHanteiListManager();
        ShinsaHanteiIraiIchiranhyoReport report = new ShinsaHanteiIraiIchiranhyoReport(manager.createEntity(entity, i, 市町村名, parameter));
        report.writeBy(reportSourceWriter);
        i++;
    }

    @Override
    protected void afterExecute() {
        PntNinteiShinsaHanteiListManager manager = new PntNinteiShinsaHanteiListManager();
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.
                createInstance(manager.バッチ出力条件リストの出力(地方公共団体, batchReportWriter, parameter));
        printer.print();

    }
}
