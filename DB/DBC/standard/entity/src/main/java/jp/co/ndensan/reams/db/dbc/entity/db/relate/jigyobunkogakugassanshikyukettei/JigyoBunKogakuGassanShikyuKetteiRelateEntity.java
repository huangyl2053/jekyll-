/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jigyobunkogakugassanshikyukettei;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 汎用リスト_事業分高額合算支給決定情報Entityクラスです。
 *
 * @reamsid_L DBC-5060-030 duanzhanli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoBunKogakuGassanShikyuKetteiRelateEntity {

    private RString 市町村コード;
    private RString 被保険者番号;
    private RString 資格取得事由コード;
    private RString 資格取得年月日;
    private RString 資格取得届出年月日;
    private RString 資格喪失事由コード;
    private RString 資格喪失年月日;
    private RString 資格喪失届出年月日;
    private RString 被保険者区分コード;
    private RString 住所地特例フラグ;
    private RString 受給申請事由;
    private RString 受給申請年月日;
    private RString 要介護認定状態区分コード;
    private RString 認定有効期間開始年月日;
    private RString 認定有効期間終了年月日;
    private RString 認定年月日;
    private boolean 旧措置者フラグ;
    private RString みなし要介護区分コード;
    private RString 直近異動事由コード;
    private RString 対象年度;
    private RString 保険者番号;
    private RString 連絡票整理番号;
    private RString 履歴番号;
    private RString 自己負担額証明書整理番号;
    private RString 対象計算期間開始年月日;
    private RString 対象計算期間終了年月日;
    private RString 申請年月日;
    private RString 決定年月日;
    private Decimal 自己負担総額;
    private RString 支給区分コード;
    private Decimal 支給額;
    private RString 給付の種類;
    private RString 不支給理由;
    private RString 支払方法区分;
    private RString 支払場所;
    private RString 支払期間開始年月日;
    private RString 支払期間終了年月日;
    private RString 支払期間開始時間;
    private RString 支払期間終了時間;
    private RString 決定通知書作成年月日;
    private RString 振込通知書作成年月日;
    private RString 受取年月;
    private TokuteiKozaRelateEntity 口座Entity;
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
    private UaFt250FindAtesakiEntity 宛先Entity;

}
