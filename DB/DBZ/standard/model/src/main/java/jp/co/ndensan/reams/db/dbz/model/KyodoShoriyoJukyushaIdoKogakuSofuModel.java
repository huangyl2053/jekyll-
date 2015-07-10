/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 共同処理用受給者異動高額送付のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyodoShoriyoJukyushaIdoKogakuSofuModel implements Serializable {

    private DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity entity;

    /**
     * コンストラクタです。
     */
    public KyodoShoriyoJukyushaIdoKogakuSofuModel() {
        entity = new DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity
     */
    public KyodoShoriyoJukyushaIdoKogakuSofuModel(DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityを返します。
     *
     * @return DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity
     */
    public DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity getEntity() {
        return entity;
    }

    /**
     * DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityを設定します。
     *
     * @param entity DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity
     */
    public void setEntity(DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity entity) {
        this.entity = entity;
    }

    /**
     * 異動年月日を返します。
     *
     * @return 異動年月日
     */
    public FlexibleDate get異動年月日() {
        return entity.getIdoYMD();
    }

    /**
     * 異動区分コードを返します。
     *
     * @return 異動区分コード
     */
    public RString get異動区分コード() {
        return entity.getIdoKubunCode();
    }

    /**
     * 受給者異動事由を返します。
     *
     * @return 受給者異動事由
     */
    public RString get受給者異動事由() {
        return entity.getJukyushaIdoJiyu();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHiHokenshaNo();
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
     * 世帯集約番号を返します。
     *
     * @return 世帯集約番号
     */
    public HihokenshaNo get世帯集約番号() {
        return entity.getSetaiShuyakuNo();
    }

    /**
     * 世帯所得区分コードを返します。
     *
     * @return 世帯所得区分コード
     */
    public RString get世帯所得区分コード() {
        return entity.getSetaiShotokuKubunCode();
    }

    /**
     * 所得区分コードを返します。
     *
     * @return 所得区分コード
     */
    public RString get所得区分コード() {
        return entity.getShotokuKubunCode();
    }

    /**
     * 老齢福祉年金受給有フラグを返します。
     *
     * @return 老齢福祉年金受給有フラグ
     */
    public boolean get老齢福祉年金受給有フラグ() {
        return entity.getRoureiFukushiNenkinJukyuAriFlag();
    }

    /**
     * 利用者負担第２段階有フラグを返します。
     *
     * @return 利用者負担第２段階有フラグ
     */
    public boolean get利用者負担第２段階有フラグ() {
        return entity.getRiyoshaFutan2DankaiAriFlag();
    }

    /**
     * 支給申請書出力有フラグを返します。
     *
     * @return 支給申請書出力有フラグ
     */
    public boolean get支給申請書出力有フラグ() {
        return entity.getShikyuShinseishoOutputAriFlag();
    }

    /**
     * 訂正連絡票フラグを返します。
     *
     * @return 訂正連絡票フラグ
     */
    public boolean get訂正連絡票フラグ() {
        return entity.getTeiseiRenrakuhyoFlag();
    }

    /**
     * 送付年月を返します。
     *
     * @return 送付年月
     */
    public FlexibleYearMonth get送付年月() {
        return entity.getSofuYM();
    }

    /**
     * 異動年月日を設定します。
     *
     * @param 異動年月日 異動年月日
     */
    public void set異動年月日(FlexibleDate 異動年月日) {
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        entity.setIdoYMD(異動年月日);
    }

    /**
     * 異動区分コードを設定します。
     *
     * @param 異動区分コード 異動区分コード
     */
    public void set異動区分コード(RString 異動区分コード) {
        requireNonNull(異動区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("異動区分コード"));
        entity.setIdoKubunCode(異動区分コード);
    }

    /**
     * 受給者異動事由を設定します。
     *
     * @param 受給者異動事由 受給者異動事由
     */
    public void set受給者異動事由(RString 受給者異動事由) {
        requireNonNull(受給者異動事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者異動事由"));
        entity.setJukyushaIdoJiyu(受給者異動事由);
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(HokenshaNo 証記載保険者番号) {
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
        entity.setHiHokenshaNo(被保険者番号);
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
     * 世帯集約番号を設定します。
     *
     * @param 世帯集約番号 世帯集約番号
     */
    public void set世帯集約番号(HihokenshaNo 世帯集約番号) {
        requireNonNull(世帯集約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯集約番号"));
        entity.setSetaiShuyakuNo(世帯集約番号);
    }

    /**
     * 世帯所得区分コードを設定します。
     *
     * @param 世帯所得区分コード 世帯所得区分コード
     */
    public void set世帯所得区分コード(RString 世帯所得区分コード) {
        requireNonNull(世帯所得区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯所得区分コード"));
        entity.setSetaiShotokuKubunCode(世帯所得区分コード);
    }

    /**
     * 所得区分コードを設定します。
     *
     * @param 所得区分コード 所得区分コード
     */
    public void set所得区分コード(RString 所得区分コード) {
        requireNonNull(所得区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("所得区分コード"));
        entity.setShotokuKubunCode(所得区分コード);
    }

    /**
     * 老齢福祉年金受給有フラグを設定します。
     *
     * @param 老齢福祉年金受給有フラグ 老齢福祉年金受給有フラグ
     */
    public void set老齢福祉年金受給有フラグ(boolean 老齢福祉年金受給有フラグ) {
        requireNonNull(老齢福祉年金受給有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("老齢福祉年金受給有フラグ"));
        entity.setRoureiFukushiNenkinJukyuAriFlag(老齢福祉年金受給有フラグ);
    }

    /**
     * 利用者負担第２段階有フラグを設定します。
     *
     * @param 利用者負担第２段階有フラグ 利用者負担第２段階有フラグ
     */
    public void set利用者負担第２段階有フラグ(boolean 利用者負担第２段階有フラグ) {
        requireNonNull(利用者負担第２段階有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担第２段階有フラグ"));
        entity.setRiyoshaFutan2DankaiAriFlag(利用者負担第２段階有フラグ);
    }

    /**
     * 支給申請書出力有フラグを設定します。
     *
     * @param 支給申請書出力有フラグ 支給申請書出力有フラグ
     */
    public void set支給申請書出力有フラグ(boolean 支給申請書出力有フラグ) {
        requireNonNull(支給申請書出力有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書出力有フラグ"));
        entity.setShikyuShinseishoOutputAriFlag(支給申請書出力有フラグ);
    }

    /**
     * 訂正連絡票フラグを設定します。
     *
     * @param 訂正連絡票フラグ 訂正連絡票フラグ
     */
    public void set訂正連絡票フラグ(boolean 訂正連絡票フラグ) {
        requireNonNull(訂正連絡票フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("訂正連絡票フラグ"));
        entity.setTeiseiRenrakuhyoFlag(訂正連絡票フラグ);
    }

    /**
     * 送付年月を設定します。
     *
     * @param 送付年月 送付年月
     */
    public void set送付年月(FlexibleYearMonth 送付年月) {
        requireNonNull(送付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("送付年月"));
        entity.setSofuYM(送付年月);
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
