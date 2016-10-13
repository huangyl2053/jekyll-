/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3071KogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 高額合算自己負担額情報補正（一括）entityクラスです。
 *
 * @reamsid_L DBC-2320-060 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanJikofutangakuInfoHoseiEntity implements IDbAccessable, Serializable {

    private KogakugassanJikofutangakuInfoHoseiTempEntity 中間DBEntity;
    private RString juminShubetsuCode;
    private LasdecCode shichosonCode;
    private FlexibleDate seinengappiYMD;
    private RString seibetsuCode;
    private AtenaMeisho kanjiShimei;
    private AtenaKanaMeisho kanaShimei;
    private YubinNo yubinNo;
    private ZenkokuJushoCode zenkokuJushoCode;
    private GyoseikuCode gyoseikuCode;
    private HihokenshaNo hihokenshaNo;
    private FlexibleYear taishoNendo;
    private HokenshaNo hokenshaNo;
    private RString shikyuShinseishoSeiriNo;
    private int rirekiNo;
    private RString taishoM;
    private DbT3071KogakuGassanJikoFutanGakuMeisaiEntity dbt3071Entity;
    private DbT3070KogakuGassanJikoFutanGakuEntity dbt3070Entity;
}
