/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenko;

import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 支払方法変更管理（画面）のビジネスクラスです。
 *
 * @reamsid_L DBD-3620-070 liangbc
 */
public class ShiharaiHohoHenkoService {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShiharaiHohoHenkoService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 支払方法変更管理（画面）のビジネスのIntanceを作成します。
     *
     * @return ShakaiFukushiHojinKeigenFinder
     */
    public static ShiharaiHohoHenkoService createIntance() {
        return InstanceProvider.create(ShiharaiHohoHenkoService.class);
    }

    public void find支払方法変更() {

    }

    public void find償還払い支給() {

    }

    public void save支払方法変更() {

    }
}
