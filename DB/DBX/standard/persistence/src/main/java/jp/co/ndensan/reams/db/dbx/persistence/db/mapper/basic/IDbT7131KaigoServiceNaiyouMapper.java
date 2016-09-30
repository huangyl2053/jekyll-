/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.servicecode.SabisuKodoParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;

/**
 *
 * @author LDNS 燕京
 */
public interface IDbT7131KaigoServiceNaiyouMapper {

    /**
     * {@link DbT7131KaigoServiceNaiyouEntity}を取得します。
     *
     * @return {@link DbT7131KaigoServiceNaiyouEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT7131KaigoServiceNaiyouEntity getEntity();

    /**
     * サービスコード取得します。
     *
     * @param param SabisuKodoParameter
     * @return List<DbT7131KaigoServiceNaiyouEntity>
     */
    List<DbT7131KaigoServiceNaiyouEntity> getKaigoServiceNaiyou(SabisuKodoParameter param);

    /**
     * サービスコード取得3を取得します。
     *
     * @param param SabisuKodoParameter
     * @return List<DbT7131KaigoServiceNaiyouEntity>
     */
    List<DbT7131KaigoServiceNaiyouEntity> getServiceCodeList3(SabisuKodoParameter param);

    /**
     * サービスコード取得4を取得します。
     *
     * @param param SabisuKodoParameter
     * @return List<DbT7131KaigoServiceNaiyouEntity>
     */
    List<DbT7131KaigoServiceNaiyouEntity> getServiceCodeList4(SabisuKodoParameter param);

}
