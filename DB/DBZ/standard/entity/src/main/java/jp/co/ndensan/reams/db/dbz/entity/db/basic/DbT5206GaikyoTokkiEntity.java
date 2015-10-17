package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 認定調査票（概況特記）テーブルのエンティティクラスです。
 */
public class DbT5206GaikyoTokkiEntity extends DbTableEntityBase<DbT5206GaikyoTokkiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5206GaikyoTokki");

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
    private RString shuso;
    private RDateTime shusoImageSharedFileId;
    private RDateTime shusoMaskingImageSharedFileId;
    private RString kazokuJokyo;
    private RDateTime kazokuJokyoImageSharedFileId;
    private RDateTime kazokuJokyoMaskingImageSharedFileId;
    private RString kyojuKankyo;
    private RDateTime kyojuKankyoImageSharedFileId;
    private RDateTime kyojuKankyoMaskingImageSharedFileId;
    private RString kikaiKiki;
    private RDateTime kikaiKikiImageSharedFileId;
    private RDateTime kikaiKikiMaskingImageSharedFileId;

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
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
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
     * 概況特記事項（主訴）のgetメソッドです。
     *
     * @return 概況特記事項（主訴）
     */
    public RString getShuso() {
        return shuso;
    }

    /**
     * 概況特記事項（主訴）のsetメソッドです。
     *
     * @param shuso 概況特記事項（主訴）
     */
    public void setShuso(RString shuso) {
        this.shuso = shuso;
    }

    /**
     * 概況特記（主訴）イメージ共有ファイルIDのgetメソッドです。
     *
     * @return 概況特記（主訴）イメージ共有ファイルID
     */
    public RDateTime getShusoImageSharedFileId() {
        return shusoImageSharedFileId;
    }

    /**
     * 概況特記（主訴）イメージ共有ファイルIDのsetメソッドです。
     *
     * @param shusoImageSharedFileId 概況特記（主訴）イメージ共有ファイルID
     */
    public void setShusoImageSharedFileId(RDateTime shusoImageSharedFileId) {
        this.shusoImageSharedFileId = shusoImageSharedFileId;
    }

    /**
     * 概況特記（主訴）マスキングイメージ共有ファイルIDのgetメソッドです。
     *
     * @return 概況特記（主訴）マスキングイメージ共有ファイルID
     */
    public RDateTime getShusoMaskingImageSharedFileId() {
        return shusoMaskingImageSharedFileId;
    }

    /**
     * 概況特記（主訴）マスキングイメージ共有ファイルIDのsetメソッドです。
     *
     * @param shusoMaskingImageSharedFileId 概況特記（主訴）マスキングイメージ共有ファイルID
     */
    public void setShusoMaskingImageSharedFileId(RDateTime shusoMaskingImageSharedFileId) {
        this.shusoMaskingImageSharedFileId = shusoMaskingImageSharedFileId;
    }

    /**
     * 概況特記事項（家族状況）のgetメソッドです。
     *
     * @return 概況特記事項（家族状況）
     */
    public RString getKazokuJokyo() {
        return kazokuJokyo;
    }

    /**
     * 概況特記事項（家族状況）のsetメソッドです。
     *
     * @param kazokuJokyo 概況特記事項（家族状況）
     */
    public void setKazokuJokyo(RString kazokuJokyo) {
        this.kazokuJokyo = kazokuJokyo;
    }

    /**
     * 概況特記（家族状況）イメージ共有ファイルIDのgetメソッドです。
     *
     * @return 概況特記（家族状況）イメージ共有ファイルID
     */
    public RDateTime getKazokuJokyoImageSharedFileId() {
        return kazokuJokyoImageSharedFileId;
    }

    /**
     * 概況特記（家族状況）イメージ共有ファイルIDのsetメソッドです。
     *
     * @param kazokuJokyoImageSharedFileId 概況特記（家族状況）イメージ共有ファイルID
     */
    public void setKazokuJokyoImageSharedFileId(RDateTime kazokuJokyoImageSharedFileId) {
        this.kazokuJokyoImageSharedFileId = kazokuJokyoImageSharedFileId;
    }

    /**
     * 概況特記（家族状況）マスキングイメージ共有ファイルIDのgetメソッドです。
     *
     * @return 概況特記（家族状況）マスキングイメージ共有ファイルID
     */
    public RDateTime getKazokuJokyoMaskingImageSharedFileId() {
        return kazokuJokyoMaskingImageSharedFileId;
    }

    /**
     * 概況特記（家族状況）マスキングイメージ共有ファイルIDのsetメソッドです。
     *
     * @param kazokuJokyoMaskingImageSharedFileId 概況特記（家族状況）マスキングイメージ共有ファイルID
     */
    public void setKazokuJokyoMaskingImageSharedFileId(RDateTime kazokuJokyoMaskingImageSharedFileId) {
        this.kazokuJokyoMaskingImageSharedFileId = kazokuJokyoMaskingImageSharedFileId;
    }

    /**
     * 概況特記事項（居住環境）のgetメソッドです。
     *
     * @return 概況特記事項（居住環境）
     */
    public RString getKyojuKankyo() {
        return kyojuKankyo;
    }

    /**
     * 概況特記事項（居住環境）のsetメソッドです。
     *
     * @param kyojuKankyo 概況特記事項（居住環境）
     */
    public void setKyojuKankyo(RString kyojuKankyo) {
        this.kyojuKankyo = kyojuKankyo;
    }

    /**
     * 概況特記（居住環境）イメージ共有ファイルIDのgetメソッドです。
     *
     * @return 概況特記（居住環境）イメージ共有ファイルID
     */
    public RDateTime getKyojuKankyoImageSharedFileId() {
        return kyojuKankyoImageSharedFileId;
    }

    /**
     * 概況特記（居住環境）イメージ共有ファイルIDのsetメソッドです。
     *
     * @param kyojuKankyoImageSharedFileId 概況特記（居住環境）イメージ共有ファイルID
     */
    public void setKyojuKankyoImageSharedFileId(RDateTime kyojuKankyoImageSharedFileId) {
        this.kyojuKankyoImageSharedFileId = kyojuKankyoImageSharedFileId;
    }

    /**
     * 概況特記（居住環境）マスキングイメージ共有ファイルIDのgetメソッドです。
     *
     * @return 概況特記（居住環境）マスキングイメージ共有ファイルID
     */
    public RDateTime getKyojuKankyoMaskingImageSharedFileId() {
        return kyojuKankyoMaskingImageSharedFileId;
    }

    /**
     * 概況特記（居住環境）マスキングイメージ共有ファイルIDのsetメソッドです。
     *
     * @param kyojuKankyoMaskingImageSharedFileId 概況特記（居住環境）マスキングイメージ共有ファイルID
     */
    public void setKyojuKankyoMaskingImageSharedFileId(RDateTime kyojuKankyoMaskingImageSharedFileId) {
        this.kyojuKankyoMaskingImageSharedFileId = kyojuKankyoMaskingImageSharedFileId;
    }

    /**
     * 概況特記事項（機器・器械）のgetメソッドです。
     *
     * @return 概況特記事項（機器・器械）
     */
    public RString getKikaiKiki() {
        return kikaiKiki;
    }

    /**
     * 概況特記事項（機器・器械）のsetメソッドです。
     *
     * @param kikaiKiki 概況特記事項（機器・器械）
     */
    public void setKikaiKiki(RString kikaiKiki) {
        this.kikaiKiki = kikaiKiki;
    }

    /**
     * 概況特記（機器・器械）イメージ共有ファイルIDのgetメソッドです。
     *
     * @return 概況特記（機器・器械）イメージ共有ファイルID
     */
    public RDateTime getKikaiKikiImageSharedFileId() {
        return kikaiKikiImageSharedFileId;
    }

    /**
     * 概況特記（機器・器械）イメージ共有ファイルIDのsetメソッドです。
     *
     * @param kikaiKikiImageSharedFileId 概況特記（機器・器械）イメージ共有ファイルID
     */
    public void setKikaiKikiImageSharedFileId(RDateTime kikaiKikiImageSharedFileId) {
        this.kikaiKikiImageSharedFileId = kikaiKikiImageSharedFileId;
    }

    /**
     * 概況特記（機器・器械）マスキングイメージ共有ファイルIDのgetメソッドです。
     *
     * @return 概況特記（機器・器械）マスキングイメージ共有ファイルID
     */
    public RDateTime getKikaiKikiMaskingImageSharedFileId() {
        return kikaiKikiMaskingImageSharedFileId;
    }

    /**
     * 概況特記（機器・器械）マスキングイメージ共有ファイルIDのsetメソッドです。
     *
     * @param kikaiKikiMaskingImageSharedFileId 概況特記（機器・器械）マスキングイメージ共有ファイルID
     */
    public void setKikaiKikiMaskingImageSharedFileId(RDateTime kikaiKikiMaskingImageSharedFileId) {
        this.kikaiKikiMaskingImageSharedFileId = kikaiKikiMaskingImageSharedFileId;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5206GaikyoTokkiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT5206GaikyoTokkiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5206GaikyoTokkiEntity other) {
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
    public void shallowCopy(DbT5206GaikyoTokkiEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ninteichosaRirekiNo = entity.ninteichosaRirekiNo;
        this.shuso = entity.shuso;
        this.shusoImageSharedFileId = entity.shusoImageSharedFileId;
        this.shusoMaskingImageSharedFileId = entity.shusoMaskingImageSharedFileId;
        this.kazokuJokyo = entity.kazokuJokyo;
        this.kazokuJokyoImageSharedFileId = entity.kazokuJokyoImageSharedFileId;
        this.kazokuJokyoMaskingImageSharedFileId = entity.kazokuJokyoMaskingImageSharedFileId;
        this.kyojuKankyo = entity.kyojuKankyo;
        this.kyojuKankyoImageSharedFileId = entity.kyojuKankyoImageSharedFileId;
        this.kyojuKankyoMaskingImageSharedFileId = entity.kyojuKankyoMaskingImageSharedFileId;
        this.kikaiKiki = entity.kikaiKiki;
        this.kikaiKikiImageSharedFileId = entity.kikaiKikiImageSharedFileId;
        this.kikaiKikiMaskingImageSharedFileId = entity.kikaiKikiMaskingImageSharedFileId;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ninteichosaRirekiNo, shuso, shusoImageSharedFileId, shusoMaskingImageSharedFileId, kazokuJokyo, kazokuJokyoImageSharedFileId, kazokuJokyoMaskingImageSharedFileId, kyojuKankyo, kyojuKankyoImageSharedFileId, kyojuKankyoMaskingImageSharedFileId, kikaiKiki, kikaiKikiImageSharedFileId, kikaiKikiMaskingImageSharedFileId);
    }

// </editor-fold>
}
