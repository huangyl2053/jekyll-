/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link GappeiNaiJutokushaShinKyuNoHenkan}の編集を行うビルダークラスです。
 */
public class GappeiNaiJutokushaShinKyuNoHenkanBuilder {

    private final DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity;
    private final GappeiNaiJutokushaShinKyuNoHenkanIdentifier id;

    /**
     * {@link DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity}より{@link GappeiNaiJutokushaShinKyuNoHenkan}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity}
     * @param id {@link GappeiNaiJutokushaShinKyuNoHenkanIdentifier}
     *
     */
    GappeiNaiJutokushaShinKyuNoHenkanBuilder(
            DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity,
            GappeiNaiJutokushaShinKyuNoHenkanIdentifier id
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
     * @return {@link GappeiNaiJutokushaShinKyuNoHenkanBuilder}
     */
    public GappeiNaiJutokushaShinKyuNoHenkanBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link GappeiNaiJutokushaShinKyuNoHenkanBuilder}
     */
    public GappeiNaiJutokushaShinKyuNoHenkanBuilder set履歴番号(RString 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 識別コード_措置元）を設定します。
     *
     * @param 識別コード_措置元 識別コード_措置元）
     * @return {@link GappeiNaiJutokushaShinKyuNoHenkanBuilder}
     */
    public GappeiNaiJutokushaShinKyuNoHenkanBuilder set識別コード_措置元(ShikibetsuCode 識別コード_措置元) {
        requireNonNull(識別コード_措置元, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード_措置元"));
        entity.setShikibetsuCodeSochiMoto(識別コード_措置元);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link GappeiNaiJutokushaShinKyuNoHenkanBuilder}
     */
    public GappeiNaiJutokushaShinKyuNoHenkanBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 市町村コード_措置元）を設定します。
     *
     * @param 市町村コード_措置元 市町村コード_措置元）
     * @return {@link GappeiNaiJutokushaShinKyuNoHenkanBuilder}
     */
    public GappeiNaiJutokushaShinKyuNoHenkanBuilder set市町村コード_措置元(LasdecCode 市町村コード_措置元) {
        requireNonNull(市町村コード_措置元, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード_措置元）"));
        entity.setShichosonCodeSochiMoto(市町村コード_措置元);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link GappeiNaiJutokushaShinKyuNoHenkanBuilder}
     */
    public GappeiNaiJutokushaShinKyuNoHenkanBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 被保険者番号_措置元）を設定します。
     *
     * @param 被保険者番号_措置元 被保険者番号_措置元）
     * @return {@link GappeiNaiJutokushaShinKyuNoHenkanBuilder}
     */
    public GappeiNaiJutokushaShinKyuNoHenkanBuilder set被保険者番号_措置元(HihokenshaNo 被保険者番号_措置元) {
        requireNonNull(被保険者番号_措置元, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号_措置元）"));
        entity.setHihokenshaNoSochiMoto(被保険者番号_措置元);
        return this;
    }

    /**
     * 開始年月日を設定します。
     *
     * @param 開始年月日 開始年月日
     * @return {@link GappeiNaiJutokushaShinKyuNoHenkanBuilder}
     */
    public GappeiNaiJutokushaShinKyuNoHenkanBuilder set開始年月日(FlexibleDate 開始年月日) {
        requireNonNull(開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月日"));
        entity.setKaishiYMD(開始年月日);
        return this;
    }

    /**
     * 終了年月日を設定します。
     *
     * @param 終了年月日 終了年月日
     * @return {@link GappeiNaiJutokushaShinKyuNoHenkanBuilder}
     */
    public GappeiNaiJutokushaShinKyuNoHenkanBuilder set終了年月日(FlexibleDate 終了年月日) {
        requireNonNull(終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月日"));
        entity.setShuryoYMD(終了年月日);
        return this;
    }

    /**
     * {@link GappeiNaiJutokushaShinKyuNoHenkan}のインスタンスを生成します。
     *
     * @return {@link GappeiNaiJutokushaShinKyuNoHenkan}のインスタンス
     */
    public GappeiNaiJutokushaShinKyuNoHenkan build() {
        return new GappeiNaiJutokushaShinKyuNoHenkan(entity, id);
    }
}
