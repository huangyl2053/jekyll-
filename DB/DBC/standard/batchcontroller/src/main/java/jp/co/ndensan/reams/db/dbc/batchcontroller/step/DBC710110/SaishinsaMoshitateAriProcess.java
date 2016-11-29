/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710110;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitate.SaishinsaMoshitate;
import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsamoshitate.SaishinsamoshitateProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitate.SaishinsaMoshitateRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.saishinsamoshitate.HanyoListSaishinsaMoshitateAriEUCEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 汎用リスト 再審査申立情報_連番ありのProcessクラスです。
 *
 * @reamsid_L DBC-3106-020 zhengsongling
 */
public class SaishinsaMoshitateAriProcess extends BatchProcessBase<SaishinsaMoshitateRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc."
            + "persistence.db.mapper.relate.saishinsamoshitate.ISaishinsaMoshitateMapper.get再審査申立情報");
    private SaishinsamoshitateProcessParameter processParameter;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC701011");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString FILENAME = new RString("HanyoList_SaishinsaMoshitate.csv");
    private static final RString BATCHCSV = new RString("汎用リスト 再審査申立情報CSV");
    private static final RString 保険者コード_拡張情報 = new RString("0003");
    private static final RString 被保険者番号_拡張情報 = new RString("被保険者番号");
    private int 連番 = 1;
    private ShutsuryokujunRelateEntity 出力順Entity;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private Map<RString, KoseiShichosonMaster> 市町村名MasterMap;
    private Association association;
    private List<PersonalData> personalDataList;
    private boolean flag;
    @BatchWriter
    private CsvWriter<HanyoListSaishinsaMoshitateAriEUCEntity> eucCsvWriter;
    private ChohyoSeigyoKyotsu 帳票制御共通;

    @Override
    protected void initialize() {
        flag = false;
        association = AssociationFinderFactory.createInstance().getAssociation();
        List<KoseiShichosonMaster> 構成市町村マスタ = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
        市町村名MasterMap = new HashMap<>();
        for (KoseiShichosonMaster koseiShichosonMaster : 構成市町村マスタ) {
            市町村名MasterMap.put(koseiShichosonMaster.get市町村コード().value(), koseiShichosonMaster);
        }
        personalDataList = new ArrayList<>();
        出力順Entity = get出力順項目();
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        帳票制御共通 = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701011.getReportId());
    }

    @Override
    protected IBatchReader createReader() {
        boolean has出力順 = false;
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        if (!RString.isNullOrEmpty(出力順Entity.get出力順OrderBy())) {
            has出力順 = true;
        }
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toSaishinsamoshitateMybatisParameter(
                psmShikibetsuTaisho, has出力順, 出力順Entity.get出力順OrderBy()));
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), FILENAME);
        eucCsvWriter = BatchWriters.csvWriter(HanyoListSaishinsaMoshitateAriEUCEntity.class)
                .filePath(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(processParameter.isKomokumeiFuka())
                .build();
    }

    @Override
    protected void process(SaishinsaMoshitateRelateEntity entity) {
        flag = true;
        eucCsvWriter.writeLine(new SaishinsaMoshitate().setRenbanariEUCEntity(entity, 連番++, processParameter, 市町村名MasterMap, 帳票制御共通, association));
        if (!RString.isNullOrEmpty(nullToEmpty(entity.get被保険者番号()))) {
            personalDataList.add(toPersonalData(entity));
        }
    }

    @Override
    protected void afterExecute() {
        if (!flag) {
            eucCsvWriter.writeLine(new SaishinsaMoshitate().setRenbanariEUCEntity());
            eucCsvWriter.close();
            manager.spool(eucFilePath);
        } else {
            AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            eucCsvWriter.close();
            manager.spool(eucFilePath, log);
        }
        outputJokenhyoFactory();
    }

    private ShutsuryokujunRelateEntity get出力順項目() {
        ShutsuryokujunRelateEntity entity = new ShutsuryokujunRelateEntity();
        entity.set出力順OrderBy(RString.EMPTY);
        if (processParameter.getShutsuryokujunId() != null) {
            entity = ReportUtil.get出力順情報(SaishinsaMoshitate.ShutsuryokujunEnum.class,
                    SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC701011.getReportId(),
                    processParameter.getShutsuryokujunId());
        }
        return entity;
    }

    private void outputJokenhyoFactory() {
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                BATCHCSV,
                association.getLasdecCode_().value(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                FILENAME,
                EUC_ENTITY_ID.toRString(),
                get出力件数(new Decimal(eucCsvWriter.getCount())),
                new SaishinsaMoshitate().set出力条件(processParameter));
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private RString get出力件数(Decimal 出力件数) {
        if (!flag) {
            return new RString("0");
        }
        RStringBuilder builder = new RStringBuilder();
        builder.append(DecimalFormatter.toコンマ区切りRString(出力件数, 0));
        return builder.toRString();
    }

    private PersonalData toPersonalData(SaishinsaMoshitateRelateEntity entity) {
        if (RString.isNullOrEmpty(nullToEmpty(entity.get被保険者番号()))) {
            if (entity.getPsmEntity() == null) {
                return PersonalData.of(ShikibetsuCode.EMPTY);
            } else {
                return PersonalData.of(entity.getPsmEntity().getShikibetsuCode());
            }
        } else {
            ExpandedInformation expandedInfo = new ExpandedInformation(new Code(保険者コード_拡張情報), 被保険者番号_拡張情報,
                    nullToEmpty(entity.get被保険者番号()));
            if (entity.getPsmEntity() == null) {
                return PersonalData.of(ShikibetsuCode.EMPTY);
            } else {
                return PersonalData.of(entity.getPsmEntity().getShikibetsuCode(), expandedInfo);
            }
        }
    }

    private RString nullToEmpty(HihokenshaNo obj) {
        if (obj == null || obj.isEmpty()) {
            return RString.EMPTY;
        } else {
            return obj.value();
        }
    }
}
