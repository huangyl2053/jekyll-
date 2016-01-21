package jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 償還払請求食事費用テーブルのエンティティクラスです。
 */
public class DbT3043ShokanShokujiHiyoEntity extends DbTableEntityBase<DbT3043ShokanShokujiHiyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
    private RString meisaiNo;
    @PrimaryKey
    private RString renban;
    private Decimal kihonTeikyoNissu;
    private Decimal kihonTeikyoTanka;
    private int kihonTeikyoKingaku;
    private Decimal tokubetsuTeikyoNissu;
    private Decimal tokubetsuTeikyoTanka;
    private int tokubetsuTeikyoKingaku;
    private Decimal shokujiTeikyoTotalNissu;
    private int shokujiTeikyohiTotal;
    private int getsugakuHyojunFutangaku;
    private int shokujiTeikyohiSeikyugaku;
    private Decimal nichigakuHyojunFutangaku;
    private RString shikyuKubunCode;
    private int tensuKingaku;
    private int shikyuKingaku;
    private int zougenTen;

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
    public RString getSeiriNp() {
        return seiriNp;
    }

    /**
     * 整理番号のsetメソッドです。
     *
     * @param seiriNp 整理番号
     */
    public void setSeiriNp(RString seiriNp) {
        this.seiriNp = seiriNp;
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
     * 明細番号のgetメソッドです。
     *
     * @return 明細番号
     */
    public RString getMeisaiNo() {
        return meisaiNo;
    }

    /**
     * 明細番号のsetメソッドです。
     *
     * @param meisaiNo 明細番号
     */
    public void setMeisaiNo(RString meisaiNo) {
        this.meisaiNo = meisaiNo;
    }

    /**
     * 連番のgetメソッドです。
     *
     * @return 連番
     */
    public RString getRenban() {
        return renban;
    }

    /**
     * 連番のsetメソッドです。
     *
     * @param renban 連番
     */
    public void setRenban(RString renban) {
        this.renban = renban;
    }

    /**
     * 基本提供日数のgetメソッドです。
     *
     * @return 基本提供日数
     */
    public Decimal getKihonTeikyoNissu() {
        return kihonTeikyoNissu;
    }

    /**
     * 基本提供日数のsetメソッドです。
     *
     * @param kihonTeikyoNissu 基本提供日数
     */
    public void setKihonTeikyoNissu(Decimal kihonTeikyoNissu) {
        this.kihonTeikyoNissu = kihonTeikyoNissu;
    }

    /**
     * 基本提供単価のgetメソッドです。
     *
     * @return 基本提供単価
     */
    public Decimal getKihonTeikyoTanka() {
        return kihonTeikyoTanka;
    }

    /**
     * 基本提供単価のsetメソッドです。
     *
     * @param kihonTeikyoTanka 基本提供単価
     */
    public void setKihonTeikyoTanka(Decimal kihonTeikyoTanka) {
        this.kihonTeikyoTanka = kihonTeikyoTanka;
    }

    /**
     * 基本提供金額のgetメソッドです。
     *
     * @return 基本提供金額
     */
    public int getKihonTeikyoKingaku() {
        return kihonTeikyoKingaku;
    }

    /**
     * 基本提供金額のsetメソッドです。
     *
     * @param kihonTeikyoKingaku 基本提供金額
     */
    public void setKihonTeikyoKingaku(int kihonTeikyoKingaku) {
        this.kihonTeikyoKingaku = kihonTeikyoKingaku;
    }

    /**
     * 特別提供日数のgetメソッドです。
     *
     * @return 特別提供日数
     */
    public Decimal getTokubetsuTeikyoNissu() {
        return tokubetsuTeikyoNissu;
    }

    /**
     * 特別提供日数のsetメソッドです。
     *
     * @param tokubetsuTeikyoNissu 特別提供日数
     */
    public void setTokubetsuTeikyoNissu(Decimal tokubetsuTeikyoNissu) {
        this.tokubetsuTeikyoNissu = tokubetsuTeikyoNissu;
    }

    /**
     * 特別提供単価のgetメソッドです。
     *
     * @return 特別提供単価
     */
    public Decimal getTokubetsuTeikyoTanka() {
        return tokubetsuTeikyoTanka;
    }

    /**
     * 特別提供単価のsetメソッドです。
     *
     * @param tokubetsuTeikyoTanka 特別提供単価
     */
    public void setTokubetsuTeikyoTanka(Decimal tokubetsuTeikyoTanka) {
        this.tokubetsuTeikyoTanka = tokubetsuTeikyoTanka;
    }

    /**
     * 特別提供金額のgetメソッドです。
     *
     * @return 特別提供金額
     */
    public int getTokubetsuTeikyoKingaku() {
        return tokubetsuTeikyoKingaku;
    }

    /**
     * 特別提供金額のsetメソッドです。
     *
     * @param tokubetsuTeikyoKingaku 特別提供金額
     */
    public void setTokubetsuTeikyoKingaku(int tokubetsuTeikyoKingaku) {
        this.tokubetsuTeikyoKingaku = tokubetsuTeikyoKingaku;
    }

    /**
     * 食事提供延べ日数のgetメソッドです。
     *
     * @return 食事提供延べ日数
     */
    public Decimal getShokujiTeikyoTotalNissu() {
        return shokujiTeikyoTotalNissu;
    }

    /**
     * 食事提供延べ日数のsetメソッドです。
     *
     * @param shokujiTeikyoTotalNissu 食事提供延べ日数
     */
    public void setShokujiTeikyoTotalNissu(Decimal shokujiTeikyoTotalNissu) {
        this.shokujiTeikyoTotalNissu = shokujiTeikyoTotalNissu;
    }

    /**
     * 食事提供費合計のgetメソッドです。
     *
     * @return 食事提供費合計
     */
    public int getShokujiTeikyohiTotal() {
        return shokujiTeikyohiTotal;
    }

    /**
     * 食事提供費合計のsetメソッドです。
     *
     * @param shokujiTeikyohiTotal 食事提供費合計
     */
    public void setShokujiTeikyohiTotal(int shokujiTeikyohiTotal) {
        this.shokujiTeikyohiTotal = shokujiTeikyohiTotal;
    }

    /**
     * 標準負担額（月額）のgetメソッドです。
     *
     * @return 標準負担額（月額）
     */
    public int getGetsugakuHyojunFutangaku() {
        return getsugakuHyojunFutangaku;
    }

    /**
     * 標準負担額（月額）のsetメソッドです。
     *
     * @param getsugakuHyojunFutangaku 標準負担額（月額）
     */
    public void setGetsugakuHyojunFutangaku(int getsugakuHyojunFutangaku) {
        this.getsugakuHyojunFutangaku = getsugakuHyojunFutangaku;
    }

    /**
     * 食事提供費請求額のgetメソッドです。
     *
     * @return 食事提供費請求額
     */
    public int getShokujiTeikyohiSeikyugaku() {
        return shokujiTeikyohiSeikyugaku;
    }

    /**
     * 食事提供費請求額のsetメソッドです。
     *
     * @param shokujiTeikyohiSeikyugaku 食事提供費請求額
     */
    public void setShokujiTeikyohiSeikyugaku(int shokujiTeikyohiSeikyugaku) {
        this.shokujiTeikyohiSeikyugaku = shokujiTeikyohiSeikyugaku;
    }

    /**
     * 標準負担額（日額）のgetメソッドです。
     *
     * @return 標準負担額（日額）
     */
    public Decimal getNichigakuHyojunFutangaku() {
        return nichigakuHyojunFutangaku;
    }

    /**
     * 標準負担額（日額）のsetメソッドです。
     *
     * @param nichigakuHyojunFutangaku 標準負担額（日額）
     */
    public void setNichigakuHyojunFutangaku(Decimal nichigakuHyojunFutangaku) {
        this.nichigakuHyojunFutangaku = nichigakuHyojunFutangaku;
    }

    /**
     * 支給区分コードのgetメソッドです。
     * <br/>
     * <br/>支給・不支給決定情報
     *
     * @return 支給区分コード
     */
    public RString getShikyuKubunCode() {
        return shikyuKubunCode;
    }

    /**
     * 支給区分コードのsetメソッドです。
     * <br/>
     * <br/>支給・不支給決定情報
     *
     * @param shikyuKubunCode 支給区分コード
     */
    public void setShikyuKubunCode(RString shikyuKubunCode) {
        this.shikyuKubunCode = shikyuKubunCode;
    }

    /**
     * 点数／金額のgetメソッドです。
     * <br/>
     * <br/>支給・不支給決定情報
     *
     * @return 点数／金額
     */
    public int getTensuKingaku() {
        return tensuKingaku;
    }

    /**
     * 点数／金額のsetメソッドです。
     * <br/>
     * <br/>支給・不支給決定情報
     *
     * @param tensuKingaku 点数／金額
     */
    public void setTensuKingaku(int tensuKingaku) {
        this.tensuKingaku = tensuKingaku;
    }

    /**
     * 支給金額のgetメソッドです。
     * <br/>
     * <br/>支給・不支給決定情報
     *
     * @return 支給金額
     */
    public int getShikyuKingaku() {
        return shikyuKingaku;
    }

    /**
     * 支給金額のsetメソッドです。
     * <br/>
     * <br/>支給・不支給決定情報
     *
     * @param shikyuKingaku 支給金額
     */
    public void setShikyuKingaku(int shikyuKingaku) {
        this.shikyuKingaku = shikyuKingaku;
    }

    /**
     * 増減点のgetメソッドです。
     * <br/>
     * <br/>支給・不支給決定情報
     *
     * @return 増減点
     */
    public int getZougenTen() {
        return zougenTen;
    }

    /**
     * 増減点のsetメソッドです。
     * <br/>
     * <br/>支給・不支給決定情報
     *
     * @param zougenTen 増減点
     */
    public void setZougenTen(int zougenTen) {
        this.zougenTen = zougenTen;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3043ShokanShokujiHiyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal DbT3043ShokanShokujiHiyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
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
        if (this.meisaiNo != other.meisaiNo) {
            return false;
        }
        if (this.renban != other.renban) {
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
        this.meisaiNo = entity.meisaiNo;
        this.renban = entity.renban;
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
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNp, jigyoshaNo, yoshikiNo, meisaiNo, renban, kihonTeikyoNissu, kihonTeikyoTanka, kihonTeikyoKingaku, tokubetsuTeikyoNissu, tokubetsuTeikyoTanka, tokubetsuTeikyoKingaku, shokujiTeikyoTotalNissu, shokujiTeikyohiTotal, getsugakuHyojunFutangaku, shokujiTeikyohiSeikyugaku, nichigakuHyojunFutangaku, shikyuKubunCode, tensuKingaku, shikyuKingaku, zougenTen);
    }

// </editor-fold>
}
