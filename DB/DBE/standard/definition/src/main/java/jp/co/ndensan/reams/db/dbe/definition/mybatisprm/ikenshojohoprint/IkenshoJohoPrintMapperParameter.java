/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshojohoprint;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 意見書情報印刷のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1390-090 lijia
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class IkenshoJohoPrintMapperParameter implements IMyBatisParameter {

    private final RString 主治医意見書未提出者一覧作成条件;
    private final FlexibleDate 主治医意見書未提出者一覧申請日From;
    private final FlexibleDate 主治医意見書未提出者一覧申請日To;
    private final RString 主治医意見書項目確認一覧表作成条件;
    private final RString 主治医意見書５項目確認一覧表審査会;
    private final RString 主治医意見書依頼未処理者一覧表作成条件;
    private final FlexibleDate 主治医意見書依頼未処理者一覧表申請日From;
    private final FlexibleDate 主治医意見書依頼未処理者一覧表申請日To;
    private final FlexibleDate 主治医意見書作成依頼変更者一覧表申請日From;
    private final FlexibleDate 主治医意見書作成依頼変更者一覧表申請日To;
    private final RString 主治医意見書依頼済み一覧表作成条件;
    private final FlexibleDate 主治医意見書依頼済み一覧表処理日From;
    private final FlexibleDate 主治医意見書依頼済み一覧表処理日To;
    private final FlexibleDate 主治医意見書依頼済み一覧表申請日From;
    private final FlexibleDate 主治医意見書依頼済み一覧表申請日To;
    private final RString 主治医意見書作成料請求一覧表作成条件;
    private final FlexibleDate 主治医意見書作成料請求一覧表処理日From;
    private final FlexibleDate 主治医意見書作成料請求一覧表処理日To;
    private final FlexibleDate 主治医意見書作成料請求一覧表受領日From;
    private final FlexibleDate 主治医意見書作成料請求一覧表受領日To;
    private final RString 処理状態区分_通常;
    private final RString 処理状態区分_延期;
    private final FlexibleDate 主治医意見書作成依頼年月日;
    private final boolean 主治医意見書依頼未処理者一覧表作成条件フラグ;
    private final boolean 主治医意見書未提出者一覧作成条件フラグ;
    private final boolean 主治医意見書未提出者一覧作成条件フラグ2;
    private final boolean 主治医意見書依頼済み一覧表作成条件フラグ;
    private final boolean 主治医意見書依頼済み一覧表作成条件フラグ2;
    private final boolean 主治医意見書項目確認一覧表作成条件フラグ;
    private final boolean 主治医意見書作成料請求一覧表作成条件フラグ;
    private final boolean 主治医意見書作成料請求一覧表作成条件フラグ2;
    private static final RString FLAG_1 = new RString("1");
    private static final RString FLAG_2 = new RString("2");

    /**
     * コンストラクタです。
     *
     * @param 主治医意見書未提出者一覧作成条件 RString
     * @param 主治医意見書未提出者一覧申請日From FlexibleDate
     * @param 主治医意見書未提出者一覧申請日To FlexibleDate
     * @param 主治医意見書項目確認一覧表作成条件 RString
     * @param 主治医意見書５項目確認一覧表審査会 RString
     * @param 主治医意見書依頼未処理者一覧表作成条件 RString
     * @param 主治医意見書依頼未処理者一覧表申請日From FlexibleDate
     * @param 主治医意見書依頼未処理者一覧表申請日To FlexibleDate
     * @param 主治医意見書作成依頼変更者一覧表申請日From FlexibleDate
     * @param 主治医意見書作成依頼変更者一覧表申請日To FlexibleDate
     * @param 主治医意見書依頼済み一覧表作成条件 RString
     * @param 主治医意見書依頼済み一覧表処理日From FlexibleDate
     * @param 主治医意見書依頼済み一覧表処理日To FlexibleDate
     * @param 主治医意見書依頼済み一覧表申請日From FlexibleDate
     * @param 主治医意見書依頼済み一覧表申請日To FlexibleDate
     * @param 主治医意見書作成料請求一覧表作成条件 RString
     * @param 主治医意見書作成料請求一覧表処理日From FlexibleDate
     * @param 主治医意見書作成料請求一覧表処理日To FlexibleDate
     * @param 主治医意見書作成料請求一覧表受領日From FlexibleDate
     * @param 主治医意見書作成料請求一覧表受領日To FlexibleDate
     * @param 処理状態区分_通常 RString
     * @param 処理状態区分_延期 RString
     * @param 主治医意見書作成依頼年月日 FlexibleDate
     * @param 主治医意見書依頼未処理者一覧表作成条件フラグ boolean
     * @param 主治医意見書未提出者一覧作成条件フラグ boolean
     * @param 主治医意見書未提出者一覧作成条件フラグ2 boolean
     * @param 主治医意見書依頼済み一覧表作成条件フラグ boolean
     * @param 主治医意見書依頼済み一覧表作成条件フラグ2 boolean
     * @param 主治医意見書項目確認一覧表作成条件フラグ boolean
     * @param 主治医意見書作成料請求一覧表作成条件フラグ boolean
     * @param 主治医意見書作成料請求一覧表作成条件フラグ2 boolean
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private IkenshoJohoPrintMapperParameter(
            RString 主治医意見書未提出者一覧作成条件,
            FlexibleDate 主治医意見書未提出者一覧申請日From,
            FlexibleDate 主治医意見書未提出者一覧申請日To,
            RString 主治医意見書項目確認一覧表作成条件,
            RString 主治医意見書５項目確認一覧表審査会,
            RString 主治医意見書依頼未処理者一覧表作成条件,
            FlexibleDate 主治医意見書依頼未処理者一覧表申請日From,
            FlexibleDate 主治医意見書依頼未処理者一覧表申請日To,
            FlexibleDate 主治医意見書作成依頼変更者一覧表申請日From,
            FlexibleDate 主治医意見書作成依頼変更者一覧表申請日To,
            RString 主治医意見書依頼済み一覧表作成条件,
            FlexibleDate 主治医意見書依頼済み一覧表処理日From,
            FlexibleDate 主治医意見書依頼済み一覧表処理日To,
            FlexibleDate 主治医意見書依頼済み一覧表申請日From,
            FlexibleDate 主治医意見書依頼済み一覧表申請日To,
            RString 主治医意見書作成料請求一覧表作成条件,
            FlexibleDate 主治医意見書作成料請求一覧表処理日From,
            FlexibleDate 主治医意見書作成料請求一覧表処理日To,
            FlexibleDate 主治医意見書作成料請求一覧表受領日From,
            FlexibleDate 主治医意見書作成料請求一覧表受領日To,
            RString 処理状態区分_通常,
            RString 処理状態区分_延期,
            FlexibleDate 主治医意見書作成依頼年月日,
            boolean 主治医意見書依頼未処理者一覧表作成条件フラグ,
            boolean 主治医意見書未提出者一覧作成条件フラグ,
            boolean 主治医意見書未提出者一覧作成条件フラグ2,
            boolean 主治医意見書依頼済み一覧表作成条件フラグ,
            boolean 主治医意見書依頼済み一覧表作成条件フラグ2,
            boolean 主治医意見書項目確認一覧表作成条件フラグ,
            boolean 主治医意見書作成料請求一覧表作成条件フラグ,
            boolean 主治医意見書作成料請求一覧表作成条件フラグ2
    ) {
        this.主治医意見書未提出者一覧作成条件 = 主治医意見書未提出者一覧作成条件;
        this.主治医意見書未提出者一覧申請日From = 主治医意見書未提出者一覧申請日From;
        this.主治医意見書未提出者一覧申請日To = 主治医意見書未提出者一覧申請日To;
        this.主治医意見書項目確認一覧表作成条件 = 主治医意見書項目確認一覧表作成条件;
        this.主治医意見書５項目確認一覧表審査会 = 主治医意見書５項目確認一覧表審査会;
        this.主治医意見書依頼未処理者一覧表作成条件 = 主治医意見書依頼未処理者一覧表作成条件;
        this.主治医意見書依頼未処理者一覧表申請日From = 主治医意見書依頼未処理者一覧表申請日From;
        this.主治医意見書依頼未処理者一覧表申請日To = 主治医意見書依頼未処理者一覧表申請日To;
        this.主治医意見書作成依頼変更者一覧表申請日From = 主治医意見書作成依頼変更者一覧表申請日From;
        this.主治医意見書作成依頼変更者一覧表申請日To = 主治医意見書作成依頼変更者一覧表申請日To;
        this.主治医意見書依頼済み一覧表作成条件 = 主治医意見書依頼済み一覧表作成条件;
        this.主治医意見書依頼済み一覧表処理日From = 主治医意見書依頼済み一覧表処理日From;
        this.主治医意見書依頼済み一覧表処理日To = 主治医意見書依頼済み一覧表処理日To;
        this.主治医意見書依頼済み一覧表申請日From = 主治医意見書依頼済み一覧表申請日From;
        this.主治医意見書依頼済み一覧表申請日To = 主治医意見書依頼済み一覧表申請日To;
        this.主治医意見書作成料請求一覧表作成条件 = 主治医意見書作成料請求一覧表作成条件;
        this.主治医意見書作成料請求一覧表処理日From = 主治医意見書作成料請求一覧表処理日From;
        this.主治医意見書作成料請求一覧表処理日To = 主治医意見書作成料請求一覧表処理日To;
        this.主治医意見書作成料請求一覧表受領日From = 主治医意見書作成料請求一覧表受領日From;
        this.主治医意見書作成料請求一覧表受領日To = 主治医意見書作成料請求一覧表受領日To;
        this.処理状態区分_通常 = 処理状態区分_通常;
        this.処理状態区分_延期 = 処理状態区分_延期;
        this.主治医意見書作成依頼年月日 = 主治医意見書作成依頼年月日;
        this.主治医意見書依頼未処理者一覧表作成条件フラグ = 主治医意見書依頼未処理者一覧表作成条件フラグ;
        this.主治医意見書未提出者一覧作成条件フラグ = 主治医意見書未提出者一覧作成条件フラグ;
        this.主治医意見書未提出者一覧作成条件フラグ2 = 主治医意見書未提出者一覧作成条件フラグ2;
        this.主治医意見書依頼済み一覧表作成条件フラグ = 主治医意見書依頼済み一覧表作成条件フラグ;
        this.主治医意見書依頼済み一覧表作成条件フラグ2 = 主治医意見書依頼済み一覧表作成条件フラグ2;
        this.主治医意見書項目確認一覧表作成条件フラグ = 主治医意見書項目確認一覧表作成条件フラグ;
        this.主治医意見書作成料請求一覧表作成条件フラグ = 主治医意見書作成料請求一覧表作成条件フラグ;
        this.主治医意見書作成料請求一覧表作成条件フラグ2 = 主治医意見書作成料請求一覧表作成条件フラグ2;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 主治医意見書未提出者一覧作成条件 RString
     * @param 主治医意見書未提出者一覧申請日From FlexibleDate
     * @param 主治医意見書未提出者一覧申請日To FlexibleDate
     * @param 主治医意見書項目確認一覧表作成条件 RString
     * @param 主治医意見書５項目確認一覧表審査会 RString
     * @param 主治医意見書依頼未処理者一覧表作成条件 RString
     * @param 主治医意見書依頼未処理者一覧表申請日From FlexibleDate
     * @param 主治医意見書依頼未処理者一覧表申請日To FlexibleDate
     * @param 主治医意見書作成依頼変更者一覧表申請日From FlexibleDate
     * @param 主治医意見書作成依頼変更者一覧表申請日To FlexibleDate
     * @param 主治医意見書依頼済み一覧表作成条件 RString
     * @param 主治医意見書依頼済み一覧表処理日From FlexibleDate
     * @param 主治医意見書依頼済み一覧表処理日To FlexibleDate
     * @param 主治医意見書依頼済み一覧表申請日From FlexibleDate
     * @param 主治医意見書依頼済み一覧表申請日To FlexibleDate
     * @param 主治医意見書作成料請求一覧表作成条件 RString
     * @param 主治医意見書作成料請求一覧表処理日From FlexibleDate
     * @param 主治医意見書作成料請求一覧表処理日To FlexibleDate
     * @param 主治医意見書作成料請求一覧表受領日From FlexibleDate
     * @param 主治医意見書作成料請求一覧表受領日To FlexibleDate
     * @param 処理状態区分_通常 RString
     * @param 処理状態区分_延期 RString
     * @param 主治医意見書作成依頼年月日 FlexibleDate
     * @return 身体手帳検索パラメータ
     */
    public static IkenshoJohoPrintMapperParameter createSelectByKeyParam(
            RString 主治医意見書未提出者一覧作成条件,
            FlexibleDate 主治医意見書未提出者一覧申請日From,
            FlexibleDate 主治医意見書未提出者一覧申請日To,
            RString 主治医意見書項目確認一覧表作成条件,
            RString 主治医意見書５項目確認一覧表審査会,
            RString 主治医意見書依頼未処理者一覧表作成条件,
            FlexibleDate 主治医意見書依頼未処理者一覧表申請日From,
            FlexibleDate 主治医意見書依頼未処理者一覧表申請日To,
            FlexibleDate 主治医意見書作成依頼変更者一覧表申請日From,
            FlexibleDate 主治医意見書作成依頼変更者一覧表申請日To,
            RString 主治医意見書依頼済み一覧表作成条件,
            FlexibleDate 主治医意見書依頼済み一覧表処理日From,
            FlexibleDate 主治医意見書依頼済み一覧表処理日To,
            FlexibleDate 主治医意見書依頼済み一覧表申請日From,
            FlexibleDate 主治医意見書依頼済み一覧表申請日To,
            RString 主治医意見書作成料請求一覧表作成条件,
            FlexibleDate 主治医意見書作成料請求一覧表処理日From,
            FlexibleDate 主治医意見書作成料請求一覧表処理日To,
            FlexibleDate 主治医意見書作成料請求一覧表受領日From,
            FlexibleDate 主治医意見書作成料請求一覧表受領日To,
            RString 処理状態区分_通常,
            RString 処理状態区分_延期,
            FlexibleDate 主治医意見書作成依頼年月日) {
        return new IkenshoJohoPrintMapperParameter(
                主治医意見書未提出者一覧作成条件,
                主治医意見書未提出者一覧申請日From,
                主治医意見書未提出者一覧申請日To,
                主治医意見書項目確認一覧表作成条件,
                主治医意見書５項目確認一覧表審査会,
                主治医意見書依頼未処理者一覧表作成条件,
                主治医意見書依頼未処理者一覧表申請日From,
                主治医意見書依頼未処理者一覧表申請日To,
                主治医意見書作成依頼変更者一覧表申請日From,
                主治医意見書作成依頼変更者一覧表申請日To,
                主治医意見書依頼済み一覧表作成条件,
                主治医意見書依頼済み一覧表処理日From,
                主治医意見書依頼済み一覧表処理日To,
                主治医意見書依頼済み一覧表申請日From,
                主治医意見書依頼済み一覧表申請日To,
                主治医意見書作成料請求一覧表作成条件,
                主治医意見書作成料請求一覧表処理日From,
                主治医意見書作成料請求一覧表処理日To,
                主治医意見書作成料請求一覧表受領日From,
                主治医意見書作成料請求一覧表受領日To,
                処理状態区分_通常,
                処理状態区分_延期,
                主治医意見書作成依頼年月日,
                FLAG_2.equals(主治医意見書依頼未処理者一覧表作成条件),
                FLAG_1.equals(主治医意見書未提出者一覧作成条件),
                FLAG_2.equals(主治医意見書未提出者一覧作成条件),
                FLAG_1.equals(主治医意見書依頼済み一覧表作成条件),
                FLAG_2.equals(主治医意見書依頼済み一覧表作成条件),
                FLAG_2.equals(主治医意見書項目確認一覧表作成条件),
                FLAG_1.equals(主治医意見書作成料請求一覧表作成条件),
                FLAG_2.equals(主治医意見書作成料請求一覧表作成条件)
        );
    }
}
