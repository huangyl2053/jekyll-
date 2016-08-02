package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 徴収方法Newestテーブルのエンティティクラスです。
 */
public class DbV2001ChoshuHohoEntity extends DbTableEntityBase<DbV2001ChoshuHohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV2001ChoshuHoho");

    private FlexibleYear fukaNendo;
    private HihokenshaNo hihokenshaNo;
    private int rirekiNo;
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
    private YMDHMS tokuchoTeishiNichiji;
    private RString tokuchoTeishiJiyuCode;

    /**
     * fukaNendoのgetメソッドです。
     * 
     * @return fukaNendo
     */
    @CheckForNull
    public FlexibleYear getFukaNendo() {
        return fukaNendo;
    }

    /**
     * fukaNendoのsetメソッドです。
     * 
     * @param fukaNendo fukaNendo
     */
    public void setFukaNendo(FlexibleYear fukaNendo) {
        this.fukaNendo = fukaNendo;
    }

    /**
     * hihokenshaNoのgetメソッドです。
     * 
     * @return hihokenshaNo
     */
    @CheckForNull
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * hihokenshaNoのsetメソッドです。
     * 
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * rirekiNoのgetメソッドです。
     * 
     * @return rirekiNo
     */
    @CheckForNull
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * rirekiNoのsetメソッドです。
     * 
     * @param rirekiNo rirekiNo
     */
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * choshuHoho4gatsuのgetメソッドです。
     * 
     * @return choshuHoho4gatsu
     */
    @CheckForNull
    public RString getChoshuHoho4gatsu() {
        return choshuHoho4gatsu;
    }

    /**
     * choshuHoho4gatsuのsetメソッドです。
     * 
     * @param choshuHoho4gatsu choshuHoho4gatsu
     */
    public void setChoshuHoho4gatsu(RString choshuHoho4gatsu) {
        this.choshuHoho4gatsu = choshuHoho4gatsu;
    }

    /**
     * choshuHoho5gatsuのgetメソッドです。
     * 
     * @return choshuHoho5gatsu
     */
    @CheckForNull
    public RString getChoshuHoho5gatsu() {
        return choshuHoho5gatsu;
    }

    /**
     * choshuHoho5gatsuのsetメソッドです。
     * 
     * @param choshuHoho5gatsu choshuHoho5gatsu
     */
    public void setChoshuHoho5gatsu(RString choshuHoho5gatsu) {
        this.choshuHoho5gatsu = choshuHoho5gatsu;
    }

    /**
     * choshuHoho6gatsuのgetメソッドです。
     * 
     * @return choshuHoho6gatsu
     */
    @CheckForNull
    public RString getChoshuHoho6gatsu() {
        return choshuHoho6gatsu;
    }

    /**
     * choshuHoho6gatsuのsetメソッドです。
     * 
     * @param choshuHoho6gatsu choshuHoho6gatsu
     */
    public void setChoshuHoho6gatsu(RString choshuHoho6gatsu) {
        this.choshuHoho6gatsu = choshuHoho6gatsu;
    }

    /**
     * choshuHoho7gatsuのgetメソッドです。
     * 
     * @return choshuHoho7gatsu
     */
    @CheckForNull
    public RString getChoshuHoho7gatsu() {
        return choshuHoho7gatsu;
    }

    /**
     * choshuHoho7gatsuのsetメソッドです。
     * 
     * @param choshuHoho7gatsu choshuHoho7gatsu
     */
    public void setChoshuHoho7gatsu(RString choshuHoho7gatsu) {
        this.choshuHoho7gatsu = choshuHoho7gatsu;
    }

    /**
     * choshuHoho8gatsuのgetメソッドです。
     * 
     * @return choshuHoho8gatsu
     */
    @CheckForNull
    public RString getChoshuHoho8gatsu() {
        return choshuHoho8gatsu;
    }

    /**
     * choshuHoho8gatsuのsetメソッドです。
     * 
     * @param choshuHoho8gatsu choshuHoho8gatsu
     */
    public void setChoshuHoho8gatsu(RString choshuHoho8gatsu) {
        this.choshuHoho8gatsu = choshuHoho8gatsu;
    }

    /**
     * choshuHoho9gatsuのgetメソッドです。
     * 
     * @return choshuHoho9gatsu
     */
    @CheckForNull
    public RString getChoshuHoho9gatsu() {
        return choshuHoho9gatsu;
    }

    /**
     * choshuHoho9gatsuのsetメソッドです。
     * 
     * @param choshuHoho9gatsu choshuHoho9gatsu
     */
    public void setChoshuHoho9gatsu(RString choshuHoho9gatsu) {
        this.choshuHoho9gatsu = choshuHoho9gatsu;
    }

    /**
     * choshuHoho10gatsuのgetメソッドです。
     * 
     * @return choshuHoho10gatsu
     */
    @CheckForNull
    public RString getChoshuHoho10gatsu() {
        return choshuHoho10gatsu;
    }

    /**
     * choshuHoho10gatsuのsetメソッドです。
     * 
     * @param choshuHoho10gatsu choshuHoho10gatsu
     */
    public void setChoshuHoho10gatsu(RString choshuHoho10gatsu) {
        this.choshuHoho10gatsu = choshuHoho10gatsu;
    }

    /**
     * choshuHoho11gatsuのgetメソッドです。
     * 
     * @return choshuHoho11gatsu
     */
    @CheckForNull
    public RString getChoshuHoho11gatsu() {
        return choshuHoho11gatsu;
    }

    /**
     * choshuHoho11gatsuのsetメソッドです。
     * 
     * @param choshuHoho11gatsu choshuHoho11gatsu
     */
    public void setChoshuHoho11gatsu(RString choshuHoho11gatsu) {
        this.choshuHoho11gatsu = choshuHoho11gatsu;
    }

    /**
     * choshuHoho12gatsuのgetメソッドです。
     * 
     * @return choshuHoho12gatsu
     */
    @CheckForNull
    public RString getChoshuHoho12gatsu() {
        return choshuHoho12gatsu;
    }

    /**
     * choshuHoho12gatsuのsetメソッドです。
     * 
     * @param choshuHoho12gatsu choshuHoho12gatsu
     */
    public void setChoshuHoho12gatsu(RString choshuHoho12gatsu) {
        this.choshuHoho12gatsu = choshuHoho12gatsu;
    }

    /**
     * choshuHoho1gatsuのgetメソッドです。
     * 
     * @return choshuHoho1gatsu
     */
    @CheckForNull
    public RString getChoshuHoho1gatsu() {
        return choshuHoho1gatsu;
    }

    /**
     * choshuHoho1gatsuのsetメソッドです。
     * 
     * @param choshuHoho1gatsu choshuHoho1gatsu
     */
    public void setChoshuHoho1gatsu(RString choshuHoho1gatsu) {
        this.choshuHoho1gatsu = choshuHoho1gatsu;
    }

    /**
     * choshuHoho2gatsuのgetメソッドです。
     * 
     * @return choshuHoho2gatsu
     */
    @CheckForNull
    public RString getChoshuHoho2gatsu() {
        return choshuHoho2gatsu;
    }

    /**
     * choshuHoho2gatsuのsetメソッドです。
     * 
     * @param choshuHoho2gatsu choshuHoho2gatsu
     */
    public void setChoshuHoho2gatsu(RString choshuHoho2gatsu) {
        this.choshuHoho2gatsu = choshuHoho2gatsu;
    }

    /**
     * choshuHoho3gatsuのgetメソッドです。
     * 
     * @return choshuHoho3gatsu
     */
    @CheckForNull
    public RString getChoshuHoho3gatsu() {
        return choshuHoho3gatsu;
    }

    /**
     * choshuHoho3gatsuのsetメソッドです。
     * 
     * @param choshuHoho3gatsu choshuHoho3gatsu
     */
    public void setChoshuHoho3gatsu(RString choshuHoho3gatsu) {
        this.choshuHoho3gatsu = choshuHoho3gatsu;
    }

    /**
     * choshuHohoYoku4gatsuのgetメソッドです。
     * 
     * @return choshuHohoYoku4gatsu
     */
    @CheckForNull
    public RString getChoshuHohoYoku4gatsu() {
        return choshuHohoYoku4gatsu;
    }

    /**
     * choshuHohoYoku4gatsuのsetメソッドです。
     * 
     * @param choshuHohoYoku4gatsu choshuHohoYoku4gatsu
     */
    public void setChoshuHohoYoku4gatsu(RString choshuHohoYoku4gatsu) {
        this.choshuHohoYoku4gatsu = choshuHohoYoku4gatsu;
    }

    /**
     * choshuHohoYoku5gatsuのgetメソッドです。
     * 
     * @return choshuHohoYoku5gatsu
     */
    @CheckForNull
    public RString getChoshuHohoYoku5gatsu() {
        return choshuHohoYoku5gatsu;
    }

    /**
     * choshuHohoYoku5gatsuのsetメソッドです。
     * 
     * @param choshuHohoYoku5gatsu choshuHohoYoku5gatsu
     */
    public void setChoshuHohoYoku5gatsu(RString choshuHohoYoku5gatsu) {
        this.choshuHohoYoku5gatsu = choshuHohoYoku5gatsu;
    }

    /**
     * choshuHohoYoku6gatsuのgetメソッドです。
     * 
     * @return choshuHohoYoku6gatsu
     */
    @CheckForNull
    public RString getChoshuHohoYoku6gatsu() {
        return choshuHohoYoku6gatsu;
    }

    /**
     * choshuHohoYoku6gatsuのsetメソッドです。
     * 
     * @param choshuHohoYoku6gatsu choshuHohoYoku6gatsu
     */
    public void setChoshuHohoYoku6gatsu(RString choshuHohoYoku6gatsu) {
        this.choshuHohoYoku6gatsu = choshuHohoYoku6gatsu;
    }

    /**
     * choshuHohoYoku7gatsuのgetメソッドです。
     * 
     * @return choshuHohoYoku7gatsu
     */
    @CheckForNull
    public RString getChoshuHohoYoku7gatsu() {
        return choshuHohoYoku7gatsu;
    }

    /**
     * choshuHohoYoku7gatsuのsetメソッドです。
     * 
     * @param choshuHohoYoku7gatsu choshuHohoYoku7gatsu
     */
    public void setChoshuHohoYoku7gatsu(RString choshuHohoYoku7gatsu) {
        this.choshuHohoYoku7gatsu = choshuHohoYoku7gatsu;
    }

    /**
     * choshuHohoYoku8gatsuのgetメソッドです。
     * 
     * @return choshuHohoYoku8gatsu
     */
    @CheckForNull
    public RString getChoshuHohoYoku8gatsu() {
        return choshuHohoYoku8gatsu;
    }

    /**
     * choshuHohoYoku8gatsuのsetメソッドです。
     * 
     * @param choshuHohoYoku8gatsu choshuHohoYoku8gatsu
     */
    public void setChoshuHohoYoku8gatsu(RString choshuHohoYoku8gatsu) {
        this.choshuHohoYoku8gatsu = choshuHohoYoku8gatsu;
    }

    /**
     * choshuHohoYoku9gatsuのgetメソッドです。
     * 
     * @return choshuHohoYoku9gatsu
     */
    @CheckForNull
    public RString getChoshuHohoYoku9gatsu() {
        return choshuHohoYoku9gatsu;
    }

    /**
     * choshuHohoYoku9gatsuのsetメソッドです。
     * 
     * @param choshuHohoYoku9gatsu choshuHohoYoku9gatsu
     */
    public void setChoshuHohoYoku9gatsu(RString choshuHohoYoku9gatsu) {
        this.choshuHohoYoku9gatsu = choshuHohoYoku9gatsu;
    }

    /**
     * kariNenkinNoのgetメソッドです。
     * 
     * @return kariNenkinNo
     */
    @CheckForNull
    public RString getKariNenkinNo() {
        return kariNenkinNo;
    }

    /**
     * kariNenkinNoのsetメソッドです。
     * 
     * @param kariNenkinNo kariNenkinNo
     */
    public void setKariNenkinNo(RString kariNenkinNo) {
        this.kariNenkinNo = kariNenkinNo;
    }

    /**
     * kariNenkinCodeのgetメソッドです。
     * 
     * @return kariNenkinCode
     */
    @CheckForNull
    public RString getKariNenkinCode() {
        return kariNenkinCode;
    }

    /**
     * kariNenkinCodeのsetメソッドです。
     * 
     * @param kariNenkinCode kariNenkinCode
     */
    public void setKariNenkinCode(RString kariNenkinCode) {
        this.kariNenkinCode = kariNenkinCode;
    }

    /**
     * kariHosokuMのgetメソッドです。
     * 
     * @return kariHosokuM
     */
    @CheckForNull
    public RString getKariHosokuM() {
        return kariHosokuM;
    }

    /**
     * kariHosokuMのsetメソッドです。
     * 
     * @param kariHosokuM kariHosokuM
     */
    public void setKariHosokuM(RString kariHosokuM) {
        this.kariHosokuM = kariHosokuM;
    }

    /**
     * honNenkinNoのgetメソッドです。
     * 
     * @return honNenkinNo
     */
    @CheckForNull
    public RString getHonNenkinNo() {
        return honNenkinNo;
    }

    /**
     * honNenkinNoのsetメソッドです。
     * 
     * @param honNenkinNo honNenkinNo
     */
    public void setHonNenkinNo(RString honNenkinNo) {
        this.honNenkinNo = honNenkinNo;
    }

    /**
     * honNenkinCodeのgetメソッドです。
     * 
     * @return honNenkinCode
     */
    @CheckForNull
    public RString getHonNenkinCode() {
        return honNenkinCode;
    }

    /**
     * honNenkinCodeのsetメソッドです。
     * 
     * @param honNenkinCode honNenkinCode
     */
    public void setHonNenkinCode(RString honNenkinCode) {
        this.honNenkinCode = honNenkinCode;
    }

    /**
     * honHosokuMのgetメソッドです。
     * 
     * @return honHosokuM
     */
    @CheckForNull
    public RString getHonHosokuM() {
        return honHosokuM;
    }

    /**
     * honHosokuMのsetメソッドです。
     * 
     * @param honHosokuM honHosokuM
     */
    public void setHonHosokuM(RString honHosokuM) {
        this.honHosokuM = honHosokuM;
    }

    /**
     * yokunendoKariNenkinNoのgetメソッドです。
     * 
     * @return yokunendoKariNenkinNo
     */
    @CheckForNull
    public RString getYokunendoKariNenkinNo() {
        return yokunendoKariNenkinNo;
    }

    /**
     * yokunendoKariNenkinNoのsetメソッドです。
     * 
     * @param yokunendoKariNenkinNo yokunendoKariNenkinNo
     */
    public void setYokunendoKariNenkinNo(RString yokunendoKariNenkinNo) {
        this.yokunendoKariNenkinNo = yokunendoKariNenkinNo;
    }

    /**
     * yokunendoKariNenkinCodeのgetメソッドです。
     * 
     * @return yokunendoKariNenkinCode
     */
    @CheckForNull
    public RString getYokunendoKariNenkinCode() {
        return yokunendoKariNenkinCode;
    }

    /**
     * yokunendoKariNenkinCodeのsetメソッドです。
     * 
     * @param yokunendoKariNenkinCode yokunendoKariNenkinCode
     */
    public void setYokunendoKariNenkinCode(RString yokunendoKariNenkinCode) {
        this.yokunendoKariNenkinCode = yokunendoKariNenkinCode;
    }

    /**
     * yokunendoKariHosokuMのgetメソッドです。
     * 
     * @return yokunendoKariHosokuM
     */
    @CheckForNull
    public RString getYokunendoKariHosokuM() {
        return yokunendoKariHosokuM;
    }

    /**
     * yokunendoKariHosokuMのsetメソッドです。
     * 
     * @param yokunendoKariHosokuM yokunendoKariHosokuM
     */
    public void setYokunendoKariHosokuM(RString yokunendoKariHosokuM) {
        this.yokunendoKariHosokuM = yokunendoKariHosokuM;
    }

    /**
     * iraiSohuzumiFlagのgetメソッドです。
     * 
     * @return iraiSohuzumiFlag
     */
    @CheckForNull
    public boolean getIraiSohuzumiFlag() {
        return iraiSohuzumiFlag;
    }

    /**
     * iraiSohuzumiFlagのsetメソッドです。
     * 
     * @param iraiSohuzumiFlag iraiSohuzumiFlag
     */
    public void setIraiSohuzumiFlag(boolean iraiSohuzumiFlag) {
        this.iraiSohuzumiFlag = iraiSohuzumiFlag;
    }

    /**
     * tsuikaIraiSohuzumiFlagのgetメソッドです。
     * 
     * @return tsuikaIraiSohuzumiFlag
     */
    @CheckForNull
    public boolean getTsuikaIraiSohuzumiFlag() {
        return tsuikaIraiSohuzumiFlag;
    }

    /**
     * tsuikaIraiSohuzumiFlagのsetメソッドです。
     * 
     * @param tsuikaIraiSohuzumiFlag tsuikaIraiSohuzumiFlag
     */
    public void setTsuikaIraiSohuzumiFlag(boolean tsuikaIraiSohuzumiFlag) {
        this.tsuikaIraiSohuzumiFlag = tsuikaIraiSohuzumiFlag;
    }

    /**
     * tokuchoTeishiNichijiのgetメソッドです。
     * 
     * @return tokuchoTeishiNichiji
     */
    @CheckForNull
    public YMDHMS getTokuchoTeishiNichiji() {
        return tokuchoTeishiNichiji;
    }

    /**
     * tokuchoTeishiNichijiのsetメソッドです。
     * 
     * @param tokuchoTeishiNichiji tokuchoTeishiNichiji
     */
    public void setTokuchoTeishiNichiji(YMDHMS tokuchoTeishiNichiji) {
        this.tokuchoTeishiNichiji = tokuchoTeishiNichiji;
    }

    /**
     * tokuchoTeishiJiyuCodeのgetメソッドです。
     * 
     * @return tokuchoTeishiJiyuCode
     */
    @CheckForNull
    public RString getTokuchoTeishiJiyuCode() {
        return tokuchoTeishiJiyuCode;
    }

    /**
     * tokuchoTeishiJiyuCodeのsetメソッドです。
     * 
     * @param tokuchoTeishiJiyuCode tokuchoTeishiJiyuCode
     */
    public void setTokuchoTeishiJiyuCode(RString tokuchoTeishiJiyuCode) {
        this.tokuchoTeishiJiyuCode = tokuchoTeishiJiyuCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV2001ChoshuHohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV2001ChoshuHohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV2001ChoshuHohoEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV2001ChoshuHohoEntity entity) {
        this.fukaNendo = entity.fukaNendo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
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
        this.tokuchoTeishiNichiji = entity.tokuchoTeishiNichiji;
        this.tokuchoTeishiJiyuCode = entity.tokuchoTeishiJiyuCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(fukaNendo, hihokenshaNo, rirekiNo, choshuHoho4gatsu, choshuHoho5gatsu, choshuHoho6gatsu, choshuHoho7gatsu, choshuHoho8gatsu, choshuHoho9gatsu, choshuHoho10gatsu, choshuHoho11gatsu, choshuHoho12gatsu, choshuHoho1gatsu, choshuHoho2gatsu, choshuHoho3gatsu, choshuHohoYoku4gatsu, choshuHohoYoku5gatsu, choshuHohoYoku6gatsu, choshuHohoYoku7gatsu, choshuHohoYoku8gatsu, choshuHohoYoku9gatsu, kariNenkinNo, kariNenkinCode, kariHosokuM, honNenkinNo, honNenkinCode, honHosokuM, yokunendoKariNenkinNo, yokunendoKariNenkinCode, yokunendoKariHosokuM, iraiSohuzumiFlag, tsuikaIraiSohuzumiFlag, tokuchoTeishiNichiji, tokuchoTeishiJiyuCode);
    }

// </editor-fold>
}
