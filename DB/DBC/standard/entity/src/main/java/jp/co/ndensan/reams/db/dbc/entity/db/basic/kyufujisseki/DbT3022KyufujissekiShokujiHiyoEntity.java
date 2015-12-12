package jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績食事費用テーブルのエンティティクラスです。
 */
public class DbT3022KyufujissekiShokujiHiyoEntity extends DbTableEntityBase<DbT3022KyufujissekiShokujiHiyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3022KyufujissekiShokujiHiyo");

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
    private Decimal kihonTeikyoNissu;
    private Decimal kihonTeikyoTanka;
    private Decimal kihonTeikyoKingaku;
    private Decimal tokubestuTeikyoNissu;
    private Decimal tokubestuTeikyoTanka;
    private Decimal tokubestuTeikyoKingaku;
    private Decimal syokujiTeikyoNissu;
    private Decimal kohi1SyokujiTeikyoNissu;
    private Decimal kohi2SyokujiTeikyoNissu;
    private Decimal kohi3SyokujiTeikyoNissu;
    private Decimal syokujiTeikyohiTotal;
    private Decimal getsugakuHyojunFutanGaku;
    private Decimal syokujiTeikyohiSeikyugaku;
    private Decimal kohi1SyokujiTeikyohiSeikyugaku;
    private Decimal kohi2SyokujiTeikyohiSeikyugaku;
    private Decimal kohi3SyokujiTeikyohiSeikyugaku;
    private Decimal nichigakuHyojunFutanGaku;
    private Decimal atoKihonTeikyoTanka;
    private Decimal atoTokubestuTeikyoTanka;
    private Decimal atoSyokujiTeikyohiSeikyugaku;
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
     * 基本・提供日数のgetメソッドです。
     *
     * @return 基本・提供日数
     */
    public Decimal getKihonTeikyoNissu() {
        return kihonTeikyoNissu;
    }

    /**
     * 基本・提供日数のsetメソッドです。
     *
     * @param kihonTeikyoNissu 基本・提供日数
     */
    public void setKihonTeikyoNissu(Decimal kihonTeikyoNissu) {
        this.kihonTeikyoNissu = kihonTeikyoNissu;
    }

    /**
     * 基本・提供単価のgetメソッドです。
     *
     * @return 基本・提供単価
     */
    public Decimal getKihonTeikyoTanka() {
        return kihonTeikyoTanka;
    }

    /**
     * 基本・提供単価のsetメソッドです。
     *
     * @param kihonTeikyoTanka 基本・提供単価
     */
    public void setKihonTeikyoTanka(Decimal kihonTeikyoTanka) {
        this.kihonTeikyoTanka = kihonTeikyoTanka;
    }

    /**
     * 基本・提供金額のgetメソッドです。
     *
     * @return 基本・提供金額
     */
    public Decimal getKihonTeikyoKingaku() {
        return kihonTeikyoKingaku;
    }

    /**
     * 基本・提供金額のsetメソッドです。
     *
     * @param kihonTeikyoKingaku 基本・提供金額
     */
    public void setKihonTeikyoKingaku(Decimal kihonTeikyoKingaku) {
        this.kihonTeikyoKingaku = kihonTeikyoKingaku;
    }

    /**
     * 特別・提供日数のgetメソッドです。
     *
     * @return 特別・提供日数
     */
    public Decimal getTokubestuTeikyoNissu() {
        return tokubestuTeikyoNissu;
    }

    /**
     * 特別・提供日数のsetメソッドです。
     *
     * @param tokubestuTeikyoNissu 特別・提供日数
     */
    public void setTokubestuTeikyoNissu(Decimal tokubestuTeikyoNissu) {
        this.tokubestuTeikyoNissu = tokubestuTeikyoNissu;
    }

    /**
     * 特別・提供単価のgetメソッドです。
     *
     * @return 特別・提供単価
     */
    public Decimal getTokubestuTeikyoTanka() {
        return tokubestuTeikyoTanka;
    }

    /**
     * 特別・提供単価のsetメソッドです。
     *
     * @param tokubestuTeikyoTanka 特別・提供単価
     */
    public void setTokubestuTeikyoTanka(Decimal tokubestuTeikyoTanka) {
        this.tokubestuTeikyoTanka = tokubestuTeikyoTanka;
    }

    /**
     * 特別・提供金額のgetメソッドです。
     *
     * @return 特別・提供金額
     */
    public Decimal getTokubestuTeikyoKingaku() {
        return tokubestuTeikyoKingaku;
    }

    /**
     * 特別・提供金額のsetメソッドです。
     *
     * @param tokubestuTeikyoKingaku 特別・提供金額
     */
    public void setTokubestuTeikyoKingaku(Decimal tokubestuTeikyoKingaku) {
        this.tokubestuTeikyoKingaku = tokubestuTeikyoKingaku;
    }

    /**
     * 食事提供延べ日数のgetメソッドです。
     *
     * @return 食事提供延べ日数
     */
    public Decimal getSyokujiTeikyoNissu() {
        return syokujiTeikyoNissu;
    }

    /**
     * 食事提供延べ日数のsetメソッドです。
     *
     * @param syokujiTeikyoNissu 食事提供延べ日数
     */
    public void setSyokujiTeikyoNissu(Decimal syokujiTeikyoNissu) {
        this.syokujiTeikyoNissu = syokujiTeikyoNissu;
    }

    /**
     * 公費１対象食事提供延べ日数のgetメソッドです。
     *
     * @return 公費１対象食事提供延べ日数
     */
    public Decimal getKohi1SyokujiTeikyoNissu() {
        return kohi1SyokujiTeikyoNissu;
    }

    /**
     * 公費１対象食事提供延べ日数のsetメソッドです。
     *
     * @param kohi1SyokujiTeikyoNissu 公費１対象食事提供延べ日数
     */
    public void setKohi1SyokujiTeikyoNissu(Decimal kohi1SyokujiTeikyoNissu) {
        this.kohi1SyokujiTeikyoNissu = kohi1SyokujiTeikyoNissu;
    }

    /**
     * 公費２対象食事提供延べ日数のgetメソッドです。
     *
     * @return 公費２対象食事提供延べ日数
     */
    public Decimal getKohi2SyokujiTeikyoNissu() {
        return kohi2SyokujiTeikyoNissu;
    }

    /**
     * 公費２対象食事提供延べ日数のsetメソッドです。
     *
     * @param kohi2SyokujiTeikyoNissu 公費２対象食事提供延べ日数
     */
    public void setKohi2SyokujiTeikyoNissu(Decimal kohi2SyokujiTeikyoNissu) {
        this.kohi2SyokujiTeikyoNissu = kohi2SyokujiTeikyoNissu;
    }

    /**
     * 公費３対象食事提供延べ日数のgetメソッドです。
     *
     * @return 公費３対象食事提供延べ日数
     */
    public Decimal getKohi3SyokujiTeikyoNissu() {
        return kohi3SyokujiTeikyoNissu;
    }

    /**
     * 公費３対象食事提供延べ日数のsetメソッドです。
     *
     * @param kohi3SyokujiTeikyoNissu 公費３対象食事提供延べ日数
     */
    public void setKohi3SyokujiTeikyoNissu(Decimal kohi3SyokujiTeikyoNissu) {
        this.kohi3SyokujiTeikyoNissu = kohi3SyokujiTeikyoNissu;
    }

    /**
     * 食事提供費合計のgetメソッドです。
     *
     * @return 食事提供費合計
     */
    public Decimal getSyokujiTeikyohiTotal() {
        return syokujiTeikyohiTotal;
    }

    /**
     * 食事提供費合計のsetメソッドです。
     *
     * @param syokujiTeikyohiTotal 食事提供費合計
     */
    public void setSyokujiTeikyohiTotal(Decimal syokujiTeikyohiTotal) {
        this.syokujiTeikyohiTotal = syokujiTeikyohiTotal;
    }

    /**
     * 標準負担額（月額）のgetメソッドです。
     *
     * @return 標準負担額（月額）
     */
    public Decimal getGetsugakuHyojunFutanGaku() {
        return getsugakuHyojunFutanGaku;
    }

    /**
     * 標準負担額（月額）のsetメソッドです。
     *
     * @param getsugakuHyojunFutanGaku 標準負担額（月額）
     */
    public void setGetsugakuHyojunFutanGaku(Decimal getsugakuHyojunFutanGaku) {
        this.getsugakuHyojunFutanGaku = getsugakuHyojunFutanGaku;
    }

    /**
     * 食事提供費請求額のgetメソッドです。
     *
     * @return 食事提供費請求額
     */
    public Decimal getSyokujiTeikyohiSeikyugaku() {
        return syokujiTeikyohiSeikyugaku;
    }

    /**
     * 食事提供費請求額のsetメソッドです。
     *
     * @param syokujiTeikyohiSeikyugaku 食事提供費請求額
     */
    public void setSyokujiTeikyohiSeikyugaku(Decimal syokujiTeikyohiSeikyugaku) {
        this.syokujiTeikyohiSeikyugaku = syokujiTeikyohiSeikyugaku;
    }

    /**
     * 公費１食事提供費請求額のgetメソッドです。
     *
     * @return 公費１食事提供費請求額
     */
    public Decimal getKohi1SyokujiTeikyohiSeikyugaku() {
        return kohi1SyokujiTeikyohiSeikyugaku;
    }

    /**
     * 公費１食事提供費請求額のsetメソッドです。
     *
     * @param kohi1SyokujiTeikyohiSeikyugaku 公費１食事提供費請求額
     */
    public void setKohi1SyokujiTeikyohiSeikyugaku(Decimal kohi1SyokujiTeikyohiSeikyugaku) {
        this.kohi1SyokujiTeikyohiSeikyugaku = kohi1SyokujiTeikyohiSeikyugaku;
    }

    /**
     * 公費２食事提供費請求額のgetメソッドです。
     *
     * @return 公費２食事提供費請求額
     */
    public Decimal getKohi2SyokujiTeikyohiSeikyugaku() {
        return kohi2SyokujiTeikyohiSeikyugaku;
    }

    /**
     * 公費２食事提供費請求額のsetメソッドです。
     *
     * @param kohi2SyokujiTeikyohiSeikyugaku 公費２食事提供費請求額
     */
    public void setKohi2SyokujiTeikyohiSeikyugaku(Decimal kohi2SyokujiTeikyohiSeikyugaku) {
        this.kohi2SyokujiTeikyohiSeikyugaku = kohi2SyokujiTeikyohiSeikyugaku;
    }

    /**
     * 公費３食事提供費請求額のgetメソッドです。
     *
     * @return 公費３食事提供費請求額
     */
    public Decimal getKohi3SyokujiTeikyohiSeikyugaku() {
        return kohi3SyokujiTeikyohiSeikyugaku;
    }

    /**
     * 公費３食事提供費請求額のsetメソッドです。
     *
     * @param kohi3SyokujiTeikyohiSeikyugaku 公費３食事提供費請求額
     */
    public void setKohi3SyokujiTeikyohiSeikyugaku(Decimal kohi3SyokujiTeikyohiSeikyugaku) {
        this.kohi3SyokujiTeikyohiSeikyugaku = kohi3SyokujiTeikyohiSeikyugaku;
    }

    /**
     * 標準負担額（日額）のgetメソッドです。
     *
     * @return 標準負担額（日額）
     */
    public Decimal getNichigakuHyojunFutanGaku() {
        return nichigakuHyojunFutanGaku;
    }

    /**
     * 標準負担額（日額）のsetメソッドです。
     *
     * @param nichigakuHyojunFutanGaku 標準負担額（日額）
     */
    public void setNichigakuHyojunFutanGaku(Decimal nichigakuHyojunFutanGaku) {
        this.nichigakuHyojunFutanGaku = nichigakuHyojunFutanGaku;
    }

    /**
     * 後・基本食提供費用提供単価のgetメソッドです。
     *
     * @return 後・基本食提供費用提供単価
     */
    public Decimal getAtoKihonTeikyoTanka() {
        return atoKihonTeikyoTanka;
    }

    /**
     * 後・基本食提供費用提供単価のsetメソッドです。
     *
     * @param atoKihonTeikyoTanka 後・基本食提供費用提供単価
     */
    public void setAtoKihonTeikyoTanka(Decimal atoKihonTeikyoTanka) {
        this.atoKihonTeikyoTanka = atoKihonTeikyoTanka;
    }

    /**
     * 後・特別食提供費用提供単価のgetメソッドです。
     *
     * @return 後・特別食提供費用提供単価
     */
    public Decimal getAtoTokubestuTeikyoTanka() {
        return atoTokubestuTeikyoTanka;
    }

    /**
     * 後・特別食提供費用提供単価のsetメソッドです。
     *
     * @param atoTokubestuTeikyoTanka 後・特別食提供費用提供単価
     */
    public void setAtoTokubestuTeikyoTanka(Decimal atoTokubestuTeikyoTanka) {
        this.atoTokubestuTeikyoTanka = atoTokubestuTeikyoTanka;
    }

    /**
     * 後・食事提供費請求額のgetメソッドです。
     *
     * @return 後・食事提供費請求額
     */
    public Decimal getAtoSyokujiTeikyohiSeikyugaku() {
        return atoSyokujiTeikyohiSeikyugaku;
    }

    /**
     * 後・食事提供費請求額のsetメソッドです。
     *
     * @param atoSyokujiTeikyohiSeikyugaku 後・食事提供費請求額
     */
    public void setAtoSyokujiTeikyohiSeikyugaku(Decimal atoSyokujiTeikyohiSeikyugaku) {
        this.atoSyokujiTeikyohiSeikyugaku = atoSyokujiTeikyohiSeikyugaku;
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
     * このエンティティの主キーが他の{@literal DbT3022KyufujissekiShokujiHiyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3022KyufujissekiShokujiHiyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3022KyufujissekiShokujiHiyoEntity other) {
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
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3022KyufujissekiShokujiHiyoEntity entity) {
        this.kokanJohoShikibetsuNo = entity.kokanJohoShikibetsuNo;
        this.inputShikibetsuNo = entity.inputShikibetsuNo;
        this.recodeShubetsuCode = entity.recodeShubetsuCode;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.toshiNo = entity.toshiNo;
        this.kihonTeikyoNissu = entity.kihonTeikyoNissu;
        this.kihonTeikyoTanka = entity.kihonTeikyoTanka;
        this.kihonTeikyoKingaku = entity.kihonTeikyoKingaku;
        this.tokubestuTeikyoNissu = entity.tokubestuTeikyoNissu;
        this.tokubestuTeikyoTanka = entity.tokubestuTeikyoTanka;
        this.tokubestuTeikyoKingaku = entity.tokubestuTeikyoKingaku;
        this.syokujiTeikyoNissu = entity.syokujiTeikyoNissu;
        this.kohi1SyokujiTeikyoNissu = entity.kohi1SyokujiTeikyoNissu;
        this.kohi2SyokujiTeikyoNissu = entity.kohi2SyokujiTeikyoNissu;
        this.kohi3SyokujiTeikyoNissu = entity.kohi3SyokujiTeikyoNissu;
        this.syokujiTeikyohiTotal = entity.syokujiTeikyohiTotal;
        this.getsugakuHyojunFutanGaku = entity.getsugakuHyojunFutanGaku;
        this.syokujiTeikyohiSeikyugaku = entity.syokujiTeikyohiSeikyugaku;
        this.kohi1SyokujiTeikyohiSeikyugaku = entity.kohi1SyokujiTeikyohiSeikyugaku;
        this.kohi2SyokujiTeikyohiSeikyugaku = entity.kohi2SyokujiTeikyohiSeikyugaku;
        this.kohi3SyokujiTeikyohiSeikyugaku = entity.kohi3SyokujiTeikyohiSeikyugaku;
        this.nichigakuHyojunFutanGaku = entity.nichigakuHyojunFutanGaku;
        this.atoKihonTeikyoTanka = entity.atoKihonTeikyoTanka;
        this.atoTokubestuTeikyoTanka = entity.atoTokubestuTeikyoTanka;
        this.atoSyokujiTeikyohiSeikyugaku = entity.atoSyokujiTeikyohiSeikyugaku;
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
        return super.toMd5(kokanJohoShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, jigyoshoNo, toshiNo, kihonTeikyoNissu, kihonTeikyoTanka, kihonTeikyoKingaku, tokubestuTeikyoNissu, tokubestuTeikyoTanka, tokubestuTeikyoKingaku, syokujiTeikyoNissu, kohi1SyokujiTeikyoNissu, kohi2SyokujiTeikyoNissu, kohi3SyokujiTeikyoNissu, syokujiTeikyohiTotal, getsugakuHyojunFutanGaku, syokujiTeikyohiSeikyugaku, kohi1SyokujiTeikyohiSeikyugaku, kohi2SyokujiTeikyohiSeikyugaku, kohi3SyokujiTeikyohiSeikyugaku, nichigakuHyojunFutanGaku, atoKihonTeikyoTanka, atoTokubestuTeikyoTanka, atoSyokujiTeikyohiSeikyugaku, saishinsaKaisu, kagoKaisu, shinsaYM, seiriNo, torikomiYM);
    }

// </editor-fold>
}
