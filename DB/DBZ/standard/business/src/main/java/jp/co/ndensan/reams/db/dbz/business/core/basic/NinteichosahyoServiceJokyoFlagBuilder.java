/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * {@link NinteichosahyoServiceJokyoFlag}の編集を行うビルダークラスです。
 */
public class NinteichosahyoServiceJokyoFlagBuilder {

    private final DbT5208NinteichosahyoServiceJokyoFlagEntity entity;
    private final NinteichosahyoServiceJokyoFlagIdentifier id;

    /**
     * {@link DbT5208NinteichosahyoServiceJokyoFlagEntity}より{@link NinteichosahyoServiceJokyoFlag}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5208NinteichosahyoServiceJokyoFlagEntity}
     * @param id {@link NinteichosahyoServiceJokyoFlagIdentifier}
     *
     */
    NinteichosahyoServiceJokyoFlagBuilder(
            DbT5208NinteichosahyoServiceJokyoFlagEntity entity,
            NinteichosahyoServiceJokyoFlagIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return {@link NinteichosahyoServiceJokyoFlagBuilder}
     */
    public NinteichosahyoServiceJokyoFlagBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 認定調査依頼履歴番号を設定します。
     *
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return {@link NinteichosahyoServiceJokyoFlagBuilder}
     */
    public NinteichosahyoServiceJokyoFlagBuilder set認定調査依頼履歴番号(int 認定調査依頼履歴番号) {
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        entity.setNinteichosaRirekiNo(認定調査依頼履歴番号);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link NinteichosahyoServiceJokyoFlagBuilder}
     */
    public NinteichosahyoServiceJokyoFlagBuilder set連番(int 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRemban(連番);
        return this;
    }

    /**
     * サービスの状況フラグを設定します。
     *
     * @param サービスの状況フラグ サービスの状況フラグ
     * @return {@link NinteichosahyoServiceJokyoFlagBuilder}
     */
    public NinteichosahyoServiceJokyoFlagBuilder setサービスの状況フラグ(boolean サービスの状況フラグ) {
        requireNonNull(サービスの状況フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスの状況フラグ"));
        entity.setServiceJokyoFlag(サービスの状況フラグ);
        return this;
    }

    /**
     * {@link NinteichosahyoServiceJokyoFlag}のインスタンスを生成します。
     *
     * @return {@link NinteichosahyoServiceJokyoFlag}のインスタンス
     */
    public NinteichosahyoServiceJokyoFlag build() {
        return new NinteichosahyoServiceJokyoFlag(entity, id);
    }
}
