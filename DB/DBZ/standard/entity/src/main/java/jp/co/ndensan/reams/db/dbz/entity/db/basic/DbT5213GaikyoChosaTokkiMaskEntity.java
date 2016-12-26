package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 認定調査票（概況調査）特記マスクテーブルのエンティティクラスです。
 */
public class DbT5213GaikyoChosaTokkiMaskEntity extends DbTableEntityBase<DbT5213GaikyoChosaTokkiMaskEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5213GaikyoChosaTokkiMask");

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
    @PrimaryKey
    private RString gaikyoChosaTextImageKubun;
    private RString tokki;

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
     * 認定調査依頼履歴番号のgetメソッドです。
     * <br/>
     * <br/>認定調査依頼情報
     * 
     * @return 認定調査依頼履歴番号
     */
    public int getNinteichosaRirekiNo() {
        return ninteichosaRirekiNo;
    }

    /**
     * 認定調査依頼履歴番号のsetメソッドです。
     * <br/>
     * <br/>認定調査依頼情報
     * 
     * @param ninteichosaRirekiNo 認定調査依頼履歴番号
     */
    public void setNinteichosaRirekiNo(@Nonnull int ninteichosaRirekiNo) {
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;
    }

    /**
     * 概況調査テキスト・イメージ区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：特記事項テキスト・イメージ区分）1:テキスト 2:イメージ
     * 
     * @return 概況調査テキスト・イメージ区分
     */
    public RString getGaikyoChosaTextImageKubun() {
        return gaikyoChosaTextImageKubun;
    }

    /**
     * 概況調査テキスト・イメージ区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：特記事項テキスト・イメージ区分）1:テキスト 2:イメージ
     * 
     * @param gaikyoChosaTextImageKubun 概況調査テキスト・イメージ区分
     */
    public void setGaikyoChosaTextImageKubun(@Nonnull RString gaikyoChosaTextImageKubun) {
        this.gaikyoChosaTextImageKubun = gaikyoChosaTextImageKubun;
    }

    /**
     * 特記のgetメソッドです。
     * <br/>
     * <br/>マスクした特記
     * 
     * @return 特記
     */
    @CheckForNull
    public RString getTokki() {
        return tokki;
    }

    /**
     * 特記のsetメソッドです。
     * <br/>
     * <br/>マスクした特記
     * 
     * @param tokki 特記
     */
    public void setTokki(RString tokki) {
        this.tokki = tokki;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5213GaikyoChosaTokkiMaskEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5213GaikyoChosaTokkiMaskEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5213GaikyoChosaTokkiMaskEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.ninteichosaRirekiNo != other.ninteichosaRirekiNo) {
            return false;
        }
        if (!Objects.equals(this.gaikyoChosaTextImageKubun, other.gaikyoChosaTextImageKubun)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5213GaikyoChosaTokkiMaskEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ninteichosaRirekiNo = entity.ninteichosaRirekiNo;
        this.gaikyoChosaTextImageKubun = entity.gaikyoChosaTextImageKubun;
        this.tokki = entity.tokki;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ninteichosaRirekiNo, gaikyoChosaTextImageKubun, tokki);
    }

// </editor-fold>
}
