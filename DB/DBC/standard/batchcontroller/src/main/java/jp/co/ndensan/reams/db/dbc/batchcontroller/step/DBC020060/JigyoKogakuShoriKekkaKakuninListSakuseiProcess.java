/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020060;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakuserviceshikyukettei.KogakuServicehiShikyuKetteiTsuchisho_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.DbWT0203ShoriKekkaKakuninListTempEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 高額総合事業サービス費支給（不支給）決定通知書作成の処理結果リスト作成する。
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
public class JigyoKogakuShoriKekkaKakuninListSakuseiProcess extends BatchProcessBase<DbWT0203ShoriKekkaKakuninListTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakusogojigyoservice.IKogakuJigyoServicehiShikyuKetteiTsuchishoMapper.select処理結果リスト一時TBL");
    private static final RString 出力ファイル名 = new RString("DBC900004_ShoriKekkaKakuninList.csv");
    private static final RString MSG_高額サービス費支給決定通知書_エラー区分 = new RString("高額サービス費支給決定通知書_エラー区分");
    private static final RString HEADER_作成日時 = new RString("作成日時");
    private static final RString HEADER_処理名 = new RString("処理名");
    private static final RString HEADER_証記載保険者番号 = new RString("証記載保険者番号");
    private static final RString HEADER_被保険者番号 = new RString("被保険者番号");
    private static final RString HEADER_被保険者氏名 = new RString("被保険者氏名");
    private static final RString HEADER_サービス提供年月 = new RString("サービス提供年月");
    private static final RString HEADER_履歴番号 = new RString("履歴番号");
    private static final RString HEADER_エラー内容 = new RString("エラー内容");
    private static final RString HEADER_備考 = new RString("備考");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC900004"));
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString SAKUSEI = new RString("作成");
    private int number;
    private List<RString> headerList;
    private RString csvFilePath;
    private FileSpoolManager manager;
    private CsvListWriter csvListWriter;

    @Override
    protected void initialize() {
        number = 0;
        headerList = new ArrayList<>();
        headerList.add(HEADER_作成日時);
        headerList.add(HEADER_処理名);
        headerList.add(HEADER_証記載保険者番号);
        headerList.add(HEADER_被保険者番号);
        headerList.add(HEADER_被保険者氏名);
        headerList.add(HEADER_サービス提供年月);
        headerList.add(HEADER_履歴番号);
        headerList.add(HEADER_エラー内容);
        headerList.add(HEADER_備考);

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void process(DbWT0203ShoriKekkaKakuninListTempEntity entity) {
        if (null == csvListWriter) {
            manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                    EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
            RString spoolWorkPath = manager.getEucOutputDirectry();
            csvFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
            csvListWriter = new CsvListWriter.InstanceBuilder(csvFilePath)
                    .setDelimiter(コンマ)
                    .setEnclosure(ダブル引用符)
                    .setEncode(Encode.UTF_8withBOM)
                    .hasHeader(true)
                    .setHeader(headerList)
                    .setNewLine(NewLine.CRLF)
                    .build();
        }
        List<RString> csvList = getCsvList(entity);
        csvListWriter.writeLine(csvList);
    }

    @Override
    protected void afterExecute() {
        if (null != csvListWriter) {
            csvListWriter.close();
            manager.spool(csvFilePath);
        }
    }

    private List<RString> getCsvList(DbWT0203ShoriKekkaKakuninListTempEntity entity) {
        List<RString> list = new ArrayList<>();
        if (number == 0) {
            RDateTime 作成日時 = RDateTime.now();
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            list.add(作成日.concat(RString.HALF_SPACE).concat(作成時).concat(RString.HALF_SPACE).concat(SAKUSEI));
            number++;
        } else {
            list.add(RString.EMPTY);
        }
        try {
            KogakuServicehiShikyuKetteiTsuchisho_ErrorKubun.toValue(entity.getErrorKubun());
            list.add(KogakuServicehiShikyuKetteiTsuchisho_ErrorKubun.get処理名(entity.getErrorKubun()));
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JigyoKogakuShoriKekkaKakuninListSakuseiProcess.class.getName()).log(Level.SEVERE, null, ex);
            throw new BatchInterruptedException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(
                    MSG_高額サービス費支給決定通知書_エラー区分.toString()).toString());
        }
        list.add(getColumnValue(entity.getShoKisaiHokenshaNo()));
        list.add(getColumnValue(entity.getHihokenshaNo()));
        list.add(entity.getHihokenshaShimei());
        list.add(entity.getKey1());
        list.add(entity.getKey2());
        list.add(KogakuServicehiShikyuKetteiTsuchisho_ErrorKubun.getエラーメッセージ(entity.getErrorKubun()));
        list.add(entity.getBiko());
        return list;
    }

    private RString getColumnValue(IDbColumnMappable column) {
        if (null == column) {
            return RString.EMPTY;
        }
        return column.getColumnValue();
    }

}
