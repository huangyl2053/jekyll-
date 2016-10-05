/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ichijihanteizumidatashutsuryoku;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataRelateEntity;

/**
 * 一次判定データ出力Businessです。
 *
 * @reamsid_L DBE-1610-010 wanghui
 */
public class IchijiHanteizumiDataBusiness {

    private final IchijiHanteizumiDataRelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 一次判定データ出力RelateEntity
     */
    public IchijiHanteizumiDataBusiness(IchijiHanteizumiDataRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 一次判定結果情報を取得します。
     *
     * @return 一次判定結果情報のEntity
     */
    public IchijiHanteizumiDataRelateEntity get一次判定結果情報() {
        return entity;
    }
}
