/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShinKyuChosaItakusakiChosainNoHenkan}の編集を行うビルダークラスです。
 */
public class ShinKyuChosaItakusakiChosainNoHenkanBuilder {

    private final DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity;
    private final ShinKyuChosaItakusakiChosainNoHenkanIdentifier id;

    /**
     * {@link DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity}より{@link ShinKyuChosaItakusakiChosainNoHenkan}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity}
     * @param id {@link ShinKyuChosaItakusakiChosainNoHenkanIdentifier}
     *
     */
    ShinKyuChosaItakusakiChosainNoHenkanBuilder(
            DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity,
            ShinKyuChosaItakusakiChosainNoHenkanIdentifier id
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
     * @return {@link ShinKyuChosaItakusakiChosainNoHenkanBuilder}
     */
    public ShinKyuChosaItakusakiChosainNoHenkanBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 新調査委託先番号を設定します。
     *
     * @param 新調査委託先番号 新調査委託先番号
     * @return {@link ShinKyuChosaItakusakiChosainNoHenkanBuilder}
     */
    public ShinKyuChosaItakusakiChosainNoHenkanBuilder set新調査委託先番号(RString 新調査委託先番号) {
        requireNonNull(新調査委託先番号, UrSystemErrorMessages.値がnull.getReplacedMessage("新調査委託先番号"));
        entity.setShinChosaItakusakiNo(新調査委託先番号);
        return this;
    }

    /**
     * 新調査員番号を設定します。
     *
     * @param 新調査員番号 新調査員番号
     * @return {@link ShinKyuChosaItakusakiChosainNoHenkanBuilder}
     */
    public ShinKyuChosaItakusakiChosainNoHenkanBuilder set新調査員番号(RString 新調査員番号) {
        requireNonNull(新調査員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("新調査員番号"));
        entity.setShinChosainNo(新調査員番号);
        return this;
    }

    /**
     * 旧調査委託先番号を設定します。
     *
     * @param 旧調査委託先番号 旧調査委託先番号
     * @return {@link ShinKyuChosaItakusakiChosainNoHenkanBuilder}
     */
    public ShinKyuChosaItakusakiChosainNoHenkanBuilder set旧調査委託先番号(RString 旧調査委託先番号) {
        requireNonNull(旧調査委託先番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧調査委託先番号"));
        entity.setKyuChosaItakusakiNo(旧調査委託先番号);
        return this;
    }

    /**
     * 旧調査員番号を設定します。
     *
     * @param 旧調査員番号 旧調査員番号
     * @return {@link ShinKyuChosaItakusakiChosainNoHenkanBuilder}
     */
    public ShinKyuChosaItakusakiChosainNoHenkanBuilder set旧調査員番号(RString 旧調査員番号) {
        requireNonNull(旧調査員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧調査員番号"));
        entity.setKyuChosainNo(旧調査員番号);
        return this;
    }

    /**
     * 市町村コード２を設定します。
     *
     * @param 市町村コード２ 市町村コード２
     * @return {@link ShinKyuChosaItakusakiChosainNoHenkanBuilder}
     */
    public ShinKyuChosaItakusakiChosainNoHenkanBuilder set市町村コード２(LasdecCode 市町村コード２) {
        requireNonNull(市町村コード２, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード２"));
        entity.setShichosonCode2(市町村コード２);
        return this;
    }

    /**
     * 旧調査委託先番号２を設定します。
     *
     * @param 旧調査委託先番号２ 旧調査委託先番号２
     * @return {@link ShinKyuChosaItakusakiChosainNoHenkanBuilder}
     */
    public ShinKyuChosaItakusakiChosainNoHenkanBuilder set旧調査委託先番号２(RString 旧調査委託先番号２) {
        requireNonNull(旧調査委託先番号２, UrSystemErrorMessages.値がnull.getReplacedMessage("旧調査委託先番号２"));
        entity.setKyuChosaItakusakiNo2(旧調査委託先番号２);
        return this;
    }

    /**
     * 旧調査員番号２を設定します。
     *
     * @param 旧調査員番号２ 旧調査員番号２
     * @return {@link ShinKyuChosaItakusakiChosainNoHenkanBuilder}
     */
    public ShinKyuChosaItakusakiChosainNoHenkanBuilder set旧調査員番号２(RString 旧調査員番号２) {
        requireNonNull(旧調査員番号２, UrSystemErrorMessages.値がnull.getReplacedMessage("旧調査員番号２"));
        entity.setKyuChosainNo2(旧調査員番号２);
        return this;
    }

    /**
     * {@link ShinKyuChosaItakusakiChosainNoHenkan}のインスタンスを生成します。
     *
     * @return {@link ShinKyuChosaItakusakiChosainNoHenkan}のインスタンス
     */
    public ShinKyuChosaItakusakiChosainNoHenkan build() {
        return new ShinKyuChosaItakusakiChosainNoHenkan(entity, id);
    }
}
