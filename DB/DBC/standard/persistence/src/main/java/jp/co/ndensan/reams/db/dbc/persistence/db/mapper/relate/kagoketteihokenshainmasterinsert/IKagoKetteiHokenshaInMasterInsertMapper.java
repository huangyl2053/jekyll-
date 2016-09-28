/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteihokenshainmasterinsert;

import java.util.Map;

/**
 * 過誤決定通知書情報取込共通処理（マスタ登録）のマッパーインタフェースです。
 *
 * @reamsid_L DBC-0980-301 surun
 */
public interface IKagoKetteiHokenshaInMasterInsertMapper {

    /**
     * 過誤決定集計の登録処理
     *
     * @param parameter Map<String, Object>
     */
    void insert過誤決定集計(Map<String, Object> parameter);

    /**
     * 過誤決定明細の登録処理
     *
     * @param parameter Map<String, Object>
     */
    void insert過誤決定明細(Map<String, Object> parameter);

    /**
     * 過誤決定明細TBL再処理準備
     *
     * @param parameter Map<String, Object>
     */
    void 再処理準備(Map<String, Object> parameter);
}
