/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.ninteirirekiichiran;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定履歴一覧（画面) 受給者台帳情報取得_自己作成Entityオブジェクト
 *
 * @reamsid_L DBC-4350-070 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JyukyuuSyaDaiTyouEntity {

    private FlexibleDate 申請日;
    private Code 要介護認定状態区分;
    private FlexibleDate 認定有効開始日;
    private FlexibleDate 認定有効終了日;
    private RString 申請種別;
    private RString みなし区分;
    private boolean 旧措置者フラグ;
}
