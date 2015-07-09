package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * 定型文属性テーブルのエンティティクラスです。
 */
public class DbT7232TeikeibunPropertyEntity extends DbTableEntityBase<DbT7232TeikeibunPropertyEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7232TeikeibunProperty");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private Decimal teikeibunZokuseiID;
    private RString teikeibunZokuseiCode;
    private RString teikeibunZokuseiName;
    private RString teikeibunCode;

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
     * 定型文属性IDのgetメソッドです。
     * <br/>
     * <br/>内部的なPK
     * 
     * @return 定型文属性ID
     */
    public Decimal getTeikeibunZokuseiID() {
        return teikeibunZokuseiID;
    }

    /**
     * 定型文属性IDのsetメソッドです。
     * <br/>
     * <br/>内部的なPK
     * 
     * @param teikeibunZokuseiID 定型文属性ID
     */
    public void setTeikeibunZokuseiID(Decimal teikeibunZokuseiID) {
        this.teikeibunZokuseiID = teikeibunZokuseiID;
    }

    /**
     * 定型文属性コードのgetメソッドです。
     * <br/>
     * <br/>101：認定理由、102：サ変理由、103：取消理由、104：却下理由、105：延期理由、109：サービス種類、201：調査票住宅改修、202：調査票主訴、203：調査票家族状況、204：調査票居住環境、205：機器器械、210：特記事項、501：審査会意見、502：審査会メモ、503：審査会メモ情報
     * 
     * @return 定型文属性コード
     */
    public RString getTeikeibunZokuseiCode() {
        return teikeibunZokuseiCode;
    }

    /**
     * 定型文属性コードのsetメソッドです。
     * <br/>
     * <br/>101：認定理由、102：サ変理由、103：取消理由、104：却下理由、105：延期理由、109：サービス種類、201：調査票住宅改修、202：調査票主訴、203：調査票家族状況、204：調査票居住環境、205：機器器械、210：特記事項、501：審査会意見、502：審査会メモ、503：審査会メモ情報
     * 
     * @param teikeibunZokuseiCode 定型文属性コード
     */
    public void setTeikeibunZokuseiCode(RString teikeibunZokuseiCode) {
        this.teikeibunZokuseiCode = teikeibunZokuseiCode;
    }

    /**
     * 属性名称のgetメソッドです。
     * 
     * @return 属性名称
     */
    public RString getTeikeibunZokuseiName() {
        return teikeibunZokuseiName;
    }

    /**
     * 属性名称のsetメソッドです。
     * 
     * @param teikeibunZokuseiName 属性名称
     */
    public void setTeikeibunZokuseiName(RString teikeibunZokuseiName) {
        this.teikeibunZokuseiName = teikeibunZokuseiName;
    }

    /**
     * 定型文コードのgetメソッドです。
     * 
     * @return 定型文コード
     */
    public RString getTeikeibunCode() {
        return teikeibunCode;
    }

    /**
     * 定型文コードのsetメソッドです。
     * 
     * @param teikeibunCode 定型文コード
     */
    public void setTeikeibunCode(RString teikeibunCode) {
        this.teikeibunCode = teikeibunCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7232TeikeibunPropertyEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7232TeikeibunPropertyEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7232TeikeibunPropertyEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.teikeibunZokuseiID, other.teikeibunZokuseiID)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7232TeikeibunPropertyEntity entity) {
        this.teikeibunZokuseiID = entity.teikeibunZokuseiID;
        this.teikeibunZokuseiCode = entity.teikeibunZokuseiCode;
        this.teikeibunZokuseiName = entity.teikeibunZokuseiName;
        this.teikeibunCode = entity.teikeibunCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(teikeibunZokuseiID, teikeibunZokuseiCode, teikeibunZokuseiName, teikeibunCode);
    }

// </editor-fold>
}
