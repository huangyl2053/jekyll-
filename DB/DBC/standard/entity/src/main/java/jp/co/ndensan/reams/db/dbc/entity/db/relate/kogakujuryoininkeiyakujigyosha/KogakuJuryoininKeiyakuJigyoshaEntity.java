/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakujuryoininkeiyakujigyosha;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3076KogakuJuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費等受領委任払情報管理のEntityです。
 *
 * @reamsid_L DBC-1980-010 yuqingzhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuJuryoininKeiyakuJigyoshaEntity implements Serializable {

    private DbT3076KogakuJuryoininKeiyakuJigyoshaEntity kogakuJuryoininKeiyakuJigyoshaEntity;
    private RString jigyoshaNo;
    private RString jigyoshaName;

    /**
     * MD5初期化します。
     */
    public void initMd5() {
        if (kogakuJuryoininKeiyakuJigyoshaEntity != null) {
            kogakuJuryoininKeiyakuJigyoshaEntity.initializeMd5();
        }
    }
}
