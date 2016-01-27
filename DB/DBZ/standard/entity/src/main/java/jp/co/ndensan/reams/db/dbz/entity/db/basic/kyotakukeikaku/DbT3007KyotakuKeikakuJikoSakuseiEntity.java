package jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DbT3007KyotakuKeikakuJikoSakuseiの項目定義クラスです
 *
 */
public class DbT3007KyotakuKeikakuJikoSakuseiEntity extends DbTableEntityBase<DbT3007KyotakuKeikakuJikoSakuseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3007KyotakuKeikakuJikoSakusei");

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
    private FlexibleYearMonth taishoYM;
    @PrimaryKey
    private Decimal rirekiNo;
    private RString kyotaku_SogoJigyoKubun;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private RString sakuseiKubunCode;
    private FlexibleDate keikakuSakuseiYMD;
    private FlexibleDate keikakuHenkoYMD;
    private RString keikakuHenkoJiyu;

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
     * 対象年月のgetメソッドです。
     *
     * @return 対象年月
     */
    public FlexibleYearMonth getTaishoYM() {
        return taishoYM;
    }

    /**
     * 対象年月のsetメソッドです。
     *
     * @param taishoYM 対象年月
     */
    public void setTaishoYM(FlexibleYearMonth taishoYM) {
        this.taishoYM = taishoYM;
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
     * 居宅・総合事業区分のgetメソッドです。
     * <br/>
     * <br/>1:居宅サービス計画,2:総合事業費計画
     *
     * @return 居宅・総合事業区分
     */
    public RString getKyotaku_SogoJigyoKubun() {
        return kyotaku_SogoJigyoKubun;
    }

    /**
     * 居宅・総合事業区分のsetメソッドです。
     * <br/>
     * <br/>1:居宅サービス計画,2:総合事業費計画
     *
     * @param kyotaku_SogoJigyoKubun 居宅・総合事業区分
     */
    public void setKyotaku_SogoJigyoKubun(RString kyotaku_SogoJigyoKubun) {
        this.kyotaku_SogoJigyoKubun = kyotaku_SogoJigyoKubun;
    }

    /**
     * 適用開始年月日のgetメソッドです。
     *
     * @return 適用開始年月日
     */
    public FlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    /**
     * 適用開始年月日のsetメソッドです。
     *
     * @param tekiyoKaishiYMD 適用開始年月日
     */
    public void setTekiyoKaishiYMD(FlexibleDate tekiyoKaishiYMD) {
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    /**
     * 適用終了年月日のgetメソッドです。
     *
     * @return 適用終了年月日
     */
    public FlexibleDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    /**
     * 適用終了年月日のsetメソッドです。
     *
     * @param tekiyoShuryoYMD 適用終了年月日
     */
    public void setTekiyoShuryoYMD(FlexibleDate tekiyoShuryoYMD) {
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    /**
     * 作成区分コードのgetメソッドです。
     * <br/>
     * <br/>3：自己作成（固定）
     *
     * @return 作成区分コード
     */
    public RString getSakuseiKubunCode() {
        return sakuseiKubunCode;
    }

    /**
     * 作成区分コードのsetメソッドです。
     * <br/>
     * <br/>3：自己作成（固定）
     *
     * @param sakuseiKubunCode 作成区分コード
     */
    public void setSakuseiKubunCode(RString sakuseiKubunCode) {
        this.sakuseiKubunCode = sakuseiKubunCode;
    }

    /**
     * 計画作成年月日のgetメソッドです。
     *
     * @return 計画作成年月日
     */
    public FlexibleDate getKeikakuSakuseiYMD() {
        return keikakuSakuseiYMD;
    }

    /**
     * 計画作成年月日のsetメソッドです。
     *
     * @param keikakuSakuseiYMD 計画作成年月日
     */
    public void setKeikakuSakuseiYMD(FlexibleDate keikakuSakuseiYMD) {
        this.keikakuSakuseiYMD = keikakuSakuseiYMD;
    }

    /**
     * 計画変更年月日のgetメソッドです。
     *
     * @return 計画変更年月日
     */
    public FlexibleDate getKeikakuHenkoYMD() {
        return keikakuHenkoYMD;
    }

    /**
     * 計画変更年月日のsetメソッドです。
     *
     * @param keikakuHenkoYMD 計画変更年月日
     */
    public void setKeikakuHenkoYMD(FlexibleDate keikakuHenkoYMD) {
        this.keikakuHenkoYMD = keikakuHenkoYMD;
    }

    /**
     * 計画変更事由のgetメソッドです。
     *
     * @return 計画変更事由
     */
    public RString getKeikakuHenkoJiyu() {
        return keikakuHenkoJiyu;
    }

    /**
     * 計画変更事由のsetメソッドです。
     *
     * @param keikakuHenkoJiyu 計画変更事由
     */
    public void setKeikakuHenkoJiyu(RString keikakuHenkoJiyu) {
        this.keikakuHenkoJiyu = keikakuHenkoJiyu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3007KyotakuKeikakuJikoSakuseiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3007KyotakuKeikakuJikoSakuseiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3007KyotakuKeikakuJikoSakuseiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.taishoYM, other.taishoYM)) {
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
    public void shallowCopy(DbT3007KyotakuKeikakuJikoSakuseiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.taishoYM = entity.taishoYM;
        this.rirekiNo = entity.rirekiNo;
        this.kyotaku_SogoJigyoKubun = entity.kyotaku_SogoJigyoKubun;
        this.tekiyoKaishiYMD = entity.tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = entity.tekiyoShuryoYMD;
        this.sakuseiKubunCode = entity.sakuseiKubunCode;
        this.keikakuSakuseiYMD = entity.keikakuSakuseiYMD;
        this.keikakuHenkoYMD = entity.keikakuHenkoYMD;
        this.keikakuHenkoJiyu = entity.keikakuHenkoJiyu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, taishoYM, rirekiNo, kyotaku_SogoJigyoKubun, tekiyoKaishiYMD, tekiyoShuryoYMD, sakuseiKubunCode, keikakuSakuseiYMD, keikakuHenkoYMD, keikakuHenkoJiyu);
    }

// </editor-fold>
}
