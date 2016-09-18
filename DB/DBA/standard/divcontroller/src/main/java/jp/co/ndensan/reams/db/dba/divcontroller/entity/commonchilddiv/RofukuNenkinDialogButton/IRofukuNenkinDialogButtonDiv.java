package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RofukuNenkinDialogButton;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.RofukuNenkinState;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IRofukuNenkinDialogButtonDiv extends ICommonChildDivBaseProperties {

    /**
     * 老齢福祉年金ダイアログBTNを初期化します。
     *
     * @param hihokenshaNo 被保険者番号
     * @param shikibetsuCode 識別コード
     * @param state 開いたダイアログの状態
     */
    void initialize(HihokenshaNo hihokenshaNo, ShikibetsuCode shikibetsuCode, RofukuNenkinState state);

    /**
     * ダイアログで設定したデータを保存します。
     *
     * @return
     */
    int save();
}
