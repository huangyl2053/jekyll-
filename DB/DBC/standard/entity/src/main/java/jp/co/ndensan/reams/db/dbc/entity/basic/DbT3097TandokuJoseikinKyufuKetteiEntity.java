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
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenKyufuRitsu;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 市町村単独助成金給付決定テーブルのエンティティクラスです。
 */
public class DbT3097TandokuJoseikinKyufuKetteiEntity extends DbTableEntityBase<DbT3097TandokuJoseikinKyufuKetteiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3097TandokuJoseikinKyufuKettei");

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
    private FlexibleDate uketsukeYMD;
    @PrimaryKey
    private Decimal rirekiNo;
    private FlexibleDate ketteiYMD;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate yukoKigenYMD;
    private RString riyoshaFutan_KetteiKubun;
    private RString riyoshaFutan_FuShoninRiyu;
    private RString kohi_JukyushaNo;
    private RString kohi_FutanshaNo;
    private HokenKyufuRitsu kyufuRitsu;
    private RString jukyushaNo;
    private RString keikaSochiKubun;
    private RString kuniKeigenKubun;
    private RString shakaiFukushiHojinKeigenKubun;
    private RString tokubetsuChiikiKasanKubun;
    private RString taino_HoryuKubun;
    private RString ninteiShinseichu_HoryuKubun;
    private RString ninteiKigenGire_HoryuKubun;

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
     * 受付年月日のgetメソッドです。
     *
     * @return 受付年月日
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * 受付年月日のsetメソッドです。
     *
     * @param uketsukeYMD 受付年月日
     */
    public void setUketsukeYMD(FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
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
     * 決定年月日のgetメソッドです。
     *
     * @return 決定年月日
     */
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * 決定年月日のsetメソッドです。
     *
     * @param ketteiYMD 決定年月日
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
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
     * 有効期限のgetメソッドです。
     *
     * @return 有効期限
     */
    public FlexibleDate getYukoKigenYMD() {
        return yukoKigenYMD;
    }

    /**
     * 有効期限のsetメソッドです。
     *
     * @param yukoKigenYMD 有効期限
     */
    public void setYukoKigenYMD(FlexibleDate yukoKigenYMD) {
        this.yukoKigenYMD = yukoKigenYMD;
    }

    /**
     * 利用者負担・決定区分のgetメソッドです。
     *
     * @return 利用者負担・決定区分
     */
    public RString getRiyoshaFutan_KetteiKubun() {
        return riyoshaFutan_KetteiKubun;
    }

    /**
     * 利用者負担・決定区分のsetメソッドです。
     *
     * @param riyoshaFutan_KetteiKubun 利用者負担・決定区分
     */
    public void setRiyoshaFutan_KetteiKubun(RString riyoshaFutan_KetteiKubun) {
        this.riyoshaFutan_KetteiKubun = riyoshaFutan_KetteiKubun;
    }

    /**
     * 利用者負担・不承認理由のgetメソッドです。
     *
     * @return 利用者負担・不承認理由
     */
    public RString getRiyoshaFutan_FuShoninRiyu() {
        return riyoshaFutan_FuShoninRiyu;
    }

    /**
     * 利用者負担・不承認理由のsetメソッドです。
     *
     * @param riyoshaFutan_FuShoninRiyu 利用者負担・不承認理由
     */
    public void setRiyoshaFutan_FuShoninRiyu(RString riyoshaFutan_FuShoninRiyu) {
        this.riyoshaFutan_FuShoninRiyu = riyoshaFutan_FuShoninRiyu;
    }

    /**
     * 公費受給者番号のgetメソッドです。
     *
     * @return 公費受給者番号
     */
    public RString getKohi_JukyushaNo() {
        return kohi_JukyushaNo;
    }

    /**
     * 公費受給者番号のsetメソッドです。
     *
     * @param kohi_JukyushaNo 公費受給者番号
     */
    public void setKohi_JukyushaNo(RString kohi_JukyushaNo) {
        this.kohi_JukyushaNo = kohi_JukyushaNo;
    }

    /**
     * 公費負担者番号のgetメソッドです。
     *
     * @return 公費負担者番号
     */
    public RString getKohi_FutanshaNo() {
        return kohi_FutanshaNo;
    }

    /**
     * 公費負担者番号のsetメソッドです。
     *
     * @param kohi_FutanshaNo 公費負担者番号
     */
    public void setKohi_FutanshaNo(RString kohi_FutanshaNo) {
        this.kohi_FutanshaNo = kohi_FutanshaNo;
    }

    /**
     * 給付率のgetメソッドです。
     *
     * @return 給付率
     */
    public HokenKyufuRitsu getKyufuRitsu() {
        return kyufuRitsu;
    }

    /**
     * 給付率のsetメソッドです。
     *
     * @param kyufuRitsu 給付率
     */
    public void setKyufuRitsu(HokenKyufuRitsu kyufuRitsu) {
        this.kyufuRitsu = kyufuRitsu;
    }

    /**
     * 受給者番号のgetメソッドです。
     *
     * @return 受給者番号
     */
    public RString getJukyushaNo() {
        return jukyushaNo;
    }

    /**
     * 受給者番号のsetメソッドです。
     *
     * @param jukyushaNo 受給者番号
     */
    public void setJukyushaNo(RString jukyushaNo) {
        this.jukyushaNo = jukyushaNo;
    }

    /**
     * 経過措置のgetメソッドです。
     *
     * @return 経過措置
     */
    public RString getKeikaSochiKubun() {
        return keikaSochiKubun;
    }

    /**
     * 経過措置のsetメソッドです。
     *
     * @param keikaSochiKubun 経過措置
     */
    public void setKeikaSochiKubun(RString keikaSochiKubun) {
        this.keikaSochiKubun = keikaSochiKubun;
    }

    /**
     * 国軽減のgetメソッドです。
     *
     * @return 国軽減
     */
    public RString getKuniKeigenKubun() {
        return kuniKeigenKubun;
    }

    /**
     * 国軽減のsetメソッドです。
     *
     * @param kuniKeigenKubun 国軽減
     */
    public void setKuniKeigenKubun(RString kuniKeigenKubun) {
        this.kuniKeigenKubun = kuniKeigenKubun;
    }

    /**
     * 社会福祉法人軽減のgetメソッドです。
     *
     * @return 社会福祉法人軽減
     */
    public RString getShakaiFukushiHojinKeigenKubun() {
        return shakaiFukushiHojinKeigenKubun;
    }

    /**
     * 社会福祉法人軽減のsetメソッドです。
     *
     * @param shakaiFukushiHojinKeigenKubun 社会福祉法人軽減
     */
    public void setShakaiFukushiHojinKeigenKubun(RString shakaiFukushiHojinKeigenKubun) {
        this.shakaiFukushiHojinKeigenKubun = shakaiFukushiHojinKeigenKubun;
    }

    /**
     * 特別地域加算のgetメソッドです。
     *
     * @return 特別地域加算
     */
    public RString getTokubetsuChiikiKasanKubun() {
        return tokubetsuChiikiKasanKubun;
    }

    /**
     * 特別地域加算のsetメソッドです。
     *
     * @param tokubetsuChiikiKasanKubun 特別地域加算
     */
    public void setTokubetsuChiikiKasanKubun(RString tokubetsuChiikiKasanKubun) {
        this.tokubetsuChiikiKasanKubun = tokubetsuChiikiKasanKubun;
    }

    /**
     * 保留区分・滞納のgetメソッドです。
     *
     * @return 保留区分・滞納
     */
    public RString getTaino_HoryuKubun() {
        return taino_HoryuKubun;
    }

    /**
     * 保留区分・滞納のsetメソッドです。
     *
     * @param taino_HoryuKubun 保留区分・滞納
     */
    public void setTaino_HoryuKubun(RString taino_HoryuKubun) {
        this.taino_HoryuKubun = taino_HoryuKubun;
    }

    /**
     * 保留区分・認定申請中のgetメソッドです。
     *
     * @return 保留区分・認定申請中
     */
    public RString getNinteiShinseichu_HoryuKubun() {
        return ninteiShinseichu_HoryuKubun;
    }

    /**
     * 保留区分・認定申請中のsetメソッドです。
     *
     * @param ninteiShinseichu_HoryuKubun 保留区分・認定申請中
     */
    public void setNinteiShinseichu_HoryuKubun(RString ninteiShinseichu_HoryuKubun) {
        this.ninteiShinseichu_HoryuKubun = ninteiShinseichu_HoryuKubun;
    }

    /**
     * 保留区分・認定有効期限切れのgetメソッドです。
     *
     * @return 保留区分・認定有効期限切れ
     */
    public RString getNinteiKigenGire_HoryuKubun() {
        return ninteiKigenGire_HoryuKubun;
    }

    /**
     * 保留区分・認定有効期限切れのsetメソッドです。
     *
     * @param ninteiKigenGire_HoryuKubun 保留区分・認定有効期限切れ
     */
    public void setNinteiKigenGire_HoryuKubun(RString ninteiKigenGire_HoryuKubun) {
        this.ninteiKigenGire_HoryuKubun = ninteiKigenGire_HoryuKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3097TandokuJoseikinKyufuKetteiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3097TandokuJoseikinKyufuKetteiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3097TandokuJoseikinKyufuKetteiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.uketsukeYMD, other.uketsukeYMD)) {
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
    public void shallowCopy(DbT3097TandokuJoseikinKyufuKetteiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.rirekiNo = entity.rirekiNo;
        this.ketteiYMD = entity.ketteiYMD;
        this.tekiyoKaishiYMD = entity.tekiyoKaishiYMD;
        this.yukoKigenYMD = entity.yukoKigenYMD;
        this.riyoshaFutan_KetteiKubun = entity.riyoshaFutan_KetteiKubun;
        this.riyoshaFutan_FuShoninRiyu = entity.riyoshaFutan_FuShoninRiyu;
        this.kohi_JukyushaNo = entity.kohi_JukyushaNo;
        this.kohi_FutanshaNo = entity.kohi_FutanshaNo;
        this.kyufuRitsu = entity.kyufuRitsu;
        this.jukyushaNo = entity.jukyushaNo;
        this.keikaSochiKubun = entity.keikaSochiKubun;
        this.kuniKeigenKubun = entity.kuniKeigenKubun;
        this.shakaiFukushiHojinKeigenKubun = entity.shakaiFukushiHojinKeigenKubun;
        this.tokubetsuChiikiKasanKubun = entity.tokubetsuChiikiKasanKubun;
        this.taino_HoryuKubun = entity.taino_HoryuKubun;
        this.ninteiShinseichu_HoryuKubun = entity.ninteiShinseichu_HoryuKubun;
        this.ninteiKigenGire_HoryuKubun = entity.ninteiKigenGire_HoryuKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, uketsukeYMD, rirekiNo, ketteiYMD, tekiyoKaishiYMD, yukoKigenYMD, riyoshaFutan_KetteiKubun, riyoshaFutan_FuShoninRiyu, kohi_JukyushaNo, kohi_FutanshaNo, kyufuRitsu, jukyushaNo, keikaSochiKubun, kuniKeigenKubun, shakaiFukushiHojinKeigenKubun, tokubetsuChiikiKasanKubun, taino_HoryuKubun, ninteiShinseichu_HoryuKubun, ninteiKigenGire_HoryuKubun);
    }

// </editor-fold>
}
