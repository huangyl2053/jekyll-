/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeika;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-9999-011 sunhaidi
 */
public class KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder {

    private final DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity;
    private final KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier id;

    /**
     * {@link DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity}より{@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity}
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
     * @return {@link YoboKeikakuJikoSakuseiTankiRiyoNissuBuilder}
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
     * @return {@link YoboKeikakuJikoSakuseiTankiRiyoNissuBuilder}
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 利用年月を設定します。
     *
     * @param 利用年月 利用年月
     * @return {@link YoboKeikakuJikoSakuseiTankiRiyoNissuBuilder}
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder set利用年月(FlexibleYearMonth 利用年月) {
        requireNonNull(利用年月, UrSystemErrorMessages.値がnull.getReplacedMessage("利用年月"));
        entity.setRiyoYM(利用年月);
        return this;
    }

    /**
     * 前回迄利用日数を設定します。
     *
     * @param 前回迄利用日数 前回迄利用日数
     * @return {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder}
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder set前回迄利用日数(Decimal 前回迄利用日数) {
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
        entity.setKonkaiKeikakuRiyoNissu(今回計画利用日数);
        return this;
    }

    /**
     * 暫定区分を設定します。
     *
     * @param 暫定区分 暫定区分
     * @return {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder}
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder set暫定区分(RString 暫定区分) {
        entity.setZanteiKubun(暫定区分);
        return this;
    }

    /**
     * 更新区分を設定します。
     *
     * @param 更新区分 更新区分
     * @return {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder}
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder set更新区分(RString 更新区分) {
        entity.setKoshinKubun(更新区分);
        return this;
    }

    /**
     * 更新年月日を設定します。
     *
     * @param 更新年月日 更新年月日
     * @return {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder}
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder set更新年月日(FlexibleDate 更新年月日) {
        entity.setKoshinYMD(更新年月日);
        return this;
    }

    /**
     * 送付年月を設定します。
     *
     * @param 送付年月 送付年月
     * @return {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder}
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder set送付年月(FlexibleYearMonth 送付年月) {
        entity.setSofuYM(送付年月);
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
