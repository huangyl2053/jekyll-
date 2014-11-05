package jp.co.ndensan.reams.db.dbz.divcontroller.entity.neiReiTotatsuSrchConInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.neiReiTotatsuSrchConInfo.NenReiTotatsuSrchConInfoDiv.DisplayMode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * このコードはツールによって生成されました。
 */
public interface INenReiTotatsuSrchConInfoDiv {

    TextBoxFlexibleDate getTxtZenkaiFrom();

    void setTxtZenkaiFrom(TextBoxFlexibleDate txtZenkaiFrom);

    TextBoxFlexibleDate getTxtZenkaiTo();

    void setTxtZenkaiTo(TextBoxFlexibleDate txtZenkaiTo);

    Button getBtnKensaku();

    void setBtnKensaku(Button btnKensaku);

    TextBoxFlexibleDate getTxtNenreiTotatsuKikanTo();

    void setTxtNenreiTotatsuKikanTo(TextBoxFlexibleDate txtNenreiTotatsuKikanTo);

    TextBoxFlexibleDate getTxtNenreiTotatsuKikanFrom();

    void setTxtNenreiTotatsuKikanFrom(TextBoxFlexibleDate txtNenreiTotatsuKikanFrom);

    DisplayMode getMode_DisplayMode();

    void setMode_DisplayMode(DisplayMode value);

}
