/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.IShujii;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiJokyo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7012ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.ShujiiMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IShujiiDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 主治医情報を管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiManager implements IShujiiManager {

    private final IShujiiDac dac;

    /**
     * InstanceCreatorを用いてDacのインスタンスを生成し、メンバ変数に保持します。
     */
    public ShujiiManager() {
        dac = InstanceProvider.create(IShujiiDac.class);
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param dac モック主治医情報Dac
     */
    ShujiiManager(IShujiiDac dac) {
        this.dac = dac;
    }

    @Override
    public boolean save(IShujii 主治医情報) {
        return dac.insertOrUpdate(ShujiiMapper.toEntity(主治医情報)) != 0;
    }

    @Override
    public boolean saveAs有効(IShujii 主治医情報) {
        DbT7012ShujiiJohoEntity entity = ShujiiMapper.toEntity(主治医情報);
        entity.setShujiiJokyo(IshiJokyo.有効.getCode());
        return dac.insertOrUpdate(entity) != 0;
    }

    @Override
    public boolean saveAs無効(IShujii 主治医情報) {
        DbT7012ShujiiJohoEntity entity = ShujiiMapper.toEntity(主治医情報);
        entity.setShujiiJokyo(IshiJokyo.無効.getCode());
        return dac.insertOrUpdate(entity) != 0;
    }

    @Override
    public boolean saveAsNew(IShujii 主治医情報) {
        return dac.insert(ShujiiMapper.toEntity(主治医情報)) != 0;
    }

    @Override
    public boolean remove(IShujii 主治医情報) {
        return dac.delete(ShujiiMapper.toEntity(主治医情報)) != 0;
    }
}
