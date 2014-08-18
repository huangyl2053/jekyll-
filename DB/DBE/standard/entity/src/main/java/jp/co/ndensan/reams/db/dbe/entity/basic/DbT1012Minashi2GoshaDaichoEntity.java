package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;

/**
 * DbT1012Minashi2GoshaDaichoの項目定義クラスです
 *
 */
public class DbT1012Minashi2GoshaDaichoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT1012Minashi2GoshaDaicho");

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
    private KaigoHihokenshaNo hihokenshaNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private ShikibetsuCode shikibetsuCode;
    private Code hihokenshaKubunCode;
    private FlexibleDate minashi2GoshaTorokuYMD;
    private FlexibleDate minashi2GoshaKaijoYMD;
    //TODO n8178 城間篤人 福祉で使用されている被保険者番号に変更するか、新規で型を作る必要がある 2014年9月末
    private RString fukushiHihokenshaNo;

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
     * getHihokenshaKubunCode
     *
     * @return hihokenshaKubunCode
     */
    public Code getHihokenshaKubunCode() {
        return hihokenshaKubunCode;
    }

    /**
     * setHihokenshaKubunCode
     *
     * @param hihokenshaKubunCode hihokenshaKubunCode
     */
    public void setHihokenshaKubunCode(Code hihokenshaKubunCode) {
        this.hihokenshaKubunCode = hihokenshaKubunCode;
    }

    /**
     * getHihokenshaKubunCodeMeisho
     *
     * @return Meisho
     */
    public RString getHihokenshaKubunCodeMeisho() {
        //TODO n8178 城間篤人 コードマスタからの取得方法が確立された後修正予定 2014年9月
        return new RString("みなし2号");
//        return CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.認定審査員区分, hihokenshaKubunCode);
    }

    /**
     * getHihokenshaKubunCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getHihokenshaKubunCodeRyakusho() {
        //TODO n8178 城間篤人 コードマスタからの取得方法が確立された後修正予定 2014年9月
        return new RString("みなし2号");
//        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.認定審査員区分, hihokenshaKubunCode);
    }

    /**
     * getMinashi2GoshaTorokuYMD
     *
     * @return minashi2GoshaTorokuYMD
     */
    public FlexibleDate getMinashi2GoshaTorokuYMD() {
        return minashi2GoshaTorokuYMD;
    }

    /**
     * setMinashi2GoshaTorokuYMD
     *
     * @param minashi2GoshaTorokuYMD minashi2GoshaTorokuYMD
     */
    public void setMinashi2GoshaTorokuYMD(FlexibleDate minashi2GoshaTorokuYMD) {
        this.minashi2GoshaTorokuYMD = minashi2GoshaTorokuYMD;
    }

    /**
     * getMinashi2GoshaKaijoYMD
     *
     * @return minashi2GoshaKaijoYMD
     */
    public FlexibleDate getMinashi2GoshaKaijoYMD() {
        return minashi2GoshaKaijoYMD;
    }

    /**
     * setMinashi2GoshaKaijoYMD
     *
     * @param minashi2GoshaKaijoYMD minashi2GoshaKaijoYMD
     */
    public void setMinashi2GoshaKaijoYMD(FlexibleDate minashi2GoshaKaijoYMD) {
        this.minashi2GoshaKaijoYMD = minashi2GoshaKaijoYMD;
    }

    /**
     * getFukushiHihokenshaNo
     *
     * @return fukushiHihokenshaNo
     */
    public RString getFukushiHihokenshaNo() {
        return fukushiHihokenshaNo;
    }

    /**
     * setFukushiHihokenshaNo
     *
     * @param fukushiHihokenshaNo fukushiHihokenshaNo
     */
    public void setFukushiHihokenshaNo(RString fukushiHihokenshaNo) {
        this.fukushiHihokenshaNo = fukushiHihokenshaNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1012Minashi2GoshaDaichoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1012Minashi2GoshaDaichoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT1012Minashi2GoshaDaichoEntity other) {
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

// </editor-fold>
}
