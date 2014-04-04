/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.IShujiiIryoKikan;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.ShujiiIryoKikanMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IShuJiiIryoKikanDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 主治医医療機関の情報を扱うクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShujiiIryoKikanManager implements IShujiiIryoKikanManager {

    private final IShuJiiIryoKikanDac dac;

    /**
     * デフォルトコンストラクタです。
     */
    public ShujiiIryoKikanManager() {
        dac = InstanceProvider.create(IShuJiiIryoKikanDac.class);
    }

    /**
     * 引数からDACを受け取る、テスト用プライベートコンストラクタです。
     *
     * @param dac テスト用DAC
     */
    ShujiiIryoKikanManager(IShuJiiIryoKikanDac dac) {
        this.dac = dac;
    }

    @Override
    public boolean save(IShujiiIryoKikan 主治医医療機関) {
        DbT7011ShujiiIryoKikanJohoEntity entity = ShujiiIryoKikanMapper.toShujiiIryoKikanEntity(主治医医療機関);
        return is更新成功(dac.insertOrUpdate(entity));
    }

    @Override
    public boolean remove(IShujiiIryoKikan 主治医医療機関) {
        DbT7011ShujiiIryoKikanJohoEntity entity = ShujiiIryoKikanMapper.toShujiiIryoKikanEntity(主治医医療機関);
        return is更新成功(dac.delete(entity));
    }

    @Override
    public boolean saveAs有効(IShujiiIryoKikan 主治医医療機関) {
        DbT7011ShujiiIryoKikanJohoEntity entity =
                ShujiiIryoKikanMapper.toShujiiIryoKikanEntity(主治医医療機関, IryoKikanJokyo.有効);
        return is更新成功(dac.insertOrUpdate(entity));
    }

    @Override
    public boolean saveAs無効(IShujiiIryoKikan 主治医医療機関) {
        DbT7011ShujiiIryoKikanJohoEntity entity =
                ShujiiIryoKikanMapper.toShujiiIryoKikanEntity(主治医医療機関, IryoKikanJokyo.無効);
        return is更新成功(dac.insertOrUpdate(entity));
    }

    private boolean is更新成功(int 更新件数) {
        return 更新件数 == 1 ? true : false;
    }
}
