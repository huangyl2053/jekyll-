/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jukyushateiseirenrakuhyotorokumanager;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * ビジネス設計_DBCMN81002_受給者訂正連絡票登録（画面）
 *
 * @reamsid_L DBC-2101-030 quxiaodong
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaTeiseiRenrakuhyoTorokuManagerParameter {

    private final FlexibleDate 異動年月日;
    private final HihokenshaNo 被保険者番号;

    /**
     * コンストラクタです
     *
     * @param 異動年月日 FlexibleDate
     * @param 被保険者番号 HihokenshaNo
     */
    public JukyushaTeiseiRenrakuhyoTorokuManagerParameter(
            FlexibleDate 異動年月日,
            HihokenshaNo 被保険者番号) {
        this.異動年月日 = 異動年月日;
        this.被保険者番号 = 被保険者番号;
    }

}
