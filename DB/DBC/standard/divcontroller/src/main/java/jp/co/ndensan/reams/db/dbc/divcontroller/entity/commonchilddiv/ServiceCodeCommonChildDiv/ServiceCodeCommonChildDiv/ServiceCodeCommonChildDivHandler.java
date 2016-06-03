/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceCodeCommonChildDiv.ServiceCodeCommonChildDiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.servicecode.ServiceCodeModel;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * サービスコード検索の抽象Handlerクラスです。
 * @reamsid_L DBA-0060-010 dongyabin
 */
public class ServiceCodeCommonChildDivHandler {
    
    private final ServiceCodeCommonChildDivDiv div;
    
    private static final int INDEX_サービス項目コード = 6;
    
    /**
     * コンストラクタです。
     *
     * @param div
     */
    public ServiceCodeCommonChildDivHandler(ServiceCodeCommonChildDivDiv div) {
        this.div = div;
    }
    
    /**
     * サービスコード検索一覧初期化の設定します。
     *
     */
    public void onLoad() {
        ServiceCodeModel serviceCode = DataPassingConverter.deserialize(div.getServiceCodeModel(), ServiceCodeModel.class);
        div.getTxtServiceCode().setValue(serviceCode.getサービス種類コード());
        div.getTxtKomokuCode().setValue(serviceCode.getサービス項目コード());
        div.getTxtKijunYM().setValue(RDate.getNowDate());
    }
    
    /**
     *
     * サービスコードを検索の設定します。
     *
     * @param list
     */
    public void initialize(List<KaigoServiceNaiyou> list) {
        List<dgCodeIchiran_Row> dataList = new ArrayList<>();
        for (KaigoServiceNaiyou serviceCode : list) {
            dgCodeIchiran_Row row = new dgCodeIchiran_Row();
            RStringBuilder sb = new RStringBuilder();
            sb.append(div.getTxtServiceCode().getValue());
            sb.append(serviceCode.getサービス項目コード());
            row.setTxtServiceCode(sb.toRString());
            row.setTxtServiceName(serviceCode.getサービス名称());
            dataList.add(row);
        }
        div.getDgCodeIchiran().setDataSource(dataList);
    }
    
    /**
     * 「確定する」ボタンをクリック場合、画面遷移が表示します。
     *
     */
    public void onClick_btnKakutei() {
        ServiceCodeModel serviceCode = new ServiceCodeModel();
        serviceCode.setサービス種類コード(div.getDgCodeIchiran().getClickedItem().getTxtServiceCode().substring(0, 2));
        serviceCode.setサービス項目コード(div.getDgCodeIchiran().getClickedItem().getTxtServiceCode().substring(2,
                INDEX_サービス項目コード));
        serviceCode.setサービス種類名称(div.getDgCodeIchiran().getClickedItem().getTxtServiceName());
        div.setServiceCodeModel(DataPassingConverter.serialize(serviceCode));
    }
    
    /**
     *
     * サービス種類検索初期化のデータを全てクリアします。
     *
     */
    public void clear() {
        div.getDgCodeIchiran().getDataSource().clear();
    }
    
    /**
     * 対象行を選択しないのチェック処理です。
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs addMessage() {
        ValidationMessageControlPairs validation = new ValidationMessageControlPairs();
        validation.add(new ValidationMessageControlPair(RRVMessages.Validate対象者一覧未選択));
        return validation;
    }
    
    private static enum RRVMessages implements IValidationMessage {

        Validate対象者一覧未選択(UrErrorMessages.対象行を選択);
        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
    
}
