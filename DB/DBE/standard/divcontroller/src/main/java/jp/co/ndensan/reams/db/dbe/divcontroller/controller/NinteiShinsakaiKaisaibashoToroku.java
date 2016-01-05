/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijoho.gogitaijoho.GogitaiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5120001.dgKaisaibashoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuHandler;
import static jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuHandler.全て;
import static jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuHandler.削除モード;
import static jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuHandler.更新モード;
import static jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuHandler.有効;
import static jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuHandler.追加モード;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 介護認定審査会開催場所登録Divを制御します。
 *
 */
public class NinteiShinsakaiKaisaibashoToroku {
    
    /**
     * 介護認定審査会開催場所登録の初期処理を表します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> onLoad(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> response = new ResponseData<>();
        getHandler(div).set介護認定審査会開催場所一覧(get開催場所一覧(div));
        response.data = div;
        return response;
    }

    /**
     * 介護認定審査会開催場所登録の初期処理を表します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> btnKensaku_onClick(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> response = new ResponseData<>();
        getHandler(div).set介護認定審査会開催場所一覧(get開催場所一覧(div));
        response.data = div;
        return response;
    }
    
    /**
     * 開催場所を追加するのクリック処理をします。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> btnTsuiKa_onClick(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> response = new ResponseData<>();
        if (更新モード.equals(div.getShinakaiKaisaIbashoShosai().getJyotai()) 
                && 追加モード.equals(div.getShinakaiKaisaIbashoShosai().getJyotai())) {
            if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                 &&  ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                   getHandler(div).set開催場所一覧の追加();
              response.data = div;
            }
        }else {
            getHandler(div).set開催場所一覧の追加();
        }
        return response;
    }
    
    
    /**
     * 介護認定審査会開催場所一覧の削除処理をします。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> dataGrid_onSelectByDeleteButton(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> response = new ResponseData<>();
         if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                    UrQuestionMessages.削除の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
         }
         if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
              &&  ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                 getHandler(div).set開催場所一覧の削除();
                 response.data = div;    
         }
        return response;
    }
    
    /**
     * 介護認定審査会開催場所一覧の修正処理をします。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> dataGrid_onSelectByModifyButton(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> response = new ResponseData<>();
         if (更新モード.equals(div.getShinakaiKaisaIbashoShosai().getJyotai())
                && 追加モード.equals(div.getShinakaiKaisaIbashoShosai().getJyotai())) {
            if (!ResponseHolder.isReRequest()) {
               QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                       UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
               return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                 &&  ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
               getHandler(div).set修正の場合開催場所編集エリア();
               response.data = div;
            }
        }else {
           getHandler(div).set修正の場合開催場所編集エリア();
        }
        return response;
    }
    
    /**
     * 介護認定審査会開催場所一覧のクリック処理をします。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> dataGrid_onSelectBySelectButton(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> response = new ResponseData<>();
        getHandler(div).set開催場所一覧の参照();
        response.data = div;
        return response;
    }
    
    /**
     * 「入力内容を取消する」のクリック処理をします。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> btnback_onClick(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> response = new ResponseData<>();
         if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
         }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
              &&  ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).set開催場所編集エリアを初期化処理();
            response.data = div;
         }
        return response;
    }
    
    /**
     * 「入力内容を更新する」のクリック処理をします。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> btnupdate_onClick(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> response = new ResponseData<>();
        getHandler(div).開催場所一覧の更新();
        response.data = div;
        return response;
    }
    
    
   /**
     * 開催場所の更新処理します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> btnUpdate_onClick(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> response = new ResponseData<>();
        List<dgKaisaibashoIchiran_Row> rowList = div.getDgKaisaibashoIchiran().getDataSource();
        for (dgKaisaibashoIchiran_Row row : rowList) {
            if (追加モード.equals(row.getJyotai())) {
            
            } else if (更新モード.equals(row.getJyotai())) {
            
            } else if (削除モード.equals(row.getJyotai())) {
            
            }
        }
        
        response.data = div;
        return response;
    }
    
    private List<ShinsakaiKaisaiBashoJoho> get開催場所一覧(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        List<ShinsakaiKaisaiBashoJoho> businessList = new ArrayList<>();
        ShinsakaiKaisaiBashoJohoManager manager = ShinsakaiKaisaiBashoJohoManager.createInstance();
        if (new RString("yuuKo").equals(div.getRadHyojiJoken().getSelectedKey())) {
           businessList =  manager.
                    get介護認定審査会開催場所情報一覧(GogitaiJohoMapperParameter.
                            createSelectBy審査会開催場所状況(有効));
        } else{
             businessList =  manager.
                    get介護認定審査会開催場所情報一覧(GogitaiJohoMapperParameter.
                            createSelectBy審査会開催場所状況(全て));
        }
        return businessList;
    }
    
    private NinteiShinsakaiKaisaibashoTorokuHandler getHandler(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        return new NinteiShinsakaiKaisaibashoTorokuHandler(div);
    }
}
