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
 * 事前審査結果集計表のクラスです。
 *
 * @reamsid_L DBE-1640-010 zhaoyao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiJizenshinsakekkaIchiranRelateEntity {

    private int shinsakaiOrder;
    private RString hihokenshaNo;
    private RString koroshoIfShikibetsuCode;
    private RString nigoTokuteiShippeiCode;
    private RString nijiHanteiYokaigoJotaiKubunCode;
    private RString ichijiHanteiKekkaCode;
    private RString ninteiShinseiShinseijiKubunCode;
    private RString shinsakaiIinCode;
    private RString kaigoninteiShinsakaiGichoKubunCode;
    private RString shinsakaiIinShimei;
    private RString shinsakaiKaisaiNo;
    private RString nijiHanteiKekkaCode;
    private int gogitaiNo;
    private RString shinsakaiKaisaiYoteiYMD;
    private RString shinsakaiKaishiYoteiTime;
    private RString yukokikan;
}
