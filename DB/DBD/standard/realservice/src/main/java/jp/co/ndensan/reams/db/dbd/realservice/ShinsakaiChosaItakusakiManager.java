/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.business.INinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbd.business.ShinsakaiNinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbd.entity.basic.INinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT5910NinteichosaItakusakiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;

/**
 * 認定調査委託先情報を作成するクラスです。
 *
 * @author n8223　朴義一
 */
public class ShinsakaiChosaItakusakiManager extends ChosaItakusakiManagerBase {

    private final DbT5910NinteichosaItakusakiJohoDac dac;

    /**
     * コンストラクタです。
     *
     * 認定調査委託先情報を作成するインターフェースを生成します。
     */
    public ShinsakaiChosaItakusakiManager() {
        this.dac = InstanceProvider.create(DbT5910NinteichosaItakusakiJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac 認定調査委託先情報Dac
     */
    ShinsakaiChosaItakusakiManager(DbT5910NinteichosaItakusakiJohoDac dac) {
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
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return 調査委託先情報
     */
    @Override
    public Optional<INinteichosaItakusakiJoho> find調査委託先情報(LasdecCode 市町村コード, ChosaItakusakiCode 認定調査委託先コード) {
        return dac.selectByKey(市町村コード, 認定調査委託先コード)
                .map(new IFunction<DbT5910NinteichosaItakusakiJohoEntity, INinteichosaItakusakiJoho>() {
                    @Override
                    public INinteichosaItakusakiJoho apply(DbT5910NinteichosaItakusakiJohoEntity t) {
                        return new ShinsakaiNinteichosaItakusakiJoho(t);
                    }
                });
    }

    private ItemList<INinteichosaItakusakiJoho> to調査委託先情報(ItemList<DbT5910NinteichosaItakusakiJohoEntity> entityList) {

        ItemList<INinteichosaItakusakiJoho> shinsakaiNinteichosaItakusakiJohList = ItemList.empty();

        for (DbT5910NinteichosaItakusakiJohoEntity entity : entityList) {
            ShinsakaiNinteichosaItakusakiJoho shinsakaiNinteichosaItakusakiJoho = new ShinsakaiNinteichosaItakusakiJoho(entity);
            shinsakaiNinteichosaItakusakiJohList.added(shinsakaiNinteichosaItakusakiJoho);
        }

        return shinsakaiNinteichosaItakusakiJohList;
    }

    /**
     * 調査委託先情報を更新します。
     *
     * @param 調査委託先情報 INinteichosaItakusakiJoho
     * @return 更新件数
     */
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
