/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * {@link NinteiKekkaJoho}の編集を行うビルダークラスです。
 */
public class NinteiKekkaJohoBuilder {

    private final DbT5102NinteiKekkaJohoEntity entity;
    private final NinteiKekkaJohoIdentifier id;

    /**
     * {@link DbT5102NinteiKekkaJohoEntity}より{@link NinteiKekkaJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5102NinteiKekkaJohoEntity}
     * @param id {@link NinteiKekkaJohoIdentifier}
     *
     */
    NinteiKekkaJohoBuilder(
            DbT5102NinteiKekkaJohoEntity entity,
            NinteiKekkaJohoIdentifier id
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
     * @return {@link NinteiKekkaJohoBuilder}
     */
    public NinteiKekkaJohoBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * {@link NinteiKekkaJoho}のインスタンスを生成します。
     *
     * @return {@link NinteiKekkaJoho}のインスタンス
     */
    public NinteiKekkaJoho build() {
        return new NinteiKekkaJoho(entity, id);
    }
}
