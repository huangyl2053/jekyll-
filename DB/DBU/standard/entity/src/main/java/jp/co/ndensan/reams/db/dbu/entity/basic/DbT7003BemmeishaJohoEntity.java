package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.BushoCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * 弁明者情報テーブルのエンティティクラスです。
 * <br/> 弁明書を記載・確認した弁明者を管理する
 */
public class DbT7003BemmeishaJohoEntity extends DbTableEntityBase<DbT7003BemmeishaJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7003BemmeishaJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private HihokenshaNo genshobunHihokenshaNo;
    @PrimaryKey
    private FlexibleDate shinsaseikyuTodokedeYMD;
    @PrimaryKey
    private FlexibleDate bemmeishoSakuseiYMD;
    @PrimaryKey
    private int bemmeishaEdaban;
    private Code shokuinCode;
    private BushoCode bushoCode;
    private RString yakushoskuName;
    private AtenaMeisho bemmeishaShimei;

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
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
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
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     *
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 原処分被保険者番号のgetメソッドです。
     *
     * @return 原処分被保険者番号
     */
    public HihokenshaNo getGenshobunHihokenshaNo() {
        return genshobunHihokenshaNo;
    }

    /**
     * 原処分被保険者番号のsetメソッドです。
     *
     * @param genshobunHihokenshaNo 原処分被保険者番号
     */
    public void setGenshobunHihokenshaNo(HihokenshaNo genshobunHihokenshaNo) {
        this.genshobunHihokenshaNo = genshobunHihokenshaNo;
    }

    /**
     * 審査請求届出日のgetメソッドです。
     *
     * @return 審査請求届出日
     */
    public FlexibleDate getShinsaseikyuTodokedeYMD() {
        return shinsaseikyuTodokedeYMD;
    }

    /**
     * 審査請求届出日のsetメソッドです。
     *
     * @param shinsaseikyuTodokedeYMD 審査請求届出日
     */
    public void setShinsaseikyuTodokedeYMD(FlexibleDate shinsaseikyuTodokedeYMD) {
        this.shinsaseikyuTodokedeYMD = shinsaseikyuTodokedeYMD;
    }

    /**
     * 弁明書作成日のgetメソッドです。
     *
     * @return 弁明書作成日
     */
    public FlexibleDate getBemmeishoSakuseiYMD() {
        return bemmeishoSakuseiYMD;
    }

    /**
     * 弁明書作成日のsetメソッドです。
     *
     * @param bemmeishoSakuseiYMD 弁明書作成日
     */
    public void setBemmeishoSakuseiYMD(FlexibleDate bemmeishoSakuseiYMD) {
        this.bemmeishoSakuseiYMD = bemmeishoSakuseiYMD;
    }

    /**
     * 弁明者枝番のgetメソッドです。
     *
     * @return 弁明者枝番
     */
    public int getBemmeishaEdaban() {
        return bemmeishaEdaban;
    }

    /**
     * 弁明者枝番のsetメソッドです。
     *
     * @param bemmeishaEdaban 弁明者枝番
     */
    public void setBemmeishaEdaban(int bemmeishaEdaban) {
        this.bemmeishaEdaban = bemmeishaEdaban;
    }

    /**
     * 職員コードのgetメソッドです。
     *
     * @return 職員コード
     */
    public Code getShokuinCode() {
        return shokuinCode;
    }

    /**
     * 職員コードのsetメソッドです。
     *
     * @param shokuinCode 職員コード
     */
    public void setShokuinCode(Code shokuinCode) {
        this.shokuinCode = shokuinCode;
    }

    /**
     * 部署コードのgetメソッドです。
     *
     * @return 部署コード
     */
    public BushoCode getBushoCode() {
        return bushoCode;
    }

    /**
     * 部署コードのsetメソッドです。
     *
     * @param bushoCode 部署コード
     */
    public void setBushoCode(BushoCode bushoCode) {
        this.bushoCode = bushoCode;
    }

    /**
     * 役職名のgetメソッドです。
     *
     * @return 役職名
     */
    public RString getYakushoskuName() {
        return yakushoskuName;
    }

    /**
     * 役職名のsetメソッドです。
     *
     * @param yakushoskuName 役職名
     */
    public void setYakushoskuName(RString yakushoskuName) {
        this.yakushoskuName = yakushoskuName;
    }

    /**
     * 弁明者氏名のgetメソッドです。
     *
     * @return 弁明者氏名
     */
    public AtenaMeisho getBemmeishaShimei() {
        return bemmeishaShimei;
    }

    /**
     * 弁明者氏名のsetメソッドです。
     *
     * @param bemmeishaShimei 弁明者氏名
     */
    public void setBemmeishaShimei(AtenaMeisho bemmeishaShimei) {
        this.bemmeishaShimei = bemmeishaShimei;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7003BemmeishaJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7003BemmeishaJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7003BemmeishaJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.genshobunHihokenshaNo, other.genshobunHihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shinsaseikyuTodokedeYMD, other.shinsaseikyuTodokedeYMD)) {
            return false;
        }
        if (!Objects.equals(this.bemmeishoSakuseiYMD, other.bemmeishoSakuseiYMD)) {
            return false;
        }
        if (this.bemmeishaEdaban != other.bemmeishaEdaban) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7003BemmeishaJohoEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.genshobunHihokenshaNo = entity.genshobunHihokenshaNo;
        this.shinsaseikyuTodokedeYMD = entity.shinsaseikyuTodokedeYMD;
        this.bemmeishoSakuseiYMD = entity.bemmeishoSakuseiYMD;
        this.bemmeishaEdaban = entity.bemmeishaEdaban;
        this.shokuinCode = entity.shokuinCode;
        this.bushoCode = entity.bushoCode;
        this.yakushoskuName = entity.yakushoskuName;
        this.bemmeishaShimei = entity.bemmeishaShimei;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, shikibetsuCode, genshobunHihokenshaNo, shinsaseikyuTodokedeYMD, bemmeishoSakuseiYMD, bemmeishaEdaban, shokuinCode, bushoCode, yakushoskuName, bemmeishaShimei);
    }

// </editor-fold>
}
