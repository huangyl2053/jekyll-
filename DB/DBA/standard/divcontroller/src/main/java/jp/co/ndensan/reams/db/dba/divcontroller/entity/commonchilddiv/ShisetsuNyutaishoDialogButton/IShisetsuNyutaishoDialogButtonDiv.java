package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoDialogButton;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoState;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IShisetsuNyutaishoDialogButtonDiv extends ICommonChildDivBaseProperties {

    /**
     * 施設入退所ダイアログBTNの初期化を行います。
     *
     * @param shikibetsuCode 対象の識別コード
     * @param daichoShubetsu 台帳種別
     * @param state ダイアログで開いた共有子Divの状態
     */
    void initialize(ShikibetsuCode shikibetsuCode, RString daichoShubetsu, ShisetsuNyutaishoState state);

    /**
     * ダイアログで設定したデータを保存します。
     *
     * @return 保存した件数
     */
    int save();
}
