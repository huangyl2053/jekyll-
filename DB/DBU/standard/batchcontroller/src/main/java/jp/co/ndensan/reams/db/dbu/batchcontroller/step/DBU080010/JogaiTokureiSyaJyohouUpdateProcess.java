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
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.JogaiTokureiSyaJyohouMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.JogaiTokureiSyaJyohouProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7301TokuteiKojinJohoHanKanriEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeikyoKihonJohoNNTempEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeyikyouTayisyousyaJyohouRelateEntity;
import jp.co.ndensan.reams.db.dbu.service.core.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例者情報の更新用プロセスクラスです。
 *
 * @reamsid_L DBU-4880-040 linghuhang
 */
public class JogaiTokureiSyaJyohouUpdateProcess extends BatchProcessBase<TeyikyouTayisyousyaJyohouRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo."
            + "IJogaiTokureiSyaJyohouMapper.get提供対象者");
    private static final RString 転義符 = new RString("\"");
    private JogaiTokureiSyaJyohouProcessParameter processParameter;
    private JogaiTokureiSyaJyohouMybatisParameter mybatisParameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 中間DB提供基本情報;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7301TokuteiKojinJohoHanKanriEntity> dbT7301EntityWriter;

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        List<JuminShubetsu> 住民種別List = new ArrayList<>();
        住民種別List.add(JuminShubetsu.日本人);
        住民種別List.add(JuminShubetsu.外国人);
        住民種別List.add(JuminShubetsu.住登外個人_外国人);
        住民種別List.add(JuminShubetsu.住登外個人_日本人);
        List<JuminJotai> 住民状態List = new ArrayList<>();
        住民状態List.add(JuminJotai.住民);
        住民状態List.add(JuminJotai.住登外);
        住民状態List.add(JuminJotai.消除者);
        住民状態List.add(JuminJotai.転出者);
        住民状態List.add(JuminJotai.死亡者);
        key.set住民種別(住民種別List);
        key.set住民状態(住民状態List);
        key.set同一人代表者優先区分(DoitsuninDaihyoshaYusenKubun.同一人代表者を優先しない);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        mybatisParameter = JogaiTokureiSyaJyohouMybatisParameter.createParamter当初_版改定_異動分データ抽出(
                FlexibleDate.EMPTY, FlexibleDate.EMPTY,
                RDateTime.MAX, RDateTime.MAX,
                HihokenshaNo.EMPTY,
                RString.EMPTY, processParameter.get新規異動区分(),
                転義符.concat(processParameter.get提供基本情報中間テーブル名()).concat(転義符),
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        dbT7301EntityWriter = new BatchPermanentTableWriter(DbT7301TokuteiKojinJohoHanKanriEntity.class);
        中間DB提供基本情報 = new BatchEntityCreatedTempTableWriter(processParameter.get提供基本情報中間テーブル名(),
                TeikyoKihonJohoNNTempEntity.class);
    }

    @Override
    protected void process(TeyikyouTayisyousyaJyohouRelateEntity entity) {
        中間DB提供基本情報.update(getTeikyoKihonJohoEntity(entity));
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
        List<TokuteiKojinJohoHanKanri> businessList = TokuteiKojinJohoTeikyoManager.createInstance().get版番号(
                RString.EMPTY, TokuteiKojinJohomeiCode.特定個人情報版管理番号04.getコード(),
                DataSetNo._0102住所地特例情報.getコード(), FlexibleDate.EMPTY);
        for (TokuteiKojinJohoHanKanri business : businessList) {
            DbT7301TokuteiKojinJohoHanKanriEntity entity = business.toEntity();
            entity.setShokaiTeikyoKubun(ShokaiTeikyoKubun.初回提供済み.getコード());
            dbT7301EntityWriter.update(entity);
        }
    }
}
