/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.NinteiShinsakaiTaishoshaWariateDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.NinteiShinsakaiIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.dgWariatezumiTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.dgMiwariateTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.dgShinsainKoseiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.dgShinsainIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 審査会対象者個別割当Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class NinteiShinsakaiTaishoshaWariate {

    private static final int MIWARIATE = 0;
    private static final int WARIATEZUMI = 1;

    private static final int INIT = 0;
    private static final int WARITSUKE = 1;
    private static final int KAIJO = 2;

    /**
     * 審査会一覧データグリッド上の審査会選択時の処理を表します。
     *
     * @param panel ninteiShinsakaiTaishoshaWariateDiv
     * @param panel2 NinteiShinsakaiIchiranDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiTaishoshaWariateDiv> dispNinteiShinsakaiTaishoshaWariate(
            NinteiShinsakaiTaishoshaWariateDiv panel, NinteiShinsakaiIchiranDiv panel2) {
        ResponseData<NinteiShinsakaiTaishoshaWariateDiv> response = new ResponseData<>();
        setNinteiShinsakaiTaishoshaWariateData(panel, panel2);

        ViewStateHolder.put("割当人数", new RString(String.valueOf(
                panel.getTabWariate().getTplTaishoshaWariate().
                getDgWariatezumiTaishoshaIchiran().getDataSource().size())));

        response.data = panel;
        return response;

    }

    /**
     * 対象者一覧に割り付けるボタン押下時の処理を表します。
     *
     * @param panel ninteiShinsakaiTaishoshaWariateDiv
     * @param panel2 NinteiShinsakaiIchiranDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiTaishoshaWariateDiv> onClick_BtnWaritsukeTaishosha(
            NinteiShinsakaiTaishoshaWariateDiv panel, NinteiShinsakaiIchiranDiv panel2) {
        ResponseData<NinteiShinsakaiTaishoshaWariateDiv> response = new ResponseData<>();

        setTaishosha(panel, WARITSUKE);
        ViewStateHolder.put("割当人数", new RString(String.valueOf(
                panel.getTabWariate().getTplTaishoshaWariate().
                getDgWariatezumiTaishoshaIchiran().getDataSource().size())));

        response.data = panel;
        return response;

    }

    /**
     * 対象者一覧から解除するボタン押下時の処理を表します。
     *
     * @param panel ninteiShinsakaiTaishoshaWariateDiv
     * @param panel2 NinteiShinsakaiIchiranDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiTaishoshaWariateDiv> onClick_BtnKaijoTaishosha(
            NinteiShinsakaiTaishoshaWariateDiv panel, NinteiShinsakaiIchiranDiv panel2) {
        ResponseData<NinteiShinsakaiTaishoshaWariateDiv> response = new ResponseData<>();

        setTaishosha(panel, KAIJO);
        ViewStateHolder.put("割当人数", new RString(String.valueOf(
                panel.getTabWariate().getTplTaishoshaWariate().
                getDgWariatezumiTaishoshaIchiran().getDataSource().size())));

        response.data = panel;
        return response;

    }

    /**
     * 審査員構成一覧に割り付けるボタン押下時の処理を表します。
     *
     * @param panel ninteiShinsakaiTaishoshaWariateDiv
     * @param panel2 NinteiShinsakaiIchiranDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiTaishoshaWariateDiv> onClick_BtnWaritsukeShinsain(
            NinteiShinsakaiTaishoshaWariateDiv panel, NinteiShinsakaiIchiranDiv panel2) {
        ResponseData<NinteiShinsakaiTaishoshaWariateDiv> response = new ResponseData<>();

        setShinsain(panel, WARITSUKE);

        response.data = panel;
        return response;

    }

    /**
     * 構成一覧から解除するボタン押下時の処理を表します。
     *
     * @param panel ninteiShinsakaiTaishoshaWariateDiv
     * @param panel2 NinteiShinsakaiIchiranDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiTaishoshaWariateDiv> onClick_BtnKaijoShinsain(
            NinteiShinsakaiTaishoshaWariateDiv panel, NinteiShinsakaiIchiranDiv panel2) {
        ResponseData<NinteiShinsakaiTaishoshaWariateDiv> response = new ResponseData<>();

        setShinsain(panel, KAIJO);

        response.data = panel;
        return response;

    }

    /*
     *認定審査会対象者割当詳細情報を取得します。
     */
    private void setNinteiShinsakaiTaishoshaWariateData(
            NinteiShinsakaiTaishoshaWariateDiv panel, NinteiShinsakaiIchiranDiv panel2) {

        List<HashMap> ninteiShinsakaiTaishoshaWariate = YamlLoader.DBE.loadAsList(
                new RString("dbe4060001/NinteiShinsakaiTaishoshaWariate.yml"));
        HashMap hashMap = ninteiShinsakaiTaishoshaWariate.get(0);
        ControlGenerator cg = new ControlGenerator(hashMap);
        RString strKaisaiBasho = cg.getAsRString("kaisaiBasho");
        RString strSaidaiTeiin = cg.getAsRString("saidaiTeiin");
        RString strDummyKbn = cg.getAsRString("dummyKbn");
        RString strKyukaiKbn = cg.getAsRString("kyukaiKbn");

        //ヘッダー情報の設定
        panel.getNinteiShinsakaiJoho().getTxtKaisaikai().setValue(
                panel2.getDgNinteiShinsakaiIchiran().getActiveRow().getKaisaiNo());

        panel.getNinteiShinsakaiJoho().getTxtShinsakaiYoteibi().setValue(new RDate(
                panel2.getDgNinteiShinsakaiIchiran().getActiveRow().getYoteibi().toString()));

        panel.getNinteiShinsakaiJoho().getTxtGogitaiNo().setValue(
                panel2.getDgNinteiShinsakaiIchiran().getActiveRow().getGogitaiNo());

        panel.getNinteiShinsakaiJoho().getTxtGogitaiMeisho().setValue(
                panel2.getDgNinteiShinsakaiIchiran().getActiveRow().getGogitaiMeisho());

        panel.getNinteiShinsakaiJoho().getTxtKaisaiBasho().setValue(strKaisaiBasho);

        panel.getNinteiShinsakaiJoho().getTxtKaishiYoteiJikan().setValue(
                RTime.parse(panel2.getDgNinteiShinsakaiIchiran().getActiveRow().getKaishiJikan().toString()));

        panel.getNinteiShinsakaiJoho().getTxtShuryoYoteiJikan().setValue(
                RTime.parse(panel2.getDgNinteiShinsakaiIchiran().getActiveRow().getShuryoJikan().toString()));

        panel.getNinteiShinsakaiJoho().getTxtSaidaiTeiin().setValue(new Decimal(strSaidaiTeiin.toString()));

        panel.getNinteiShinsakaiJoho().getTxtYoteiTeiin().setValue(
                new Decimal(panel2.getDgNinteiShinsakaiIchiran().getActiveRow().getYoteiTeiin().toString()));

        if (strDummyKbn.toString().equals("1")) {
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            dataSource.add(new KeyValueDataSource(new RString("1"), new RString("ダミー区分")));
            panel.getNinteiShinsakaiJoho().getChkDummyKbn().setSelectedItems(dataSource);
        }

        if (strKyukaiKbn.toString().equals("1")) {
            List<KeyValueDataSource> dataSource1 = new ArrayList<>();
            dataSource1.add(new KeyValueDataSource(new RString("1"), new RString("休会区分")));
            panel.getNinteiShinsakaiJoho().getChkKyukaiKbn().setSelectedItems(dataSource1);
        }

        //割当済み対象者、未割当対象者一覧の初期設定
        setTaishosha(panel, INIT);

        //審査員構成一覧、審査員一覧の初期設定
        setShinsain(panel, INIT);
    }

    /*
     *割当済み対象者情報を設定します。
     */
    private void setTaishosha(NinteiShinsakaiTaishoshaWariateDiv panel, int iShoriKbn) {

        if (iShoriKbn == INIT) {
            List<HashMap> taishoshaIchiranData = YamlLoader.DBE.loadAsList(
                    new RString("dbe4060001/TaishoshaIchiran.yml"));

            //割当済み対象者一覧の初期設定
            List wariatezumiData = createRowTaishoshaIchiran(taishoshaIchiranData, WARIATEZUMI);
            DataGrid dgWariatezumiList = panel.getTabWariate().getTplTaishoshaWariate().getDgWariatezumiTaishoshaIchiran();
            dgWariatezumiList.setDataSource(wariatezumiData);

            //未割当対象者一覧の初期設定
            List miwariateData = createRowTaishoshaIchiran(taishoshaIchiranData, MIWARIATE);
            DataGrid dgMiwariateList = panel.getTabWariate().getTplTaishoshaWariate().getDgMiwariateTaishoshaIchiran();
            dgMiwariateList.setDataSource(miwariateData);

        } else if (iShoriKbn == WARITSUKE) {
            List<dgMiwariateTaishoshaIchiran_Row> selectedMiwariateData
                    = panel.getTabWariate().getTplTaishoshaWariate().getDgMiwariateTaishoshaIchiran().getSelectedItems();

            if (selectedMiwariateData.isEmpty() == false) {

                //割付済み対象者一覧の再設定
                DataGrid dgWariatezumiList = panel.getTabWariate().getTplTaishoshaWariate().getDgWariatezumiTaishoshaIchiran();
                List<dgWariatezumiTaishoshaIchiran_Row> wariatezumiData = dgWariatezumiList.getDataSource();
                List newWariatezumiData = setRowWariatezumiTaishoshaIchiran(wariatezumiData, selectedMiwariateData);
                dgWariatezumiList.setDataSource(newWariatezumiData);

                //未割付対象者一覧の再設定
                DataGrid dgMiwariateList = panel.getTabWariate().getTplTaishoshaWariate().getDgMiwariateTaishoshaIchiran();
                List<dgMiwariateTaishoshaIchiran_Row> MiwariateData = dgMiwariateList.getDataSource();
                List<dgMiwariateTaishoshaIchiran_Row> newMiwariateData = new ArrayList<>();
                for (dgMiwariateTaishoshaIchiran_Row row : MiwariateData) {
                    boolean bSelectFlg = false;
                    for (dgMiwariateTaishoshaIchiran_Row selectRow : selectedMiwariateData) {
                        if (row.toString().equalsIgnoreCase(selectRow.toString())) {
                            bSelectFlg = true;
                        }
                    }
                    if (bSelectFlg == Boolean.FALSE) {
                        newMiwariateData.add(row);
                    }
                }
                dgMiwariateList.setDataSource(newMiwariateData);

            }
        } else if (iShoriKbn == KAIJO) {
            List<dgWariatezumiTaishoshaIchiran_Row> selectedWariatezumiData
                    = panel.getTabWariate().getTplTaishoshaWariate().getDgWariatezumiTaishoshaIchiran().getSelectedItems();

            if (selectedWariatezumiData.isEmpty() == false) {

                //未割付対象者一覧の再設定
                DataGrid dgMiWariateList = panel.getTabWariate().getTplTaishoshaWariate().getDgMiwariateTaishoshaIchiran();
                List<dgMiwariateTaishoshaIchiran_Row> miwariateData = dgMiWariateList.getDataSource();
                List newMiwariateData = setRowMiwariateTaishoshaIchiran(miwariateData, selectedWariatezumiData);
                dgMiWariateList.setDataSource(newMiwariateData);

                //割付済み対象者一覧の再設定
                DataGrid dgWariatezumiList = panel.getTabWariate().getTplTaishoshaWariate().getDgWariatezumiTaishoshaIchiran();
                List<dgWariatezumiTaishoshaIchiran_Row> wariatezumiData = dgWariatezumiList.getDataSource();
                List<dgWariatezumiTaishoshaIchiran_Row> newWariateData = new ArrayList<>();
                for (dgWariatezumiTaishoshaIchiran_Row row : wariatezumiData) {
                    boolean bSelectFlg = false;
                    for (dgWariatezumiTaishoshaIchiran_Row selectRow : selectedWariatezumiData) {
                        if (row.toString().equalsIgnoreCase(selectRow.toString())) {
                            bSelectFlg = true;
                        }
                    }
                    if (bSelectFlg == Boolean.FALSE) {
                        newWariateData.add(row);
                    }
                }
                dgWariatezumiList.setDataSource(newWariateData);

            }

        }

        //割付ボタンの活性化制御
        if (panel.getTabWariate().getTplTaishoshaWariate().getDgMiwariateTaishoshaIchiran().
                getDataSource().isEmpty()) {

            panel.getTabWariate().getTplTaishoshaWariate().getTaishoshaWariateBtn().
                    getBtnWaritsukeTaishosha().setDisabled(true);
        } else {
            panel.getTabWariate().getTplTaishoshaWariate().getTaishoshaWariateBtn().
                    getBtnWaritsukeTaishosha().setDisabled(false);
        }

        //割付解除ボタンの活性化制御
        if (panel.getTabWariate().getTplTaishoshaWariate().getDgWariatezumiTaishoshaIchiran().
                getDataSource().isEmpty()) {

            panel.getTabWariate().getTplTaishoshaWariate().getTaishoshaWariateBtn().
                    getBtnKaijoTaishosha().setDisabled(true);
        } else {
            panel.getTabWariate().getTplTaishoshaWariate().getTaishoshaWariateBtn().
                    getBtnKaijoTaishosha().setDisabled(false);
        }
    }

    /*
     *割当済み対象者情報の初期値をセットします。
     */
    private List createRowTaishoshaIchiran(List<HashMap> TaishoshaIchiranData, int iList) {

        int iShinsaNo = 1;
        List arrayDataList = new ArrayList();

        for (int i = 0; i < TaishoshaIchiranData.size(); i++) {

            HashMap hashMap = TaishoshaIchiranData.get(i);
            String strWariatezumi = (String) hashMap.get("wariatezumi");
            if (iList == WARIATEZUMI && Integer.parseInt(strWariatezumi) == WARIATEZUMI) {
                String strShinsaNo = String.valueOf(iShinsaNo);
                String strHokensha = (String) hashMap.get("hokensha");
                String strHihoNo = (String) hashMap.get("hihoNo");
                String strShimei = (String) hashMap.get("shimei");
                String strKana = (String) hashMap.get("kana");
                String strShinseibi = (String) hashMap.get("shinseibi");
                String strShinseiKbn = (String) hashMap.get("shinseiKbn");
                String strSeibetsu = (String) hashMap.get("seibetsu");
                String strIchijiHantei = (String) hashMap.get("ichijiHantei");
                String strKijunJikan = (String) hashMap.get("kijunJikan");
                String strFuriwakeKbn = (String) hashMap.get("furiwakeKbn");
                String strIryoKikanMei = (String) hashMap.get("iryoKikanMei");
                String strShujiiMei = (String) hashMap.get("shujiiMei");
                String strChosaKikanMei = (String) hashMap.get("chosaKikanMei");
                String strChosainMei = (String) hashMap.get("chosainMei");

                arrayDataList.add(createRowWariatezumiTaishoshaIchiran(
                        strShinsaNo,
                        strHokensha,
                        strHihoNo,
                        strShimei,
                        strKana,
                        strShinseibi,
                        strShinseiKbn,
                        strSeibetsu,
                        strIchijiHantei,
                        strKijunJikan,
                        strFuriwakeKbn,
                        strIryoKikanMei,
                        strShujiiMei,
                        strChosaKikanMei,
                        strChosainMei
                ));
                iShinsaNo = iShinsaNo + 1;

            } else if (iList == MIWARIATE && Integer.parseInt(strWariatezumi) == MIWARIATE) {
                String strHokensha = (String) hashMap.get("hokensha");
                String strHihoNo = (String) hashMap.get("hihoNo");
                String strShimei = (String) hashMap.get("shimei");
                String strKana = (String) hashMap.get("kana");
                String strShinseibi = (String) hashMap.get("shinseibi");
                String strShinseiKbn = (String) hashMap.get("shinseiKbn");
                String strSeibetsu = (String) hashMap.get("seibetsu");
                String strIchijiHantei = (String) hashMap.get("ichijiHantei");
                String strKijunJikan = (String) hashMap.get("kijunJikan");
                String strFuriwakeKbn = (String) hashMap.get("furiwakeKbn");
                String strIryoKikanMei = (String) hashMap.get("iryoKikanMei");
                String strShujiiMei = (String) hashMap.get("shujiiMei");
                String strChosaKikanMei = (String) hashMap.get("chosaKikanMei");
                String strChosainMei = (String) hashMap.get("chosainMei");

                arrayDataList.add(createRowMiwariateTaishoshaIchiran(
                        strHokensha,
                        strHihoNo,
                        strShimei,
                        strKana,
                        strShinseibi,
                        strShinseiKbn,
                        strSeibetsu,
                        strIchijiHantei,
                        strKijunJikan,
                        strFuriwakeKbn,
                        strIryoKikanMei,
                        strShujiiMei,
                        strChosaKikanMei,
                        strChosainMei
                ));
            }

        }
        return arrayDataList;
    }

    /*
     *引数を元にデータグリッド内に挿入する割当済み対象者一覧データを作成します。
     */
    private dgWariatezumiTaishoshaIchiran_Row createRowWariatezumiTaishoshaIchiran(
            String shinsaNo,
            String hokensha,
            String hihoNo,
            String shimei,
            String kana,
            String shinseibi,
            String shinseiKbn,
            String seibetsu,
            String ichijiHantei,
            String kijunJikan,
            String furiwakeKbn,
            String iryoKikanMei,
            String shujiiMei,
            String chosaKikanMei,
            String chosainMei
    ) {
        dgWariatezumiTaishoshaIchiran_Row rowWariatezumiTaishoshaIchiranData = new dgWariatezumiTaishoshaIchiran_Row(
                new RString(shinsaNo),
                new RString(hokensha),
                new RString(hihoNo),
                new RString(shimei),
                new RString(kana),
                new RString(shinseibi),
                new RString(shinseiKbn),
                new RString(seibetsu),
                new RString(ichijiHantei),
                new RString(kijunJikan),
                new RString(furiwakeKbn),
                new RString(iryoKikanMei),
                new RString(shujiiMei),
                new RString(chosaKikanMei),
                new RString(chosainMei)
        );
        return rowWariatezumiTaishoshaIchiranData;
    }

    /*
     *引数を元にデータグリッド内に挿入する未割当対象者一覧データを作成します。
     */
    private dgMiwariateTaishoshaIchiran_Row createRowMiwariateTaishoshaIchiran(
            String hokensha,
            String hihoNo,
            String shimei,
            String kana,
            String shinseibi,
            String shinseiKbn,
            String seibetsu,
            String ichijiHantei,
            String kijunJikan,
            String furiwakeKbn,
            String iryoKikanMei,
            String shujiiMei,
            String chosaKikanMei,
            String chosainMei
    ) {
        dgMiwariateTaishoshaIchiran_Row rowMiwariateTaishoshaIchiranData = new dgMiwariateTaishoshaIchiran_Row(
                new RString(hokensha),
                new RString(hihoNo),
                new RString(shimei),
                new RString(kana),
                new RString(shinseibi),
                new RString(shinseiKbn),
                new RString(seibetsu),
                new RString(ichijiHantei),
                new RString(kijunJikan),
                new RString(furiwakeKbn),
                new RString(iryoKikanMei),
                new RString(shujiiMei),
                new RString(chosaKikanMei),
                new RString(chosainMei)
        );
        return rowMiwariateTaishoshaIchiranData;
    }

    /*
     *審査員情報を設定します。
     */
    private void setShinsain(NinteiShinsakaiTaishoshaWariateDiv panel, int iShoriKbn) {

        if (iShoriKbn == INIT) {
            List<HashMap> shinsainIchiranData = YamlLoader.DBE.loadAsList(
                    new RString("dbe4060001/ShinsainIchiran.yml"));

            //審査員構成一覧の初期設定
            List shinsainKoseiData = createRowShinsainIchiran(shinsainIchiranData, WARIATEZUMI);
            DataGrid dgShinsainKoseiList = panel.getTabWariate().getTplShinsainWariate().getDgShinsainKoseiIchiran();
            dgShinsainKoseiList.setDataSource(shinsainKoseiData);

            //審査員一覧の初期設定
            List shinsainData = createRowShinsainIchiran(shinsainIchiranData, MIWARIATE);
            DataGrid dgShinsainList = panel.getTabWariate().getTplShinsainWariate().getDgShinsainIchiran();
            dgShinsainList.setDataSource(shinsainData);

        } else if (iShoriKbn == WARITSUKE) {
            List<dgShinsainIchiran_Row> selectedShinsainData
                    = panel.getTabWariate().getTplShinsainWariate().getDgShinsainIchiran().getSelectedItems();

            if (selectedShinsainData.isEmpty() == false) {

                //審査員構成一覧の再設定
                DataGrid dgShinsainKoseiList = panel.getTabWariate().getTplShinsainWariate().getDgShinsainKoseiIchiran();
                List<dgShinsainKoseiIchiran_Row> shinsainKoseiData = dgShinsainKoseiList.getDataSource();
                List newShinsainKoseiData = setRowShinsainKoseiIchiran(shinsainKoseiData, selectedShinsainData);
                dgShinsainKoseiList.setDataSource(newShinsainKoseiData);

                //審査員一覧の再設定
                DataGrid dgShinsainList = panel.getTabWariate().getTplShinsainWariate().getDgShinsainIchiran();
                List<dgShinsainIchiran_Row> shinsainData = dgShinsainList.getDataSource();
                List<dgShinsainIchiran_Row> newShinsainData = new ArrayList<>();
                for (dgShinsainIchiran_Row row : shinsainData) {
                    boolean bSelectFlg = false;
                    for (dgShinsainIchiran_Row selectRow : selectedShinsainData) {
                        if (row.toString().equalsIgnoreCase(selectRow.toString())) {
                            bSelectFlg = true;
                        }
                    }
                    if (bSelectFlg == Boolean.FALSE) {
                        newShinsainData.add(row);
                    }
                }
                dgShinsainList.setDataSource(newShinsainData);

            }
        } else if (iShoriKbn == KAIJO) {

            List<dgShinsainKoseiIchiran_Row> selectedShinsainKoseiData
                    = panel.getTabWariate().getTplShinsainWariate().getDgShinsainKoseiIchiran().getSelectedItems();

            if (selectedShinsainKoseiData.isEmpty() == false) {

                //審査員一覧の再設定
                DataGrid dgShinsainList = panel.getTabWariate().getTplShinsainWariate().getDgShinsainIchiran();
                List<dgShinsainIchiran_Row> shinsainData = dgShinsainList.getDataSource();
                List newShinsainData = setRowShinsainIchiran(shinsainData, selectedShinsainKoseiData);
                dgShinsainList.setDataSource(newShinsainData);

                //審査員構成一覧の再設定
                DataGrid dgShinsainKoseiList = panel.getTabWariate().getTplShinsainWariate().getDgShinsainKoseiIchiran();
                List<dgShinsainKoseiIchiran_Row> shinsainKoseiData = dgShinsainKoseiList.getDataSource();
                List<dgShinsainKoseiIchiran_Row> newShinsainKoseiData = new ArrayList<>();
                for (dgShinsainKoseiIchiran_Row row : shinsainKoseiData) {
                    boolean bSelectFlg = false;
                    for (dgShinsainKoseiIchiran_Row selectRow : selectedShinsainKoseiData) {
                        if (row.toString().equalsIgnoreCase(selectRow.toString())) {
                            bSelectFlg = true;
                        }
                    }
                    if (bSelectFlg == Boolean.FALSE) {
                        newShinsainKoseiData.add(row);
                    }
                }
                dgShinsainKoseiList.setDataSource(newShinsainKoseiData);

            }
        }

        //割付ボタンの活性化制御
        if (panel.getTabWariate().getTplShinsainWariate().getDgShinsainIchiran().
                getDataSource().isEmpty()) {

            panel.getTabWariate().getTplShinsainWariate().getShinsainWariateBtn().
                    getBtnWaritsukeShinsain().setDisabled(true);
        } else {
            panel.getTabWariate().getTplShinsainWariate().getShinsainWariateBtn().
                    getBtnWaritsukeShinsain().setDisabled(false);
        }

        //割付解除ボタンの活性化制御
        if (panel.getTabWariate().getTplShinsainWariate().getDgShinsainKoseiIchiran().
                getDataSource().isEmpty()) {

            panel.getTabWariate().getTplShinsainWariate().getShinsainWariateBtn().
                    getBtnKaijoShinsain().setDisabled(true);
        } else {
            panel.getTabWariate().getTplShinsainWariate().getShinsainWariateBtn().
                    getBtnKaijoShinsain().setDisabled(false);
        }

    }

    /*
     *審査員構成、審査員情報の初期値をセットします。
     */
    private List createRowShinsainIchiran(List<HashMap> shinsainIchiranData, int iList) {

        List arrayDataList = new ArrayList();

        for (int i = 0; i < shinsainIchiranData.size(); i++) {

            HashMap hashMap = shinsainIchiranData.get(i);
            String strWariatezumi = (String) hashMap.get("wariatezumi");
            String strShinsainNo = (String) hashMap.get("shinsainNo");
            String strShinsainShimei = (String) hashMap.get("shinsainShimei");
            String strShozokukikan = (String) hashMap.get("shozokukikan");
            String strSeibetsu = (String) hashMap.get("seibetsu");
            String strShinsainKbn = (String) hashMap.get("shinsainKbn");
            String strGogitaichoKbn = (String) hashMap.get("gogitaichoKbn");
            String strShukketsuKbn = (String) hashMap.get("shukketsuKbn");
            String strShinsainJokyo = (String) hashMap.get("shinsainJokyo");
            String strShinsainKaishibi = (String) hashMap.get("shinsainKaishibi");
            String strShinsainShuryobi = (String) hashMap.get("shinsainShuryobi");
            if (iList == WARIATEZUMI && Integer.parseInt(strWariatezumi) == WARIATEZUMI) {
                arrayDataList.add(createRowShinsainKoseiIchiran(
                        strShinsainNo,
                        strShinsainShimei,
                        strShozokukikan,
                        strSeibetsu,
                        strShinsainKbn,
                        strGogitaichoKbn,
                        strShukketsuKbn,
                        strShinsainJokyo,
                        strShinsainKaishibi,
                        strShinsainShuryobi
                ));
            } else if (iList == MIWARIATE && Integer.parseInt(strWariatezumi) == MIWARIATE) {

                arrayDataList.add(createRowShinsainIchiran(
                        strShinsainNo,
                        strShinsainShimei,
                        strShozokukikan,
                        strSeibetsu,
                        strShinsainKbn,
                        strShinsainJokyo,
                        strShinsainKaishibi,
                        strShinsainShuryobi,
                        strGogitaichoKbn,
                        strShukketsuKbn
                ));

            }
        }
        return arrayDataList;
    }

    /*
     *引数を元にデータグリッド内に挿入する審査員構成一覧データを作成します。
     */
    private dgShinsainKoseiIchiran_Row createRowShinsainKoseiIchiran(
            String shinsainNo,
            String shinsainShimei,
            String shozokukikan,
            String seibetsu,
            String shinsainKbn,
            String gogitaichoKbn,
            String shukketsuKbn,
            String shinsainJokyo,
            String shinsainKaishibi,
            String shinsainShuryobi
    ) {
        dgShinsainKoseiIchiran_Row rowShinsainKoseiIchiran = new dgShinsainKoseiIchiran_Row(
                new RString(shinsainNo),
                new RString(shinsainShimei),
                new RString(shozokukikan),
                new RString(seibetsu),
                new RString(shinsainKbn),
                new RString(gogitaichoKbn),
                new RString(shukketsuKbn),
                new RString(shinsainJokyo),
                new RString(shinsainKaishibi),
                new RString(shinsainShuryobi)
        );
        return rowShinsainKoseiIchiran;
    }

    /*
     *引数を元にデータグリッド内に挿入する審査員一覧データを作成します。
     */
    private dgShinsainIchiran_Row createRowShinsainIchiran(
            String shinsainNo,
            String shinsainShimei,
            String shozokukikan,
            String seibetsu,
            String shinsainKbn,
            String shinsainJokyo,
            String shinsainKaishibi,
            String shinsainShuryobi,
            String gogitaichoKbn,
            String shukketsuKbn
    ) {
        dgShinsainIchiran_Row rowShinsainIchiran = new dgShinsainIchiran_Row(
                new RString(shinsainNo),
                new RString(shinsainShimei),
                new RString(shozokukikan),
                new RString(seibetsu),
                new RString(shinsainKbn),
                new RString(shinsainJokyo),
                new RString(shinsainKaishibi),
                new RString(shinsainShuryobi),
                new RString(gogitaichoKbn),
                new RString(shukketsuKbn)
        );
        return rowShinsainIchiran;
    }

    /*
     *割当済み対象者一覧へ割付します。
     */
    private List setRowWariatezumiTaishoshaIchiran(
            List<dgWariatezumiTaishoshaIchiran_Row> wariatezumiTaishoshaIchiranData,
            List<dgMiwariateTaishoshaIchiran_Row> selectedMiwariateData) {

        for (int i = 0; i < selectedMiwariateData.size(); i++) {

            wariatezumiTaishoshaIchiranData.add(createRowWariatezumiTaishoshaIchiran(
                    new String(),
                    selectedMiwariateData.get(i).getHokensha().toString(),
                    selectedMiwariateData.get(i).getHihokenNo().toString(),
                    selectedMiwariateData.get(i).getShimei().toString(),
                    selectedMiwariateData.get(i).getShimeiKana().toString(),
                    selectedMiwariateData.get(i).getShinseibi().toString(),
                    selectedMiwariateData.get(i).getShinseiKbn().toString(),
                    selectedMiwariateData.get(i).getSeibetsu().toString(),
                    selectedMiwariateData.get(i).getIchijiHantei().toString(),
                    selectedMiwariateData.get(i).getKijunJikan().toString(),
                    selectedMiwariateData.get(i).getFuriwakeKbn().toString(),
                    selectedMiwariateData.get(i).getIryokikan().toString(),
                    selectedMiwariateData.get(i).getShujii().toString(),
                    selectedMiwariateData.get(i).getChosakikan().toString(),
                    selectedMiwariateData.get(i).getChosain().toString()
            ));
        }

        return wariatezumiTaishoshaIchiranData;
    }

    /*
     *未割当対象者一覧へ割付します。
     */
    private List setRowMiwariateTaishoshaIchiran(
            List<dgMiwariateTaishoshaIchiran_Row> miwariateTaishoshaIchiranData,
            List<dgWariatezumiTaishoshaIchiran_Row> selectedWariatezumiData) {

        for (int i = 0; i < selectedWariatezumiData.size(); i++) {

            miwariateTaishoshaIchiranData.add(createRowMiwariateTaishoshaIchiran(
                    selectedWariatezumiData.get(i).getHokensha().toString(),
                    selectedWariatezumiData.get(i).getHihokenNo().toString(),
                    selectedWariatezumiData.get(i).getShimei().toString(),
                    selectedWariatezumiData.get(i).getShimeiKana().toString(),
                    selectedWariatezumiData.get(i).getShinseibi().toString(),
                    selectedWariatezumiData.get(i).getShinseiKbn().toString(),
                    selectedWariatezumiData.get(i).getSeibetsu().toString(),
                    selectedWariatezumiData.get(i).getIchijiHantei().toString(),
                    selectedWariatezumiData.get(i).getKijunJikan().toString(),
                    selectedWariatezumiData.get(i).getFuriwakeKbn().toString(),
                    selectedWariatezumiData.get(i).getIryokikan().toString(),
                    selectedWariatezumiData.get(i).getShujii().toString(),
                    selectedWariatezumiData.get(i).getChosakikan().toString(),
                    selectedWariatezumiData.get(i).getChosain().toString()
            ));
        }

        return miwariateTaishoshaIchiranData;
    }

    /*
     *審査員構成一覧へ割付します。
     */
    private List setRowShinsainKoseiIchiran(
            List<dgShinsainKoseiIchiran_Row> shinsainKoseiIchiranData,
            List<dgShinsainIchiran_Row> selectedShinsainData) {

        for (int i = 0; i < selectedShinsainData.size(); i++) {

            shinsainKoseiIchiranData.add(createRowShinsainKoseiIchiran(
                    selectedShinsainData.get(i).getShinsainNo().toString(),
                    selectedShinsainData.get(i).getShinsainShimei().toString(),
                    selectedShinsainData.get(i).getShozokukikan().toString(),
                    selectedShinsainData.get(i).getSeibetsu().toString(),
                    selectedShinsainData.get(i).getShinsainKbn().toString(),
                    selectedShinsainData.get(i).getGogitaichoKbn().toString(),
                    selectedShinsainData.get(i).getShukketsuKbn().toString(),
                    selectedShinsainData.get(i).getShinsainJokyo().toString(),
                    selectedShinsainData.get(i).getShinsainKaishibi().toString(),
                    selectedShinsainData.get(i).getShinsainShuryobi().toString()
            ));
        }
        return shinsainKoseiIchiranData;
    }

    /*
     *審査員一覧へ割付します。
     */
    private List setRowShinsainIchiran(
            List<dgShinsainIchiran_Row> shinsainIchiranData,
            List<dgShinsainKoseiIchiran_Row> selectedShinsainKoseiData) {

        for (int i = 0; i < selectedShinsainKoseiData.size(); i++) {

            shinsainIchiranData.add(createRowShinsainIchiran(
                    selectedShinsainKoseiData.get(i).getShinsainNo().toString(),
                    selectedShinsainKoseiData.get(i).getShinsainShimei().toString(),
                    selectedShinsainKoseiData.get(i).getShozokukikan().toString(),
                    selectedShinsainKoseiData.get(i).getSeibetsu().toString(),
                    selectedShinsainKoseiData.get(i).getShinsainKbn().toString(),
                    selectedShinsainKoseiData.get(i).getShinsainJokyo().toString(),
                    selectedShinsainKoseiData.get(i).getShinsainKaishibi().toString(),
                    selectedShinsainKoseiData.get(i).getShinsainShuryobi().toString(),
                    selectedShinsainKoseiData.get(i).getGogitaichoKbn().toString(),
                    selectedShinsainKoseiData.get(i).getShukketsuKbn().toString()
            ));
        }
        return shinsainIchiranData;
    }
}
