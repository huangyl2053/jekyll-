/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519003;

import jp.co.ndensan.reams.db.dbd.business.core.dbd519003.ShinsaHanteiIraiIchiranhyoCsvProcessCore;
import jp.co.ndensan.reams.db.dbd.business.report.dbd503001.ShinsaHanteiIraiIchiranhyoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5190003.RenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.chohyoshuchiryokuyoshiseijyoho.ChohyoShuchiryokuyoShiseiJyohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd503001.ShinsaHanteiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
    private int 连番;
    private static final int 连番_INITIALIZE = 1;
    private IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey;
    private ShinsaHanteiIraiIchiranhyoCsvProcessCore core;

    @BatchWriter
    private BatchReportWriter<ShinsaHanteiIraiIchiranhyoReportSource> batchReportWriter;
    private ReportSourceWriter<ShinsaHanteiIraiIchiranhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        连番 = 连番_INITIALIZE;
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.未定義);
        shikibetsuTaishoPSMSearchKey = key.build();
        core = new ShinsaHanteiIraiIchiranhyoCsvProcessCore();
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
        entity.set認定申請区分_申請時コード(new Code(String.valueOf(NinteiShinseiKubunShinsei.資格喪失_死亡.コード())));
        ShinsaHanteiIraiIchiranhyoReport report = new ShinsaHanteiIraiIchiranhyoReport(entity);
        report.writeBy(reportSourceWriter);
        连番++;
    }

    @Override
    protected void afterExecute() {
        core.資格喪失帳票出力(batchReportWriter, para);
    }
}
