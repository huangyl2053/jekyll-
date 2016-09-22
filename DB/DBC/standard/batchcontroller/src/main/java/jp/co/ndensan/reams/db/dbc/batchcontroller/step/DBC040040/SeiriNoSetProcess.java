/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040040;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040040.JohoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040040.KogakuGassanNendoSizeEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040040.KogakuGassanTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 *
 * 自己負担額証明書整理番号Updateのprocessクラスです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
public class SeiriNoSetProcess extends BatchProcessBase<KogakuGassanNendoSizeEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040040."
                    + "IJikofutanShomeishoMapper.select高額合算一時");
    private static final RString TABLE_NAME = new RString("KogakuGassanTemp");
    private static final RString TEMP_TABLE_NAME = new RString("JohoTemp");
    private static final RString 汎用キー = new RString("自己負担額証明書整理番号");
    private static final RString 定数_99 = new RString("99");
    private static final int NUM_1 = 1;
    private static final int NUM_8 = 8;

    @BatchWriter
    IBatchTableWriter tableWriter;

    @BatchWriter
    IBatchTableWriter tempTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, KogakuGassanTempEntity.class);
        tempTableWriter = new BatchEntityCreatedTempTableWriter(TEMP_TABLE_NAME, JohoTempEntity.class);
    }

    @Override
    protected void process(KogakuGassanNendoSizeEntity entity) {
        CountedItem countedItem = Saiban.get(SubGyomuCode.DBC介護給付, 汎用キー, entity.get高額合算一時().getTaishoNendo(),
                Integer.parseInt(entity.get採番件数().toString()));
        RString 自己負担額証明書整理番号 = entity.get高額合算一時().getTaishoNendo().toDateString().concat(定数_99).
                concat(entity.get高額合算一時().getHokenshaNo().getColumnValue()).concat(countedItem.nextString().padZeroToLeft(NUM_8));
        KogakuGassanTempEntity tempEntity = entity.get高額合算一時();
        tempEntity.setJikoFutanGaku_RirekiNo(tempEntity.getJikoFutanGaku_RirekiNo() + NUM_1);
        tempEntity.setJikoFutanGaku_JikoFutanSeiriNo(自己負担額証明書整理番号);
        tableWriter.update(tempEntity);
        JohoTempEntity johoTempEntity = new JohoTempEntity();
        johoTempEntity.setHihokenshaNo(entity.get高額合算一時().getHihokenshaNo());
        johoTempEntity.setTaishoNendo(entity.get高額合算一時().getTaishoNendo());
        johoTempEntity.setHokenshaNo(entity.get高額合算一時().getHokenshaNo());
        johoTempEntity.setShikyuShinseishoSeiriNo(entity.get高額合算一時().getShikyuShinseishoSeiriNo());
        tempTableWriter.insert(johoTempEntity);
    }

}
