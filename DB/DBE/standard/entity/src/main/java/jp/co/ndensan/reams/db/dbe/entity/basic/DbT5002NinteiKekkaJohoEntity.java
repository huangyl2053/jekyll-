package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 要介護認定結果情報のエンティティクラスです。
 *
 * @author N8156 宮本 康
 */
public class DbT5002NinteiKekkaJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5002NinteiKekkaJoho");
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
    private RString shinseishoKanriNo;
    private RString shoKisaiHokenshaNo;
    private RString hihokenshaNo;
    private FlexibleDate youkaigodoNinteiYMD;
    private Code youkaigoJotaiKubunCode;
    private int ninteiYukoKikan;
    private FlexibleDate ninteiYukoKaishiYMD;
    private FlexibleDate ninteiYukoShuryoYMD;
    private Code tokuteiShippeiCode;
    private boolean shisetsuNyushoFlag;
    private int shinsakaiKaisaiNo;
    private RString shinsakaiIken;
    private RString ichijiHnateiKekkaHenkoRiyu;
    private Code yokaigoJotaizoReiCode;
    private RString ninteishinsakaiIkenShurui;
    private RString kaigoServiceShurui;
    private RString ninteiKekkaIdoJiyu;
    private FlexibleDate ninteiKekkaIdoYMD;
    private RString ninteiTorikeshiRiyu;
    private FlexibleDate ninteiTorikeshiYMD;
    private RString tuchiKubun;
    private RString ninteiRiyu;
    private RString shinsakaiMemo;

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
     * getShinseishoKanriNo
     *
     * @return shinseishoKanriNo
     */
    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * setShinseishoKanriNo
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * getShoKisaiHokenshaNo
     *
     * @return shoKisaiHokenshaNo
     */
    public RString getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * setShoKisaiHokenshaNo
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     */
    public void setShoKisaiHokenshaNo(RString shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * getHihokenshaNo
     *
     * @return hihokenshaNo
     */
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * getYoukaigodoNinteiYMD
     *
     * @return youkaigodoNinteiYMD
     */
    public FlexibleDate getYoukaigodoNinteiYMD() {
        return youkaigodoNinteiYMD;
    }

    /**
     * setYoukaigodoNinteiYMD
     *
     * @param youkaigodoNinteiYMD youkaigodoNinteiYMD
     */
    public void setYoukaigodoNinteiYMD(FlexibleDate youkaigodoNinteiYMD) {
        this.youkaigodoNinteiYMD = youkaigodoNinteiYMD;
    }

    /**
     * getYoukaigoJotaiKubunCode
     *
     * @return youkaigoJotaiKubunCode
     */
    public Code getYoukaigoJotaiKubunCode() {
        return youkaigoJotaiKubunCode;
    }

    /**
     * setYoukaigoJotaiKubunCode
     *
     * @param youkaigoJotaiKubunCode youkaigoJotaiKubunCode
     */
    public void setYoukaigoJotaiKubunCode(Code youkaigoJotaiKubunCode) {
        this.youkaigoJotaiKubunCode = youkaigoJotaiKubunCode;
    }

    /**
     * getNinteiYukoKikan
     *
     * @return ninteiYukoKikan
     */
    public int getNinteiYukoKikan() {
        return ninteiYukoKikan;
    }

    /**
     * setNinteiYukoKikan
     *
     * @param ninteiYukoKikan ninteiYukoKikan
     */
    public void setNinteiYukoKikan(int ninteiYukoKikan) {
        this.ninteiYukoKikan = ninteiYukoKikan;
    }

    /**
     * getNinteiYukoKaishiYMD
     *
     * @return ninteiYukoKaishiYMD
     */
    public FlexibleDate getNinteiYukoKaishiYMD() {
        return ninteiYukoKaishiYMD;
    }

    /**
     * setNinteiYukoKaishiYMD
     *
     * @param ninteiYukoKaishiYMD ninteiYukoKaishiYMD
     */
    public void setNinteiYukoKaishiYMD(FlexibleDate ninteiYukoKaishiYMD) {
        this.ninteiYukoKaishiYMD = ninteiYukoKaishiYMD;
    }

    /**
     * getNinteiYukoShuryoYMD
     *
     * @return ninteiYukoShuryoYMD
     */
    public FlexibleDate getNinteiYukoShuryoYMD() {
        return ninteiYukoShuryoYMD;
    }

    /**
     * setNinteiYukoShuryoYMD
     *
     * @param ninteiYukoShuryoYMD ninteiYukoShuryoYMD
     */
    public void setNinteiYukoShuryoYMD(FlexibleDate ninteiYukoShuryoYMD) {
        this.ninteiYukoShuryoYMD = ninteiYukoShuryoYMD;
    }

    /**
     * getTokuteiShippeiCode
     *
     * @return tokuteiShippeiCode
     */
    public Code getTokuteiShippeiCode() {
        return tokuteiShippeiCode;
    }

    /**
     * setTokuteiShippeiCode
     *
     * @param tokuteiShippeiCode tokuteiShippeiCode
     */
    public void setTokuteiShippeiCode(Code tokuteiShippeiCode) {
        this.tokuteiShippeiCode = tokuteiShippeiCode;
    }

    /**
     * getShisetsuNyushoFlag
     *
     * @return shisetsuNyushoFlag
     */
    public boolean getShisetsuNyushoFlag() {
        return shisetsuNyushoFlag;
    }

    /**
     * setShisetsuNyushoFlag
     *
     * @param shisetsuNyushoFlag shisetsuNyushoFlag
     */
    public void setShisetsuNyushoFlag(boolean shisetsuNyushoFlag) {
        this.shisetsuNyushoFlag = shisetsuNyushoFlag;
    }

    /**
     * getShinsakaiKaisaiNo
     *
     * @return shinsakaiKaisaiNo
     */
    public int getShinsakaiKaisaiNo() {
        return shinsakaiKaisaiNo;
    }

    /**
     * setShinsakaiKaisaiNo
     *
     * @param shinsakaiKaisaiNo shinsakaiKaisaiNo
     */
    public void setShinsakaiKaisaiNo(int shinsakaiKaisaiNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }

    /**
     * getShinsakaiIken
     *
     * @return shinsakaiIken
     */
    public RString getShinsakaiIken() {
        return shinsakaiIken;
    }

    /**
     * setShinsakaiIken
     *
     * @param shinsakaiIken shinsakaiIken
     */
    public void setShinsakaiIken(RString shinsakaiIken) {
        this.shinsakaiIken = shinsakaiIken;
    }

    /**
     * getIchijiHnateiKekkaHenkoRiyu
     *
     * @return ichijiHnateiKekkaHenkoRiyu
     */
    public RString getIchijiHnateiKekkaHenkoRiyu() {
        return ichijiHnateiKekkaHenkoRiyu;
    }

    /**
     * setIchijiHnateiKekkaHenkoRiyu
     *
     * @param ichijiHnateiKekkaHenkoRiyu ichijiHnateiKekkaHenkoRiyu
     */
    public void setIchijiHnateiKekkaHenkoRiyu(RString ichijiHnateiKekkaHenkoRiyu) {
        this.ichijiHnateiKekkaHenkoRiyu = ichijiHnateiKekkaHenkoRiyu;
    }

    /**
     * getYokaigoJotaizoReiCode
     *
     * @return yokaigoJotaizoReiCode
     */
    public Code getYokaigoJotaizoReiCode() {
        return yokaigoJotaizoReiCode;
    }

    /**
     * setYokaigoJotaizoReiCode
     *
     * @param yokaigoJotaizoReiCode yokaigoJotaizoReiCode
     */
    public void setYokaigoJotaizoReiCode(Code yokaigoJotaizoReiCode) {
        this.yokaigoJotaizoReiCode = yokaigoJotaizoReiCode;
    }

    /**
     * getNinteishinsakaiIkenShurui
     *
     * @return ninteishinsakaiIkenShurui
     */
    public RString getNinteishinsakaiIkenShurui() {
        return ninteishinsakaiIkenShurui;
    }

    /**
     * setNinteishinsakaiIkenShurui
     *
     * @param ninteishinsakaiIkenShurui ninteishinsakaiIkenShurui
     */
    public void setNinteishinsakaiIkenShurui(RString ninteishinsakaiIkenShurui) {
        this.ninteishinsakaiIkenShurui = ninteishinsakaiIkenShurui;
    }

    /**
     * getKaigoServiceShurui
     *
     * @return kaigoServiceShurui
     */
    public RString getKaigoServiceShurui() {
        return kaigoServiceShurui;
    }

    /**
     * setKaigoServiceShurui
     *
     * @param kaigoServiceShurui kaigoServiceShurui
     */
    public void setKaigoServiceShurui(RString kaigoServiceShurui) {
        this.kaigoServiceShurui = kaigoServiceShurui;
    }

    /**
     * getNinteiKekkaIdoJiyu
     *
     * @return ninteiKekkaIdoJiyu
     */
    public RString getNinteiKekkaIdoJiyu() {
        return ninteiKekkaIdoJiyu;
    }

    /**
     * setNinteiKekkaIdoJiyu
     *
     * @param ninteiKekkaIdoJiyu ninteiKekkaIdoJiyu
     */
    public void setNinteiKekkaIdoJiyu(RString ninteiKekkaIdoJiyu) {
        this.ninteiKekkaIdoJiyu = ninteiKekkaIdoJiyu;
    }

    /**
     * getNinteiKekkaIdoYMD
     *
     * @return ninteiKekkaIdoYMD
     */
    public FlexibleDate getNinteiKekkaIdoYMD() {
        return ninteiKekkaIdoYMD;
    }

    /**
     * setNinteiKekkaIdoYMD
     *
     * @param ninteiKekkaIdoYMD ninteiKekkaIdoYMD
     */
    public void setNinteiKekkaIdoYMD(FlexibleDate ninteiKekkaIdoYMD) {
        this.ninteiKekkaIdoYMD = ninteiKekkaIdoYMD;
    }

    /**
     * getNinteiTorikeshiRiyu
     *
     * @return ninteiTorikeshiRiyu
     */
    public RString getNinteiTorikeshiRiyu() {
        return ninteiTorikeshiRiyu;
    }

    /**
     * setNinteiTorikeshiRiyu
     *
     * @param ninteiTorikeshiRiyu ninteiTorikeshiRiyu
     */
    public void setNinteiTorikeshiRiyu(RString ninteiTorikeshiRiyu) {
        this.ninteiTorikeshiRiyu = ninteiTorikeshiRiyu;
    }

    /**
     * getNinteiTorikeshiYMD
     *
     * @return ninteiTorikeshiYMD
     */
    public FlexibleDate getNinteiTorikeshiYMD() {
        return ninteiTorikeshiYMD;
    }

    /**
     * setNinteiTorikeshiYMD
     *
     * @param ninteiTorikeshiYMD ninteiTorikeshiYMD
     */
    public void setNinteiTorikeshiYMD(FlexibleDate ninteiTorikeshiYMD) {
        this.ninteiTorikeshiYMD = ninteiTorikeshiYMD;
    }

    /**
     * getTuchiKubun
     *
     * @return tuchiKubun
     */
    public RString getTuchiKubun() {
        return tuchiKubun;
    }

    /**
     * setTuchiKubun
     *
     * @param tuchiKubun tuchiKubun
     */
    public void setTuchiKubun(RString tuchiKubun) {
        this.tuchiKubun = tuchiKubun;
    }

    /**
     * getNinteiRiyu
     *
     * @return ninteiRiyu
     */
    public RString getNinteiRiyu() {
        return ninteiRiyu;
    }

    /**
     * setNinteiRiyu
     *
     * @param ninteiRiyu ninteiRiyu
     */
    public void setNinteiRiyu(RString ninteiRiyu) {
        this.ninteiRiyu = ninteiRiyu;
    }

    /**
     * getShinsakaiMemo
     *
     * @return shinsakaiMemo
     */
    public RString getShinsakaiMemo() {
        return shinsakaiMemo;
    }

    /**
     * setShinsakaiMemo
     *
     * @param shinsakaiMemo shinsakaiMemo
     */
    public void setShinsakaiMemo(RString shinsakaiMemo) {
        this.shinsakaiMemo = shinsakaiMemo;
    }
// </editor-fold>
}
