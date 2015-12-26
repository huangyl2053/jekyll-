/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.YoboKeikakuJikoSakuseiMeisai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyotakuKeikakuJikoSakusei}の編集を行うビルダークラスです。
 */
public class KyotakuKeikakuJikoSakuseiBuilder {

    private final DbT3007KyotakuKeikakuJikoSakuseiEntity entity;
    private final KyotakuKeikakuJikoSakuseiIdentifier id;

    /**
     * {@link DbT3007KyotakuKeikakuJikoSakuseiEntity}より{@link KyotakuKeikakuJikoSakusei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3007KyotakuKeikakuJikoSakuseiEntity}
     * @param id {@link KyotakuKeikakuJikoSakuseiIdentifier}
     *
     */
    KyotakuKeikakuJikoSakuseiBuilder(
            DbT3007KyotakuKeikakuJikoSakuseiEntity entity,
            KyotakuKeikakuJikoSakuseiIdentifier id
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
     * @return {@link KyotakuKeikakuJikoSakuseiBuilder}
     */
    public KyotakuKeikakuJikoSakuseiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 対象年月を設定します。
     *
     * @param 対象年月 対象年月
     * @return {@link KyotakuKeikakuJikoSakuseiBuilder}
     */
    public KyotakuKeikakuJikoSakuseiBuilder set対象年月(FlexibleYearMonth 対象年月) {
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        entity.setTaishoYM(対象年月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KyotakuKeikakuJikoSakuseiBuilder}
     */
    public KyotakuKeikakuJikoSakuseiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 居宅・総合事業区分を設定します。
     *
     * @param 居宅_総合事業区分 居宅・総合事業区分
     * @return {@link KyotakuKeikakuJikoSakuseiBuilder}
     */
    public KyotakuKeikakuJikoSakuseiBuilder set居宅_総合事業区分(RString 居宅_総合事業区分) {
        requireNonNull(居宅_総合事業区分, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅・総合事業区分"));
        entity.setKyotaku_SogoJigyoKubun(居宅_総合事業区分);
        return this;
    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     * @return {@link KyotakuKeikakuJikoSakuseiBuilder}
     */
    public KyotakuKeikakuJikoSakuseiBuilder set適用開始年月日(FlexibleDate 適用開始年月日) {
        requireNonNull(適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月日"));
        entity.setTekiyoKaishiYMD(適用開始年月日);
        return this;
    }

    /**
     * 適用終了年月日を設定します。
     *
     * @param 適用終了年月日 適用終了年月日
     * @return {@link KyotakuKeikakuJikoSakuseiBuilder}
     */
    public KyotakuKeikakuJikoSakuseiBuilder set適用終了年月日(FlexibleDate 適用終了年月日) {
        requireNonNull(適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月日"));
        entity.setTekiyoShuryoYMD(適用終了年月日);
        return this;
    }

    /**
     * 作成区分コードを設定します。
     *
     * @param 作成区分コード 作成区分コード
     * @return {@link KyotakuKeikakuJikoSakuseiBuilder}
     */
    public KyotakuKeikakuJikoSakuseiBuilder set作成区分コード(RString 作成区分コード) {
        requireNonNull(作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("作成区分コード"));
        entity.setSakuseiKubunCode(作成区分コード);
        return this;
    }

    /**
     * 計画作成年月日を設定します。
     *
     * @param 計画作成年月日 計画作成年月日
     * @return {@link KyotakuKeikakuJikoSakuseiBuilder}
     */
    public KyotakuKeikakuJikoSakuseiBuilder set計画作成年月日(FlexibleDate 計画作成年月日) {
        requireNonNull(計画作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("計画作成年月日"));
        entity.setKeikakuSakuseiYMD(計画作成年月日);
        return this;
    }

    /**
     * 計画変更年月日を設定します。
     *
     * @param 計画変更年月日 計画変更年月日
     * @return {@link KyotakuKeikakuJikoSakuseiBuilder}
     */
    public KyotakuKeikakuJikoSakuseiBuilder set計画変更年月日(FlexibleDate 計画変更年月日) {
        requireNonNull(計画変更年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("計画変更年月日"));
        entity.setKeikakuHenkoYMD(計画変更年月日);
        return this;
    }

    /**
     * 計画変更事由を設定します。
     *
     * @param 計画変更事由 計画変更事由
     * @return {@link KyotakuKeikakuJikoSakuseiBuilder}
     */
    public KyotakuKeikakuJikoSakuseiBuilder set計画変更事由(RString 計画変更事由) {
        requireNonNull(計画変更事由, UrSystemErrorMessages.値がnull.getReplacedMessage("計画変更事由"));
        entity.setKeikakuHenkoJiyu(計画変更事由);
        return this;
    }

    /**
     * {@link KyotakuKeikakuJikoSakusei}のインスタンスを生成します。
     *
     * @return {@link KyotakuKeikakuJikoSakusei}のインスタンス
     */
    public KyotakuKeikakuJikoSakusei build() {
        return new KyotakuKeikakuJikoSakusei(entity, id);
    }

    /**
     * setKyotakuKeikaku
     *
     * @param createKyotakuKeikaku createKyotakuKeikaku
     * @return KyotakuKeikakuJikoSakuseiBuilder
     */
    public KyotakuKeikakuJikoSakuseiBuilder
            setKyotakuKeikaku(KyotakuKeikakuJikosakuseiMeisai createKyotakuKeikaku) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * setYoboKeikaku
     *
     * @param createKyotakuKeikaku createKyotakuKeikaku
     * @return KyotakuKeikakuJikoSakuseiBuilder
     */
    public KyotakuKeikakuJikoSakuseiBuilder
            setYoboKeikaku(YoboKeikakuJikoSakuseiMeisai createKyotakuKeikaku) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
