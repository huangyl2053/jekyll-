/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010050;

import jp.co.ndensan.reams.db.dbu.business.core.ippanshokanketteiym.JigyoHokokuGeppoIppanShokanBusiness;
import jp.co.ndensan.reams.db.dbu.definition.processprm.ippanshokanketteiym.JigyoHokokuGeppoIppanShokanProcessParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippanshokanketteiym.IJigyouHoukokuTokeiEUCEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippanshokanketteiym.JyukyushaJohoKonkyoCSVRelateEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
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
 * 事業報告月報_一般状況のProcessクラスです。
 *
 * @reamsid_L DBU-5550-030 suguangjun
 */
public class JigyoHokokuGeppoIppanShokanDBU011400Process extends BatchProcessBase<JyukyushaJohoKonkyoCSVRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippanshokanketteiym."
            + "IJigyoHokokuGeppoIppanShokanMapper.getJyukyushaJohoKonkyoCSV");
    private JigyoHokokuGeppoIppanShokanProcessParamter processParameter;
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private FileSpoolManager manager;
    private RString eucFilePath;
    private JigyoHokokuGeppoIppanShokanBusiness business;
    @BatchWriter
    private CsvWriter<IJigyouHoukokuTokeiEUCEntity> eucCsvWriter;

    @Override
    protected void initialize() {
        business = new JigyoHokokuGeppoIppanShokanBusiness();
        manager = processParameter.getManager();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toDataMybitisParamter());
    }

    @Override
    protected void createWriter() {
        eucFilePath = Path.combinePath(processParameter.getCsvFilePath(), new RString("DBU011400.csv"));
        eucCsvWriter = BatchWriters.csvWriter(IJigyouHoukokuTokeiEUCEntity.class)
                .filePath(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void process(JyukyushaJohoKonkyoCSVRelateEntity entity) {
        eucCsvWriter.writeLine(business.set統計明細CSVデータ(entity));
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        RString zipFilePath = new RString(Path.combinePath(processParameter.getCsvFilePath(),
                new RString("KonkyoCsv_HokenKyufuKetteJyokyou_Kougaku.zip")).toString());
        ZipUtil.createFromFolder(zipFilePath, processParameter.getCsvFilePath());
        manager.spool(zipFilePath);
    }
}
