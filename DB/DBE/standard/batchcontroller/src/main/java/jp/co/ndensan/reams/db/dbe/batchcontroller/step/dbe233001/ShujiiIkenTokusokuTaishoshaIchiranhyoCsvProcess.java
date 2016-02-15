/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe233001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokutaishoshaichiranhyo.NinteiChosaTokusokuTaishoshaIchiranhyoItem;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe233001.ShujiiCsvProcessParameter;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 主治医意見書督促対象者一覧表csvの作成クラスです。
 */
public class ShujiiIkenTokusokuTaishoshaIchiranhyoCsvProcess extends BatchProcessBase {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.IDbT5301ShujiiIkenshoIraiJohoMapper."
            + "getListForProcess");
    private ShujiiCsvProcessParameter processParameter;
    private static final RString ファイル名 = new RString("主治医意見書督促対象者一覧表.csv");
    private static final RString タイトル = new RString("督促状発行対象者一覧");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("ShujiiIkenEucCsv"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private FileSpoolManager manager;
    private RString eucFilePath;

    @Override
    protected void initialize() {
    }

    @BatchWriter
    private EucCsvWriter<ShujiiIkenTokusokujoCsvEntity> csvWriter;

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Other);
        eucFilePath = Path.combinePath(Path.getTmpDirectoryPath(), ファイル名);
        csvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setEncode(Encode.SJIS)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true).
                build();

        csvWriter.writeLine(new ShujiiIkenTokusokujoCsvEntity(
                タイトル, null, null, null, null,
                null, null, null, null,
                null, null, null));

        csvWriter.writeLine(new ShujiiIkenTokusokujoCsvEntity(
                new RString(RDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString().toString()),
                null, null, null, null,
                null, null, null, null,
                null, null, null));

        List<NinteiChosaTokusokuTaishoshaIchiranhyoItem> dataList
                = (List<NinteiChosaTokusokuTaishoshaIchiranhyoItem>) processParameter.getShujiiItemList();
        for (NinteiChosaTokusokuTaishoshaIchiranhyoItem item : dataList) {
            csvWriter.writeLine(createCsvEntity(item));
        }
        csvWriter.close();
    }

    @Override
    protected void process(Object list) {

    }

    private ShujiiIkenTokusokujoCsvEntity createCsvEntity(NinteiChosaTokusokuTaishoshaIchiranhyoItem item) {
        return new ShujiiIkenTokusokujoCsvEntity(
                item.getCityCode(), item.getCityName(), item.getListUpper1_1(),
                item.getListLower1_1(), item.getListUpper1_2(),
                item.getListLower1_2(), item.getListShinseiYMD_1().toDateString(),
                item.getListTokusokujoHakkoYMD_1().toDateString(),
                item.getListLower2_1(), item.getListUpper2_1(),
                item.getListUpper2_2(), item.getListLower2_2());
    }

    @Override
    protected void afterExecute() {

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }
}
