/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020071;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020071.HoseiHakkoYoshiki2KensuEtcTotalPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業報告（月報）補正発行_様式２件数、単位数補正、費用額、給付費補正のクラス
 *
 * @reamsid_L DBU-1100-090 lijunjun
 */
public class HoseiHakkoYoshiki2KensuEtcTotalPanelKyuufugakuDataHandler {

    private static final Decimal 横番号_1 = new Decimal("1");
    private static final Decimal 横番号_2 = new Decimal("2");
    private static final Decimal 横番号_3 = new Decimal("3");
    private static final Decimal 横番号_4 = new Decimal("4");
    private static final Decimal 横番号_5 = new Decimal("5");
    private static final Decimal 横番号_6 = new Decimal("6");
    private static final Decimal 横番号_7 = new Decimal("7");
    private static final Decimal 横番号_8 = new Decimal("8");
    private static final Decimal 横番号_9 = new Decimal("9");
    private static final Decimal 横番号_10 = new Decimal("10");
    private static final Decimal 横番号_11 = new Decimal("11");
    private static final Decimal 横番号_12 = new Decimal("12");
    private static final Decimal 縦番号_1 = new Decimal("1");
    private static final Decimal 縦番号_2 = new Decimal("2");
    private static final Decimal 縦番号_3 = new Decimal("3");
    private static final Decimal 縦番号_4 = new Decimal("4");
    private static final Decimal 縦番号_5 = new Decimal("5");
    private static final Decimal 縦番号_6 = new Decimal("6");
    private static final Decimal 縦番号_7 = new Decimal("7");
    private static final Decimal 縦番号_8 = new Decimal("8");
    private static final Decimal 縦番号_9 = new Decimal("9");
    private static final Decimal 縦番号_10 = new Decimal("10");
    private static final Decimal 縦番号_11 = new Decimal("11");
    private static final Decimal 縦番号_12 = new Decimal("12");
    private static final Decimal 縦番号_13 = new Decimal("13");
    private static final Decimal 縦番号_14 = new Decimal("14");
    private static final Decimal 縦番号_15 = new Decimal("15");
    private static final Decimal 縦番号_16 = new Decimal("16");
    private static final Decimal 縦番号_17 = new Decimal("17");
    private static final Decimal 縦番号_18 = new Decimal("18");
    private static final Decimal 縦番号_19 = new Decimal("19");
    private static final Decimal 縦番号_20 = new Decimal("20");
    private static final Decimal 縦番号_21 = new Decimal("21");
    private static final Decimal 縦番号_22 = new Decimal("22");
    private static final Decimal 縦番号_23 = new Decimal("23");
    private static final Decimal 縦番号_24 = new Decimal("24");
    private static final Decimal 縦番号_25 = new Decimal("25");
    private static final Decimal 縦番号_26 = new Decimal("26");
    private static final Decimal 縦番号_27 = new Decimal("27");
    private static final Decimal 縦番号_28 = new Decimal("28");
    private static final Decimal 縦番号_29 = new Decimal("29");
    private static final Decimal 縦番号_30 = new Decimal("30");
    private static final Decimal 縦番号_31 = new Decimal("31");
    private static final Decimal 縦番号_32 = new Decimal("32");
    private static final Decimal 縦番号_33 = new Decimal("33");
    private static final Decimal 縦番号_34 = new Decimal("34");
    private static final Decimal 縦番号_35 = new Decimal("35");
    private static final Decimal 縦番号_36 = new Decimal("36");
    private static final Decimal 縦番号_37 = new Decimal("37");
    private static final Decimal 縦番号_38 = new Decimal("38");
    private static final RString 給付額総数 = new RString("01");
    private static final RString 給付額第２号被保険者分再掲 = new RString("02");
    private static final RString 給付額総数特例分 = new RString("03");
    private static final RString 給付額第２号被保険者分再掲特例分 = new RString("04");
    private static final RString 更新 = new RString("更新");
    private static final RString 削除 = new RString("削除");

    private final HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HoseiHakkoYoshiki2KensuEtcTotalPanelDiv
     */
    public HoseiHakkoYoshiki2KensuEtcTotalPanelKyuufugakuDataHandler(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        this.div = div;
    }

    /**
     * 削除状態に非活性化設定
     */
    public void 非活性化設定() {
        div.setDisabled(true);
    }

    /**
     * 予防給付チェック前設定
     */
    public void 予防給付チェック前設定() {
        div.getPnlMain().set予防給付(RString.EMPTY);
    }

    /**
     * 予防給付チェック後設定
     */
    public void 予防給付チェック後設定() {
        div.getPnlMain().set予防給付(RString.HALF_SPACE);
    }

    /**
     * 介護給付チェック前設定
     */
    public void 介護給付チェック前設定() {
        div.getPnlMain().set介護給付(RString.EMPTY);
    }

    /**
     * 介護給付チェック後設定
     */
    public void 介護給付チェック後設定() {
        div.getPnlMain().set介護給付(RString.HALF_SPACE);
    }

    /**
     * 合計チェック前設定
     */
    public void 合計チェック前設定() {
        div.getPnlMain().set合計(RString.EMPTY);
    }

    /**
     * 合計チェック後設定
     */
    public void 合計チェック後設定() {
        div.getPnlMain().set合計(RString.HALF_SPACE);
    }

    /**
     * 予防給付判空
     *
     * @return 予防給付判空の結果
     */
    public boolean 予防給付判空() {
        return div.getPnlMain().get予防給付().isNullOrEmpty();
    }

    /**
     * 介護給付判空
     *
     * @return 介護給付判空の結果
     */
    public boolean 介護給付判空() {
        return div.getPnlMain().get介護給付().isNullOrEmpty();
    }

    /**
     * 合計判空
     *
     * @return 合計判空の結果
     */
    public boolean 合計判空() {
        return div.getPnlMain().get合計().isNullOrEmpty();
    }

    /**
     * 正常終了に画面表示
     */
    public void 更新正常終了() {
        div.getPnlKanryo().getCcdKanryoMessage().setSuccessMessage(new RString(
                UrInformationMessages.正常終了.getMessage().replace(更新.toString()).evaluate()));
    }

    /**
     * 正常終了に画面表示
     */
    public void 削除正常終了() {
        div.getPnlKanryo().getCcdKanryoMessage().setSuccessMessage(new RString(
                UrInformationMessages.正常終了.getMessage().replace(削除.toString()).evaluate()));
    }

    /**
     * 修正データリストを取得のメソッドます。
     *
     * @param 給付額引き継ぎデータ List<JigyoHokokuTokeiData>
     * @param 事業報告基本データ JigyoHokokuGeppoParameter
     * @return List<JigyoHokokuTokeiData>
     */
    public List<JigyoHokokuTokeiData> get給付額修正データリスト(List<JigyoHokokuTokeiData> 給付額引き継ぎデータ,
            JigyoHokokuGeppoParameter 事業報告基本データ) {

        List<JigyoHokokuTokeiData> 修正データリスト = new ArrayList<>();
        List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト = new ArrayList<>();
        if (事業報告基本データ.get行集計番号().startsWith(給付額総数)) {
            事業報告月報詳細データリスト = 給付額引き継ぎデータ;
        } else if (事業報告基本データ.get行集計番号().startsWith(給付額第２号被保険者分再掲)) {
            事業報告月報詳細データリスト = 給付額引き継ぎデータ;
        } else if (事業報告基本データ.get行集計番号().startsWith(給付額総数特例分)) {
            事業報告月報詳細データリスト = 給付額引き継ぎデータ;
        } else if (事業報告基本データ.get行集計番号().startsWith(給付額第２号被保険者分再掲特例分)) {
            事業報告月報詳細データリスト = 給付額引き継ぎデータ;
        }
        修正データリスト = get事業報告給付額修正データリスト(事業報告月報詳細データリスト, 修正データリスト);
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> get事業報告給付額修正データリスト(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {

        修正データリスト = editor給付額修正データリスト1(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor給付額修正データリスト2(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor給付額修正データリスト3(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor給付額修正データリスト4(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor給付額修正データリスト5(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor給付額修正データリスト6(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor給付額修正データリスト7(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor給付額修正データリスト8(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor給付額修正データリスト9(事業報告月報詳細データリスト, 修正データリスト);
        修正データリスト = editor給付額修正データリスト10(事業報告月報詳細データリスト, 修正データリスト);

        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor給付額修正データリスト1(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {

        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_15,
                div.getPnlMain().getTbl4().getTextBox1206().getValue(),
                div.getPnlMain().getTbl4().getTextBox1207().getValue(),
                div.getPnlMain().getTbl4().getTextBox1208().getValue(),
                div.getPnlMain().getTbl4().getTextBox1209().getValue(),
                div.getPnlMain().getTbl4().getTextBox1210().getValue(),
                div.getPnlMain().getTbl4().getTextBox1211().getValue(),
                div.getPnlMain().getTbl4().getTextBox1212().getValue(),
                div.getPnlMain().getTbl4().getTextBox1213().getValue(),
                div.getPnlMain().getTbl4().getTextBox1214().getValue(),
                div.getPnlMain().getTbl4().getTextBox1215().getValue(),
                div.getPnlMain().getTbl4().getTextBox1216().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_1,
                div.getPnlMain().getTbl4().getTextBox1217().getValue(),
                div.getPnlMain().getTbl4().getTextBox1218().getValue(),
                div.getPnlMain().getTbl4().getTextBox1219().getValue(),
                div.getPnlMain().getTbl4().getTextBox1220().getValue(),
                div.getPnlMain().getTbl4().getTextBox1221().getValue(),
                div.getPnlMain().getTbl4().getTextBox1222().getValue(),
                div.getPnlMain().getTbl4().getTextBox1223().getValue(),
                div.getPnlMain().getTbl4().getTextBox1224().getValue(),
                div.getPnlMain().getTbl4().getTextBox1225().getValue(),
                div.getPnlMain().getTbl4().getTextBox1226().getValue(),
                div.getPnlMain().getTbl4().getTextBox1227().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_16,
                div.getPnlMain().getTbl4().getTextBox1228().getValue(),
                div.getPnlMain().getTbl4().getTextBox1229().getValue(),
                div.getPnlMain().getTbl4().getTextBox1230().getValue(),
                div.getPnlMain().getTbl4().getTextBox1231().getValue(),
                div.getPnlMain().getTbl4().getTextBox1232().getValue(),
                div.getPnlMain().getTbl4().getTextBox1233().getValue(),
                div.getPnlMain().getTbl4().getTextBox1234().getValue(),
                div.getPnlMain().getTbl4().getTextBox1235().getValue(),
                div.getPnlMain().getTbl4().getTextBox1236().getValue(),
                div.getPnlMain().getTbl4().getTextBox1237().getValue(),
                div.getPnlMain().getTbl4().getTextBox1238().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_17,
                div.getPnlMain().getTbl4().getTextBox1239().getValue(),
                div.getPnlMain().getTbl4().getTextBox1240().getValue(),
                div.getPnlMain().getTbl4().getTextBox1241().getValue(),
                div.getPnlMain().getTbl4().getTextBox1242().getValue(),
                div.getPnlMain().getTbl4().getTextBox1243().getValue(),
                div.getPnlMain().getTbl4().getTextBox1244().getValue(),
                div.getPnlMain().getTbl4().getTextBox1245().getValue(),
                div.getPnlMain().getTbl4().getTextBox1246().getValue(),
                div.getPnlMain().getTbl4().getTextBox1247().getValue(),
                div.getPnlMain().getTbl4().getTextBox1248().getValue(),
                div.getPnlMain().getTbl4().getTextBox1249().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor給付額修正データリスト2(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_18,
                div.getPnlMain().getTbl4().getTextBox1250().getValue(),
                div.getPnlMain().getTbl4().getTextBox1251().getValue(),
                div.getPnlMain().getTbl4().getTextBox1252().getValue(),
                div.getPnlMain().getTbl4().getTextBox1253().getValue(),
                div.getPnlMain().getTbl4().getTextBox1254().getValue(),
                div.getPnlMain().getTbl4().getTextBox1255().getValue(),
                div.getPnlMain().getTbl4().getTextBox1256().getValue(),
                div.getPnlMain().getTbl4().getTextBox1257().getValue(),
                div.getPnlMain().getTbl4().getTextBox1258().getValue(),
                div.getPnlMain().getTbl4().getTextBox1259().getValue(),
                div.getPnlMain().getTbl4().getTextBox1260().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_19,
                div.getPnlMain().getTbl4().getTextBox1261().getValue(),
                div.getPnlMain().getTbl4().getTextBox1262().getValue(),
                div.getPnlMain().getTbl4().getTextBox1263().getValue(),
                div.getPnlMain().getTbl4().getTextBox1264().getValue(),
                div.getPnlMain().getTbl4().getTextBox1265().getValue(),
                div.getPnlMain().getTbl4().getTextBox1266().getValue(),
                div.getPnlMain().getTbl4().getTextBox1267().getValue(),
                div.getPnlMain().getTbl4().getTextBox1268().getValue(),
                div.getPnlMain().getTbl4().getTextBox1269().getValue(),
                div.getPnlMain().getTbl4().getTextBox1270().getValue(),
                div.getPnlMain().getTbl4().getTextBox1271().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_26,
                div.getPnlMain().getTbl4().getTextBox1272().getValue(),
                div.getPnlMain().getTbl4().getTextBox1273().getValue(),
                div.getPnlMain().getTbl4().getTextBox1274().getValue(),
                div.getPnlMain().getTbl4().getTextBox1275().getValue(),
                div.getPnlMain().getTbl4().getTextBox1276().getValue(),
                div.getPnlMain().getTbl4().getTextBox1277().getValue(),
                div.getPnlMain().getTbl4().getTextBox1278().getValue(),
                div.getPnlMain().getTbl4().getTextBox1279().getValue(),
                div.getPnlMain().getTbl4().getTextBox1280().getValue(),
                div.getPnlMain().getTbl4().getTextBox1281().getValue(),
                div.getPnlMain().getTbl4().getTextBox1282().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_30,
                div.getPnlMain().getTbl4().getTextBox1283().getValue(),
                div.getPnlMain().getTbl4().getTextBox1284().getValue(),
                div.getPnlMain().getTbl4().getTextBox1285().getValue(),
                div.getPnlMain().getTbl4().getTextBox1286().getValue(),
                div.getPnlMain().getTbl4().getTextBox1287().getValue(),
                div.getPnlMain().getTbl4().getTextBox1288().getValue(),
                div.getPnlMain().getTbl4().getTextBox1289().getValue(),
                div.getPnlMain().getTbl4().getTextBox1290().getValue(),
                div.getPnlMain().getTbl4().getTextBox1291().getValue(),
                div.getPnlMain().getTbl4().getTextBox1292().getValue(),
                div.getPnlMain().getTbl4().getTextBox1293().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor給付額修正データリスト3(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_20,
                div.getPnlMain().getTbl4().getTextBox1294().getValue(),
                div.getPnlMain().getTbl4().getTextBox1295().getValue(),
                div.getPnlMain().getTbl4().getTextBox1296().getValue(),
                div.getPnlMain().getTbl4().getTextBox1297().getValue(),
                div.getPnlMain().getTbl4().getTextBox1298().getValue(),
                div.getPnlMain().getTbl4().getTextBox1299().getValue(),
                div.getPnlMain().getTbl4().getTextBox1300().getValue(),
                div.getPnlMain().getTbl4().getTextBox1301().getValue(),
                div.getPnlMain().getTbl4().getTextBox1302().getValue(),
                div.getPnlMain().getTbl4().getTextBox1303().getValue(),
                div.getPnlMain().getTbl4().getTextBox1304().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_21,
                div.getPnlMain().getTbl4().getTextBox1305().getValue(),
                div.getPnlMain().getTbl4().getTextBox1306().getValue(),
                div.getPnlMain().getTbl4().getTextBox1307().getValue(),
                div.getPnlMain().getTbl4().getTextBox1308().getValue(),
                div.getPnlMain().getTbl4().getTextBox1309().getValue(),
                div.getPnlMain().getTbl4().getTextBox1310().getValue(),
                div.getPnlMain().getTbl4().getTextBox1311().getValue(),
                div.getPnlMain().getTbl4().getTextBox1312().getValue(),
                div.getPnlMain().getTbl4().getTextBox1313().getValue(),
                div.getPnlMain().getTbl4().getTextBox1314().getValue(),
                div.getPnlMain().getTbl4().getTextBox1315().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_2,
                div.getPnlMain().getTbl4().getTextBox1316().getValue(),
                div.getPnlMain().getTbl4().getTextBox1317().getValue(),
                div.getPnlMain().getTbl4().getTextBox1318().getValue(),
                div.getPnlMain().getTbl4().getTextBox1319().getValue(),
                div.getPnlMain().getTbl4().getTextBox1320().getValue(),
                div.getPnlMain().getTbl4().getTextBox1321().getValue(),
                div.getPnlMain().getTbl4().getTextBox1322().getValue(),
                div.getPnlMain().getTbl4().getTextBox1323().getValue(),
                div.getPnlMain().getTbl4().getTextBox1324().getValue(),
                div.getPnlMain().getTbl4().getTextBox1325().getValue(),
                div.getPnlMain().getTbl4().getTextBox1326().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_23,
                div.getPnlMain().getTbl4().getTextBox1327().getValue(),
                div.getPnlMain().getTbl4().getTextBox1328().getValue(),
                div.getPnlMain().getTbl4().getTextBox1329().getValue(),
                div.getPnlMain().getTbl4().getTextBox1330().getValue(),
                div.getPnlMain().getTbl4().getTextBox1331().getValue(),
                div.getPnlMain().getTbl4().getTextBox1332().getValue(),
                div.getPnlMain().getTbl4().getTextBox1333().getValue(),
                div.getPnlMain().getTbl4().getTextBox1334().getValue(),
                div.getPnlMain().getTbl4().getTextBox1335().getValue(),
                div.getPnlMain().getTbl4().getTextBox1336().getValue(),
                div.getPnlMain().getTbl4().getTextBox1337().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor給付額修正データリスト4(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_24,
                div.getPnlMain().getTbl4().getTextBox1338().getValue(),
                div.getPnlMain().getTbl4().getTextBox1339().getValue(),
                div.getPnlMain().getTbl4().getTextBox1340().getValue(),
                div.getPnlMain().getTbl4().getTextBox1341().getValue(),
                div.getPnlMain().getTbl4().getTextBox1342().getValue(),
                div.getPnlMain().getTbl4().getTextBox1343().getValue(),
                div.getPnlMain().getTbl4().getTextBox1344().getValue(),
                div.getPnlMain().getTbl4().getTextBox1345().getValue(),
                div.getPnlMain().getTbl4().getTextBox1346().getValue(),
                div.getPnlMain().getTbl4().getTextBox1347().getValue(),
                div.getPnlMain().getTbl4().getTextBox1348().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_25,
                div.getPnlMain().getTbl4().getTextBox1349().getValue(),
                div.getPnlMain().getTbl4().getTextBox1350().getValue(),
                div.getPnlMain().getTbl4().getTextBox1351().getValue(),
                div.getPnlMain().getTbl4().getTextBox1352().getValue(),
                div.getPnlMain().getTbl4().getTextBox1353().getValue(),
                div.getPnlMain().getTbl4().getTextBox1354().getValue(),
                div.getPnlMain().getTbl4().getTextBox1355().getValue(),
                div.getPnlMain().getTbl4().getTextBox1356().getValue(),
                div.getPnlMain().getTbl4().getTextBox1357().getValue(),
                div.getPnlMain().getTbl4().getTextBox1358().getValue(),
                div.getPnlMain().getTbl4().getTextBox1359().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_3,
                div.getPnlMain().getTbl4().getTextBox1360().getValue(),
                div.getPnlMain().getTbl4().getTextBox1361().getValue(),
                div.getPnlMain().getTbl4().getTextBox1362().getValue(),
                div.getPnlMain().getTbl4().getTextBox1363().getValue(),
                div.getPnlMain().getTbl4().getTextBox1364().getValue(),
                div.getPnlMain().getTbl4().getTextBox1365().getValue(),
                div.getPnlMain().getTbl4().getTextBox1366().getValue(),
                div.getPnlMain().getTbl4().getTextBox1367().getValue(),
                div.getPnlMain().getTbl4().getTextBox1368().getValue(),
                div.getPnlMain().getTbl4().getTextBox1369().getValue(),
                div.getPnlMain().getTbl4().getTextBox1370().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_22,
                div.getPnlMain().getTbl4().getTextBox1371().getValue(),
                div.getPnlMain().getTbl4().getTextBox1372().getValue(),
                div.getPnlMain().getTbl4().getTextBox1373().getValue(),
                div.getPnlMain().getTbl4().getTextBox1374().getValue(),
                div.getPnlMain().getTbl4().getTextBox1375().getValue(),
                div.getPnlMain().getTbl4().getTextBox1376().getValue(),
                div.getPnlMain().getTbl4().getTextBox1377().getValue(),
                div.getPnlMain().getTbl4().getTextBox1378().getValue(),
                div.getPnlMain().getTbl4().getTextBox1379().getValue(),
                div.getPnlMain().getTbl4().getTextBox1380().getValue(),
                div.getPnlMain().getTbl4().getTextBox1381().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor給付額修正データリスト5(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_4,
                div.getPnlMain().getTbl4().getTextBox1382().getValue(),
                div.getPnlMain().getTbl4().getTextBox1383().getValue(),
                div.getPnlMain().getTbl4().getTextBox1384().getValue(),
                div.getPnlMain().getTbl4().getTextBox1385().getValue(),
                div.getPnlMain().getTbl4().getTextBox1386().getValue(),
                div.getPnlMain().getTbl4().getTextBox1387().getValue(),
                div.getPnlMain().getTbl4().getTextBox1388().getValue(),
                div.getPnlMain().getTbl4().getTextBox1389().getValue(),
                div.getPnlMain().getTbl4().getTextBox1390().getValue(),
                div.getPnlMain().getTbl4().getTextBox1391().getValue(),
                div.getPnlMain().getTbl4().getTextBox1392().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_5,
                div.getPnlMain().getTbl4().getTextBox1393().getValue(),
                div.getPnlMain().getTbl4().getTextBox1394().getValue(),
                div.getPnlMain().getTbl4().getTextBox1395().getValue(),
                div.getPnlMain().getTbl4().getTextBox1396().getValue(),
                div.getPnlMain().getTbl4().getTextBox1397().getValue(),
                div.getPnlMain().getTbl4().getTextBox1398().getValue(),
                div.getPnlMain().getTbl4().getTextBox1399().getValue(),
                div.getPnlMain().getTbl4().getTextBox1400().getValue(),
                div.getPnlMain().getTbl4().getTextBox1401().getValue(),
                div.getPnlMain().getTbl4().getTextBox1402().getValue(),
                div.getPnlMain().getTbl4().getTextBox1403().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_28,
                div.getPnlMain().getTbl4().getTextBox1404().getValue(),
                div.getPnlMain().getTbl4().getTextBox1405().getValue(),
                div.getPnlMain().getTbl4().getTextBox1406().getValue(),
                div.getPnlMain().getTbl4().getTextBox1407().getValue(),
                div.getPnlMain().getTbl4().getTextBox1408().getValue(),
                div.getPnlMain().getTbl4().getTextBox1409().getValue(),
                div.getPnlMain().getTbl4().getTextBox1410().getValue(),
                div.getPnlMain().getTbl4().getTextBox1411().getValue(),
                div.getPnlMain().getTbl4().getTextBox1412().getValue(),
                div.getPnlMain().getTbl4().getTextBox1413().getValue(),
                div.getPnlMain().getTbl4().getTextBox1414().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_29,
                div.getPnlMain().getTbl4().getTextBox1415().getValue(),
                div.getPnlMain().getTbl4().getTextBox1416().getValue(),
                div.getPnlMain().getTbl4().getTextBox1417().getValue(),
                div.getPnlMain().getTbl4().getTextBox1418().getValue(),
                div.getPnlMain().getTbl4().getTextBox1419().getValue(),
                div.getPnlMain().getTbl4().getTextBox1420().getValue(),
                div.getPnlMain().getTbl4().getTextBox1421().getValue(),
                div.getPnlMain().getTbl4().getTextBox1422().getValue(),
                div.getPnlMain().getTbl4().getTextBox1423().getValue(),
                div.getPnlMain().getTbl4().getTextBox1424().getValue(),
                div.getPnlMain().getTbl4().getTextBox1425().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor給付額修正データリスト6(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_31,
                div.getPnlMain().getTbl4().getTextBox1426().getValue(),
                div.getPnlMain().getTbl4().getTextBox1427().getValue(),
                div.getPnlMain().getTbl4().getTextBox1428().getValue(),
                div.getPnlMain().getTbl4().getTextBox1429().getValue(),
                div.getPnlMain().getTbl4().getTextBox1430().getValue(),
                div.getPnlMain().getTbl4().getTextBox1431().getValue(),
                div.getPnlMain().getTbl4().getTextBox1432().getValue(),
                div.getPnlMain().getTbl4().getTextBox1433().getValue(),
                div.getPnlMain().getTbl4().getTextBox1434().getValue(),
                div.getPnlMain().getTbl4().getTextBox1435().getValue(),
                div.getPnlMain().getTbl4().getTextBox1436().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_37,
                div.getPnlMain().getTbl4().getTextBox1437().getValue(),
                div.getPnlMain().getTbl4().getTextBox1438().getValue(),
                div.getPnlMain().getTbl4().getTextBox1439().getValue(),
                div.getPnlMain().getTbl4().getTextBox1440().getValue(),
                div.getPnlMain().getTbl4().getTextBox1441().getValue(),
                div.getPnlMain().getTbl4().getTextBox1442().getValue(),
                div.getPnlMain().getTbl4().getTextBox1443().getValue(),
                div.getPnlMain().getTbl4().getTextBox1444().getValue(),
                div.getPnlMain().getTbl4().getTextBox1445().getValue(),
                div.getPnlMain().getTbl4().getTextBox1446().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_32,
                div.getPnlMain().getTbl4().getTextBox1447().getValue(),
                div.getPnlMain().getTbl4().getTextBox1448().getValue(),
                div.getPnlMain().getTbl4().getTextBox1449().getValue(),
                div.getPnlMain().getTbl4().getTextBox1450().getValue(),
                div.getPnlMain().getTbl4().getTextBox1451().getValue(),
                div.getPnlMain().getTbl4().getTextBox1452().getValue(),
                div.getPnlMain().getTbl4().getTextBox1453().getValue(),
                div.getPnlMain().getTbl4().getTextBox1454().getValue(),
                div.getPnlMain().getTbl4().getTextBox1455().getValue(),
                div.getPnlMain().getTbl4().getTextBox1456().getValue());
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_33,
                div.getPnlMain().getTbl4().getTextBox1457().getValue(),
                div.getPnlMain().getTbl4().getTextBox1458().getValue(),
                div.getPnlMain().getTbl4().getTextBox1459().getValue(),
                div.getPnlMain().getTbl4().getTextBox1460().getValue(),
                div.getPnlMain().getTbl4().getTextBox1461().getValue(),
                div.getPnlMain().getTbl4().getTextBox1462().getValue(),
                div.getPnlMain().getTbl4().getTextBox1463().getValue(),
                div.getPnlMain().getTbl4().getTextBox1464().getValue(),
                div.getPnlMain().getTbl4().getTextBox1465().getValue(),
                div.getPnlMain().getTbl4().getTextBox1466().getValue(),
                div.getPnlMain().getTbl4().getTextBox1467().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor給付額修正データリスト7(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ(事業報告月報詳細データリスト, 修正データリスト, 縦番号_34,
                div.getPnlMain().getTbl4().getTextBox1468().getValue(),
                div.getPnlMain().getTbl4().getTextBox1469().getValue(),
                div.getPnlMain().getTbl4().getTextBox1470().getValue(),
                div.getPnlMain().getTbl4().getTextBox1471().getValue(),
                div.getPnlMain().getTbl4().getTextBox1472().getValue(),
                div.getPnlMain().getTbl4().getTextBox1473().getValue(),
                div.getPnlMain().getTbl4().getTextBox1474().getValue(),
                div.getPnlMain().getTbl4().getTextBox1475().getValue(),
                div.getPnlMain().getTbl4().getTextBox1476().getValue(),
                div.getPnlMain().getTbl4().getTextBox1477().getValue(),
                div.getPnlMain().getTbl4().getTextBox1478().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_27,
                div.getPnlMain().getTbl4().getTextBox1479().getValue(),
                div.getPnlMain().getTbl4().getTextBox1480().getValue(),
                div.getPnlMain().getTbl4().getTextBox1481().getValue(),
                div.getPnlMain().getTbl4().getTextBox1482().getValue(),
                div.getPnlMain().getTbl4().getTextBox1483().getValue(),
                div.getPnlMain().getTbl4().getTextBox1484().getValue(),
                div.getPnlMain().getTbl4().getTextBox1485().getValue(),
                div.getPnlMain().getTbl4().getTextBox1486().getValue(),
                div.getPnlMain().getTbl4().getTextBox1487().getValue(),
                div.getPnlMain().getTbl4().getTextBox1488().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_35,
                div.getPnlMain().getTbl4().getTextBox1489().getValue(),
                div.getPnlMain().getTbl4().getTextBox1490().getValue(),
                div.getPnlMain().getTbl4().getTextBox1491().getValue(),
                div.getPnlMain().getTbl4().getTextBox1492().getValue(),
                div.getPnlMain().getTbl4().getTextBox1493().getValue(),
                div.getPnlMain().getTbl4().getTextBox1494().getValue(),
                div.getPnlMain().getTbl4().getTextBox1495().getValue(),
                div.getPnlMain().getTbl4().getTextBox1496().getValue(),
                div.getPnlMain().getTbl4().getTextBox1497().getValue(),
                div.getPnlMain().getTbl4().getTextBox1498().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_36,
                div.getPnlMain().getTbl4().getTextBox1499().getValue(),
                div.getPnlMain().getTbl4().getTextBox1500().getValue(),
                div.getPnlMain().getTbl4().getTextBox1501().getValue(),
                div.getPnlMain().getTbl4().getTextBox1502().getValue(),
                div.getPnlMain().getTbl4().getTextBox1503().getValue(),
                div.getPnlMain().getTbl4().getTextBox1504().getValue(),
                div.getPnlMain().getTbl4().getTextBox1505().getValue(),
                div.getPnlMain().getTbl4().getTextBox1506().getValue(),
                div.getPnlMain().getTbl4().getTextBox1507().getValue(),
                div.getPnlMain().getTbl4().getTextBox1508().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor給付額修正データリスト8(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_38,
                div.getPnlMain().getTbl4().getTextBox1509().getValue(),
                div.getPnlMain().getTbl4().getTextBox1510().getValue(),
                div.getPnlMain().getTbl4().getTextBox1511().getValue(),
                div.getPnlMain().getTbl4().getTextBox1512().getValue(),
                div.getPnlMain().getTbl4().getTextBox1513().getValue(),
                div.getPnlMain().getTbl4().getTextBox1514().getValue(),
                div.getPnlMain().getTbl4().getTextBox1515().getValue(),
                div.getPnlMain().getTbl4().getTextBox1516().getValue(),
                div.getPnlMain().getTbl4().getTextBox1517().getValue(),
                div.getPnlMain().getTbl4().getTextBox1518().getValue());
        修正データリスト = get事業報告修正データ_2(事業報告月報詳細データリスト, 修正データリスト, 縦番号_6,
                div.getPnlMain().getTbl4().getTextBox1519().getValue(),
                div.getPnlMain().getTbl4().getTextBox1520().getValue(),
                div.getPnlMain().getTbl4().getTextBox1521().getValue(),
                div.getPnlMain().getTbl4().getTextBox1522().getValue(),
                div.getPnlMain().getTbl4().getTextBox1523().getValue(),
                div.getPnlMain().getTbl4().getTextBox1524().getValue(),
                div.getPnlMain().getTbl4().getTextBox1525().getValue(),
                div.getPnlMain().getTbl4().getTextBox1526().getValue(),
                div.getPnlMain().getTbl4().getTextBox1527().getValue(),
                div.getPnlMain().getTbl4().getTextBox1528().getValue(),
                div.getPnlMain().getTbl4().getTextBox1529().getValue());
        修正データリスト = get事業報告修正データ_2(事業報告月報詳細データリスト, 修正データリスト, 縦番号_7,
                div.getPnlMain().getTbl4().getTextBox1530().getValue(),
                div.getPnlMain().getTbl4().getTextBox1531().getValue(),
                div.getPnlMain().getTbl4().getTextBox1532().getValue(),
                div.getPnlMain().getTbl4().getTextBox1533().getValue(),
                div.getPnlMain().getTbl4().getTextBox1534().getValue(),
                div.getPnlMain().getTbl4().getTextBox1535().getValue(),
                div.getPnlMain().getTbl4().getTextBox1536().getValue(),
                div.getPnlMain().getTbl4().getTextBox1537().getValue(),
                div.getPnlMain().getTbl4().getTextBox1538().getValue(),
                div.getPnlMain().getTbl4().getTextBox1539().getValue(),
                div.getPnlMain().getTbl4().getTextBox1540().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_8,
                div.getPnlMain().getTbl4().getTextBox1541().getValue(),
                div.getPnlMain().getTbl4().getTextBox1542().getValue(),
                div.getPnlMain().getTbl4().getTextBox1543().getValue(),
                div.getPnlMain().getTbl4().getTextBox1544().getValue(),
                div.getPnlMain().getTbl4().getTextBox1545().getValue(),
                div.getPnlMain().getTbl4().getTextBox1546().getValue(),
                div.getPnlMain().getTbl4().getTextBox1547().getValue(),
                div.getPnlMain().getTbl4().getTextBox1548().getValue(),
                div.getPnlMain().getTbl4().getTextBox1549().getValue(),
                div.getPnlMain().getTbl4().getTextBox1550().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor給付額修正データリスト9(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_9,
                div.getPnlMain().getTbl4().getTextBox1551().getValue(),
                div.getPnlMain().getTbl4().getTextBox1552().getValue(),
                div.getPnlMain().getTbl4().getTextBox1553().getValue(),
                div.getPnlMain().getTbl4().getTextBox1554().getValue(),
                div.getPnlMain().getTbl4().getTextBox1555().getValue(),
                div.getPnlMain().getTbl4().getTextBox1556().getValue(),
                div.getPnlMain().getTbl4().getTextBox1557().getValue(),
                div.getPnlMain().getTbl4().getTextBox1558().getValue(),
                div.getPnlMain().getTbl4().getTextBox1559().getValue(),
                div.getPnlMain().getTbl4().getTextBox1560().getValue());
        修正データリスト = get事業報告修正データ_2(事業報告月報詳細データリスト, 修正データリスト, 縦番号_10,
                div.getPnlMain().getTbl4().getTextBox1561().getValue(),
                div.getPnlMain().getTbl4().getTextBox1562().getValue(),
                div.getPnlMain().getTbl4().getTextBox1563().getValue(),
                div.getPnlMain().getTbl4().getTextBox1564().getValue(),
                div.getPnlMain().getTbl4().getTextBox1565().getValue(),
                div.getPnlMain().getTbl4().getTextBox1566().getValue(),
                div.getPnlMain().getTbl4().getTextBox1567().getValue(),
                div.getPnlMain().getTbl4().getTextBox1568().getValue(),
                div.getPnlMain().getTbl4().getTextBox1569().getValue(),
                div.getPnlMain().getTbl4().getTextBox1570().getValue(),
                div.getPnlMain().getTbl4().getTextBox1571().getValue());
        修正データリスト = get事業報告修正データ_2(事業報告月報詳細データリスト, 修正データリスト, 縦番号_11,
                div.getPnlMain().getTbl4().getTextBox1572().getValue(),
                div.getPnlMain().getTbl4().getTextBox1573().getValue(),
                div.getPnlMain().getTbl4().getTextBox1574().getValue(),
                div.getPnlMain().getTbl4().getTextBox1575().getValue(),
                div.getPnlMain().getTbl4().getTextBox1576().getValue(),
                div.getPnlMain().getTbl4().getTextBox1577().getValue(),
                div.getPnlMain().getTbl4().getTextBox1578().getValue(),
                div.getPnlMain().getTbl4().getTextBox1579().getValue(),
                div.getPnlMain().getTbl4().getTextBox1580().getValue(),
                div.getPnlMain().getTbl4().getTextBox1581().getValue(),
                div.getPnlMain().getTbl4().getTextBox1582().getValue());
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_12,
                div.getPnlMain().getTbl4().getTextBox1583().getValue(),
                div.getPnlMain().getTbl4().getTextBox1584().getValue(),
                div.getPnlMain().getTbl4().getTextBox1585().getValue(),
                div.getPnlMain().getTbl4().getTextBox1586().getValue(),
                div.getPnlMain().getTbl4().getTextBox1587().getValue(),
                div.getPnlMain().getTbl4().getTextBox1588().getValue(),
                div.getPnlMain().getTbl4().getTextBox1589().getValue(),
                div.getPnlMain().getTbl4().getTextBox1590().getValue(),
                div.getPnlMain().getTbl4().getTextBox1591().getValue(),
                div.getPnlMain().getTbl4().getTextBox1592().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> editor給付額修正データリスト10(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get事業報告修正データ_1(事業報告月報詳細データリスト, 修正データリスト, 縦番号_13,
                div.getPnlMain().getTbl4().getTextBox1593().getValue(),
                div.getPnlMain().getTbl4().getTextBox1594().getValue(),
                div.getPnlMain().getTbl4().getTextBox1595().getValue(),
                div.getPnlMain().getTbl4().getTextBox1596().getValue(),
                div.getPnlMain().getTbl4().getTextBox1597().getValue(),
                div.getPnlMain().getTbl4().getTextBox1598().getValue(),
                div.getPnlMain().getTbl4().getTextBox1599().getValue(),
                div.getPnlMain().getTbl4().getTextBox1600().getValue(),
                div.getPnlMain().getTbl4().getTextBox1601().getValue(),
                div.getPnlMain().getTbl4().getTextBox1602().getValue());
        修正データリスト = get事業報告修正データ_3(事業報告月報詳細データリスト, 修正データリスト, 縦番号_14,
                div.getPnlMain().getTbl4().getTextBox1603().getValue(),
                div.getPnlMain().getTbl4().getTextBox1604().getValue(),
                div.getPnlMain().getTbl4().getTextBox1605().getValue(),
                div.getPnlMain().getTbl4().getTextBox1606().getValue(),
                div.getPnlMain().getTbl4().getTextBox1607().getValue(),
                div.getPnlMain().getTbl4().getTextBox1608().getValue(),
                div.getPnlMain().getTbl4().getTextBox1609().getValue(),
                div.getPnlMain().getTbl4().getTextBox1610().getValue(),
                div.getPnlMain().getTbl4().getTextBox1611().getValue(),
                div.getPnlMain().getTbl4().getTextBox1612().getValue(),
                div.getPnlMain().getTbl4().getTextBox1613().getValue(),
                div.getPnlMain().getTbl4().getTextBox1614().getValue());
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> get事業報告修正データ_3(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト,
            Decimal 縦番号,
            Decimal 集計結果値1,
            Decimal 集計結果値2,
            Decimal 集計結果値3,
            Decimal 集計結果値4,
            Decimal 集計結果値5,
            Decimal 集計結果値6,
            Decimal 集計結果値7,
            Decimal 集計結果値8,
            Decimal 集計結果値9,
            Decimal 集計結果値10,
            Decimal 集計結果値11,
            Decimal 集計結果値12) {
        修正データリスト = set集計結果値(集計結果値1, 修正データリスト, 事業報告月報詳細データリスト, 横番号_1, 縦番号);
        修正データリスト = set集計結果値(集計結果値2, 修正データリスト, 事業報告月報詳細データリスト, 横番号_2, 縦番号);
        修正データリスト = set集計結果値(集計結果値3, 修正データリスト, 事業報告月報詳細データリスト, 横番号_3, 縦番号);
        修正データリスト = set集計結果値(集計結果値4, 修正データリスト, 事業報告月報詳細データリスト, 横番号_4, 縦番号);
        修正データリスト = set集計結果値(集計結果値5, 修正データリスト, 事業報告月報詳細データリスト, 横番号_5, 縦番号);
        修正データリスト = set集計結果値(集計結果値6, 修正データリスト, 事業報告月報詳細データリスト, 横番号_6, 縦番号);
        修正データリスト = set集計結果値(集計結果値7, 修正データリスト, 事業報告月報詳細データリスト, 横番号_7, 縦番号);
        修正データリスト = set集計結果値(集計結果値8, 修正データリスト, 事業報告月報詳細データリスト, 横番号_8, 縦番号);
        修正データリスト = set集計結果値(集計結果値9, 修正データリスト, 事業報告月報詳細データリスト, 横番号_9, 縦番号);
        修正データリスト = set集計結果値(集計結果値10, 修正データリスト, 事業報告月報詳細データリスト, 横番号_10, 縦番号);
        修正データリスト = set集計結果値(集計結果値11, 修正データリスト, 事業報告月報詳細データリスト, 横番号_11, 縦番号);
        修正データリスト = set集計結果値(集計結果値12, 修正データリスト, 事業報告月報詳細データリスト, 横番号_12, 縦番号);
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> get事業報告修正データ_2(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト,
            Decimal 縦番号,
            Decimal 集計結果値1,
            Decimal 集計結果値2,
            Decimal 集計結果値3,
            Decimal 集計結果値4,
            Decimal 集計結果値5,
            Decimal 集計結果値6,
            Decimal 集計結果値7,
            Decimal 集計結果値8,
            Decimal 集計結果値9,
            Decimal 集計結果値10,
            Decimal 集計結果値11) {
        修正データリスト = set集計結果値(集計結果値1, 修正データリスト, 事業報告月報詳細データリスト, 横番号_1, 縦番号);
        修正データリスト = set集計結果値(集計結果値2, 修正データリスト, 事業報告月報詳細データリスト, 横番号_3, 縦番号);
        修正データリスト = set集計結果値(集計結果値3, 修正データリスト, 事業報告月報詳細データリスト, 横番号_4, 縦番号);
        修正データリスト = set集計結果値(集計結果値4, 修正データリスト, 事業報告月報詳細データリスト, 横番号_5, 縦番号);
        修正データリスト = set集計結果値(集計結果値5, 修正データリスト, 事業報告月報詳細データリスト, 横番号_6, 縦番号);
        修正データリスト = set集計結果値(集計結果値6, 修正データリスト, 事業報告月報詳細データリスト, 横番号_7, 縦番号);
        修正データリスト = set集計結果値(集計結果値7, 修正データリスト, 事業報告月報詳細データリスト, 横番号_8, 縦番号);
        修正データリスト = set集計結果値(集計結果値8, 修正データリスト, 事業報告月報詳細データリスト, 横番号_9, 縦番号);
        修正データリスト = set集計結果値(集計結果値9, 修正データリスト, 事業報告月報詳細データリスト, 横番号_10, 縦番号);
        修正データリスト = set集計結果値(集計結果値10, 修正データリスト, 事業報告月報詳細データリスト, 横番号_11, 縦番号);
        修正データリスト = set集計結果値(集計結果値11, 修正データリスト, 事業報告月報詳細データリスト, 横番号_12, 縦番号);
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> get事業報告修正データ_1(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト,
            Decimal 縦番号,
            Decimal 集計結果値1,
            Decimal 集計結果値2,
            Decimal 集計結果値3,
            Decimal 集計結果値4,
            Decimal 集計結果値5,
            Decimal 集計結果値6,
            Decimal 集計結果値7,
            Decimal 集計結果値8,
            Decimal 集計結果値9,
            Decimal 集計結果値10) {
        修正データリスト = set集計結果値(集計結果値1, 修正データリスト, 事業報告月報詳細データリスト, 横番号_3, 縦番号);
        修正データリスト = set集計結果値(集計結果値2, 修正データリスト, 事業報告月報詳細データリスト, 横番号_4, 縦番号);
        修正データリスト = set集計結果値(集計結果値3, 修正データリスト, 事業報告月報詳細データリスト, 横番号_5, 縦番号);
        修正データリスト = set集計結果値(集計結果値4, 修正データリスト, 事業報告月報詳細データリスト, 横番号_6, 縦番号);
        修正データリスト = set集計結果値(集計結果値5, 修正データリスト, 事業報告月報詳細データリスト, 横番号_7, 縦番号);
        修正データリスト = set集計結果値(集計結果値6, 修正データリスト, 事業報告月報詳細データリスト, 横番号_8, 縦番号);
        修正データリスト = set集計結果値(集計結果値7, 修正データリスト, 事業報告月報詳細データリスト, 横番号_9, 縦番号);
        修正データリスト = set集計結果値(集計結果値8, 修正データリスト, 事業報告月報詳細データリスト, 横番号_10, 縦番号);
        修正データリスト = set集計結果値(集計結果値9, 修正データリスト, 事業報告月報詳細データリスト, 横番号_11, 縦番号);
        修正データリスト = set集計結果値(集計結果値10, 修正データリスト, 事業報告月報詳細データリスト, 横番号_12, 縦番号);
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> get事業報告修正データ(List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト,
            Decimal 縦番号,
            Decimal 集計結果値1,
            Decimal 集計結果値2,
            Decimal 集計結果値3,
            Decimal 集計結果値4,
            Decimal 集計結果値5,
            Decimal 集計結果値6,
            Decimal 集計結果値7,
            Decimal 集計結果値8,
            Decimal 集計結果値9,
            Decimal 集計結果値10,
            Decimal 集計結果値11) {
        修正データリスト = set集計結果値(集計結果値1, 修正データリスト, 事業報告月報詳細データリスト, 横番号_2, 縦番号);
        修正データリスト = set集計結果値(集計結果値2, 修正データリスト, 事業報告月報詳細データリスト, 横番号_3, 縦番号);
        修正データリスト = set集計結果値(集計結果値3, 修正データリスト, 事業報告月報詳細データリスト, 横番号_4, 縦番号);
        修正データリスト = set集計結果値(集計結果値4, 修正データリスト, 事業報告月報詳細データリスト, 横番号_5, 縦番号);
        修正データリスト = set集計結果値(集計結果値5, 修正データリスト, 事業報告月報詳細データリスト, 横番号_6, 縦番号);
        修正データリスト = set集計結果値(集計結果値6, 修正データリスト, 事業報告月報詳細データリスト, 横番号_7, 縦番号);
        修正データリスト = set集計結果値(集計結果値7, 修正データリスト, 事業報告月報詳細データリスト, 横番号_8, 縦番号);
        修正データリスト = set集計結果値(集計結果値8, 修正データリスト, 事業報告月報詳細データリスト, 横番号_9, 縦番号);
        修正データリスト = set集計結果値(集計結果値9, 修正データリスト, 事業報告月報詳細データリスト, 横番号_10, 縦番号);
        修正データリスト = set集計結果値(集計結果値10, 修正データリスト, 事業報告月報詳細データリスト, 横番号_11, 縦番号);
        修正データリスト = set集計結果値(集計結果値11, 修正データリスト, 事業報告月報詳細データリスト, 横番号_12, 縦番号);
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> set集計結果値(
            Decimal 集計結果値,
            List<JigyoHokokuTokeiData> 修正データリスト,
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            Decimal 横番号,
            Decimal 縦番号) {
        JigyoHokokuTokeiData entity = check事業報告統計データ(事業報告月報詳細データリスト, 横番号, 縦番号);
        if (集計結果値 == null) {
            if (entity != null && entity.get集計結果値() != null) {
                entity = entity.createBuilderForEdit().set集計結果値(null).build();
                entity = entity.modifiedModel();
                修正データリスト.add(entity);
                return 修正データリスト;
            }
        } else {
            if (entity == null) {
                entity = set事業報告統計データ(事業報告月報詳細データリスト, 横番号, 縦番号, 集計結果値);
                修正データリスト.add(entity);
                return 修正データリスト;
            } else if (entity.get集計結果値() == null) {
                entity = entity.createBuilderForEdit().set集計結果値(集計結果値).build();
                entity = entity.modifiedModel();
                修正データリスト.add(entity);
                return 修正データリスト;
            } else if (!entity.get集計結果値().equals(集計結果値)) {
                entity = entity.createBuilderForEdit().set集計結果値(集計結果値).build();
                entity = entity.modifiedModel();
                修正データリスト.add(entity);
                return 修正データリスト;
            }
        }
        return 修正データリスト;
    }

    private JigyoHokokuTokeiData set事業報告統計データ(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            Decimal 横番号,
            Decimal 縦番号,
            Decimal 集計結果値) {
        JigyoHokokuTokeiData entity = 事業報告月報詳細データリスト.get(0).createBuilderForEdit()
                .set横番号(横番号)
                .set縦番号(縦番号)
                .set集計結果値(集計結果値)
                .set集計項目名称(null)
                .set縦項目コード(null)
                .set横項目コード(null).build();
        entity = entity.addedModel();
        return entity;
    }

    private JigyoHokokuTokeiData check事業報告統計データ(
            List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト,
            Decimal 横番号,
            Decimal 縦番号) {
        for (JigyoHokokuTokeiData entity : 事業報告月報詳細データリスト) {
            if (entity.get縦番号().equals(縦番号) && entity.get横番号().equals(横番号)) {
                return entity;
            }
        }
        return null;
    }

}
