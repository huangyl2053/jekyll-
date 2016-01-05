/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha.roreifukushinenkinjukyusha;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * {@link RoreiFukushiNenkinJukyusha}の編集を行うビルダークラスです。
 */
public class RoreiFukushiNenkinJukyushaBuilder {

    private final DbT7006RoreiFukushiNenkinJukyushaEntity entity;
    private final RoreiFukushiNenkinJukyushaIdentifier id;

    /**
     * {@link DbT7006RoreiFukushiNenkinJukyushaEntity}より{@link RoreiFukushiNenkinJukyusha}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7006RoreiFukushiNenkinJukyushaEntity}
     * @param id {@link RoreiFukushiNenkinJukyushaIdentifier}
     *
     */
    RoreiFukushiNenkinJukyushaBuilder(
            DbT7006RoreiFukushiNenkinJukyushaEntity entity,
            RoreiFukushiNenkinJukyushaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 受給終了年月日を設定します。
     *
     * @param 受給終了年月日 受給終了年月日
     * @return {@link RoreiFukushiNenkinJukyushaBuilder}
     */
    public RoreiFukushiNenkinJukyushaBuilder set受給廃止年月日(FlexibleDate 受給終了年月日) {
        requireNonNull(受給終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給終了年月日"));
        entity.setJukyuShuryoYMD(受給終了年月日);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link RoreiFukushiNenkinJukyushaBuilder}
     */
    public RoreiFukushiNenkinJukyushaBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * {@link RoreiFukushiNenkinJukyusha}のインスタンスを生成します。
     *
     * @return {@link RoreiFukushiNenkinJukyusha}のインスタンス
     */
    public RoreiFukushiNenkinJukyusha build() {
        return new RoreiFukushiNenkinJukyusha(entity, id);
    }
}
