/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jigyobunshikyugakukeisanKekkarenrakuhyopanel;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業高額合算支給額計算結果Entityクラスです。
 *
 * @reamsid_L DBC-4840-010 lihang
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity implements Cloneable, Serializable {

    private HihokenshaNo hihokenshaNo;
    private FlexibleYear taishoNendo;
    private HokenshaNo shoKisaiHokenshaNo;
    private RString shikyuShinseishoSeiriNo;
    private int rirekiNo;
    private FlexibleDate sikyugakuKeisanKekkaRenrakuhyoSakuseiYMD;
}
