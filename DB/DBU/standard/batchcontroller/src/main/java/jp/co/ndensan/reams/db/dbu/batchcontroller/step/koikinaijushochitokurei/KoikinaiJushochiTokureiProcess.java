/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.batchcontroller.step.koikinaijushochitokurei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.koikinaijushochitokurei.KoikinaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbu.definition.koikinaijushochitokurei.KoikinaiJushochiTokureiEnum;
import jp.co.ndensan.reams.db.dbu.definition.processprm.koikinaijushochitokurei.KoikinaiJushochiTokureiProcessParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.koikinaijushochitokurei.KoikinaiJushochiTokureiRelateEntity;
import jp.co.ndensan.reams.db.dbu.persistence.mapper.relate.koikinaijushochitokurei.IKoikinaiJushochiTokureiMapper;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 広域内住所地特例者情報の設定クラスです。
 */
public class KoikinaiJushochiTokureiProcess extends SimpleBatchProcessBase{
    
    private static final RString 直近 = new RString("1");
    private static final RString 基準日 = new RString("2");
    private static final RString 範囲 = new RString("3");
    private static final ReportId REPORT_ID = new ReportId(KoikinaiJushochiTokureiEnum.ReportId.getコード());
    private KoikinaiJushochiTokureiProcessParamter paramter;

    @Override
    protected void process() {
        get広域内住所地特例者情報();
        
    }
    
    private void get広域内住所地特例者情報() {
        if (直近.equals(paramter.getModel())) {
            
        } else if (基準日.equals(paramter.getModel())) {
            get基準日広住特適用();
        } else if (範囲.equals(paramter.getModel())) {
            get範囲広住特適用();
        }
    }
    
    private List<KoikinaiJushochiTokureiEntity> get直近広住特適用() {
        List<KoikinaiJushochiTokureiEntity> 広域内住所地特例者List = new ArrayList<>();
        List<KoikinaiJushochiTokureiRelateEntity> 直近広住特適用情報List = getMapper(IKoikinaiJushochiTokureiMapper.class).
                get直近広住特適用情報(paramter.toMybatisParamter(getPsmParamter()));
        for (KoikinaiJushochiTokureiRelateEntity entity : 直近広住特適用情報List) {
            KoikinaiJushochiTokureiEntity 広域内住所地特例者Entity = new KoikinaiJushochiTokureiEntity();
            広域内住所地特例者Entity.set被保険者番号(entity.getHihokenshaNo().getColumnValue());
            広域内住所地特例者Entity.set氏名カナ(ShikibetsuTaishoFactory
                    .createKojin(entity.getFt200Entity()).get名称().getKana().getColumnValue());
            広域内住所地特例者Entity.set生年月日(new RString(ShikibetsuTaishoFactory
                    .createKojin(entity.getFt200Entity()).get生年月日().toString()));
            広域内住所地特例者Entity.set住所コード(ShikibetsuTaishoFactory
                    .createKojin(entity.getFt200Entity()).get住所().get全国住所コード().getColumnValue());
            広域内住所地特例者Entity.set行政区CD(ShikibetsuTaishoFactory
                    .createKojin(entity.getFt200Entity()).get行政区画().getGyoseiku().getコード().getColumnValue());
            広域内住所地特例者Entity.set行政区(ShikibetsuTaishoFactory
                    .createKojin(entity.getFt200Entity()).get行政区画().getGyoseiku().get名称());
            広域内住所地特例者Entity.set取得日(new RString(entity.getShikakuShutokuYMD().toString()));
            広域内住所地特例者Entity.set取得届出日(new RString(entity.getShikakuShutokuTodokedeYMD().toString()));
            広域内住所地特例者Entity.set喪失日(new RString(entity.getShikakuSoshitsuYMD().toString()));
            広域内住所地特例者Entity.set広住喪失届出日(new RString(entity.getShikakuSoshitsuTodokedeYMD().toString()));
            
            
        }
        return 広域内住所地特例者List;
    }
    
    private List<KoikinaiJushochiTokureiRelateEntity> get基準日広住特適用() {
        return getMapper(IKoikinaiJushochiTokureiMapper.class).
                get基準日広住特適用情報(paramter.toMybatisParamter(getPsmParamter()));
    }
    
    private List<KoikinaiJushochiTokureiRelateEntity> get範囲広住特適用() {
        return getMapper(IKoikinaiJushochiTokureiMapper.class).
                get範囲広住特適用情報(paramter.toMybatisParamter(getPsmParamter()));
    }
    
    private RString getPsmParamter() {
         ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        List<JuminJotai> 住民状態 = new ArrayList<>();
        住民種別.add(JuminShubetsu.住登外個人_外国人);
        住民種別.add(JuminShubetsu.住登外個人_日本人);
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.外国人);
        住民状態.add(JuminJotai.住民);
        住民状態.add(JuminJotai.住登外);
        住民状態.add(JuminJotai.消除者);
        住民状態.add(JuminJotai.転出者);
        住民状態.add(JuminJotai.死亡者);
        key.set住民種別(住民種別);
        key.set住民状態(住民状態);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        return new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
    }

}
