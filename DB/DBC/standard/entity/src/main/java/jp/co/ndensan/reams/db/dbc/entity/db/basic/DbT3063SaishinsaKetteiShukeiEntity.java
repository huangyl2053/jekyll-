package jp.co.ndensan.reams.db.dbc.entity.db.basic;

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
 * 再審査決定集計テーブルのエンティティクラスです。
 */
public class DbT3063SaishinsaKetteiShukeiEntity extends DbTableEntityBase<DbT3063SaishinsaKetteiShukeiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3063SaishinsaKetteiShukei");

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
    private int kaigoKyufuhiSeikyuKensu;
    private Decimal kaigoKyufuhiSeikyuTanisu;
    private Decimal kaigoKyufuhiSeikyuFutangaku;
    private int kaigoKyufuhiKetteiKensu;
    private Decimal kaigoKyufuhiKetteiTanisu;
    private Decimal kaigoKyufuhiKetteiFutangaku;
    private int kaigoKyufuhiChoseiKensu;
    private Decimal kaigoKyufuhiChoseiTanisu;
    private Decimal kaigoKyufuhiChoseiFutangaku;
    private int kogakuKaigoServicehiSeikyuKensu;
    private Decimal kogakuKaigoServicehiSeikyuTanisu;
    private Decimal kogakuKaigoServicehiSeikyuFutangaku;
    private int kogakuKaigoServicehiKetteiKensu;
    private Decimal kogakuKaigoServicehiKetteiTanisu;
    private Decimal kogakuKaigoServicehiKetteiFutangaku;
    private int kogakuKaigoServicehiChoseiKensu;
    private Decimal kogakuKaigoServicehiChoseiTanisu;
    private Decimal kogakuKaigoServicehiChoseiFutangaku;
    private RString kohiFutanshaNo;
    private FlexibleDate sakuseiYMD;
    private RString sinsaiinkaiName;
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
     * <br/>連合会が取扱った年月(ヘッダ情報)
     *
     * @return 取扱年月
     */
    public FlexibleYearMonth getToriatsukaiYM() {
        return toriatsukaiYM;
    }

    /**
     * 取扱年月のsetメソッドです。
     * <br/>
     * <br/>連合会が取扱った年月(ヘッダ情報)
     *
     * @param toriatsukaiYM 取扱年月
     */
    public void setToriatsukaiYM(FlexibleYearMonth toriatsukaiYM) {
        this.toriatsukaiYM = toriatsukaiYM;
    }

    /**
     * 保険者区分のgetメソッドです。
     * <br/>
     * <br/>1：保険者　2：公費負担者
     *
     * <br/>3：総合事業費保険者
     *
     * <br/>4：総合事業費公費負担者
     *
     * @return 保険者区分
     */
    public RString getHokenshaKubun() {
        return hokenshaKubun;
    }

    /**
     * 保険者区分のsetメソッドです。
     * <br/>
     * <br/>1：保険者　2：公費負担者
     *
     * <br/>3：総合事業費保険者
     *
     * <br/>4：総合事業費公費負担者
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
     * 介護給付費・請求・件数のgetメソッドです。
     *
     * @return 介護給付費・請求・件数
     */
    public int getKaigoKyufuhiSeikyuKensu() {
        return kaigoKyufuhiSeikyuKensu;
    }

    /**
     * 介護給付費・請求・件数のsetメソッドです。
     *
     * @param kaigoKyufuhiSeikyuKensu 介護給付費・請求・件数
     */
    public void setKaigoKyufuhiSeikyuKensu(int kaigoKyufuhiSeikyuKensu) {
        this.kaigoKyufuhiSeikyuKensu = kaigoKyufuhiSeikyuKensu;
    }

    /**
     * 介護給付費・請求・単位数のgetメソッドです。
     *
     * @return 介護給付費・請求・単位数
     */
    public Decimal getKaigoKyufuhiSeikyuTanisu() {
        return kaigoKyufuhiSeikyuTanisu;
    }

    /**
     * 介護給付費・請求・単位数のsetメソッドです。
     *
     * @param kaigoKyufuhiSeikyuTanisu 介護給付費・請求・単位数
     */
    public void setKaigoKyufuhiSeikyuTanisu(Decimal kaigoKyufuhiSeikyuTanisu) {
        this.kaigoKyufuhiSeikyuTanisu = kaigoKyufuhiSeikyuTanisu;
    }

    /**
     * 介護給付費・請求・保険者負担額のgetメソッドです。
     * <br/>
     * <br/>公費（保険者区分=2,4）の場合、'公費負担額
     *
     * @return 介護給付費・請求・保険者負担額
     */
    public Decimal getKaigoKyufuhiSeikyuFutangaku() {
        return kaigoKyufuhiSeikyuFutangaku;
    }

    /**
     * 介護給付費・請求・保険者負担額のsetメソッドです。
     * <br/>
     * <br/>公費（保険者区分=2,4）の場合、'公費負担額
     *
     * @param kaigoKyufuhiSeikyuFutangaku 介護給付費・請求・保険者負担額
     */
    public void setKaigoKyufuhiSeikyuFutangaku(Decimal kaigoKyufuhiSeikyuFutangaku) {
        this.kaigoKyufuhiSeikyuFutangaku = kaigoKyufuhiSeikyuFutangaku;
    }

    /**
     * 介護給付費・決定・件数のgetメソッドです。
     *
     * @return 介護給付費・決定・件数
     */
    public int getKaigoKyufuhiKetteiKensu() {
        return kaigoKyufuhiKetteiKensu;
    }

    /**
     * 介護給付費・決定・件数のsetメソッドです。
     *
     * @param kaigoKyufuhiKetteiKensu 介護給付費・決定・件数
     */
    public void setKaigoKyufuhiKetteiKensu(int kaigoKyufuhiKetteiKensu) {
        this.kaigoKyufuhiKetteiKensu = kaigoKyufuhiKetteiKensu;
    }

    /**
     * 介護給付費・決定・単位数のgetメソッドです。
     *
     * @return 介護給付費・決定・単位数
     */
    public Decimal getKaigoKyufuhiKetteiTanisu() {
        return kaigoKyufuhiKetteiTanisu;
    }

    /**
     * 介護給付費・決定・単位数のsetメソッドです。
     *
     * @param kaigoKyufuhiKetteiTanisu 介護給付費・決定・単位数
     */
    public void setKaigoKyufuhiKetteiTanisu(Decimal kaigoKyufuhiKetteiTanisu) {
        this.kaigoKyufuhiKetteiTanisu = kaigoKyufuhiKetteiTanisu;
    }

    /**
     * 介護給付費・決定・保険者負担額のgetメソッドです。
     * <br/>
     * <br/>公費（保険者区分=2,4）の場合、'公費負担額
     *
     * @return 介護給付費・決定・保険者負担額
     */
    public Decimal getKaigoKyufuhiKetteiFutangaku() {
        return kaigoKyufuhiKetteiFutangaku;
    }

    /**
     * 介護給付費・決定・保険者負担額のsetメソッドです。
     * <br/>
     * <br/>公費（保険者区分=2,4）の場合、'公費負担額
     *
     * @param kaigoKyufuhiKetteiFutangaku 介護給付費・決定・保険者負担額
     */
    public void setKaigoKyufuhiKetteiFutangaku(Decimal kaigoKyufuhiKetteiFutangaku) {
        this.kaigoKyufuhiKetteiFutangaku = kaigoKyufuhiKetteiFutangaku;
    }

    /**
     * 介護給付費・調整・件数のgetメソッドです。
     *
     * @return 介護給付費・調整・件数
     */
    public int getKaigoKyufuhiChoseiKensu() {
        return kaigoKyufuhiChoseiKensu;
    }

    /**
     * 介護給付費・調整・件数のsetメソッドです。
     *
     * @param kaigoKyufuhiChoseiKensu 介護給付費・調整・件数
     */
    public void setKaigoKyufuhiChoseiKensu(int kaigoKyufuhiChoseiKensu) {
        this.kaigoKyufuhiChoseiKensu = kaigoKyufuhiChoseiKensu;
    }

    /**
     * 介護給付費・調整・単位数のgetメソッドです。
     *
     * @return 介護給付費・調整・単位数
     */
    public Decimal getKaigoKyufuhiChoseiTanisu() {
        return kaigoKyufuhiChoseiTanisu;
    }

    /**
     * 介護給付費・調整・単位数のsetメソッドです。
     *
     * @param kaigoKyufuhiChoseiTanisu 介護給付費・調整・単位数
     */
    public void setKaigoKyufuhiChoseiTanisu(Decimal kaigoKyufuhiChoseiTanisu) {
        this.kaigoKyufuhiChoseiTanisu = kaigoKyufuhiChoseiTanisu;
    }

    /**
     * 介護給付費・調整・保険者負担額のgetメソッドです。
     * <br/>
     * <br/>未使用、公費（保険者区分=2,4）の場合、'公費負担額
     *
     * @return 介護給付費・調整・保険者負担額
     */
    public Decimal getKaigoKyufuhiChoseiFutangaku() {
        return kaigoKyufuhiChoseiFutangaku;
    }

    /**
     * 介護給付費・調整・保険者負担額のsetメソッドです。
     * <br/>
     * <br/>未使用、公費（保険者区分=2,4）の場合、'公費負担額
     *
     * @param kaigoKyufuhiChoseiFutangaku 介護給付費・調整・保険者負担額
     */
    public void setKaigoKyufuhiChoseiFutangaku(Decimal kaigoKyufuhiChoseiFutangaku) {
        this.kaigoKyufuhiChoseiFutangaku = kaigoKyufuhiChoseiFutangaku;
    }

    /**
     * 高額介護サービス費・請求・件数のgetメソッドです。
     * <br/>
     * <br/>未使用
     *
     * @return 高額介護サービス費・請求・件数
     */
    public int getKogakuKaigoServicehiSeikyuKensu() {
        return kogakuKaigoServicehiSeikyuKensu;
    }

    /**
     * 高額介護サービス費・請求・件数のsetメソッドです。
     * <br/>
     * <br/>未使用
     *
     * @param kogakuKaigoServicehiSeikyuKensu 高額介護サービス費・請求・件数
     */
    public void setKogakuKaigoServicehiSeikyuKensu(int kogakuKaigoServicehiSeikyuKensu) {
        this.kogakuKaigoServicehiSeikyuKensu = kogakuKaigoServicehiSeikyuKensu;
    }

    /**
     * 高額介護サービス費・請求・単位数のgetメソッドです。
     * <br/>
     * <br/>未使用
     *
     * @return 高額介護サービス費・請求・単位数
     */
    public Decimal getKogakuKaigoServicehiSeikyuTanisu() {
        return kogakuKaigoServicehiSeikyuTanisu;
    }

    /**
     * 高額介護サービス費・請求・単位数のsetメソッドです。
     * <br/>
     * <br/>未使用
     *
     * @param kogakuKaigoServicehiSeikyuTanisu 高額介護サービス費・請求・単位数
     */
    public void setKogakuKaigoServicehiSeikyuTanisu(Decimal kogakuKaigoServicehiSeikyuTanisu) {
        this.kogakuKaigoServicehiSeikyuTanisu = kogakuKaigoServicehiSeikyuTanisu;
    }

    /**
     * 高額介護サービス費・請求・保険者負担額のgetメソッドです。
     * <br/>
     * <br/>未使用、公費（保険者区分=2,4）の場合、'公費負担額
     *
     * @return 高額介護サービス費・請求・保険者負担額
     */
    public Decimal getKogakuKaigoServicehiSeikyuFutangaku() {
        return kogakuKaigoServicehiSeikyuFutangaku;
    }

    /**
     * 高額介護サービス費・請求・保険者負担額のsetメソッドです。
     * <br/>
     * <br/>未使用、公費（保険者区分=2,4）の場合、'公費負担額
     *
     * @param kogakuKaigoServicehiSeikyuFutangaku 高額介護サービス費・請求・保険者負担額
     */
    public void setKogakuKaigoServicehiSeikyuFutangaku(Decimal kogakuKaigoServicehiSeikyuFutangaku) {
        this.kogakuKaigoServicehiSeikyuFutangaku = kogakuKaigoServicehiSeikyuFutangaku;
    }

    /**
     * 高額介護サービス費・決定・件数のgetメソッドです。
     * <br/>
     * <br/>未使用
     *
     * @return 高額介護サービス費・決定・件数
     */
    public int getKogakuKaigoServicehiKetteiKensu() {
        return kogakuKaigoServicehiKetteiKensu;
    }

    /**
     * 高額介護サービス費・決定・件数のsetメソッドです。
     * <br/>
     * <br/>未使用
     *
     * @param kogakuKaigoServicehiKetteiKensu 高額介護サービス費・決定・件数
     */
    public void setKogakuKaigoServicehiKetteiKensu(int kogakuKaigoServicehiKetteiKensu) {
        this.kogakuKaigoServicehiKetteiKensu = kogakuKaigoServicehiKetteiKensu;
    }

    /**
     * 高額介護サービス費・決定・単位数のgetメソッドです。
     * <br/>
     * <br/>未使用
     *
     * @return 高額介護サービス費・決定・単位数
     */
    public Decimal getKogakuKaigoServicehiKetteiTanisu() {
        return kogakuKaigoServicehiKetteiTanisu;
    }

    /**
     * 高額介護サービス費・決定・単位数のsetメソッドです。
     * <br/>
     * <br/>未使用
     *
     * @param kogakuKaigoServicehiKetteiTanisu 高額介護サービス費・決定・単位数
     */
    public void setKogakuKaigoServicehiKetteiTanisu(Decimal kogakuKaigoServicehiKetteiTanisu) {
        this.kogakuKaigoServicehiKetteiTanisu = kogakuKaigoServicehiKetteiTanisu;
    }

    /**
     * 高額介護サービス費・決定・保険者負担額のgetメソッドです。
     * <br/>
     * <br/>未使用、公費（保険者区分=2,4）の場合、'公費負担額
     *
     * @return 高額介護サービス費・決定・保険者負担額
     */
    public Decimal getKogakuKaigoServicehiKetteiFutangaku() {
        return kogakuKaigoServicehiKetteiFutangaku;
    }

    /**
     * 高額介護サービス費・決定・保険者負担額のsetメソッドです。
     * <br/>
     * <br/>未使用、公費（保険者区分=2,4）の場合、'公費負担額
     *
     * @param kogakuKaigoServicehiKetteiFutangaku 高額介護サービス費・決定・保険者負担額
     */
    public void setKogakuKaigoServicehiKetteiFutangaku(Decimal kogakuKaigoServicehiKetteiFutangaku) {
        this.kogakuKaigoServicehiKetteiFutangaku = kogakuKaigoServicehiKetteiFutangaku;
    }

    /**
     * 高額介護サービス費・調整・件数のgetメソッドです。
     * <br/>
     * <br/>未使用
     *
     * @return 高額介護サービス費・調整・件数
     */
    public int getKogakuKaigoServicehiChoseiKensu() {
        return kogakuKaigoServicehiChoseiKensu;
    }

    /**
     * 高額介護サービス費・調整・件数のsetメソッドです。
     * <br/>
     * <br/>未使用
     *
     * @param kogakuKaigoServicehiChoseiKensu 高額介護サービス費・調整・件数
     */
    public void setKogakuKaigoServicehiChoseiKensu(int kogakuKaigoServicehiChoseiKensu) {
        this.kogakuKaigoServicehiChoseiKensu = kogakuKaigoServicehiChoseiKensu;
    }

    /**
     * 高額介護サービス費・調整・単位数のgetメソッドです。
     * <br/>
     * <br/>未使用
     *
     * @return 高額介護サービス費・調整・単位数
     */
    public Decimal getKogakuKaigoServicehiChoseiTanisu() {
        return kogakuKaigoServicehiChoseiTanisu;
    }

    /**
     * 高額介護サービス費・調整・単位数のsetメソッドです。
     * <br/>
     * <br/>未使用
     *
     * @param kogakuKaigoServicehiChoseiTanisu 高額介護サービス費・調整・単位数
     */
    public void setKogakuKaigoServicehiChoseiTanisu(Decimal kogakuKaigoServicehiChoseiTanisu) {
        this.kogakuKaigoServicehiChoseiTanisu = kogakuKaigoServicehiChoseiTanisu;
    }

    /**
     * 高額介護サービス費・調整・保険者負担額のgetメソッドです。
     * <br/>
     * <br/>未使用、公費（保険者区分=2,4）の場合、'公費負担額
     *
     * @return 高額介護サービス費・調整・保険者負担額
     */
    public Decimal getKogakuKaigoServicehiChoseiFutangaku() {
        return kogakuKaigoServicehiChoseiFutangaku;
    }

    /**
     * 高額介護サービス費・調整・保険者負担額のsetメソッドです。
     * <br/>
     * <br/>未使用、公費（保険者区分=2,4）の場合、'公費負担額
     *
     * @param kogakuKaigoServicehiChoseiFutangaku 高額介護サービス費・調整・保険者負担額
     */
    public void setKogakuKaigoServicehiChoseiFutangaku(Decimal kogakuKaigoServicehiChoseiFutangaku) {
        this.kogakuKaigoServicehiChoseiFutangaku = kogakuKaigoServicehiChoseiFutangaku;
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
     * <br/>保険者区分=4のとき：公費負担者番号
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
     * <br/>保険者区分=4のとき：公費負担者番号
     *
     * @param kohiFutanshaNo 公費負担者番号
     */
    public void setKohiFutanshaNo(RString kohiFutanshaNo) {
        this.kohiFutanshaNo = kohiFutanshaNo;
    }

    /**
     * 作成年月日のgetメソッドです。
     * <br/>
     * <br/>ヘッダ情報
     *
     * @return 作成年月日
     */
    public FlexibleDate getSakuseiYMD() {
        return sakuseiYMD;
    }

    /**
     * 作成年月日のsetメソッドです。
     * <br/>
     * <br/>ヘッダ情報
     *
     * @param sakuseiYMD 作成年月日
     */
    public void setSakuseiYMD(FlexibleDate sakuseiYMD) {
        this.sakuseiYMD = sakuseiYMD;
    }

    /**
     * 審査委員会名のgetメソッドです。
     * <br/>
     * <br/>ヘッダ情報
     *
     * @return 審査委員会名
     */
    public RString getSinsaiinkaiName() {
        return sinsaiinkaiName;
    }

    /**
     * 審査委員会名のsetメソッドです。
     * <br/>
     * <br/>ヘッダ情報
     *
     * @param sinsaiinkaiName 審査委員会名
     */
    public void setSinsaiinkaiName(RString sinsaiinkaiName) {
        this.sinsaiinkaiName = sinsaiinkaiName;
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
     * このエンティティの主キーが他の{@literal DbT3063SaishinsaKetteiShukeiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3063SaishinsaKetteiShukeiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3063SaishinsaKetteiShukeiEntity other) {
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
    public void shallowCopy(DbT3063SaishinsaKetteiShukeiEntity entity) {
        this.toriatsukaiYM = entity.toriatsukaiYM;
        this.hokenshaKubun = entity.hokenshaKubun;
        this.rirekiNo = entity.rirekiNo;
        this.kaigoKyufuhiSeikyuKensu = entity.kaigoKyufuhiSeikyuKensu;
        this.kaigoKyufuhiSeikyuTanisu = entity.kaigoKyufuhiSeikyuTanisu;
        this.kaigoKyufuhiSeikyuFutangaku = entity.kaigoKyufuhiSeikyuFutangaku;
        this.kaigoKyufuhiKetteiKensu = entity.kaigoKyufuhiKetteiKensu;
        this.kaigoKyufuhiKetteiTanisu = entity.kaigoKyufuhiKetteiTanisu;
        this.kaigoKyufuhiKetteiFutangaku = entity.kaigoKyufuhiKetteiFutangaku;
        this.kaigoKyufuhiChoseiKensu = entity.kaigoKyufuhiChoseiKensu;
        this.kaigoKyufuhiChoseiTanisu = entity.kaigoKyufuhiChoseiTanisu;
        this.kaigoKyufuhiChoseiFutangaku = entity.kaigoKyufuhiChoseiFutangaku;
        this.kogakuKaigoServicehiSeikyuKensu = entity.kogakuKaigoServicehiSeikyuKensu;
        this.kogakuKaigoServicehiSeikyuTanisu = entity.kogakuKaigoServicehiSeikyuTanisu;
        this.kogakuKaigoServicehiSeikyuFutangaku = entity.kogakuKaigoServicehiSeikyuFutangaku;
        this.kogakuKaigoServicehiKetteiKensu = entity.kogakuKaigoServicehiKetteiKensu;
        this.kogakuKaigoServicehiKetteiTanisu = entity.kogakuKaigoServicehiKetteiTanisu;
        this.kogakuKaigoServicehiKetteiFutangaku = entity.kogakuKaigoServicehiKetteiFutangaku;
        this.kogakuKaigoServicehiChoseiKensu = entity.kogakuKaigoServicehiChoseiKensu;
        this.kogakuKaigoServicehiChoseiTanisu = entity.kogakuKaigoServicehiChoseiTanisu;
        this.kogakuKaigoServicehiChoseiFutangaku = entity.kogakuKaigoServicehiChoseiFutangaku;
        this.kohiFutanshaNo = entity.kohiFutanshaNo;
        this.sakuseiYMD = entity.sakuseiYMD;
        this.sinsaiinkaiName = entity.sinsaiinkaiName;
        this.torikomiYM = entity.torikomiYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(toriatsukaiYM, hokenshaKubun, rirekiNo, kaigoKyufuhiSeikyuKensu, kaigoKyufuhiSeikyuTanisu, kaigoKyufuhiSeikyuFutangaku, kaigoKyufuhiKetteiKensu, kaigoKyufuhiKetteiTanisu, kaigoKyufuhiKetteiFutangaku, kaigoKyufuhiChoseiKensu, kaigoKyufuhiChoseiTanisu, kaigoKyufuhiChoseiFutangaku, kogakuKaigoServicehiSeikyuKensu, kogakuKaigoServicehiSeikyuTanisu, kogakuKaigoServicehiSeikyuFutangaku, kogakuKaigoServicehiKetteiKensu, kogakuKaigoServicehiKetteiTanisu, kogakuKaigoServicehiKetteiFutangaku, kogakuKaigoServicehiChoseiKensu, kogakuKaigoServicehiChoseiTanisu, kogakuKaigoServicehiChoseiFutangaku, kohiFutanshaNo, sakuseiYMD, sinsaiinkaiName, torikomiYM);
    }

// </editor-fold>
}
