package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import java.util.Objects;

/**
 * DbT7023RendoHoryuTokuteiJushoの項目定義クラスです
 *
 */
public class DbT7023RendoHoryuTokuteiJushoEntity extends DbTableEntityBase<DbT7023RendoHoryuTokuteiJushoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7023RendoHoryuTokuteiJusho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString kanriNo;
    @PrimaryKey
    private LasdecCode shichosonCode;
    private ChoikiCode jushoCode;
    private AtenaJusho jusho;
    private BanchiCode banchiCode1;
    private BanchiCode banchiCode2;
    private BanchiCode banchiCode3;
    private AtenaBanchi banchi;
    private RString shisetsuShurui;
    private RString shisetsuCode;

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
     * getKanriNo
     * @return kanriNo
     */
    public RString getKanriNo() {
        return kanriNo;
    }

    /**
     * setKanriNo
     * @param kanriNo kanriNo
     */
    public void setKanriNo(RString kanriNo) {
        this.kanriNo = kanriNo;
    }

    /**
     * getShichosonCode
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * getJushoCode
     * @return jushoCode
     */
    public ChoikiCode getJushoCode() {
        return jushoCode;
    }

    /**
     * setJushoCode
     * @param jushoCode jushoCode
     */
    public void setJushoCode(ChoikiCode jushoCode) {
        this.jushoCode = jushoCode;
    }

    /**
     * getJusho
     * @return jusho
     */
    public AtenaJusho getJusho() {
        return jusho;
    }

    /**
     * setJusho
     * @param jusho jusho
     */
    public void setJusho(AtenaJusho jusho) {
        this.jusho = jusho;
    }

    /**
     * getBanchiCode1
     * @return banchiCode1
     */
    public BanchiCode getBanchiCode1() {
        return banchiCode1;
    }

    /**
     * setBanchiCode1
     * @param banchiCode1 banchiCode1
     */
    public void setBanchiCode1(BanchiCode banchiCode1) {
        this.banchiCode1 = banchiCode1;
    }

    /**
     * getBanchiCode2
     * @return banchiCode2
     */
    public BanchiCode getBanchiCode2() {
        return banchiCode2;
    }

    /**
     * setBanchiCode2
     * @param banchiCode2 banchiCode2
     */
    public void setBanchiCode2(BanchiCode banchiCode2) {
        this.banchiCode2 = banchiCode2;
    }

    /**
     * getBanchiCode3
     * @return banchiCode3
     */
    public BanchiCode getBanchiCode3() {
        return banchiCode3;
    }

    /**
     * setBanchiCode3
     * @param banchiCode3 banchiCode3
     */
    public void setBanchiCode3(BanchiCode banchiCode3) {
        this.banchiCode3 = banchiCode3;
    }

    /**
     * getBanchi
     * @return banchi
     */
    public AtenaBanchi getBanchi() {
        return banchi;
    }

    /**
     * setBanchi
     * @param banchi banchi
     */
    public void setBanchi(AtenaBanchi banchi) {
        this.banchi = banchi;
    }

    /**
     * getShisetsuShurui
     * @return shisetsuShurui
     */
    public RString getShisetsuShurui() {
        return shisetsuShurui;
    }

    /**
     * setShisetsuShurui
     * @param shisetsuShurui shisetsuShurui
     */
    public void setShisetsuShurui(RString shisetsuShurui) {
        this.shisetsuShurui = shisetsuShurui;
    }

    /**
     * getShisetsuCode
     * @return shisetsuCode
     */
    public RString getShisetsuCode() {
        return shisetsuCode;
    }

    /**
     * setShisetsuCode
     * @param shisetsuCode shisetsuCode
     */
    public void setShisetsuCode(RString shisetsuCode) {
        this.shisetsuCode = shisetsuCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7023RendoHoryuTokuteiJushoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7023RendoHoryuTokuteiJushoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7023RendoHoryuTokuteiJushoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.kanriNo, other.kanriNo)) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7023RendoHoryuTokuteiJushoEntity entity) {
        this.kanriNo = entity.kanriNo;
        this.shichosonCode = entity.shichosonCode;
        this.jushoCode = entity.jushoCode;
        this.jusho = entity.jusho;
        this.banchiCode1 = entity.banchiCode1;
        this.banchiCode2 = entity.banchiCode2;
        this.banchiCode3 = entity.banchiCode3;
        this.banchi = entity.banchi;
        this.shisetsuShurui = entity.shisetsuShurui;
        this.shisetsuCode = entity.shisetsuCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kanriNo, shichosonCode, jushoCode, jusho, banchiCode1, banchiCode2, banchiCode3, banchi, shisetsuShurui, shisetsuCode);
    }

// </editor-fold>


}
