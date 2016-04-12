package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2020011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2020011.ShisetsuNyutaishoIdoDiv;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設入退所異動Divのハンドラークラスです。
 *
 * @reamsid_L DBA-0360-040 wangxiaodong
 */
public class ShisetsuNyutaishoIdoHandler {

    private static final RString 表示モード = new RString("資格異動");
    private static final RString WIDTHサイズモード = new RString("モード1");
    private static final RString 明細表示モード = new RString("追加_修正");
    private static final RString 利用モード = new RString("台帳種別表示機能");
    private final ShisetsuNyutaishoIdoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 施設入退所異動Div
     */
    public ShisetsuNyutaishoIdoHandler(ShisetsuNyutaishoIdoDiv div) {
        this.div = div;
    }

    /**
     * 施設入退所異動Divを初期化します。
     *
     * @param 識別コード 識別コード
     */
    public void initLoad(ShikibetsuCode 識別コード) {

        div.getKihonJoho().getCcdKaigoAtenaInfo().onLoad(識別コード);
        init介護資格系基本情報(識別コード);
        init施設入退所異動エリア(識別コード);
    }

    private void init介護資格系基本情報(ShikibetsuCode 識別コード) {
        div.getKihonJoho().getCcdKaigoShikakuKihon().onLoad(識別コード);
        div.getKihonJoho().getCcdKaigoShikakuKihon().set被保履歴ボタンDisable(false);
        div.getKihonJoho().getCcdKaigoShikakuKihon().set認定履歴ボタンDisable(false);
    }

    private void init施設入退所異動エリア(ShikibetsuCode 識別コード) {
        div.getShisetsuNyutaishoRireki().getCcdShisetsuNyutaishoRirekiKanri().set表示モード(表示モード);
        div.getShisetsuNyutaishoRireki().getCcdShisetsuNyutaishoRirekiKanri().set表示widthサイズ(WIDTHサイズモード);
        div.getShisetsuNyutaishoRireki().getCcdShisetsuNyutaishoRirekiKanri().set明細表示モード(明細表示モード);
        div.getShisetsuNyutaishoRireki().getCcdShisetsuNyutaishoRirekiKanri().set利用モード(利用モード);
        div.getShisetsuNyutaishoRireki().getCcdShisetsuNyutaishoRirekiKanri().initialize(識別コード);
    }

}
