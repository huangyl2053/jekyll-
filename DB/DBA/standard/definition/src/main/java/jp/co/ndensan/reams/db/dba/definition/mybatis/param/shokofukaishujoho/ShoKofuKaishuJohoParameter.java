/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatis.param.shokofukaishujoho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 証交付回収情報の取得するクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShoKofuKaishuJohoParameter {

    private final FlexibleDate kofuYMD;
    private final FlexibleDate yukoKigenYMD;
    private final RString kofuJiyu;
    private final RString kofuRiyu;
    private final FlexibleDate kaishuYMD;
    private final RString kaishuJiyu;
    private final RString kaishuRiyu;

    private ShoKofuKaishuJohoParameter(
            FlexibleDate kofuYMD,
            FlexibleDate yukoKigenYMD,
            RString kofuJiyu,
            RString kofuRiyu,
            FlexibleDate kaishuYMD,
            RString kaishuJiyu,
            RString kaishuRiyu) {
        this.kofuYMD = kofuYMD;
        this.yukoKigenYMD = yukoKigenYMD;
        this.kofuJiyu = kofuJiyu;
        this.kofuRiyu = kofuRiyu;
        this.kaishuYMD = kaishuYMD;
        this.kaishuJiyu = kaishuJiyu;
        this.kaishuRiyu = kaishuRiyu;
    }

    /**
     * 登録処理取得パラメータ設定
     *
     * @param kofuYMD FlexibleDate
     * @param yukoKigenYMD FlexibleDate
     * @param kofuJiyu RString
     * @param kofuRiyu RString
     * @param kaishuYMD FlexibleDate
     * @param kaishuJiyu RString
     * @param kaishuRiyu RString
     * @return createParam_common
     */
    public static ShoKofuKaishuJohoParameter createParam_update(
            FlexibleDate kofuYMD,
            FlexibleDate yukoKigenYMD,
            RString kofuJiyu,
            RString kofuRiyu,
            FlexibleDate kaishuYMD,
            RString kaishuJiyu,
            RString kaishuRiyu) {
        return new ShoKofuKaishuJohoParameter(
                kofuYMD,
                yukoKigenYMD,
                kofuJiyu,
                kofuRiyu,
                kaishuYMD,
                kaishuJiyu,
                kaishuRiyu
        );
    }
}
