/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD210010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.dbd210010.KyufuSeikentaishoshaCsvOrderKey;
import jp.co.ndensan.reams.db.dbd.business.core.dbd210010.ShiharaiHouhouKanriHitotokiDataManager;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd210010.DBD210010ProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010.KyufuSeikentaishoshaCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010.KyufuSeikentaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 給付制限対象者一覧CSVのprocessクラスです。
 *
 * @reamsid_L DBD-4300-030 liuwei2
 */
public class KyufuSeikentaishoshaCsvProcess extends BatchProcessBase<KyufuSeikentaishoshaEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kyufuseigentaishoichiran"
                    + ".IKyufuSeikentaishoshaMapper.get給付制限対象者一覧CSV情報");

    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString CSV_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId CSV_ENTITY_ID = new EucEntityId(new RString("DBD701010"));
    private static final RString CSVファイル名 = new RString("KyufuSeigenIchiran.csv");
    private RString csvFilePath;
    private FileSpoolManager manager;
    private RString fileName;
    private List<PersonalData> personalDataList;
    private IOutputOrder outputOrder;
    private DBD210010ProcessParameter processParameter;
    private RString orderBy = RString.EMPTY;
    private static final int NUM0 = 0;
    private IShikibetsuTaishoPSMSearchKey searchKey;

    @BatchWriter
    private CsvWriter<KyufuSeikentaishoshaCsvEntity> csvWriter;

    @Override
    protected void initialize() {
        searchKey = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.未定義).build();
        personalDataList = new ArrayList<>();
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (processParameter.get出力順ID() != null) {
            outputOrder = chohyoShutsuryokujunFinder.get出力順(
                    SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200010.getReportId(), processParameter.get出力順ID());
            orderBy = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.create(KyufuSeikentaishoshaCsvOrderKey.class, outputOrder), NUM0);
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toDBD210010CsvMybatisParameter(orderBy, searchKey));
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, CSV_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        csvFilePath = manager.getEucOutputDirectry();
        fileName = Path.combinePath(csvFilePath, CSVファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(fileName)
                .setEncode(Encode.UTF_8withBOM)
                .setDelimiter(CSV_WRITER_DELIMITER)
                .setEnclosure(CSV_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(false)
                .build();
    }

    @Override
    protected void process(KyufuSeikentaishoshaEntity t) {
        ShiharaiHouhouKanriHitotokiDataManager dataManager = new ShiharaiHouhouKanriHitotokiDataManager();
        KyufuSeikentaishoshaCsvEntity csvEntity = dataManager.set給付制限対象者CSV(t);
        csvWriter.writeLine(csvEntity);
        ExpandedInformation expandedInformations
                = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), t.get被保険者番号().getColumnValue());
        PersonalData personalData = PersonalData.of(t.get識別コード(), expandedInformations);
        personalDataList.add(personalData);
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        AccessLogUUID id = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
        manager.spool(csvFilePath, id);
    }

}
