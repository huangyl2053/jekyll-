/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010;

import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TeikyoYohi;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.JukyushaKihonJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.JukyushaKihonJohoProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.JukyushaTeikyoKihonJohoNNTempEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeikyoKihonJohoNNTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者基本情報のバッチ処理です。
 *
 * @reamsid_L DBU-4880-050 wangxiaodong
 */
public class JukyushaKihonJohoTeikyoKihonJohoNNTempUpdateProcess extends BatchProcessBase<JukyushaTeikyoKihonJohoNNTempEntity> {

    private static final RString GET_JUKYUSHATEIKYOJOHOTEMP = new RString("jp.co.ndensan.reams"
            + ".db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo.getJukyushaTeikyoKihonJohoNNTempData");
    private JukyushaKihonJohoProcessParameter processParameter;
    private JukyushaKihonJohoMybatisParameter mybitisParamter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter teikyoKihonJohoNNTemp;

    @Override
    protected void initialize() {
        mybitisParamter = processParameter.toJukyushaKihonJohoMybatisParameter();
        mybitisParamter.setTempTableName(new RString("\"").concat(processParameter.get提供基本情報中間テーブル名()).concat("\""));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(GET_JUKYUSHATEIKYOJOHOTEMP, mybitisParamter);
    }

    @Override
    protected void createWriter() {
        teikyoKihonJohoNNTemp = new BatchEntityCreatedTempTableWriter(
                processParameter.get提供基本情報中間テーブル名(), TeikyoKihonJohoNNTempEntity.class);
    }

    @Override
    protected void process(JukyushaTeikyoKihonJohoNNTempEntity entity) {
        TeikyoKihonJohoNNTempEntity tempEntity = entity.getTeikyoJohoKohoEntity();
        tempEntity.setTeikyoKubun(TeikyoYohi.提供要.getコード());
        tempEntity.setKojinNo(entity.getKojinNoPSM().value());
        teikyoKihonJohoNNTemp.update(tempEntity);
    }

}
