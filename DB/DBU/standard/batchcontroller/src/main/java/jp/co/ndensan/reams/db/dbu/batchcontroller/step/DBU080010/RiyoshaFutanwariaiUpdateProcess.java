/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.TokuteiKojinJohoHanKanri;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.DataSetNo;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShokaiTeikyoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TeikyoYohi;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TokuteiKojinJohomeiCode;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.RiyoshaFutanwariaiMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.RiyoshaFutanwariaiProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7301TokuteiKojinJohoHanKanriEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeikyoKihonJohoNNTempEntity;
import jp.co.ndensan.reams.db.dbu.service.core.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoManager;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担割合の更新用プロセスクラスです。
 *
 * @reamsid_L DBU-4880-060 zhaoyao
 */
public class RiyoshaFutanwariaiUpdateProcess extends BatchProcessBase<TeikyoKihonJohoNNTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate."
            + "tokuteikojinjohoteikyo.IRiyoshaFutanwariaiMapper.get提供対象者");
    private static final RString TABLE_中間DB提供基本情報 = new RString("TeikyoKihonJoho");
    private RiyoshaFutanwariaiProcessParameter processParameter;
    private RiyoshaFutanwariaiMybatisParameter mybatisParameter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 中間DB提供基本情報;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7301TokuteiKojinJohoHanKanriEntity> dbT7301EntityWriter;

    @Override
    protected IBatchReader createReader() {
        mybatisParameter = RiyoshaFutanwariaiMybatisParameter.createParamter提供対象者(getMybitisParamter());
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        中間DB提供基本情報 = new BatchEntityCreatedTempTableWriter(TABLE_中間DB提供基本情報,
                TeikyoKihonJohoNNTempEntity.class);
    }

    @Override
    protected void process(TeikyoKihonJohoNNTempEntity entity) {
        中間DB提供基本情報.update(getTeikyoKihonJohoEntity(entity));
    }

    private RString getMybitisParamter() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先));
        //TODO パラメータの設定が不明です、QA回答まち、
        //氏名検索条件（履歴を含む）名称について、履歴を含み検索するか否かを指定する。
        //履歴を含んで検索する
        //履歴を含めず検索する【初期値】
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        return new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
    }

    private TeikyoKihonJohoNNTempEntity getTeikyoKihonJohoEntity(TeikyoKihonJohoNNTempEntity entity) {
        entity.setTeikyoKubun(TeikyoYohi.提供要.getコード());
        return entity;
    }

    @Override
    protected void afterExecute() {
        TokuteiKojinJohoTeikyoManager.createInstance().update特定個人情報提供(TABLE_中間DB提供基本情報,
                processParameter.get新規異動区分(), TokuteiKojinJohomeiCode.特定個人情報版管理番号04.getコード(),
                DataSetNo._0202負担割合.getコード(), processParameter.get版番号());
        if (TeikyoYohi.提供要.getコード().equals(processParameter.get提供要否List().get(0))) {
            List<TokuteiKojinJohoHanKanri> entityList = TokuteiKojinJohoTeikyoManager.createInstance().get版番号(
                    processParameter.get新規異動区分(), TokuteiKojinJohomeiCode.特定個人情報版管理番号04.getコード(),
                    DataSetNo._0202負担割合.getコード(), FlexibleDate.EMPTY);
            for (TokuteiKojinJohoHanKanri business : entityList) {
                DbT7301TokuteiKojinJohoHanKanriEntity entity = business.toEntity();
                entity.setShokaiTeikyoKubun(ShokaiTeikyoKubun.初回提供済み.getコード());
                dbT7301EntityWriter.update(entity);
            }
        }
    }
}
