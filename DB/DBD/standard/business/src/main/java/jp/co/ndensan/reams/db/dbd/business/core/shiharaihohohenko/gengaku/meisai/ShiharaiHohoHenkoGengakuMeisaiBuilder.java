/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.gengaku.meisai;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * {@link ShiharaiHohoHenkoGengakuMeisai}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class ShiharaiHohoHenkoGengakuMeisaiBuilder {

    private final DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity entity;
    private final ShiharaiHohoHenkoGengakuMeisaiIdentifier id;

    /**
     * {@link DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity}より{@link ShiharaiHohoHenkoGengakuMeisai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity}
     * @param id {@link ShiharaiHohoHenkoGengakuMeisaiIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    ShiharaiHohoHenkoGengakuMeisaiBuilder(
            DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity entity,
            ShiharaiHohoHenkoGengakuMeisaiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;
    }

    /**
     * EntityDataStateを設定します
     *
     * @param state EntityDataState
     * @return {@link ShiharaiHohoHenkoGengakuMeisaiBuilder}
     */
    public ShiharaiHohoHenkoGengakuMeisaiBuilder setState(EntityDataState state) {
        requireNonNull(state, UrSystemErrorMessages.値がnull.getReplacedMessage("EntityDataState"));
        entity.setState(state);
        return this;
    }

    /**
     * 未納_時効消滅減額を設定します。
     *
     * @param 未納_時効消滅減額 未納_時効消滅減額
     * @return {@link ShiharaiHohoHenkoGengakuMeisaiBuilder}
     */
    public ShiharaiHohoHenkoGengakuMeisaiBuilder set未納_時効消滅減額(Decimal 未納_時効消滅減額) {
        requireNonNull(未納_時効消滅減額, UrSystemErrorMessages.値がnull.getReplacedMessage("未納_時効消滅減額")
        );
        entity.setMino_JikoShometsuGengaku(未納_時効消滅減額
        );
        return this;
    }

    /**
     * 納付額を設定します。
     *
     * @param 納付額 納付額
     * @return {@link ShiharaiHohoHenkoGengakuMeisaiBuilder}
     */
    public ShiharaiHohoHenkoGengakuMeisaiBuilder set納付額(Decimal 納付額) {
        requireNonNull(納付額, UrSystemErrorMessages.値がnull.getReplacedMessage("納付額"));
        entity.setNofugaku(納付額);
        return this;
    }

    /**
     * 年賦課額を設定します。
     *
     * @param 年賦課額 年賦課額
     * @return {@link ShiharaiHohoHenkoGengakuMeisaiBuilder}
     */
    public ShiharaiHohoHenkoGengakuMeisaiBuilder set年賦課額(Decimal 年賦課額) {
        requireNonNull(年賦課額, UrSystemErrorMessages.値がnull.getReplacedMessage("年賦課額"));
        entity.setNenFukagaku(年賦課額);
        return this;
    }

    /**
     * {@link ShiharaiHohoHenkoGengakuMeisai}のインスタンスを生成します。
     *
     * @return {@link ShiharaiHohoHenkoGengakuMeisai}のインスタンス
     */
    public ShiharaiHohoHenkoGengakuMeisai build() {
        return new ShiharaiHohoHenkoGengakuMeisai(entity, id);
    }
}
