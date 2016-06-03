    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmenjokyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 減免照会（画面）のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-4342-020 wangjie2
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GemmenJokyoParameter {

    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private RString システム日付;
    private RString 減免減額種類コード;

}
