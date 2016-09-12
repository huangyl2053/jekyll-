/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00002;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 減免減額申請クラスです．
 *
 * @reamsid_L DBD-3980-050 x_youyj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GennmennGenneSyoukennEntity {
    // 団体(市町村)コード
    private RString insertDantaiCd;
    // 行挿入日時
    private RString insertTimestamp;
    // 行挿入したReamsログインid
    private RString insertReamsLoginId;
    // 行挿入時の接続コンテキスト
    private RString insertContextId;
    // 理削除行であればtrue
    private boolean isDeleted;
    // Update回数
    private int updateCount;
    // 最終Update日時
    private RString lastUpdateTimestamp;
    // 最後にupdateしたReamsログインid
    private RString lastUpdateReamsLoginId;
    // 証記載保険者番号
    private RString shoKisaiHokenshaNo;
    // 被保険者番号
    private RString hihokenshaNo;
    // 減免減額種類
    private RString gemmenGengakuShurui;
    // 履歴番号
    private RString shinseiRirekiNo;
    // 申請届出代行区分
    private RString shinseiTodokedeDaikoKubun;
    // 申請届出者氏名
    private RString shinseiTodokedeshaShimei;
    // 申請届出者氏名カナ
    private RString shinseiTodokedeshaKanaShimei;
    // 申請届出者続柄
    private RString shinseiTodokedeshaTsuzukigara;
    // 申請届出代行事業者番号
    private RString shinseiTodokedeDaikoJigyoshaNo;
    // 事業者区分
    private RString jigyoshaKubun;
    // 申請届出者郵便番号
    private RString shinseiTodokedeshaYubinNo;
    // 申請届出者住所
    private RString shinseiTodokedeshaJusho;
    // 申請届出者電話番号
    private RString shinseiTodokedeshaTelNo;
}
