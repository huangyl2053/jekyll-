/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosahoshushokai;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査報酬照会のbatch用Businessクラスです。
 *
 * @reamsid_L DBE-1940-010 jinjue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaHoshuShokaiFlowBusiness {

    private RString 認定調査員コード;
    private RString 認定調査委託先コード;
    private RString 在宅_初;
    private RString 在宅_再;
    private RString 施設_初;
    private RString 施設_再;
    private RString 事業者名称;
    private RString 調査員氏名;
    private RDate 認定調査依頼年月日;
    private RDate 認定調査実施年月日;
    private RDate 認定調査受領年月日;
    private RString 認定調査依頼区分コード;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private int 認定調査委託料;

}
