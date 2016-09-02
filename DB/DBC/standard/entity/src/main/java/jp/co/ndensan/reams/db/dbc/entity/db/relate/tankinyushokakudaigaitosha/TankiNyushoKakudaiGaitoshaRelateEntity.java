/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.tankinyushokakudaigaitosha;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 汎用リスト_短期入所拡大該当者情報Entityクラスです。
 *
 * @reamsid_L DBC-3111-020 duanzhanli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TankiNyushoKakudaiGaitoshaRelateEntity {

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
    private RString 有効開始年月;
    private RString 有効終了年月;
    private int 拡大倍数;
    private Decimal 切り分け単位数;
    private RString 限度額管理期間数;
    private RString 登録年月日;
    private RString 変更年月日;
    private RString 受給申請事由;
    private RString 受給申請年月日;
    private RString 要介護認定状態区分コード;
    private RString 認定有効期間開始年月日;
    private RString 認定有効期間終了年月日;
    private RString 認定年月日;
    private boolean 旧措置者フラグ;
    private RString みなし要介護区分コード;
    private RString 直近異動事由コード;
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
}
