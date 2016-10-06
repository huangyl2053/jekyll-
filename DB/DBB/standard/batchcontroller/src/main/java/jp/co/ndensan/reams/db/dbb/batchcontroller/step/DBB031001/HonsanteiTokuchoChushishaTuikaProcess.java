/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honnsanteifuka.HonsanteiTokuchoChushishaParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt4300.HonsanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本算定特徴中止者追加するクラスです。
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
public class HonsanteiTokuchoChushishaTuikaProcess extends BatchProcessBase<DbT2001ChoshuHohoEntity> {

    private static final RString T5 = new RString("T5");
    private static final RString SELECTPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "honnsanteifuka.IHonnSanteiFukaMapper.select徴収方法情報");
    @BatchWriter
    private BatchPermanentTableWriter writer;
    private HonsanteiTokuchoChushishaParameter myBatisParameter;
    private HonsanteiFukaProcessParameter processParameter;

    @Override
    protected void createWriter() {
        writer = new BatchPermanentTableWriter(DbT2001ChoshuHohoEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        myBatisParameter = creatParameter(processParameter);
        return new BatchDbReader(SELECTPATH, myBatisParameter);
    }

    @Override
    protected void process(DbT2001ChoshuHohoEntity entity) {
        writer.insert(creatEntity(entity));
    }

    private HonsanteiTokuchoChushishaParameter creatParameter(HonsanteiFukaProcessParameter processParameter) {
        HonsanteiTokuchoChushishaParameter parameter = new HonsanteiTokuchoChushishaParameter();
        parameter.set賦課年度(processParameter.get賦課年度());
        parameter.set処理日時(processParameter.getバッチ起動時処理日時());
        return parameter;
    }

    private DbT2001ChoshuHohoEntity creatEntity(DbT2001ChoshuHohoEntity entity) {
        entity.setRirekiNo(entity.getRirekiNo() + 1);
        entity.setTokuchoTeishiNichiji(myBatisParameter.get処理日時());
        entity.setTokuchoTeishiJiyuCode(T5);
        return entity;
    }

}
