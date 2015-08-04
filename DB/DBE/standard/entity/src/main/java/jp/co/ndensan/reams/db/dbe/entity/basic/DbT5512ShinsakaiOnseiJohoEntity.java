package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import java.util.Objects;

/**
 * 介護認定審査会音声情報テーブルのエンティティクラスです。
 */
public class DbT5512ShinsakaiOnseiJohoEntity extends DbTableEntityBase<DbT5512ShinsakaiOnseiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5512ShinsakaiOnseiJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private int shinsakaiKaisaiNo;
    @PrimaryKey
    private int renban;
    private byte[] shinsakaiOnseiFile;

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
     * 介護認定審査会開催番号のgetメソッドです。
     * 
     * @return 介護認定審査会開催番号
     */
    public int getShinsakaiKaisaiNo() {
        return shinsakaiKaisaiNo;
    }

    /**
     * 介護認定審査会開催番号のsetメソッドです。
     * 
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     */
    public void setShinsakaiKaisaiNo(int shinsakaiKaisaiNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }

    /**
     * 連番のgetメソッドです。
     * 
     * @return 連番
     */
    public int getRenban() {
        return renban;
    }

    /**
     * 連番のsetメソッドです。
     * 
     * @param renban 連番
     */
    public void setRenban(int renban) {
        this.renban = renban;
    }

    /**
     * 審査会音声ファイルのgetメソッドです。
     * 
     * @return 審査会音声ファイル
     */
    public byte[] getShinsakaiOnseiFile() {
        return shinsakaiOnseiFile;
    }

    /**
     * 審査会音声ファイルのsetメソッドです。
     * 
     * @param shinsakaiOnseiFile 審査会音声ファイル
     */
    public void setShinsakaiOnseiFile(byte[] shinsakaiOnseiFile) {
        this.shinsakaiOnseiFile = shinsakaiOnseiFile;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5512ShinsakaiOnseiJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5512ShinsakaiOnseiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5512ShinsakaiOnseiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (this.shinsakaiKaisaiNo != other.shinsakaiKaisaiNo) {
            return false;
        }
        if (this.renban != other.renban) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5512ShinsakaiOnseiJohoEntity entity) {
        this.shinsakaiKaisaiNo = entity.shinsakaiKaisaiNo;
        this.renban = entity.renban;
        this.shinsakaiOnseiFile = entity.shinsakaiOnseiFile;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinsakaiKaisaiNo, renban, shinsakaiOnseiFile);
    }

// </editor-fold>

}
