/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010;

import java.util.ArrayList;
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
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeyikyouTayisyousyaJyohouRelateEntity;
import jp.co.ndensan.reams.db.dbu.service.core.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoManager;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DoitsuninDaihyoshaYusenKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
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
public class RiyoshaFutanwariaiUpdateProcess extends BatchProcessBase<TeyikyouTayisyousyaJyohouRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate."
            + "tokuteikojinjohoteikyo.IRiyoshaFutanwariaiMapper.get提供対象者");
    private static final RString TABLE_中間DB提供基本情報 = new RString("TeikyoKihonJohoNNTemp");
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
        dbT7301EntityWriter = new BatchPermanentTableWriter(DbT7301TokuteiKojinJohoHanKanriEntity.class);
        中間DB提供基本情報 = new BatchEntityCreatedTempTableWriter(TABLE_中間DB提供基本情報,
                TeikyoKihonJohoNNTempEntity.class);
    }

    @Override
    protected void process(TeyikyouTayisyousyaJyohouRelateEntity entity) {
        中間DB提供基本情報.update(getTeikyoKihonJohoEntity(entity));
    }

    private RString getMybitisParamter() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        List<JuminShubetsu> 住民種別リスト = new ArrayList<>();
        住民種別リスト.add(JuminShubetsu.住登外個人_外国人);
        住民種別リスト.add(JuminShubetsu.住登外個人_日本人);
        住民種別リスト.add(JuminShubetsu.外国人);
        住民種別リスト.add(JuminShubetsu.日本人);
        key.set住民種別(住民種別リスト);
        List<JuminJotai> 住民状態リスト = new ArrayList<>();
        住民状態リスト.add(JuminJotai.住民);
        住民状態リスト.add(JuminJotai.住登外);
        住民状態リスト.add(JuminJotai.消除者);
        住民状態リスト.add(JuminJotai.転出者);
        住民状態リスト.add(JuminJotai.死亡者);
        key.set住民状態(住民状態リスト);
        key.set同一人代表者優先区分(DoitsuninDaihyoshaYusenKubun.同一人代表者を優先しない);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        return new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
    }

    private TeikyoKihonJohoNNTempEntity getTeikyoKihonJohoEntity(TeyikyouTayisyousyaJyohouRelateEntity entity) {
        TeikyoKihonJohoNNTempEntity tempEntity = entity.getTeikyoKihonJohoNNTempEntity();
        tempEntity.setTeikyoKubun(TeikyoYohi.提供要.getコード());
        if (entity.getKojinNo() != null && !entity.getKojinNo().isEmpty()) {
            tempEntity.setKojinNo(entity.getKojinNo().value());
        }
        return tempEntity;
    }

    @Override
    protected void afterExecute() {
        TokuteiKojinJohoTeikyoManager.createInstance().update特定個人情報提供(
                new RString("\"").concat(TABLE_中間DB提供基本情報).concat("\""),
                processParameter.get新規異動区分(), TokuteiKojinJohomeiCode.特定個人情報版管理番号04.getコード(),
                DataSetNo._0202負担割合.getコード(), processParameter.get版番号());
        if (TeikyoYohi.提供要.getコード().equals(processParameter.get特定個人情報名コード())) {
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
