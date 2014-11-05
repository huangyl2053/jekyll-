package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import java.util.Objects;

/**
 * DbT5014ShinsakaiIinJogaiJohoの項目定義クラスです
 *
 */
public class DbT5014ShinsakaiIinJogaiJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5014ShinsakaiIinJogaiJoho");

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
    private KaigoHihokenshaNo hihokenshaNo;
    @PrimaryKey
    private int kanriNo;
    private RString jogaiTaishoShinsakaiIinCode;

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
     * getKanriNo
     *
     * @return kanriNo
     */
    public int getKanriNo() {
        return kanriNo;
    }

    /**
     * setKanriNo
     *
     * @param kanriNo kanriNo
     */
    public void setKanriNo(int kanriNo) {
        this.kanriNo = kanriNo;
    }

    /**
     * getJogaiTaishoShinsakaiIinCode
     *
     * @return jogaiTaishoShinsakaiIinCode
     */
    public RString getJogaiTaishoShinsakaiIinCode() {
        return jogaiTaishoShinsakaiIinCode;
    }

    /**
     * setJogaiTaishoShinsakaiIinCode
     *
     * @param jogaiTaishoShinsakaiIinCode jogaiTaishoShinsakaiIinCode
     */
    public void setJogaiTaishoShinsakaiIinCode(RString jogaiTaishoShinsakaiIinCode) {
        this.jogaiTaishoShinsakaiIinCode = jogaiTaishoShinsakaiIinCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5014ShinsakaiIinJogaiJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5014ShinsakaiIinJogaiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT5014ShinsakaiIinJogaiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (this.kanriNo != other.kanriNo) {
            return false;
        }
        return true;
    }

// </editor-fold>
}
