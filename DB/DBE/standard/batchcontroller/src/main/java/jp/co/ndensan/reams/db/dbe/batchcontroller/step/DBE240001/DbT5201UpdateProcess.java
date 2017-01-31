/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001;

import jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko.NinteiChosaBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.NinteiChosaProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoTmpEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * テーブル「DbT5201NinteichosaIraiJoho」の更新処理クラスです。
 *
 * @reamsid_L DBE-0080-140 duanzhanli
 */
public class DbT5201UpdateProcess extends BatchProcessBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get訪問調査依頼書");
    private NinteiChosaProcessParamter processParamter;
    private NinteiChosaBusiness business;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5201NinteichosaIraiJohoEntity> dbT5201EntityWriter;
    @BatchWriter
    private IBatchTableWriter homonChosaTempWriter;

    private static final RString TABLE_NAME_TMP = new RString("HomonChosaIraishoTmp");

    @Override
    protected void initialize() {
        business = new NinteiChosaBusiness(processParamter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toNinteiChosaMybitisParamter());
    }

    @Override
    protected void createWriter() {
        dbT5201EntityWriter = new BatchPermanentTableWriter(DbT5201NinteichosaIraiJohoEntity.class);
        homonChosaTempWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME_TMP, HomonChosaIraishoTmpEntity.class);
    }

    @Override
    protected void process(HomonChosaIraishoRelateEntity entity) {
        dbT5201EntityWriter.update(business.update認定調査依頼情報(entity));
        homonChosaTempWriter.insert(new HomonChosaIraishoTmpEntity(entity));
    }

}
