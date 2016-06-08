package jp.co.ndensan.reams.db.dbz.entity.db.basic;

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
 * 認定調査票（特記情報）テーブルのエンティティクラスです。
 */
public class DbT5205NinteichosahyoTokkijikoEntity extends DbTableEntityBase<DbT5205NinteichosahyoTokkijikoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5205NinteichosahyoTokkijiko");

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
    private RString ninteichosaTokkijikoNo;
    @PrimaryKey
    private int ninteichosaTokkijikoRemban;
    @PrimaryKey
    private RString tokkijikoTextImageKubun;
    @PrimaryKey
    private Code genponMaskKubun;
    private RString tokkiJiko;

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
     * 認定調査特記事項番号のgetメソッドです。
     *
     * @return 認定調査特記事項番号
     */
    public RString getNinteichosaTokkijikoNo() {
        return ninteichosaTokkijikoNo;
    }

    /**
     * 認定調査特記事項番号のsetメソッドです。
     *
     * @param ninteichosaTokkijikoNo 認定調査特記事項番号
     */
    public void setNinteichosaTokkijikoNo(@Nonnull RString ninteichosaTokkijikoNo) {
        this.ninteichosaTokkijikoNo = ninteichosaTokkijikoNo;
    }

    /**
     * 認定調査特記事項連番のgetメソッドです。
     *
     * @return 認定調査特記事項連番
     */
    public int getNinteichosaTokkijikoRemban() {
        return ninteichosaTokkijikoRemban;
    }

    /**
     * 認定調査特記事項連番のsetメソッドです。
     *
     * @param ninteichosaTokkijikoRemban 認定調査特記事項連番
     */
    public void setNinteichosaTokkijikoRemban(@Nonnull int ninteichosaTokkijikoRemban) {
        this.ninteichosaTokkijikoRemban = ninteichosaTokkijikoRemban;
    }

    /**
     * 特記事項テキスト・イメージ区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：特記事項テキスト・イメージ区分）1:テキスト 2:イメージ
     *
     * @return 特記事項テキスト・イメージ区分
     */
    public RString getTokkijikoTextImageKubun() {
        return tokkijikoTextImageKubun;
    }

    /**
     * 特記事項テキスト・イメージ区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：特記事項テキスト・イメージ区分）1:テキスト 2:イメージ
     *
     * @param tokkijikoTextImageKubun 特記事項テキスト・イメージ区分
     */
    public void setTokkijikoTextImageKubun(@Nonnull RString tokkijikoTextImageKubun) {
        this.tokkijikoTextImageKubun = tokkijikoTextImageKubun;
    }

    /**
     * 原本マスク区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：原本マスク区分）1:原本 2:マスク
     *
     * @return 原本マスク区分
     */
    public Code getGenponMaskKubun() {
        return genponMaskKubun;
    }

    /**
     * 原本マスク区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：原本マスク区分）1:原本 2:マスク
     *
     * @param genponMaskKubun 原本マスク区分
     */
    public void setGenponMaskKubun(@Nonnull Code genponMaskKubun) {
        this.genponMaskKubun = genponMaskKubun;
    }

    /**
     * 特記事項のgetメソッドです。
     *
     * @return 特記事項
     */
    @CheckForNull
    public RString getTokkiJiko() {
        return tokkiJiko;
    }

    /**
     * 特記事項のsetメソッドです。
     *
     * @param tokkiJiko 特記事項
     */
    public void setTokkiJiko(RString tokkiJiko) {
        this.tokkiJiko = tokkiJiko;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5205NinteichosahyoTokkijikoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5205NinteichosahyoTokkijikoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5205NinteichosahyoTokkijikoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.ninteichosaRirekiNo != other.ninteichosaRirekiNo) {
            return false;
        }
        if (!Objects.equals(this.ninteichosaTokkijikoNo, other.ninteichosaTokkijikoNo)) {
            return false;
        }
        if (this.ninteichosaTokkijikoRemban != other.ninteichosaTokkijikoRemban) {
            return false;
        }
        if (!Objects.equals(this.tokkijikoTextImageKubun, other.tokkijikoTextImageKubun)) {
            return false;
        }
        if (!Objects.equals(this.genponMaskKubun, other.genponMaskKubun)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5205NinteichosahyoTokkijikoEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ninteichosaRirekiNo = entity.ninteichosaRirekiNo;
        this.ninteichosaTokkijikoNo = entity.ninteichosaTokkijikoNo;
        this.ninteichosaTokkijikoRemban = entity.ninteichosaTokkijikoRemban;
        this.tokkijikoTextImageKubun = entity.tokkijikoTextImageKubun;
        this.genponMaskKubun = entity.genponMaskKubun;
        this.tokkiJiko = entity.tokkiJiko;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ninteichosaRirekiNo, ninteichosaTokkijikoNo, ninteichosaTokkijikoRemban, tokkijikoTextImageKubun, genponMaskKubun, tokkiJiko);
    }

// </editor-fold>
}
