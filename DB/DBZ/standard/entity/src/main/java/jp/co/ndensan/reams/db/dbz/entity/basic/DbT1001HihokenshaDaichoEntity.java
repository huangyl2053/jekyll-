package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;

/**
 * DbT1001HihokenshaDaichoの項目定義クラスです。
 *
 */
public class DbT1001HihokenshaDaichoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT1001HihokenshaDaicho");
    private RString insertDantaiCd;
    @PrimaryKey
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private LasdecCode shichosonCode;
    private KaigoHihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RDateTime shoriTimestamp;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate shikakuShutokuTodokedeYMD;
    private RString shikakuShutokuJiyuCode;
    private FlexibleDate shikakuShutokuYMD;
    private FlexibleDate ichigoHihokenshaNenreiTotatsuYMD;
    private RString hihokennshaKubunCode;
    private RString shikakuSoshitsuJiyuCode;
    private FlexibleDate shikakuSoshitsuTodokedeYMD;
    private FlexibleDate shikakuSoshitsuYMD;
    private RString jushochiTokureiFlag;
    private RString shikakuIdouKubunCode;
    private RString shikakuHenkoJiyuCode;
    private FlexibleDate shikakuHenkoTodokedeYMD;
    private FlexibleDate shikakuHenkoYMD;
    private RString jushochitokureiTekiyoJiyuCode;
    private FlexibleDate jushochitokureiTekiyoTodokedeYMD;
    private FlexibleDate jushochitokureiTekiyoYMD;
    private RString jushochitokureiKaijoJiyuCode;
    private FlexibleDate jushochitokureiKaijoTodokedeYMD;
    private FlexibleDate jushochitokureiKaijoYMD;
    private RString koikinaiJushochiTokureiFlag;
    private LasdecCode koikinaiTokureiSochimotoShichosonCode;
    private LasdecCode kyuShichosonCode;
    private RString saikofuKubun;
    private RString saikofuJiyuCode;
    private RString chohyoKofuRirekiID;

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
     * getShichosonCode
     *
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     *
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * getHihokenshaNo
     *
     * @return hihokenshaNo
     */
    public KaigoHihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(KaigoHihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public RDateTime getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(RDateTime shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getShikibetsuCode
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     *
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * getShikakuShutokuTodokedeYMD
     *
     * @return shikakuShutokuTodokedeYMD
     */
    public FlexibleDate getShikakuShutokuTodokedeYMD() {
        return shikakuShutokuTodokedeYMD;
    }

    /**
     * setShikakuShutokuTodokedeYMD
     *
     * @param shikakuShutokuTodokedeYMD shikakuShutokuTodokedeYMD
     */
    public void setShikakuShutokuTodokedeYMD(FlexibleDate shikakuShutokuTodokedeYMD) {
        this.shikakuShutokuTodokedeYMD = shikakuShutokuTodokedeYMD;
    }

    /**
     * getShikakuShutokuJiyuCode
     *
     * @return shikakuShutokuJiyuCode
     */
    public RString getShikakuShutokuJiyuCode() {
        return shikakuShutokuJiyuCode;
    }

    /**
     * setShikakuShutokuJiyuCode
     *
     * @param shikakuShutokuJiyuCode shikakuShutokuJiyuCode
     */
    public void setShikakuShutokuJiyuCode(RString shikakuShutokuJiyuCode) {
        this.shikakuShutokuJiyuCode = shikakuShutokuJiyuCode;
    }

    /**
     * getShikakuShutokuYMD
     *
     * @return shikakuShutokuYMD
     */
    public FlexibleDate getShikakuShutokuYMD() {
        return shikakuShutokuYMD;
    }

    /**
     * setShikakuShutokuYMD
     *
     * @param shikakuShutokuYMD shikakuShutokuYMD
     */
    public void setShikakuShutokuYMD(FlexibleDate shikakuShutokuYMD) {
        this.shikakuShutokuYMD = shikakuShutokuYMD;
    }

    /**
     * getIchigoHihokenshaNenreiTotatsuYMD
     *
     * @return ichigoHihokenshaNenreiTotatsuYMD
     */
    public FlexibleDate getIchigoHihokenshaNenreiTotatsuYMD() {
        return ichigoHihokenshaNenreiTotatsuYMD;
    }

    /**
     * setIchigoHihokenshaNenreiTotatsuYMD
     *
     * @param ichigoHihokenshaNenreiTotatsuYMD ichigoHihokenshaNenreiTotatsuYMD
     */
    public void setIchigoHihokenshaNenreiTotatsuYMD(FlexibleDate ichigoHihokenshaNenreiTotatsuYMD) {
        this.ichigoHihokenshaNenreiTotatsuYMD = ichigoHihokenshaNenreiTotatsuYMD;
    }

    /**
     * getHihokennshaKubunCode
     *
     * @return hihokennshaKubunCode
     */
    public RString getHihokennshaKubunCode() {
        return hihokennshaKubunCode;
    }

    /**
     * setHihokennshaKubunCode
     *
     * @param hihokennshaKubunCode hihokennshaKubunCode
     */
    public void setHihokennshaKubunCode(RString hihokennshaKubunCode) {
        this.hihokennshaKubunCode = hihokennshaKubunCode;
    }

    /**
     * getShikakuSoshitsuJiyuCode
     *
     * @return shikakuSoshitsuJiyuCode
     */
    public RString getShikakuSoshitsuJiyuCode() {
        return shikakuSoshitsuJiyuCode;
    }

    /**
     * setShikakuSoshitsuJiyuCode
     *
     * @param shikakuSoshitsuJiyuCode shikakuSoshitsuJiyuCode
     */
    public void setShikakuSoshitsuJiyuCode(RString shikakuSoshitsuJiyuCode) {
        this.shikakuSoshitsuJiyuCode = shikakuSoshitsuJiyuCode;
    }

    /**
     * getShikakuSoshitsuTodokedeYMD
     *
     * @return shikakuSoshitsuTodokedeYMD
     */
    public FlexibleDate getShikakuSoshitsuTodokedeYMD() {
        return shikakuSoshitsuTodokedeYMD;
    }

    /**
     * setShikakuSoshitsuTodokedeYMD
     *
     * @param shikakuSoshitsuTodokedeYMD shikakuSoshitsuTodokedeYMD
     */
    public void setShikakuSoshitsuTodokedeYMD(FlexibleDate shikakuSoshitsuTodokedeYMD) {
        this.shikakuSoshitsuTodokedeYMD = shikakuSoshitsuTodokedeYMD;
    }

    /**
     * getShikakuSoshitsuYMD
     *
     * @return shikakuSoshitsuYMD
     */
    public FlexibleDate getShikakuSoshitsuYMD() {
        return shikakuSoshitsuYMD;
    }

    /**
     * setShikakuSoshitsuYMD
     *
     * @param shikakuSoshitsuYMD shikakuSoshitsuYMD
     */
    public void setShikakuSoshitsuYMD(FlexibleDate shikakuSoshitsuYMD) {
        this.shikakuSoshitsuYMD = shikakuSoshitsuYMD;
    }

    /**
     * getJushochiTokureiFlag
     *
     * @return jushochiTokureiFlag
     */
    public RString getJushochiTokureiFlag() {
        return jushochiTokureiFlag;
    }

    /**
     * setJushochiTokureiFlag
     *
     * @param jushochiTokureiFlag jushochiTokureiFlag
     */
    public void setJushochiTokureiFlag(RString jushochiTokureiFlag) {
        this.jushochiTokureiFlag = jushochiTokureiFlag;
    }

    /**
     * getShikakuIdouKubunCode
     *
     * @return shikakuIdouKubunCode
     */
    public RString getShikakuIdouKubunCode() {
        return shikakuIdouKubunCode;
    }

    /**
     * setShikakuIdouKubunCode
     *
     * @param shikakuIdouKubunCode shikakuIdouKubunCode
     */
    public void setShikakuIdouKubunCode(RString shikakuIdouKubunCode) {
        this.shikakuIdouKubunCode = shikakuIdouKubunCode;
    }

    /**
     * getShikakuHenkoJiyuCode
     *
     * @return shikakuHenkoJiyuCode
     */
    public RString getShikakuHenkoJiyuCode() {
        return shikakuHenkoJiyuCode;
    }

    /**
     * setShikakuHenkoJiyuCode
     *
     * @param shikakuHenkoJiyuCode shikakuHenkoJiyuCode
     */
    public void setShikakuHenkoJiyuCode(RString shikakuHenkoJiyuCode) {
        this.shikakuHenkoJiyuCode = shikakuHenkoJiyuCode;
    }

    /**
     * getShikakuHenkoTodokedeYMD
     *
     * @return shikakuHenkoTodokedeYMD
     */
    public FlexibleDate getShikakuHenkoTodokedeYMD() {
        return shikakuHenkoTodokedeYMD;
    }

    /**
     * setShikakuHenkoTodokedeYMD
     *
     * @param shikakuHenkoTodokedeYMD shikakuHenkoTodokedeYMD
     */
    public void setShikakuHenkoTodokedeYMD(FlexibleDate shikakuHenkoTodokedeYMD) {
        this.shikakuHenkoTodokedeYMD = shikakuHenkoTodokedeYMD;
    }

    /**
     * getShikakuHenkoYMD
     *
     * @return shikakuHenkoYMD
     */
    public FlexibleDate getShikakuHenkoYMD() {
        return shikakuHenkoYMD;
    }

    /**
     * setShikakuHenkoYMD
     *
     * @param shikakuHenkoYMD shikakuHenkoYMD
     */
    public void setShikakuHenkoYMD(FlexibleDate shikakuHenkoYMD) {
        this.shikakuHenkoYMD = shikakuHenkoYMD;
    }

    /**
     * getJushochitokureiTekiyoJiyuCode
     *
     * @return jushochitokureiTekiyoJiyuCode
     */
    public RString getJushochitokureiTekiyoJiyuCode() {
        return jushochitokureiTekiyoJiyuCode;
    }

    /**
     * setJushochitokureiTekiyoJiyuCode
     *
     * @param jushochitokureiTekiyoJiyuCode jushochitokureiTekiyoJiyuCode
     */
    public void setJushochitokureiTekiyoJiyuCode(RString jushochitokureiTekiyoJiyuCode) {
        this.jushochitokureiTekiyoJiyuCode = jushochitokureiTekiyoJiyuCode;
    }

    /**
     * getJushochitokureiTekiyoTodokedeYMD
     *
     * @return jushochitokureiTekiyoTodokedeYMD
     */
    public FlexibleDate getJushochitokureiTekiyoTodokedeYMD() {
        return jushochitokureiTekiyoTodokedeYMD;
    }

    /**
     * setJushochitokureiTekiyoTodokedeYMD
     *
     * @param jushochitokureiTekiyoTodokedeYMD jushochitokureiTekiyoTodokedeYMD
     */
    public void setJushochitokureiTekiyoTodokedeYMD(FlexibleDate jushochitokureiTekiyoTodokedeYMD) {
        this.jushochitokureiTekiyoTodokedeYMD = jushochitokureiTekiyoTodokedeYMD;
    }

    /**
     * getJushochitokureiTekiyoYMD
     *
     * @return jushochitokureiTekiyoYMD
     */
    public FlexibleDate getJushochitokureiTekiyoYMD() {
        return jushochitokureiTekiyoYMD;
    }

    /**
     * setJushochitokureiTekiyoYMD
     *
     * @param jushochitokureiTekiyoYMD jushochitokureiTekiyoYMD
     */
    public void setJushochitokureiTekiyoYMD(FlexibleDate jushochitokureiTekiyoYMD) {
        this.jushochitokureiTekiyoYMD = jushochitokureiTekiyoYMD;
    }

    /**
     * getJushochitokureiKaijoJiyuCode
     *
     * @return jushochitokureiKaijoJiyuCode
     */
    public RString getJushochitokureiKaijoJiyuCode() {
        return jushochitokureiKaijoJiyuCode;
    }

    /**
     * setJushochitokureiKaijoJiyuCode
     *
     * @param jushochitokureiKaijoJiyuCode jushochitokureiKaijoJiyuCode
     */
    public void setJushochitokureiKaijoJiyuCode(RString jushochitokureiKaijoJiyuCode) {
        this.jushochitokureiKaijoJiyuCode = jushochitokureiKaijoJiyuCode;
    }

    /**
     * getJushochitokureiKaijoTodokedeYMD
     *
     * @return jushochitokureiKaijoTodokedeYMD
     */
    public FlexibleDate getJushochitokureiKaijoTodokedeYMD() {
        return jushochitokureiKaijoTodokedeYMD;
    }

    /**
     * setJushochitokureiKaijoTodokedeYMD
     *
     * @param jushochitokureiKaijoTodokedeYMD jushochitokureiKaijoTodokedeYMD
     */
    public void setJushochitokureiKaijoTodokedeYMD(FlexibleDate jushochitokureiKaijoTodokedeYMD) {
        this.jushochitokureiKaijoTodokedeYMD = jushochitokureiKaijoTodokedeYMD;
    }

    /**
     * getJushochitokureiKaijoYMD
     *
     * @return jushochitokureiKaijoYMD
     */
    public FlexibleDate getJushochitokureiKaijoYMD() {
        return jushochitokureiKaijoYMD;
    }

    /**
     * setJushochitokureiKaijoYMD
     *
     * @param jushochitokureiKaijoYMD jushochitokureiKaijoYMD
     */
    public void setJushochitokureiKaijoYMD(FlexibleDate jushochitokureiKaijoYMD) {
        this.jushochitokureiKaijoYMD = jushochitokureiKaijoYMD;
    }

    /**
     * getKoikinaiJushochiTokureiFlag
     *
     * @return koikinaiJushochiTokureiFlag
     */
    public RString getKoikinaiJushochiTokureiFlag() {
        return koikinaiJushochiTokureiFlag;
    }

    /**
     * setKoikinaiJushochiTokureiFlag
     *
     * @param koikinaiJushochiTokureiFlag koikinaiJushochiTokureiFlag
     */
    public void setKoikinaiJushochiTokureiFlag(RString koikinaiJushochiTokureiFlag) {
        this.koikinaiJushochiTokureiFlag = koikinaiJushochiTokureiFlag;
    }

    /**
     * getKoikinaiTokureiSochimotoShichosonCode
     *
     * @return koikinaiTokureiSochimotoShichosonCode
     */
    public LasdecCode getKoikinaiTokureiSochimotoShichosonCode() {
        return koikinaiTokureiSochimotoShichosonCode;
    }

    /**
     * setKoikinaiTokureiSochimotoShichosonCode
     *
     * @param koikinaiTokureiSochimotoShichosonCode
     * koikinaiTokureiSochimotoShichosonCode
     */
    public void setKoikinaiTokureiSochimotoShichosonCode(LasdecCode koikinaiTokureiSochimotoShichosonCode) {
        this.koikinaiTokureiSochimotoShichosonCode = koikinaiTokureiSochimotoShichosonCode;
    }

    /**
     * getKyuShichosonCode
     *
     * @return kyuShichosonCode
     */
    public LasdecCode getKyuShichosonCode() {
        return kyuShichosonCode;
    }

    /**
     * setKyuShichosonCode
     *
     * @param kyuShichosonCode kyuShichosonCode
     */
    public void setKyuShichosonCode(LasdecCode kyuShichosonCode) {
        this.kyuShichosonCode = kyuShichosonCode;
    }

    /**
     * getSaikofuKubun
     *
     * @return saikofuKubun
     */
    public RString getSaikofuKubun() {
        return saikofuKubun;
    }

    /**
     * setSaikofuKubun
     *
     * @param saikofuKubun saikofuKubun
     */
    public void setSaikofuKubun(RString saikofuKubun) {
        this.saikofuKubun = saikofuKubun;
    }

    /**
     * getSaikofuJiyuCode
     *
     * @return saikofuJiyuCode
     */
    public RString getSaikofuJiyuCode() {
        return saikofuJiyuCode;
    }

    /**
     * setSaikofuJiyuCode
     *
     * @param saikofuJiyuCode saikofuJiyuCode
     */
    public void setSaikofuJiyuCode(RString saikofuJiyuCode) {
        this.saikofuJiyuCode = saikofuJiyuCode;
    }

    /**
     * getChohyoKofuRirekiID
     *
     * @return chohyoKofuRirekiID
     */
    public RString getChohyoKofuRirekiID() {
        return chohyoKofuRirekiID;
    }

    /**
     * setChohyoKofuRirekiID
     *
     * @param chohyoKofuRirekiID chohyoKofuRirekiID
     */
    public void setChohyoKofuRirekiID(RString chohyoKofuRirekiID) {
        this.chohyoKofuRirekiID = chohyoKofuRirekiID;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1001HihokenshaDaichoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1001HihokenshaDaichoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT1001HihokenshaDaichoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.insertTimestamp, other.insertTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        return true;
    }
// </editor-fold>
}
