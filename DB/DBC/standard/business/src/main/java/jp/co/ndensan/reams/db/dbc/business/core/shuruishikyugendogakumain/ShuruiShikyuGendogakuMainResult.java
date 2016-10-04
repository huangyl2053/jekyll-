/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shuruishikyugendogakumain;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7111ServiceShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shuruishikyugendogakumain.ShuruiShikyuGendogakuMainEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;

/**
 * DBC4210011_種類支給限度額登録のクラスです。
 *
 * @reamsid_L DBC-3440-010 lihang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShuruiShikyuGendogakuMainResult implements Serializable {

    private ShuruiShikyuGendogakuMainEntity entity;
    private DbT7130KaigoServiceShuruiEntity dbT7130entity;
    private DbT7111ServiceShuruiShikyuGendoGakuEntity dbT7111entity;

    /**
     * コンストラクタです。
     *
     * @param entity ShuruiShikyuGendogakuMainEntity
     */
    public ShuruiShikyuGendogakuMainResult(ShuruiShikyuGendogakuMainEntity entity) {
        this.entity = entity;
    }

    /**
     * コンストラクタです。
     *
     * @param dbT7130entity DbT7130KaigoServiceShuruiEntity
     */
    public ShuruiShikyuGendogakuMainResult(DbT7130KaigoServiceShuruiEntity dbT7130entity) {
        this.dbT7130entity = dbT7130entity;
    }

    /**
     * コンストラクタです。
     *
     * @param dbT7111entity DbT7111ServiceShuruiShikyuGendoGakuEntity
     */
    public ShuruiShikyuGendogakuMainResult(DbT7111ServiceShuruiShikyuGendoGakuEntity dbT7111entity) {
        this.dbT7111entity = dbT7111entity;
    }
}
