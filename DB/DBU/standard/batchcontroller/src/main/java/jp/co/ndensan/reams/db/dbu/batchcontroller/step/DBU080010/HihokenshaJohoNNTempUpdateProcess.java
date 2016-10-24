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
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.HihokenshaJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.HihokenshaJohoProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7301TokuteiKojinJohoHanKanriEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.JukyushaTeikyoKihonJohoNNTempEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeikyoKihonJohoNNTempEntity;
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
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者情報のバッチ処理です。
 *
 * @reamsid_L DBU-4880-030 zhaoyao
 */
public class HihokenshaJohoNNTempUpdateProcess extends BatchProcessBase<JukyushaTeikyoKihonJohoNNTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate."
            + "tokuteikojinjohoteikyo.IHihokenshaJohoMapper.get提供対象者");
    private HihokenshaJohoProcessParameter processParameter;
    private HihokenshaJohoMybatisParameter mybitisParamter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter teikyoKihonJohoNNTemp;

    @Override
    protected void initialize() {
        mybitisParamter = HihokenshaJohoMybatisParameter.createParamter提供対象者(getMybitisParamter(),
                new RString("\"").concat(processParameter.get提供基本情報中間テーブル名()).concat("\"")
        );

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybitisParamter);
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

    @Override
    protected void afterExecute() {
        TokuteiKojinJohoTeikyoManager 特定個人情報提供Manager = TokuteiKojinJohoTeikyoManager.createInstance();
        特定個人情報提供Manager.update特定個人情報提供(
                mybitisParamter.getTempTableName(),
                processParameter.get新規異動区分(),
                processParameter.get特定個人情報名コード(),
                DataSetNo._0101被保険者情報.getコード(),
                processParameter.get版番号());
        for (TokuteiKojinJohoHanKanri 個人情報提供 : 特定個人情報提供Manager.get版番号(
                RString.EMPTY, processParameter.get特定個人情報名コード(), DataSetNo._0101被保険者情報.getコード(), FlexibleDate.EMPTY)) {
            DbT7301TokuteiKojinJohoHanKanriEntity entity = 個人情報提供.toEntity();
            entity.setShokaiTeikyoKubun(ShokaiTeikyoKubun.初回提供済み.getコード());
        }
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
}
