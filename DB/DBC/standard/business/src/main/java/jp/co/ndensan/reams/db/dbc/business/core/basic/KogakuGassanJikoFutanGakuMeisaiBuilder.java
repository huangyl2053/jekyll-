/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * {@link KogakuGassanJikoFutanGakuMeisai}の編集を行うビルダークラスです。
 */
public class KogakuGassanJikoFutanGakuMeisaiBuilder {

    private final DbT3071KogakuGassanJikoFutanGakuMeisaiEntity entity;
    private final KogakuGassanJikoFutanGakuMeisaiIdentifier id;

    /**
     * {@link DbT3071KogakuGassanJikoFutanGakuMeisaiEntity}より{@link KogakuGassanJikoFutanGakuMeisai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3071KogakuGassanJikoFutanGakuMeisaiEntity}
     * @param id {@link KogakuGassanJikoFutanGakuMeisaiIdentifier}
     *
     */
    KogakuGassanJikoFutanGakuMeisaiBuilder(
            DbT3071KogakuGassanJikoFutanGakuMeisaiEntity entity,
            KogakuGassanJikoFutanGakuMeisaiIdentifier id
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
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 対象年度を設定します。
     *
     * @param 対象年度 対象年度
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set対象年度(FlexibleYear 対象年度) {
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        entity.setTaishoNendo(対象年度);
        return this;
    }

    /**
     * 保険者番号を設定します。
     *
     * @param 保険者番号 保険者番号
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set保険者番号(HokenshaNo 保険者番号) {
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        entity.setHokenshaNo(保険者番号);
        return this;
    }

    /**
     * 支給申請書整理番号を設定します。
     *
     * @param 支給申請書整理番号 支給申請書整理番号
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set支給申請書整理番号(RString 支給申請書整理番号) {
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        entity.setShikyuShinseishoSeiriNo(支給申請書整理番号);
        return this;
    }

    /**
     * 対象月を設定します。
     *
     * @param 対象月 対象月
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set対象月(RString 対象月) {
        requireNonNull(対象月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象月"));
        entity.setTaishoM(対象月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 自己負担額を設定します。
     *
     * @param 自己負担額 自己負担額
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set自己負担額(Decimal 自己負担額) {
        requireNonNull(自己負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担額"));
        entity.setJikoFutanGaku(自己負担額);
        return this;
    }

    /**
     * 70-74自己負担額（内数）を設定します。
     *
     * @param 70-74自己負担額（内数） 70-74自己負担額（内数）
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set70-74自己負担額（内数）(Decimal 70-74自己負担額（内数）) {
        requireNonNull(70-74自己負担額（内数）, UrSystemErrorMessages.値がnull.getReplacedMessage("70-74自己負担額（内数）"));
        entity.setUchisu_70_74JikoFutanGaku(70-74自己負担額（内数）);
        return this;
    }

    /**
     * 70未満高額支給額を設定します。
     *
     * @param 70未満高額支給額 70未満高額支給額
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set70未満高額支給額(Decimal 70未満高額支給額) {
        requireNonNull(70未満高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("70未満高額支給額"));
        entity.setUnder_70KogakuShikyuGaku(70未満高額支給額);
        return this;
    }

    /**
     * 70-74高額支給額を設定します。
     *
     * @param 70-74高額支給額 70-74高額支給額
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set70-74高額支給額(Decimal 70-74高額支給額) {
        requireNonNull(70-74高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("70-74高額支給額"));
        entity.setOver_70_74KogakuShikyuGaku(70-74高額支給額);
        return this;
    }

    /**
     * 摘要を設定します。
     *
     * @param 摘要 摘要
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set摘要(RString 摘要) {
        requireNonNull(摘要, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要"));
        entity.setTekiyo(摘要);
        return this;
    }

    /**
     * 補正済・自己負担額を設定します。
     *
     * @param 補正済・自己負担額 補正済・自己負担額
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set補正済・自己負担額(Decimal 補正済・自己負担額) {
        requireNonNull(補正済・自己負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("補正済・自己負担額"));
        entity.setSumi_JikoFutanGaku(補正済・自己負担額);
        return this;
    }

    /**
     * 補正済・70-74自己負担額（内数）を設定します。
     *
     * @param 補正済・70-74自己負担額（内数） 補正済・70-74自己負担額（内数）
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set補正済・70-74自己負担額（内数）(Decimal 補正済・70-74自己負担額（内数）) {
        requireNonNull(補正済・70-74自己負担額（内数）, UrSystemErrorMessages.値がnull.getReplacedMessage("補正済・70-74自己負担額（内数）"));
        entity.setSumi_70_74JikoFutanGaku(補正済・70-74自己負担額（内数）);
        return this;
    }

    /**
     * 補正済・70未満高額支給額を設定します。
     *
     * @param 補正済・70未満高額支給額 補正済・70未満高額支給額
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set補正済・70未満高額支給額(Decimal 補正済・70未満高額支給額) {
        requireNonNull(補正済・70未満高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("補正済・70未満高額支給額"));
        entity.setSumi_under_70KogakuShikyuGaku(補正済・70未満高額支給額);
        return this;
    }

    /**
     * 補正済・70-74高額支給額を設定します。
     *
     * @param 補正済・70-74高額支給額 補正済・70-74高額支給額
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set補正済・70-74高額支給額(Decimal 補正済・70-74高額支給額) {
        requireNonNull(補正済・70-74高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("補正済・70-74高額支給額"));
        entity.setSumi_70_74KogakuShikyuGaku(補正済・70-74高額支給額);
        return this;
    }

    /**
     * 補正済・摘要を設定します。
     *
     * @param 補正済・摘要 補正済・摘要
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set補正済・摘要(RString 補正済・摘要) {
        requireNonNull(補正済・摘要, UrSystemErrorMessages.値がnull.getReplacedMessage("補正済・摘要"));
        entity.setSumi_Tekiyo(補正済・摘要);
        return this;
    }

    /**
     * {@link KogakuGassanJikoFutanGakuMeisai}のインスタンスを生成します。
     *
     * @return {@link KogakuGassanJikoFutanGakuMeisai}のインスタンス
     */
    public KogakuGassanJikoFutanGakuMeisai build() {
        return new KogakuGassanJikoFutanGakuMeisai(entity, id);
    }
}
