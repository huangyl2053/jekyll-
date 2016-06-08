/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link TekiyoJogaisha}の編集を行うビルダークラスです。
 */
public class TekiyoJogaishaBuilder {

    private final DbT1002TekiyoJogaishaEntity entity;
    private final TekiyoJogaishaIdentifier id;

    /**
     * {@link DbT1002TekiyoJogaishaEntity}より{@link TekiyoJogaisha}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT1002TekiyoJogaishaEntity}
     * @param id {@link TekiyoJogaishaIdentifier}
     *
     */
    TekiyoJogaishaBuilder(
            DbT1002TekiyoJogaishaEntity entity,
            TekiyoJogaishaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link TekiyoJogaishaBuilder}
     */
    public TekiyoJogaishaBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 異動日を設定します。
     *
     * @param 異動日 異動日
     * @return {@link TekiyoJogaishaBuilder}
     */
    public TekiyoJogaishaBuilder set異動日(FlexibleDate 異動日) {
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        entity.setIdoYMD(異動日);
        return this;
    }

    /**
     * 枝番を設定します。
     *
     * @param 枝番 枝番
     * @return {@link TekiyoJogaishaBuilder}
     */
    public TekiyoJogaishaBuilder set枝番(RString 枝番) {
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        entity.setEdaNo(枝番);
        return this;
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
     * {@link TekiyoJogaisha}のインスタンスを生成します。
     *
     * @return {@link TekiyoJogaisha}のインスタンス
     */
    public TekiyoJogaisha build() {
        return new TekiyoJogaisha(entity, id);
    }
}
