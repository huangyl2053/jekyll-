package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT2001ChoshuHohoの項目定義クラスです
 *
 */
public class DbT2001ChoshuHohoEntity extends DbTableEntityBase<DbT2001ChoshuHohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT2001ChoshuHoho");

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
    private FlexibleYear fukaNendo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RDateTime shoriTimestamp;
    private RString choshuHoho4gatsu;
    private RString choshuHoho5gatsu;
    private RString choshuHoho6gatsu;
    private RString choshuHoho7gatsu;
    private RString choshuHoho8gatsu;
    private RString choshuHoho9gatsu;
    private RString choshuHoho10gatsu;
    private RString choshuHoho11gatsu;
    private RString choshuHoho12gatsu;
    private RString choshuHoho1gatsu;
    private RString choshuHoho2gatsu;
    private RString choshuHoho3gatsu;
    private RString choshuHohoYoku4gatsu;
    private RString choshuHohoYoku5gatsu;
    private RString choshuHohoYoku6gatsu;
    private RString choshuHohoYoku7gatsu;
    private RString choshuHohoYoku8gatsu;
    private RString choshuHohoYoku9gatsu;
    private RString kariNenkinNo;
    private RString kariNenkinCode;
    private RString kariHosokuM;
    private RString honNenkinNo;
    private RString honNenkinCode;
    private RString honHosokuM;
    private RString yokunendoKariNenkinNo;
    private RString yokunendoKariNenkinCode;
    private RString yokunendoKariHosokuM;
    private boolean iraiSohuzumiFlag;
    private boolean tsuikaIraiSohuzumiFlag;
    private YMDHMS tokuchoTeishiTimestamp;
    private RString tokuchoTeishiJiyuCode;

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
     * getFukaNendo
     *
     * @return fukaNendo
     */
    public FlexibleYear getFukaNendo() {
        return fukaNendo;
    }

    /**
     * setFukaNendo
     *
     * @param fukaNendo fukaNendo
     */
    public void setFukaNendo(FlexibleYear fukaNendo) {
        this.fukaNendo = fukaNendo;
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
     * getChoshuHoho4gatsu
     *
     * @return choshuHoho4gatsu
     */
    public RString getChoshuHoho4gatsu() {
        return choshuHoho4gatsu;
    }

    /**
     * setChoshuHoho4gatsu
     *
     * @param choshuHoho4gatsu choshuHoho4gatsu
     */
    public void setChoshuHoho4gatsu(RString choshuHoho4gatsu) {
        this.choshuHoho4gatsu = choshuHoho4gatsu;
    }

    /**
     * getChoshuHoho5gatsu
     *
     * @return choshuHoho5gatsu
     */
    public RString getChoshuHoho5gatsu() {
        return choshuHoho5gatsu;
    }

    /**
     * setChoshuHoho5gatsu
     *
     * @param choshuHoho5gatsu choshuHoho5gatsu
     */
    public void setChoshuHoho5gatsu(RString choshuHoho5gatsu) {
        this.choshuHoho5gatsu = choshuHoho5gatsu;
    }

    /**
     * getChoshuHoho6gatsu
     *
     * @return choshuHoho6gatsu
     */
    public RString getChoshuHoho6gatsu() {
        return choshuHoho6gatsu;
    }

    /**
     * setChoshuHoho6gatsu
     *
     * @param choshuHoho6gatsu choshuHoho6gatsu
     */
    public void setChoshuHoho6gatsu(RString choshuHoho6gatsu) {
        this.choshuHoho6gatsu = choshuHoho6gatsu;
    }

    /**
     * getChoshuHoho7gatsu
     *
     * @return choshuHoho7gatsu
     */
    public RString getChoshuHoho7gatsu() {
        return choshuHoho7gatsu;
    }

    /**
     * setChoshuHoho7gatsu
     *
     * @param choshuHoho7gatsu choshuHoho7gatsu
     */
    public void setChoshuHoho7gatsu(RString choshuHoho7gatsu) {
        this.choshuHoho7gatsu = choshuHoho7gatsu;
    }

    /**
     * getChoshuHoho8gatsu
     *
     * @return choshuHoho8gatsu
     */
    public RString getChoshuHoho8gatsu() {
        return choshuHoho8gatsu;
    }

    /**
     * setChoshuHoho8gatsu
     *
     * @param choshuHoho8gatsu choshuHoho8gatsu
     */
    public void setChoshuHoho8gatsu(RString choshuHoho8gatsu) {
        this.choshuHoho8gatsu = choshuHoho8gatsu;
    }

    /**
     * getChoshuHoho9gatsu
     *
     * @return choshuHoho9gatsu
     */
    public RString getChoshuHoho9gatsu() {
        return choshuHoho9gatsu;
    }

    /**
     * setChoshuHoho9gatsu
     *
     * @param choshuHoho9gatsu choshuHoho9gatsu
     */
    public void setChoshuHoho9gatsu(RString choshuHoho9gatsu) {
        this.choshuHoho9gatsu = choshuHoho9gatsu;
    }

    /**
     * getChoshuHoho10gatsu
     *
     * @return choshuHoho10gatsu
     */
    public RString getChoshuHoho10gatsu() {
        return choshuHoho10gatsu;
    }

    /**
     * setChoshuHoho10gatsu
     *
     * @param choshuHoho10gatsu choshuHoho10gatsu
     */
    public void setChoshuHoho10gatsu(RString choshuHoho10gatsu) {
        this.choshuHoho10gatsu = choshuHoho10gatsu;
    }

    /**
     * getChoshuHoho11gatsu
     *
     * @return choshuHoho11gatsu
     */
    public RString getChoshuHoho11gatsu() {
        return choshuHoho11gatsu;
    }

    /**
     * setChoshuHoho11gatsu
     *
     * @param choshuHoho11gatsu choshuHoho11gatsu
     */
    public void setChoshuHoho11gatsu(RString choshuHoho11gatsu) {
        this.choshuHoho11gatsu = choshuHoho11gatsu;
    }

    /**
     * getChoshuHoho12gatsu
     *
     * @return choshuHoho12gatsu
     */
    public RString getChoshuHoho12gatsu() {
        return choshuHoho12gatsu;
    }

    /**
     * setChoshuHoho12gatsu
     *
     * @param choshuHoho12gatsu choshuHoho12gatsu
     */
    public void setChoshuHoho12gatsu(RString choshuHoho12gatsu) {
        this.choshuHoho12gatsu = choshuHoho12gatsu;
    }

    /**
     * getChoshuHoho1gatsu
     *
     * @return choshuHoho1gatsu
     */
    public RString getChoshuHoho1gatsu() {
        return choshuHoho1gatsu;
    }

    /**
     * setChoshuHoho1gatsu
     *
     * @param choshuHoho1gatsu choshuHoho1gatsu
     */
    public void setChoshuHoho1gatsu(RString choshuHoho1gatsu) {
        this.choshuHoho1gatsu = choshuHoho1gatsu;
    }

    /**
     * getChoshuHoho2gatsu
     *
     * @return choshuHoho2gatsu
     */
    public RString getChoshuHoho2gatsu() {
        return choshuHoho2gatsu;
    }

    /**
     * setChoshuHoho2gatsu
     *
     * @param choshuHoho2gatsu choshuHoho2gatsu
     */
    public void setChoshuHoho2gatsu(RString choshuHoho2gatsu) {
        this.choshuHoho2gatsu = choshuHoho2gatsu;
    }

    /**
     * getChoshuHoho3gatsu
     *
     * @return choshuHoho3gatsu
     */
    public RString getChoshuHoho3gatsu() {
        return choshuHoho3gatsu;
    }

    /**
     * setChoshuHoho3gatsu
     *
     * @param choshuHoho3gatsu choshuHoho3gatsu
     */
    public void setChoshuHoho3gatsu(RString choshuHoho3gatsu) {
        this.choshuHoho3gatsu = choshuHoho3gatsu;
    }

    /**
     * getChoshuHohoYoku4gatsu
     *
     * @return choshuHohoYoku4gatsu
     */
    public RString getChoshuHohoYoku4gatsu() {
        return choshuHohoYoku4gatsu;
    }

    /**
     * setChoshuHohoYoku4gatsu
     *
     * @param choshuHohoYoku4gatsu choshuHohoYoku4gatsu
     */
    public void setChoshuHohoYoku4gatsu(RString choshuHohoYoku4gatsu) {
        this.choshuHohoYoku4gatsu = choshuHohoYoku4gatsu;
    }

    /**
     * getChoshuHohoYoku5gatsu
     *
     * @return choshuHohoYoku5gatsu
     */
    public RString getChoshuHohoYoku5gatsu() {
        return choshuHohoYoku5gatsu;
    }

    /**
     * setChoshuHohoYoku5gatsu
     *
     * @param choshuHohoYoku5gatsu choshuHohoYoku5gatsu
     */
    public void setChoshuHohoYoku5gatsu(RString choshuHohoYoku5gatsu) {
        this.choshuHohoYoku5gatsu = choshuHohoYoku5gatsu;
    }

    /**
     * getChoshuHohoYoku6gatsu
     *
     * @return choshuHohoYoku6gatsu
     */
    public RString getChoshuHohoYoku6gatsu() {
        return choshuHohoYoku6gatsu;
    }

    /**
     * setChoshuHohoYoku6gatsu
     *
     * @param choshuHohoYoku6gatsu choshuHohoYoku6gatsu
     */
    public void setChoshuHohoYoku6gatsu(RString choshuHohoYoku6gatsu) {
        this.choshuHohoYoku6gatsu = choshuHohoYoku6gatsu;
    }

    /**
     * getChoshuHohoYoku7gatsu
     *
     * @return choshuHohoYoku7gatsu
     */
    public RString getChoshuHohoYoku7gatsu() {
        return choshuHohoYoku7gatsu;
    }

    /**
     * setChoshuHohoYoku7gatsu
     *
     * @param choshuHohoYoku7gatsu choshuHohoYoku7gatsu
     */
    public void setChoshuHohoYoku7gatsu(RString choshuHohoYoku7gatsu) {
        this.choshuHohoYoku7gatsu = choshuHohoYoku7gatsu;
    }

    /**
     * getChoshuHohoYoku8gatsu
     *
     * @return choshuHohoYoku8gatsu
     */
    public RString getChoshuHohoYoku8gatsu() {
        return choshuHohoYoku8gatsu;
    }

    /**
     * setChoshuHohoYoku8gatsu
     *
     * @param choshuHohoYoku8gatsu choshuHohoYoku8gatsu
     */
    public void setChoshuHohoYoku8gatsu(RString choshuHohoYoku8gatsu) {
        this.choshuHohoYoku8gatsu = choshuHohoYoku8gatsu;
    }

    /**
     * getChoshuHohoYoku9gatsu
     *
     * @return choshuHohoYoku9gatsu
     */
    public RString getChoshuHohoYoku9gatsu() {
        return choshuHohoYoku9gatsu;
    }

    /**
     * setChoshuHohoYoku9gatsu
     *
     * @param choshuHohoYoku9gatsu choshuHohoYoku9gatsu
     */
    public void setChoshuHohoYoku9gatsu(RString choshuHohoYoku9gatsu) {
        this.choshuHohoYoku9gatsu = choshuHohoYoku9gatsu;
    }

    /**
     * getKariNenkinNo
     *
     * @return kariNenkinNo
     */
    public RString getKariNenkinNo() {
        return kariNenkinNo;
    }

    /**
     * setKariNenkinNo
     *
     * @param kariNenkinNo kariNenkinNo
     */
    public void setKariNenkinNo(RString kariNenkinNo) {
        this.kariNenkinNo = kariNenkinNo;
    }

    /**
     * getKariNenkinCode
     *
     * @return kariNenkinCode
     */
    public RString getKariNenkinCode() {
        return kariNenkinCode;
    }

    /**
     * setKariNenkinCode
     *
     * @param kariNenkinCode kariNenkinCode
     */
    public void setKariNenkinCode(RString kariNenkinCode) {
        this.kariNenkinCode = kariNenkinCode;
    }

    /**
     * getKariHosokuM
     *
     * @return kariHosokuM
     */
    public RString getKariHosokuM() {
        return kariHosokuM;
    }

    /**
     * setKariHosokuM
     *
     * @param kariHosokuM kariHosokuM
     */
    public void setKariHosokuM(RString kariHosokuM) {
        this.kariHosokuM = kariHosokuM;
    }

    /**
     * getHonNenkinNo
     *
     * @return honNenkinNo
     */
    public RString getHonNenkinNo() {
        return honNenkinNo;
    }

    /**
     * setHonNenkinNo
     *
     * @param honNenkinNo honNenkinNo
     */
    public void setHonNenkinNo(RString honNenkinNo) {
        this.honNenkinNo = honNenkinNo;
    }

    /**
     * getHonNenkinCode
     *
     * @return honNenkinCode
     */
    public RString getHonNenkinCode() {
        return honNenkinCode;
    }

    /**
     * setHonNenkinCode
     *
     * @param honNenkinCode honNenkinCode
     */
    public void setHonNenkinCode(RString honNenkinCode) {
        this.honNenkinCode = honNenkinCode;
    }

    /**
     * getHonHosokuM
     *
     * @return honHosokuM
     */
    public RString getHonHosokuM() {
        return honHosokuM;
    }

    /**
     * setHonHosokuM
     *
     * @param honHosokuM honHosokuM
     */
    public void setHonHosokuM(RString honHosokuM) {
        this.honHosokuM = honHosokuM;
    }

    /**
     * getYokunendoKariNenkinNo
     *
     * @return yokunendoKariNenkinNo
     */
    public RString getYokunendoKariNenkinNo() {
        return yokunendoKariNenkinNo;
    }

    /**
     * setYokunendoKariNenkinNo
     *
     * @param yokunendoKariNenkinNo yokunendoKariNenkinNo
     */
    public void setYokunendoKariNenkinNo(RString yokunendoKariNenkinNo) {
        this.yokunendoKariNenkinNo = yokunendoKariNenkinNo;
    }

    /**
     * getYokunendoKariNenkinCode
     *
     * @return yokunendoKariNenkinCode
     */
    public RString getYokunendoKariNenkinCode() {
        return yokunendoKariNenkinCode;
    }

    /**
     * setYokunendoKariNenkinCode
     *
     * @param yokunendoKariNenkinCode yokunendoKariNenkinCode
     */
    public void setYokunendoKariNenkinCode(RString yokunendoKariNenkinCode) {
        this.yokunendoKariNenkinCode = yokunendoKariNenkinCode;
    }

    /**
     * getYokunendoKariHosokuM
     *
     * @return yokunendoKariHosokuM
     */
    public RString getYokunendoKariHosokuM() {
        return yokunendoKariHosokuM;
    }

    /**
     * setYokunendoKariHosokuM
     *
     * @param yokunendoKariHosokuM yokunendoKariHosokuM
     */
    public void setYokunendoKariHosokuM(RString yokunendoKariHosokuM) {
        this.yokunendoKariHosokuM = yokunendoKariHosokuM;
    }

    /**
     * getIraiSohuzumiFlag
     *
     * @return iraiSohuzumiFlag
     */
    public boolean getIraiSohuzumiFlag() {
        return iraiSohuzumiFlag;
    }

    /**
     * setIraiSohuzumiFlag
     *
     * @param iraiSohuzumiFlag iraiSohuzumiFlag
     */
    public void setIraiSohuzumiFlag(boolean iraiSohuzumiFlag) {
        this.iraiSohuzumiFlag = iraiSohuzumiFlag;
    }

    /**
     * getTsuikaIraiSohuzumiFlag
     *
     * @return tsuikaIraiSohuzumiFlag
     */
    public boolean getTsuikaIraiSohuzumiFlag() {
        return tsuikaIraiSohuzumiFlag;
    }

    /**
     * setTsuikaIraiSohuzumiFlag
     *
     * @param tsuikaIraiSohuzumiFlag tsuikaIraiSohuzumiFlag
     */
    public void setTsuikaIraiSohuzumiFlag(boolean tsuikaIraiSohuzumiFlag) {
        this.tsuikaIraiSohuzumiFlag = tsuikaIraiSohuzumiFlag;
    }

    /**
     * getTokuchoTeishiTimestamp
     *
     * @return tokuchoTeishiTimestamp
     */
    public YMDHMS getTokuchoTeishiTimestamp() {
        return tokuchoTeishiTimestamp;
    }

    /**
     * setTokuchoTeishiTimestamp
     *
     * @param tokuchoTeishiTimestamp tokuchoTeishiTimestamp
     */
    public void setTokuchoTeishiTimestamp(YMDHMS tokuchoTeishiTimestamp) {
        this.tokuchoTeishiTimestamp = tokuchoTeishiTimestamp;
    }

    /**
     * getTokuchoTeishiJiyuCode
     *
     * @return tokuchoTeishiJiyuCode
     */
    public RString getTokuchoTeishiJiyuCode() {
        return tokuchoTeishiJiyuCode;
    }

    /**
     * setTokuchoTeishiJiyuCode
     *
     * @param tokuchoTeishiJiyuCode tokuchoTeishiJiyuCode
     */
    public void setTokuchoTeishiJiyuCode(RString tokuchoTeishiJiyuCode) {
        this.tokuchoTeishiJiyuCode = tokuchoTeishiJiyuCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2001ChoshuHohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT2001ChoshuHohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2001ChoshuHohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.insertTimestamp, other.insertTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.fukaNendo, other.fukaNendo)) {
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
    public void shallowCopy(DbT2001ChoshuHohoEntity entity) {
        this.fukaNendo = entity.fukaNendo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.choshuHoho4gatsu = entity.choshuHoho4gatsu;
        this.choshuHoho5gatsu = entity.choshuHoho5gatsu;
        this.choshuHoho6gatsu = entity.choshuHoho6gatsu;
        this.choshuHoho7gatsu = entity.choshuHoho7gatsu;
        this.choshuHoho8gatsu = entity.choshuHoho8gatsu;
        this.choshuHoho9gatsu = entity.choshuHoho9gatsu;
        this.choshuHoho10gatsu = entity.choshuHoho10gatsu;
        this.choshuHoho11gatsu = entity.choshuHoho11gatsu;
        this.choshuHoho12gatsu = entity.choshuHoho12gatsu;
        this.choshuHoho1gatsu = entity.choshuHoho1gatsu;
        this.choshuHoho2gatsu = entity.choshuHoho2gatsu;
        this.choshuHoho3gatsu = entity.choshuHoho3gatsu;
        this.choshuHohoYoku4gatsu = entity.choshuHohoYoku4gatsu;
        this.choshuHohoYoku5gatsu = entity.choshuHohoYoku5gatsu;
        this.choshuHohoYoku6gatsu = entity.choshuHohoYoku6gatsu;
        this.choshuHohoYoku7gatsu = entity.choshuHohoYoku7gatsu;
        this.choshuHohoYoku8gatsu = entity.choshuHohoYoku8gatsu;
        this.choshuHohoYoku9gatsu = entity.choshuHohoYoku9gatsu;
        this.kariNenkinNo = entity.kariNenkinNo;
        this.kariNenkinCode = entity.kariNenkinCode;
        this.kariHosokuM = entity.kariHosokuM;
        this.honNenkinNo = entity.honNenkinNo;
        this.honNenkinCode = entity.honNenkinCode;
        this.honHosokuM = entity.honHosokuM;
        this.yokunendoKariNenkinNo = entity.yokunendoKariNenkinNo;
        this.yokunendoKariNenkinCode = entity.yokunendoKariNenkinCode;
        this.yokunendoKariHosokuM = entity.yokunendoKariHosokuM;
        this.iraiSohuzumiFlag = entity.iraiSohuzumiFlag;
        this.tsuikaIraiSohuzumiFlag = entity.tsuikaIraiSohuzumiFlag;
        this.tokuchoTeishiTimestamp = entity.tokuchoTeishiTimestamp;
        this.tokuchoTeishiJiyuCode = entity.tokuchoTeishiJiyuCode;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(fukaNendo, hihokenshaNo, shoriTimestamp, choshuHoho4gatsu, choshuHoho5gatsu, choshuHoho6gatsu, choshuHoho7gatsu, choshuHoho8gatsu, choshuHoho9gatsu, choshuHoho10gatsu, choshuHoho11gatsu, choshuHoho12gatsu, choshuHoho1gatsu, choshuHoho2gatsu, choshuHoho3gatsu, choshuHohoYoku4gatsu, choshuHohoYoku5gatsu, choshuHohoYoku6gatsu, choshuHohoYoku7gatsu, choshuHohoYoku8gatsu, choshuHohoYoku9gatsu, kariNenkinNo, kariNenkinCode, kariHosokuM, honNenkinNo, honNenkinCode, honHosokuM, yokunendoKariNenkinNo, yokunendoKariNenkinCode, yokunendoKariHosokuM, iraiSohuzumiFlag, tsuikaIraiSohuzumiFlag, tokuchoTeishiTimestamp, tokuchoTeishiJiyuCode);
    }

// </editor-fold>
}
