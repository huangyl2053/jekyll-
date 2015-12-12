package jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;

/**
 * DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuの項目定義クラスです
 *
 */
public class DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity extends DbTableEntityBase<DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3030KyufuJissekiShakaiFukushiHojinKeigengaku");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private KokanShikibetsuNo kokanJohoShikibetsuNo;
    @PrimaryKey
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    @PrimaryKey
    private RString recodeShubetsuCode;
    @PrimaryKey
    private HokenshaNo shokisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private JigyoshaNo jigyoshoNo;
    @PrimaryKey
    private RString toshiNo;
    private Decimal keigenritsu;
    @PrimaryKey
    private ServiceShuruiCode serviceSyuruiCode;
    private Decimal riyoshaFutanTotal;
    private Decimal keigengaku;
    private Decimal keigengoRiyoshaFutangaku;
    private RString biko;
    private Decimal atoRiyoshaFutanTotal;
    private Decimal atoKeigengaku;
    private Decimal atoKeigengoRiyoshaFutangaku;
    private Decimal saishinsaKaisu;
    private Decimal kagoKaisu;
    private FlexibleYearMonth shinsaYM;
    private RString seiriNo;
    private FlexibleYearMonth torikomiYM;

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
     * 交換情報識別番号のgetメソッドです。
     *
     * @return 交換情報識別番号
     */
    public KokanShikibetsuNo getKokanJohoShikibetsuNo() {
        return kokanJohoShikibetsuNo;
    }

    /**
     * 交換情報識別番号のsetメソッドです。
     *
     * @param kokanJohoShikibetsuNo 交換情報識別番号
     */
    public void setKokanJohoShikibetsuNo(KokanShikibetsuNo kokanJohoShikibetsuNo) {
        this.kokanJohoShikibetsuNo = kokanJohoShikibetsuNo;
    }

    /**
     * 入力識別番号のgetメソッドです。
     *
     * @return 入力識別番号
     */
    public NyuryokuShikibetsuNo getInputShikibetsuNo() {
        return inputShikibetsuNo;
    }

    /**
     * 入力識別番号のsetメソッドです。
     *
     * @param inputShikibetsuNo 入力識別番号
     */
    public void setInputShikibetsuNo(NyuryokuShikibetsuNo inputShikibetsuNo) {
        this.inputShikibetsuNo = inputShikibetsuNo;
    }

    /**
     * レコード種別コードのgetメソッドです。
     *
     * @return レコード種別コード
     */
    public RString getRecodeShubetsuCode() {
        return recodeShubetsuCode;
    }

    /**
     * レコード種別コードのsetメソッドです。
     *
     * @param recodeShubetsuCode レコード種別コード
     */
    public void setRecodeShubetsuCode(RString recodeShubetsuCode) {
        this.recodeShubetsuCode = recodeShubetsuCode;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shokisaiHokenshaNo 証記載保険者番号
     */
    public void setShokisaiHokenshaNo(HokenshaNo shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
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
     * 事業所番号のgetメソッドです。
     *
     * @return 事業所番号
     */
    public JigyoshaNo getJigyoshoNo() {
        return jigyoshoNo;
    }

    /**
     * 事業所番号のsetメソッドです。
     *
     * @param jigyoshoNo 事業所番号
     */
    public void setJigyoshoNo(JigyoshaNo jigyoshoNo) {
        this.jigyoshoNo = jigyoshoNo;
    }

    /**
     * 通し番号のgetメソッドです。
     *
     * @return 通し番号
     */
    public RString getToshiNo() {
        return toshiNo;
    }

    /**
     * 通し番号のsetメソッドです。
     *
     * @param toshiNo 通し番号
     */
    public void setToshiNo(RString toshiNo) {
        this.toshiNo = toshiNo;
    }

    /**
     * 軽減率のgetメソッドです。
     *
     * @return 軽減率
     */
    public Decimal getKeigenritsu() {
        return keigenritsu;
    }

    /**
     * 軽減率のsetメソッドです。
     *
     * @param keigenritsu 軽減率
     */
    public void setKeigenritsu(Decimal keigenritsu) {
        this.keigenritsu = keigenritsu;
    }

    /**
     * サービス種類コードのgetメソッドです。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getServiceSyuruiCode() {
        return serviceSyuruiCode;
    }

    /**
     * サービス種類コードのsetメソッドです。
     *
     * @param serviceSyuruiCode サービス種類コード
     */
    public void setServiceSyuruiCode(ServiceShuruiCode serviceSyuruiCode) {
        this.serviceSyuruiCode = serviceSyuruiCode;
    }

    /**
     * 受領すべき利用者負担の総額のgetメソッドです。
     *
     * @return 受領すべき利用者負担の総額
     */
    public Decimal getRiyoshaFutanTotal() {
        return riyoshaFutanTotal;
    }

    /**
     * 受領すべき利用者負担の総額のsetメソッドです。
     *
     * @param riyoshaFutanTotal 受領すべき利用者負担の総額
     */
    public void setRiyoshaFutanTotal(Decimal riyoshaFutanTotal) {
        this.riyoshaFutanTotal = riyoshaFutanTotal;
    }

    /**
     * 軽減額のgetメソッドです。
     *
     * @return 軽減額
     */
    public Decimal getKeigengaku() {
        return keigengaku;
    }

    /**
     * 軽減額のsetメソッドです。
     *
     * @param keigengaku 軽減額
     */
    public void setKeigengaku(Decimal keigengaku) {
        this.keigengaku = keigengaku;
    }

    /**
     * 軽減後利用者負担額のgetメソッドです。
     *
     * @return 軽減後利用者負担額
     */
    public Decimal getKeigengoRiyoshaFutangaku() {
        return keigengoRiyoshaFutangaku;
    }

    /**
     * 軽減後利用者負担額のsetメソッドです。
     *
     * @param keigengoRiyoshaFutangaku 軽減後利用者負担額
     */
    public void setKeigengoRiyoshaFutangaku(Decimal keigengoRiyoshaFutangaku) {
        this.keigengoRiyoshaFutangaku = keigengoRiyoshaFutangaku;
    }

    /**
     * 備考のgetメソッドです。
     *
     * @return 備考
     */
    public RString getBiko() {
        return biko;
    }

    /**
     * 備考のsetメソッドです。
     *
     * @param biko 備考
     */
    public void setBiko(RString biko) {
        this.biko = biko;
    }

    /**
     * 後・受領すべき利用者負担の総額のgetメソッドです。
     *
     * @return 後・受領すべき利用者負担の総額
     */
    public Decimal getAtoRiyoshaFutanTotal() {
        return atoRiyoshaFutanTotal;
    }

    /**
     * 後・受領すべき利用者負担の総額のsetメソッドです。
     *
     * @param atoRiyoshaFutanTotal 後・受領すべき利用者負担の総額
     */
    public void setAtoRiyoshaFutanTotal(Decimal atoRiyoshaFutanTotal) {
        this.atoRiyoshaFutanTotal = atoRiyoshaFutanTotal;
    }

    /**
     * 後・軽減額のgetメソッドです。
     *
     * @return 後・軽減額
     */
    public Decimal getAtoKeigengaku() {
        return atoKeigengaku;
    }

    /**
     * 後・軽減額のsetメソッドです。
     *
     * @param atoKeigengaku 後・軽減額
     */
    public void setAtoKeigengaku(Decimal atoKeigengaku) {
        this.atoKeigengaku = atoKeigengaku;
    }

    /**
     * 後・軽減後利用者負担額のgetメソッドです。
     *
     * @return 後・軽減後利用者負担額
     */
    public Decimal getAtoKeigengoRiyoshaFutangaku() {
        return atoKeigengoRiyoshaFutangaku;
    }

    /**
     * 後・軽減後利用者負担額のsetメソッドです。
     *
     * @param atoKeigengoRiyoshaFutangaku 後・軽減後利用者負担額
     */
    public void setAtoKeigengoRiyoshaFutangaku(Decimal atoKeigengoRiyoshaFutangaku) {
        this.atoKeigengoRiyoshaFutangaku = atoKeigengoRiyoshaFutangaku;
    }

    /**
     * 再審査回数のgetメソッドです。
     *
     * @return 再審査回数
     */
    public Decimal getSaishinsaKaisu() {
        return saishinsaKaisu;
    }

    /**
     * 再審査回数のsetメソッドです。
     *
     * @param saishinsaKaisu 再審査回数
     */
    public void setSaishinsaKaisu(Decimal saishinsaKaisu) {
        this.saishinsaKaisu = saishinsaKaisu;
    }

    /**
     * 過誤回数のgetメソッドです。
     *
     * @return 過誤回数
     */
    public Decimal getKagoKaisu() {
        return kagoKaisu;
    }

    /**
     * 過誤回数のsetメソッドです。
     *
     * @param kagoKaisu 過誤回数
     */
    public void setKagoKaisu(Decimal kagoKaisu) {
        this.kagoKaisu = kagoKaisu;
    }

    /**
     * 審査年月のgetメソッドです。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth getShinsaYM() {
        return shinsaYM;
    }

    /**
     * 審査年月のsetメソッドです。
     *
     * @param shinsaYM 審査年月
     */
    public void setShinsaYM(FlexibleYearMonth shinsaYM) {
        this.shinsaYM = shinsaYM;
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
     * 取込年月のgetメソッドです。
     *
     * @return 取込年月
     */
    public FlexibleYearMonth getTorikomiYM() {
        return torikomiYM;
    }

    /**
     * 取込年月のsetメソッドです。
     *
     * @param torikomiYM 取込年月
     */
    public void setTorikomiYM(FlexibleYearMonth torikomiYM) {
        this.torikomiYM = torikomiYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.kokanJohoShikibetsuNo, other.kokanJohoShikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.inputShikibetsuNo, other.inputShikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.recodeShubetsuCode, other.recodeShubetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.shokisaiHokenshaNo, other.shokisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.jigyoshoNo, other.jigyoshoNo)) {
            return false;
        }
        if (!Objects.equals(this.toshiNo, other.toshiNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceSyuruiCode, other.serviceSyuruiCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity entity) {
        this.kokanJohoShikibetsuNo = entity.kokanJohoShikibetsuNo;
        this.inputShikibetsuNo = entity.inputShikibetsuNo;
        this.recodeShubetsuCode = entity.recodeShubetsuCode;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.toshiNo = entity.toshiNo;
        this.keigenritsu = entity.keigenritsu;
        this.serviceSyuruiCode = entity.serviceSyuruiCode;
        this.riyoshaFutanTotal = entity.riyoshaFutanTotal;
        this.keigengaku = entity.keigengaku;
        this.keigengoRiyoshaFutangaku = entity.keigengoRiyoshaFutangaku;
        this.biko = entity.biko;
        this.atoRiyoshaFutanTotal = entity.atoRiyoshaFutanTotal;
        this.atoKeigengaku = entity.atoKeigengaku;
        this.atoKeigengoRiyoshaFutangaku = entity.atoKeigengoRiyoshaFutangaku;
        this.saishinsaKaisu = entity.saishinsaKaisu;
        this.kagoKaisu = entity.kagoKaisu;
        this.shinsaYM = entity.shinsaYM;
        this.seiriNo = entity.seiriNo;
        this.torikomiYM = entity.torikomiYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kokanJohoShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, jigyoshoNo, toshiNo, keigenritsu, serviceSyuruiCode, riyoshaFutanTotal, keigengaku, keigengoRiyoshaFutangaku, biko, atoRiyoshaFutanTotal, atoKeigengaku, atoKeigengoRiyoshaFutangaku, saishinsaKaisu, kagoKaisu, shinsaYM, seiriNo, torikomiYM);
    }

// </editor-fold>
}
