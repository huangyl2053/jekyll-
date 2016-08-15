/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.itizihanteiiftorikomi;

import jp.co.ndensan.reams.db.dbe.business.core.itizi.itizihanteiiftorikomi.ItizihanteiIFtoriKomiBusiness;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumifoutput.IchijiHanteizumIfOutputEucCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.itizihanteiiftorikomi.IchijiHanteiKekkaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchCsvReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBE309002_一次判定IF取込のProcessクラスです。
 *
 * @reamsid_L DBE-1470-022 wanghui
 */
public class ItizihanteiIFtoriKomiProcess extends BatchProcessBase<IchijiHanteizumIfOutputEucCsvEntity> {

    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private ItizihanteiIFtoriKomiBusiness business;
    private RString filePath;
    private RString 込ファイル名;
    private final int 項目数 = 328;
    private static final RString TABLE要介護認定一次判定結果情報 = new RString("IchijiHanteiKekkaJohoTemp");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 調査票概況調査サービスの状況TempTable;

    @Override
    protected void initialize() {
        込ファイル名 = DbBusinessConfig.get(ConfigNameDBE.認定ソフト一次判定用データ取込ファイル名, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
    }

    @Override
    protected void beforeExecute() {
        business = new ItizihanteiIFtoriKomiBusiness();
    }

    @Override
    protected IBatchReader createReader() {
        //TODO csvのパースかありません。
        //RString spoolWorkPath = manager.getEucOutputDirectry();
        filePath = new RString("C:\\Users\\soft863\\wanghui\\").concat(込ファイル名);
        CsvReader csvReader = new CsvReader.InstanceBuilder(filePath, IchijiHanteizumIfOutputEucCsvEntity.class)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS)
                .hasHeader(false).setNewLine(NewLine.CRLF).build();
        return new BatchCsvReader(csvReader);

    }

    @Override
    protected void createWriter() {
        調査票概況調査サービスの状況TempTable = new BatchEntityCreatedTempTableWriter(TABLE要介護認定一次判定結果情報,
                IchijiHanteiKekkaJohoTempTableEntity.class);
    }

    @Override
    protected void process(IchijiHanteizumIfOutputEucCsvEntity entity) {
        IchijiHanteiKekkaJohoTempTableEntity tabEntity = new IchijiHanteiKekkaJohoTempTableEntity();
        CsvListReader read = new CsvListReader.InstanceBuilder(filePath).build();
        if (read.readLine().size() != 項目数) {
            return;
        }
        if (business.連携対象項目一覧判定(entity)) {
            return;
        }
        if (!(new RString("01").equals(business.要介護認定一次判定結果コードの名称(entity.get一次判定結果()))
                || (new RString("12").equals(business.要介護認定一次判定結果コードの名称(entity.get一次判定結果())))
                || (new RString("13").equals(business.要介護認定一次判定結果コードの名称(entity.get一次判定結果())))
                || (new RString("21").equals(business.要介護認定一次判定結果コードの名称(entity.get一次判定結果())))
                || (new RString("22").equals(business.要介護認定一次判定結果コードの名称(entity.get一次判定結果())))
                || (new RString("23").equals(business.要介護認定一次判定結果コードの名称(entity.get一次判定結果())))
                || (new RString("24").equals(business.要介護認定一次判定結果コードの名称(entity.get一次判定結果())))
                || (new RString("25").equals(business.要介護認定一次判定結果コードの名称(entity.get一次判定結果()))))) {
            return;
        }
        RString 結果コード = business.要介護認定一次判定結果コードの名称(entity.get一次判定結果());
        tabEntity = business.set一時テーブル(tabEntity, entity, 結果コード);
        調査票概況調査サービスの状況TempTable.insert(tabEntity);
    }
}
