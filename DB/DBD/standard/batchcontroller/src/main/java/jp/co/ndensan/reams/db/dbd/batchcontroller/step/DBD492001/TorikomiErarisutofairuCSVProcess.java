/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd492001.RendingJieguoLianxieProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.TorikomiErarisutofairuCSVEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.ErrordataIchijiTeburuEntity;
import jp.co.ndensan.reams.db.dbd.service.core.dbd492001.NinteiKekkaRenkeiDataTorikomiManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.EucFileOutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.File;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 進捗の取込みエラーリストファイルの出力_process処理クラスです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
public class TorikomiErarisutofairuCSVProcess extends BatchProcessBase<ErrordataIchijiTeburuEntity> {

    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 一時デーブル_日次進捗 = new RString("1");
    private static final RString 一時デーブル_認定結果 = new RString("2");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate."
            + "yokaigoninteikekkarenkeidetatorikomi.IErrorDataTebruMapper.getエラーリストファイル一時テーブル");
    private RendingJieguoLianxieProcessParameter processParameter;
    private RString eucFilePath;
    private Association association;
    private boolean flag = true;

    @BatchWriter
    private CsvWriter<TorikomiErarisutofairuCSVEntity> eucCsvWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void createWriter() {
        if (一時デーブル_日次進捗.equals(processParameter.get取込みデータ区分())) {
            eucFilePath = Path.combinePath(Path.getTmpDirectoryPath(), new RString("SinchokuNoTorikomiErrList.CSV"));
        } else if (一時デーブル_認定結果.equals(processParameter.get取込みデータ区分())) {
            eucFilePath = Path.combinePath(Path.getTmpDirectoryPath(), new RString("KekkaNoTorikomiErrList.CSV"));
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
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
    }

    @Override
    protected void process(ErrordataIchijiTeburuEntity error) {
        flag = false;
        TorikomiErarisutofairuCSVEntity csventity = new TorikomiErarisutofairuCSVEntity();
        NinteiKekkaRenkeiDataTorikomiManager.createInstance().ファイル出力進捗の取込みエラーリストファイル(csventity, error);
        eucCsvWriter.writeLine(csventity);
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        EucFileOutputJokenhyoFactory.createInstance(NinteiKekkaRenkeiDataTorikomiManager.createInstance().エラーバッチ出力条件リストの出力(association,
                processParameter, eucCsvWriter.getCount())).print();
        if (flag) {
            File.deleteIfExists(eucFilePath);
        }
    }
}
