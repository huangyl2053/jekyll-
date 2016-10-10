/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010.KokuhoShikakuJyohoInpotoyoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130010.IKokuhoShikakuIdoInMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7123KokuhoShikakuInfoEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBC130010_国保資格異動情報取込(国保資格情報に登録)
 *
 * @reamsid_L DBC-3020-030 dengwei
 */
public class InsertKokuhoShikakuJyohoProcess extends BatchProcessBase<KokuhoShikakuJyohoInpotoyoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130010.IKokuhoShikakuIdoInMapper.get国保資格情報インポート用Entitｙリスト");
    @BatchWriter
    private IBatchTableWriter<DbT7123KokuhoShikakuInfoEntity> 国保資格情報Writer;

    @Override
    protected void beforeExecute() {
        IKokuhoShikakuIdoInMapper mapper = getMapper(IKokuhoShikakuIdoInMapper.class);
        if (mapper.get国保資格情報インポート用Entitｙ件数() > 0) {
            mapper.delete国保資格情報();
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        国保資格情報Writer = BatchWriters.batchPermanentTableWriter(DbT7123KokuhoShikakuInfoEntity.class).build();
    }

    @Override
    protected void process(KokuhoShikakuJyohoInpotoyoEntity entity) {
        国保資格情報Writer.insert(get国保資格情報Entity(entity));
    }

    private DbT7123KokuhoShikakuInfoEntity get国保資格情報Entity(KokuhoShikakuJyohoInpotoyoEntity entity) {
        DbT7123KokuhoShikakuInfoEntity 国保資格情報Entity = new DbT7123KokuhoShikakuInfoEntity();
        国保資格情報Entity.setShikibetsuCode(new ShikibetsuCode(entity.get識別コード()));
        国保資格情報Entity.setRirekiNo(entity.get履歴番号());
        国保資格情報Entity.setKokuhoNo(entity.get国保番号());
        国保資格情報Entity.setKokuhoHokenshaNo(entity.get国保保険者番号());
        国保資格情報Entity.setKokuhoHokenshoNo(entity.get国保保険証番号());
        国保資格情報Entity.setKokuhoKojinNo(entity.get国保個人番号());
        国保資格情報Entity.setShikakuShutokuYMD(entity.get資格取得日());
        国保資格情報Entity.setShikakuSoshitsuYMD(entity.get資格喪失日());
        国保資格情報Entity.setTaishokuGaitoYMD(entity.get退職該当日());
        国保資格情報Entity.setTaishokuHigaitoYMD(entity.get退職非該当日());
        国保資格情報Entity.setKojinKubunCode(entity.get個人区分コード());
        国保資格情報Entity.setTorokuKubun(entity.get登録区分());

        return 国保資格情報Entity;
    }
}
