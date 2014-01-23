/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.HatsubanJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.T5020HatsubanKanriJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 発番情報のビジネスクラスとエンティティの変換を行うクラスです
 *
 * @author N1013 松本直樹
 */
public final class HatsubanJohoMapper {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです
     */
    private HatsubanJohoMapper() {
    }

    /**
     * 発番管理情報エンティティから発番情報への対応付けを行います
     *
     * @param 発番管理情報Entity 発番管理情報Entity
     * @return 発番情報
     * @throws NullPointerException 引数がnullのとき
     */
    public static HatsubanJoho toHatsubanJoho(T5020HatsubanKanriJohoEntity 発番管理情報Entity) throws NullPointerException {
        requireNonNull(発番管理情報Entity, Messages.E00003.replace("発番管理情報エンティティ", "発番情報").getMessage());
        return new HatsubanJoho(発番管理情報Entity.get発番());
    }
}
