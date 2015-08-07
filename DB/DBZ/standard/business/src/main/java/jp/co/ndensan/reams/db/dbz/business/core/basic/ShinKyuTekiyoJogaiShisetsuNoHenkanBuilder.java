/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShinKyuTekiyoJogaiShisetsuNoHenkan}の編集を行うビルダークラスです。
 */
public class ShinKyuTekiyoJogaiShisetsuNoHenkanBuilder {

    private final DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity entity;
    private final ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifier id;

    /**
     * {@link DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity}より{@link ShinKyuTekiyoJogaiShisetsuNoHenkan}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity}
     * @param id {@link ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifier}
     *
     */
    ShinKyuTekiyoJogaiShisetsuNoHenkanBuilder(
            DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity entity,
            ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifier id
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
     * @return {@link ShinKyuTekiyoJogaiShisetsuNoHenkanBuilder}
     */
    public ShinKyuTekiyoJogaiShisetsuNoHenkanBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 新適用除外施設番号を設定します。
     *
     * @param 新適用除外施設番号 新適用除外施設番号
     * @return {@link ShinKyuTekiyoJogaiShisetsuNoHenkanBuilder}
     */
    public ShinKyuTekiyoJogaiShisetsuNoHenkanBuilder set新適用除外施設番号(RString 新適用除外施設番号) {
        requireNonNull(新適用除外施設番号, UrSystemErrorMessages.値がnull.getReplacedMessage("新適用除外施設番号"));
        entity.setShinTekiyoJogaiShisetsuNo(新適用除外施設番号);
        return this;
    }

    /**
     * 旧適用除外施設番号を設定します。
     *
     * @param 旧適用除外施設番号 旧適用除外施設番号
     * @return {@link ShinKyuTekiyoJogaiShisetsuNoHenkanBuilder}
     */
    public ShinKyuTekiyoJogaiShisetsuNoHenkanBuilder set旧適用除外施設番号(RString 旧適用除外施設番号) {
        requireNonNull(旧適用除外施設番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧適用除外施設番号"));
        entity.setKyuTekiyoJogaiShisetsuNo(旧適用除外施設番号);
        return this;
    }

    /**
     * 市町村コード２を設定します。
     *
     * @param 市町村コード２ 市町村コード２
     * @return {@link ShinKyuTekiyoJogaiShisetsuNoHenkanBuilder}
     */
    public ShinKyuTekiyoJogaiShisetsuNoHenkanBuilder set市町村コード２(LasdecCode 市町村コード２) {
        requireNonNull(市町村コード２, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード２"));
        entity.setShichosonCode2(市町村コード２);
        return this;
    }

    /**
     * 旧適用除外施設番号２を設定します。
     *
     * @param 旧適用除外施設番号２ 旧適用除外施設番号２
     * @return {@link ShinKyuTekiyoJogaiShisetsuNoHenkanBuilder}
     */
    public ShinKyuTekiyoJogaiShisetsuNoHenkanBuilder set旧適用除外施設番号２(RString 旧適用除外施設番号２) {
        requireNonNull(旧適用除外施設番号２, UrSystemErrorMessages.値がnull.getReplacedMessage("旧適用除外施設番号２"));
        entity.setKyuTekiyoJogaiShisetsuNo2(旧適用除外施設番号２);
        return this;
    }

    /**
     * {@link ShinKyuTekiyoJogaiShisetsuNoHenkan}のインスタンスを生成します。
     *
     * @return {@link ShinKyuTekiyoJogaiShisetsuNoHenkan}のインスタンス
     */
    public ShinKyuTekiyoJogaiShisetsuNoHenkan build() {
        return new ShinKyuTekiyoJogaiShisetsuNoHenkan(entity, id);
    }
}
