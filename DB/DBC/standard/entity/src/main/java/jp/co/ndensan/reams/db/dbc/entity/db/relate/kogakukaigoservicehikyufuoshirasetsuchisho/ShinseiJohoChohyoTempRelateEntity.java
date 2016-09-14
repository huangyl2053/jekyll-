/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請情報帳票発行一時関連のエンティティクラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
@lombok.Getter
@lombok.Setter
public class ShinseiJohoChohyoTempRelateEntity {

    private ShinseiJohoChohyoTempEntity 申請情報;
    private UaFt250FindAtesakiEntity 宛先;
    private RString 市町村名称;

    /**
     * コンストラクタです。
     */
    public ShinseiJohoChohyoTempRelateEntity() {
        this.申請情報 = new ShinseiJohoChohyoTempEntity();
        this.宛先 = new UaFt250FindAtesakiEntity();
    }

}
