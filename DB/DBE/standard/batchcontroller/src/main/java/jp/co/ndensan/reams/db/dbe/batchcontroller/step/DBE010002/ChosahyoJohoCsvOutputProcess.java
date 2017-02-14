/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE010002;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.euc.dbe010002.ChosahyoJoho02AEucEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.euc.dbe010002.ChosahyoJoho06AEucEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.euc.dbe010002.ChosahyoJoho09AEucEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.euc.dbe010002.ChosahyoJoho09BEucEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.euc.dbe010002.ChosahyoJoho99AEucEntityEditor;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinseishadataout.ShinseishaDataOutMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinseishadataout.ShinseishaDataOutProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseishadataout.ChosahyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.shinseishadataout.DBE010002_ChosahyoJoho02AEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.shinseishadataout.DBE010002_ChosahyoJoho06AEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.shinseishadataout.DBE010002_ChosahyoJoho09AEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.shinseishadataout.DBE010002_ChosahyoJoho09BEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.shinseishadataout.DBE010002_ChosahyoJoho99AEucEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinseishadataout.IShinseishaDataOutMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
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
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 申請者調査票情報CSV出力プロセスです。
 *
 * @author N3212 竹内 和紀
 */
public class ChosahyoJohoCsvOutputProcess extends BatchProcessBase<ChosahyoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinseishadataout."
            + "IShinseishaDataOutMapper.select調査票情報");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBE010002");
    private static final RString CSV_FILE_NAME_09B = new RString("申請者調査票情報09B.csv");
    private static final RString CSV_FILE_NAME_09A = new RString("申請者調査票情報09A.csv");
    private static final RString CSV_FILE_NAME_06A = new RString("申請者調査票情報06A.csv");
    private static final RString CSV_FILE_NAME_02A = new RString("申請者調査票情報02A.csv");
    private static final RString CSV_FILE_NAME_99A = new RString("申請者調査票情報99A.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");

    @BatchWriter
    private CsvWriter<DBE010002_ChosahyoJoho09BEucEntity> csvWriter_09B;
    @BatchWriter
    private CsvWriter<DBE010002_ChosahyoJoho09AEucEntity> csvWriter_09A;
    @BatchWriter
    private CsvWriter<DBE010002_ChosahyoJoho06AEucEntity> csvWriter_06A;
    @BatchWriter
    private CsvWriter<DBE010002_ChosahyoJoho02AEucEntity> csvWriter_02A;
    @BatchWriter
    private CsvWriter<DBE010002_ChosahyoJoho99AEucEntity> csvWriter_99A;
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
    protected void process(ChosahyoEntity entity) {
        ShinseishaDataOutMybatisParameter parameter = new ShinseishaDataOutMybatisParameter(entity.getShinseishoKanriNo());
        List<DbT5207NinteichosahyoServiceJokyoEntity> サービスの状況List = mapper.select認定調査票サービスの状況(parameter);
        List<DbT5208NinteichosahyoServiceJokyoFlagEntity> サービスの状況フラグList = mapper.select認定調査票サービスの状況フラグ(parameter);
        List<DbT5209NinteichosahyoKinyuItemEntity> 記入項目List = mapper.select認定調査票記入項目(parameter);
        List<DbT5210NinteichosahyoShisetsuRiyoEntity> 施設利用List = mapper.select施設利用(parameter);
        List<DbT5211NinteichosahyoChosaItemEntity> 調査項目List = mapper.select認定調査票調査項目(parameter);
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.asCode().equals(entity.getKoroshoIfShikibetsuCode())) {
            csvWriter_09B.writeLine(ChosahyoJoho09BEucEntityEditor.edit(entity,
                    サービスの状況List, サービスの状況フラグList, 記入項目List, 施設利用List, 調査項目List));
            exist09B = true;
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.asCode().equals(entity.getKoroshoIfShikibetsuCode())) {
            csvWriter_09A.writeLine(ChosahyoJoho09AEucEntityEditor.edit(entity,
                    サービスの状況List, サービスの状況フラグList, 記入項目List, 施設利用List, 調査項目List));
            exist09A = true;
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.asCode().equals(entity.getKoroshoIfShikibetsuCode())) {
            csvWriter_06A.writeLine(ChosahyoJoho06AEucEntityEditor.edit(entity,
                    サービスの状況List, サービスの状況フラグList, 記入項目List, 施設利用List, 調査項目List));
            exist06A = true;
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.asCode().equals(entity.getKoroshoIfShikibetsuCode())) {
            csvWriter_02A.writeLine(ChosahyoJoho02AEucEntityEditor.edit(entity,
                    サービスの状況List, サービスの状況フラグList, 記入項目List, 施設利用List, 調査項目List));
            exist02A = true;
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.asCode().equals(entity.getKoroshoIfShikibetsuCode())) {
            csvWriter_99A.writeLine(ChosahyoJoho99AEucEntityEditor.edit(entity,
                    サービスの状況List, サービスの状況フラグList, 記入項目List, 施設利用List, 調査項目List));
            exist99A = true;
        }
    }

    @Override
    protected void afterExecute() {
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
}
