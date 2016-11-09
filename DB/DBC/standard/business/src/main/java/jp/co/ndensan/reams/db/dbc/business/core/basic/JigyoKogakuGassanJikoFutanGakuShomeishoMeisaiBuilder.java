/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link JigyoKogakuGassanJikoFutanGakuShomeishoMeisai}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-4820-010 sunhaidi
 */
public class JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder {

    private final DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity entity;
    private final JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiIdentifier id;

    /**
     * {@link DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity}より{@link JigyoKogakuGassanJikoFutanGakuShomeishoMeisai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity}
     * @param id {@link JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiIdentifier}
     *
     */
    JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder(
            DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity entity,
            JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 対象月を設定します。
     *
     * @param 対象月 対象月
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder set対象月(RString 対象月) {
        requireNonNull(対象月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象月"));
        entity.setTaishoM(対象月);
        return this;
    }

    /**
     * 自己負担額を設定します。
     *
     * @param 自己負担額 自己負担額
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder set自己負担額(Decimal 自己負担額) {
        requireNonNull(自己負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担額"));
        entity.setJikoFutanGaku(自己負担額);
        return this;
    }

    /**
     * 70-74自己負担額（内数）を設定します。
     *
     * @param 自己負担額_内数 70-74自己負担額（内数）
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder set70_74自己負担額_内数(Decimal 自己負担額_内数) {
        requireNonNull(自己負担額_内数, UrSystemErrorMessages.値がnull.getReplacedMessage("70-74自己負担額（内数）"));
        entity.setUchisu_70_74JikoFutanGaku(自己負担額_内数);
        return this;
    }

    /**
     * 70未満高額支給額を設定します。
     *
     * @param 未満高額支給額 70未満高額支給額
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder set70未満高額支給額(Decimal 未満高額支給額) {
        requireNonNull(未満高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("70未満高額支給額"));
        entity.setUnder_70KogakuShikyuGaku(未満高額支給額);
        return this;
    }

    /**
     * 70-74高額支給額を設定します。
     *
     * @param 高額支給額 70-74高額支給額
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder set70_74高額支給額(Decimal 高額支給額) {
        requireNonNull(高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("70-74高額支給額"));
        entity.setOver_70_74KogakuShikyuGaku(高額支給額);
        return this;
    }

    /**
     * 摘要を設定します。
     *
     * @param 摘要 摘要
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder set摘要(RString 摘要) {
        requireNonNull(摘要, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要"));
        entity.setTekiyo(摘要);
        return this;
    }

    /**
     * {@link JigyoKogakuGassanJikoFutanGakuShomeishoMeisai}のインスタンスを生成します。
     *
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoMeisai}のインスタンス
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoMeisai build() {
        return new JigyoKogakuGassanJikoFutanGakuShomeishoMeisai(entity, id);
    }
}
