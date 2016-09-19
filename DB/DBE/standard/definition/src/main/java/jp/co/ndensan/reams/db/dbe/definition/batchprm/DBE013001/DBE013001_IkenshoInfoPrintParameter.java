/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE013001;

import jp.co.ndensan.reams.db.dbe.definition.processprm.ikenshojohoprint.IkenshoJohoPrintProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書情報印刷ののMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1390-090 lijia
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBE013001_IkenshoInfoPrintParameter extends BatchParameterBase {

    private static final long serialVersionUID = -7349208346467269276L;
    private static final String 未提出者一覧フラグ = "主治医意見書未提出者一覧フラグ";
    private static final String 未提出者一覧作成条件 = "主治医意見書未提出者一覧作成条件";
    private static final String 未提出者一覧依頼日数 = "主治医意見書未提出者一覧依頼日数";
    private static final String 未提出者一覧申請開始日 = "主治医意見書未提出者一覧申請日From";
    private static final String 未提出者一覧申請終了日 = "主治医意見書未提出者一覧申請日To";
    private static final String 項目確認一覧表フラグ = "主治医意見書５項目確認一覧表フラグ";
    private static final String 項目確認一覧表作成条件 = "主治医意見書５項目確認一覧表作成条件";
    private static final String 項目確認一覧表審査会 = "主治医意見書５項目確認一覧表審査会";
    private static final String 依頼未処理者一覧表フラグ = "主治医意見書依頼未処理者一覧表フラグ";
    private static final String 依頼未処理者一覧表作成条件 = "主治医意見書依頼未処理者一覧表作成条件";
    private static final String 依頼未処理者一覧表申請開始日 = "主治医意見書依頼未処理者一覧表申請日From";
    private static final String 依頼未処理者一覧表申請終了日 = "主治医意見書依頼未処理者一覧表申請日To";
    private static final String 作成依頼変更者一覧表フラグ = "主治医意見書作成依頼変更者一覧表フラグ";
    private static final String 作成依頼変更者一覧表申請開始日 = "主治医意見書作成依頼変更者一覧表申請日From";
    private static final String 作成依頼変更者一覧表申請終了日 = "主治医意見書作成依頼変更者一覧表申請日To";
    private static final String 依頼済み一覧表フラグ = "主治医意見書依頼済み一覧表フラグ";
    private static final String 依頼済み一覧表作成条件 = "主治医意見書依頼済み一覧表作成条件";
    private static final String 依頼済み一覧表処理開始日 = "主治医意見書依頼済み一覧表処理日From";
    private static final String 依頼済み一覧表処理終了日 = "主治医意見書依頼済み一覧表処理日To";
    private static final String 依頼済み一覧表申請開始日 = "主治医意見書依頼済み一覧表申請日From";
    private static final String 依頼済み一覧表申請終了日 = "主治医意見書依頼済み一覧表申請日To";
    private static final String 作成料請求一覧表フラグ = "主治医意見書作成料請求一覧表フラグ";
    private static final String 作成料請求一覧表作成条件 = "主治医意見書作成料請求一覧表作成条件";
    private static final String 作成料請求一覧表処理開始日 = "主治医意見書作成料請求一覧表処理日From";
    private static final String 作成料請求一覧表処理終了日 = "主治医意見書作成料請求一覧表処理日To";
    private static final String 作成料請求一覧表受領開始日 = "主治医意見書作成料請求一覧表受領日From";
    private static final String 作成料請求一覧表受領終了日 = "主治医意見書作成料請求一覧表受領日To";

    @BatchParameter(key = 未提出者一覧フラグ, name = "主治医意見書未提出者一覧フラグ")
    private boolean 主治医意見書未提出者一覧フラグ;
    @BatchParameter(key = 未提出者一覧作成条件, name = "主治医意見書未提出者一覧作成条件")
    private RString 主治医意見書未提出者一覧作成条件;
    @BatchParameter(key = 未提出者一覧依頼日数, name = "主治医意見書未提出者一覧依頼日数")
    private RString 主治医意見書未提出者一覧依頼日数;
    @BatchParameter(key = 未提出者一覧申請開始日, name = "主治医意見書未提出者一覧申請日From")
    private FlexibleDate 主治医意見書未提出者一覧申請日From;
    @BatchParameter(key = 未提出者一覧申請終了日, name = "主治医意見書未提出者一覧申請日To")
    private FlexibleDate 主治医意見書未提出者一覧申請日To;
    @BatchParameter(key = 項目確認一覧表フラグ, name = "主治医意見書５項目確認一覧表フラグ")
    private boolean 主治医意見書５項目確認一覧表フラグ;
    @BatchParameter(key = 項目確認一覧表作成条件, name = "主治医意見書５項目確認一覧表作成条件")
    private RString 主治医意見書５項目確認一覧表作成条件;
    @BatchParameter(key = 項目確認一覧表審査会, name = "主治医意見書５項目確認一覧表審査会")
    private RString 主治医意見書５項目確認一覧表審査会;
    @BatchParameter(key = 依頼未処理者一覧表フラグ, name = "主治医意見書依頼未処理者一覧表フラグ")
    private boolean 主治医意見書依頼未処理者一覧表フラグ;
    @BatchParameter(key = 依頼未処理者一覧表作成条件, name = "主治医意見書依頼未処理者一覧表作成条件")
    private RString 主治医意見書依頼未処理者一覧表作成条件;
    @BatchParameter(key = 依頼未処理者一覧表申請開始日, name = "主治医意見書依頼未処理者一覧表申請日From")
    private FlexibleDate 主治医意見書依頼未処理者一覧表申請日From;
    @BatchParameter(key = 依頼未処理者一覧表申請終了日, name = "主治医意見書依頼未処理者一覧表申請日To")
    private FlexibleDate 主治医意見書依頼未処理者一覧表申請日To;
    @BatchParameter(key = 作成依頼変更者一覧表フラグ, name = "主治医意見書作成依頼変更者一覧表フラグ")
    private boolean 主治医意見書作成依頼変更者一覧表フラグ;
    @BatchParameter(key = 作成依頼変更者一覧表申請開始日, name = "主治医意見書作成依頼変更者一覧表申請日From")
    private FlexibleDate 主治医意見書作成依頼変更者一覧表申請日From;
    @BatchParameter(key = 作成依頼変更者一覧表申請終了日, name = "主治医意見書作成依頼変更者一覧表申請日To")
    private FlexibleDate 主治医意見書作成依頼変更者一覧表申請日To;
    @BatchParameter(key = 依頼済み一覧表フラグ, name = "主治医意見書依頼済み一覧表フラグ")
    private boolean 主治医意見書依頼済み一覧表フラグ;
    @BatchParameter(key = 依頼済み一覧表作成条件, name = "主治医意見書依頼済み一覧表作成条件")
    private RString 主治医意見書依頼済み一覧表作成条件;
    @BatchParameter(key = 依頼済み一覧表処理開始日, name = "主治医意見書依頼済み一覧表処理日From")
    private FlexibleDate 主治医意見書依頼済み一覧表処理日From;
    @BatchParameter(key = 依頼済み一覧表処理終了日, name = "主治医意見書依頼済み一覧表処理日To")
    private FlexibleDate 主治医意見書依頼済み一覧表処理日To;
    @BatchParameter(key = 依頼済み一覧表申請開始日, name = "主治医意見書依頼済み一覧表申請日From")
    private FlexibleDate 主治医意見書依頼済み一覧表申請日From;
    @BatchParameter(key = 依頼済み一覧表申請終了日, name = "主治医意見書依頼済み一覧表申請日To")
    private FlexibleDate 主治医意見書依頼済み一覧表申請日To;
    @BatchParameter(key = 作成料請求一覧表フラグ, name = "主治医意見書作成料請求一覧表フラグ")
    private boolean 主治医意見書作成料請求一覧表フラグ;
    @BatchParameter(key = 作成料請求一覧表作成条件, name = "主治医意見書作成料請求一覧表作成条件")
    private RString 主治医意見書作成料請求一覧表作成条件;
    @BatchParameter(key = 作成料請求一覧表処理開始日, name = "主治医意見書作成料請求一覧表処理日From")
    private FlexibleDate 主治医意見書作成料請求一覧表処理日From;
    @BatchParameter(key = 作成料請求一覧表処理終了日, name = "主治医意見書作成料請求一覧表処理日To")
    private FlexibleDate 主治医意見書作成料請求一覧表処理日To;
    @BatchParameter(key = 作成料請求一覧表受領開始日, name = "主治医意見書作成料請求一覧表受領日From")
    private FlexibleDate 主治医意見書作成料請求一覧表受領日From;
    @BatchParameter(key = 作成料請求一覧表受領終了日, name = "主治医意見書作成料請求一覧表受領日To")
    private FlexibleDate 主治医意見書作成料請求一覧表受領日To;

    /**
     * コンストラクタです。
     */
    public DBE013001_IkenshoInfoPrintParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param 主治医意見書未提出者一覧フラグ boolean
     * @param 主治医意見書未提出者一覧作成条件 RString
     * @param 主治医意見書未提出者一覧依頼日数 RString
     * @param 主治医意見書未提出者一覧申請日From FlexibleDate
     * @param 主治医意見書未提出者一覧申請日To FlexibleDate
     * @param 主治医意見書５項目確認一覧表フラグ boolean
     * @param 主治医意見書５項目確認一覧表作成条件 RString
     * @param 主治医意見書５項目確認一覧表審査会 RString
     * @param 主治医意見書依頼未処理者一覧表フラグ boolean
     * @param 主治医意見書依頼未処理者一覧表作成条件 RString
     * @param 主治医意見書依頼未処理者一覧表申請日From FlexibleDate
     * @param 主治医意見書依頼未処理者一覧表申請日To FlexibleDate
     * @param 主治医意見書作成依頼変更者一覧表フラグ boolean
     * @param 主治医意見書作成依頼変更者一覧表申請日From FlexibleDate
     * @param 主治医意見書作成依頼変更者一覧表申請日To FlexibleDate
     * @param 主治医意見書依頼済み一覧表フラグ boolean
     * @param 主治医意見書依頼済み一覧表作成条件 RString
     * @param 主治医意見書依頼済み一覧表処理日From FlexibleDate
     * @param 主治医意見書依頼済み一覧表処理日To FlexibleDate
     * @param 主治医意見書依頼済み一覧表申請日From FlexibleDate
     * @param 主治医意見書依頼済み一覧表申請日To FlexibleDate
     * @param 主治医意見書作成料請求一覧表フラグ boolean
     * @param 主治医意見書作成料請求一覧表作成条件 RString
     * @param 主治医意見書作成料請求一覧表処理日From FlexibleDate
     * @param 主治医意見書作成料請求一覧表処理日To FlexibleDate
     * @param 主治医意見書作成料請求一覧表受領日From FlexibleDate
     * @param 主治医意見書作成料請求一覧表受領日To FlexibleDate
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public DBE013001_IkenshoInfoPrintParameter(
            boolean 主治医意見書未提出者一覧フラグ,
            RString 主治医意見書未提出者一覧作成条件,
            RString 主治医意見書未提出者一覧依頼日数,
            FlexibleDate 主治医意見書未提出者一覧申請日From,
            FlexibleDate 主治医意見書未提出者一覧申請日To,
            boolean 主治医意見書５項目確認一覧表フラグ,
            RString 主治医意見書５項目確認一覧表作成条件,
            RString 主治医意見書５項目確認一覧表審査会,
            boolean 主治医意見書依頼未処理者一覧表フラグ,
            RString 主治医意見書依頼未処理者一覧表作成条件,
            FlexibleDate 主治医意見書依頼未処理者一覧表申請日From,
            FlexibleDate 主治医意見書依頼未処理者一覧表申請日To,
            boolean 主治医意見書作成依頼変更者一覧表フラグ,
            FlexibleDate 主治医意見書作成依頼変更者一覧表申請日From,
            FlexibleDate 主治医意見書作成依頼変更者一覧表申請日To,
            boolean 主治医意見書依頼済み一覧表フラグ,
            RString 主治医意見書依頼済み一覧表作成条件,
            FlexibleDate 主治医意見書依頼済み一覧表処理日From,
            FlexibleDate 主治医意見書依頼済み一覧表処理日To,
            FlexibleDate 主治医意見書依頼済み一覧表申請日From,
            FlexibleDate 主治医意見書依頼済み一覧表申請日To,
            boolean 主治医意見書作成料請求一覧表フラグ,
            RString 主治医意見書作成料請求一覧表作成条件,
            FlexibleDate 主治医意見書作成料請求一覧表処理日From,
            FlexibleDate 主治医意見書作成料請求一覧表処理日To,
            FlexibleDate 主治医意見書作成料請求一覧表受領日From,
            FlexibleDate 主治医意見書作成料請求一覧表受領日To) {
        this.主治医意見書未提出者一覧フラグ = 主治医意見書未提出者一覧フラグ;
        this.主治医意見書未提出者一覧作成条件 = 主治医意見書未提出者一覧作成条件;
        this.主治医意見書未提出者一覧依頼日数 = 主治医意見書未提出者一覧依頼日数;
        this.主治医意見書未提出者一覧申請日From = 主治医意見書未提出者一覧申請日From;
        this.主治医意見書未提出者一覧申請日To = 主治医意見書未提出者一覧申請日To;
        this.主治医意見書５項目確認一覧表フラグ = 主治医意見書５項目確認一覧表フラグ;
        this.主治医意見書５項目確認一覧表作成条件 = 主治医意見書５項目確認一覧表作成条件;
        this.主治医意見書５項目確認一覧表審査会 = 主治医意見書５項目確認一覧表審査会;
        this.主治医意見書依頼未処理者一覧表フラグ = 主治医意見書依頼未処理者一覧表フラグ;
        this.主治医意見書依頼未処理者一覧表作成条件 = 主治医意見書依頼未処理者一覧表作成条件;
        this.主治医意見書依頼未処理者一覧表申請日From = 主治医意見書依頼未処理者一覧表申請日From;
        this.主治医意見書依頼未処理者一覧表申請日To = 主治医意見書依頼未処理者一覧表申請日To;
        this.主治医意見書作成依頼変更者一覧表フラグ = 主治医意見書作成依頼変更者一覧表フラグ;
        this.主治医意見書作成依頼変更者一覧表申請日From = 主治医意見書作成依頼変更者一覧表申請日From;
        this.主治医意見書作成依頼変更者一覧表申請日To = 主治医意見書作成依頼変更者一覧表申請日To;
        this.主治医意見書依頼済み一覧表フラグ = 主治医意見書依頼済み一覧表フラグ;
        this.主治医意見書依頼済み一覧表作成条件 = 主治医意見書依頼済み一覧表作成条件;
        this.主治医意見書依頼済み一覧表処理日From = 主治医意見書依頼済み一覧表処理日From;
        this.主治医意見書依頼済み一覧表処理日To = 主治医意見書依頼済み一覧表処理日To;
        this.主治医意見書依頼済み一覧表申請日From = 主治医意見書依頼済み一覧表申請日From;
        this.主治医意見書依頼済み一覧表申請日To = 主治医意見書依頼済み一覧表申請日To;
        this.主治医意見書作成料請求一覧表フラグ = 主治医意見書作成料請求一覧表フラグ;
        this.主治医意見書作成料請求一覧表作成条件 = 主治医意見書作成料請求一覧表作成条件;
        this.主治医意見書作成料請求一覧表処理日From = 主治医意見書作成料請求一覧表処理日From;
        this.主治医意見書作成料請求一覧表処理日To = 主治医意見書作成料請求一覧表処理日To;
        this.主治医意見書作成料請求一覧表受領日From = 主治医意見書作成料請求一覧表受領日From;
        this.主治医意見書作成料請求一覧表受領日To = 主治医意見書作成料請求一覧表受領日To;
    }

    /**
     * 意見書情報印刷のバッチのパラメータを設定します。
     *
     * @return 意見書情報印刷のProcessParameter
     */
    public IkenshoJohoPrintProcessParameter toIkenshoJohoPrintProcessParameter() {
        return new IkenshoJohoPrintProcessParameter(
                主治医意見書未提出者一覧フラグ,
                主治医意見書未提出者一覧作成条件,
                主治医意見書未提出者一覧依頼日数,
                主治医意見書未提出者一覧申請日From,
                主治医意見書未提出者一覧申請日To,
                主治医意見書５項目確認一覧表フラグ,
                主治医意見書５項目確認一覧表作成条件,
                主治医意見書５項目確認一覧表審査会,
                主治医意見書依頼未処理者一覧表フラグ,
                主治医意見書依頼未処理者一覧表作成条件,
                主治医意見書依頼未処理者一覧表申請日From,
                主治医意見書依頼未処理者一覧表申請日To,
                主治医意見書作成依頼変更者一覧表フラグ,
                主治医意見書作成依頼変更者一覧表申請日From,
                主治医意見書作成依頼変更者一覧表申請日To,
                主治医意見書依頼済み一覧表フラグ,
                主治医意見書依頼済み一覧表作成条件,
                主治医意見書依頼済み一覧表処理日From,
                主治医意見書依頼済み一覧表処理日To,
                主治医意見書依頼済み一覧表申請日From,
                主治医意見書依頼済み一覧表申請日To,
                主治医意見書作成料請求一覧表フラグ,
                主治医意見書作成料請求一覧表作成条件,
                主治医意見書作成料請求一覧表処理日From,
                主治医意見書作成料請求一覧表処理日To,
                主治医意見書作成料請求一覧表受領日From,
                主治医意見書作成料請求一覧表受領日To);
    }

}
