/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Value;

/**
 * 償還受領委任契約者の識別子です。
 */
@Value
public class ShokanJuryoininKeiyakushaIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleDate 申請年月日;
    private final RString 契約事業者番号;
    private final RString 契約サービス種類;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 申請年月日 申請年月日
     * @param 契約事業者番号 契約事業者番号
     * @param 契約サービス種類 契約サービス種類
     */
    public ShokanJuryoininKeiyakushaIdentifier(HihokenshaNo 被保険者番号,
            FlexibleDate 申請年月日,
            RString 契約事業者番号,
            RString 契約サービス種類
    ) {
        this.被保険者番号 = 被保険者番号;
        this.申請年月日 = 申請年月日;
        this.契約事業者番号 = 契約事業者番号;
        this.契約サービス種類 = 契約サービス種類;
    }
}
