/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE511001;

import jp.co.ndensan.reams.db.dbe.definition.processprm.gogitaijohosakusei.GogitaiJohoSakuseiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei.GogitaiJohoSakuseiCSVEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei.TempGogitaiJohoSakusei;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchCsvReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 合議体情報を一時テーブルにInsertするプロセスです。
 *
 * @reamsid_L DBE-0090-020 chengsanyuan
 */
public class GogitaiJohoTorikomiProcess extends BatchProcessBase<GogitaiJohoSakuseiCSVEntity> {

    private GogitaiJohoSakuseiProcessParamter parameter;
    private FileSpoolManager manager;

    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE511001"));

    @BatchWriter
    private BatchEntityCreatedTempTableWriter<TempGogitaiJohoSakusei> gogitaiJohoSakuseiTempTableWriter;

    @Override
    protected void initialize() {

    }

    @Override
    protected void createWriter() {
        gogitaiJohoSakuseiTempTableWriter = new BatchEntityCreatedTempTableWriter<>(TempGogitaiJohoSakusei.TABLE_NAME, TempGogitaiJohoSakusei.class);
    }

    @Override
    protected IBatchReader createReader() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        SharedFile.copyToLocal(new ReadOnlySharedFileEntryDescriptor(new FilesystemName(parameter.getSharedFileName()),
                parameter.getSharedFileID()), new FilesystemPath(spoolWorkPath));
        RString filePath = Path.combinePath(spoolWorkPath, parameter.getInputFileName());
        CsvReader csvReader = new CsvReader.InstanceBuilder(filePath, GogitaiJohoSakuseiCSVEntity.class)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS)
                .hasHeader(false).setNewLine(NewLine.CRLF).build();

        return new BatchCsvReader(csvReader);
    }

    @Override
    protected void process(GogitaiJohoSakuseiCSVEntity entity) {
        if (entity != null) {
            gogitaiJohoSakuseiTempTableWriter.insert(getGogitaiJohoSakusei(entity));
        }
    }

    @Override
    protected void afterExecute() {
        SharedFile.deleteEntry(new SharedFileEntryDescriptor(new FilesystemName(parameter.getSharedFileName()),
                parameter.getSharedFileID()));
    }

    private TempGogitaiJohoSakusei getGogitaiJohoSakusei(GogitaiJohoSakuseiCSVEntity entity) {
        TempGogitaiJohoSakusei temp = new TempGogitaiJohoSakusei();

        temp.set合議体NO(getRStrig(entity.getGogitaiNo()));
        temp.set合議体名称(getRStrig(entity.getGogitaiMei()));
        temp.set有効開始日(getRStrig(entity.getGogitaiYukoKikanKaishiYMD()));
        temp.set有効終了日(getRStrig(entity.getGogitaiYukoKikanShuryoYMD()));
        temp.set合議体開始予定時刻(getRStrig(entity.getGogitaiKaishiYoteiTime()));
        temp.set合議体終了予定時刻(getRStrig(entity.getGogitaiShuryoYoteiTime()));
        temp.set審査会予定定員(getRStrig(entity.getShinsakaiYoteiTeiin()));
        temp.set審査会自動割当定員(getRStrig(entity.getShinsakaiJidoWariateTeiin()));
        temp.set審査会委員定員(getRStrig(entity.getShinsakaiIinTeiin()));
        temp.set開催場所コード(getRStrig(entity.getShinsakaiKaisaiBashoCode()));
        temp.set精神科医所属(getRStrig(entity.getGogitaiSeishinkaSonzaiFlag()));
        temp.set合議体ダミーフラグ(getRStrig(entity.getGogitaiDummyFlag()));
        temp.set審査会委員コード(getRStrig(entity.getShinsakaiIinCode()));
        temp.set補欠(getRStrig(entity.getSubstituteFlag()));
        temp.set合議体長区分コード(getRStrig(entity.getGogitaichoKubunCode()));

        return temp;
    }

    private RString getRStrig(RString str) {
        return RString.isNullOrEmpty(str) ? RString.EMPTY : str;
    }

}
