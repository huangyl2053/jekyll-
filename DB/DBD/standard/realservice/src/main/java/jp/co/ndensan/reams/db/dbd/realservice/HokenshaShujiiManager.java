/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbd.business.HokenshaShujiiJoho;
import jp.co.ndensan.reams.db.dbd.business.IShujiiJoho;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4912ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT4912ShujiiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定用(DBE)の主治医を管理するクラスです。
 *
 * @author N8235 船山 洋介
 */
public class HokenshaShujiiManager extends ShujiiManagerBase {

    private final DbT4912ShujiiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public HokenshaShujiiManager() {
        this.dac = InstanceProvider.create(DbT4912ShujiiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     */
    HokenshaShujiiManager(DbT4912ShujiiJohoDac dac) {
        this.dac = dac;
    }

    @Override
    public Optional<IShujiiJoho> find主治医(LasdecCode 市町村コード, ShujiiIryokikanCode 主治医医療機関コード, ShujiiCode 主治医コード) {
        return dac.selectByKey(市町村コード, 主治医医療機関コード, 主治医コード).map(new IFunction<DbT4912ShujiiJohoEntity, IShujiiJoho>() {
            @Override
            public IShujiiJoho apply(DbT4912ShujiiJohoEntity t) {
                return new HokenshaShujiiJoho(t);
            }
        });
    }

    @Override
    public ItemList<IShujiiJoho> getAll主治医() {

        return to主治医List(dac.selectAll());
    }

    private ItemList<IShujiiJoho> to主治医List(ItemList<DbT4912ShujiiJohoEntity> entityList) {

        ItemList<IShujiiJoho> hihokenshaShujiiList = ItemList.empty();

        for (DbT4912ShujiiJohoEntity entity : entityList) {
            HokenshaShujiiJoho hihokenshaShujiiJoho = new HokenshaShujiiJoho(entity);
            hihokenshaShujiiList.added(hihokenshaShujiiJoho);
        }

        return hihokenshaShujiiList;
    }

    /**
     * 主治医医療機関情報を登録します。
     *
     * @param 主治医機関情報 RankJohoModel
     * @return 登録件数
     */
    public int save主治医機関情報(IShujiiJoho 主治医機関情報) {

        if (主治医機関情報.getState() == EntityDataState.Added) {
            return dac.insert(主治医機関情報.getEntity());
        } else if (主治医機関情報.getState() == EntityDataState.Modified) {
            return dac.update(主治医機関情報.getEntity());
        } else if (主治医機関情報.getState() == EntityDataState.Deleted) {
            return dac.delete(主治医機関情報.getEntity());
        }

        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }

}
