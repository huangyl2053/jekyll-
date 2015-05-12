/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

//import jp.co.ndensan.reams.ur.urf.entity.basic.ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.basic.ChosainJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * ChosainJohoEntityを生成するためのMockクラスです
 *
 * @author N8187 久保田 英男
 */
public final class ChosainJohoEntityMock {

    private ChosainJohoEntityMock() {
    }

//    public static ChosainJohoEntity getSpiedInstance() {
//        ChosainJohoEntity chosainJohoEntity = new ChosainJohoEntity();
//        chosainJohoEntity.set介護事業者番号(new RString("1000000001"));
//        chosainJohoEntity.set介護調査員番号(new RString("00000001"));
//        chosainJohoEntity.set調査員氏名(new RString("調査員太郎"));
//        chosainJohoEntity.set調査員氏名カナ(new RString("ﾁｮｳｻｲﾝﾀﾛｳ"));
//        return spy(chosainJohoEntity);
//    }
    public static ChosainJohoEntity getSpiedInstance() {
        ChosainJohoEntity chosainJohoEntity = new ChosainJohoEntity();
        chosainJohoEntity.set介護事業者番号(new KaigoJigyoshaNo("1000000001"));
        chosainJohoEntity.set介護調査員番号(new RString("00000001"));
        chosainJohoEntity.set調査員氏名(new RString("調査員太郎"));
        chosainJohoEntity.set調査員氏名カナ(new RString("ﾁｮｳｻｲﾝﾀﾛｳ"));
        return spy(chosainJohoEntity);
    }
}
