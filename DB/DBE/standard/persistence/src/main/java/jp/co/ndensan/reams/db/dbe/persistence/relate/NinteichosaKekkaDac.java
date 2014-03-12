/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import jp.co.ndensan.reams.db.dbe.entity.relate.NinteichosaKekkaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteichosaKekkaJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteichosahyoJohoDac;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;

/**
 * 要介護認定調査結果のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaKekkaDac implements INinteichosaKekkaDac {

    private final INinteichosaKekkaJohoDac chosaKekkaDac = InstanceCreator.create(INinteichosaKekkaJohoDac.class);
    private final INinteichosahyoJohoDac chosahyoDac = InstanceCreator.create(INinteichosahyoJohoDac.class);

    public NinteichosaKekkaEntity select(RString 申請書管理番号, int 認定調査履歴番号) {
        NinteichosaKekkaEntity entity = new NinteichosaKekkaEntity();
        entity.setDbT5008NinteichosaKekkaJohoEntity(chosaKekkaDac.select(申請書管理番号, 認定調査履歴番号));
        entity.setDbT5009NinteichosahyoJohoEntity(chosahyoDac.select(申請書管理番号, 認定調査履歴番号));
        return entity;
    }

    public boolean insertOrUpdate(NinteichosaKekkaEntity entity) {
        return chosaKekkaDac.insertOrUpdate(entity.getDbT5008NinteichosaKekkaJohoEntity()) != 0
                && chosahyoDac.insertOrUpdate(entity.getDbT5009NinteichosahyoJohoEntity()) != 0;
    }

    public boolean insert(NinteichosaKekkaEntity entity) {
        return chosaKekkaDac.insert(entity.getDbT5008NinteichosaKekkaJohoEntity()) != 0
                && chosahyoDac.insert(entity.getDbT5009NinteichosahyoJohoEntity()) != 0;
    }

    public boolean update(NinteichosaKekkaEntity entity) {
        return chosaKekkaDac.update(entity.getDbT5008NinteichosaKekkaJohoEntity()) != 0
                && chosahyoDac.update(entity.getDbT5009NinteichosahyoJohoEntity()) != 0;
    }

    public boolean delete(NinteichosaKekkaEntity entity) {
        return chosaKekkaDac.delete(entity.getDbT5008NinteichosaKekkaJohoEntity()) != 0
                && chosahyoDac.delete(entity.getDbT5009NinteichosahyoJohoEntity()) != 0;
    }
}
