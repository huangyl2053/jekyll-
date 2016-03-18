/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.ichijihanteikekkajohosearch;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 一次判定結果情報です。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IchijiHanteiKekkaJohoSearchEntity {

    private RString 一次判定結果;
    private RString 認知症加算後の一次判定結果;
    private RString 要介護認定等基準時間;
    private RString 中間評価項目得点;
    private RString 一次判定警告コード;
    private RString 認知症自立度Ⅱ以上の蓋然性_評価の１０倍;
    private RString 状態の安定性;
    private RString 認知機能及び状態安定性から推定される給付区分;
    private Code 厚労省IF識別コード;
    private int 認定調査票_基本調査_件数;
    private int 要介護認定主治医意見書情報件数;

}
