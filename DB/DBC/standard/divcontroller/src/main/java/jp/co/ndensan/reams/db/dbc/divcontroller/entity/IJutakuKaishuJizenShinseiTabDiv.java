package jp.co.ndensan.reams.db.dbc.divcontroller.entity;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinseishaInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.PaymentMethodDiv;

/**
 * このコードはツールによって生成されました。
 */

public interface IJutakuKaishuJizenShinseiTabDiv {

    tabJizenShinseiDiv getTabJizenShinsei();

    void setTabJizenShinsei(tabJizenShinseiDiv tabJizenShinsei);

    Button getBtnClose();

    void setBtnClose(Button btnClose);

    tplJizenShinseiContentsDiv getTplJizenShinseiContents();

    void setTplJizenShinseiContents(tplJizenShinseiContentsDiv tplJizenShinseiContents);

    TextBox getTxtJutakuOwner();

    void setTxtJutakuOwner(TextBox txtJutakuOwner);

    TextBox getTxtRelationWithHihokensha();

    void setTxtRelationWithHihokensha(TextBox txtRelationWithHihokensha);

    DataGrid<dgJutakuKaishuJizenShinseiDetail_Row> getDgJutakuKaishuJizenShinseiDetail();

    void setDgJutakuKaishuJizenShinseiDetail(DataGrid<dgJutakuKaishuJizenShinseiDetail_Row> dgJutakuKaishuJizenShinseiDetail);

    ShinseishaInfoDiv getJutakuKaishuJizenShinseisha();

    JutakuKaishuJizenShinseiReasonForTabDiv getJutakuKaishuJizenShinseiReasonForTab();

    void setJutakuKaishuJizenShinseiReasonForTab(JutakuKaishuJizenShinseiReasonForTabDiv JutakuKaishuJizenShinseiReasonForTab);

    tplJizenShinseiResultDiv getTplJizenShinseiResult();

    void setTplJizenShinseiResult(tplJizenShinseiResultDiv tplJizenShinseiResult);

    KyufugakuSummaryDiv getJutakuKaishuJizenShinseiKyufugakuSummary();

    HorizontalLine getHl();

    void setHl(HorizontalLine hl);

    TextBoxDate getTxtJudgeDate();

    void setTxtJudgeDate(TextBoxDate txtJudgeDate);

    RadioButton getRadJudgeKubun();

    void setRadJudgeKubun(RadioButton radJudgeKubun);

    TextBoxMultiLine getTxtShoninCondition();

    void setTxtShoninCondition(TextBoxMultiLine txtShoninCondition);

    TextBoxMultiLine getTxtFushoninReason();

    void setTxtFushoninReason(TextBoxMultiLine txtFushoninReason);

    CheckBoxList getChkResetInfo();

    void setChkResetInfo(CheckBoxList chkResetInfo);

    tplJizenShinseiPayMethodDiv getTplJizenShinseiPayMethod();

    void setTplJizenShinseiPayMethod(tplJizenShinseiPayMethodDiv tplJizenShinseiPayMethod);

    PaymentMethodDiv getPaymentMethod();
}
