/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice.helper;

import jp.co.ndensan.reams.db.dbx.entity.basic.ChosainJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * ChosainJohoEntityを生成するためのMockクラスです。
 *
 * @author N2204 三井 沙織
 */
public class MockChosainJohoEntity {

    private MockChosainJohoEntity() {
    }

    /**
     * Mockito#spyでラップされたChosainJohoEntityを生成します。
     *
     * @return ChosainJohoEntity Mockito#spyでラップされたインスタンス
     */
    public static ChosainJohoEntity getSpiedInstance() {
        ChosainJohoEntity chosainJohoEntity = new ChosainJohoEntity();
        chosainJohoEntity.set介護事業者番号(new KaigoJigyoshaNo("1000000001"));
        chosainJohoEntity.set介護調査員番号(new RString("00000001"));
        chosainJohoEntity.set調査員氏名(new RString("調査員太郎"));
        chosainJohoEntity.set調査員氏名カナ(new RString("ﾁｮｳｻｲﾝﾀﾛｳ"));
        return spy(chosainJohoEntity);
    }
}
