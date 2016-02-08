/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tekiyojogaisha.tekiyojogaisha;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.tekiyojogaisha.shisetsunyutaisho.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dba.business.core.tekiyojogaisha.shisetsunyutaisho.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dbx.business.core.uzclasses.Models;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link TekiyoJogaisha}の編集を行うビルダークラスです。
 */
public class TekiyoJogaishaBuilder {

    private final DbT1002TekiyoJogaishaEntity entity;
    private final TekiyoJogaishaIdentifier id;
    private final Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaisho;

    /**
     * {@link DbT1002TekiyoJogaishaEntity}より{@link TekiyoJogaisha}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT1002TekiyoJogaishaEntity}
     * @param id {@link TekiyoJogaishaIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    TekiyoJogaishaBuilder(
            DbT1002TekiyoJogaishaEntity entity,
            TekiyoJogaishaIdentifier id,
            Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaisho
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.shisetsuNyutaisho = shisetsuNyutaisho.clone();
    }

    /**
     * 異動事由コードを設定します。
     *
     * @param 異動事由コード 異動事由コード
     * @return {@link TekiyoJogaishaBuilder}
     */
    public TekiyoJogaishaBuilder set異動事由コード(RString 異動事由コード) {
        requireNonNull(異動事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("異動事由コード"));
        entity.setIdoJiyuCode(異動事由コード);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link TekiyoJogaishaBuilder}
     */
    public TekiyoJogaishaBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 適用除外適用事由コードを設定します。
     *
     * @param 適用除外適用事由コード 適用除外適用事由コード
     * @return {@link TekiyoJogaishaBuilder}
     */
    public TekiyoJogaishaBuilder set適用除外適用事由コード(RString 適用除外適用事由コード) {
        requireNonNull(適用除外適用事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("適用除外適用事由コード"));
        entity.setTekiyoJogaiTekiyoJiyuCode(適用除外適用事由コード);
        return this;
    }

    /**
     * 適用年月日を設定します。
     *
     * @param 適用年月日 適用年月日
     * @return {@link TekiyoJogaishaBuilder}
     */
    public TekiyoJogaishaBuilder set適用年月日(FlexibleDate 適用年月日) {
        requireNonNull(適用年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用年月日"));
        entity.setTekiyoYMD(適用年月日);
        return this;
    }

    /**
     * 適用届出年月日を設定します。
     *
     * @param 適用届出年月日 適用届出年月日
     * @return {@link TekiyoJogaishaBuilder}
     */
    public TekiyoJogaishaBuilder set適用届出年月日(FlexibleDate 適用届出年月日) {
        requireNonNull(適用届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用届出年月日"));
        entity.setTekiyoTodokedeYMD(適用届出年月日);
        return this;
    }

    /**
     * 適用受付年月日を設定します。
     *
     * @param 適用受付年月日 適用受付年月日
     * @return {@link TekiyoJogaishaBuilder}
     */
    public TekiyoJogaishaBuilder set適用受付年月日(FlexibleDate 適用受付年月日) {
        requireNonNull(適用受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用受付年月日"));
        entity.setTekiyoUketsukeYMD(適用受付年月日);
        return this;
    }

    /**
     * 適用除外解除事由コードを設定します。
     *
     * @param 適用除外解除事由コード 適用除外解除事由コード
     * @return {@link TekiyoJogaishaBuilder}
     */
    public TekiyoJogaishaBuilder set適用除外解除事由コード(RString 適用除外解除事由コード) {
        requireNonNull(適用除外解除事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("適用除外解除事由コード"));
        entity.setTekiyoJogaikaijokaijoJiyuCode(適用除外解除事由コード);
        return this;
    }

    /**
     * 解除年月日を設定します。
     *
     * @param 解除年月日 解除年月日
     * @return {@link TekiyoJogaishaBuilder}
     */
    public TekiyoJogaishaBuilder set解除年月日(FlexibleDate 解除年月日) {
        requireNonNull(解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除年月日"));
        entity.setKaijoYMD(解除年月日);
        return this;
    }

    /**
     * 解除届出年月日を設定します。
     *
     * @param 解除届出年月日 解除届出年月日
     * @return {@link TekiyoJogaishaBuilder}
     */
    public TekiyoJogaishaBuilder set解除届出年月日(FlexibleDate 解除届出年月日) {
        requireNonNull(解除届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除届出年月日"));
        entity.setKaijoTodokedeYMD(解除届出年月日);
        return this;
    }

    /**
     * 解除受付年月日を設定します。
     *
     * @param 解除受付年月日 解除受付年月日
     * @return {@link TekiyoJogaishaBuilder}
     */
    public TekiyoJogaishaBuilder set解除受付年月日(FlexibleDate 解除受付年月日) {
        requireNonNull(解除受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除受付年月日"));
        entity.setKaijoUketsukeYMD(解除受付年月日);
        return this;
    }

    /**
     * 入所通知発行日を設定します。
     *
     * @param 入所通知発行日 入所通知発行日
     * @return {@link TekiyoJogaishaBuilder}
     */
    public TekiyoJogaishaBuilder set入所通知発行日(FlexibleDate 入所通知発行日) {
        requireNonNull(入所通知発行日, UrSystemErrorMessages.値がnull.getReplacedMessage("入所通知発行日"));
        entity.setNyushoTsuchiHakkoYMD(入所通知発行日);
        return this;
    }

    /**
     * 退所通知発行日を設定します。
     *
     * @param 退所通知発行日 退所通知発行日
     * @return {@link TekiyoJogaishaBuilder}
     */
    public TekiyoJogaishaBuilder set退所通知発行日(FlexibleDate 退所通知発行日) {
        requireNonNull(退所通知発行日, UrSystemErrorMessages.値がnull.getReplacedMessage("退所通知発行日"));
        entity.setTaishoTsuchiHakkoYMD(退所通知発行日);
        return this;
    }

    /**
     * 変更通知発行日を設定します。
     *
     * @param 変更通知発行日 変更通知発行日
     * @return {@link TekiyoJogaishaBuilder}
     */
    public TekiyoJogaishaBuilder set変更通知発行日(FlexibleDate 変更通知発行日) {
        requireNonNull(変更通知発行日, UrSystemErrorMessages.値がnull.getReplacedMessage("変更通知発行日"));
        entity.setHenkoTsuchiHakkoYMD(変更通知発行日);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link TekiyoJogaishaBuilder}
     */
    public TekiyoJogaishaBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * 介護保険施設入退所情報のキー情報について判定します。<br>
     * 介護保険施設入退所情報に関連できる介護保険施設入退所情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は介護保険施設入退所情報リストに介護保険施設入退所情報{@link SeishinTechoNini}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 介護保険施設入退所情報 {@link SeishinTechoNini}
     * @return {@link SeishinTechoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public TekiyoJogaishaBuilder setSeishinTechoNini(ShisetsuNyutaisho 介護保険施設入退所情報) {
        if (hasSameIdentifier(介護保険施設入退所情報.identifier())) {
            shisetsuNyutaisho.add(介護保険施設入退所情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(ShisetsuNyutaishoIdentifier 介護保険施設入退所情報識別子) {
        return id.get識別コード().equals(介護保険施設入退所情報識別子.get識別コード());
    }

    /**
     * {@link TekiyoJogaisha}のインスタンスを生成します。
     *
     * @return {@link TekiyoJogaisha}のインスタンス
     */
    public TekiyoJogaisha build() {
        return new TekiyoJogaisha(entity, id, shisetsuNyutaisho);
    }
}
