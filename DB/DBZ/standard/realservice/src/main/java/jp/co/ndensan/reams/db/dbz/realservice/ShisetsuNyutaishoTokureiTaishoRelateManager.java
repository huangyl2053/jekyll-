/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.model.kaigojogaitokureitaishoshisetsu.KaigoJogaiTokureiTaishoShisetsuModel;
import jp.co.ndensan.reams.db.dbz.model.relate.ShisetsuNyutaishoRelateModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.ShisetsuNyutaishoTokureiTaishoRelateDac;
// TODO N8187 久保田 以下のimportはURF.IKaigoJigyoshaDaichoManager 等が使用可能になったら有効にする。
//import jp.co.ndensan.reams.ur.urf.model.relate.KaigoJigyoshaRelateModel;
//import jp.co.ndensan.reams.ur.urf.realservice.IKaigoJigyoshaDaichoManager;
//import jp.co.ndensan.reams.ur.urf.realservice.KaigoJigyoshaDaichoManagerFactory;
//import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険施設入退所・介護除外住所地特例対象施設を管理するクラスです。
 *
 * @author n8223 朴義一
 */
public class ShisetsuNyutaishoTokureiTaishoRelateManager {

    private final ShisetsuNyutaishoTokureiTaishoRelateDac dac;

    /**
     * コンストラクタです。
     */
    public ShisetsuNyutaishoTokureiTaishoRelateManager() {
        dac = InstanceProvider.create(ShisetsuNyutaishoTokureiTaishoRelateDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    ShisetsuNyutaishoTokureiTaishoRelateManager(ShisetsuNyutaishoTokureiTaishoRelateDac dac) {
        this.dac = dac;
    }

    /**
     * 主キー1に合致する介護保険施設入退所の一覧を返します。
     *
     * @param 識別コード ShikibetsuCode
     * @return IItemList<ShisetsuNyutaishoRelateModel>
     */
    @Transaction
    public IItemList<ShisetsuNyutaishoRelateModel> get介護保険施設入退所一覧By主キー1(ShikibetsuCode 識別コード) {

        IItemList<ShisetsuNyutaishoRelateModel> shisetsuNyutaishoIchiranList = dac.select介護保険施設入退所一覧By識別コード(識別コード);

        //介護除外住所地特例対象施設情報　施設入退情報から台帳種別が①被保険者（UR）場合に、パラメタ（入所施設種類・入所施設コード）をURに渡して、事業者名を取得する。
        //介護除外住所地特例対象施設情報　施設入退情報から台帳種別が②他市町村住所地特例③適用除外者（DA)パラメタ（入所施設種類・入所施設コード）をDBに渡して、事業者名を取得する。
        //台帳種別  1:被保険者台帳、2:適用除外者台帳,3:他市町村住所地特例者台帳
        for (ShisetsuNyutaishoRelateModel model : shisetsuNyutaishoIchiranList) {

            if (model.get介護保険施設入退所モデル().get台帳種別().equals(DaichoType.被保険者.getCode())) {

                // TODO N8187 久保田 以下の施設入退所情報取得処理はURF.IKaigoJigyoshaDaichoManager が使用可能になったら有効にする。
//                IKaigoJigyoshaDaichoManager manager = KaigoJigyoshaDaichoManagerFactory.getInstance();
//                List<KaigoJigyoshaRelateModel> list = manager.findJigyoshaCurrent(new KaigoJigyoshaNo(model.get介護保険施設入退所モデル().get入所施設コード()));
//                if (!list.isEmpty()) {
//                    model.setJigyoshaMeisho(list.get(0).get介護事業者モデル().get事業者名称().value());
//                } else {
//                    model.setJigyoshaMeisho(RString.EMPTY);
//                }
            } else if (model.get介護保険施設入退所モデル().get台帳種別().equals(DaichoType.適用除外者.getCode())
                    || model.get介護保険施設入退所モデル().get台帳種別().equals(DaichoType.他市町村住所地特例者.getCode())) {
                Optional<KaigoJogaiTokureiTaishoShisetsuModel> result = dac.select介護除外住所地特例対象施設ByKey(
                        model.get介護保険施設入退所モデル().get入所施設種類(),
                        model.get介護保険施設入退所モデル().get入所施設コード(),
                        model.get介護保険施設入退所モデル().get入所年月日());
                if (result.isPresent()) {
                    model.setJigyoshaMeisho(result.get().get事業者名称().value());
                } else {
                    model.setJigyoshaMeisho(RString.EMPTY);
                }
            }
            shisetsuNyutaishoIchiranList.added(model);
        }

        return shisetsuNyutaishoIchiranList;
    }

}
