/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenshinseishotaishohaaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 申請書発行対象者情報entityクラスです。
 *
 * @reamsid_L DBD-3530-030 liuwei2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinseishoHakkoTaishoJohoSakuseiEntity {

    private HihokenshaNo 被保険者番号;
    private boolean 更新認定フラグ;
    private ShikibetsuCode 識別コード;
    private RString 世帯課税区分;
    private RString 本人課税区分;
    private boolean 老齢受給者フラグ;
    private boolean 生保受給者フラグ;
    private RString 利用者負担段階;
    private Decimal 合計所得金額;
    private Decimal 年金収入額;
    private RString 入所施設コード;
    private Decimal 非課税年金勘案額;
    private JigyoshaNo 事業者番号;

}
