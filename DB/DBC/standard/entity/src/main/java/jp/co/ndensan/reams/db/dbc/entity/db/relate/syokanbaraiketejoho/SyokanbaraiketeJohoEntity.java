/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraiketejoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払決定情報Entityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SyokanbaraiketeJohoEntity implements Cloneable, Serializable {

    private JigyoshaNo jigyoshaNo;
    private RString yoshikiNo;
    private RString meisaiNo;
    private RString renban;
    private ServiceCode serviceCode;
    private RString serviceName;
    private RString fukushiYoguShohinName;
    private Integer kounyuKingaku;
    private Integer shiharaiKingaku;
    private Integer sagakuKingaku;
    private RString tableKbn;
    private RString dekidakaKbn;
}
