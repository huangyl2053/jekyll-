/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 保険者番号取込のEntityクラスです
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenshaTorikomiEntity {

    private HokenshaNo 保険者番号;
    private RString 保険者名;
    private DbWT2111ShokanShinseiTempEntity 償還一時Entity;
}
