/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.jushochitokurei.tashichosonjushochitokurei;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.jushochitokurei.shisetsunyutaisho.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dba.business.core.jushochitokurei.shisetsunyutaisho.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoTatokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoTatokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link TashichosonJushochiTokurei}の編集を行うビルダークラスです。
 */
public class TashichosonJushochiTokureiBuilder {

    private final DbT1003TashichosonJushochiTokureiEntity entity;
    private final TashichosonJushochiTokureiIdentifier id;
    private final Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaisho;

    /**
     * {@link DbT1003TashichosonJushochiTokureiEntity}より{@link TashichosonJushochiTokurei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT1003TashichosonJushochiTokureiEntity}
     * @param id {@link TashichosonJushochiTokureiIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    TashichosonJushochiTokureiBuilder(
            DbT1003TashichosonJushochiTokureiEntity entity,
            TashichosonJushochiTokureiIdentifier id,
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
     * @return {@link TashichosonJushochiTokureiBuilder}
     */
    public TashichosonJushochiTokureiBuilder set異動事由コード(RString 異動事由コード) {
        requireNonNull(異動事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("異動事由コード"));
        entity.setIdoJiyuCode(異動事由コード);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link TashichosonJushochiTokureiBuilder}
     */
    public TashichosonJushochiTokureiBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 他市町村住所地特例適用事由コードを設定します。
     *
     * @param 他市町村住所地特例適用事由コード 他市町村住所地特例適用事由コード
     * @return {@link TashichosonJushochiTokureiBuilder}
     */
    public TashichosonJushochiTokureiBuilder set他市町村住所地特例適用事由コード(KaigoTatokuTekiyoJiyu 他市町村住所地特例適用事由コード) {
        requireNonNull(他市町村住所地特例適用事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例適用事由コード"));
        entity.setTekiyoJiyuCode(他市町村住所地特例適用事由コード);
        return this;
    }

    /**
     * 適用年月日を設定します。
     *
     * @param 適用年月日 適用年月日
     * @return {@link TashichosonJushochiTokureiBuilder}
     */
    public TashichosonJushochiTokureiBuilder set適用年月日(FlexibleDate 適用年月日) {
        requireNonNull(適用年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用年月日"));
        entity.setTekiyoYMD(適用年月日);
        return this;
    }

    /**
     * 適用届出年月日を設定します。
     *
     * @param 適用届出年月日 適用届出年月日
     * @return {@link TashichosonJushochiTokureiBuilder}
     */
    public TashichosonJushochiTokureiBuilder set適用届出年月日(FlexibleDate 適用届出年月日) {
        requireNonNull(適用届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用届出年月日"));
        entity.setTekiyoTodokedeYMD(適用届出年月日);
        return this;
    }

    /**
     * 適用受付年月日を設定します。
     *
     * @param 適用受付年月日 適用受付年月日
     * @return {@link TashichosonJushochiTokureiBuilder}
     */
    public TashichosonJushochiTokureiBuilder set適用受付年月日(FlexibleDate 適用受付年月日) {
        requireNonNull(適用受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用受付年月日"));
        entity.setTekiyoUketsukeYMD(適用受付年月日);
        return this;
    }

    /**
     * 他市町村住所地特例解除事由コードを設定します。
     *
     * @param 他市町村住所地特例解除事由コード 他市町村住所地特例解除事由コード
     * @return {@link TashichosonJushochiTokureiBuilder}
     */
    public TashichosonJushochiTokureiBuilder set他市町村住所地特例解除事由コード(KaigoTatokuKaijoJiyu 他市町村住所地特例解除事由コード) {
        requireNonNull(他市町村住所地特例解除事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例解除事由コード"));
        entity.setKaijoJiyuCode(他市町村住所地特例解除事由コード);
        return this;
    }

    /**
     * 解除年月日を設定します。
     *
     * @param 解除年月日 解除年月日
     * @return {@link TashichosonJushochiTokureiBuilder}
     */
    public TashichosonJushochiTokureiBuilder set解除年月日(FlexibleDate 解除年月日) {
        requireNonNull(解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除年月日"));
        entity.setKaijoYMD(解除年月日);
        return this;
    }

    /**
     * 解除届出年月日を設定します。
     *
     * @param 解除届出年月日 解除届出年月日
     * @return {@link TashichosonJushochiTokureiBuilder}
     */
    public TashichosonJushochiTokureiBuilder set解除届出年月日(FlexibleDate 解除届出年月日) {
        requireNonNull(解除届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除届出年月日"));
        entity.setKaijoTodokedeYMD(解除届出年月日);
        return this;
    }

    /**
     * 解除受付年月日を設定します。
     *
     * @param 解除受付年月日 解除受付年月日
     * @return {@link TashichosonJushochiTokureiBuilder}
     */
    public TashichosonJushochiTokureiBuilder set解除受付年月日(FlexibleDate 解除受付年月日) {
        requireNonNull(解除受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除受付年月日"));
        entity.setKaijoUketsukeYMD(解除受付年月日);
        return this;
    }

    /**
     * 措置保険者番号を設定します。
     *
     * @param 措置保険者番号 措置保険者番号
     * @return {@link TashichosonJushochiTokureiBuilder}
     */
    public TashichosonJushochiTokureiBuilder set措置保険者番号(ShoKisaiHokenshaNo 措置保険者番号) {
        requireNonNull(措置保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("措置保険者番号"));
        entity.setSochiHokenshaNo(措置保険者番号);
        return this;
    }

    /**
     * 措置被保険者番号を設定します。
     *
     * @param 措置被保険者番号 措置被保険者番号
     * @return {@link TashichosonJushochiTokureiBuilder}
     */
    public TashichosonJushochiTokureiBuilder set措置被保険者番号(HihokenshaNo 措置被保険者番号) {
        requireNonNull(措置被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("措置被保険者番号"));
        entity.setSochiHihokenshaNo(措置被保険者番号);
        return this;
    }

    /**
     * 他特例連絡票発行年月日を設定します。
     *
     * @param 他特例連絡票発行年月日 他特例連絡票発行年月日
     * @return {@link TashichosonJushochiTokureiBuilder}
     */
    public TashichosonJushochiTokureiBuilder set他特例連絡票発行年月日(FlexibleDate 他特例連絡票発行年月日) {
        requireNonNull(他特例連絡票発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("他特例連絡票発行年月日"));
        entity.setTatokuRenrakuhyoHakkoYMD(他特例連絡票発行年月日);
        return this;
    }

    /**
     * 施設退所通知発行年月日を設定します。
     *
     * @param 施設退所通知発行年月日 施設退所通知発行年月日
     * @return {@link TashichosonJushochiTokureiBuilder}
     */
    public TashichosonJushochiTokureiBuilder set施設退所通知発行年月日(FlexibleDate 施設退所通知発行年月日) {
        requireNonNull(施設退所通知発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("施設退所通知発行年月日"));
        entity.setShisetsuTaishoTsuchiHakkoYMD(施設退所通知発行年月日);
        return this;
    }

    /**
     * 施設変更通知発行年月日を設定します。
     *
     * @param 施設変更通知発行年月日 施設変更通知発行年月日
     * @return {@link TashichosonJushochiTokureiBuilder}
     */
    public TashichosonJushochiTokureiBuilder set施設変更通知発行年月日(FlexibleDate 施設変更通知発行年月日) {
        requireNonNull(施設変更通知発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("施設変更通知発行年月日"));
        entity.setShisetsuHenkoTsuchiHakkoYMD(施設変更通知発行年月日);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link TashichosonJushochiTokureiBuilder}
     */
    public TashichosonJushochiTokureiBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * 介護保険施設入退所のキー情報について判定します。<br>
     * 介護保険施設入退所情報に関連できる介護保険施設入退所である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は介護保険施設入退所リストに介護保険施設入退所{@link SeishinTechoNini}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 介護保険施設入退所 {@link SeishinTechoNini}
     * @return {@link SeishinTechoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public TashichosonJushochiTokureiBuilder setSeishinTechoNini(ShisetsuNyutaisho 介護保険施設入退所) {
        if (hasSameIdentifier(介護保険施設入退所.identifier())) {
            shisetsuNyutaisho.add(介護保険施設入退所);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(ShisetsuNyutaishoIdentifier 介護保険施設入退所識別子) {
        return id.get識別コード().equals(介護保険施設入退所識別子.get識別コード());
    }

    /**
     * {@link TashichosonJushochiTokurei}のインスタンスを生成します。
     *
     * @return {@link TashichosonJushochiTokurei}のインスタンス
     */
    public TashichosonJushochiTokurei build() {
        return new TashichosonJushochiTokurei(entity, id, shisetsuNyutaisho);
    }
}
