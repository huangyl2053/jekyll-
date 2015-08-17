/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.mapper;

import jp.co.ndensan.reams.db.dbx.business.IKogakuKaigoServiceHi;
import jp.co.ndensan.reams.db.dbx.business._KogakuKaigoServiceHi;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbV3057KogakuShikyuHanteiKekkaEntity;

/**
 * 高額介護サービス費のマッパークラスです。
 *
 * @author N9943 王 永康
 * @jpName 高額介護サービス費マッパー
 * @bizDomain 介護
 * @category 高額介護給付費
 * @subCategory
 * @mainClass
 * @reference
 */
public final class KogakuKaigoServiceHiMapper {

    private KogakuKaigoServiceHiMapper() {
    }

    /**
     * 高額介護サービス費エンティティから高額介護サービス費型に変換して返します。
     *
     * @param entity 高額介護サービス費エンティティ
     * @return 高額介護サービス費
     */
    public static IKogakuKaigoServiceHi toKogakuKaigoServiceHi(DbV3057KogakuShikyuHanteiKekkaEntity entity) {
        return new _KogakuKaigoServiceHi(entity.getHihokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getShiharaiKingaku(),
                entity.getHonninShiharaiGaku());
    }
}
