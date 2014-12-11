package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import java.util.Objects;

/**
 * DbT7024KoikiShichosonCodeHenkanPatternの項目定義クラスです
 *
 */
public class DbT7024KoikiShichosonCodeHenkanPatternEntity extends DbTableEntityBase<DbT7024KoikiShichosonCodeHenkanPatternEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7024KoikiShichosonCodeHenkanPattern");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString koikiShichosonNo;
    @PrimaryKey
    private LasdecCode shichosonCode;
    @PrimaryKey
    private RString codeKubun;
    private RString codeHenkanTableShiyoUmu;
    private RString jidoSaibanKubun;
    private int shichosonCodeKetasu;
    private int shichosonCodeKaishiIchi;
    private int shichosonCodeShiyoKetasu;
    private RString shichosonNinshoNoUmu;
    private int koikiCodeKetasu;
    private int koikiCodeKaishiIchi;
    private int koikiCodeShiyoKetasu;
    private RString koikiNinshoNoUmu;
    private RString shichosonNoFukaKubun;

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
     * getKoikiShichosonNo
     * @return koikiShichosonNo
     */
    public RString getKoikiShichosonNo() {
        return koikiShichosonNo;
    }

    /**
     * setKoikiShichosonNo
     * @param koikiShichosonNo koikiShichosonNo
     */
    public void setKoikiShichosonNo(RString koikiShichosonNo) {
        this.koikiShichosonNo = koikiShichosonNo;
    }

    /**
     * getShichosonCode
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * getCodeKubun
     * @return codeKubun
     */
    public RString getCodeKubun() {
        return codeKubun;
    }

    /**
     * setCodeKubun
     * @param codeKubun codeKubun
     */
    public void setCodeKubun(RString codeKubun) {
        this.codeKubun = codeKubun;
    }

    /**
     * getCodeHenkanTableShiyoUmu
     * @return codeHenkanTableShiyoUmu
     */
    public RString getCodeHenkanTableShiyoUmu() {
        return codeHenkanTableShiyoUmu;
    }

    /**
     * setCodeHenkanTableShiyoUmu
     * @param codeHenkanTableShiyoUmu codeHenkanTableShiyoUmu
     */
    public void setCodeHenkanTableShiyoUmu(RString codeHenkanTableShiyoUmu) {
        this.codeHenkanTableShiyoUmu = codeHenkanTableShiyoUmu;
    }

    /**
     * getJidoSaibanKubun
     * @return jidoSaibanKubun
     */
    public RString getJidoSaibanKubun() {
        return jidoSaibanKubun;
    }

    /**
     * setJidoSaibanKubun
     * @param jidoSaibanKubun jidoSaibanKubun
     */
    public void setJidoSaibanKubun(RString jidoSaibanKubun) {
        this.jidoSaibanKubun = jidoSaibanKubun;
    }

    /**
     * getShichosonCodeKetasu
     * @return shichosonCodeKetasu
     */
    public int getShichosonCodeKetasu() {
        return shichosonCodeKetasu;
    }

    /**
     * setShichosonCodeKetasu
     * @param shichosonCodeKetasu shichosonCodeKetasu
     */
    public void setShichosonCodeKetasu(int shichosonCodeKetasu) {
        this.shichosonCodeKetasu = shichosonCodeKetasu;
    }

    /**
     * getShichosonCodeKaishiIchi
     * @return shichosonCodeKaishiIchi
     */
    public int getShichosonCodeKaishiIchi() {
        return shichosonCodeKaishiIchi;
    }

    /**
     * setShichosonCodeKaishiIchi
     * @param shichosonCodeKaishiIchi shichosonCodeKaishiIchi
     */
    public void setShichosonCodeKaishiIchi(int shichosonCodeKaishiIchi) {
        this.shichosonCodeKaishiIchi = shichosonCodeKaishiIchi;
    }

    /**
     * getShichosonCodeShiyoKetasu
     * @return shichosonCodeShiyoKetasu
     */
    public int getShichosonCodeShiyoKetasu() {
        return shichosonCodeShiyoKetasu;
    }

    /**
     * setShichosonCodeShiyoKetasu
     * @param shichosonCodeShiyoKetasu shichosonCodeShiyoKetasu
     */
    public void setShichosonCodeShiyoKetasu(int shichosonCodeShiyoKetasu) {
        this.shichosonCodeShiyoKetasu = shichosonCodeShiyoKetasu;
    }

    /**
     * getShichosonNinshoNoUmu
     * @return shichosonNinshoNoUmu
     */
    public RString getShichosonNinshoNoUmu() {
        return shichosonNinshoNoUmu;
    }

    /**
     * setShichosonNinshoNoUmu
     * @param shichosonNinshoNoUmu shichosonNinshoNoUmu
     */
    public void setShichosonNinshoNoUmu(RString shichosonNinshoNoUmu) {
        this.shichosonNinshoNoUmu = shichosonNinshoNoUmu;
    }

    /**
     * getKoikiCodeKetasu
     * @return koikiCodeKetasu
     */
    public int getKoikiCodeKetasu() {
        return koikiCodeKetasu;
    }

    /**
     * setKoikiCodeKetasu
     * @param koikiCodeKetasu koikiCodeKetasu
     */
    public void setKoikiCodeKetasu(int koikiCodeKetasu) {
        this.koikiCodeKetasu = koikiCodeKetasu;
    }

    /**
     * getKoikiCodeKaishiIchi
     * @return koikiCodeKaishiIchi
     */
    public int getKoikiCodeKaishiIchi() {
        return koikiCodeKaishiIchi;
    }

    /**
     * setKoikiCodeKaishiIchi
     * @param koikiCodeKaishiIchi koikiCodeKaishiIchi
     */
    public void setKoikiCodeKaishiIchi(int koikiCodeKaishiIchi) {
        this.koikiCodeKaishiIchi = koikiCodeKaishiIchi;
    }

    /**
     * getKoikiCodeShiyoKetasu
     * @return koikiCodeShiyoKetasu
     */
    public int getKoikiCodeShiyoKetasu() {
        return koikiCodeShiyoKetasu;
    }

    /**
     * setKoikiCodeShiyoKetasu
     * @param koikiCodeShiyoKetasu koikiCodeShiyoKetasu
     */
    public void setKoikiCodeShiyoKetasu(int koikiCodeShiyoKetasu) {
        this.koikiCodeShiyoKetasu = koikiCodeShiyoKetasu;
    }

    /**
     * getKoikiNinshoNoUmu
     * @return koikiNinshoNoUmu
     */
    public RString getKoikiNinshoNoUmu() {
        return koikiNinshoNoUmu;
    }

    /**
     * setKoikiNinshoNoUmu
     * @param koikiNinshoNoUmu koikiNinshoNoUmu
     */
    public void setKoikiNinshoNoUmu(RString koikiNinshoNoUmu) {
        this.koikiNinshoNoUmu = koikiNinshoNoUmu;
    }

    /**
     * getShichosonNoFukaKubun
     * @return shichosonNoFukaKubun
     */
    public RString getShichosonNoFukaKubun() {
        return shichosonNoFukaKubun;
    }

    /**
     * setShichosonNoFukaKubun
     * @param shichosonNoFukaKubun shichosonNoFukaKubun
     */
    public void setShichosonNoFukaKubun(RString shichosonNoFukaKubun) {
        this.shichosonNoFukaKubun = shichosonNoFukaKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7024KoikiShichosonCodeHenkanPatternEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7024KoikiShichosonCodeHenkanPatternEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7024KoikiShichosonCodeHenkanPatternEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.koikiShichosonNo, other.koikiShichosonNo)) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.codeKubun, other.codeKubun)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7024KoikiShichosonCodeHenkanPatternEntity entity) {
        this.koikiShichosonNo = entity.koikiShichosonNo;
        this.shichosonCode = entity.shichosonCode;
        this.codeKubun = entity.codeKubun;
        this.codeHenkanTableShiyoUmu = entity.codeHenkanTableShiyoUmu;
        this.jidoSaibanKubun = entity.jidoSaibanKubun;
        this.shichosonCodeKetasu = entity.shichosonCodeKetasu;
        this.shichosonCodeKaishiIchi = entity.shichosonCodeKaishiIchi;
        this.shichosonCodeShiyoKetasu = entity.shichosonCodeShiyoKetasu;
        this.shichosonNinshoNoUmu = entity.shichosonNinshoNoUmu;
        this.koikiCodeKetasu = entity.koikiCodeKetasu;
        this.koikiCodeKaishiIchi = entity.koikiCodeKaishiIchi;
        this.koikiCodeShiyoKetasu = entity.koikiCodeShiyoKetasu;
        this.koikiNinshoNoUmu = entity.koikiNinshoNoUmu;
        this.shichosonNoFukaKubun = entity.shichosonNoFukaKubun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(koikiShichosonNo, shichosonCode, codeKubun, codeHenkanTableShiyoUmu, jidoSaibanKubun, shichosonCodeKetasu, shichosonCodeKaishiIchi, shichosonCodeShiyoKetasu, shichosonNinshoNoUmu, koikiCodeKetasu, koikiCodeKaishiIchi, koikiCodeShiyoKetasu, koikiNinshoNoUmu, shichosonNoFukaKubun);
    }

// </editor-fold>


}
