/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyuufuseigennrirekijyoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * KyuufuSeigennRirekiJyoho_給付制限履歴情報 Entityのクラスです。
 *
 * @reamsid_L DBC-4350-100 liuxiaoyu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyuufuSeigennRirekiJyohoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private HihokenshaNo 被保険者番号;
    private RString 管理区分;
    private RString 登録区分;
    private FlexibleDate 適用開始年月日;
    private FlexibleDate 適用終了年月日;
    private RString 終了区分;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 管理区分 RString
     * @param 登録区分 RString
     * @param 適用開始年月日 TextBoxFlexibleDate
     * @param 適用終了年月日 TextBoxFlexibleDate
     * @param 終了区分 RString
     */
    public KyuufuSeigennRirekiJyohoEntity(
            HihokenshaNo 被保険者番号,
            RString 管理区分,
            RString 登録区分,
            FlexibleDate 適用開始年月日,
            FlexibleDate 適用終了年月日,
            RString 終了区分) {
        this.被保険者番号 = 被保険者番号;
        this.管理区分 = 管理区分;
        this.登録区分 = 登録区分;
        this.適用開始年月日 = 適用開始年月日;
        this.適用終了年月日 = 適用終了年月日;
        this.終了区分 = 終了区分;
    }
}
