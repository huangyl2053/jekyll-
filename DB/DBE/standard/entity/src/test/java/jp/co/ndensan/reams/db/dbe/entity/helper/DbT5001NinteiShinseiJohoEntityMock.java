/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiShinsei;
import jp.co.ndensan.reams.db.dbe.business.helper.YokaigoNinteiShinseiMock;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.YokaigoNinteiShinseiMapper;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShishoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N3327 三浦 凌
 */
public class DbT5001NinteiShinseiJohoEntityMock {

    private DbT5001NinteiShinseiJohoEntityMock() {
    }

    /**
     *
     * @return DbT5001NinteiShinseiJohoEntity
     */
    public static DbT5001NinteiShinseiJohoEntity getEntity() {
        DbT5001NinteiShinseiJohoEntity entity = new DbT5001NinteiShinseiJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(RString.EMPTY));
        entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(new RString("000000")));
        entity.setShishoCode(ShishoCode.NULL_VALUE);
        entity.setHihokenshaNo(new KaigoHihokenshaNo(new RString("0000000001")));
        entity.setShikibetsuCode(new ShikibetsuCode("1"));
        entity.setNinteiShinseiYMD(FlexibleDate.getNowDate());
        entity.setNinteiShinseiEdabanCode(new EdabanCode("000"));
        entity.setNinteiShinseiShinseijiKubunCode(new Code(String.valueOf(NinteiShinseiKubunShinsei.新規申請.コード())));
        entity.setNinteiShinseiHoreiKubunCode(new Code(""));
        entity.setNinteiShinseiYukoKubunCode(new Code(""));
        entity.setShienShinseiKubun(RString.HALF_SPACE);
        entity.setShinseiRiyu(RString.EMPTY);
        entity.setJohoteikyoDouiUmuKubun(true);
        entity.setNinteichosaIraiRirekiNo(0);
        entity.setIkenshoIraiRirekiNo(0);
        entity.setNinteichosaShikibetsuCode(new Code(""));
        return entity;
    }
}
