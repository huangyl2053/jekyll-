/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7028KakushuShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KakushuShinKyuNoHenkan}の編集を行うビルダークラスです。
 */
public class KakushuShinKyuNoHenkanBuilder {

    private final DbT7028KakushuShinKyuNoHenkanEntity entity;
    private final KakushuShinKyuNoHenkanIdentifier id;

    /**
     * {@link DbT7028KakushuShinKyuNoHenkanEntity}より{@link KakushuShinKyuNoHenkan}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7028KakushuShinKyuNoHenkanEntity}
     * @param id {@link KakushuShinKyuNoHenkanIdentifier}
     *
     */
    KakushuShinKyuNoHenkanBuilder(
            DbT7028KakushuShinKyuNoHenkanEntity entity,
            KakushuShinKyuNoHenkanIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KakushuShinKyuNoHenkanBuilder}
     */
    public KakushuShinKyuNoHenkanBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 番号区分を設定します。
     *
     * @param 番号区分 番号区分
     * @return {@link KakushuShinKyuNoHenkanBuilder}
     */
    public KakushuShinKyuNoHenkanBuilder set番号区分(RString 番号区分) {
        requireNonNull(番号区分, UrSystemErrorMessages.値がnull.getReplacedMessage("番号区分"));
        entity.setNoKubun(番号区分);
        return this;
    }

    /**
     * 新番号を設定します。
     *
     * @param 新番号 新番号
     * @return {@link KakushuShinKyuNoHenkanBuilder}
     */
    public KakushuShinKyuNoHenkanBuilder set新番号(RString 新番号) {
        requireNonNull(新番号, UrSystemErrorMessages.値がnull.getReplacedMessage("新番号"));
        entity.setShinNo(新番号);
        return this;
    }

    /**
     * 旧番号を設定します。
     *
     * @param 旧番号 旧番号
     * @return {@link KakushuShinKyuNoHenkanBuilder}
     */
    public KakushuShinKyuNoHenkanBuilder set旧番号(RString 旧番号) {
        requireNonNull(旧番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧番号"));
        entity.setKyuNo(旧番号);
        return this;
    }

    /**
     * {@link KakushuShinKyuNoHenkan}のインスタンスを生成します。
     *
     * @return {@link KakushuShinKyuNoHenkan}のインスタンス
     */
    public KakushuShinKyuNoHenkan build() {
        return new KakushuShinKyuNoHenkan(entity, id);
    }
}
