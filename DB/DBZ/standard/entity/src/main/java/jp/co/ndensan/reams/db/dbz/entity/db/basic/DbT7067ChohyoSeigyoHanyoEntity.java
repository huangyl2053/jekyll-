package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 帳票制御汎用テーブルのエンティティクラスです。
 * <br/> 帳票制御のために必要な、各帳票独自の項目を管理します。
 */
public class DbT7067ChohyoSeigyoHanyoEntity extends DbTableEntityBase<DbT7067ChohyoSeigyoHanyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7067ChohyoSeigyoHanyo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private SubGyomuCode subGyomuCode;
    @PrimaryKey
    private ReportId chohyoBunruiID;
    @PrimaryKey
    private FlexibleYear kanriNendo;
    @PrimaryKey
    private RString komokuName;
    private RString komokuValue;
    private RString komokuSetsumei;
    private boolean henkoKahi;
    private SubGyomuCode codeMasterSubGyomuCode;
    private CodeShubetsu codeMasterCodeShubetsu;

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
     * サブ業務コードのgetメソッドです。
     * 
     * @return サブ業務コード
     */
    public SubGyomuCode getSubGyomuCode() {
        return subGyomuCode;
    }

    /**
     * サブ業務コードのsetメソッドです。
     * 
     * @param subGyomuCode サブ業務コード
     */
    public void setSubGyomuCode(@Nonnull SubGyomuCode subGyomuCode) {
        this.subGyomuCode = subGyomuCode;
    }

    /**
     * 帳票分類IDのgetメソッドです。
     * 
     * @return 帳票分類ID
     */
    public ReportId getChohyoBunruiID() {
        return chohyoBunruiID;
    }

    /**
     * 帳票分類IDのsetメソッドです。
     * 
     * @param chohyoBunruiID 帳票分類ID
     */
    public void setChohyoBunruiID(@Nonnull ReportId chohyoBunruiID) {
        this.chohyoBunruiID = chohyoBunruiID;
    }

    /**
     * 管理年度のgetメソッドです。
     * 
     * @return 管理年度
     */
    public FlexibleYear getKanriNendo() {
        return kanriNendo;
    }

    /**
     * 管理年度のsetメソッドです。
     * 
     * @param kanriNendo 管理年度
     */
    public void setKanriNendo(@Nonnull FlexibleYear kanriNendo) {
        this.kanriNendo = kanriNendo;
    }

    /**
     * 項目名のgetメソッドです。
     * 
     * @return 項目名
     */
    public RString getKomokuName() {
        return komokuName;
    }

    /**
     * 項目名のsetメソッドです。
     * 
     * @param komokuName 項目名
     */
    public void setKomokuName(@Nonnull RString komokuName) {
        this.komokuName = komokuName;
    }

    /**
     * 設定値のgetメソッドです。
     * 
     * @return 設定値
     */
    @CheckForNull
    public RString getKomokuValue() {
        return komokuValue;
    }

    /**
     * 設定値のsetメソッドです。
     * 
     * @param komokuValue 設定値
     */
    public void setKomokuValue(RString komokuValue) {
        this.komokuValue = komokuValue;
    }

    /**
     * 説明のgetメソッドです。
     * 
     * @return 説明
     */
    @CheckForNull
    public RString getKomokuSetsumei() {
        return komokuSetsumei;
    }

    /**
     * 説明のsetメソッドです。
     * 
     * @param komokuSetsumei 説明
     */
    public void setKomokuSetsumei(RString komokuSetsumei) {
        this.komokuSetsumei = komokuSetsumei;
    }

    /**
     * 変更可否のgetメソッドです。
     * 
     * @return 変更可否
     */
    public boolean getHenkoKahi() {
        return henkoKahi;
    }

    /**
     * 変更可否のsetメソッドです。
     * 
     * @param henkoKahi 変更可否
     */
    public void setHenkoKahi(@Nonnull boolean henkoKahi) {
        this.henkoKahi = henkoKahi;
    }

    /**
     * コードマスタサブ業務コードのgetメソッドです。
     * 
     * @return コードマスタサブ業務コード
     */
    @CheckForNull
    public SubGyomuCode getCodeMasterSubGyomuCode() {
        return codeMasterSubGyomuCode;
    }

    /**
     * コードマスタサブ業務コードのsetメソッドです。
     * 
     * @param codeMasterSubGyomuCode コードマスタサブ業務コード
     */
    public void setCodeMasterSubGyomuCode(SubGyomuCode codeMasterSubGyomuCode) {
        this.codeMasterSubGyomuCode = codeMasterSubGyomuCode;
    }

    /**
     * コードマスタコード種別のgetメソッドです。
     * 
     * @return コードマスタコード種別
     */
    @CheckForNull
    public CodeShubetsu getCodeMasterCodeShubetsu() {
        return codeMasterCodeShubetsu;
    }

    /**
     * コードマスタコード種別のsetメソッドです。
     * 
     * @param codeMasterCodeShubetsu コードマスタコード種別
     */
    public void setCodeMasterCodeShubetsu(CodeShubetsu codeMasterCodeShubetsu) {
        this.codeMasterCodeShubetsu = codeMasterCodeShubetsu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7067ChohyoSeigyoHanyoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7067ChohyoSeigyoHanyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7067ChohyoSeigyoHanyoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.subGyomuCode, other.subGyomuCode)) {
            return false;
        }
        if (!Objects.equals(this.chohyoBunruiID, other.chohyoBunruiID)) {
            return false;
        }
        if (!Objects.equals(this.kanriNendo, other.kanriNendo)) {
            return false;
        }
        if (!Objects.equals(this.komokuName, other.komokuName)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7067ChohyoSeigyoHanyoEntity entity) {
        this.subGyomuCode = entity.subGyomuCode;
        this.chohyoBunruiID = entity.chohyoBunruiID;
        this.kanriNendo = entity.kanriNendo;
        this.komokuName = entity.komokuName;
        this.komokuValue = entity.komokuValue;
        this.komokuSetsumei = entity.komokuSetsumei;
        this.henkoKahi = entity.henkoKahi;
        this.codeMasterSubGyomuCode = entity.codeMasterSubGyomuCode;
        this.codeMasterCodeShubetsu = entity.codeMasterCodeShubetsu;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(subGyomuCode, chohyoBunruiID, kanriNendo, komokuName, komokuValue, komokuSetsumei, henkoKahi, codeMasterSubGyomuCode, codeMasterCodeShubetsu);
    }

// </editor-fold>

}
