/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanfukushiyoguhanbaihi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3034ShokanShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3036ShokanHanteiKekkaEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3038ShokanKihonEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3048ShokanFukushiYoguHanbaihiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3053ShokanShukeiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

/**
 *
 * @author chenaoqi
 */
public class FukushiyoguKonyuhiShikyuGendogakuManagerTest {

    private RString 画面モード;
    private ShikibetsuCode 識別コード;
    private DbT3038ShokanKihonEntity shokanKihonEntity;
    private List<DbT3048ShokanFukushiYoguHanbaihiEntity> list;
    private DbT3034ShokanShinseiEntity shokanShinseiEntity;
    private DbT3036ShokanHanteiKekkaEntity shokanHanteiKekkaEntity;
    private DbT3053ShokanShukeiEntity shokanShukeiEntity;
    private RString 修正前支給区分;
    private static final RString モード_登録 = new RString("登録");
    private static final RString モード_修正 = new RString("修正");
    private static final RString モード_差額登録 = new RString("差額登録");
    private static final RString モード_削除 = new RString("削除");
    private static final RString モード_審査 = new RString("審査");
    private static final RString 通し番号 = Saiban.get(SubGyomuCode.DBC介護給付, SaibanHanyokeyName.実績管理番号.getコード()).nextString();
    private FukushiyoguKonyuhiShikyuGendogakuManager sut;

    @Before
    public void setUp() {
        sut = mock(FukushiyoguKonyuhiShikyuGendogakuManager.class);
        画面モード = モード_審査;
        識別コード = new ShikibetsuCode("2");
        修正前支給区分 = ShikyuFushikyuKubun.不支給.getコード();
        shokanKihonEntity = DbT3038ShokanKihonEntityGenerator.createDbT3038ShokanKihonEntity();
        DbT3048ShokanFukushiYoguHanbaihiEntity entity = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity();
        list = new ArrayList<>();
        list.add(entity);
        shokanShinseiEntity = DbT3034ShokanShinseiEntityGenerator.createDbT3034ShokanShinseiEntity();
        shokanHanteiKekkaEntity = DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity();
        shokanShukeiEntity = DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity();
    }

    @Test
    public void dealKyufujissekiTest() {
        sut.dealKyufujisseki(画面モード, 識別コード, shokanKihonEntity, list, shokanShinseiEntity, shokanHanteiKekkaEntity, shokanShukeiEntity, 修正前支給区分);
    }

}
