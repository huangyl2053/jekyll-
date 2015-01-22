package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;

/**
 * DbT7035RendoPatternの項目定義クラスです
 *
 */
public class DbT7035RendoPatternEntity extends DbTableEntityBase<DbT7035RendoPatternEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7035RendoPattern");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private LasdecCode motoShichosonCode;
    @PrimaryKey
    private LasdecCode sakiShichosonCode;
    @PrimaryKey
    private RString shubetsu;
    @PrimaryKey
    private FlexibleDate yukoKaishiYMD;
    @PrimaryKey
    private FlexibleDate yukoShuryoYMD;
    private RString rendoKeitaiCode;
    private RString motoFormatVersion;
    private RString motoEncodeKeitai;
    private RString sakiFormatVersion;
    private RString sakiEncodeKeitai;
    private RString codeHenkanKubun;
    private RString gaijiHenkanKubun;
    private RString zenkenRendoKubun;
    private RString rendoKubun;

    /**
     * getInsertDantaiCd
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * setLastUpdateReamsLoginId
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getMotoShichosonCode
     * @return motoShichosonCode
     */
    public LasdecCode getMotoShichosonCode() {
        return motoShichosonCode;
    }

    /**
     * setMotoShichosonCode
     * @param motoShichosonCode motoShichosonCode
     */
    public void setMotoShichosonCode(LasdecCode motoShichosonCode) {
        this.motoShichosonCode = motoShichosonCode;
    }

    /**
     * getSakiShichosonCode
     * @return sakiShichosonCode
     */
    public LasdecCode getSakiShichosonCode() {
        return sakiShichosonCode;
    }

    /**
     * setSakiShichosonCode
     * @param sakiShichosonCode sakiShichosonCode
     */
    public void setSakiShichosonCode(LasdecCode sakiShichosonCode) {
        this.sakiShichosonCode = sakiShichosonCode;
    }

    /**
     * getShubetsu
     * @return shubetsu
     */
    public RString getShubetsu() {
        return shubetsu;
    }

    /**
     * setShubetsu
     * @param shubetsu shubetsu
     */
    public void setShubetsu(RString shubetsu) {
        this.shubetsu = shubetsu;
    }

    /**
     * getYukoKaishiYMD
     * @return yukoKaishiYMD
     */
    public FlexibleDate getYukoKaishiYMD() {
        return yukoKaishiYMD;
    }

    /**
     * setYukoKaishiYMD
     * @param yukoKaishiYMD yukoKaishiYMD
     */
    public void setYukoKaishiYMD(FlexibleDate yukoKaishiYMD) {
        this.yukoKaishiYMD = yukoKaishiYMD;
    }

    /**
     * getYukoShuryoYMD
     * @return yukoShuryoYMD
     */
    public FlexibleDate getYukoShuryoYMD() {
        return yukoShuryoYMD;
    }

    /**
     * setYukoShuryoYMD
     * @param yukoShuryoYMD yukoShuryoYMD
     */
    public void setYukoShuryoYMD(FlexibleDate yukoShuryoYMD) {
        this.yukoShuryoYMD = yukoShuryoYMD;
    }

    /**
     * getRendoKeitaiCode
     * @return rendoKeitaiCode
     */
    public RString getRendoKeitaiCode() {
        return rendoKeitaiCode;
    }

    /**
     * setRendoKeitaiCode
     * @param rendoKeitaiCode rendoKeitaiCode
     */
    public void setRendoKeitaiCode(RString rendoKeitaiCode) {
        this.rendoKeitaiCode = rendoKeitaiCode;
    }

    /**
     * getMotoFormatVersion
     * @return motoFormatVersion
     */
    public RString getMotoFormatVersion() {
        return motoFormatVersion;
    }

    /**
     * setMotoFormatVersion
     * @param motoFormatVersion motoFormatVersion
     */
    public void setMotoFormatVersion(RString motoFormatVersion) {
        this.motoFormatVersion = motoFormatVersion;
    }

    /**
     * getMotoEncodeKeitai
     * @return motoEncodeKeitai
     */
    public RString getMotoEncodeKeitai() {
        return motoEncodeKeitai;
    }

    /**
     * setMotoEncodeKeitai
     * @param motoEncodeKeitai motoEncodeKeitai
     */
    public void setMotoEncodeKeitai(RString motoEncodeKeitai) {
        this.motoEncodeKeitai = motoEncodeKeitai;
    }

    /**
     * getSakiFormatVersion
     * @return sakiFormatVersion
     */
    public RString getSakiFormatVersion() {
        return sakiFormatVersion;
    }

    /**
     * setSakiFormatVersion
     * @param sakiFormatVersion sakiFormatVersion
     */
    public void setSakiFormatVersion(RString sakiFormatVersion) {
        this.sakiFormatVersion = sakiFormatVersion;
    }

    /**
     * getSakiEncodeKeitai
     * @return sakiEncodeKeitai
     */
    public RString getSakiEncodeKeitai() {
        return sakiEncodeKeitai;
    }

    /**
     * setSakiEncodeKeitai
     * @param sakiEncodeKeitai sakiEncodeKeitai
     */
    public void setSakiEncodeKeitai(RString sakiEncodeKeitai) {
        this.sakiEncodeKeitai = sakiEncodeKeitai;
    }

    /**
     * getCodeHenkanKubun
     * @return codeHenkanKubun
     */
    public RString getCodeHenkanKubun() {
        return codeHenkanKubun;
    }

    /**
     * setCodeHenkanKubun
     * @param codeHenkanKubun codeHenkanKubun
     */
    public void setCodeHenkanKubun(RString codeHenkanKubun) {
        this.codeHenkanKubun = codeHenkanKubun;
    }

    /**
     * getGaijiHenkanKubun
     * @return gaijiHenkanKubun
     */
    public RString getGaijiHenkanKubun() {
        return gaijiHenkanKubun;
    }

    /**
     * setGaijiHenkanKubun
     * @param gaijiHenkanKubun gaijiHenkanKubun
     */
    public void setGaijiHenkanKubun(RString gaijiHenkanKubun) {
        this.gaijiHenkanKubun = gaijiHenkanKubun;
    }

    /**
     * getZenkenRendoKubun
     * @return zenkenRendoKubun
     */
    public RString getZenkenRendoKubun() {
        return zenkenRendoKubun;
    }

    /**
     * setZenkenRendoKubun
     * @param zenkenRendoKubun zenkenRendoKubun
     */
    public void setZenkenRendoKubun(RString zenkenRendoKubun) {
        this.zenkenRendoKubun = zenkenRendoKubun;
    }

    /**
     * getRendoKubun
     * @return rendoKubun
     */
    public RString getRendoKubun() {
        return rendoKubun;
    }

    /**
     * setRendoKubun
     * @param rendoKubun rendoKubun
     */
    public void setRendoKubun(RString rendoKubun) {
        this.rendoKubun = rendoKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7035RendoPatternEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7035RendoPatternEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7035RendoPatternEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.motoShichosonCode, other.motoShichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.sakiShichosonCode, other.sakiShichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.shubetsu, other.shubetsu)) {
            return false;
        }
        if (!Objects.equals(this.yukoKaishiYMD, other.yukoKaishiYMD)) {
            return false;
        }
        if (!Objects.equals(this.yukoShuryoYMD, other.yukoShuryoYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7035RendoPatternEntity entity) {
        this.motoShichosonCode = entity.motoShichosonCode;
        this.sakiShichosonCode = entity.sakiShichosonCode;
        this.shubetsu = entity.shubetsu;
        this.yukoKaishiYMD = entity.yukoKaishiYMD;
        this.yukoShuryoYMD = entity.yukoShuryoYMD;
        this.rendoKeitaiCode = entity.rendoKeitaiCode;
        this.motoFormatVersion = entity.motoFormatVersion;
        this.motoEncodeKeitai = entity.motoEncodeKeitai;
        this.sakiFormatVersion = entity.sakiFormatVersion;
        this.sakiEncodeKeitai = entity.sakiEncodeKeitai;
        this.codeHenkanKubun = entity.codeHenkanKubun;
        this.gaijiHenkanKubun = entity.gaijiHenkanKubun;
        this.zenkenRendoKubun = entity.zenkenRendoKubun;
        this.rendoKubun = entity.rendoKubun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(motoShichosonCode, sakiShichosonCode, shubetsu, yukoKaishiYMD, yukoShuryoYMD, rendoKeitaiCode, motoFormatVersion, motoEncodeKeitai, sakiFormatVersion, sakiEncodeKeitai, codeHenkanKubun, gaijiHenkanKubun, zenkenRendoKubun, rendoKubun);
    }

// </editor-fold>



}
