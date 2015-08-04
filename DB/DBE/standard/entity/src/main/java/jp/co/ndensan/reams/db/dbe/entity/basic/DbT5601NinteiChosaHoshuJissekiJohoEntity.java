package jp.co.ndensan.reams.db.dbe.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 認定調査報酬実績情報テーブルのエンティティクラスです。
 */
public class DbT5601NinteiChosaHoshuJissekiJohoEntity extends DbTableEntityBase<DbT5601NinteiChosaHoshuJissekiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5601NinteiChosaHoshuJissekiJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private JigyoshaNo ninteichosaItakusakiCode;
    @PrimaryKey
    private RString ninteichosainCode;
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private int ninteichosaIraiRirekiNo;
    private int chosaItakuryo;
    private FlexibleDate chosaItakuryoShiharaiYMD;
    private RString chosaItakuryoShiharaiMemo;
    private boolean isGinkoFurikomiShutsuryoku;

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
     * 認定調査委託先コードのgetメソッドです。
     *
     * @return 認定調査委託先コード
     */
    public JigyoshaNo getNinteichosaItakusakiCode() {
        return ninteichosaItakusakiCode;
    }

    /**
     * 認定調査委託先コードのsetメソッドです。
     *
     * @param ninteichosaItakusakiCode 認定調査委託先コード
     */
    public void setNinteichosaItakusakiCode(JigyoshaNo ninteichosaItakusakiCode) {
        this.ninteichosaItakusakiCode = ninteichosaItakusakiCode;
    }

    /**
     * 認定調査員コードのgetメソッドです。
     *
     * @return 認定調査員コード
     */
    public RString getNinteichosainCode() {
        return ninteichosainCode;
    }

    /**
     * 認定調査員コードのsetメソッドです。
     *
     * @param ninteichosainCode 認定調査員コード
     */
    public void setNinteichosainCode(RString ninteichosainCode) {
        this.ninteichosainCode = ninteichosainCode;
    }

    /**
     * 申請書管理番号のgetメソッドです。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     *
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 認定調査依頼履歴番号のgetメソッドです。
     *
     * @return 認定調査依頼履歴番号
     */
    public int getNinteichosaIraiRirekiNo() {
        return ninteichosaIraiRirekiNo;
    }

    /**
     * 認定調査依頼履歴番号のsetメソッドです。
     *
     * @param ninteichosaIraiRirekiNo 認定調査依頼履歴番号
     */
    public void setNinteichosaIraiRirekiNo(int ninteichosaIraiRirekiNo) {
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
    }

    /**
     * 認定調査委託料のgetメソッドです。
     *
     * @return 認定調査委託料
     */
    public int getChosaItakuryo() {
        return chosaItakuryo;
    }

    /**
     * 認定調査委託料のsetメソッドです。
     *
     * @param chosaItakuryo 認定調査委託料
     */
    public void setChosaItakuryo(int chosaItakuryo) {
        this.chosaItakuryo = chosaItakuryo;
    }

    /**
     * 認定調査委託料支払年月日のgetメソッドです。
     *
     * @return 認定調査委託料支払年月日
     */
    public FlexibleDate getChosaItakuryoShiharaiYMD() {
        return chosaItakuryoShiharaiYMD;
    }

    /**
     * 認定調査委託料支払年月日のsetメソッドです。
     *
     * @param chosaItakuryoShiharaiYMD 認定調査委託料支払年月日
     */
    public void setChosaItakuryoShiharaiYMD(FlexibleDate chosaItakuryoShiharaiYMD) {
        this.chosaItakuryoShiharaiYMD = chosaItakuryoShiharaiYMD;
    }

    /**
     * 認定調査委託料支払メモのgetメソッドです。
     *
     * @return 認定調査委託料支払メモ
     */
    public RString getChosaItakuryoShiharaiMemo() {
        return chosaItakuryoShiharaiMemo;
    }

    /**
     * 認定調査委託料支払メモのsetメソッドです。
     *
     * @param chosaItakuryoShiharaiMemo 認定調査委託料支払メモ
     */
    public void setChosaItakuryoShiharaiMemo(RString chosaItakuryoShiharaiMemo) {
        this.chosaItakuryoShiharaiMemo = chosaItakuryoShiharaiMemo;
    }

    /**
     * 銀行振込出力フラグのgetメソッドです。
     *
     * @return 銀行振込出力フラグ
     */
    public boolean getIsGinkoFurikomiShutsuryoku() {
        return isGinkoFurikomiShutsuryoku;
    }

    /**
     * 銀行振込出力フラグのsetメソッドです。
     *
     * @param isGinkoFurikomiShutsuryoku 銀行振込出力フラグ
     */
    public void setIsGinkoFurikomiShutsuryoku(boolean isGinkoFurikomiShutsuryoku) {
        this.isGinkoFurikomiShutsuryoku = isGinkoFurikomiShutsuryoku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5601NinteiChosaHoshuJissekiJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5601NinteiChosaHoshuJissekiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5601NinteiChosaHoshuJissekiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.ninteichosaItakusakiCode, other.ninteichosaItakusakiCode)) {
            return false;
        }
        if (!Objects.equals(this.ninteichosainCode, other.ninteichosainCode)) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.ninteichosaIraiRirekiNo != other.ninteichosaIraiRirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5601NinteiChosaHoshuJissekiJohoEntity entity) {
        this.ninteichosaItakusakiCode = entity.ninteichosaItakusakiCode;
        this.ninteichosainCode = entity.ninteichosainCode;
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ninteichosaIraiRirekiNo = entity.ninteichosaIraiRirekiNo;
        this.chosaItakuryo = entity.chosaItakuryo;
        this.chosaItakuryoShiharaiYMD = entity.chosaItakuryoShiharaiYMD;
        this.chosaItakuryoShiharaiMemo = entity.chosaItakuryoShiharaiMemo;
        this.isGinkoFurikomiShutsuryoku = entity.isGinkoFurikomiShutsuryoku;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(ninteichosaItakusakiCode, ninteichosainCode, shinseishoKanriNo, ninteichosaIraiRirekiNo, chosaItakuryo, chosaItakuryoShiharaiYMD, chosaItakuryoShiharaiMemo, isGinkoFurikomiShutsuryoku);
    }

// </editor-fold>
}
