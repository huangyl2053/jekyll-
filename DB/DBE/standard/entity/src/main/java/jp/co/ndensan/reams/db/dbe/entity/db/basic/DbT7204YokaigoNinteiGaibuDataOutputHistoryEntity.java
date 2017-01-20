package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 要介護認定外部データ出力履歴テーブルのエンティティクラスです。
 */
public class DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity extends DbTableEntityBase<DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7204YokaigoNinteiGaibuDataOutputHistory");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private Code dataKubun;
    private YMDHMS dataOutputKaishiYMDHMS;
    private YMDHMS dataOutputShuryoYMDHMS;

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
     * 外部出力データ区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：外部出力データ区分）1:申請情報、2:４マスタ、3:資格喪失(死亡)情報
     * 
     * @return 外部出力データ区分
     */
    public Code getDataKubun() {
        return dataKubun;
    }

    /**
     * 外部出力データ区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：外部出力データ区分）1:申請情報、2:４マスタ、3:資格喪失(死亡)情報
     * 
     * @param dataKubun 外部出力データ区分
     */
    public void setDataKubun(@Nonnull Code dataKubun) {
        this.dataKubun = dataKubun;
    }

    /**
     * データ出力開始年月日時分秒のgetメソッドです。
     * 
     * @return データ出力開始年月日時分秒
     */
    @CheckForNull
    public YMDHMS getDataOutputKaishiYMDHMS() {
        return dataOutputKaishiYMDHMS;
    }

    /**
     * データ出力開始年月日時分秒のsetメソッドです。
     * 
     * @param dataOutputKaishiYMDHMS データ出力開始年月日時分秒
     */
    public void setDataOutputKaishiYMDHMS(YMDHMS dataOutputKaishiYMDHMS) {
        this.dataOutputKaishiYMDHMS = dataOutputKaishiYMDHMS;
    }

    /**
     * データ出力終了年月日時分秒のgetメソッドです。
     * 
     * @return データ出力終了年月日時分秒
     */
    @CheckForNull
    public YMDHMS getDataOutputShuryoYMDHMS() {
        return dataOutputShuryoYMDHMS;
    }

    /**
     * データ出力終了年月日時分秒のsetメソッドです。
     * 
     * @param dataOutputShuryoYMDHMS データ出力終了年月日時分秒
     */
    public void setDataOutputShuryoYMDHMS(YMDHMS dataOutputShuryoYMDHMS) {
        this.dataOutputShuryoYMDHMS = dataOutputShuryoYMDHMS;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.dataKubun, other.dataKubun)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity entity) {
        this.dataKubun = entity.dataKubun;
        this.dataOutputKaishiYMDHMS = entity.dataOutputKaishiYMDHMS;
        this.dataOutputShuryoYMDHMS = entity.dataOutputShuryoYMDHMS;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(dataKubun, dataOutputKaishiYMDHMS, dataOutputShuryoYMDHMS);
    }

// </editor-fold>

}
