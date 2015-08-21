/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7908KaigoDonyuKeitaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KaigoDonyuKeitai}の編集を行うビルダークラスです。
 */
public class KaigoDonyuKeitaiBuilder {

    private final DbT7908KaigoDonyuKeitaiEntity entity;
    private final KaigoDonyuKeitaiIdentifier id;

    /**
     * {@link DbT7908KaigoDonyuKeitaiEntity}より{@link KaigoDonyuKeitai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7908KaigoDonyuKeitaiEntity}
     * @param id {@link KaigoDonyuKeitaiIdentifier}
     *
     */
    KaigoDonyuKeitaiBuilder(
            DbT7908KaigoDonyuKeitaiEntity entity,
            KaigoDonyuKeitaiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 業務分類を設定します。
     *
     * @param 業務分類 業務分類
     * @return {@link KaigoDonyuKeitaiBuilder}
     */
    public KaigoDonyuKeitaiBuilder set業務分類(RString 業務分類) {
        requireNonNull(業務分類, UrSystemErrorMessages.値がnull.getReplacedMessage("業務分類"));
        entity.setGyomuBunrui(業務分類);
        return this;
    }

    /**
     * 導入形態コードを設定します。
     *
     * @param 導入形態コード 導入形態コード
     * @return {@link KaigoDonyuKeitaiBuilder}
     */
    public KaigoDonyuKeitaiBuilder set導入形態コード(Code 導入形態コード) {
        requireNonNull(導入形態コード, UrSystemErrorMessages.値がnull.getReplacedMessage("導入形態コード"));
        entity.setDonyuKeitaiCode(導入形態コード);
        return this;
    }

    /**
     * 支所管理有無フラグを設定します。
     *
     * @param 支所管理有無フラグ 支所管理有無フラグ
     * @return {@link KaigoDonyuKeitaiBuilder}
     */
    public KaigoDonyuKeitaiBuilder set支所管理有無フラグ(boolean 支所管理有無フラグ) {
        requireNonNull(支所管理有無フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("支所管理有無フラグ"));
        entity.setShishoKanriUmuFlag(支所管理有無フラグ);
        return this;
    }

    /**
     * {@link KaigoDonyuKeitai}のインスタンスを生成します。
     *
     * @return {@link KaigoDonyuKeitai}のインスタンス
     */
    public KaigoDonyuKeitai build() {
        return new KaigoDonyuKeitai(entity, id);
    }
}
