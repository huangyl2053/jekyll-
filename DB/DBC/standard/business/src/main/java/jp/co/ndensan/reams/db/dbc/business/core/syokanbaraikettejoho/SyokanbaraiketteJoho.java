/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.syokanbaraikettejoho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraiketejoho.SyokanbaraiketeJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払決定情報クラスです。
 */
public class SyokanbaraiketteJoho {

    private final SyokanbaraiketeJohoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity　償還払決定情報Entityクラス
     */
    public SyokanbaraiketteJoho(SyokanbaraiketeJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 事業者番号を取得します。
     *
     * @return 事業者番号
     */
    public JigyoshaNo getJigyoshaNo() {
        return entity.getJigyoshaNo();
    }

    /**
     * 様式番号を取得します。
     *
     * @return 様式番号
     */
    public RString getYoshikiNo() {
        return entity.getYoshikiNo();
    }

    /**
     * 明細番号を取得します。
     *
     * @return 明細番号
     */
    public RString getMeisaiNo() {
        return entity.getMeisaiNo();
    }

    /**
     * 連番を取得します。
     *
     * @return 連番
     */
    public RString getRenban() {
        return entity.getRenban();
    }

    /**
     * サービスコードを取得します。
     *
     * @return サービスコード
     */
    public ServiceCode getServiceCode() {
        return entity.getServiceCode();
    }

    /**
     * サービス種類名称を取得します。
     *
     * @return サービス種類名称
     */
    public RString getServiceName() {
        return entity.getServiceName();
    }

    /**
     * 福祉用具商品名を取得します。
     *
     * @return 福祉用具商品名
     */
    public RString getFukushiYoguShohinName() {
        return entity.getFukushiYoguShohinName();
    }

    /**
     * 単位金額を取得します。
     *
     * @return 単位金額
     */
    public Integer getKounyuKingaku() {
        return entity.getKounyuKingaku();
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
     * 差額金額を取得します。
     *
     * @return 差額金額
     */
    public Integer getSagakuKingaku() {
        return entity.getSagakuKingaku();
    }

    /**
     * テーブル区分を取得します。
     *
     * @return テーブル区分
     */
    public RString getTableKbn() {
        return entity.getTableKbn();
    }

    /**
     * 出来高区分を取得します。
     *
     * @return 出来高区分
     */
    public RString getDekidakaKbn() {
        return entity.getDekidakaKbn();
    }
}
