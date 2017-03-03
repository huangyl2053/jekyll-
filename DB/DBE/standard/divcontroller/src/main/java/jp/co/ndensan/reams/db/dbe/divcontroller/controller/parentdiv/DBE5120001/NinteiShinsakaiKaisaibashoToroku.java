/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5120001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5120001.DBE5120001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5120001.DBE5120001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5120001.dgKaisaibashoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5120001.NinteiShinsakaiKaisaibashoTorokuHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ShinsakaiKaisaiYoteiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.gogitaijoho.GogitaiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzQuestionMessages;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.gogitaijoho.gogitaijoho.GogitaiJohoMapperParameter;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 介護認定審査会開催場所登録Divを制御クラスです。
 *
 * @reamsid_L DBE-0100-010 wangkun
 */
public class NinteiShinsakaiKaisaibashoToroku {

    private static final RString 更新モード = new RString("修正");
    private static final RString 追加モード = new RString("追加");
    private static final RString 削除モード = new RString("削除");
    private static final RString 通常 = new RString("通常");
    private static final RString デフォルト検索条件 = new RString("yuuKo");
    private static final boolean 有効 = true;
    private static final boolean 全て = false;
    private final RString 開催場所登録 = new RString("開催場所登録");
    private final RString 合議体情報 = new RString("合議体情報");
    private final RString 介護認定審査会開催予定情報 = new RString("介護認定審査会開催予定情報");
    private final RString 介護認定審査会開催結果情報 = new RString("介護認定審査会開催結果情報");

    /**
     * 介護認定審査会開催場所登録の初期処理を表示します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> onLoad(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        RString 最大表示件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getShinsakaiKaisaibashokensaku().getTxtDispMax().setValue(new Decimal(最大表示件数.toString()));
        getHandler(div).set介護認定審査会開催場所一覧(get開催場所一覧(div));
        div.getBtnTsuika().setDisabled(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), true);
        return ResponseData.of(div).respond();
    }

    /**
     * 介護認定審査会開催場所登録の「クリア」ボタンが押下します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> onClick_btnClear(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        div.getShinsakaiKaisaibashokensaku().getRadHyojiJoken().setSelectedKey(デフォルト検索条件);
        RString 最大表示件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getShinsakaiKaisaibashokensaku().getTxtDispMax().setValue(new Decimal(最大表示件数.toString()));
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), false);
        return ResponseData.of(div).respond();
    }

    /**
     * 介護認定審査会開催場所登録の「検索する」ボタンが押下します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv>
            onClick_btnKensaku(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        boolean ChangeFlg = is変更有無(div);
        if (ChangeFlg) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }

        if (!ChangeFlg || new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).set介護認定審査会開催場所一覧(get開催場所一覧(div));
            div.getBtnTsuika().setDisabled(false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), true);
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 介護認定審査会開催場所登録の「追加」ボタンが押下します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> onClick_btnTsuiKa(NinteiShinsakaiKaisaibashoTorokuDiv div) {
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
        div.getShinsakaiKaisaibashokensaku().setReadOnly(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), true);
        return ResponseData.of(div).respond();
    }

    /**
     * 介護認定審査会開催場所登録の「削除」ボタンが押下します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> onClick_dataGridOnSelectByDeleteButton(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            RString 状態 = div.getDgKaisaibashoIchiran().getClickedItem().getJyotai();
            if (削除モード.equals(状態)) {
                Message message = DbzQuestionMessages.削除取消の確認.getMessage();
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(DbzQuestionMessages.削除取消の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).set開催場所一覧の削除();
//            div.getBtnTsuika().setDisabled(false);
//            div.getShinsakaiKaisaibashokensaku().setReadOnly(false);
        } else {
            getHandler(div).set削除の場合開催場所編集エリア();
        }
//        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), false);
        
//        getHandler(div).set開催場所一覧の削除();
//        div.getBtnTsuika().setDisabled(true);
//        div.getShinsakaiKaisaibashokensaku().setReadOnly(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 介護認定審査会開催場所登録の「修正」ボタンが押下します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> onClick_dataGridOnSelectByModifyButton(NinteiShinsakaiKaisaibashoTorokuDiv div) {
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
        div.getBtnTsuika().setDisabled(true);
        div.getTxtKaisaibashoCode().setReadOnly(true);
        div.getShinsakaiKaisaibashokensaku().setReadOnly(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), true);
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
        div.getBtnTsuika().setDisabled(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 介護認定審査会開催場所登録の「入力内容を取消する」ボタンが押下します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> onClick_btnback(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        if ((更新モード.equals(div.getShinakaiKaisaIbashoShosai().getJyotai()) && isUpdateHasChange(div))
                || (isAddHasChange(div) && 追加モード.equals(div.getShinakaiKaisaIbashoShosai().getJyotai()))) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).set開催場所編集エリアを初期化処理();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        } else {
            getHandler(div).set開催場所編集エリアを初期化処理();
        }
        div.getShinsakaiKaisaibashokensaku().setReadOnly(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), false);
        return ResponseData.of(div).respond();
    }

    /**
     * 介護認定審査会開催場所登録の「入力内容を更新する」ボタンが押下します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> onClick_btnSyuuSei(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        開催場所コードの重複チェック(div);
        開催地区コードの存在チェック(div);
        開催場所コードの使用チェック(div);
        getHandler(div).開催場所一覧の更新();
        div.getBtnTsuika().setDisabled(false);
        div.getShinsakaiKaisaibashokensaku().setReadOnly(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), false);
        return ResponseData.of(div).respond();
    }

    /**
     * 介護認定審査会開催場所登録の「保存する」ボタンが押下します。
     *
     * @param div NinteiShinsakaiKaisaibashoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> onClick_btnUpdate(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            Models<ShinsakaiKaisaiBashoJohoIdentifier, ShinsakaiKaisaiBashoJoho> shinsakaiKaisaiBashoJohoList
                    = ViewStateHolder.get(ViewStateKeys.開催場所情報一覧, Models.class);
            getHandler(div).save(shinsakaiKaisaiBashoJohoList);
            div.getCcdKanryoMsg().setMessage(new RString(UrInformationMessages.正常終了.getMessage().
                    replace(開催場所登録.toString()).evaluate()), RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE5120001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「完了する」ボタン イベントハンドラです。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiKaisaibashoTorokuDiv> onClick_btnComplete(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBE5120001TransitionEventName.処理完了).respond();
    }

    private List<ShinsakaiKaisaiBashoJoho> get開催場所一覧(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        List<ShinsakaiKaisaiBashoJoho> businessList;
        ShinsakaiKaisaiBashoJohoManager manager = ShinsakaiKaisaiBashoJohoManager.createInstance();
        if (デフォルト検索条件.equals(div.getRadHyojiJoken().getSelectedKey())) {
            businessList = manager.
                    get介護認定審査会開催場所情報一覧(GogitaiJohoMapperParameter.
                            createSelectBy審査会開催場所状況(有効, div.getShinsakaiKaisaibashokensaku().getTxtDispMax().getValue().intValue()))
                    .records();
        } else {
            businessList = manager.
                    get介護認定審査会開催場所情報一覧(GogitaiJohoMapperParameter.
                            createSelectBy審査会開催場所状況(全て, div.getShinsakaiKaisaibashokensaku().getTxtDispMax().getValue().intValue()))
                    .records();
        }
        Models<ShinsakaiKaisaiBashoJohoIdentifier, ShinsakaiKaisaiBashoJoho> shinsakaiKaisaiBashoJohoList
                = Models.create(businessList);
        ViewStateHolder.put(ViewStateKeys.開催場所情報一覧, shinsakaiKaisaiBashoJohoList);
        return businessList;
    }

    private int get最大件数(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        ShinsakaiKaisaiBashoJohoManager manager = ShinsakaiKaisaiBashoJohoManager.createInstance();
        int 最大件数 = manager.get介護認定審査会開催場所情報一覧().records().size();
        return 最大件数;
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
            if (ShinsakaiKaisaiBashoJohoManager
                    .createInstance()
                    .get介護認定審査会開催場所情報(kaisaibashoCode) != null) {
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
        if (!div.getCcdKaisaiChikuCode().getCode().isEmpty()) {
            List<UzT0007CodeEntity> codeList = CodeMaster.getCode(SubGyomuCode.DBE認定支援, DBECodeShubetsu.審査会地区コード.getコード(),
                    FlexibleDate.getNowDate());
            if (codeList == null || codeList.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.コードマスタなし.getMessage().replace(
                        div.getCcdKaisaiChikuCode().getCode().getColumnValue().toString()));
            }
            boolean isNotExits = true;
            for (UzT0007CodeEntity entity : codeList) {
                if (div.getCcdKaisaiChikuCode().getCode().equals(entity.getコード())) {
                    isNotExits = false;
                }
            }
            if (isNotExits) {
                throw new ApplicationException(UrErrorMessages.コードマスタなし.getMessage());
            }
        }
    }

    private void 開催場所コードの使用チェック(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        if (div.getShinakaiKaisaIbashoShosai().getJyotai().equals(削除モード)) {

            //チェック対象
            //　合議体情報(DbT5591GogitaiJoho)
            //　介護認定審査会開催予定情報(DbT5501ShinsakaiKaisaiYoteiJoho)
            //　介護認定審査会開催結果情報(Dbt5511ShinsakaiKaisaiKekkaJoho)
            RString ret = 開催場所コードの使用各テーブルチェック(div.getDgKaisaibashoIchiran().getClickedItem());

            if (!ret.equals(RString.EMPTY)) {
                // DbzErrorMessages.実行不可(?ため?できません。)
                throw new ApplicationException(DbzErrorMessages.実行不可.getMessage().replace(ret.concat("で開催場所コードが使用されている").toString(), "削除"));
            }
        }
    }

    private RString 開催場所コードの使用各テーブルチェック(dgKaisaibashoIchiran_Row row) {

        RString 開催場所コード = row.getKaisaibashoCode();

        //　合議体情報(DbT5591GogitaiJoho)
        if (GogitaiJohoManager.createInstance().count合議体情報リストBy開催場所コード(開催場所コード) > 0) {
            return 合議体情報;
        }

        //　介護認定審査会開催予定情報(DbT5501ShinsakaiKaisaiYoteiJoho)
        ShinsakaiKaisaiYoteiJohoManager shinsakaiKaisaiYoteiJohoManager = new ShinsakaiKaisaiYoteiJohoManager();
        if (!shinsakaiKaisaiYoteiJohoManager.get介護認定審査会開催予定情報リストBy開催場所コード(開催場所コード).isEmpty()) {
            return 介護認定審査会開催予定情報;
        }

        //　介護認定審査会開催結果情報(Dbt5511ShinsakaiKaisaiKekkaJoho)
        if (!ShinsakaiKaisaiKekkaJohoManager.createInstance().get介護認定審査会開催結果情報リストBy開催場所コード(開催場所コード).isEmpty()) {
            return 介護認定審査会開催結果情報;
        }

        return RString.EMPTY;
       
    }

    private NinteiShinsakaiKaisaibashoTorokuHandler getHandler(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        return new NinteiShinsakaiKaisaibashoTorokuHandler(div);
    }

    private boolean is変更有無(NinteiShinsakaiKaisaibashoTorokuDiv div) {
        List<dgKaisaibashoIchiran_Row> rowList = div.getDgKaisaibashoIchiran().getDataSource();
        for (dgKaisaibashoIchiran_Row row : rowList) {
            if (!RString.isNullOrEmpty(row.getJyotai())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
