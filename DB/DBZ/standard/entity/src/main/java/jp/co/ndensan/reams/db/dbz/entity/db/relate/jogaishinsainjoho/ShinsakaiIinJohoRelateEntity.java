/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.jogaishinsainjoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査会委員情報のRelateEntityクラス。
 *
 * @reamsid_L DBZ-1300-040 dongyabin
 */
@Getter
@Setter
public class ShinsakaiIinJohoRelateEntity {

    private RString shinsakaiIinCode;
    private FlexibleDate shinsakaiIinKaishiYMD;
    private FlexibleDate shinsakaiIinShuryoYMD;
    private AtenaMeisho shinsakaiIinShimei;
    private AtenaKanaMeisho shinsakaiIinKanaShimei;
    private RString seibetsu;
    private Code shinsakaiIinShikakuCode;
    private RString shinsainYusoKubun;
    private ChikuCode tantoChikuCode;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private TelNo telNo;
    private TelNo faxNo;
    private FlexibleDate seinengappiYMD;
    private RString biko;
    private boolean haishiFlag;
    private FlexibleDate haishiYMD;
    private int remban;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private RString shujiiIryokikanCode;
    private RString shujiiCode;
    private RString ninteichosaItakusakiCode;
    private RString ninteiChosainNo;
    private RString sonotaKikanCode;
    private RString shichosonCode;
    private RString jogaiTaishoShinsakaiIinCode;

}
