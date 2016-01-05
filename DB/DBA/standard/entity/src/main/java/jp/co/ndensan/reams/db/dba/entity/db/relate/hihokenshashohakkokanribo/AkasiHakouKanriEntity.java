/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 証発行管理リストEntityです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AkasiHakouKanriEntity {

    private int renban;
    private HihokenshaNo hihokenshaNo;
    private RString juminCode;
    private YubinNo yubinNo;
    private RString shimei;
    private RString jusho;
    private LasdecCode shichosonCode;
    private FlexibleDate kofuYMD;
    private Code kofuJiyuCode;
    private RString kofuJiyuRyakusho;
    private RString kofuJiyuMeisho;
    private FlexibleDate kaishuYMD;
    private Code kaishuJiyuCode;
    private RString kaishuJiyuMeisho;
    private FlexibleDate yukoKigenYMD;
    private RString shoYoshikiKubunCode;
    private boolean komokuNameFukaFlag;
    private boolean hitukiHenshuFlag;
}
