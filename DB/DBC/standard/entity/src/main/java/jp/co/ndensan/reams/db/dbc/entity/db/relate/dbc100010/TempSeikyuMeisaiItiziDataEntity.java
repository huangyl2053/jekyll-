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
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成のRelateEntityクラスです。
 *
 * @reamsid_L DBC-2860-030 suguangjun
 */
@SuppressWarnings("PMd.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
@OnNextSchema("rgdb")
public class TempSeikyuMeisaiItiziDataEntity {

    private ShoKisaiHokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private int 履歴番号;
    private ServiceCode サービスコード;
    private RString 介護住宅改修事業者名称;
    private FlexibleDate 介護住宅改修着工年月日;
    private RString 介護住宅改修住宅所有者;
    private RString 改修対象住宅住所;
    private RString 改修内容箇所及び規模;
    private FlexibleDate 介護住宅改修理由書作成年月日;
    private JigyoshaNo 介護住宅改修理由書作成事業者番号;
    private RString 介護住宅改修理由書作成者名;
    private RString 介護住宅改修理由書作成者名カナ;
    private FlexibleDate 介護住宅改修理由書作成申請年月日;
    private FlexibleDate 介護住宅改修理由書作成受付年月日;
    private RString 集計関連付け番号;
    private boolean 対象外フラグ;
}
