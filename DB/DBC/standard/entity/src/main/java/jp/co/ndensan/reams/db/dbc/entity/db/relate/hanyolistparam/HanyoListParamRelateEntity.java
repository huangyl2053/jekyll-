/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistparam;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 汎用リスト_基準収入額適用情報Entityクラスです。
 *
 * @reamsid_L DBC-5050-030 duanzhanli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListParamRelateEntity {

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
    private RString 広域内住所地特例フラグ;
    private RString 広住特措置元市町村コード;
    private RString 受給申請事由;
    private RString 受給申請年月日;
    private RString 要介護認定状態区分コード;
    private RString 認定有効期間開始年月日;
    private RString 認定有効期間終了年月日;
    private RString 認定年月日;
    private boolean 旧措置者フラグ;
    private RString みなし要介護区分コード;
    private RString 直近異動事由コード;
    private RString 世帯コード;
    private RString 年度;
    private RString 履歴番号;
    private Decimal 公的年金収入額;
    private Decimal 給与収入額;
    private Decimal その他の収入額;
    private Decimal 算定基準額;
    private RString 適用開始年月;
    private RString 申請日;
    private RString 決定日;
    private RString 申請書作成日;
    private RString 申請書作成の世帯基準日;
    private boolean 宛先印字対象者フラグ;
    private int 年少扶養控除_16歳未満;
    private int 年少扶養控除_16_18歳;
    private Decimal 世帯員の総収入額;
    private boolean 世帯主フラグ;
    private Decimal 課税所得額;
    private Decimal 課税所得額_除後;
    private RString 決定通知書発行日;
    private RString 要支援者認定申請区分;
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
    private UaFt250FindAtesakiEntity 宛先Entity;

}
