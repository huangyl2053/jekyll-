/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.jyutakugaisyunaiyolist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanjutakukaishu.ShokanJutakuKaishuBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.JyutakugaisyunaiyoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.dgGaisyuList_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 *
 * 住宅改修内容一覧のHandlerクラスです。
 */
public class JyutakugaisyunaiyoListHandler {

    private final JyutakugaisyunaiyoListDiv div;
    private static final RString 状態_登録 = new RString("登録");
    private static final RString 状態_参照 = new RString("参照");

    public JyutakugaisyunaiyoListHandler(JyutakugaisyunaiyoListDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param 状態
     * @param jyutakugaisyunaiyoList 住宅改修一覧
     */
    public void initialize(RString 状態, SearchResult<ShokanJutakuKaishuBusiness> jyutakugaisyunaiyoList) {
        List<dgGaisyuList_Row> dgGaisyuListRow = new ArrayList<>();
        if (!jyutakugaisyunaiyoList.records().isEmpty()) {
            for (ShokanJutakuKaishuBusiness jyutaku : jyutakugaisyunaiyoList.records()) {
                dgGaisyuList_Row listRow = new dgGaisyuList_Row();
                if (jyutaku.get住宅改修着工年月日() != null) {
                    listRow.setTxtChakkoYoteibi(jyutaku.get住宅改修着工年月日().wareki().toDateString());
                }
                if (jyutaku.get住宅改修完成年月日() != null) {
                    listRow.setTxtKanseiYoteibi(jyutaku.get住宅改修完成年月日().wareki().toDateString());
                }
                listRow.setTxtKaishuKingaku(new RString(String.valueOf(jyutaku.get改修金額())));
                listRow.setTxtJigyosha(jyutaku.get住宅改修事業者名());
                listRow.setTxtJyotai(RString.EMPTY);
                listRow.setTxtJutakuAddress(jyutaku.get住宅改修住宅住所());
                listRow.setTxtKaishuNaiyo(jyutaku.get住宅改修内容());
                listRow.setTxtSeiriNo(jyutaku.get整理番号());
                dgGaisyuListRow.add(listRow);
            }
        }
        div.getTxtKaisyunaiyo().setValue(RString.EMPTY);
        div.getTxtKaisyunaiyo().setReadOnly(true);
        div.getTxtJigyosya().setValue(RString.EMPTY);
        div.getTxtJigyosya().setReadOnly(true);
        div.getBtnHonnijyusyoCopy().setDisabled(true);
        div.getTxtJyusyo().clearDomain();
        div.getTxtJyusyo().setReadOnly(true);
        div.getTxtTyakkoyotebi().clearValue();
        div.getTxtTyakkoyotebi().setReadOnly(true);
        div.getTxtKanseyotebi().clearValue();
        div.getTxtKanseyotebi().setReadOnly(true);
        div.getTxtKaisyukingaku().clearValue();
        div.getTxtKaisyukingaku().setReadOnly(true);
        div.getBtnClear().setDisabled(true);
        div.getBtnDetailConfirm().setDisabled(true);
        this.get状態(状態, dgGaisyuListRow);
    }

    private void get状態(RString 状態, List<dgGaisyuList_Row> dgGaisyuListRow) {
        div.getDgGaisyuList().setDataSource(dgGaisyuListRow);
        if (状態_登録.equals(状態)) {
            div.getBtnDetailAdd().setVisible(true);
            div.getDgGaisyuList().getGridSetting().setIsShowModifyButtonColumn(true);
            div.getDgGaisyuList().getGridSetting().setIsShowDeleteButtonColumn(true);
            div.getDgGaisyuList().getGridSetting().setIsShowSelectButtonColumn(false);
        } else if (状態_参照.equals(状態)) {
            div.getBtnDetailAdd().setVisible(false);
            div.getDgGaisyuList().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getDgGaisyuList().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getDgGaisyuList().getGridSetting().setIsShowSelectButtonColumn(true);
        }
    }
}
