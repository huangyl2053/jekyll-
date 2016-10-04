/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 三つ一時TBLを結合結果のRelateEntityクラスです。
 *
 * @reamsid_L DBC-2780-011 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyoudouShoriRelateEntity {

    private RString 集約保険者番号;
    private RString 集約保険者名;
    private RString 集約被保険者番号;
    private RString 集約異動年月日;
    private RString 基_保険者番号;
    private RString 基_保険者名;
    private RString 基_交換情報識別番号;
    private RString 基_被保険者番号;
    private RString 基_異動年月日;
    private RString 基_異動区分コード;
    private RString 基_異動事由;
    private RString 基_証記載保険者番号;
    private RString 基_被保険者氏名;
    private RString 基_郵便番号;
    private RString 基_住所カナ;
    private RString 基_住所;
    private RString 基_電話番号;
    private RString 基_帳票出力順序コード;
    private RString 基_訂正区分コード;
    private RString 基_訂正年月日;
    private RString 償_保険者番号;
    private RString 償_保険者名;
    private RString 償_交換情報識別番号;
    private RString 償_被保険者番号;
    private RString 償_異動年月日;
    private RString 償_異動区分コード;
    private RString 償_異動事由;
    private RString 償_証記載保険者番号;
    private RString 償_保険給付支払の一時差止の開始年月日;
    private RString 償_保険給付支払の一時差止の終了年月日;
    private RString 償_保険給付支払の一時差止区分;
    private RString 償_保険給付支払の一時差止金額;
    private RString 償_訂正区分コード;
    private RString 償_訂正年月日;
    private RString 高_保険者番号;
    private RString 高_保険者名;
    private RString 高_交換情報識別番号;
    private RString 高_被保険者番号;
    private RString 高_異動年月日;
    private RString 高_異動区分コード;
    private RString 高_異動事由;
    private RString 高_証記載保険者番号;
    private RString 高_世帯主被保険者番号;
    private RString 高_世帯所得区分コード;
    private RString 高_所得区分コード;
    private RString 高_老齢福祉年金受給の有無;
    private RString 高_利用者負担第２段階;
    private RString 高_支給申請書出力の有無;
    private RString 高_訂正区分コード;
    private RString 高_訂正年月日;
}
