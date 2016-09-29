/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteishinseiinfoif;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd519001.NinteiShinseiJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;

/**
 * 介護認定申請情報を取得します。
 *
 * @reamsid_L DBD-1480-040 liuyl
 */
public interface INinteiShinseiJohoMapper {

    /**
     * 要介護認定申請情報を取得します。
     *
     * @param parameter NinteiShinseiJohoMybatisParameter
     * @return List<DbT4101NinteiShinseiJohoEntity>
     */
    List<DbT4101NinteiShinseiJohoEntity> select要介護認定申請情報(NinteiShinseiJohoMybatisParameter parameter);
}
