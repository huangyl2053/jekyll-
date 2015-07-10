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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 共同処理用受給者異動基本送付のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyodoShoriyoJukyushaIdoKihonSofuModel implements Serializable {

    private DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity entity;

    /**
     * コンストラクタです。
     */
    public KyodoShoriyoJukyushaIdoKihonSofuModel() {
        entity = new DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity
     */
    public KyodoShoriyoJukyushaIdoKihonSofuModel(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityを返します。
     *
     * @return DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity
     */
    public DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity getEntity() {
        return entity;
    }

    /**
     * DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityを設定します。
     *
     * @param entity DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity
     */
    public void setEntity(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity entity) {
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
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return entity.getHiHokenshaName();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 住所カナを返します。
     *
     * @return 住所カナ
     */
    public RString get住所カナ() {
        return entity.getDdressKana();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public RString get住所() {
        return entity.getAddress();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    /**
     * 帳票出力順序コードを返します。
     *
     * @return 帳票出力順序コード
     */
    public RString get帳票出力順序コード() {
        return entity.getChohyoOutputJunjyoCode();
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
     * 被保険者氏名を設定します。
     *
     * @param 被保険者氏名 被保険者氏名
     */
    public void set被保険者氏名(RString 被保険者氏名) {
        requireNonNull(被保険者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者氏名"));
        entity.setHiHokenshaName(被保険者氏名);
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     */
    public void set郵便番号(YubinNo 郵便番号) {
        requireNonNull(郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便番号"));
        entity.setYubinNo(郵便番号);
    }

    /**
     * 住所カナを設定します。
     *
     * @param 住所カナ 住所カナ
     */
    public void set住所カナ(RString 住所カナ) {
        requireNonNull(住所カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("住所カナ"));
        entity.setDdressKana(住所カナ);
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 住所
     */
    public void set住所(RString 住所) {
        requireNonNull(住所, UrSystemErrorMessages.値がnull.getReplacedMessage("住所"));
        entity.setAddress(住所);
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     */
    public void set電話番号(TelNo 電話番号) {
        requireNonNull(電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("電話番号"));
        entity.setTelNo(電話番号);
    }

    /**
     * 帳票出力順序コードを設定します。
     *
     * @param 帳票出力順序コード 帳票出力順序コード
     */
    public void set帳票出力順序コード(RString 帳票出力順序コード) {
        requireNonNull(帳票出力順序コード, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票出力順序コード"));
        entity.setChohyoOutputJunjyoCode(帳票出力順序コード);
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
