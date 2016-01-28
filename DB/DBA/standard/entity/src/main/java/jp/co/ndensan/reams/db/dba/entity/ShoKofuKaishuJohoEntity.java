/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 証交付回収情報のエンティティクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoKofuKaishuJohoEntity {

    private RString status;
    private FlexibleDate kofuYMD;
    private FlexibleDate yukoKigenYMD;
    private RString kofuJiyu;
    private RString kofuRiyu;
    private FlexibleDate kaishuYMD;
    private RString kaishuJiyu;
    private RString kaishuRiyu;
    private RString kofuShoShurui;
    private HihokenshaNo hihokenshaNo;
    private YMDHMS hakkoShoriTimestamp;
    private ShikibetsuCode shikibetsuCode;

}
