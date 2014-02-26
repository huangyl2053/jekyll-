/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.KaigoNinteiChosain;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7013ChosainJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 介護認定調査員のMapperクラスです。
 *
 * @author N8187 久保田 英男
 */
public final class KaigoNinteiChosainMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private KaigoNinteiChosainMapper() {
    }

    /**
     * 介護認定調査員Entityを介護認定調査員クラスに変換します。
     *
     * @param entity 介護認定調査員Entity
     * @return 介護認定調査員クラス
     */
    public static KaigoNinteiChosain toKaigoNinteiChosain(DbT7013ChosainJohoEntity entity) {
        requireNonNull(entity, Messages.E00003.replace("介護認定調査員エンティティ", "介護認定調査員").getMessage());

        return new KaigoNinteiChosain(
                entity.getShichosonCode(),
                entity.getKaigoJigyoshaNo(),
                entity.getKaigoChosainNo(),
                entity.getJigyoshaNo(),
                entity.getKaigoChosainJokyo(),
                entity.getChosainShimei(),
                entity.getChosainKanaShimei(),
                entity.getSeibetsu(),
                entity.getChosainShikakuCode(),
                entity.getChikuCode(),
                entity.getYubinNo(),
                entity.getJusho(),
                entity.getTelNo());
    }

    /**
     * 介護認定調査員クラスを介護認定調査員Entityに変換します。
     *
     * @param 介護認定調査員 介護認定調査員クラス
     * @return 介護認定調査員Entity
     */
    public static DbT7013ChosainJohoEntity toKaigoNinteiChosainEntity(KaigoNinteiChosain 介護認定調査員) {
        DbT7013ChosainJohoEntity entity = new DbT7013ChosainJohoEntity();
        entity.setShichosonCode(介護認定調査員.get市町村コード());
        entity.setKaigoJigyoshaNo(介護認定調査員.get介護事業者番号());
        entity.setKaigoChosainNo(介護認定調査員.get介護調査員番号());
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
