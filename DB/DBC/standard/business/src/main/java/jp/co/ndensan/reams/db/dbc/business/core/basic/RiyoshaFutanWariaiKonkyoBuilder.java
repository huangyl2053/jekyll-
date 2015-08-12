/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3115RiyoshaFutanWariaiKonkyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link RiyoshaFutanWariaiKonkyo}の編集を行うビルダークラスです。
 */
public class RiyoshaFutanWariaiKonkyoBuilder {

    private final DbT3115RiyoshaFutanWariaiKonkyoEntity entity;
    private final RiyoshaFutanWariaiKonkyoIdentifier id;

    /**
     * {@link DbT3115RiyoshaFutanWariaiKonkyoEntity}より{@link RiyoshaFutanWariaiKonkyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3115RiyoshaFutanWariaiKonkyoEntity}
     * @param id {@link RiyoshaFutanWariaiKonkyoIdentifier}
     *
     */
    RiyoshaFutanWariaiKonkyoBuilder(
            DbT3115RiyoshaFutanWariaiKonkyoEntity entity,
            RiyoshaFutanWariaiKonkyoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 年度を設定します。
     *
     * @param 年度 年度
     * @return {@link RiyoshaFutanWariaiKonkyoBuilder}
     */
    public RiyoshaFutanWariaiKonkyoBuilder set年度(FlexibleYear 年度) {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        entity.setNendo(年度);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link RiyoshaFutanWariaiKonkyoBuilder}
     */
    public RiyoshaFutanWariaiKonkyoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link RiyoshaFutanWariaiKonkyoBuilder}
     */
    public RiyoshaFutanWariaiKonkyoBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 枝番号を設定します。
     *
     * @param 枝番号 枝番号
     * @return {@link RiyoshaFutanWariaiKonkyoBuilder}
     */
    public RiyoshaFutanWariaiKonkyoBuilder set枝番号(Decimal 枝番号) {
        requireNonNull(枝番号, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番号"));
        entity.setEdaNo(枝番号);
        return this;
    }

    /**
     * 世帯員被保険者番号を設定します。
     *
     * @param 世帯員被保険者番号 世帯員被保険者番号
     * @return {@link RiyoshaFutanWariaiKonkyoBuilder}
     */
    public RiyoshaFutanWariaiKonkyoBuilder set世帯員被保険者番号(HihokenshaNo 世帯員被保険者番号) {
        requireNonNull(世帯員被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員被保険者番号"));
        entity.setSetaiinHihokenshaNo(世帯員被保険者番号);
        return this;
    }

    /**
     * 世帯員所得履歴番号を設定します。
     *
     * @param 世帯員所得履歴番号 世帯員所得履歴番号
     * @return {@link RiyoshaFutanWariaiKonkyoBuilder}
     */
    public RiyoshaFutanWariaiKonkyoBuilder set世帯員所得履歴番号(Decimal 世帯員所得履歴番号) {
        requireNonNull(世帯員所得履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員所得履歴番号"));
        entity.setSetaiinShotokuRirekiNo(世帯員所得履歴番号);
        return this;
    }

    /**
     * {@link RiyoshaFutanWariaiKonkyo}のインスタンスを生成します。
     *
     * @return {@link RiyoshaFutanWariaiKonkyo}のインスタンス
     */
    public RiyoshaFutanWariaiKonkyo build() {
        return new RiyoshaFutanWariaiKonkyo(entity, id);
    }
}
