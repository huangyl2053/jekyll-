/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link JigyoKogakuKyufuTaishoshaMeisai}の編集を行うビルダークラスです。
 */
public class JigyoKogakuKyufuTaishoshaMeisaiBuilder {

    private final DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity entity;
    private final JigyoKogakuKyufuTaishoshaMeisaiIdentifier id;

    /**
     * {@link DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity}より{@link JigyoKogakuKyufuTaishoshaMeisai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity}
     * @param id {@link JigyoKogakuKyufuTaishoshaMeisaiIdentifier}
     *
     */
    JigyoKogakuKyufuTaishoshaMeisaiBuilder(
            DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity entity,
            JigyoKogakuKyufuTaishoshaMeisaiIdentifier id
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
     * @return {@link JigyoKogakuKyufuTaishoshaMeisaiBuilder}
     */
    public JigyoKogakuKyufuTaishoshaMeisaiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link JigyoKogakuKyufuTaishoshaMeisaiBuilder}
     */
    public JigyoKogakuKyufuTaishoshaMeisaiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     * @return {@link JigyoKogakuKyufuTaishoshaMeisaiBuilder}
     */
    public JigyoKogakuKyufuTaishoshaMeisaiBuilder set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link JigyoKogakuKyufuTaishoshaMeisaiBuilder}
     */
    public JigyoKogakuKyufuTaishoshaMeisaiBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link JigyoKogakuKyufuTaishoshaMeisaiBuilder}
     */
    public JigyoKogakuKyufuTaishoshaMeisaiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * サービス費用合計額を設定します。
     *
     * @param サービス費用合計額 サービス費用合計額
     * @return {@link JigyoKogakuKyufuTaishoshaMeisaiBuilder}
     */
    public JigyoKogakuKyufuTaishoshaMeisaiBuilder setサービス費用合計額(Decimal サービス費用合計額) {
        requireNonNull(サービス費用合計額, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス費用合計額"));
        entity.setServiceHiyoGokeiGaku(サービス費用合計額);
        return this;
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     * @return {@link JigyoKogakuKyufuTaishoshaMeisaiBuilder}
     */
    public JigyoKogakuKyufuTaishoshaMeisaiBuilder set利用者負担額(Decimal 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutanGaku(利用者負担額);
        return this;
    }

    /**
     * 事業高額給付根拠を設定します。
     *
     * @param 事業高額給付根拠 事業高額給付根拠
     * @return {@link JigyoKogakuKyufuTaishoshaMeisaiBuilder}
     */
    public JigyoKogakuKyufuTaishoshaMeisaiBuilder set事業高額給付根拠(RString 事業高額給付根拠) {
        requireNonNull(事業高額給付根拠, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額給付根拠"));
        entity.setJigyoKogakuKyufuKonkyo(事業高額給付根拠);
        return this;
    }

    /**
     * {@link JigyoKogakuKyufuTaishoshaMeisai}のインスタンスを生成します。
     *
     * @return {@link JigyoKogakuKyufuTaishoshaMeisai}のインスタンス
     */
    public JigyoKogakuKyufuTaishoshaMeisai build() {
        return new JigyoKogakuKyufuTaishoshaMeisai(entity, id);
    }
}
