/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0000001.testShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.model.relate.ShisetsuNyutaishoRelateModel;
import jp.co.ndensan.reams.db.dbz.realservice.ShisetsuNyutaishoManager;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.realservice.KaigoJogaiTokureiTaishoShisetsuManager;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設履歴管理共有子Divのテスト画面のコントローラクラスです。※テスト用※
 *
 * @author N8223　朴義一
 */
public class TestShisetsuNyutaishoRirekiKanri {

    private static final ShikibetsuCode SHIKIBETSU_CODE = new ShikibetsuCode("1234567890");

    private final ShisetsuNyutaishoManager 介護保険施設入退所Manager = new ShisetsuNyutaishoManager();
    private final KaigoJogaiTokureiTaishoShisetsuManager 介護除外住所地特例対象施設Manager = new KaigoJogaiTokureiTaishoShisetsuManager();

    /**
     * 画面ロード時のイベントメソッドです。 検索キーを元にデータを取得し、Divに設定します。
     *
     * @param div テスト施設情報Div
     * @return レスポンス
     */
    public ResponseData<testShisetsuNyutaishoRirekiKanriDiv> onLoad(testShisetsuNyutaishoRirekiKanriDiv div) {

        div.getCcdShisetsuNyutaishRirekiKanri().initialize();
        div.getCcdShisetsuNyutaishRirekiKanri().load(SHIKIBETSU_CODE);

        //施設入退情報
//        IItemList<ShisetsuNyutaishoRelateModel> shisetsuNyutaishoIchiranList
//                = ItemList.of(介護保険施設入退所Manager.get介護保険施設入退所一覧By主キー1(SHIKIBETSU_CODE));
//
//        //介護除外住所地特例対象施設情報　施設入退情報から台帳種別が①被保険者（UR）場合に、パラメタ（入所施設種類・入所施設コード）をURに渡して、事業者名を取得する。
//        //介護除外住所地特例対象施設情報　施設入退情報から台帳種別が②他市町村住所地特例③適用除外者（DA)パラメタ（入所施設種類・入所施設コード）をDBに渡して、事業者名を取得する。
//        //台帳種別  1:被保険者台帳、2:適用除外者台帳,3:他市町村住所地特例者台帳
//        //   IItemList<ShisetsuNyutaishoRelateModel> list = ItemList.empty();
//        for (ShisetsuNyutaishoRelateModel model : shisetsuNyutaishoIchiranList) {
//
//            if (model.get介護保険施設入退所モデル().get台帳種別().equals(new RString("1"))) {
//            } else if (model.get介護保険施設入退所モデル().get台帳種別().equals(new RString("2")) || model.get介護保険施設入退所モデル().get台帳種別().equals(new RString("3"))) {
//                model.setJigyoshaMeisho(介護除外住所地特例対象施設Manager.get介護除外住所地特例対象施設(
//                        model.get介護保険施設入退所モデル().get入所施設種類(),
//                        model.get介護保険施設入退所モデル().get入所施設コード(),
//                        model.get介護保険施設入退所モデル().get入所年月日()).get介護除外住所地特例対象施設モデル().get事業者名称().value());
//
//            }
//            shisetsuNyutaishoIchiranList.added(model);
//        }
//
//        div.getCcdShisetsuNyutaishRirekiKanri().set施設入退所履歴(shisetsuNyutaishoIchiranList);
        return createResponse(div);
    }

    private ResponseData<testShisetsuNyutaishoRirekiKanriDiv> createResponse(testShisetsuNyutaishoRirekiKanriDiv div) {

        ResponseData<testShisetsuNyutaishoRirekiKanriDiv> response = new ResponseData();
        response.data = div;
        return response;
    }

}
