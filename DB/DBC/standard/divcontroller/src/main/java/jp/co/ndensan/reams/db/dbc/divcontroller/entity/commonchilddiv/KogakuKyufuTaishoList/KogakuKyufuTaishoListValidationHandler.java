/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.kaigoserviceshurui.KaigoServiceShuruiMapperParameter;
import jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShuruiManager;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.ServiceJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dbz.definition.core.kaigojigyoshano.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.jigyosha.JigyoshaInputGuideParameter;
import jp.co.ndensan.reams.db.dbz.service.core.jigyosha.JigyoshaInputGuideFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 画面設計_DBCKD00006_高額給付対象一覧共有子Div
 *
 * @reamsid_L DBC-2020-030 quxiaodong
 */
public class KogakuKyufuTaishoListValidationHandler {

    private final KogakuKyufuTaishoListDiv div;
    private static final RString 事業者番号 = new RString("事業者番号");
    private static final RString サービス費用合計と利用者負担合計 = new RString("サービス費用合計と利用者負担合計");
    private static final RString 明細合計区分 = new RString("明細合計区分");
    private static final RString サービス種類コード = new RString("サービス種類コード");

    /**
     * コンストラクタです。
     *
     * @param div KogakuKyufuTaishoListDiv
     */
    public KogakuKyufuTaishoListValidationHandler(KogakuKyufuTaishoListDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面DIV
     * @return KogakuKyufuTaishoListDiv
     */
    public static KogakuKyufuTaishoListValidationHandler of(KogakuKyufuTaishoListDiv div) {
        return new KogakuKyufuTaishoListValidationHandler(div);
    }

    /**
     * 確定チェック
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs 確定チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        SearchResult<ServiceJigyoshaInputGuide> Jigyosha = JigyoshaInputGuideFinder.
                createInstance().getServiceJigyoshaInputGuide(
                        JigyoshaInputGuideParameter.createParam_ServiceJigyoshaInputGuide(new KaigoJigyoshaNo(
                                        div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode().getValue()),
                                FlexibleDate.EMPTY, FlexibleDate.EMPTY, new AtenaMeisho(RString.EMPTY),
                                new YubinNo(RString.EMPTY), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                                RString.EMPTY, FlexibleDate.getNowDate(), RString.EMPTY, 0));
        if (Jigyosha.records().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    new KogakuKyufuTaishoListValidationHandler.IdocheckMessages(
                            UrErrorMessages.存在しない, 事業者番号.toString())));
        }
        SearchResult<KaigoServiceShurui> kalist = KaigoServiceShuruiManager.createInstance().
                getServiceTypeList(KaigoServiceShuruiMapperParameter.createSelectByKeyParam(
                                new ServiceShuruiCode(div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().getValue()),
                                new FlexibleYearMonth(RDate.getNowDate().getYearMonth().toDateString())));
        if (kalist.records().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    new KogakuKyufuTaishoListValidationHandler.IdocheckMessages(UrErrorMessages.コードマスタなし)));
        }
        if (div.getMeisaiGokeiHenshuPanel().getTxtHyoGkei().getValue().intValue()
                < div.getMeisaiGokeiHenshuPanel().getTxtRiyoshafutanGokei().getValue().intValue()) {
            validPairs.add(new ValidationMessageControlPair(
                    new KogakuKyufuTaishoListValidationHandler.IdocheckMessages(
                            UrErrorMessages.大小関係が不正, サービス費用合計と利用者負担合計.toString())));
        }
        List<dgTaishoshaIchiran_Row> rowData = div.getDgTaishoshaIchiran().getDataSource();
        List<dgTaishoshaIchiran_Row> rowList = new ArrayList<>();
        rowList.addAll(rowData);
        rowList.remove(div.getDgTaishoshaIchiran().getClickedItem());
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        for (dgTaishoshaIchiran_Row row : rowList) {
            if (div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().getValue().equals(row.getData11())) {
                flag1 = true;
            }
            if (div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode().getValue().equals(row.getData1())) {
                flag2 = true;
            }
            if (div.getMeisaiGokeiHenshuPanel().getRdbMisaiGkeiKbun().getSelectedKey().equals(row.getData10())) {
                flag3 = true;
            }
            if (flag1 && flag2 && flag3) {
                validPairs.add(new ValidationMessageControlPair(
                        new KogakuKyufuTaishoListValidationHandler.IdocheckMessages(
                                UrErrorMessages.既に登録済, サービス種類コード.toString())));
                validPairs.add(new ValidationMessageControlPair(
                        new KogakuKyufuTaishoListValidationHandler.IdocheckMessages(
                                UrErrorMessages.既に登録済, 事業者番号.toString())));
                validPairs.add(new ValidationMessageControlPair(
                        new KogakuKyufuTaishoListValidationHandler.IdocheckMessages(
                                UrErrorMessages.既に登録済, 明細合計区分.toString())));
                break;
            }
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
