/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteidetaikatsukousin;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd560001.NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd560001.YokaigoNinteiInterfaceEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;

/**
 * 要介護認定インターフェース情報Mapperです。
 *
 * @reamsid_L DBD-2120-020 liuwei2
 */
public interface INinteidetaikkatsukousinMapper {

    /**
     * 要介護認定インターフェース情報を取得する。
     *
     * @return List<YokaigoNinteiInterfaceEntity>
     */
    List<YokaigoNinteiInterfaceEntity> get要介護認定インターフェース情報();

    /**
     * 要介護認定結果情報を取得する。
     *
     * @return List<NinteiKekkaJohoEntity>
     */
    List<NinteiKekkaJohoEntity> get要介護認定結果情報();

    /**
     * 受給者台帳更新対象データを取得する。
     *
     * @return List<DbT4001JukyushaDaichoEntity>
     */
    List<DbT4001JukyushaDaichoEntity> get受給者台帳更新対象データ();
}
