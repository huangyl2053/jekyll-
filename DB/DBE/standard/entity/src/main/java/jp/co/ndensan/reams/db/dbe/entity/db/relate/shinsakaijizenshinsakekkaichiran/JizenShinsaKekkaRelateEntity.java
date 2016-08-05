/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaijizenshinsakekkaichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事前審査結果のクラスです。
 *
 * @reamsid_L DBE-1640-010 zhaoyao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JizenShinsaKekkaRelateEntity {

    private RString shinsakaiIinShimei;
    private RString kaigoninteiShinsakaiGichoKubunCode;
    private RString shinsakaiIinCode;
    private int shinsakaiOrder;
    private RString nijiHanteiKekkaCode;
}
