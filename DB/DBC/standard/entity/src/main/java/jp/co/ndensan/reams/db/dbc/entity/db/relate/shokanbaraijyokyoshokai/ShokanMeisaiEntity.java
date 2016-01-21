/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3039ShokanMeisaiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス提供証明書のオブジェクトクラスです。
 */
@lombok.Getter
@lombok.Setter
public class ShokanMeisaiEntity implements Cloneable, Serializable {

    private DbT3039ShokanMeisaiEntity entity;
    private RString serviceName;

    public ShokanMeisaiEntity() {
        entity = new DbT3039ShokanMeisaiEntity();
        serviceName = new RString("");
    }

    public void initializeMd5ToEntities() {
        entity.initializeMd5();
    }

}
