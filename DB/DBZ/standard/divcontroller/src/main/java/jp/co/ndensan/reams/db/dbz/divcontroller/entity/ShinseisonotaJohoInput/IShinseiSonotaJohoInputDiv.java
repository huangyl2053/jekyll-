package jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinseisonotaJohoInput;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IShinseiSonotaJohoInputDiv extends ICommonChildDivBaseProperties {

    /**
     * 選択されている移動事由のKeyを取得します。
     *
     * @return 異動事由Key
     */
    RString get移動事由();

    /**
     * 選択されている削除事由のKeyを取得します。
     *
     * @return 削除事由Key
     */
    RString get削除事由();

    /**
     * 異動理由を取得します。
     *
     * @return 異動理由
     */
    RString get理由();

    /**
     * 喪失日を取得します。
     *
     * @return 喪失日
     */
    FlexibleDate get喪失日();

    /**
     * 取消日を取得します。
     *
     * @return 取消日
     */
    FlexibleDate get取消日();

    /**
     * 当初認定期間開始日を取得します。
     *
     * @return 当初認定期間開始日
     */
    FlexibleDate get当初認定期間開始();

    /**
     * 当初認定期間終了日を取得します。
     *
     * @return 当初認定期間終了日
     */
    FlexibleDate get当初認定期間終了();

    /**
     * 受給資格者証発効日１を取得します。
     *
     * @return 受給資格者証発効日１
     */
    FlexibleDate get受給資格者証発行日１();

    /**
     * 受給資格者証発効日２を取得します。
     *
     * @return 受給資格者証発効日２
     */
    FlexibleDate get受給資格者証発効日２();

    /**
     * 使用データベース決定サブ業務コード(隠し項目)を設定します。
     *
     * @param hdnDatabaseSubGyomuCode サブ業務コード
     */
    public void setHdnDatabaseSubGyomuCode(RString hdnDatabaseSubGyomuCode);

    /**
     * 申請書管理番号(隠し項目)を設定します。
     *
     * @param hdnShinseishoKanriNo 申請書管理番号
     */
    public void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo);

    /**
     * 共有子Divにモードをセットします。
     *
     * @param value 処理タイプモード
     */
    public void setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType value);

    /**
     * 入力値をクリアします。
     */
    public void clear();

    /**
     * 画面の初期化処理を行います。
     */
    void initialize();

}
