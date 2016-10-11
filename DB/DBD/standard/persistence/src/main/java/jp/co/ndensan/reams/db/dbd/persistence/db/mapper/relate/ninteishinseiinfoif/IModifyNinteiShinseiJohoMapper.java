/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteishinseiinfoif;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd519001.ModifyNinteiShinseiJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001.ModifyNinteiShinseiJohoEntity;

/**
 * 申請情報IFを取得します。
 *
 * @reamsid_L DBD-1480-040 liuyl
 */
public interface IModifyNinteiShinseiJohoMapper {

    /**
     * 申請情報IF電算標準版を取得します。
     *
     * @param parameter ModifyNinteiShinseiJohoMybatisParameter
     * @return List<ModifyNinteiShinseiJohoEntity>
     */
    List<ModifyNinteiShinseiJohoEntity> select申請情報IF電算標準版(ModifyNinteiShinseiJohoMybatisParameter parameter);

    /**
     * 申請情報IF厚労省を取得します。
     *
     * @param parameter ModifyNinteiShinseiJohoMybatisParameter
     * @return List<ModifyNinteiShinseiJohoEntity>
     */
    List<ModifyNinteiShinseiJohoEntity> select申請情報IF厚労省版(ModifyNinteiShinseiJohoMybatisParameter parameter);
}
