/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakujuryoininkeiyakujigyosha;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuJuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3076KogakuJuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費等受領委任払情報管理のResultです。
 *
 * @reamsid_L DBC-1980-010 yuqingzhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuJuryoininKeiyakuJigyoshaResult implements Serializable {

    private KogakuJuryoininKeiyakuJigyosha kogakuJuryoininKeiyakuJigyosha;
    private RString 所属事業者番号;
    private RString 事業者名称;

    /**
     * コンストラクタです。
     *
     * @param kogakuJuryoininKeiyakuJigyosha KogakuJuryoininKeiyakuJigyosha
     * @param 所属事業者番号 RString
     * @param 事業者名称 RString
     */
    public KogakuJuryoininKeiyakuJigyoshaResult(KogakuJuryoininKeiyakuJigyosha kogakuJuryoininKeiyakuJigyosha, RString 所属事業者番号, RString 事業者名称) {
        this.kogakuJuryoininKeiyakuJigyosha = kogakuJuryoininKeiyakuJigyosha;
        this.所属事業者番号 = 所属事業者番号;
        this.事業者名称 = 事業者名称;
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3076KogakuJuryoininKeiyakuJigyoshaEntity
     * @param 所属事業者番号 RString
     * @param 事業者名称 RString
     */
    public KogakuJuryoininKeiyakuJigyoshaResult(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity, RString 所属事業者番号,
            RString 事業者名称) {
        this.kogakuJuryoininKeiyakuJigyosha = new KogakuJuryoininKeiyakuJigyosha(entity);
        this.所属事業者番号 = 所属事業者番号;
        this.事業者名称 = 事業者名称;
    }
}
