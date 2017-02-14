/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE010002;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.euc.dbe010001.KihonJohoEucEntityEditor;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinseishadataout.ShinseishaDataOutMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinseishadataout.ShinseishaDataOutProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseishadataout.KihonJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.shinseishadataout.DBE010001_KihonJohoEucEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinseishadataout.IShinseishaDataOutMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
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

    @BatchWriter
    private CsvWriter<DBE010001_KihonJohoEucEntity> csvWriter;
    private FileSpoolManager fileSpoolManager;
    private RString filePath;
    private ShinseishaDataOutProcessParameter processParameter;
    private IShinseishaDataOutMapper mapper;

    @Override
    protected void initialize() {
        fileSpoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        mapper = InstanceProvider.create(MapperProvider.class).create(IShinseishaDataOutMapper.class);
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
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        fileSpoolManager.spool(filePath);
    }
}
