/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.fukajoho;

import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 賦課根拠照会のSearchResultクラスです。
 *
 * @reamsid_L DBB-5723-020 xuxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaJohoRelateSearchResult {

    private Fuka 介護賦課Result;
    private int 期;
    private Decimal 調定額;

}
