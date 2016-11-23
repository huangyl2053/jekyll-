/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU070020;

import jp.co.ndensan.reams.db.dbu.definition.processprm.kaigojyuminhyokoukiu.KaiGoJuminHyokouKiuProcessParameter;
import jp.co.ndensan.reams.db.dbu.service.core.kaigojyuminhyoutashajuki.KaiGoJuminHyokouKiuEucCsvBusiness;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護住民票個別事項連携情報作成【広域運用】のバッチのパラメータです。
 *
 * @reamsid_L DBU-0550-020 wanghui
 *
 */
public class KaiGoJuminHyokouKiuDBUpdateProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kaigojyuminhyokoukiu."
            + "IkaigojyuminhyokoukiuMapper.get処理日付管理マスタ登録処理");
    private boolean isEmpty = true;
    private KaiGoJuminHyokouKiuProcessParameter parameter;
    private DbT7022ShoriDateKanriEntity dbt7022entity;
    private KaiGoJuminHyokouKiuEucCsvBusiness business;

    @BatchWriter
    private BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> tableWrite;

    @Override
    protected void initialize() {
        dbt7022entity = new DbT7022ShoriDateKanriEntity();
        business = new KaiGoJuminHyokouKiuEucCsvBusiness();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toKaiGoJuminHyokouKiuMapperParameter());
    }

    @Override
    protected void createWriter() {
        tableWrite = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity entity) {
        isEmpty = false;
        dbt7022entity = business.set更新(parameter);
        tableWrite.update(dbt7022entity);
    }

    @Override
    protected void afterExecute() {
        if (isEmpty) {
            tableWrite.insert(business.set追加(parameter));
        }
    }
}
