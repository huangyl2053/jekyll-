package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 被保険者台帳管理・福祉Viewテーブルのエンティティクラスです。
 */
public class DbV7501HihokenshaDaichoFukushiEntity extends DbTableEntityBase<DbV7501HihokenshaDaichoFukushiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV7501HihokenshaDaichoFukushi");

    private HihokenshaNo hihokenshaNo;
    private FlexibleDate idoYMD;
    private RString edaNo;
    private RString idoJiyuCode;
    private LasdecCode shichosonCode;
    private ShikibetsuCode shikibetsuCode;
    private RString shikakuShutokuJiyuCode;
    private FlexibleDate shikakuShutokuYMD;
    private FlexibleDate shikakuShutokuTodokedeYMD;
    private FlexibleDate ichigoShikakuShutokuYMD;
    private RString hihokennshaKubunCode;
    private RString shikakuSoshitsuJiyuCode;
    private FlexibleDate shikakuSoshitsuYMD;
    private RString shikakuSoshitsuYMDCmp;
    private FlexibleDate shikakuSoshitsuTodokedeYMD;
    private RString shikakuHenkoJiyuCode;
    private FlexibleDate shikakuHenkoYMD;
    private FlexibleDate shikakuHenkoTodokedeYMD;
    private RString jushochitokureiTekiyoJiyuCode;
    private FlexibleDate jushochitokureiTekiyoYMD;
    private FlexibleDate jushochitokureiTekiyoTodokedeYMD;
    private RString jushochitokureiKaijoJiyuCode;
    private FlexibleDate jushochitokureiKaijoYMD;
    private FlexibleDate jushochitokureiKaijoTodokedeYMD;
    private RString jushochiTokureiFlag;
    private RString koikinaiJushochiTokureiFlag;
    private LasdecCode koikinaiTokureiSochimotoShichosonCode;
    private LasdecCode kyuShichosonCode;
    private boolean logicalDeletedFlag;

    /**
     * hihokenshaNoのgetメソッドです。
     * 
     * @return hihokenshaNo
     */
    @CheckForNull
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * hihokenshaNoのsetメソッドです。
     * 
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * idoYMDのgetメソッドです。
     * 
     * @return idoYMD
     */
    @CheckForNull
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * idoYMDのsetメソッドです。
     * 
     * @param idoYMD idoYMD
     */
    public void setIdoYMD(FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * edaNoのgetメソッドです。
     * 
     * @return edaNo
     */
    @CheckForNull
    public RString getEdaNo() {
        return edaNo;
    }

    /**
     * edaNoのsetメソッドです。
     * 
     * @param edaNo edaNo
     */
    public void setEdaNo(RString edaNo) {
        this.edaNo = edaNo;
    }

    /**
     * idoJiyuCodeのgetメソッドです。
     * 
     * @return idoJiyuCode
     */
    @CheckForNull
    public RString getIdoJiyuCode() {
        return idoJiyuCode;
    }

    /**
     * idoJiyuCodeのsetメソッドです。
     * 
     * @param idoJiyuCode idoJiyuCode
     */
    public void setIdoJiyuCode(RString idoJiyuCode) {
        this.idoJiyuCode = idoJiyuCode;
    }

    /**
     * shichosonCodeのgetメソッドです。
     * 
     * @return shichosonCode
     */
    @CheckForNull
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * shichosonCodeのsetメソッドです。
     * 
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * shikibetsuCodeのgetメソッドです。
     * 
     * @return shikibetsuCode
     */
    @CheckForNull
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * shikibetsuCodeのsetメソッドです。
     * 
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * shikakuShutokuJiyuCodeのgetメソッドです。
     * 
     * @return shikakuShutokuJiyuCode
     */
    @CheckForNull
    public RString getShikakuShutokuJiyuCode() {
        return shikakuShutokuJiyuCode;
    }

    /**
     * shikakuShutokuJiyuCodeのsetメソッドです。
     * 
     * @param shikakuShutokuJiyuCode shikakuShutokuJiyuCode
     */
    public void setShikakuShutokuJiyuCode(RString shikakuShutokuJiyuCode) {
        this.shikakuShutokuJiyuCode = shikakuShutokuJiyuCode;
    }

    /**
     * shikakuShutokuYMDのgetメソッドです。
     * 
     * @return shikakuShutokuYMD
     */
    @CheckForNull
    public FlexibleDate getShikakuShutokuYMD() {
        return shikakuShutokuYMD;
    }

    /**
     * shikakuShutokuYMDのsetメソッドです。
     * 
     * @param shikakuShutokuYMD shikakuShutokuYMD
     */
    public void setShikakuShutokuYMD(FlexibleDate shikakuShutokuYMD) {
        this.shikakuShutokuYMD = shikakuShutokuYMD;
    }

    /**
     * shikakuShutokuTodokedeYMDのgetメソッドです。
     * 
     * @return shikakuShutokuTodokedeYMD
     */
    @CheckForNull
    public FlexibleDate getShikakuShutokuTodokedeYMD() {
        return shikakuShutokuTodokedeYMD;
    }

    /**
     * shikakuShutokuTodokedeYMDのsetメソッドです。
     * 
     * @param shikakuShutokuTodokedeYMD shikakuShutokuTodokedeYMD
     */
    public void setShikakuShutokuTodokedeYMD(FlexibleDate shikakuShutokuTodokedeYMD) {
        this.shikakuShutokuTodokedeYMD = shikakuShutokuTodokedeYMD;
    }

    /**
     * ichigoShikakuShutokuYMDのgetメソッドです。
     * 
     * @return ichigoShikakuShutokuYMD
     */
    @CheckForNull
    public FlexibleDate getIchigoShikakuShutokuYMD() {
        return ichigoShikakuShutokuYMD;
    }

    /**
     * ichigoShikakuShutokuYMDのsetメソッドです。
     * 
     * @param ichigoShikakuShutokuYMD ichigoShikakuShutokuYMD
     */
    public void setIchigoShikakuShutokuYMD(FlexibleDate ichigoShikakuShutokuYMD) {
        this.ichigoShikakuShutokuYMD = ichigoShikakuShutokuYMD;
    }

    /**
     * hihokennshaKubunCodeのgetメソッドです。
     * 
     * @return hihokennshaKubunCode
     */
    @CheckForNull
    public RString getHihokennshaKubunCode() {
        return hihokennshaKubunCode;
    }

    /**
     * hihokennshaKubunCodeのsetメソッドです。
     * 
     * @param hihokennshaKubunCode hihokennshaKubunCode
     */
    public void setHihokennshaKubunCode(RString hihokennshaKubunCode) {
        this.hihokennshaKubunCode = hihokennshaKubunCode;
    }

    /**
     * shikakuSoshitsuJiyuCodeのgetメソッドです。
     * 
     * @return shikakuSoshitsuJiyuCode
     */
    @CheckForNull
    public RString getShikakuSoshitsuJiyuCode() {
        return shikakuSoshitsuJiyuCode;
    }

    /**
     * shikakuSoshitsuJiyuCodeのsetメソッドです。
     * 
     * @param shikakuSoshitsuJiyuCode shikakuSoshitsuJiyuCode
     */
    public void setShikakuSoshitsuJiyuCode(RString shikakuSoshitsuJiyuCode) {
        this.shikakuSoshitsuJiyuCode = shikakuSoshitsuJiyuCode;
    }

    /**
     * shikakuSoshitsuYMDのgetメソッドです。
     * 
     * @return shikakuSoshitsuYMD
     */
    @CheckForNull
    public FlexibleDate getShikakuSoshitsuYMD() {
        return shikakuSoshitsuYMD;
    }

    /**
     * shikakuSoshitsuYMDのsetメソッドです。
     * 
     * @param shikakuSoshitsuYMD shikakuSoshitsuYMD
     */
    public void setShikakuSoshitsuYMD(FlexibleDate shikakuSoshitsuYMD) {
        this.shikakuSoshitsuYMD = shikakuSoshitsuYMD;
    }

    /**
     * shikakuSoshitsuYMDCmpのgetメソッドです。
     * 
     * @return shikakuSoshitsuYMDCmp
     */
    @CheckForNull
    public RString getShikakuSoshitsuYMDCmp() {
        return shikakuSoshitsuYMDCmp;
    }

    /**
     * shikakuSoshitsuYMDCmpのsetメソッドです。
     * 
     * @param shikakuSoshitsuYMDCmp shikakuSoshitsuYMDCmp
     */
    public void setShikakuSoshitsuYMDCmp(RString shikakuSoshitsuYMDCmp) {
        this.shikakuSoshitsuYMDCmp = shikakuSoshitsuYMDCmp;
    }

    /**
     * shikakuSoshitsuTodokedeYMDのgetメソッドです。
     * 
     * @return shikakuSoshitsuTodokedeYMD
     */
    @CheckForNull
    public FlexibleDate getShikakuSoshitsuTodokedeYMD() {
        return shikakuSoshitsuTodokedeYMD;
    }

    /**
     * shikakuSoshitsuTodokedeYMDのsetメソッドです。
     * 
     * @param shikakuSoshitsuTodokedeYMD shikakuSoshitsuTodokedeYMD
     */
    public void setShikakuSoshitsuTodokedeYMD(FlexibleDate shikakuSoshitsuTodokedeYMD) {
        this.shikakuSoshitsuTodokedeYMD = shikakuSoshitsuTodokedeYMD;
    }

    /**
     * shikakuHenkoJiyuCodeのgetメソッドです。
     * 
     * @return shikakuHenkoJiyuCode
     */
    @CheckForNull
    public RString getShikakuHenkoJiyuCode() {
        return shikakuHenkoJiyuCode;
    }

    /**
     * shikakuHenkoJiyuCodeのsetメソッドです。
     * 
     * @param shikakuHenkoJiyuCode shikakuHenkoJiyuCode
     */
    public void setShikakuHenkoJiyuCode(RString shikakuHenkoJiyuCode) {
        this.shikakuHenkoJiyuCode = shikakuHenkoJiyuCode;
    }

    /**
     * shikakuHenkoYMDのgetメソッドです。
     * 
     * @return shikakuHenkoYMD
     */
    @CheckForNull
    public FlexibleDate getShikakuHenkoYMD() {
        return shikakuHenkoYMD;
    }

    /**
     * shikakuHenkoYMDのsetメソッドです。
     * 
     * @param shikakuHenkoYMD shikakuHenkoYMD
     */
    public void setShikakuHenkoYMD(FlexibleDate shikakuHenkoYMD) {
        this.shikakuHenkoYMD = shikakuHenkoYMD;
    }

    /**
     * shikakuHenkoTodokedeYMDのgetメソッドです。
     * 
     * @return shikakuHenkoTodokedeYMD
     */
    @CheckForNull
    public FlexibleDate getShikakuHenkoTodokedeYMD() {
        return shikakuHenkoTodokedeYMD;
    }

    /**
     * shikakuHenkoTodokedeYMDのsetメソッドです。
     * 
     * @param shikakuHenkoTodokedeYMD shikakuHenkoTodokedeYMD
     */
    public void setShikakuHenkoTodokedeYMD(FlexibleDate shikakuHenkoTodokedeYMD) {
        this.shikakuHenkoTodokedeYMD = shikakuHenkoTodokedeYMD;
    }

    /**
     * jushochitokureiTekiyoJiyuCodeのgetメソッドです。
     * 
     * @return jushochitokureiTekiyoJiyuCode
     */
    @CheckForNull
    public RString getJushochitokureiTekiyoJiyuCode() {
        return jushochitokureiTekiyoJiyuCode;
    }

    /**
     * jushochitokureiTekiyoJiyuCodeのsetメソッドです。
     * 
     * @param jushochitokureiTekiyoJiyuCode jushochitokureiTekiyoJiyuCode
     */
    public void setJushochitokureiTekiyoJiyuCode(RString jushochitokureiTekiyoJiyuCode) {
        this.jushochitokureiTekiyoJiyuCode = jushochitokureiTekiyoJiyuCode;
    }

    /**
     * jushochitokureiTekiyoYMDのgetメソッドです。
     * 
     * @return jushochitokureiTekiyoYMD
     */
    @CheckForNull
    public FlexibleDate getJushochitokureiTekiyoYMD() {
        return jushochitokureiTekiyoYMD;
    }

    /**
     * jushochitokureiTekiyoYMDのsetメソッドです。
     * 
     * @param jushochitokureiTekiyoYMD jushochitokureiTekiyoYMD
     */
    public void setJushochitokureiTekiyoYMD(FlexibleDate jushochitokureiTekiyoYMD) {
        this.jushochitokureiTekiyoYMD = jushochitokureiTekiyoYMD;
    }

    /**
     * jushochitokureiTekiyoTodokedeYMDのgetメソッドです。
     * 
     * @return jushochitokureiTekiyoTodokedeYMD
     */
    @CheckForNull
    public FlexibleDate getJushochitokureiTekiyoTodokedeYMD() {
        return jushochitokureiTekiyoTodokedeYMD;
    }

    /**
     * jushochitokureiTekiyoTodokedeYMDのsetメソッドです。
     * 
     * @param jushochitokureiTekiyoTodokedeYMD jushochitokureiTekiyoTodokedeYMD
     */
    public void setJushochitokureiTekiyoTodokedeYMD(FlexibleDate jushochitokureiTekiyoTodokedeYMD) {
        this.jushochitokureiTekiyoTodokedeYMD = jushochitokureiTekiyoTodokedeYMD;
    }

    /**
     * jushochitokureiKaijoJiyuCodeのgetメソッドです。
     * 
     * @return jushochitokureiKaijoJiyuCode
     */
    @CheckForNull
    public RString getJushochitokureiKaijoJiyuCode() {
        return jushochitokureiKaijoJiyuCode;
    }

    /**
     * jushochitokureiKaijoJiyuCodeのsetメソッドです。
     * 
     * @param jushochitokureiKaijoJiyuCode jushochitokureiKaijoJiyuCode
     */
    public void setJushochitokureiKaijoJiyuCode(RString jushochitokureiKaijoJiyuCode) {
        this.jushochitokureiKaijoJiyuCode = jushochitokureiKaijoJiyuCode;
    }

    /**
     * jushochitokureiKaijoYMDのgetメソッドです。
     * 
     * @return jushochitokureiKaijoYMD
     */
    @CheckForNull
    public FlexibleDate getJushochitokureiKaijoYMD() {
        return jushochitokureiKaijoYMD;
    }

    /**
     * jushochitokureiKaijoYMDのsetメソッドです。
     * 
     * @param jushochitokureiKaijoYMD jushochitokureiKaijoYMD
     */
    public void setJushochitokureiKaijoYMD(FlexibleDate jushochitokureiKaijoYMD) {
        this.jushochitokureiKaijoYMD = jushochitokureiKaijoYMD;
    }

    /**
     * jushochitokureiKaijoTodokedeYMDのgetメソッドです。
     * 
     * @return jushochitokureiKaijoTodokedeYMD
     */
    @CheckForNull
    public FlexibleDate getJushochitokureiKaijoTodokedeYMD() {
        return jushochitokureiKaijoTodokedeYMD;
    }

    /**
     * jushochitokureiKaijoTodokedeYMDのsetメソッドです。
     * 
     * @param jushochitokureiKaijoTodokedeYMD jushochitokureiKaijoTodokedeYMD
     */
    public void setJushochitokureiKaijoTodokedeYMD(FlexibleDate jushochitokureiKaijoTodokedeYMD) {
        this.jushochitokureiKaijoTodokedeYMD = jushochitokureiKaijoTodokedeYMD;
    }

    /**
     * jushochiTokureiFlagのgetメソッドです。
     * 
     * @return jushochiTokureiFlag
     */
    @CheckForNull
    public RString getJushochiTokureiFlag() {
        return jushochiTokureiFlag;
    }

    /**
     * jushochiTokureiFlagのsetメソッドです。
     * 
     * @param jushochiTokureiFlag jushochiTokureiFlag
     */
    public void setJushochiTokureiFlag(RString jushochiTokureiFlag) {
        this.jushochiTokureiFlag = jushochiTokureiFlag;
    }

    /**
     * koikinaiJushochiTokureiFlagのgetメソッドです。
     * 
     * @return koikinaiJushochiTokureiFlag
     */
    @CheckForNull
    public RString getKoikinaiJushochiTokureiFlag() {
        return koikinaiJushochiTokureiFlag;
    }

    /**
     * koikinaiJushochiTokureiFlagのsetメソッドです。
     * 
     * @param koikinaiJushochiTokureiFlag koikinaiJushochiTokureiFlag
     */
    public void setKoikinaiJushochiTokureiFlag(RString koikinaiJushochiTokureiFlag) {
        this.koikinaiJushochiTokureiFlag = koikinaiJushochiTokureiFlag;
    }

    /**
     * koikinaiTokureiSochimotoShichosonCodeのgetメソッドです。
     * 
     * @return koikinaiTokureiSochimotoShichosonCode
     */
    @CheckForNull
    public LasdecCode getKoikinaiTokureiSochimotoShichosonCode() {
        return koikinaiTokureiSochimotoShichosonCode;
    }

    /**
     * koikinaiTokureiSochimotoShichosonCodeのsetメソッドです。
     * 
     * @param koikinaiTokureiSochimotoShichosonCode koikinaiTokureiSochimotoShichosonCode
     */
    public void setKoikinaiTokureiSochimotoShichosonCode(LasdecCode koikinaiTokureiSochimotoShichosonCode) {
        this.koikinaiTokureiSochimotoShichosonCode = koikinaiTokureiSochimotoShichosonCode;
    }

    /**
     * kyuShichosonCodeのgetメソッドです。
     * 
     * @return kyuShichosonCode
     */
    @CheckForNull
    public LasdecCode getKyuShichosonCode() {
        return kyuShichosonCode;
    }

    /**
     * kyuShichosonCodeのsetメソッドです。
     * 
     * @param kyuShichosonCode kyuShichosonCode
     */
    public void setKyuShichosonCode(LasdecCode kyuShichosonCode) {
        this.kyuShichosonCode = kyuShichosonCode;
    }

    /**
     * logicalDeletedFlagのgetメソッドです。
     * 
     * @return logicalDeletedFlag
     */
    @CheckForNull
    public boolean getLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    /**
     * logicalDeletedFlagのsetメソッドです。
     * 
     * @param logicalDeletedFlag logicalDeletedFlag
     */
    public void setLogicalDeletedFlag(boolean logicalDeletedFlag) {
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV7501HihokenshaDaichoFukushiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV7501HihokenshaDaichoFukushiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV7501HihokenshaDaichoFukushiEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV7501HihokenshaDaichoFukushiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.idoYMD = entity.idoYMD;
        this.edaNo = entity.edaNo;
        this.idoJiyuCode = entity.idoJiyuCode;
        this.shichosonCode = entity.shichosonCode;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.shikakuShutokuJiyuCode = entity.shikakuShutokuJiyuCode;
        this.shikakuShutokuYMD = entity.shikakuShutokuYMD;
        this.shikakuShutokuTodokedeYMD = entity.shikakuShutokuTodokedeYMD;
        this.ichigoShikakuShutokuYMD = entity.ichigoShikakuShutokuYMD;
        this.hihokennshaKubunCode = entity.hihokennshaKubunCode;
        this.shikakuSoshitsuJiyuCode = entity.shikakuSoshitsuJiyuCode;
        this.shikakuSoshitsuYMD = entity.shikakuSoshitsuYMD;
        this.shikakuSoshitsuYMDCmp = entity.shikakuSoshitsuYMDCmp;
        this.shikakuSoshitsuTodokedeYMD = entity.shikakuSoshitsuTodokedeYMD;
        this.shikakuHenkoJiyuCode = entity.shikakuHenkoJiyuCode;
        this.shikakuHenkoYMD = entity.shikakuHenkoYMD;
        this.shikakuHenkoTodokedeYMD = entity.shikakuHenkoTodokedeYMD;
        this.jushochitokureiTekiyoJiyuCode = entity.jushochitokureiTekiyoJiyuCode;
        this.jushochitokureiTekiyoYMD = entity.jushochitokureiTekiyoYMD;
        this.jushochitokureiTekiyoTodokedeYMD = entity.jushochitokureiTekiyoTodokedeYMD;
        this.jushochitokureiKaijoJiyuCode = entity.jushochitokureiKaijoJiyuCode;
        this.jushochitokureiKaijoYMD = entity.jushochitokureiKaijoYMD;
        this.jushochitokureiKaijoTodokedeYMD = entity.jushochitokureiKaijoTodokedeYMD;
        this.jushochiTokureiFlag = entity.jushochiTokureiFlag;
        this.koikinaiJushochiTokureiFlag = entity.koikinaiJushochiTokureiFlag;
        this.koikinaiTokureiSochimotoShichosonCode = entity.koikinaiTokureiSochimotoShichosonCode;
        this.kyuShichosonCode = entity.kyuShichosonCode;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, idoYMD, edaNo, idoJiyuCode, shichosonCode, shikibetsuCode, shikakuShutokuJiyuCode, shikakuShutokuYMD, shikakuShutokuTodokedeYMD, ichigoShikakuShutokuYMD, hihokennshaKubunCode, shikakuSoshitsuJiyuCode, shikakuSoshitsuYMD, shikakuSoshitsuYMDCmp, shikakuSoshitsuTodokedeYMD, shikakuHenkoJiyuCode, shikakuHenkoYMD, shikakuHenkoTodokedeYMD, jushochitokureiTekiyoJiyuCode, jushochitokureiTekiyoYMD, jushochitokureiTekiyoTodokedeYMD, jushochitokureiKaijoJiyuCode, jushochitokureiKaijoYMD, jushochitokureiKaijoTodokedeYMD, jushochiTokureiFlag, koikinaiJushochiTokureiFlag, koikinaiTokureiSochimotoShichosonCode, kyuShichosonCode, logicalDeletedFlag);
    }

// </editor-fold>
}
