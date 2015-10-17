/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3069KogakuGassanShinseishoKanyurekiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KogakuGassanShinseishoKanyureki}の編集を行うビルダークラスです。
 */
public class KogakuGassanShinseishoKanyurekiBuilder {

    private final DbT3069KogakuGassanShinseishoKanyurekiEntity entity;
    private final KogakuGassanShinseishoKanyurekiIdentifier id;

    /**
     * {@link DbT3069KogakuGassanShinseishoKanyurekiEntity}より{@link KogakuGassanShinseishoKanyureki}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3069KogakuGassanShinseishoKanyurekiEntity}
     * @param id {@link KogakuGassanShinseishoKanyurekiIdentifier}
     *
     */
    KogakuGassanShinseishoKanyurekiBuilder(
            DbT3069KogakuGassanShinseishoKanyurekiEntity entity,
            KogakuGassanShinseishoKanyurekiIdentifier id
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
     * @return {@link KogakuGassanShinseishoKanyurekiBuilder}
     */
    public KogakuGassanShinseishoKanyurekiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 対象年度を設定します。
     *
     * @param 対象年度 対象年度
     * @return {@link KogakuGassanShinseishoKanyurekiBuilder}
     */
    public KogakuGassanShinseishoKanyurekiBuilder set対象年度(FlexibleYear 対象年度) {
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        entity.setTaishoNendo(対象年度);
        return this;
    }

    /**
     * 保険者番号を設定します。
     *
     * @param 保険者番号 保険者番号
     * @return {@link KogakuGassanShinseishoKanyurekiBuilder}
     */
    public KogakuGassanShinseishoKanyurekiBuilder set保険者番号(HokenshaNo 保険者番号) {
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        entity.setHokenshaNo(保険者番号);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link KogakuGassanShinseishoKanyurekiBuilder}
     */
    public KogakuGassanShinseishoKanyurekiBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 加入歴番号を設定します。
     *
     * @param 加入歴番号 加入歴番号
     * @return {@link KogakuGassanShinseishoKanyurekiBuilder}
     */
    public KogakuGassanShinseishoKanyurekiBuilder set加入歴番号(RString 加入歴番号) {
        requireNonNull(加入歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("加入歴番号"));
        entity.setKanyurekiNo(加入歴番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KogakuGassanShinseishoKanyurekiBuilder}
     */
    public KogakuGassanShinseishoKanyurekiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 保険者名を設定します。
     *
     * @param 保険者名 保険者名
     * @return {@link KogakuGassanShinseishoKanyurekiBuilder}
     */
    public KogakuGassanShinseishoKanyurekiBuilder set保険者名(RString 保険者名) {
        requireNonNull(保険者名, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者名"));
        entity.setHokenshaMei(保険者名);
        return this;
    }

    /**
     * 加入期間開始年月日を設定します。
     *
     * @param 加入期間開始年月日 加入期間開始年月日
     * @return {@link KogakuGassanShinseishoKanyurekiBuilder}
     */
    public KogakuGassanShinseishoKanyurekiBuilder set加入期間開始年月日(FlexibleDate 加入期間開始年月日) {
        requireNonNull(加入期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("加入期間開始年月日"));
        entity.setKanyuKaishiYMD(加入期間開始年月日);
        return this;
    }

    /**
     * 加入期間終了年月日を設定します。
     *
     * @param 加入期間終了年月日 加入期間終了年月日
     * @return {@link KogakuGassanShinseishoKanyurekiBuilder}
     */
    public KogakuGassanShinseishoKanyurekiBuilder set加入期間終了年月日(FlexibleDate 加入期間終了年月日) {
        requireNonNull(加入期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("加入期間終了年月日"));
        entity.setKanyuShuryoYMD(加入期間終了年月日);
        return this;
    }

    /**
     * 自己負担額証明書整理番号を設定します。
     *
     * @param 自己負担額証明書整理番号 自己負担額証明書整理番号
     * @return {@link KogakuGassanShinseishoKanyurekiBuilder}
     */
    public KogakuGassanShinseishoKanyurekiBuilder set自己負担額証明書整理番号(RString 自己負担額証明書整理番号) {
        requireNonNull(自己負担額証明書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担額証明書整理番号"));
        entity.setJikoFutanShomeisho_SeiriNo(自己負担額証明書整理番号);
        return this;
    }

    /**
     * {@link KogakuGassanShinseishoKanyureki}のインスタンスを生成します。
     *
     * @return {@link KogakuGassanShinseishoKanyureki}のインスタンス
     */
    public KogakuGassanShinseishoKanyureki build() {
        return new KogakuGassanShinseishoKanyureki(entity, id);
    }
}
