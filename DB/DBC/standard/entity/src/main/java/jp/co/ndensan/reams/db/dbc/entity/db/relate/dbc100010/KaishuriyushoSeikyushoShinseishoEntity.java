/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成取得Entity
 *
 * @reamsid_L DBC-2860-030 suguangjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaishuriyushoSeikyushoShinseishoEntity {

    private ShoKisaiHokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private RString 住宅所有者;
    private FlexibleDate 理由書作成日;
    private JigyoshaNo 理由書作成事業者番号;
    private RString 理由書作成者;
    private RString 理由書作成者カナ;
    private FlexibleDate 申請年月日;
    private FlexibleDate 受付年月日;
    private ServiceCode サービスコード;
    private RString 住宅改修事業者名;
    private FlexibleDate 住宅改修着工年月日;
    private RString 住宅改修住宅住所;
    private RString 住宅改修内容;
}
