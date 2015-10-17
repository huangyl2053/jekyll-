/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2020011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2020011.ShisetsuNyutaishoRirekiDiv;
import static jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2020011.DBA2020011StateName.追加;
import static jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2020011.DBA2020011StateName.修正;
import static jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2020011.DBA2020011StateName.削除;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 施設入退所異動のShisetsuNyutaishoRirekiの処理を記載
 *
 */
public class ShisetsuNyutaishoRireki {

    /**
     * 追加ボタン押下時の処理。
     *
     * @param div 施設入退所異動div
     * @return ResponseData
     */
    public ResponseData<ShisetsuNyutaishoRirekiDiv> onClickAddShisetsuNyutaisho(ShisetsuNyutaishoRirekiDiv div) {
        return toAdd(div);
    }

    /**
     * DataGridで修正選択時の処理。
     *
     * @param div 施設入退所異動div
     * @return ResponseData
     */
    public ResponseData<ShisetsuNyutaishoRirekiDiv> onClickModifyShisetsuNyutaisho(ShisetsuNyutaishoRirekiDiv div) {
        return toModify(div);
    }

    /**
     * DataGridで削除選択時の処理。
     *
     * @param div 施設入退所異動div
     * @return ResponseData
     */
    public ResponseData<ShisetsuNyutaishoRirekiDiv> onClickDeleteShisetsuNyutaisho(ShisetsuNyutaishoRirekiDiv div) {
        return toDelete(div);
    }

    private ResponseData<ShisetsuNyutaishoRirekiDiv> toAdd(ShisetsuNyutaishoRirekiDiv div) {
        return ResponseData.of(div).setState(追加);
    }

    private ResponseData<ShisetsuNyutaishoRirekiDiv> toModify(ShisetsuNyutaishoRirekiDiv div) {
        return ResponseData.of(div).setState(修正);
    }

    private ResponseData<ShisetsuNyutaishoRirekiDiv> toDelete(ShisetsuNyutaishoRirekiDiv div) {
        return ResponseData.of(div).setState(削除);
    }

}
