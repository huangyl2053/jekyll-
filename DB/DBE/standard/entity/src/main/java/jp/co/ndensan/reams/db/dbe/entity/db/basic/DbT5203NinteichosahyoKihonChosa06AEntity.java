package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 認定調査票（基本調査）06Aテーブルのエンティティクラスです。
 */
public class DbT5203NinteichosahyoKihonChosa06AEntity extends DbTableEntityBase<DbT5203NinteichosahyoKihonChosa06AEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5203NinteichosahyoKihonChosa06A");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private int ninteichosaRirekiNo;
    private Code koroshoIfShikibetsuCode;
    private Code ninchishoNichijoSeikatsuJiritsudoCode;
    private Code shogaiNichijoSeikatsuJiritsudoCode;

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
     * 申請書管理番号のgetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     * 
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     * 
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(@Nonnull ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 要介護認定調査履歴番号のgetメソッドです。
     * <br/>
     * <br/>認定調査依頼情報
     * 
     * @return 要介護認定調査履歴番号
     */
    public int getNinteichosaRirekiNo() {
        return ninteichosaRirekiNo;
    }

    /**
     * 要介護認定調査履歴番号のsetメソッドです。
     * <br/>
     * <br/>認定調査依頼情報
     * 
     * @param ninteichosaRirekiNo 要介護認定調査履歴番号
     */
    public void setNinteichosaRirekiNo(@Nonnull int ninteichosaRirekiNo) {
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;
    }

    /**
     * 厚労省IF識別コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）
     * 
     * @return 厚労省IF識別コード
     */
    public Code getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    /**
     * 厚労省IF識別コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）
     * 
     * @param koroshoIfShikibetsuCode 厚労省IF識別コード
     */
    public void setKoroshoIfShikibetsuCode(@Nonnull Code koroshoIfShikibetsuCode) {
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    /**
     * 認定調査・認知症高齢者の日常生活自立度コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認知症高齢者自立度コード）
     * 
     * @return 認定調査・認知症高齢者の日常生活自立度コード
     */
    @CheckForNull
    public Code getNinchishoNichijoSeikatsuJiritsudoCode() {
        return ninchishoNichijoSeikatsuJiritsudoCode;
    }

    /**
     * 認定調査・認知症高齢者の日常生活自立度コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認知症高齢者自立度コード）
     * 
     * @param ninchishoNichijoSeikatsuJiritsudoCode 認定調査・認知症高齢者の日常生活自立度コード
     */
    public void setNinchishoNichijoSeikatsuJiritsudoCode(Code ninchishoNichijoSeikatsuJiritsudoCode) {
        this.ninchishoNichijoSeikatsuJiritsudoCode = ninchishoNichijoSeikatsuJiritsudoCode;
    }

    /**
     * 認定調査・障害高齢者の日常生活自立度コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：障害高齢者自立度コード）
     * 
     * @return 認定調査・障害高齢者の日常生活自立度コード
     */
    @CheckForNull
    public Code getShogaiNichijoSeikatsuJiritsudoCode() {
        return shogaiNichijoSeikatsuJiritsudoCode;
    }

    /**
     * 認定調査・障害高齢者の日常生活自立度コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：障害高齢者自立度コード）
     * 
     * @param shogaiNichijoSeikatsuJiritsudoCode 認定調査・障害高齢者の日常生活自立度コード
     */
    public void setShogaiNichijoSeikatsuJiritsudoCode(Code shogaiNichijoSeikatsuJiritsudoCode) {
        this.shogaiNichijoSeikatsuJiritsudoCode = shogaiNichijoSeikatsuJiritsudoCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5203NinteichosahyoKihonChosa06AEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5203NinteichosahyoKihonChosa06AEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5203NinteichosahyoKihonChosa06AEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.ninteichosaRirekiNo != other.ninteichosaRirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5203NinteichosahyoKihonChosa06AEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ninteichosaRirekiNo = entity.ninteichosaRirekiNo;
        this.koroshoIfShikibetsuCode = entity.koroshoIfShikibetsuCode;
        this.ninchishoNichijoSeikatsuJiritsudoCode = entity.ninchishoNichijoSeikatsuJiritsudoCode;
        this.shogaiNichijoSeikatsuJiritsudoCode = entity.shogaiNichijoSeikatsuJiritsudoCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ninteichosaRirekiNo, koroshoIfShikibetsuCode, ninchishoNichijoSeikatsuJiritsudoCode, shogaiNichijoSeikatsuJiritsudoCode);
    }

// </editor-fold>
}
