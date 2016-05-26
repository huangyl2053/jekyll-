/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkyotakuservicekeikaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 汎用リスト 居宅サービス計画Entityクラスです。
 *
 * @reamsid_L DBC-3091-020 surun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKyotakuServiceKeikakuEntity {

    private HihokenshaNo dbV1001被保険者番号;
    private LasdecCode dbV1001市町村コード;
    private RString dbV1001資格取得事由コード;
    private FlexibleDate dbV1001資格取得年月日;
    private FlexibleDate dbV1001資格取得届出年月日;
    private RString dbV1001資格喪失事由コード;
    private FlexibleDate dbV1001資格喪失年月日;
    private FlexibleDate dbV1001資格喪失届出年月日;
    private RString dbV1001被保険者区分コード;
    private RString dbV1001住所地特例フラグ;
    private RString dbV1001広域内住所地特例フラグ;
    private LasdecCode dbV1001広住特措置元市町村コード;
    private JigyoshaNo dbV1004入所施設コード;
    private FlexibleDate dbV1004入所年月日;
    private FlexibleDate dbV1004退所年月日;
    private RString dbV1004入所施設種類;
    private AtenaMeisho dbT7060事業者名称;
    private AtenaKanaMeisho dbT7060事業者名称カナ;
    private YubinNo dbT7060郵便番号;
    private AtenaJusho dbT7060事業者住所;
    private AtenaMeisho dbT7062代表者名;
    private AtenaKanaMeisho dbT7062代表者名カナ;
    private RString dbT7062代表者役職名;
    private TelNo dbT7060電話番号;
    private TelNo dbT7060FAX番号;
    private Decimal dbT7060所属人数;
    private Decimal dbT7060利用者数;
    private FlexibleDate dbT7060有効開始日;
    private FlexibleDate dbT7060有効終了日;
    private RString dbT7060サービス実施地域;
    private AtenaMeisho dbV1005事業者名称;
    private AtenaKanaMeisho dbV1005事業者名称カナ;
    private YubinNo dbV1005郵便番号;
    private AtenaJusho dbV1005事業者住所;
    private AtenaMeisho dbV1005代表者名称;
    private AtenaKanaMeisho dbV1005代表者名称カナ;
    private RString dbV1005役職;
    private TelNo dbV1005電話番号;
    private TelNo dbV1005FAX番号;
    private FlexibleDate dbV1005有効開始日;
    private FlexibleDate dbV1005有効終了年月日;
    private HihokenshaNo dbT3005被保険者番号;
    private FlexibleYearMonth dbT3005対象年月;
    private Decimal dbT3005履歴番号;
    private RString dbT3005届出区分;
    private FlexibleDate dbT3005届出年月日;
    private HihokenshaNo dbT3006被保険者番号;
    private RString dbT3006作成区分コード;
    private FlexibleDate dbT3006適用開始年月日;
    private FlexibleDate dbT3006適用終了年月日;
    private FlexibleDate dbT3006事業者変更年月日;
    private HihokenshaNo dbT3007被保険者番号;
    private RString dbT3007作成区分コード;
    private FlexibleDate dbT3007適用開始年月日;
    private FlexibleDate dbT3007適用終了年月日;
    private FlexibleDate dbT3007計画作成年月日;
    private FlexibleDate dbT3007計画変更年月日;
    private RString dbT3007変更理由;
    private JigyoshaNo dbT3006計画事業者番号;
    private AtenaMeisho dbT7060_Keikaku事業者名称;
    private JigyoshaNo dbT3006委託先事業者番号;
    private AtenaMeisho dbT7060_Itaku事業者名称;
    private Code dbV4001受給申請事由;
    private FlexibleDate dbV4001受給申請年月日;
    private Code dbV4001要介護認定状態区分コード;
    private FlexibleDate dbV4001認定有効期間開始日;
    private FlexibleDate dbV4001認定有効期間終了日;
    private FlexibleDate dbV4001受給認定日;
    private RString dbV4001旧措置フラグ;
    private Code dbT4001みなし要介護区分コード;
    private Code dbV4001直近異動事由コード;

    /**
     * -- GETTER -- 宛名Entity。
     *
     * @return 宛名Entity -- SETTER -- 宛名Entity。
     *
     * @param 宛名Entity 宛名Entity
     */
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
    /**
     * -- GETTER -- 宛先Entity。
     *
     * @return 宛先Entity -- SETTER -- 宛先Entity。
     *
     * @param 宛先Entity 宛先Entity
     */

    private UaFt250FindAtesakiEntity 宛先Entity;

}
