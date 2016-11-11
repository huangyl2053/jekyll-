/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030020;

import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokunenpoyoshiki1to2.JigyoHokokuNenpoYoshiki1To2Business;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.HyoNo;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2.Yoshiki1To2ComMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokunenpoyoshiki1to2.JigyoHokokuNenpoYoshiki1To2ProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki1to2.KonkyoListCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki1to2.TempIchijiTableEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokunenpoyoshiki1to2.IJigyoHokokuNenpoYoshiki1To2Mapper;
import jp.co.ndensan.reams.db.dbu.service.core.jigyohokokunenpoyoshiki1to2.JigyoHokokuNenpoYoshiki1To2Manager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.ZipUtil;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;

/**
 * ファイルの作成_集計データ登録プロセスクラスです。
 *
 * @reamsid_L DBU-5610-030 chengsanyuan
 */
public class FileSakuseiDataTorokuProcess extends BatchProcessBase<TempIchijiTableEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyojokyohokokushiryonemposakuseiiti."
            + "IJigyoHokokuNenpoYoshiki1To2Mapper.get一時テーブル");
    private JigyoHokokuNenpoYoshiki1To2ProcessParameter processParameter;
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString FILENAME_0101 = new RString("DBU010400.CSV");
    private RString filePath_0101;
    private FileSpoolManager fileManager;
    private IJigyoHokokuNenpoYoshiki1To2Mapper mapper;
    private JigyoHokokuNenpoYoshiki1To2Business business;
    private JigyoHokokuNenpoYoshiki1To2Manager manager;
    @BatchWriter
    private CsvWriter<KonkyoListCsvEntity> 根拠リストCSVWriter;

    @Override
    protected void initialize() {
        business = new JigyoHokokuNenpoYoshiki1To2Business();
        manager = new JigyoHokokuNenpoYoshiki1To2Manager();
        fileManager = processParameter.getManager();
        filePath_0101 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0101);
        根拠リストCSVWriter = new CsvWriter.InstanceBuilder(filePath_0101).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        mapper = getMapper(IJigyoHokokuNenpoYoshiki1To2Mapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(TempIchijiTableEntity entity) {
        根拠リストCSVWriter.writeLine(business.toKonkyoListCsvEntity(entity));
    }

    @Override
    protected void afterExecute() {
        根拠リストCSVWriter.close();
        RString zipFilePath = new RString(Path.combinePath(processParameter.getCsvFilePath(),
                new RString("KonkyoCsv_HokenKyufuKetteJyokyou_Kougaku.zip")).toString());
        ZipUtil.createFromFolder(zipFilePath, processParameter.getCsvFilePath());
        fileManager.spool(zipFilePath);
        mapper.delete事業報告統計データ(Yoshiki1To2ComMybatisParameter.createDelZenkaiSyoriDataParam(
                processParameter.get集計年度(), HyoNo.現物_一般状況.getコード()));
        mapper.delete事業報告統計データ(Yoshiki1To2ComMybatisParameter.createDelZenkaiSyoriDataParam(
                processParameter.get集計年度(), HyoNo.現物_一般状況_旧市町村.getコード()));
        manager.ins事業報告統計データFor市町村コード(processParameter, mapper);
        manager.ins事業報告統計データFor構成市町村コード(processParameter, mapper);
        manager.ins事業報告統計データFor旧市町村コード(processParameter, mapper);
    }

}
