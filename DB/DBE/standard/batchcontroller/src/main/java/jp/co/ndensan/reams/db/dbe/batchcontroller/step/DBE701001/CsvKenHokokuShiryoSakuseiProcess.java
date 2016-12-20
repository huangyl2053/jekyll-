package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE701001;

import jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku.CsvKenHokokuShiryoEditor;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.CsvKenHokokuShiryoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.CsvKenHokokuShiryoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.KenHokokuShiryoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.KenHokokuShiryoSakuseiCSVEntity;
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

/**
 * 介護認定審査会判定状況の取得バッチクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class CsvKenHokokuShiryoSakuseiProcess extends BatchProcessBase<CsvKenHokokuShiryoEntity> {

    private static final RString SELECT_HEADER = new RString("jp.co.ndensan.reams.db.dbe.persistence"
            + ".db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper.getCsvKenHokokuShiryoSakusei");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE701001"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 被保険者無い = new RString(0);
    private static final RString 非該当タイトル = new RString("非該当");
    private static final RString 要支援1タイトル = new RString("要支援1");
    private static final RString 要支援2タイトル = new RString("要支援2");
    private static final RString 要介護1タイトル = new RString("要介護1");
    private static final RString 要介護2タイトル = new RString("要介護2");
    private static final RString 要介護3タイトル = new RString("要介護3");
    private static final RString 要介護4タイトル = new RString("要介護4");
    private static final RString 要介護5タイトル = new RString("要介護5");
    private CsvKenHokokuShiryoSakuseiProcessParameter paramter;
    private KenHokokuShiryoEntity 県報告用資料情報;
    private FileSpoolManager manager;
    private RString eucFilename;
    @BatchWriter
    private CsvWriter<KenHokokuShiryoSakuseiCSVEntity> eucCsvWriterKenHokokuShiryo;

    @Override
    protected void initialize() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilename = Path.combinePath(spoolWorkPath, paramter.getShutsuryokuFairu());
        eucCsvWriterKenHokokuShiryo = new CsvWriter.InstanceBuilder(eucFilename).
                setEncode(Encode.UTF_8withBOM)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true).build();
        県報告用資料情報 = new KenHokokuShiryoEntity();
        init県報告用資料情報();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_HEADER, paramter.toCsvKenHokokuShiryoSakuseiMyBatisParameter());
    }

    @Override
    protected void process(CsvKenHokokuShiryoEntity current) {
        new CsvKenHokokuShiryoEditor(current, 県報告用資料情報).set県報告用資料情報();
    }

    @Override
    protected void afterExecute() {
        writer非該当();
        writer要支援1();
        writer要支援2();
        writer要介護1();
        writer要介護2();
        writer要介護3();
        writer要介護4();
        writer要介護5();
        eucCsvWriterKenHokokuShiryo.close();
        manager.spool(eucFilename);
    }

    private void writer非該当() {
        eucCsvWriterKenHokokuShiryo.writeLine(new KenHokokuShiryoSakuseiCSVEntity(
                非該当タイトル,
                県報告用資料情報.get一次非該当_二次非該当(),
                県報告用資料情報.get一次非該当_二次要支援1(),
                県報告用資料情報.get一次非該当_二次要支援2(),
                県報告用資料情報.get一次非該当_二次要介護1(),
                県報告用資料情報.get一次非該当_二次要介護2(),
                県報告用資料情報.get一次非該当_二次要介護3(),
                県報告用資料情報.get一次非該当_二次要介護4(),
                県報告用資料情報.get一次非該当_二次要介護5()));
    }

    private void writer要支援1() {
        eucCsvWriterKenHokokuShiryo.writeLine(new KenHokokuShiryoSakuseiCSVEntity(
                要支援1タイトル,
                県報告用資料情報.get一次要支援1_二次非該当(),
                県報告用資料情報.get一次要支援1_二次要支援1(),
                県報告用資料情報.get一次要支援1_二次要支援2(),
                県報告用資料情報.get一次要支援1_二次要介護1(),
                県報告用資料情報.get一次要支援1_二次要介護2(),
                県報告用資料情報.get一次要支援1_二次要介護3(),
                県報告用資料情報.get一次要支援1_二次要介護4(),
                県報告用資料情報.get一次要支援1_二次要介護5()));
    }

    private void writer要支援2() {
        eucCsvWriterKenHokokuShiryo.writeLine(new KenHokokuShiryoSakuseiCSVEntity(
                要支援2タイトル,
                県報告用資料情報.get一次要支援2_二次非該当(),
                県報告用資料情報.get一次要支援2_二次要支援1(),
                県報告用資料情報.get一次要支援2_二次要支援2(),
                県報告用資料情報.get一次要支援2_二次要介護1(),
                県報告用資料情報.get一次要支援2_二次要介護2(),
                県報告用資料情報.get一次要支援2_二次要介護3(),
                県報告用資料情報.get一次要支援2_二次要介護4(),
                県報告用資料情報.get一次要支援2_二次要介護5()));
    }

    private void writer要介護1() {
        eucCsvWriterKenHokokuShiryo.writeLine(new KenHokokuShiryoSakuseiCSVEntity(
                要介護1タイトル,
                県報告用資料情報.get一次要介護1_二次非該当(),
                県報告用資料情報.get一次要介護1_二次要支援1(),
                県報告用資料情報.get一次要介護1_二次要支援2(),
                県報告用資料情報.get一次要介護1_二次要介護1(),
                県報告用資料情報.get一次要介護1_二次要介護2(),
                県報告用資料情報.get一次要介護1_二次要介護3(),
                県報告用資料情報.get一次要介護1_二次要介護4(),
                県報告用資料情報.get一次要介護1_二次要介護5()));
    }

    private void writer要介護2() {
        eucCsvWriterKenHokokuShiryo.writeLine(new KenHokokuShiryoSakuseiCSVEntity(
                要介護2タイトル,
                県報告用資料情報.get一次要介護2_二次非該当(),
                県報告用資料情報.get一次要介護2_二次要支援1(),
                県報告用資料情報.get一次要介護2_二次要支援2(),
                県報告用資料情報.get一次要介護2_二次要介護1(),
                県報告用資料情報.get一次要介護2_二次要介護2(),
                県報告用資料情報.get一次要介護2_二次要介護3(),
                県報告用資料情報.get一次要介護2_二次要介護4(),
                県報告用資料情報.get一次要介護2_二次要介護5()));
    }

    private void writer要介護3() {
        eucCsvWriterKenHokokuShiryo.writeLine(new KenHokokuShiryoSakuseiCSVEntity(
                要介護3タイトル,
                県報告用資料情報.get一次要介護3_二次非該当(),
                県報告用資料情報.get一次要介護3_二次要支援1(),
                県報告用資料情報.get一次要介護3_二次要支援2(),
                県報告用資料情報.get一次要介護3_二次要介護1(),
                県報告用資料情報.get一次要介護3_二次要介護2(),
                県報告用資料情報.get一次要介護3_二次要介護3(),
                県報告用資料情報.get一次要介護3_二次要介護4(),
                県報告用資料情報.get一次要介護3_二次要介護5()));
    }

    private void writer要介護4() {
        eucCsvWriterKenHokokuShiryo.writeLine(new KenHokokuShiryoSakuseiCSVEntity(
                要介護4タイトル,
                県報告用資料情報.get一次要介護4_二次非該当(),
                県報告用資料情報.get一次要介護4_二次要支援1(),
                県報告用資料情報.get一次要介護4_二次要支援2(),
                県報告用資料情報.get一次要介護4_二次要介護1(),
                県報告用資料情報.get一次要介護4_二次要介護2(),
                県報告用資料情報.get一次要介護4_二次要介護3(),
                県報告用資料情報.get一次要介護4_二次要介護4(),
                県報告用資料情報.get一次要介護4_二次要介護5()));
    }

    private void writer要介護5() {
        eucCsvWriterKenHokokuShiryo.writeLine(new KenHokokuShiryoSakuseiCSVEntity(
                要介護5タイトル,
                県報告用資料情報.get一次要介護5_二次非該当(),
                県報告用資料情報.get一次要介護5_二次要支援1(),
                県報告用資料情報.get一次要介護5_二次要支援2(),
                県報告用資料情報.get一次要介護5_二次要介護1(),
                県報告用資料情報.get一次要介護5_二次要介護2(),
                県報告用資料情報.get一次要介護5_二次要介護3(),
                県報告用資料情報.get一次要介護5_二次要介護4(),
                県報告用資料情報.get一次要介護5_二次要介護5()));
    }

    private void init県報告用資料情報() {
        init一次非該当();
        init一次要支援1();
        init一次要支援2();
        init一次要介護1();
        init一次要介護2();
        init一次要介護3();
        init一次要介護4();
        init一次要介護5();
    }

    private void init一次非該当() {
        県報告用資料情報.set一次非該当_二次非該当(被保険者無い);
        県報告用資料情報.set一次非該当_二次要支援1(被保険者無い);
        県報告用資料情報.set一次非該当_二次要支援2(被保険者無い);
        県報告用資料情報.set一次非該当_二次要介護1(被保険者無い);
        県報告用資料情報.set一次非該当_二次要介護2(被保険者無い);
        県報告用資料情報.set一次非該当_二次要介護3(被保険者無い);
        県報告用資料情報.set一次非該当_二次要介護4(被保険者無い);
        県報告用資料情報.set一次非該当_二次要介護5(被保険者無い);
    }

    private void init一次要支援1() {
        県報告用資料情報.set一次要支援1_二次非該当(被保険者無い);
        県報告用資料情報.set一次要支援1_二次要支援1(被保険者無い);
        県報告用資料情報.set一次要支援1_二次要支援2(被保険者無い);
        県報告用資料情報.set一次要支援1_二次要介護1(被保険者無い);
        県報告用資料情報.set一次要支援1_二次要介護2(被保険者無い);
        県報告用資料情報.set一次要支援1_二次要介護3(被保険者無い);
        県報告用資料情報.set一次要支援1_二次要介護4(被保険者無い);
        県報告用資料情報.set一次要支援1_二次要介護5(被保険者無い);
    }

    private void init一次要支援2() {
        県報告用資料情報.set一次要支援2_二次非該当(被保険者無い);
        県報告用資料情報.set一次要支援2_二次要支援1(被保険者無い);
        県報告用資料情報.set一次要支援2_二次要支援2(被保険者無い);
        県報告用資料情報.set一次要支援2_二次要介護1(被保険者無い);
        県報告用資料情報.set一次要支援2_二次要介護2(被保険者無い);
        県報告用資料情報.set一次要支援2_二次要介護3(被保険者無い);
        県報告用資料情報.set一次要支援2_二次要介護4(被保険者無い);
        県報告用資料情報.set一次要支援2_二次要介護5(被保険者無い);
    }

    private void init一次要介護1() {
        県報告用資料情報.set一次要介護1_二次非該当(被保険者無い);
        県報告用資料情報.set一次要介護1_二次要支援1(被保険者無い);
        県報告用資料情報.set一次要介護1_二次要支援2(被保険者無い);
        県報告用資料情報.set一次要介護1_二次要介護1(被保険者無い);
        県報告用資料情報.set一次要介護1_二次要介護2(被保険者無い);
        県報告用資料情報.set一次要介護1_二次要介護3(被保険者無い);
        県報告用資料情報.set一次要介護1_二次要介護4(被保険者無い);
        県報告用資料情報.set一次要介護1_二次要介護5(被保険者無い);
    }

    private void init一次要介護2() {
        県報告用資料情報.set一次要介護2_二次非該当(被保険者無い);
        県報告用資料情報.set一次要介護2_二次要支援1(被保険者無い);
        県報告用資料情報.set一次要介護2_二次要支援2(被保険者無い);
        県報告用資料情報.set一次要介護2_二次要介護1(被保険者無い);
        県報告用資料情報.set一次要介護2_二次要介護2(被保険者無い);
        県報告用資料情報.set一次要介護2_二次要介護3(被保険者無い);
        県報告用資料情報.set一次要介護2_二次要介護4(被保険者無い);
        県報告用資料情報.set一次要介護2_二次要介護5(被保険者無い);
    }

    private void init一次要介護3() {
        県報告用資料情報.set一次要介護3_二次非該当(被保険者無い);
        県報告用資料情報.set一次要介護3_二次要支援1(被保険者無い);
        県報告用資料情報.set一次要介護3_二次要支援2(被保険者無い);
        県報告用資料情報.set一次要介護3_二次要介護1(被保険者無い);
        県報告用資料情報.set一次要介護3_二次要介護2(被保険者無い);
        県報告用資料情報.set一次要介護3_二次要介護3(被保険者無い);
        県報告用資料情報.set一次要介護3_二次要介護4(被保険者無い);
        県報告用資料情報.set一次要介護3_二次要介護5(被保険者無い);
    }

    private void init一次要介護4() {
        県報告用資料情報.set一次要介護4_二次非該当(被保険者無い);
        県報告用資料情報.set一次要介護4_二次要支援1(被保険者無い);
        県報告用資料情報.set一次要介護4_二次要支援2(被保険者無い);
        県報告用資料情報.set一次要介護4_二次要介護1(被保険者無い);
        県報告用資料情報.set一次要介護4_二次要介護2(被保険者無い);
        県報告用資料情報.set一次要介護4_二次要介護3(被保険者無い);
        県報告用資料情報.set一次要介護4_二次要介護4(被保険者無い);
        県報告用資料情報.set一次要介護4_二次要介護5(被保険者無い);
    }

    private void init一次要介護5() {
        県報告用資料情報.set一次要介護5_二次非該当(被保険者無い);
        県報告用資料情報.set一次要介護5_二次要支援1(被保険者無い);
        県報告用資料情報.set一次要介護5_二次要支援2(被保険者無い);
        県報告用資料情報.set一次要介護5_二次要介護1(被保険者無い);
        県報告用資料情報.set一次要介護5_二次要介護2(被保険者無い);
        県報告用資料情報.set一次要介護5_二次要介護3(被保険者無い);
        県報告用資料情報.set一次要介護5_二次要介護4(被保険者無い);
        県報告用資料情報.set一次要介護5_二次要介護5(被保険者無い);
    }

}
