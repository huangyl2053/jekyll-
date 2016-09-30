/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3100NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * {@link NijiYoboJigyoTaishosha}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-9999-012 yuqingzhang
 */
public class NijiYoboJigyoTaishoshaBuilder {

    private final DbT3100NijiYoboJigyoTaishoshaEntity entity;
    private final NijiYoboJigyoTaishoshaIdentifier id;

    /**
     * {@link DbT3100NijiYoboJigyoTaishoshaEntity}より{@link NijiYoboJigyoTaishosha}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3100NijiYoboJigyoTaishoshaEntity}
     * @param id {@link NijiYoboJigyoTaishoshaIdentifier}
     *
     */
    NijiYoboJigyoTaishoshaBuilder(
            DbT3100NijiYoboJigyoTaishoshaEntity entity,
            NijiYoboJigyoTaishoshaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     * @return {@link NijiYoboJigyoTaishoshaBuilder}
     */
    public NijiYoboJigyoTaishoshaBuilder set適用開始年月日(FlexibleDate 適用開始年月日) {
        requireNonNull(適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月日"));
        entity.setTekiyoKaishiYMD(適用開始年月日);
        return this;
    }

    /**
     * 適用終了年月日を設定します。
     *
     * @param 適用終了年月日 適用終了年月日
     * @return {@link NijiYoboJigyoTaishoshaBuilder}
     */
    public NijiYoboJigyoTaishoshaBuilder set適用終了年月日(FlexibleDate 適用終了年月日) {
        requireNonNull(適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月日"));
        entity.setTekiyoShuryoYMD(適用終了年月日);
        return this;
    }

    /**
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     * @return {@link NijiYoboJigyoTaishoshaBuilder}
     */
    public NijiYoboJigyoTaishoshaBuilder set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
        return this;
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     * @return {@link NijiYoboJigyoTaishoshaBuilder}
     */
    public NijiYoboJigyoTaishoshaBuilder set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
        return this;
    }

    /**
     * 調査実施日を設定します。
     *
     * @param 調査実施日 調査実施日
     * @return {@link NijiYoboJigyoTaishoshaBuilder}
     */
    public NijiYoboJigyoTaishoshaBuilder set調査実施日(FlexibleDate 調査実施日) {
        requireNonNull(調査実施日, UrSystemErrorMessages.値がnull.getReplacedMessage("調査実施日"));
        entity.setChosaJisshiYMD(調査実施日);
        return this;
    }

    /**
     * {@link NijiYoboJigyoTaishosha}のインスタンスを生成します。
     *
     * @return {@link NijiYoboJigyoTaishosha}のインスタンス
     */
    public NijiYoboJigyoTaishosha build() {
        return new NijiYoboJigyoTaishosha(entity, id);
    }

    /**
     * NijiYoboJigyoTaishoshaの編集を行うビルダークラスを返します。
     *
     * @param createNijiYoboKihonCheckList 二次予防基本チェックリストを管理するクラス
     * @return NijiYoboJigyoTaishoshaの編集を行うビルダークラス
     */
    public NijiYoboJigyoTaishoshaBuilder setNijiYoboKihonCheckList(NijiYoboKihonCheckList createNijiYoboKihonCheckList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
