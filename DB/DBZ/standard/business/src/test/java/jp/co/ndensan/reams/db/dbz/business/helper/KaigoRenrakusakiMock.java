/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.helper;

import jp.co.ndensan.reams.db.dbz.business.KaigoRenrakusaki;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.RenrakusakiKubunNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護連絡先の共通Mockです。
 *
 * @author n9606 漢那 憲作
 */
public class KaigoRenrakusakiMock {

    public static KaigoRenrakusaki create介護連絡先() {
        return new KaigoRenrakusaki(
                new AtenaMeisho(new RString("連絡　てすと")),
                new AtenaKanaMeisho(new RString("レンラク　テスト")),
                new TelNo("000-111-2345"),
                new TelNo("000-2222-9876"),
                new YubinNo("111-2345"),
                new AtenaJusho("てすと市１２３４５６番地"),
                new RString("父"),
                new RenrakusakiKubunNo(new RString("00000001")),
                new ShoKisaiHokenshaNo(new RString("123456")),
                new HihokenshaNo(new RString("1111111111")),
                new RString("01"));
    }
}
