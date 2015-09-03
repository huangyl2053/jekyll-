/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7025KoikiNoHatsubanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KoikiNoHatsuban}の編集を行うビルダークラスです。
 */
public class KoikiNoHatsubanBuilder {

    private final DbT7025KoikiNoHatsubanEntity entity;
    private final KoikiNoHatsubanIdentifier id;

    /**
     * {@link DbT7025KoikiNoHatsubanEntity}より{@link KoikiNoHatsuban}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7025KoikiNoHatsubanEntity}
     * @param id {@link KoikiNoHatsubanIdentifier}
     *
     */
    KoikiNoHatsubanBuilder(
            DbT7025KoikiNoHatsubanEntity entity,
            KoikiNoHatsubanIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link KoikiNoHatsubanBuilder}
     */
    public KoikiNoHatsubanBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * コード区分を設定します。
     *
     * @param コード区分 コード区分
     * @return {@link KoikiNoHatsubanBuilder}
     */
    public KoikiNoHatsubanBuilder setコード区分(RString コード区分) {
        requireNonNull(コード区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード区分"));
        entity.setCodeKubun(コード区分);
        return this;
    }

    /**
     * 番号を設定します。
     *
     * @param 番号 番号
     * @return {@link KoikiNoHatsubanBuilder}
     */
    public KoikiNoHatsubanBuilder set番号(RString 番号) {
        requireNonNull(番号, UrSystemErrorMessages.値がnull.getReplacedMessage("番号"));
        entity.setNo(番号);
        return this;
    }

    /**
     * {@link KoikiNoHatsuban}のインスタンスを生成します。
     *
     * @return {@link KoikiNoHatsuban}のインスタンス
     */
    public KoikiNoHatsuban build() {
        return new KoikiNoHatsuban(entity, id);
    }
}
