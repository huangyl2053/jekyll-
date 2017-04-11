/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE010002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.euc.dbe010001.KihonJohoEucEntityEditor;
import jp.co.ndensan.reams.db.dbe.definition.core.util.accesslog.ExpandedInformations;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinseishadataout.ShinseishaDataOutMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinseishadataout.ShinseishaDataOutProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseishadataout.KihonJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.shinseishadataout.DBE010001_KihonJohoEucEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinseishadataout.IShinseishaDataOutMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbz.service.core.DbAccessLogger;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
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
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 申請者基本情報CSV出力プロセスです。
 *
 * @author N3212 竹内 和紀
 */
public class KihonJohoCsvOutputProcess extends BatchProcessBase<KihonJohoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinseishadataout."
            + "IShinseishaDataOutMapper.select基本情報");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBE010001");
    private static final RString CSV_FILE_NAME = new RString("申請者基本情報.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 出力条件タイトル_申請書管理番号 = new RString("【申請書管理番号】");
    private static final RString スペース = new RString("　　　　　　　　　");
    private static final Decimal 申請書管理番号の1行表示最大件数 = new Decimal(9);

    @BatchWriter
    private CsvWriter<DBE010001_KihonJohoEucEntity> csvWriter;
    private FileSpoolManager fileSpoolManager;
    private RString filePath;
    private ShinseishaDataOutProcessParameter processParameter;
    private IShinseishaDataOutMapper mapper;
    private List<RString> 申請書管理番号リスト;
    private DbAccessLogger accessLogger;

    @Override
    protected void initialize() {
        fileSpoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        mapper = InstanceProvider.create(MapperProvider.class).create(IShinseishaDataOutMapper.class);
        申請書管理番号リスト = new ArrayList<>();
        accessLogger = new DbAccessLogger();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        filePath = Path.combinePath(fileSpoolManager.getEucOutputDirectry(), CSV_FILE_NAME);
        csvWriter = new CsvWriter.InstanceBuilder(filePath)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void process(KihonJohoEntity entity) {
        ShinseishaDataOutMybatisParameter parameter = new ShinseishaDataOutMybatisParameter(entity.getShinseishoKanriNo());
        List<DbT5304ShujiiIkenshoIkenItemEntity> 意見項目List = mapper.select要介護認定主治医意見書意見項目(parameter);
        csvWriter.writeLine(KihonJohoEucEntityEditor.edit(entity, 意見項目List));
        申請書管理番号リスト.add(entity.getShinseishoKanriNo());
        accessLogger.store(new ShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo()), entity.getHihokenshaNo(),
                ExpandedInformations.fromValue(entity.getShinseishoKanriNo()));
    }

    @Override
    protected void afterExecute() {
        output出力条件表();
        csvWriter.close();
        fileSpoolManager.spool(filePath, accessLogger.flushByEUC(UzUDE0835SpoolOutputType.EucOther));
    }

    private void output出力条件表() {
        List<RString> 出力条件 = new ArrayList();
        if (!processParameter.is検索実行()) {
            申請書管理番号リスト = processParameter.get申請書管理番号リスト();
        }
        if (!申請書管理番号リスト.isEmpty()) {
            RStringBuilder builder = new RStringBuilder();
            builder.append(出力条件タイトル_申請書管理番号);
            builder.append(申請書管理番号リスト.get(0));
            for (int index = 1; index < 申請書管理番号リスト.size(); index++) {
                if (new Decimal(index + 1).remainder(申請書管理番号の1行表示最大件数).equals(Decimal.ZERO)) {
                    builder.append(", ").append(申請書管理番号リスト.get(index)).append(", ");
                    出力条件.add(builder.toRString());
                    builder = new RStringBuilder().append(スペース);
                } else if (new Decimal(index + 1).remainder(申請書管理番号の1行表示最大件数).equals(Decimal.ONE)) {
                    builder.append(申請書管理番号リスト.get(index));
                } else {
                    builder.append(", ").append(申請書管理番号リスト.get(index));
                }
            }
            出力条件.add(builder.toRString());
        }
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        EucFileOutputJokenhyoItem 帳票出力条件
                = new EucFileOutputJokenhyoItem(
                        CSV_FILE_NAME,
                        association.getLasdecCode_().getColumnValue(),
                        association.get市町村名(),
                        new RString(JobContextHolder.getJobId()),
                        new RString("ShinseishaKihonJoho.csv"),
                        EUC_ENTITY_ID.toRString(),
                        new RString(csvWriter.getCount()),
                        出力条件);
        OutputJokenhyoFactory.createInstance(帳票出力条件).print();
    }
}
