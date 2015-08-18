/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu}の編集を行うビルダークラスです。
 */
public class KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder {

    private final DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity;
    private final KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier id;

    /**
     * {@link DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity}より{@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu}の編集用Builderクラスを生成します。
     *
     * @param entity
     * {@link DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity}
     * @param id {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier}
     *
     */
    KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder(
            DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity,
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier id
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
     * @return {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder}
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 対象年月を設定します。
     *
     * @param 対象年月 対象年月
     * @return {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder}
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder set対象年月(FlexibleYearMonth 対象年月) {
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        entity.setTaishoYM(対象年月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder}
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 前回迄利用日数を設定します。
     *
     * @param 前回迄利用日数 前回迄利用日数
     * @return {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder}
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder set前回迄利用日数(Decimal 前回迄利用日数) {
        requireNonNull(前回迄利用日数, UrSystemErrorMessages.値がnull.getReplacedMessage("前回迄利用日数"));
        entity.setZenkaiRiyoNissu(前回迄利用日数);
        return this;
    }

    /**
     * 今回計画利用日数を設定します。
     *
     * @param 今回計画利用日数 今回計画利用日数
     * @return {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder}
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder set今回計画利用日数(Decimal 今回計画利用日数) {
        requireNonNull(今回計画利用日数, UrSystemErrorMessages.値がnull.getReplacedMessage("今回計画利用日数"));
        entity.setKonkaiKeikakuRiyoNissu(今回計画利用日数);
        return this;
    }

    /**
     * {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu}のインスタンスを生成します。
     *
     * @return {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu}のインスタンス
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu build() {
        return new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(entity, id);
    }
}
