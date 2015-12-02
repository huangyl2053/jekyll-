/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.konicho;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 *
 * @author LINGHUHANG
 */
public class KoNiChoRelateEntity {

    @PrimaryKey
    private LasdecCode shichosonCode;
    private RString shichosonMeisho;
    @PrimaryKey
    private ChosainCode ninteiChosainNo;
    private RString chosainShimei;
    private RString chosainKanaShimei;
    @PrimaryKey
    private RString ninteichosaItakusakiCode;
    private RString jigyoshaMeisho;
    private RString seibetsu;
    private RString chikuCode;
    private RString chosainShikaku;

    private int chosaKanoNinzuPerMonth;
    private boolean jokyoFlag;

    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private TelNo telNo;
    private TelNo faxNo;

    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    public RString getShichosonMeisho() {
        return shichosonMeisho;
    }

    public ChosainCode getNinteiChosainNo() {
        return ninteiChosainNo;
    }

    public RString getChosainShimei() {
        return chosainShimei;
    }

    public RString getChosainKanaShimei() {
        return chosainKanaShimei;
    }

    public RString getNinteichosaItakusakiCode() {
        return ninteichosaItakusakiCode;
    }

    public RString getJigyoshaMeisho() {
        return jigyoshaMeisho;
    }

    public RString getSeibetsu() {
        return seibetsu;
    }

    public RString getChikuCode() {
        return chikuCode;
    }

    public RString getChosainShikaku() {
        return chosainShikaku;
    }

    public int getChosaKanoNinzuPerMonth() {
        return chosaKanoNinzuPerMonth;
    }

    public boolean isJokyoFlag() {
        return jokyoFlag;
    }

    public YubinNo getYubinNo() {
        return yubinNo;
    }

    public AtenaJusho getJusho() {
        return jusho;
    }

    public TelNo getTelNo() {
        return telNo;
    }

    public TelNo getFaxNo() {
        return faxNo;
    }

}
