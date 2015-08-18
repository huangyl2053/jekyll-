/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShinKyuHihokenshaNoHenkan}の編集を行うビルダークラスです。
 */
public class ShinKyuHihokenshaNoHenkanBuilder {

    private final DbT7026ShinKyuHihokenshaNoHenkanEntity entity;
    private final ShinKyuHihokenshaNoHenkanIdentifier id;

    /**
     * {@link DbT7026ShinKyuHihokenshaNoHenkanEntity}より{@link ShinKyuHihokenshaNoHenkan}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7026ShinKyuHihokenshaNoHenkanEntity}
     * @param id {@link ShinKyuHihokenshaNoHenkanIdentifier}
     *
     */
    ShinKyuHihokenshaNoHenkanBuilder(
            DbT7026ShinKyuHihokenshaNoHenkanEntity entity,
            ShinKyuHihokenshaNoHenkanIdentifier id
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
     * @return {@link ShinKyuHihokenshaNoHenkanBuilder}
     */
    public ShinKyuHihokenshaNoHenkanBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 新番号を設定します。
     *
     * @param 新番号 新番号
     * @return {@link ShinKyuHihokenshaNoHenkanBuilder}
     */
    public ShinKyuHihokenshaNoHenkanBuilder set新番号(RString 新番号) {
        requireNonNull(新番号, UrSystemErrorMessages.値がnull.getReplacedMessage("新番号"));
        entity.setShinNo(新番号);
        return this;
    }

    /**
     * 旧番号を設定します。
     *
     * @param 旧番号 旧番号
     * @return {@link ShinKyuHihokenshaNoHenkanBuilder}
     */
    public ShinKyuHihokenshaNoHenkanBuilder set旧番号(RString 旧番号) {
        requireNonNull(旧番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧番号"));
        entity.setKyuNo(旧番号);
        return this;
    }

    /**
     * 旧市町村コード２を設定します。
     *
     * @param 旧市町村コード２ 旧市町村コード２
     * @return {@link ShinKyuHihokenshaNoHenkanBuilder}
     */
    public ShinKyuHihokenshaNoHenkanBuilder set旧市町村コード２(LasdecCode 旧市町村コード２) {
        requireNonNull(旧市町村コード２, UrSystemErrorMessages.値がnull.getReplacedMessage("旧市町村コード２"));
        entity.setKyuShichosonCode(旧市町村コード２);
        return this;
    }

    /**
     * 旧番号２を設定します。
     *
     * @param 旧番号２ 旧番号２
     * @return {@link ShinKyuHihokenshaNoHenkanBuilder}
     */
    public ShinKyuHihokenshaNoHenkanBuilder set旧番号２(RString 旧番号２) {
        requireNonNull(旧番号２, UrSystemErrorMessages.値がnull.getReplacedMessage("旧番号２"));
        entity.setKyuNo2(旧番号２);
        return this;
    }

    /**
     * {@link ShinKyuHihokenshaNoHenkan}のインスタンスを生成します。
     *
     * @return {@link ShinKyuHihokenshaNoHenkan}のインスタンス
     */
    public ShinKyuHihokenshaNoHenkan build() {
        return new ShinKyuHihokenshaNoHenkan(entity, id);
    }
}
