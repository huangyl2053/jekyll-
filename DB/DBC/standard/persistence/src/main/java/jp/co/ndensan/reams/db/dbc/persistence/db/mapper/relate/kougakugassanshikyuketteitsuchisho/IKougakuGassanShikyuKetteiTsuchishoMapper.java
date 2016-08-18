/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kougakugassanshikyuketteitsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakugassanshikyuketteitsuchisho.KougakuGassanShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kougakugassanshikyuketteitsuchisho.JigyoKogakuGassanEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kougakugassanshikyuketteitsuchisho.KozaJyohoEntity;

/**
 * ビジネス設計_DBCMNN2003_事業分高額合算支給決定通知書（単）のビジネス。
 *
 * @reamsid_L DBC-4850-040 pengxingyi
 */
public interface IKougakuGassanShikyuKetteiTsuchishoMapper {

    /**
     * 口座情報取得です。
     *
     * @param param param
     * @return {@link List<KozaJyohoEntity>}
     */
    List<KozaJyohoEntity> getKozaJyoho(KougakuGassanShikyuKetteiTsuchishoParameter param);

    /**
     * 事業高額合算情報取得です。
     *
     * @param param param
     * @return {@link JigyoKogakuGassanEntity}
     */
    JigyoKogakuGassanEntity select事業高額合算(KougakuGassanShikyuKetteiTsuchishoParameter param);
}
