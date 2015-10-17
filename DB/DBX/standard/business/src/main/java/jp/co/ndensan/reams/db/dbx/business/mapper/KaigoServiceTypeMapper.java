/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.mapper;

import jp.co.ndensan.reams.db.dbx.business.IKaigoServiceType;
import jp.co.ndensan.reams.db.dbx.business._KaigoServiceType;
import jp.co.ndensan.reams.db.dbx.business._KaigoServiceTypeCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.KaigoServiceTypeEntity;

/**
 * 介護サービス種類Entityを操作クラスに変換するクラスです。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護サービスタイプマッパー
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス種類
 * @mainClass
 * @reference
 */
public final class KaigoServiceTypeMapper {

    private KaigoServiceTypeMapper() {
        //インスタンス生成禁止のため
        throw new AssertionError();
    }

    /**
     * 介護サービス種類Entityを操作クラスに変換します。
     *
     * @param 介護サービス種類Entity 介護サービス種類エンティティ
     * @return 介護サービス種類
     */
    public static IKaigoServiceType toKaigoServiceType(KaigoServiceTypeEntity 介護サービス種類Entity) {
        return new _KaigoServiceType(new _KaigoServiceTypeCode(介護サービス種類Entity.getサービス種類コード()),
                介護サービス種類Entity.get提供開始年月().getYearMonth(),
                介護サービス種類Entity.getサービス種類名称(),
                介護サービス種類Entity.getサービス種類略称(),
                介護サービス種類Entity.getサービス分類());
    }
}
