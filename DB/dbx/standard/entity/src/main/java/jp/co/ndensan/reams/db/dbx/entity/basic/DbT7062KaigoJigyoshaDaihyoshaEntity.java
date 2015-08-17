package jp.co.ndensan.reams.db.dbx.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * DbT7062KaigoJigyoshaDaihyoshaの項目定義クラスです
 *
 */
@OnNextSchema("rgdb")
public class DbT7062KaigoJigyoshaDaihyoshaEntity extends DbTableEntityBase<DbT7062KaigoJigyoshaDaihyoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7062KaigoJigyoshaDaihyosha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private KaigoJigyoshaNo jigyoshaNo;
    @PrimaryKey
    private FlexibleDate yukoKaishiYMD;
    private AtenaMeisho daihyoshaShimei;
    private AtenaKanaMeisho daihyoshaKanaShimei;
    private YubinNo daihyoshaYubinNo;
    private AtenaJusho daihyoshaJusho;
    private RString daihyoshaKanaJusho;
    private RString daihyoshaYakushokuMei;
    private AtenaMeisho kaisetsushaShimei;
    private AtenaKanaMeisho kaisetsushaKanaShimei;
    private YubinNo kaisetsushaYubinNo;
    private AtenaJusho kaisetsushaJusho;
    private RString kaisetsushaKanaJusho;
    private TelNo kaisetsushaTelNo;
    private TelNo kaisetsushaFaxNo;

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
     * getJigyoshaNo
     *
     * @return jigyoshaNo
     */
    public KaigoJigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * setJigyoshaNo
     *
     * @param jigyoshaNo jigyoshaNo
     */
    public void setJigyoshaNo(KaigoJigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * getYukoKaishiYMD
     *
     * @return yukoKaishiYMD
     */
    public FlexibleDate getYukoKaishiYMD() {
        return yukoKaishiYMD;
    }

    /**
     * setYukoKaishiYMD
     *
     * @param yukoKaishiYMD yukoKaishiYMD
     */
    public void setYukoKaishiYMD(FlexibleDate yukoKaishiYMD) {
        this.yukoKaishiYMD = yukoKaishiYMD;
    }

    /**
     * getDaihyoshaShimei
     *
     * @return daihyoshaShimei
     */
    public AtenaMeisho getDaihyoshaShimei() {
        return daihyoshaShimei;
    }

    /**
     * setDaihyoshaShimei
     *
     * @param daihyoshaShimei daihyoshaShimei
     */
    public void setDaihyoshaShimei(AtenaMeisho daihyoshaShimei) {
        this.daihyoshaShimei = daihyoshaShimei;
    }

    /**
     * getDaihyoshaKanaShimei
     *
     * @return daihyoshaKanaShimei
     */
    public AtenaKanaMeisho getDaihyoshaKanaShimei() {
        return daihyoshaKanaShimei;
    }

    /**
     * setDaihyoshaKanaShimei
     *
     * @param daihyoshaKanaShimei daihyoshaKanaShimei
     */
    public void setDaihyoshaKanaShimei(AtenaKanaMeisho daihyoshaKanaShimei) {
        this.daihyoshaKanaShimei = daihyoshaKanaShimei;
    }

    /**
     * getDaihyoshaYubinNo
     *
     * @return daihyoshaYubinNo
     */
    public YubinNo getDaihyoshaYubinNo() {
        return daihyoshaYubinNo;
    }

    /**
     * setDaihyoshaYubinNo
     *
     * @param daihyoshaYubinNo daihyoshaYubinNo
     */
    public void setDaihyoshaYubinNo(YubinNo daihyoshaYubinNo) {
        this.daihyoshaYubinNo = daihyoshaYubinNo;
    }

    /**
     * getDaihyoshaJusho
     *
     * @return daihyoshaJusho
     */
    public AtenaJusho getDaihyoshaJusho() {
        return daihyoshaJusho;
    }

    /**
     * setDaihyoshaJusho
     *
     * @param daihyoshaJusho daihyoshaJusho
     */
    public void setDaihyoshaJusho(AtenaJusho daihyoshaJusho) {
        this.daihyoshaJusho = daihyoshaJusho;
    }

    /**
     * getDaihyoshaKanaJusho
     *
     * @return daihyoshaKanaJusho
     */
    public RString getDaihyoshaKanaJusho() {
        return daihyoshaKanaJusho;
    }

    /**
     * setDaihyoshaKanaJusho
     *
     * @param daihyoshaKanaJusho daihyoshaKanaJusho
     */
    public void setDaihyoshaKanaJusho(RString daihyoshaKanaJusho) {
        this.daihyoshaKanaJusho = daihyoshaKanaJusho;
    }

    /**
     * getDaihyoshaYakushokuMei
     *
     * @return daihyoshaYakushokuMei
     */
    public RString getDaihyoshaYakushokuMei() {
        return daihyoshaYakushokuMei;
    }

    /**
     * setDaihyoshaYakushokuMei
     *
     * @param daihyoshaYakushokuMei daihyoshaYakushokuMei
     */
    public void setDaihyoshaYakushokuMei(RString daihyoshaYakushokuMei) {
        this.daihyoshaYakushokuMei = daihyoshaYakushokuMei;
    }

    /**
     * getKaisetsushaShimei
     *
     * @return kaisetsushaShimei
     */
    public AtenaMeisho getKaisetsushaShimei() {
        return kaisetsushaShimei;
    }

    /**
     * setKaisetsushaShimei
     *
     * @param kaisetsushaShimei kaisetsushaShimei
     */
    public void setKaisetsushaShimei(AtenaMeisho kaisetsushaShimei) {
        this.kaisetsushaShimei = kaisetsushaShimei;
    }

    /**
     * getKaisetsushaKanaShimei
     *
     * @return kaisetsushaKanaShimei
     */
    public AtenaKanaMeisho getKaisetsushaKanaShimei() {
        return kaisetsushaKanaShimei;
    }

    /**
     * setKaisetsushaKanaShimei
     *
     * @param kaisetsushaKanaShimei kaisetsushaKanaShimei
     */
    public void setKaisetsushaKanaShimei(AtenaKanaMeisho kaisetsushaKanaShimei) {
        this.kaisetsushaKanaShimei = kaisetsushaKanaShimei;
    }

    /**
     * getKaisetsushaYubinNo
     *
     * @return kaisetsushaYubinNo
     */
    public YubinNo getKaisetsushaYubinNo() {
        return kaisetsushaYubinNo;
    }

    /**
     * setKaisetsushaYubinNo
     *
     * @param kaisetsushaYubinNo kaisetsushaYubinNo
     */
    public void setKaisetsushaYubinNo(YubinNo kaisetsushaYubinNo) {
        this.kaisetsushaYubinNo = kaisetsushaYubinNo;
    }

    /**
     * getKaisetsushaJusho
     *
     * @return kaisetsushaJusho
     */
    public AtenaJusho getKaisetsushaJusho() {
        return kaisetsushaJusho;
    }

    /**
     * setKaisetsushaJusho
     *
     * @param kaisetsushaJusho kaisetsushaJusho
     */
    public void setKaisetsushaJusho(AtenaJusho kaisetsushaJusho) {
        this.kaisetsushaJusho = kaisetsushaJusho;
    }

    /**
     * getKaisetsushaKanaJusho
     *
     * @return kaisetsushaKanaJusho
     */
    public RString getKaisetsushaKanaJusho() {
        return kaisetsushaKanaJusho;
    }

    /**
     * setKaisetsushaKanaJusho
     *
     * @param kaisetsushaKanaJusho kaisetsushaKanaJusho
     */
    public void setKaisetsushaKanaJusho(RString kaisetsushaKanaJusho) {
        this.kaisetsushaKanaJusho = kaisetsushaKanaJusho;
    }

    /**
     * getKaisetsushaTelNo
     *
     * @return kaisetsushaTelNo
     */
    public TelNo getKaisetsushaTelNo() {
        return kaisetsushaTelNo;
    }

    /**
     * setKaisetsushaTelNo
     *
     * @param kaisetsushaTelNo kaisetsushaTelNo
     */
    public void setKaisetsushaTelNo(TelNo kaisetsushaTelNo) {
        this.kaisetsushaTelNo = kaisetsushaTelNo;
    }

    /**
     * getKaisetsushaFaxNo
     *
     * @return kaisetsushaFaxNo
     */
    public TelNo getKaisetsushaFaxNo() {
        return kaisetsushaFaxNo;
    }

    /**
     * setKaisetsushaFaxNo
     *
     * @param kaisetsushaFaxNo kaisetsushaFaxNo
     */
    public void setKaisetsushaFaxNo(TelNo kaisetsushaFaxNo) {
        this.kaisetsushaFaxNo = kaisetsushaFaxNo;
    }

    /**
     * このエンティティの主キーが他の{@literal UrT0520KaigoJigyoshaDaihyoshaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal UrT0520KaigoJigyoshaDaihyoshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7062KaigoJigyoshaDaihyoshaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.yukoKaishiYMD, other.yukoKaishiYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7062KaigoJigyoshaDaihyoshaEntity entity) {
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yukoKaishiYMD = entity.yukoKaishiYMD;
        this.daihyoshaShimei = entity.daihyoshaShimei;
        this.daihyoshaKanaShimei = entity.daihyoshaKanaShimei;
        this.daihyoshaYubinNo = entity.daihyoshaYubinNo;
        this.daihyoshaJusho = entity.daihyoshaJusho;
        this.daihyoshaKanaJusho = entity.daihyoshaKanaJusho;
        this.daihyoshaYakushokuMei = entity.daihyoshaYakushokuMei;
        this.kaisetsushaShimei = entity.kaisetsushaShimei;
        this.kaisetsushaKanaShimei = entity.kaisetsushaKanaShimei;
        this.kaisetsushaYubinNo = entity.kaisetsushaYubinNo;
        this.kaisetsushaJusho = entity.kaisetsushaJusho;
        this.kaisetsushaKanaJusho = entity.kaisetsushaKanaJusho;
        this.kaisetsushaTelNo = entity.kaisetsushaTelNo;
        this.kaisetsushaFaxNo = entity.kaisetsushaFaxNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(jigyoshaNo, yukoKaishiYMD, daihyoshaShimei, daihyoshaKanaShimei, daihyoshaYubinNo, daihyoshaJusho, daihyoshaKanaJusho, daihyoshaYakushokuMei, kaisetsushaShimei, kaisetsushaKanaShimei, kaisetsushaYubinNo, kaisetsushaJusho, kaisetsushaKanaJusho, kaisetsushaTelNo, kaisetsushaFaxNo);
    }

// </editor-fold>
}
