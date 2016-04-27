package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE7010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJoho;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.hokokushiryosakusei.HokokuShiryoSakuSeiBatchParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigonintei.shinsei.HihokenshaKubun;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE7010001.HokokuShiryoSakuSeiParameterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE7010001.HokokuShiryoSakuSeiParameterHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE7010001.HokokuShiryoSakuSeiParameterValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.hokokushiryosakusei.HokokuShiryoSakuSeiFinder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面の条件を指定して、報告資料作成バッチ処理を起動し、各種統計資料を作成するクラスです。
 *
 * @reamsid_L DBE-1450-010 wangxiaodong
 */
public class HokokuShiryoSakuSeiParameter {

    private static final RString SELECTKEY_KEY0 = new RString("key0");
    private static final RString SELECTKEY_KEY1 = new RString("key1");
    private static final RString SELECTKEY_KEY2 = new RString("key2");
    private static final RString SELECTKEY_KEY3 = new RString("key3");
    private final HokokuShiryoSakuSeiFinder finder;

    /**
     * コンストラクタです。
     */
    public HokokuShiryoSakuSeiParameter() {
        this.finder = HokokuShiryoSakuSeiFinder.createInstance();
    }

    /**
     * 画面初期化処理です。
     *
     * @param div 報告資料発行画面
     * @return ResponseData<HokokuShiryoSakuSeiParameterDiv>
     */
    public ResponseData<HokokuShiryoSakuSeiParameterDiv> onload(HokokuShiryoSakuSeiParameterDiv div) {

        getHandler(div).inint_Clear();
        set合議体番号DLL(div, finder.getGogitaiNo().records());
        return ResponseData.of(div).respond();
    }

    /**
     * 画面初期化処理です。
     *
     * @param div 報告資料発行画面
     * @return ResponseData<HokokuShiryoSakuSeiParameterDiv>
     */
    public ResponseData<HokokuShiryoSakuSeiParameterDiv> onChange_chkShutsuryokuChohyo(HokokuShiryoSakuSeiParameterDiv div) {

        List<RString> disabledItems = new ArrayList<>();
        for (RString selectedKey : div.getChkShutsuryokuChohyo().getSelectedKeys()) {
            if (SELECTKEY_KEY0.equals(selectedKey)) {
                disabledItems.clear();
                disabledItems.add(SELECTKEY_KEY1);
                disabledItems.add(SELECTKEY_KEY2);
                div.getChkShutsuryokuChohyo().setDisabledItemsByKey(disabledItems);
                div.getCcdHokenshaList().setDisabled(true);
                div.getDdlGogitaiBango().setDisabled(true);
                continue;
            } else {
                disabledItems.clear();
                div.getChkShutsuryokuChohyo().setDisabledItemsByKey(disabledItems);
                div.getCcdHokenshaList().setDisabled(false);
                div.getDdlGogitaiBango().setDisabled(false);
            }
            if (SELECTKEY_KEY1.equals(selectedKey) || SELECTKEY_KEY2.equals(selectedKey)) {
                disabledItems.clear();
                disabledItems.add(SELECTKEY_KEY0);
                div.getChkShutsuryokuChohyo().setDisabledItemsByKey(disabledItems);
                continue;
            } else {
                disabledItems.clear();
                div.getChkShutsuryokuChohyo().setDisabledItemsByKey(disabledItems);
            }
            if (SELECTKEY_KEY3.equals(selectedKey)) {
                div.getTxtKijyunYMD().setDisabled(true);
            } else {
                div.getTxtKijyunYMD().setDisabled(false);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 対象月編集chkを変更する処理です。
     *
     * @param div 報告資料発行画面
     * @return ResponseData<HokokuShiryoSakuSeiParameterDiv>
     */
    public ResponseData<HokokuShiryoSakuSeiParameterDiv> onChange_chkModifyTaishoTsuki(HokokuShiryoSakuSeiParameterDiv div) {
        if (!div.getChkModifyTaishoTsuki().getSelectedKeys().isEmpty()) {
            ValidationMessageControlPairs message = new ValidationMessageControlPairs();
            new HokokuShiryoSakuSeiParameterValidationHandler(div).check_TaishoNendoNyuryoku(message);
            if (message.iterator().hasNext()) {
                div.getChkModifyTaishoTsuki().setSelectedItemsByKey(new ArrayList<RString>());
                return ResponseData.of(div).addValidationMessages(message).respond();
            }
            div.getDdlTsuki().setDisabled(false);
        } else {
            div.getDdlTsuki().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 対象月日編集chkを変更する処理です。
     *
     * @param div 報告資料発行画面
     * @return ResponseData<HokokuShiryoSakuSeiParameterDiv>
     */
    public ResponseData<HokokuShiryoSakuSeiParameterDiv> onChange_chkModifyTaishoGeppi(HokokuShiryoSakuSeiParameterDiv div) {
        if (!div.getChkModifyTaishoGeppi().getSelectedKeys().isEmpty()) {
            ValidationMessageControlPairs message = new ValidationMessageControlPairs();
            new HokokuShiryoSakuSeiParameterValidationHandler(div).check_TaishoNendoNyuryoku(message);
            if (message.iterator().hasNext()) {
                div.getChkModifyTaishoGeppi().setSelectedItemsByKey(new ArrayList<RString>());
                return ResponseData.of(div).addValidationMessages(message).respond();
            }
            div.getTxtTaishoGappi().setDisabled(false);
        } else {
            div.getTxtTaishoGappi().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「資料の出力を実行する」ボタンをチェックする処理です。
     *
     * @param div 報告資料発行画面
     * @return ResponseData<HokokuShiryoSakuSeiParameterDiv>
     */
    public ResponseData<HokokuShiryoSakuSeiParameterDiv> onClick_btnCheck(HokokuShiryoSakuSeiParameterDiv div) {
        ValidationMessageControlPairs message = new ValidationMessageControlPairs();
        new HokokuShiryoSakuSeiParameterValidationHandler(div).check_btnBatchRegisterHokokuShiryo(message);
        if (message.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「資料の出力を実行する」ボタンを実行する処理です。
     *
     * @param div 報告資料発行画面
     * @return ResponseData<HokokuShiryoSakuSeiParameterDiv>
     */
    public ResponseData<HokokuShiryoSakuSeiBatchParameter> onClick_btnBatchRegisterHokokuShiryo(HokokuShiryoSakuSeiParameterDiv div) {

        return ResponseData.of(getBatchParameter(div)).respond();
    }

    private void set合議体番号DLL(HokokuShiryoSakuSeiParameterDiv div, List<GogitaiJoho> 合議体番号リスト) {
        List<KeyValueDataSource> 合議体番号DLL = new ArrayList<>();
        for (GogitaiJoho 合議体番号 : 合議体番号リスト) {
            合議体番号DLL.add(new KeyValueDataSource(
                    new RString(String.valueOf(合議体番号.get合議体番号())), 合議体番号.get合議体名称()));
        }
        div.getDdlGogitaiBango().setDataSource(合議体番号DLL);
    }

    private HokokuShiryoSakuSeiBatchParameter getBatchParameter(HokokuShiryoSakuSeiParameterDiv div) {
        return new HokokuShiryoSakuSeiBatchParameter(
                div.getChkShutsuryokuChohyo().getSelectedKeys().contains(SELECTKEY_KEY0),
                div.getChkShutsuryokuChohyo().getSelectedKeys().contains(SELECTKEY_KEY1),
                div.getChkShutsuryokuChohyo().getSelectedKeys().contains(SELECTKEY_KEY2),
                div.getChkShutsuryokuChohyo().getSelectedKeys().contains(SELECTKEY_KEY3),
                div.getChkCsvShutsuryoku().getSelectedKeys().contains(SELECTKEY_KEY0),
                div.getTxtShuturyokuSaki().getValue(),
                div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号().value(),
                getHiHokensyaKubun(div).getコード(),
                div.getTxtTaishoNendo().getValue(),
                div.getDdlGogitaiBango().getSelectedKey().isEmpty() ? -1 : Integer.parseInt(
                        div.getDdlGogitaiBango().getSelectedKey().toString()),
                div.getChkModifyTaishoTsuki().getSelectedKeys().contains(SELECTKEY_KEY0),
                div.getDdlTsuki().getSelectedKey(),
                div.getTxtKijyunYMD().getValue(),
                div.getChkModifyTaishoGeppi().getSelectedKeys().contains(SELECTKEY_KEY0),
                div.getTxtTaishoGappi().getFromValue() == null
                ? RString.EMPTY : div.getTxtTaishoGappi().getFromValue().toDateString(),
                div.getTxtTaishoGappi().getToValue() == null
                ? RString.EMPTY : div.getTxtTaishoGappi().getToValue().toDateString(),
                div.getChkShukeiTani().getSelectedKeys().contains(SELECTKEY_KEY0),
                div.getChkShukeiTani().getSelectedKeys().contains(SELECTKEY_KEY1));
    }

    private HihokenshaKubun getHiHokensyaKubun(HokokuShiryoSakuSeiParameterDiv div) {

        if (div.getChkHihokenshaKubun().isAllSelected()) {
            return HihokenshaKubun.すべて選択;
        }
        if (div.getChkHihokenshaKubun().getSelectedKeys().contains(SELECTKEY_KEY0)
                && div.getChkHihokenshaKubun().getSelectedKeys().contains(SELECTKEY_KEY1)) {
            return HihokenshaKubun.第１号と第２号;
        }
        if (div.getChkHihokenshaKubun().getSelectedKeys().contains(SELECTKEY_KEY0)
                && div.getChkHihokenshaKubun().getSelectedKeys().contains(SELECTKEY_KEY2)) {
            return HihokenshaKubun.第１号とその他;
        }
        if (div.getChkHihokenshaKubun().getSelectedKeys().contains(SELECTKEY_KEY1)
                && div.getChkHihokenshaKubun().getSelectedKeys().contains(SELECTKEY_KEY2)) {
            return HihokenshaKubun.第２号とその他;
        }
        if (div.getChkHihokenshaKubun().getSelectedKeys().contains(SELECTKEY_KEY0)) {
            return HihokenshaKubun.第１号被保険者;
        }
        if (div.getChkHihokenshaKubun().getSelectedKeys().contains(SELECTKEY_KEY1)) {
            return HihokenshaKubun.第２号被保険者;
        }
        if (div.getChkHihokenshaKubun().getSelectedKeys().contains(SELECTKEY_KEY2)) {
            return HihokenshaKubun.その他;
        }
        return HihokenshaKubun.選択なし;
    }

    private HokokuShiryoSakuSeiParameterHandler getHandler(HokokuShiryoSakuSeiParameterDiv div) {
        return new HokokuShiryoSakuSeiParameterHandler(div);
    }
}
