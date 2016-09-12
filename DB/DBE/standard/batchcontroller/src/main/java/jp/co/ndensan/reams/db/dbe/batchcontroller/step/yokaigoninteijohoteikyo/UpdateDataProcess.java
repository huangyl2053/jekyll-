/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.yokaigoninteijohoteikyo;

import jp.co.ndensan.reams.db.dbe.definition.processprm.yokaigoninteijohoteikyo.YokaigoBatchProcessParamter;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo.IYokaigoNinteiJohoTeikyoMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請情報への更新処理のクラスです。
 *
 * @reamsid_L DBE-0230-030 zhangzhiming
 */
public class UpdateDataProcess extends BatchProcessBase<RString> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.IDbT5301ShujiiIkenshoIraiJohoMapper."
            + "getListForProcess");
    private YokaigoBatchProcessParamter processParameter;
    private IYokaigoNinteiJohoTeikyoMapper mapper;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5101NinteiShinseiJohoEntity> dbT5101Temp;

    @Override
    protected void initialize() {
        mapper = getMapper(IYokaigoNinteiJohoTeikyoMapper.class);
    }

    @Override
    protected void createWriter() {
        dbT5101Temp = new BatchPermanentTableWriter<>(DbT5101NinteiShinseiJohoEntity.class);
    }

    @Override
    protected void process(RString item) {

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void afterExecute() {
        DbT5101NinteiShinseiJohoEntity entity = mapper.get要介護認定申請情報(processParameter.toYokaigoBatchMybitisParamter());
        entity.setJohoteikyoSiryoOutputYMD(FlexibleDate.getNowDate());
        dbT5101Temp.update(entity);
    }
}
