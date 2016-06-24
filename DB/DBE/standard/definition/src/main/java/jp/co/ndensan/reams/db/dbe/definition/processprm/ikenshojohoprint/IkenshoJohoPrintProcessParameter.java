/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ikenshojohoprint;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshojohoprint.IkenshoJohoPrintMapperParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書情報印刷のProcessParameterです。
 *
 * @reamsid_L DBE-1390-090 lijia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoJohoPrintProcessParameter implements IBatchProcessParameter {

    private boolean 主治医意見書未提出者一覧フラグ;
    private RString 主治医意見書未提出者一覧作成条件;
    private RString 主治医意見書未提出者一覧依頼日数;
    private FlexibleDate 主治医意見書未提出者一覧申請日From;
    private FlexibleDate 主治医意見書未提出者一覧申請日To;
    private boolean 主治医意見書５項目確認一覧表フラグ;
    private RString 主治医意見書５項目確認一覧表作成条件;
    private RString 主治医意見書５項目確認一覧表審査会;
    private boolean 主治医意見書依頼未処理者一覧表フラグ;
    private RString 主治医意見書依頼未処理者一覧表作成条件;
    private FlexibleDate 主治医意見書依頼未処理者一覧表申請日From;
    private FlexibleDate 主治医意見書依頼未処理者一覧表申請日To;
    private boolean 主治医意見書作成依頼変更者一覧表フラグ;
    private FlexibleDate 主治医意見書作成依頼変更者一覧表申請日From;
    private FlexibleDate 主治医意見書作成依頼変更者一覧表申請日To;
    private boolean 主治医意見書依頼済み一覧表フラグ;
    private RString 主治医意見書依頼済み一覧表作成条件;
    private FlexibleDate 主治医意見書依頼済み一覧表処理日From;
    private FlexibleDate 主治医意見書依頼済み一覧表処理日To;
    private FlexibleDate 主治医意見書依頼済み一覧表申請日From;
    private FlexibleDate 主治医意見書依頼済み一覧表申請日To;
    private boolean 主治医意見書作成料請求一覧表フラグ;
    private RString 主治医意見書作成料請求一覧表作成条件;
    private FlexibleDate 主治医意見書作成料請求一覧表処理日From;
    private FlexibleDate 主治医意見書作成料請求一覧表処理日To;
    private FlexibleDate 主治医意見書作成料請求一覧表受領日From;
    private FlexibleDate 主治医意見書作成料請求一覧表受領日To;

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
    public IkenshoJohoPrintProcessParameter(
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
     * IkenshoJohoPrintMapperParameterに転換します。
     *
     * @return IkenshoJohoPrintMapperParameter
     */
    public IkenshoJohoPrintMapperParameter toSinsakaiHanteiJyokyoMyBatisParameter() {
        RDate 年月日 = RDate.getNowDate();
        if (!RString.isNullOrEmpty(主治医意見書未提出者一覧依頼日数)) {
            年月日 = RDate.getNowDate().minusDay(Integer.parseInt(主治医意見書未提出者一覧依頼日数.toString()));
        }
        return IkenshoJohoPrintMapperParameter.createSelectByKeyParam(
                主治医意見書未提出者一覧作成条件,
                主治医意見書未提出者一覧申請日From,
                主治医意見書未提出者一覧申請日To,
                主治医意見書５項目確認一覧表作成条件,
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
                ShoriJotaiKubun.通常.getコード(),
                ShoriJotaiKubun.延期.getコード(),
                年月日.toFlexibleDate());
    }
}
