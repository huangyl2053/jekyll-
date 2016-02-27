/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 証発行管理リストです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AkasiHakouKanriEntity {

    private int renban;
    private RString hihokenshaNo;
    private LasdecCode shichosonCode;
    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate kofuYMD;
    private FlexibleDate yukoKigenYMD;
    private RString kofuJiyu;
    private FlexibleDate kaishuYMD;
    private RString kaishuJiyu;
    private RString shoYoshikiKubunCode;
    private RString meisho;
    private RString yubinNo;
    private RString jusho;
    private Code kofuJiyuCode;
    private RString kofuJiyuRyakusho;
    private Code kaishuJiyuCode;

}
