/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 基本調査項目データのマッピング用Entityです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KihonChosaKomokuDataRelateEntity {

    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RString 認定申請年月日;
    private Decimal 連番;
    private RString 厚労省IF識別コード;
    private RString 調査項目;

}
