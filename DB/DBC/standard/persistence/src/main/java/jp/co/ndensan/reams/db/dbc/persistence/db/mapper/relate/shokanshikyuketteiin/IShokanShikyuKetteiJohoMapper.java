/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanshikyuketteiin;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT3036ShokanHanteiKekkaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.ShokanShikyuKetteiChohyoEntity;

/**
 * 償還払支給決定情報取込のMapperです。
 *
 * @reamsid_L DBC-0980-330 gongliang
 */
public interface IShokanShikyuKetteiJohoMapper {

    /**
     * 償還払支給判定結果一時TBLを作成する。
     */
    void create償還払支給判定結果一時TBL();

    /**
     * 償還払支給判定結果一時TBLに登録する。
     *
     * @param entity DbWT3036ShokanHanteiKekkaTempEntity
     */
    void do償還払支給判定結果一時TBLに登録(DbWT3036ShokanHanteiKekkaTempEntity entity);

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter Map<String, Object>
     * @return List<ShokanShikyuKetteiChohyoEntity>
     */
    List<ShokanShikyuKetteiChohyoEntity> get帳票出力対象データ(Map<String, Object> parameter);
}
