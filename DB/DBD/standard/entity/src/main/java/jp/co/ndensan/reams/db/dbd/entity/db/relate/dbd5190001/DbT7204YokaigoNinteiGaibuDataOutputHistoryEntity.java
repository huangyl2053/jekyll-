/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5190001;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHM;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 要介護認定外部データ出力履歴のテーブルエンティティクラスです。
 *
 * @reamsid_L DBD-1480-010 zhuxiaojun
 */
public class DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity
        extends DbTableEntityBase<DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity> implements IDbAccessable {

    /**
     * テーブル名です。
     */
    @TableName
    public static final RString TABLE_NAME;

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
    private YMDHM dataOutputKaishiYMDHM;
    private YMDHM dataOutputShuryoYMDHM;

    static {
        TABLE_NAME = new RString("DbT7204YokaigoNinteiGaibuDataOutputHistory");
    }

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
     * データ区分のgetメソッドです。
     * <br/>
     * <br/>1:申請情報、2:４マスタ、3:資格喪失(死亡)情報
     *
     * @return データ区分
     */
    public Code getDataKubun() {
        return dataKubun;
    }

    /**
     * データ区分のsetメソッドです。
     * <br/>
     * <br/>1:申請情報、2:４マスタ、3:資格喪失(死亡)情報
     *
     * @param dataKubun データ区分
     */
    public void setDataKubun(Code dataKubun) {
        this.dataKubun = dataKubun;
    }

    /**
     * データ出力開始年月日時分のgetメソッドです。
     *
     * @return データ出力開始年月日時分
     */
    public YMDHM getDataOutputKaishiYMDHM() {
        return dataOutputKaishiYMDHM;
    }

    /**
     * データ出力開始年月日時分のsetメソッドです。
     *
     * @param dataOutputKaishiYMDHM データ出力開始年月日時分
     */
    public void setDataOutputKaishiYMDHM(YMDHM dataOutputKaishiYMDHM) {
        this.dataOutputKaishiYMDHM = dataOutputKaishiYMDHM;
    }

    /**
     * データ出力終了年月日時分のgetメソッドです。
     *
     * @return データ出力終了年月日時分
     */
    public YMDHM getDataOutputShuryoYMDHM() {
        return dataOutputShuryoYMDHM;
    }

    /**
     * データ出力終了年月日時分のsetメソッドです。
     *
     * @param dataOutputShuryoYMDHM データ出力終了年月日時分
     */
    public void setDataOutputShuryoYMDHM(YMDHM dataOutputShuryoYMDHM) {
        this.dataOutputShuryoYMDHM = dataOutputShuryoYMDHM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity}の場合{@literal true}、それ以外の場合は{@literal false}
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
     * @param entity DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity entity) {
        this.dataKubun = entity.dataKubun;
        this.dataOutputKaishiYMDHM = entity.dataOutputKaishiYMDHM;
        this.dataOutputShuryoYMDHM = entity.dataOutputShuryoYMDHM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(dataKubun, dataOutputKaishiYMDHM, dataOutputShuryoYMDHM);
    }

}
