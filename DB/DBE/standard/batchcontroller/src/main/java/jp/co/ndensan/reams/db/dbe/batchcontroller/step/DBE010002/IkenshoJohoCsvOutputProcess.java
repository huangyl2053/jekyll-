/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE010002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.euc.dbe010003.IkenshoJoho02AEucEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.euc.dbe010003.IkenshoJoho06AEucEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.euc.dbe010003.IkenshoJoho09AEucEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.euc.dbe010003.IkenshoJoho09BEucEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.euc.dbe010003.IkenshoJoho99AEucEntityEditor;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinseishadataout.ShinseishaDataOutMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinseishadataout.ShinseishaDataOutProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseishadataout.IkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.shinseishadataout.DBE010003_IkenshoJoho02AEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.shinseishadataout.DBE010003_IkenshoJoho06AEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.shinseishadataout.DBE010003_IkenshoJoho09AEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.shinseishadataout.DBE010003_IkenshoJoho09BEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.shinseishadataout.DBE010003_IkenshoJoho99AEucEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinseishadataout.IShinseishaDataOutMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5303ShujiiIkenshoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
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
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 申請者意見書情報CSV出力プロセスです。
 *
 * @author N3212 竹内 和紀
 */
public class IkenshoJohoCsvOutputProcess extends BatchProcessBase<IkenshoJohoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinseishadataout."
            + "IShinseishaDataOutMapper.select意見書情報");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBE010003");
    private static final RString CSV_FILE_NAME_09B = new RString("申請者意見書情報09B.csv");
    private static final RString CSV_FILE_NAME_09A = new RString("申請者意見書情報09A.csv");
    private static final RString CSV_FILE_NAME_06A = new RString("申請者意見書情報06A.csv");
    private static final RString CSV_FILE_NAME_02A = new RString("申請者意見書情報02A.csv");
    private static final RString CSV_FILE_NAME_99A = new RString("申請者意見書情報99A.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 出力条件タイトル_申請書管理番号 = new RString("【申請書管理番号】");

    @BatchWriter
    private CsvWriter<DBE010003_IkenshoJoho09BEucEntity> csvWriter_09B;
    @BatchWriter
    private CsvWriter<DBE010003_IkenshoJoho09AEucEntity> csvWriter_09A;
    @BatchWriter
    private CsvWriter<DBE010003_IkenshoJoho06AEucEntity> csvWriter_06A;
    @BatchWriter
    private CsvWriter<DBE010003_IkenshoJoho02AEucEntity> csvWriter_02A;
    @BatchWriter
    private CsvWriter<DBE010003_IkenshoJoho99AEucEntity> csvWriter_99A;
    private RString filePath_09B;
    private RString filePath_09A;
    private RString filePath_06A;
    private RString filePath_02A;
    private RString filePath_99A;
    private FileSpoolManager fileSpoolManager;
    private ShinseishaDataOutProcessParameter processParameter;
    private IShinseishaDataOutMapper mapper;
    private boolean exist09B;
    private boolean exist09A;
    private boolean exist06A;
    private boolean exist02A;
    private boolean exist99A;

    @Override
    protected void initialize() {
        fileSpoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        mapper = InstanceProvider.create(MapperProvider.class).create(IShinseishaDataOutMapper.class);
        exist09B = false;
        exist09A = false;
        exist06A = false;
        exist02A = false;
        exist99A = false;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        filePath_09B = Path.combinePath(fileSpoolManager.getEucOutputDirectry(), CSV_FILE_NAME_09B);
        csvWriter_09B = new CsvWriter.InstanceBuilder(filePath_09B).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();

        filePath_09A = Path.combinePath(fileSpoolManager.getEucOutputDirectry(), CSV_FILE_NAME_09A);
        csvWriter_09A = new CsvWriter.InstanceBuilder(filePath_09A).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();

        filePath_06A = Path.combinePath(fileSpoolManager.getEucOutputDirectry(), CSV_FILE_NAME_06A);
        csvWriter_06A = new CsvWriter.InstanceBuilder(filePath_06A).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();

        filePath_02A = Path.combinePath(fileSpoolManager.getEucOutputDirectry(), CSV_FILE_NAME_02A);
        csvWriter_02A = new CsvWriter.InstanceBuilder(filePath_02A).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();

        filePath_99A = Path.combinePath(fileSpoolManager.getEucOutputDirectry(), CSV_FILE_NAME_99A);
        csvWriter_99A = new CsvWriter.InstanceBuilder(filePath_99A).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void process(IkenshoJohoEntity entity) {
        ShinseishaDataOutMybatisParameter parameter = new ShinseishaDataOutMybatisParameter(entity.getShinseishoKanriNo());
        List<DbT5303ShujiiIkenshoKinyuItemEntity> 記入項目List = mapper.select要介護認定主治医意見書記入項目(parameter);
        List<DbT5304ShujiiIkenshoIkenItemEntity> 意見項目List = mapper.select要介護認定主治医意見書意見項目(parameter);
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.asCode().equals(entity.getKoroshoIfShikibetsuCode())) {
            csvWriter_09B.writeLine(IkenshoJoho09BEucEntityEditor.edit(entity, 記入項目List, 意見項目List));
            exist09B = true;
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.asCode().equals(entity.getKoroshoIfShikibetsuCode())) {
            csvWriter_09A.writeLine(IkenshoJoho09AEucEntityEditor.edit(entity, 記入項目List, 意見項目List));
            exist09A = true;
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.asCode().equals(entity.getKoroshoIfShikibetsuCode())) {
            csvWriter_06A.writeLine(IkenshoJoho06AEucEntityEditor.edit(entity, 記入項目List, 意見項目List));
            exist06A = true;
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.asCode().equals(entity.getKoroshoIfShikibetsuCode())) {
            csvWriter_02A.writeLine(IkenshoJoho02AEucEntityEditor.edit(entity, 記入項目List, 意見項目List));
            exist02A = true;
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.asCode().equals(entity.getKoroshoIfShikibetsuCode())) {
            csvWriter_99A.writeLine(IkenshoJoho99AEucEntityEditor.edit(entity, 記入項目List, 意見項目List));
            exist99A = true;
        }
    }

    @Override
    protected void afterExecute() {
        output出力条件表();
        csvWriter_09B.close();
        csvWriter_09A.close();
        csvWriter_06A.close();
        csvWriter_02A.close();
        csvWriter_99A.close();
        if (exist09B) {
            fileSpoolManager.spool(filePath_09B);
        }
        if (exist09A) {
            fileSpoolManager.spool(filePath_09A);
        }
        if (exist06A) {
            fileSpoolManager.spool(filePath_06A);
        }
        if (exist02A) {
            fileSpoolManager.spool(filePath_02A);
        }
        if (exist99A) {
            fileSpoolManager.spool(filePath_99A);
        }
    }

    private void output出力条件表() {
        List<RString> 出力条件 = new ArrayList();
        RStringBuilder builder = new RStringBuilder();
        builder.append(出力条件タイトル_申請書管理番号);
        List<RString> 申請書管理番号リスト = processParameter.get申請書管理番号リスト();
        builder.append(申請書管理番号リスト.get(0));
        for (int index = 1; index < 申請書管理番号リスト.size(); index++) {
            builder.append(", ").append(申請書管理番号リスト.get(index));
        }
        出力条件.add(builder.toRString());
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        EucFileOutputJokenhyoItem 帳票出力条件
                = new EucFileOutputJokenhyoItem(
                        new RString("申請者意見書情報.csv"),
                        association.getLasdecCode_().getColumnValue(),
                        association.get市町村名(),
                        new RString(JobContextHolder.getJobId()),
                        new RString("ShinseishaIkenshoJoho.csv"),
                        EUC_ENTITY_ID.toRString(),
                        new RString(csvWriter_09B.getCount() + csvWriter_09A.getCount()
                                + csvWriter_06A.getCount() + csvWriter_02A.getCount() + csvWriter_99A.getCount()),
                        出力条件);
        OutputJokenhyoFactory.createInstance(帳票出力条件).print();
    }
}
