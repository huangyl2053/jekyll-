/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb022002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.definition.processprm.hanyolistshotokujoho.HanyoListShotokuJohoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistshotokujoho.HanyoListShotokuJohoCsvEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistshotokujoho.HanyoListShotokuJohoEntity;
import jp.co.ndensan.reams.db.dbb.service.core.hanyolistshotokujoho.HanyoListShotokuJohoCsvEditor;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * バッチ設計_DBBBT22002_汎用リスト 所得情報Processのクラス
 *
 * @reamsid_L DBB-1901-030 surun
 */
public class HanyoListShotokuJohoProcess extends BatchProcessBase<HanyoListShotokuJohoEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "hanyolistshotokujoho.IHanyoListShotokuJohoMapper.getCSVData");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBB200034"));
    private static final RString CSVNAME = new RString("HanyoList_ShotokuJojo.csv");
    private static final RString 定数_被保険者番号 = new RString("被保険者番号");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString CODE = new RString("0003");
    private HanyoListShotokuJohoCsvEditor csvEditor;
    private HanyoListShotokuJohoProcessParameter processParameter;
    private List<PersonalData> personalDataList;
    private HokenryoDankaiList 保険料段階リスト;
    List<KoseiShichosonMaster> 構成市町村マスタlist;
    private Association 地方公共団体;
    private FileSpoolManager manager;
    private YMDHMS システム日時;
    private RString eucFilePath;
    private Decimal 連番;

    @BatchWriter
    private EucCsvWriter<HanyoListShotokuJohoCsvEntity> eucCsvWriter;

    @Override
    protected void beforeExecute() {
        連番 = Decimal.ONE;
        システム日時 = YMDHMS.now();
        csvEditor = new HanyoListShotokuJohoCsvEditor();
        personalDataList = new ArrayList<>();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        HokenryoDankaiSettings hokenryoDankaiSettings = new HokenryoDankaiSettings();
        保険料段階リスト = hokenryoDankaiSettings.get保険料段階ListIn(processParameter.get賦課年度());
        構成市町村マスタlist = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        builder.setデータ取得区分(DataShutokuKubun.直近レコード);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        processParameter.set宛名検索条件(searchKey);
        return new BatchDbReader(READ_DATA_ID, processParameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, CSVNAME);
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(processParameter.is項目名付加()).build();
    }

    @Override
    protected void process(HanyoListShotokuJohoEntity entity) {
        eucCsvWriter.writeLine(csvEditor.editor(entity, processParameter, 連番, 保険料段階リスト, 構成市町村マスタlist));
        連番 = 連番.add(Decimal.ONE);
        personalDataList.add(toPersonalData(entity));
    }

    private PersonalData toPersonalData(HanyoListShotokuJohoEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE), 定数_被保険者番号,
                entity.getDbv1001被保険者番号().value());
        return PersonalData.of(entity.get宛名Entity().getShikibetsuCode(), expandedInfo);
    }

    @Override
    protected void afterExecute() {
        if ((personalDataList == null || personalDataList.isEmpty()) && processParameter.is項目名付加()) {
            eucCsvWriter.writeLine(new HanyoListShotokuJohoCsvEntity());
        }
        eucCsvWriter.close();
        if (personalDataList == null || personalDataList.isEmpty()) {
            manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
        } else {
            AccessLogUUID accessLog = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
            manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath, accessLog);
        }
    }

}
