/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.syokanbaraiketteJoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraiketeJoho.KetteJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 決定情報クラスです。
 */
public class KetteJoho implements Serializable {

    private final KetteJohoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 償還払決定情報Entityクラス
     */
    public KetteJoho(KetteJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 被保険者を取得します。
     *
     * @return 被保険者
     */
    public HihokenshaNo getHiHokenshaNo() {
        return entity.getHiHokenshaNo();
    }

    /**
     * サービス提供年月を取得します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return entity.getServiceTeikyoYM();
    }

    /**
     * 整理番号を取得します。
     *
     * @return 整理番号
     */
    public RString getSeiriNo() {
        return entity.getSeiriNo();
    }

    /**
     * 決定日を取得します。
     *
     * @return 決定日
     */
    public FlexibleDate getKetteiYMD() {
        return entity.getKetteiYMD();
    }

    /**
     * 支給区分を取得します。
     *
     * @return 支給区分
     */
    public RString getShikyuHushikyuKetteiKubun() {
        return entity.getShikyuHushikyuKetteiKubun();
    }

    /**
     * 増減理由等を取得します。
     *
     * @return 増減理由等
     */
    public RString getZougenRiyu() {
        return entity.getZougenRiyu();
    }

    /**
     * 支払金額を取得します。
     *
     * @return 支払金額
     */
    public Integer getShiharaiKingaku() {
        return entity.getShiharaiKingaku();
    }

    /**
     * 不支給理由等を取得します。
     *
     * @return 不支給理由等
     */
    public RString getHushikyuRiyu() {
        return entity.getHushikyuRiyu();
    }

    /**
     * 増減単位を取得します。
     *
     * @return 増減単位
     */
    public Integer getZougenten() {
        return entity.getZougenten();
    }

    /**
     * 購入・改修履歴等を取得します。
     *
     * @return 購入・改修履歴等
     */
    public RString getKounyuKaishuRireki() {
        return entity.getKounyuKaishuRireki();
    }
}
