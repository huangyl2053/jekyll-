/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.KaigoNinteichosain;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoNinteichosainNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7013ChosainJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 介護認定調査員のMapperクラスです。
 *
 * @author N8187 久保田 英男
 */
public final class KaigoNinteichosainMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private KaigoNinteichosainMapper() {
    }

    /**
     * 認定調査員Entity、認定調査委託先Entityを介護認定調査員クラスに変換します。
     *
     * @param chosainJohoEntity 認定調査員Entity
     * @param itakusakiJohoEntity 認定調査委託先Entity
     * @return 介護認定調査員クラス
     * @throws NullPointerException 引数にNULLが渡された場合
     */
    public static KaigoNinteichosain toKaigoNinteichosain(
            DbT7013ChosainJohoEntity chosainJohoEntity,
            DbT7010NinteichosaItakusakiJohoEntity itakusakiJohoEntity) throws NullPointerException {
        requireNonNull(chosainJohoEntity, Messages.E00003.replace("認定調査員エンティティ", "介護認定調査員").getMessage());
        requireNonNull(itakusakiJohoEntity, Messages.E00003.replace("認定調査委託先エンティティ", "介護認定調査員").getMessage());

        return new KaigoNinteichosain(
                chosainJohoEntity.getShichosonCode(),
                chosainJohoEntity.getKaigoJigyoshaNo(),
                new KaigoNinteichosainNo(chosainJohoEntity.getKaigoChosainNo()),
                chosainJohoEntity.getJigyoshaNo(),
                chosainJohoEntity.getKaigoChosainJokyo(),
                chosainJohoEntity.getChosainShimei(),
                chosainJohoEntity.getChosainKanaShimei(),
                chosainJohoEntity.getSeibetsu(),
                chosainJohoEntity.getChosainShikakuCode(),
                chosainJohoEntity.getChikuCode(),
                chosainJohoEntity.getYubinNo(),
                chosainJohoEntity.getJusho(),
                chosainJohoEntity.getTelNo(),
                NinteichosaItakusakiMapper.toNinteichosaItakusaki(itakusakiJohoEntity));
    }

    /**
     * 介護認定調査員クラスを介護認定調査員Entityに変換します。
     *
     * @param 介護認定調査員 介護認定調査員クラス
     * @return 介護認定調査員Entity
     * @throws NullPointerException 引数にNULLが渡された場合
     */
    public static DbT7013ChosainJohoEntity toKaigoNinteichosainEntity(KaigoNinteichosain 介護認定調査員) throws NullPointerException {
        requireNonNull(介護認定調査員, Messages.E00003.replace("介護認定調査員", "介護認定調査員エンティティ").getMessage());
        DbT7013ChosainJohoEntity entity = new DbT7013ChosainJohoEntity();
        entity.setShichosonCode(介護認定調査員.get市町村コード());
        entity.setKaigoJigyoshaNo(介護認定調査員.get介護事業者番号());
        entity.setKaigoChosainNo(介護認定調査員.get介護調査員番号().value());
        entity.setJigyoshaNo(介護認定調査員.get事業者番号());
        entity.setKaigoChosainJokyo(介護認定調査員.is調査員状況());
        entity.setChosainShimei(介護認定調査員.get調査員氏名());
        entity.setChosainKanaShimei(介護認定調査員.get調査員氏名カナ());
        entity.setSeibetsu(介護認定調査員.get性別());
        entity.setChosainShikakuCode(介護認定調査員.get調査員資格コード());
        entity.setChikuCode(介護認定調査員.get地区コード());
        entity.setYubinNo(介護認定調査員.get郵便番号());
        entity.setJusho(介護認定調査員.get住所());
        entity.setTelNo(介護認定調査員.get電話番号());
        return entity;
    }
}
