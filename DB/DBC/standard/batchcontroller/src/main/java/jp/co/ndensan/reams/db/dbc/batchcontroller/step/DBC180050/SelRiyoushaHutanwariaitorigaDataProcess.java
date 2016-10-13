/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180050.SelRiyoushaHutanwariaitorigaDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.SelRiyoushaHutanwariaitorigaDataResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.TorigaDataTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(利用者負担割合トリガデータ抽出Process)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
public class SelRiyoushaHutanwariaitorigaDataProcess extends BatchProcessBase<SelRiyoushaHutanwariaitorigaDataResultEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc180050.IKoseiTaishoKyufuJissekiIchiranMapper.get利用者負担割合情報");

    private SelRiyoushaHutanwariaitorigaDataProcessParameter processParameter;
    @BatchWriter
    private IBatchTableWriter<TorigaDataTempEntity> トリガデータTempWriter;
    private static final RString TEMP_TABLE = new RString("torigaDataTemp");
    private static final RString 開始月 = new RString("08");
    private static final int 十二 = 12;

    @Override

    protected void initialize() {
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toSelRiyoushaHutanwariaitorigaDataMybatisParameter());
    }

    @Override
    protected void createWriter() {
        トリガデータTempWriter = new BatchEntityCreatedTempTableWriter(TEMP_TABLE, TorigaDataTempEntity.class);
    }

    @Override
    protected void process(SelRiyoushaHutanwariaitorigaDataResultEntity entity) {
        FlexibleYearMonth 年月開始 = new FlexibleYearMonth(entity.get年度().toDateString().concat(開始月));
        for (int i = 0; i < 十二; i++) {
            TorigaDataTempEntity tenpEntity = new TorigaDataTempEntity();
            tenpEntity.set年度(entity.get年度());
            tenpEntity.set被保険者番号(entity.get被保険者番号());
            tenpEntity.set年月(年月開始.plusMonth(i));
            トリガデータTempWriter.insert(tenpEntity);
        }
    }
}
