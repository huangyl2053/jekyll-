/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassanshikyushinseitoroku;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyushinseitoroku.HihokenshaMeishoSearchParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyushinseitoroku.ShinseishoJohoSearchParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3069KogakuGassanShinseishoKanyurekiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 高額合算支給申請書登録のmapperです。
 *
 * @reamsid_L DBC-2040-040 huzongcheng
 */
public interface IKogakuGassanShikyuShinseiTorokuMapper {

    /**
     * 被保険者番号を取得する。
     *
     * @param parameter Map
     * @return HihokenshaNo
     */
    HihokenshaNo select被保険者番号(Map<String, Object> parameter);

    /**
     * 申請書情報を取得する。
     *
     * @param parameter ShinseishoJohoSearchParameter
     * @return KogakuGassanShinseisho
     */
    List<DbT3068KogakuGassanShinseishoEntity> select申請書情報(ShinseishoJohoSearchParameter parameter);

    /**
     * 被保険者名を取得する。
     *
     * @param parameter HihokenshaMeishoSearchParameter
     * @return 被保険者情報
     */
    List<UaFt200FindShikibetsuTaishoEntity> select被保険者名(HihokenshaMeishoSearchParameter parameter);

    /**
     * 高額合算申請書加入歴データを取得する。
     *
     * @param parameter Map
     * @return List<DbT3069KogakuGassanShinseishoKanyurekiEntity>
     */
    List<DbT3069KogakuGassanShinseishoKanyurekiEntity> select高額合算申請書加入歴(Map<String, Object> parameter);

    /**
     * Max加入歴番号を取得します。
     *
     * @param parameter Map
     * @return DbT3069KogakuGassanShinseishoKanyurekiEntity
     */
    DbT3069KogakuGassanShinseishoKanyurekiEntity selectMax加入履歴番号(Map<String, Object> parameter);
}
