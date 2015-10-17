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

/**
 * 認定調査票（特記情報）テーブルのエンティティクラスです。
 */
public class DbT4205NinteichosahyoTokkijikoEntity extends DbTableEntityBase<DbT4205NinteichosahyoTokkijikoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4205NinteichosahyoTokkijiko");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString shinseishoKanriNo;
    @PrimaryKey
    private int ninteichosaRirekiNo;
    @PrimaryKey
    private RString ninteichosaTokkijikoNo;
    @PrimaryKey
    private RString ninteichosaTokkijikoRenban;
    @PrimaryKey
    private RString tokkijikoTextImageKubun;
    @PrimaryKey
    private Code genponMaskKubun;
    private RString tokkiJiko;
    private RDateTime tokkiJikoImageSharedFileId;
    private RDateTime tokkiJikoMaskingImageSharedFileId;

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
    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     * 
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
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
    public void setNinteichosaRirekiNo(int ninteichosaRirekiNo) {
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
    public void setNinteichosaTokkijikoNo(RString ninteichosaTokkijikoNo) {
        this.ninteichosaTokkijikoNo = ninteichosaTokkijikoNo;
    }

    /**
     * 認定調査特記事項連番のgetメソッドです。
     * 
     * @return 認定調査特記事項連番
     */
    public RString getNinteichosaTokkijikoRenban() {
        return ninteichosaTokkijikoRenban;
    }

    /**
     * 認定調査特記事項連番のsetメソッドです。
     * 
     * @param ninteichosaTokkijikoRenban 認定調査特記事項連番
     */
    public void setNinteichosaTokkijikoRenban(RString ninteichosaTokkijikoRenban) {
        this.ninteichosaTokkijikoRenban = ninteichosaTokkijikoRenban;
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
    public void setTokkijikoTextImageKubun(RString tokkijikoTextImageKubun) {
        this.tokkijikoTextImageKubun = tokkijikoTextImageKubun;
    }

    /**
     * 原本マスク区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：原本マスク区分）1:原本  2:マスク
     * 
     * @return 原本マスク区分
     */
    public Code getGenponMaskKubun() {
        return genponMaskKubun;
    }

    /**
     * 原本マスク区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：原本マスク区分）1:原本  2:マスク
     * 
     * @param genponMaskKubun 原本マスク区分
     */
    public void setGenponMaskKubun(Code genponMaskKubun) {
        this.genponMaskKubun = genponMaskKubun;
    }

    /**
     * 特記事項のgetメソッドです。
     * 
     * @return 特記事項
     */
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
     * 特記事項イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 特記事項イメージ共有ファイルID
     */
    public RDateTime getTokkiJikoImageSharedFileId() {
        return tokkiJikoImageSharedFileId;
    }

    /**
     * 特記事項イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param tokkiJikoImageSharedFileId 特記事項イメージ共有ファイルID
     */
    public void setTokkiJikoImageSharedFileId(RDateTime tokkiJikoImageSharedFileId) {
        this.tokkiJikoImageSharedFileId = tokkiJikoImageSharedFileId;
    }

    /**
     * 特記事項マスキングイメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 特記事項マスキングイメージ共有ファイルID
     */
    public RDateTime getTokkiJikoMaskingImageSharedFileId() {
        return tokkiJikoMaskingImageSharedFileId;
    }

    /**
     * 特記事項マスキングイメージ共有ファイルIDのsetメソッドです。
     * 
     * @param tokkiJikoMaskingImageSharedFileId 特記事項マスキングイメージ共有ファイルID
     */
    public void setTokkiJikoMaskingImageSharedFileId(RDateTime tokkiJikoMaskingImageSharedFileId) {
        this.tokkiJikoMaskingImageSharedFileId = tokkiJikoMaskingImageSharedFileId;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4205NinteichosahyoTokkijikoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4205NinteichosahyoTokkijikoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4205NinteichosahyoTokkijikoEntity other) {
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
        if (!Objects.equals(this.ninteichosaTokkijikoRenban, other.ninteichosaTokkijikoRenban)) {
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
    public void shallowCopy(DbT4205NinteichosahyoTokkijikoEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ninteichosaRirekiNo = entity.ninteichosaRirekiNo;
        this.ninteichosaTokkijikoNo = entity.ninteichosaTokkijikoNo;
        this.ninteichosaTokkijikoRenban = entity.ninteichosaTokkijikoRenban;
        this.tokkijikoTextImageKubun = entity.tokkijikoTextImageKubun;
        this.genponMaskKubun = entity.genponMaskKubun;
        this.tokkiJiko = entity.tokkiJiko;
        this.tokkiJikoImageSharedFileId = entity.tokkiJikoImageSharedFileId;
        this.tokkiJikoMaskingImageSharedFileId = entity.tokkiJikoMaskingImageSharedFileId;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ninteichosaRirekiNo, ninteichosaTokkijikoNo, ninteichosaTokkijikoRenban, tokkijikoTextImageKubun, genponMaskKubun, tokkiJiko, tokkiJikoImageSharedFileId, tokkiJikoMaskingImageSharedFileId);
    }

// </editor-fold>
}
