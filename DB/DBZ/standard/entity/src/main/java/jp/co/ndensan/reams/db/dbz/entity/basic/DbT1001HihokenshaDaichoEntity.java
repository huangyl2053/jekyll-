package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuHenkoJiyuHihokensha;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuJutokuKaijo;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuJutokuTekiyo;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuShutokuJiyuHihokensha;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuSoshitsuJiyuHihokennsha;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KofuJiyu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * DbT1001HihokenshaDaichoの項目定義クラスです
 *
 */
public class DbT1001HihokenshaDaichoEntity extends DbTableEntityBase<DbT1001HihokenshaDaichoEntity> implements IDbAccessable {

    // <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT1001HihokenshaDaicho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private LasdecCode shichosonCode;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private ShikibetsuCode shikibetsuCode;
    private KaigoshikakuShutokuJiyuHihokensha shikakuShutokuJiyuCode;
    private FlexibleDate shikakuShutokuYMD;
    private FlexibleDate shikakuShutokuTodokedeYMD;
    private FlexibleDate ichigoShikakuShutokuYMD;
    private RString hihokennshaKubunCode;
    private KaigoshikakuSoshitsuJiyuHihokennsha shikakuSoshitsuJiyuCode;
    private FlexibleDate shikakuSoshitsuYMD;
    private FlexibleDate shikakuSoshitsuTodokedeYMD;
    private RString jushochiTokureiFlag;
    private KaigoshikakuHenkoJiyuHihokensha shikakuHenkoJiyuCode;
    private FlexibleDate shikakuHenkoYMD;
    private FlexibleDate shikakuHenkoTodokedeYMD;
    private KaigoshikakuJutokuTekiyo jushochitokureiTekiyoJiyuCode;
    private FlexibleDate jushochitokureiTekiyoYMD;
    private FlexibleDate jushochitokureiTekiyoTodokedeYMD;
    private KaigoshikakuJutokuKaijo jushochitokureiKaijoJiyuCode;
    private FlexibleDate jushochitokureiKaijoYMD;
    private FlexibleDate jushochitokureiKaijoTodokedeYMD;
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
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
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
     * getShikakuShutokuJiyuCode
     *
     * @return shikakuShutokuJiyuCode
     */
    public KaigoshikakuShutokuJiyuHihokensha getShikakuShutokuJiyuCode() {
        return shikakuShutokuJiyuCode;
    }

    /**
     * setShikakuShutokuJiyuCode
     *
     * @param shikakuShutokuJiyuCode shikakuShutokuJiyuCode
     */
    public void setShikakuShutokuJiyuCode(KaigoshikakuShutokuJiyuHihokensha shikakuShutokuJiyuCode) {
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
     * getIchigoShikakuShutokuYMD
     *
     * @return ichigoShikakuShutokuYMD
     */
    public FlexibleDate getIchigoShikakuShutokuYMD() {
        return ichigoShikakuShutokuYMD;
    }

    /**
     * setIchigoShikakuShutokuYMD
     *
     * @param ichigoShikakuShutokuYMD ichigoShikakuShutokuYMD
     */
    public void setIchigoShikakuShutokuYMD(FlexibleDate ichigoShikakuShutokuYMD) {
        this.ichigoShikakuShutokuYMD = ichigoShikakuShutokuYMD;
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
    public KaigoshikakuSoshitsuJiyuHihokennsha getShikakuSoshitsuJiyuCode() {
        return shikakuSoshitsuJiyuCode;
    }

    /**
     * setShikakuSoshitsuJiyuCode
     *
     * @param shikakuSoshitsuJiyuCode shikakuSoshitsuJiyuCode
     */
    public void setShikakuSoshitsuJiyuCode(KaigoshikakuSoshitsuJiyuHihokennsha shikakuSoshitsuJiyuCode) {
        this.shikakuSoshitsuJiyuCode = shikakuSoshitsuJiyuCode;
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
     * getShikakuHenkoJiyuCode
     *
     * @return shikakuHenkoJiyuCode
     */
    public KaigoshikakuHenkoJiyuHihokensha getShikakuHenkoJiyuCode() {
        return shikakuHenkoJiyuCode;
    }

    /**
     * setShikakuHenkoJiyuCode
     *
     * @param shikakuHenkoJiyuCode shikakuHenkoJiyuCode
     */
    public void setShikakuHenkoJiyuCode(KaigoshikakuHenkoJiyuHihokensha shikakuHenkoJiyuCode) {
        this.shikakuHenkoJiyuCode = shikakuHenkoJiyuCode;
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
     * getJushochitokureiTekiyoJiyuCode
     *
     * @return jushochitokureiTekiyoJiyuCode
     */
    public KaigoshikakuJutokuTekiyo getJushochitokureiTekiyoJiyuCode() {
        return jushochitokureiTekiyoJiyuCode;
    }

    /**
     * setJushochitokureiTekiyoJiyuCode
     *
     * @param jushochitokureiTekiyoJiyuCode jushochitokureiTekiyoJiyuCode
     */
    public void setJushochitokureiTekiyoJiyuCode(KaigoshikakuJutokuTekiyo jushochitokureiTekiyoJiyuCode) {
        this.jushochitokureiTekiyoJiyuCode = jushochitokureiTekiyoJiyuCode;
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
     * getJushochitokureiKaijoJiyuCode
     *
     * @return jushochitokureiKaijoJiyuCode
     */
    public KaigoshikakuJutokuKaijo getJushochitokureiKaijoJiyuCode() {
        return jushochitokureiKaijoJiyuCode;
    }

    /**
     * setJushochitokureiKaijoJiyuCode
     *
     * @param jushochitokureiKaijoJiyuCode jushochitokureiKaijoJiyuCode
     */
    public void setJushochitokureiKaijoJiyuCode(KaigoshikakuJutokuKaijo jushochitokureiKaijoJiyuCode) {
        this.jushochitokureiKaijoJiyuCode = jushochitokureiKaijoJiyuCode;
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
    @Override
    public boolean equalsPrimaryKeys(DbT1001HihokenshaDaichoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT1001HihokenshaDaichoEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.shikakuShutokuJiyuCode = entity.shikakuShutokuJiyuCode;
        this.shikakuShutokuYMD = entity.shikakuShutokuYMD;
        this.shikakuShutokuTodokedeYMD = entity.shikakuShutokuTodokedeYMD;
        this.ichigoShikakuShutokuYMD = entity.ichigoShikakuShutokuYMD;
        this.hihokennshaKubunCode = entity.hihokennshaKubunCode;
        this.shikakuSoshitsuJiyuCode = entity.shikakuSoshitsuJiyuCode;
        this.shikakuSoshitsuYMD = entity.shikakuSoshitsuYMD;
        this.shikakuSoshitsuTodokedeYMD = entity.shikakuSoshitsuTodokedeYMD;
        this.jushochiTokureiFlag = entity.jushochiTokureiFlag;
        this.shikakuHenkoJiyuCode = entity.shikakuHenkoJiyuCode;
        this.shikakuHenkoYMD = entity.shikakuHenkoYMD;
        this.shikakuHenkoTodokedeYMD = entity.shikakuHenkoTodokedeYMD;
        this.jushochitokureiTekiyoJiyuCode = entity.jushochitokureiTekiyoJiyuCode;
        this.jushochitokureiTekiyoYMD = entity.jushochitokureiTekiyoYMD;
        this.jushochitokureiTekiyoTodokedeYMD = entity.jushochitokureiTekiyoTodokedeYMD;
        this.jushochitokureiKaijoJiyuCode = entity.jushochitokureiKaijoJiyuCode;
        this.jushochitokureiKaijoYMD = entity.jushochitokureiKaijoYMD;
        this.jushochitokureiKaijoTodokedeYMD = entity.jushochitokureiKaijoTodokedeYMD;
        this.koikinaiJushochiTokureiFlag = entity.koikinaiJushochiTokureiFlag;
        this.koikinaiTokureiSochimotoShichosonCode = entity.koikinaiTokureiSochimotoShichosonCode;
        this.kyuShichosonCode = entity.kyuShichosonCode;
        this.saikofuKubun = entity.saikofuKubun;
        this.saikofuJiyuCode = entity.saikofuJiyuCode;
        this.chohyoKofuRirekiID = entity.chohyoKofuRirekiID;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, hihokenshaNo, shoriTimestamp, shikibetsuCode, shikakuShutokuJiyuCode, shikakuShutokuYMD, shikakuShutokuTodokedeYMD, ichigoShikakuShutokuYMD, hihokennshaKubunCode, shikakuSoshitsuJiyuCode, shikakuSoshitsuYMD, shikakuSoshitsuTodokedeYMD, jushochiTokureiFlag, shikakuHenkoJiyuCode, shikakuHenkoYMD, shikakuHenkoTodokedeYMD, jushochitokureiTekiyoJiyuCode, jushochitokureiTekiyoYMD, jushochitokureiTekiyoTodokedeYMD, jushochitokureiKaijoJiyuCode, jushochitokureiKaijoYMD, jushochitokureiKaijoTodokedeYMD, koikinaiJushochiTokureiFlag, koikinaiTokureiSochimotoShichosonCode, kyuShichosonCode, saikofuKubun, saikofuJiyuCode, chohyoKofuRirekiID);
    }

// </editor-fold>
    /**
     * 最終更新日時を取得します。
     *
     * @return 最終更新日時
     */
    public RDateTime getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

}
