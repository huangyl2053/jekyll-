/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosahoshushokai;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査報酬照会のbatch用Businessクラスです。
 *
 * @reamsid_L DBE-1940-020 jinjue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaHoshuShokaiFlowBusiness implements Serializable {

    private static final long serialVersionUID = 1L;
    private RString 認定調査員コード;
    private RString 認定調査委託先コード;
    private RString 申請書管理番号;
    private int 認定調査依頼履歴番号;
}
