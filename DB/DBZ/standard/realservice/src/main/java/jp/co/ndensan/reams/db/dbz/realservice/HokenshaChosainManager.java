/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.IChosainJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT4913ChosainJohoDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.db.dbz.business.HokenshaChosainJoho;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.IChosainJohoEntity;
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
public class HokenshaChosainManager extends ChosainManagerBase {

    private final DbT4913ChosainJohoDac dac;

    /**
     * コンストラクタです。
     *
     * 認定調査員情報を作成するインターフェースを生成します。
     *
     */
    public HokenshaChosainManager() {
        this.dac = InstanceProvider.create(DbT4913ChosainJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac 認定調査員情報Dac
     */
    HokenshaChosainManager(DbT4913ChosainJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 認定調情報を取得します。
     *
     * @return 調査員情報
     */
    @Override
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
    @Override
    public Optional<IChosainJoho> find調査員情報(LasdecCode 市町村コード, ChosaItakusakiCode 認定調査委託先コード, ChosainCode 認定調査員コード) {
        return dac.selectByKey(市町村コード, 認定調査委託先コード, 認定調査員コード)
                .map(new IFunction<DbT4913ChosainJohoEntity, IChosainJoho>() {
                    @Override
                    public IChosainJoho apply(DbT4913ChosainJohoEntity t) {
                        return new HokenshaChosainJoho(t);
                    }
                });
    }

    private ItemList<IChosainJoho> to調査員情報(ItemList<DbT4913ChosainJohoEntity> entityList) {

        ItemList<IChosainJoho> hokenshaChosainJohoList = ItemList.empty();
        for (DbT4913ChosainJohoEntity entity : entityList) {
            HokenshaChosainJoho hokenshaChosainJoho = new HokenshaChosainJoho(entity);
            hokenshaChosainJohoList.added(hokenshaChosainJoho);
        }

        return hokenshaChosainJohoList;
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
