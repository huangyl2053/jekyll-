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
                panel.getTabWariate().getTplTaishoshaWariate().getWariateZumisha().
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
                panel.getTabWariate().getTplTaishoshaWariate().getWariateZumisha().
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
                panel.getTabWariate().getTplTaishoshaWariate().getWariateZumisha().
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
            DataGrid dgWariatezumiList = panel.getTabWariate().getTplTaishoshaWariate().getWariateZumisha().
                    getDgWariatezumiTaishoshaIchiran();
            dgWariatezumiList.setDataSource(wariatezumiData);

            //未割当対象者一覧の初期設定
            List miwariateData = createRowTaishoshaIchiran(taishoshaIchiranData, MIWARIATE);
            DataGrid dgMiwariateList = panel.getTabWariate().getTplTaishoshaWariate().getMiwariatesha().
                    getDgMiwariateTaishoshaIchiran();
            dgMiwariateList.setDataSource(miwariateData);

        } else if (iShoriKbn == WARITSUKE) {
            List<dgMiwariateTaishoshaIchiran_Row> selectedMiwariateData
                    = panel.getTabWariate().getTplTaishoshaWariate().getMiwariatesha().
                    getDgMiwariateTaishoshaIchiran().getSelectedItems();

//            if (selectedMiwariateData.isEmpty() == false) {
            if (!selectedMiwariateData.isEmpty()) {

                //割付済み対象者一覧の再設定
                DataGrid dgWariatezumiList = panel.getTabWariate().getTplTaishoshaWariate().getWariateZumisha().
                        getDgWariatezumiTaishoshaIchiran();
                List<dgWariatezumiTaishoshaIchiran_Row> wariatezumiData = dgWariatezumiList.getDataSource();
                List newWariatezumiData = setRowWariatezumiTaishoshaIchiran(wariatezumiData, selectedMiwariateData);
                dgWariatezumiList.setDataSource(newWariatezumiData);

                //未割付対象者一覧の再設定
                DataGrid dgMiwariateList = panel.getTabWariate().getTplTaishoshaWariate().getMiwariatesha().
                        getDgMiwariateTaishoshaIchiran();
                List<dgMiwariateTaishoshaIchiran_Row> miwariateData = dgMiwariateList.getDataSource();
                List<dgMiwariateTaishoshaIchiran_Row> newMiwariateData = new ArrayList<>();
                for (dgMiwariateTaishoshaIchiran_Row row : miwariateData) {
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
                    = panel.getTabWariate().getTplTaishoshaWariate().getWariateZumisha().
                    getDgWariatezumiTaishoshaIchiran().getSelectedItems();

            if (!selectedWariatezumiData.isEmpty()) {

                //未割付対象者一覧の再設定
                DataGrid dgMiWariateList = panel.getTabWariate().getTplTaishoshaWariate().getMiwariatesha().
                        getDgMiwariateTaishoshaIchiran();
                List<dgMiwariateTaishoshaIchiran_Row> miwariateData = dgMiWariateList.getDataSource();
                List newMiwariateData = setRowMiwariateTaishoshaIchiran(miwariateData, selectedWariatezumiData);
                dgMiWariateList.setDataSource(newMiwariateData);

                //割付済み対象者一覧の再設定
                DataGrid dgWariatezumiList = panel.getTabWariate().getTplTaishoshaWariate().getWariateZumisha().
                        getDgWariatezumiTaishoshaIchiran();
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
        if (panel.getTabWariate().getTplTaishoshaWariate().getMiwariatesha().getDgMiwariateTaishoshaIchiran().
                getDataSource().isEmpty()) {

            panel.getTabWariate().getTplTaishoshaWariate().getMiwariatesha().getWariateButtonArea().
                    getBtnWaritsukeTaishosha().setDisabled(true);
        } else {
            panel.getTabWariate().getTplTaishoshaWariate().getMiwariatesha().getWariateButtonArea().
                    getBtnWaritsukeTaishosha().setDisabled(false);
        }

        //割付解除ボタンの活性化制御
        if (panel.getTabWariate().getTplTaishoshaWariate().getWariateZumisha().
                getDgWariatezumiTaishoshaIchiran().
                getDataSource().isEmpty()) {

            panel.getTabWariate().getTplTaishoshaWariate().getMiwariatesha().getKaijoButtonArea().
                    getBtnKaijoTaishosha().setDisabled(true);
        } else {
            panel.getTabWariate().getTplTaishoshaWariate().getMiwariatesha().getKaijoButtonArea().
                    getBtnKaijoTaishosha().setDisabled(false);
        }
    }

    /*
     *割当済み対象者情報の初期値をセットします。
     */
    private List createRowTaishoshaIchiran(List<HashMap> taishoshaIchiranData, int iList) {

        int iShinsaNo = 1;
        List arrayDataList = new ArrayList();

        for (int i = 0; i < taishoshaIchiranData.size(); i++) {

//            HashMap hashMap = taishoshaIchiranData.get(i);
            ControlGenerator cg = new ControlGenerator(taishoshaIchiranData.get(i));
            RString strWariatezumi = cg.getAsRString("wariatezumi");
            if (iList == WARIATEZUMI && Integer.parseInt(strWariatezumi.toString()) == WARIATEZUMI) {
                RString strShinsaNo = new RString(String.valueOf(iShinsaNo));
                RString strHokensha = cg.getAsRString("hokensha");
                RString strHihoNo = cg.getAsRString("hihoNo");
                RString strShimei = cg.getAsRString("shimei");
                RString strKana = cg.getAsRString("kana");
                RString strShinseibi = cg.getAsRString("shinseibi");
                RString strShinseiKbn = cg.getAsRString("shinseiKbn");
                RString strSeibetsu = cg.getAsRString("seibetsu");
                RString strIchijiHantei = cg.getAsRString("ichijiHantei");
                RString strKijunJikan = cg.getAsRString("kijunJikan");
                RString strFuriwakeKbn = cg.getAsRString("furiwakeKbn");
                RString strIryoKikanMei = cg.getAsRString("iryoKikanMei");
                RString strShujiiMei = cg.getAsRString("shujiiMei");
                RString strChosaKikanMei = cg.getAsRString("chosaKikanMei");
                RString strChosainMei = cg.getAsRString("chosainMei");

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

            } else if (iList == MIWARIATE && Integer.parseInt(strWariatezumi.toString()) == MIWARIATE) {
                RString strHokensha = cg.getAsRString("hokensha");
                RString strHihoNo = cg.getAsRString("hihoNo");
                RString strShimei = cg.getAsRString("shimei");
                RString strKana = cg.getAsRString("kana");
                RString strFuriwakeKbn = cg.getAsRString("furiwakeKbn");
                RString strShinseibi = cg.getAsRString("shinseibi");
                RString strShinseiKbn = cg.getAsRString("shinseiKbn");
                RString strSeibetsu = cg.getAsRString("seibetsu");
                RString strIchijiHantei = cg.getAsRString("ichijiHantei");
                RString strKijunJikan = cg.getAsRString("kijunJikan");
                RString strIryoKikanMei = cg.getAsRString("iryoKikanMei");
                RString strShujiiMei = cg.getAsRString("shujiiMei");
                RString strChosaKikanMei = cg.getAsRString("chosaKikanMei");
                RString strChosainMei = cg.getAsRString("chosainMei");

                arrayDataList.add(createRowMiwariateTaishoshaIchiran(
                        strHokensha,
                        strHihoNo,
                        strShimei,
                        strKana,
                        strFuriwakeKbn,
                        strShinseibi,
                        strShinseiKbn,
                        strSeibetsu,
                        strIchijiHantei,
                        strKijunJikan,
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
            RString shinsaNo,
            RString hokensha,
            RString hihoNo,
            RString shimei,
            RString kana,
            RString shinseibi,
            RString shinseiKbn,
            RString seibetsu,
            RString ichijiHantei,
            RString kijunJikan,
            RString furiwakeKbn,
            RString iryoKikanMei,
            RString shujiiMei,
            RString chosaKikanMei,
            RString chosainMei
    ) {
        dgWariatezumiTaishoshaIchiran_Row rowWariatezumiTaishoshaIchiranData = new dgWariatezumiTaishoshaIchiran_Row(
                shinsaNo, hokensha, hihoNo, shimei, kana, shinseibi, shinseiKbn, seibetsu, ichijiHantei, kijunJikan, furiwakeKbn,
                iryoKikanMei, shujiiMei, chosaKikanMei, chosainMei);
        return rowWariatezumiTaishoshaIchiranData;
    }

    /*
     *引数を元にデータグリッド内に挿入する未割当対象者一覧データを作成します。
     */
    private dgMiwariateTaishoshaIchiran_Row createRowMiwariateTaishoshaIchiran(
            RString hokensha,
            RString hihoNo,
            RString shimei,
            RString kana,
            RString furiwakeKbn,
            RString shinseibi,
            RString shinseiKbn,
            RString seibetsu,
            RString ichijiHantei,
            RString kijunJikan,
            RString iryoKikanMei,
            RString shujiiMei,
            RString chosaKikanMei,
            RString chosainMei
    ) {
        dgMiwariateTaishoshaIchiran_Row rowMiwariateTaishoshaIchiranData = new dgMiwariateTaishoshaIchiran_Row(
                hokensha, hihoNo, shimei, kana, furiwakeKbn, shinseibi, shinseiKbn, seibetsu, ichijiHantei, kijunJikan,
                iryoKikanMei, shujiiMei, chosaKikanMei, chosainMei);
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

            if (!selectedShinsainData.isEmpty()) {

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

            if (!selectedShinsainKoseiData.isEmpty()) {

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

//            HashMap hashMap = shinsainIchiranData.get(i);
            ControlGenerator cg = new ControlGenerator(shinsainIchiranData.get(i));
            RString strWariatezumi = cg.getAsRString("wariatezumi");
            RString strShinsainNo = cg.getAsRString("shinsainNo");
            RString strShinsainShimei = cg.getAsRString("shinsainShimei");
            RString strShozokukikan = cg.getAsRString("shozokukikan");
            RString strSeibetsu = cg.getAsRString("seibetsu");
            RString strShinsainKbn = cg.getAsRString("shinsainKbn");
            RString strGogitaichoKbn = cg.getAsRString("gogitaichoKbn");
            RString strShukketsuKbn = cg.getAsRString("shukketsuKbn");
            RString strShinsainJokyo = cg.getAsRString("shinsainJokyo");
            RString strShinsainKaishibi = cg.getAsRString("shinsainKaishibi");
            RString strShinsainShuryobi = cg.getAsRString("shinsainShuryobi");
            if (iList == WARIATEZUMI && Integer.parseInt(strWariatezumi.toString()) == WARIATEZUMI) {
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
            } else if (iList == MIWARIATE && Integer.parseInt(strWariatezumi.toString()) == MIWARIATE) {

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
            RString shinsainNo,
            RString shinsainShimei,
            RString shozokukikan,
            RString seibetsu,
            RString shinsainKbn,
            RString gogitaichoKbn,
            RString shukketsuKbn,
            RString shinsainJokyo,
            RString shinsainKaishibi,
            RString shinsainShuryobi
    ) {
        dgShinsainKoseiIchiran_Row rowShinsainKoseiIchiran = new dgShinsainKoseiIchiran_Row(
                shinsainNo, shinsainShimei, shozokukikan, seibetsu, shinsainKbn, gogitaichoKbn,
                shukketsuKbn, shinsainJokyo, shinsainKaishibi, shinsainShuryobi);
        return rowShinsainKoseiIchiran;
    }

    /*
     *引数を元にデータグリッド内に挿入する審査員一覧データを作成します。
     */
    private dgShinsainIchiran_Row createRowShinsainIchiran(
            RString shinsainNo,
            RString shinsainShimei,
            RString shozokukikan,
            RString seibetsu,
            RString shinsainKbn,
            RString shinsainJokyo,
            RString shinsainKaishibi,
            RString shinsainShuryobi,
            RString gogitaichoKbn,
            RString shukketsuKbn
    ) {
        dgShinsainIchiran_Row rowShinsainIchiran = new dgShinsainIchiran_Row(
                shinsainNo, shinsainShimei, shozokukikan, seibetsu, shinsainKbn, shinsainJokyo, shinsainKaishibi,
                shinsainShuryobi, gogitaichoKbn, shukketsuKbn);
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
                    RString.EMPTY,
                    selectedMiwariateData.get(i).getHokensha(),
                    selectedMiwariateData.get(i).getHihokenNo(),
                    selectedMiwariateData.get(i).getShimei(),
                    selectedMiwariateData.get(i).getShimeiKana(),
                    selectedMiwariateData.get(i).getShinseibi(),
                    selectedMiwariateData.get(i).getShinseiKbn(),
                    selectedMiwariateData.get(i).getSeibetsu(),
                    selectedMiwariateData.get(i).getIchijiHantei(),
                    selectedMiwariateData.get(i).getKijunJikan(),
                    selectedMiwariateData.get(i).getFuriwakeKbn(),
                    selectedMiwariateData.get(i).getIryokikan(),
                    selectedMiwariateData.get(i).getShujii(),
                    selectedMiwariateData.get(i).getChosakikan(),
                    selectedMiwariateData.get(i).getChosain()
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
                    selectedWariatezumiData.get(i).getHokensha(),
                    selectedWariatezumiData.get(i).getHihokenNo(),
                    selectedWariatezumiData.get(i).getShimei(),
                    selectedWariatezumiData.get(i).getShimeiKana(),
                    selectedWariatezumiData.get(i).getFuriwakeKbn(),
                    selectedWariatezumiData.get(i).getShinseibi(),
                    selectedWariatezumiData.get(i).getShinseiKbn(),
                    selectedWariatezumiData.get(i).getSeibetsu(),
                    selectedWariatezumiData.get(i).getIchijiHantei(),
                    selectedWariatezumiData.get(i).getKijunJikan(),
                    selectedWariatezumiData.get(i).getIryokikan(),
                    selectedWariatezumiData.get(i).getShujii(),
                    selectedWariatezumiData.get(i).getChosakikan(),
                    selectedWariatezumiData.get(i).getChosain()
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
                    selectedShinsainData.get(i).getShinsainNo(),
                    selectedShinsainData.get(i).getShinsainShimei(),
                    selectedShinsainData.get(i).getShozokukikan(),
                    selectedShinsainData.get(i).getSeibetsu(),
                    selectedShinsainData.get(i).getShinsainKbn(),
                    selectedShinsainData.get(i).getGogitaichoKbn(),
                    selectedShinsainData.get(i).getShukketsuKbn(),
                    selectedShinsainData.get(i).getShinsainJokyo(),
                    selectedShinsainData.get(i).getShinsainKaishibi(),
                    selectedShinsainData.get(i).getShinsainShuryobi()
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
                    selectedShinsainKoseiData.get(i).getShinsainNo(),
                    selectedShinsainKoseiData.get(i).getShinsainShimei(),
                    selectedShinsainKoseiData.get(i).getShozokukikan(),
                    selectedShinsainKoseiData.get(i).getSeibetsu(),
                    selectedShinsainKoseiData.get(i).getShinsainKbn(),
                    selectedShinsainKoseiData.get(i).getShinsainJokyo(),
                    selectedShinsainKoseiData.get(i).getShinsainKaishibi(),
                    selectedShinsainKoseiData.get(i).getShinsainShuryobi(),
                    selectedShinsainKoseiData.get(i).getGogitaichoKbn(),
                    selectedShinsainKoseiData.get(i).getShukketsuKbn()
            ));
        }
        return shinsainIchiranData;
    }
}
