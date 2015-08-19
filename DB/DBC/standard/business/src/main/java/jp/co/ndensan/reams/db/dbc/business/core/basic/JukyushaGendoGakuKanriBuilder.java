/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7116JukyushaGendoGakuKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link JukyushaGendoGakuKanri}の編集を行うビルダークラスです。
 */
public class JukyushaGendoGakuKanriBuilder {

    private final DbT7116JukyushaGendoGakuKanriEntity entity;
    private final JukyushaGendoGakuKanriIdentifier id;

    /**
     * {@link DbT7116JukyushaGendoGakuKanriEntity}より{@link JukyushaGendoGakuKanri}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7116JukyushaGendoGakuKanriEntity}
     * @param id {@link JukyushaGendoGakuKanriIdentifier}
     *
     */
    JukyushaGendoGakuKanriBuilder(
            DbT7116JukyushaGendoGakuKanriEntity entity,
            JukyushaGendoGakuKanriIdentifier id
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
     * @return {@link JukyushaGendoGakuKanriBuilder}
     */
    public JukyushaGendoGakuKanriBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 識別区分を設定します。
     *
     * @param 識別区分 識別区分
     * @return {@link JukyushaGendoGakuKanriBuilder}
     */
    public JukyushaGendoGakuKanriBuilder set識別区分(RString 識別区分) {
        requireNonNull(識別区分, UrSystemErrorMessages.値がnull.getReplacedMessage("識別区分"));
        entity.setShikibetsuKubun(識別区分);
        return this;
    }

    /**
     * 有効開始年月を設定します。
     *
     * @param 有効開始年月 有効開始年月
     * @return {@link JukyushaGendoGakuKanriBuilder}
     */
    public JukyushaGendoGakuKanriBuilder set有効開始年月(FlexibleYearMonth 有効開始年月) {
        requireNonNull(有効開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月"));
        entity.setYukoKaishiYM(有効開始年月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link JukyushaGendoGakuKanriBuilder}
     */
    public JukyushaGendoGakuKanriBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 有効終了年月を設定します。
     *
     * @param 有効終了年月 有効終了年月
     * @return {@link JukyushaGendoGakuKanriBuilder}
     */
    public JukyushaGendoGakuKanriBuilder set有効終了年月(FlexibleYearMonth 有効終了年月) {
        requireNonNull(有効終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("有効終了年月"));
        entity.setYukoShuryoYM(有効終了年月);
        return this;
    }

    /**
     * 要介護状態区分を設定します。
     *
     * @param 要介護状態区分 要介護状態区分
     * @return {@link JukyushaGendoGakuKanriBuilder}
     */
    public JukyushaGendoGakuKanriBuilder set要介護状態区分(RString 要介護状態区分) {
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        entity.setYoKaigoJotaiKubun(要介護状態区分);
        return this;
    }

    /**
     * 拡大倍数を設定します。
     *
     * @param 拡大倍数 拡大倍数
     * @return {@link JukyushaGendoGakuKanriBuilder}
     */
    public JukyushaGendoGakuKanriBuilder set拡大倍数(RString 拡大倍数) {
        requireNonNull(拡大倍数, UrSystemErrorMessages.値がnull.getReplacedMessage("拡大倍数"));
        entity.setKakudaiBaisu(拡大倍数);
        return this;
    }

    /**
     * 切り分け単位数を設定します。
     *
     * @param 切り分け単位数 切り分け単位数
     * @return {@link JukyushaGendoGakuKanriBuilder}
     */
    public JukyushaGendoGakuKanriBuilder set切り分け単位数(Decimal 切り分け単位数) {
        requireNonNull(切り分け単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("切り分け単位数"));
        entity.setKiriwakeTaniSu(切り分け単位数);
        return this;
    }

    /**
     * 登録年月日を設定します。
     *
     * @param 登録年月日 登録年月日
     * @return {@link JukyushaGendoGakuKanriBuilder}
     */
    public JukyushaGendoGakuKanriBuilder set登録年月日(FlexibleDate 登録年月日) {
        requireNonNull(登録年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("登録年月日"));
        entity.setTorokuYMD(登録年月日);
        return this;
    }

    /**
     * 変更年月日を設定します。
     *
     * @param 変更年月日 変更年月日
     * @return {@link JukyushaGendoGakuKanriBuilder}
     */
    public JukyushaGendoGakuKanriBuilder set変更年月日(FlexibleDate 変更年月日) {
        requireNonNull(変更年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("変更年月日"));
        entity.setHenkoYMD(変更年月日);
        return this;
    }

    /**
     * 限度額管理期間数を設定します。
     *
     * @param 限度額管理期間数 限度額管理期間数
     * @return {@link JukyushaGendoGakuKanriBuilder}
     */
    public JukyushaGendoGakuKanriBuilder set限度額管理期間数(RString 限度額管理期間数) {
        requireNonNull(限度額管理期間数, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額管理期間数"));
        entity.setGendoGakuKanriKikanSu(限度額管理期間数);
        return this;
    }

    /**
     * 新体系管理区分を設定します。
     *
     * @param 新体系管理区分 新体系管理区分
     * @return {@link JukyushaGendoGakuKanriBuilder}
     */
    public JukyushaGendoGakuKanriBuilder set新体系管理区分(RString 新体系管理区分) {
        requireNonNull(新体系管理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("新体系管理区分"));
        entity.setShinTaikeiKanriKubun(新体系管理区分);
        return this;
    }

    /**
     * 新体系拡大適用有無を設定します。
     *
     * @param 新体系拡大適用有無 新体系拡大適用有無
     * @return {@link JukyushaGendoGakuKanriBuilder}
     */
    public JukyushaGendoGakuKanriBuilder set新体系拡大適用有無(RString 新体系拡大適用有無) {
        requireNonNull(新体系拡大適用有無, UrSystemErrorMessages.値がnull.getReplacedMessage("新体系拡大適用有無"));
        entity.setShinTaikeiKakudaiTekiyoUmu(新体系拡大適用有無);
        return this;
    }

    /**
     * {@link JukyushaGendoGakuKanri}のインスタンスを生成します。
     *
     * @return {@link JukyushaGendoGakuKanri}のインスタンス
     */
    public JukyushaGendoGakuKanri build() {
        return new JukyushaGendoGakuKanri(entity, id);
    }
}
