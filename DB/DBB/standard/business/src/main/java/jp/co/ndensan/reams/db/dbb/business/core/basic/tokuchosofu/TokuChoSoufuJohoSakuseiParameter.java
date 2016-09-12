/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchosofu;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 *
 * 特徴送付情報作成のバッチ起動時画面divに設定されるパラメータ
 *
 * @reamsid_L DBB-1840-040 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuChoSoufuJohoSakuseiParameter {

    private RYear 賦課年度;
    private RString 処理対象月;
    private RString 出力順ID;
}
