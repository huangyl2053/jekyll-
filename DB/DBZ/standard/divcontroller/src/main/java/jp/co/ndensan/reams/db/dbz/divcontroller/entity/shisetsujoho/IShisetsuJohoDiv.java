package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho;

import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 * このコードはツールによって生成されました。
 */
public interface IShisetsuJohoDiv {

    /**
     * 台帳種別をもつDropDownListを返します。
     *
     * @return 台帳種別を持つDropDownList
     */
    DropDownList getDdlDaichoShubetsu();

    /**
     * 施設種類を持つRadioButtonを返します。
     *
     * @return 施設種類を持つRadioButton
     */
    RadioButton getRadShisetsuShurui();

    /**
     * 施設コードをもつTextBoxCodeを返します。
     *
     * @return 施設コードをもつTextBoxCode
     */
    TextBoxCode getTxtShisetsuCode();

    /**
     * 施設名称をもつTextBoxを返します。
     *
     * @return 施設名称をもつTextBox
     */
    TextBox getTxtShisetsuMeisho();

    /**
     * 自身のハンドラクラスを返します。
     *
     * @return 自身のハンドラ
     */
    ShisetsuJohoHandler getHandler();

}
