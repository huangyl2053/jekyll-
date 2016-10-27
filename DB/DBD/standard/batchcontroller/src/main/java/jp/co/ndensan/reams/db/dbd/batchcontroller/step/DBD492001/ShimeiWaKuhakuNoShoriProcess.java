/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd492001.RendingJieguoLianxieProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.OutFile;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.OutFilekekka;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ShinchokuNoTorikomiRisutoFairuCSVEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.JinbunoQurirumirisutofairuYishiteburuEntity;
import jp.co.ndensan.reams.db.dbd.service.core.dbd492001.NinteiKekkaRenkeiDataTorikomiManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.EucFileOutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * ファイル出力用データの編集_process処理クラスです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
public class ShimeiWaKuhakuNoShoriProcess extends BatchProcessBase<OutFile> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate."
            + "yokaigoninteikekkarenkeidetatorikomi.IShutsuryokuFairuRisutooSakuseiMapper.get出力ファイルリスト");
    private Association association;
    private RString eucFilePath;
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 一時デーブル_日次進捗 = new RString("1");
    private static final RString 一時デーブル_認定結果 = new RString("2");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;
    private JinbunoQurirumirisutofairuYishiteburuEntity entity;
    @BatchWriter
    private CsvWriter<ShinchokuNoTorikomiRisutoFairuCSVEntity> eucCsvWriter;
    private RendingJieguoLianxieProcessParameter processParameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = new BatchEntityCreatedTempTableWriter(JinbunoQurirumirisutofairuYishiteburuEntity.TABLE_NAME,
                JinbunoQurirumirisutofairuYishiteburuEntity.class);
        if (一時デーブル_日次進捗.equals(processParameter.get取込みデータ区分())) {
            eucFilePath = Path.combinePath(Path.getTmpDirectoryPath(), new RString("SinchokuNoTorikomiList.CSV"));
        } else if (一時デーブル_認定結果.equals(processParameter.get取込みデータ区分())) {
            eucFilePath = Path.combinePath(Path.getTmpDirectoryPath(), new RString("KekkaNoTorikomiList.CSV"));
        }
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                hasHeader(true).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                build();
    }

    @Override
    protected void process(OutFile outFile) {
        entity = new JinbunoQurirumirisutofairuYishiteburuEntity();
        OutFilekekka out = new OutFilekekka();
        NinteiKekkaRenkeiDataTorikomiManager.createInstance().項目設定(outFile, out);
        NinteiKekkaRenkeiDataTorikomiManager.createInstance().進捗の取込みリストファイル一時テーブル(entity, out);
        tmpTableWriter.insert(entity);
        ShinchokuNoTorikomiRisutoFairuCSVEntity csventity = new ShinchokuNoTorikomiRisutoFairuCSVEntity();
        NinteiKekkaRenkeiDataTorikomiManager.createInstance().ファイル出力進捗の取込みリストファイル(csventity, entity);
        eucCsvWriter.writeLine(csventity);
        AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, toPersonalData(outFile));
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        EucFileOutputJokenhyoFactory.createInstance(NinteiKekkaRenkeiDataTorikomiManager.createInstance().ファイルバッチ出力条件リストの出力(association,
                processParameter, eucCsvWriter.getCount())).print();
    }

    private PersonalData toPersonalData(OutFile entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0001")), new RString("申請書管理番号"),
                entity.get被保険者番号());
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }
}
