/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyotakuKeikakuJigyoshaSakusei}の編集を行うビルダークラスです。
 */
public class KyotakuKeikakuJigyoshaSakuseiBuilder {

    private final DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity;
    private final KyotakuKeikakuJigyoshaSakuseiIdentifier id;

    /**
     * {@link DbT3006KyotakuKeikakuJigyoshaSakuseiEntity}より{@link KyotakuKeikakuJigyoshaSakusei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3006KyotakuKeikakuJigyoshaSakuseiEntity}
     * @param id {@link KyotakuKeikakuJigyoshaSakuseiIdentifier}
     *
     */
    KyotakuKeikakuJigyoshaSakuseiBuilder(
            DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity,
            KyotakuKeikakuJigyoshaSakuseiIdentifier id
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
     * @return {@link KyotakuKeikakuJigyoshaSakuseiBuilder}
     */
    public KyotakuKeikakuJigyoshaSakuseiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshano(被保険者番号);
        return this;
    }

    /**
     * 対象年月を設定します。
     *
     * @param 対象年月 対象年月
     * @return {@link KyotakuKeikakuJigyoshaSakuseiBuilder}
     */
    public KyotakuKeikakuJigyoshaSakuseiBuilder set対象年月(FlexibleYearMonth 対象年月) {
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        entity.setTaishoYM(対象年月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KyotakuKeikakuJigyoshaSakuseiBuilder}
     */
    public KyotakuKeikakuJigyoshaSakuseiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     * @return {@link KyotakuKeikakuJigyoshaSakuseiBuilder}
     */
    public KyotakuKeikakuJigyoshaSakuseiBuilder set適用開始年月日(FlexibleDate 適用開始年月日) {
        requireNonNull(適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月日"));
        entity.setTekiyoKaishiYMD(適用開始年月日);
        return this;
    }

    /**
     * 適用終了年月日を設定します。
     *
     * @param 適用終了年月日 適用終了年月日
     * @return {@link KyotakuKeikakuJigyoshaSakuseiBuilder}
     */
    public KyotakuKeikakuJigyoshaSakuseiBuilder set適用終了年月日(FlexibleDate 適用終了年月日) {
        requireNonNull(適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月日"));
        entity.setTekiyoShuryoYMD(適用終了年月日);
        return this;
    }

    /**
     * 作成区分コードを設定します。
     *
     * @param 作成区分コード 作成区分コード
     * @return {@link KyotakuKeikakuJigyoshaSakuseiBuilder}
     */
    public KyotakuKeikakuJigyoshaSakuseiBuilder set作成区分コード(RString 作成区分コード) {
        requireNonNull(作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("作成区分コード"));
        entity.setSakuseiKubunCode(作成区分コード);
        return this;
    }

    /**
     * 計画事業者番号を設定します。
     *
     * @param 計画事業者番号 計画事業者番号
     * @return {@link KyotakuKeikakuJigyoshaSakuseiBuilder}
     */
    public KyotakuKeikakuJigyoshaSakuseiBuilder set計画事業者番号(JigyoshaNo 計画事業者番号) {
        requireNonNull(計画事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("計画事業者番号"));
        entity.setKeikakuJigyoshaNo(計画事業者番号);
        return this;
    }

    /**
     * 委託先事業者番号を設定します。
     *
     * @param 委託先事業者番号 委託先事業者番号
     * @return {@link KyotakuKeikakuJigyoshaSakuseiBuilder}
     */
    public KyotakuKeikakuJigyoshaSakuseiBuilder set委託先事業者番号(JigyoshaNo 委託先事業者番号) {
        requireNonNull(委託先事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("委託先事業者番号"));
        entity.setItakusakiJigyoshaNo(委託先事業者番号);
        return this;
    }

    /**
     * 事業者変更年月日を設定します。
     *
     * @param 事業者変更年月日 事業者変更年月日
     * @return {@link KyotakuKeikakuJigyoshaSakuseiBuilder}
     */
    public KyotakuKeikakuJigyoshaSakuseiBuilder set事業者変更年月日(FlexibleDate 事業者変更年月日) {
        requireNonNull(事業者変更年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者変更年月日"));
        entity.setJigyoshaHenkoYMD(事業者変更年月日);
        return this;
    }

    /**
     * 事業者変更事由を設定します。
     *
     * @param 事業者変更事由 事業者変更事由
     * @return {@link KyotakuKeikakuJigyoshaSakuseiBuilder}
     */
    public KyotakuKeikakuJigyoshaSakuseiBuilder set事業者変更事由(RString 事業者変更事由) {
        requireNonNull(事業者変更事由, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者変更事由"));
        entity.setJigyoshaHenkoJiyu(事業者変更事由);
        return this;
    }

    /**
     * {@link KyotakuKeikakuJigyoshaSakusei}のインスタンスを生成します。
     *
     * @return {@link KyotakuKeikakuJigyoshaSakusei}のインスタンス
     */
    public KyotakuKeikakuJigyoshaSakusei build() {
        return new KyotakuKeikakuJigyoshaSakusei(entity, id);
    }
}
