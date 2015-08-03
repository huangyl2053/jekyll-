package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import java.util.Objects;

/**
 * 給付実績食事費用テーブルのエンティティクラスです。
 */
public class DbT3022KyufujissekiShokujiHiyoEntity extends DbTableEntityBase<DbT3022KyufujissekiShokujiHiyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
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
    private DbUDD009KokanShikibetsuNo kokanJohoShikibetsuNo;
    @PrimaryKey
    private DbUDD010NyuryokuShikibetsuNo inputShikibetsuNo;
    @PrimaryKey
    private RString recodeShubetsuCode;
    @PrimaryKey
    private DbUDD003HokenshaNo shokisaiHokenshaNo;
    @PrimaryKey
    private DbUDD002HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private DbUDD004JigyoshaNo jigyoshoNo;
    @PrimaryKey
    private RString toshiNo;
    private int kihonTeikyoNissu;
    private int kihonTeikyoTanka;
    private int kihonTeikyoKingaku;
    private int tokubestuTeikyoNissu;
    private int tokubestuTeikyoTanka;
    private int tokubestuTeikyoKingaku;
    private int syokujiTeikyoNissu;
    private int kohi1SyokujiTeikyoNissu;
    private int kohi2SyokujiTeikyoNissu;
    private int kohi3SyokujiTeikyoNissu;
    private int syokujiTeikyohiTotal;
    private int getsugakuHyojunFutanGaku;
    private int syokujiTeikyohiSeikyugaku;
    private int kohi1SyokujiTeikyohiSeikyugaku;
    private int kohi2SyokujiTeikyohiSeikyugaku;
    private int kohi3SyokujiTeikyohiSeikyugaku;
    private int nichigakuHyojunFutanGaku;
    private int atoKihonTeikyoTanka;
    private int atoTokubestuTeikyoTanka;
    private int atoSyokujiTeikyohiSeikyugaku;
    private int saishinsaKaisu;
    private int kagoKaisu;
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
    public DbUDD009KokanShikibetsuNo getKokanJohoShikibetsuNo() {
        return kokanJohoShikibetsuNo;
    }

    /**
     * 交換情報識別番号のsetメソッドです。
     * 
     * @param kokanJohoShikibetsuNo 交換情報識別番号
     */
    public void setKokanJohoShikibetsuNo(DbUDD009KokanShikibetsuNo kokanJohoShikibetsuNo) {
        this.kokanJohoShikibetsuNo = kokanJohoShikibetsuNo;
    }

    /**
     * 入力識別番号のgetメソッドです。
     * 
     * @return 入力識別番号
     */
    public DbUDD010NyuryokuShikibetsuNo getInputShikibetsuNo() {
        return inputShikibetsuNo;
    }

    /**
     * 入力識別番号のsetメソッドです。
     * 
     * @param inputShikibetsuNo 入力識別番号
     */
    public void setInputShikibetsuNo(DbUDD010NyuryokuShikibetsuNo inputShikibetsuNo) {
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
    public DbUDD003HokenshaNo getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     * 
     * @param shokisaiHokenshaNo 証記載保険者番号
     */
    public void setShokisaiHokenshaNo(DbUDD003HokenshaNo shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
    }

    /**
     * 被保険者番号のgetメソッドです。
     * 
     * @return 被保険者番号
     */
    public DbUDD002HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * 
     * @param hiHokenshaNo 被保険者番号
     */
    public void setHiHokenshaNo(DbUDD002HihokenshaNo hiHokenshaNo) {
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
    public DbUDD004JigyoshaNo getJigyoshoNo() {
        return jigyoshoNo;
    }

    /**
     * 事業所番号のsetメソッドです。
     * 
     * @param jigyoshoNo 事業所番号
     */
    public void setJigyoshoNo(DbUDD004JigyoshaNo jigyoshoNo) {
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
    public int getKihonTeikyoNissu() {
        return kihonTeikyoNissu;
    }

    /**
     * 基本・提供日数のsetメソッドです。
     * 
     * @param kihonTeikyoNissu 基本・提供日数
     */
    public void setKihonTeikyoNissu(int kihonTeikyoNissu) {
        this.kihonTeikyoNissu = kihonTeikyoNissu;
    }

    /**
     * 基本・提供単価のgetメソッドです。
     * 
     * @return 基本・提供単価
     */
    public int getKihonTeikyoTanka() {
        return kihonTeikyoTanka;
    }

    /**
     * 基本・提供単価のsetメソッドです。
     * 
     * @param kihonTeikyoTanka 基本・提供単価
     */
    public void setKihonTeikyoTanka(int kihonTeikyoTanka) {
        this.kihonTeikyoTanka = kihonTeikyoTanka;
    }

    /**
     * 基本・提供金額のgetメソッドです。
     * 
     * @return 基本・提供金額
     */
    public int getKihonTeikyoKingaku() {
        return kihonTeikyoKingaku;
    }

    /**
     * 基本・提供金額のsetメソッドです。
     * 
     * @param kihonTeikyoKingaku 基本・提供金額
     */
    public void setKihonTeikyoKingaku(int kihonTeikyoKingaku) {
        this.kihonTeikyoKingaku = kihonTeikyoKingaku;
    }

    /**
     * 特別・提供日数のgetメソッドです。
     * 
     * @return 特別・提供日数
     */
    public int getTokubestuTeikyoNissu() {
        return tokubestuTeikyoNissu;
    }

    /**
     * 特別・提供日数のsetメソッドです。
     * 
     * @param tokubestuTeikyoNissu 特別・提供日数
     */
    public void setTokubestuTeikyoNissu(int tokubestuTeikyoNissu) {
        this.tokubestuTeikyoNissu = tokubestuTeikyoNissu;
    }

    /**
     * 特別・提供単価のgetメソッドです。
     * 
     * @return 特別・提供単価
     */
    public int getTokubestuTeikyoTanka() {
        return tokubestuTeikyoTanka;
    }

    /**
     * 特別・提供単価のsetメソッドです。
     * 
     * @param tokubestuTeikyoTanka 特別・提供単価
     */
    public void setTokubestuTeikyoTanka(int tokubestuTeikyoTanka) {
        this.tokubestuTeikyoTanka = tokubestuTeikyoTanka;
    }

    /**
     * 特別・提供金額のgetメソッドです。
     * 
     * @return 特別・提供金額
     */
    public int getTokubestuTeikyoKingaku() {
        return tokubestuTeikyoKingaku;
    }

    /**
     * 特別・提供金額のsetメソッドです。
     * 
     * @param tokubestuTeikyoKingaku 特別・提供金額
     */
    public void setTokubestuTeikyoKingaku(int tokubestuTeikyoKingaku) {
        this.tokubestuTeikyoKingaku = tokubestuTeikyoKingaku;
    }

    /**
     * 食事提供延べ日数のgetメソッドです。
     * 
     * @return 食事提供延べ日数
     */
    public int getSyokujiTeikyoNissu() {
        return syokujiTeikyoNissu;
    }

    /**
     * 食事提供延べ日数のsetメソッドです。
     * 
     * @param syokujiTeikyoNissu 食事提供延べ日数
     */
    public void setSyokujiTeikyoNissu(int syokujiTeikyoNissu) {
        this.syokujiTeikyoNissu = syokujiTeikyoNissu;
    }

    /**
     * 公費１対象食事提供延べ日数のgetメソッドです。
     * 
     * @return 公費１対象食事提供延べ日数
     */
    public int getKohi1SyokujiTeikyoNissu() {
        return kohi1SyokujiTeikyoNissu;
    }

    /**
     * 公費１対象食事提供延べ日数のsetメソッドです。
     * 
     * @param kohi1SyokujiTeikyoNissu 公費１対象食事提供延べ日数
     */
    public void setKohi1SyokujiTeikyoNissu(int kohi1SyokujiTeikyoNissu) {
        this.kohi1SyokujiTeikyoNissu = kohi1SyokujiTeikyoNissu;
    }

    /**
     * 公費２対象食事提供延べ日数のgetメソッドです。
     * 
     * @return 公費２対象食事提供延べ日数
     */
    public int getKohi2SyokujiTeikyoNissu() {
        return kohi2SyokujiTeikyoNissu;
    }

    /**
     * 公費２対象食事提供延べ日数のsetメソッドです。
     * 
     * @param kohi2SyokujiTeikyoNissu 公費２対象食事提供延べ日数
     */
    public void setKohi2SyokujiTeikyoNissu(int kohi2SyokujiTeikyoNissu) {
        this.kohi2SyokujiTeikyoNissu = kohi2SyokujiTeikyoNissu;
    }

    /**
     * 公費３対象食事提供延べ日数のgetメソッドです。
     * 
     * @return 公費３対象食事提供延べ日数
     */
    public int getKohi3SyokujiTeikyoNissu() {
        return kohi3SyokujiTeikyoNissu;
    }

    /**
     * 公費３対象食事提供延べ日数のsetメソッドです。
     * 
     * @param kohi3SyokujiTeikyoNissu 公費３対象食事提供延べ日数
     */
    public void setKohi3SyokujiTeikyoNissu(int kohi3SyokujiTeikyoNissu) {
        this.kohi3SyokujiTeikyoNissu = kohi3SyokujiTeikyoNissu;
    }

    /**
     * 食事提供費合計のgetメソッドです。
     * 
     * @return 食事提供費合計
     */
    public int getSyokujiTeikyohiTotal() {
        return syokujiTeikyohiTotal;
    }

    /**
     * 食事提供費合計のsetメソッドです。
     * 
     * @param syokujiTeikyohiTotal 食事提供費合計
     */
    public void setSyokujiTeikyohiTotal(int syokujiTeikyohiTotal) {
        this.syokujiTeikyohiTotal = syokujiTeikyohiTotal;
    }

    /**
     * 標準負担額（月額）のgetメソッドです。
     * 
     * @return 標準負担額（月額）
     */
    public int getGetsugakuHyojunFutanGaku() {
        return getsugakuHyojunFutanGaku;
    }

    /**
     * 標準負担額（月額）のsetメソッドです。
     * 
     * @param getsugakuHyojunFutanGaku 標準負担額（月額）
     */
    public void setGetsugakuHyojunFutanGaku(int getsugakuHyojunFutanGaku) {
        this.getsugakuHyojunFutanGaku = getsugakuHyojunFutanGaku;
    }

    /**
     * 食事提供費請求額のgetメソッドです。
     * 
     * @return 食事提供費請求額
     */
    public int getSyokujiTeikyohiSeikyugaku() {
        return syokujiTeikyohiSeikyugaku;
    }

    /**
     * 食事提供費請求額のsetメソッドです。
     * 
     * @param syokujiTeikyohiSeikyugaku 食事提供費請求額
     */
    public void setSyokujiTeikyohiSeikyugaku(int syokujiTeikyohiSeikyugaku) {
        this.syokujiTeikyohiSeikyugaku = syokujiTeikyohiSeikyugaku;
    }

    /**
     * 公費１食事提供費請求額のgetメソッドです。
     * 
     * @return 公費１食事提供費請求額
     */
    public int getKohi1SyokujiTeikyohiSeikyugaku() {
        return kohi1SyokujiTeikyohiSeikyugaku;
    }

    /**
     * 公費１食事提供費請求額のsetメソッドです。
     * 
     * @param kohi1SyokujiTeikyohiSeikyugaku 公費１食事提供費請求額
     */
    public void setKohi1SyokujiTeikyohiSeikyugaku(int kohi1SyokujiTeikyohiSeikyugaku) {
        this.kohi1SyokujiTeikyohiSeikyugaku = kohi1SyokujiTeikyohiSeikyugaku;
    }

    /**
     * 公費２食事提供費請求額のgetメソッドです。
     * 
     * @return 公費２食事提供費請求額
     */
    public int getKohi2SyokujiTeikyohiSeikyugaku() {
        return kohi2SyokujiTeikyohiSeikyugaku;
    }

    /**
     * 公費２食事提供費請求額のsetメソッドです。
     * 
     * @param kohi2SyokujiTeikyohiSeikyugaku 公費２食事提供費請求額
     */
    public void setKohi2SyokujiTeikyohiSeikyugaku(int kohi2SyokujiTeikyohiSeikyugaku) {
        this.kohi2SyokujiTeikyohiSeikyugaku = kohi2SyokujiTeikyohiSeikyugaku;
    }

    /**
     * 公費３食事提供費請求額のgetメソッドです。
     * 
     * @return 公費３食事提供費請求額
     */
    public int getKohi3SyokujiTeikyohiSeikyugaku() {
        return kohi3SyokujiTeikyohiSeikyugaku;
    }

    /**
     * 公費３食事提供費請求額のsetメソッドです。
     * 
     * @param kohi3SyokujiTeikyohiSeikyugaku 公費３食事提供費請求額
     */
    public void setKohi3SyokujiTeikyohiSeikyugaku(int kohi3SyokujiTeikyohiSeikyugaku) {
        this.kohi3SyokujiTeikyohiSeikyugaku = kohi3SyokujiTeikyohiSeikyugaku;
    }

    /**
     * 標準負担額（日額）のgetメソッドです。
     * 
     * @return 標準負担額（日額）
     */
    public int getNichigakuHyojunFutanGaku() {
        return nichigakuHyojunFutanGaku;
    }

    /**
     * 標準負担額（日額）のsetメソッドです。
     * 
     * @param nichigakuHyojunFutanGaku 標準負担額（日額）
     */
    public void setNichigakuHyojunFutanGaku(int nichigakuHyojunFutanGaku) {
        this.nichigakuHyojunFutanGaku = nichigakuHyojunFutanGaku;
    }

    /**
     * 後・基本食提供費用提供単価のgetメソッドです。
     * 
     * @return 後・基本食提供費用提供単価
     */
    public int getAtoKihonTeikyoTanka() {
        return atoKihonTeikyoTanka;
    }

    /**
     * 後・基本食提供費用提供単価のsetメソッドです。
     * 
     * @param atoKihonTeikyoTanka 後・基本食提供費用提供単価
     */
    public void setAtoKihonTeikyoTanka(int atoKihonTeikyoTanka) {
        this.atoKihonTeikyoTanka = atoKihonTeikyoTanka;
    }

    /**
     * 後・特別食提供費用提供単価のgetメソッドです。
     * 
     * @return 後・特別食提供費用提供単価
     */
    public int getAtoTokubestuTeikyoTanka() {
        return atoTokubestuTeikyoTanka;
    }

    /**
     * 後・特別食提供費用提供単価のsetメソッドです。
     * 
     * @param atoTokubestuTeikyoTanka 後・特別食提供費用提供単価
     */
    public void setAtoTokubestuTeikyoTanka(int atoTokubestuTeikyoTanka) {
        this.atoTokubestuTeikyoTanka = atoTokubestuTeikyoTanka;
    }

    /**
     * 後・食事提供費請求額のgetメソッドです。
     * 
     * @return 後・食事提供費請求額
     */
    public int getAtoSyokujiTeikyohiSeikyugaku() {
        return atoSyokujiTeikyohiSeikyugaku;
    }

    /**
     * 後・食事提供費請求額のsetメソッドです。
     * 
     * @param atoSyokujiTeikyohiSeikyugaku 後・食事提供費請求額
     */
    public void setAtoSyokujiTeikyohiSeikyugaku(int atoSyokujiTeikyohiSeikyugaku) {
        this.atoSyokujiTeikyohiSeikyugaku = atoSyokujiTeikyohiSeikyugaku;
    }

    /**
     * 再審査回数のgetメソッドです。
     * 
     * @return 再審査回数
     */
    public int getSaishinsaKaisu() {
        return saishinsaKaisu;
    }

    /**
     * 再審査回数のsetメソッドです。
     * 
     * @param saishinsaKaisu 再審査回数
     */
    public void setSaishinsaKaisu(int saishinsaKaisu) {
        this.saishinsaKaisu = saishinsaKaisu;
    }

    /**
     * 過誤回数のgetメソッドです。
     * 
     * @return 過誤回数
     */
    public int getKagoKaisu() {
        return kagoKaisu;
    }

    /**
     * 過誤回数のsetメソッドです。
     * 
     * @param kagoKaisu 過誤回数
     */
    public void setKagoKaisu(int kagoKaisu) {
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
     * @@return 
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
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kokanJohoShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, jigyoshoNo, toshiNo, kihonTeikyoNissu, kihonTeikyoTanka, kihonTeikyoKingaku, tokubestuTeikyoNissu, tokubestuTeikyoTanka, tokubestuTeikyoKingaku, syokujiTeikyoNissu, kohi1SyokujiTeikyoNissu, kohi2SyokujiTeikyoNissu, kohi3SyokujiTeikyoNissu, syokujiTeikyohiTotal, getsugakuHyojunFutanGaku, syokujiTeikyohiSeikyugaku, kohi1SyokujiTeikyohiSeikyugaku, kohi2SyokujiTeikyohiSeikyugaku, kohi3SyokujiTeikyohiSeikyugaku, nichigakuHyojunFutanGaku, atoKihonTeikyoTanka, atoTokubestuTeikyoTanka, atoSyokujiTeikyohiSeikyugaku, saishinsaKaisu, kagoKaisu, shinsaYM, seiriNo, torikomiYM);
    }

// </editor-fold>
}
