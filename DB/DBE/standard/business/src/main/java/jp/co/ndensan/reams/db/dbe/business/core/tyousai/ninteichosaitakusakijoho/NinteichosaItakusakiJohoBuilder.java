/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.tyousai.ninteichosaitakusakijoho;

import jp.co.ndensan.reams.db.dbe.business.core.tyousai.chosainjoho.ChosainJoho;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.chosainjoho.ChosainJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link NinteichosaItakusakiJoho}の編集を行うビルダークラスです。
 */
public class NinteichosaItakusakiJohoBuilder {

    private final DbT5910NinteichosaItakusakiJohoEntity entity;
    private final NinteichosaItakusakiJohoIdentifier id;
    private final Models<ChosainJohoIdentifier, ChosainJoho> chosainJoho;

    /**
     * {@link DbT5910NinteichosaItakusakiJohoEntity}より{@link NinteichosaItakusakiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5910NinteichosaItakusakiJohoEntity}
     * @param id {@link NinteichosaItakusakiJohoIdentifier}
     * @param chosainJoho {@link Models}
     *
     */
    NinteichosaItakusakiJohoBuilder(
            DbT5910NinteichosaItakusakiJohoEntity entity,
            NinteichosaItakusakiJohoIdentifier id,
            Models<ChosainJohoIdentifier, ChosainJoho> chosainJoho) {
        this.entity = entity.clone();
        this.id = id;
        this.chosainJoho = chosainJoho;

    }

    /**
     * 調査員情報のキー情報について判定します。<br>
     * 調査員情報に関連できる認定調査委託先情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は調査員情報リストに調査員情報{@link ChosainJoho}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 調査員情報 {@link ChosainJoho}
     * @return {@link SeishinTechoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public NinteichosaItakusakiJohoBuilder setSeishinTechoNini(ChosainJoho 調査員情報) {
        if (hasSameIdentifier(調査員情報.identifier())) {
            chosainJoho.add(調査員情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(ChosainJohoIdentifier 調査員情報の識別子) {
        return (id.get市町村コード().equals(調査員情報の識別子.get市町村コード())
                && id.get認定調査委託先コード() == 調査員情報の識別子.get認定調査委託先コード());
    }

    /**
     * {@link NinteichosaItakusakiJoho}のインスタンスを生成します。
     *
     * @return {@link NinteichosaItakusakiJoho}のインスタンス
     */
    public NinteichosaItakusakiJoho build() {
        return new NinteichosaItakusakiJoho(entity, id, chosainJoho);
    }
}
