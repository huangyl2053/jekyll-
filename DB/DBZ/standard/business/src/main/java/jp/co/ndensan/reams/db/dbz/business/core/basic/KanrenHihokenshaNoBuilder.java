/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7054KanrenHihokenshaNoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * {@link KanrenHihokenshaNo}の編集を行うビルダークラスです。
 */
public class KanrenHihokenshaNoBuilder {

    private final DbT7054KanrenHihokenshaNoEntity entity;
    private final KanrenHihokenshaNoIdentifier id;

    /**
     * {@link DbT7054KanrenHihokenshaNoEntity}より{@link KanrenHihokenshaNo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7054KanrenHihokenshaNoEntity}
     * @param id {@link KanrenHihokenshaNoIdentifier}
     *
     */
    KanrenHihokenshaNoBuilder(
            DbT7054KanrenHihokenshaNoEntity entity,
            KanrenHihokenshaNoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KanrenHihokenshaNoBuilder}
     */
    public KanrenHihokenshaNoBuilder set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 最新被保険者番号を設定します。
     *
     * @param 最新被保険者番号 最新被保険者番号
     * @return {@link KanrenHihokenshaNoBuilder}
     */
    public KanrenHihokenshaNoBuilder set最新被保険者番号(HihokenshaNo 最新被保険者番号) {
        requireNonNull(最新被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("最新被保険者番号"));
        entity.setSaishinHihokenshaNo(最新被保険者番号);
        return this;
    }

    /**
     * 旧被保険者番号を設定します。
     *
     * @param 旧被保険者番号 旧被保険者番号
     * @return {@link KanrenHihokenshaNoBuilder}
     */
    public KanrenHihokenshaNoBuilder set旧被保険者番号(HihokenshaNo 旧被保険者番号) {
        requireNonNull(旧被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧被保険者番号"));
        entity.setKyuuHihokenshaNo(旧被保険者番号);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link KanrenHihokenshaNoBuilder}
     */
    public KanrenHihokenshaNoBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * {@link KanrenHihokenshaNo}のインスタンスを生成します。
     *
     * @return {@link KanrenHihokenshaNo}のインスタンス
     */
    public KanrenHihokenshaNo build() {
        return new KanrenHihokenshaNo(entity, id);
    }
}
