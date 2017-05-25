/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ikenshoirai;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshoiraishokai.ShujiiIkenshoIraiParameter;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiikenshoiraishokai.IShujiiIkenshoIraiMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * @author n3509
 */
public class ShujiiIkenshoIraiManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShujiiIkenshoIraiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinnteiChousairaiShudouFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NinnteiChousairaiShudouFinder}のインスタンス
     */
    public static ShujiiIkenshoIraiManager createInstance() {
        return InstanceProvider.create(ShujiiIkenshoIraiManager.class);
    }

    /**
     * 最大認定調査依頼履歴番号を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return Max認定調査依頼履歴番号
     */
    @Transaction
    public boolean is再意見書(RString 申請書管理番号) {
        IShujiiIkenshoIraiMapper mapper = mapperProvider.create(IShujiiIkenshoIraiMapper.class);
        boolean result = mapper.is再意見書(ShujiiIkenshoIraiParameter.createParameter(申請書管理番号));
        return result;
    }
}
