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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DbT3006KyotakuKeikakuJigyoshaSakuseiの項目定義クラスです
 *
 */
public class DbT3006KyotakuKeikakuJigyoshaSakuseiEntity extends DbTableEntityBase<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3006KyotakuKeikakuJigyoshaSakusei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hihokenshano;
    @PrimaryKey
    private FlexibleYearMonth taishoYM;
    @PrimaryKey
    private Decimal rirekiNo;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private RString sakuseiKubunCode;
    private JigyoshaNo keikakuJigyoshaNo;
    private JigyoshaNo itakusakiJigyoshaNo;
    private FlexibleDate jigyoshaHenkoYMD;
    private RString jigyoshaHenkoJiyu;

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
    public HihokenshaNo getHihokenshano() {
        return hihokenshano;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshano 被保険者番号
     */
    public void setHihokenshano(HihokenshaNo hihokenshano) {
        this.hihokenshano = hihokenshano;
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
     * <br/>1：指定居宅介護支援事業者作成、2：基準該当居宅介護支援事業者作成、4：介護予防支援事業者作成
     *
     * @return 作成区分コード
     */
    public RString getSakuseiKubunCode() {
        return sakuseiKubunCode;
    }

    /**
     * 作成区分コードのsetメソッドです。
     * <br/>
     * <br/>1：指定居宅介護支援事業者作成、2：基準該当居宅介護支援事業者作成、4：介護予防支援事業者作成
     *
     * @param sakuseiKubunCode 作成区分コード
     */
    public void setSakuseiKubunCode(RString sakuseiKubunCode) {
        this.sakuseiKubunCode = sakuseiKubunCode;
    }

    /**
     * 計画事業者番号のgetメソッドです。
     *
     * @return 計画事業者番号
     */
    public JigyoshaNo getKeikakuJigyoshaNo() {
        return keikakuJigyoshaNo;
    }

    /**
     * 計画事業者番号のsetメソッドです。
     *
     * @param keikakuJigyoshaNo 計画事業者番号
     */
    public void setKeikakuJigyoshaNo(JigyoshaNo keikakuJigyoshaNo) {
        this.keikakuJigyoshaNo = keikakuJigyoshaNo;
    }

    /**
     * 委託先事業者番号のgetメソッドです。
     * <br/>
     * <br/>地域包括支援センターの委託先
     *
     * @return 委託先事業者番号
     */
    public JigyoshaNo getItakusakiJigyoshaNo() {
        return itakusakiJigyoshaNo;
    }

    /**
     * 委託先事業者番号のsetメソッドです。
     * <br/>
     * <br/>地域包括支援センターの委託先
     *
     * @param itakusakiJigyoshaNo 委託先事業者番号
     */
    public void setItakusakiJigyoshaNo(JigyoshaNo itakusakiJigyoshaNo) {
        this.itakusakiJigyoshaNo = itakusakiJigyoshaNo;
    }

    /**
     * 事業者変更年月日のgetメソッドです。
     *
     * @return 事業者変更年月日
     */
    public FlexibleDate getJigyoshaHenkoYMD() {
        return jigyoshaHenkoYMD;
    }

    /**
     * 事業者変更年月日のsetメソッドです。
     *
     * @param jigyoshaHenkoYMD 事業者変更年月日
     */
    public void setJigyoshaHenkoYMD(FlexibleDate jigyoshaHenkoYMD) {
        this.jigyoshaHenkoYMD = jigyoshaHenkoYMD;
    }

    /**
     * 事業者変更事由のgetメソッドです。
     *
     * @return 事業者変更事由
     */
    public RString getJigyoshaHenkoJiyu() {
        return jigyoshaHenkoJiyu;
    }

    /**
     * 事業者変更事由のsetメソッドです。
     *
     * @param jigyoshaHenkoJiyu 事業者変更事由
     */
    public void setJigyoshaHenkoJiyu(RString jigyoshaHenkoJiyu) {
        this.jigyoshaHenkoJiyu = jigyoshaHenkoJiyu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3006KyotakuKeikakuJigyoshaSakuseiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3006KyotakuKeikakuJigyoshaSakuseiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshano, other.hihokenshano)) {
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
    public void shallowCopy(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity) {
        this.hihokenshano = entity.hihokenshano;
        this.taishoYM = entity.taishoYM;
        this.rirekiNo = entity.rirekiNo;
        this.tekiyoKaishiYMD = entity.tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = entity.tekiyoShuryoYMD;
        this.sakuseiKubunCode = entity.sakuseiKubunCode;
        this.keikakuJigyoshaNo = entity.keikakuJigyoshaNo;
        this.itakusakiJigyoshaNo = entity.itakusakiJigyoshaNo;
        this.jigyoshaHenkoYMD = entity.jigyoshaHenkoYMD;
        this.jigyoshaHenkoJiyu = entity.jigyoshaHenkoJiyu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshano, taishoYM, rirekiNo, tekiyoKaishiYMD, tekiyoShuryoYMD, sakuseiKubunCode, keikakuJigyoshaNo, itakusakiJigyoshaNo, jigyoshaHenkoYMD, jigyoshaHenkoJiyu);
    }

// </editor-fold>
}
