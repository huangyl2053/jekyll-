/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.gogitaijohosakusei;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Hoshu.GogitaichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.gogitaijohosakusei.GogitaiJohoIkkatuSakuseiErrorMessage;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijohosakusei.GogitaiJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.gogitaijohosakusei.GogitaiJohoSakuseiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5591GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5593GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei.GogitaiJohoSakuseiCSVEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gogitaijohosakusei.IGogitaiJohoSakuseiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchCsvReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.workflow.flow.task.TaskCompleteState;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.TaskStateAccessor;

/**
 * 合議体情報一括作成_バッチフ処理クラスです
 */
public class GogitaiJohoIkkatuSakuseiProcess extends BatchProcessBase<GogitaiJohoSakuseiCSVEntity> {

    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final int GOGITAIMEI_LENGTH_200 = 200;
    private static final int TEIIN_LENGTH_4 = 4;
    private static final RString SLASH = new RString("/");
    private static final RString POSITIVE_INTEGERS_REGEX = new RString("^[1-9]\\d*$");
    private static final RString FLAG_TRUE = new RString("true");
    private static final RString FLAG_FALSE = new RString("false");
    private GogitaiJohoSakuseiProcessParamter parameter;
    private RString errorMsg;
    private int errorNo;
    private IGogitaiJohoSakuseiMapper mapper;

    @BatchWriter
    private BatchPermanentTableWriter<DbT5591GogitaiJohoEntity> dbT5591EntityWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5593GogitaiWariateIinJohoEntity> dbT5593EntityWriter;

    @Override
    protected void initialize() {
        errorMsg = RString.EMPTY;
        errorNo = 0;
    }

    @Override
    protected IBatchReader createReader() {
        FileSpoolManager manager = new FileSpoolManager(
                UzUDE0835SpoolOutputType.EucOther, new RString("GogitaiJohoIkkatuSakuseiProcess"), UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();

        SharedFile.copyToLocal(new ReadOnlySharedFileEntryDescriptor(new FilesystemName(parameter.getSharedFileName()),
                parameter.getSharedFileID()), new FilesystemPath(spoolWorkPath));

        RString filePath = Path.combinePath(spoolWorkPath, parameter.getInputFileName());

        // TODO window以下、テスト用
        filePath = filePath.insert(63, "tmp/");

        CsvReader csvReader = new CsvReader.InstanceBuilder(filePath, GogitaiJohoSakuseiCSVEntity.class)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS)
                .hasHeader(false).setNewLine(NewLine.CRLF).build();
        return new BatchCsvReader(csvReader);
    }

    @Override
    protected void createWriter() {
        dbT5591EntityWriter = new BatchPermanentTableWriter(DbT5591GogitaiJohoEntity.class);
        dbT5593EntityWriter = new BatchPermanentTableWriter(DbT5593GogitaiWariateIinJohoEntity.class);
    }

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IGogitaiJohoSakuseiMapper.class);
    }

    @Override
    protected void process(GogitaiJohoSakuseiCSVEntity item) {
        errorMsg = RString.EMPTY;
        errorNo = errorNo + 1;
        this.checkCSVData(item);
        if (errorMsg.isEmpty()) {
            int count = mapper.getGogitaiJohoCount(GogitaiJohoSakuseiParameter.createGogitaiJohoSakuseiParameter(
                    FlexibleDate.MAX,
                    true,
                    Integer.parseInt(item.getGogitaiNo().toString()),
                    FlexibleDate.MAX,
                    RString.EMPTY));
            if (count == 0) {
                dbT5591EntityWriter.insert(item.toDbt5591Entity());
            } else {
                dbT5591EntityWriter.update(item.toDbt5591Entity());
            }
            count = mapper.getGogitaiWariateIinJohoCount(GogitaiJohoSakuseiParameter.createGogitaiJohoSakuseiParameter(
                    FlexibleDate.MAX,
                    true,
                    0,
                    FlexibleDate.MAX,
                    item.getShinsakaiKaisaiBashoCode()));
            if (count == 0) {
                dbT5593EntityWriter.insert(item.toDbt5593Entity());
            } else {
                dbT5593EntityWriter.update(item.toDbt5593Entity());
            }
        }
    }

    @Override
    protected void afterExecute() {
        SharedFile.deleteEntry(new SharedFileEntryDescriptor(new FilesystemName(parameter.getSharedFileName()),
                parameter.getSharedFileID()));
        if (errorMsg.isEmpty()) {
            // TODO QA464 ＤＢコミット、ＤＢロールバック ログファイル
            TaskStateAccessor.setCompleteState(TaskCompleteState.SUCCESS);
        } else {
            TaskStateAccessor.setCompleteState(TaskCompleteState.BUSINESS_ERROR);
        }
    }

    private void checkCSVData(GogitaiJohoSakuseiCSVEntity csvData) {

        RStringBuilder rsb = new RStringBuilder();
        if (csvData.getGogitaiNo().length() != 2) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.合議体Noは２桁.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (!RStringUtil.isAlphabetAndHalfsizeNumberOnly(csvData.getGogitaiNo())) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.合議体Noが半角英数字.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (csvData.getGogitaiMei().isEmpty()) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.合議体名称が空.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (GOGITAIMEI_LENGTH_200 < csvData.getGogitaiMei().length()) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.合議体名称の桁数.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (csvData.getGogitaiYukoKikanKaishiYMD().isEmpty()) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.有効開始日が空.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (csvData.getGogitaiYukoKikanShuryoYMD().isEmpty()) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.有効終了日が空.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (!FlexibleDate.canConvert(csvData.getGogitaiYukoKikanKaishiYMD().replace(SLASH, RString.EMPTY))) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.有効開始日が日付.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (!FlexibleDate.canConvert(csvData.getGogitaiYukoKikanShuryoYMD().replace(SLASH, RString.EMPTY))) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.有効終了日が日付.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (new FlexibleDate(csvData.getGogitaiYukoKikanShuryoYMD().replace(SLASH, RString.EMPTY))
                .isBefore(new FlexibleDate(csvData.getGogitaiYukoKikanKaishiYMD().replace(SLASH, RString.EMPTY)))) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.有効開始日大有効終了日.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (csvData.getGogitaiKaishiYoteiTime().isEmpty()) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.開始予定時刻が空.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (csvData.getGogitaiShuryoYoteiTime().isEmpty()) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.終了予定時刻が空.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (!RTime.canConvert(csvData.getGogitaiKaishiYoteiTime())) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.開始予定時刻が時刻.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (!RTime.canConvert(csvData.getGogitaiShuryoYoteiTime())) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.終了予定時刻が時刻.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (mapper.getKaisaiBashoJohoCount(csvData.getShinsakaiKaisaiBashoCode()) == 0) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.開催場所コードがテーブルに存在.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        rsb.append(checkIntCSVData(csvData));
        rsb.append(checkFlagCSVData(csvData));
        rsb.append(checkGogitaiWariateIinJohoData(csvData));
        errorMsg = rsb.toRString();
    }

    private RStringBuilder checkFlagCSVData(GogitaiJohoSakuseiCSVEntity csvData) {
        RStringBuilder rsb = new RStringBuilder();
        if (csvData.getGogitaiSeishinkaSonzaiFlag().isEmpty()) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.精神科医所属が空.getErrorMSG()));
        }
        if (!(FLAG_TRUE.equals(csvData.getGogitaiSeishinkaSonzaiFlag())
                || FLAG_FALSE.equals(csvData.getGogitaiSeishinkaSonzaiFlag()))) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.精神科医所属が01.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (csvData.getGogitaiDummyFlag().isEmpty()) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.ダミーフラグが空.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (!(FLAG_TRUE.equals(csvData.getGogitaiDummyFlag())
                || FLAG_FALSE.equals(csvData.getGogitaiDummyFlag()))) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.ダミーフラグが01.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }

        return rsb;
    }

    private RStringBuilder checkGogitaiWariateIinJohoData(GogitaiJohoSakuseiCSVEntity csvData) {
        RStringBuilder rsb = new RStringBuilder();
        if (mapper.getShinsakaiIinJohoCount(csvData.getShinsakaiIinCode()) == 0) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.審査会委員コードがテーブルに存在.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (csvData.getGogitaichoKubunCode().isEmpty()) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.合議体長区分コードが空.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (!(GogitaichoKubunCode.通常.getコード().equals(csvData.getGogitaichoKubunCode())
                || GogitaichoKubunCode.副合議体長.getコード().equals(csvData.getGogitaichoKubunCode())
                || GogitaichoKubunCode.合議体長.getコード().equals(csvData.getGogitaichoKubunCode()))) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.合議体長区分コードが012.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (csvData.getSubstituteFlag().isEmpty()) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.補欠が空.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (!(FLAG_TRUE.equals(csvData.getSubstituteFlag())
                || FLAG_FALSE.equals(csvData.getSubstituteFlag()))) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.補欠が01.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        return rsb;
    }

    private RStringBuilder checkIntCSVData(GogitaiJohoSakuseiCSVEntity csvData) {
        RStringBuilder rsb = new RStringBuilder();
        if (csvData.getShinsakaiYoteiTeiin().isEmpty()) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.予定定員が空.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (!RStringUtil.matchesRegex(csvData.getShinsakaiYoteiTeiin(), POSITIVE_INTEGERS_REGEX)) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.予定定員が正整数字.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (TEIIN_LENGTH_4 < csvData.getShinsakaiYoteiTeiin().length()) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.予定定員の桁数大4.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (!RStringUtil.matchesRegex(csvData.getShinsakaiJidoWariateTeiin(), POSITIVE_INTEGERS_REGEX)) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.自動割当定員が正整数字.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (TEIIN_LENGTH_4 < csvData.getShinsakaiJidoWariateTeiin().length()) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.自動割当定員の桁数大4.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (csvData.getShinsakaiIinTeiin().isEmpty()) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.委員定員が空.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (!RStringUtil.matchesRegex(csvData.getShinsakaiIinTeiin(), POSITIVE_INTEGERS_REGEX)) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.委員定員が正整数字.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        if (TEIIN_LENGTH_4 < csvData.getShinsakaiIinTeiin().length()) {
            rsb.append(intToRStr(errorNo).concat(GogitaiJohoIkkatuSakuseiErrorMessage.委員定員の桁数大4.getErrorMSG()));
            rsb.append(NewLine.CRLF);
        }
        return rsb;
    }

    private RString intToRStr(int no) {
        return new RString(String.valueOf(no));
    }

}
