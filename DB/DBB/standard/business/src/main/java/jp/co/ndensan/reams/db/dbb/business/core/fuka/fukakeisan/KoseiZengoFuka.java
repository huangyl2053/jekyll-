/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 更正前後賦課のクラスです。
 *
 * @reamsid_L DBB-0660-020 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoseiZengoFuka implements Serializable {

    private FlexibleYear 賦課年度;
    private TsuchishoNo 通知書番号;
    private NendobunFukaList 更正前;
    private NendobunFukaList 更正後;
    private boolean hasChanged;
}
