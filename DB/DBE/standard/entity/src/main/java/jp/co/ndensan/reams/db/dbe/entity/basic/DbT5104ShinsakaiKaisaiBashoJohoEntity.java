package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.definition.DbeShubetsuKey;

/**
 * DbT5104ShinsakaiKaisaiBashoJohoの項目定義クラスです
 *
 * @author n8178 城間篤人
 */
public class DbT5104ShinsakaiKaisaiBashoJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5104ShinsakaiKaisaiBashoJoho");
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString shinsakaiKaisaiBashoCode;
    private RString shinsakaiKaisaiBashoMei;
    private Code shinsakaiKaisaiChikuCode;
    private AtenaJusho shinsakaiKaisaiBashoJusho;
    private TelNo shinsakaiKaisaiBashoTelNo;
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
    public RString getShinsakaiKaisaiBashoCode() {
        return shinsakaiKaisaiBashoCode;
    }

    /**
     * setShinsakaiKaisaiBashoCode
     *
     * @param shinsakaiKaisaiBashoCode shinsakaiKaisaiBashoCode
     */
    public void setShinsakaiKaisaiBashoCode(RString shinsakaiKaisaiBashoCode) {
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
    public Code getShinsakaiKaisaiChikuCode() {
        return shinsakaiKaisaiChikuCode;
    }

    /**
     * setShinsakaiKaisaiChikuCode
     *
     * @param shinsakaiKaisaiChikuCode shinsakaiKaisaiChikuCode
     */
    public void setShinsakaiKaisaiChikuCode(Code shinsakaiKaisaiChikuCode) {
        this.shinsakaiKaisaiChikuCode = shinsakaiKaisaiChikuCode;
    }

    /**
     * getShinsakaiKaisaiChikuCodeMeisho
     *
     * @return Meisho
     */
    public RString getShinsakaiKaisaiChikuCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.審査会地区, shinsakaiKaisaiChikuCode);
    }

    /**
     * getShinsakaiKaisaiChikuCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getShinsakaiKaisaiChikuCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.審査会地区, shinsakaiKaisaiChikuCode);
    }

    /**
     * getShinsakaiKaisaiBashoJusho
     *
     * @return shinsakaiKaisaiBashoJusho
     */
    public AtenaJusho getShinsakaiKaisaiBashoJusho() {
        return shinsakaiKaisaiBashoJusho;
    }

    /**
     * setShinsakaiKaisaiBashoJusho
     *
     * @param shinsakaiKaisaiBashoJusho shinsakaiKaisaiBashoJusho
     */
    public void setShinsakaiKaisaiBashoJusho(AtenaJusho shinsakaiKaisaiBashoJusho) {
        this.shinsakaiKaisaiBashoJusho = shinsakaiKaisaiBashoJusho;
    }

    /**
     * getShinsakaiKaisaiBashoTelNo
     *
     * @return shinsakaiKaisaiBashoTelNo
     */
    public TelNo getShinsakaiKaisaiBashoTelNo() {
        return shinsakaiKaisaiBashoTelNo;
    }

    /**
     * setShinsakaiKaisaiBashoTelNo
     *
     * @param shinsakaiKaisaiBashoTelNo shinsakaiKaisaiBashoTelNo
     */
    public void setShinsakaiKaisaiBashoTelNo(TelNo shinsakaiKaisaiBashoTelNo) {
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

    /**
     * このエンティティの主キーが他の{@literal DbT5104ShinsakaiKaisaiBashoJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5104ShinsakaiKaisaiBashoJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT5104ShinsakaiKaisaiBashoJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinsakaiKaisaiBashoCode, other.shinsakaiKaisaiBashoCode)) {
            return false;
        }
        return true;
    }
// </editor-fold>
}
