package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * 特定標準負担額減額テーブルのエンティティクラスです。
 */
public class DbT4013TokuteiHyojunFutangakuGengakuEntity extends DbTableEntityBase<DbT4013TokuteiHyojunFutangakuGengakuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT4013TokuteiHyojunFutangakuGengaku");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private int rirekiNo;
    private RString shinseiJiyu;
    private RString riyoshaFutanDankai;
    private RString hyojunFutanKubun;
    private RString kyoshitsuShubetsu;
    private Decimal shokuhiFutanGendogaku;
    private Decimal unitTypeKoshitsu;
    private Decimal unitTypeJunKoshitsu;
    private Decimal juraiTypeKoshitsu_Tokuyo;
    private Decimal juraiTypeKoshitsu_Roken_Ryoyo;
    private Decimal tashoshitsu;

    /**
     * insertDantaiCdのgetメソッドです。
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * insertDantaiCdのsetメソッドです。
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * isDeletedのgetメソッドです。
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedのsetメソッドです。
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(@Nonnull ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(@Nonnull HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 申請事由のgetメソッドです。
     *
     * @return 申請事由
     */
    @CheckForNull
    public RString getShinseiJiyu() {
        return shinseiJiyu;
    }

    /**
     * 申請事由のsetメソッドです。
     *
     * @param shinseiJiyu 申請事由
     */
    public void setShinseiJiyu(RString shinseiJiyu) {
        this.shinseiJiyu = shinseiJiyu;
    }

    /**
     * 利用者負担段階のgetメソッドです。
     * <br/>
     * <br/>・第一段階
     *
     * <br/>・第二段階
     *
     * <br/>・第三段階
     *
     * <br/>・課税層第三段階
     *
     * @return 利用者負担段階
     */
    @CheckForNull
    public RString getRiyoshaFutanDankai() {
        return riyoshaFutanDankai;
    }

    /**
     * 利用者負担段階のsetメソッドです。
     * <br/>
     * <br/>・第一段階
     *
     * <br/>・第二段階
     *
     * <br/>・第三段階
     *
     * <br/>・課税層第三段階
     *
     * @param riyoshaFutanDankai 利用者負担段階
     */
    public void setRiyoshaFutanDankai(RString riyoshaFutanDankai) {
        this.riyoshaFutanDankai = riyoshaFutanDankai;
    }

    /**
     * 標準負担区分のgetメソッドです。
     * <br/>
     * <br/>1:標準負担
     *
     * <br/>2:特定標準負担
     *
     * @return 標準負担区分
     */
    @CheckForNull
    public RString getHyojunFutanKubun() {
        return hyojunFutanKubun;
    }

    /**
     * 標準負担区分のsetメソッドです。
     * <br/>
     * <br/>1:標準負担
     *
     * <br/>2:特定標準負担
     *
     * @param hyojunFutanKubun 標準負担区分
     */
    public void setHyojunFutanKubun(RString hyojunFutanKubun) {
        this.hyojunFutanKubun = hyojunFutanKubun;
    }

    /**
     * 居室種別のgetメソッドです。
     * <br/>
     * <br/>1：ユニット型個室
     *
     * <br/>2：ユニット型準個室
     *
     * <br/>3：従来型個室
     *
     * <br/>4：多床室
     *
     * <br/>5：従来型個室（老健）
     *
     * @return 居室種別
     */
    @CheckForNull
    public RString getKyoshitsuShubetsu() {
        return kyoshitsuShubetsu;
    }

    /**
     * 居室種別のsetメソッドです。
     * <br/>
     * <br/>1：ユニット型個室
     *
     * <br/>2：ユニット型準個室
     *
     * <br/>3：従来型個室
     *
     * <br/>4：多床室
     *
     * <br/>5：従来型個室（老健）
     *
     * @param kyoshitsuShubetsu 居室種別
     */
    public void setKyoshitsuShubetsu(RString kyoshitsuShubetsu) {
        this.kyoshitsuShubetsu = kyoshitsuShubetsu;
    }

    /**
     * 食費負担限度額のgetメソッドです。
     *
     * @return 食費負担限度額
     */
    @CheckForNull
    public Decimal getShokuhiFutanGendogaku() {
        return shokuhiFutanGendogaku;
    }

    /**
     * 食費負担限度額のsetメソッドです。
     *
     * @param shokuhiFutanGendogaku 食費負担限度額
     */
    public void setShokuhiFutanGendogaku(Decimal shokuhiFutanGendogaku) {
        this.shokuhiFutanGendogaku = shokuhiFutanGendogaku;
    }

    /**
     * ユニット型個室のgetメソッドです。
     *
     * @return ユニット型個室
     */
    @CheckForNull
    public Decimal getUnitTypeKoshitsu() {
        return unitTypeKoshitsu;
    }

    /**
     * ユニット型個室のsetメソッドです。
     *
     * @param unitTypeKoshitsu ユニット型個室
     */
    public void setUnitTypeKoshitsu(Decimal unitTypeKoshitsu) {
        this.unitTypeKoshitsu = unitTypeKoshitsu;
    }

    /**
     * ユニット型準個室のgetメソッドです。
     *
     * @return ユニット型準個室
     */
    @CheckForNull
    public Decimal getUnitTypeJunKoshitsu() {
        return unitTypeJunKoshitsu;
    }

    /**
     * ユニット型準個室のsetメソッドです。
     *
     * @param unitTypeJunKoshitsu ユニット型準個室
     */
    public void setUnitTypeJunKoshitsu(Decimal unitTypeJunKoshitsu) {
        this.unitTypeJunKoshitsu = unitTypeJunKoshitsu;
    }

    /**
     * 従来型個室（特養等）のgetメソッドです。
     *
     * @return 従来型個室（特養等）
     */
    @CheckForNull
    public Decimal getJuraiTypeKoshitsu_Tokuyo() {
        return juraiTypeKoshitsu_Tokuyo;
    }

    /**
     * 従来型個室（特養等）のsetメソッドです。
     *
     * @param juraiTypeKoshitsu_Tokuyo 従来型個室（特養等）
     */
    public void setJuraiTypeKoshitsu_Tokuyo(Decimal juraiTypeKoshitsu_Tokuyo) {
        this.juraiTypeKoshitsu_Tokuyo = juraiTypeKoshitsu_Tokuyo;
    }

    /**
     * 従来型個室（老健・療養等）のgetメソッドです。
     *
     * @return 従来型個室（老健・療養等）
     */
    @CheckForNull
    public Decimal getJuraiTypeKoshitsu_Roken_Ryoyo() {
        return juraiTypeKoshitsu_Roken_Ryoyo;
    }

    /**
     * 従来型個室（老健・療養等）のsetメソッドです。
     *
     * @param juraiTypeKoshitsu_Roken_Ryoyo 従来型個室（老健・療養等）
     */
    public void setJuraiTypeKoshitsu_Roken_Ryoyo(Decimal juraiTypeKoshitsu_Roken_Ryoyo) {
        this.juraiTypeKoshitsu_Roken_Ryoyo = juraiTypeKoshitsu_Roken_Ryoyo;
    }

    /**
     * 多床室のgetメソッドです。
     *
     * @return 多床室
     */
    @CheckForNull
    public Decimal getTashoshitsu() {
        return tashoshitsu;
    }

    /**
     * 多床室のsetメソッドです。
     *
     * @param tashoshitsu 多床室
     */
    public void setTashoshitsu(Decimal tashoshitsu) {
        this.tashoshitsu = tashoshitsu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4013TokuteiHyojunFutangakuGengakuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4013TokuteiHyojunFutangakuGengakuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4013TokuteiHyojunFutangakuGengakuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT4013TokuteiHyojunFutangakuGengakuEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.shinseiJiyu = entity.shinseiJiyu;
        this.riyoshaFutanDankai = entity.riyoshaFutanDankai;
        this.hyojunFutanKubun = entity.hyojunFutanKubun;
        this.kyoshitsuShubetsu = entity.kyoshitsuShubetsu;
        this.shokuhiFutanGendogaku = entity.shokuhiFutanGendogaku;
        this.unitTypeKoshitsu = entity.unitTypeKoshitsu;
        this.unitTypeJunKoshitsu = entity.unitTypeJunKoshitsu;
        this.juraiTypeKoshitsu_Tokuyo = entity.juraiTypeKoshitsu_Tokuyo;
        this.juraiTypeKoshitsu_Roken_Ryoyo = entity.juraiTypeKoshitsu_Roken_Ryoyo;
        this.tashoshitsu = entity.tashoshitsu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, hihokenshaNo, rirekiNo, shinseiJiyu, riyoshaFutanDankai, hyojunFutanKubun, kyoshitsuShubetsu, shokuhiFutanGendogaku, unitTypeKoshitsu, unitTypeJunKoshitsu, juraiTypeKoshitsu_Tokuyo, juraiTypeKoshitsu_Roken_Ryoyo, tashoshitsu);
    }

// </editor-fold>
}
