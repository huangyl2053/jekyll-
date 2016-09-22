/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180070;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidata.KenkouKaruteRenkeiDATEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidatakoiki.KenkoKaruteRenkeiKoikiTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidatakoiki.KenkouKaruteRenkeiDataKoikiEditEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidatakoiki.KenkouKaruteRenkeiDataKoikiHenkanErrorCsvEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.io.fld.FldWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 健康かるて連携データ作成（広域用）のバッチクラスです。
 *
 * @reamsid_L DBC-5020-011 wangxiaodong
 */
public class KenkouKaruteRenkeiDataKoikiProcess extends BatchKeyBreakBase<KenkoKaruteRenkeiKoikiTempTableEntity> {

    private static final RString SELECT_GENSHICHOSONJOHO = new RString("jp.co.ndensan.reams.db.dbc."
            + "persistence.db.mapper.relate.kenkoukaruterenkeidatakoiki.IKenkouKaruteRenkeiDataKoikiMapper.getKenkouKaruteRenkeiDataKoiki");
    private static final RString DAT_拡張子 = new RString(".DAT");
    private static final RString DAT_NAME = new RString("HCSETF8_");
    private static final RString CSV_NAME = new RString("KoikiShikibetsuHenkanError.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString DAT_WRITER_DELIMITER = new RString("-");
    private RString filePath;
    private boolean isNotFirst;
    private List<RString> 作成されたファイル;

    @BatchWriter
    private CsvWriter<KenkouKaruteRenkeiDataKoikiHenkanErrorCsvEntity> csvWriter;
    private FldWriter<KenkouKaruteRenkeiDATEntity> fldWriter;

    @Override
    protected void initialize() {
        isNotFirst = true;
        filePath = Path.getTmpDirectoryPath();
        作成されたファイル = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_GENSHICHOSONJOHO);
    }

    @Override
    protected void createWriter() {
        csvWriter = new CsvWriter.InstanceBuilder(CSV_NAME).
                setEncode(Encode.UTF_8withBOM)
                .canAppend(true)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(false).build();
    }

    @Override
    protected void keyBreakProcess(KenkoKaruteRenkeiKoikiTempTableEntity entity) {
        if (hasBreak(getBefore(), entity)) {
            fldWriter.close();
            fldWriter = new FldWriter.InstanceBuilder(Path.combinePath(filePath, DAT_NAME.concat(entity.getShichosonCode().concat(DAT_拡張子))))
                    .setEncodeUtf8(true)
                    .setDelimiter(DAT_WRITER_DELIMITER)
                    .setNewLine(NewLine.CRLF).build();
            作成されたファイル.add(DAT_NAME.concat(entity.getShichosonCode().concat(DAT_拡張子)));
        }
    }

    @Override
    protected void usualProcess(KenkoKaruteRenkeiKoikiTempTableEntity entity) {
        if (isNotFirst) {
            fldWriter = new FldWriter.InstanceBuilder(Path.combinePath(filePath, DAT_NAME.concat(entity.getShichosonCode().concat(DAT_拡張子))))
                    .setEncodeUtf8(true)
                    .setDelimiter(DAT_WRITER_DELIMITER)
                    .setNewLine(NewLine.CRLF).build();
            作成されたファイル.add(DAT_NAME.concat(entity.getShichosonCode().concat(DAT_拡張子)));
        }
        isNotFirst = false;
        if (has識別コード変換エラー(entity)) {
            KenkouKaruteRenkeiDataKoikiHenkanErrorCsvEntity csvEntity = new KenkouKaruteRenkeiDataKoikiHenkanErrorCsvEntity();
            csvEntity.set被保険者番号(entity.getHihokenshaNo());
            csvEntity.set異動日(getValue(entity.getIdoYMD()));
            csvEntity.set市町村コード(entity.getShichosonCode());
            csvEntity.set識別コード(entity.getShikibetsuCode());
            csvEntity.set資格取得年月日(getValue(entity.getShikakuShutokuYMD()));
            csvEntity.set資格喪失年月日(getValue(entity.getShikakuSoshitsuYMD()));
            csvEntity.set業務コード(entity.getGyomuCode());
            csvEntity.set住民種別コード(entity.getJuminShubetsuCode());
            csvEntity.set住民状態コード(entity.getJuminJotaiCode());
            csvEntity.set名称(entity.getMeisho());
            csvEntity.setカナ名称(entity.getKanaMeisho());
            csvEntity.set生年月日(getValue(entity.getSeinengappiYMD()));
            csvEntity.set性別(entity.getSeibetsuCode());
            csvEntity.set履歴番号(entity.getRirekiNo());
            csvEntity.set認定年月日(getValue(entity.getNinteiYMD()));
            csvEntity.set喪失年月日(getValue(entity.getSoshitsuYMD()));
            csvEntity.set認定有効期間開始年月日(getValue(entity.getNinteiYukoKikanKaishiYMD()));
            csvEntity.set認定有効期間終了年月日(getValue(entity.getNinteiYukoKikanShuryoYMD()));
            csvEntity.setエラーメッセージ(new RString("該当市町村の識別コード未登録"));
            csvWriter.writeLine(csvEntity);
        } else {
            fldWriter.writeLine(new KenkouKaruteRenkeiDataKoikiEditEntity(entity).getWriteLine内容());
        }
        AccessLogger.log(AccessLogType.照会, toPersonalData(entity.getShikibetsuCode(), entity.getHihokenshaNo()));
    }

    @Override
    protected void afterExecute() {
        for (RString 作成されたファイルNAME : 作成されたファイル) {
            FilesystemName ファイル名称 = new FilesystemName(作成されたファイルNAME);
            SharedFileDescriptor sfd = new ReadOnlySharedFileDescriptor(ファイル名称);
            SharedFile.defineSharedFile(sfd);
            SharedFile.copyToSharedFile(new FilesystemPath(filePath), ファイル名称);
        }
    }

    private boolean hasBreak(KenkoKaruteRenkeiKoikiTempTableEntity before, KenkoKaruteRenkeiKoikiTempTableEntity entity) {
        return !before.getShichosonCode().equals(entity.getShichosonCode());
    }

    private boolean has識別コード変換エラー(KenkoKaruteRenkeiKoikiTempTableEntity entity) {
        // TODO#100470 「介護広域連合」が管理する「識別コード」」の意味はあまりわかりません
        // 回答：現時点でも共通メソッドは決定しておりません。申し訳ありませんがToDoとして実装しておいてください。
        return RString.isNullOrEmpty(entity.getShichosonCode());
    }

    private RString getValue(FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        return new RString(年月日.toString());
    }

    private PersonalData toPersonalData(RString 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号);
        return PersonalData.of(new ShikibetsuCode(識別コード), expandedInfo);
    }
}
