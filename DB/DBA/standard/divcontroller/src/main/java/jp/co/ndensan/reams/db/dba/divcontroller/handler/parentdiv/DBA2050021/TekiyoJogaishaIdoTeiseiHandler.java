/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2050021;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2050021.TekiyoJogaishaIdoTeiseiDiv;
import jp.co.ndensan.reams.db.dba.service.core.tekiyojogaisha.TekiyoJogaishaManager;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 適用除外者異動の訂正のハンドラークラスです。
 *
 * @reamsid_L DBA-0411-050 lizhuoxuan
 */
public class TekiyoJogaishaIdoTeiseiHandler {

    private final TekiyoJogaishaIdoTeiseiDiv div;
    private static final RString 表示モード1 = new RString("資格異動");
    private static final RString WIDTHサイズモード = new RString("モード1");
    private static final RString 明細表示モード = new RString("追加_修正");
    private static final RString 利用モード = new RString("適用除外者対象機能");
    private static final RString 訂正履歴モード = new RString("訂正履歴モード");

    /**
     * コンストラクタです。
     *
     * @param div 適用除外者異動の訂正Div
     */
    public TekiyoJogaishaIdoTeiseiHandler(TekiyoJogaishaIdoTeiseiDiv div) {
        this.div = div;
    }

    /**
     * 施設入退所異動Divを初期化します。
     *
     * @param 識別コード 識別コード
     */
    public void initLoad(ShikibetsuCode 識別コード) {
        div.getShikakuKihonJoho().getCcdKaigoAtenaInfo().initialize(識別コード);
        init適用除外情報一覧エリア(識別コード);
        init施設入退所異動エリア(識別コード);
    }

    private void init適用除外情報一覧エリア(ShikibetsuCode 識別コード) {
        div.getTekiyoJogaiJohoIchiran().getCcdTekiyoJogaiRireki().set状態(訂正履歴モード);
        div.getTekiyoJogaiJohoIchiran().getCcdTekiyoJogaiRireki().initialize(識別コード);
    }

    private void init施設入退所異動エリア(ShikibetsuCode 識別コード) {
        div.getTekiyoJogaiJohoIchiran().getShisetsuHenkoJohoInput().getCcdShisetsuNyutaishoRirekiKanri().set表示モード(表示モード1);
        div.getTekiyoJogaiJohoIchiran().getShisetsuHenkoJohoInput().getCcdShisetsuNyutaishoRirekiKanri().set表示widthサイズ(WIDTHサイズモード);
        div.getTekiyoJogaiJohoIchiran().getShisetsuHenkoJohoInput().getCcdShisetsuNyutaishoRirekiKanri().set明細表示モード(明細表示モード);
        div.getTekiyoJogaiJohoIchiran().getShisetsuHenkoJohoInput().getCcdShisetsuNyutaishoRirekiKanri().set利用モード(利用モード);
        div.getTekiyoJogaiJohoIchiran().getShisetsuHenkoJohoInput().getCcdShisetsuNyutaishoRirekiKanri().initialize(識別コード, DaichoType.適用除外者.getコード());
    }

    /**
     * @param 識別コード 識別コード
     * @return 適用除外者の場合、{@code true}.
     */
    public boolean is適用除外者(ShikibetsuCode 識別コード) {
        TekiyoJogaishaManager manager = TekiyoJogaishaManager.createInstance();
        TekiyoJogaisha tekiyoJogaisha = manager.getNewestTekiyoJogaisha(識別コード);
        if (tekiyoJogaisha == null) {
            return false;
        }
        return (!(tekiyoJogaisha.get適用年月日() == null || tekiyoJogaisha.get適用年月日().isEmpty())
                && (tekiyoJogaisha.get解除年月日() == null || tekiyoJogaisha.get解除年月日().isEmpty()));
    }
}
