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
 *
 * @author Administrator
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
