/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5050RenrakusakiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連絡先情報Entityの共通Mockです。
 *
 * @author N9606 漢那 憲作
 */
public class RenrakusakiJohoEntityMock {

    public static DbT5050RenrakusakiJohoEntity create連絡先情報Entity() {

        DbT5050RenrakusakiJohoEntity entity = new DbT5050RenrakusakiJohoEntity();
        entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(new RString("123456")));
        entity.setHihokenshaNo(new KaigoHihokenshaNo(new RString("1111111111")));
        entity.setRenrakusakiShimei(new AtenaMeisho(new RString("連絡　てすと")));
        entity.setRenrakusakiKanaSimei(new AtenaKanaMeisho(new RString("レンラク　テスト")));
        entity.setRenrakusakiTuzukigara(new RString("父"));
        entity.setRenrakusakiTelNo(new TelNo("000-111-2345"));
        entity.setRenrakusakiKeitaiTelNo(new TelNo("000-2222-9876"));
        entity.setRenrakusakiYubinNo(new YubinNo("111-2345"));
        entity.setRenrakusakiJusho(new AtenaJusho("てすと市１２３４５６番地"));
        entity.setRenrakusakiKubunNo(new RString("00000001"));
        entity.setShishoCode(null);
        return entity;
    }
}
