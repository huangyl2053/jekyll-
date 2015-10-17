package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
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
 * 利用者負担割合明細テーブルのエンティティクラスです。
 * <br/> 利用者負担割合の明細
 */
public class DbT3114RiyoshaFutanWariaiMeisaiEntity extends DbTableEntityBase<DbT3114RiyoshaFutanWariaiMeisaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3114RiyoshaFutanWariaiMeisai");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYear nendo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private Decimal rirekiNo;
    @PrimaryKey
    private Decimal edaNo;
    private RString shikakuKubun;
    private RString futanWariaiKubun;
    private FlexibleDate yukoKaishiYMD;
    private FlexibleDate yukoShuryoYMD;
    private Decimal honninGoukeiShotokuGaku;
    private Decimal setaiIchigouHihoknehsaSu;
    private Decimal nenkinShunyuGoukei;
    private Decimal sonotanoGoukeiShotokuKingakuGoukei;
    private RString koseiRiyu;
    private SetaiCode setaiCd;

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
     * 年度のgetメソッドです。
     *
     * @return 年度
     */
    public FlexibleYear getNendo() {
        return nendo;
    }

    /**
     * 年度のsetメソッドです。
     *
     * @param nendo 年度
     */
    public void setNendo(FlexibleYear nendo) {
        this.nendo = nendo;
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
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public Decimal getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(Decimal rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 枝番号のgetメソッドです。
     *
     * @return 枝番号
     */
    public Decimal getEdaNo() {
        return edaNo;
    }

    /**
     * 枝番号のsetメソッドです。
     *
     * @param edaNo 枝番号
     */
    public void setEdaNo(Decimal edaNo) {
        this.edaNo = edaNo;
    }

    /**
     * 資格区分のgetメソッドです。
     * <br/>
     * <br/>01：1号被保険者
     *
     * <br/>02：2号被保険者
     *
     * <br/>03：2号被保険者（基準日時点1号被保険者）
     *
     * @return 資格区分
     */
    public RString getShikakuKubun() {
        return shikakuKubun;
    }

    /**
     * 資格区分のsetメソッドです。
     * <br/>
     * <br/>01：1号被保険者
     *
     * <br/>02：2号被保険者
     *
     * <br/>03：2号被保険者（基準日時点1号被保険者）
     *
     * @param shikakuKubun 資格区分
     */
    public void setShikakuKubun(RString shikakuKubun) {
        this.shikakuKubun = shikakuKubun;
    }

    /**
     * 負担割合区分のgetメソッドです。
     * <br/>
     * <br/>10：1割　20：2割
     *
     * @return 負担割合区分
     */
    public RString getFutanWariaiKubun() {
        return futanWariaiKubun;
    }

    /**
     * 負担割合区分のsetメソッドです。
     * <br/>
     * <br/>10：1割　20：2割
     *
     * @param futanWariaiKubun 負担割合区分
     */
    public void setFutanWariaiKubun(RString futanWariaiKubun) {
        this.futanWariaiKubun = futanWariaiKubun;
    }

    /**
     * 有効開始日のgetメソッドです。
     *
     * @return 有効開始日
     */
    public FlexibleDate getYukoKaishiYMD() {
        return yukoKaishiYMD;
    }

    /**
     * 有効開始日のsetメソッドです。
     *
     * @param yukoKaishiYMD 有効開始日
     */
    public void setYukoKaishiYMD(FlexibleDate yukoKaishiYMD) {
        this.yukoKaishiYMD = yukoKaishiYMD;
    }

    /**
     * 有効終了日のgetメソッドです。
     *
     * @return 有効終了日
     */
    public FlexibleDate getYukoShuryoYMD() {
        return yukoShuryoYMD;
    }

    /**
     * 有効終了日のsetメソッドです。
     *
     * @param yukoShuryoYMD 有効終了日
     */
    public void setYukoShuryoYMD(FlexibleDate yukoShuryoYMD) {
        this.yukoShuryoYMD = yukoShuryoYMD;
    }

    /**
     * 本人合計所得金額のgetメソッドです。
     *
     * @return 本人合計所得金額
     */
    public Decimal getHonninGoukeiShotokuGaku() {
        return honninGoukeiShotokuGaku;
    }

    /**
     * 本人合計所得金額のsetメソッドです。
     *
     * @param honninGoukeiShotokuGaku 本人合計所得金額
     */
    public void setHonninGoukeiShotokuGaku(Decimal honninGoukeiShotokuGaku) {
        this.honninGoukeiShotokuGaku = honninGoukeiShotokuGaku;
    }

    /**
     * 世帯１号被保険者数のgetメソッドです。
     *
     * @return 世帯１号被保険者数
     */
    public Decimal getSetaiIchigouHihoknehsaSu() {
        return setaiIchigouHihoknehsaSu;
    }

    /**
     * 世帯１号被保険者数のsetメソッドです。
     *
     * @param setaiIchigouHihoknehsaSu 世帯１号被保険者数
     */
    public void setSetaiIchigouHihoknehsaSu(Decimal setaiIchigouHihoknehsaSu) {
        this.setaiIchigouHihoknehsaSu = setaiIchigouHihoknehsaSu;
    }

    /**
     * 年金収入合計のgetメソッドです。
     *
     * @return 年金収入合計
     */
    public Decimal getNenkinShunyuGoukei() {
        return nenkinShunyuGoukei;
    }

    /**
     * 年金収入合計のsetメソッドです。
     *
     * @param nenkinShunyuGoukei 年金収入合計
     */
    public void setNenkinShunyuGoukei(Decimal nenkinShunyuGoukei) {
        this.nenkinShunyuGoukei = nenkinShunyuGoukei;
    }

    /**
     * その他の合計所得金額合計のgetメソッドです。
     *
     * @return その他の合計所得金額合計
     */
    public Decimal getSonotanoGoukeiShotokuKingakuGoukei() {
        return sonotanoGoukeiShotokuKingakuGoukei;
    }

    /**
     * その他の合計所得金額合計のsetメソッドです。
     *
     * @param sonotanoGoukeiShotokuKingakuGoukei その他の合計所得金額合計
     */
    public void setSonotanoGoukeiShotokuKingakuGoukei(Decimal sonotanoGoukeiShotokuKingakuGoukei) {
        this.sonotanoGoukeiShotokuKingakuGoukei = sonotanoGoukeiShotokuKingakuGoukei;
    }

    /**
     * 更正理由のgetメソッドです。
     *
     * @return 更正理由
     */
    public RString getKoseiRiyu() {
        return koseiRiyu;
    }

    /**
     * 更正理由のsetメソッドです。
     *
     * @param koseiRiyu 更正理由
     */
    public void setKoseiRiyu(RString koseiRiyu) {
        this.koseiRiyu = koseiRiyu;
    }

    /**
     * 世帯コードのgetメソッドです。
     *
     * @return 世帯コード
     */
    public SetaiCode getSetaiCd() {
        return setaiCd;
    }

    /**
     * 世帯コードのsetメソッドです。
     *
     * @param setaiCd 世帯コード
     */
    public void setSetaiCd(SetaiCode setaiCd) {
        this.setaiCd = setaiCd;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3114RiyoshaFutanWariaiMeisaiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3114RiyoshaFutanWariaiMeisaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3114RiyoshaFutanWariaiMeisaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.nendo, other.nendo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        if (this.edaNo != other.edaNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3114RiyoshaFutanWariaiMeisaiEntity entity) {
        this.nendo = entity.nendo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.edaNo = entity.edaNo;
        this.shikakuKubun = entity.shikakuKubun;
        this.futanWariaiKubun = entity.futanWariaiKubun;
        this.yukoKaishiYMD = entity.yukoKaishiYMD;
        this.yukoShuryoYMD = entity.yukoShuryoYMD;
        this.honninGoukeiShotokuGaku = entity.honninGoukeiShotokuGaku;
        this.setaiIchigouHihoknehsaSu = entity.setaiIchigouHihoknehsaSu;
        this.nenkinShunyuGoukei = entity.nenkinShunyuGoukei;
        this.sonotanoGoukeiShotokuKingakuGoukei = entity.sonotanoGoukeiShotokuKingakuGoukei;
        this.koseiRiyu = entity.koseiRiyu;
        this.setaiCd = entity.setaiCd;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(nendo, hihokenshaNo, rirekiNo, edaNo, shikakuKubun, futanWariaiKubun, yukoKaishiYMD, yukoShuryoYMD, honninGoukeiShotokuGaku, setaiIchigouHihoknehsaSu, nenkinShunyuGoukei, sonotanoGoukeiShotokuKingakuGoukei, koseiRiyu, setaiCd);
    }

// </editor-fold>
}
