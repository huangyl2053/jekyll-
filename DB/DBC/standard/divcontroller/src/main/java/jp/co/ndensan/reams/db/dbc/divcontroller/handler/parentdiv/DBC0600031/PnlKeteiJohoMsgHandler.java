/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0600031;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraikettejoho.KetteJoho;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJoho.dgSyokanbaraikete_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600031.PnlKeteiJohoMsgDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.uz.uza.math.Decimal.ONE;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import static org.joda.time.Seconds.TWO;

/**
 * 福祉用具購入費支給申請_決定情報登録 Handler
 *
 * @reamsid_L DBC-1020-010 yangchenbing
 */
public final class PnlKeteiJohoMsgHandler {

    private final PnlKeteiJohoMsgDiv div;
    private static final RString 決定日 = new RString("決定日");

    private PnlKeteiJohoMsgHandler(PnlKeteiJohoMsgDiv div) {
        this.div = div;
    }

    /**
     * 戻り対象
     *
     * @param div div
     * @return PnlKeteiJohoMsgHandler
     */
    public static PnlKeteiJohoMsgHandler of(PnlKeteiJohoMsgDiv div) {
        return new PnlKeteiJohoMsgHandler(div);
    }

    /**
     *
     * @param 償還払決定一覧 List<dgSyokanbaraikete_Row>
     * @param 決定情報 KetteJoho
     * @return boolean
     */
    public boolean is内容変更状態(List<dgSyokanbaraikete_Row> 償還払決定一覧, KetteJoho 決定情報) {
        boolean flag = false;
        FlexibleDate ketebi = new FlexibleDate(div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().getTxtKetebi()
                .getValue().toDateString());
        if (!ketebi.equals(決定情報.getKetteiYMD())) {
            flag = true;
        }
        RString rdoShikyukubunNew = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().getRdoShikyukubun().getSelectedKey();
        if (!rdoShikyukubunNew.equals(決定情報.getShikyuHushikyuKetteiKubun())) {
            flag = true;
        } else if (決定情報.getShikyuHushikyuKetteiKubun().equals(ONE)) {
            RString zogenriyu = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().getTxtZogenriyu().getValue();
            if (!zogenriyu.equals(決定情報.getZougenRiyu())) {
                flag = true;
            }
            int zogentani = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().getTxtZogentani().getValue().intValue();
            if (zogentani != 決定情報.getZougenten()) {
                flag = true;
            }
            int shiharaikingakugoke = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().getTxtShiharaikingakugoke()
                    .getValue().intValue();
            if (shiharaikingakugoke != 決定情報.getShiharaiKingaku()) {
                flag = true;
            }
        } else if (決定情報.getShikyuHushikyuKetteiKubun().equals(TWO)) {
            RString fuSyikyuriyu1 = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().getTxtFuSyikyuriyu1().getValue();
            if (!fuSyikyuriyu1.equals(決定情報.getHushikyuRiyu())) {
                flag = true;
            }
            RString fushikyuriyu2 = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().getTxtFushikyuriyu2().getValue();
            if (!fushikyuriyu2.equals(決定情報.getKounyuKaishuRireki())) {
                flag = true;
            }
        }
        List<dgSyokanbaraikete_Row> rowList = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().getDgSyokanbaraikete().getDataSource();
        for (int i = 0; i < rowList.size(); i++) {
            if (償還払決定一覧.get(i).getSagakuKingaku().getValue().intValue() != rowList.get(i).getSagakuKingaku().getValue().intValue()) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 入力チェックのメソッドます。
     *
     * @return ResponseData
     */
    public ValidationMessageControlPairs getCheckMessage() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        pairs.add(new ValidationMessageControlPair(new PnlKeteiJohoMsgHandler.IdocheckMessages(
                UrErrorMessages.必須, 決定日.toString())));
        return pairs;
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
