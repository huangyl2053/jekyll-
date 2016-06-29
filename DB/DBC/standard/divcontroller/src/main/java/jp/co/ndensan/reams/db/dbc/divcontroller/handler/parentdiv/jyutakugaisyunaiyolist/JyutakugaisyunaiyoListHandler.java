/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.jyutakugaisyunaiyolist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.jyutakugaisyunaiyolist.JyutakugaisyunaiyoListDataPassModel;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.JyutakugaisyunaiyoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.dgGaisyuList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.jyutakukaisyuyichiran.JyutakukaisyuyichiranFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 住宅改修内容一覧のHandlerクラスです。
 *
 * @reamsid_L DBC-0940-010 yaodongsheng
 */
public class JyutakugaisyunaiyoListHandler {

    private final JyutakugaisyunaiyoListDiv div;
    private static final RString 状態_登録 = new RString("toroku");
    private static final RString 状態_参照 = new RString("sansyo");

    /**
     * コンストラクタです。
     *
     * @param div 住宅改修内容一覧Div
     */
    public JyutakugaisyunaiyoListHandler(JyutakugaisyunaiyoListDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param model JyutakugaisyunaiyoListDataPassModel
     */
    public void initialize(JyutakugaisyunaiyoListDataPassModel model) {
        div.setJushoData(DataPassingConverter.serialize(model.get識別コード()));
        RString 状態 = model.get状態();
        SearchResult<ShokanJutakuKaishu> jyutakugaisyunaiyoList;
        HihokenshaNo 被保険者番号 = model.get被保険者番号();
        FlexibleYearMonth サービス提供年月 = model.getサービス提供年月();
        RString 整理番号 = model.get整理番号();
        RString 様式番号 = model.get様式番号();
        if (被保険者番号 == null || サービス提供年月 == null || 整理番号 == null || 様式番号 == null) {
            jyutakugaisyunaiyoList = SearchResult.of(new ArrayList<>(), 0, false);
        } else {
            jyutakugaisyunaiyoList = JyutakukaisyuyichiranFinder
                    .createInstance().selectJyutakukaisyuList(被保険者番号, サービス提供年月, 整理番号, 様式番号);
        }
        Models<ShokanJutakuKaishuIdentifier, ShokanJutakuKaishu> jyutakugaisyu = Models.create(jyutakugaisyunaiyoList.records());
        ViewStateHolder.put(ViewStateKeys.住宅改修内容一覧_検索結果, jyutakugaisyu);
        List<dgGaisyuList_Row> dgGaisyuListRow = new ArrayList<>();
        if (!jyutakugaisyunaiyoList.records().isEmpty()) {
            for (ShokanJutakuKaishu jyutaku : jyutakugaisyunaiyoList.records()) {
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
                listRow.setTxtKaishuNaiyo(jyutaku.get住宅改修住宅内容());
                listRow.setTxtSeiriNo(jyutaku.get整理番号());
                listRow.setTxtJigyoshaNo(jyutaku.get事業者番号().value());
                listRow.setTxtRenban(jyutaku.get連番());
                listRow.setTxtMeseiNo(jyutaku.get明細番号());
                dgGaisyuListRow.add(listRow);
            }
        }
        div.getTxtKaisyunaiyo().setValue(RString.EMPTY);
        div.getTxtKaisyunaiyo().setDisabled(true);
        div.getTxtJigyosya().setValue(RString.EMPTY);
        div.getTxtJigyosya().setDisabled(true);
        div.getBtnHonnijyusyoCopy().setDisabled(true);
        div.getTxtJyusyo().clearDomain();
        div.getTxtJyusyo().setDisabled(true);
        div.getTxtTyakkoyotebi().clearValue();
        div.getTxtTyakkoyotebi().setDisabled(true);
        div.getTxtKanseyotebi().clearValue();
        div.getTxtKanseyotebi().setDisabled(true);
        div.getTxtKaisyukingaku().clearValue();
        div.getTxtKaisyukingaku().setDisabled(true);
        div.getBtnClear().setDisabled(true);
        div.getBtnDetailConfirm().setDisabled(true);
        this.get状態(状態, dgGaisyuListRow);
    }

    /**
     * 住宅改修内容一覧を取得する。
     *
     * @return List<dgGaisyuList_Row>
     */
    public List<dgGaisyuList_Row> get住宅改修内容一覧() {
        return div.getDgGaisyuList().getDataSource();
    }

    private void get状態(RString 状態, List<dgGaisyuList_Row> dgGaisyuListRow) {
        div.getDgGaisyuList().setDataSource(dgGaisyuListRow);
        if (状態_登録.equals(状態)) {
            div.setMode_State(JyutakugaisyunaiyoListDiv.State.touroku);
            div.getBtnDetailAdd().setVisible(true);
            div.getBtnHonnijyusyoCopy().setDisabled(true);
            div.getBtnClear().setDisabled(true);
            div.getBtnDetailConfirm().setDisabled(true);
            div.getDgGaisyuList().getGridSetting().setIsShowModifyButtonColumn(true);
            div.getDgGaisyuList().getGridSetting().setIsShowDeleteButtonColumn(true);
            div.getDgGaisyuList().getGridSetting().setIsShowSelectButtonColumn(false);
        } else if (状態_参照.equals(状態)) {
            div.setMode_State(JyutakugaisyunaiyoListDiv.State.sansyo);
            div.getBtnDetailAdd().setVisible(false);
            div.getDgGaisyuList().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getDgGaisyuList().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getDgGaisyuList().getGridSetting().setIsShowSelectButtonColumn(true);
        }
    }
}
