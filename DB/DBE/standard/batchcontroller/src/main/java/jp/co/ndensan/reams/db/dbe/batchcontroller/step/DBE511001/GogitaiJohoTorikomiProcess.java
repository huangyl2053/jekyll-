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
    private int sequence;

    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE511001"));

    @BatchWriter
    private BatchEntityCreatedTempTableWriter<TempGogitaiJohoSakusei> gogitaiTempTableWriter;

    @Override
    protected void initialize() {
        sequence = 0;
    }

    @Override
    protected void createWriter() {
        gogitaiTempTableWriter = new BatchEntityCreatedTempTableWriter<>(TempGogitaiJohoSakusei.TABLE_NAME, TempGogitaiJohoSakusei.class);
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
            sequence++;
            gogitaiTempTableWriter.insert(getGogitaiJohoSakusei(entity));
        }
    }

    @Override
    protected void afterExecute() {
        SharedFile.deleteEntry(new SharedFileEntryDescriptor(new FilesystemName(parameter.getSharedFileName()),
                parameter.getSharedFileID()));
    }

    private TempGogitaiJohoSakusei getGogitaiJohoSakusei(GogitaiJohoSakuseiCSVEntity entity) {
        TempGogitaiJohoSakusei temp = new TempGogitaiJohoSakusei();

        temp.setシーケンス番号(sequence);
        temp.set合議体NO(getRString(entity.getGogitaiNo()));
        temp.set合議体名称(getRString(entity.getGogitaiMei()));
        temp.set有効開始日(getRString(entity.getGogitaiYukoKikanKaishiYMD()));
        temp.set有効終了日(getRString(entity.getGogitaiYukoKikanShuryoYMD()));
        temp.set合議体開始予定時刻(getRString(entity.getGogitaiKaishiYoteiTime()));
        temp.set合議体終了予定時刻(getRString(entity.getGogitaiShuryoYoteiTime()));
        temp.set審査会予定定員(getRString(entity.getShinsakaiYoteiTeiin()));
        temp.set審査会自動割当定員(getRString(entity.getShinsakaiJidoWariateTeiin()));
        temp.set審査会委員定員(getRString(entity.getShinsakaiIinTeiin()));
        temp.set開催場所コード(getRString(entity.getShinsakaiKaisaiBashoCode()));
        temp.set精神科医所属(getRString(entity.getGogitaiSeishinkaSonzaiFlag()));
        temp.set合議体ダミーフラグ(getRString(entity.getGogitaiDummyFlag()));
        temp.set審査会委員コード(getRString(entity.getShinsakaiIinCode()));
        temp.set補欠(getRString(entity.getSubstituteFlag()));
        temp.set合議体長区分コード(getRString(entity.getGogitaichoKubunCode()));

        return temp;
    }

    private RString getRString(RString str) {
        return RString.isNullOrEmpty(str) ? RString.EMPTY : str;
    }

}
