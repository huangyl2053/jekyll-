package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushosettei.KaigoAtesakiJushoSettei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
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
     * 公開メソッドis帳票独自。
     *
     */
    void is帳票独自();

    /**
     * 公開メソッドis帳票独自。
     *
     */
    void is都道府県名表示();

    /**
     * 公開メソッドis郡名表示()。
     *
     */
    void is郡名表示();

    /**
     * 公開メソッドis市町村名表示()。
     *
     */
    void is市町村名表示();

    /**
     * 公開メソッドiget町域編集方法()。
     *
     */
    void get町域編集方法();

    /**
     * 公開メソッドis方書表示。
     *
     */
    void is方書表示();
}
