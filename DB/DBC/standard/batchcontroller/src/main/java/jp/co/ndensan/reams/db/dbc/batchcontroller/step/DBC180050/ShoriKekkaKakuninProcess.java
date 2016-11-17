/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050;

import jp.co.ndensan.reams.db.dbc.definition.core.koseitaishokyufujisseki.KoseiTaishoKyufuJisseki_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180050.ShoriKekkaKakuninListProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.ShoriKekkaKakuninCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenjiriyoshafutanwariaihantei.DbWT1801ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(処理結果確認リスト作成)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
public class ShoriKekkaKakuninProcess extends BatchProcessBase<DbWT1801ShoriKekkaKakuninListEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc180050.IKoseiTaishoKyufuJissekiIchiranMapper.get処理結果確認リスト");
    private CsvWriter<ShoriKekkaKakuninCsvEntity> csvWriter;

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC900004"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private RString eucFilePath;
    private FileSpoolManager manager;
    private static final RString CSVファイル名 = new RString("DBC900004_ShoriKekkaKakuninList.csv");
    private static final RString 作成 = new RString("作成");
    private static final RString 処理名 = new RString("負担割合情報作成");
    private static final RString エラー内容_削除 = new RString("負担割合データが削除されています。");
    private static final RString エラー内容_取得 = new RString("負担割合データが取得できませんでした。");
    private ShoriKekkaKakuninListProcessParameter processParameter;
    private boolean 開始flag;

    @Override
    protected void initialize() {
        開始flag = true;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        this.eucFilePath = Path.combinePath(spoolWorkPath, CSVファイル名);
    }

    @Override
    protected void process(DbWT1801ShoriKekkaKakuninListEntity entity) {
        if (開始flag) {
            csvWriter = new CsvWriter.InstanceBuilder(this.eucFilePath).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(true).
                    build();
        }
        csvWriter.writeLine(getCsvEntity(entity));
        開始flag = false;
    }

    @Override
    protected void afterExecute() {
        if (!開始flag) {
            csvWriter.close();
            manager.spool(SubGyomuCode.DBC介護給付, eucFilePath);
        }
    }

    private ShoriKekkaKakuninCsvEntity getCsvEntity(DbWT1801ShoriKekkaKakuninListEntity entity) {
        ShoriKekkaKakuninCsvEntity csvEntity = new ShoriKekkaKakuninCsvEntity();
        if (開始flag) {
            csvEntity.set作成日時(get和暦日時(processParameter.get作成日時()));
        }
        csvEntity.set処理名(処理名);
        csvEntity.set被保険者番号(entity.getHihokenshaNo());
        if (KoseiTaishoKyufuJisseki_ErrorKubun.負担割合_削除.getコード().equals(entity.getErrorKubun())) {
            csvEntity.setエラー内容(エラー内容_削除);
        } else if (KoseiTaishoKyufuJisseki_ErrorKubun.負担割合_取得.getコード().equals(entity.getErrorKubun())) {
            csvEntity.setエラー内容(エラー内容_取得);
        }
        csvEntity.set備考(entity.getBiko());
        return csvEntity;
    }

    private RString get和暦日時(RDateTime 日時) {
        if (null != 日時) {
            RString 和暦日 = 日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 和暦時 = 日時.getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE);
            return 和暦日.concat(和暦時).concat(作成);
        }
        return RString.EMPTY;
    }
}
