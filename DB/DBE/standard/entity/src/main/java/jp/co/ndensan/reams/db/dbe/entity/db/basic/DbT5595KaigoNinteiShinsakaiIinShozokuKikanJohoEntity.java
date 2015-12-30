package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 介護認定審査会委員所属機関情報テーブルのエンティティクラスです。
 */
public class DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity extends DbTableEntityBase<DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5595KaigoNinteiShinsakaiIinShozokuKikanJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString shinsakaiIinCode;
    @PrimaryKey
    private int remban;
    private RString jigyoshaKubun;
    private FlexibleDate shozokuKaishiYMD;
    private FlexibleDate shozokuShuryoYMD;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private RString shujiiIryokikanCode;
    private RString shujiiCode;
    private RString ninteichosaItakusakiCode;
    private RString ninteiChosainNo;
    private RString sonotaKikanCode;

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
     * 介護認定審査会委員コードのgetメソッドです。
     *
     * @return 介護認定審査会委員コード
     */
    public RString getShinsakaiIinCode() {
        return shinsakaiIinCode;
    }

    /**
     * 介護認定審査会委員コードのsetメソッドです。
     *
     * @param shinsakaiIinCode 介護認定審査会委員コード
     */
    public void setShinsakaiIinCode(@Nonnull RString shinsakaiIinCode) {
        this.shinsakaiIinCode = shinsakaiIinCode;
    }

    /**
     * 連番のgetメソッドです。
     *
     * @return 連番
     */
    public int getRemban() {
        return remban;
    }

    /**
     * 連番のsetメソッドです。
     *
     * @param remban 連番
     */
    public void setRemban(@Nonnull int remban) {
        this.remban = remban;
    }

    /**
     * 事業者区分のgetメソッドです。
     *
     * @return 事業者区分
     */
    @CheckForNull
    public RString getJigyoshaKubun() {
        return jigyoshaKubun;
    }

    /**
     * 事業者区分のsetメソッドです。
     *
     * @param jigyoshaKubun 事業者区分
     */
    public void setJigyoshaKubun(RString jigyoshaKubun) {
        this.jigyoshaKubun = jigyoshaKubun;
    }

    /**
     * 所属開始年月日のgetメソッドです。
     *
     * @return 所属開始年月日
     */
    @CheckForNull
    public FlexibleDate getShozokuKaishiYMD() {
        return shozokuKaishiYMD;
    }

    /**
     * 所属開始年月日のsetメソッドです。
     *
     * @param shozokuKaishiYMD 所属開始年月日
     */
    public void setShozokuKaishiYMD(FlexibleDate shozokuKaishiYMD) {
        this.shozokuKaishiYMD = shozokuKaishiYMD;
    }

    /**
     * 所属終了年月日のgetメソッドです。
     *
     * @return 所属終了年月日
     */
    @CheckForNull
    public FlexibleDate getShozokuShuryoYMD() {
        return shozokuShuryoYMD;
    }

    /**
     * 所属終了年月日のsetメソッドです。
     *
     * @param shozokuShuryoYMD 所属終了年月日
     */
    public void setShozokuShuryoYMD(FlexibleDate shozokuShuryoYMD) {
        this.shozokuShuryoYMD = shozokuShuryoYMD;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    @CheckForNull
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 主治医医療機関コードのgetメソッドです。
     * <br/>
     * <br/>証記載保険者番号＋主治医医療機関コード
     *
     * @return 主治医医療機関コード
     */
    @CheckForNull
    public RString getShujiiIryokikanCode() {
        return shujiiIryokikanCode;
    }

    /**
     * 主治医医療機関コードのsetメソッドです。
     * <br/>
     * <br/>証記載保険者番号＋主治医医療機関コード
     *
     * @param shujiiIryokikanCode 主治医医療機関コード
     */
    public void setShujiiIryokikanCode(RString shujiiIryokikanCode) {
        this.shujiiIryokikanCode = shujiiIryokikanCode;
    }

    /**
     * 主治医コードのgetメソッドです。
     * <br/>
     * <br/>証記載保険者番号＋主治医医療機関コード＋主治医コード
     *
     * @return 主治医コード
     */
    @CheckForNull
    public RString getShujiiCode() {
        return shujiiCode;
    }

    /**
     * 主治医コードのsetメソッドです。
     * <br/>
     * <br/>証記載保険者番号＋主治医医療機関コード＋主治医コード
     *
     * @param shujiiCode 主治医コード
     */
    public void setShujiiCode(RString shujiiCode) {
        this.shujiiCode = shujiiCode;
    }

    /**
     * 認定調査委託先コードのgetメソッドです。
     * <br/>
     * <br/>証記載保険者番号＋認定調査委託先コード
     *
     * @return 認定調査委託先コード
     */
    @CheckForNull
    public RString getNinteichosaItakusakiCode() {
        return ninteichosaItakusakiCode;
    }

    /**
     * 認定調査委託先コードのsetメソッドです。
     * <br/>
     * <br/>証記載保険者番号＋認定調査委託先コード
     *
     * @param ninteichosaItakusakiCode 認定調査委託先コード
     */
    public void setNinteichosaItakusakiCode(RString ninteichosaItakusakiCode) {
        this.ninteichosaItakusakiCode = ninteichosaItakusakiCode;
    }

    /**
     * 認定調査員コードのgetメソッドです。
     * <br/>
     * <br/>証記載保険者番号＋認定調査委託先コード＋認定調査員コード
     *
     * @return 認定調査員コード
     */
    @CheckForNull
    public RString getNinteiChosainNo() {
        return ninteiChosainNo;
    }

    /**
     * 認定調査員コードのsetメソッドです。
     * <br/>
     * <br/>証記載保険者番号＋認定調査委託先コード＋認定調査員コード
     *
     * @param ninteiChosainNo 認定調査員コード
     */
    public void setNinteiChosainNo(RString ninteiChosainNo) {
        this.ninteiChosainNo = ninteiChosainNo;
    }

    /**
     * その他機関コードのgetメソッドです。
     * <br/>
     * <br/>証記載保険者番号＋その他機関コード
     *
     * @return その他機関コード
     */
    @CheckForNull
    public RString getSonotaKikanCode() {
        return sonotaKikanCode;
    }

    /**
     * その他機関コードのsetメソッドです。
     * <br/>
     * <br/>証記載保険者番号＋その他機関コード
     *
     * @param sonotaKikanCode その他機関コード
     */
    public void setSonotaKikanCode(RString sonotaKikanCode) {
        this.sonotaKikanCode = sonotaKikanCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinsakaiIinCode, other.shinsakaiIinCode)) {
            return false;
        }
        if (this.remban != other.remban) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity entity) {
        this.shinsakaiIinCode = entity.shinsakaiIinCode;
        this.remban = entity.remban;
        this.jigyoshaKubun = entity.jigyoshaKubun;
        this.shozokuKaishiYMD = entity.shozokuKaishiYMD;
        this.shozokuShuryoYMD = entity.shozokuShuryoYMD;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shujiiIryokikanCode = entity.shujiiIryokikanCode;
        this.shujiiCode = entity.shujiiCode;
        this.ninteichosaItakusakiCode = entity.ninteichosaItakusakiCode;
        this.ninteiChosainNo = entity.ninteiChosainNo;
        this.sonotaKikanCode = entity.sonotaKikanCode;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinsakaiIinCode, remban, jigyoshaKubun, shozokuKaishiYMD, shozokuShuryoYMD, shoKisaiHokenshaNo, shujiiIryokikanCode, shujiiCode, ninteichosaItakusakiCode, ninteiChosainNo, sonotaKikanCode);
    }

// </editor-fold>
}
