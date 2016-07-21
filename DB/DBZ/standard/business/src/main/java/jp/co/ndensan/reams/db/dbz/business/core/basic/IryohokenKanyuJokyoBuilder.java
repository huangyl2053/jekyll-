/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link IryohokenKanyuJokyo}の編集を行うビルダークラスです。
 */
public class IryohokenKanyuJokyoBuilder {

    private final DbT1008IryohokenKanyuJokyoEntity entity;
    private final IryohokenKanyuJokyoIdentifier id;

    /**
     * {@link DbT1008IryohokenKanyuJokyoEntity}より{@link IryohokenKanyuJokyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT1008IryohokenKanyuJokyoEntity}
     * @param id {@link IryohokenKanyuJokyoIdentifier}
     *
     */
    IryohokenKanyuJokyoBuilder(
            DbT1008IryohokenKanyuJokyoEntity entity,
            IryohokenKanyuJokyoIdentifier id
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
     * @return {@link IryohokenKanyuJokyoBuilder}
     */
    public IryohokenKanyuJokyoBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link IryohokenKanyuJokyoBuilder}
     */
    public IryohokenKanyuJokyoBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link IryohokenKanyuJokyoBuilder}
     */
    public IryohokenKanyuJokyoBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link IryohokenKanyuJokyoBuilder}
     */
    public IryohokenKanyuJokyoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 医療保険種別コードを設定します。
     *
     * @param 医療保険種別コード 医療保険種別コード
     * @return {@link IryohokenKanyuJokyoBuilder}
     */
    public IryohokenKanyuJokyoBuilder set医療保険種別コード(RString 医療保険種別コード) {
        requireNonNull(医療保険種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("医療保険種別コード"));
        entity.setIryoHokenShubetsuCode(医療保険種別コード);
        return this;
    }

    /**
     * 医療保険者番号を設定します。
     *
     * @param 医療保険者番号 医療保険者番号
     * @return {@link IryohokenKanyuJokyoBuilder}
     */
    public IryohokenKanyuJokyoBuilder set医療保険者番号(RString 医療保険者番号) {
        requireNonNull(医療保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("医療保険者番号"));
        entity.setIryoHokenshaNo(医療保険者番号);
        return this;
    }

    /**
     * 医療保険者名称を設定します。
     *
     * @param 医療保険者名称 医療保険者名称
     * @return {@link IryohokenKanyuJokyoBuilder}
     */
    public IryohokenKanyuJokyoBuilder set医療保険者名称(RString 医療保険者名称) {
        requireNonNull(医療保険者名称, UrSystemErrorMessages.値がnull.getReplacedMessage("医療保険者名称"));
        entity.setIryoHokenshaMeisho(医療保険者名称);
        return this;
    }

    /**
     * 医療保険記号番号を設定します。
     *
     * @param 医療保険記号番号 医療保険記号番号
     * @return {@link IryohokenKanyuJokyoBuilder}
     */
    public IryohokenKanyuJokyoBuilder set医療保険記号番号(RString 医療保険記号番号) {
        requireNonNull(医療保険記号番号, UrSystemErrorMessages.値がnull.getReplacedMessage("医療保険記号番号"));
        entity.setIryoHokenKigoNo(医療保険記号番号);
        return this;
    }

    /**
     * 医療保険加入年月日を設定します。
     *
     * @param 医療保険加入年月日 医療保険加入年月日
     * @return {@link IryohokenKanyuJokyoBuilder}
     */
    public IryohokenKanyuJokyoBuilder set医療保険加入年月日(FlexibleDate 医療保険加入年月日) {
        requireNonNull(医療保険加入年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("医療保険加入年月日"));
        entity.setIryoHokenKanyuYMD(医療保険加入年月日);
        return this;
    }

    /**
     * 医療保険脱退年月日を設定します。
     *
     * @param 医療保険脱退年月日 医療保険脱退年月日
     * @return {@link IryohokenKanyuJokyoBuilder}
     */
    public IryohokenKanyuJokyoBuilder set医療保険脱退年月日(FlexibleDate 医療保険脱退年月日) {
        requireNonNull(医療保険脱退年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("医療保険脱退年月日"));
        entity.setIryoHokenDattaiYMD(医療保険脱退年月日);
        return this;
    }

    /**
     * {@link IryohokenKanyuJokyo}のインスタンスを生成します。
     *
     * @return {@link IryohokenKanyuJokyo}のインスタンス
     */
    public IryohokenKanyuJokyo build() {
        return new IryohokenKanyuJokyo(entity, id);
    }
}
