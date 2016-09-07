/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jutakukaishusikyushinsei;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiKey;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishusikyushinsei.JutakukaishuJizenShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiEntity;

/**
 * 支給申請一覧取得のマッパーインタフェースです。
 *
 * @reamsid_L DBC-0992-150 xicongwang
 */
public interface IJutakukaishuSikyuShinseiMapper {

    /**
     * 住宅改修費支給申請情報取得
     *
     * @param parameter parameter
     * @return List<JutakukaishuSikyuShinseiEntity>
     */
    List<JutakukaishuSikyuShinseiEntity> get住宅改修費支給申請情報(Map<String, Object> parameter);

    /**
     * 住宅改修費事前申請情報取得
     *
     * @param parameter parameter
     * @return List<JutakukaishuSikyuShinseiEntity>
     */
    List<JutakukaishuSikyuShinseiEntity> get住宅改修費事前申請情報(Map<String, Object> parameter);

    /**
     * 事前申請一覧情報取得
     *
     * @param parameter parameter
     * @return List<JutakukaishuJizenShinseiEntity>
     */
    List<JutakukaishuJizenShinseiEntity> get事前申請一覧(Map<String, Object> parameter);

    /**
     * 償還払支給申請情報取得
     *
     * @param key key
     * @return DbT3034ShokanShinseiEntity
     */
    DbT3034ShokanShinseiEntity get償還払支給申請(JutakukaishuSikyuShinseiKey key);

}
