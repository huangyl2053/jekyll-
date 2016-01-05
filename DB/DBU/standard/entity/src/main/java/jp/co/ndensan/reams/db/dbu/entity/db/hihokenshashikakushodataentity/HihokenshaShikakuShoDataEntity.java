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
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
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

}
