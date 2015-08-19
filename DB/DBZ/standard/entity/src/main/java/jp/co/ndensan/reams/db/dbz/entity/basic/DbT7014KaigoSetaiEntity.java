package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT7014KaigoSetaiの項目定義クラスです
 *
 */
public class DbT7014KaigoSetaiEntity extends DbTableEntityBase<DbT7014KaigoSetaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7014KaigoSetai");

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
    private RString kanriShikibetsuKubun;
    @PrimaryKey
    private FlexibleDate setaiHaakuKijunYMD;
    @PrimaryKey
    private int setaiInkanriRenban;
    private ShikibetsuCode setaiInshikibetsuCode;
    private RString honninKubun;
    private FlexibleYear kazeiNendo;
    private RString kazeiHikazeiKubun;
    private Decimal gokeiShotokuKingaku;
    private Decimal kazeiNenkinShunyugaku;

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
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 管理識別区分のgetメソッドです。
     * <br/>
     * <br/>1：賦課、2：高額介護、3：負担限度額、4：社福軽減
     *
     * @return 管理識別区分
     */
    public RString getKanriShikibetsuKubun() {
        return kanriShikibetsuKubun;
    }

    /**
     * 管理識別区分のsetメソッドです。
     * <br/>
     * <br/>1：賦課、2：高額介護、3：負担限度額、4：社福軽減
     *
     * @param kanriShikibetsuKubun 管理識別区分
     */
    public void setKanriShikibetsuKubun(RString kanriShikibetsuKubun) {
        this.kanriShikibetsuKubun = kanriShikibetsuKubun;
    }

    /**
     * 世帯把握基準年月日のgetメソッドです。
     *
     * @return 世帯把握基準年月日
     */
    public FlexibleDate getSetaiHaakuKijunYMD() {
        return setaiHaakuKijunYMD;
    }

    /**
     * 世帯把握基準年月日のsetメソッドです。
     *
     * @param setaiHaakuKijunYMD 世帯把握基準年月日
     */
    public void setSetaiHaakuKijunYMD(FlexibleDate setaiHaakuKijunYMD) {
        this.setaiHaakuKijunYMD = setaiHaakuKijunYMD;
    }

    /**
     * 世帯員管理連番のgetメソッドです。
     *
     * @return 世帯員管理連番
     */
    public int getSetaiInkanriRenban() {
        return setaiInkanriRenban;
    }

    /**
     * 世帯員管理連番のsetメソッドです。
     *
     * @param setaiInkanriRenban 世帯員管理連番
     */
    public void setSetaiInkanriRenban(int setaiInkanriRenban) {
        this.setaiInkanriRenban = setaiInkanriRenban;
    }

    /**
     * 世帯員識別コードのgetメソッドです。
     *
     * @return 世帯員識別コード
     */
    public ShikibetsuCode getSetaiInshikibetsuCode() {
        return setaiInshikibetsuCode;
    }

    /**
     * 世帯員識別コードのsetメソッドです。
     *
     * @param setaiInshikibetsuCode 世帯員識別コード
     */
    public void setSetaiInshikibetsuCode(ShikibetsuCode setaiInshikibetsuCode) {
        this.setaiInshikibetsuCode = setaiInshikibetsuCode;
    }

    /**
     * 本人区分のgetメソッドです。
     * <br/>
     * <br/>1：本人、2：世帯構成員
     *
     * @return 本人区分
     */
    public RString getHonninKubun() {
        return honninKubun;
    }

    /**
     * 本人区分のsetメソッドです。
     * <br/>
     * <br/>1：本人、2：世帯構成員
     *
     * @param honninKubun 本人区分
     */
    public void setHonninKubun(RString honninKubun) {
        this.honninKubun = honninKubun;
    }

    /**
     * 課税年度のgetメソッドです。
     *
     * @return 課税年度
     */
    public FlexibleYear getKazeiNendo() {
        return kazeiNendo;
    }

    /**
     * 課税年度のsetメソッドです。
     *
     * @param kazeiNendo 課税年度
     */
    public void setKazeiNendo(FlexibleYear kazeiNendo) {
        this.kazeiNendo = kazeiNendo;
    }

    /**
     * 課税非課税区分のgetメソッドです。
     * <br/>
     * <br/>1:課税　2:非課税　3:未申告　4:所得調査中
     *
     * @return 課税非課税区分
     */
    public RString getKazeiHikazeiKubun() {
        return kazeiHikazeiKubun;
    }

    /**
     * 課税非課税区分のsetメソッドです。
     * <br/>
     * <br/>1:課税　2:非課税　3:未申告　4:所得調査中
     *
     * @param kazeiHikazeiKubun 課税非課税区分
     */
    public void setKazeiHikazeiKubun(RString kazeiHikazeiKubun) {
        this.kazeiHikazeiKubun = kazeiHikazeiKubun;
    }

    /**
     * 合計所得金額のgetメソッドです。
     *
     * @return 合計所得金額
     */
    public Decimal getGokeiShotokuKingaku() {
        return gokeiShotokuKingaku;
    }

    /**
     * 合計所得金額のsetメソッドです。
     *
     * @param gokeiShotokuKingaku 合計所得金額
     */
    public void setGokeiShotokuKingaku(Decimal gokeiShotokuKingaku) {
        this.gokeiShotokuKingaku = gokeiShotokuKingaku;
    }

    /**
     * 課税年金収入額のgetメソッドです。
     *
     * @return 課税年金収入額
     */
    public Decimal getKazeiNenkinShunyugaku() {
        return kazeiNenkinShunyugaku;
    }

    /**
     * 課税年金収入額のsetメソッドです。
     *
     * @param kazeiNenkinShunyugaku 課税年金収入額
     */
    public void setKazeiNenkinShunyugaku(Decimal kazeiNenkinShunyugaku) {
        this.kazeiNenkinShunyugaku = kazeiNenkinShunyugaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7014KaigoSetaiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT7014KaigoSetaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7014KaigoSetaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.kanriShikibetsuKubun, other.kanriShikibetsuKubun)) {
            return false;
        }
        if (!Objects.equals(this.setaiHaakuKijunYMD, other.setaiHaakuKijunYMD)) {
            return false;
        }
        if (this.setaiInkanriRenban != other.setaiInkanriRenban) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7014KaigoSetaiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kanriShikibetsuKubun = entity.kanriShikibetsuKubun;
        this.setaiHaakuKijunYMD = entity.setaiHaakuKijunYMD;
        this.setaiInkanriRenban = entity.setaiInkanriRenban;
        this.setaiInshikibetsuCode = entity.setaiInshikibetsuCode;
        this.honninKubun = entity.honninKubun;
        this.kazeiNendo = entity.kazeiNendo;
        this.kazeiHikazeiKubun = entity.kazeiHikazeiKubun;
        this.gokeiShotokuKingaku = entity.gokeiShotokuKingaku;
        this.kazeiNenkinShunyugaku = entity.kazeiNenkinShunyugaku;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, kanriShikibetsuKubun, setaiHaakuKijunYMD, setaiInkanriRenban, setaiInshikibetsuCode, honninKubun, kazeiNendo, kazeiHikazeiKubun, gokeiShotokuKingaku, kazeiNenkinShunyugaku);
    }

// </editor-fold>
}
