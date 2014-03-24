/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShujiiIkenshoRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.relate.ShujiiIkenshoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShujiiIkenshoJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShujiiIkenshoShosaiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 主治医意見書のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoDac implements IShujiiIkenshoDac {

    private final ShujiiIkenshoJohoDac ikenshoDac = InstanceProvider.create(ShujiiIkenshoJohoDac.class);
    private final ShujiiIkenshoShosaiJohoDac shosaiDac = InstanceProvider.create(ShujiiIkenshoShosaiJohoDac.class);

    @Override
    public ShujiiIkenshoEntity select(ShinseishoKanriNo 申請書管理番号, ShujiiIkenshoRirekiNo 意見書履歴番号) {
        ShujiiIkenshoEntity entity = new ShujiiIkenshoEntity();
        entity.setDbT5012ShujiiIkenshoJohoEntity(ikenshoDac.select(申請書管理番号, 意見書履歴番号));
        entity.setDbT5013ShujiiIkenshoShosaiJohoEntity(shosaiDac.select(申請書管理番号, 意見書履歴番号));
        return entity;
    }

    @Override
    public boolean insertOrUpdate(ShujiiIkenshoEntity entity) {
        return ikenshoDac.insertOrUpdate(entity.getDbT5012ShujiiIkenshoJohoEntity()) != 0
                && shosaiDac.insertOrUpdate(entity.getDbT5013ShujiiIkenshoShosaiJohoEntity()) != 0;
    }

    @Override
    public boolean insert(ShujiiIkenshoEntity entity) {
        return ikenshoDac.insert(entity.getDbT5012ShujiiIkenshoJohoEntity()) != 0
                && shosaiDac.insert(entity.getDbT5013ShujiiIkenshoShosaiJohoEntity()) != 0;
    }

    @Override
    public boolean update(ShujiiIkenshoEntity entity) {
        return ikenshoDac.update(entity.getDbT5012ShujiiIkenshoJohoEntity()) != 0
                && shosaiDac.update(entity.getDbT5013ShujiiIkenshoShosaiJohoEntity()) != 0;
    }

    @Override
    public boolean delete(ShujiiIkenshoEntity entity) {
        return ikenshoDac.delete(entity.getDbT5012ShujiiIkenshoJohoEntity()) != 0
                && shosaiDac.delete(entity.getDbT5013ShujiiIkenshoShosaiJohoEntity()) != 0;
    }
}
