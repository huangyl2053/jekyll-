package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;

/**
 * 過誤決定集計テーブルのエンティティクラスです。
 */
public class DbT3060KagoKetteiShukeiEntity extends DbTableEntityBase<DbT3060KagoKetteiShukeiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3060KagoKetteiShukei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYearMonth toriatsukaiYM;
    @PrimaryKey
    private RString hokenshaKubun;
    @PrimaryKey
    private Decimal rirekiNo;
    private int kaigoKyufuhiKensu;
    private Decimal kaigoKyufuhiTanisu;
    private Decimal kaigoKyufuhiFutangaku;
    private int kogakuServicehiKensu;
    private Decimal kogakuServicehiTanisu;
    private Decimal kogakuServicehiFutangaku;
    private int tokuteiNyushoshaServicehiKensu;
    private Decimal tokuteiNyushoshaServicehiTanisu;
    private Decimal tokuteiNyushoshaServicehiFutangaku;
    private RString kohiFutanshaNo;
    private FlexibleDate sakuseiYMD;
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
     * 取扱年月のgetメソッドです。
     * <br/>
     * <br/>連合会が取扱った年月
     *
     * @return 取扱年月
     */
    public FlexibleYearMonth getToriatsukaiYM() {
        return toriatsukaiYM;
    }

    /**
     * 取扱年月のsetメソッドです。
     * <br/>
     * <br/>連合会が取扱った年月
     *
     * @param toriatsukaiYM 取扱年月
     */
    public void setToriatsukaiYM(FlexibleYearMonth toriatsukaiYM) {
        this.toriatsukaiYM = toriatsukaiYM;
    }

    /**
     * 保険者区分のgetメソッドです。
     * <br/>
     * <br/>1：保険者
     *
     * <br/>2：公費負担者
     *
     * <br/>3：総合事業費(経過措置)保険者
     *
     * <br/>4：総合事業費保険者
     *
     * <br/>5：総合事業費公費負担者
     *
     * @return 保険者区分
     */
    public RString getHokenshaKubun() {
        return hokenshaKubun;
    }

    /**
     * 保険者区分のsetメソッドです。
     * <br/>
     * <br/>1：保険者
     *
     * <br/>2：公費負担者
     *
     * <br/>3：総合事業費(経過措置)保険者
     *
     * <br/>4：総合事業費保険者
     *
     * <br/>5：総合事業費公費負担者
     *
     * @param hokenshaKubun 保険者区分
     */
    public void setHokenshaKubun(RString hokenshaKubun) {
        this.hokenshaKubun = hokenshaKubun;
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
     * 介護給付費件数のgetメソッドです。
     *
     * @return 介護給付費件数
     */
    public int getKaigoKyufuhiKensu() {
        return kaigoKyufuhiKensu;
    }

    /**
     * 介護給付費件数のsetメソッドです。
     *
     * @param kaigoKyufuhiKensu 介護給付費件数
     */
    public void setKaigoKyufuhiKensu(int kaigoKyufuhiKensu) {
        this.kaigoKyufuhiKensu = kaigoKyufuhiKensu;
    }

    /**
     * 介護給付費単位数のgetメソッドです。
     *
     * @return 介護給付費単位数
     */
    public Decimal getKaigoKyufuhiTanisu() {
        return kaigoKyufuhiTanisu;
    }

    /**
     * 介護給付費単位数のsetメソッドです。
     *
     * @param kaigoKyufuhiTanisu 介護給付費単位数
     */
    public void setKaigoKyufuhiTanisu(Decimal kaigoKyufuhiTanisu) {
        this.kaigoKyufuhiTanisu = kaigoKyufuhiTanisu;
    }

    /**
     * 介護給付費保険者負担額のgetメソッドです。
     * <br/>
     * <br/>公費（保険者区分=2、5）の場合、'公費負担額
     *
     * @return 介護給付費保険者負担額
     */
    public Decimal getKaigoKyufuhiFutangaku() {
        return kaigoKyufuhiFutangaku;
    }

    /**
     * 介護給付費保険者負担額のsetメソッドです。
     * <br/>
     * <br/>公費（保険者区分=2、5）の場合、'公費負担額
     *
     * @param kaigoKyufuhiFutangaku 介護給付費保険者負担額
     */
    public void setKaigoKyufuhiFutangaku(Decimal kaigoKyufuhiFutangaku) {
        this.kaigoKyufuhiFutangaku = kaigoKyufuhiFutangaku;
    }

    /**
     * 高額介護サービス費件数のgetメソッドです。
     *
     * @return 高額介護サービス費件数
     */
    public int getKogakuServicehiKensu() {
        return kogakuServicehiKensu;
    }

    /**
     * 高額介護サービス費件数のsetメソッドです。
     *
     * @param kogakuServicehiKensu 高額介護サービス費件数
     */
    public void setKogakuServicehiKensu(int kogakuServicehiKensu) {
        this.kogakuServicehiKensu = kogakuServicehiKensu;
    }

    /**
     * 高額介護サービス費単位数のgetメソッドです。
     *
     * @return 高額介護サービス費単位数
     */
    public Decimal getKogakuServicehiTanisu() {
        return kogakuServicehiTanisu;
    }

    /**
     * 高額介護サービス費単位数のsetメソッドです。
     *
     * @param kogakuServicehiTanisu 高額介護サービス費単位数
     */
    public void setKogakuServicehiTanisu(Decimal kogakuServicehiTanisu) {
        this.kogakuServicehiTanisu = kogakuServicehiTanisu;
    }

    /**
     * 高額介護サービス費保険者負担額のgetメソッドです。
     * <br/>
     * <br/>公費（保険者区分=2、5）の場合、'公費負担額
     *
     * @return 高額介護サービス費保険者負担額
     */
    public Decimal getKogakuServicehiFutangaku() {
        return kogakuServicehiFutangaku;
    }

    /**
     * 高額介護サービス費保険者負担額のsetメソッドです。
     * <br/>
     * <br/>公費（保険者区分=2、5）の場合、'公費負担額
     *
     * @param kogakuServicehiFutangaku 高額介護サービス費保険者負担額
     */
    public void setKogakuServicehiFutangaku(Decimal kogakuServicehiFutangaku) {
        this.kogakuServicehiFutangaku = kogakuServicehiFutangaku;
    }

    /**
     * 特定入所者介護サービス費等件数のgetメソッドです。
     *
     * @return 特定入所者介護サービス費等件数
     */
    public int getTokuteiNyushoshaServicehiKensu() {
        return tokuteiNyushoshaServicehiKensu;
    }

    /**
     * 特定入所者介護サービス費等件数のsetメソッドです。
     *
     * @param tokuteiNyushoshaServicehiKensu 特定入所者介護サービス費等件数
     */
    public void setTokuteiNyushoshaServicehiKensu(int tokuteiNyushoshaServicehiKensu) {
        this.tokuteiNyushoshaServicehiKensu = tokuteiNyushoshaServicehiKensu;
    }

    /**
     * 特定入所者介護サービス費等費用額のgetメソッドです。
     *
     * @return 特定入所者介護サービス費等費用額
     */
    public Decimal getTokuteiNyushoshaServicehiTanisu() {
        return tokuteiNyushoshaServicehiTanisu;
    }

    /**
     * 特定入所者介護サービス費等費用額のsetメソッドです。
     *
     * @param tokuteiNyushoshaServicehiTanisu 特定入所者介護サービス費等費用額
     */
    public void setTokuteiNyushoshaServicehiTanisu(Decimal tokuteiNyushoshaServicehiTanisu) {
        this.tokuteiNyushoshaServicehiTanisu = tokuteiNyushoshaServicehiTanisu;
    }

    /**
     * 特定入所者介護サービス費等保険者負担額のgetメソッドです。
     * <br/>
     * <br/>公費（保険者区分=2、5）の場合、'公費負担額
     *
     * @return 特定入所者介護サービス費等保険者負担額
     */
    public Decimal getTokuteiNyushoshaServicehiFutangaku() {
        return tokuteiNyushoshaServicehiFutangaku;
    }

    /**
     * 特定入所者介護サービス費等保険者負担額のsetメソッドです。
     * <br/>
     * <br/>公費（保険者区分=2、5）の場合、'公費負担額
     *
     * @param tokuteiNyushoshaServicehiFutangaku 特定入所者介護サービス費等保険者負担額
     */
    public void setTokuteiNyushoshaServicehiFutangaku(Decimal tokuteiNyushoshaServicehiFutangaku) {
        this.tokuteiNyushoshaServicehiFutangaku = tokuteiNyushoshaServicehiFutangaku;
    }

    /**
     * 公費負担者番号のgetメソッドです。
     * <br/>
     * <br/>保険者区分=1のとき：証記載保険者番号（上６桁）
     *
     * <br/>保険者区分=2のとき：公費負担者番号
     *
     * <br/>保険者区分=3のとき：証記載保険者番号（上６桁）
     *
     * <br/>保険者区分=4のとき：証記載保険者番号（上６桁）
     *
     * <br/>保険者区分=5のとき：公費負担者番号
     *
     * @return 公費負担者番号
     */
    public RString getKohiFutanshaNo() {
        return kohiFutanshaNo;
    }

    /**
     * 公費負担者番号のsetメソッドです。
     * <br/>
     * <br/>保険者区分=1のとき：証記載保険者番号（上６桁）
     *
     * <br/>保険者区分=2のとき：公費負担者番号
     *
     * <br/>保険者区分=3のとき：証記載保険者番号（上６桁）
     *
     * <br/>保険者区分=4のとき：証記載保険者番号（上６桁）
     *
     * <br/>保険者区分=5のとき：公費負担者番号
     *
     * @param kohiFutanshaNo 公費負担者番号
     */
    public void setKohiFutanshaNo(RString kohiFutanshaNo) {
        this.kohiFutanshaNo = kohiFutanshaNo;
    }

    /**
     * 作成年月日のgetメソッドです。
     *
     * @return 作成年月日
     */
    public FlexibleDate getSakuseiYMD() {
        return sakuseiYMD;
    }

    /**
     * 作成年月日のsetメソッドです。
     *
     * @param sakuseiYMD 作成年月日
     */
    public void setSakuseiYMD(FlexibleDate sakuseiYMD) {
        this.sakuseiYMD = sakuseiYMD;
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
     * このエンティティの主キーが他の{@literal DbT3060KagoKetteiShukeiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3060KagoKetteiShukeiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3060KagoKetteiShukeiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.toriatsukaiYM, other.toriatsukaiYM)) {
            return false;
        }
        if (!Objects.equals(this.hokenshaKubun, other.hokenshaKubun)) {
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
    public void shallowCopy(DbT3060KagoKetteiShukeiEntity entity) {
        this.toriatsukaiYM = entity.toriatsukaiYM;
        this.hokenshaKubun = entity.hokenshaKubun;
        this.rirekiNo = entity.rirekiNo;
        this.kaigoKyufuhiKensu = entity.kaigoKyufuhiKensu;
        this.kaigoKyufuhiTanisu = entity.kaigoKyufuhiTanisu;
        this.kaigoKyufuhiFutangaku = entity.kaigoKyufuhiFutangaku;
        this.kogakuServicehiKensu = entity.kogakuServicehiKensu;
        this.kogakuServicehiTanisu = entity.kogakuServicehiTanisu;
        this.kogakuServicehiFutangaku = entity.kogakuServicehiFutangaku;
        this.tokuteiNyushoshaServicehiKensu = entity.tokuteiNyushoshaServicehiKensu;
        this.tokuteiNyushoshaServicehiTanisu = entity.tokuteiNyushoshaServicehiTanisu;
        this.tokuteiNyushoshaServicehiFutangaku = entity.tokuteiNyushoshaServicehiFutangaku;
        this.kohiFutanshaNo = entity.kohiFutanshaNo;
        this.sakuseiYMD = entity.sakuseiYMD;
        this.torikomiYM = entity.torikomiYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(toriatsukaiYM, hokenshaKubun, rirekiNo, kaigoKyufuhiKensu, kaigoKyufuhiTanisu, kaigoKyufuhiFutangaku, kogakuServicehiKensu, kogakuServicehiTanisu, kogakuServicehiFutangaku, tokuteiNyushoshaServicehiKensu, tokuteiNyushoshaServicehiTanisu, tokuteiNyushoshaServicehiFutangaku, kohiFutanshaNo, sakuseiYMD, torikomiYM);
    }

// </editor-fold>
}
