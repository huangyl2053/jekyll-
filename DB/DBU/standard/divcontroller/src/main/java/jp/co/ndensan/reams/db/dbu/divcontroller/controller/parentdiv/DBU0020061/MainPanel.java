/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0020061;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020061.DBU0020061TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020061.MainPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0020061.MainPanelHandler;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 事業報告（月報）補正発行_様式１(別紙)のクラス
 */
public class MainPanel {

    private static final RString 修正 = new RString("修正");

    /**
     * 画面ロードメソッド
     *
     * @param div MainPanelDiv
     * @return ResponseData<MainPanelDiv>
     */
    public ResponseData<MainPanelDiv> onLoad(MainPanelDiv div) {
        MainPanelHandler handler = getHandler(div);
        // TODO 引き継ぎデータの取得
//        RString entity = ViewStateHolder.get(ViewStateKeys.償還払請求パラメータ, XXX.class);
        RString 引き継ぎデータEntity = new RString("");
        List<DbT7021JigyoHokokuTokeiDataEntity> 更新前データリスト = handler.get更新前データリスト(引き継ぎデータEntity);
        handler.更新前データリスト初期化(更新前データリスト.get(0));
        return ResponseData.of(div).respond();
    }

    /**
     * 保存ボタンークをリックして時実行するメソッド
     *
     * @param div MainPanelDiv
     * @return ResponseData<MainPanelDiv>
     */
    public ResponseData<MainPanelDiv> onClick_btnSave(MainPanelDiv div) {
        MainPanelHandler handler = getHandler(div);
        // TODO 引き継ぎデータの取得
        // RString entity = ViewStateHolder.get(ViewStateKeys.償還払請求パラメータ, XXX.class);
        RString 引き継ぎデータEntity = new RString("");
        //TODO ビジネス設計_DBUMN91003_事業報告（月報）補正発行.xlsxの「事業報告月報詳細データの取得」を呼び出す
        //DbT7021JigyoHokokuTokeiDataEntity 事業報告統計データEntityリスト = getJigyoHokokuGeppoDetal(報告年, 報告月, 集計対象年, 集計対象月, 統計対象区分, 市町村コード, 表番号, 集計番号);
        if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (handler.get修正データ(引き継ぎデータEntity).isEmpty()) {
                throw new ApplicationException(DbzErrorMessages.編集なしで更新不可.getMessage());
            }
            if (!div.getDaiichigohiHokenshazogenUchiWake().getTblSetaiSu().getTxtTonenZoTennyu().getValue().add(
                    div.getDaiichigohiHokenshazogenUchiWake().getTxtTonenZoShokkenfukkatsu().getValue()).subtract(
                            div.getDaiichigohiHokenshazogenUchiWake().getTblSetaiSu().getTxtTonenZorokugosaitotatsu().getValue()).equals(
                            div.getDaiichigohiHokenshazogenUchiWake().getTblSetaiSu().getTxtTonenZoTekiyojogaihi().getValue())) {
                throw new ApplicationException(UrWarningMessages.相違.getMessage().replace("当月末現在の世帯数", "前月末世帯数から増減した世帯数の計算結果"));
            }
            if (handler.get修正データ(引き継ぎデータEntity).size() > 0) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
            }
        }
//        else if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
//            // 「ビジネス設計_DBUMN91003_事業報告（月報）補正発行.xlsx」の「事業報告月報詳細データの削除」を呼び出す
//            // 引数：削除条件オブジェクト
//        }
        return ResponseData.of(div).respond();
    }

    /**
     * 戻るボタンークをリックして時実行するメソッド
     *
     * @param div MainPanelDiv
     * @return ResponseData<MainPanelDiv>
     */
    public ResponseData<MainPanelDiv> onClick_btnBack(MainPanelDiv div) {
        MainPanelHandler handler = getHandler(div);
        // TODO 引き継ぎデータの取得
        RString 引き継ぎデータentity = new RString("");
        if (handler.get修正データ(引き継ぎデータentity).isEmpty()) {
            return ResponseData.of(div).forwardWithEventName(DBU0020061TransitionEventName.補正発行検索に戻る).respond();
        } else if (handler.get修正データ(引き継ぎデータentity).size() > 0) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    private MainPanelHandler getHandler(MainPanelDiv div) {
        return MainPanelHandler.of(div);
    }

}
