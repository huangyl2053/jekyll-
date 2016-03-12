/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.chosaitakusakiandchosaininput;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 調査委託先＆調査員入力ビジネスクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaItakusakiAndChosain {

    private RString 事業者名称;
    private RString 認定調査委託先コード;
    private RString 調査員氏名;
    private RString 認定調査員コード;

}
