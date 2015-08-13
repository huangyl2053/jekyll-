/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShoKofuKaishu}の編集を行うビルダークラスです。
 */
public class ShoKofuKaishuBuilder {

    private final DbT7037ShoKofuKaishuEntity entity;
    private final ShoKofuKaishuIdentifier id;

    /**
     * {@link DbT7037ShoKofuKaishuEntity}より{@link ShoKofuKaishu}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7037ShoKofuKaishuEntity}
     * @param id {@link ShoKofuKaishuIdentifier}
     *
     */
    ShoKofuKaishuBuilder(
            DbT7037ShoKofuKaishuEntity entity,
            ShoKofuKaishuIdentifier id
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
     * @return {@link ShoKofuKaishuBuilder}
     */
    public ShoKofuKaishuBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 交付証種類を設定します。
     *
     * @param 交付証種類 交付証種類
     * @return {@link ShoKofuKaishuBuilder}
     */
    public ShoKofuKaishuBuilder set交付証種類(RString 交付証種類) {
        requireNonNull(交付証種類, UrSystemErrorMessages.値がnull.getReplacedMessage("交付証種類"));
        entity.setKofuShoShurui(交付証種類);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ShoKofuKaishuBuilder}
     */
    public ShoKofuKaishuBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link ShoKofuKaishuBuilder}
     */
    public ShoKofuKaishuBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link ShoKofuKaishuBuilder}
     */
    public ShoKofuKaishuBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 交付年月日を設定します。
     *
     * @param 交付年月日 交付年月日
     * @return {@link ShoKofuKaishuBuilder}
     */
    public ShoKofuKaishuBuilder set交付年月日(FlexibleDate 交付年月日) {
        requireNonNull(交付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("交付年月日"));
        entity.setKofuYMD(交付年月日);
        return this;
    }

    /**
     * 有効期限を設定します。
     *
     * @param 有効期限 有効期限
     * @return {@link ShoKofuKaishuBuilder}
     */
    public ShoKofuKaishuBuilder set有効期限(FlexibleDate 有効期限) {
        requireNonNull(有効期限, UrSystemErrorMessages.値がnull.getReplacedMessage("有効期限"));
        entity.setYukoKigenYMD(有効期限);
        return this;
    }

    /**
     * 交付事由を設定します。
     *
     * @param 交付事由 交付事由
     * @return {@link ShoKofuKaishuBuilder}
     */
    public ShoKofuKaishuBuilder set交付事由(RString 交付事由) {
        requireNonNull(交付事由, UrSystemErrorMessages.値がnull.getReplacedMessage("交付事由"));
        entity.setKofuJiyu(交付事由);
        return this;
    }

    /**
     * 交付理由を設定します。
     *
     * @param 交付理由 交付理由
     * @return {@link ShoKofuKaishuBuilder}
     */
    public ShoKofuKaishuBuilder set交付理由(RString 交付理由) {
        requireNonNull(交付理由, UrSystemErrorMessages.値がnull.getReplacedMessage("交付理由"));
        entity.setKofuRiyu(交付理由);
        return this;
    }

    /**
     * 回収年月日を設定します。
     *
     * @param 回収年月日 回収年月日
     * @return {@link ShoKofuKaishuBuilder}
     */
    public ShoKofuKaishuBuilder set回収年月日(FlexibleDate 回収年月日) {
        requireNonNull(回収年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("回収年月日"));
        entity.setKaishuYMD(回収年月日);
        return this;
    }

    /**
     * 回収事由を設定します。
     *
     * @param 回収事由 回収事由
     * @return {@link ShoKofuKaishuBuilder}
     */
    public ShoKofuKaishuBuilder set回収事由(RString 回収事由) {
        requireNonNull(回収事由, UrSystemErrorMessages.値がnull.getReplacedMessage("回収事由"));
        entity.setKaishuJiyu(回収事由);
        return this;
    }

    /**
     * 回収理由を設定します。
     *
     * @param 回収理由 回収理由
     * @return {@link ShoKofuKaishuBuilder}
     */
    public ShoKofuKaishuBuilder set回収理由(RString 回収理由) {
        requireNonNull(回収理由, UrSystemErrorMessages.値がnull.getReplacedMessage("回収理由"));
        entity.setKaishuRiyu(回収理由);
        return this;
    }

    /**
     * 単票発行有無フラグを設定します。
     *
     * @param 単票発行有無フラグ 単票発行有無フラグ
     * @return {@link ShoKofuKaishuBuilder}
     */
    public ShoKofuKaishuBuilder set単票発行有無フラグ(boolean 単票発行有無フラグ) {
        requireNonNull(単票発行有無フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("単票発行有無フラグ"));
        entity.setTanpyoHakkoUmuFlag(単票発行有無フラグ);
        return this;
    }

    /**
     * 発行処理日時を設定します。
     *
     * @param 発行処理日時 発行処理日時
     * @return {@link ShoKofuKaishuBuilder}
     */
    public ShoKofuKaishuBuilder set発行処理日時(YMDHMS 発行処理日時) {
        requireNonNull(発行処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("発行処理日時"));
        entity.setHakkoShoriTimestamp(発行処理日時);
        return this;
    }

    /**
     * 新様式印書済区分コードを設定します。
     *
     * @param 新様式印書済区分コード 新様式印書済区分コード
     * @return {@link ShoKofuKaishuBuilder}
     */
    public ShoKofuKaishuBuilder set新様式印書済区分コード(RString 新様式印書済区分コード) {
        requireNonNull(新様式印書済区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("新様式印書済区分コード"));
        entity.setShinYoshikiSumiKubunCode(新様式印書済区分コード);
        return this;
    }

    /**
     * 証様式区分コードを設定します。
     *
     * @param 証様式区分コード 証様式区分コード
     * @return {@link ShoKofuKaishuBuilder}
     */
    public ShoKofuKaishuBuilder set証様式区分コード(RString 証様式区分コード) {
        requireNonNull(証様式区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("証様式区分コード"));
        entity.setShoYoshikiKubunCode(証様式区分コード);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link ShoKofuKaishuBuilder}
     */
    public ShoKofuKaishuBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * {@link ShoKofuKaishu}のインスタンスを生成します。
     *
     * @return {@link ShoKofuKaishu}のインスタンス
     */
    public ShoKofuKaishu build() {
        return new ShoKofuKaishu(entity, id);
    }
}
