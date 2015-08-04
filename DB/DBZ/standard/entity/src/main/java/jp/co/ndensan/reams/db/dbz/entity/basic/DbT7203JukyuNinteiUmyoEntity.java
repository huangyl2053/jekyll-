package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 受給認定運用管理テーブルのエンティティクラスです。
 */
public class DbT7203JukyuNinteiUmyoEntity extends DbTableEntityBase<DbT7203JukyuNinteiUmyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7203JukyuNinteiUmyo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShichosonCode shichosonCode;
    private FlexibleDate koshinTaishoChushutsuYMD;
    private FlexibleYearMonth koshinTaishoChushutsuYukoShuryoYM;

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
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    public ShichosonCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * 市町村コードのsetメソッドです。
     *
     * @param shichosonCode 市町村コード
     */
    public void setShichosonCode(ShichosonCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 更新対象抽出処理日のgetメソッドです。
     *
     * @return 更新対象抽出処理日
     */
    public FlexibleDate getKoshinTaishoChushutsuYMD() {
        return koshinTaishoChushutsuYMD;
    }

    /**
     * 更新対象抽出処理日のsetメソッドです。
     *
     * @param koshinTaishoChushutsuYMD 更新対象抽出処理日
     */
    public void setKoshinTaishoChushutsuYMD(FlexibleDate koshinTaishoChushutsuYMD) {
        this.koshinTaishoChushutsuYMD = koshinTaishoChushutsuYMD;
    }

    /**
     * 更新対象抽出有効終了年月のgetメソッドです。
     *
     * @return 更新対象抽出有効終了年月
     */
    public FlexibleYearMonth getKoshinTaishoChushutsuYukoShuryoYM() {
        return koshinTaishoChushutsuYukoShuryoYM;
    }

    /**
     * 更新対象抽出有効終了年月のsetメソッドです。
     *
     * @param koshinTaishoChushutsuYukoShuryoYM 更新対象抽出有効終了年月
     */
    public void setKoshinTaishoChushutsuYukoShuryoYM(FlexibleYearMonth koshinTaishoChushutsuYukoShuryoYM) {
        this.koshinTaishoChushutsuYukoShuryoYM = koshinTaishoChushutsuYukoShuryoYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7203JukyuNinteiUmyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT7203JukyuNinteiUmyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7203JukyuNinteiUmyoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7203JukyuNinteiUmyoEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.koshinTaishoChushutsuYMD = entity.koshinTaishoChushutsuYMD;
        this.koshinTaishoChushutsuYukoShuryoYM = entity.koshinTaishoChushutsuYukoShuryoYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, koshinTaishoChushutsuYMD, koshinTaishoChushutsuYukoShuryoYM
        );
    }

// </editor-fold>
}
