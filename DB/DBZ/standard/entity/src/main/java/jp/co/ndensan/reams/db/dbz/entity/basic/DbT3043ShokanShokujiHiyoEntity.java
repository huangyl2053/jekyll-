package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3043ShokanShokujiHiyoの項目定義クラスです
 *
 */
public class DbT3043ShokanShokujiHiyoEntity extends DbTableEntityBase<DbT3043ShokanShokujiHiyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3043ShokanShokujiHiyo");

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
    private RString seiriNp;
    @PrimaryKey
    private JigyoshaNo jigyoshaNo;
    @PrimaryKey
    private RString yoshikiNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private int kihonTeikyoNissu;
    private int kihonTeikyoTanka;
    private int kihonTeikyoKingaku;
    private int tokubetsuTeikyoNissu;
    private int tokubetsuTeikyoTanka;
    private int tokubetsuTeikyoKingaku;
    private int shokujiTeikyoTotalNissu;
    private int shokujiTeikyohiTotal;
    private int getsugakuHyojunFutangaku;
    private int shokujiTeikyohiSeikyugaku;
    private int nichigakuHyojunFutangaku;
    private RString shikyuKubunCode;
    private int tensuKingaku;
    private int shikyuKingaku;
    private int zougenTen;

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getHiHokenshaNo
     *
     * @return hiHokenshaNo
     */
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * setHiHokenshaNo
     *
     * @param hiHokenshaNo hiHokenshaNo
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * getServiceTeikyoYM
     *
     * @return serviceTeikyoYM
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * setServiceTeikyoYM
     *
     * @param serviceTeikyoYM serviceTeikyoYM
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * getSeiriNp
     *
     * @return seiriNp
     */
    public RString getSeiriNp() {
        return seiriNp;
    }

    /**
     * setSeiriNp
     *
     * @param seiriNp seiriNp
     */
    public void setSeiriNp(RString seiriNp) {
        this.seiriNp = seiriNp;
    }

    /**
     * getJigyoshaNo
     *
     * @return jigyoshaNo
     */
    public JigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * setJigyoshaNo
     *
     * @param jigyoshaNo jigyoshaNo
     */
    public void setJigyoshaNo(JigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * getYoshikiNo
     *
     * @return yoshikiNo
     */
    public RString getYoshikiNo() {
        return yoshikiNo;
    }

    /**
     * setYoshikiNo
     *
     * @param yoshikiNo yoshikiNo
     */
    public void setYoshikiNo(RString yoshikiNo) {
        this.yoshikiNo = yoshikiNo;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getKihonTeikyoNissu
     *
     * @return kihonTeikyoNissu
     */
    public int getKihonTeikyoNissu() {
        return kihonTeikyoNissu;
    }

    /**
     * setKihonTeikyoNissu
     *
     * @param kihonTeikyoNissu kihonTeikyoNissu
     */
    public void setKihonTeikyoNissu(int kihonTeikyoNissu) {
        this.kihonTeikyoNissu = kihonTeikyoNissu;
    }

    /**
     * getKihonTeikyoTanka
     *
     * @return kihonTeikyoTanka
     */
    public int getKihonTeikyoTanka() {
        return kihonTeikyoTanka;
    }

    /**
     * setKihonTeikyoTanka
     *
     * @param kihonTeikyoTanka kihonTeikyoTanka
     */
    public void setKihonTeikyoTanka(int kihonTeikyoTanka) {
        this.kihonTeikyoTanka = kihonTeikyoTanka;
    }

    /**
     * getKihonTeikyoKingaku
     *
     * @return kihonTeikyoKingaku
     */
    public int getKihonTeikyoKingaku() {
        return kihonTeikyoKingaku;
    }

    /**
     * setKihonTeikyoKingaku
     *
     * @param kihonTeikyoKingaku kihonTeikyoKingaku
     */
    public void setKihonTeikyoKingaku(int kihonTeikyoKingaku) {
        this.kihonTeikyoKingaku = kihonTeikyoKingaku;
    }

    /**
     * getTokubetsuTeikyoNissu
     *
     * @return tokubetsuTeikyoNissu
     */
    public int getTokubetsuTeikyoNissu() {
        return tokubetsuTeikyoNissu;
    }

    /**
     * setTokubetsuTeikyoNissu
     *
     * @param tokubetsuTeikyoNissu tokubetsuTeikyoNissu
     */
    public void setTokubetsuTeikyoNissu(int tokubetsuTeikyoNissu) {
        this.tokubetsuTeikyoNissu = tokubetsuTeikyoNissu;
    }

    /**
     * getTokubetsuTeikyoTanka
     *
     * @return tokubetsuTeikyoTanka
     */
    public int getTokubetsuTeikyoTanka() {
        return tokubetsuTeikyoTanka;
    }

    /**
     * setTokubetsuTeikyoTanka
     *
     * @param tokubetsuTeikyoTanka tokubetsuTeikyoTanka
     */
    public void setTokubetsuTeikyoTanka(int tokubetsuTeikyoTanka) {
        this.tokubetsuTeikyoTanka = tokubetsuTeikyoTanka;
    }

    /**
     * getTokubetsuTeikyoKingaku
     *
     * @return tokubetsuTeikyoKingaku
     */
    public int getTokubetsuTeikyoKingaku() {
        return tokubetsuTeikyoKingaku;
    }

    /**
     * setTokubetsuTeikyoKingaku
     *
     * @param tokubetsuTeikyoKingaku tokubetsuTeikyoKingaku
     */
    public void setTokubetsuTeikyoKingaku(int tokubetsuTeikyoKingaku) {
        this.tokubetsuTeikyoKingaku = tokubetsuTeikyoKingaku;
    }

    /**
     * getShokujiTeikyoTotalNissu
     *
     * @return shokujiTeikyoTotalNissu
     */
    public int getShokujiTeikyoTotalNissu() {
        return shokujiTeikyoTotalNissu;
    }

    /**
     * setShokujiTeikyoTotalNissu
     *
     * @param shokujiTeikyoTotalNissu shokujiTeikyoTotalNissu
     */
    public void setShokujiTeikyoTotalNissu(int shokujiTeikyoTotalNissu) {
        this.shokujiTeikyoTotalNissu = shokujiTeikyoTotalNissu;
    }

    /**
     * getShokujiTeikyohiTotal
     *
     * @return shokujiTeikyohiTotal
     */
    public int getShokujiTeikyohiTotal() {
        return shokujiTeikyohiTotal;
    }

    /**
     * setShokujiTeikyohiTotal
     *
     * @param shokujiTeikyohiTotal shokujiTeikyohiTotal
     */
    public void setShokujiTeikyohiTotal(int shokujiTeikyohiTotal) {
        this.shokujiTeikyohiTotal = shokujiTeikyohiTotal;
    }

    /**
     * getGetsugakuHyojunFutangaku
     *
     * @return getsugakuHyojunFutangaku
     */
    public int getGetsugakuHyojunFutangaku() {
        return getsugakuHyojunFutangaku;
    }

    /**
     * setGetsugakuHyojunFutangaku
     *
     * @param getsugakuHyojunFutangaku getsugakuHyojunFutangaku
     */
    public void setGetsugakuHyojunFutangaku(int getsugakuHyojunFutangaku) {
        this.getsugakuHyojunFutangaku = getsugakuHyojunFutangaku;
    }

    /**
     * getShokujiTeikyohiSeikyugaku
     *
     * @return shokujiTeikyohiSeikyugaku
     */
    public int getShokujiTeikyohiSeikyugaku() {
        return shokujiTeikyohiSeikyugaku;
    }

    /**
     * setShokujiTeikyohiSeikyugaku
     *
     * @param shokujiTeikyohiSeikyugaku shokujiTeikyohiSeikyugaku
     */
    public void setShokujiTeikyohiSeikyugaku(int shokujiTeikyohiSeikyugaku) {
        this.shokujiTeikyohiSeikyugaku = shokujiTeikyohiSeikyugaku;
    }

    /**
     * getNichigakuHyojunFutangaku
     *
     * @return nichigakuHyojunFutangaku
     */
    public int getNichigakuHyojunFutangaku() {
        return nichigakuHyojunFutangaku;
    }

    /**
     * setNichigakuHyojunFutangaku
     *
     * @param nichigakuHyojunFutangaku nichigakuHyojunFutangaku
     */
    public void setNichigakuHyojunFutangaku(int nichigakuHyojunFutangaku) {
        this.nichigakuHyojunFutangaku = nichigakuHyojunFutangaku;
    }

    /**
     * getShikyuKubunCode
     *
     * @return shikyuKubunCode
     */
    public RString getShikyuKubunCode() {
        return shikyuKubunCode;
    }

    /**
     * setShikyuKubunCode
     *
     * @param shikyuKubunCode shikyuKubunCode
     */
    public void setShikyuKubunCode(RString shikyuKubunCode) {
        this.shikyuKubunCode = shikyuKubunCode;
    }

    /**
     * getTensuKingaku
     *
     * @return tensuKingaku
     */
    public int getTensuKingaku() {
        return tensuKingaku;
    }

    /**
     * setTensuKingaku
     *
     * @param tensuKingaku tensuKingaku
     */
    public void setTensuKingaku(int tensuKingaku) {
        this.tensuKingaku = tensuKingaku;
    }

    /**
     * getShikyuKingaku
     *
     * @return shikyuKingaku
     */
    public int getShikyuKingaku() {
        return shikyuKingaku;
    }

    /**
     * setShikyuKingaku
     *
     * @param shikyuKingaku shikyuKingaku
     */
    public void setShikyuKingaku(int shikyuKingaku) {
        this.shikyuKingaku = shikyuKingaku;
    }

    /**
     * getZougenTen
     *
     * @return zougenTen
     */
    public int getZougenTen() {
        return zougenTen;
    }

    /**
     * setZougenTen
     *
     * @param zougenTen zougenTen
     */
    public void setZougenTen(int zougenTen) {
        this.zougenTen = zougenTen;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3043ShokanShokujiHiyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT3043ShokanShokujiHiyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3043ShokanShokujiHiyoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.seiriNp, other.seiriNp)) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.yoshikiNo, other.yoshikiNo)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3043ShokanShokujiHiyoEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNp = entity.seiriNp;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yoshikiNo = entity.yoshikiNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.kihonTeikyoNissu = entity.kihonTeikyoNissu;
        this.kihonTeikyoTanka = entity.kihonTeikyoTanka;
        this.kihonTeikyoKingaku = entity.kihonTeikyoKingaku;
        this.tokubetsuTeikyoNissu = entity.tokubetsuTeikyoNissu;
        this.tokubetsuTeikyoTanka = entity.tokubetsuTeikyoTanka;
        this.tokubetsuTeikyoKingaku = entity.tokubetsuTeikyoKingaku;
        this.shokujiTeikyoTotalNissu = entity.shokujiTeikyoTotalNissu;
        this.shokujiTeikyohiTotal = entity.shokujiTeikyohiTotal;
        this.getsugakuHyojunFutangaku = entity.getsugakuHyojunFutangaku;
        this.shokujiTeikyohiSeikyugaku = entity.shokujiTeikyohiSeikyugaku;
        this.nichigakuHyojunFutangaku = entity.nichigakuHyojunFutangaku;
        this.shikyuKubunCode = entity.shikyuKubunCode;
        this.tensuKingaku = entity.tensuKingaku;
        this.shikyuKingaku = entity.shikyuKingaku;
        this.zougenTen = entity.zougenTen;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNp, jigyoshaNo, yoshikiNo, shoriTimestamp, kihonTeikyoNissu, kihonTeikyoTanka, kihonTeikyoKingaku, tokubetsuTeikyoNissu, tokubetsuTeikyoTanka, tokubetsuTeikyoKingaku, shokujiTeikyoTotalNissu, shokujiTeikyohiTotal, getsugakuHyojunFutangaku, shokujiTeikyohiSeikyugaku, nichigakuHyojunFutangaku, shikyuKubunCode, tensuKingaku, shikyuKingaku, zougenTen);
    }

// </editor-fold>
}
