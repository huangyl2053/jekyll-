/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.iraijohodatatorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.iraijohodatatorikomi.IraiJohoDataTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.iraijohodatatorikomi.NinteiShinseiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.iraijohodatatorikomi.ShujiiIkenshoIraiJohoIkenItemRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.iraijohodatatorikomi.ShujiiIkenshoIraiJohoKinyuItemRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;

/**
 * 依頼情報データ受取（オルカ）のMapperクラスです。
 *
 * @reamsid_L DBE-1600-010 lishengli
 */
public interface IIraiJohoDataTorikomiMapper {

    /**
     * 要介護認定申請情報の取得する。
     *
     * @param parameter IraiJohoDataTorikomiParameter
     * @return List<NinteiShinseiJohoRelateEntity>
     */
    List<NinteiShinseiJohoRelateEntity> get要介護認定申請情報(IraiJohoDataTorikomiParameter parameter);

    /**
     * 要介護認定主治医意見書情報の取得する。
     *
     * @param parameter IraiJohoDataTorikomiParameter
     * @return DbT5302ShujiiIkenshoJohoEntity
     */
    DbT5302ShujiiIkenshoJohoEntity 要介護認定主治医意見書情報(IraiJohoDataTorikomiParameter parameter);

    /**
     * 要介護認定主治医意見書意見項目の取得する。
     *
     * @param parameter IraiJohoDataTorikomiParameter
     * @return List<ShujiiIkenshoIraiJohoIkenItemRelateEntity>
     */
    List<ShujiiIkenshoIraiJohoIkenItemRelateEntity> 要介護認定主治医意見書意見項目(IraiJohoDataTorikomiParameter parameter);

    /**
     * 要介護認定主治医意見書記入項目の取得する。
     *
     * @param parameter IraiJohoDataTorikomiParameter
     * @return List<ShujiiIkenshoIraiJohoKinyuItemRelateEntity>
     */
    List<ShujiiIkenshoIraiJohoKinyuItemRelateEntity> 要介護認定主治医意見書記入項目(IraiJohoDataTorikomiParameter parameter);

    /**
     * 主治医意見書依頼区分の取得する。
     *
     * @param parameter IraiJohoDataTorikomiParameter
     * @return DbT5302ShujiiIkenshoJohoEntity
     */
    DbT5302ShujiiIkenshoJohoEntity 主治医意見書依頼区分(IraiJohoDataTorikomiParameter parameter);

}
