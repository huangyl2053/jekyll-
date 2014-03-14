/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice.helper;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定申請情報を生成するためのMockクラスです
 *
 * @author N8187 久保田 英男
 */
public class NinteiShinseiJohoMock {

    private NinteiShinseiJohoMock() {
    }

    public static DbT5001NinteiShinseiJohoEntity create認定申請情報Entity() {
        final RString 試験用文字列 = new RString("0001");
        return new DbT5001NinteiShinseiJohoEntity(
                new ShinseishoKanriNo(試験用文字列),
                new ShichosonCode(試験用文字列),
                試験用文字列,
                new KaigoHihokenshaNo(試験用文字列),
                new ShikibetsuCode(試験用文字列),
                new FlexibleDate(new RString("20140101")),
                new EdabanCode(new RString("01")),
                new Code(試験用文字列),
                new Code(試験用文字列),
                new Code(試験用文字列),
                試験用文字列,
                試験用文字列,
                new Code(試験用文字列),
                1,
                true,
                new NinteichosaIraiRirekiNo(1),
                1,
                試験用文字列,
                true,
                true,
                試験用文字列,
                new Code(試験用文字列),
                試験用文字列,
                new FlexibleDate(new RString("20140101")),
                true);
    }
}
