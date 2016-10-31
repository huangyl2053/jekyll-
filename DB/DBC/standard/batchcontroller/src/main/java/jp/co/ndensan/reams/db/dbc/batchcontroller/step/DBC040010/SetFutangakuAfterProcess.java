/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.SetFutangakuAfterProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseishoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）の<br/>
 * 高額合算申請書テーブルの更新のプロセスです。<br/>
 * 入力．事業分フラグがFalseの場合のみ、高額合算申請書TBLを更新する
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
public class SetFutangakuAfterProcess extends BatchProcessBase<DbT3068KogakuGassanShinseishoEntity> {

    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc040010.IKogakuGassanJikofutangakuKeisanMapper.getUpd高額合算申請書");
    private static final RString 固定 = new RString("0");
    private FlexibleYearMonth 自己負担額計算年月;
    @BatchWriter
    private IBatchTableWriter 高額合算申請書Writer;
    private SetFutangakuAfterProcessParameter parameter;

    @Override
    protected void initialize() {
        RDateTime 処理日時 = parameter.get処理日時();
        if (処理日時 == null) {
            自己負担額計算年月 = null;
        } else {
            RDate 処理日 = 処理日時.getDate();
            自己負担額計算年月 = new FlexibleYearMonth(処理日.getYearMonth().toDateString());
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }

    @Override
    protected void createWriter() {
        高額合算申請書Writer = new BatchPermanentTableWriter(DbT3068KogakuGassanShinseishoEntity.class);
    }

    @Override
    protected void process(DbT3068KogakuGassanShinseishoEntity entity) {
        entity.setJikoFutan_KeisanYM(自己負担額計算年月);
        entity.setSaiKeisanKubun(固定);
        entity.setState(EntityDataState.Modified);
        高額合算申請書Writer.update(entity);
    }
}
