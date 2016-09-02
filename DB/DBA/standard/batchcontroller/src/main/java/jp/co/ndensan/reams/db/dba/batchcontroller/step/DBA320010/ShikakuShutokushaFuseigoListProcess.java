/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA320010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.shikakushutokushafuseigo.ShikakuShutokushaFuseigoListHenSyu;
import jp.co.ndensan.reams.db.dba.business.report.shikakushutokushafuseigoichiranhyo.ShikakushutokushaFuseigoIchiranhyoReport;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.shikakushutokushafuseigo.ShikakuShutokushaFuseigoMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba320010.ShikakuShutokushaFuseigoProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.shikakushutokushafuseigoichiranhyo.ShikakuShutokushaFuseigoEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.shikakushutokushafuseigoichiranhyo.ShikakushutokushaFuseigoIchiranCsvDataEntity;
import jp.co.ndensan.reams.db.dba.entity.report.shikakushutokushafuseigoichiranhyo.ShikakushutokushaFuseigoIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.shikakushutokushafuseigo.IShikakuShutokushaFuseigoListMapper;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 資格取得者不整合リストのバッチ処理クラスです。
 *
 * @reamsid_L DBU-4020-030 lishengli
 */
public class ShikakuShutokushaFuseigoListProcess extends SimpleBatchProcessBase {

    private static final RString すべて対象 = new RString("1");
    private static final RString 資格重複者 = new RString("2");
    private static final RString EUC_ENTITY_ID = new RString("DBA200014");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private ShikakuShutokushaFuseigoProcessParameter processParameter;
    private ShikakuShutokushaFuseigoMybatisParameter mybatisParameter;
    private IShikakuShutokushaFuseigoListMapper mapper;
    private RString eucFilename;
    private FileSpoolManager manager;

    @BatchWriter
    private CsvWriter<ShikakushutokushaFuseigoIchiranCsvDataEntity> csvWriter;
    private BatchReportWriter<ShikakushutokushaFuseigoIchiranhyoReportSource> batchReportWriter;
    private ReportSourceWriter<ShikakushutokushaFuseigoIchiranhyoReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilename = Path.combinePath(manager.getEucOutputDirectry(), new RString("資格取得者不整合一覧表.csv"));
        csvWriter = new CsvWriter.InstanceBuilder(eucFilename)
                .setEncode(Encode.SJIS)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        mybatisParameter = new ShikakuShutokushaFuseigoMybatisParameter(
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        mapper = getMapper(IShikakuShutokushaFuseigoListMapper.class);

    }

    @Override
    protected void process() {
        List<ShikakuShutokushaFuseigoEntity> entityList = new ArrayList<>();
        if (すべて対象.equals(processParameter.getShuturyokuTaishouKubun())) {
            entityList.addAll(mapper.get資格重複者(mybatisParameter));
            entityList.addAll(mapper.get重複者以外(mybatisParameter));
        } else if (資格重複者.equals(processParameter.getShuturyokuTaishouKubun())) {
            entityList.addAll(mapper.get資格重複者(mybatisParameter));
        } else {
            entityList.addAll(mapper.get重複者以外(mybatisParameter));
        }
        ShikakuShutokushaFuseigoListHenSyu henSyu = new ShikakuShutokushaFuseigoListHenSyu();
        int renban = 1;
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBA.DBA200012.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        for (ShikakuShutokushaFuseigoEntity shikakuShutokushaFuseigoEntity : entityList) {
            ShikakushutokushaFuseigoIchiranhyoReport report = new ShikakushutokushaFuseigoIchiranhyoReport(
                    henSyu.get資格取得者不整合リスト帳票用データ(shikakuShutokushaFuseigoEntity));
            report.writeBy(reportSourceWriter);
            csvWriter.writeLine(henSyu.get資格取得者不整合リストCSV用データ(shikakuShutokushaFuseigoEntity, renban));
            renban = renban + 1;
        }
        csvWriter.close();
        manager.spool(eucFilename);
        batchReportWriter.close();
    }
}
