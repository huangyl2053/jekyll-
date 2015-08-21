/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.view;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbV1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link TashichosonJushochiTokureiAlive}の編集を行うビルダークラスです。
 */
public class TashichosonJushochiTokureiAliveBuilder {

    private final DbV1003TashichosonJushochiTokureiEntity entity;
    private final TashichosonJushochiTokureiAliveIdentifier id;

    /**
     * {@link DbV1003TashichosonJushochiTokureiEntity}より{@link TashichosonJushochiTokureiAlive}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbV1003TashichosonJushochiTokureiEntity}
     * @param id {@link TashichosonJushochiTokureiAliveIdentifier}
     *
     */
    TashichosonJushochiTokureiAliveBuilder(
            DbV1003TashichosonJushochiTokureiEntity entity,
            TashichosonJushochiTokureiAliveIdentifier id
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
     * @return {@link TashichosonJushochiTokureiAliveBuilder}
     */
    public TashichosonJushochiTokureiAliveBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 異動日を設定します。
     *
     * @param 異動日 異動日
     * @return {@link TashichosonJushochiTokureiAliveBuilder}
     */
    public TashichosonJushochiTokureiAliveBuilder set異動日(FlexibleDate 異動日) {
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        entity.setIdoYMD(異動日);
        return this;
    }

    /**
     * 枝番を設定します。
     *
     * @param 枝番 枝番
     * @return {@link TashichosonJushochiTokureiAliveBuilder}
     */
    public TashichosonJushochiTokureiAliveBuilder set枝番(RString 枝番) {
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        entity.setEdaNo(枝番);
        return this;
    }

    /**
     * 異動事由コードを設定します。
     *
     * @param 異動事由コード 異動事由コード
     * @return {@link TashichosonJushochiTokureiAliveBuilder}
     */
    public TashichosonJushochiTokureiAliveBuilder set異動事由コード(RString 異動事由コード) {
        requireNonNull(異動事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("異動事由コード"));
        entity.setIdoJiyuCode(異動事由コード);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link TashichosonJushochiTokureiAliveBuilder}
     */
    public TashichosonJushochiTokureiAliveBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 他市町村住所地特例適用事由コードを設定します。
     *
     * @param 他市町村住所地特例適用事由コード 他市町村住所地特例適用事由コード
     * @return {@link TashichosonJushochiTokureiAliveBuilder}
     */
    public TashichosonJushochiTokureiAliveBuilder set他市町村住所地特例適用事由コード(RString 他市町村住所地特例適用事由コード) {
        requireNonNull(他市町村住所地特例適用事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例適用事由コード"));
        entity.setTekiyoJiyuCode(他市町村住所地特例適用事由コード);
        return this;
    }

    /**
     * 適用年月日を設定します。
     *
     * @param 適用年月日 適用年月日
     * @return {@link TashichosonJushochiTokureiAliveBuilder}
     */
    public TashichosonJushochiTokureiAliveBuilder set適用年月日(FlexibleDate 適用年月日) {
        requireNonNull(適用年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用年月日"));
        entity.setTekiyoYMD(適用年月日);
        return this;
    }

    /**
     * 適用届出年月日を設定します。
     *
     * @param 適用届出年月日 適用届出年月日
     * @return {@link TashichosonJushochiTokureiAliveBuilder}
     */
    public TashichosonJushochiTokureiAliveBuilder set適用届出年月日(FlexibleDate 適用届出年月日) {
        requireNonNull(適用届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用届出年月日"));
        entity.setTekiyoTodokedeYMD(適用届出年月日);
        return this;
    }

    /**
     * 適用受付年月日を設定します。
     *
     * @param 適用受付年月日 適用受付年月日
     * @return {@link TashichosonJushochiTokureiAliveBuilder}
     */
    public TashichosonJushochiTokureiAliveBuilder set適用受付年月日(FlexibleDate 適用受付年月日) {
        requireNonNull(適用受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用受付年月日"));
        entity.setTekiyoUketsukeYMD(適用受付年月日);
        return this;
    }

    /**
     * 他市町村住所地特例解除事由コードを設定します。
     *
     * @param 他市町村住所地特例解除事由コード 他市町村住所地特例解除事由コード
     * @return {@link TashichosonJushochiTokureiAliveBuilder}
     */
    public TashichosonJushochiTokureiAliveBuilder set他市町村住所地特例解除事由コード(RString 他市町村住所地特例解除事由コード) {
        requireNonNull(他市町村住所地特例解除事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例解除事由コード"));
        entity.setKaijoJiyuCode(他市町村住所地特例解除事由コード);
        return this;
    }

    /**
     * 解除年月日を設定します。
     *
     * @param 解除年月日 解除年月日
     * @return {@link TashichosonJushochiTokureiAliveBuilder}
     */
    public TashichosonJushochiTokureiAliveBuilder set解除年月日(FlexibleDate 解除年月日) {
        requireNonNull(解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除年月日"));
        entity.setKaijoYMD(解除年月日);
        return this;
    }

    /**
     * 解除届出年月日を設定します。
     *
     * @param 解除届出年月日 解除届出年月日
     * @return {@link TashichosonJushochiTokureiAliveBuilder}
     */
    public TashichosonJushochiTokureiAliveBuilder set解除届出年月日(FlexibleDate 解除届出年月日) {
        requireNonNull(解除届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除届出年月日"));
        entity.setKaijoTodokedeYMD(解除届出年月日);
        return this;
    }

    /**
     * 解除受付年月日を設定します。
     *
     * @param 解除受付年月日 解除受付年月日
     * @return {@link TashichosonJushochiTokureiAliveBuilder}
     */
    public TashichosonJushochiTokureiAliveBuilder set解除受付年月日(FlexibleDate 解除受付年月日) {
        requireNonNull(解除受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除受付年月日"));
        entity.setKaijoUketsukeYMD(解除受付年月日);
        return this;
    }

    /**
     * 措置保険者番号を設定します。
     *
     * @param 措置保険者番号 措置保険者番号
     * @return {@link TashichosonJushochiTokureiAliveBuilder}
     */
    public TashichosonJushochiTokureiAliveBuilder set措置保険者番号(ShoKisaiHokenshaNo 措置保険者番号) {
        requireNonNull(措置保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("措置保険者番号"));
        entity.setSochiHokenshaNo(措置保険者番号);
        return this;
    }

    /**
     * 措置被保険者番号を設定します。
     *
     * @param 措置被保険者番号 措置被保険者番号
     * @return {@link TashichosonJushochiTokureiAliveBuilder}
     */
    public TashichosonJushochiTokureiAliveBuilder set措置被保険者番号(HihokenshaNo 措置被保険者番号) {
        requireNonNull(措置被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("措置被保険者番号"));
        entity.setSochiHihokenshaNo(措置被保険者番号);
        return this;
    }

    /**
     * 他特例連絡票発行年月日を設定します。
     *
     * @param 他特例連絡票発行年月日 他特例連絡票発行年月日
     * @return {@link TashichosonJushochiTokureiAliveBuilder}
     */
    public TashichosonJushochiTokureiAliveBuilder set他特例連絡票発行年月日(FlexibleDate 他特例連絡票発行年月日) {
        requireNonNull(他特例連絡票発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("他特例連絡票発行年月日"));
        entity.setTatokuRenrakuhyoHakkoYMD(他特例連絡票発行年月日);
        return this;
    }

    /**
     * 施設退所通知発行年月日を設定します。
     *
     * @param 施設退所通知発行年月日 施設退所通知発行年月日
     * @return {@link TashichosonJushochiTokureiAliveBuilder}
     */
    public TashichosonJushochiTokureiAliveBuilder set施設退所通知発行年月日(FlexibleDate 施設退所通知発行年月日) {
        requireNonNull(施設退所通知発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("施設退所通知発行年月日"));
        entity.setShisetsuTaishoTsuchiHakkoYMD(施設退所通知発行年月日);
        return this;
    }

    /**
     * 施設変更通知発行年月日を設定します。
     *
     * @param 施設変更通知発行年月日 施設変更通知発行年月日
     * @return {@link TashichosonJushochiTokureiAliveBuilder}
     */
    public TashichosonJushochiTokureiAliveBuilder set施設変更通知発行年月日(FlexibleDate 施設変更通知発行年月日) {
        requireNonNull(施設変更通知発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("施設変更通知発行年月日"));
        entity.setShisetsuHenkoTsuchiHakkoYMD(施設変更通知発行年月日);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link TashichosonJushochiTokureiAliveBuilder}
     */
    public TashichosonJushochiTokureiAliveBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * {@link TashichosonJushochiTokureiAlive}のインスタンスを生成します。
     *
     * @return {@link TashichosonJushochiTokureiAlive}のインスタンス
     */
    public TashichosonJushochiTokureiAlive build() {
        return new TashichosonJushochiTokureiAlive(entity, id);
    }
}
