/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1810000.KashitsukeHenkanListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinList.dgKyufuhiKashitsukekinList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 給付費貸付金返還徴収登録の給付費貸付金一覧のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class KashitsukeHenkanList {

    private List<HashMap> getYaml() {
        return YamlLoader.DBC.loadAsList(new RString("dbc1810000/KashitsukeHenkanList.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KashitsukeHenkanListDiv> onLoad(KashitsukeHenkanListDiv panel) {
        setKashitsukeHenkanListData(panel);

        ResponseData<KashitsukeHenkanListDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    private void setKashitsukeHenkanListData(KashitsukeHenkanListDiv panel) {

        List<HashMap> sourceList = getYaml();
        DataGrid<dgKyufuhiKashitsukekinList_Row> dgRow = panel.getKashitsukeHenkanListInfo().getDgKyufuhiKashitsukekinList();
        List<dgKyufuhiKashitsukekinList_Row> dgRowList = dgRow.getDataSource();

        for (int i = 0; i < 3; i++) {
            ControlGenerator cg = new ControlGenerator(sourceList.get(i));
            dgRowList.add(create給付費貸付金一覧アイテム(
                    cg.getAsRString("被保番号"),
                    cg.getAsRString("被保険者氏名"),
                    cg.getAsRString("被保険者カナ"),
                    cg.getAsRString("借入受付日"),
                    cg.getAsRString("借入申請日"),
                    cg.getAsRString("借入利用開始日"),
                    cg.getAsRString("借入利用終了日"),
                    cg.getAsRString("貸付対象サービス種類"),
                    cg.getAsRString("事業者の支払請求額"),
                    cg.getAsRString("申請金額"),
                    cg.getAsRString("貸付審査決定日"),
                    cg.getAsRString("貸付承認不承認"),
                    cg.getAsRString("借受日"),
                    cg.getAsRString("償還期限延長申請日")
            ));
        }
    }

    private dgKyufuhiKashitsukekinList_Row create給付費貸付金一覧アイテム(
            RString txtHihoNo,
            RString txtHihokenshaName,
            RString txtHihokenshaKana,
            RString txtUketsukeYMD,
            RString txtShinseiYMD,
            RString txtKaishiYMD,
            RString txtShuryoYMD,
            RString txtServiceShurui,
            RString txtSeikyugaku,
            RString txtShinseigaku,
            RString txtKetteiYMD,
            RString txtShonin,
            RString txtKariukeYMD,
            RString txtEnchoShinseiYMD
    ) {
        dgKyufuhiKashitsukekinList_Row item = new dgKyufuhiKashitsukekinList_Row(
                txtHihoNo,
                txtHihokenshaName,
                txtHihokenshaKana,
                txtUketsukeYMD,
                txtShinseiYMD,
                txtKaishiYMD,
                txtShuryoYMD,
                txtServiceShurui,
                txtSeikyugaku,
                txtShinseigaku,
                txtKetteiYMD,
                txtShonin,
                txtKariukeYMD,
                txtEnchoShinseiYMD
        );
        return item;
    }
}
