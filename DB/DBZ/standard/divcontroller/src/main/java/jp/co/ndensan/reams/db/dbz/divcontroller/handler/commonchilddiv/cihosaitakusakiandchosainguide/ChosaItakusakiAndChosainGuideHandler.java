/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.cihosaitakusakiandchosainguide;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjoho;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjohoiDataPassModel;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuide.dgKensakuKekkaIchiran_Row;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 調査委託先＆調査員ガイドDivのHandlerクラスです。
 */
public class ChosaItakusakiAndChosainGuideHandler {

    private final ChosaItakusakiAndChosainGuideDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 事業者種類共有子Divのエンティティ
     */
    public ChosaItakusakiAndChosainGuideHandler(ChosaItakusakiAndChosainGuideDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void intialize() {
        div.getTxtMaxKensu().setValue(new Decimal(BusinessConfig.
                get(ConfigNameDBU.検索制御_最大取得件数上限, SubGyomuCode.DBU介護統計報告).toString()));
        KijuntsukiShichosonjohoiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), KijuntsukiShichosonjohoiDataPassModel.class);
        if (dataPassModel != null) {
            div.setHdnDatabaseSubGyomuCode(dataPassModel.getサブ業務コード());
        }
        div.getKensakuKekkaIchiran().setVisible(false);
    }

    /**
     * 「条件をクリアする」ボタン押下、検索条件をクリアします。
     */
    public void 検索条件クリア() {
        div.getTxtChosaItakusakiCodeFrom().clearValue();
        div.getTxtChosaItakuaskiCodeTo().clearValue();
        div.getTxtChosaItakusakiName().clearValue();
        div.getTxtChosaItakusakiKanaMeisho().clearValue();
        div.getDdlChosaItakusakiKubun().setSelectedKey(RString.EMPTY);
        div.getTxtChikuCode().clearDomain();
        div.getTxtChosainCodeFrom().clearValue();
        div.getTxtChosainCodeTo().clearValue();
        div.getTxtChosainName().clearValue();
        div.getTxtChosainKanaShimei().clearValue();
        div.getTxtMaxKensu().clearValue();
    }

    /**
     * 主治医医療機関＆主治医情報gridエリア。
     *
     * @param list 情報gridエリア内容
     */
    public void setDataGrid(List<KijuntsukiShichosonjoho> list) {
        List<dgKensakuKekkaIchiran_Row> kensakuKekkaIchiranGridList = new ArrayList<>();
        if (!list.isEmpty()) {
            div.getKensakuKekkaIchiran().setVisible(true);
            for (int i = 0; i < list.size(); i++) {
                KijuntsukiShichosonjoho business = list.get(i);
                dgKensakuKekkaIchiran_Row kensakuKekkaIchiran_Row = new dgKensakuKekkaIchiran_Row();
                kensakuKekkaIchiran_Row.getItakusakicode().setValue(nullToEmpty(business.get認定調査委託先コード()));
                kensakuKekkaIchiran_Row.setItakusakiMeisho(nullToEmpty(business.get事業者名称()));
                kensakuKekkaIchiran_Row.setItakusakiKanaMeisho(nullToEmpty(business.get事業者名称カナ()));
                kensakuKekkaIchiran_Row.setItakusakiKubun(nullToEmpty(business.get調査委託区分()));
                kensakuKekkaIchiran_Row.setItakusakiJokyo(nullToEmpty(business.is状況フラグ()
                        ? new RString("有効") : new RString("無効")));
                kensakuKekkaIchiran_Row.setChosainCode(nullToEmpty(business.get認定調査員コード()));
                kensakuKekkaIchiran_Row.setChosainShimei(nullToEmpty(business.get調査員氏名()));
                kensakuKekkaIchiran_Row.setChosainKanaShimei(nullToEmpty(business.get調査員氏名カナ()));
                kensakuKekkaIchiran_Row.setChosainHJokyo(nullToEmpty(business.is調査員状況フラグ()
                        ? new RString("有効") : new RString("無効")));
                if (!business.is状況フラグ() || !business.is調査員状況フラグ()) {
                    kensakuKekkaIchiran_Row.setRowBgColor(DataGridCellBgColor.bgColorGray);
                }
                kensakuKekkaIchiranGridList.add(kensakuKekkaIchiran_Row);
            }
            div.getDgKensakuKekkaIchiran().setDataSource(kensakuKekkaIchiranGridList);
        } else {
            div.getDgKensakuKekkaIchiran().setVisible(false);
        }
    }

    /**
     * 対象モードを設定します。
     */
    public void setModes() {
        if (!div.getTxtChosaItakusakiCodeFrom().getValue().isEmpty()
                || !div.getTxtChosaItakuaskiCodeTo().getValue().isEmpty()
                || !div.getTxtChosaItakusakiName().getValue().isEmpty()
                || !div.getTxtChosaItakusakiKanaMeisho().getValue().isEmpty()) {
            div.setMode_TaishoMode(ChosaItakusakiAndChosainGuideDiv.TaishoMode.Chosain);
        } else {
            div.setMode_TaishoMode(ChosaItakusakiAndChosainGuideDiv.TaishoMode.Itakusaki);
        }
    }

    /**
     * 選択ボタンを押下します。
     */
    public void onSelectbtn() {
        KijuntsukiShichosonjohoiDataPassModel dataPassModel = new KijuntsukiShichosonjohoiDataPassModel();
        dataPassModel.set市町村コード(div.getHokensha().getSelectedItem().get市町村コード().value());
        dataPassModel.setサブ業務コード(div.getHdnDatabaseSubGyomuCode());
        if (ChosaItakusakiAndChosainGuideDiv.TaishoMode.Itakusaki.equals(div.getMode_TaishoMode())) {
            dataPassModel.set委託先コード(div.getDgKensakuKekkaIchiran().getClickedItem().getItakusakicode().getValue());
            dataPassModel.set委託先名(div.getDgKensakuKekkaIchiran().getClickedItem().getItakusakiMeisho());
        } else {
            dataPassModel.set調査員コード(div.getDgKensakuKekkaIchiran().getClickedItem().getChosainCode());
            dataPassModel.set調査員名(div.getDgKensakuKekkaIchiran().getClickedItem().getChosainShimei());
            dataPassModel.set委託先コード(div.getDgKensakuKekkaIchiran().getClickedItem().getItakusakicode().getValue());
            dataPassModel.set委託先名(div.getDgKensakuKekkaIchiran().getClickedItem().getItakusakiMeisho());
        }
        div.setHdnDataPass(DataPassingConverter.serialize(dataPassModel));
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }
}
