/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogofujoshurui;

import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0526SeikatsuHogoFujoShuruiEntity;

/**
 * {@link SeikatsuHogoFujoShurui}の編集を行うビルダークラスです。
 */
public class SeikatsuHogoFujoShuruiBuilder {

    private final UrT0526SeikatsuHogoFujoShuruiEntity entity;
    private final SeikatsuHogoFujoShuruiIdentifier id;

    /**
     * {@link UrT0526SeikatsuHogoFujoShuruiEntity}より{@link SeikatsuHogoFujoShurui}の編集用Builderクラスを生成します。
     *
     * @param entity {@link UrT0526SeikatsuHogoFujoShuruiEntity}
     * @param id {@link SeikatsuHogoFujoShuruiIdentifier}
     *
     */
    SeikatsuHogoFujoShuruiBuilder(
            UrT0526SeikatsuHogoFujoShuruiEntity entity,
            SeikatsuHogoFujoShuruiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * {@link SeikatsuHogoFujoShurui}のインスタンスを生成します。
     *
     * @return {@link SeikatsuHogoFujoShurui}のインスタンス
     */
    public SeikatsuHogoFujoShurui build() {
        return new SeikatsuHogoFujoShurui(entity, id);
    }
}
