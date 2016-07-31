/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuka;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei.HeinjunkaAfterParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fukajoho.FukaJohoRelateMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;

/**
 * 賦課の情報のマッパーインタフェースです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public interface IFukaJohoRelateMapper {

    /**
     * 賦課の情報情報をキー検索で１件取得します。
     *
     * @param 賦課の情報検索条件 賦課の情報検索条件
     * @return FukaJohoRelateEntity
     */
    FukaJohoRelateEntity select賦課の情報ByKey(FukaJohoRelateMapperParameter 賦課の情報検索条件);

    /**
     * 最新賦課の情報情報をキー検索で１件取得します。
     *
     * @param 賦課の情報検索条件 賦課の情報検索条件
     * @return FukaJohoRelateEntity
     */
    List<FukaJohoRelateEntity> select最新賦課の情報ByKey(FukaJohoRelateMapperParameter 賦課の情報検索条件);

    /**
     * 賦課の情報情報をキー検索で１件取得します。
     *
     * @param parameter 賦課の情報検索条件
     * @return FukaJohoRelateEntity
     */
    FukaJohoRelateEntity select前年度賦課の情報ByKey(Map<String, Object> parameter);

    /**
     * 賦課の情報情報を取得します。
     *
     * @param parameter 賦課の情報検索条件
     * @return List<FukaJohoRelateEntity>
     */
    List<FukaJohoRelateEntity> get賦課の情報(Map<String, Object> parameter);

    /**
     * 平準化後の賦課の情報を取得します。。
     *
     * @param parameter 賦課の情報検索条件
     * @return List<FukaJohoRelateEntity>
     */
    List<FukaJohoRelateEntity> get平準化後の賦課の情報_画面(HeinjunkaAfterParameter parameter);

    /**
     * 平準化後の賦課の情報を取得します。。
     *
     * @param parameter 賦課の情報検索条件
     * @return List<FukaJohoRelateEntity>
     */
    List<FukaJohoRelateEntity> get平準化後の賦課の情報(HeinjunkaAfterParameter parameter);
}
