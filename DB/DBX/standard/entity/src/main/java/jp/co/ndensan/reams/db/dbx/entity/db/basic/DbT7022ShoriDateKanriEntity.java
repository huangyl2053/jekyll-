package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT7022ShoriDateKanriの項目定義クラスです
 *
 */
public class DbT7022ShoriDateKanriEntity extends DbTableEntityBase<DbT7022ShoriDateKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7022ShoriDateKanri");

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
    private LasdecCode shichosonCode;
    @PrimaryKey
    private RString shoriName;
    @PrimaryKey
    private RString shoriEdaban;
    @PrimaryKey
    private FlexibleYear nendo;
    @PrimaryKey
    private RString nendoNaiRenban;
    private FlexibleDate kijunYMD;
    private YMDHMS kijunTimestamp;
    private FlexibleDate taishoKaishiYMD;
    private FlexibleDate taishoShuryoYMD;
    private YMDHMS taishoKaishiTimestamp;
    private YMDHMS taishoShuryoTimestamp;

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
    public void setSubGyomuCode(SubGyomuCode subGyomuCode) {
        this.subGyomuCode = subGyomuCode;
    }

    /**
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * 市町村コードのsetメソッドです。
     *
     * @param shichosonCode 市町村コード
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 処理名のgetメソッドです。
     *
     * @return 処理名
     */
    public RString getShoriName() {
        return shoriName;
    }

    /**
     * 処理名のsetメソッドです。
     *
     * @param shoriName 処理名
     */
    public void setShoriName(RString shoriName) {
        this.shoriName = shoriName;
    }

    /**
     * 処理枝番のgetメソッドです。
     * <br/>
     * <br/>01から連番
     *
     * @return 処理枝番
     */
    public RString getShoriEdaban() {
        return shoriEdaban;
    }

    /**
     * 処理枝番のsetメソッドです。
     * <br/>
     * <br/>01から連番
     *
     * @param shoriEdaban 処理枝番
     */
    public void setShoriEdaban(RString shoriEdaban) {
        this.shoriEdaban = shoriEdaban;
    }

    /**
     * 年度のgetメソッドです。
     * <br/>
     * <br/>使用しない場合は「0000」固定
     *
     * @return 年度
     */
    public FlexibleYear getNendo() {
        return nendo;
    }

    /**
     * 年度のsetメソッドです。
     * <br/>
     * <br/>使用しない場合は「0000」固定
     *
     * @param nendo 年度
     */
    public void setNendo(FlexibleYear nendo) {
        this.nendo = nendo;
    }

    /**
     * 年度内連番のgetメソッドです。
     * <br/>
     * <br/>01から連番
     *
     * @return 年度内連番
     */
    public RString getNendoNaiRenban() {
        return nendoNaiRenban;
    }

    /**
     * 年度内連番のsetメソッドです。
     * <br/>
     * <br/>01から連番
     *
     * @param nendoNaiRenban 年度内連番
     */
    public void setNendoNaiRenban(RString nendoNaiRenban) {
        this.nendoNaiRenban = nendoNaiRenban;
    }

    /**
     * 基準年月日のgetメソッドです。
     *
     * @return 基準年月日
     */
    public FlexibleDate getKijunYMD() {
        return kijunYMD;
    }

    /**
     * 基準年月日のsetメソッドです。
     *
     * @param kijunYMD 基準年月日
     */
    public void setKijunYMD(FlexibleDate kijunYMD) {
        this.kijunYMD = kijunYMD;
    }

    /**
     * 基準日時のgetメソッドです。
     *
     * @return 基準日時
     */
    public YMDHMS getKijunTimestamp() {
        return kijunTimestamp;
    }

    /**
     * 基準日時のsetメソッドです。
     *
     * @param kijunTimestamp 基準日時
     */
    public void setKijunTimestamp(YMDHMS kijunTimestamp) {
        this.kijunTimestamp = kijunTimestamp;
    }

    /**
     * 対象開始年月日のgetメソッドです。
     *
     * @return 対象開始年月日
     */
    public FlexibleDate getTaishoKaishiYMD() {
        return taishoKaishiYMD;
    }

    /**
     * 対象開始年月日のsetメソッドです。
     *
     * @param taishoKaishiYMD 対象開始年月日
     */
    public void setTaishoKaishiYMD(FlexibleDate taishoKaishiYMD) {
        this.taishoKaishiYMD = taishoKaishiYMD;
    }

    /**
     * 対象終了年月日のgetメソッドです。
     *
     * @return 対象終了年月日
     */
    public FlexibleDate getTaishoShuryoYMD() {
        return taishoShuryoYMD;
    }

    /**
     * 対象終了年月日のsetメソッドです。
     *
     * @param taishoShuryoYMD 対象終了年月日
     */
    public void setTaishoShuryoYMD(FlexibleDate taishoShuryoYMD) {
        this.taishoShuryoYMD = taishoShuryoYMD;
    }

    /**
     * 対象開始日時のgetメソッドです。
     *
     * @return 対象開始日時
     */
    public YMDHMS getTaishoKaishiTimestamp() {
        return taishoKaishiTimestamp;
    }

    /**
     * 対象開始日時のsetメソッドです。
     *
     * @param taishoKaishiTimestamp 対象開始日時
     */
    public void setTaishoKaishiTimestamp(YMDHMS taishoKaishiTimestamp) {
        this.taishoKaishiTimestamp = taishoKaishiTimestamp;
    }

    /**
     * 対象終了日時のgetメソッドです。
     *
     * @return 対象終了日時
     */
    public YMDHMS getTaishoShuryoTimestamp() {
        return taishoShuryoTimestamp;
    }

    /**
     * 対象終了日時のsetメソッドです。
     *
     * @param taishoShuryoTimestamp 対象終了日時
     */
    public void setTaishoShuryoTimestamp(YMDHMS taishoShuryoTimestamp) {
        this.taishoShuryoTimestamp = taishoShuryoTimestamp;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7022ShoriDateKanriEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT7022ShoriDateKanriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7022ShoriDateKanriEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.subGyomuCode, other.subGyomuCode)) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.shoriName, other.shoriName)) {
            return false;
        }
        if (!Objects.equals(this.shoriEdaban, other.shoriEdaban)) {
            return false;
        }
        if (!Objects.equals(this.nendo, other.nendo)) {
            return false;
        }
        if (!Objects.equals(this.nendoNaiRenban, other.nendoNaiRenban)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7022ShoriDateKanriEntity entity) {
        this.subGyomuCode = entity.subGyomuCode;
        this.shichosonCode = entity.shichosonCode;
        this.shoriName = entity.shoriName;
        this.shoriEdaban = entity.shoriEdaban;
        this.nendo = entity.nendo;
        this.nendoNaiRenban = entity.nendoNaiRenban;
        this.kijunYMD = entity.kijunYMD;
        this.kijunTimestamp = entity.kijunTimestamp;
        this.taishoKaishiYMD = entity.taishoKaishiYMD;
        this.taishoShuryoYMD = entity.taishoShuryoYMD;
        this.taishoKaishiTimestamp = entity.taishoKaishiTimestamp;
        this.taishoShuryoTimestamp = entity.taishoShuryoTimestamp;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(subGyomuCode, shichosonCode, shoriName, shoriEdaban, nendo, nendoNaiRenban, kijunYMD, kijunTimestamp, taishoKaishiYMD, taishoShuryoYMD, taishoKaishiTimestamp, taishoShuryoTimestamp);
    }

// </editor-fold>
}
