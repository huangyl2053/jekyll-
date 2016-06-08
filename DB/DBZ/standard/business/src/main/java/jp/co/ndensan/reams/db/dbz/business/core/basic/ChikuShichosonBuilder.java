/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5224ChikuShichosonEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * {@link ChikuShichoson}の編集を行うビルダークラスです。
 */
public class ChikuShichosonBuilder {

    private final DbT5224ChikuShichosonEntity entity;
    private final ChikuShichosonIdentifier id;

    /**
     * {@link DbT5224ChikuShichosonEntity}より{@link ChikuShichoson}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5224ChikuShichosonEntity}
     * @param id {@link ChikuShichosonIdentifier}
     *
     */
    ChikuShichosonBuilder(
            DbT5224ChikuShichosonEntity entity,
            ChikuShichosonIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 調査地区コードを設定します。
     *
     * @param 調査地区コード 調査地区コード
     * @return {@link ChikuShichosonBuilder}
     */
    public ChikuShichosonBuilder set調査地区コード(Code 調査地区コード) {
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        entity.setChosaChikuCode(調査地区コード);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link ChikuShichosonBuilder}
     */
    public ChikuShichosonBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 優先番号を設定します。
     *
     * @param 優先番号 優先番号
     * @return {@link ChikuShichosonBuilder}
     */
    public ChikuShichosonBuilder set優先番号(int 優先番号) {
        requireNonNull(優先番号, UrSystemErrorMessages.値がnull.getReplacedMessage("優先番号"));
        entity.setYusenNo(優先番号);
        return this;
    }

    /**
     * 自地区フラグを設定します。
     *
     * @param 自地区フラグ 自地区フラグ
     * @return {@link ChikuShichosonBuilder}
     */
    public ChikuShichosonBuilder set自地区フラグ(boolean 自地区フラグ) {
        requireNonNull(自地区フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("自地区フラグ"));
        entity.setJiChikuFlag(自地区フラグ);
        return this;
    }

    /**
     * {@link ChikuShichoson}のインスタンスを生成します。
     *
     * @return {@link ChikuShichoson}のインスタンス
     */
    public ChikuShichoson build() {
        return new ChikuShichoson(entity, id);
    }
}
