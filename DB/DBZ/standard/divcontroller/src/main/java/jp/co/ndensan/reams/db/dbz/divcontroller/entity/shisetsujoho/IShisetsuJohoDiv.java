package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.事業者選択;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.他特例施設選択;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.施設選択表示;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.除外施設選択;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 * このコードはツールによって生成されました。
 */
public interface IShisetsuJohoDiv {

    RadioButton getRadShisetsuShurui();

    Label getLblOtherShisetsuShurui();

    TextBoxCode getTxtShisetsuCode();

    ButtonDialog getBtnJigyoshaInputGuide();

    ButtonDialog getBtnOtherTokureiShisetsuInputGuide();

    ButtonDialog getBtnJogaiShisetsuInputGuide();

    TextBox getTxtShisetsuMeisho();

    RString getSelectRow();

    RString getInputMode();

    除外施設選択 getMode_除外施設選択();

    void setMode_除外施設選択(除外施設選択 value);

    他特例施設選択 getMode_他特例施設選択();

    void setMode_他特例施設選択(他特例施設選択 value);

    事業者選択 getMode_事業者選択();

    void setMode_事業者選択(事業者選択 value);

    施設選択表示 getMode_施設選択表示();

    void setMode_施設選択表示(施設選択表示 value);

    /**
     * 施設種類ラジオボタンの選択項目が変更された際に実行します。
     */
    void onChange_radShisetsuShurui();
}
