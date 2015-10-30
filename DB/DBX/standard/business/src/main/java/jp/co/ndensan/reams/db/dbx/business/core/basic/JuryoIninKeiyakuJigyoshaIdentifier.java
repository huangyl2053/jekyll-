/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Value;

/**
 * 受領委任契約事業者の識別子です。
 */
@Value
public class JuryoIninKeiyakuJigyoshaIdentifier implements Serializable {

    private final KaigoJigyoshaNo 受領委任契約事業者番号;
    private final FlexibleDate 受領委任契約開始日;
    private final RString 契約サービス種別;

    /**
     * コンストラクタです。
     *
     * @param 受領委任契約事業者番号 受領委任契約事業者番号
     * @param 受領委任契約開始日 受領委任契約開始日
     * @param 契約サービス種別 契約サービス種別
     */
    public JuryoIninKeiyakuJigyoshaIdentifier(KaigoJigyoshaNo 受領委任契約事業者番号,
            FlexibleDate 受領委任契約開始日,
            RString 契約サービス種別) {
        this.受領委任契約事業者番号 = 受領委任契約事業者番号;
        this.受領委任契約開始日 = 受領委任契約開始日;
        this.契約サービス種別 = 契約サービス種別;
    }

}
