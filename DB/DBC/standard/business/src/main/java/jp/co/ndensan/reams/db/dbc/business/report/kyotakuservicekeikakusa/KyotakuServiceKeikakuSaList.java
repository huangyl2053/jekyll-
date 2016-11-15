/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyotakuservicekeikakusa;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 計画届出状況情報クラスです。
 *
 * @reamsid_L DBC-1960-030 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyotakuServiceKeikakuSaList {

    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private FlexibleDate 資格取得日;
    private FlexibleDate 資格喪失日;
    private RString 喪失事由;
    private FlexibleDate 受給申請日;
    private RString 申請事由;
    private RString 要介護度;
    private FlexibleDate 認定有効開始日;
    private FlexibleDate 認定有効終了日;
    private FlexibleDate 認定日;
    private RString 現在の申請状況;
    private FlexibleDate 計画届出日;
    private FlexibleDate 計画適用開始日;
    private FlexibleDate 計画適用終了日;
    private JigyoshaNo 事業者番号;
    private TelNo 電話番号;
    private FlexibleDate 変更年月日;
    private RString 事業者名称;
    private RString 備考1;
    private RString 備考2;
    private LasdecCode 市町村コード;
}
