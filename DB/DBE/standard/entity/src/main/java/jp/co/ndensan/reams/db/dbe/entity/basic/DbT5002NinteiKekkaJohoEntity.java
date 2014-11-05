package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KaigoHihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 要介護認定結果情報のエンティティクラスです。
 *
 * @author N8156 宮本 康
 */
public class DbT5002NinteiKekkaJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

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
    private ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private KaigoHihokenshaNo hihokenshaNo;
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
    private RString kaigoServiceShurui01;
    private RString kaigoServiceShurui02;
    private RString kaigoServiceShurui03;
    private RString kaigoServiceShurui04;
    private RString kaigoServiceShurui05;
    private RString kaigoServiceShurui06;
    private RString kaigoServiceShurui07;
    private RString kaigoServiceShurui08;
    private RString kaigoServiceShurui09;
    private RString kaigoServiceShurui10;
    private RString kaigoServiceShurui11;
    private RString kaigoServiceShurui12;
    private RString kaigoServiceShurui13;
    private RString kaigoServiceShurui14;
    private RString kaigoServiceShurui15;
    private RString kaigoServiceShurui16;
    private RString kaigoServiceShurui17;
    private RString kaigoServiceShurui18;
    private RString kaigoServiceShurui19;
    private RString kaigoServiceShurui20;
    private RString kaigoServiceShurui21;
    private RString kaigoServiceShurui22;
    private RString kaigoServiceShurui23;
    private RString kaigoServiceShurui24;
    private RString kaigoServiceShurui25;
    private RString kaigoServiceShurui26;
    private RString kaigoServiceShurui27;
    private RString kaigoServiceShurui28;
    private RString kaigoServiceShurui29;
    private RString kaigoServiceShurui30;
    private RString ninteiKekkaIdoJiyu;
    private FlexibleDate ninteiKekkaIdoYMD;
    private RString ninteiTorikeshiRiyu;
    private FlexibleDate ninteiTorikeshiYMD;
    private RString tuchiKubun;
    private RString ninteiRiyu;
    private RString shinsakaiMemo;
    private FlexibleDate ifSofuYMD;

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
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * setShinseishoKanriNo
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
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
     * getKaigoServiceShurui01
     *
     * @return kaigoServiceShurui01
     */
    public RString getKaigoServiceShurui01() {
        return kaigoServiceShurui01;
    }

    /**
     * setKaigoServiceShurui01
     *
     * @param kaigoServiceShurui01 kaigoServiceShurui01
     */
    public void setKaigoServiceShurui01(RString kaigoServiceShurui01) {
        this.kaigoServiceShurui01 = kaigoServiceShurui01;
    }

    /**
     * getKaigoServiceShurui02
     *
     * @return kaigoServiceShurui02
     */
    public RString getKaigoServiceShurui02() {
        return kaigoServiceShurui02;
    }

    /**
     * setKaigoServiceShurui02
     *
     * @param kaigoServiceShurui02 kaigoServiceShurui02
     */
    public void setKaigoServiceShurui02(RString kaigoServiceShurui02) {
        this.kaigoServiceShurui02 = kaigoServiceShurui02;
    }

    /**
     * getKaigoServiceShurui03
     *
     * @return kaigoServiceShurui03
     */
    public RString getKaigoServiceShurui03() {
        return kaigoServiceShurui03;
    }

    /**
     * setKaigoServiceShurui03
     *
     * @param kaigoServiceShurui03 kaigoServiceShurui03
     */
    public void setKaigoServiceShurui03(RString kaigoServiceShurui03) {
        this.kaigoServiceShurui03 = kaigoServiceShurui03;
    }

    /**
     * getKaigoServiceShurui04
     *
     * @return kaigoServiceShurui04
     */
    public RString getKaigoServiceShurui04() {
        return kaigoServiceShurui04;
    }

    /**
     * setKaigoServiceShurui04
     *
     * @param kaigoServiceShurui04 kaigoServiceShurui04
     */
    public void setKaigoServiceShurui04(RString kaigoServiceShurui04) {
        this.kaigoServiceShurui04 = kaigoServiceShurui04;
    }

    /**
     * getKaigoServiceShurui05
     *
     * @return kaigoServiceShurui05
     */
    public RString getKaigoServiceShurui05() {
        return kaigoServiceShurui05;
    }

    /**
     * setKaigoServiceShurui05
     *
     * @param kaigoServiceShurui05 kaigoServiceShurui05
     */
    public void setKaigoServiceShurui05(RString kaigoServiceShurui05) {
        this.kaigoServiceShurui05 = kaigoServiceShurui05;
    }

    /**
     * getKaigoServiceShurui06
     *
     * @return kaigoServiceShurui06
     */
    public RString getKaigoServiceShurui06() {
        return kaigoServiceShurui06;
    }

    /**
     * setKaigoServiceShurui06
     *
     * @param kaigoServiceShurui06 kaigoServiceShurui06
     */
    public void setKaigoServiceShurui06(RString kaigoServiceShurui06) {
        this.kaigoServiceShurui06 = kaigoServiceShurui06;
    }

    /**
     * getKaigoServiceShurui07
     *
     * @return kaigoServiceShurui07
     */
    public RString getKaigoServiceShurui07() {
        return kaigoServiceShurui07;
    }

    /**
     * setKaigoServiceShurui07
     *
     * @param kaigoServiceShurui07 kaigoServiceShurui07
     */
    public void setKaigoServiceShurui07(RString kaigoServiceShurui07) {
        this.kaigoServiceShurui07 = kaigoServiceShurui07;
    }

    /**
     * getKaigoServiceShurui08
     *
     * @return kaigoServiceShurui08
     */
    public RString getKaigoServiceShurui08() {
        return kaigoServiceShurui08;
    }

    /**
     * setKaigoServiceShurui08
     *
     * @param kaigoServiceShurui08 kaigoServiceShurui08
     */
    public void setKaigoServiceShurui08(RString kaigoServiceShurui08) {
        this.kaigoServiceShurui08 = kaigoServiceShurui08;
    }

    /**
     * getKaigoServiceShurui09
     *
     * @return kaigoServiceShurui09
     */
    public RString getKaigoServiceShurui09() {
        return kaigoServiceShurui09;
    }

    /**
     * setKaigoServiceShurui09
     *
     * @param kaigoServiceShurui09 kaigoServiceShurui09
     */
    public void setKaigoServiceShurui09(RString kaigoServiceShurui09) {
        this.kaigoServiceShurui09 = kaigoServiceShurui09;
    }

    /**
     * getKaigoServiceShurui10
     *
     * @return kaigoServiceShurui10
     */
    public RString getKaigoServiceShurui10() {
        return kaigoServiceShurui10;
    }

    /**
     * setKaigoServiceShurui10
     *
     * @param kaigoServiceShurui10 kaigoServiceShurui10
     */
    public void setKaigoServiceShurui10(RString kaigoServiceShurui10) {
        this.kaigoServiceShurui10 = kaigoServiceShurui10;
    }

    /**
     * getKaigoServiceShurui11
     *
     * @return kaigoServiceShurui11
     */
    public RString getKaigoServiceShurui11() {
        return kaigoServiceShurui11;
    }

    /**
     * setKaigoServiceShurui11
     *
     * @param kaigoServiceShurui11 kaigoServiceShurui11
     */
    public void setKaigoServiceShurui11(RString kaigoServiceShurui11) {
        this.kaigoServiceShurui11 = kaigoServiceShurui11;
    }

    /**
     * getKaigoServiceShurui12
     *
     * @return kaigoServiceShurui12
     */
    public RString getKaigoServiceShurui12() {
        return kaigoServiceShurui12;
    }

    /**
     * setKaigoServiceShurui12
     *
     * @param kaigoServiceShurui12 kaigoServiceShurui12
     */
    public void setKaigoServiceShurui12(RString kaigoServiceShurui12) {
        this.kaigoServiceShurui12 = kaigoServiceShurui12;
    }

    /**
     * getKaigoServiceShurui13
     *
     * @return kaigoServiceShurui13
     */
    public RString getKaigoServiceShurui13() {
        return kaigoServiceShurui13;
    }

    /**
     * setKaigoServiceShurui13
     *
     * @param kaigoServiceShurui13 kaigoServiceShurui13
     */
    public void setKaigoServiceShurui13(RString kaigoServiceShurui13) {
        this.kaigoServiceShurui13 = kaigoServiceShurui13;
    }

    /**
     * getKaigoServiceShurui14
     *
     * @return kaigoServiceShurui14
     */
    public RString getKaigoServiceShurui14() {
        return kaigoServiceShurui14;
    }

    /**
     * setKaigoServiceShurui14
     *
     * @param kaigoServiceShurui14 kaigoServiceShurui14
     */
    public void setKaigoServiceShurui14(RString kaigoServiceShurui14) {
        this.kaigoServiceShurui14 = kaigoServiceShurui14;
    }

    /**
     * getKaigoServiceShurui15
     *
     * @return kaigoServiceShurui15
     */
    public RString getKaigoServiceShurui15() {
        return kaigoServiceShurui15;
    }

    /**
     * setKaigoServiceShurui15
     *
     * @param kaigoServiceShurui15 kaigoServiceShurui15
     */
    public void setKaigoServiceShurui15(RString kaigoServiceShurui15) {
        this.kaigoServiceShurui15 = kaigoServiceShurui15;
    }

    /**
     * getKaigoServiceShurui16
     *
     * @return kaigoServiceShurui16
     */
    public RString getKaigoServiceShurui16() {
        return kaigoServiceShurui16;
    }

    /**
     * setKaigoServiceShurui16
     *
     * @param kaigoServiceShurui16 kaigoServiceShurui16
     */
    public void setKaigoServiceShurui16(RString kaigoServiceShurui16) {
        this.kaigoServiceShurui16 = kaigoServiceShurui16;
    }

    /**
     * getKaigoServiceShurui17
     *
     * @return kaigoServiceShurui17
     */
    public RString getKaigoServiceShurui17() {
        return kaigoServiceShurui17;
    }

    /**
     * setKaigoServiceShurui17
     *
     * @param kaigoServiceShurui17 kaigoServiceShurui17
     */
    public void setKaigoServiceShurui17(RString kaigoServiceShurui17) {
        this.kaigoServiceShurui17 = kaigoServiceShurui17;
    }

    /**
     * getKaigoServiceShurui18
     *
     * @return kaigoServiceShurui18
     */
    public RString getKaigoServiceShurui18() {
        return kaigoServiceShurui18;
    }

    /**
     * setKaigoServiceShurui18
     *
     * @param kaigoServiceShurui18 kaigoServiceShurui18
     */
    public void setKaigoServiceShurui18(RString kaigoServiceShurui18) {
        this.kaigoServiceShurui18 = kaigoServiceShurui18;
    }

    /**
     * getKaigoServiceShurui19
     *
     * @return kaigoServiceShurui19
     */
    public RString getKaigoServiceShurui19() {
        return kaigoServiceShurui19;
    }

    /**
     * setKaigoServiceShurui19
     *
     * @param kaigoServiceShurui19 kaigoServiceShurui19
     */
    public void setKaigoServiceShurui19(RString kaigoServiceShurui19) {
        this.kaigoServiceShurui19 = kaigoServiceShurui19;
    }

    /**
     * getKaigoServiceShurui20
     *
     * @return kaigoServiceShurui20
     */
    public RString getKaigoServiceShurui20() {
        return kaigoServiceShurui20;
    }

    /**
     * setKaigoServiceShurui20
     *
     * @param kaigoServiceShurui20 kaigoServiceShurui20
     */
    public void setKaigoServiceShurui20(RString kaigoServiceShurui20) {
        this.kaigoServiceShurui20 = kaigoServiceShurui20;
    }

    /**
     * getKaigoServiceShurui21
     *
     * @return kaigoServiceShurui21
     */
    public RString getKaigoServiceShurui21() {
        return kaigoServiceShurui21;
    }

    /**
     * setKaigoServiceShurui21
     *
     * @param kaigoServiceShurui21 kaigoServiceShurui21
     */
    public void setKaigoServiceShurui21(RString kaigoServiceShurui21) {
        this.kaigoServiceShurui21 = kaigoServiceShurui21;
    }

    /**
     * getKaigoServiceShurui22
     *
     * @return kaigoServiceShurui22
     */
    public RString getKaigoServiceShurui22() {
        return kaigoServiceShurui22;
    }

    /**
     * setKaigoServiceShurui22
     *
     * @param kaigoServiceShurui22 kaigoServiceShurui22
     */
    public void setKaigoServiceShurui22(RString kaigoServiceShurui22) {
        this.kaigoServiceShurui22 = kaigoServiceShurui22;
    }

    /**
     * getKaigoServiceShurui23
     *
     * @return kaigoServiceShurui23
     */
    public RString getKaigoServiceShurui23() {
        return kaigoServiceShurui23;
    }

    /**
     * setKaigoServiceShurui23
     *
     * @param kaigoServiceShurui23 kaigoServiceShurui23
     */
    public void setKaigoServiceShurui23(RString kaigoServiceShurui23) {
        this.kaigoServiceShurui23 = kaigoServiceShurui23;
    }

    /**
     * getKaigoServiceShurui24
     *
     * @return kaigoServiceShurui24
     */
    public RString getKaigoServiceShurui24() {
        return kaigoServiceShurui24;
    }

    /**
     * setKaigoServiceShurui24
     *
     * @param kaigoServiceShurui24 kaigoServiceShurui24
     */
    public void setKaigoServiceShurui24(RString kaigoServiceShurui24) {
        this.kaigoServiceShurui24 = kaigoServiceShurui24;
    }

    /**
     * getKaigoServiceShurui25
     *
     * @return kaigoServiceShurui25
     */
    public RString getKaigoServiceShurui25() {
        return kaigoServiceShurui25;
    }

    /**
     * setKaigoServiceShurui25
     *
     * @param kaigoServiceShurui25 kaigoServiceShurui25
     */
    public void setKaigoServiceShurui25(RString kaigoServiceShurui25) {
        this.kaigoServiceShurui25 = kaigoServiceShurui25;
    }

    /**
     * getKaigoServiceShurui26
     *
     * @return kaigoServiceShurui26
     */
    public RString getKaigoServiceShurui26() {
        return kaigoServiceShurui26;
    }

    /**
     * setKaigoServiceShurui26
     *
     * @param kaigoServiceShurui26 kaigoServiceShurui26
     */
    public void setKaigoServiceShurui26(RString kaigoServiceShurui26) {
        this.kaigoServiceShurui26 = kaigoServiceShurui26;
    }

    /**
     * getKaigoServiceShurui27
     *
     * @return kaigoServiceShurui27
     */
    public RString getKaigoServiceShurui27() {
        return kaigoServiceShurui27;
    }

    /**
     * setKaigoServiceShurui27
     *
     * @param kaigoServiceShurui27 kaigoServiceShurui27
     */
    public void setKaigoServiceShurui27(RString kaigoServiceShurui27) {
        this.kaigoServiceShurui27 = kaigoServiceShurui27;
    }

    /**
     * getKaigoServiceShurui28
     *
     * @return kaigoServiceShurui28
     */
    public RString getKaigoServiceShurui28() {
        return kaigoServiceShurui28;
    }

    /**
     * setKaigoServiceShurui28
     *
     * @param kaigoServiceShurui28 kaigoServiceShurui28
     */
    public void setKaigoServiceShurui28(RString kaigoServiceShurui28) {
        this.kaigoServiceShurui28 = kaigoServiceShurui28;
    }

    /**
     * getKaigoServiceShurui29
     *
     * @return kaigoServiceShurui29
     */
    public RString getKaigoServiceShurui29() {
        return kaigoServiceShurui29;
    }

    /**
     * setKaigoServiceShurui29
     *
     * @param kaigoServiceShurui29 kaigoServiceShurui29
     */
    public void setKaigoServiceShurui29(RString kaigoServiceShurui29) {
        this.kaigoServiceShurui29 = kaigoServiceShurui29;
    }

    /**
     * getKaigoServiceShurui30
     *
     * @return kaigoServiceShurui30
     */
    public RString getKaigoServiceShurui30() {
        return kaigoServiceShurui30;
    }

    /**
     * setKaigoServiceShurui30
     *
     * @param kaigoServiceShurui30 kaigoServiceShurui30
     */
    public void setKaigoServiceShurui30(RString kaigoServiceShurui30) {
        this.kaigoServiceShurui30 = kaigoServiceShurui30;
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

    /**
     * getIfSofuYMD
     *
     * @return ifSofuYMD
     */
    public FlexibleDate getIfSofuYMD() {
        return ifSofuYMD;
    }

    /**
     * setIfSofuYMD
     *
     * @param ifSofuYMD ifSofuYMD
     */
    public void setIfSofuYMD(FlexibleDate ifSofuYMD) {
        this.ifSofuYMD = ifSofuYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5002NinteiKekkaJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5002NinteiKekkaJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT5002NinteiKekkaJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.insertTimestamp, other.insertTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }
// </editor-fold>
}
