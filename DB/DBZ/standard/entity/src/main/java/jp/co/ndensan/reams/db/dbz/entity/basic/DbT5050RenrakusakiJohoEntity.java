package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.RenrakusakiKubunNo;
import java.util.Objects;

/**
 * DbT5050RenrakusakiJohoの項目定義クラスです
 *
 */
public class DbT5050RenrakusakiJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5050RenrakusakiJoho");

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
    private RString renrakusakiKubunNo;
    private RString shishoCode;
    private YubinNo renrakusakiYubinNo;
    private TelNo renrakusakiTelNo;
    private AtenaJusho renrakusakiJusho;
    private AtenaMeisho renrakusakiShimei;
    private AtenaKanaMeisho renrakusakiKanaSimei;
    private RString renrakusakiTuzukigara;
    private TelNo renrakusakiKeitaiTelNo;

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
     * getRenrakusakiKubunNo
     *
     * @return renrakusakiKubunNo
     */
    public RString getRenrakusakiKubunNo() {
        return renrakusakiKubunNo;
    }

    /**
     * setRenrakusakiKubunNo
     *
     * @param renrakusakiKubunNo renrakusakiKubunNo
     */
    public void setRenrakusakiKubunNo(RString renrakusakiKubunNo) {
        this.renrakusakiKubunNo = renrakusakiKubunNo;
    }

    /**
     * getShishoCode
     *
     * @return shishoCode
     */
    public RString getShishoCode() {
        return shishoCode;
    }

    /**
     * setShishoCode
     *
     * @param shishoCode shishoCode
     */
    public void setShishoCode(RString shishoCode) {
        this.shishoCode = shishoCode;
    }

    /**
     * getRenrakusakiYubinNo
     *
     * @return renrakusakiYubinNo
     */
    public YubinNo getRenrakusakiYubinNo() {
        return renrakusakiYubinNo;
    }

    /**
     * setRenrakusakiYubinNo
     *
     * @param renrakusakiYubinNo renrakusakiYubinNo
     */
    public void setRenrakusakiYubinNo(YubinNo renrakusakiYubinNo) {
        this.renrakusakiYubinNo = renrakusakiYubinNo;
    }

    /**
     * getRenrakusakiTelNo
     *
     * @return renrakusakiTelNo
     */
    public TelNo getRenrakusakiTelNo() {
        return renrakusakiTelNo;
    }

    /**
     * setRenrakusakiTelNo
     *
     * @param renrakusakiTelNo renrakusakiTelNo
     */
    public void setRenrakusakiTelNo(TelNo renrakusakiTelNo) {
        this.renrakusakiTelNo = renrakusakiTelNo;
    }

    /**
     * getRenrakusakiJusho
     *
     * @return renrakusakiJusho
     */
    public AtenaJusho getRenrakusakiJusho() {
        return renrakusakiJusho;
    }

    /**
     * setRenrakusakiJusho
     *
     * @param renrakusakiJusho renrakusakiJusho
     */
    public void setRenrakusakiJusho(AtenaJusho renrakusakiJusho) {
        this.renrakusakiJusho = renrakusakiJusho;
    }

    /**
     * getRenrakusakiShimei
     *
     * @return renrakusakiShimei
     */
    public AtenaMeisho getRenrakusakiShimei() {
        return renrakusakiShimei;
    }

    /**
     * setRenrakusakiShimei
     *
     * @param renrakusakiShimei renrakusakiShimei
     */
    public void setRenrakusakiShimei(AtenaMeisho renrakusakiShimei) {
        this.renrakusakiShimei = renrakusakiShimei;
    }

    /**
     * getRenrakusakiKanaSimei
     *
     * @return renrakusakiKanaSimei
     */
    public AtenaKanaMeisho getRenrakusakiKanaSimei() {
        return renrakusakiKanaSimei;
    }

    /**
     * setRenrakusakiKanaSimei
     *
     * @param renrakusakiKanaSimei renrakusakiKanaSimei
     */
    public void setRenrakusakiKanaSimei(AtenaKanaMeisho renrakusakiKanaSimei) {
        this.renrakusakiKanaSimei = renrakusakiKanaSimei;
    }

    /**
     * getRenrakusakiTuzukigara
     *
     * @return renrakusakiTuzukigara
     */
    public RString getRenrakusakiTuzukigara() {
        return renrakusakiTuzukigara;
    }

    /**
     * setRenrakusakiTuzukigara
     *
     * @param renrakusakiTuzukigara renrakusakiTuzukigara
     */
    public void setRenrakusakiTuzukigara(RString renrakusakiTuzukigara) {
        this.renrakusakiTuzukigara = renrakusakiTuzukigara;
    }

    /**
     * getRenrakusakiKeitaiTelNo
     *
     * @return renrakusakiKeitaiTelNo
     */
    public TelNo getRenrakusakiKeitaiTelNo() {
        return renrakusakiKeitaiTelNo;
    }

    /**
     * setRenrakusakiKeitaiTelNo
     *
     * @param renrakusakiKeitaiTelNo renrakusakiKeitaiTelNo
     */
    public void setRenrakusakiKeitaiTelNo(TelNo renrakusakiKeitaiTelNo) {
        this.renrakusakiKeitaiTelNo = renrakusakiKeitaiTelNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5050RenrakusakiJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5050RenrakusakiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT5050RenrakusakiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.renrakusakiKubunNo, other.renrakusakiKubunNo)) {
            return false;
        }
        return true;
    }

// </editor-fold>
}
