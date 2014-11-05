/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 * DbT5001NinteiShinseiJohoEntityを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class DbT5001NinteiShinseiJohoEntityMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5001NinteiShinseiJohoEntityMock() {
    }

    /**
     * DbT5001NinteiShinseiJohoEntityを生成して返します。
     *
     * @return DbT5001NinteiShinseiJohoEntity
     */
    public static DbT5001NinteiShinseiJohoEntity getSpiedInstance() {
        DbT5001NinteiShinseiJohoEntity entity = new DbT5001NinteiShinseiJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString("申請書管理番号")));
        entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(new RString("証記載保険者番号")));
        entity.setShishoCode(new ShishoCode(new RString("支所コード")));
        entity.setHihokenshaNo(new HihokenshaNo(new RString("1234567890")));
        entity.setShikibetsuCode(new ShikibetsuCode(new RString("123456")));
        entity.setNinteiShinseiYMD(FlexibleDate.MIN);
        entity.setNinteiShinseiEdabanCode(new EdabanCode(new RString("001")));
        entity.setNinteiShinseiShinseijiKubunCode(new Code(String.valueOf(NinteiShinseiKubunShinsei.新規申請.コード())));
        entity.setNinteiShinseiHoreiKubunCode(new Code(new RString("認定申請区分（法令）コード")));
        entity.setNinteiShinseiYukoKubunCode(new Code(new RString("認定申請有効区分")));
        entity.setShienShinseiKubun(new RString("要介護申請・要支援申請の区分"));
        entity.setShinseiRiyu(new RString("認定申請理由"));
        entity.setZenYokaigoKubunCode(new Code(new RString("前回要介護状態区分コード")));
        entity.setZenYukoKikan(0);
        entity.setJohoteikyoDouiUmuKubun(true);
        entity.setNinteichosaIraiRirekiNo(1);
        entity.setIkenshoIraiRirekiNo(2);
        entity.setMinashiCode(new RString("みなし要介護区分コード"));
        entity.setEnkitsuchiDoiUmuKubun(false);
        entity.setShisetsuNyushoUmuKubun(true);
        entity.setSichosonRenrakuJiko(new RString("市町村連絡事項"));
        entity.setTorisageKubunCode(new Code(new RString("取下げ区分コード")));
        entity.setTorisageRiyu(new RString("取下げ理由"));
        entity.setTorisageYMD(FlexibleDate.MAX);
        entity.setShinsaKeizokuKubun(false);
        return spy(entity);
    }
}
