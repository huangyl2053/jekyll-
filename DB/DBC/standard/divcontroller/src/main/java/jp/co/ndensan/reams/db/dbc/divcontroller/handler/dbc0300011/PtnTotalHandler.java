/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0300011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.definition.core.keiyakushurui.JuryoIninKeiyakuShurui;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.juryoininkeiyakujigyosha.JuryoininKeiyakuJigyoshaParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300011.PtnTotalDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300011.dgKeiyakuJigyosya_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.service.core.basic.JuryoininKeiyakuJigyoshaManager;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 受領委任契約事業者登録・追加・修正・照会_検索のHandlerクラス
 */
public final class PtnTotalHandler {

    private final PtnTotalDiv div;
    private static final RString 参照 = new RString("参照");

    /**
     * コンストラクタです。
     *
     * @param div PtnTotalDiv
     */
    private PtnTotalHandler(PtnTotalDiv div) {
        this.div = div;
    }

    /**
     * 初期化メソッド
     *
     * @param div PtnTotalDiv
     * @return PtnTotalHandler
     */
    public static PtnTotalHandler of(PtnTotalDiv div) {
        return new PtnTotalHandler(div);
    }

    /**
     * 初期化設定
     */
    public void set初期化状態() {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (参照.equals(状態)) {
            div.getPnlData().getDgKeiyakuJigyosya().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getPnlData().getDgKeiyakuJigyosya().getGridSetting().setIsShowDeleteButtonColumn(false);
        }
        div.getPnlCondition().getRdoBango().setSelectedKey(new RString("1"));
        div.getPnlCondition().getTxtJigyosyakeyakuNo().clearValue();
        div.getPnlCondition().getTxtJigyosyakeyakuNo().setDisabled(false);

        div.getPnlCondition().getTxtMeisyoKana().clearValue();
        div.getPnlCondition().getTxtMeisyoKana().setDisabled(true);
        div.getPnlCondition().getChkMeisyoKana().setSelectedItemsByKey(new ArrayList<RString>());
        div.getPnlCondition().getChkMeisyoKana().setDisabled(true);
        div.getPnlCondition().getTxtMeisyoKanji().clearValue();
        div.getPnlCondition().getTxtMeisyoKanji().setDisabled(true);
        div.getPnlCondition().getChkMeisyoKanji().setSelectedItemsByKey(new ArrayList<RString>());
        div.getPnlCondition().getChkMeisyoKanji().setDisabled(true);

        List<KeyValueDataSource> keiyakuSyuruList = new ArrayList<>();
        keiyakuSyuruList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.住宅改修.getコード(), JuryoIninKeiyakuShurui.住宅改修.get名称()));
        keiyakuSyuruList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.福祉用具.getコード(), JuryoIninKeiyakuShurui.福祉用具.get名称()));
        keiyakuSyuruList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.住宅改修_福祉用具.getコード(), JuryoIninKeiyakuShurui.住宅改修_福祉用具.get名称()));
        keiyakuSyuruList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.償還払給付.getコード(), JuryoIninKeiyakuShurui.償還払給付.get名称()));
        keiyakuSyuruList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.高額給付費.getコード(), JuryoIninKeiyakuShurui.高額給付費.get名称()));
        div.getPnlCondition().getDdlKeiyakuSyurui().setDataSource(keiyakuSyuruList);
        div.getPnlCondition().getDdlKeiyakuSyurui().setSelectedKey(RString.EMPTY);
        div.getPnlCondition().getDdlKeiyakuSyurui().setDisabled(true);

        div.getPnlCondition().getTxtYubin().clearValue();
        div.getPnlCondition().getTxtYubin().setDisabled(true);
        div.getPnlCondition().getTxtJyusyoKanji().clearValue();
        div.getPnlCondition().getTxtJyusyoKanji().setDisabled(true);
        div.getPnlCondition().getChkJyusyoKanji().setSelectedItemsByKey(new ArrayList<RString>());
        div.getPnlCondition().getChkJyusyoKanji().setDisabled(true);
        div.getPnlCondition().getTxtMaxCount().setValue(new Decimal(DbBusinessConifg.
                get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(),
                        SubGyomuCode.DBU介護統計報告).toString()));
        div.getPnlData().setDisplayNone(true);
    }

    /**
     * 契約事業者番号クリック動作
     */
    public void click契約事業者番号() {
        div.getPnlCondition().getTxtJigyosyakeyakuNo().clearValue();
        div.getPnlCondition().getTxtJigyosyakeyakuNo().setDisabled(false);

        div.getPnlCondition().getTxtMeisyoKana().clearValue();
        div.getPnlCondition().getTxtMeisyoKana().setDisabled(true);
        div.getPnlCondition().getChkMeisyoKana().setSelectedItemsByKey(new ArrayList<RString>());
        div.getPnlCondition().getChkMeisyoKana().setDisabled(true);
        div.getPnlCondition().getTxtMeisyoKanji().clearValue();
        div.getPnlCondition().getTxtMeisyoKanji().setDisabled(true);
        div.getPnlCondition().getChkMeisyoKanji().setSelectedItemsByKey(new ArrayList<RString>());
        div.getPnlCondition().getChkMeisyoKanji().setDisabled(true);
        div.getPnlCondition().getDdlKeiyakuSyurui().setSelectedKey(RString.EMPTY);
        div.getPnlCondition().getDdlKeiyakuSyurui().setDisabled(true);

        div.getPnlCondition().getTxtYubin().clearValue();
        div.getPnlCondition().getTxtYubin().setDisabled(true);
        div.getPnlCondition().getTxtJyusyoKanji().clearValue();
        div.getPnlCondition().getTxtJyusyoKanji().setDisabled(true);
        div.getPnlCondition().getChkJyusyoKanji().setSelectedItemsByKey(new ArrayList<RString>());
        div.getPnlCondition().getChkJyusyoKanji().setDisabled(true);
    }

    /**
     * 契約事業者名称クリック動作
     */
    public void click契約事業者名称() {
        div.getPnlCondition().getTxtJigyosyakeyakuNo().clearValue();
        div.getPnlCondition().getTxtJigyosyakeyakuNo().setDisabled(true);

        div.getPnlCondition().getTxtMeisyoKana().clearValue();
        div.getPnlCondition().getTxtMeisyoKana().setDisabled(false);
        div.getPnlCondition().getChkMeisyoKana().setSelectedItemsByKey(new ArrayList<RString>());
        div.getPnlCondition().getChkMeisyoKana().setDisabled(false);
        div.getPnlCondition().getTxtMeisyoKanji().clearValue();
        div.getPnlCondition().getTxtMeisyoKanji().setDisabled(false);
        div.getPnlCondition().getChkMeisyoKanji().setSelectedItemsByKey(new ArrayList<RString>());
        div.getPnlCondition().getChkMeisyoKanji().setDisabled(false);
        div.getPnlCondition().getDdlKeiyakuSyurui().setSelectedKey(RString.EMPTY);
        div.getPnlCondition().getDdlKeiyakuSyurui().setDisabled(false);

        div.getPnlCondition().getTxtYubin().clearValue();
        div.getPnlCondition().getTxtYubin().setDisabled(true);
        div.getPnlCondition().getTxtJyusyoKanji().clearValue();
        div.getPnlCondition().getTxtJyusyoKanji().setDisabled(true);
        div.getPnlCondition().getChkJyusyoKanji().setSelectedItemsByKey(new ArrayList<RString>());
        div.getPnlCondition().getChkJyusyoKanji().setDisabled(true);
    }

    /**
     * 契約事業者住所クリック動作
     */
    public void click契約事業者住所() {
        div.getPnlCondition().getTxtJigyosyakeyakuNo().clearValue();
        div.getPnlCondition().getTxtJigyosyakeyakuNo().setDisabled(true);

        div.getPnlCondition().getTxtMeisyoKana().clearValue();
        div.getPnlCondition().getTxtMeisyoKana().setDisabled(true);
        div.getPnlCondition().getChkMeisyoKana().setSelectedItemsByKey(new ArrayList<RString>());
        div.getPnlCondition().getChkMeisyoKana().setDisabled(true);
        div.getPnlCondition().getTxtMeisyoKanji().clearValue();
        div.getPnlCondition().getTxtMeisyoKanji().setDisabled(true);
        div.getPnlCondition().getChkMeisyoKanji().setSelectedItemsByKey(new ArrayList<RString>());
        div.getPnlCondition().getChkMeisyoKanji().setDisabled(true);
        div.getPnlCondition().getDdlKeiyakuSyurui().setSelectedKey(RString.EMPTY);
        div.getPnlCondition().getDdlKeiyakuSyurui().setDisabled(true);

        div.getPnlCondition().getTxtYubin().clearValue();
        div.getPnlCondition().getTxtYubin().setDisabled(false);
        div.getPnlCondition().getTxtJyusyoKanji().clearValue();
        div.getPnlCondition().getTxtJyusyoKanji().setDisabled(false);
        div.getPnlCondition().getChkJyusyoKanji().setSelectedItemsByKey(new ArrayList<RString>());
        div.getPnlCondition().getChkJyusyoKanji().setDisabled(false);
    }

    /**
     * 検索ボタンの動作
     */
    public void click検索() {
        div.getPnlCondition().setDisplayNone(true);
        div.getPnlData().setDisplayNone(false);
        div.getPnlData().getBtnSearchAgain().setDisabled(false);

        boolean selectedBango = false;
        boolean selectedName = false;
        boolean selectedJusho = false;
        RString keiyakuJigyoshaNo = null;
        AtenaKanaMeisho keiyakuJigyoshaKanaName = null;
        boolean sameKanaName = false;
        AtenaMeisho keiyakuJigyoshaName = null;
        boolean sameJigyoshaName = false;
        RString keiyakuShurui = null;
        YubinNo keiyakuJigyoshaYubinNo = null;
        AtenaJusho keiyakuJigyoshaJusho = null;
        boolean sameJusho = false;

        if (new RString("1").equals(div.getPnlCondition().getRdoBango().getSelectedKey())) {
            selectedBango = true;
            keiyakuJigyoshaNo = new RString(div.getPnlCondition().getTxtJigyosyakeyakuNo().getValue().toString());
        } else if (new RString("2").equals(div.getPnlCondition().getRdoMeisyo().getSelectedKey())) {
            selectedName = true;
            if (!div.getPnlCondition().getTxtMeisyoKana().getValue().isNullOrEmpty()) {
                keiyakuJigyoshaKanaName = new AtenaKanaMeisho(div.getPnlCondition().getTxtMeisyoKana().getValue());
            }
            if (div.getPnlCondition().getChkMeisyoKana().isAllSelected()) {
                sameKanaName = true;
            }
            if (!div.getPnlCondition().getTxtMeisyoKanji().getValue().isNullOrEmpty()) {
                keiyakuJigyoshaName = new AtenaMeisho(div.getPnlCondition().getTxtMeisyoKanji().getValue());
            }
            if (div.getPnlCondition().getChkMeisyoKanji().isAllSelected()) {
                sameJigyoshaName = true;
            }
            if (!RString.EMPTY.equals(div.getPnlCondition().getDdlKeiyakuSyurui().getSelectedKey())) {
                keiyakuShurui = div.getPnlCondition().getDdlKeiyakuSyurui().getSelectedKey();
            }
        } else if (new RString("3").equals(div.getPnlCondition().getRdoJyusyo().getSelectedKey())) {
            selectedJusho = true;
            if (!div.getPnlCondition().getTxtYubin().getValue().isEmpty()) {
                keiyakuJigyoshaYubinNo = div.getPnlCondition().getTxtYubin().getValue();
            }
            if (!div.getPnlCondition().getTxtJyusyoKanji().getValue().isNullOrEmpty()) {
                keiyakuJigyoshaJusho = new AtenaJusho(div.getPnlCondition().getTxtJyusyoKanji().getValue());
            }
            if (div.getPnlCondition().getChkJyusyoKanji().isAllSelected()) {
                sameJusho = true;
            }
        }

        JuryoininKeiyakuJigyoshaParameter parameter = JuryoininKeiyakuJigyoshaParameter.createMybatisParam(
                selectedBango,
                selectedName,
                selectedJusho,
                keiyakuJigyoshaNo,
                keiyakuJigyoshaKanaName,
                sameKanaName,
                keiyakuJigyoshaName,
                sameJigyoshaName,
                keiyakuShurui,
                keiyakuJigyoshaYubinNo,
                keiyakuJigyoshaJusho,
                sameJusho);
        List<JuryoininKeiyakuJigyosha> dataList = JuryoininKeiyakuJigyoshaManager.createInstance()
                .getJuryoininKeiyakuJigyoshaList(parameter);
        List<dgKeiyakuJigyosya_Row> data = new ArrayList<>();
        if (dataList == null || dataList.isEmpty()) {
            div.getPnlData().getDgKeiyakuJigyosya().setDataSource(data);
            return;
        }
        int count = 0;
        int limit = div.getPnlCondition().getTxtMaxCount().getValue().intValue();
        if (dataList.size() > limit) {
            count = limit;
        } else {
            count = dataList.size();
        }
        ViewStateHolder.put(ViewStateKeys.受領委任契約事業者一覧データ, (ArrayList<JuryoininKeiyakuJigyosha>) dataList);

        for (int i = 0; i < count; i++) {
            dgKeiyakuJigyosya_Row row = new dgKeiyakuJigyosya_Row();

            row.setTxtKeiyakuJigyoshaNo(dataList.get(i).get契約事業者番号());
            row.setTxtKeiyakuJigyoshaName(dataList.get(i).get契約事業者名称().value());
            row.setTxtKeiyakuJigyoshaJusho(dataList.get(i).get契約事業者住所().value());
            TextBoxDate 開始年月日 = new TextBoxDate();
            RDate 開始年月日RDate = new RDate(dataList.get(i).get開始年月日().toString());
            開始年月日.setValue(開始年月日RDate);
            row.setTxtKeiyakuFromYMD(開始年月日);
            TextBoxDate 終了年月日 = new TextBoxDate();
            RDate 終了年月日RDate = new RDate(dataList.get(i).get終了年月日().toString());
            終了年月日.setValue(終了年月日RDate);
            row.setTxtKeiyakuToYMD(終了年月日);
            row.setTxtKeiyakuShurui(JuryoIninKeiyakuShurui.toValue(dataList.get(i).get契約種類()).get名称());
            data.add(row);
        }
        div.getPnlData().getDgKeiyakuJigyosya().setDataSource(data);
    }

    /**
     * 再検索ボタンの動作
     */
    public void click再検索() {
        div.getPnlCondition().setDisplayNone(false);
        div.getPnlData().setDisplayNone(true);
        div.getPnlData().getDgKeiyakuJigyosya().setDataSource(null);
        div.getPnlData().getBtnSearchAgain().setDisabled(true);
    }

    /**
     * 引継ぎデータの設定
     */
    public void setSelectedRow() {
        ArrayList<JuryoininKeiyakuJigyosha> allData
                = ViewStateHolder.get(ViewStateKeys.受領委任契約事業者一覧データ, ArrayList.class);
        for (JuryoininKeiyakuJigyosha tmp : allData) {
            if (tmp.get契約事業者番号().equals(
                    div.getPnlData().getDgKeiyakuJigyosya().getSelectedItems().get(0).getTxtKeiyakuJigyoshaNo())) {
                ViewStateHolder.put(ViewStateKeys.受領委任契約事業者詳細データ, tmp);
            }
        }
    }
}
