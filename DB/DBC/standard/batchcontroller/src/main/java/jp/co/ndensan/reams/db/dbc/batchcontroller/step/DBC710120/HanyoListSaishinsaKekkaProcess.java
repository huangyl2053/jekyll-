/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710120;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.hanyolistsaishinsakekka.HanyoListSaishinsaKekkaResult;
import jp.co.ndensan.reams.db.dbc.business.core.tankinyushokakudaigaitosha.TankiNyushoKakudaiGaitosha;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistsaishinsakekka.HanyoListSaishinsaKekkaProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistsaishinsakekka.HanyoListSaishinsaKekkaRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsaishinsakekka.IHanyoListSaishinsaKekkaEUCEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 汎用リスト 再審査結果情報のProcessクラスです。
 *
 * @reamsid_L DBC-3105-020 yaodongsheng
 */
public class HanyoListSaishinsaKekkaProcess extends BatchProcessBase<HanyoListSaishinsaKekkaRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "hanyolistsaishinsakekka.IHanyoListSaishinsaKekkaMapper.get再審査結果情報");
    private HanyoListSaishinsaKekkaProcessParameter processParameter;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC701012");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString FILENAME = new RString("HanyoList_SaishinsaKekka.csv");
    private static final RString BATCHCSV = new RString("汎用リスト 再審査結果情報CSV");
    private static final RString ZERO = new RString("0");
    private int 連番 = 1;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private Map<RString, KoseiShichosonMaster> 市町村名MasterMap;
    private Association association;
    private HanyoListSaishinsaKekkaResult business;
    private boolean flag;
    @BatchWriter
    private CsvWriter<IHanyoListSaishinsaKekkaEUCEntity> eucCsvWriter;
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
        business = new HanyoListSaishinsaKekkaResult(processParameter);
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        帳票制御共通 = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701012.getReportId());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, new HanyoListSaishinsaKekkaResult(processParameter).createMybatisParameter(get出力順()));
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), FILENAME);
        eucCsvWriter = BatchWriters.csvWriter(IHanyoListSaishinsaKekkaEUCEntity.class)
                .filePath(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(processParameter.isKomokumeiFuka())
                .build();
    }

    @Override
    protected void process(HanyoListSaishinsaKekkaRelateEntity entity) {
        flag = true;
        if (processParameter.isRenbanFuka()) {
            eucCsvWriter.writeLine(business.setRenbanariEUCEntity(entity, 連番++, 市町村名MasterMap, 帳票制御共通, association));
        } else {
            eucCsvWriter.writeLine(business.setRenbanashiEUCEntity(entity, 市町村名MasterMap, 帳票制御共通, association));
        }

    }

    @Override
    protected void afterExecute() {
        if (!flag) {
            if (processParameter.isRenbanFuka()) {
                eucCsvWriter.writeLine(business.setRenbanariEUCEntity());
            } else {
                eucCsvWriter.writeLine(business.setRenbanashiEUCEntity());
            }
        }
        eucCsvWriter.close();
        if (!flag) {
            manager.spool(eucFilePath);
        } else {
            manager.spool(eucFilePath, business.getアクセスログ());
        }
        outputJokenhyoFactory();
    }

    private RString get出力順() {
        RString 出力順 = RString.EMPTY;
        if (processParameter.getShutsuryokujunId() != null) {
            ShutsuryokujunRelateEntity shutsuryokujunrelateentity = ReportUtil.get出力順情報(TankiNyushoKakudaiGaitosha.ShutsuryokujunEnum.class,
                    SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701012.getReportId(),
                    processParameter.getShutsuryokujunId());
            if (shutsuryokujunrelateentity != null) {
                出力順 = shutsuryokujunrelateentity.get出力順OrderBy();
            }
        }
        return 出力順;
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
                business.set出力条件());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private RString get出力件数(Decimal 出力件数) {
        if (!flag) {
            return ZERO;
        }
        RStringBuilder builder = new RStringBuilder();
        builder.append(DecimalFormatter.toコンマ区切りRString(出力件数, 0));
        return builder.toRString();
    }
}
