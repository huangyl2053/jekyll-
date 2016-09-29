/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE233001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokutaishoshaichiranhyo.NinteiChosaTokusokuTaishoshaIchiranhyoItem;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE233001.ShujiiCsvProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.dbe233001.ShujiiIkenTokusokujoCsvEntity;
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
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 主治医意見書督促対象者一覧表csvの作成クラスです。
 *
 * @reamsid_L DBE-0060-040 zhangzhiming
 */
public class ShujiiIkenTokusokuTaishoshaIchiranhyoCsvProcess extends BatchProcessBase {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.IDbT5301ShujiiIkenshoIraiJohoMapper."
            + "getListForProcess");
    private ShujiiCsvProcessParameter processParameter;
    private static final RString タイトル = new RString("督促状発行対象者一覧");
    private static final RString 市町村コード = new RString("市町村コード");
    private static final RString 市町村名称 = new RString("市町村名称");
    private static final RString 番号 = new RString("No");
    private static final RString 保険者名 = new RString("保険者名");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString 被保険者氏名カナ = new RString("被保険者氏名カナ");
    private static final RString 被保険者氏名 = new RString("被保険者氏名");
    private static final RString 申請日 = new RString("申請日");
    private static final RString 督促状発行日 = new RString("督促状発行日");
    private static final RString 氏名 = new RString("氏名");
    private static final RString 事業者名称 = new RString("事業者名称");
    private static final RString 事業者住所 = new RString("事業者住所");
    private static final RString 事業者電話番号 = new RString("事業者電話番号");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("ShujiiIkenEucCsv"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private RString eucFilePath;
    private FileSpoolManager manager;

    @Override
    protected void initialize() {
    }

    @BatchWriter
    private EucCsvWriter<ShujiiIkenTokusokujoCsvEntity> csvWriter;

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, new RString("ShujiiIkenEucCsv"));
        csvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setDelimiter(EUC_WRITER_DELIMITER).setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8).setNewLine(NewLine.CRLF).hasHeader(false).build();
    }

    @Override
    protected void process(Object list) {
        csvWriter.writeLine(new ShujiiIkenTokusokujoCsvEntity(
                タイトル, null, null, null, null,
                null, null, null, null,
                null, null, null, null));
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(String.format("%02d", datetime.getHour()));
        systemDateTime.append(new RString("時"));
        systemDateTime.append(String.format("%02d", datetime.getMinute()));
        systemDateTime.append(new RString("分"));
        systemDateTime.append(String.format("%02d", datetime.getSecond()));
        systemDateTime.append(new RString("秒"));
        csvWriter.writeLine(new ShujiiIkenTokusokujoCsvEntity(
                systemDateTime.toRString(),
                null, null, null, null,
                null, null, null, null,
                null, null, null, null));
        csvWriter.writeLine(new ShujiiIkenTokusokujoCsvEntity(
                市町村コード, 市町村名称, 番号, 保険者名, 被保険者番号, 被保険者氏名カナ, 被保険者氏名, 申請日, 督促状発行日,
                氏名, 事業者名称, 事業者住所, 事業者電話番号));
        List<NinteiChosaTokusokuTaishoshaIchiranhyoItem> dataList
                = (List<NinteiChosaTokusokuTaishoshaIchiranhyoItem>) processParameter.getShujiiItemList();
        int idenx = 1;
        for (NinteiChosaTokusokuTaishoshaIchiranhyoItem item : dataList) {
            csvWriter.writeLine(createCsvEntity(item, idenx));
            idenx++;
        }
    }

    private ShujiiIkenTokusokujoCsvEntity createCsvEntity(NinteiChosaTokusokuTaishoshaIchiranhyoItem item, int idenx) {
        return new ShujiiIkenTokusokujoCsvEntity(
                item.getCityCode(), item.getCityName(), new RString(String.valueOf(idenx)), item.getListUpper1_1(),
                item.getListLower1_1(), item.getListUpper1_2(),
                item.getListLower1_2(), item.getListShinseiYMD_1().toDateString(),
                item.getListTokusokujoHakkoYMD_1().toDateString(),
                item.getListLower2_1(), item.getListUpper2_1(),
                item.getListUpper2_2(), item.getListLower2_2());
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        manager.spool(eucFilePath);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }
}
