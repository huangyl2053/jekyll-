/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.HihokenshaDaichoBirthYMDMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppoippan.HihokenshaDaichoBirthYMDProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoippan.IchigoHihokenshaJohoKonkyoCSVEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppoippan.IJigyoHokokuGeppoIppanMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
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
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 被保台帳生年月日情報処理のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
public class HihokenshaDaichoBirthYMDProcess extends BatchProcessBase<IchigoHihokenshaJohoKonkyoCSVEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence."
            + "db.mapper.relate.jigyohokokugeppoippan.IJigyoHokokuGeppoIppanMapper.getIchigoHihokenshaJohoKonkyoCSV");
    private static final RString 拡張子 = new RString(".CSV");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");

    private HihokenshaDaichoBirthYMDProcessParameter processParameter;
    private HihokenshaDaichoBirthYMDMybatisParameter mybatisParameter;
    private IJigyoHokokuGeppoIppanMapper mapper;
//    private FileSpoolManager manager;
//    private RString filename;

    @BatchWriter
    private CsvWriter<IchigoHihokenshaJohoKonkyoCSVEntity> csvWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IJigyoHokokuGeppoIppanMapper.class);
        mybatisParameter = processParameter.toHihokenshaDaichoBirthYMDMybatisParameter();
//        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc,
//                new EucEntityId(processParameter.get作成CSVファイルID()), UzUDE0831EucAccesslogFileType.Csv);
//        filename = Path.combinePath(manager.getEucOutputDirectry(), processParameter.get作成CSVファイルID().concat(拡張子));
        RString filename = Path.combinePath(processParameter.get出力ファイルPATH(), processParameter.get作成CSVファイルID().concat(拡張子));
        csvWriter = new CsvWriter.InstanceBuilder(filename).
                setEncode(Encode.UTF_8withBOM)
                .canAppend(true)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true).build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void beforeExecute() {
        mapper.exeIchigoHihokenshaDataInsert(mybatisParameter);
    }

    @Override
    protected void process(IchigoHihokenshaJohoKonkyoCSVEntity entity) {
        if (mybatisParameter.getShukeiNo().value().equals(entity.get集計番号())) {
            csvWriter.writeLine(entity);
            AccessLogger.log(AccessLogType.照会, toPersonalData(entity.get識別コード(), entity.get被保険者番号()));
        }
    }

//    @Override
//    protected void afterExecute() {
//        manager.spool(filename);
//    }
//
    private PersonalData toPersonalData(RString 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号);
        return PersonalData.of(new ShikibetsuCode(識別コード), expandedInfo);
    }
}
