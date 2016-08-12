/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0600031;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraikettejoho.KetteJoho;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJoho.dgSyokanbaraikete_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600031.PnlKeteiJohoMsgDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 福祉用具購入費支給申請_決定情報登録 Handler
 *
 * @reamsid_L DBC-1020-010 yangchenbing
 */
public final class PnlKeteiJohoMsgHandler {

    private final PnlKeteiJohoMsgDiv div;
    private static final RString 決定日 = new RString("決定日");
    private static final RString 支払金額合計 = new RString("支払金額合計");

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
     * 決定日 内容の変更を判断する
     *
     * @param 決定情報 KetteJoho
     * @param ketebi FlexibleDate
     * @return boolean
     */
    public boolean equal決定日(KetteJoho 決定情報, FlexibleDate ketebi) {
        if (決定情報 != null && ketebi != null) {
            if (!ketebi.equals(決定情報.getKetteiYMD())) {
                return true;
            }
        } else if ((決定情報 != null && 決定情報.getKetteiYMD() != null && ketebi == null)) {
            return true;
        } else if (決定情報 == null && ketebi != null && !RDate.getNowDate().equals(new RDate(ketebi.toString()))) {
            return true;
        }
        return false;
    }

    /**
     * 支給区分 内容の変更を判断する
     *
     * @param 決定情報 KetteJoho
     * @param rdoShikyukubunNew RString
     * @return boolean
     */
    public Boolean equal支給区分(KetteJoho 決定情報, RString rdoShikyukubunNew) {
        if (決定情報 != null && rdoShikyukubunNew != null) {
            if (!rdoShikyukubunNew.equals(決定情報.getShikyuHushikyuKetteiKubun())) {
                return true;
            }
        } else if ((決定情報 != null && 決定情報.getShikyuHushikyuKetteiKubun() != null && rdoShikyukubunNew == null)
                || (決定情報 == null && rdoShikyukubunNew != null && !rdoShikyukubunNew.isEmpty())) {
            return true;
        }
        return false;
    }

    /**
     * 償還払決定一覧 内容の変更を判断する
     *
     * @param rowList List<dgSyokanbaraikete_Row>
     * @param 償還払決定一覧 Map<RString, Integer>
     * @return boolean
     */
    public Boolean equal償還払決定一覧(List<dgSyokanbaraikete_Row> rowList, Map<RString, Integer> 償還払決定一覧) {
        for (int i = 0; i < rowList.size(); i++) {
            if (償還払決定一覧 != null && 償還払決定一覧.get(rowList.get(i).getNo()) != rowList.get(i).getSagakuKingaku().getValue().intValue()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 内容の変更を判断する
     *
     * @param 償還払決定一覧 List<dgSyokanbaraikete_Row>
     * @param 決定情報 KetteJoho
     * @return flag Boolean
     */
    public Boolean is内容変更状態(Map<RString, Integer> 償還払決定一覧, KetteJoho 決定情報) {
        boolean flag = false;
        if (div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().getTxtKetebi().getValue() != null) {
            FlexibleDate ketebi = new FlexibleDate(div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().getTxtKetebi().getValue().toDateString());
            if (equal決定日(決定情報, ketebi)) {
                flag = true;
            }
        }
        RString rdoShikyukubunNew = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().getRdoShikyukubun().getSelectedKey();
        if (equal支給区分(決定情報, rdoShikyukubunNew)) {
            flag = true;
        } else if (決定情報 != null && 決定情報.getShikyuHushikyuKetteiKubun() != null && 決定情報.getShikyuHushikyuKetteiKubun().
                equals(ShikyuFushikyuKubun.支給.getコード())) {
            RString zogenriyu = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().getTxtZogenriyu().getValue();
            if (zogenriyu != null && !zogenriyu.equals(決定情報.getZougenRiyu())) {
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
        } else if (決定情報 != null && 決定情報.getShikyuHushikyuKetteiKubun() != null && 決定情報.getShikyuHushikyuKetteiKubun().
                equals(ShikyuFushikyuKubun.不支給.getコード())) {
            RString fuSyikyuriyu1 = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().getTxtFuSyikyuriyu1().getValue();
            if (fuSyikyuriyu1 != null && !fuSyikyuriyu1.equals(決定情報.getHushikyuRiyu())) {
                flag = true;
            }
            RString fushikyuriyu2 = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().getTxtFushikyuriyu2().getValue();
            if (fushikyuriyu2 != null && !fushikyuriyu2.equals(決定情報.getKounyuKaishuRireki())) {
                flag = true;
            }
        }
        List<dgSyokanbaraikete_Row> rowList = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().getDgSyokanbaraikete().getDataSource();
        if (equal償還払決定一覧(rowList, 償還払決定一覧)) {
            flag = true;
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

    /**
     * 支払金額合計入力チェックのメソッドます。
     *
     * @return ResponseData
     */
    public ValidationMessageControlPairs getCheck支払金額合計Message() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        pairs.add(new ValidationMessageControlPair(new PnlKeteiJohoMsgHandler.IdocheckMessages(
                UrErrorMessages.必須, 支払金額合計.toString())));
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
