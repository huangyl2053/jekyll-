/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakusei;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseimeisai.KyotakuKeikakuJikosakuseiMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseimeisai.KyotakuKeikakuJikosakuseiMeisaiIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.yobokeikakujikosakuseimeisai.YoboKeikakuJikoSakuseiMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.yobokeikakujikosakuseimeisai.YoboKeikakuJikoSakuseiMeisaiIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KyotakuKeikakuJikoSakusei}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-9999-011 sunhaidi
 */
public class KyotakuKeikakuJikoSakuseiBuilder {

    private final DbT3007KyotakuKeikakuJikoSakuseiEntity entity;
    private final KyotakuKeikakuJikoSakuseiIdentifier id;
    private final Models<KyotakuKeikakuJikosakuseiMeisaiIdentifier, KyotakuKeikakuJikosakuseiMeisai> kyotakuJikosakuseiMeisai;
    private final Models<YoboKeikakuJikoSakuseiMeisaiIdentifier, YoboKeikakuJikoSakuseiMeisai> yoboKeikakuJikoSakuseiMeisai;

    /**
     * {@link DbT3007KyotakuKeikakuJikoSakuseiEntity}より{@link KyotakuKeikakuJikoSakusei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3007KyotakuKeikakuJikoSakuseiEntity}
     * @param id {@link KyotakuKeikakuJikoSakuseiIdentifier}
     * @param kyotakuJikosakuseiMeisai {@link Models}
     * @param yoboKeikakuJikoSakuseiMeisai {@link Models}
     *
     */
    KyotakuKeikakuJikoSakuseiBuilder(
            DbT3007KyotakuKeikakuJikoSakuseiEntity entity,
            KyotakuKeikakuJikoSakuseiIdentifier id,
            Models<KyotakuKeikakuJikosakuseiMeisaiIdentifier, KyotakuKeikakuJikosakuseiMeisai> kyotakuJikosakuseiMeisai,
            Models<YoboKeikakuJikoSakuseiMeisaiIdentifier, YoboKeikakuJikoSakuseiMeisai> yoboKeikakuJikoSakuseiMeisai
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.kyotakuJikosakuseiMeisai = kyotakuJikosakuseiMeisai.clone();
        this.yoboKeikakuJikoSakuseiMeisai = yoboKeikakuJikoSakuseiMeisai.clone();
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
     * 居宅給付計画自己作成明細のキー情報について判定します。<br>
     * 居宅給付計画自己作成明細に関連できる居宅給付計画自己作成明細である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は居宅給付計画自己作成明細リストに居宅給付計画自己作成明細{@link KyotakuKeikakuJikosakuseiMeisai}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 居宅給付計画自己作成明細 {@link KyotakuKeikakuJikosakuseiMeisai}
     * @return {@link SeishinTechoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public KyotakuKeikakuJikoSakuseiBuilder setKyotakuKeikakuJikosakuseiMeisai(KyotakuKeikakuJikosakuseiMeisai 居宅給付計画自己作成明細) {
        if (hasSameIdentifier(居宅給付計画自己作成明細.identifier())) {
            kyotakuJikosakuseiMeisai.add(居宅給付計画自己作成明細);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(KyotakuKeikakuJikosakuseiMeisaiIdentifier 居宅給付計画自己作成明細識別子) {
        return (id.get対象年月().equals(居宅給付計画自己作成明細識別子.get対象年月())
                && id.get被保険者番号().equals(居宅給付計画自己作成明細識別子.get被保険者番号())
                && id.get履歴番号() == 居宅給付計画自己作成明細識別子.get履歴番号());
    }

    /**
     * 予防給付計画自己作成明細のキー情報について判定します。<br>
     * 予防給付計画自己作成明細に関連できる予防給付計画自己作成明細である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は予防給付計画自己作成明細リストに予防給付計画自己作成明細{@link YoboKeikakuJikoSakuseiMeisai}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 予防給付計画自己作成明細 {@link YoboKeikakuJikoSakuseiMeisai}
     * @return Builder
     * @throws IllegalStateException キーが一致しない場合
     */
    public KyotakuKeikakuJikoSakuseiBuilder setYoboKeikakuJikoSakuseiMeisai(YoboKeikakuJikoSakuseiMeisai 予防給付計画自己作成明細) {
        if (hasSameIdentifier(予防給付計画自己作成明細.identifier())) {
            yoboKeikakuJikoSakuseiMeisai.add(予防給付計画自己作成明細);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(YoboKeikakuJikoSakuseiMeisaiIdentifier 予防給付計画自己作成明細識別子) {
        return (id.get対象年月().equals(予防給付計画自己作成明細識別子.get対象年月())
                && id.get被保険者番号().equals(予防給付計画自己作成明細識別子.get被保険者番号())
                && id.get履歴番号() == 予防給付計画自己作成明細識別子.get履歴番号());
    }

    /**
     * {@link KyotakuKeikakuJikoSakusei}のインスタンスを生成します。
     *
     * @return {@link KyotakuKeikakuJikoSakusei}のインスタンス
     */
    public KyotakuKeikakuJikoSakusei build() {
        return new KyotakuKeikakuJikoSakusei(entity, id, kyotakuJikosakuseiMeisai, yoboKeikakuJikoSakuseiMeisai);
    }
}
