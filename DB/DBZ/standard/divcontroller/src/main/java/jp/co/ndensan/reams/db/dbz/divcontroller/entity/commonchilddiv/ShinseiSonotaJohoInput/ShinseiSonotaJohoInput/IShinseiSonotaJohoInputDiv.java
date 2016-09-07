package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBZ-1300-120 houtianpeng
 */
public interface IShinseiSonotaJohoInputDiv extends ICommonChildDivBaseProperties {

    /**
     * 選択されている移動事由のKeyを取得します。
     *
     * @return 異動事由Key
     */
    RString get異動事由();

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
    public void initialize();

    /**
     * 異動事由の設定。
     *
     * @param key RString
     */
    public void set異動事由(RString key);

    /**
     * 削除事由の設定。
     *
     * @param key RString
     */
    public void set削除事由(RString key);

    /**
     * 理由の設定。
     *
     * @param value RString
     */
    public void set理由(RString value);

    /**
     * 喪失日の設定。
     *
     * @param day FlexibleDate
     */
    public void set喪失日(FlexibleDate day);

    /**
     * 取消日の設定。
     *
     * @param day FlexibleDate
     */
    public void set取消日(FlexibleDate day);

    /**
     * 当初認定期間の設定。
     *
     * @param day FlexibleDate
     */
    public void set当初認定期間From(FlexibleDate day);

    /**
     * 当初認定期間の設定。
     *
     * @param day FlexibleDate
     */
    public void set当初認定期間To(FlexibleDate day);

    /**
     * 発行日１の設定。
     *
     * @param day FlexibleDate
     */
    public void set発行日１(FlexibleDate day);

    /**
     * 発行日２の設定。
     *
     * @param day FlexibleDate
     */
    public void set発行日2(FlexibleDate day);

    /**
     * 喪失日の取得。
     *
     * @return TextBoxFlexibleDate
     */
    public TextBoxFlexibleDate getTxtSoshitsuDay();
}
