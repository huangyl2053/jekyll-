/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 境界層該当者のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyokaisoGaitoshaModel implements Serializable {

    private DbT1006KyokaisoGaitoshaEntity entity;

    /**
     * コンストラクタです。
     */
    public KyokaisoGaitoshaModel() {
        entity = new DbT1006KyokaisoGaitoshaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT1006KyokaisoGaitoshaEntity
     */
    public KyokaisoGaitoshaModel(DbT1006KyokaisoGaitoshaEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT1006KyokaisoGaitoshaEntityを返します。
     *
     * @return DbT1006KyokaisoGaitoshaEntity
     */
    public DbT1006KyokaisoGaitoshaEntity getEntity() {
        return entity;
    }

    /**
     * DbT1006KyokaisoGaitoshaEntityを設定します。
     *
     * @param entity DbT1006KyokaisoGaitoshaEntity
     */
    public void setEntity(DbT1006KyokaisoGaitoshaEntity entity) {
        this.entity = entity;
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 境界層措置決定年月日を返します。
     *
     * @return 境界層措置決定年月日
     */
    public FlexibleDate get境界層措置決定年月日() {
        return entity.getKyokaisoSochiKetteiYMD();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 適用開始年月日を返します。
     *
     * @return 適用開始年月日
     */
    public FlexibleDate get適用開始年月日() {
        return entity.getTekiyoKaishiYMD();
    }

    /**
     * 適用終了年月日を返します。
     *
     * @return 適用終了年月日
     */
    public FlexibleDate get適用終了年月日() {
        return entity.getTekiyoShuryoYMD();
    }

    /**
     * 給付額減額記載解除フラグを返します。
     *
     * @return 給付額減額記載解除フラグ
     */
    public RString get給付額減額記載解除フラグ() {
        return entity.getKyuufugakuGengakuKisaiKiajoFlag();
    }

    /**
     * 標準負担額額該当フラグを返します。
     *
     * @return 標準負担額額該当フラグ
     */
    public RString get標準負担額額該当フラグ() {
        return entity.getHyojunFutanGengakuGaitoFlag();
    }

    /**
     * 標準負担軽減後負担額を返します。
     *
     * @return 標準負担軽減後負担額
     */
    public Decimal get標準負担軽減後負担額() {
        return entity.getHyojunFutanKeigengoFutangaku();
    }

    /**
     * 居住費等負担額減額該当フラグを返します。
     *
     * @return 居住費等負担額減額該当フラグ
     */
    public RString get居住費等負担額減額該当フラグ() {
        return entity.getKyojuhinadoFutangakugengakuGaitoFlag();
    }

    /**
     * 居住費軽減後居室種類コードを返します。
     *
     * @return 居住費軽減後居室種類コード
     */
    public RString get居住費軽減後居室種類コード() {
        return entity.getKyojuhiKeigengoKyoshitsuShuruiCode();
    }

    /**
     * 居住費軽減後負担額を返します。
     *
     * @return 居住費軽減後負担額
     */
    public Decimal get居住費軽減後負担額() {
        return entity.getKyojuhiKeigengoHutangaku();
    }

    /**
     * 食費負担額減額該当フラグを返します。
     *
     * @return 食費負担額減額該当フラグ
     */
    public RString get食費負担額減額該当フラグ() {
        return entity.getShokuhiKeigengoHutangakuGaitoFlag();
    }

    /**
     * 食費軽減後負担額を返します。
     *
     * @return 食費軽減後負担額
     */
    public Decimal get食費軽減後負担額() {
        return entity.getShokuhiKeigengoHutangaku();
    }

    /**
     * 高額ｻｰﾋﾞｽ費上限額減額該当フラグを返します。
     *
     * @return 高額ｻｰﾋﾞｽ費上限額減額該当フラグ
     */
    public RString get高額ｻｰﾋﾞｽ費上限額減額該当フラグ() {
        return entity.getKogakuServicehiJogengakuGengakuGaitoFlag();
    }

    /**
     * 高額ｻｰﾋﾞｽ費減額後上限額を返します。
     *
     * @return 高額ｻｰﾋﾞｽ費減額後上限額
     */
    public Decimal get高額ｻｰﾋﾞｽ費減額後上限額() {
        return entity.getKogakuServicehiJogengakuGengakugoJogengaku();
    }

    /**
     * 保険料納付減額フラグを返します。
     *
     * @return 保険料納付減額フラグ
     */
    public RString get保険料納付減額フラグ() {
        return entity.getHokenryoNofuGengakuFlag();
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 境界層措置決定年月日を設定します。
     *
     * @param 境界層措置決定年月日 境界層措置決定年月日
     */
    public void set境界層措置決定年月日(FlexibleDate 境界層措置決定年月日) {
        requireNonNull(境界層措置決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層措置決定年月日"));
        entity.setKyokaisoSochiKetteiYMD(境界層措置決定年月日);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     */
    public void set適用開始年月日(FlexibleDate 適用開始年月日) {
        requireNonNull(適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月日"));
        entity.setTekiyoKaishiYMD(適用開始年月日);
    }

    /**
     * 適用終了年月日を設定します。
     *
     * @param 適用終了年月日 適用終了年月日
     */
    public void set適用終了年月日(FlexibleDate 適用終了年月日) {
        requireNonNull(適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月日"));
        entity.setTekiyoShuryoYMD(適用終了年月日);
    }

    /**
     * 給付額減額記載解除フラグを設定します。
     *
     * @param 給付額減額記載解除フラグ 給付額減額記載解除フラグ
     */
    public void set給付額減額記載解除フラグ(RString 給付額減額記載解除フラグ) {
        requireNonNull(給付額減額記載解除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("給付額減額記載解除フラグ"));
        entity.setKyuufugakuGengakuKisaiKiajoFlag(給付額減額記載解除フラグ);
    }

    /**
     * 標準負担額額該当フラグを設定します。
     *
     * @param 標準負担額額該当フラグ 標準負担額額該当フラグ
     */
    public void set標準負担額額該当フラグ(RString 標準負担額額該当フラグ) {
        requireNonNull(標準負担額額該当フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("標準負担額額該当フラグ"));
        entity.setHyojunFutanGengakuGaitoFlag(標準負担額額該当フラグ);
    }

    /**
     * 標準負担軽減後負担額を設定します。
     *
     * @param 標準負担軽減後負担額 標準負担軽減後負担額
     */
    public void set標準負担軽減後負担額(Decimal 標準負担軽減後負担額) {
        requireNonNull(標準負担軽減後負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("標準負担軽減後負担額"));
        entity.setHyojunFutanKeigengoFutangaku(標準負担軽減後負担額);
    }

    /**
     * 居住費等負担額減額該当フラグを設定します。
     *
     * @param 居住費等負担額減額該当フラグ 居住費等負担額減額該当フラグ
     */
    public void set居住費等負担額減額該当フラグ(RString 居住費等負担額減額該当フラグ) {
        requireNonNull(居住費等負担額減額該当フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費等負担額減額該当フラグ"));
        entity.setKyojuhinadoFutangakugengakuGaitoFlag(居住費等負担額減額該当フラグ);
    }

    /**
     * 居住費軽減後居室種類コードを設定します。
     *
     * @param 居住費軽減後居室種類コード 居住費軽減後居室種類コード
     */
    public void set居住費軽減後居室種類コード(RString 居住費軽減後居室種類コード) {
        requireNonNull(居住費軽減後居室種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費軽減後居室種類コード"));
        entity.setKyojuhiKeigengoKyoshitsuShuruiCode(居住費軽減後居室種類コード);
    }

    /**
     * 居住費軽減後負担額を設定します。
     *
     * @param 居住費軽減後負担額 居住費軽減後負担額
     */
    public void set居住費軽減後負担額(Decimal 居住費軽減後負担額) {
        requireNonNull(居住費軽減後負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費軽減後負担額"));
        entity.setKyojuhiKeigengoHutangaku(居住費軽減後負担額);
    }

    /**
     * 食費負担額減額該当フラグを設定します。
     *
     * @param 食費負担額減額該当フラグ 食費負担額減額該当フラグ
     */
    public void set食費負担額減額該当フラグ(RString 食費負担額減額該当フラグ) {
        requireNonNull(食費負担額減額該当フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("食費負担額減額該当フラグ"));
        entity.setShokuhiKeigengoHutangakuGaitoFlag(食費負担額減額該当フラグ);
    }

    /**
     * 食費軽減後負担額を設定します。
     *
     * @param 食費軽減後負担額 食費軽減後負担額
     */
    public void set食費軽減後負担額(Decimal 食費軽減後負担額) {
        requireNonNull(食費軽減後負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("食費軽減後負担額"));
        entity.setShokuhiKeigengoHutangaku(食費軽減後負担額);
    }

    /**
     * 高額ｻｰﾋﾞｽ費上限額減額該当フラグを設定します。
     *
     * @param 高額ｻｰﾋﾞｽ費上限額減額該当フラグ 高額ｻｰﾋﾞｽ費上限額減額該当フラグ
     */
    public void set高額ｻｰﾋﾞｽ費上限額減額該当フラグ(RString 高額ｻｰﾋﾞｽ費上限額減額該当フラグ) {
        requireNonNull(高額ｻｰﾋﾞｽ費上限額減額該当フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("高額ｻｰﾋﾞｽ費上限額減額該当フラグ"));
        entity.setKogakuServicehiJogengakuGengakuGaitoFlag(高額ｻｰﾋﾞｽ費上限額減額該当フラグ);
    }

    /**
     * 高額ｻｰﾋﾞｽ費減額後上限額を設定します。
     *
     * @param 高額ｻｰﾋﾞｽ費減額後上限額 高額ｻｰﾋﾞｽ費減額後上限額
     */
    public void set高額ｻｰﾋﾞｽ費減額後上限額(Decimal 高額ｻｰﾋﾞｽ費減額後上限額) {
        requireNonNull(高額ｻｰﾋﾞｽ費減額後上限額, UrSystemErrorMessages.値がnull.getReplacedMessage("高額ｻｰﾋﾞｽ費減額後上限額"));
        entity.setKogakuServicehiJogengakuGengakugoJogengaku(高額ｻｰﾋﾞｽ費減額後上限額);
    }

    /**
     * 保険料納付減額フラグを設定します。
     *
     * @param 保険料納付減額フラグ 保険料納付減額フラグ
     */
    public void set保険料納付減額フラグ(RString 保険料納付減額フラグ) {
        requireNonNull(保険料納付減額フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料納付減額フラグ"));
        entity.setHokenryoNofuGengakuFlag(保険料納付減額フラグ);
    }

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    public void setDeletedState(boolean deleteFlag) {
        if (deleteFlag) {
            entity.setState(EntityDataState.Deleted);
        } else {
            entity.unsetState();
        }
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return entity.getState();
    }
}
