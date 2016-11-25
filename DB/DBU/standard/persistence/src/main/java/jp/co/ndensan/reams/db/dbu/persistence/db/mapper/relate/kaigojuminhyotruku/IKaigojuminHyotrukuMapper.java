/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kaigojuminhyotruku;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kaigojuminhyotruku.KaigojuminHyotrukuMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * バッチ設計_DBUMN81001_住民異動連携情報登録【他社住基用】クラスです。
 *
 * @reamsid_L DBA-1400-020 wanghui
 */
public interface IKaigojuminHyotrukuMapper {

    /**
     * 介護住民票個別事項連携情報を条件指定検索で複数件取得します。
     *
     * @param mappreParameter KaigojuminHyotrukuMapperParameter
     * @return DbT7022ShoriDateKanriEntity
     */
    DbT7022ShoriDateKanriEntity get宛名連動介護保険更新(KaigojuminHyotrukuMapperParameter mappreParameter);
}
