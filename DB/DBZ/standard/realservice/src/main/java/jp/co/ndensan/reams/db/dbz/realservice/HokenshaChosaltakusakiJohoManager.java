/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.HokenshaNinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.INinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.INinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT4910NinteichosaItakusakiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査委託先情報を作成するクラスです。
 *
 * @author n8223　朴義一
 */
public class HokenshaChosaltakusakiJohoManager extends ChosaItakusakiManagerBase {

    private final DbT4910NinteichosaItakusakiJohoDac dac;

    /**
     * コンストラクタです。
     *
     * 認定調査委託先情報を作成するインターフェースを生成します。
     */
    public HokenshaChosaltakusakiJohoManager() {
        this.dac = InstanceProvider.create(DbT4910NinteichosaItakusakiJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac 認定調査委託先情報Dac
     */
    HokenshaChosaltakusakiJohoManager(DbT4910NinteichosaItakusakiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 調査委託先情報を取得します。
     *
     * @return 調査委託先情報
     */
    @Override
    public ItemList<INinteichosaItakusakiJoho> find調査委託先情報() {
        return to調査委託先情報(dac.selectAll());
    }

    /**
     * 調査委託先情報を取得します。
     *
     * @param 市町村コード LasdecCode
     * @param 認定調査委託先コード ChosaItakusakiCode
     * @return 調査委託先情報
     */
    @Override
    public Optional<INinteichosaItakusakiJoho> find調査委託先情報(LasdecCode 市町村コード, ChosaItakusakiCode 認定調査委託先コード) {
        return dac.selectByKey(市町村コード, 認定調査委託先コード)
                .map(new IFunction<DbT4910NinteichosaItakusakiJohoEntity, INinteichosaItakusakiJoho>() {
                    @Override
                    public INinteichosaItakusakiJoho apply(DbT4910NinteichosaItakusakiJohoEntity t) {
                        return new HokenshaNinteichosaItakusakiJoho(t);
                    }
                });
    }

    private ItemList<INinteichosaItakusakiJoho> to調査委託先情報(ItemList<DbT4910NinteichosaItakusakiJohoEntity> entityList) {

        ItemList<INinteichosaItakusakiJoho> hokenshaNinteichosaItakusakiJohonList = ItemList.empty();

        for (DbT4910NinteichosaItakusakiJohoEntity entity : entityList) {
            HokenshaNinteichosaItakusakiJoho hokenshaNinteichosaItakusakiJoho = new HokenshaNinteichosaItakusakiJoho(entity);
            hokenshaNinteichosaItakusakiJohonList.added(hokenshaNinteichosaItakusakiJoho);
        }

        return hokenshaNinteichosaItakusakiJohonList;
    }

    /**
     * 調査委託先情報を登録します。
     *
     * @param 調査委託先情報 INinteichosaItakusakiJoho
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save調査委託先(INinteichosaItakusakiJoho 調査委託先情報) {

        INinteichosaItakusakiJohoEntity entity = 調査委託先情報.getEntity();

        switch (調査委託先情報.getState()) {
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
