package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付費貸付金借用書受理テーブルのエンティティクラスです。
 */
public class DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity extends DbTableEntityBase<DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3088KyufuhiKashitsukekinShakuyoshoJuri");

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
    private FlexibleDate kariireShinseiYMD;
    @PrimaryKey
    private Decimal rirekiNo;
    private FlexibleDate kariukeYMD;
    private YubinNo kariukeninYubinNo;
    private RString kariukeninJusho;
    private AtenaKanaMeisho kariukeninShimeiKana;
    private AtenaMeisho kariukeninShimei;
    private TelNo kariukeninTelNo;
    private AtenaKanaMeisho hoshoninShimeiKana;
    private AtenaKanaMeisho hoshoninShimei;
    private YubinNo hoshoninYubinNo;
    private RString hoshoninJusho;
    private TelNo hoshoninTelNo;

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
     * 借入申請年月日のgetメソッドです。
     *
     * @return 借入申請年月日
     */
    public FlexibleDate getKariireShinseiYMD() {
        return kariireShinseiYMD;
    }

    /**
     * 借入申請年月日のsetメソッドです。
     *
     * @param kariireShinseiYMD 借入申請年月日
     */
    public void setKariireShinseiYMD(FlexibleDate kariireShinseiYMD) {
        this.kariireShinseiYMD = kariireShinseiYMD;
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
     * 借受年月日のgetメソッドです。
     *
     * @return 借受年月日
     */
    public FlexibleDate getKariukeYMD() {
        return kariukeYMD;
    }

    /**
     * 借受年月日のsetメソッドです。
     *
     * @param kariukeYMD 借受年月日
     */
    public void setKariukeYMD(FlexibleDate kariukeYMD) {
        this.kariukeYMD = kariukeYMD;
    }

    /**
     * 借受人郵便番号のgetメソッドです。
     *
     * @return 借受人郵便番号
     */
    public YubinNo getKariukeninYubinNo() {
        return kariukeninYubinNo;
    }

    /**
     * 借受人郵便番号のsetメソッドです。
     *
     * @param kariukeninYubinNo 借受人郵便番号
     */
    public void setKariukeninYubinNo(YubinNo kariukeninYubinNo) {
        this.kariukeninYubinNo = kariukeninYubinNo;
    }

    /**
     * 借受人住所のgetメソッドです。
     *
     * @return 借受人住所
     */
    public RString getKariukeninJusho() {
        return kariukeninJusho;
    }

    /**
     * 借受人住所のsetメソッドです。
     *
     * @param kariukeninJusho 借受人住所
     */
    public void setKariukeninJusho(RString kariukeninJusho) {
        this.kariukeninJusho = kariukeninJusho;
    }

    /**
     * 借受人氏名カナのgetメソッドです。
     *
     * @return 借受人氏名カナ
     */
    public AtenaKanaMeisho getKariukeninShimeiKana() {
        return kariukeninShimeiKana;
    }

    /**
     * 借受人氏名カナのsetメソッドです。
     *
     * @param kariukeninShimeiKana 借受人氏名カナ
     */
    public void setKariukeninShimeiKana(AtenaKanaMeisho kariukeninShimeiKana) {
        this.kariukeninShimeiKana = kariukeninShimeiKana;
    }

    /**
     * 借受人氏名のgetメソッドです。
     *
     * @return 借受人氏名
     */
    public AtenaMeisho getKariukeninShimei() {
        return kariukeninShimei;
    }

    /**
     * 借受人氏名のsetメソッドです。
     *
     * @param kariukeninShimei 借受人氏名
     */
    public void setKariukeninShimei(AtenaMeisho kariukeninShimei) {
        this.kariukeninShimei = kariukeninShimei;
    }

    /**
     * 借受人電話番号のgetメソッドです。
     *
     * @return 借受人電話番号
     */
    public TelNo getKariukeninTelNo() {
        return kariukeninTelNo;
    }

    /**
     * 借受人電話番号のsetメソッドです。
     *
     * @param kariukeninTelNo 借受人電話番号
     */
    public void setKariukeninTelNo(TelNo kariukeninTelNo) {
        this.kariukeninTelNo = kariukeninTelNo;
    }

    /**
     * 保証人氏名カナのgetメソッドです。
     *
     * @return 保証人氏名カナ
     */
    public AtenaKanaMeisho getHoshoninShimeiKana() {
        return hoshoninShimeiKana;
    }

    /**
     * 保証人氏名カナのsetメソッドです。
     *
     * @param hoshoninShimeiKana 保証人氏名カナ
     */
    public void setHoshoninShimeiKana(AtenaKanaMeisho hoshoninShimeiKana) {
        this.hoshoninShimeiKana = hoshoninShimeiKana;
    }

    /**
     * 保証人氏名のgetメソッドです。
     *
     * @return 保証人氏名
     */
    public AtenaKanaMeisho getHoshoninShimei() {
        return hoshoninShimei;
    }

    /**
     * 保証人氏名のsetメソッドです。
     *
     * @param hoshoninShimei 保証人氏名
     */
    public void setHoshoninShimei(AtenaKanaMeisho hoshoninShimei) {
        this.hoshoninShimei = hoshoninShimei;
    }

    /**
     * 保証人郵便番号のgetメソッドです。
     *
     * @return 保証人郵便番号
     */
    public YubinNo getHoshoninYubinNo() {
        return hoshoninYubinNo;
    }

    /**
     * 保証人郵便番号のsetメソッドです。
     *
     * @param hoshoninYubinNo 保証人郵便番号
     */
    public void setHoshoninYubinNo(YubinNo hoshoninYubinNo) {
        this.hoshoninYubinNo = hoshoninYubinNo;
    }

    /**
     * 保証人住所のgetメソッドです。
     *
     * @return 保証人住所
     */
    public RString getHoshoninJusho() {
        return hoshoninJusho;
    }

    /**
     * 保証人住所のsetメソッドです。
     *
     * @param hoshoninJusho 保証人住所
     */
    public void setHoshoninJusho(RString hoshoninJusho) {
        this.hoshoninJusho = hoshoninJusho;
    }

    /**
     * 保証人電話番号のgetメソッドです。
     *
     * @return 保証人電話番号
     */
    public TelNo getHoshoninTelNo() {
        return hoshoninTelNo;
    }

    /**
     * 保証人電話番号のsetメソッドです。
     *
     * @param hoshoninTelNo 保証人電話番号
     */
    public void setHoshoninTelNo(TelNo hoshoninTelNo) {
        this.hoshoninTelNo = hoshoninTelNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.kariireShinseiYMD, other.kariireShinseiYMD)) {
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
    public void shallowCopy(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kariireShinseiYMD = entity.kariireShinseiYMD;
        this.rirekiNo = entity.rirekiNo;
        this.kariukeYMD = entity.kariukeYMD;
        this.kariukeninYubinNo = entity.kariukeninYubinNo;
        this.kariukeninJusho = entity.kariukeninJusho;
        this.kariukeninShimeiKana = entity.kariukeninShimeiKana;
        this.kariukeninShimei = entity.kariukeninShimei;
        this.kariukeninTelNo = entity.kariukeninTelNo;
        this.hoshoninShimeiKana = entity.hoshoninShimeiKana;
        this.hoshoninShimei = entity.hoshoninShimei;
        this.hoshoninYubinNo = entity.hoshoninYubinNo;
        this.hoshoninJusho = entity.hoshoninJusho;
        this.hoshoninTelNo = entity.hoshoninTelNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, kariireShinseiYMD, rirekiNo, kariukeYMD, kariukeninYubinNo, kariukeninJusho, kariukeninShimeiKana, kariukeninShimei, kariukeninTelNo, hoshoninShimeiKana, hoshoninShimei, hoshoninYubinNo, hoshoninJusho, hoshoninTelNo);
    }

// </editor-fold>
}
