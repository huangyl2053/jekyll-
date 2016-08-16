/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.itizihanteiiftorikomi;

import jp.co.ndensan.reams.db.dbe.business.core.itizi.itizihanteiiftorikomi.ItizihanteiIFtoriKomiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.itizihanteishori.ItziHanteiShoriProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.itizihanteiiftorikomi.ItizihanteiIFtoriKomiRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBE309002_一次判定IF取込のBusinessクラスです。
 *
 * @reamsid_L DBE-1470-022 wanghui
 */
public class ItizihanteiIFtoriKomiUpdateProcess extends BatchProcessBase<ItizihanteiIFtoriKomiRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.itizihanteiiftorikomi.ItizihanteiIFtoriKomiMapper.gethihokenshaNo");
    private ItizihanteiIFtoriKomiBusiness business;
    private ItziHanteiShoriProcessParamter paramter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5116IchijiHanteiKekkaJohoEntity> tableWrite;

    @Override
    protected void beforeExecute() {
        business = new ItizihanteiIFtoriKomiBusiness();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toItziHanteiShoriMybitisParamter());
    }

    @Override
    protected void createWriter() {
        tableWrite = new BatchPermanentTableWriter<>(DbT5116IchijiHanteiKekkaJohoEntity.class);
    }

    @Override
    protected void process(ItizihanteiIFtoriKomiRelateEntity entity) {
        if (entity.getShinseishoKanriNo3() == null) {
            tableWrite.insert(business.getchijiHanteiKekkaJoho(entity));
        } else {
            tableWrite.update(business.get更新処理(entity));
        }
    }
}
