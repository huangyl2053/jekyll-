/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.common;

import jp.co.ndensan.reams.db.dbb.business.shiharaihohohenko.ShiharaiHohoHenkoSummary;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 支払方法変更概況管理するクラスです。
 */
public class ShiharaiHohoHenkoSummaryBusiness {

    private final ShiharaiHohoHenkoSummary 支払方法変更概況;

    /**
     * 支払方法変更概況を返します。
     *
     * @param 支払方法変更概況 支払方法変更概況
     */
    public ShiharaiHohoHenkoSummaryBusiness(ShiharaiHohoHenkoSummary 支払方法変更概況) {
        this.支払方法変更概況 = 支払方法変更概況;
    }

    /**
     * 支払方法変更_登録区分を返します。
     *
     * @return 支払方法変更_登録区分
     */
    public ShiharaiHenkoTorokuKubun get支払方法変更_登録区分() {
        return 支払方法変更概況.get支払方法変更_登録区分();
    }

    /**
     * 給付額減額_登録区分を返します。
     *
     * @return 給付額減額_登録区分
     */
    public ShiharaiHenkoTorokuKubun get給付額減額_登録区分() {
        return 支払方法変更概況.get給付額減額_登録区分();
    }

    /**
     * 支払方法変更_開始日を返します。
     *
     * @return 支払方法変更_開始日
     */
    public FlexibleDate get支払方法変更_開始日() {
        return 支払方法変更概況.get支払方法変更_開始日();
    }

    /**
     * 支払方法変更_終了日を返します。
     *
     * @return 支払方法変更_終了日
     */
    public FlexibleDate get支払方法変更_終了日() {
        return 支払方法変更概況.get支払方法変更_終了日();
    }

    /**
     * 給付額減額_開始日を返します。
     *
     * @return 給付額減額_開始日
     */
    public FlexibleDate get給付額減額_開始日() {
        return 支払方法変更概況.get給付額減額_開始日();
    }

    /**
     * 給付額減額_終了日を返します。
     *
     * @return 給付額減額_終了日
     */
    public FlexibleDate get給付額減額_終了日() {
        return 支払方法変更概況.get給付額減額_終了日();
    }

}
