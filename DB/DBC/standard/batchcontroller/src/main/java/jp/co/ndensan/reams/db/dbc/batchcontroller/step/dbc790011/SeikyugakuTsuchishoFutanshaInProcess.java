/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc790011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyugakutsuchishofutanshain.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 請求額通知書情報取込共通処理（CSVファイル取込・公費負担者分）のCSVファイル取込processクラスです
 *
 * @reamsid_L DBC-2790-011 hemin
 */
public class SeikyugakuTsuchishoFutanshaInProcess extends BatchProcessBase<RString> {

    private RString csvReaderPath;
    private static final RString KEY_分離文字 = new RString("file.separator");
    private final RString 区切り文字 = new RString(",");
    private SeikyugakuTsuchishoFutanshaInProcessParameter parameter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 請求額通知書一時tableWriter;

    private static final RString 請求額通知書一時_TABLE_NAME = new RString("DbWT1511SeikyugakuTsuchishoTemp");

    @Override
    protected void initialize() {
        csvReaderPath = parameter.getPath().concat(KEY_分離文字).concat(parameter.getFileName());
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(csvReaderPath);
    }

    @Override
    protected void createWriter() {
        請求額通知書一時tableWriter
                = new BatchEntityCreatedTempTableWriter(請求額通知書一時_TABLE_NAME, DbWT1511SeikyugakuTsuchishoTempEntity.class);
    }

    @Override
    protected void process(RString line) {
        List<RString> data = line.split(区切り文字.toString());
        if (data != null && !data.isEmpty()) {
            SeikyugakuTsuchishoFutanshaInManager ファイル登録Manager = SeikyugakuTsuchishoFutanshaInManager.createInstance();
            DbWT1511SeikyugakuTsuchishoTempEntity dbWT1511SeikyugakuTsuchishoTempEntity = ファイル登録Manager.csvファイル読込データ処理(data);
            請求額通知書一時tableWriter.insert(dbWT1511SeikyugakuTsuchishoTempEntity);
        }
    }

    @Override
    protected void afterExecute() {
    }

}
