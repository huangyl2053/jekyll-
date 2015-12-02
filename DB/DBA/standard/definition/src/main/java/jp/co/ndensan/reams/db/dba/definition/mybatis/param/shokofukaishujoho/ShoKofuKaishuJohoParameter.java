/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatis.param.shokofukaishujoho;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 証交付回収情報の取得するクラスです。
 */
public class ShoKofuKaishuJohoParameter {

    public RString state;
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
     * @param kofuYMD
     * @param yukoKigenYMD
     * @param kofuJiyu
     * @param kofuRiyu
     * @param kaishuYMD
     * @param kaishuJiyu
     * @param kaishuRiyu
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

    /**
     * DbT7037ShoKofuKaishuEntityを返します。
     *
     * @param entity
     * @return DbT7037ShoKofuKaishuEntity
     */
    public DbT7037ShoKofuKaishuEntity toDbT7037ShoKofuKaishuEntity(DbT7037ShoKofuKaishuEntity entity) {
        entity.setKofuYMD(kofuYMD);
        entity.setYukoKigenYMD(yukoKigenYMD);
        entity.setKofuJiyu(kofuJiyu);
        entity.setKofuRiyu(kofuRiyu);
        entity.setKaishuYMD(kaishuYMD);
        entity.setKaishuJiyu(kaishuJiyu);
        entity.setKaishuRiyu(kaishuRiyu);
        return entity;
    }

    public RString getState() {
        return state;
    }

    public FlexibleDate getKofuYMD() {
        return kofuYMD;
    }

    public FlexibleDate getYukoKigenYMD() {
        return yukoKigenYMD;
    }

    public RString getKofuJiyu() {
        return kofuJiyu;
    }

    public RString getKofuRiyu() {
        return kofuRiyu;
    }

    public FlexibleDate getKaishuYMD() {
        return kaishuYMD;
    }

    public RString getKaishuJiyu() {
        return kaishuJiyu;
    }

    public RString getKaishuRiyu() {
        return kaishuRiyu;
    }

}
