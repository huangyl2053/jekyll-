/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuide;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjoho;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjohoiDataPassModel;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaItakuKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
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
     * @param div 調査委託先＆調査員ガイ共有子Divのエンティティ
     */
    public ChosaItakusakiAndChosainGuideHandler(ChosaItakusakiAndChosainGuideDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void intialize() {
        div.getTxtMaxKensu().setValue(new Decimal(BusinessConfig.
                get(ConfigNameDBU.検索制御_最大取得件数, SubGyomuCode.DBU介護統計報告).toString()));
        KijuntsukiShichosonjohoiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), KijuntsukiShichosonjohoiDataPassModel.class);
        if (dataPassModel != null) {
            div.getTxtChosaItakusakiCodeFrom().setValue(dataPassModel.get委託先コード());
            div.getTxtChosainCodeFrom().setValue(dataPassModel.get調査員コード());
        }
        List<KeyValueDataSource> ddlShoriKubun = new ArrayList<>();
        ddlShoriKubun.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (ChosaItakuKubunCode code : ChosaItakuKubunCode.values()) {
            ddlShoriKubun.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlChosaItakusakiKubun().setDataSource(ddlShoriKubun);
    }

    /**
     * 「条件をクリアする」ボタン押下、検索条件をクリアします。
     */
    public void 検索条件クリア() {
        div.getHokensha().loadHokenshaList();
        div.getTxtChosaItakusakiCodeFrom().clearValue();
        div.getTxtChosaItakuaskiCodeTo().clearValue();
        div.getTxtChosaItakusakiName().clearValue();
        div.getRadChosainJokyo().setSelectedKey(new RString("1"));
        div.getRadItakusakiJokyo().setSelectedKey(new RString("1"));
        div.getTxtChosaItakusakiKanaMeisho().clearValue();
        div.getDdlChosaItakusakiKubun().setSelectedKey(RString.EMPTY);
        div.getTxtChikuCode().clearDomain();
        div.getTxtChosainCodeFrom().clearValue();
        div.getTxtChosainCodeTo().clearValue();
        div.getTxtChosainName().clearValue();
        div.getTxtChosainKanaShimei().clearValue();
        div.getTxtMaxKensu().setValue(new Decimal(BusinessConfig.
                get(ConfigNameDBU.検索制御_最大取得件数, SubGyomuCode.DBU介護統計報告).toString()));
    }

    /**
     * 調査委託先＆調査員ガ情報gridエリア。
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
            div.getDgKensakuKekkaIchiran().setDataSource(kensakuKekkaIchiranGridList);
        }
    }

    /**
     * 選択ボタンを押下します。
     */
    public void onSelectbtn() {
        KijuntsukiShichosonjohoiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), KijuntsukiShichosonjohoiDataPassModel.class);
        RString 対象モード;
        if (dataPassModel != null) {
            対象モード = nullToEmpty(dataPassModel.get対象モード());
            if (RString.isNullOrEmpty(dataPassModel.get市町村コード())) {
                dataPassModel.set市町村コード(div.getHokensha().getSelectedItem().get市町村コード().value());
            }
            if (ChosaItakusakiAndChosainGuideDiv.TaishoMode.Itakusaki.toString().equals(対象モード.toString())) {
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

    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }
}
