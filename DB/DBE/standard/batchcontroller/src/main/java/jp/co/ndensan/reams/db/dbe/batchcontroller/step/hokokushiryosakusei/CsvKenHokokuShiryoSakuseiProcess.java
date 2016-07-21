package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hokokushiryosakusei.CsvKenHokokuShiryoSakuseiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.CsvKenHokokuShiryoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.CsvKenHokokuShiryoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.CsvKenHokokuShiryoSakuseiHeaderEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.KenHokokuShiryoSakuseiCSVEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 介護認定審査会判定状況の取得バッチクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class CsvKenHokokuShiryoSakuseiProcess extends BatchProcessBase<CsvKenHokokuShiryoSakuseiHeaderEntity> {

    private static final RString SELECT_HEADER = new RString("jp.co.ndensan.reams.db.dbe.persistence"
            + ".db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper.getCsvKenHokokuShiryoSakuseiHeader");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE701001"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 非該当 = new RString("01");
    private static final RString 要支援1 = new RString("12");
    private static final RString 要支援2 = new RString("13");
    private static final RString 要介護1 = new RString("21");
    private static final RString 要介護2 = new RString("22");
    private static final RString 要介護3 = new RString("23");
    private static final RString 要介護4 = new RString("24");
    private static final RString 要介護5 = new RString("25");
    private static final RString 非該当タイトル = new RString("非該当");
    private static final RString 要支援1タイトル = new RString("要支援1");
    private static final RString 要支援2タイトル = new RString("要支援2");
    private static final RString 要介護1タイトル = new RString("要介護1");
    private static final RString 要介護2タイトル = new RString("要介護2");
    private static final RString 要介護3タイトル = new RString("要介護3");
    private static final RString 要介護4タイトル = new RString("要介護4");
    private static final RString 要介護5タイトル = new RString("要介護5");
    private CsvKenHokokuShiryoSakuseiProcessParameter paramter;
    private IHokokuShiryoSakuSeiMapper mapper;
    private FileSpoolManager manager;
    private RString eucFilename;
    @BatchWriter
    private EucCsvWriter<KenHokokuShiryoSakuseiCSVEntity> eucCsvWriterKenHokokuShiryo;

    @Override
    protected void initialize() {
        mapper = getMapper(IHokokuShiryoSakuSeiMapper.class);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilename = Path.combinePath(spoolWorkPath, paramter.getShutsuryokuFairu());
        eucCsvWriterKenHokokuShiryo = new EucCsvWriter.InstanceBuilder(eucFilename, EUC_ENTITY_ID).
                setEncode(Encode.UTF_8withBOM)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true).build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_HEADER, paramter.toCsvKenHokokuShiryoSakuseiMyBatisParameter());
    }

    @Override
    protected void process(CsvKenHokokuShiryoSakuseiHeaderEntity current) {
        List<CsvKenHokokuShiryoEntity> 県報告用資料 = get県報告用資料情報(current);
        writer非該当(県報告用資料);
        writer要支援1(県報告用資料);
        writer要支援2(県報告用資料);
        writer要介護1(県報告用資料);
        writer要介護2(県報告用資料);
        writer要介護3(県報告用資料);
        writer要介護4(県報告用資料);
        writer要介護5(県報告用資料);
    }

    @Override
    protected void afterExecute() {
        eucCsvWriterKenHokokuShiryo.close();
        manager.spool(eucFilename);
    }

    private List<CsvKenHokokuShiryoEntity> get県報告用資料情報(CsvKenHokokuShiryoSakuseiHeaderEntity current) {
        CsvKenHokokuShiryoSakuseiMyBatisParameter batisParameter = paramter.toCsvKenHokokuShiryoSakuseiMyBatisParameter();
        batisParameter.setGogitaiNo(current.getGogitaiNo());
        batisParameter.setTaishoGeppiFrom(current.getShinsakaiKaisaiYMDMin());
        batisParameter.setTaishoGeppiTo(current.getShinsakaiKaisaiYMDMax());
        batisParameter.setShichosonCode(current.getShichosonCode());
        return mapper.getCsvKenHokokuShiryoSakusei(batisParameter);
    }

    private void writer非該当(List<CsvKenHokokuShiryoEntity> 県報告用資料) {
        eucCsvWriterKenHokokuShiryo.writeLine(new KenHokokuShiryoSakuseiCSVEntity(
                非該当タイトル,
                new RString(get被保険者数(県報告用資料, 非該当, 非該当)),
                new RString(get被保険者数(県報告用資料, 非該当, 要支援1)),
                new RString(get被保険者数(県報告用資料, 非該当, 要支援2)),
                new RString(get被保険者数(県報告用資料, 非該当, 要介護1)),
                new RString(get被保険者数(県報告用資料, 非該当, 要介護2)),
                new RString(get被保険者数(県報告用資料, 非該当, 要介護3)),
                new RString(get被保険者数(県報告用資料, 非該当, 要介護4)),
                new RString(get被保険者数(県報告用資料, 非該当, 要介護5))));
    }

    private void writer要支援1(List<CsvKenHokokuShiryoEntity> 県報告用資料) {
        eucCsvWriterKenHokokuShiryo.writeLine(new KenHokokuShiryoSakuseiCSVEntity(要支援1タイトル,
                new RString(get被保険者数(県報告用資料, 要支援1, 非該当)),
                new RString(get被保険者数(県報告用資料, 要支援1, 要支援1)),
                new RString(get被保険者数(県報告用資料, 要支援1, 要支援2)),
                new RString(get被保険者数(県報告用資料, 要支援1, 要介護1)),
                new RString(get被保険者数(県報告用資料, 要支援1, 要介護2)),
                new RString(get被保険者数(県報告用資料, 要支援1, 要介護3)),
                new RString(get被保険者数(県報告用資料, 要支援1, 要介護4)),
                new RString(get被保険者数(県報告用資料, 要支援1, 要介護5))));
    }

    private void writer要支援2(List<CsvKenHokokuShiryoEntity> 県報告用資料) {
        eucCsvWriterKenHokokuShiryo.writeLine(new KenHokokuShiryoSakuseiCSVEntity(要支援2タイトル,
                new RString(get被保険者数(県報告用資料, 要支援2, 非該当)),
                new RString(get被保険者数(県報告用資料, 要支援2, 要支援1)),
                new RString(get被保険者数(県報告用資料, 要支援2, 要支援2)),
                new RString(get被保険者数(県報告用資料, 要支援2, 要介護1)),
                new RString(get被保険者数(県報告用資料, 要支援2, 要介護2)),
                new RString(get被保険者数(県報告用資料, 要支援2, 要介護3)),
                new RString(get被保険者数(県報告用資料, 要支援2, 要介護4)),
                new RString(get被保険者数(県報告用資料, 要支援2, 要介護5))));
    }

    private void writer要介護1(List<CsvKenHokokuShiryoEntity> 県報告用資料) {
        eucCsvWriterKenHokokuShiryo.writeLine(new KenHokokuShiryoSakuseiCSVEntity(要介護1タイトル,
                new RString(get被保険者数(県報告用資料, 要介護1, 非該当)),
                new RString(get被保険者数(県報告用資料, 要介護1, 要支援1)),
                new RString(get被保険者数(県報告用資料, 要介護1, 要支援2)),
                new RString(get被保険者数(県報告用資料, 要介護1, 要介護1)),
                new RString(get被保険者数(県報告用資料, 要介護1, 要介護2)),
                new RString(get被保険者数(県報告用資料, 要介護1, 要介護3)),
                new RString(get被保険者数(県報告用資料, 要介護1, 要介護4)),
                new RString(get被保険者数(県報告用資料, 要介護1, 要介護5))));
    }

    private void writer要介護2(List<CsvKenHokokuShiryoEntity> 県報告用資料) {
        eucCsvWriterKenHokokuShiryo.writeLine(new KenHokokuShiryoSakuseiCSVEntity(要介護2タイトル,
                new RString(get被保険者数(県報告用資料, 要介護2, 非該当)),
                new RString(get被保険者数(県報告用資料, 要介護2, 要支援1)),
                new RString(get被保険者数(県報告用資料, 要介護2, 要支援2)),
                new RString(get被保険者数(県報告用資料, 要介護2, 要介護1)),
                new RString(get被保険者数(県報告用資料, 要介護2, 要介護2)),
                new RString(get被保険者数(県報告用資料, 要介護2, 要介護3)),
                new RString(get被保険者数(県報告用資料, 要介護2, 要介護4)),
                new RString(get被保険者数(県報告用資料, 要介護2, 要介護5))));
    }

    private void writer要介護3(List<CsvKenHokokuShiryoEntity> 県報告用資料) {
        eucCsvWriterKenHokokuShiryo.writeLine(new KenHokokuShiryoSakuseiCSVEntity(要介護3タイトル,
                new RString(get被保険者数(県報告用資料, 要介護3, 非該当)),
                new RString(get被保険者数(県報告用資料, 要介護3, 要支援1)),
                new RString(get被保険者数(県報告用資料, 要介護3, 要支援2)),
                new RString(get被保険者数(県報告用資料, 要介護3, 要介護1)),
                new RString(get被保険者数(県報告用資料, 要介護3, 要介護2)),
                new RString(get被保険者数(県報告用資料, 要介護3, 要介護3)),
                new RString(get被保険者数(県報告用資料, 要介護3, 要介護4)),
                new RString(get被保険者数(県報告用資料, 要介護3, 要介護5))));
    }

    private void writer要介護4(List<CsvKenHokokuShiryoEntity> 県報告用資料) {
        eucCsvWriterKenHokokuShiryo.writeLine(new KenHokokuShiryoSakuseiCSVEntity(要介護4タイトル,
                new RString(get被保険者数(県報告用資料, 要介護4, 非該当)),
                new RString(get被保険者数(県報告用資料, 要介護4, 要支援1)),
                new RString(get被保険者数(県報告用資料, 要介護4, 要支援2)),
                new RString(get被保険者数(県報告用資料, 要介護4, 要介護1)),
                new RString(get被保険者数(県報告用資料, 要介護4, 要介護2)),
                new RString(get被保険者数(県報告用資料, 要介護4, 要介護3)),
                new RString(get被保険者数(県報告用資料, 要介護4, 要介護4)),
                new RString(get被保険者数(県報告用資料, 要介護4, 要介護5))));
    }

    private void writer要介護5(List<CsvKenHokokuShiryoEntity> 県報告用資料) {
        eucCsvWriterKenHokokuShiryo.writeLine(new KenHokokuShiryoSakuseiCSVEntity(要介護5タイトル,
                new RString(get被保険者数(県報告用資料, 要介護5, 非該当)),
                new RString(get被保険者数(県報告用資料, 要介護5, 要支援1)),
                new RString(get被保険者数(県報告用資料, 要介護5, 要支援2)),
                new RString(get被保険者数(県報告用資料, 要介護5, 要介護1)),
                new RString(get被保険者数(県報告用資料, 要介護5, 要介護2)),
                new RString(get被保険者数(県報告用資料, 要介護5, 要介護3)),
                new RString(get被保険者数(県報告用資料, 要介護5, 要介護4)),
                new RString(get被保険者数(県報告用資料, 要介護5, 要介護5))));
    }

    private int get被保険者数(List<CsvKenHokokuShiryoEntity> 県報告用資料,
            RString 要介護認定結果コード,
            RString 二次判定要介護状態区分コード) {
        for (CsvKenHokokuShiryoEntity sinsakaiHanteiJyokyoEntity : 県報告用資料) {
            if (要介護認定結果コード.equals(sinsakaiHanteiJyokyoEntity.getIchijiHanteiKekkaCode().value())
                    && 二次判定要介護状態区分コード.equals(sinsakaiHanteiJyokyoEntity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
                return sinsakaiHanteiJyokyoEntity.getHihokenshaCount();
            }
        }
        return 0;
    }

}
