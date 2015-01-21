/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.dba2030011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.ShikakuShosaiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.KihonJohoDiv;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.ResponseDatas;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.model.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.realservice.hihokenshadaicho.HihokenshaDaichoManager;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 住所地特例画面における、資格詳細Divのイベントを定義したDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class ShikakuShosai {

    /**
     * 画面が読み込まれた際に実行します。<br/>
     * 前画面から渡されているViewStateの該当者情報と画面IDを元に、住所地特例異動で使用する各種共有子Divの初期化を行います。
     *
     * @param shikakuShosaiDiv {@link ShikakuShosaiDiv 資格詳細Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格詳細Divを持つResponseData
     */
    public ResponseData<ShikakuShosaiDiv> onload(ShikakuShosaiDiv shikakuShosaiDiv, KihonJohoDiv kihonDiv) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class);
        IUrControlData controlData = UrControlDataFactory.createInstance();

        HihokenshaDaichoManager daichoManager = new HihokenshaDaichoManager();
        IItemList<HihokenshaDaichoModel> daichoList = daichoManager.get被保険者台帳一覧(
                new LasdecCode(controlData.getDonyuDantaiCode().getColumnValue()), taishoshaKey.get被保険者番号());

        return ResponseDatas.createSettingDataTo(shikakuShosaiDiv);
    }

    /**
     * 共通ボタンエリアの、該当者一覧へ戻るためのボタンが押下された際に実行します。<br/>
     *
     *
     * @param shikakuShosaiDiv {@link ShikakuShosaiDiv 資格詳細Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格詳細Divを持つResponseData
     */
    public ResponseData<ShikakuShosaiDiv> onClick_btnBackGaitoshaIchiran(ShikakuShosaiDiv shikakuShosaiDiv, KihonJohoDiv kihonDiv) {
        return ResponseDatas.createSettingDataTo(shikakuShosaiDiv);
    }

    /**
     * 共通ボタンエリアの、再検索を行うボタンが押下された際に実行します。<br/>
     *
     *
     * @param shikakuShosaiDiv {@link ShikakuShosaiDiv 資格詳細Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格詳細Divを持つResponseData
     */
    public ResponseData<ShikakuShosaiDiv> onClick_btnResearch(ShikakuShosaiDiv shikakuShosaiDiv, KihonJohoDiv kihonDiv) {
        return ResponseDatas.createSettingDataTo(shikakuShosaiDiv);
    }

    /**
     * 共通ボタンエリアの、住所地特例画面で入力した全ての情報を保存するためのボタンが押下された際に実行します。<br/>
     *
     *
     * @param shikakuShosaiDiv {@link ShikakuShosaiDiv 資格詳細Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShosaiDiv> onClick_btnUpdate(ShikakuShosaiDiv shikakuShosaiDiv, KihonJohoDiv kihonDiv) {
        return ResponseDatas.createSettingDataTo(shikakuShosaiDiv);
    }

    /**
     * {@link ShikakuShosai#onClick_btnUpdate}の処理が正常に完了した後に、自動的に実行されるイベントです。<br/>
     *
     *
     * @param shikakuShosaiDiv {@link ShikakuShosaiDiv 資格詳細Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShosaiDiv> onAfterClick_btnUpdate(ShikakuShosaiDiv shikakuShosaiDiv, KihonJohoDiv kihonDiv) {
        return ResponseDatas.createSettingDataTo(shikakuShosaiDiv);
    }
}
