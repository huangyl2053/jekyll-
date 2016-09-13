package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 医療費控除テーブルのエンティティクラスです。
 *
 * @reamsid_L DBD-9999-013 wangchao
 */
public class DbT4401IryohiKojoEntity extends DbTableEntityBase<DbT4401IryohiKojoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT4401IryohiKojo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleYear kojoTaishoNen;
    @PrimaryKey
    private RString dataKubun;
    private FlexibleDate torokuYMD;
    private FlexibleDate shinseiYMD;
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    private FlexibleDate shujiiIkenshoJuryoYMD;
    private RString nichijoSeikatsuJiritsudo;
    private boolean nyoshikkinHassei;
    private FlexibleDate hakkoYMD;
    private boolean logicalDeletedFlag;

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
     * 控除対象年のgetメソッドです。
     *
     * @return 控除対象年
     */
    public FlexibleYear getKojoTaishoNen() {
        return kojoTaishoNen;
    }

    /**
     * 控除対象年のsetメソッドです。
     *
     * @param kojoTaishoNen 控除対象年
     */
    public void setKojoTaishoNen(@Nonnull FlexibleYear kojoTaishoNen) {
        this.kojoTaishoNen = kojoTaishoNen;
    }

    /**
     * データ区分のgetメソッドです。
     * <br/>
     * <br/>1：おむつ使用証明書発行、2：主治医意見書の確認書発行
     *
     * @return データ区分
     */
    public RString getDataKubun() {
        return dataKubun;
    }

    /**
     * データ区分のsetメソッドです。
     * <br/>
     * <br/>1：おむつ使用証明書発行、2：主治医意見書の確認書発行
     *
     * @param dataKubun データ区分
     */
    public void setDataKubun(@Nonnull RString dataKubun) {
        this.dataKubun = dataKubun;
    }

    /**
     * 登録年月日のgetメソッドです。
     *
     * @return 登録年月日
     */
    public FlexibleDate getTorokuYMD() {
        return torokuYMD;
    }

    /**
     * 登録年月日のsetメソッドです。
     *
     * @param torokuYMD 登録年月日
     */
    public void setTorokuYMD(@Nonnull FlexibleDate torokuYMD) {
        this.torokuYMD = torokuYMD;
    }

    /**
     * 申請年月日のgetメソッドです。
     *
     * @return 申請年月日
     */
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * 申請年月日のsetメソッドです。
     *
     * @param shinseiYMD 申請年月日
     */
    public void setShinseiYMD(@Nonnull FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * 認定有効期間開始年月日のgetメソッドです。
     *
     * @return 認定有効期間開始年月日
     */
    public FlexibleDate getNinteiYukoKikanKaishiYMD() {
        return ninteiYukoKikanKaishiYMD;
    }

    /**
     * 認定有効期間開始年月日のsetメソッドです。
     *
     * @param ninteiYukoKikanKaishiYMD 認定有効期間開始年月日
     */
    public void setNinteiYukoKikanKaishiYMD(@Nonnull FlexibleDate ninteiYukoKikanKaishiYMD) {
        this.ninteiYukoKikanKaishiYMD = ninteiYukoKikanKaishiYMD;
    }

    /**
     * 認定有効期間終了年月日のgetメソッドです。
     *
     * @return 認定有効期間終了年月日
     */
    public FlexibleDate getNinteiYukoKikanShuryoYMD() {
        return ninteiYukoKikanShuryoYMD;
    }

    /**
     * 認定有効期間終了年月日のsetメソッドです。
     *
     * @param ninteiYukoKikanShuryoYMD 認定有効期間終了年月日
     */
    public void setNinteiYukoKikanShuryoYMD(@Nonnull FlexibleDate ninteiYukoKikanShuryoYMD) {
        this.ninteiYukoKikanShuryoYMD = ninteiYukoKikanShuryoYMD;
    }

    /**
     * 主治医意見書受領年月日のgetメソッドです。
     *
     * @return 主治医意見書受領年月日
     */
    public FlexibleDate getShujiiIkenshoJuryoYMD() {
        return shujiiIkenshoJuryoYMD;
    }

    /**
     * 主治医意見書受領年月日のsetメソッドです。
     *
     * @param shujiiIkenshoJuryoYMD 主治医意見書受領年月日
     */
    public void setShujiiIkenshoJuryoYMD(@Nonnull FlexibleDate shujiiIkenshoJuryoYMD) {
        this.shujiiIkenshoJuryoYMD = shujiiIkenshoJuryoYMD;
    }

    /**
     * 日常生活自立度のgetメソッドです。
     * <br/>
     * <br/>1:「B1」、2:「B2」、3:「C1」、4:「C2」、5：以外を登録する
     *
     * @return 日常生活自立度
     */
    public RString getNichijoSeikatsuJiritsudo() {
        return nichijoSeikatsuJiritsudo;
    }

    /**
     * 日常生活自立度のsetメソッドです。
     * <br/>
     * <br/>1:「B1」、2:「B2」、3:「C1」、4:「C2」、5：以外を登録する
     *
     * @param nichijoSeikatsuJiritsudo 日常生活自立度
     */
    public void setNichijoSeikatsuJiritsudo(@Nonnull RString nichijoSeikatsuJiritsudo) {
        this.nichijoSeikatsuJiritsudo = nichijoSeikatsuJiritsudo;
    }

    /**
     * 尿失禁の発生のgetメソッドです。
     * <br/>
     * <br/>True:有、False:無
     *
     * @return 尿失禁の発生
     */
    public boolean getNyoshikkinHassei() {
        return nyoshikkinHassei;
    }

    /**
     * 尿失禁の発生のsetメソッドです。
     * <br/>
     * <br/>True:有、False:無
     *
     * @param nyoshikkinHassei 尿失禁の発生
     */
    public void setNyoshikkinHassei(@Nonnull boolean nyoshikkinHassei) {
        this.nyoshikkinHassei = nyoshikkinHassei;
    }

    /**
     * 発行年月日のgetメソッドです。
     *
     * @return 発行年月日
     */
    public FlexibleDate getHakkoYMD() {
        return hakkoYMD;
    }

    /**
     * 発行年月日のsetメソッドです。
     *
     * @param hakkoYMD 発行年月日
     */
    public void setHakkoYMD(@Nonnull FlexibleDate hakkoYMD) {
        this.hakkoYMD = hakkoYMD;
    }

    /**
     * 論理削除フラグのgetメソッドです。
     *
     * @return 論理削除フラグ
     */
    public boolean getLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    /**
     * 論理削除フラグのsetメソッドです。
     *
     * @param logicalDeletedFlag 論理削除フラグ
     */
    public void setLogicalDeletedFlag(@Nonnull boolean logicalDeletedFlag) {
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4401IryohiKojoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal DbT4401IryohiKojoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4401IryohiKojoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.kojoTaishoNen, other.kojoTaishoNen)) {
            return false;
        }
        if (!Objects.equals(this.dataKubun, other.dataKubun)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT4401IryohiKojoEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kojoTaishoNen = entity.kojoTaishoNen;
        this.dataKubun = entity.dataKubun;
        this.torokuYMD = entity.torokuYMD;
        this.shinseiYMD = entity.shinseiYMD;
        this.ninteiYukoKikanKaishiYMD = entity.ninteiYukoKikanKaishiYMD;
        this.ninteiYukoKikanShuryoYMD = entity.ninteiYukoKikanShuryoYMD;
        this.shujiiIkenshoJuryoYMD = entity.shujiiIkenshoJuryoYMD;
        this.nichijoSeikatsuJiritsudo = entity.nichijoSeikatsuJiritsudo;
        this.nyoshikkinHassei = entity.nyoshikkinHassei;
        this.hakkoYMD = entity.hakkoYMD;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, kojoTaishoNen, dataKubun, torokuYMD, shinseiYMD, ninteiYukoKikanKaishiYMD, ninteiYukoKikanShuryoYMD, shujiiIkenshoJuryoYMD, nichijoSeikatsuJiritsudo, nyoshikkinHassei, hakkoYMD, logicalDeletedFlag);
    }

// </editor-fold>
}
