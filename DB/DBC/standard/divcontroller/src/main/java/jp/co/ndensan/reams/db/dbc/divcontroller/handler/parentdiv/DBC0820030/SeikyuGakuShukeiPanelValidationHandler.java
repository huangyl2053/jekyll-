/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.ShokanbaraiJutakuShikyuGendogakuHanteiCheck;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030.SeikyuGakuShukeiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030.dgdSeikyugakushukei_Row;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 償還払い費支給申請決定_サービス提供証明書(請求額集計）
 *
 * @reamsid_L DBC-1030-100 quxiaodong
 *
 */
public class SeikyuGakuShukeiPanelValidationHandler {

    private final SeikyuGakuShukeiPanelDiv div;
    private static final RString 対象単位 = new RString("対象単位");
    private static final RString 対象単位合計 = new RString("（対象単位+対象外単位）と等しい");
    private static final RString 単位合計 = new RString("単位合計");
    private static final RString 実日数 = new RString("実日数");
    private static final RString 計画単位 = new RString("計画単位");
    private static final RString 限度額の対象単位 = new RString("限度額対象単位");
    private static final RString 限度額の対象外単位 = new RString("限度額対象外単位");
    private static final RString 短期入所実日数 = new RString("短期入所実日数");
    private static final RString 保険分の単位合計 = new RString("保険分単位合計");
    private static final RString 保険分単位単価 = new RString("保険分単位単価");
    private static final RString 保険分請求額 = new RString("保険分請求額");
    private static final RString 保険分利用者負担 = new RString("保険分利用者負担");
    private static final RString 出来高分請求額 = new RString("出来高分請求額");
    private static final RString 出来高分利用者負担 = new RString("出来高分利用者負担");

    /**
     * 初期化
     *
     * @param div SeikyuGakuShukeiPanelDiv
     */
    public SeikyuGakuShukeiPanelValidationHandler(SeikyuGakuShukeiPanelDiv div) {
        this.div = div;
    }

    /**
     * 入力チェック
     *
     * @param meisaiPar ShoukanharaihishinseimeisaikensakuParameter
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック(ShoukanharaihishinseimeisaikensakuParameter meisaiPar) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RString 様式番号 = meisaiPar.get様式番号();
        Decimal 限度額対象単位 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoTanyi().getValue();
        Decimal 限度額対象外単位 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtTaishoGaiTanyi().getValue();
        Decimal 保険分単位合計 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtTanyigokeiHokenbun().getValue();
        ServiceShuruiCode サービス種類コード = new ServiceShuruiCode(div.getPanelSeikyugakuShukei().
                getPanelSeikyuShokai().getCcdServiceTypeInput().getサービス種類コード());
        ShokanbaraiJutakuShikyuGendogakuHanteiCheck shcheck = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean falg2 = true;
        boolean falg1 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtKeikakuTanyi().getValue() != null && div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtTaishoTanyi().getValue() != null && div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtTaishoGaiTanyi().getValue() != null;
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtTaishoTanyi().getValue() != null && div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtTaishoGaiTanyi().getValue() != null) {
            falg2 = !div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                    getTxtKeikakuTanyi().getValue().equals(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                            getTxtTaishoTanyi().getValue().add(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                                    getTxtTaishoGaiTanyi().getValue()));
        }
        boolean falg3 = shcheck.chkShokanbaraiJutakuShikyuGendogakuTaishoTani(
                様式番号, 限度額対象単位, サービス種類コード);
        boolean falg4 = true;
        if (限度額対象外単位 != null && 限度額対象単位 != null && 保険分単位合計 != null) {
            falg4 = shcheck.chkShokanbaraiJutakuShikyuGendogakuTaniGokei(
                    様式番号, 限度額対象外単位, 限度額対象単位, 保険分単位合計, サービス種類コード);
        }
        if (falg1 && falg2) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    DbcErrorMessages.計画単位数不一致)));
        }
        List<dgdSeikyugakushukei_Row> rowData = div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().getDataSource();
        List<dgdSeikyugakushukei_Row> rowList = new ArrayList<>();
        rowList.addAll(rowData);
        rowList.remove(div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().getClickedItem());
        for (dgdSeikyugakushukei_Row row : rowList) {
            ServiceShuruiCode serviceCode = new ServiceShuruiCode(row.getDefaultDataName19());
            if (div.getPanelSeikyugakuShukei().
                    getPanelSeikyuShokai().getCcdServiceTypeInput().
                    getサービス種類コード().equals(serviceCode.value())) {
                validPairs.add(
                        new ValidationMessageControlPair(new IdocheckMessages(
                                        DbcErrorMessages.サービス種類が登録済)));
            }
        }
        if (falg3) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 対象単位.toString())));
        }
        if (限度額対象外単位 != null && 限度額対象単位 != null && 保険分単位合計 != null && falg4) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.項目に対する制約, 単位合計.toString(), 対象単位合計.toString())));
        }
        必須入力チェック1(validPairs);
        return validPairs;
    }

    private ValidationMessageControlPairs 必須入力チェック1(ValidationMessageControlPairs validPairs) {
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtJitsuNissu().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.未入力, 実日数.toString())));
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKeikakuTanyi().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.未入力, 計画単位.toString())));
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoTanyi().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.未入力, 限度額の対象単位.toString())));
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoGaiTanyi().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.未入力, 限度額の対象外単位.toString())));
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtJitsuNissuTankinyusho().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.未入力, 短期入所実日数.toString())));
        }
        必須入力チェック2(validPairs);
        return validPairs;
    }

    private ValidationMessageControlPairs 必須入力チェック2(ValidationMessageControlPairs validPairs) {
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiHokenbun().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.未入力, 保険分の単位合計.toString())));
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiHokenbun().getValue() != null
                && div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyiTanka().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.未入力, 保険分単位単価.toString())));
        }
        if ((div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyiTanka().getValue() != null
                && div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtTanyiTanka().getValue() != null) && (div.getPanelSeikyugakuShukei().
                getPanelSeikyuShokai().getTxtSeikyugakuHoken().getValue() == null
                || div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtSeikyugakuHoken().getValue().equals(Decimal.ZERO))) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.未入力, 保険分請求額.toString())));
        }
        if ((div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyiTanka().getValue() != null
                && div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtTanyiTanka().getValue() != null) && (div.getPanelSeikyugakuShukei().
                getPanelSeikyuShokai().getTxtRiyoshaFutanHoken().getValue() == null
                || div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtRiyoshaFutanHoken().getValue().equals(Decimal.ZERO))) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.未入力, 保険分利用者負担.toString())));
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().getValue() != null
                && (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuDekikata().getValue() == null
                || div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtSeikyugakuDekikata().getValue().equals(Decimal.ZERO))) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.未入力, 出来高分請求額.toString())));
        }
        if (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().getValue() != null
                && (div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtRiyoshaFutanDekikata().getValue() == null
                || div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
                getTxtRiyoshaFutanDekikata().getValue().equals(Decimal.ZERO))) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.未入力, 出来高分利用者負担.toString())));
        }
        return validPairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
