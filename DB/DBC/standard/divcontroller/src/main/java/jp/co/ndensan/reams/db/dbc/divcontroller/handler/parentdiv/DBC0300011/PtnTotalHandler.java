/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0300011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.definition.core.keiyakushurui.JuryoIninKeiyakuShurui;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300011.PtnTotalDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300011.dgKeiyakuJigyosya_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * 受領委任契約事業者登録・追加・修正・照会_検索のHandlerクラス
 *
 * @reamsid_L DBC-2120-010 panhe
 */
public final class PtnTotalHandler {

    private final PtnTotalDiv div;
    private static final RString 参照 = new RString("参照");
    private static final RString KEY_1 = new RString("1");

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
     *
     * @param 初期フラグ 初期フラグ
     * @param 状態 状態
     * @param 最大取得件数 最大取得件数
     */
    public void set初期化状態(boolean 初期フラグ, RString 状態, Decimal 最大取得件数) {
        if (参照.equals(状態)) {
            div.getPnlData().getDgKeiyakuJigyosya().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getPnlData().getDgKeiyakuJigyosya().getGridSetting().setIsShowDeleteButtonColumn(false);
        }
        if (初期フラグ) {
            div.getPnlCondition().getRdoBango().setSelectedKey(KEY_1);
        }
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
        div.getPnlCondition().getDdlKeiyakuSyurui().setDataSource(keiyakuSyuruList);
        div.getPnlCondition().getDdlKeiyakuSyurui().setSelectedKey(RString.EMPTY);
        div.getPnlCondition().getDdlKeiyakuSyurui().setDisabled(true);

        div.getPnlCondition().getTxtYubin().clearValue();
        div.getPnlCondition().getTxtYubin().setDisabled(true);
        div.getPnlCondition().getTxtJyusyoKanji().clearValue();
        div.getPnlCondition().getTxtJyusyoKanji().setDisabled(true);
        div.getPnlCondition().getChkJyusyoKanji().setSelectedItemsByKey(new ArrayList<RString>());
        div.getPnlCondition().getChkJyusyoKanji().setDisabled(true);
        if (初期フラグ) {
            div.getPnlCondition().getTxtMaxCount().setValue(new Decimal(DbBusinessConfig.
                    get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(),
                            SubGyomuCode.DBU介護統計報告).toString()));
        } else {
            div.getPnlCondition().getTxtMaxCount().setValue(最大取得件数);
        }
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
        div.getPnlCondition().getChkMeisyoKana().setSelectedItemsByKey(new ArrayList<RString>() {
            {
                add(KEY_1);
            }
        });
        div.getPnlCondition().getChkMeisyoKana().setDisabled(false);
        div.getPnlCondition().getTxtMeisyoKanji().clearValue();
        div.getPnlCondition().getTxtMeisyoKanji().setDisabled(false);
        div.getPnlCondition().getChkMeisyoKanji().setSelectedItemsByKey(new ArrayList<RString>() {
            {
                add(KEY_1);
            }
        });
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
        div.getPnlCondition().getChkJyusyoKanji().setSelectedItemsByKey(new ArrayList<RString>() {
            {
                add(KEY_1);
            }
        });
        div.getPnlCondition().getChkJyusyoKanji().setDisabled(false);
    }

    /**
     * Gridセット
     *
     * @param count int
     * @param dataList List<JuryoininKeiyakuJigyosha>
     */
    public void setGrid(int count, List<JuryoininKeiyakuJigyosha> dataList) {
        List<dgKeiyakuJigyosya_Row> data = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            dgKeiyakuJigyosya_Row row = new dgKeiyakuJigyosya_Row();

            row.setTxtKeiyakuJigyoshaNo(dataList.get(i).get契約事業者番号());
            row.setTxtKeiyakuJigyoshaName(dataList.get(i).get契約事業者名称() == null ? null
                    : dataList.get(i).get契約事業者名称().getColumnValue());
            row.setTxtKeiyakuJigyoshaJusho(dataList.get(i).get契約事業者住所() == null ? null
                    : dataList.get(i).get契約事業者住所().getColumnValue());
            TextBoxDate 開始年月日 = new TextBoxDate();
            RDate 開始年月日RDate = RDate.canConvert(new RString(dataList.get(i).get開始年月日().toString()))
                    ? new RDate(dataList.get(i).get開始年月日().toString()) : null;
            開始年月日.setValue(開始年月日RDate);
            row.setTxtKeiyakuFromYMD(開始年月日);
            TextBoxDate 終了年月日 = new TextBoxDate();
            RDate 終了年月日RDate = RDate.canConvert(new RString(dataList.get(i).get終了年月日().toString()))
                    ? new RDate(dataList.get(i).get終了年月日().toString()) : null;
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

}
