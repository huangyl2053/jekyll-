package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushosettei.KaigoAtesakiJushoSettei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 *
 *@reamsid_L　DBU-3990-030　wanghui
 */
public interface IKaigoAtesakiJushoSetteiDiv extends ICommonChildDivBaseProperties {

    /**
     * 画面にセットされた内容をクリアします。
     *
     * @param サブ業務コード RString
     * @param 帳票分類ID RString
     */
    void initialize(RString サブ業務コード, RString 帳票分類ID);

    /**
     * 画面にセットされた内容をクリアします。
     *
     * @param 住所設定使用可 boolean
     * @param 宛先住所編集ボタン使用可 boolean
     * @param 都道府県名称表示有無 RString
     * @param 郡名称表示有無 RString
     * @param 方書表示有無 RString
     * @param 住所編集方法 RString
     * @param 市町村名称表示有無 RString
     */
    void initialize_systemKanri(boolean 住所設定使用可, boolean 宛先住所編集ボタン使用可,
            RString 都道府県名称表示有無, RString 郡名称表示有無, RString 市町村名称表示有無, RString 住所編集方法, RString 方書表示有無);

    /**
     * 公開メソッドis帳票独自。
     *
     * @return true
     */
    boolean is帳票独自();

    /**
     * 公開メソッドis帳票独自。
     *
     * @return true
     */
    boolean is都道府県名表示();

    /**
     * 公開メソッドis郡名表示()。
     *
     * @return true
     */
    boolean is郡名表示();

    /**
     * 公開メソッドis市町村名表示()。
     *
     * @return true
     */
    boolean is市町村名表示();

    /**
     * 公開メソッドiget町域編集方法()。
     *
     * @return 町域編集方法
     */
    RString get町域編集方法();

    /**
     * 公開メソッドis方書表示。
     *
     * @return true
     */
    boolean is方書表示();
}
