/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1013KyokaisoSochiShinseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyokaisoSochiShinsei}の編集を行うビルダークラスです。
 */
public class KyokaisoSochiShinseiBuilder {

    private final DbT1013KyokaisoSochiShinseiEntity entity;
    private final KyokaisoSochiShinseiIdentifier id;

    /**
     * {@link DbT1013KyokaisoSochiShinseiEntity}より{@link KyokaisoSochiShinsei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT1013KyokaisoSochiShinseiEntity}
     * @param id {@link KyokaisoSochiShinseiIdentifier}
     *
     */
    KyokaisoSochiShinseiBuilder(
            DbT1013KyokaisoSochiShinseiEntity entity,
            KyokaisoSochiShinseiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     * @return {@link KyokaisoSochiShinseiBuilder}
     */
    public KyokaisoSochiShinseiBuilder set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
        return this;
    }

    /**
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     * @return {@link KyokaisoSochiShinseiBuilder}
     */
    public KyokaisoSochiShinseiBuilder set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
        return this;
    }

    /**
     * 申請・廃止区分を設定します。
     *
     * @param 申請_廃止区分 申請・廃止区分
     * @return {@link KyokaisoSochiShinseiBuilder}
     */
    public KyokaisoSochiShinseiBuilder set申請_廃止区分(RString 申請_廃止区分) {
        requireNonNull(申請_廃止区分, UrSystemErrorMessages.値がnull.getReplacedMessage("申請・廃止区分"));
        entity.setShinsei_HaishiKubun(申請_廃止区分);
        return this;
    }

    /**
     * 申請・廃止年月日を設定します。
     *
     * @param 申請_廃止年月日 申請・廃止年月日
     * @return {@link KyokaisoSochiShinseiBuilder}
     */
    public KyokaisoSochiShinseiBuilder set申請_廃止年月日(FlexibleDate 申請_廃止年月日) {
        requireNonNull(申請_廃止年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請・廃止年月日"));
        entity.setShinsei_HaishiYMD(申請_廃止年月日);
        return this;
    }

    /**
     * 保護不要根拠減額金額を設定します。
     *
     * @param 保護不要根拠減額金額 保護不要根拠減額金額
     * @return {@link KyokaisoSochiShinseiBuilder}
     */
    public KyokaisoSochiShinseiBuilder set保護不要根拠減額金額(Decimal 保護不要根拠減額金額) {
        requireNonNull(保護不要根拠減額金額, UrSystemErrorMessages.値がnull.getReplacedMessage("保護不要根拠減額金額"));
        entity.setHogoHuyoKonkyoGengakuKingaku(保護不要根拠減額金額);
        return this;
    }

    /**
     * 境界層証明書交付年月日を設定します。
     *
     * @param 境界層証明書交付年月日 境界層証明書交付年月日
     * @return {@link KyokaisoSochiShinseiBuilder}
     */
    public KyokaisoSochiShinseiBuilder set境界層証明書交付年月日(FlexibleDate 境界層証明書交付年月日) {
        requireNonNull(境界層証明書交付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層証明書交付年月日"));
        entity.setKyokaisoShomeishoKofuYMD(境界層証明書交付年月日);
        return this;
    }

    /**
     * 給付額減額取消・減額自己負担月額を設定します。
     *
     * @param 給付額減額取消_減額自己負担月額 給付額減額取消・減額自己負担月額
     * @return {@link KyokaisoSochiShinseiBuilder}
     */
    public KyokaisoSochiShinseiBuilder set給付額減額取消_減額自己負担月額(Decimal 給付額減額取消_減額自己負担月額) {
        requireNonNull(給付額減額取消_減額自己負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("給付額減額取消・減額自己負担月額"));
        entity.setKyufuGengakuTorikeshi_GengakuJikofutanGetsugaku(給付額減額取消_減額自己負担月額);
        return this;
    }

    /**
     * 居住費軽減・減額自己負担月額を設定します。
     *
     * @param 居住費軽減_減額自己負担月額 居住費軽減・減額自己負担月額
     * @return {@link KyokaisoSochiShinseiBuilder}
     */
    public KyokaisoSochiShinseiBuilder set居住費軽減_減額自己負担月額(Decimal 居住費軽減_減額自己負担月額) {
        requireNonNull(居住費軽減_減額自己負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費軽減・減額自己負担月額"));
        entity.setKyojuhiKeigen_GengakuJikofutanGetsugaku(居住費軽減_減額自己負担月額);
        return this;
    }

    /**
     * 居住費軽減・負担限度額段階コードを設定します。
     *
     * @param 居住費軽減_負担限度額段階コード 居住費軽減・負担限度額段階コード
     * @return {@link KyokaisoSochiShinseiBuilder}
     */
    public KyokaisoSochiShinseiBuilder set居住費軽減_負担限度額段階コード(RString 居住費軽減_負担限度額段階コード) {
        requireNonNull(居住費軽減_負担限度額段階コード, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費軽減・負担限度額段階コード"));
        entity.setKyojuhiKeigen_FutangendogakuDankaiCode(居住費軽減_負担限度額段階コード);
        return this;
    }

    /**
     * 食費軽減・減額自己負担月額を設定します。
     *
     * @param 食費軽減_減額自己負担月額 食費軽減・減額自己負担月額
     * @return {@link KyokaisoSochiShinseiBuilder}
     */
    public KyokaisoSochiShinseiBuilder set食費軽減_減額自己負担月額(Decimal 食費軽減_減額自己負担月額) {
        requireNonNull(食費軽減_減額自己負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("食費軽減・減額自己負担月額"));
        entity.setShokuhiKeigen_GengakuJikofutanGetsugaku(食費軽減_減額自己負担月額);
        return this;
    }

    /**
     * 食費軽減・負担限度額段階コードを設定します。
     *
     * @param 食費軽減_負担限度額段階コード 食費軽減・負担限度額段階コード
     * @return {@link KyokaisoSochiShinseiBuilder}
     */
    public KyokaisoSochiShinseiBuilder set食費軽減_負担限度額段階コード(RString 食費軽減_負担限度額段階コード) {
        requireNonNull(食費軽減_負担限度額段階コード, UrSystemErrorMessages.値がnull.getReplacedMessage("食費軽減・負担限度額段階コード"));
        entity.setShokuhiKeigen_FutangendogakuDankaiCode(食費軽減_負担限度額段階コード);
        return this;
    }

    /**
     * 利用者負担世帯合算額・減額自己負担月額を設定します。
     *
     * @param 利用者負担世帯合算額_減額自己負担月額 利用者負担世帯合算額・減額自己負担月額
     * @return {@link KyokaisoSochiShinseiBuilder}
     */
    public KyokaisoSochiShinseiBuilder set利用者負担世帯合算額_減額自己負担月額(Decimal 利用者負担世帯合算額_減額自己負担月額) {
        requireNonNull(利用者負担世帯合算額_減額自己負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担世帯合算額・減額自己負担月額"));
        entity.setRiyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku(利用者負担世帯合算額_減額自己負担月額);
        return this;
    }

    /**
     * 保険料減額・減額自己負担月額を設定します。
     *
     * @param 保険料減額_減額自己負担月額 保険料減額・減額自己負担月額
     * @return {@link KyokaisoSochiShinseiBuilder}
     */
    public KyokaisoSochiShinseiBuilder set保険料減額_減額自己負担月額(Decimal 保険料減額_減額自己負担月額) {
        requireNonNull(保険料減額_減額自己負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料減額・減額自己負担月額"));
        entity.setHokenryoGengaku_GengakuJikofutanGetsugaku(保険料減額_減額自己負担月額);
        return this;
    }

    /**
     * 減額自己負担月額合計額を設定します。
     *
     * @param 減額自己負担月額合計額 減額自己負担月額合計額
     * @return {@link KyokaisoSochiShinseiBuilder}
     */
    public KyokaisoSochiShinseiBuilder set減額自己負担月額合計額(Decimal 減額自己負担月額合計額) {
        requireNonNull(減額自己負担月額合計額, UrSystemErrorMessages.値がnull.getReplacedMessage("減額自己負担月額合計額"));
        entity.setGengakuJikofutanGetsugakuGokeigaku(減額自己負担月額合計額);
        return this;
    }

    /**
     * 境界層措置決定年月日を設定します。
     *
     * @param 境界層措置決定年月日 境界層措置決定年月日
     * @return {@link KyokaisoSochiShinseiBuilder}
     */
    public KyokaisoSochiShinseiBuilder set境界層措置決定年月日(FlexibleDate 境界層措置決定年月日) {
        requireNonNull(境界層措置決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層措置決定年月日"));
        entity.setKyukaisoSochiKetteiYMD(境界層措置決定年月日);
        return this;
    }

    /**
     * 措置該当_非該当区分を設定します。
     *
     * @param 措置該当_非該当区分 措置該当・非該当区分
     * @return {@link KyokaisoSochiShinseiBuilder}
     */
    public KyokaisoSochiShinseiBuilder set措置該当_非該当区分(RString 措置該当_非該当区分) {
        requireNonNull(措置該当_非該当区分, UrSystemErrorMessages.値がnull.getReplacedMessage("措置該当・非該当区分"));
        entity.setSochiGaito_HigaitoKubun(措置該当_非該当区分);
        return this;
    }

    /**
     * {@link KyokaisoSochiShinsei}のインスタンスを生成します。
     *
     * @return {@link KyokaisoSochiShinsei}のインスタンス
     */
    public KyokaisoSochiShinsei build() {
        return new KyokaisoSochiShinsei(entity, id);
    }
}
