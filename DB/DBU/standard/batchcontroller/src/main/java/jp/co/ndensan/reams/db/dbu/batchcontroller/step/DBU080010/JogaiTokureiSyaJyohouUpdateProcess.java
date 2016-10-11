/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010;

import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShokaiTeikyoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TeikyoYohi;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7301TokuteiKojinJohoHanKanriEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.sougoujigyoujyohou.TeikyoKihonJohoEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeikyoKihonJohoNNTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例者情報の更新用プロセスクラスです。
 *
 * @reamsid_L DBU-4880-080 lishengli
 */
public class JogaiTokureiSyaJyohouUpdateProcess extends BatchProcessBase<TeikyoKihonJohoNNTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo."
            + "IJogaiTokureiSyaJyohouMapper.get提供対象者");
    private static final RString TABLE_中間DB提供基本情報 = new RString("TeikyoKihonJoho");
//    private SougouJigyouJyohouProcessParameter processParameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 中間DB提供基本情報;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7301TokuteiKojinJohoHanKanriEntity> dbT7301EntityWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        中間DB提供基本情報 = new BatchEntityCreatedTempTableWriter(TABLE_中間DB提供基本情報,
                TeikyoKihonJohoEntity.class);
    }

    @Override
    protected void process(TeikyoKihonJohoNNTempEntity entity) {
        中間DB提供基本情報.update(getTeikyoKihonJohoEntity(entity));
    }

    private TeikyoKihonJohoNNTempEntity getTeikyoKihonJohoEntity(TeikyoKihonJohoNNTempEntity entity) {
        entity.setTeikyoKubun(TeikyoYohi.提供要.getコード());
        // TODO 凌護行 個人番号デープルが無し、QA1698回答待ち、2016/10/20
        entity.setKojinNo(RString.EMPTY);
        return entity;
    }

    @Override
    protected void afterExecute() {
//        TokuteiKojinJohoTeikyoManager.createInstance().update特定個人情報提供(TABLE_中間DB提供基本情報,
//                processParameter.get新規異動区分(), TokuteiKojinJohomeiCode.特定個人情報版管理番号04.getコード(),
//                DataSetNo._0400総合事業.getコード(), TABLE_中間DB提供基本情報);
//        List<TokuteiKojinHanKanriTokuteiJohoBusiness> businessList = TokuteiKojinJohoTeikyoManager.createInstance().get版番号(
//                processParameter.get新規異動区分(), TokuteiKojinJohomeiCode.特定個人情報版管理番号04.getコード(),
//                DataSetNo._0400総合事業.getコード(), FlexibleDate.EMPTY);
//        for (TokuteiKojinHanKanriTokuteiJohoBusiness business : businessList) {
//
//        }
        DbT7301TokuteiKojinJohoHanKanriEntity entity = new DbT7301TokuteiKojinJohoHanKanriEntity();
        entity.setShokaiTeikyoKubun(ShokaiTeikyoKubun.初回提供済み.getコード());
        dbT7301EntityWriter.update(entity);
    }
}
