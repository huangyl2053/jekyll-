package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * DbTKyufukanrihyoDataTempTableの項目定義クラスです
 *
 */
@OnNextSchema("rgdb")
public class DbTKyufukanrihyoDataTempTableEntity extends DbTableEntityBase<DbTKyufukanrihyoDataTempTableEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">

    @TableName
    public static final RString TABLE_NAME = new RString("DbTKyufukanrihyoDataTempTable");

    @TempTableColumnOrder(1)
    private RString recordShubetsu;
    @TempTableColumnOrder(2)
    private RString renban;
    @TempTableColumnOrder(3)
    private RString kokanjohoShikibetsuNo;
    @TempTableColumnOrder(4)
    private RString chohyoRecordShubetsu;
    @TempTableColumnOrder(5)
    private RString shinsaYM;
    @TempTableColumnOrder(6)
    private RString taishoYM;
    @TempTableColumnOrder(7)
    private RString hokenshaNo;
    @TempTableColumnOrder(8)
    private RString KyotakuShienJigyoshoNo;
    @TempTableColumnOrder(9)
    private RString kyufukanrihyoSakuseiKubunCode;
    @TempTableColumnOrder(10)
    private RString kyufukanrihyoSakuseiYMD;
    @TempTableColumnOrder(11)
    private RString kyufukanrihyoShubetsuKubunCode;
    @TempTableColumnOrder(12)
    private RString kyufukanrihyoMeisaigyoNo;
    @TempTableColumnOrder(13)
    private RString hihokenshaNo;
    @TempTableColumnOrder(14)
    private RString seinengappiYMD;
    @TempTableColumnOrder(15)
    private RString seibetsuCode;
    @TempTableColumnOrder(16)
    private RString yokaigojotaiKubunCode;
    @TempTableColumnOrder(17)
    private RString gendogakuTekiyoKaishiYMD;
    @TempTableColumnOrder(18)
    private RString gendogakuTekiyoShuryoYMD;
    @TempTableColumnOrder(19)
    private RString kyotakuKaigoyoboShikyugendogaku;
    @TempTableColumnOrder(20)
    private RString kyotakuKeikakuSakuseiKubunCode;
    @TempTableColumnOrder(21)
    private RString serviceTeikyoJigyoshoNo;
    @TempTableColumnOrder(22)
    private RString shiteiKijunGaitoJigyoshoKubunCode;
    @TempTableColumnOrder(23)
    private RString serviceShuruiCode;
    @TempTableColumnOrder(24)
    private RString kyufuKeikakuTanisuNissu;
    @TempTableColumnOrder(25)
    private RString zentsukiMadeKyufuKeikakuNissu;
    @TempTableColumnOrder(26)
    private RString shiteiServiceShokei;
    @TempTableColumnOrder(27)
    private RString kijunGaitoServiceShokei;
    @TempTableColumnOrder(28)
    private RString kyufuKeikakuGokeiTanisuNissu;
    @TempTableColumnOrder(29)
    private RString kaigoshienSenmoninNo;
    @TempTableColumnOrder(30)
    private RString itakusakiKyotakuKaigoshienJigyoshoNo;
    @TempTableColumnOrder(31)
    private RString itakusakiKaigoshienSenmoninNo;
    @TempTableColumnOrder(32)
    private RString hihoNoHenkanShichosonCode;
    @TempTableColumnOrder(33)
    private RString shinHihokenshaNo;
    @TempTableColumnOrder(34)
    private RString shichosonCode;
    @TempTableColumnOrder(35)
    private RString koikiJutokuSochimotoShichosonCode;
    @TempTableColumnOrder(36)
    private RString kyoShichosonCode;
    @TempTableColumnOrder(37)
    private RString shikibetsuCode;
    @TempTableColumnOrder(38)
    private RString kanjiMeisho;
    @TempTableColumnOrder(39)
    private RString jigyoshoMeisho;
    @TempTableColumnOrder(40)
    private RString shokisaiHokenshaNo;

    /**
     * getRecordShubetsu
     *
     * @return recordShubetsu
     */
    public RString getRecordShubetsu() {
        return recordShubetsu;
    }

    /**
     * setRecordShubetsu
     *
     * @param recordShubetsu recordShubetsu
     */
    public void setRecordShubetsu(RString recordShubetsu) {
        this.recordShubetsu = recordShubetsu;
    }

    /**
     * getRenban
     *
     * @return renban
     */
    public RString getRenban() {
        return renban;
    }

    /**
     * setRenban
     *
     * @param renban renban
     */
    public void setRenban(RString renban) {
        this.renban = renban;
    }

    /**
     * getKokanjohoShikibetsuNo
     *
     * @return kokanjohoShikibetsuNo
     */
    public RString getKokanjohoShikibetsuNo() {
        return kokanjohoShikibetsuNo;
    }

    /**
     * setKokanjohoShikibetsuNo
     *
     * @param kokanjohoShikibetsuNo kokanjohoShikibetsuNo
     */
    public void setKokanjohoShikibetsuNo(RString kokanjohoShikibetsuNo) {
        this.kokanjohoShikibetsuNo = kokanjohoShikibetsuNo;
    }

    /**
     * getChohyoRecordShubetsu
     *
     * @return chohyoRecordShubetsu
     */
    public RString getChohyoRecordShubetsu() {
        return chohyoRecordShubetsu;
    }

    /**
     * setChohyoRecordShubetsu
     *
     * @param chohyoRecordShubetsu chohyoRecordShubetsu
     */
    public void setChohyoRecordShubetsu(RString chohyoRecordShubetsu) {
        this.chohyoRecordShubetsu = chohyoRecordShubetsu;
    }

    /**
     * getShinsaYM
     *
     * @return shinsaYM
     */
    public RString getShinsaYM() {
        return shinsaYM;
    }

    /**
     * setShinsaYM
     *
     * @param shinsaYM shinsaYM
     */
    public void setShinsaYM(RString shinsaYM) {
        this.shinsaYM = shinsaYM;
    }

    /**
     * getTaishoYM
     *
     * @return taishoYM
     */
    public RString getTaishoYM() {
        return taishoYM;
    }

    /**
     * setTaishoYM
     *
     * @param taishoYM taishoYM
     */
    public void setTaishoYM(RString taishoYM) {
        this.taishoYM = taishoYM;
    }

    /**
     * getHokenshaNo
     *
     * @return hokenshaNo
     */
    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * setHokenshaNo
     *
     * @param hokenshaNo hokenshaNo
     */
    public void setHokenshaNo(RString hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
    }

    /**
     * getKyotakuShienJigyoshoNo
     *
     * @return KyotakuShienJigyoshoNo
     */
    public RString getKyotakuShienJigyoshoNo() {
        return KyotakuShienJigyoshoNo;
    }

    /**
     * setKyotakuShienJigyoshoNo
     *
     * @param KyotakuShienJigyoshoNo KyotakuShienJigyoshoNo
     */
    public void setKyotakuShienJigyoshoNo(RString KyotakuShienJigyoshoNo) {
        this.KyotakuShienJigyoshoNo = KyotakuShienJigyoshoNo;
    }

    /**
     * getKyufukanrihyoSakuseiKubunCode
     *
     * @return kyufukanrihyoSakuseiKubunCode
     */
    public RString getKyufukanrihyoSakuseiKubunCode() {
        return kyufukanrihyoSakuseiKubunCode;
    }

    /**
     * setKyufukanrihyoSakuseiKubunCode
     *
     * @param kyufukanrihyoSakuseiKubunCode kyufukanrihyoSakuseiKubunCode
     */
    public void setKyufukanrihyoSakuseiKubunCode(RString kyufukanrihyoSakuseiKubunCode) {
        this.kyufukanrihyoSakuseiKubunCode = kyufukanrihyoSakuseiKubunCode;
    }

    /**
     * getKyufukanrihyoSakuseiYMD
     *
     * @return kyufukanrihyoSakuseiYMD
     */
    public RString getKyufukanrihyoSakuseiYMD() {
        return kyufukanrihyoSakuseiYMD;
    }

    /**
     * setKyufukanrihyoSakuseiYMD
     *
     * @param kyufukanrihyoSakuseiYMD kyufukanrihyoSakuseiYMD
     */
    public void setKyufukanrihyoSakuseiYMD(RString kyufukanrihyoSakuseiYMD) {
        this.kyufukanrihyoSakuseiYMD = kyufukanrihyoSakuseiYMD;
    }

    /**
     * getKyufukanrihyoShubetsuKubunCode
     *
     * @return kyufukanrihyoShubetsuKubunCode
     */
    public RString getKyufukanrihyoShubetsuKubunCode() {
        return kyufukanrihyoShubetsuKubunCode;
    }

    /**
     * setKyufukanrihyoShubetsuKubunCode
     *
     * @param kyufukanrihyoShubetsuKubunCode kyufukanrihyoShubetsuKubunCode
     */
    public void setKyufukanrihyoShubetsuKubunCode(RString kyufukanrihyoShubetsuKubunCode) {
        this.kyufukanrihyoShubetsuKubunCode = kyufukanrihyoShubetsuKubunCode;
    }

    /**
     * getKyufukanrihyoMeisaigyoNo
     *
     * @return kyufukanrihyoMeisaigyoNo
     */
    public RString getKyufukanrihyoMeisaigyoNo() {
        return kyufukanrihyoMeisaigyoNo;
    }

    /**
     * setKyufukanrihyoMeisaigyoNo
     *
     * @param kyufukanrihyoMeisaigyoNo kyufukanrihyoMeisaigyoNo
     */
    public void setKyufukanrihyoMeisaigyoNo(RString kyufukanrihyoMeisaigyoNo) {
        this.kyufukanrihyoMeisaigyoNo = kyufukanrihyoMeisaigyoNo;
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
     * getSeinengappiYMD
     *
     * @return seinengappiYMD
     */
    public RString getSeinengappiYMD() {
        return seinengappiYMD;
    }

    /**
     * setSeinengappiYMD
     *
     * @param seinengappiYMD seinengappiYMD
     */
    public void setSeinengappiYMD(RString seinengappiYMD) {
        this.seinengappiYMD = seinengappiYMD;
    }

    /**
     * getSeibetsuCode
     *
     * @return seibetsuCode
     */
    public RString getSeibetsuCode() {
        return seibetsuCode;
    }

    /**
     * setSeibetsuCode
     *
     * @param seibetsuCode seibetsuCode
     */
    public void setSeibetsuCode(RString seibetsuCode) {
        this.seibetsuCode = seibetsuCode;
    }

    /**
     * getYokaigojotaiKubunCode
     *
     * @return yokaigojotaiKubunCode
     */
    public RString getYokaigojotaiKubunCode() {
        return yokaigojotaiKubunCode;
    }

    /**
     * setYokaigojotaiKubunCode
     *
     * @param yokaigojotaiKubunCode yokaigojotaiKubunCode
     */
    public void setYokaigojotaiKubunCode(RString yokaigojotaiKubunCode) {
        this.yokaigojotaiKubunCode = yokaigojotaiKubunCode;
    }

    /**
     * getGendogakuTekiyoKaishiYMD
     *
     * @return gendogakuTekiyoKaishiYMD
     */
    public RString getGendogakuTekiyoKaishiYMD() {
        return gendogakuTekiyoKaishiYMD;
    }

    /**
     * setGendogakuTekiyoKaishiYMD
     *
     * @param gendogakuTekiyoKaishiYMD gendogakuTekiyoKaishiYMD
     */
    public void setGendogakuTekiyoKaishiYMD(RString gendogakuTekiyoKaishiYMD) {
        this.gendogakuTekiyoKaishiYMD = gendogakuTekiyoKaishiYMD;
    }

    /**
     * getGendogakuTekiyoShuryoYMD
     *
     * @return gendogakuTekiyoShuryoYMD
     */
    public RString getGendogakuTekiyoShuryoYMD() {
        return gendogakuTekiyoShuryoYMD;
    }

    /**
     * setGendogakuTekiyoShuryoYMD
     *
     * @param gendogakuTekiyoShuryoYMD gendogakuTekiyoShuryoYMD
     */
    public void setGendogakuTekiyoShuryoYMD(RString gendogakuTekiyoShuryoYMD) {
        this.gendogakuTekiyoShuryoYMD = gendogakuTekiyoShuryoYMD;
    }

    /**
     * getKyotakuKaigoyoboShikyugendogaku
     *
     * @return kyotakuKaigoyoboShikyugendogaku
     */
    public RString getKyotakuKaigoyoboShikyugendogaku() {
        return kyotakuKaigoyoboShikyugendogaku;
    }

    /**
     * setKyotakuKaigoyoboShikyugendogaku
     *
     * @param kyotakuKaigoyoboShikyugendogaku kyotakuKaigoyoboShikyugendogaku
     */
    public void setKyotakuKaigoyoboShikyugendogaku(RString kyotakuKaigoyoboShikyugendogaku) {
        this.kyotakuKaigoyoboShikyugendogaku = kyotakuKaigoyoboShikyugendogaku;
    }

    /**
     * getKyotakuKeikakuSakuseiKubunCode
     *
     * @return kyotakuKeikakuSakuseiKubunCode
     */
    public RString getKyotakuKeikakuSakuseiKubunCode() {
        return kyotakuKeikakuSakuseiKubunCode;
    }

    /**
     * setKyotakuKeikakuSakuseiKubunCode
     *
     * @param kyotakuKeikakuSakuseiKubunCode kyotakuKeikakuSakuseiKubunCode
     */
    public void setKyotakuKeikakuSakuseiKubunCode(RString kyotakuKeikakuSakuseiKubunCode) {
        this.kyotakuKeikakuSakuseiKubunCode = kyotakuKeikakuSakuseiKubunCode;
    }

    /**
     * getServiceTeikyoJigyoshoNo
     *
     * @return serviceTeikyoJigyoshoNo
     */
    public RString getServiceTeikyoJigyoshoNo() {
        return serviceTeikyoJigyoshoNo;
    }

    /**
     * setServiceTeikyoJigyoshoNo
     *
     * @param serviceTeikyoJigyoshoNo serviceTeikyoJigyoshoNo
     */
    public void setServiceTeikyoJigyoshoNo(RString serviceTeikyoJigyoshoNo) {
        this.serviceTeikyoJigyoshoNo = serviceTeikyoJigyoshoNo;
    }

    /**
     * getShiteiKijunGaitoJigyoshoKubunCode
     *
     * @return shiteiKijunGaitoJigyoshoKubunCode
     */
    public RString getShiteiKijunGaitoJigyoshoKubunCode() {
        return shiteiKijunGaitoJigyoshoKubunCode;
    }

    /**
     * setShiteiKijunGaitoJigyoshoKubunCode
     *
     * @param shiteiKijunGaitoJigyoshoKubunCode shiteiKijunGaitoJigyoshoKubunCode
     */
    public void setShiteiKijunGaitoJigyoshoKubunCode(RString shiteiKijunGaitoJigyoshoKubunCode) {
        this.shiteiKijunGaitoJigyoshoKubunCode = shiteiKijunGaitoJigyoshoKubunCode;
    }

    /**
     * getServiceShuruiCode
     *
     * @return serviceShuruiCode
     */
    public RString getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * setServiceShuruiCode
     *
     * @param serviceShuruiCode serviceShuruiCode
     */
    public void setServiceShuruiCode(RString serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * getKyufuKeikakuTanisuNissu
     *
     * @return kyufuKeikakuTanisuNissu
     */
    public RString getKyufuKeikakuTanisuNissu() {
        return kyufuKeikakuTanisuNissu;
    }

    /**
     * setKyufuKeikakuTanisuNissu
     *
     * @param kyufuKeikakuTanisuNissu kyufuKeikakuTanisuNissu
     */
    public void setKyufuKeikakuTanisuNissu(RString kyufuKeikakuTanisuNissu) {
        this.kyufuKeikakuTanisuNissu = kyufuKeikakuTanisuNissu;
    }

    /**
     * getZentsukiMadeKyufuKeikakuNissu
     *
     * @return zentsukiMadeKyufuKeikakuNissu
     */
    public RString getZentsukiMadeKyufuKeikakuNissu() {
        return zentsukiMadeKyufuKeikakuNissu;
    }

    /**
     * setZentsukiMadeKyufuKeikakuNissu
     *
     * @param zentsukiMadeKyufuKeikakuNissu zentsukiMadeKyufuKeikakuNissu
     */
    public void setZentsukiMadeKyufuKeikakuNissu(RString zentsukiMadeKyufuKeikakuNissu) {
        this.zentsukiMadeKyufuKeikakuNissu = zentsukiMadeKyufuKeikakuNissu;
    }

    /**
     * getShiteiServiceShokei
     *
     * @return shiteiServiceShokei
     */
    public RString getShiteiServiceShokei() {
        return shiteiServiceShokei;
    }

    /**
     * setShiteiServiceShokei
     *
     * @param shiteiServiceShokei shiteiServiceShokei
     */
    public void setShiteiServiceShokei(RString shiteiServiceShokei) {
        this.shiteiServiceShokei = shiteiServiceShokei;
    }

    /**
     * getKijunGaitoServiceShokei
     *
     * @return kijunGaitoServiceShokei
     */
    public RString getKijunGaitoServiceShokei() {
        return kijunGaitoServiceShokei;
    }

    /**
     * setKijunGaitoServiceShokei
     *
     * @param kijunGaitoServiceShokei kijunGaitoServiceShokei
     */
    public void setKijunGaitoServiceShokei(RString kijunGaitoServiceShokei) {
        this.kijunGaitoServiceShokei = kijunGaitoServiceShokei;
    }

    /**
     * getKyufuKeikakuGokeiTanisuNissu
     *
     * @return kyufuKeikakuGokeiTanisuNissu
     */
    public RString getKyufuKeikakuGokeiTanisuNissu() {
        return kyufuKeikakuGokeiTanisuNissu;
    }

    /**
     * setKyufuKeikakuGokeiTanisuNissu
     *
     * @param kyufuKeikakuGokeiTanisuNissu kyufuKeikakuGokeiTanisuNissu
     */
    public void setKyufuKeikakuGokeiTanisuNissu(RString kyufuKeikakuGokeiTanisuNissu) {
        this.kyufuKeikakuGokeiTanisuNissu = kyufuKeikakuGokeiTanisuNissu;
    }

    /**
     * getKaigoshienSenmoninNo
     *
     * @return kaigoshienSenmoninNo
     */
    public RString getKaigoshienSenmoninNo() {
        return kaigoshienSenmoninNo;
    }

    /**
     * setKaigoshienSenmoninNo
     *
     * @param kaigoshienSenmoninNo kaigoshienSenmoninNo
     */
    public void setKaigoshienSenmoninNo(RString kaigoshienSenmoninNo) {
        this.kaigoshienSenmoninNo = kaigoshienSenmoninNo;
    }

    /**
     * getItakusakiKyotakuKaigoshienJigyoshoNo
     *
     * @return itakusakiKyotakuKaigoshienJigyoshoNo
     */
    public RString getItakusakiKyotakuKaigoshienJigyoshoNo() {
        return itakusakiKyotakuKaigoshienJigyoshoNo;
    }

    /**
     * setItakusakiKyotakuKaigoshienJigyoshoNo
     *
     * @param itakusakiKyotakuKaigoshienJigyoshoNo itakusakiKyotakuKaigoshienJigyoshoNo
     */
    public void setItakusakiKyotakuKaigoshienJigyoshoNo(RString itakusakiKyotakuKaigoshienJigyoshoNo) {
        this.itakusakiKyotakuKaigoshienJigyoshoNo = itakusakiKyotakuKaigoshienJigyoshoNo;
    }

    /**
     * getItakusakiKaigoshienSenmoninNo
     *
     * @return itakusakiKaigoshienSenmoninNo
     */
    public RString getItakusakiKaigoshienSenmoninNo() {
        return itakusakiKaigoshienSenmoninNo;
    }

    /**
     * setItakusakiKaigoshienSenmoninNo
     *
     * @param itakusakiKaigoshienSenmoninNo itakusakiKaigoshienSenmoninNo
     */
    public void setItakusakiKaigoshienSenmoninNo(RString itakusakiKaigoshienSenmoninNo) {
        this.itakusakiKaigoshienSenmoninNo = itakusakiKaigoshienSenmoninNo;
    }

    /**
     * getHihoNoHenkanShichosonCode
     *
     * @return hihoNoHenkanShichosonCode
     */
    public RString getHihoNoHenkanShichosonCode() {
        return hihoNoHenkanShichosonCode;
    }

    /**
     * setHihoNoHenkanShichosonCode
     *
     * @param hihoNoHenkanShichosonCode hihoNoHenkanShichosonCode
     */
    public void setHihoNoHenkanShichosonCode(RString hihoNoHenkanShichosonCode) {
        this.hihoNoHenkanShichosonCode = hihoNoHenkanShichosonCode;
    }

    /**
     * getShinHihokenshaNo
     *
     * @return shinHihokenshaNo
     */
    public RString getShinHihokenshaNo() {
        return shinHihokenshaNo;
    }

    /**
     * setShinHihokenshaNo
     *
     * @param shinHihokenshaNo shinHihokenshaNo
     */
    public void setShinHihokenshaNo(RString shinHihokenshaNo) {
        this.shinHihokenshaNo = shinHihokenshaNo;
    }

    /**
     * getShichosonCode
     *
     * @return shichosonCode
     */
    public RString getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     *
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(RString shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * getKoikiJutokuSochimotoShichosonCode
     *
     * @return koikiJutokuSochimotoShichosonCode
     */
    public RString getKoikiJutokuSochimotoShichosonCode() {
        return koikiJutokuSochimotoShichosonCode;
    }

    /**
     * setKoikiJutokuSochimotoShichosonCode
     *
     * @param koikiJutokuSochimotoShichosonCode koikiJutokuSochimotoShichosonCode
     */
    public void setKoikiJutokuSochimotoShichosonCode(RString koikiJutokuSochimotoShichosonCode) {
        this.koikiJutokuSochimotoShichosonCode = koikiJutokuSochimotoShichosonCode;
    }

    /**
     * getKyoShichosonCode
     *
     * @return kyoShichosonCode
     */
    public RString getKyoShichosonCode() {
        return kyoShichosonCode;
    }

    /**
     * setKyoShichosonCode
     *
     * @param kyoShichosonCode kyoShichosonCode
     */
    public void setKyoShichosonCode(RString kyoShichosonCode) {
        this.kyoShichosonCode = kyoShichosonCode;
    }

    /**
     * getShikibetsuCode
     *
     * @return shikibetsuCode
     */
    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     *
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(RString shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * getKanjiMeisho
     *
     * @return kanjiMeisho
     */
    public RString getKanjiMeisho() {
        return kanjiMeisho;
    }

    /**
     * setKanjiMeisho
     *
     * @param kanjiMeisho kanjiMeisho
     */
    public void setKanjiMeisho(RString kanjiMeisho) {
        this.kanjiMeisho = kanjiMeisho;
    }

    /**
     * getJigyoshoMeisho
     *
     * @return jigyoshoMeisho
     */
    public RString getJigyoshoMeisho() {
        return jigyoshoMeisho;
    }

    /**
     * setJigyoshoMeisho
     *
     * @param jigyoshoMeisho jigyoshoMeisho
     */
    public void setJigyoshoMeisho(RString jigyoshoMeisho) {
        this.jigyoshoMeisho = jigyoshoMeisho;
    }

    /**
     * getShokisaiHokenshaNo
     *
     * @return shokisaiHokenshaNo
     */
    public RString getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    /**
     * setShokisaiHokenshaNo
     *
     * @param shokisaiHokenshaNo shokisaiHokenshaNo
     */
    public void setShokisaiHokenshaNo(RString shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbTKyufukanrihyoDataTempTableEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbTKyufukanrihyoDataTempTableEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbTKyufukanrihyoDataTempTableEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbTKyufukanrihyoDataTempTableEntity entity) {
        this.recordShubetsu = entity.recordShubetsu;
        this.renban = entity.renban;
        this.kokanjohoShikibetsuNo = entity.kokanjohoShikibetsuNo;
        this.chohyoRecordShubetsu = entity.chohyoRecordShubetsu;
        this.shinsaYM = entity.shinsaYM;
        this.taishoYM = entity.taishoYM;
        this.hokenshaNo = entity.hokenshaNo;
        this.KyotakuShienJigyoshoNo = entity.KyotakuShienJigyoshoNo;
        this.kyufukanrihyoSakuseiKubunCode = entity.kyufukanrihyoSakuseiKubunCode;
        this.kyufukanrihyoSakuseiYMD = entity.kyufukanrihyoSakuseiYMD;
        this.kyufukanrihyoShubetsuKubunCode = entity.kyufukanrihyoShubetsuKubunCode;
        this.kyufukanrihyoMeisaigyoNo = entity.kyufukanrihyoMeisaigyoNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.seinengappiYMD = entity.seinengappiYMD;
        this.seibetsuCode = entity.seibetsuCode;
        this.yokaigojotaiKubunCode = entity.yokaigojotaiKubunCode;
        this.gendogakuTekiyoKaishiYMD = entity.gendogakuTekiyoKaishiYMD;
        this.gendogakuTekiyoShuryoYMD = entity.gendogakuTekiyoShuryoYMD;
        this.kyotakuKaigoyoboShikyugendogaku = entity.kyotakuKaigoyoboShikyugendogaku;
        this.kyotakuKeikakuSakuseiKubunCode = entity.kyotakuKeikakuSakuseiKubunCode;
        this.serviceTeikyoJigyoshoNo = entity.serviceTeikyoJigyoshoNo;
        this.shiteiKijunGaitoJigyoshoKubunCode = entity.shiteiKijunGaitoJigyoshoKubunCode;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.kyufuKeikakuTanisuNissu = entity.kyufuKeikakuTanisuNissu;
        this.zentsukiMadeKyufuKeikakuNissu = entity.zentsukiMadeKyufuKeikakuNissu;
        this.shiteiServiceShokei = entity.shiteiServiceShokei;
        this.kijunGaitoServiceShokei = entity.kijunGaitoServiceShokei;
        this.kyufuKeikakuGokeiTanisuNissu = entity.kyufuKeikakuGokeiTanisuNissu;
        this.kaigoshienSenmoninNo = entity.kaigoshienSenmoninNo;
        this.itakusakiKyotakuKaigoshienJigyoshoNo = entity.itakusakiKyotakuKaigoshienJigyoshoNo;
        this.itakusakiKaigoshienSenmoninNo = entity.itakusakiKaigoshienSenmoninNo;
        this.hihoNoHenkanShichosonCode = entity.hihoNoHenkanShichosonCode;
        this.shinHihokenshaNo = entity.shinHihokenshaNo;
        this.shichosonCode = entity.shichosonCode;
        this.koikiJutokuSochimotoShichosonCode = entity.koikiJutokuSochimotoShichosonCode;
        this.kyoShichosonCode = entity.kyoShichosonCode;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.kanjiMeisho = entity.kanjiMeisho;
        this.jigyoshoMeisho = entity.jigyoshoMeisho;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(recordShubetsu, renban, kokanjohoShikibetsuNo, chohyoRecordShubetsu, shinsaYM, taishoYM, hokenshaNo, KyotakuShienJigyoshoNo, kyufukanrihyoSakuseiKubunCode, kyufukanrihyoSakuseiYMD, kyufukanrihyoShubetsuKubunCode, kyufukanrihyoMeisaigyoNo, hihokenshaNo, seinengappiYMD, seibetsuCode, yokaigojotaiKubunCode, gendogakuTekiyoKaishiYMD, gendogakuTekiyoShuryoYMD, kyotakuKaigoyoboShikyugendogaku, kyotakuKeikakuSakuseiKubunCode, serviceTeikyoJigyoshoNo, shiteiKijunGaitoJigyoshoKubunCode, serviceShuruiCode, kyufuKeikakuTanisuNissu, zentsukiMadeKyufuKeikakuNissu, shiteiServiceShokei, kijunGaitoServiceShokei, kyufuKeikakuGokeiTanisuNissu, kaigoshienSenmoninNo, itakusakiKyotakuKaigoshienJigyoshoNo, itakusakiKaigoshienSenmoninNo, hihoNoHenkanShichosonCode, shinHihokenshaNo, shichosonCode, koikiJutokuSochimotoShichosonCode, kyoShichosonCode, shikibetsuCode, kanjiMeisho, jigyoshoMeisho, shokisaiHokenshaNo);
    }

// </editor-fold>
}
