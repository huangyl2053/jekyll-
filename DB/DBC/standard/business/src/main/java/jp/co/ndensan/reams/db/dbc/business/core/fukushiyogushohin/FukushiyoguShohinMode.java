/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.fukushiyogushohin;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 福祉用具商品名入力ガイドの項目定義クラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukushiyoguShohinMode implements Serializable {

    private static final long serialVersionUID = 1L;

    private RString shohinmei;
    private RString seizoJigyoshamei;
    private RString hinmokuCode;
}
