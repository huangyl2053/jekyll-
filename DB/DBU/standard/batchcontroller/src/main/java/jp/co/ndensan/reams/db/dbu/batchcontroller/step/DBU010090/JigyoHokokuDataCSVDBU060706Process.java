/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010090;

import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokugeppohokenkyufukogaku.JigyoHokokuGeppoHokenkyufuKogaku;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppohokenkyufukogaku.JigyoHokokuGeppoHokenkyufuKogakuProcessParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohokenkyufukogaku.JigyoHokokuDataCsvRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokugeppohokenkyufukogaku.IJigyoHokokuGeppoHokenEUCEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 根拠CSV作成のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5580-030 zhangzhiming
 */
public class JigyoHokokuDataCSVDBU060706Process extends BatchProcessBase<JigyoHokokuDataCsvRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppohokenkyufukogaku."
            + "IJigyoHokokuGeppoHokenkyufuKogakuMapper.getJigyoHokokuDataCsv");
    private JigyoHokokuGeppoHokenkyufuKogakuProcessParamter processParameter;
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString コンマ = new RString(",");
    private RString eucFilePath;
    @BatchWriter
    private CsvWriter<IJigyoHokokuGeppoHokenEUCEntity> eucCsvWriter;
    private JigyoHokokuGeppoHokenkyufuKogaku business;

    @Override
    protected void initialize() {
        business = new JigyoHokokuGeppoHokenkyufuKogaku();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter
                .toJigyoHokokuDataCSVMybitisParamter(ShukeiNo.利用者負担第三段階_0706.getコード()));
    }

    @Override
    protected void createWriter() {
        eucFilePath = Path.combinePath(processParameter.getCsvFilePath(), new RString("DBU060706.CSV"));
        eucCsvWriter = BatchWriters.csvWriter(IJigyoHokokuGeppoHokenEUCEntity.class)
                .filePath(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void process(JigyoHokokuDataCsvRelateEntity entity) {
        eucCsvWriter.writeLine(business.setEUCEntity(entity));
    }
}
