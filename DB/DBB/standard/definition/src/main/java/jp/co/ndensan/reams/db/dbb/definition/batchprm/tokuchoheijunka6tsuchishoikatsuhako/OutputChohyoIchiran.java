/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheijunka6tsuchishoikatsuhako;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 出力帳票の情報です。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class OutputChohyoIchiran implements Serializable {

    private RString 帳票分類ID;
    private RString 帳票ID;
    private RString 帳票名;
    private RString 出力順ID;

}
