package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;

/**
 * 合併市町村テーブルのエンティティクラスです。
 */
public class DbT7056GappeiShichosonEntity extends DbTableEntityBase<DbT7056GappeiShichosonEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7056GappeiShichoson");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleDate gappeiYMD;
    @PrimaryKey
    private RString chiikiNo;
    @PrimaryKey
    private LasdecCode kyuShichosonCode;
    private FlexibleDate unyoKaishiYMD;
    private FlexibleDate unyoShuryoYMD;
    private HokenshaNo kyuHokenshaNo;
    private RString kyuShichosonMeisho;
    private RString todofukenMeisho;
    private RString gunMeisho;
    private YubinNo yubinNo;
    private TelNo telNo;
    private RString rojinhokenShichosonNo;
    private RString rokenJukyushaNoTaikei;
    private RString hyojiUmu;

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
     * 合併年月日のgetメソッドです。
     *
     * @return 合併年月日
     */
    public FlexibleDate getGappeiYMD() {
        return gappeiYMD;
    }

    /**
     * 合併年月日のsetメソッドです。
     *
     * @param gappeiYMD 合併年月日
     */
    public void setGappeiYMD(FlexibleDate gappeiYMD) {
        this.gappeiYMD = gappeiYMD;
    }

    /**
     * 地域番号のgetメソッドです。
     *
     * @return 地域番号
     */
    public RString getChiikiNo() {
        return chiikiNo;
    }

    /**
     * 地域番号のsetメソッドです。
     *
     * @param chiikiNo 地域番号
     */
    public void setChiikiNo(RString chiikiNo) {
        this.chiikiNo = chiikiNo;
    }

    /**
     * 旧市町村コードのgetメソッドです。
     *
     * @return 旧市町村コード
     */
    public LasdecCode getKyuShichosonCode() {
        return kyuShichosonCode;
    }

    /**
     * 旧市町村コードのsetメソッドです。
     *
     * @param kyuShichosonCode 旧市町村コード
     */
    public void setKyuShichosonCode(LasdecCode kyuShichosonCode) {
        this.kyuShichosonCode = kyuShichosonCode;
    }

    /**
     * 運用開始年月日のgetメソッドです。
     *
     * @return 運用開始年月日
     */
    public FlexibleDate getUnyoKaishiYMD() {
        return unyoKaishiYMD;
    }

    /**
     * 運用開始年月日のsetメソッドです。
     *
     * @param unyoKaishiYMD 運用開始年月日
     */
    public void setUnyoKaishiYMD(FlexibleDate unyoKaishiYMD) {
        this.unyoKaishiYMD = unyoKaishiYMD;
    }

    /**
     * 運用終了年月日のgetメソッドです。
     *
     * @return 運用終了年月日
     */
    public FlexibleDate getUnyoShuryoYMD() {
        return unyoShuryoYMD;
    }

    /**
     * 運用終了年月日のsetメソッドです。
     *
     * @param unyoShuryoYMD 運用終了年月日
     */
    public void setUnyoShuryoYMD(FlexibleDate unyoShuryoYMD) {
        this.unyoShuryoYMD = unyoShuryoYMD;
    }

    /**
     * 旧保険者番号のgetメソッドです。
     *
     * @return 旧保険者番号
     */
    public HokenshaNo getKyuHokenshaNo() {
        return kyuHokenshaNo;
    }

    /**
     * 旧保険者番号のsetメソッドです。
     *
     * @param kyuHokenshaNo 旧保険者番号
     */
    public void setKyuHokenshaNo(HokenshaNo kyuHokenshaNo) {
        this.kyuHokenshaNo = kyuHokenshaNo;
    }

    /**
     * 旧市町村名称のgetメソッドです。
     *
     * @return 旧市町村名称
     */
    public RString getKyuShichosonMeisho() {
        return kyuShichosonMeisho;
    }

    /**
     * 旧市町村名称のsetメソッドです。
     *
     * @param kyuShichosonMeisho 旧市町村名称
     */
    public void setKyuShichosonMeisho(RString kyuShichosonMeisho) {
        this.kyuShichosonMeisho = kyuShichosonMeisho;
    }

    /**
     * 都道府県名称のgetメソッドです。
     *
     * @return 都道府県名称
     */
    public RString getTodofukenMeisho() {
        return todofukenMeisho;
    }

    /**
     * 都道府県名称のsetメソッドです。
     *
     * @param todofukenMeisho 都道府県名称
     */
    public void setTodofukenMeisho(RString todofukenMeisho) {
        this.todofukenMeisho = todofukenMeisho;
    }

    /**
     * 郡名称のgetメソッドです。
     *
     * @return 郡名称
     */
    public RString getGunMeisho() {
        return gunMeisho;
    }

    /**
     * 郡名称のsetメソッドです。
     *
     * @param gunMeisho 郡名称
     */
    public void setGunMeisho(RString gunMeisho) {
        this.gunMeisho = gunMeisho;
    }

    /**
     * 郵便番号のgetメソッドです。
     *
     * @return 郵便番号
     */
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * 郵便番号のsetメソッドです。
     *
     * @param yubinNo 郵便番号
     */
    public void setYubinNo(YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * 電話番号のgetメソッドです。
     *
     * @return 電話番号
     */
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * 電話番号のsetメソッドです。
     *
     * @param telNo 電話番号
     */
    public void setTelNo(TelNo telNo) {
        this.telNo = telNo;
    }

    /**
     * 老人保健市町村番号のgetメソッドです。
     *
     * @return 老人保健市町村番号
     */
    public RString getRojinhokenShichosonNo() {
        return rojinhokenShichosonNo;
    }

    /**
     * 老人保健市町村番号のsetメソッドです。
     *
     * @param rojinhokenShichosonNo 老人保健市町村番号
     */
    public void setRojinhokenShichosonNo(RString rojinhokenShichosonNo) {
        this.rojinhokenShichosonNo = rojinhokenShichosonNo;
    }

    /**
     * 老人保健受給者番号体系のgetメソッドです。
     * <br/>
     * <br/>1:住民コード 2:医療給付サブシステム 3:市町村独自
     *
     * @return 老人保健受給者番号体系
     */
    public RString getRokenJukyushaNoTaikei() {
        return rokenJukyushaNoTaikei;
    }

    /**
     * 老人保健受給者番号体系のsetメソッドです。
     * <br/>
     * <br/>1:住民コード 2:医療給付サブシステム 3:市町村独自
     *
     * @param rokenJukyushaNoTaikei 老人保健受給者番号体系
     */
    public void setRokenJukyushaNoTaikei(RString rokenJukyushaNoTaikei) {
        this.rokenJukyushaNoTaikei = rokenJukyushaNoTaikei;
    }

    /**
     * 表示有無のgetメソッドです。
     * <br/>
     * <br/>1:表示対象とする 0:表示対象としない
     *
     * @return 表示有無
     */
    public RString getHyojiUmu() {
        return hyojiUmu;
    }

    /**
     * 表示有無のsetメソッドです。
     * <br/>
     * <br/>1:表示対象とする 0:表示対象としない
     *
     * @param hyojiUmu 表示有無
     */
    public void setHyojiUmu(RString hyojiUmu) {
        this.hyojiUmu = hyojiUmu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7056GappeiShichosonEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7056GappeiShichosonEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7056GappeiShichosonEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.gappeiYMD, other.gappeiYMD)) {
            return false;
        }
        if (!Objects.equals(this.chiikiNo, other.chiikiNo)) {
            return false;
        }
        if (!Objects.equals(this.kyuShichosonCode, other.kyuShichosonCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7056GappeiShichosonEntity entity) {
        this.gappeiYMD = entity.gappeiYMD;
        this.chiikiNo = entity.chiikiNo;
        this.kyuShichosonCode = entity.kyuShichosonCode;
        this.unyoKaishiYMD = entity.unyoKaishiYMD;
        this.unyoShuryoYMD = entity.unyoShuryoYMD;
        this.kyuHokenshaNo = entity.kyuHokenshaNo;
        this.kyuShichosonMeisho = entity.kyuShichosonMeisho;
        this.todofukenMeisho = entity.todofukenMeisho;
        this.gunMeisho = entity.gunMeisho;
        this.yubinNo = entity.yubinNo;
        this.telNo = entity.telNo;
        this.rojinhokenShichosonNo = entity.rojinhokenShichosonNo;
        this.rokenJukyushaNoTaikei = entity.rokenJukyushaNoTaikei;
        this.hyojiUmu = entity.hyojiUmu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(gappeiYMD, chiikiNo, kyuShichosonCode, unyoKaishiYMD, unyoShuryoYMD, kyuHokenshaNo, kyuShichosonMeisho, todofukenMeisho, gunMeisho, yubinNo, telNo, rojinhokenShichosonNo, rokenJukyushaNoTaikei, hyojiUmu);
    }

// </editor-fold>
}
