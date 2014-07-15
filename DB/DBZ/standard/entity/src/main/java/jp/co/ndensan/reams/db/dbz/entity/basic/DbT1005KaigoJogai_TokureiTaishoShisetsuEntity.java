package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import java.util.Objects;

/**
 * DbT1005KaigoJogai_TokureiTaishoShisetsuの項目定義クラスです
 *
 */
public class DbT1005KaigoJogai_TokureiTaishoShisetsuEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT1005KaigoJogai_TokureiTaishoShisetsu");

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
    private RString nyushoShisetsuShurui;
    @PrimaryKey
    private RString nyushoShisetsuCode;
    @PrimaryKey
    private RDateTime shoriTimestamp;
    private FlexibleDate yukoKaishiYMD;
    private FlexibleDate yukoShuryoYMD;
    private ShikibetsuCode shikibetsuCode;
    private RString shisetsuRyakusho;
    private RString shisetsuKanaRyakusho;
    private RString shisetsuKanaJusho;
    private RString idoJiyuCode;
    private FlexibleDate idoYMD;
    private RString hojinShubetsuCode;
    private FlexibleDate shisetsuKaishiYMD;
    private FlexibleDate shisetsuKyushiYMD;
    private FlexibleDate shisetsuHaishiYMD;
    private FlexibleDate shisetsuSaikaiYMD;

    /**
     * getInsertDantaiCd
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * setLastUpdateReamsLoginId
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getNyushoShisetsuShurui
     * @return nyushoShisetsuShurui
     */
    public RString getNyushoShisetsuShurui() {
        return nyushoShisetsuShurui;
    }

    /**
     * setNyushoShisetsuShurui
     * @param nyushoShisetsuShurui nyushoShisetsuShurui
     */
    public void setNyushoShisetsuShurui(RString nyushoShisetsuShurui) {
        this.nyushoShisetsuShurui = nyushoShisetsuShurui;
    }

    /**
     * getNyushoShisetsuCode
     * @return nyushoShisetsuCode
     */
    public RString getNyushoShisetsuCode() {
        return nyushoShisetsuCode;
    }

    /**
     * setNyushoShisetsuCode
     * @param nyushoShisetsuCode nyushoShisetsuCode
     */
    public void setNyushoShisetsuCode(RString nyushoShisetsuCode) {
        this.nyushoShisetsuCode = nyushoShisetsuCode;
    }

    /**
     * getShoriTimestamp
     * @return shoriTimestamp
     */
    public RDateTime getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(RDateTime shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getYukoKaishiYMD
     * @return yukoKaishiYMD
     */
    public FlexibleDate getYukoKaishiYMD() {
        return yukoKaishiYMD;
    }

    /**
     * setYukoKaishiYMD
     * @param yukoKaishiYMD yukoKaishiYMD
     */
    public void setYukoKaishiYMD(FlexibleDate yukoKaishiYMD) {
        this.yukoKaishiYMD = yukoKaishiYMD;
    }

    /**
     * getYukoShuryoYMD
     * @return yukoShuryoYMD
     */
    public FlexibleDate getYukoShuryoYMD() {
        return yukoShuryoYMD;
    }

    /**
     * setYukoShuryoYMD
     * @param yukoShuryoYMD yukoShuryoYMD
     */
    public void setYukoShuryoYMD(FlexibleDate yukoShuryoYMD) {
        this.yukoShuryoYMD = yukoShuryoYMD;
    }

    /**
     * getShikibetsuCode
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * getShisetsuRyakusho
     * @return shisetsuRyakusho
     */
    public RString getShisetsuRyakusho() {
        return shisetsuRyakusho;
    }

    /**
     * setShisetsuRyakusho
     * @param shisetsuRyakusho shisetsuRyakusho
     */
    public void setShisetsuRyakusho(RString shisetsuRyakusho) {
        this.shisetsuRyakusho = shisetsuRyakusho;
    }

    /**
     * getShisetsuKanaRyakusho
     * @return shisetsuKanaRyakusho
     */
    public RString getShisetsuKanaRyakusho() {
        return shisetsuKanaRyakusho;
    }

    /**
     * setShisetsuKanaRyakusho
     * @param shisetsuKanaRyakusho shisetsuKanaRyakusho
     */
    public void setShisetsuKanaRyakusho(RString shisetsuKanaRyakusho) {
        this.shisetsuKanaRyakusho = shisetsuKanaRyakusho;
    }

    /**
     * getShisetsuKanaJusho
     * @return shisetsuKanaJusho
     */
    public RString getShisetsuKanaJusho() {
        return shisetsuKanaJusho;
    }

    /**
     * setShisetsuKanaJusho
     * @param shisetsuKanaJusho shisetsuKanaJusho
     */
    public void setShisetsuKanaJusho(RString shisetsuKanaJusho) {
        this.shisetsuKanaJusho = shisetsuKanaJusho;
    }

    /**
     * getIdoJiyuCode
     * @return idoJiyuCode
     */
    public RString getIdoJiyuCode() {
        return idoJiyuCode;
    }

    /**
     * setIdoJiyuCode
     * @param idoJiyuCode idoJiyuCode
     */
    public void setIdoJiyuCode(RString idoJiyuCode) {
        this.idoJiyuCode = idoJiyuCode;
    }

    /**
     * getIdoYMD
     * @return idoYMD
     */
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * setIdoYMD
     * @param idoYMD idoYMD
     */
    public void setIdoYMD(FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * getHojinShubetsuCode
     * @return hojinShubetsuCode
     */
    public RString getHojinShubetsuCode() {
        return hojinShubetsuCode;
    }

    /**
     * setHojinShubetsuCode
     * @param hojinShubetsuCode hojinShubetsuCode
     */
    public void setHojinShubetsuCode(RString hojinShubetsuCode) {
        this.hojinShubetsuCode = hojinShubetsuCode;
    }

    /**
     * getShisetsuKaishiYMD
     * @return shisetsuKaishiYMD
     */
    public FlexibleDate getShisetsuKaishiYMD() {
        return shisetsuKaishiYMD;
    }

    /**
     * setShisetsuKaishiYMD
     * @param shisetsuKaishiYMD shisetsuKaishiYMD
     */
    public void setShisetsuKaishiYMD(FlexibleDate shisetsuKaishiYMD) {
        this.shisetsuKaishiYMD = shisetsuKaishiYMD;
    }

    /**
     * getShisetsuKyushiYMD
     * @return shisetsuKyushiYMD
     */
    public FlexibleDate getShisetsuKyushiYMD() {
        return shisetsuKyushiYMD;
    }

    /**
     * setShisetsuKyushiYMD
     * @param shisetsuKyushiYMD shisetsuKyushiYMD
     */
    public void setShisetsuKyushiYMD(FlexibleDate shisetsuKyushiYMD) {
        this.shisetsuKyushiYMD = shisetsuKyushiYMD;
    }

    /**
     * getShisetsuHaishiYMD
     * @return shisetsuHaishiYMD
     */
    public FlexibleDate getShisetsuHaishiYMD() {
        return shisetsuHaishiYMD;
    }

    /**
     * setShisetsuHaishiYMD
     * @param shisetsuHaishiYMD shisetsuHaishiYMD
     */
    public void setShisetsuHaishiYMD(FlexibleDate shisetsuHaishiYMD) {
        this.shisetsuHaishiYMD = shisetsuHaishiYMD;
    }

    /**
     * getShisetsuSaikaiYMD
     * @return shisetsuSaikaiYMD
     */
    public FlexibleDate getShisetsuSaikaiYMD() {
        return shisetsuSaikaiYMD;
    }

    /**
     * setShisetsuSaikaiYMD
     * @param shisetsuSaikaiYMD shisetsuSaikaiYMD
     */
    public void setShisetsuSaikaiYMD(FlexibleDate shisetsuSaikaiYMD) {
        this.shisetsuSaikaiYMD = shisetsuSaikaiYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1005KaigoJogai_TokureiTaishoShisetsuEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1005KaigoJogai_TokureiTaishoShisetsuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT1005KaigoJogai_TokureiTaishoShisetsuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.insertTimestamp, other.insertTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.nyushoShisetsuShurui, other.nyushoShisetsuShurui)) {
            return false;
        }
        if (!Objects.equals(this.nyushoShisetsuCode, other.nyushoShisetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

// </editor-fold>

}
