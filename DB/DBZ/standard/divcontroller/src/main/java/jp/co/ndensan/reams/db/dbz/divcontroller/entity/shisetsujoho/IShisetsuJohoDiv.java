package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.入力補助;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.台帳種別;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.施設種類;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 * このコードはツールによって生成されました。
 */
public interface IShisetsuJohoDiv {

    DropDownList getDdlDaichoShubetsu();

    RadioButton getRadShisetsuShurui();

    TextBoxCode getTxtShisetsuCode();

    ButtonDialog getBtnJigyoshaInputGuide();

    ButtonDialog getBtnOtherTokureiShisetsuInputGuide();

    ButtonDialog getBtnJogaiShisetsuInputGuide();

    TextBox getTxtShisetsuMeisho();

    RString getSelectRow();

    RString getInputMode();

    台帳種別 getMode_台帳種別();

    void setMode_台帳種別(台帳種別 value);

    施設種類 getMode_施設種類();

    void setMode_施設種類(ShisetsuJohoDiv.施設種類 value);

    入力補助 getMode_入力補助();

    void setMode_入力補助(ShisetsuJohoDiv.入力補助 value);

    /**
     * 施設種類ラジオボタンの選択項目が変更された際に実行します。
     */
    void onChange_radShisetsuShurui();

    /**
     * 台帳種別DropDonwnListの選択項目が変更された際に実行します。
     */
//    void onChange_ddlDaichoShubetsu();
}
