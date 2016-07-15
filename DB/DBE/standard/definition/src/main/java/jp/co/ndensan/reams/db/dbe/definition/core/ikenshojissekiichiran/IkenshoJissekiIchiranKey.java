/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.ikenshojissekiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 主治医意見書作成実績集計表のキー情報クラスです。
 *
 * @reamsid_L DBE-1690-020 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class IkenshoJissekiIchiranKey {

    private RString shujiiIryoKikanCode;
    private RString shujiiCode;
    private RString shinseishoKanriNo;
    private int ikenshoIraiRirekiNo;
}
