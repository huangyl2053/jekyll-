/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7027KakushuCodeHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KakushuCodeHenkan}の編集を行うビルダークラスです。
 */
public class KakushuCodeHenkanBuilder {

    private final DbT7027KakushuCodeHenkanEntity entity;
    private final KakushuCodeHenkanIdentifier id;

    /**
     * {@link DbT7027KakushuCodeHenkanEntity}より{@link KakushuCodeHenkan}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7027KakushuCodeHenkanEntity}
     * @param id {@link KakushuCodeHenkanIdentifier}
     *
     */
    KakushuCodeHenkanBuilder(
            DbT7027KakushuCodeHenkanEntity entity,
            KakushuCodeHenkanIdentifier id
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
     * @return {@link KakushuCodeHenkanBuilder}
     */
    public KakushuCodeHenkanBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * コード区分を設定します。
     *
     * @param コード区分 コード区分
     * @return {@link KakushuCodeHenkanBuilder}
     */
    public KakushuCodeHenkanBuilder setコード区分(RString コード区分) {
        requireNonNull(コード区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード区分"));
        entity.setCodeKubun(コード区分);
        return this;
    }

    /**
     * 内部コードを設定します。
     *
     * @param 内部コード 内部コード
     * @return {@link KakushuCodeHenkanBuilder}
     */
    public KakushuCodeHenkanBuilder set内部コード(RString 内部コード) {
        requireNonNull(内部コード, UrSystemErrorMessages.値がnull.getReplacedMessage("内部コード"));
        entity.setNaibuCode(内部コード);
        return this;
    }

    /**
     * 内部番号を設定します。
     *
     * @param 内部番号 内部番号
     * @return {@link KakushuCodeHenkanBuilder}
     */
    public KakushuCodeHenkanBuilder set内部番号(RString 内部番号) {
        requireNonNull(内部番号, UrSystemErrorMessages.値がnull.getReplacedMessage("内部番号"));
        entity.setNaibuNo(内部番号);
        return this;
    }

    /**
     * 外部コードを設定します。
     *
     * @param 外部コード 外部コード
     * @return {@link KakushuCodeHenkanBuilder}
     */
    public KakushuCodeHenkanBuilder set外部コード(RString 外部コード) {
        requireNonNull(外部コード, UrSystemErrorMessages.値がnull.getReplacedMessage("外部コード"));
        entity.setGaibuCode(外部コード);
        return this;
    }

    /**
     * 市町村コード２を設定します。
     *
     * @param 市町村コード２ 市町村コード２
     * @return {@link KakushuCodeHenkanBuilder}
     */
    public KakushuCodeHenkanBuilder set市町村コード２(LasdecCode 市町村コード２) {
        requireNonNull(市町村コード２, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード２"));
        entity.setShichosonCode2(市町村コード２);
        return this;
    }

    /**
     * 外部コード２を設定します。
     *
     * @param 外部コード２ 外部コード２
     * @return {@link KakushuCodeHenkanBuilder}
     */
    public KakushuCodeHenkanBuilder set外部コード２(RString 外部コード２) {
        requireNonNull(外部コード２, UrSystemErrorMessages.値がnull.getReplacedMessage("外部コード２"));
        entity.setGaibuCode2(外部コード２);
        return this;
    }

    /**
     * {@link KakushuCodeHenkan}のインスタンスを生成します。
     *
     * @return {@link KakushuCodeHenkan}のインスタンス
     */
    public KakushuCodeHenkan build() {
        return new KakushuCodeHenkan(entity, id);
    }
}
