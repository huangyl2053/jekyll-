/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * @author soft863
 */
public class SikakuKanrenIdoEntity implements IDbAccessable {

    private HihokenshaNo hihokenshaNo;
    private FlexibleDate idoYMD;
    private RString edaNo;
    private FlexibleDate shikakuHenkoYMD;
    private FlexibleDate shikakuHenkoTodokedeYMD;
    private KaigoShikakuJutokuTekiyoJiyu jushochitokureiTekiyoJiyuCode;
    private LasdecCode shichosonCode;
    private RString shichosonMeisho;
    private LasdecCode koikinaiTokureiSochimotoShichosonCode;
    private RString shichosonMeisho2;
    private LasdecCode kyuShichosonCode;
    private RString kyuShichosonMeisho;

    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setIdoYMD(FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    public void setEdaNo(RString edaNo) {
        this.edaNo = edaNo;
    }

    public void setShikakuHenkoYMD(FlexibleDate shikakuHenkoYMD) {
        this.shikakuHenkoYMD = shikakuHenkoYMD;
    }

    public void setShikakuHenkoTodokedeYMD(FlexibleDate shikakuHenkoTodokedeYMD) {
        this.shikakuHenkoTodokedeYMD = shikakuHenkoTodokedeYMD;
    }

    public void setJushochitokureiTekiyoJiyuCode(KaigoShikakuJutokuTekiyoJiyu jushochitokureiTekiyoJiyuCode) {
        this.jushochitokureiTekiyoJiyuCode = jushochitokureiTekiyoJiyuCode;
    }

    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    public void setShichosonMeisho(RString shichosonMeisho) {
        this.shichosonMeisho = shichosonMeisho;
    }

    public void setKoikinaiTokureiSochimotoShichosonCode(LasdecCode koikinaiTokureiSochimotoShichosonCode) {
        this.koikinaiTokureiSochimotoShichosonCode = koikinaiTokureiSochimotoShichosonCode;
    }

    public void setShichosonMeisho2(RString shichosonMeisho2) {
        this.shichosonMeisho2 = shichosonMeisho2;
    }

    public void setKyuShichosonCode(LasdecCode kyuShichosonCode) {
        this.kyuShichosonCode = kyuShichosonCode;
    }

    public void setKyuShichosonMeisho(RString kyuShichosonMeisho) {
        this.kyuShichosonMeisho = kyuShichosonMeisho;
    }

    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    public RString getEdaNo() {
        return edaNo;
    }

    public FlexibleDate getShikakuHenkoYMD() {
        return shikakuHenkoYMD;
    }

    public FlexibleDate getShikakuHenkoTodokedeYMD() {
        return shikakuHenkoTodokedeYMD;
    }

    public KaigoShikakuJutokuTekiyoJiyu getJushochitokureiTekiyoJiyuCode() {
        return jushochitokureiTekiyoJiyuCode;
    }

    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    public RString getShichosonMeisho() {
        return shichosonMeisho;
    }

    public LasdecCode getKoikinaiTokureiSochimotoShichosonCode() {
        return koikinaiTokureiSochimotoShichosonCode;
    }

    public RString getShichosonMeisho2() {
        return shichosonMeisho2;
    }

    public LasdecCode getKyuShichosonCode() {
        return kyuShichosonCode;
    }

    public RString getKyuShichosonMeisho() {
        return kyuShichosonMeisho;
    }
}
