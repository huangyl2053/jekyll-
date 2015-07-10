package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT7053ShinseitodokedeJohoの項目定義クラスです
 *
 */
public class DbT7053ShinseitodokedeJohoEntity extends DbTableEntityBase<DbT7053ShinseitodokedeJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

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
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getShoKisaiHokenshaNo
     *
     * @return shoKisaiHokenshaNo
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * setShoKisaiHokenshaNo
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     */
    public void setShoKisaiHokenshaNo(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * getHihokenshaNo
     *
     * @return hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * getShinseiTodokedeYMD
     *
     * @return shinseiTodokedeYMD
     */
    public RDate getShinseiTodokedeYMD() {
        return shinseiTodokedeYMD;
    }

    /**
     * setShinseiTodokedeYMD
     *
     * @param shinseiTodokedeYMD shinseiTodokedeYMD
     */
    public void setShinseiTodokedeYMD(RDate shinseiTodokedeYMD) {
        this.shinseiTodokedeYMD = shinseiTodokedeYMD;
    }

    /**
     * getShinseishoKanriNo
     *
     * @return shinseishoKanriNo
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * setShinseishoKanriNo
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * getShinseiTodokedeShubetsuCode
     *
     * @return shinseiTodokedeShubetsuCode
     */
    public RString getShinseiTodokedeShubetsuCode() {
        return shinseiTodokedeShubetsuCode;
    }

    /**
     * setShinseiTodokedeShubetsuCode
     *
     * @param shinseiTodokedeShubetsuCode shinseiTodokedeShubetsuCode
     */
    public void setShinseiTodokedeShubetsuCode(RString shinseiTodokedeShubetsuCode) {
        this.shinseiTodokedeShubetsuCode = shinseiTodokedeShubetsuCode;
    }

    /**
     * getShinseiTodokedeDaikoKubunCode
     *
     * @return shinseiTodokedeDaikoKubunCode
     */
    public Code getShinseiTodokedeDaikoKubunCode() {
        return shinseiTodokedeDaikoKubunCode;
    }

    /**
     * setShinseiTodokedeDaikoKubunCode
     *
     * @param shinseiTodokedeDaikoKubunCode shinseiTodokedeDaikoKubunCode
     */
    public void setShinseiTodokedeDaikoKubunCode(Code shinseiTodokedeDaikoKubunCode) {
        this.shinseiTodokedeDaikoKubunCode = shinseiTodokedeDaikoKubunCode;
    }

    /**
     * getShinseiTodokedeshaShimei
     *
     * @return shinseiTodokedeshaShimei
     */
    public AtenaMeisho getShinseiTodokedeshaShimei() {
        return shinseiTodokedeshaShimei;
    }

    /**
     * setShinseiTodokedeshaShimei
     *
     * @param shinseiTodokedeshaShimei shinseiTodokedeshaShimei
     */
    public void setShinseiTodokedeshaShimei(AtenaMeisho shinseiTodokedeshaShimei) {
        this.shinseiTodokedeshaShimei = shinseiTodokedeshaShimei;
    }

    /**
     * getShinseiTodokedeshaKanaShimei
     *
     * @return shinseiTodokedeshaKanaShimei
     */
    public AtenaKanaMeisho getShinseiTodokedeshaKanaShimei() {
        return shinseiTodokedeshaKanaShimei;
    }

    /**
     * setShinseiTodokedeshaKanaShimei
     *
     * @param shinseiTodokedeshaKanaShimei shinseiTodokedeshaKanaShimei
     */
    public void setShinseiTodokedeshaKanaShimei(AtenaKanaMeisho shinseiTodokedeshaKanaShimei) {
        this.shinseiTodokedeshaKanaShimei = shinseiTodokedeshaKanaShimei;
    }

    /**
     * getShinseiTodokedeshaTsuzukigaraCode
     *
     * @return shinseiTodokedeshaTsuzukigaraCode
     */
    public RString getShinseiTodokedeshaTsuzukigaraCode() {
        return shinseiTodokedeshaTsuzukigaraCode;
    }

    /**
     * setShinseiTodokedeshaTsuzukigaraCode
     *
     * @param shinseiTodokedeshaTsuzukigaraCode shinseiTodokedeshaTsuzukigaraCode
     */
    public void setShinseiTodokedeshaTsuzukigaraCode(RString shinseiTodokedeshaTsuzukigaraCode) {
        this.shinseiTodokedeshaTsuzukigaraCode = shinseiTodokedeshaTsuzukigaraCode;
    }

    /**
     * getShinseiTodokedeDaikoJigyoshaNo
     *
     * @return shinseiTodokedeDaikoJigyoshaNo
     */
    public JigyoshaNo getShinseiTodokedeDaikoJigyoshaNo() {
        return shinseiTodokedeDaikoJigyoshaNo;
    }

    /**
     * setShinseiTodokedeDaikoJigyoshaNo
     *
     * @param shinseiTodokedeDaikoJigyoshaNo shinseiTodokedeDaikoJigyoshaNo
     */
    public void setShinseiTodokedeDaikoJigyoshaNo(JigyoshaNo shinseiTodokedeDaikoJigyoshaNo) {
        this.shinseiTodokedeDaikoJigyoshaNo = shinseiTodokedeDaikoJigyoshaNo;
    }

    /**
     * getJigyoshaKubun
     *
     * @return jigyoshaKubun
     */
    public RString getJigyoshaKubun() {
        return jigyoshaKubun;
    }

    /**
     * setJigyoshaKubun
     *
     * @param jigyoshaKubun jigyoshaKubun
     */
    public void setJigyoshaKubun(RString jigyoshaKubun) {
        this.jigyoshaKubun = jigyoshaKubun;
    }

    /**
     * getShinseiTodokedeshaYubinNo
     *
     * @return shinseiTodokedeshaYubinNo
     */
    public YubinNo getShinseiTodokedeshaYubinNo() {
        return shinseiTodokedeshaYubinNo;
    }

    /**
     * setShinseiTodokedeshaYubinNo
     *
     * @param shinseiTodokedeshaYubinNo shinseiTodokedeshaYubinNo
     */
    public void setShinseiTodokedeshaYubinNo(YubinNo shinseiTodokedeshaYubinNo) {
        this.shinseiTodokedeshaYubinNo = shinseiTodokedeshaYubinNo;
    }

    /**
     * getShinseiTodokedeshaJusho
     *
     * @return shinseiTodokedeshaJusho
     */
    public AtenaJusho getShinseiTodokedeshaJusho() {
        return shinseiTodokedeshaJusho;
    }

    /**
     * setShinseiTodokedeshaJusho
     *
     * @param shinseiTodokedeshaJusho shinseiTodokedeshaJusho
     */
    public void setShinseiTodokedeshaJusho(AtenaJusho shinseiTodokedeshaJusho) {
        this.shinseiTodokedeshaJusho = shinseiTodokedeshaJusho;
    }

    /**
     * getShinseiTodokedeshaTelNo
     *
     * @return shinseiTodokedeshaTelNo
     */
    public TelNo getShinseiTodokedeshaTelNo() {
        return shinseiTodokedeshaTelNo;
    }

    /**
     * setShinseiTodokedeshaTelNo
     *
     * @param shinseiTodokedeshaTelNo shinseiTodokedeshaTelNo
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
