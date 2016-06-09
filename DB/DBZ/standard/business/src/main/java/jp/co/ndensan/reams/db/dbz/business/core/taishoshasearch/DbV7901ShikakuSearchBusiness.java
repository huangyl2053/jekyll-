/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.business.core.taishoshasearch;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV7901ShikakuSearchEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n2810
 */
public class DbV7901ShikakuSearchBusiness {

    private final DbV7901ShikakuSearchEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 要介護認定申請情報(受給)Entity
     */
    public DbV7901ShikakuSearchBusiness(DbV7901ShikakuSearchEntity entity) {
        this.entity = entity;
    }

    /**
     * shikibetsuCodeのgetメソッドです。
     *
     * @return this.entity.shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return this.entity.getShikibetsuCode();
    }

    /**
     * shichosonCodeのgetメソッドです。
     *
     * @return this.entity.shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return this.entity.getShichosonCode();
    }

    /**
     * hihokenshaNoのgetメソッドです。
     *
     * @return this.entity.hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return this.entity.getHihokenshaNo();
    }

    /**
     * shikakuShutokuJiyuCodeのgetメソッドです。
     *
     * @return this.entity.shikakuShutokuJiyuCode
     */
    public RString getShikakuShutokuJiyuCode() {
        return this.entity.getShikakuShutokuJiyuCode();
    }

    /**
     * shikakuShutokuYMDのgetメソッドです。
     *
     * @return this.entity.shikakuShutokuYMD
     */
    public FlexibleDate getShikakuShutokuYMD() {
        return this.entity.getShikakuShutokuYMD();
    }

    /**
     * hihokennshaKubunCodeのgetメソッドです。
     *
     * @return this.entity.hihokennshaKubunCode
     */
    public RString getHihokennshaKubunCode() {
        return this.entity.getHihokennshaKubunCode();
    }

    /**
     * shikakuSoshitsuJiyuCodeのgetメソッドです。
     *
     * @return this.entity.shikakuSoshitsuJiyuCode
     */
    public RString getShikakuSoshitsuJiyuCode() {
        return this.entity.getShikakuSoshitsuJiyuCode();
    }

    /**
     * shikakuSoshitsuYMDのgetメソッドです。
     *
     * @return this.entity.shikakuSoshitsuYMD
     */
    public FlexibleDate getShikakuSoshitsuYMD() {
        return this.entity.getShikakuSoshitsuYMD();
    }

    /**
     * jushochiTokureiFlagのgetメソッドです。
     *
     * @return this.entity.jushochiTokureiFlag
     */
    public RString getJushochiTokureiFlag() {
        return this.entity.getJushochiTokureiFlag();
    }

    /**
     * shikakuHenkoJiyuCodeのgetメソッドです。
     *
     * @return this.entity.shikakuHenkoJiyuCode
     */
    public RString getShikakuHenkoJiyuCode() {
        return this.entity.getShikakuHenkoJiyuCode();
    }

    /**
     * shikakuHenkoYMDのgetメソッドです。
     *
     * @return this.entity.shikakuHenkoYMD
     */
    public FlexibleDate getShikakuHenkoYMD() {
        return this.entity.getShikakuHenkoYMD();
    }

    /**
     * jushochitokureiTekiyoJiyuCodeのgetメソッドです。
     *
     * @return this.entity.jushochitokureiTekiyoJiyuCode
     */
    public RString getJushochitokureiTekiyoJiyuCode() {
        return this.entity.getJushochitokureiTekiyoJiyuCode();
    }

    /**
     * jushochitokureiTekiyoYMDのgetメソッドです。
     *
     * @return this.entity.jushochitokureiTekiyoYMD
     */
    public FlexibleDate getJushochitokureiTekiyoYMD() {
        return this.entity.getJushochitokureiTekiyoYMD();
    }

    /**
     * jushochitokureiKaijoJiyuCodeのgetメソッドです。
     *
     * @return this.entity.jushochitokureiKaijoJiyuCode
     */
    public RString getJushochitokureiKaijoJiyuCode() {
        return this.entity.getJushochitokureiKaijoJiyuCode();
    }

    /**
     * jushochitokureiKaijoYMDのgetメソッドです。
     *
     * @return this.entity.jushochitokureiKaijoYMD
     */
    public FlexibleDate getJushochitokureiKaijoYMD() {
        return this.entity.getJushochitokureiKaijoYMD();
    }

    /**
     * koikinaiJushochiTokureiFlagのgetメソッドです。
     *
     * @return this.entity.koikinaiJushochiTokureiFlag
     */
    public RString getKoikinaiJushochiTokureiFlag() {
        return this.entity.getKoikinaiJushochiTokureiFlag();
    }

    /**
     * koikinaiTokureiSochimotoShichosonCodeのgetメソッドです。
     *
     * @return this.entity.koikinaiTokureiSochimotoShichosonCode
     */
    public LasdecCode getKoikinaiTokureiSochimotoShichosonCode() {
        return this.entity.getKoikinaiTokureiSochimotoShichosonCode();
    }

    /**
     * tekiyoJogaiTekiyoJiyuCodeのgetメソッドです。
     *
     * @return this.entity.tekiyoJogaiTekiyoJiyuCode
     */
    public RString getTekiyoJogaiTekiyoJiyuCode() {
        return this.entity.getTekiyoJogaiTekiyoJiyuCode();
    }

    /**
     * tekiyoJogaiTekiyoYMDのgetメソッドです。
     *
     * @return this.entity.tekiyoJogaiTekiyoYMD
     */
    public FlexibleDate getTekiyoJogaiTekiyoYMD() {
        return this.entity.getTekiyoJogaiTekiyoYMD();
    }

    /**
     * tekiyoJogaikaijokaijoJiyuCodeのgetメソッドです。
     *
     * @return this.entity.tekiyoJogaikaijokaijoJiyuCode
     */
    public RString getTekiyoJogaikaijokaijoJiyuCode() {
        return this.entity.getTekiyoJogaikaijokaijoJiyuCode();
    }

    /**
     * tekiyoJogaiKaijoYMDのgetメソッドです。
     *
     * @return this.entity.tekiyoJogaiKaijoYMD
     */
    public FlexibleDate getTekiyoJogaiKaijoYMD() {
        return this.entity.getTekiyoJogaiKaijoYMD();
    }

    /**
     * tatokureiTekiyoJiyuCodeのgetメソッドです。
     *
     * @return this.entity.tatokureiTekiyoJiyuCode
     */
    public RString getTatokureiTekiyoJiyuCode() {
        return this.entity.getTatokureiTekiyoJiyuCode();
    }

    /**
     * tatokureiTekiyoYMDのgetメソッドです。
     *
     * @return this.entity.tatokureiTekiyoYMD
     */
    public FlexibleDate getTatokureiTekiyoYMD() {
        return this.entity.getTatokureiTekiyoYMD();
    }

    /**
     * tatokureiKaijoJiyuCodeのgetメソッドです。
     *
     * @return this.entity.tatokureiKaijoJiyuCode
     */
    public RString getTatokureiKaijoJiyuCode() {
        return this.entity.getTatokureiKaijoJiyuCode();
    }

    /**
     * tatokureiKaijoYMDのgetメソッドです。
     *
     * @return this.entity.tatokureiKaijoYMD
     */
    public FlexibleDate getTatokureiKaijoYMD() {
        return this.entity.getTatokureiKaijoYMD();
    }

    /**
     * JukyushaDaichoHihokenshaNoのgetメソッドです。
     *
     * @return this.entity.JukyushaDaichoHihokenshaNo
     */
    public HihokenshaNo getJukyushaDaichoHihokenshaNo() {
        return this.entity.getJukyushaDaichoHihokenshaNo();
    }

}
