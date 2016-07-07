/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 市町村情報
 *
 * @reamsid_L DBB-1650-050 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShichosonJouhouResult {

    private LasdecCode 市町村コード;
    private RString 市町村識別ID;
    private FlexibleDate 開始年月日;
    private RString 開始時刻;
    private FlexibleDate 終了年月日;
    private RString 終了時刻;
}
