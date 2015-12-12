package jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払請求特定診療費・特別療養費テーブルのエンティティクラスです。
 */
public class DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity extends DbTableEntityBase<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3042ShokanTokuteiShinryoTokubetsuRyoyo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private RString seiriNo;
    @PrimaryKey
    private JigyoshaNo jigyoshaNo;
    @PrimaryKey
    private RString yoshikiNo;
    @PrimaryKey
    private RString junjiNo;
    @PrimaryKey
    private Decimal rirekiNo;
    private RString shobyoName;
    private RString shikibetsuNo;
    private Decimal tanisu;
    private Decimal kaisu;
    private int serviceTanisu;
    private int totalTanisu;
    private RString tekiyo;

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
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hiHokenshaNo 被保険者番号
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * サービス提供年月のgetメソッドです。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * サービス提供年月のsetメソッドです。
     *
     * @param serviceTeikyoYM サービス提供年月
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * 整理番号のgetメソッドです。
     *
     * @return 整理番号
     */
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * 整理番号のsetメソッドです。
     *
     * @param seiriNo 整理番号
     */
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
    }

    /**
     * 事業者番号のgetメソッドです。
     *
     * @return 事業者番号
     */
    public JigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * 事業者番号のsetメソッドです。
     *
     * @param jigyoshaNo 事業者番号
     */
    public void setJigyoshaNo(JigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * 様式番号のgetメソッドです。
     *
     * @return 様式番号
     */
    public RString getYoshikiNo() {
        return yoshikiNo;
    }

    /**
     * 様式番号のsetメソッドです。
     *
     * @param yoshikiNo 様式番号
     */
    public void setYoshikiNo(RString yoshikiNo) {
        this.yoshikiNo = yoshikiNo;
    }

    /**
     * 順次番号のgetメソッドです。
     * <br/>
     * <br/>複数レコード対応のため
     *
     * @return 順次番号
     */
    public RString getJunjiNo() {
        return junjiNo;
    }

    /**
     * 順次番号のsetメソッドです。
     * <br/>
     * <br/>複数レコード対応のため
     *
     * @param junjiNo 順次番号
     */
    public void setJunjiNo(RString junjiNo) {
        this.junjiNo = junjiNo;
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
     * 傷病名のgetメソッドです。
     *
     * @return 傷病名
     */
    public RString getShobyoName() {
        return shobyoName;
    }

    /**
     * 傷病名のsetメソッドです。
     *
     * @param shobyoName 傷病名
     */
    public void setShobyoName(RString shobyoName) {
        this.shobyoName = shobyoName;
    }

    /**
     * 識別番号のgetメソッドです。
     *
     * @return 識別番号
     */
    public RString getShikibetsuNo() {
        return shikibetsuNo;
    }

    /**
     * 識別番号のsetメソッドです。
     *
     * @param shikibetsuNo 識別番号
     */
    public void setShikibetsuNo(RString shikibetsuNo) {
        this.shikibetsuNo = shikibetsuNo;
    }

    /**
     * 単位数のgetメソッドです。
     *
     * @return 単位数
     */
    public Decimal getTanisu() {
        return tanisu;
    }

    /**
     * 単位数のsetメソッドです。
     *
     * @param tanisu 単位数
     */
    public void setTanisu(Decimal tanisu) {
        this.tanisu = tanisu;
    }

    /**
     * 回数のgetメソッドです。
     *
     * @return 回数
     */
    public Decimal getKaisu() {
        return kaisu;
    }

    /**
     * 回数のsetメソッドです。
     *
     * @param kaisu 回数
     */
    public void setKaisu(Decimal kaisu) {
        this.kaisu = kaisu;
    }

    /**
     * サービス単位数のgetメソッドです。
     *
     * @return サービス単位数
     */
    public int getServiceTanisu() {
        return serviceTanisu;
    }

    /**
     * サービス単位数のsetメソッドです。
     *
     * @param serviceTanisu サービス単位数
     */
    public void setServiceTanisu(int serviceTanisu) {
        this.serviceTanisu = serviceTanisu;
    }

    /**
     * 合計単位数のgetメソッドです。
     *
     * @return 合計単位数
     */
    public int getTotalTanisu() {
        return totalTanisu;
    }

    /**
     * 合計単位数のsetメソッドです。
     *
     * @param totalTanisu 合計単位数
     */
    public void setTotalTanisu(int totalTanisu) {
        this.totalTanisu = totalTanisu;
    }

    /**
     * 摘要のgetメソッドです。
     *
     * @return 摘要
     */
    public RString getTekiyo() {
        return tekiyo;
    }

    /**
     * 摘要のsetメソッドです。
     *
     * @param tekiyo 摘要
     */
    public void setTekiyo(RString tekiyo) {
        this.tekiyo = tekiyo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.seiriNo, other.seiriNo)) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.yoshikiNo, other.yoshikiNo)) {
            return false;
        }
        if (!Objects.equals(this.junjiNo, other.junjiNo)) {
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
    public void shallowCopy(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNo = entity.seiriNo;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yoshikiNo = entity.yoshikiNo;
        this.junjiNo = entity.junjiNo;
        this.rirekiNo = entity.rirekiNo;
        this.shobyoName = entity.shobyoName;
        this.shikibetsuNo = entity.shikibetsuNo;
        this.tanisu = entity.tanisu;
        this.kaisu = entity.kaisu;
        this.serviceTanisu = entity.serviceTanisu;
        this.totalTanisu = entity.totalTanisu;
        this.tekiyo = entity.tekiyo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, jigyoshaNo, yoshikiNo, junjiNo, rirekiNo, shobyoName, shikibetsuNo, tanisu, kaisu, serviceTanisu, totalTanisu, tekiyo);
    }

// </editor-fold>
}
