/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.iryohikojokakuninsinsei;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.iryohikojokakuninsinsei.IryohiKojoUpdParameter;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.iryohikojokakuninsinsei.IIryoHiKojoKakuninSinseiMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * おむつ使用証明書画面のManagerです。
 *
 * @reamsid_L DBD-5780-010 tz_chengpeng
 */
public class IryoHiKojoKakuninSinseiManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public IryoHiKojoKakuninSinseiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * おむつ使用証明書画面ManagerのIntanceを作成します。
     *
     * @return IryoHiKojoKakuninSinseiManager
     */
    public static IryoHiKojoKakuninSinseiManager createInstance() {
        return InstanceProvider.create(IryoHiKojoKakuninSinseiManager.class);
    }

    /**
     * 医療費控除データの更新
     *
     * @param param
     */
    public void updateIryohikojyo(IryohiKojoUpdParameter param) {
        IIryoHiKojoKakuninSinseiMapper mapper = mapperProvider.create(IIryoHiKojoKakuninSinseiMapper.class);
        mapper.update医療費控除(param);
    }
}
