package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 受給者台帳Aliveテーブルのエンティティクラスです。
 */
public class DbV4001JukyushaDaichoEntity extends DbTableEntityBase<DbV4001JukyushaDaichoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbV4001JukyushaDaicho");

    private LasdecCode shichosonCode;
    private HihokenshaNo hihokenshaNo;
    private RString rirekiNo;
    private RString edaban;
    private ShinseishoKanriNo shinseishoKanriNo;
    private RString shinseiJokyoKubun;
    private RString shishoCode;
    private boolean chokkinFlag;
    private ShikibetsuCode shikibetsuCode;
    private Code jukyuShinseiJiyu;
    private RString shinseiRiyu;
    private Code shinseishaKankeiCode;
    private RString homninKankei;
    private FlexibleDate jukyuShinseiYMD;
    private Code nigoTokuteiShippeiCode;
    private FlexibleDate shinsakaiIraiYMD;
    private Code yokaigoJotaiKubunCode;
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    private FlexibleDate ninteiYMD;
    private ServiceShuruiCode shiteiServiceShurui01;
    private ServiceShuruiCode shiteiServiceShurui02;
    private ServiceShuruiCode shiteiServiceShurui03;
    private ServiceShuruiCode shiteiServiceShurui04;
    private ServiceShuruiCode shiteiServiceShurui05;
    private ServiceShuruiCode shiteiServiceShurui06;
    private ServiceShuruiCode shiteiServiceShurui07;
    private ServiceShuruiCode shiteiServiceShurui08;
    private ServiceShuruiCode shiteiServiceShurui09;
    private ServiceShuruiCode shiteiServiceShurui10;
    private ServiceShuruiCode shiteiServiceShurui11;
    private ServiceShuruiCode shiteiServiceShurui12;
    private ServiceShuruiCode shiteiServiceShurui13;
    private ServiceShuruiCode shiteiServiceShurui14;
    private ServiceShuruiCode shiteiServiceShurui15;
    private ServiceShuruiCode shiteiServiceShurui16;
    private ServiceShuruiCode shiteiServiceShurui17;
    private ServiceShuruiCode shiteiServiceShurui18;
    private ServiceShuruiCode shiteiServiceShurui19;
    private ServiceShuruiCode shiteiServiceShurui20;
    private ServiceShuruiCode shiteiServiceShurui21;
    private ServiceShuruiCode shiteiServiceShurui22;
    private ServiceShuruiCode shiteiServiceShurui23;
    private ServiceShuruiCode shiteiServiceShurui24;
    private ServiceShuruiCode shiteiServiceShurui25;
    private ServiceShuruiCode shiteiServiceShurui26;
    private ServiceShuruiCode shiteiServiceShurui27;
    private ServiceShuruiCode shiteiServiceShurui28;
    private ServiceShuruiCode shiteiServiceShurui29;
    private ServiceShuruiCode shiteiServiceShurui30;
    private FlexibleDate soshitsuYMD;
    private FlexibleDate chokkinIdoYMD;
    private Code chokkinIdoJiyuCode;
    private Code yukoMukoKubun;
    private Code dataKubun;
    private RString remban;
    private RString idoRiyu;
    private Code shinseishoKubun;
    private Code sakujoJiyuCode;
    private boolean yoshienshaNinteiShinseiFlag;
    private Decimal shikyuGendoTanisu;
    private FlexibleDate shikyuGendoKaishiYMD;
    private FlexibleDate shikyuGendoShuryoYMD;
    private int tankiSikyuGendoNissu;
    private FlexibleDate tankiShikyuGendoKaishiYMD;
    private FlexibleDate tankiShikyuGendoShuryoYMD;
    private FlexibleDate toshoNinteiYukoKaishiYMD;
    private FlexibleDate toshoNinteiYukoShuryoYMD;
    private FlexibleDate jukyuShikakuShomeishoHakkoYMD1;
    private FlexibleDate jukyuShikakuShomeishoHakkoYMD2;
    private FlexibleDate shindanMeireishoHakkoYMD;
    private FlexibleDate nigoShinseiJuriTsuchishoHakkoYMD;
    private FlexibleDate ninteiKekkaTsuchishoHakkoYMD;
    private FlexibleDate kubunHenkoTsuchishoHakkoYMD;
    private FlexibleDate serviceHenkoTsuchishoHakkoYMD;
    private FlexibleDate ninteiKyakkaTsuchishoHakkoYMD;
    private FlexibleDate ninteiTorikeshiTsuchishoHakkoYMD;
    private boolean shikakuShutokuMaeShinseiFlag;
    private boolean kyuSochishaFlag;
    private boolean logicalDeletedFlag;

    /**
     * shichosonCodeのgetメソッドです。
     *
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * shichosonCodeのsetメソッドです。
     *
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * hihokenshaNoのgetメソッドです。
     *
     * @return hihokenshaNo
     */
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
    public RString getRirekiNo() {
        return rirekiNo;
    }

    /**
     * rirekiNoのsetメソッドです。
     *
     * @param rirekiNo rirekiNo
     */
    public void setRirekiNo(RString rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * edabanのgetメソッドです。
     *
     * @return edaban
     */
    public RString getEdaban() {
        return edaban;
    }

    /**
     * edabanのsetメソッドです。
     *
     * @param edaban edaban
     */
    public void setEdaban(RString edaban) {
        this.edaban = edaban;
    }

    /**
     * shinseishoKanriNoのgetメソッドです。
     *
     * @return shinseishoKanriNo
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * shinseishoKanriNoのsetメソッドです。
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * shinseiJokyoKubunのgetメソッドです。
     *
     * @return shinseiJokyoKubun
     */
    public RString getShinseiJokyoKubun() {
        return shinseiJokyoKubun;
    }

    /**
     * shinseiJokyoKubunのsetメソッドです。
     *
     * @param shinseiJokyoKubun shinseiJokyoKubun
     */
    public void setShinseiJokyoKubun(RString shinseiJokyoKubun) {
        this.shinseiJokyoKubun = shinseiJokyoKubun;
    }

    /**
     * shishoCodeのgetメソッドです。
     *
     * @return shishoCode
     */
    public RString getShishoCode() {
        return shishoCode;
    }

    /**
     * shishoCodeのsetメソッドです。
     *
     * @param shishoCode shishoCode
     */
    public void setShishoCode(RString shishoCode) {
        this.shishoCode = shishoCode;
    }

    /**
     * chokkinFlagのgetメソッドです。
     *
     * @return chokkinFlag
     */
    public boolean getChokkinFlag() {
        return chokkinFlag;
    }

    /**
     * chokkinFlagのsetメソッドです。
     *
     * @param chokkinFlag chokkinFlag
     */
    public void setChokkinFlag(boolean chokkinFlag) {
        this.chokkinFlag = chokkinFlag;
    }

    /**
     * shikibetsuCodeのgetメソッドです。
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * shikibetsuCodeのsetメソッドです。
     *
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * jukyuShinseiJiyuのgetメソッドです。
     *
     * @return jukyuShinseiJiyu
     */
    public Code getJukyuShinseiJiyu() {
        return jukyuShinseiJiyu;
    }

    /**
     * jukyuShinseiJiyuのsetメソッドです。
     *
     * @param jukyuShinseiJiyu jukyuShinseiJiyu
     */
    public void setJukyuShinseiJiyu(Code jukyuShinseiJiyu) {
        this.jukyuShinseiJiyu = jukyuShinseiJiyu;
    }

    /**
     * shinseiRiyuのgetメソッドです。
     *
     * @return shinseiRiyu
     */
    public RString getShinseiRiyu() {
        return shinseiRiyu;
    }

    /**
     * shinseiRiyuのsetメソッドです。
     *
     * @param shinseiRiyu shinseiRiyu
     */
    public void setShinseiRiyu(RString shinseiRiyu) {
        this.shinseiRiyu = shinseiRiyu;
    }

    /**
     * shinseishaKankeiCodeのgetメソッドです。
     *
     * @return shinseishaKankeiCode
     */
    public Code getShinseishaKankeiCode() {
        return shinseishaKankeiCode;
    }

    /**
     * shinseishaKankeiCodeのsetメソッドです。
     *
     * @param shinseishaKankeiCode shinseishaKankeiCode
     */
    public void setShinseishaKankeiCode(Code shinseishaKankeiCode) {
        this.shinseishaKankeiCode = shinseishaKankeiCode;
    }

    /**
     * homninKankeiのgetメソッドです。
     *
     * @return homninKankei
     */
    public RString getHomninKankei() {
        return homninKankei;
    }

    /**
     * homninKankeiのsetメソッドです。
     *
     * @param homninKankei homninKankei
     */
    public void setHomninKankei(RString homninKankei) {
        this.homninKankei = homninKankei;
    }

    /**
     * jukyuShinseiYMDのgetメソッドです。
     *
     * @return jukyuShinseiYMD
     */
    public FlexibleDate getJukyuShinseiYMD() {
        return jukyuShinseiYMD;
    }

    /**
     * jukyuShinseiYMDのsetメソッドです。
     *
     * @param jukyuShinseiYMD jukyuShinseiYMD
     */
    public void setJukyuShinseiYMD(FlexibleDate jukyuShinseiYMD) {
        this.jukyuShinseiYMD = jukyuShinseiYMD;
    }

    /**
     * nigoTokuteiShippeiCodeのgetメソッドです。
     *
     * @return nigoTokuteiShippeiCode
     */
    public Code getNigoTokuteiShippeiCode() {
        return nigoTokuteiShippeiCode;
    }

    /**
     * nigoTokuteiShippeiCodeのsetメソッドです。
     *
     * @param nigoTokuteiShippeiCode nigoTokuteiShippeiCode
     */
    public void setNigoTokuteiShippeiCode(Code nigoTokuteiShippeiCode) {
        this.nigoTokuteiShippeiCode = nigoTokuteiShippeiCode;
    }

    /**
     * shinsakaiIraiYMDのgetメソッドです。
     *
     * @return shinsakaiIraiYMD
     */
    public FlexibleDate getShinsakaiIraiYMD() {
        return shinsakaiIraiYMD;
    }

    /**
     * shinsakaiIraiYMDのsetメソッドです。
     *
     * @param shinsakaiIraiYMD shinsakaiIraiYMD
     */
    public void setShinsakaiIraiYMD(FlexibleDate shinsakaiIraiYMD) {
        this.shinsakaiIraiYMD = shinsakaiIraiYMD;
    }

    /**
     * yokaigoJotaiKubunCodeのgetメソッドです。
     *
     * @return yokaigoJotaiKubunCode
     */
    public Code getYokaigoJotaiKubunCode() {
        return yokaigoJotaiKubunCode;
    }

    /**
     * yokaigoJotaiKubunCodeのsetメソッドです。
     *
     * @param yokaigoJotaiKubunCode yokaigoJotaiKubunCode
     */
    public void setYokaigoJotaiKubunCode(Code yokaigoJotaiKubunCode) {
        this.yokaigoJotaiKubunCode = yokaigoJotaiKubunCode;
    }

    /**
     * ninteiYukoKikanKaishiYMDのgetメソッドです。
     *
     * @return ninteiYukoKikanKaishiYMD
     */
    public FlexibleDate getNinteiYukoKikanKaishiYMD() {
        return ninteiYukoKikanKaishiYMD;
    }

    /**
     * ninteiYukoKikanKaishiYMDのsetメソッドです。
     *
     * @param ninteiYukoKikanKaishiYMD ninteiYukoKikanKaishiYMD
     */
    public void setNinteiYukoKikanKaishiYMD(FlexibleDate ninteiYukoKikanKaishiYMD) {
        this.ninteiYukoKikanKaishiYMD = ninteiYukoKikanKaishiYMD;
    }

    /**
     * ninteiYukoKikanShuryoYMDのgetメソッドです。
     *
     * @return ninteiYukoKikanShuryoYMD
     */
    public FlexibleDate getNinteiYukoKikanShuryoYMD() {
        return ninteiYukoKikanShuryoYMD;
    }

    /**
     * ninteiYukoKikanShuryoYMDのsetメソッドです。
     *
     * @param ninteiYukoKikanShuryoYMD ninteiYukoKikanShuryoYMD
     */
    public void setNinteiYukoKikanShuryoYMD(FlexibleDate ninteiYukoKikanShuryoYMD) {
        this.ninteiYukoKikanShuryoYMD = ninteiYukoKikanShuryoYMD;
    }

    /**
     * ninteiYMDのgetメソッドです。
     *
     * @return ninteiYMD
     */
    public FlexibleDate getNinteiYMD() {
        return ninteiYMD;
    }

    /**
     * ninteiYMDのsetメソッドです。
     *
     * @param ninteiYMD ninteiYMD
     */
    public void setNinteiYMD(FlexibleDate ninteiYMD) {
        this.ninteiYMD = ninteiYMD;
    }

    /**
     * shiteiServiceShurui01のgetメソッドです。
     *
     * @return shiteiServiceShurui01
     */
    public ServiceShuruiCode getShiteiServiceShurui01() {
        return shiteiServiceShurui01;
    }

    /**
     * shiteiServiceShurui01のsetメソッドです。
     *
     * @param shiteiServiceShurui01 shiteiServiceShurui01
     */
    public void setShiteiServiceShurui01(ServiceShuruiCode shiteiServiceShurui01) {
        this.shiteiServiceShurui01 = shiteiServiceShurui01;
    }

    /**
     * shiteiServiceShurui02のgetメソッドです。
     *
     * @return shiteiServiceShurui02
     */
    public ServiceShuruiCode getShiteiServiceShurui02() {
        return shiteiServiceShurui02;
    }

    /**
     * shiteiServiceShurui02のsetメソッドです。
     *
     * @param shiteiServiceShurui02 shiteiServiceShurui02
     */
    public void setShiteiServiceShurui02(ServiceShuruiCode shiteiServiceShurui02) {
        this.shiteiServiceShurui02 = shiteiServiceShurui02;
    }

    /**
     * shiteiServiceShurui03のgetメソッドです。
     *
     * @return shiteiServiceShurui03
     */
    public ServiceShuruiCode getShiteiServiceShurui03() {
        return shiteiServiceShurui03;
    }

    /**
     * shiteiServiceShurui03のsetメソッドです。
     *
     * @param shiteiServiceShurui03 shiteiServiceShurui03
     */
    public void setShiteiServiceShurui03(ServiceShuruiCode shiteiServiceShurui03) {
        this.shiteiServiceShurui03 = shiteiServiceShurui03;
    }

    /**
     * shiteiServiceShurui04のgetメソッドです。
     *
     * @return shiteiServiceShurui04
     */
    public ServiceShuruiCode getShiteiServiceShurui04() {
        return shiteiServiceShurui04;
    }

    /**
     * shiteiServiceShurui04のsetメソッドです。
     *
     * @param shiteiServiceShurui04 shiteiServiceShurui04
     */
    public void setShiteiServiceShurui04(ServiceShuruiCode shiteiServiceShurui04) {
        this.shiteiServiceShurui04 = shiteiServiceShurui04;
    }

    /**
     * shiteiServiceShurui05のgetメソッドです。
     *
     * @return shiteiServiceShurui05
     */
    public ServiceShuruiCode getShiteiServiceShurui05() {
        return shiteiServiceShurui05;
    }

    /**
     * shiteiServiceShurui05のsetメソッドです。
     *
     * @param shiteiServiceShurui05 shiteiServiceShurui05
     */
    public void setShiteiServiceShurui05(ServiceShuruiCode shiteiServiceShurui05) {
        this.shiteiServiceShurui05 = shiteiServiceShurui05;
    }

    /**
     * shiteiServiceShurui06のgetメソッドです。
     *
     * @return shiteiServiceShurui06
     */
    public ServiceShuruiCode getShiteiServiceShurui06() {
        return shiteiServiceShurui06;
    }

    /**
     * shiteiServiceShurui06のsetメソッドです。
     *
     * @param shiteiServiceShurui06 shiteiServiceShurui06
     */
    public void setShiteiServiceShurui06(ServiceShuruiCode shiteiServiceShurui06) {
        this.shiteiServiceShurui06 = shiteiServiceShurui06;
    }

    /**
     * shiteiServiceShurui07のgetメソッドです。
     *
     * @return shiteiServiceShurui07
     */
    public ServiceShuruiCode getShiteiServiceShurui07() {
        return shiteiServiceShurui07;
    }

    /**
     * shiteiServiceShurui07のsetメソッドです。
     *
     * @param shiteiServiceShurui07 shiteiServiceShurui07
     */
    public void setShiteiServiceShurui07(ServiceShuruiCode shiteiServiceShurui07) {
        this.shiteiServiceShurui07 = shiteiServiceShurui07;
    }

    /**
     * shiteiServiceShurui08のgetメソッドです。
     *
     * @return shiteiServiceShurui08
     */
    public ServiceShuruiCode getShiteiServiceShurui08() {
        return shiteiServiceShurui08;
    }

    /**
     * shiteiServiceShurui08のsetメソッドです。
     *
     * @param shiteiServiceShurui08 shiteiServiceShurui08
     */
    public void setShiteiServiceShurui08(ServiceShuruiCode shiteiServiceShurui08) {
        this.shiteiServiceShurui08 = shiteiServiceShurui08;
    }

    /**
     * shiteiServiceShurui09のgetメソッドです。
     *
     * @return shiteiServiceShurui09
     */
    public ServiceShuruiCode getShiteiServiceShurui09() {
        return shiteiServiceShurui09;
    }

    /**
     * shiteiServiceShurui09のsetメソッドです。
     *
     * @param shiteiServiceShurui09 shiteiServiceShurui09
     */
    public void setShiteiServiceShurui09(ServiceShuruiCode shiteiServiceShurui09) {
        this.shiteiServiceShurui09 = shiteiServiceShurui09;
    }

    /**
     * shiteiServiceShurui10のgetメソッドです。
     *
     * @return shiteiServiceShurui10
     */
    public ServiceShuruiCode getShiteiServiceShurui10() {
        return shiteiServiceShurui10;
    }

    /**
     * shiteiServiceShurui10のsetメソッドです。
     *
     * @param shiteiServiceShurui10 shiteiServiceShurui10
     */
    public void setShiteiServiceShurui10(ServiceShuruiCode shiteiServiceShurui10) {
        this.shiteiServiceShurui10 = shiteiServiceShurui10;
    }

    /**
     * shiteiServiceShurui11のgetメソッドです。
     *
     * @return shiteiServiceShurui11
     */
    public ServiceShuruiCode getShiteiServiceShurui11() {
        return shiteiServiceShurui11;
    }

    /**
     * shiteiServiceShurui11のsetメソッドです。
     *
     * @param shiteiServiceShurui11 shiteiServiceShurui11
     */
    public void setShiteiServiceShurui11(ServiceShuruiCode shiteiServiceShurui11) {
        this.shiteiServiceShurui11 = shiteiServiceShurui11;
    }

    /**
     * shiteiServiceShurui12のgetメソッドです。
     *
     * @return shiteiServiceShurui12
     */
    public ServiceShuruiCode getShiteiServiceShurui12() {
        return shiteiServiceShurui12;
    }

    /**
     * shiteiServiceShurui12のsetメソッドです。
     *
     * @param shiteiServiceShurui12 shiteiServiceShurui12
     */
    public void setShiteiServiceShurui12(ServiceShuruiCode shiteiServiceShurui12) {
        this.shiteiServiceShurui12 = shiteiServiceShurui12;
    }

    /**
     * shiteiServiceShurui13のgetメソッドです。
     *
     * @return shiteiServiceShurui13
     */
    public ServiceShuruiCode getShiteiServiceShurui13() {
        return shiteiServiceShurui13;
    }

    /**
     * shiteiServiceShurui13のsetメソッドです。
     *
     * @param shiteiServiceShurui13 shiteiServiceShurui13
     */
    public void setShiteiServiceShurui13(ServiceShuruiCode shiteiServiceShurui13) {
        this.shiteiServiceShurui13 = shiteiServiceShurui13;
    }

    /**
     * shiteiServiceShurui14のgetメソッドです。
     *
     * @return shiteiServiceShurui14
     */
    public ServiceShuruiCode getShiteiServiceShurui14() {
        return shiteiServiceShurui14;
    }

    /**
     * shiteiServiceShurui14のsetメソッドです。
     *
     * @param shiteiServiceShurui14 shiteiServiceShurui14
     */
    public void setShiteiServiceShurui14(ServiceShuruiCode shiteiServiceShurui14) {
        this.shiteiServiceShurui14 = shiteiServiceShurui14;
    }

    /**
     * shiteiServiceShurui15のgetメソッドです。
     *
     * @return shiteiServiceShurui15
     */
    public ServiceShuruiCode getShiteiServiceShurui15() {
        return shiteiServiceShurui15;
    }

    /**
     * shiteiServiceShurui15のsetメソッドです。
     *
     * @param shiteiServiceShurui15 shiteiServiceShurui15
     */
    public void setShiteiServiceShurui15(ServiceShuruiCode shiteiServiceShurui15) {
        this.shiteiServiceShurui15 = shiteiServiceShurui15;
    }

    /**
     * shiteiServiceShurui16のgetメソッドです。
     *
     * @return shiteiServiceShurui16
     */
    public ServiceShuruiCode getShiteiServiceShurui16() {
        return shiteiServiceShurui16;
    }

    /**
     * shiteiServiceShurui16のsetメソッドです。
     *
     * @param shiteiServiceShurui16 shiteiServiceShurui16
     */
    public void setShiteiServiceShurui16(ServiceShuruiCode shiteiServiceShurui16) {
        this.shiteiServiceShurui16 = shiteiServiceShurui16;
    }

    /**
     * shiteiServiceShurui17のgetメソッドです。
     *
     * @return shiteiServiceShurui17
     */
    public ServiceShuruiCode getShiteiServiceShurui17() {
        return shiteiServiceShurui17;
    }

    /**
     * shiteiServiceShurui17のsetメソッドです。
     *
     * @param shiteiServiceShurui17 shiteiServiceShurui17
     */
    public void setShiteiServiceShurui17(ServiceShuruiCode shiteiServiceShurui17) {
        this.shiteiServiceShurui17 = shiteiServiceShurui17;
    }

    /**
     * shiteiServiceShurui18のgetメソッドです。
     *
     * @return shiteiServiceShurui18
     */
    public ServiceShuruiCode getShiteiServiceShurui18() {
        return shiteiServiceShurui18;
    }

    /**
     * shiteiServiceShurui18のsetメソッドです。
     *
     * @param shiteiServiceShurui18 shiteiServiceShurui18
     */
    public void setShiteiServiceShurui18(ServiceShuruiCode shiteiServiceShurui18) {
        this.shiteiServiceShurui18 = shiteiServiceShurui18;
    }

    /**
     * shiteiServiceShurui19のgetメソッドです。
     *
     * @return shiteiServiceShurui19
     */
    public ServiceShuruiCode getShiteiServiceShurui19() {
        return shiteiServiceShurui19;
    }

    /**
     * shiteiServiceShurui19のsetメソッドです。
     *
     * @param shiteiServiceShurui19 shiteiServiceShurui19
     */
    public void setShiteiServiceShurui19(ServiceShuruiCode shiteiServiceShurui19) {
        this.shiteiServiceShurui19 = shiteiServiceShurui19;
    }

    /**
     * shiteiServiceShurui20のgetメソッドです。
     *
     * @return shiteiServiceShurui20
     */
    public ServiceShuruiCode getShiteiServiceShurui20() {
        return shiteiServiceShurui20;
    }

    /**
     * shiteiServiceShurui20のsetメソッドです。
     *
     * @param shiteiServiceShurui20 shiteiServiceShurui20
     */
    public void setShiteiServiceShurui20(ServiceShuruiCode shiteiServiceShurui20) {
        this.shiteiServiceShurui20 = shiteiServiceShurui20;
    }

    /**
     * shiteiServiceShurui21のgetメソッドです。
     *
     * @return shiteiServiceShurui21
     */
    public ServiceShuruiCode getShiteiServiceShurui21() {
        return shiteiServiceShurui21;
    }

    /**
     * shiteiServiceShurui21のsetメソッドです。
     *
     * @param shiteiServiceShurui21 shiteiServiceShurui21
     */
    public void setShiteiServiceShurui21(ServiceShuruiCode shiteiServiceShurui21) {
        this.shiteiServiceShurui21 = shiteiServiceShurui21;
    }

    /**
     * shiteiServiceShurui22のgetメソッドです。
     *
     * @return shiteiServiceShurui22
     */
    public ServiceShuruiCode getShiteiServiceShurui22() {
        return shiteiServiceShurui22;
    }

    /**
     * shiteiServiceShurui22のsetメソッドです。
     *
     * @param shiteiServiceShurui22 shiteiServiceShurui22
     */
    public void setShiteiServiceShurui22(ServiceShuruiCode shiteiServiceShurui22) {
        this.shiteiServiceShurui22 = shiteiServiceShurui22;
    }

    /**
     * shiteiServiceShurui23のgetメソッドです。
     *
     * @return shiteiServiceShurui23
     */
    public ServiceShuruiCode getShiteiServiceShurui23() {
        return shiteiServiceShurui23;
    }

    /**
     * shiteiServiceShurui23のsetメソッドです。
     *
     * @param shiteiServiceShurui23 shiteiServiceShurui23
     */
    public void setShiteiServiceShurui23(ServiceShuruiCode shiteiServiceShurui23) {
        this.shiteiServiceShurui23 = shiteiServiceShurui23;
    }

    /**
     * shiteiServiceShurui24のgetメソッドです。
     *
     * @return shiteiServiceShurui24
     */
    public ServiceShuruiCode getShiteiServiceShurui24() {
        return shiteiServiceShurui24;
    }

    /**
     * shiteiServiceShurui24のsetメソッドです。
     *
     * @param shiteiServiceShurui24 shiteiServiceShurui24
     */
    public void setShiteiServiceShurui24(ServiceShuruiCode shiteiServiceShurui24) {
        this.shiteiServiceShurui24 = shiteiServiceShurui24;
    }

    /**
     * shiteiServiceShurui25のgetメソッドです。
     *
     * @return shiteiServiceShurui25
     */
    public ServiceShuruiCode getShiteiServiceShurui25() {
        return shiteiServiceShurui25;
    }

    /**
     * shiteiServiceShurui25のsetメソッドです。
     *
     * @param shiteiServiceShurui25 shiteiServiceShurui25
     */
    public void setShiteiServiceShurui25(ServiceShuruiCode shiteiServiceShurui25) {
        this.shiteiServiceShurui25 = shiteiServiceShurui25;
    }

    /**
     * shiteiServiceShurui26のgetメソッドです。
     *
     * @return shiteiServiceShurui26
     */
    public ServiceShuruiCode getShiteiServiceShurui26() {
        return shiteiServiceShurui26;
    }

    /**
     * shiteiServiceShurui26のsetメソッドです。
     *
     * @param shiteiServiceShurui26 shiteiServiceShurui26
     */
    public void setShiteiServiceShurui26(ServiceShuruiCode shiteiServiceShurui26) {
        this.shiteiServiceShurui26 = shiteiServiceShurui26;
    }

    /**
     * shiteiServiceShurui27のgetメソッドです。
     *
     * @return shiteiServiceShurui27
     */
    public ServiceShuruiCode getShiteiServiceShurui27() {
        return shiteiServiceShurui27;
    }

    /**
     * shiteiServiceShurui27のsetメソッドです。
     *
     * @param shiteiServiceShurui27 shiteiServiceShurui27
     */
    public void setShiteiServiceShurui27(ServiceShuruiCode shiteiServiceShurui27) {
        this.shiteiServiceShurui27 = shiteiServiceShurui27;
    }

    /**
     * shiteiServiceShurui28のgetメソッドです。
     *
     * @return shiteiServiceShurui28
     */
    public ServiceShuruiCode getShiteiServiceShurui28() {
        return shiteiServiceShurui28;
    }

    /**
     * shiteiServiceShurui28のsetメソッドです。
     *
     * @param shiteiServiceShurui28 shiteiServiceShurui28
     */
    public void setShiteiServiceShurui28(ServiceShuruiCode shiteiServiceShurui28) {
        this.shiteiServiceShurui28 = shiteiServiceShurui28;
    }

    /**
     * shiteiServiceShurui29のgetメソッドです。
     *
     * @return shiteiServiceShurui29
     */
    public ServiceShuruiCode getShiteiServiceShurui29() {
        return shiteiServiceShurui29;
    }

    /**
     * shiteiServiceShurui29のsetメソッドです。
     *
     * @param shiteiServiceShurui29 shiteiServiceShurui29
     */
    public void setShiteiServiceShurui29(ServiceShuruiCode shiteiServiceShurui29) {
        this.shiteiServiceShurui29 = shiteiServiceShurui29;
    }

    /**
     * shiteiServiceShurui30のgetメソッドです。
     *
     * @return shiteiServiceShurui30
     */
    public ServiceShuruiCode getShiteiServiceShurui30() {
        return shiteiServiceShurui30;
    }

    /**
     * shiteiServiceShurui30のsetメソッドです。
     *
     * @param shiteiServiceShurui30 shiteiServiceShurui30
     */
    public void setShiteiServiceShurui30(ServiceShuruiCode shiteiServiceShurui30) {
        this.shiteiServiceShurui30 = shiteiServiceShurui30;
    }

    /**
     * soshitsuYMDのgetメソッドです。
     *
     * @return soshitsuYMD
     */
    public FlexibleDate getSoshitsuYMD() {
        return soshitsuYMD;
    }

    /**
     * soshitsuYMDのsetメソッドです。
     *
     * @param soshitsuYMD soshitsuYMD
     */
    public void setSoshitsuYMD(FlexibleDate soshitsuYMD) {
        this.soshitsuYMD = soshitsuYMD;
    }

    /**
     * chokkinIdoYMDのgetメソッドです。
     *
     * @return chokkinIdoYMD
     */
    public FlexibleDate getChokkinIdoYMD() {
        return chokkinIdoYMD;
    }

    /**
     * chokkinIdoYMDのsetメソッドです。
     *
     * @param chokkinIdoYMD chokkinIdoYMD
     */
    public void setChokkinIdoYMD(FlexibleDate chokkinIdoYMD) {
        this.chokkinIdoYMD = chokkinIdoYMD;
    }

    /**
     * chokkinIdoJiyuCodeのgetメソッドです。
     *
     * @return chokkinIdoJiyuCode
     */
    public Code getChokkinIdoJiyuCode() {
        return chokkinIdoJiyuCode;
    }

    /**
     * chokkinIdoJiyuCodeのsetメソッドです。
     *
     * @param chokkinIdoJiyuCode chokkinIdoJiyuCode
     */
    public void setChokkinIdoJiyuCode(Code chokkinIdoJiyuCode) {
        this.chokkinIdoJiyuCode = chokkinIdoJiyuCode;
    }

    /**
     * yukoMukoKubunのgetメソッドです。
     *
     * @return yukoMukoKubun
     */
    public Code getYukoMukoKubun() {
        return yukoMukoKubun;
    }

    /**
     * yukoMukoKubunのsetメソッドです。
     *
     * @param yukoMukoKubun yukoMukoKubun
     */
    public void setYukoMukoKubun(Code yukoMukoKubun) {
        this.yukoMukoKubun = yukoMukoKubun;
    }

    /**
     * dataKubunのgetメソッドです。
     *
     * @return dataKubun
     */
    public Code getDataKubun() {
        return dataKubun;
    }

    /**
     * dataKubunのsetメソッドです。
     *
     * @param dataKubun dataKubun
     */
    public void setDataKubun(Code dataKubun) {
        this.dataKubun = dataKubun;
    }

    /**
     * rembanのgetメソッドです。
     *
     * @return remban
     */
    public RString getRemban() {
        return remban;
    }

    /**
     * rembanのsetメソッドです。
     *
     * @param remban remban
     */
    public void setRemban(RString remban) {
        this.remban = remban;
    }

    /**
     * idoRiyuのgetメソッドです。
     *
     * @return idoRiyu
     */
    public RString getIdoRiyu() {
        return idoRiyu;
    }

    /**
     * idoRiyuのsetメソッドです。
     *
     * @param idoRiyu idoRiyu
     */
    public void setIdoRiyu(RString idoRiyu) {
        this.idoRiyu = idoRiyu;
    }

    /**
     * shinseishoKubunのgetメソッドです。
     *
     * @return shinseishoKubun
     */
    public Code getShinseishoKubun() {
        return shinseishoKubun;
    }

    /**
     * shinseishoKubunのsetメソッドです。
     *
     * @param shinseishoKubun shinseishoKubun
     */
    public void setShinseishoKubun(Code shinseishoKubun) {
        this.shinseishoKubun = shinseishoKubun;
    }

    /**
     * sakujoJiyuCodeのgetメソッドです。
     *
     * @return sakujoJiyuCode
     */
    public Code getSakujoJiyuCode() {
        return sakujoJiyuCode;
    }

    /**
     * sakujoJiyuCodeのsetメソッドです。
     *
     * @param sakujoJiyuCode sakujoJiyuCode
     */
    public void setSakujoJiyuCode(Code sakujoJiyuCode) {
        this.sakujoJiyuCode = sakujoJiyuCode;
    }

    /**
     * yoshienshaNinteiShinseiFlagのgetメソッドです。
     *
     * @return yoshienshaNinteiShinseiFlag
     */
    public boolean getYoshienshaNinteiShinseiFlag() {
        return yoshienshaNinteiShinseiFlag;
    }

    /**
     * yoshienshaNinteiShinseiFlagのsetメソッドです。
     *
     * @param yoshienshaNinteiShinseiFlag yoshienshaNinteiShinseiFlag
     */
    public void setYoshienshaNinteiShinseiFlag(boolean yoshienshaNinteiShinseiFlag) {
        this.yoshienshaNinteiShinseiFlag = yoshienshaNinteiShinseiFlag;
    }

    /**
     * shikyuGendoTanisuのgetメソッドです。
     *
     * @return shikyuGendoTanisu
     */
    public Decimal getShikyuGendoTanisu() {
        return shikyuGendoTanisu;
    }

    /**
     * shikyuGendoTanisuのsetメソッドです。
     *
     * @param shikyuGendoTanisu shikyuGendoTanisu
     */
    public void setShikyuGendoTanisu(Decimal shikyuGendoTanisu) {
        this.shikyuGendoTanisu = shikyuGendoTanisu;
    }

    /**
     * shikyuGendoKaishiYMDのgetメソッドです。
     *
     * @return shikyuGendoKaishiYMD
     */
    public FlexibleDate getShikyuGendoKaishiYMD() {
        return shikyuGendoKaishiYMD;
    }

    /**
     * shikyuGendoKaishiYMDのsetメソッドです。
     *
     * @param shikyuGendoKaishiYMD shikyuGendoKaishiYMD
     */
    public void setShikyuGendoKaishiYMD(FlexibleDate shikyuGendoKaishiYMD) {
        this.shikyuGendoKaishiYMD = shikyuGendoKaishiYMD;
    }

    /**
     * shikyuGendoShuryoYMDのgetメソッドです。
     *
     * @return shikyuGendoShuryoYMD
     */
    public FlexibleDate getShikyuGendoShuryoYMD() {
        return shikyuGendoShuryoYMD;
    }

    /**
     * shikyuGendoShuryoYMDのsetメソッドです。
     *
     * @param shikyuGendoShuryoYMD shikyuGendoShuryoYMD
     */
    public void setShikyuGendoShuryoYMD(FlexibleDate shikyuGendoShuryoYMD) {
        this.shikyuGendoShuryoYMD = shikyuGendoShuryoYMD;
    }

    /**
     * tankiSikyuGendoNissuのgetメソッドです。
     *
     * @return tankiSikyuGendoNissu
     */
    public int getTankiSikyuGendoNissu() {
        return tankiSikyuGendoNissu;
    }

    /**
     * tankiSikyuGendoNissuのsetメソッドです。
     *
     * @param tankiSikyuGendoNissu tankiSikyuGendoNissu
     */
    public void setTankiSikyuGendoNissu(int tankiSikyuGendoNissu) {
        this.tankiSikyuGendoNissu = tankiSikyuGendoNissu;
    }

    /**
     * tankiShikyuGendoKaishiYMDのgetメソッドです。
     *
     * @return tankiShikyuGendoKaishiYMD
     */
    public FlexibleDate getTankiShikyuGendoKaishiYMD() {
        return tankiShikyuGendoKaishiYMD;
    }

    /**
     * tankiShikyuGendoKaishiYMDのsetメソッドです。
     *
     * @param tankiShikyuGendoKaishiYMD tankiShikyuGendoKaishiYMD
     */
    public void setTankiShikyuGendoKaishiYMD(FlexibleDate tankiShikyuGendoKaishiYMD) {
        this.tankiShikyuGendoKaishiYMD = tankiShikyuGendoKaishiYMD;
    }

    /**
     * tankiShikyuGendoShuryoYMDのgetメソッドです。
     *
     * @return tankiShikyuGendoShuryoYMD
     */
    public FlexibleDate getTankiShikyuGendoShuryoYMD() {
        return tankiShikyuGendoShuryoYMD;
    }

    /**
     * tankiShikyuGendoShuryoYMDのsetメソッドです。
     *
     * @param tankiShikyuGendoShuryoYMD tankiShikyuGendoShuryoYMD
     */
    public void setTankiShikyuGendoShuryoYMD(FlexibleDate tankiShikyuGendoShuryoYMD) {
        this.tankiShikyuGendoShuryoYMD = tankiShikyuGendoShuryoYMD;
    }

    /**
     * toshoNinteiYukoKaishiYMDのgetメソッドです。
     *
     * @return toshoNinteiYukoKaishiYMD
     */
    public FlexibleDate getToshoNinteiYukoKaishiYMD() {
        return toshoNinteiYukoKaishiYMD;
    }

    /**
     * toshoNinteiYukoKaishiYMDのsetメソッドです。
     *
     * @param toshoNinteiYukoKaishiYMD toshoNinteiYukoKaishiYMD
     */
    public void setToshoNinteiYukoKaishiYMD(FlexibleDate toshoNinteiYukoKaishiYMD) {
        this.toshoNinteiYukoKaishiYMD = toshoNinteiYukoKaishiYMD;
    }

    /**
     * toshoNinteiYukoShuryoYMDのgetメソッドです。
     *
     * @return toshoNinteiYukoShuryoYMD
     */
    public FlexibleDate getToshoNinteiYukoShuryoYMD() {
        return toshoNinteiYukoShuryoYMD;
    }

    /**
     * toshoNinteiYukoShuryoYMDのsetメソッドです。
     *
     * @param toshoNinteiYukoShuryoYMD toshoNinteiYukoShuryoYMD
     */
    public void setToshoNinteiYukoShuryoYMD(FlexibleDate toshoNinteiYukoShuryoYMD) {
        this.toshoNinteiYukoShuryoYMD = toshoNinteiYukoShuryoYMD;
    }

    /**
     * jukyuShikakuShomeishoHakkoYMD1のgetメソッドです。
     *
     * @return jukyuShikakuShomeishoHakkoYMD1
     */
    public FlexibleDate getJukyuShikakuShomeishoHakkoYMD1() {
        return jukyuShikakuShomeishoHakkoYMD1;
    }

    /**
     * jukyuShikakuShomeishoHakkoYMD1のsetメソッドです。
     *
     * @param jukyuShikakuShomeishoHakkoYMD1 jukyuShikakuShomeishoHakkoYMD1
     */
    public void setJukyuShikakuShomeishoHakkoYMD1(FlexibleDate jukyuShikakuShomeishoHakkoYMD1) {
        this.jukyuShikakuShomeishoHakkoYMD1 = jukyuShikakuShomeishoHakkoYMD1;
    }

    /**
     * jukyuShikakuShomeishoHakkoYMD2のgetメソッドです。
     *
     * @return jukyuShikakuShomeishoHakkoYMD2
     */
    public FlexibleDate getJukyuShikakuShomeishoHakkoYMD2() {
        return jukyuShikakuShomeishoHakkoYMD2;
    }

    /**
     * jukyuShikakuShomeishoHakkoYMD2のsetメソッドです。
     *
     * @param jukyuShikakuShomeishoHakkoYMD2 jukyuShikakuShomeishoHakkoYMD2
     */
    public void setJukyuShikakuShomeishoHakkoYMD2(FlexibleDate jukyuShikakuShomeishoHakkoYMD2) {
        this.jukyuShikakuShomeishoHakkoYMD2 = jukyuShikakuShomeishoHakkoYMD2;
    }

    /**
     * shindanMeireishoHakkoYMDのgetメソッドです。
     *
     * @return shindanMeireishoHakkoYMD
     */
    public FlexibleDate getShindanMeireishoHakkoYMD() {
        return shindanMeireishoHakkoYMD;
    }

    /**
     * shindanMeireishoHakkoYMDのsetメソッドです。
     *
     * @param shindanMeireishoHakkoYMD shindanMeireishoHakkoYMD
     */
    public void setShindanMeireishoHakkoYMD(FlexibleDate shindanMeireishoHakkoYMD) {
        this.shindanMeireishoHakkoYMD = shindanMeireishoHakkoYMD;
    }

    /**
     * nigoShinseiJuriTsuchishoHakkoYMDのgetメソッドです。
     *
     * @return nigoShinseiJuriTsuchishoHakkoYMD
     */
    public FlexibleDate getNigoShinseiJuriTsuchishoHakkoYMD() {
        return nigoShinseiJuriTsuchishoHakkoYMD;
    }

    /**
     * nigoShinseiJuriTsuchishoHakkoYMDのsetメソッドです。
     *
     * @param nigoShinseiJuriTsuchishoHakkoYMD nigoShinseiJuriTsuchishoHakkoYMD
     */
    public void setNigoShinseiJuriTsuchishoHakkoYMD(FlexibleDate nigoShinseiJuriTsuchishoHakkoYMD) {
        this.nigoShinseiJuriTsuchishoHakkoYMD = nigoShinseiJuriTsuchishoHakkoYMD;
    }

    /**
     * ninteiKekkaTsuchishoHakkoYMDのgetメソッドです。
     *
     * @return ninteiKekkaTsuchishoHakkoYMD
     */
    public FlexibleDate getNinteiKekkaTsuchishoHakkoYMD() {
        return ninteiKekkaTsuchishoHakkoYMD;
    }

    /**
     * ninteiKekkaTsuchishoHakkoYMDのsetメソッドです。
     *
     * @param ninteiKekkaTsuchishoHakkoYMD ninteiKekkaTsuchishoHakkoYMD
     */
    public void setNinteiKekkaTsuchishoHakkoYMD(FlexibleDate ninteiKekkaTsuchishoHakkoYMD) {
        this.ninteiKekkaTsuchishoHakkoYMD = ninteiKekkaTsuchishoHakkoYMD;
    }

    /**
     * kubunHenkoTsuchishoHakkoYMDのgetメソッドです。
     *
     * @return kubunHenkoTsuchishoHakkoYMD
     */
    public FlexibleDate getKubunHenkoTsuchishoHakkoYMD() {
        return kubunHenkoTsuchishoHakkoYMD;
    }

    /**
     * kubunHenkoTsuchishoHakkoYMDのsetメソッドです。
     *
     * @param kubunHenkoTsuchishoHakkoYMD kubunHenkoTsuchishoHakkoYMD
     */
    public void setKubunHenkoTsuchishoHakkoYMD(FlexibleDate kubunHenkoTsuchishoHakkoYMD) {
        this.kubunHenkoTsuchishoHakkoYMD = kubunHenkoTsuchishoHakkoYMD;
    }

    /**
     * serviceHenkoTsuchishoHakkoYMDのgetメソッドです。
     *
     * @return serviceHenkoTsuchishoHakkoYMD
     */
    public FlexibleDate getServiceHenkoTsuchishoHakkoYMD() {
        return serviceHenkoTsuchishoHakkoYMD;
    }

    /**
     * serviceHenkoTsuchishoHakkoYMDのsetメソッドです。
     *
     * @param serviceHenkoTsuchishoHakkoYMD serviceHenkoTsuchishoHakkoYMD
     */
    public void setServiceHenkoTsuchishoHakkoYMD(FlexibleDate serviceHenkoTsuchishoHakkoYMD) {
        this.serviceHenkoTsuchishoHakkoYMD = serviceHenkoTsuchishoHakkoYMD;
    }

    /**
     * ninteiKyakkaTsuchishoHakkoYMDのgetメソッドです。
     *
     * @return ninteiKyakkaTsuchishoHakkoYMD
     */
    public FlexibleDate getNinteiKyakkaTsuchishoHakkoYMD() {
        return ninteiKyakkaTsuchishoHakkoYMD;
    }

    /**
     * ninteiKyakkaTsuchishoHakkoYMDのsetメソッドです。
     *
     * @param ninteiKyakkaTsuchishoHakkoYMD ninteiKyakkaTsuchishoHakkoYMD
     */
    public void setNinteiKyakkaTsuchishoHakkoYMD(FlexibleDate ninteiKyakkaTsuchishoHakkoYMD) {
        this.ninteiKyakkaTsuchishoHakkoYMD = ninteiKyakkaTsuchishoHakkoYMD;
    }

    /**
     * ninteiTorikeshiTsuchishoHakkoYMDのgetメソッドです。
     *
     * @return ninteiTorikeshiTsuchishoHakkoYMD
     */
    public FlexibleDate getNinteiTorikeshiTsuchishoHakkoYMD() {
        return ninteiTorikeshiTsuchishoHakkoYMD;
    }

    /**
     * ninteiTorikeshiTsuchishoHakkoYMDのsetメソッドです。
     *
     * @param ninteiTorikeshiTsuchishoHakkoYMD ninteiTorikeshiTsuchishoHakkoYMD
     */
    public void setNinteiTorikeshiTsuchishoHakkoYMD(FlexibleDate ninteiTorikeshiTsuchishoHakkoYMD) {
        this.ninteiTorikeshiTsuchishoHakkoYMD = ninteiTorikeshiTsuchishoHakkoYMD;
    }

    /**
     * shikakuShutokuMaeShinseiFlagのgetメソッドです。
     *
     * @return shikakuShutokuMaeShinseiFlag
     */
    public boolean getShikakuShutokuMaeShinseiFlag() {
        return shikakuShutokuMaeShinseiFlag;
    }

    /**
     * shikakuShutokuMaeShinseiFlagのsetメソッドです。
     *
     * @param shikakuShutokuMaeShinseiFlag shikakuShutokuMaeShinseiFlag
     */
    public void setShikakuShutokuMaeShinseiFlag(boolean shikakuShutokuMaeShinseiFlag) {
        this.shikakuShutokuMaeShinseiFlag = shikakuShutokuMaeShinseiFlag;
    }

    /**
     * kyuSochishaFlagのgetメソッドです。
     *
     * @return kyuSochishaFlag
     */
    public boolean getKyuSochishaFlag() {
        return kyuSochishaFlag;
    }

    /**
     * kyuSochishaFlagのsetメソッドです。
     *
     * @param kyuSochishaFlag kyuSochishaFlag
     */
    public void setKyuSochishaFlag(boolean kyuSochishaFlag) {
        this.kyuSochishaFlag = kyuSochishaFlag;
    }

    /**
     * logicalDeletedFlagのgetメソッドです。
     *
     * @return logicalDeletedFlag
     */
    public boolean getLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    /**
     * logicalDeletedFlagのsetメソッドです。
     *
     * @param logicalDeletedFlag logicalDeletedFlag
     */
    public void setLogicalDeletedFlag(boolean logicalDeletedFlag) {
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV4001JukyushaDaichoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbV4001JukyushaDaichoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV4001JukyushaDaichoEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV4001JukyushaDaichoEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.edaban = entity.edaban;
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.shinseiJokyoKubun = entity.shinseiJokyoKubun;
        this.shishoCode = entity.shishoCode;
        this.chokkinFlag = entity.chokkinFlag;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.jukyuShinseiJiyu = entity.jukyuShinseiJiyu;
        this.shinseiRiyu = entity.shinseiRiyu;
        this.shinseishaKankeiCode = entity.shinseishaKankeiCode;
        this.homninKankei = entity.homninKankei;
        this.jukyuShinseiYMD = entity.jukyuShinseiYMD;
        this.nigoTokuteiShippeiCode = entity.nigoTokuteiShippeiCode;
        this.shinsakaiIraiYMD = entity.shinsakaiIraiYMD;
        this.yokaigoJotaiKubunCode = entity.yokaigoJotaiKubunCode;
        this.ninteiYukoKikanKaishiYMD = entity.ninteiYukoKikanKaishiYMD;
        this.ninteiYukoKikanShuryoYMD = entity.ninteiYukoKikanShuryoYMD;
        this.ninteiYMD = entity.ninteiYMD;
        this.shiteiServiceShurui01 = entity.shiteiServiceShurui01;
        this.shiteiServiceShurui02 = entity.shiteiServiceShurui02;
        this.shiteiServiceShurui03 = entity.shiteiServiceShurui03;
        this.shiteiServiceShurui04 = entity.shiteiServiceShurui04;
        this.shiteiServiceShurui05 = entity.shiteiServiceShurui05;
        this.shiteiServiceShurui06 = entity.shiteiServiceShurui06;
        this.shiteiServiceShurui07 = entity.shiteiServiceShurui07;
        this.shiteiServiceShurui08 = entity.shiteiServiceShurui08;
        this.shiteiServiceShurui09 = entity.shiteiServiceShurui09;
        this.shiteiServiceShurui10 = entity.shiteiServiceShurui10;
        this.shiteiServiceShurui11 = entity.shiteiServiceShurui11;
        this.shiteiServiceShurui12 = entity.shiteiServiceShurui12;
        this.shiteiServiceShurui13 = entity.shiteiServiceShurui13;
        this.shiteiServiceShurui14 = entity.shiteiServiceShurui14;
        this.shiteiServiceShurui15 = entity.shiteiServiceShurui15;
        this.shiteiServiceShurui16 = entity.shiteiServiceShurui16;
        this.shiteiServiceShurui17 = entity.shiteiServiceShurui17;
        this.shiteiServiceShurui18 = entity.shiteiServiceShurui18;
        this.shiteiServiceShurui19 = entity.shiteiServiceShurui19;
        this.shiteiServiceShurui20 = entity.shiteiServiceShurui20;
        this.shiteiServiceShurui21 = entity.shiteiServiceShurui21;
        this.shiteiServiceShurui22 = entity.shiteiServiceShurui22;
        this.shiteiServiceShurui23 = entity.shiteiServiceShurui23;
        this.shiteiServiceShurui24 = entity.shiteiServiceShurui24;
        this.shiteiServiceShurui25 = entity.shiteiServiceShurui25;
        this.shiteiServiceShurui26 = entity.shiteiServiceShurui26;
        this.shiteiServiceShurui27 = entity.shiteiServiceShurui27;
        this.shiteiServiceShurui28 = entity.shiteiServiceShurui28;
        this.shiteiServiceShurui29 = entity.shiteiServiceShurui29;
        this.shiteiServiceShurui30 = entity.shiteiServiceShurui30;
        this.soshitsuYMD = entity.soshitsuYMD;
        this.chokkinIdoYMD = entity.chokkinIdoYMD;
        this.chokkinIdoJiyuCode = entity.chokkinIdoJiyuCode;
        this.yukoMukoKubun = entity.yukoMukoKubun;
        this.dataKubun = entity.dataKubun;
        this.remban = entity.remban;
        this.idoRiyu = entity.idoRiyu;
        this.shinseishoKubun = entity.shinseishoKubun;
        this.sakujoJiyuCode = entity.sakujoJiyuCode;
        this.yoshienshaNinteiShinseiFlag = entity.yoshienshaNinteiShinseiFlag;
        this.shikyuGendoTanisu = entity.shikyuGendoTanisu;
        this.shikyuGendoKaishiYMD = entity.shikyuGendoKaishiYMD;
        this.shikyuGendoShuryoYMD = entity.shikyuGendoShuryoYMD;
        this.tankiSikyuGendoNissu = entity.tankiSikyuGendoNissu;
        this.tankiShikyuGendoKaishiYMD = entity.tankiShikyuGendoKaishiYMD;
        this.tankiShikyuGendoShuryoYMD = entity.tankiShikyuGendoShuryoYMD;
        this.toshoNinteiYukoKaishiYMD = entity.toshoNinteiYukoKaishiYMD;
        this.toshoNinteiYukoShuryoYMD = entity.toshoNinteiYukoShuryoYMD;
        this.jukyuShikakuShomeishoHakkoYMD1 = entity.jukyuShikakuShomeishoHakkoYMD1;
        this.jukyuShikakuShomeishoHakkoYMD2 = entity.jukyuShikakuShomeishoHakkoYMD2;
        this.shindanMeireishoHakkoYMD = entity.shindanMeireishoHakkoYMD;
        this.nigoShinseiJuriTsuchishoHakkoYMD = entity.nigoShinseiJuriTsuchishoHakkoYMD;
        this.ninteiKekkaTsuchishoHakkoYMD = entity.ninteiKekkaTsuchishoHakkoYMD;
        this.kubunHenkoTsuchishoHakkoYMD = entity.kubunHenkoTsuchishoHakkoYMD;
        this.serviceHenkoTsuchishoHakkoYMD = entity.serviceHenkoTsuchishoHakkoYMD;
        this.ninteiKyakkaTsuchishoHakkoYMD = entity.ninteiKyakkaTsuchishoHakkoYMD;
        this.ninteiTorikeshiTsuchishoHakkoYMD = entity.ninteiTorikeshiTsuchishoHakkoYMD;
        this.shikakuShutokuMaeShinseiFlag = entity.shikakuShutokuMaeShinseiFlag;
        this.kyuSochishaFlag = entity.kyuSochishaFlag;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, hihokenshaNo, rirekiNo, edaban, shinseishoKanriNo, shinseiJokyoKubun, shishoCode, chokkinFlag, shikibetsuCode, jukyuShinseiJiyu, shinseiRiyu, shinseishaKankeiCode, homninKankei, jukyuShinseiYMD, nigoTokuteiShippeiCode, shinsakaiIraiYMD, yokaigoJotaiKubunCode, ninteiYukoKikanKaishiYMD, ninteiYukoKikanShuryoYMD, ninteiYMD, shiteiServiceShurui01, shiteiServiceShurui02, shiteiServiceShurui03, shiteiServiceShurui04, shiteiServiceShurui05, shiteiServiceShurui06, shiteiServiceShurui07, shiteiServiceShurui08, shiteiServiceShurui09, shiteiServiceShurui10, shiteiServiceShurui11, shiteiServiceShurui12, shiteiServiceShurui13, shiteiServiceShurui14, shiteiServiceShurui15, shiteiServiceShurui16, shiteiServiceShurui17, shiteiServiceShurui18, shiteiServiceShurui19, shiteiServiceShurui20, shiteiServiceShurui21, shiteiServiceShurui22, shiteiServiceShurui23, shiteiServiceShurui24, shiteiServiceShurui25, shiteiServiceShurui26, shiteiServiceShurui27, shiteiServiceShurui28, shiteiServiceShurui29, shiteiServiceShurui30, soshitsuYMD, chokkinIdoYMD, chokkinIdoJiyuCode, yukoMukoKubun, dataKubun, remban, idoRiyu, shinseishoKubun, sakujoJiyuCode, yoshienshaNinteiShinseiFlag, shikyuGendoTanisu, shikyuGendoKaishiYMD, shikyuGendoShuryoYMD, tankiSikyuGendoNissu, tankiShikyuGendoKaishiYMD, tankiShikyuGendoShuryoYMD, toshoNinteiYukoKaishiYMD, toshoNinteiYukoShuryoYMD, jukyuShikakuShomeishoHakkoYMD1, jukyuShikakuShomeishoHakkoYMD2, shindanMeireishoHakkoYMD, nigoShinseiJuriTsuchishoHakkoYMD, ninteiKekkaTsuchishoHakkoYMD, kubunHenkoTsuchishoHakkoYMD, serviceHenkoTsuchishoHakkoYMD, ninteiKyakkaTsuchishoHakkoYMD, ninteiTorikeshiTsuchishoHakkoYMD, shikakuShutokuMaeShinseiFlag, kyuSochishaFlag, logicalDeletedFlag);
    }

// </editor-fold>
}
