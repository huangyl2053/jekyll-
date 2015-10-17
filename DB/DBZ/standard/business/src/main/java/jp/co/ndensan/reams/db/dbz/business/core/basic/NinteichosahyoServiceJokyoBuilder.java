/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * {@link NinteichosahyoServiceJokyo}の編集を行うビルダークラスです。
 */
public class NinteichosahyoServiceJokyoBuilder {

    private final DbT5207NinteichosahyoServiceJokyoEntity entity;
    private final NinteichosahyoServiceJokyoIdentifier id;

    /**
     * {@link DbT5207NinteichosahyoServiceJokyoEntity}より{@link NinteichosahyoServiceJokyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5207NinteichosahyoServiceJokyoEntity}
     * @param id {@link NinteichosahyoServiceJokyoIdentifier}
     *
     */
    NinteichosahyoServiceJokyoBuilder(
            DbT5207NinteichosahyoServiceJokyoEntity entity,
            NinteichosahyoServiceJokyoIdentifier id
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
     * @return {@link NinteichosahyoServiceJokyoBuilder}
     */
    public NinteichosahyoServiceJokyoBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 認定調査依頼履歴番号を設定します。
     *
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return {@link NinteichosahyoServiceJokyoBuilder}
     */
    public NinteichosahyoServiceJokyoBuilder set認定調査依頼履歴番号(int 認定調査依頼履歴番号) {
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        entity.setNinteichosaRirekiNo(認定調査依頼履歴番号);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link NinteichosahyoServiceJokyoBuilder}
     */
    public NinteichosahyoServiceJokyoBuilder set連番(int 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRemban(連番);
        return this;
    }

    /**
     * サービスの状況を設定します。
     *
     * @param サービスの状況 サービスの状況
     * @return {@link NinteichosahyoServiceJokyoBuilder}
     */
    public NinteichosahyoServiceJokyoBuilder setサービスの状況(int サービスの状況) {
        requireNonNull(サービスの状況, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスの状況"));
        entity.setServiceJokyo(サービスの状況);
        return this;
    }

    /**
     * {@link NinteichosahyoServiceJokyo}のインスタンスを生成します。
     *
     * @return {@link NinteichosahyoServiceJokyo}のインスタンス
     */
    public NinteichosahyoServiceJokyo build() {
        return new NinteichosahyoServiceJokyo(entity, id);
    }
}
