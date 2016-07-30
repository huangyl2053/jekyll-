/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KogakuKyufuTaishoshaMeisai}の編集を行うビルダークラスです。
 */
public class KogakuKyufuTaishoshaMeisaiBuilder {

    private final DbT3054KogakuKyufuTaishoshaMeisaiEntity entity;
    private final KogakuKyufuTaishoshaMeisaiIdentifier id;

    /**
     * {@link DbT3054KogakuKyufuTaishoshaMeisaiEntity}より{@link KogakuKyufuTaishoshaMeisai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3054KogakuKyufuTaishoshaMeisaiEntity}
     * @param id {@link KogakuKyufuTaishoshaMeisaiIdentifier}
     *
     */
    KogakuKyufuTaishoshaMeisaiBuilder(
            DbT3054KogakuKyufuTaishoshaMeisaiEntity entity,
            KogakuKyufuTaishoshaMeisaiIdentifier id
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
     * @return {@link KogakuKyufuTaishoshaMeisaiBuilder}
     */
    public KogakuKyufuTaishoshaMeisaiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KogakuKyufuTaishoshaMeisaiBuilder}
     */
    public KogakuKyufuTaishoshaMeisaiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     * @return {@link KogakuKyufuTaishoshaMeisaiBuilder}
     */
    public KogakuKyufuTaishoshaMeisaiBuilder set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link KogakuKyufuTaishoshaMeisaiBuilder}
     */
    public KogakuKyufuTaishoshaMeisaiBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KogakuKyufuTaishoshaMeisaiBuilder}
     */
    public KogakuKyufuTaishoshaMeisaiBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * サービス費用合計額を設定します。
     *
     * @param サービス費用合計額 サービス費用合計額
     * @return {@link KogakuKyufuTaishoshaMeisaiBuilder}
     */
    public KogakuKyufuTaishoshaMeisaiBuilder setサービス費用合計額(Decimal サービス費用合計額) {
        requireNonNull(サービス費用合計額, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス費用合計額"));
        entity.setServiceHiyoGokeiGaku(サービス費用合計額);
        return this;
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     * @return {@link KogakuKyufuTaishoshaMeisaiBuilder}
     */
    public KogakuKyufuTaishoshaMeisaiBuilder set利用者負担額(Decimal 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutanGaku(利用者負担額);
        return this;
    }

    /**
     * 高額給付根拠を設定します。
     *
     * @param 高額給付根拠 高額給付根拠
     * @return {@link KogakuKyufuTaishoshaMeisaiBuilder}
     */
    public KogakuKyufuTaishoshaMeisaiBuilder set高額給付根拠(RString 高額給付根拠) {
        requireNonNull(高額給付根拠, UrSystemErrorMessages.値がnull.getReplacedMessage("高額給付根拠"));
        entity.setKogakuKyufuKonkyo(高額給付根拠);
        return this;
    }

    /**
     * 高額給付根拠を設定します。
     *
     * @param 対象者受取年月 FlexibleYearMonth
     * @return {@link KogakuKyufuTaishoshaMeisaiBuilder}
     */
    public KogakuKyufuTaishoshaMeisaiBuilder set対象者受取年月(FlexibleYearMonth 対象者受取年月) {
        requireNonNull(対象者受取年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象者受取年月"));
        entity.setTaishoshaUketoriYM(対象者受取年月);
        return this;
    }

    /**
     * {@link KogakuKyufuTaishoshaMeisai}のインスタンスを生成します。
     *
     * @return {@link KogakuKyufuTaishoshaMeisai}のインスタンス
     */
    public KogakuKyufuTaishoshaMeisai build() {
        return new KogakuKyufuTaishoshaMeisai(entity, id);
    }
}
