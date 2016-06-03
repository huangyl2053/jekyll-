/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調定事由リストクラスです。
 *
 * @reamsid_L DBB-0740-020 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TyouteiZiyu {

    private RString 調定事由_一番目;
    private RString 調定事由_二番目;
    private RString 調定事由_三番目;
    private RString 調定事由_四番目;
}
