/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.jogaishinsainjoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査会一覧のデータソースをbusinessl
 *
 * @reamsid_L DBZ-1300-040 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiIinItiran implements Serializable {

    private static final long serialVersionUID = 7004722913207631159L;
    private RString shinsakaiIinCode;
    private RString shimei;
    private RString shozokuKikan;
}
