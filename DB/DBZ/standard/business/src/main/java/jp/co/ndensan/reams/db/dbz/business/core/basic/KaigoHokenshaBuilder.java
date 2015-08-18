/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7050KaigoHokenshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * {@link KaigoHokensha}の編集を行うビルダークラスです。
 */
public class KaigoHokenshaBuilder {

    private final DbT7050KaigoHokenshaEntity entity;
    private final KaigoHokenshaIdentifier id;

    /**
     * {@link DbT7050KaigoHokenshaEntity}より{@link KaigoHokensha}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7050KaigoHokenshaEntity}
     * @param id {@link KaigoHokenshaIdentifier}
     *
     */
    KaigoHokenshaBuilder(
            DbT7050KaigoHokenshaEntity entity,
            KaigoHokenshaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 広域保険者市町村コードを設定します。
     *
     * @param 広域保険者市町村コード 広域保険者市町村コード
     * @return {@link KaigoHokenshaBuilder}
     */
    public KaigoHokenshaBuilder set広域保険者市町村コード(LasdecCode 広域保険者市町村コード) {
        requireNonNull(広域保険者市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("広域保険者市町村コード"));
        entity.setKoikiHokenshaShichosonCode(広域保険者市町村コード);
        return this;
    }

    /**
     * 広域保険者番号を設定します。
     *
     * @param 広域保険者番号 広域保険者番号
     * @return {@link KaigoHokenshaBuilder}
     */
    public KaigoHokenshaBuilder set広域保険者番号(ShoKisaiHokenshaNo 広域保険者番号) {
        requireNonNull(広域保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("広域保険者番号"));
        entity.setKoikiHokenshaNo(広域保険者番号);
        return this;
    }

    /**
     * {@link KaigoHokensha}のインスタンスを生成します。
     *
     * @return {@link KaigoHokensha}のインスタンス
     */
    public KaigoHokensha build() {
        return new KaigoHokensha(entity, id);
    }
}
