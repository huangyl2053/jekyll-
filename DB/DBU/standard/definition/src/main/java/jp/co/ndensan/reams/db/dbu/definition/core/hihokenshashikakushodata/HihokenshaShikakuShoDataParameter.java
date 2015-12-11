/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashikakushodata;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証・資格者証パラメタクラスです。
 */
public class HihokenshaShikakuShoDataParameter {

    private RString menuId;
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
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;

    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getKofuShoShurui() {
        return kofuShoShurui;
    }

    public int getRirekiNo() {
        return rirekiNo;
    }

    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    public FlexibleDate getKofuYMD() {
        return kofuYMD;
    }

    public FlexibleDate getYukoKigenYMD() {
        return yukoKigenYMD;
    }

    public RString getKofuJiyu() {
        return kofuJiyu;
    }

    public RString getKofuRiyu() {
        return kofuRiyu;
    }

    public FlexibleDate getKaishuYMD() {
        return kaishuYMD;
    }

    public RString getKaishuJiyu() {
        return kaishuJiyu;
    }

    public RString getKaishuRiyu() {
        return kaishuRiyu;
    }

    public boolean isTanpyoHakkoUmuFlag() {
        return tanpyoHakkoUmuFlag;
    }

    public YMDHMS getHakkoShoriTimestamp() {
        return hakkoShoriTimestamp;
    }

    public RString getShinYoshikiSumiKubunCode() {
        return shinYoshikiSumiKubunCode;
    }

    public RString getShoYoshikiKubunCode() {
        return shoYoshikiKubunCode;
    }

    public boolean isLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    public RString getMenuId() {
        return menuId;
    }

    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

}
