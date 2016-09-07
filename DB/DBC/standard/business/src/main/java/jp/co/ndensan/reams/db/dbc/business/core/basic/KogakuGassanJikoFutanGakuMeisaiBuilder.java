/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3071KogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KogakuGassanJikoFutanGakuMeisai}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-4800-010 huzongcheng
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
    public KogakuGassanJikoFutanGakuMeisaiBuilder set履歴番号(int 履歴番号) {
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
        entity.setJikoFutanGaku(自己負担額);
        return this;
    }

    /**
     * 70_74自己負担額_内数を設定します。
     *
     * @param 自己負担額_内数_70_74 70_74自己負担額_内数
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set70_74自己負担額_内数(Decimal 自己負担額_内数_70_74) {
        entity.setUchisu_70_74JikoFutanGaku(自己負担額_内数_70_74);
        return this;
    }

    /**
     * 70未満高額支給額を設定します。
     *
     * @param 高額支給額_70未満 70未満高額支給額
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set70未満高額支給額(Decimal 高額支給額_70未満) {
        entity.setUnder_70KogakuShikyuGaku(高額支給額_70未満);
        return this;
    }

    /**
     * 70_74高額支給額を設定します。
     *
     * @param 高額支給額70_74 70_74高額支給額
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set70_74高額支給額(Decimal 高額支給額70_74) {
        entity.setOver_70_74KogakuShikyuGaku(高額支給額70_74);
        return this;
    }

    /**
     * 摘要を設定します。
     *
     * @param 摘要 摘要
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set摘要(RString 摘要) {
        entity.setTekiyo(摘要);
        return this;
    }

    /**
     * 補正済_自己負担額を設定します。
     *
     * @param 補正済_自己負担額 補正済_自己負担額
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set補正済_自己負担額(Decimal 補正済_自己負担額) {
        entity.setSumi_JikoFutanGaku(補正済_自己負担額);
        return this;
    }

    /**
     * 補正済_70_74自己負担額_内数を設定します。
     *
     * @param 補正済_70_74自己負担額_内数 補正済_70_74自己負担額_内数
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set補正済_70_74自己負担額_内数(Decimal 補正済_70_74自己負担額_内数) {
        entity.setSumi_70_74JikoFutanGaku(補正済_70_74自己負担額_内数);
        return this;
    }

    /**
     * 補正済_70未満高額支給額を設定します。
     *
     * @param 補正済_70未満高額支給額 補正済_70未満高額支給額
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set補正済_70未満高額支給額(Decimal 補正済_70未満高額支給額) {
        entity.setSumi_under_70KogakuShikyuGaku(補正済_70未満高額支給額);
        return this;
    }

    /**
     * 補正済_70_74高額支給額を設定します。
     *
     * @param 補正済_70_74高額支給額 補正済_70_74高額支給額
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set補正済_70_74高額支給額(Decimal 補正済_70_74高額支給額) {
        entity.setSumi_70_74KogakuShikyuGaku(補正済_70_74高額支給額);
        return this;
    }

    /**
     * 補正済_摘要を設定します。
     *
     * @param 補正済_摘要 補正済_摘要
     * @return {@link KogakuGassanJikoFutanGakuMeisaiBuilder}
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder set補正済_摘要(RString 補正済_摘要) {
        entity.setSumi_Tekiyo(補正済_摘要);
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
