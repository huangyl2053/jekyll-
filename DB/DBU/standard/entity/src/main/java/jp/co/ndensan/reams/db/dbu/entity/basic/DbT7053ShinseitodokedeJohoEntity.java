package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * 申請届出情報テーブルのエンティティクラスです。
 * <br/> 申請届出情報を一元管理する
 */
public class DbT7053ShinseitodokedeJohoEntity extends DbTableEntityBase<DbT7053ShinseitodokedeJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7053ShinseitodokedeJoho");

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
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RDate shinseiTodokedeYMD;
    private ShinseishoKanriNo shinseishoKanriNo;
    private RString shinseiTodokedeShubetsuCode;
    private Code shinseiTodokedeDaikoKubunCode;
    private AtenaMeisho shinseiTodokedeshaShimei;
    private AtenaKanaMeisho shinseiTodokedeshaKanaShimei;
    private RString shinseiTodokedeshaTsuzukigaraCode;
    private JigyoshaNo shinseiTodokedeDaikoJigyoshaNo;
    private RString jigyoshaKubun;
    private YubinNo shinseiTodokedeshaYubinNo;
    private AtenaJusho shinseiTodokedeshaJusho;
    private TelNo shinseiTodokedeshaTelNo;

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
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 申請届出年月日のgetメソッドです。
     *
     * @return 申請届出年月日
     */
    public RDate getShinseiTodokedeYMD() {
        return shinseiTodokedeYMD;
    }

    /**
     * 申請届出年月日のsetメソッドです。
     *
     * @param shinseiTodokedeYMD 申請届出年月日
     */
    public void setShinseiTodokedeYMD(RDate shinseiTodokedeYMD) {
        this.shinseiTodokedeYMD = shinseiTodokedeYMD;
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
     * 申請届出種別コードのgetメソッドです。
     * <br/>
     * <br/>資格・認定・受給・給付・賦課の申請届出を区別
     *
     * @return 申請届出種別コード
     */
    public RString getShinseiTodokedeShubetsuCode() {
        return shinseiTodokedeShubetsuCode;
    }

    /**
     * 申請届出種別コードのsetメソッドです。
     * <br/>
     * <br/>資格・認定・受給・給付・賦課の申請届出を区別
     *
     * @param shinseiTodokedeShubetsuCode 申請届出種別コード
     */
    public void setShinseiTodokedeShubetsuCode(RString shinseiTodokedeShubetsuCode) {
        this.shinseiTodokedeShubetsuCode = shinseiTodokedeShubetsuCode;
    }

    /**
     * 申請届出代行区分コードのgetメソッドです。
     * <br/>
     * <br/>本人・家族・委任者・代行事業者等
     *
     * @return 申請届出代行区分コード
     */
    public Code getShinseiTodokedeDaikoKubunCode() {
        return shinseiTodokedeDaikoKubunCode;
    }

    /**
     * 申請届出代行区分コードのsetメソッドです。
     * <br/>
     * <br/>本人・家族・委任者・代行事業者等
     *
     * @param shinseiTodokedeDaikoKubunCode 申請届出代行区分コード
     */
    public void setShinseiTodokedeDaikoKubunCode(Code shinseiTodokedeDaikoKubunCode) {
        this.shinseiTodokedeDaikoKubunCode = shinseiTodokedeDaikoKubunCode;
    }

    /**
     * 申請届出者氏名のgetメソッドです。
     *
     * @return 申請届出者氏名
     */
    public AtenaMeisho getShinseiTodokedeshaShimei() {
        return shinseiTodokedeshaShimei;
    }

    /**
     * 申請届出者氏名のsetメソッドです。
     *
     * @param shinseiTodokedeshaShimei 申請届出者氏名
     */
    public void setShinseiTodokedeshaShimei(AtenaMeisho shinseiTodokedeshaShimei) {
        this.shinseiTodokedeshaShimei = shinseiTodokedeshaShimei;
    }

    /**
     * 申請届出者氏名カナのgetメソッドです。
     *
     * @return 申請届出者氏名カナ
     */
    public AtenaKanaMeisho getShinseiTodokedeshaKanaShimei() {
        return shinseiTodokedeshaKanaShimei;
    }

    /**
     * 申請届出者氏名カナのsetメソッドです。
     *
     * @param shinseiTodokedeshaKanaShimei 申請届出者氏名カナ
     */
    public void setShinseiTodokedeshaKanaShimei(AtenaKanaMeisho shinseiTodokedeshaKanaShimei) {
        this.shinseiTodokedeshaKanaShimei = shinseiTodokedeshaKanaShimei;
    }

    /**
     * 申請届出者続柄コードのgetメソッドです。
     *
     * @return 申請届出者続柄コード
     */
    public RString getShinseiTodokedeshaTsuzukigaraCode() {
        return shinseiTodokedeshaTsuzukigaraCode;
    }

    /**
     * 申請届出者続柄コードのsetメソッドです。
     *
     * @param shinseiTodokedeshaTsuzukigaraCode 申請届出者続柄コード
     */
    public void setShinseiTodokedeshaTsuzukigaraCode(RString shinseiTodokedeshaTsuzukigaraCode) {
        this.shinseiTodokedeshaTsuzukigaraCode = shinseiTodokedeshaTsuzukigaraCode;
    }

    /**
     * 申請届出代行事業者番号のgetメソッドです。
     *
     * @return 申請届出代行事業者番号
     */
    public JigyoshaNo getShinseiTodokedeDaikoJigyoshaNo() {
        return shinseiTodokedeDaikoJigyoshaNo;
    }

    /**
     * 申請届出代行事業者番号のsetメソッドです。
     *
     * @param shinseiTodokedeDaikoJigyoshaNo 申請届出代行事業者番号
     */
    public void setShinseiTodokedeDaikoJigyoshaNo(JigyoshaNo shinseiTodokedeDaikoJigyoshaNo) {
        this.shinseiTodokedeDaikoJigyoshaNo = shinseiTodokedeDaikoJigyoshaNo;
    }

    /**
     * 事業者区分のgetメソッドです。
     *
     * @return 事業者区分
     */
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
     * 申請届出者郵便番号のgetメソッドです。
     *
     * @return 申請届出者郵便番号
     */
    public YubinNo getShinseiTodokedeshaYubinNo() {
        return shinseiTodokedeshaYubinNo;
    }

    /**
     * 申請届出者郵便番号のsetメソッドです。
     *
     * @param shinseiTodokedeshaYubinNo 申請届出者郵便番号
     */
    public void setShinseiTodokedeshaYubinNo(YubinNo shinseiTodokedeshaYubinNo) {
        this.shinseiTodokedeshaYubinNo = shinseiTodokedeshaYubinNo;
    }

    /**
     * 申請届出者住所のgetメソッドです。
     *
     * @return 申請届出者住所
     */
    public AtenaJusho getShinseiTodokedeshaJusho() {
        return shinseiTodokedeshaJusho;
    }

    /**
     * 申請届出者住所のsetメソッドです。
     *
     * @param shinseiTodokedeshaJusho 申請届出者住所
     */
    public void setShinseiTodokedeshaJusho(AtenaJusho shinseiTodokedeshaJusho) {
        this.shinseiTodokedeshaJusho = shinseiTodokedeshaJusho;
    }

    /**
     * 申請届出者電話番号のgetメソッドです。
     *
     * @return 申請届出者電話番号
     */
    public TelNo getShinseiTodokedeshaTelNo() {
        return shinseiTodokedeshaTelNo;
    }

    /**
     * 申請届出者電話番号のsetメソッドです。
     *
     * @param shinseiTodokedeshaTelNo 申請届出者電話番号
     */
    public void setShinseiTodokedeshaTelNo(TelNo shinseiTodokedeshaTelNo) {
        this.shinseiTodokedeshaTelNo = shinseiTodokedeshaTelNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7053ShinseitodokedeJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7053ShinseitodokedeJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7053ShinseitodokedeJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shinseiTodokedeYMD, other.shinseiTodokedeYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7053ShinseitodokedeJohoEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shinseiTodokedeYMD = entity.shinseiTodokedeYMD;
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.shinseiTodokedeShubetsuCode = entity.shinseiTodokedeShubetsuCode;
        this.shinseiTodokedeDaikoKubunCode = entity.shinseiTodokedeDaikoKubunCode;
        this.shinseiTodokedeshaShimei = entity.shinseiTodokedeshaShimei;
        this.shinseiTodokedeshaKanaShimei = entity.shinseiTodokedeshaKanaShimei;
        this.shinseiTodokedeshaTsuzukigaraCode = entity.shinseiTodokedeshaTsuzukigaraCode;
        this.shinseiTodokedeDaikoJigyoshaNo = entity.shinseiTodokedeDaikoJigyoshaNo;
        this.jigyoshaKubun = entity.jigyoshaKubun;
        this.shinseiTodokedeshaYubinNo = entity.shinseiTodokedeshaYubinNo;
        this.shinseiTodokedeshaJusho = entity.shinseiTodokedeshaJusho;
        this.shinseiTodokedeshaTelNo = entity.shinseiTodokedeshaTelNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, hihokenshaNo, shinseiTodokedeYMD, shinseishoKanriNo, shinseiTodokedeShubetsuCode, shinseiTodokedeDaikoKubunCode, shinseiTodokedeshaShimei, shinseiTodokedeshaKanaShimei, shinseiTodokedeshaTsuzukigaraCode, shinseiTodokedeDaikoJigyoshaNo, jigyoshaKubun, shinseiTodokedeshaYubinNo, shinseiTodokedeshaJusho, shinseiTodokedeshaTelNo);
    }

// </editor-fold>
}
