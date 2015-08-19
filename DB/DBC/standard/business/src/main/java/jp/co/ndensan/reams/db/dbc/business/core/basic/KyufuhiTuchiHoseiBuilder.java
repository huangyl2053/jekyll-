/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3067KyufuhiTuchiHoseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyufuhiTuchiHosei}の編集を行うビルダークラスです。
 */
public class KyufuhiTuchiHoseiBuilder {

    private final DbT3067KyufuhiTuchiHoseiEntity entity;
    private final KyufuhiTuchiHoseiIdentifier id;

    /**
     * {@link DbT3067KyufuhiTuchiHoseiEntity}より{@link KyufuhiTuchiHosei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3067KyufuhiTuchiHoseiEntity}
     * @param id {@link KyufuhiTuchiHoseiIdentifier}
     *
     */
    KyufuhiTuchiHoseiBuilder(
            DbT3067KyufuhiTuchiHoseiEntity entity,
            KyufuhiTuchiHoseiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KyufuhiTuchiHoseiBuilder}
     */
    public KyufuhiTuchiHoseiBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyufuhiTuchiHoseiBuilder}
     */
    public KyufuhiTuchiHoseiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KyufuhiTuchiHoseiBuilder}
     */
    public KyufuhiTuchiHoseiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     * @return {@link KyufuhiTuchiHoseiBuilder}
     */
    public KyufuhiTuchiHoseiBuilder set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link KyufuhiTuchiHoseiBuilder}
     */
    public KyufuhiTuchiHoseiBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KyufuhiTuchiHoseiBuilder}
     */
    public KyufuhiTuchiHoseiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * サービス費用合計額を設定します。
     *
     * @param サービス費用合計額 サービス費用合計額
     * @return {@link KyufuhiTuchiHoseiBuilder}
     */
    public KyufuhiTuchiHoseiBuilder setサービス費用合計額(Decimal サービス費用合計額) {
        requireNonNull(サービス費用合計額, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス費用合計額"));
        entity.setServiceHiyoTotal(サービス費用合計額);
        return this;
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     * @return {@link KyufuhiTuchiHoseiBuilder}
     */
    public KyufuhiTuchiHoseiBuilder set利用者負担額(Decimal 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutangaku(利用者負担額);
        return this;
    }

    /**
     * {@link KyufuhiTuchiHosei}のインスタンスを生成します。
     *
     * @return {@link KyufuhiTuchiHosei}のインスタンス
     */
    public KyufuhiTuchiHosei build() {
        return new KyufuhiTuchiHosei(entity, id);
    }
}
