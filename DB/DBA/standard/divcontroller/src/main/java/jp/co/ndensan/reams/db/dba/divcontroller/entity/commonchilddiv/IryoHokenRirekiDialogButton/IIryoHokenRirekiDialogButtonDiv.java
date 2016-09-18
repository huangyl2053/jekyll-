package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.IryoHokenRirekiDialogButton;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IryoHokenRirekiState;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IIryoHokenRirekiDialogButtonDiv extends ICommonChildDivBaseProperties {

    /**
     * 医療保険履歴ダイアログBTNの初期化を行います。
     *
     * @param hihokenshaNo 被保険者番号
     * @param shikibetsuCode 識別コード
     * @param state 開いた先のダイアログの状態。照会・登録等を指定する。
     */
    void initialize(HihokenshaNo hihokenshaNo, ShikibetsuCode shikibetsuCode, IryoHokenRirekiState state);

    /**
     * ダイアログで入力した医療保険履歴のデータを保存します。変更したデータが無い場合は何も行いません。
     *
     * @return 保存件数
     */
    int save();
}
