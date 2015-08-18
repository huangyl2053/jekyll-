package jp.co.ndensan.reams.db.dbx.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;

/**
 * 介護導入形態テーブルのエンティティクラスです。
 * <br/> 介護事務と介護認定を導入する形態を識別する制御情報を定義します
 */
public class DbT7908KaigoDonyuKeitaiEntity extends DbTableEntityBase<DbT7908KaigoDonyuKeitaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7908KaigoDonyuKeitai");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString gyomuBunrui;
    @PrimaryKey
    private Code donyuKeitaiCode;
    private boolean shishoKanriUmuFlag;

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
     * 業務分類のgetメソッドです。
     *
     * @return 業務分類
     */
    public RString getGyomuBunrui() {
        return gyomuBunrui;
    }

    /**
     * 業務分類のsetメソッドです。
     *
     * @param gyomuBunrui 業務分類
     */
    public void setGyomuBunrui(RString gyomuBunrui) {
        this.gyomuBunrui = gyomuBunrui;
    }

    /**
     * 導入形態コードのgetメソッドです。
     *
     * @return 導入形態コード
     */
    public Code getDonyuKeitaiCode() {
        return donyuKeitaiCode;
    }

    /**
     * 導入形態コードのsetメソッドです。
     *
     * @param donyuKeitaiCode 導入形態コード
     */
    public void setDonyuKeitaiCode(Code donyuKeitaiCode) {
        this.donyuKeitaiCode = donyuKeitaiCode;
    }

    /**
     * 支所管理有無フラグのgetメソッドです。
     *
     * @return 支所管理有無フラグ
     */
    public boolean getShishoKanriUmuFlag() {
        return shishoKanriUmuFlag;
    }

    /**
     * 支所管理有無フラグのsetメソッドです。
     *
     * @param shishoKanriUmuFlag 支所管理有無フラグ
     */
    public void setShishoKanriUmuFlag(boolean shishoKanriUmuFlag) {
        this.shishoKanriUmuFlag = shishoKanriUmuFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7908KaigoDonyuKeitaiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7908KaigoDonyuKeitaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7908KaigoDonyuKeitaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.gyomuBunrui, other.gyomuBunrui)) {
            return false;
        }
        if (!Objects.equals(this.donyuKeitaiCode, other.donyuKeitaiCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7908KaigoDonyuKeitaiEntity entity) {
        this.gyomuBunrui = entity.gyomuBunrui;
        this.donyuKeitaiCode = entity.donyuKeitaiCode;
        this.shishoKanriUmuFlag = entity.shishoKanriUmuFlag;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(gyomuBunrui, donyuKeitaiCode, shishoKanriUmuFlag);
    }

// </editor-fold>
}
