/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosadatatorikomi;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 認定調査データ取込のMyBatis用パラメータクラスです。
 *
 * @author N3212 竹内 和紀
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class NinteiChosaDataTorikomiMapperParameter {

    private final RString 証記載保険者番号;
    private final RString 被保険者番号;
    private final RString 認定申請日;

    public NinteiChosaDataTorikomiMapperParameter(RString 証記載保険者番号,
            RString 被保険者番号, RString 認定申請日) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.認定申請日 = 認定申請日;
    }
}
