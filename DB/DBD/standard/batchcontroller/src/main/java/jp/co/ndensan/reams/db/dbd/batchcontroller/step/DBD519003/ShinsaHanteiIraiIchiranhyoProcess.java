/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd503001.ShinsaHanteiIraiIchiranhyoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5190003.RenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.chohyoshuchiryokuyoshiseijyoho.ChohyoShuchiryokuyoShiseiJyohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd503001.ShinsaHanteiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 資格喪失（死亡）データの帳票Processクラスです。
 *
 * @reamsid_L DBD-2110-010 LDNS shaotw
 */
public class ShinsaHanteiIraiIchiranhyoProcess extends BatchProcessBase<ChohyoShuchiryokuyoShiseiJyohoEntity> {

    private static final RString MYBATIS_SELECT_ID_資格喪失 = new RString("jp.co.ndensan.reams.db.dbd.persistence"
            + ".db.mapper.relate.shikakusoushitsudata.IShikakuSoushitsuDataMapper.getShikakuSoshitsuEntity");
    private RenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter para;
    private static final ReportId REPORT_DBD503001 = ReportIdDBD.DBD503001.getReportId();
    private static final RString 今回開始日時 = new RString("【今回開始日時】");
    private static final RString 今回終了日時 = new RString("【今回終了日時】");
    private int 连番;
    private static final int 连番_INITIALIZE = 1;
    private static final int 先頭9桁 = 9;
    private IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey;

    @BatchWriter
    private BatchReportWriter<ShinsaHanteiIraiIchiranhyoReportSource> batchReportWriter;
    private ReportSourceWriter<ShinsaHanteiIraiIchiranhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        连番 = 连番_INITIALIZE;
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.未定義);
        shikibetsuTaishoPSMSearchKey = key.build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID_資格喪失,
                para.toRenkeiDataShutsuryokuSikakuSakuseiSoshitsuMybatisParameter(shikibetsuTaishoPSMSearchKey));
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(REPORT_DBD503001.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(ChohyoShuchiryokuyoShiseiJyohoEntity entity) {
        entity.setIndex(连番);
        entity.set出力CSV状況申請(RString.EMPTY);
        ShinsaHanteiIraiIchiranhyoReport report = new ShinsaHanteiIraiIchiranhyoReport(entity);
        report.writeBy(reportSourceWriter);
        连番++;
    }

    @Override
    protected void afterExecute() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                REPORT_DBD503001.getColumnValue().substring(0, 先頭9桁),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBD.DBD503001.getReportName(),
                new RString(batchReportWriter.getPageCount()),
                new RString("なし"),
                new RString("なし"),
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        if (para.getKonkaikaishidatetime() != null && para.getKonkaikaishidatetime().getDate().isWareki()) {
            出力条件.add(今回開始日時.concat(para.getKonkaikaishidatetime().getDate().wareki().toDateString()));
        }
        if (para.getKonkaishoridatetime() != null && para.getKonkaishoridatetime().getDate().isWareki()) {
            出力条件.add(今回終了日時.concat(para.getKonkaishoridatetime().getDate().wareki().toDateString()));
        }
        return 出力条件;
    }

}
