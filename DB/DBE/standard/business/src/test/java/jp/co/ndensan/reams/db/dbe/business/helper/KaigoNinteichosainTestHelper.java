/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.helper;

import jp.co.ndensan.reams.db.dbe.business.KaigoNinteichosain;
import jp.co.ndensan.reams.db.dbe.business.mapper.NinteichosaItakusakiMapper;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoNinteichosainNo;
import static jp.co.ndensan.reams.db.dbe.entity.helper.KaigoNinteichosainTestHelper.介護事業者番号;
import static jp.co.ndensan.reams.db.dbe.entity.helper.KaigoNinteichosainTestHelper.介護調査員番号;
import static jp.co.ndensan.reams.db.dbe.entity.helper.KaigoNinteichosainTestHelper.住所;
import static jp.co.ndensan.reams.db.dbe.entity.helper.KaigoNinteichosainTestHelper.地区コード;
import static jp.co.ndensan.reams.db.dbe.entity.helper.KaigoNinteichosainTestHelper.市町村コード;
import static jp.co.ndensan.reams.db.dbe.entity.helper.KaigoNinteichosainTestHelper.性別;
import static jp.co.ndensan.reams.db.dbe.entity.helper.KaigoNinteichosainTestHelper.調査員氏名;
import static jp.co.ndensan.reams.db.dbe.entity.helper.KaigoNinteichosainTestHelper.調査員氏名カナ;
import static jp.co.ndensan.reams.db.dbe.entity.helper.KaigoNinteichosainTestHelper.調査員状況;
import static jp.co.ndensan.reams.db.dbe.entity.helper.KaigoNinteichosainTestHelper.調査員資格コード;
import static jp.co.ndensan.reams.db.dbe.entity.helper.KaigoNinteichosainTestHelper.郵便番号;
import static jp.co.ndensan.reams.db.dbe.entity.helper.KaigoNinteichosainTestHelper.電話番号;
import jp.co.ndensan.reams.db.dbe.entity.helper.MockNinteichosaItakusakiJohoEntity;

/**
 * モデルパッケージ作成時にエラーになったため仮作成。対応するときに考える。
 *
 * @author N3317 塚田 萌
 */
public class KaigoNinteichosainTestHelper {

    public static KaigoNinteichosain create認定調査員() {
        return new KaigoNinteichosain(
                市町村コード,
                介護事業者番号,
                new KaigoNinteichosainNo(介護調査員番号),
                調査員状況,
                調査員氏名,
                調査員氏名カナ,
                性別,
                調査員資格コード,
                地区コード,
                郵便番号,
                住所,
                電話番号,
                NinteichosaItakusakiMapper.toNinteichosaItakusaki(MockNinteichosaItakusakiJohoEntity.getSpiedInstance()));
    }
}
