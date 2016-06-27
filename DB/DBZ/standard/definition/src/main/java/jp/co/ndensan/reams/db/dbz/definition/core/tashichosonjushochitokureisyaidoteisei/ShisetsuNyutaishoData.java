/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.tashichosonjushochitokureisyaidoteisei;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 施設入退所データクラスです。
 *
 * @reamsid_L DBA-0401-010 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShisetsuNyutaishoData {

    private FlexibleDate 入所日;
    private FlexibleDate 退所日;

}
