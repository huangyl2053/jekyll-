/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaItakusaki;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 認定調査委託先のビジネスクラスとエンティティの変換を行うクラスです
 *
 * @author N1013 松本直樹
 */
public final class NinteichosaItakusakiMapper {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです
     */
    private NinteichosaItakusakiMapper() {
    }

    /**
     * 認定調査委託先エンティティから認定調査委託先への対応付けを行います
     *
     * @param 認定調査委託先Entity 認定調査委託先Entity
     * @return 認定調査委託先
     * @throws NullPointerException {@code 認定調査委託先Entity}がnullの場合
     */
    public static NinteichosaItakusaki toNinteichosaItakusaki(DbT7010NinteichosaItakusakiJohoEntity 認定調査委託先Entity) throws NullPointerException {
        requireNonNull(認定調査委託先Entity, Messages.E00003.replace("認定調査委託先エンティティ", "認定調査委託先").getMessage());
        return new NinteichosaItakusaki(
                認定調査委託先Entity.get市町村コード(),
                認定調査委託先Entity.get介護事業者番号(),
                認定調査委託先Entity.get事業者番号(),
                認定調査委託先Entity.is介護事業者状況(),
                認定調査委託先Entity.get調査委託区分(),
                認定調査委託先Entity.get割付定員(),
                認定調査委託先Entity.get割付地区(),
                認定調査委託先Entity.get機関の区分());
    }
}
