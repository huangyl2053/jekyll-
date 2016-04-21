/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fukajoho.fukajoho;

import java.util.List;
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
     * 主キー1に合致する賦課の情報のリストを取得します。
     *
     * @param 賦課の情報検索条件 賦課の情報検索条件
     * @return FukaJohoRelateEntityの{@code list}
     */
    List<FukaJohoRelateEntity> select賦課の情報リストBy主キー1(FukaJohoRelateMapperParameter 賦課の情報検索条件);
}
