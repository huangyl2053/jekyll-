/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteishinseiinfoif;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd519001.ModifyNinteiShinseiJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001.ModifyNinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4150RenrakusakiJohoEntity;

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
     * 介護連絡先情報を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return List<DbT4150RenrakusakiJohoEntity>
     */
    List<DbT4150RenrakusakiJohoEntity> select連絡先情報(ShinseishoKanriNo 申請書管理番号);

    /**
     * 申請情報IF厚労省を取得します。
     *
     * @return List<ModifyNinteiShinseiJohoEntity>
     */
    List<ModifyNinteiShinseiJohoEntity> select申請情報IF厚労省版();
}
