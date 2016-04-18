/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 賦課の情報。
 *
 * @reamsid_L DBB-0740-010 wangkanglei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaInfo implements Serializable {

    private DbT2002FukaEntity 介護賦課;
    private Decimal 特徴期別金額01;
    private Decimal 特徴期別金額02;
    private Decimal 特徴期別金額03;
    private Decimal 特徴期別金額04;
    private Decimal 特徴期別金額05;
    private Decimal 特徴期別金額06;
    private Decimal 普徴期別金額01;
    private Decimal 普徴期別金額02;
    private Decimal 普徴期別金額03;
    private Decimal 普徴期別金額04;
    private Decimal 普徴期別金額05;
    private Decimal 普徴期別金額06;
    private Decimal 普徴期別金額07;
    private Decimal 普徴期別金額08;
    private Decimal 普徴期別金額09;
    private Decimal 普徴期別金額10;
    private Decimal 普徴期別金額11;
    private Decimal 普徴期別金額12;
    private Decimal 普徴期別金額13;
    private Decimal 普徴期別金額14;

    /**
     * FukaInfo。
     *
     * @return FukaInfo
     */
    public FukaInfo getFukaInfo() {
        this.介護賦課 = getDBT();
        this.特徴期別金額01 = new Decimal(1);
        this.普徴期別金額01 = new Decimal(1);
        return this;
    }

    private DbT2002FukaEntity getDBT() {
        DbT2002FukaEntity entity = new DbT2002FukaEntity();
        entity.setChoteiNendo(new FlexibleYear("2016"));
        entity.setFukaNendo(new FlexibleYear("2015"));
        entity.setChoteiNichiji(new YMDHMS("20160416161233"));
        return entity;
    }
}
