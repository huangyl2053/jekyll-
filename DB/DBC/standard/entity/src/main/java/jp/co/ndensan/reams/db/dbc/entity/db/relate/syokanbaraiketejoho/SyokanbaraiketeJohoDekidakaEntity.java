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
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払決定情報Entityクラスです。
 *
 * @reamsid_L DBC-0950-010 zuotao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SyokanbaraiketeJohoDekidakaEntity implements Cloneable, Serializable {

    private JigyoshaNo jigyoshaNo;
    private RString yoshikiNo;
    private RString meisaiNo;
    private RString renban;
    private ServiceCode serviceCode;
    private RString serviceName;
    private RString fukushiYoguShohinName;
    private Integer tanisuTotal;
    private Decimal seikyuKaku;
    private Integer seikyugakuSagakuKingaku;
    private Integer dekidakaIryohiTanisuTotal;
    private Decimal dekidakaSeikyukaku;
    private Integer dekidakaSeikyugakuSagaku;
    private int updateCount;
}
