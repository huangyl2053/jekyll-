/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.business.IChosainJoho;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT5913ChosainJohoDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.db.dbd.business.ShinsakaiChosainJoho;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbd.entity.basic.IChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査員を作成するクラスです。
 *
 * @author n8223　朴義一
 */
public class ShinsakaiChosainManager extends ChosainManagerBase {

    private final DbT5913ChosainJohoDac dac;

    /**
     * コンストラクタです。
     *
     * 認定調査員情報を作成するインターフェースを生成します。
     *
     */
    public ShinsakaiChosainManager() {
        this.dac = InstanceProvider.create(DbT5913ChosainJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac 認定調査員情報Dac
     */
    ShinsakaiChosainManager(DbT5913ChosainJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 認定調情報を取得します。
     *
     * @return 調査員情報
     */
    public ItemList<IChosainJoho> find調査員情報() {
        return to調査員情報(dac.selectAll());
    }

    /**
     * 認定調情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @return 認定調情報
     */
    public Optional<IChosainJoho> find調査員情報(LasdecCode 市町村コード, ChosaItakusakiCode 認定調査委託先コード, ChosainCode 認定調査員コード) {
        return dac.selectByKey(市町村コード, 認定調査委託先コード, 認定調査員コード)
                .map(new IFunction<DbT5913ChosainJohoEntity, IChosainJoho>() {
                    @Override
                    public IChosainJoho apply(DbT5913ChosainJohoEntity t) {
                        return new ShinsakaiChosainJoho(t);
                    }
                });
    }

    private ItemList<IChosainJoho> to調査員情報(ItemList<DbT5913ChosainJohoEntity> entityList) {

        ItemList<IChosainJoho> shinsakaiChosainJohoList = ItemList.empty();
        for (DbT5913ChosainJohoEntity entity : entityList) {
            ShinsakaiChosainJoho shinsakaiChosainJoho = new ShinsakaiChosainJoho(entity);
            shinsakaiChosainJohoList.added(shinsakaiChosainJoho);
        }

        return shinsakaiChosainJohoList;
    }

    /**
     * 調査員情報を登録します。
     *
     * @param 調査員情報 IChosainJoho
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save調査員(IChosainJoho 調査員情報) {
        IChosainJohoEntity entity = 調査員情報.getEntity();

        switch (調査員情報.getState()) {
            case Added:
                return dac.insert(entity);
            case Modified:
                return dac.update(entity);
            case Deleted:
                return dac.delete(entity);
            default:
                return 0;
        }
    }

}
