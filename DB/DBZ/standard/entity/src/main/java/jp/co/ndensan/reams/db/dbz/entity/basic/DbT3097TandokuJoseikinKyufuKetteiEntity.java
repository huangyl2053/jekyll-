package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3097TandokuJoseikinKyufuKetteiの項目定義クラスです
 *
 */
public class DbT3097TandokuJoseikinKyufuKetteiEntity extends DbTableEntityBase<DbT3097TandokuJoseikinKyufuKetteiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

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
    private YMDHMS shoriTimestamp;
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
     * getHihokenshaNo
     *
     * @return hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * getUketsukeYMD
     *
     * @return uketsukeYMD
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * setUketsukeYMD
     *
     * @param uketsukeYMD uketsukeYMD
     */
    public void setUketsukeYMD(FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
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
     * getKetteiYMD
     *
     * @return ketteiYMD
     */
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * setKetteiYMD
     *
     * @param ketteiYMD ketteiYMD
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
    }

    /**
     * getTekiyoKaishiYMD
     *
     * @return tekiyoKaishiYMD
     */
    public FlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    /**
     * setTekiyoKaishiYMD
     *
     * @param tekiyoKaishiYMD tekiyoKaishiYMD
     */
    public void setTekiyoKaishiYMD(FlexibleDate tekiyoKaishiYMD) {
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    /**
     * getYukoKigenYMD
     *
     * @return yukoKigenYMD
     */
    public FlexibleDate getYukoKigenYMD() {
        return yukoKigenYMD;
    }

    /**
     * setYukoKigenYMD
     *
     * @param yukoKigenYMD yukoKigenYMD
     */
    public void setYukoKigenYMD(FlexibleDate yukoKigenYMD) {
        this.yukoKigenYMD = yukoKigenYMD;
    }

    /**
     * getRiyoshaFutan_KetteiKubun
     *
     * @return riyoshaFutan_KetteiKubun
     */
    public RString getRiyoshaFutan_KetteiKubun() {
        return riyoshaFutan_KetteiKubun;
    }

    /**
     * setRiyoshaFutan_KetteiKubun
     *
     * @param riyoshaFutan_KetteiKubun riyoshaFutan_KetteiKubun
     */
    public void setRiyoshaFutan_KetteiKubun(RString riyoshaFutan_KetteiKubun) {
        this.riyoshaFutan_KetteiKubun = riyoshaFutan_KetteiKubun;
    }

    /**
     * getRiyoshaFutan_FuShoninRiyu
     *
     * @return riyoshaFutan_FuShoninRiyu
     */
    public RString getRiyoshaFutan_FuShoninRiyu() {
        return riyoshaFutan_FuShoninRiyu;
    }

    /**
     * setRiyoshaFutan_FuShoninRiyu
     *
     * @param riyoshaFutan_FuShoninRiyu riyoshaFutan_FuShoninRiyu
     */
    public void setRiyoshaFutan_FuShoninRiyu(RString riyoshaFutan_FuShoninRiyu) {
        this.riyoshaFutan_FuShoninRiyu = riyoshaFutan_FuShoninRiyu;
    }

    /**
     * getKohi_JukyushaNo
     *
     * @return kohi_JukyushaNo
     */
    public RString getKohi_JukyushaNo() {
        return kohi_JukyushaNo;
    }

    /**
     * setKohi_JukyushaNo
     *
     * @param kohi_JukyushaNo kohi_JukyushaNo
     */
    public void setKohi_JukyushaNo(RString kohi_JukyushaNo) {
        this.kohi_JukyushaNo = kohi_JukyushaNo;
    }

    /**
     * getKohi_FutanshaNo
     *
     * @return kohi_FutanshaNo
     */
    public RString getKohi_FutanshaNo() {
        return kohi_FutanshaNo;
    }

    /**
     * setKohi_FutanshaNo
     *
     * @param kohi_FutanshaNo kohi_FutanshaNo
     */
    public void setKohi_FutanshaNo(RString kohi_FutanshaNo) {
        this.kohi_FutanshaNo = kohi_FutanshaNo;
    }

    /**
     * getKyufuRitsu
     *
     * @return kyufuRitsu
     */
    public HokenKyufuRitsu getKyufuRitsu() {
        return kyufuRitsu;
    }

    /**
     * setKyufuRitsu
     *
     * @param kyufuRitsu kyufuRitsu
     */
    public void setKyufuRitsu(HokenKyufuRitsu kyufuRitsu) {
        this.kyufuRitsu = kyufuRitsu;
    }

    /**
     * getJukyushaNo
     *
     * @return jukyushaNo
     */
    public RString getJukyushaNo() {
        return jukyushaNo;
    }

    /**
     * setJukyushaNo
     *
     * @param jukyushaNo jukyushaNo
     */
    public void setJukyushaNo(RString jukyushaNo) {
        this.jukyushaNo = jukyushaNo;
    }

    /**
     * getKeikaSochiKubun
     *
     * @return keikaSochiKubun
     */
    public RString getKeikaSochiKubun() {
        return keikaSochiKubun;
    }

    /**
     * setKeikaSochiKubun
     *
     * @param keikaSochiKubun keikaSochiKubun
     */
    public void setKeikaSochiKubun(RString keikaSochiKubun) {
        this.keikaSochiKubun = keikaSochiKubun;
    }

    /**
     * getKuniKeigenKubun
     *
     * @return kuniKeigenKubun
     */
    public RString getKuniKeigenKubun() {
        return kuniKeigenKubun;
    }

    /**
     * setKuniKeigenKubun
     *
     * @param kuniKeigenKubun kuniKeigenKubun
     */
    public void setKuniKeigenKubun(RString kuniKeigenKubun) {
        this.kuniKeigenKubun = kuniKeigenKubun;
    }

    /**
     * getShakaiFukushiHojinKeigenKubun
     *
     * @return shakaiFukushiHojinKeigenKubun
     */
    public RString getShakaiFukushiHojinKeigenKubun() {
        return shakaiFukushiHojinKeigenKubun;
    }

    /**
     * setShakaiFukushiHojinKeigenKubun
     *
     * @param shakaiFukushiHojinKeigenKubun shakaiFukushiHojinKeigenKubun
     */
    public void setShakaiFukushiHojinKeigenKubun(RString shakaiFukushiHojinKeigenKubun) {
        this.shakaiFukushiHojinKeigenKubun = shakaiFukushiHojinKeigenKubun;
    }

    /**
     * getTokubetsuChiikiKasanKubun
     *
     * @return tokubetsuChiikiKasanKubun
     */
    public RString getTokubetsuChiikiKasanKubun() {
        return tokubetsuChiikiKasanKubun;
    }

    /**
     * setTokubetsuChiikiKasanKubun
     *
     * @param tokubetsuChiikiKasanKubun tokubetsuChiikiKasanKubun
     */
    public void setTokubetsuChiikiKasanKubun(RString tokubetsuChiikiKasanKubun) {
        this.tokubetsuChiikiKasanKubun = tokubetsuChiikiKasanKubun;
    }

    /**
     * getTaino_HoryuKubun
     *
     * @return taino_HoryuKubun
     */
    public RString getTaino_HoryuKubun() {
        return taino_HoryuKubun;
    }

    /**
     * setTaino_HoryuKubun
     *
     * @param taino_HoryuKubun taino_HoryuKubun
     */
    public void setTaino_HoryuKubun(RString taino_HoryuKubun) {
        this.taino_HoryuKubun = taino_HoryuKubun;
    }

    /**
     * getNinteiShinseichu_HoryuKubun
     *
     * @return ninteiShinseichu_HoryuKubun
     */
    public RString getNinteiShinseichu_HoryuKubun() {
        return ninteiShinseichu_HoryuKubun;
    }

    /**
     * setNinteiShinseichu_HoryuKubun
     *
     * @param ninteiShinseichu_HoryuKubun ninteiShinseichu_HoryuKubun
     */
    public void setNinteiShinseichu_HoryuKubun(RString ninteiShinseichu_HoryuKubun) {
        this.ninteiShinseichu_HoryuKubun = ninteiShinseichu_HoryuKubun;
    }

    /**
     * getNinteiKigenGire_HoryuKubun
     *
     * @return ninteiKigenGire_HoryuKubun
     */
    public RString getNinteiKigenGire_HoryuKubun() {
        return ninteiKigenGire_HoryuKubun;
    }

    /**
     * setNinteiKigenGire_HoryuKubun
     *
     * @param ninteiKigenGire_HoryuKubun ninteiKigenGire_HoryuKubun
     */
    public void setNinteiKigenGire_HoryuKubun(RString ninteiKigenGire_HoryuKubun) {
        this.ninteiKigenGire_HoryuKubun = ninteiKigenGire_HoryuKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3097TandokuJoseikinKyufuKetteiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
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
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
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
        this.shoriTimestamp = entity.shoriTimestamp;
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
        return super.toMd5(hihokenshaNo, uketsukeYMD, shoriTimestamp, ketteiYMD, tekiyoKaishiYMD, yukoKigenYMD, riyoshaFutan_KetteiKubun, riyoshaFutan_FuShoninRiyu, kohi_JukyushaNo, kohi_FutanshaNo, kyufuRitsu, jukyushaNo, keikaSochiKubun, kuniKeigenKubun, shakaiFukushiHojinKeigenKubun, tokubetsuChiikiKasanKubun, taino_HoryuKubun, ninteiShinseichu_HoryuKubun, ninteiKigenGire_HoryuKubun);
    }

// </editor-fold>
}
