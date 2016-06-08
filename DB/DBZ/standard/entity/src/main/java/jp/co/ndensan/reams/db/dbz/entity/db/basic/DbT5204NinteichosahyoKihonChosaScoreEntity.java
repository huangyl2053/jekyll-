package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 認定調査票（基本調査素点）テーブルのエンティティクラスです。
 */
public class DbT5204NinteichosahyoKihonChosaScoreEntity extends DbTableEntityBase<DbT5204NinteichosahyoKihonChosaScoreEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5204NinteichosahyoKihonChosaScore");

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
    private int tokutenTotal1gun;
    private int tokutenTotal2gun;
    private int tokutenTotal3gun;
    private int tokutenTotal4gun;
    private int tokutenTotal5gun;
    private int tokutenTotal6gun;
    private int tokutenTotal7gun;

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
    public void setNinteichosaRirekiNo(int ninteichosaRirekiNo) {
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
    public void setKoroshoIfShikibetsuCode(Code koroshoIfShikibetsuCode) {
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    /**
     * 素点合計　第１郡のgetメソッドです。
     *
     * @return 素点合計　第１郡
     */
    public int getTokutenTotal1gun() {
        return tokutenTotal1gun;
    }

    /**
     * 素点合計　第１郡のsetメソッドです。
     *
     * @param tokutenTotal1gun 素点合計　第１郡
     */
    public void setTokutenTotal1gun(int tokutenTotal1gun) {
        this.tokutenTotal1gun = tokutenTotal1gun;
    }

    /**
     * 素点合計　第２郡のgetメソッドです。
     *
     * @return 素点合計　第２郡
     */
    public int getTokutenTotal2gun() {
        return tokutenTotal2gun;
    }

    /**
     * 素点合計　第２郡のsetメソッドです。
     *
     * @param tokutenTotal2gun 素点合計　第２郡
     */
    public void setTokutenTotal2gun(int tokutenTotal2gun) {
        this.tokutenTotal2gun = tokutenTotal2gun;
    }

    /**
     * 素点合計　第３郡のgetメソッドです。
     *
     * @return 素点合計　第３郡
     */
    public int getTokutenTotal3gun() {
        return tokutenTotal3gun;
    }

    /**
     * 素点合計　第３郡のsetメソッドです。
     *
     * @param tokutenTotal3gun 素点合計　第３郡
     */
    public void setTokutenTotal3gun(int tokutenTotal3gun) {
        this.tokutenTotal3gun = tokutenTotal3gun;
    }

    /**
     * 素点合計　第４郡のgetメソッドです。
     *
     * @return 素点合計　第４郡
     */
    public int getTokutenTotal4gun() {
        return tokutenTotal4gun;
    }

    /**
     * 素点合計　第４郡のsetメソッドです。
     *
     * @param tokutenTotal4gun 素点合計　第４郡
     */
    public void setTokutenTotal4gun(int tokutenTotal4gun) {
        this.tokutenTotal4gun = tokutenTotal4gun;
    }

    /**
     * 素点合計　第５郡のgetメソッドです。
     *
     * @return 素点合計　第５郡
     */
    public int getTokutenTotal5gun() {
        return tokutenTotal5gun;
    }

    /**
     * 素点合計　第５郡のsetメソッドです。
     *
     * @param tokutenTotal5gun 素点合計　第５郡
     */
    public void setTokutenTotal5gun(int tokutenTotal5gun) {
        this.tokutenTotal5gun = tokutenTotal5gun;
    }

    /**
     * 素点合計　第６郡のgetメソッドです。
     *
     * @return 素点合計　第６郡
     */
    public int getTokutenTotal6gun() {
        return tokutenTotal6gun;
    }

    /**
     * 素点合計　第６郡のsetメソッドです。
     *
     * @param tokutenTotal6gun 素点合計　第６郡
     */
    public void setTokutenTotal6gun(int tokutenTotal6gun) {
        this.tokutenTotal6gun = tokutenTotal6gun;
    }

    /**
     * 素点合計　第７郡のgetメソッドです。
     *
     * @return 素点合計　第７郡
     */
    public int getTokutenTotal7gun() {
        return tokutenTotal7gun;
    }

    /**
     * 素点合計　第７郡のsetメソッドです。
     *
     * @param tokutenTotal7gun 素点合計　第７郡
     */
    public void setTokutenTotal7gun(int tokutenTotal7gun) {
        this.tokutenTotal7gun = tokutenTotal7gun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5204NinteichosahyoKihonChosaScoreEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5204NinteichosahyoKihonChosaScoreEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5204NinteichosahyoKihonChosaScoreEntity other) {
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
    public void shallowCopy(DbT5204NinteichosahyoKihonChosaScoreEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ninteichosaRirekiNo = entity.ninteichosaRirekiNo;
        this.koroshoIfShikibetsuCode = entity.koroshoIfShikibetsuCode;
        this.tokutenTotal1gun = entity.tokutenTotal1gun;
        this.tokutenTotal2gun = entity.tokutenTotal2gun;
        this.tokutenTotal3gun = entity.tokutenTotal3gun;
        this.tokutenTotal4gun = entity.tokutenTotal4gun;
        this.tokutenTotal5gun = entity.tokutenTotal5gun;
        this.tokutenTotal6gun = entity.tokutenTotal6gun;
        this.tokutenTotal7gun = entity.tokutenTotal7gun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ninteichosaRirekiNo, koroshoIfShikibetsuCode, tokutenTotal1gun, tokutenTotal2gun, tokutenTotal3gun, tokutenTotal4gun, tokutenTotal5gun, tokutenTotal6gun, tokutenTotal7gun);
    }

// </editor-fold>
}
