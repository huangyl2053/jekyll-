/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Value;

/**
 * 受領委任契約事業者の識別子です。
 */
@Value
public class JuryoininKeiyakuJigyoshaIdentifier implements Serializable {

    private final RString 事業者契約番号;
    private final FlexibleDate 開始年月日;

    /**
     * コンストラクタです。
     *
     * @param 事業者契約番号 事業者契約番号
     * @param 開始年月日 開始年月日
     */
    public JuryoininKeiyakuJigyoshaIdentifier(RString 事業者契約番号,
            FlexibleDate 開始年月日) {
        this.事業者契約番号 = 事業者契約番号;
        this.開始年月日 = 開始年月日;
    }
}
