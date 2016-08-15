/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenjukyushain;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain.DbWT0001DbWT5331Entity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain.DbWT5331JukyushaJohoEntity;

/**
 * 国保連保有受給者情報取込
 *
 * @author DBC-2740-010 fuyanling
 */
public interface IKokuhorenJukyushaMapper {

    /**
     * 受給者情報明細一時TBLを作成する。
     */
    void create受給者情報明細一時TBL();

    /**
     * 受給者情報明細一時TBLに登録する。
     *
     * @param entity DbWT0001HihokenshaTempEntity
     * @return
     */
    int insert受給者情報明細一時TBLに登録(DbWT5331JukyushaJohoEntity entity);

    /**
     * 帳票出力対象データ
     *
     * @param map
     * @return 帳票出力対象データ
     */
    List<DbWT0001DbWT5331Entity> get帳票出力対象データ(Map<String, Object> map);

}
