package jp.co.ndensan.reams.db.dbb.entity.db.basic;

import java.util.UUID;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 賦課徴収猶予Newestテーブルのエンティティクラスです。
 */
public class DbV2006ChoshuYuyoEntity extends DbTableEntityBase<DbV2006ChoshuYuyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV2006ChoshuYuyo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private TsuchishoNo tsuchishoNo;
    private int rirekiNo;
    private FlexibleDate shinseiYMD;
    private FlexibleDate ketteiYMD;
    private FlexibleDate torikeshiYMD;
    private RString jotaiKubun;
    private RString sakuseiKubun;
    private RString shinseiJiyu;
    private Code yuyoJiyuCode;
    private RString yuyoJiyu;
    private Code yuyoTorikeshiJiyuCode;
    private RString yuyoTorikeshiJiyu;

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
     * choteiNendoのgetメソッドです。
     * 
     * @return choteiNendo
     */
    @CheckForNull
    public FlexibleYear getChoteiNendo() {
        return choteiNendo;
    }

    /**
     * choteiNendoのsetメソッドです。
     * 
     * @param choteiNendo choteiNendo
     */
    public void setChoteiNendo(FlexibleYear choteiNendo) {
        this.choteiNendo = choteiNendo;
    }

    /**
     * fukaNendoのgetメソッドです。
     * 
     * @return fukaNendo
     */
    @CheckForNull
    public FlexibleYear getFukaNendo() {
        return fukaNendo;
    }

    /**
     * fukaNendoのsetメソッドです。
     * 
     * @param fukaNendo fukaNendo
     */
    public void setFukaNendo(FlexibleYear fukaNendo) {
        this.fukaNendo = fukaNendo;
    }

    /**
     * tsuchishoNoのgetメソッドです。
     * 
     * @return tsuchishoNo
     */
    @CheckForNull
    public TsuchishoNo getTsuchishoNo() {
        return tsuchishoNo;
    }

    /**
     * tsuchishoNoのsetメソッドです。
     * 
     * @param tsuchishoNo tsuchishoNo
     */
    public void setTsuchishoNo(TsuchishoNo tsuchishoNo) {
        this.tsuchishoNo = tsuchishoNo;
    }

    /**
     * rirekiNoのgetメソッドです。
     * 
     * @return rirekiNo
     */
    @CheckForNull
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * rirekiNoのsetメソッドです。
     * 
     * @param rirekiNo rirekiNo
     */
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * shinseiYMDのgetメソッドです。
     * 
     * @return shinseiYMD
     */
    @CheckForNull
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * shinseiYMDのsetメソッドです。
     * 
     * @param shinseiYMD shinseiYMD
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * ketteiYMDのgetメソッドです。
     * 
     * @return ketteiYMD
     */
    @CheckForNull
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * ketteiYMDのsetメソッドです。
     * 
     * @param ketteiYMD ketteiYMD
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
    }

    /**
     * torikeshiYMDのgetメソッドです。
     * 
     * @return torikeshiYMD
     */
    @CheckForNull
    public FlexibleDate getTorikeshiYMD() {
        return torikeshiYMD;
    }

    /**
     * torikeshiYMDのsetメソッドです。
     * 
     * @param torikeshiYMD torikeshiYMD
     */
    public void setTorikeshiYMD(FlexibleDate torikeshiYMD) {
        this.torikeshiYMD = torikeshiYMD;
    }

    /**
     * jotaiKubunのgetメソッドです。
     * 
     * @return jotaiKubun
     */
    @CheckForNull
    public RString getJotaiKubun() {
        return jotaiKubun;
    }

    /**
     * jotaiKubunのsetメソッドです。
     * 
     * @param jotaiKubun jotaiKubun
     */
    public void setJotaiKubun(RString jotaiKubun) {
        this.jotaiKubun = jotaiKubun;
    }

    /**
     * sakuseiKubunのgetメソッドです。
     * 
     * @return sakuseiKubun
     */
    @CheckForNull
    public RString getSakuseiKubun() {
        return sakuseiKubun;
    }

    /**
     * sakuseiKubunのsetメソッドです。
     * 
     * @param sakuseiKubun sakuseiKubun
     */
    public void setSakuseiKubun(RString sakuseiKubun) {
        this.sakuseiKubun = sakuseiKubun;
    }

    /**
     * shinseiJiyuのgetメソッドです。
     * 
     * @return shinseiJiyu
     */
    @CheckForNull
    public RString getShinseiJiyu() {
        return shinseiJiyu;
    }

    /**
     * shinseiJiyuのsetメソッドです。
     * 
     * @param shinseiJiyu shinseiJiyu
     */
    public void setShinseiJiyu(RString shinseiJiyu) {
        this.shinseiJiyu = shinseiJiyu;
    }

    /**
     * yuyoJiyuCodeのgetメソッドです。
     * 
     * @return yuyoJiyuCode
     */
    @CheckForNull
    public Code getYuyoJiyuCode() {
        return yuyoJiyuCode;
    }

    /**
     * yuyoJiyuCodeのsetメソッドです。
     * 
     * @param yuyoJiyuCode yuyoJiyuCode
     */
    public void setYuyoJiyuCode(Code yuyoJiyuCode) {
        this.yuyoJiyuCode = yuyoJiyuCode;
    }

    /**
     * yuyoJiyuのgetメソッドです。
     * 
     * @return yuyoJiyu
     */
    @CheckForNull
    public RString getYuyoJiyu() {
        return yuyoJiyu;
    }

    /**
     * yuyoJiyuのsetメソッドです。
     * 
     * @param yuyoJiyu yuyoJiyu
     */
    public void setYuyoJiyu(RString yuyoJiyu) {
        this.yuyoJiyu = yuyoJiyu;
    }

    /**
     * yuyoTorikeshiJiyuCodeのgetメソッドです。
     * 
     * @return yuyoTorikeshiJiyuCode
     */
    @CheckForNull
    public Code getYuyoTorikeshiJiyuCode() {
        return yuyoTorikeshiJiyuCode;
    }

    /**
     * yuyoTorikeshiJiyuCodeのsetメソッドです。
     * 
     * @param yuyoTorikeshiJiyuCode yuyoTorikeshiJiyuCode
     */
    public void setYuyoTorikeshiJiyuCode(Code yuyoTorikeshiJiyuCode) {
        this.yuyoTorikeshiJiyuCode = yuyoTorikeshiJiyuCode;
    }

    /**
     * yuyoTorikeshiJiyuのgetメソッドです。
     * 
     * @return yuyoTorikeshiJiyu
     */
    @CheckForNull
    public RString getYuyoTorikeshiJiyu() {
        return yuyoTorikeshiJiyu;
    }

    /**
     * yuyoTorikeshiJiyuのsetメソッドです。
     * 
     * @param yuyoTorikeshiJiyu yuyoTorikeshiJiyu
     */
    public void setYuyoTorikeshiJiyu(RString yuyoTorikeshiJiyu) {
        this.yuyoTorikeshiJiyu = yuyoTorikeshiJiyu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV2006ChoshuYuyoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV2006ChoshuYuyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV2006ChoshuYuyoEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV2006ChoshuYuyoEntity entity) {
        this.choteiNendo = entity.choteiNendo;
        this.fukaNendo = entity.fukaNendo;
        this.tsuchishoNo = entity.tsuchishoNo;
        this.rirekiNo = entity.rirekiNo;
        this.shinseiYMD = entity.shinseiYMD;
        this.ketteiYMD = entity.ketteiYMD;
        this.torikeshiYMD = entity.torikeshiYMD;
        this.jotaiKubun = entity.jotaiKubun;
        this.sakuseiKubun = entity.sakuseiKubun;
        this.shinseiJiyu = entity.shinseiJiyu;
        this.yuyoJiyuCode = entity.yuyoJiyuCode;
        this.yuyoJiyu = entity.yuyoJiyu;
        this.yuyoTorikeshiJiyuCode = entity.yuyoTorikeshiJiyuCode;
        this.yuyoTorikeshiJiyu = entity.yuyoTorikeshiJiyu;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo, shinseiYMD, ketteiYMD, torikeshiYMD, jotaiKubun, sakuseiKubun, shinseiJiyu, yuyoJiyuCode, yuyoJiyu, yuyoTorikeshiJiyuCode, yuyoTorikeshiJiyu);
    }

// </editor-fold>
}
