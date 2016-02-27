/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0060021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiDataIdentifier;
import jp.co.ndensan.reams.db.dbu.definition.core.zigyouhoukokunenpou.ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity;
import jp.co.ndensan.reams.db.dbu.definition.enumeratedtype.DbuViewStateKey;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo.SearchJigyoHokokuNenpo;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060021.DBU0060021StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060021.DBU0060021TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060021.NenpoYoushiki1HoseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0060021.NenpoYoushiki1HoseiHandler;
import jp.co.ndensan.reams.db.dbu.service.core.jigyohokokunenpo.JigyoHokokuNenpoHoseiHakoManager;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 老人保健受給者台帳管理Divを制御します。
 */
public class NenpoYoushiki1Hosei {

    private static final int 選択した市町村コード = 6;
    private static final RString 処理種別_修正 = new RString("修正");
    private static final RString 処理種別_削除 = new RString("削除");

    /**
     * 事業状況報告（年報）補正様式１補正画面初期化を処理します。
     *
     * @param div NenpoYoushiki1Hosei のクラスファイル
     * @return ResponseData<NenpoYoushiki1HoseiDiv>
     */
    public ResponseData<NenpoYoushiki1HoseiDiv> onLoad(NenpoYoushiki1HoseiDiv div) {
        ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity param = ViewStateHolder.get(DbuViewStateKey.補正検索画面情報,
                ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity.class);
        List<JigyoHokokuTokeiData> jigyoHokokuTokeiDataList = JigyoHokokuNenpoHoseiHakoManager.createInstance()
                .getJigyoHokokuNenpoDetal(new SearchJigyoHokokuNenpo(new FlexibleYear(param.get画面報告年度()),
                                new FlexibleYear(param.get画面集計年度()),
                                new LasdecCode(param.get選択した市町村コード().substring(0, 選択した市町村コード)),
                                param.get事業報告年報補正表示のコード(),
                                Code.EMPTY)).records();
        if (jigyoHokokuTokeiDataList.isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
            }
            if (new RString(UrInformationMessages.該当データなし.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)) {
                return ResponseData.of(div).forwardWithEventName(DBU0060021TransitionEventName.検索に戻る).respond();
            }
        }
        Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> jigyoHokokuTokeiData = Models.create(jigyoHokokuTokeiDataList);
        ViewStateHolder.put(ViewStateKeys.開催場所情報一覧, jigyoHokokuTokeiData);
        createHandler(div).initialize(jigyoHokokuTokeiDataList, param);
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンの押下後処理します。
     *
     * @param div NenpoYoushiki1Hosei のクラスファイル
     * @return ResponseData<NenpoYoushiki1HoseiDiv>
     */
    public ResponseData<NenpoYoushiki1HoseiDiv> onClick_btnUpdate(NenpoYoushiki1HoseiDiv div) {
        ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity param = ViewStateHolder.get(DbuViewStateKey.補正検索画面情報, ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity.class);
        if (処理種別_修正.equals(param.get補正フラグ())) {
            List<JigyoHokokuTokeiData> 修正データの取得リスト = 修正データのチェック(div);
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)) {
                JigyoHokokuNenpoHoseiHakoManager.createInstance().updateJigyoHokokuNenpoData(修正データの取得リスト);
                div.getKanryoMessge().getCCKanryoMessge().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                        .replace("更新").evaluate()),
                        RString.EMPTY, RString.EMPTY, true);
                return ResponseData.of(div).setState(DBU0060021StateName.完了状態);
            }
        } else if (処理種別_削除.equals(param.get補正フラグ())) {
            deleteJigyoHokokuNenpoData();
            div.getKanryoMessge().getCCKanryoMessge().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                    .replace("削除").evaluate()),
                    RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBU0060021StateName.完了状態);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 該当一覧へ戻るボタンの押下後処理します。
     *
     * @param div NenpoYoushiki1Hosei のクラスファイル
     * @return ResponseData<NenpoYoushiki1HoseiDiv>
     */
    public ResponseData<NenpoYoushiki1HoseiDiv> onClick_btnBack(NenpoYoushiki1HoseiDiv div) {
        NenpoYoushiki1HoseiHandler handler = createHandler(div);
        List<JigyoHokokuTokeiData> 修正データの取得リスト = handler.修正データの取得();
        if (修正データの取得リスト.isEmpty()) {
            return ResponseData.of(div).forwardWithEventName(DBU0060021TransitionEventName.検索に戻る).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)) {
            return ResponseData.of(div).forwardWithEventName(DBU0060021TransitionEventName.検索に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    private void deleteJigyoHokokuNenpoData() {
        Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> jigyoHokokuTokeiData = ViewStateHolder.get(ViewStateKeys.開催場所情報一覧, Models.class);
        List<JigyoHokokuTokeiData> 事業報告集計一覧データリスト = new ArrayList<>();
        for (JigyoHokokuTokeiData date : jigyoHokokuTokeiData) {
            事業報告集計一覧データリスト.add(date);
        }
        JigyoHokokuNenpoHoseiHakoManager.createInstance().deleteJigyoHokokuNenpoData(事業報告集計一覧データリスト);
    }

    private List<JigyoHokokuTokeiData> 修正データのチェック(NenpoYoushiki1HoseiDiv div) {
        List<JigyoHokokuTokeiData> 修正データの取得リスト = createHandler(div).修正データの取得();
        if (修正データの取得リスト.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
        }
        return 修正データの取得リスト;
    }

    private NenpoYoushiki1HoseiHandler createHandler(NenpoYoushiki1HoseiDiv div) {
        return new NenpoYoushiki1HoseiHandler(div);
    }
}
