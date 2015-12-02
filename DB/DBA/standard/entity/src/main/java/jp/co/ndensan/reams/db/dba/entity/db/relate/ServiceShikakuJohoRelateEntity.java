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
public class ServiceShikakuJohoRelateEntity implements IDbAccessable {

    private HihokenshaNo hihokenshaNo;
    private FlexibleDate idoYMD;
    private RString edaNo;
    private FlexibleDate shikakuShutokuYMD;
    private FlexibleDate shikakuShutokuTodokedeYMD;
    private KaigoShikakuJutokuTekiyoJiyu jushochitokureiTekiyoJiyuCode;
    private RString hihokennshaKubunCode;
    private FlexibleDate shikakuSoshitsuYMD;
    private FlexibleDate shikakuSoshitsuTodokedeYMD;
    private KaigoShikakuJutokuTekiyoJiyu jushochitokureiKaijoJiyuCode;
    private RString jushochiTokureiFlag;
    private LasdecCode shichosonCode;
    private RString shichosonMeisho;
    private LasdecCode shichosonCode2;
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

    public void setShikakuShutokuYMD(FlexibleDate shikakuShutokuYMD) {
        this.shikakuShutokuYMD = shikakuShutokuYMD;
    }

    public void setShikakuShutokuTodokedeYMD(FlexibleDate shikakuShutokuTodokedeYMD) {
        this.shikakuShutokuTodokedeYMD = shikakuShutokuTodokedeYMD;
    }

    public void setKaigoShikakuJutokuTekiyoJiyu(KaigoShikakuJutokuTekiyoJiyu jushochitokureiTekiyoJiyuCode) {
        this.jushochitokureiTekiyoJiyuCode = jushochitokureiTekiyoJiyuCode;
    }

    public void setHihokennshaKubunCode(RString hihokennshaKubunCode) {
        this.hihokennshaKubunCode = hihokennshaKubunCode;
    }

    public void setShikakuSoshitsuYMD(FlexibleDate shikakuSoshitsuYMD) {
        this.shikakuSoshitsuYMD = shikakuSoshitsuYMD;
    }

    public void setShikakuSoshitsuTodokedeYMD(FlexibleDate shikakuSoshitsuTodokedeYMD) {
        this.shikakuSoshitsuTodokedeYMD = shikakuSoshitsuTodokedeYMD;
    }

    public void setKaigoShikakuJutokuTekiyoJiyu2(KaigoShikakuJutokuTekiyoJiyu jushochitokureiKaijoJiyuCode) {
        this.jushochitokureiKaijoJiyuCode = jushochitokureiKaijoJiyuCode;
    }

    public void setJushochiTokureiFlag(RString jushochiTokureiFlag) {
        this.jushochiTokureiFlag = jushochiTokureiFlag;
    }

    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    public void setShichosonMeisho(RString shichosonMeisho) {
        this.shichosonMeisho = shichosonMeisho;
    }

    public void setShichosonCode2(LasdecCode shichosonCode2) {
        this.shichosonCode2 = shichosonCode2;
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

    public FlexibleDate getShikakuShutokuYMD() {
        return shikakuShutokuYMD;
    }

    public KaigoShikakuJutokuTekiyoJiyu getJushochitokureiTekiyoJiyuCode() {
        return jushochitokureiTekiyoJiyuCode;
    }

    public FlexibleDate getShikakuShutokuTodokedeYMD() {
        return shikakuShutokuTodokedeYMD;
    }

    public RString getHihokennshaKubunCode() {
        return hihokennshaKubunCode;
    }

    public FlexibleDate getShikakuSoshitsuYMD() {
        return shikakuSoshitsuYMD;
    }

    public KaigoShikakuJutokuTekiyoJiyu getJushochitokureiKaijoJiyuCode() {
        return jushochitokureiKaijoJiyuCode;
    }

    public FlexibleDate getShikakuSoshitsuTodokedeYMD() {
        return shikakuSoshitsuTodokedeYMD;
    }

    public RString getJushochiTokureiFlag() {
        return jushochiTokureiFlag;
    }

    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    public RString getShichosonMeisho() {
        return shichosonMeisho;
    }

    public LasdecCode getShichosonCode2() {
        return shichosonCode2;
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
