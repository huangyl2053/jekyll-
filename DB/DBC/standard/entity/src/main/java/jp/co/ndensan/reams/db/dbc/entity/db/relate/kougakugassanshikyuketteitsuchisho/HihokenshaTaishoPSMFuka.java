/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kougakugassanshikyuketteitsuchisho;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * ビジネス設計_DBCMNN2003_事業分高額合算支給決定通知書（単）のEntity。
 *
 * @reamsid_L DBC-4850-040 pengxingyi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaTaishoPSMFuka {

    private LasdecCode shichosonCode;
    private ShikibetsuCode shikibetsuCode;
    private AtenaMeisho kanjiShimei;
    private AtenaKanaMeisho kanaShimei;
    private FlexibleDate seinengappiYMD;
    private RString seibetsuCode;
    private YubinNo yubinNo;
    private ZenkokuJushoCode zenkokuJushoCode;
    private GyoseikuCode gyoseikuCode;
    private RString juminShubetsuCode;
    private AtenaJusho jusho;
}
