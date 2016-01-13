/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.dbamn71001;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.dbamn71001.AtenaMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.dbamn71001.ShikakuIdoTaishoshaShutokuMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.dbamn71001.ShikakuIdoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1010TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * ６５歳年齢到達資格異動のマッパーインタフェースです。
 */
public interface IDbamn71001RelateMapper {
    
    /**
     * 識別コードを取得します。
     * 
     * @param parameter 検索条件
     * @return List<UaFt200FindShikibetsuTaishoEntity>
     */
    List<UaFt200FindShikibetsuTaishoEntity> select識別コード(AtenaMybatisParameter parameter);
    
   /**
     * 資格異動対象者のデータを取得します。
     *
     * @param parameter 検索条件
     * @return 資格異動対象者リスト
     */
    List<ShikakuIdoTaishoshaEntity> select資格異動対象者(AtenaMybatisParameter parameter);
    
    /**
     * 他市町村住所地特例のデータを取得します。
     * 
     * @param param 検索条件
     * @return 他市町村住所地特例のデータ
     */
    List<DbT1003TashichosonJushochiTokureiEntity> select他市町村住所地特例(ShikakuIdoTaishoshaShutokuMybatisParameter param);
    
    /**
     * 適用除外者のデータを取得します。
     * 
     * @param param 検索条件
     * @return 適用除外者のデータ
     */
    List<DbT1002TekiyoJogaishaEntity> select適用除外者(ShikakuIdoTaishoshaShutokuMybatisParameter param);
    
    /**
     * 資格取得除外者のデータを取得します。
     * 
     * @param param
     * @return 資格取得除外者のデータ
     */
    List<DbT1009ShikakuShutokuJogaishaEntity> select資格取得除外者(ShikakuIdoTaishoshaShutokuMybatisParameter param);
    
    /**
     * 転入保留対象者のデータを取得します。
     * 
     * @param param
     * @return 転入保留対象者のデータ
     */
    List<DbT1010TennyushutsuHoryuTaishoshaEntity> select転入保留対象者(ShikakuIdoTaishoshaShutokuMybatisParameter param);
    
}
