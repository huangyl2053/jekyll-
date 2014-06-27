/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0500011.SearchResultShoKaishuKanriDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0500011.ShoKaishuJokyoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishukirokukanri.ShoKaishuJokyoShosaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishukirokukanri.dgShoKaishuJokyo_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 *
 * @author n8178 城間篤人
 */
public class ShoKaishuJokyo {

    /**
     * 証回収状況検索結果グリッドから、処理の対象とするデータを1つ選んだときに実行されます。<br/>
     * 処理対象者の詳細情報を表示します。
     *
     * @param shoKaishuJoho 証回収詳細情報Div
     * @param searchResultDiv　証回収状況検索結果Div
     * @return レスポンス
     */
    public ResponseData onSelectBySelectButton_SearchResultShoKaishuJokyoList(ShoKaishuJokyoDiv shoKaishuJoho,
            SearchResultShoKaishuKanriDiv searchResultDiv) {
        ResponseData<ShoKaishuJokyoDiv> response = new ResponseData<>();

        ShoKaishuJokyoShosaiDiv shosai = shoKaishuJoho.getShoKaishuJokyoShosai();
        dgShoKaishuJokyo_Row row = searchResultDiv.getSearchResultShoKaishuJokyoList().getDgShoKaishuJokyo().getClickedItem();

        shosai.getTxtKofuDate().setValue(row.getKofuDate().getValue());
        shosai.getTxtKofuJiyu().setValue(row.getKofuJiyu());
        shosai.getTxtKofuRiyu().setValue(row.getKofuRiyu());
        shosai.getTxtKofuShoShurui().setValue(row.getKofushoShurui());
        shosai.getTxtYukoKigen().setValue(row.getYukoKigen().getValue());
        shosai.getDdlKaishuJiyu().setSelectedItem(row.getKaishuJiyuKey());
        shosai.getTxtKaishuDate().setValue(row.getKaishuDate().getValue());
        shosai.getTxtKaishuRiyu().setValue(row.getKaishuRiyu());

        response.data = shoKaishuJoho;
        return response;
    }

    /**
     * 証類回収情報入力画面-「証類状況を保存する」ボタン活性非活性制御を表します。
     *
     * @param shoKaishuJoho 証回収詳細情報Div
     * @param searchResultDiv　証回収状況検索結果Div
     * @return ResponseData
     */
    public ResponseData<ShoKaishuJokyoDiv> setEnableControl(ShoKaishuJokyoDiv shoKaishuJoho,
            SearchResultShoKaishuKanriDiv searchResultDiv) {
        ResponseData<ShoKaishuJokyoDiv> response = new ResponseData<>();

        if (shoKaishuJoho.getShoKaishuJokyoShosai().getTxtKaishuDate().getText().isEmpty()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSave"), true);
        } else {
            if (shoKaishuJoho.getShoKaishuJokyoShosai().getDdlKaishuJiyu().getSelectedValue().isEmpty()) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSave"), true);
            } else {
                if (shoKaishuJoho.getShoKaishuJokyoShosai().getTxtKaishuRiyu().getText().isEmpty()) {
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSave"), true);
                } else {
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSave"), false);
                }
            }
        }

        response.data = shoKaishuJoho;
        return response;
    }

}
