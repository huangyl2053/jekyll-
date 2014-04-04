/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.relate.NinteichosaKekkaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.NinteichosahyoJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.NinteichosaKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定調査結果のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaKekkaDac implements IReplaceable<NinteichosaKekkaEntity>, IDeletable<NinteichosaKekkaEntity> {

    private final NinteichosaKekkaJohoDac chosaKekkaDac = InstanceProvider.create(NinteichosaKekkaJohoDac.class);
    private final NinteichosahyoJohoDac chosahyoDac = InstanceProvider.create(NinteichosahyoJohoDac.class);

    @Transaction
    public NinteichosaKekkaEntity select(ShinseishoKanriNo 申請書管理番号, NinteichosaIraiRirekiNo 認定調査履歴番号) {
        NinteichosaKekkaEntity entity = new NinteichosaKekkaEntity();
        entity.setDbT5008NinteichosaKekkaJohoEntity(chosaKekkaDac.select(申請書管理番号, 認定調査履歴番号));
        entity.setDbT5009NinteichosahyoJohoEntity(chosahyoDac.select(申請書管理番号, 認定調査履歴番号));
        return entity;
    }

    @Override
    @Transaction
    public int insertOrUpdate(NinteichosaKekkaEntity entity) {
        return chosaKekkaDac.insertOrUpdate(entity.getDbT5008NinteichosaKekkaJohoEntity())
                & chosahyoDac.insertOrUpdate(entity.getDbT5009NinteichosahyoJohoEntity());
    }

    @Override
    @Transaction
    public int insert(NinteichosaKekkaEntity entity) {
        return chosaKekkaDac.insert(entity.getDbT5008NinteichosaKekkaJohoEntity())
                & chosahyoDac.insert(entity.getDbT5009NinteichosahyoJohoEntity());
    }

    @Override
    @Transaction
    public int update(NinteichosaKekkaEntity entity) {
        return chosaKekkaDac.update(entity.getDbT5008NinteichosaKekkaJohoEntity())
                & chosahyoDac.update(entity.getDbT5009NinteichosahyoJohoEntity());
    }

    @Override
    @Transaction
    public int delete(NinteichosaKekkaEntity entity) {
        return chosaKekkaDac.delete(entity.getDbT5008NinteichosaKekkaJohoEntity())
                & chosahyoDac.delete(entity.getDbT5009NinteichosahyoJohoEntity());
    }
}
