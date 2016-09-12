/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.masking.MaskingParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5305IkenshoImageJohoEntity;

/**
 *
 * @author LDNS chenty
 */
public interface IDbT5305IkenshoImageJohoMapper {

    /**
     * {@link  DbT5305IkenshoImageJohoEntity}を取得します。
     *
     * @return {@link  DbT5305IkenshoImageJohoEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT5305IkenshoImageJohoEntity getEntity();

    /**
     * イメージ情報数の取得する。
     *
     * @param parameter MaskingParameter
     * @return イメージ情報数
     */
    int getイメージ情報数(MaskingParameter parameter);
}
