/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB211001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 *
 * 特徴送付情報作成のバッチ起動時に設定されるパラメータ
 *
 * @reamsid_L DBB-1840-040 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB211001_TokuchoSofuJohoSakuseiParameter {

    private RYear 賦課年度;
    private RString 処理対象月;
    private RString 帳票ID;
    private RString 件数表帳票ID;
    private RString 出力順ID;

}
