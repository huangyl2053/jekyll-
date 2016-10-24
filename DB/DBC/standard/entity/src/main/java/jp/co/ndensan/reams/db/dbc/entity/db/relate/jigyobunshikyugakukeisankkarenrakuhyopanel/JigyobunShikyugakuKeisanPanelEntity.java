/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jigyobunshikyugakukeisankkarenrakuhyopanel;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
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
public class JigyobunShikyugakuKeisanPanelEntity implements Cloneable, Serializable {

    private HihokenshaNo hihokenshaNo;
    private FlexibleYear taishoNendo;
    private HokenshaNo shoKisaiHokenshaNo;
    private RString shikyuShinseishoSeiriNo;
    private int rirekiNo;
    private FlexibleDate sikyugakuKeisanKekkaRenrakuhyoSakuseiYMD;

    private RString hokenSeidoCode;
    private DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity dbt3172Entity;
    private DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity dbt3173Entity;

    /**
     * コンストラクタです。
     */
    public JigyobunShikyugakuKeisanPanelEntity() {

    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity
     */
    public JigyobunShikyugakuKeisanPanelEntity(DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity entity) {
        this.dbt3172Entity = entity;
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity
     */
    public JigyobunShikyugakuKeisanPanelEntity(DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity) {
        this.dbt3173Entity = entity;
    }

    /**
     * コンストラクタです。
     *
     * @param hokenSeidoCode RString
     */
    public JigyobunShikyugakuKeisanPanelEntity(RString hokenSeidoCode) {
        this.hokenSeidoCode = hokenSeidoCode;
    }
}
