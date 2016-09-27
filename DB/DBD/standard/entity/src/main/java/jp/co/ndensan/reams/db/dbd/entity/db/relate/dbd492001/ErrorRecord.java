/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * エラーメッセージEntity
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ErrorRecord {

    private ShikibetsuCode shikibetsukodo;
    private RString hokenshabango;
    private RString hihokenjabango;
    private FlexibleDate ninteishinseibi;
    private RString edaban;
    private Code shinseikubunhorei;
    private Code shinseikubunshinseiji;
    private Code torisakubunkodo;
    private Code hihokenjakubun;
    private Code shinseidaikokubun;
    private FlexibleDate seinengappi;
    private int nenrei;
    private Code seibetsukodo;
    private AtenaKanaMeisho hihokenjakanashimei;
    private AtenaMeisho hihokenjakanjishimei;
    private YubinNo yubenbango;
    private AtenaJusho jusho;
    private TelNo tenwabango;
    private RString byoinshisetsutonomeisho;
    private RString byoinshisetsutonoshozaichi;
    private RString eramesseji;

}
