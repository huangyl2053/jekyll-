/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.koseishichosonselector;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoseiShichoson;
import jp.co.ndensan.reams.db.dbz.definition.core.koseishichosonselector.KoseiShiChosonSelectorModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.koseishichosonselector.KoseiShiChosonSelector.KoseiShiChosonSelectorDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.koseishichosonselector.KoseiShiChosonSelector.dgKoseiShichosonList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 構成市町村選択の抽象Handlerクラスです。
 */
public class KoseiShiChosonSelectorHandler {
    
    private final KoseiShiChosonSelectorDiv div;
    
    /**
     * コンストラクタです。
     * @param div 画面情報
     */
    public KoseiShiChosonSelectorHandler(KoseiShiChosonSelectorDiv div) {
        this.div = div;
    }
    
    /**
     * 画面初期化処理です。
     * @param koseiShichosonList 一覧検索情報
     */
    public void onLoad(List<KoseiShichoson> koseiShichosonList) {
        List<dgKoseiShichosonList_Row> rowList = new ArrayList<>();
        for (KoseiShichoson koseiShichoson : koseiShichosonList) {
            dgKoseiShichosonList_Row row = new dgKoseiShichosonList_Row(koseiShichoson.get市町村名称(),
                    koseiShichoson.get市町村コード().getColumnValue());
            rowList.add(row);
        }
        div.getDgKoseiShichosonList().setDataSource(rowList);
    }
    
    /**
     * 構成市町村一覧データのチェック処理です。
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs getMessage() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(
                KoseiShiChosonSelectorMessage.データが存在しない));
        return validationMessages;
    }
    
    /**
     * 構成市町村一覧データを選択の処理です。
     */
    public void onClick_Kensaku() {
        
        KoseiShiChosonSelectorModel model = new KoseiShiChosonSelectorModel();
        model.set市町村コード(div.getDgKoseiShichosonList().getClickedItem().getShicosoncode());
        model.set市町村名称(div.getDgKoseiShichosonList().getClickedItem().getShichosonname());
        ViewStateHolder.put(ViewStateKeys.構成市町村選択_引き継ぎデータ, model);
    }
    
    private static enum KoseiShiChosonSelectorMessage implements IValidationMessage {

        データが存在しない(UrErrorMessages.該当データなし);

        private final Message message;

        private KoseiShiChosonSelectorMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
