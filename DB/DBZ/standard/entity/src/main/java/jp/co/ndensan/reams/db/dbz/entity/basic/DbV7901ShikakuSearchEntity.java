package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbV7901ShikakuSearchの項目定義クラスです
 *
 */
public class DbV7901ShikakuSearchEntity extends DbTableEntityBase<DbV7901ShikakuSearchEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">

    @TableName
    public static final RString TABLE_NAME = new RString("DbV7901ShikakuSearch");

    private ShikibetsuCode shikibetsuCode;
    private LasdecCode shichosonCode;
    private HihokenshaNo hihokenshaNo;
    private RString shikakuShutokuJiyuCode;
    private FlexibleDate shikakuShutokuYMD;
    private Code hihokennshaKubunCode;
    private RString shikakuSoshitsuJiyuCode;
    private FlexibleDate shikakuSoshitsuYMD;
    private RString jushochiTokureiFlag;
    private RString shikakuHenkoJiyuCode;
    private FlexibleDate shikakuHenkoYMD;
    private RString jushochitokureiTekiyoJiyuCode;
    private FlexibleDate jushochitokureiTekiyoYMD;
    private RString jushochitokureiKaijoJiyuCode;
    private FlexibleDate jushochitokureiKaijoYMD;
    private RString koikinaiJushochiTokureiFlag;
    private LasdecCode koikinaiTokureiSochimotoShichosonCode;
    private RString tekiyoJogaiTekiyoJiyuCode;
    private FlexibleDate tekiyoJogaiTekiyoYMD;
    private RString tekiyoJogaikaijokaijoJiyuCode;
    private FlexibleDate tekiyoJogaiKaijoYMD;
    private RString tatokureiTekiyoJiyuCode;
    private FlexibleDate tatokureiTekiyoYMD;
    private RString tatokureiKaijoJiyuCode;
    private FlexibleDate tatokureiKaijoYMD;

    /**
     * getShikibetsuCode
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     *
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * getShichosonCode
     *
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     *
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
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
     * getShikakuShutokuJiyuCode
     *
     * @return shikakuShutokuJiyuCode
     */
    public RString getShikakuShutokuJiyuCode() {
        return shikakuShutokuJiyuCode;
    }

    /**
     * setShikakuShutokuJiyuCode
     *
     * @param shikakuShutokuJiyuCode shikakuShutokuJiyuCode
     */
    public void setShikakuShutokuJiyuCode(RString shikakuShutokuJiyuCode) {
        this.shikakuShutokuJiyuCode = shikakuShutokuJiyuCode;
    }

    /**
     * getShikakuShutokuYMD
     *
     * @return shikakuShutokuYMD
     */
    public FlexibleDate getShikakuShutokuYMD() {
        return shikakuShutokuYMD;
    }

    /**
     * setShikakuShutokuYMD
     *
     * @param shikakuShutokuYMD shikakuShutokuYMD
     */
    public void setShikakuShutokuYMD(FlexibleDate shikakuShutokuYMD) {
        this.shikakuShutokuYMD = shikakuShutokuYMD;
    }

    /**
     * getHihokennshaKubunCode
     *
     * @return hihokennshaKubunCode
     */
    public Code getHihokennshaKubunCode() {
        return hihokennshaKubunCode;
    }

    /**
     * setHihokennshaKubunCode
     *
     * @param hihokennshaKubunCode hihokennshaKubunCode
     */
    public void setHihokennshaKubunCode(Code hihokennshaKubunCode) {
        this.hihokennshaKubunCode = hihokennshaKubunCode;
    }

    /**
     * getShikakuSoshitsuJiyuCode
     *
     * @return shikakuSoshitsuJiyuCode
     */
    public RString getShikakuSoshitsuJiyuCode() {
        return shikakuSoshitsuJiyuCode;
    }

    /**
     * setShikakuSoshitsuJiyuCode
     *
     * @param shikakuSoshitsuJiyuCode shikakuSoshitsuJiyuCode
     */
    public void setShikakuSoshitsuJiyuCode(RString shikakuSoshitsuJiyuCode) {
        this.shikakuSoshitsuJiyuCode = shikakuSoshitsuJiyuCode;
    }

    /**
     * getShikakuSoshitsuYMD
     *
     * @return shikakuSoshitsuYMD
     */
    public FlexibleDate getShikakuSoshitsuYMD() {
        return shikakuSoshitsuYMD;
    }

    /**
     * setShikakuSoshitsuYMD
     *
     * @param shikakuSoshitsuYMD shikakuSoshitsuYMD
     */
    public void setShikakuSoshitsuYMD(FlexibleDate shikakuSoshitsuYMD) {
        this.shikakuSoshitsuYMD = shikakuSoshitsuYMD;
    }

    /**
     * getJushochiTokureiFlag
     *
     * @return jushochiTokureiFlag
     */
    public RString getJushochiTokureiFlag() {
        return jushochiTokureiFlag;
    }

    /**
     * setJushochiTokureiFlag
     *
     * @param jushochiTokureiFlag jushochiTokureiFlag
     */
    public void setJushochiTokureiFlag(RString jushochiTokureiFlag) {
        this.jushochiTokureiFlag = jushochiTokureiFlag;
    }

    /**
     * getShikakuHenkoJiyuCode
     *
     * @return shikakuHenkoJiyuCode
     */
    public RString getShikakuHenkoJiyuCode() {
        return shikakuHenkoJiyuCode;
    }

    /**
     * setShikakuHenkoJiyuCode
     *
     * @param shikakuHenkoJiyuCode shikakuHenkoJiyuCode
     */
    public void setShikakuHenkoJiyuCode(RString shikakuHenkoJiyuCode) {
        this.shikakuHenkoJiyuCode = shikakuHenkoJiyuCode;
    }

    /**
     * getShikakuHenkoYMD
     *
     * @return shikakuHenkoYMD
     */
    public FlexibleDate getShikakuHenkoYMD() {
        return shikakuHenkoYMD;
    }

    /**
     * setShikakuHenkoYMD
     *
     * @param shikakuHenkoYMD shikakuHenkoYMD
     */
    public void setShikakuHenkoYMD(FlexibleDate shikakuHenkoYMD) {
        this.shikakuHenkoYMD = shikakuHenkoYMD;
    }

    /**
     * getJushochitokureiTekiyoJiyuCode
     *
     * @return jushochitokureiTekiyoJiyuCode
     */
    public RString getJushochitokureiTekiyoJiyuCode() {
        return jushochitokureiTekiyoJiyuCode;
    }

    /**
     * setJushochitokureiTekiyoJiyuCode
     *
     * @param jushochitokureiTekiyoJiyuCode jushochitokureiTekiyoJiyuCode
     */
    public void setJushochitokureiTekiyoJiyuCode(RString jushochitokureiTekiyoJiyuCode) {
        this.jushochitokureiTekiyoJiyuCode = jushochitokureiTekiyoJiyuCode;
    }

    /**
     * getJushochitokureiTekiyoYMD
     *
     * @return jushochitokureiTekiyoYMD
     */
    public FlexibleDate getJushochitokureiTekiyoYMD() {
        return jushochitokureiTekiyoYMD;
    }

    /**
     * setJushochitokureiTekiyoYMD
     *
     * @param jushochitokureiTekiyoYMD jushochitokureiTekiyoYMD
     */
    public void setJushochitokureiTekiyoYMD(FlexibleDate jushochitokureiTekiyoYMD) {
        this.jushochitokureiTekiyoYMD = jushochitokureiTekiyoYMD;
    }

    /**
     * getJushochitokureiKaijoJiyuCode
     *
     * @return jushochitokureiKaijoJiyuCode
     */
    public RString getJushochitokureiKaijoJiyuCode() {
        return jushochitokureiKaijoJiyuCode;
    }

    /**
     * setJushochitokureiKaijoJiyuCode
     *
     * @param jushochitokureiKaijoJiyuCode jushochitokureiKaijoJiyuCode
     */
    public void setJushochitokureiKaijoJiyuCode(RString jushochitokureiKaijoJiyuCode) {
        this.jushochitokureiKaijoJiyuCode = jushochitokureiKaijoJiyuCode;
    }

    /**
     * getJushochitokureiKaijoYMD
     *
     * @return jushochitokureiKaijoYMD
     */
    public FlexibleDate getJushochitokureiKaijoYMD() {
        return jushochitokureiKaijoYMD;
    }

    /**
     * setJushochitokureiKaijoYMD
     *
     * @param jushochitokureiKaijoYMD jushochitokureiKaijoYMD
     */
    public void setJushochitokureiKaijoYMD(FlexibleDate jushochitokureiKaijoYMD) {
        this.jushochitokureiKaijoYMD = jushochitokureiKaijoYMD;
    }

    /**
     * getKoikinaiJushochiTokureiFlag
     *
     * @return koikinaiJushochiTokureiFlag
     */
    public RString getKoikinaiJushochiTokureiFlag() {
        return koikinaiJushochiTokureiFlag;
    }

    /**
     * setKoikinaiJushochiTokureiFlag
     *
     * @param koikinaiJushochiTokureiFlag koikinaiJushochiTokureiFlag
     */
    public void setKoikinaiJushochiTokureiFlag(RString koikinaiJushochiTokureiFlag) {
        this.koikinaiJushochiTokureiFlag = koikinaiJushochiTokureiFlag;
    }

    /**
     * getKoikinaiTokureiSochimotoShichosonCode
     *
     * @return koikinaiTokureiSochimotoShichosonCode
     */
    public LasdecCode getKoikinaiTokureiSochimotoShichosonCode() {
        return koikinaiTokureiSochimotoShichosonCode;
    }

    /**
     * setKoikinaiTokureiSochimotoShichosonCode
     *
     * @param koikinaiTokureiSochimotoShichosonCode koikinaiTokureiSochimotoShichosonCode
     */
    public void setKoikinaiTokureiSochimotoShichosonCode(LasdecCode koikinaiTokureiSochimotoShichosonCode) {
        this.koikinaiTokureiSochimotoShichosonCode = koikinaiTokureiSochimotoShichosonCode;
    }

    /**
     * getTekiyoJogaiTekiyoJiyuCode
     *
     * @return tekiyoJogaiTekiyoJiyuCode
     */
    public RString getTekiyoJogaiTekiyoJiyuCode() {
        return tekiyoJogaiTekiyoJiyuCode;
    }

    /**
     * setTekiyoJogaiTekiyoJiyuCode
     *
     * @param tekiyoJogaiTekiyoJiyuCode tekiyoJogaiTekiyoJiyuCode
     */
    public void setTekiyoJogaiTekiyoJiyuCode(RString tekiyoJogaiTekiyoJiyuCode) {
        this.tekiyoJogaiTekiyoJiyuCode = tekiyoJogaiTekiyoJiyuCode;
    }

    /**
     * getTekiyoJogaiTekiyoYMD
     *
     * @return tekiyoJogaiTekiyoYMD
     */
    public FlexibleDate getTekiyoJogaiTekiyoYMD() {
        return tekiyoJogaiTekiyoYMD;
    }

    /**
     * setTekiyoJogaiTekiyoYMD
     *
     * @param tekiyoJogaiTekiyoYMD tekiyoJogaiTekiyoYMD
     */
    public void setTekiyoJogaiTekiyoYMD(FlexibleDate tekiyoJogaiTekiyoYMD) {
        this.tekiyoJogaiTekiyoYMD = tekiyoJogaiTekiyoYMD;
    }

    /**
     * getTekiyoJogaikaijokaijoJiyuCode
     *
     * @return tekiyoJogaikaijokaijoJiyuCode
     */
    public RString getTekiyoJogaikaijokaijoJiyuCode() {
        return tekiyoJogaikaijokaijoJiyuCode;
    }

    /**
     * setTekiyoJogaikaijokaijoJiyuCode
     *
     * @param tekiyoJogaikaijokaijoJiyuCode tekiyoJogaikaijokaijoJiyuCode
     */
    public void setTekiyoJogaikaijokaijoJiyuCode(RString tekiyoJogaikaijokaijoJiyuCode) {
        this.tekiyoJogaikaijokaijoJiyuCode = tekiyoJogaikaijokaijoJiyuCode;
    }

    /**
     * getTekiyoJogaiKaijoYMD
     *
     * @return tekiyoJogaiKaijoYMD
     */
    public FlexibleDate getTekiyoJogaiKaijoYMD() {
        return tekiyoJogaiKaijoYMD;
    }

    /**
     * setTekiyoJogaiKaijoYMD
     *
     * @param tekiyoJogaiKaijoYMD tekiyoJogaiKaijoYMD
     */
    public void setTekiyoJogaiKaijoYMD(FlexibleDate tekiyoJogaiKaijoYMD) {
        this.tekiyoJogaiKaijoYMD = tekiyoJogaiKaijoYMD;
    }

    /**
     * getTatokureiTekiyoJiyuCode
     *
     * @return tatokureiTekiyoJiyuCode
     */
    public RString getTatokureiTekiyoJiyuCode() {
        return tatokureiTekiyoJiyuCode;
    }

    /**
     * setTatokureiTekiyoJiyuCode
     *
     * @param tatokureiTekiyoJiyuCode tatokureiTekiyoJiyuCode
     */
    public void setTatokureiTekiyoJiyuCode(RString tatokureiTekiyoJiyuCode) {
        this.tatokureiTekiyoJiyuCode = tatokureiTekiyoJiyuCode;
    }

    /**
     * getTatokureiTekiyoYMD
     *
     * @return tatokureiTekiyoYMD
     */
    public FlexibleDate getTatokureiTekiyoYMD() {
        return tatokureiTekiyoYMD;
    }

    /**
     * setTatokureiTekiyoYMD
     *
     * @param tatokureiTekiyoYMD tatokureiTekiyoYMD
     */
    public void setTatokureiTekiyoYMD(FlexibleDate tatokureiTekiyoYMD) {
        this.tatokureiTekiyoYMD = tatokureiTekiyoYMD;
    }

    /**
     * getTatokureiKaijoJiyuCode
     *
     * @return tatokureiKaijoJiyuCode
     */
    public RString getTatokureiKaijoJiyuCode() {
        return tatokureiKaijoJiyuCode;
    }

    /**
     * setTatokureiKaijoJiyuCode
     *
     * @param tatokureiKaijoJiyuCode tatokureiKaijoJiyuCode
     */
    public void setTatokureiKaijoJiyuCode(RString tatokureiKaijoJiyuCode) {
        this.tatokureiKaijoJiyuCode = tatokureiKaijoJiyuCode;
    }

    /**
     * getTatokureiKaijoYMD
     *
     * @return tatokureiKaijoYMD
     */
    public FlexibleDate getTatokureiKaijoYMD() {
        return tatokureiKaijoYMD;
    }

    /**
     * setTatokureiKaijoYMD
     *
     * @param tatokureiKaijoYMD tatokureiKaijoYMD
     */
    public void setTatokureiKaijoYMD(FlexibleDate tatokureiKaijoYMD) {
        this.tatokureiKaijoYMD = tatokureiKaijoYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV7901ShikakuSearchEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbV7901ShikakuSearchEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV7901ShikakuSearchEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV7901ShikakuSearchEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.shichosonCode = entity.shichosonCode;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shikakuShutokuJiyuCode = entity.shikakuShutokuJiyuCode;
        this.shikakuShutokuYMD = entity.shikakuShutokuYMD;
        this.hihokennshaKubunCode = entity.hihokennshaKubunCode;
        this.shikakuSoshitsuJiyuCode = entity.shikakuSoshitsuJiyuCode;
        this.shikakuSoshitsuYMD = entity.shikakuSoshitsuYMD;
        this.jushochiTokureiFlag = entity.jushochiTokureiFlag;
        this.shikakuHenkoJiyuCode = entity.shikakuHenkoJiyuCode;
        this.shikakuHenkoYMD = entity.shikakuHenkoYMD;
        this.jushochitokureiTekiyoJiyuCode = entity.jushochitokureiTekiyoJiyuCode;
        this.jushochitokureiTekiyoYMD = entity.jushochitokureiTekiyoYMD;
        this.jushochitokureiKaijoJiyuCode = entity.jushochitokureiKaijoJiyuCode;
        this.jushochitokureiKaijoYMD = entity.jushochitokureiKaijoYMD;
        this.koikinaiJushochiTokureiFlag = entity.koikinaiJushochiTokureiFlag;
        this.koikinaiTokureiSochimotoShichosonCode = entity.koikinaiTokureiSochimotoShichosonCode;
        this.tekiyoJogaiTekiyoJiyuCode = entity.tekiyoJogaiTekiyoJiyuCode;
        this.tekiyoJogaiTekiyoYMD = entity.tekiyoJogaiTekiyoYMD;
        this.tekiyoJogaikaijokaijoJiyuCode = entity.tekiyoJogaikaijokaijoJiyuCode;
        this.tekiyoJogaiKaijoYMD = entity.tekiyoJogaiKaijoYMD;
        this.tatokureiTekiyoJiyuCode = entity.tatokureiTekiyoJiyuCode;
        this.tatokureiTekiyoYMD = entity.tatokureiTekiyoYMD;
        this.tatokureiKaijoJiyuCode = entity.tatokureiKaijoJiyuCode;
        this.tatokureiKaijoYMD = entity.tatokureiKaijoYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, shichosonCode, hihokenshaNo, shikakuShutokuJiyuCode, shikakuShutokuYMD, hihokennshaKubunCode, shikakuSoshitsuJiyuCode, shikakuSoshitsuYMD, jushochiTokureiFlag, shikakuHenkoJiyuCode, shikakuHenkoYMD, jushochitokureiTekiyoJiyuCode, jushochitokureiTekiyoYMD, jushochitokureiKaijoJiyuCode, jushochitokureiKaijoYMD, koikinaiJushochiTokureiFlag, koikinaiTokureiSochimotoShichosonCode, tekiyoJogaiTekiyoJiyuCode, tekiyoJogaiTekiyoYMD, tekiyoJogaikaijokaijoJiyuCode, tekiyoJogaiKaijoYMD, tatokureiTekiyoJiyuCode, tatokureiTekiyoYMD, tatokureiKaijoJiyuCode, tatokureiKaijoYMD);
    }

// </editor-fold>
}
