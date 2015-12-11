/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.hihokenshashikakushodataentity;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証・資格者証データ取得項目クラスです。
 */
public class HihokenshaShikakuShoDataEntity {

    private HihokenshaNo hihokenshaNo;
    private RString kofuShoShurui;
    private int rirekiNo;
    private LasdecCode shichosonCode;
    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate kofuYMD;
    private FlexibleDate yukoKigenYMD;
    private RString kofuJiyu;
    private RString kofuRiyu;
    private FlexibleDate kaishuYMD;
    private RString kaishuJiyu;
    private RString kaishuRiyu;
    private boolean tanpyoHakkoUmuFlag;
    private YMDHMS hakkoShoriTimestamp;
    private RString shinYoshikiSumiKubunCode;
    private RString shoYoshikiKubunCode;
    private boolean logicalDeletedFlag;

    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    public RString getKofuShoShurui() {
        return kofuShoShurui;
    }

    public void setKofuShoShurui(RString kofuShoShurui) {
        this.kofuShoShurui = kofuShoShurui;
    }

    public int getRirekiNo() {
        return rirekiNo;
    }

    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    public FlexibleDate getKofuYMD() {
        return kofuYMD;
    }

    public void setKofuYMD(FlexibleDate kofuYMD) {
        this.kofuYMD = kofuYMD;
    }

    public FlexibleDate getYukoKigenYMD() {
        return yukoKigenYMD;
    }

    public void setYukoKigenYMD(FlexibleDate yukoKigenYMD) {
        this.yukoKigenYMD = yukoKigenYMD;
    }

    public RString getKofuJiyu() {
        return kofuJiyu;
    }

    public void setKofuJiyu(RString kofuJiyu) {
        this.kofuJiyu = kofuJiyu;
    }

    public RString getKofuRiyu() {
        return kofuRiyu;
    }

    public void setKofuRiyu(RString kofuRiyu) {
        this.kofuRiyu = kofuRiyu;
    }

    public FlexibleDate getKaishuYMD() {
        return kaishuYMD;
    }

    public void setKaishuYMD(FlexibleDate kaishuYMD) {
        this.kaishuYMD = kaishuYMD;
    }

    public RString getKaishuJiyu() {
        return kaishuJiyu;
    }

    public void setKaishuJiyu(RString kaishuJiyu) {
        this.kaishuJiyu = kaishuJiyu;
    }

    public RString getKaishuRiyu() {
        return kaishuRiyu;
    }

    public void setKaishuRiyu(RString kaishuRiyu) {
        this.kaishuRiyu = kaishuRiyu;
    }

    public boolean isTanpyoHakkoUmuFlag() {
        return tanpyoHakkoUmuFlag;
    }

    public void setTanpyoHakkoUmuFlag(boolean tanpyoHakkoUmuFlag) {
        this.tanpyoHakkoUmuFlag = tanpyoHakkoUmuFlag;
    }

    public YMDHMS getHakkoShoriTimestamp() {
        return hakkoShoriTimestamp;
    }

    public void setHakkoShoriTimestamp(YMDHMS hakkoShoriTimestamp) {
        this.hakkoShoriTimestamp = hakkoShoriTimestamp;
    }

    public RString getShinYoshikiSumiKubunCode() {
        return shinYoshikiSumiKubunCode;
    }

    public void setShinYoshikiSumiKubunCode(RString shinYoshikiSumiKubunCode) {
        this.shinYoshikiSumiKubunCode = shinYoshikiSumiKubunCode;
    }

    public RString getShoYoshikiKubunCode() {
        return shoYoshikiKubunCode;
    }

    public void setShoYoshikiKubunCode(RString shoYoshikiKubunCode) {
        this.shoYoshikiKubunCode = shoYoshikiKubunCode;
    }

    public boolean isLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    public void setLogicalDeletedFlag(boolean logicalDeletedFlag) {
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

}
