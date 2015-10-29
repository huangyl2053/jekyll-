/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1810000.KashitsukeHenkanListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuhiKashitsukekinList.dgKyufuhiKashitsukekinList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1810000.DBC1810000StateName.徴収登録;

/**
 * 給付費貸付金返還徴収登録の給付費貸付金一覧のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class KashitsukeHenkanList {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KashitsukeHenkanListDiv> onLoad(KashitsukeHenkanListDiv panel) {
        setKashitsukeHenkanListData(panel);

        return ResponseData.of(panel).respond();
    }

    public ResponseData<KashitsukeHenkanListDiv> toTorokuDiv(KashitsukeHenkanListDiv panel) {

        return ResponseData.of(panel).setState(徴収登録);
    }

    private void setKashitsukeHenkanListData(KashitsukeHenkanListDiv panel) {

        DataGrid<dgKyufuhiKashitsukekinList_Row> dgRow = panel.getKashitsukeHenkanListInfo().getDgKyufuhiKashitsukekinList();
        List<dgKyufuhiKashitsukekinList_Row> dgRowList = dgRow.getDataSource();

        //TODO n3317塚田　遷移するために空のリストを作成
        dgRowList.add(new dgKyufuhiKashitsukekinList_Row());
//            dgRowList.add(create給付費貸付金一覧アイテム(
//                    cg.getAsRString("被保番号"),
//                    cg.getAsRString("被保険者氏名"),
//                    cg.getAsRString("被保険者カナ"),
//                    cg.getAsRString("借入受付日"),
//                    cg.getAsRString("借入申請日"),
//                    cg.getAsRString("借入利用開始日"),
//                    cg.getAsRString("借入利用終了日"),
//                    cg.getAsRString("貸付対象サービス種類"),
//                    cg.getAsRString("事業者の支払請求額"),
//                    cg.getAsRString("申請金額"),
//                    cg.getAsRString("貸付審査決定日"),
//                    cg.getAsRString("貸付承認不承認"),
//                    cg.getAsRString("借受日"),
//                    cg.getAsRString("償還期限延長申請日")
//            ));
//        }
    }

//    private dgKyufuhiKashitsukekinList_Row create給付費貸付金一覧アイテム(
//            RString txtHihoNo,
//            RString txtHihokenshaName,
//            RString txtHihokenshaKana,
//            RString txtUketsukeYMD,
//            RString txtShinseiYMD,
//            RString txtKaishiYMD,
//            RString txtShuryoYMD,
//            RString txtServiceShurui,
//            RString txtSeikyugaku,
//            RString txtShinseigaku,
//            RString txtKetteiYMD,
//            RString txtShonin,
//            RString txtKariukeYMD,
//            RString txtEnchoShinseiYMD
//    ) {
//        dgKyufuhiKashitsukekinList_Row item = new dgKyufuhiKashitsukekinList_Row(
//                txtHihoNo,
//                txtHihokenshaName,
//                txtHihokenshaKana,
//                txtUketsukeYMD,
//                txtShinseiYMD,
//                txtKaishiYMD,
//                txtShuryoYMD,
//                txtServiceShurui,
//                txtSeikyugaku,
//                txtShinseigaku,
//                txtKetteiYMD,
//                txtShonin,
//                txtKariukeYMD,
//                txtEnchoShinseiYMD
//        );
//        return item;
//    }
}
