/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.dbamn71001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.dbamn71001.ShikakuIdoTaishoshaShutokuMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dbamn71001.ShikakuIdoTaishoshaShutokuProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.dbamn71001.ShikakuIdoTaishoshaEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.dbamn71001.IDbamn71001RelateMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1010TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth._DateOfBirth;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格異動対象者情報の取得_バッチフ処理クラスです
 */
public class ShikakuIdoTaishoshaShutokuProcess extends SimpleBatchProcessBase {


   /**
     * OutputParameter用キー shikakuIdoTaishoShaList
     */
    public static final RString SHIKAKU_IDO_TAISHOSHA_LIST;
    private ShikakuIdoTaishoshaShutokuProcessParameter parameter;
    private IDbamn71001RelateMapper mapper;
    private static final int AGE_65 = 65;
    
    static {
        SHIKAKU_IDO_TAISHOSHA_LIST = new RString("shikakuIdoTaishoShaList");
    }
    private OutputParameter<List<ShikakuIdoTaishoshaEntity>> shikakuIdoTaishoShaList;
    
    @Override
    protected void beforeExecute() {
        mapper = getMapper(IDbamn71001RelateMapper.class);
        shikakuIdoTaishoShaList= new OutputParameter<>();
    }
    
    @Override
    protected void process() {
        FlexibleDate 開始日 = parameter.get開始日();
        FlexibleDate 終了日 = parameter.get終了日();
        
        List<ShikibetsuCode> shikibetsuCode = new ArrayList<>();
        
        // 識別コードの検索
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.未定義);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminShubetsu> juminShubetsuList = new ArrayList<>();
        juminShubetsuList.add(JuminShubetsu.日本人);
        juminShubetsuList.add(JuminShubetsu.外国人);
        key.set住民種別(juminShubetsuList);
        List<JuminJotai> juminJotaiList = new ArrayList<>();
        juminJotaiList.add(JuminJotai.住民);
        juminJotaiList.add(JuminJotai.住登外);
        juminJotaiList.add(JuminJotai.消除者);
        juminJotaiList.add(JuminJotai.転出者);
        key.set住民状態(juminJotaiList);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.build();
        
        List<UaFt200FindShikibetsuTaishoEntity> entityList = mapper.select識別コード(parameter
                                        .toAtenaMybatisParameter(shikibetsuTaishoPSMSearchKey, null));
        for (UaFt200FindShikibetsuTaishoEntity entity : entityList) {
            if (entity.getShikibetsuCode() != null) {
                shikibetsuCode.add(entity.getShikibetsuCode());
            }
        }
        
        // 宛名識別対象PSMの検索
        key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        juminShubetsuList = new ArrayList<>();
        juminShubetsuList.add(JuminShubetsu.日本人);
        juminShubetsuList.add(JuminShubetsu.外国人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_日本人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_外国人);
        key.set住民種別(juminShubetsuList);
        juminJotaiList = new ArrayList<>();
        juminJotaiList.add(JuminJotai.住民);
        juminJotaiList.add(JuminJotai.住登外);
        juminJotaiList.add(JuminJotai.消除者);
        juminJotaiList.add(JuminJotai.転出者);
        key.set住民状態(juminJotaiList);
        shikibetsuTaishoPSMSearchKey = key.build();
        
        List<ShikakuIdoTaishoshaEntity> 資格異動対象者ListTmp = mapper.select資格異動対象者(parameter
                                        .toAtenaMybatisParameter(shikibetsuTaishoPSMSearchKey, shikibetsuCode));
        
        List<ShikakuIdoTaishoshaEntity> 資格異動対象者List = new ArrayList<>();
        資格異動対象者List.addAll(資格異動対象者ListTmp);
        for (ShikakuIdoTaishoshaEntity entity : 資格異動対象者ListTmp) {
            if (entity.get生年月日().isBefore(開始日.plusYear(AGE_65).plusDay(1))
                    || 終了日.minusYear(AGE_65).plusDay(1).isBefore(entity.get生年月日())) {
                資格異動対象者List.remove(entity);
            }
        }
        
        資格異動対象者ListTmp.clear();
        資格異動対象者ListTmp.addAll(資格異動対象者List);
        List<DbT1003TashichosonJushochiTokureiEntity> 他市町村住所地特例List;
        List<DbT1002TekiyoJogaishaEntity> 適用除外者List;
        List<DbT1009ShikakuShutokuJogaishaEntity> 資格取得除外者List;
        List<DbT1010TennyushutsuHoryuTaishoshaEntity> 転入保留対象者List;
        
        for (ShikakuIdoTaishoshaEntity entity : 資格異動対象者ListTmp) {
            // 65歳年齢到達日の取得  TODO QA コンストラクタと引数を確認 #73116
            AgeCalculator ageCalculator = new AgeCalculator(new _DateOfBirth(entity.get生年月日()),
                                        JuminJotai.toValue(entity.get住民状態コード()), FlexibleDate.MAX);
            FlexibleDate age = ageCalculator.get年齢到達日(AGE_65);
            
            ShikakuIdoTaishoshaShutokuMybatisParameter myBatisParam = parameter
                                        .toShikakuIdoTaishoshaShutokuMybatisParameter(entity.get識別コード(), age);
            
            他市町村住所地特例List = mapper.select他市町村住所地特例(myBatisParam);
            if (!他市町村住所地特例List.isEmpty()) {
                資格異動対象者List.remove(entity);
            }
            
            適用除外者List = mapper.select適用除外者(myBatisParam);
            if (!適用除外者List.isEmpty()) {
                資格異動対象者List.remove(entity);
            }
            
            資格取得除外者List = mapper.select資格取得除外者(myBatisParam);
            if (!資格取得除外者List.isEmpty()) {
                資格異動対象者List.remove(entity);
            }
            
            転入保留対象者List = mapper.select転入保留対象者(myBatisParam);
            if (!転入保留対象者List.isEmpty()) {
                資格異動対象者List.remove(entity);
            }
        }
        shikakuIdoTaishoShaList.setValue(資格異動対象者List);
    }
    
}
