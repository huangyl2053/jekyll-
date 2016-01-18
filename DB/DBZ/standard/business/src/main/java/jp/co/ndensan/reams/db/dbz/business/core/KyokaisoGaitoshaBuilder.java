/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyokaisoGaitosha}の編集を行うビルダークラスです。
 */
public class KyokaisoGaitoshaBuilder {

    private final DbT1006KyokaisoGaitoshaEntity entity;
    private final KyokaisoGaitoshaIdentifier id;

    /**
     * {@link DbT1006KyokaisoGaitoshaEntity}より{@link KyokaisoGaitosha}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT1006KyokaisoGaitoshaEntity}
     * @param id {@link KyokaisoGaitoshaIdentifier}
     *
     */
    KyokaisoGaitoshaBuilder(
            DbT1006KyokaisoGaitoshaEntity entity,
            KyokaisoGaitoshaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     * @return {@link KyokaisoGaitoshaBuilder}
     */
    public KyokaisoGaitoshaBuilder set適用開始年月日(FlexibleDate 適用開始年月日) {
        requireNonNull(適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月日"));
        entity.setTekiyoKaishiYMD(適用開始年月日);
        return this;
    }

    /**
     * 適用終了年月日を設定します。
     *
     * @param 適用終了年月日 適用終了年月日
     * @return {@link KyokaisoGaitoshaBuilder}
     */
    public KyokaisoGaitoshaBuilder set適用終了年月日(FlexibleDate 適用終了年月日) {
        requireNonNull(適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月日"));
        entity.setTekiyoShuryoYMD(適用終了年月日);
        return this;
    }

    /**
     * 境界層措置決定年月日を設定します。
     *
     * @param 境界層措置決定年月日 境界層措置決定年月日
     * @return {@link KyokaisoGaitoshaBuilder}
     */
    public KyokaisoGaitoshaBuilder set境界層措置決定年月日(FlexibleDate 境界層措置決定年月日) {
        requireNonNull(境界層措置決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層措置決定年月日"));
        entity.setKyokaisoSochiKetteiYMD(境界層措置決定年月日);
        return this;
    }

    /**
     * 給付額減額記載解除フラグを設定します。
     *
     * @param 給付額減額記載解除フラグ 給付額減額記載解除フラグ
     * @return {@link KyokaisoGaitoshaBuilder}
     */
    public KyokaisoGaitoshaBuilder set給付額減額記載解除フラグ(RString 給付額減額記載解除フラグ) {
        requireNonNull(給付額減額記載解除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("給付額減額記載解除フラグ"));
        entity.setKyuufugakuGengakuKisaiKiajoFlag(給付額減額記載解除フラグ);
        return this;
    }

    /**
     * 標準負担額額該当フラグを設定します。
     *
     * @param 標準負担額額該当フラグ 標準負担額額該当フラグ
     * @return {@link KyokaisoGaitoshaBuilder}
     */
    public KyokaisoGaitoshaBuilder set標準負担額額該当フラグ(RString 標準負担額額該当フラグ) {
        requireNonNull(標準負担額額該当フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("標準負担額額該当フラグ"));
        entity.setHyojunFutanGengakuGaitoFlag(標準負担額額該当フラグ);
        return this;
    }

    /**
     * 標準負担軽減後負担額を設定します。
     *
     * @param 標準負担軽減後負担額 標準負担軽減後負担額
     * @return {@link KyokaisoGaitoshaBuilder}
     */
    public KyokaisoGaitoshaBuilder set標準負担軽減後負担額(Decimal 標準負担軽減後負担額) {
        requireNonNull(標準負担軽減後負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("標準負担軽減後負担額"));
        entity.setHyojunFutanKeigengoFutangaku(標準負担軽減後負担額);
        return this;
    }

    /**
     * 居住費等負担額減額該当フラグを設定します。
     *
     * @param 居住費等負担額減額該当フラグ 居住費等負担額減額該当フラグ
     * @return {@link KyokaisoGaitoshaBuilder}
     */
    public KyokaisoGaitoshaBuilder set居住費等負担額減額該当フラグ(RString 居住費等負担額減額該当フラグ) {
        requireNonNull(居住費等負担額減額該当フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費等負担額減額該当フラグ"));
        entity.setKyojuhinadoFutangakugengakuGaitoFlag(居住費等負担額減額該当フラグ);
        return this;
    }

    /**
     * 居住費軽減後居室種類コードを設定します。
     *
     * @param 居住費軽減後居室種類コード 居住費軽減後居室種類コード
     * @return {@link KyokaisoGaitoshaBuilder}
     */
    public KyokaisoGaitoshaBuilder set居住費軽減後居室種類コード(RString 居住費軽減後居室種類コード) {
        requireNonNull(居住費軽減後居室種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費軽減後居室種類コード"));
        entity.setKyojuhiKeigengoKyoshitsuShuruiCode(居住費軽減後居室種類コード);
        return this;
    }

    /**
     * 居住費軽減後負担額を設定します。
     *
     * @param 居住費軽減後負担額 居住費軽減後負担額
     * @return {@link KyokaisoGaitoshaBuilder}
     */
    public KyokaisoGaitoshaBuilder set居住費軽減後負担額(Decimal 居住費軽減後負担額) {
        requireNonNull(居住費軽減後負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費軽減後負担額"));
        entity.setKyojuhiKeigengoHutangaku(居住費軽減後負担額);
        return this;
    }

    /**
     * 食費負担額減額該当フラグを設定します。
     *
     * @param 食費負担額減額該当フラグ 食費負担額減額該当フラグ
     * @return {@link KyokaisoGaitoshaBuilder}
     */
    public KyokaisoGaitoshaBuilder set食費負担額減額該当フラグ(RString 食費負担額減額該当フラグ) {
        requireNonNull(食費負担額減額該当フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("食費負担額減額該当フラグ"));
        entity.setShokuhiKeigengoHutangakuGaitoFlag(食費負担額減額該当フラグ);
        return this;
    }

    /**
     * 食費軽減後負担額を設定します。
     *
     * @param 食費軽減後負担額 食費軽減後負担額
     * @return {@link KyokaisoGaitoshaBuilder}
     */
    public KyokaisoGaitoshaBuilder set食費軽減後負担額(Decimal 食費軽減後負担額) {
        requireNonNull(食費軽減後負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("食費軽減後負担額"));
        entity.setShokuhiKeigengoHutangaku(食費軽減後負担額);
        return this;
    }

    /**
     * 高額ｻｰﾋﾞｽ費上限額減額該当フラグを設定します。
     *
     * @param 高額ｻｰﾋﾞｽ費上限額減額該当フラグ 高額ｻｰﾋﾞｽ費上限額減額該当フラグ
     * @return {@link KyokaisoGaitoshaBuilder}
     */
    public KyokaisoGaitoshaBuilder set高額ｻｰﾋﾞｽ費上限額減額該当フラグ(RString 高額ｻｰﾋﾞｽ費上限額減額該当フラグ) {
        requireNonNull(高額ｻｰﾋﾞｽ費上限額減額該当フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("高額ｻｰﾋﾞｽ費上限額減額該当フラグ"));
        entity.setKogakuServicehiJogengakuGengakuGaitoFlag(高額ｻｰﾋﾞｽ費上限額減額該当フラグ);
        return this;
    }

    /**
     * 高額ｻｰﾋﾞｽ費減額後上限額を設定します。
     *
     * @param 高額ｻｰﾋﾞｽ費減額後上限額 高額ｻｰﾋﾞｽ費減額後上限額
     * @return {@link KyokaisoGaitoshaBuilder}
     */
    public KyokaisoGaitoshaBuilder set高額ｻｰﾋﾞｽ費減額後上限額(Decimal 高額ｻｰﾋﾞｽ費減額後上限額) {
        requireNonNull(高額ｻｰﾋﾞｽ費減額後上限額, UrSystemErrorMessages.値がnull.getReplacedMessage("高額ｻｰﾋﾞｽ費減額後上限額"));
        entity.setKogakuServicehiJogengakuGengakugoJogengaku(高額ｻｰﾋﾞｽ費減額後上限額);
        return this;
    }

    /**
     * 保険料納付減額フラグを設定します。
     *
     * @param 保険料納付減額フラグ 保険料納付減額フラグ
     * @return {@link KyokaisoGaitoshaBuilder}
     */
    public KyokaisoGaitoshaBuilder set保険料納付減額フラグ(RString 保険料納付減額フラグ) {
        requireNonNull(保険料納付減額フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料納付減額フラグ"));
        entity.setHokenryoNofuGengakuFlag(保険料納付減額フラグ);
        return this;
    }

    /**
     * {@link KyokaisoGaitosha}のインスタンスを生成します。
     *
     * @return {@link KyokaisoGaitosha}のインスタンス
     */
    public KyokaisoGaitosha build() {
        return new KyokaisoGaitosha(entity, id);
    }
}
