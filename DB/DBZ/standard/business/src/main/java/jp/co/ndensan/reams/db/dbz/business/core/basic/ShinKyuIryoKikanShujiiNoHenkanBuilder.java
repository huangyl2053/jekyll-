/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShinKyuIryoKikanShujiiNoHenkan}の編集を行うビルダークラスです。
 */
public class ShinKyuIryoKikanShujiiNoHenkanBuilder {

    private final DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity;
    private final ShinKyuIryoKikanShujiiNoHenkanIdentifier id;

    /**
     * {@link DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity}より{@link ShinKyuIryoKikanShujiiNoHenkan}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity}
     * @param id {@link ShinKyuIryoKikanShujiiNoHenkanIdentifier}
     *
     */
    ShinKyuIryoKikanShujiiNoHenkanBuilder(
            DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity,
            ShinKyuIryoKikanShujiiNoHenkanIdentifier id
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
     * @return {@link ShinKyuIryoKikanShujiiNoHenkanBuilder}
     */
    public ShinKyuIryoKikanShujiiNoHenkanBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 新医療機関番号を設定します。
     *
     * @param 新医療機関番号 新医療機関番号
     * @return {@link ShinKyuIryoKikanShujiiNoHenkanBuilder}
     */
    public ShinKyuIryoKikanShujiiNoHenkanBuilder set新医療機関番号(RString 新医療機関番号) {
        requireNonNull(新医療機関番号, UrSystemErrorMessages.値がnull.getReplacedMessage("新医療機関番号"));
        entity.setShinIryoKikanNo(新医療機関番号);
        return this;
    }

    /**
     * 新主治医番号を設定します。
     *
     * @param 新主治医番号 新主治医番号
     * @return {@link ShinKyuIryoKikanShujiiNoHenkanBuilder}
     */
    public ShinKyuIryoKikanShujiiNoHenkanBuilder set新主治医番号(RString 新主治医番号) {
        requireNonNull(新主治医番号, UrSystemErrorMessages.値がnull.getReplacedMessage("新主治医番号"));
        entity.setShinShujiiNo(新主治医番号);
        return this;
    }

    /**
     * 旧医療機関番号を設定します。
     *
     * @param 旧医療機関番号 旧医療機関番号
     * @return {@link ShinKyuIryoKikanShujiiNoHenkanBuilder}
     */
    public ShinKyuIryoKikanShujiiNoHenkanBuilder set旧医療機関番号(RString 旧医療機関番号) {
        requireNonNull(旧医療機関番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧医療機関番号"));
        entity.setKyuIryoKikanNo(旧医療機関番号);
        return this;
    }

    /**
     * 旧主治医番号を設定します。
     *
     * @param 旧主治医番号 旧主治医番号
     * @return {@link ShinKyuIryoKikanShujiiNoHenkanBuilder}
     */
    public ShinKyuIryoKikanShujiiNoHenkanBuilder set旧主治医番号(RString 旧主治医番号) {
        requireNonNull(旧主治医番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧主治医番号"));
        entity.setKyuShujiiNo(旧主治医番号);
        return this;
    }

    /**
     * 市町村コード２を設定します。
     *
     * @param 市町村コード２ 市町村コード２
     * @return {@link ShinKyuIryoKikanShujiiNoHenkanBuilder}
     */
    public ShinKyuIryoKikanShujiiNoHenkanBuilder set市町村コード２(LasdecCode 市町村コード２) {
        requireNonNull(市町村コード２, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード２"));
        entity.setShichosonCode2(市町村コード２);
        return this;
    }

    /**
     * 旧医療機関番号２を設定します。
     *
     * @param 旧医療機関番号２ 旧医療機関番号２
     * @return {@link ShinKyuIryoKikanShujiiNoHenkanBuilder}
     */
    public ShinKyuIryoKikanShujiiNoHenkanBuilder set旧医療機関番号２(RString 旧医療機関番号２) {
        requireNonNull(旧医療機関番号２, UrSystemErrorMessages.値がnull.getReplacedMessage("旧医療機関番号２"));
        entity.setKyuIryoKikanNo2(旧医療機関番号２);
        return this;
    }

    /**
     * 旧主治医番号２を設定します。
     *
     * @param 旧主治医番号２ 旧主治医番号２
     * @return {@link ShinKyuIryoKikanShujiiNoHenkanBuilder}
     */
    public ShinKyuIryoKikanShujiiNoHenkanBuilder set旧主治医番号２(RString 旧主治医番号２) {
        requireNonNull(旧主治医番号２, UrSystemErrorMessages.値がnull.getReplacedMessage("旧主治医番号２"));
        entity.setKyuShujiiNo2(旧主治医番号２);
        return this;
    }

    /**
     * {@link ShinKyuIryoKikanShujiiNoHenkan}のインスタンスを生成します。
     *
     * @return {@link ShinKyuIryoKikanShujiiNoHenkan}のインスタンス
     */
    public ShinKyuIryoKikanShujiiNoHenkan build() {
        return new ShinKyuIryoKikanShujiiNoHenkan(entity, id);
    }
}
