package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import java.util.Objects;

/**
 * 介護認定受給フラグテーブルのエンティティクラスです。
 */
public class DbT7105KaigoninteiJukyuFlagEntity extends DbTableEntityBase<DbT7105KaigoninteiJukyuFlagEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7105KaigoninteiJukyuFlag");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private boolean kihonJokyoFlag;
    private boolean mobileDataFlag;
    private boolean ninteiJohoTeikyoKiboAriFlag;
    private boolean shinsakaiShinsajunKakuteiFlag;
    private boolean gogitaiDummyFlag;
    private boolean gogitaiSeishinkaiFlag;
    private boolean shinsakaiKyukaiFlag;

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
     * 基本情報状況フラグのgetメソッドです。
     * <br/>
     * <br/>0:無効　1:有効
     * 
     * @return 基本情報状況フラグ
     */
    public boolean getKihonJokyoFlag() {
        return kihonJokyoFlag;
    }

    /**
     * 基本情報状況フラグのsetメソッドです。
     * <br/>
     * <br/>0:無効　1:有効
     * 
     * @param kihonJokyoFlag 基本情報状況フラグ
     */
    public void setKihonJokyoFlag(boolean kihonJokyoFlag) {
        this.kihonJokyoFlag = kihonJokyoFlag;
    }

    /**
     * モバイルデータ出力フラグのgetメソッドです。
     * <br/>
     * <br/>0:無し　1:有
     * 
     * @return モバイルデータ出力フラグ
     */
    public boolean getMobileDataFlag() {
        return mobileDataFlag;
    }

    /**
     * モバイルデータ出力フラグのsetメソッドです。
     * <br/>
     * <br/>0:無し　1:有
     * 
     * @param mobileDataFlag モバイルデータ出力フラグ
     */
    public void setMobileDataFlag(boolean mobileDataFlag) {
        this.mobileDataFlag = mobileDataFlag;
    }

    /**
     * 認定情報提供希望有フラグのgetメソッドです。
     * <br/>
     * <br/>0:無し　1:有
     * 
     * @return 認定情報提供希望有フラグ
     */
    public boolean getNinteiJohoTeikyoKiboAriFlag() {
        return ninteiJohoTeikyoKiboAriFlag;
    }

    /**
     * 認定情報提供希望有フラグのsetメソッドです。
     * <br/>
     * <br/>0:無し　1:有
     * 
     * @param ninteiJohoTeikyoKiboAriFlag 認定情報提供希望有フラグ
     */
    public void setNinteiJohoTeikyoKiboAriFlag(boolean ninteiJohoTeikyoKiboAriFlag) {
        this.ninteiJohoTeikyoKiboAriFlag = ninteiJohoTeikyoKiboAriFlag;
    }

    /**
     * 介護認定審査会審査順確定フラグのgetメソッドです。
     * <br/>
     * <br/>0:不確定　1:確定
     * 
     * @return 介護認定審査会審査順確定フラグ
     */
    public boolean getShinsakaiShinsajunKakuteiFlag() {
        return shinsakaiShinsajunKakuteiFlag;
    }

    /**
     * 介護認定審査会審査順確定フラグのsetメソッドです。
     * <br/>
     * <br/>0:不確定　1:確定
     * 
     * @param shinsakaiShinsajunKakuteiFlag 介護認定審査会審査順確定フラグ
     */
    public void setShinsakaiShinsajunKakuteiFlag(boolean shinsakaiShinsajunKakuteiFlag) {
        this.shinsakaiShinsajunKakuteiFlag = shinsakaiShinsajunKakuteiFlag;
    }

    /**
     * 合議体ダミーフラグのgetメソッドです。
     * <br/>
     * <br/>0:正規　1:ダミー
     * 
     * @return 合議体ダミーフラグ
     */
    public boolean getGogitaiDummyFlag() {
        return gogitaiDummyFlag;
    }

    /**
     * 合議体ダミーフラグのsetメソッドです。
     * <br/>
     * <br/>0:正規　1:ダミー
     * 
     * @param gogitaiDummyFlag 合議体ダミーフラグ
     */
    public void setGogitaiDummyFlag(boolean gogitaiDummyFlag) {
        this.gogitaiDummyFlag = gogitaiDummyFlag;
    }

    /**
     * 合議体精神科医存在フラグのgetメソッドです。
     * <br/>
     * <br/>0:いない　1:いる
     * 
     * @return 合議体精神科医存在フラグ
     */
    public boolean getGogitaiSeishinkaiFlag() {
        return gogitaiSeishinkaiFlag;
    }

    /**
     * 合議体精神科医存在フラグのsetメソッドです。
     * <br/>
     * <br/>0:いない　1:いる
     * 
     * @param gogitaiSeishinkaiFlag 合議体精神科医存在フラグ
     */
    public void setGogitaiSeishinkaiFlag(boolean gogitaiSeishinkaiFlag) {
        this.gogitaiSeishinkaiFlag = gogitaiSeishinkaiFlag;
    }

    /**
     * 介護認定審査会休会フラグのgetメソッドです。
     * <br/>
     * <br/>0:開会　1:休会
     * 
     * @return 介護認定審査会休会フラグ
     */
    public boolean getShinsakaiKyukaiFlag() {
        return shinsakaiKyukaiFlag;
    }

    /**
     * 介護認定審査会休会フラグのsetメソッドです。
     * <br/>
     * <br/>0:開会　1:休会
     * 
     * @param shinsakaiKyukaiFlag 介護認定審査会休会フラグ
     */
    public void setShinsakaiKyukaiFlag(boolean shinsakaiKyukaiFlag) {
        this.shinsakaiKyukaiFlag = shinsakaiKyukaiFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7105KaigoninteiJukyuFlagEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7105KaigoninteiJukyuFlagEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7105KaigoninteiJukyuFlagEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7105KaigoninteiJukyuFlagEntity entity) {
        this.kihonJokyoFlag = entity.kihonJokyoFlag;
        this.mobileDataFlag = entity.mobileDataFlag;
        this.ninteiJohoTeikyoKiboAriFlag = entity.ninteiJohoTeikyoKiboAriFlag;
        this.shinsakaiShinsajunKakuteiFlag = entity.shinsakaiShinsajunKakuteiFlag;
        this.gogitaiDummyFlag = entity.gogitaiDummyFlag;
        this.gogitaiSeishinkaiFlag = entity.gogitaiSeishinkaiFlag;
        this.shinsakaiKyukaiFlag = entity.shinsakaiKyukaiFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kihonJokyoFlag, mobileDataFlag, ninteiJohoTeikyoKiboAriFlag, shinsakaiShinsajunKakuteiFlag, gogitaiDummyFlag, gogitaiSeishinkaiFlag, shinsakaiKyukaiFlag);
    }

// </editor-fold>
}
