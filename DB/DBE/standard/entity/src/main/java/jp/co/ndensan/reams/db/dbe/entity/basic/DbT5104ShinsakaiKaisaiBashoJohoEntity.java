package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaisaiBashoChikuCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaisaiBashoCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * DbT5104ShinsakaiKaisaiBashoJohoの項目定義クラスです
 *
 * @author N1013 松本直樹
 */
public class DbT5104ShinsakaiKaisaiBashoJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5104ShinsakaiKaisaiBashoJoho");
    private RString insertDantaiCd = RString.EMPTY;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId = RString.EMPTY;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId = RString.EMPTY;
    @PrimaryKey
    private KaisaiBashoCode shinsakaiKaisaiBashoCode;
    private RString shinsakaiKaisaiBashoMei;
    private KaisaiBashoChikuCode shinsakaiKaisaiChikuCode;
    private RString shinsakaiKaisaiBashoJusho;
    private RString shinsakaiKaisaiBashoTelNo;
    private boolean shinsakaiKaisaiBashoJokyo;

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
     * getShinsakaiKaisaiBashoCode
     *
     * @return shinsakaiKaisaiBashoCode
     */
    public KaisaiBashoCode getShinsakaiKaisaiBashoCode() {
        return shinsakaiKaisaiBashoCode;
    }

    /**
     * setShinsakaiKaisaiBashoCode
     *
     * @param shinsakaiKaisaiBashoCode shinsakaiKaisaiBashoCode
     */
    public void setShinsakaiKaisaiBashoCode(KaisaiBashoCode shinsakaiKaisaiBashoCode) {
        this.shinsakaiKaisaiBashoCode = shinsakaiKaisaiBashoCode;
    }

    /**
     * getShinsakaiKaisaiBashoMei
     *
     * @return shinsakaiKaisaiBashoMei
     */
    public RString getShinsakaiKaisaiBashoMei() {
        return shinsakaiKaisaiBashoMei;
    }

    /**
     * setShinsakaiKaisaiBashoMei
     *
     * @param shinsakaiKaisaiBashoMei shinsakaiKaisaiBashoMei
     */
    public void setShinsakaiKaisaiBashoMei(RString shinsakaiKaisaiBashoMei) {
        this.shinsakaiKaisaiBashoMei = shinsakaiKaisaiBashoMei;
    }

    /**
     * getShinsakaiKaisaiChikuCode
     *
     * @return shinsakaiKaisaiChikuCode
     */
    public KaisaiBashoChikuCode getShinsakaiKaisaiChikuCode() {
        return shinsakaiKaisaiChikuCode;
    }

    /**
     * setShinsakaiKaisaiChikuCode
     *
     * @param shinsakaiKaisaiChikuCode shinsakaiKaisaiChikuCode
     */
    public void setShinsakaiKaisaiChikuCode(KaisaiBashoChikuCode shinsakaiKaisaiChikuCode) {
        this.shinsakaiKaisaiChikuCode = shinsakaiKaisaiChikuCode;
    }

    public RString getShinsakaiKaisaiChikuCodeMeisho() {
        return CodeMaster.getCodeMeisho(new RString("DB"), new RString("100"), shinsakaiKaisaiChikuCode.getColumnValue());
    }

    public RString getShinsakaiKaisaiChikuCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(new RString("DB"), new RString("100"), shinsakaiKaisaiChikuCode.getColumnValue());
    }

    /**
     * getShinsakaiKaisaiBashoJusho
     *
     * @return shinsakaiKaisaiBashoJusho
     */
    public RString getShinsakaiKaisaiBashoJusho() {
        return shinsakaiKaisaiBashoJusho;
    }

    /**
     * setShinsakaiKaisaiBashoJusho
     *
     * @param shinsakaiKaisaiBashoJusho shinsakaiKaisaiBashoJusho
     */
    public void setShinsakaiKaisaiBashoJusho(RString shinsakaiKaisaiBashoJusho) {
        this.shinsakaiKaisaiBashoJusho = shinsakaiKaisaiBashoJusho;
    }

    /**
     * getShinsakaiKaisaiBashoTelNo
     *
     * @return shinsakaiKaisaiBashoTelNo
     */
    public RString getShinsakaiKaisaiBashoTelNo() {
        return shinsakaiKaisaiBashoTelNo;
    }

    /**
     * setShinsakaiKaisaiBashoTelNo
     *
     * @param shinsakaiKaisaiBashoTelNo shinsakaiKaisaiBashoTelNo
     */
    public void setShinsakaiKaisaiBashoTelNo(RString shinsakaiKaisaiBashoTelNo) {
        this.shinsakaiKaisaiBashoTelNo = shinsakaiKaisaiBashoTelNo;
    }

    /**
     * getShinsakaiKaisaiBashoJokyo
     *
     * @return shinsakaiKaisaiBashoJokyo
     */
    public boolean getShinsakaiKaisaiBashoJokyo() {
        return shinsakaiKaisaiBashoJokyo;
    }

    /**
     * setShinsakaiKaisaiBashoJokyo
     *
     * @param shinsakaiKaisaiBashoJokyo shinsakaiKaisaiBashoJokyo
     */
    public void setShinsakaiKaisaiBashoJokyo(boolean shinsakaiKaisaiBashoJokyo) {
        this.shinsakaiKaisaiBashoJokyo = shinsakaiKaisaiBashoJokyo;
    }
// </editor-fold>
}
