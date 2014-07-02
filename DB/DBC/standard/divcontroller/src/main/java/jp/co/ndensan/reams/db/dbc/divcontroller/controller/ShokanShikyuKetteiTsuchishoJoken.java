/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1000000.ShokanShikyuKetteiTsuchishoJokenDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還支給（不支給）決定通知書一括作成の抽出条件のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class ShokanShikyuKetteiTsuchishoJoken {

    private List<HashMap> getShokanShikyuTorokuShomeishoYaml() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc1000000/ShokanShikyuKetteiTsuchishoJoken.yml"));
    }

    private enum 日付種類 {

        受付日,
        決定日
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuKetteiTsuchishoJokenDiv> onLoad(ShokanShikyuKetteiTsuchishoJokenDiv panel) {
        ResponseData<ShokanShikyuKetteiTsuchishoJokenDiv> response = new ResponseData<>();

        setTsuchishoJoken(panel);

        setUketsukeKetteiData(panel, 日付種類.受付日);
        showUketsukeKettei(panel, 日付種類.受付日);

        response.data = panel;
        return response;
    }

    /**
     * 受付日/決定日 選択時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuKetteiTsuchishoJokenDiv> onChangeUketsukeKettei(ShokanShikyuKetteiTsuchishoJokenDiv panel) {
        日付種類 dateKind;
        RString key = panel.getTblUketsukeKetteiYMD().getRadUketsukeKetteiYMD().getSelectedItem();
        if (key.equals(new RString("key0"))) {
            dateKind = 日付種類.受付日;
        } else {
            dateKind = 日付種類.決定日;
        }
        setUketsukeKetteiData(panel, dateKind);
        showUketsukeKettei(panel, dateKind);
        ResponseData<ShokanShikyuKetteiTsuchishoJokenDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    private void setTsuchishoJoken(ShokanShikyuKetteiTsuchishoJokenDiv panel) {
        HashMap source = getShokanShikyuTorokuShomeishoYaml().get(0);

        panel.getTxtZenkaiTaishoYMD().setFromValue(new RDate(source.get("前回対象開始日").toString()));
        panel.getTxtZenkaiTaishoYMD().setToValue(new RDate(source.get("前回対象終了日").toString()));
        panel.getTblUketsukeKetteiYMD().getRadUketsukeKetteiYMD().setSelectedItem(new RString(source.get("受付決定key").toString()));
    }

    private void setUketsukeKetteiData(ShokanShikyuKetteiTsuchishoJokenDiv panel, 日付種類 dateKind) {
        HashMap source = getShokanShikyuTorokuShomeishoYaml().get(0);
        if (dateKind.equals(日付種類.受付日)) {
            panel.getTblUketsukeKetteiYMD().getTxtUketsukeYMD().setFromValue(new RDate(source.get("受付開始日").toString()));
            panel.getTblUketsukeKetteiYMD().getTxtUketsukeYMD().setToValue(new RDate(source.get("受付終了日").toString()));
            panel.getTblUketsukeKetteiYMD().getTxtKetteiYMD().clearFromValue();
            panel.getTblUketsukeKetteiYMD().getTxtKetteiYMD().clearToValue();
        } else {
            panel.getTblUketsukeKetteiYMD().getTxtUketsukeYMD().clearFromValue();
            panel.getTblUketsukeKetteiYMD().getTxtUketsukeYMD().clearToValue();
            panel.getTblUketsukeKetteiYMD().getTxtKetteiYMD().setFromValue(new RDate(source.get("決定開始日").toString()));
            panel.getTblUketsukeKetteiYMD().getTxtKetteiYMD().setToValue(new RDate(source.get("決定終了日").toString()));
        }
    }

    private void showUketsukeKettei(ShokanShikyuKetteiTsuchishoJokenDiv panel, 日付種類 dateKind) {
        if (dateKind.equals(日付種類.受付日)) {
            panel.getTblUketsukeKetteiYMD().getTxtUketsukeYMD().setDisabled(false);
            panel.getTblUketsukeKetteiYMD().getTxtKetteiYMD().setDisabled(true);
        } else {
            panel.getTblUketsukeKetteiYMD().getTxtUketsukeYMD().setDisabled(true);
            panel.getTblUketsukeKetteiYMD().getTxtKetteiYMD().setDisabled(false);
        }
    }
}
