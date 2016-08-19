/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenjukyushain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain.DbWT0001DbWT5331Entity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain.DbWT5331JukyushaJohoEntity;

/**
 * 国保連保有受給者情報取込
 *
 * @reamsid_L DBC-2740-010 fuyanling
 */
public interface IKokuhorenJukyushaMapper {

    /**
     * 受給者情報明細一時TBLに登録する。
     *
     * @param entity DbWT0001HihokenshaTempEntity
     * @return int
     */
    int insert受給者情報明細一時TBLに登録(DbWT5331JukyushaJohoEntity entity);

    /**
     * 帳票出力対象データ
     *
     * @param 帳票データの取得Parameter KokuhorenIchiranhyoMybatisParameter
     * @return 帳票出力対象データ List<DbWT0001DbWT5331Entity>
     */
    List<DbWT0001DbWT5331Entity> get帳票出力対象データ(KokuhorenIchiranhyoMybatisParameter 帳票データの取得Parameter);

}
