package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyoshosai;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * 共有子Div「証回収状況詳細」において、外部に公開する処理を定義したインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IShoKaishuJokyoShosaiDiv {

    /**
     * 証交付種類を持つTextBoxを返します。
     *
     * @return 証交付種類を持つTextBox
     */
    TextBox getTxtShoKofuShurui();

    /**
     * 交付日を持つTextBoxを返します。
     *
     * @return 交付日を持つTextBoxFlexibleDate
     */
    TextBoxFlexibleDate getTxtKofuDate();

    /**
     * 交付期限を持つTextBoxを返します。
     *
     * @return 交付期限を持つTextBoxFlexibleDate
     */
    TextBoxFlexibleDate getTxtYukoKigen();

    /**
     * 交付事由を持つTextBox返します。
     *
     * @return　交付事由を持つTextBox
     */
    TextBox getTxtKofuJiyu();

    /**
     * 交付理由をもつTextBoxを返します。
     *
     * @return　交付理由を持つTextBoxMultiLine
     */
    TextBoxMultiLine getTxtKofuRiyu();

    /**
     * 回収日を持つTextBoxを返します。
     *
     * @return 回収日を持つTextBoxFlexibleDate
     */
    TextBoxFlexibleDate getTxtKaishuDate();

    /**
     * 回収事由を持つDropDownListを返します。
     *
     * @return 回収事由を持つDropDownList
     */
    DropDownList getDdlKaishuJiyu();

    /**
     * 回収理由をもつTextBoxMultiLineを返します。
     *
     * @return 回収理由をもつTextBoxMultiLine
     */
    TextBoxMultiLine getTxtKaishuRiyu();
}
