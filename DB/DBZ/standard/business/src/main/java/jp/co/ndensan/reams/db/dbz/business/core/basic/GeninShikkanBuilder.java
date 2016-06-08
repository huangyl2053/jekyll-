/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5300GeninShikkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * {@link GeninShikkan}の編集を行うビルダークラスです。
 */
public class GeninShikkanBuilder {

    private final DbT5300GeninShikkanEntity entity;
    private final GeninShikkanIdentifier id;

    /**
     * {@link DbT5300GeninShikkanEntity}より{@link GeninShikkan}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5300GeninShikkanEntity}
     * @param id {@link GeninShikkanIdentifier}
     *
     */
    GeninShikkanBuilder(
            DbT5300GeninShikkanEntity entity,
            GeninShikkanIdentifier id
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
     * @return {@link GeninShikkanBuilder}
     */
    public GeninShikkanBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link GeninShikkanBuilder}
     */
    public GeninShikkanBuilder set連番(int 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRemban(連番);
        return this;
    }

    /**
     * 主たる原因疾患フラグを設定します。
     *
     * @param 主たる原因疾患フラグ 主たる原因疾患フラグ
     * @return {@link GeninShikkanBuilder}
     */
    public GeninShikkanBuilder set主たる原因疾患フラグ(boolean 主たる原因疾患フラグ) {
        requireNonNull(主たる原因疾患フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("主たる原因疾患フラグ"));
        entity.setIsShutaruGeninShikkan(主たる原因疾患フラグ);
        return this;
    }

    /**
     * 原因疾患コードを設定します。
     *
     * @param 原因疾患コード 原因疾患コード
     * @return {@link GeninShikkanBuilder}
     */
    public GeninShikkanBuilder set原因疾患コード(Code 原因疾患コード) {
        requireNonNull(原因疾患コード, UrSystemErrorMessages.値がnull.getReplacedMessage("原因疾患コード"));
        entity.setGeninShikkanCode(原因疾患コード);
        return this;
    }

    /**
     * {@link GeninShikkan}のインスタンスを生成します。
     *
     * @return {@link GeninShikkan}のインスタンス
     */
    public GeninShikkan build() {
        return new GeninShikkan(entity, id);
    }
}
