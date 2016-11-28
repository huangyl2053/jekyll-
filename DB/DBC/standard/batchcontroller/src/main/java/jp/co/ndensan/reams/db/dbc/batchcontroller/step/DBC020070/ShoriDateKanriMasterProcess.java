/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020070.JigyobunShikyugakuKeisanProcessParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 処理結果を、処理日付管理マスタに設定する処理クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class ShoriDateKanriMasterProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020070."
            + "IJigyobunShikyugakuKeisanMapper.get処理日付管理マスタ");

    private JigyobunShikyugakuKeisanProcessParameter processParameter;

    private RString 市町村コード;

    @BatchWriter
    private BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> tableWrite;

    @Override
    protected void initialize() {
        市町村コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().value();
        processParameter.set自市町村コード(市町村コード);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, processParameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        this.tableWrite = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity entity) {
        entity.setKijunYMD(processParameter.get処理日());
        entity.setTaishoKaishiYMD(processParameter.get処理日());
        entity.setTaishoKaishiTimestamp(new YMDHMS(new RString(processParameter.get処理日().toString()).
                concat(getTime(processParameter.get処理時間()))));
        entity.setState(EntityDataState.Modified);
        tableWrite.update(entity);
    }

    private RString getTime(RTime time) {
        if (time == null) {
            return null;
        }
        RString hour = new RString(time.getHour());
        RString minute = new RString(time.getMinute());
        RString second = new RString(time.getSecond());
        hour = hour.length() == 1 ? new RString(0).concat(hour) : hour;
        minute = minute.length() == 1 ? new RString(0).concat(minute) : minute;
        second = second.length() == 1 ? new RString(0).concat(second) : second;
        return hour.concat(minute).concat(second);
    }
}
