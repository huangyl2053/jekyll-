/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijoho.gogitaijoho.GogitaiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5120001.dgKaisaibashoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuHandler;
import static jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuHandler.コード種別;
import static jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuHandler.デフォルト検索条件;
import static jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuHandler.全て;
import static jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuHandler.更新モード;
import static jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuHandler.有効;
import static jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuHandler.追加モード;
import static jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuHandler.通常;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJohoManager;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 介護認定審査会開催場所登録Divを制御クラスです。
 *
 */
public class NinteiShinsakaiKaisaibashoToroku {

    /**
     * 介護認定審査会開催場所登録の初期処理を表示します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> onLoad(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        getHandler(div).set介護認定審査会開催場所一覧(get開催場所一覧(div));
        div.getBtnTsuika().setDisabled(false);
        return  ResponseData.of(div).respond();
    }

    /**
     * 介護認定審査会開催場所登録の「検索する」ボタンが押下します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> 
        onClick_btnKensaku(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        getHandler(div).set介護認定審査会開催場所一覧(get開催場所一覧(div));
        div.getBtnTsuika().setDisabled(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 介護認定審査会開催場所登録の「追加」ボタンが押下します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> 
        onClick_btnTsuiKa(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        if ((更新モード.equals(div.getShinakaiKaisaIbashoShosai().getJyotai()) && isUpdateHasChange(div))
                || (isAddHasChange(div) && 追加モード.equals(div.getShinakaiKaisaIbashoShosai().getJyotai()))) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).set開催場所一覧の追加();
            }
        } else {
            getHandler(div).set開催場所一覧の追加();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 介護認定審査会開催場所登録の「削除」ボタンが押下します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> 
        onClick_dataGridOnSelectByDeleteButton(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                    UrQuestionMessages.削除の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).set開催場所一覧の削除();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 介護認定審査会開催場所登録の「修正」ボタンが押下します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> 
        onClick_dataGridOnSelectByModifyButton(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        if ((更新モード.equals(div.getShinakaiKaisaIbashoShosai().getJyotai()) && isUpdateHasChange(div))
              || (isAddHasChange(div) && 追加モード.equals(div.getShinakaiKaisaIbashoShosai().getJyotai()))) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).set修正の場合開催場所編集エリア();
            }
        } else {
            getHandler(div).set修正の場合開催場所編集エリア();
        }
        div.getTxtKaisaibashoCode().setReadOnly(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 介護認定審査会開催場所一覧のクリック処理をします。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> 
        onClick_dataGridOnSelectBySelectButton(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        getHandler(div).set開催場所一覧の参照();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護認定審査会開催場所登録の「入力内容を取消する」ボタンが押下します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> 
        onClick_btnback(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).set開催場所編集エリアを初期化処理();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 介護認定審査会開催場所登録の「入力内容を更新する」ボタンが押下します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> 
        onClick_btnSyuuSei(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        開催場所コードの重複チェック(div);
        開催地区コードの存在チェック(div);
        getHandler(div).開催場所一覧の更新();
        div.getBtnTsuika().setDisabled(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 介護認定審査会開催場所登録の「保存する」ボタンが押下します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> 
        onClick_btnUpdate(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        } 
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).save();
            onLoad(div);
        }    
        return ResponseData.of(div).respond();
    }

    private SearchResult<ShinsakaiKaisaiBashoJoho> get開催場所一覧(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        SearchResult<ShinsakaiKaisaiBashoJoho> businessList;
        ShinsakaiKaisaiBashoJohoManager manager = ShinsakaiKaisaiBashoJohoManager.createInstance();
        if (デフォルト検索条件.equals(div.getRadHyojiJoken().getSelectedKey())) {
            businessList = manager.
                    get介護認定審査会開催場所情報一覧(GogitaiJohoMapperParameter.
                            createSelectBy審査会開催場所状況(有効));
        } else {
            businessList = manager.
                    get介護認定審査会開催場所情報一覧(GogitaiJohoMapperParameter.
                            createSelectBy審査会開催場所状況(全て));
        }
        Models<ShinsakaiKaisaiBashoJohoIdentifier, ShinsakaiKaisaiBashoJoho> shinsakaiKaisaiBashoJohoList
                = Models.create(businessList.records());
        ViewStateHolder.put(ViewStateKeys.開催場所情報一覧, shinsakaiKaisaiBashoJohoList);
        return businessList;
    }


    private void 開催場所コードの重複チェック(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        RString kaisaibashoCode = div.getTxtKaisaibashoCode().getValue();
        List<dgKaisaibashoIchiran_Row> rowList = div.getDgKaisaibashoIchiran().getDataSource();
        if (追加モード.equals(div.getShinakaiKaisaIbashoShosai().getJyotai())) {
            for (dgKaisaibashoIchiran_Row row : rowList) {
                if (kaisaibashoCode.equals(row.getKaisaibashoCode())) {
                    throw new ApplicationException(UrErrorMessages.既に登録済.getMessage().replace(
                            kaisaibashoCode.toString()));
                }
            }
            ShinsakaiKaisaiBashoJoho shinsakaiKaisaiBashoJoho = ShinsakaiKaisaiBashoJohoManager
                    .createInstance()
                    .get介護認定審査会開催場所情報(kaisaibashoCode).records().get(0);
            if (shinsakaiKaisaiBashoJoho != null) {
                throw new ApplicationException(UrErrorMessages.既に登録済.getMessage().replace(
                        kaisaibashoCode.toString()));
            }
        } else if (更新モード.equals(div.getShinakaiKaisaIbashoShosai().getJyotai())) {
            int selectId = div.getDgKaisaibashoIchiran().getClickedRowId();
            for (int i = 0; i < rowList.size(); i++) {
                if (i == selectId) {
                    continue;
                }
                if (kaisaibashoCode.equals(rowList.get(i).getKaisaibashoCode())) {
                    throw new ApplicationException(UrErrorMessages.既に登録済.getMessage().replace(
                            kaisaibashoCode.toString()));
                }
            }
        }
    }

    private boolean isUpdateHasChange(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        RStringBuilder stringBuilder = new RStringBuilder(div.getTxtKaisaibashoCode().getValue());
        stringBuilder.append(div.getTxtKaisaibashoMeisho().getValue())
         .append(div.getTxtKaisaibashoJusho().getValue())
         .append(div.getTxtTelNumber().getDomain().value())
         .append(div.getDdlKaisaiBashoJokyo().getSelectedValue())
         .append(div.getCcdKaisaiChikuCode().getCode().value());
        return !div.getShinakaiKaisaIbashoShosai().getSelectItem().equals(stringBuilder.toRString());
    }

    private boolean isAddHasChange(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        return !div.getTxtKaisaibashoCode().getValue().isEmpty()
                || !div.getTxtKaisaibashoMeisho().getValue().isEmpty()
                || !div.getTxtKaisaibashoJusho().getValue().isEmpty()
                || !div.getTxtTelNumber().getDomain().isEmpty()
                || !通常.equals(div.getDdlKaisaiBashoJokyo().getSelectedValue())
                || !div.getCcdKaisaiChikuCode().getCode().isEmpty()
                || !div.getCcdKaisaiChikuCode().getCodeMeisho().isEmpty();
    }
    
    private void 開催地区コードの存在チェック(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        // CodeMaster.getCode(コード種別,div.getCcdKaisaiChikuCode().getCode());
        // QA292は同様の問題があります、暫定以下の方式を実現。
        if (!div.getCcdKaisaiChikuCode().getCode().isEmpty()) {
            List<UzT0007CodeEntity> codeList = CodeMaster.getCode();
            if (codeList == null || codeList.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.コードマスタなし.getMessage().replace(
                        div.getCcdKaisaiChikuCode().getCode().getColumnValue().toString()));
            }
            boolean isNotExits = true;
            for (UzT0007CodeEntity entity : codeList) {
                if (コード種別.equals(entity.getコード種別())
                     && div.getCcdKaisaiChikuCode().getCode().equals(entity.getコード())) {
                    isNotExits = false;
                }
            }
            if (isNotExits) {
                throw new ApplicationException(UrErrorMessages.コードマスタなし.getMessage());
            }
        }
    }

    private NinteiShinsakaiKaisaibashoTorokuHandler getHandler(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        return new NinteiShinsakaiKaisaibashoTorokuHandler(div);
    }
}
