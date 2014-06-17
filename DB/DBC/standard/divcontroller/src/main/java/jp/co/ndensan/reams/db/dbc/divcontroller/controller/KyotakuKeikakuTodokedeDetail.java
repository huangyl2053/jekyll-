/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000.KyotakuKeikakuTodokedeDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000.KyotakuKeikakuTodokedeHenkoNaiyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000.KyotakuKeikakuTodokedeJigyoshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000.KyotakuKeikakuTodokedeMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000.KyotakuKeikakuTodokedeRirekiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000.KyotakuKeikakuTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000.dgKyotakuKeikakuTodokedeRirekiList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * 居宅サービス計画作成依頼届出をコントロールするクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyotakuKeikakuTodokedeDetail {

    private List<HashMap> getYaml() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc0100000/KyotakuKeikakuTodokedeDetail.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel 居宅サービス計画作成依頼届出
     * @return ResponseData
     */
    public ResponseData onLoad(KyotakuKeikakuTodokedeDetailDiv panel) {
        ResponseData<KyotakuKeikakuTodokedeDetailDiv> response = new ResponseData<>();
        setRirekiList(panel);
        setMeisaiDefaultData(panel);
        response.data = panel;
        return response;
    }

    private enum 画面表示 {

        初期表示,
        新規届出,
        変更届出,
        届出内容修正
    }

    private enum 修正削除 {

        修正,
        削除
    }

    /**
     * 履歴一覧のデータ設定
     */
    private void setRirekiList(KyotakuKeikakuTodokedeDetailDiv panel) {
        Button btn = new Button();
        for (int i = 0; i < 2; i++) {
            ControlGenerator cg = new ControlGenerator(getYaml().get(i));
            add履歴(panel, create履歴(
                    btn,
                    cg.getAsRString("状態"),
                    cg.getAsRString("計画適用期間開始日"),
                    cg.getAsRString("計画適用期間終了日"),
                    cg.getAsRString("届出日"),
                    cg.getAsRString("届出区分"),
                    cg.getAsRString("計画依頼事業者")));
        }
    }

//    /**
//     * 履歴一覧の適用開始日を降順でソートするためのクラス。
//     */
//    private static class DateComparator implements Comparator<dgKyotakuKeikakuTodokedeRirekiList_Row> {
//
//        @Override
//        public int compare(dgKyotakuKeikakuTodokedeRirekiList_Row o1, dgKyotakuKeikakuTodokedeRirekiList_Row o2) {
//            return o2.getTxtKeikakuTekiyoKaishiYMDInvisible().getValue().compareTo(o1.getTxtKeikakuTekiyoKaishiYMDInvisible().getValue());
//        }
//    }
    private static class DateComparator implements Comparator<dgKyotakuKeikakuTodokedeRirekiList_Row> {

        @Override
        public int compare(dgKyotakuKeikakuTodokedeRirekiList_Row o1, dgKyotakuKeikakuTodokedeRirekiList_Row o2) {
            return new FlexibleDate(o2.getTxtKeikakuTekiyoKaishiYMD().replace(".", "")).compareTo(new FlexibleDate(o1.getTxtKeikakuTekiyoKaishiYMD().replace(".", "")));
        }
    }

    private void add履歴(KyotakuKeikakuTodokedeDetailDiv panel, dgKyotakuKeikakuTodokedeRirekiList_Row addRow) {
        KyotakuKeikakuTodokedeRirekiListDiv rirekiList = panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().
                getTplKyotakuKeikakuTodokedeDetailRireki().getKyotakuKeikakuTodokedeRirekiList();
        List<dgKyotakuKeikakuTodokedeRirekiList_Row> dgList = rirekiList.getDgKyotakuKeikakuTodokedeRirekiList().getDataSource();
        dgList.add(addRow);
        Collections.sort(dgList, new DateComparator());
        rirekiList.getDgKyotakuKeikakuTodokedeRirekiList().setDataSource(dgList);
    }

    private void modify履歴(KyotakuKeikakuTodokedeDetailDiv panel, int index, 修正削除 kubun) {
        KyotakuKeikakuTodokedeRirekiListDiv rirekiList = panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().
                getTplKyotakuKeikakuTodokedeDetailRireki().getKyotakuKeikakuTodokedeRirekiList();
        List<dgKyotakuKeikakuTodokedeRirekiList_Row> dgList = rirekiList.getDgKyotakuKeikakuTodokedeRirekiList().getDataSource();
        dgKyotakuKeikakuTodokedeRirekiList_Row currentRow = dgList.get(index);

        dgKyotakuKeikakuTodokedeRirekiList_Row newRow = create履歴(
                currentRow.getBtnSelect(),
                new RString(kubun.toString()),
                currentRow.getTxtKeikakuTekiyoKaishiYMD(),
                currentRow.getTxtKeikakuTekiyoShuryoYMD(),
                currentRow.getTxtTodokedeYMD(),
                currentRow.getTxtTodokedeKubun(),
                currentRow.getTxtKeikakuIraiJigyosha());
        dgList.remove(index);
        dgList.add(index, newRow);
        Collections.sort(dgList, new DateComparator());

        rirekiList.getDgKyotakuKeikakuTodokedeRirekiList().setDataSource(dgList);
    }

    private dgKyotakuKeikakuTodokedeRirekiList_Row create履歴(
            Button btn,
            RString txtJotai,
            RString txtKeikakuTekiyoKaishiYMD,
            RString txtKeikakuTekiyoShuryoYMD,
            RString txtTodokedeYMD,
            RString txtTodokedeKubun,
            RString txtKeikakuIraiJigyosha) {
        return new dgKyotakuKeikakuTodokedeRirekiList_Row(
                btn,
                txtJotai,
                txtKeikakuTekiyoKaishiYMD,
                txtKeikakuTekiyoShuryoYMD,
                txtTodokedeYMD,
                txtTodokedeKubun,
                txtKeikakuIraiJigyosha);
    }

    /**
     * 計画届出明細(初期表示)のデータ設定
     *
     * @param panel panel
     */
    private void setMeisaiDefaultData(KyotakuKeikakuTodokedeDetailDiv panel) {
        showMeisai(panel, 画面表示.初期表示);
        setMeisaiData(panel, 画面表示.初期表示);
    }

    /**
     * 新規届出を追加するボタン押下時の処理
     *
     * @param panel panel
     * @return KyotakuKeikakuTodokedeDetailDiv
     */
    public ResponseData onClickTodokedeNew(KyotakuKeikakuTodokedeDetailDiv panel) {
        ResponseData<KyotakuKeikakuTodokedeDetailDiv> response = new ResponseData<>();
        showMeisai(panel, 画面表示.新規届出);
        setMeisaiData(panel, 画面表示.新規届出);
        response.data = panel;
        return response;
    }

    /**
     * 変更届出を追加するボタン押下時の処理
     *
     * @param panel panel
     * @return KyotakuKeikakuTodokedeDetailDiv
     */
    public ResponseData onClickTodokedeModify(KyotakuKeikakuTodokedeDetailDiv panel) {
        ResponseData<KyotakuKeikakuTodokedeDetailDiv> response = new ResponseData<>();
        showMeisai(panel, 画面表示.変更届出);
        setMeisaiData(panel, 画面表示.変更届出);
        response.data = panel;
        return response;
    }

    /**
     * 履歴一覧で選択ボタン押下時の処理
     *
     * @param panel panel
     * @return KyotakuKeikakuTodokedeDetailDiv
     */
    public ResponseData onClickTodokedeSelect(KyotakuKeikakuTodokedeDetailDiv panel) {
        ResponseData<KyotakuKeikakuTodokedeDetailDiv> response = new ResponseData<>();
        showMeisai(panel, 画面表示.届出内容修正);
        setMeisaiData(panel, 画面表示.届出内容修正);
        int selectRowindex = panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().getTplKyotakuKeikakuTodokedeDetailRireki().
                getKyotakuKeikakuTodokedeRirekiList().getDgKyotakuKeikakuTodokedeRirekiList().getActiveRowId();
        RString index = new RString(String.valueOf(selectRowindex));
        panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().getTplKyotakuKeikakuTodokedeDetailRireki().
                getKyotakuKeikakuTodokedeMeisai().getTxtRirekiListSelectIndex().setValue(index);

        response.data = panel;
        return response;
    }

    /**
     * 届出明細を削除するボタン押下時の処理
     *
     * @param panel panel
     * @return KyotakuKeikakuTodokedeDetailDiv
     */
    public ResponseData onClickTodokedeDelete(KyotakuKeikakuTodokedeDetailDiv panel) {
        ResponseData<KyotakuKeikakuTodokedeDetailDiv> response = new ResponseData<>();
        int index = Integer.valueOf(panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().
                getTplKyotakuKeikakuTodokedeDetailRireki().getKyotakuKeikakuTodokedeMeisai().getTxtRirekiListSelectIndex().getValue().toString());
        modify履歴(panel, index, 修正削除.削除);
        response.data = panel;
        return response;
    }

    /**
     * 届出明細をクリアするボタン押下時の処理
     *
     * @param panel panel
     * @return KyotakuKeikakuTodokedeDetailDiv
     */
    public ResponseData onClickTodokedeClear(KyotakuKeikakuTodokedeDetailDiv panel) {
        ResponseData<KyotakuKeikakuTodokedeDetailDiv> response = new ResponseData<>();
        initMeisai(panel);
        response.data = panel;
        return response;
    }

    /**
     * 届出明細を確定するボタン押下時の処理
     *
     * @param panel panel
     * @return KyotakuKeikakuTodokedeDetailDiv
     */
    public ResponseData onClickTodokedeKakutei(KyotakuKeikakuTodokedeDetailDiv panel) {
        ResponseData<KyotakuKeikakuTodokedeDetailDiv> response = new ResponseData<>();
        Button btn = new Button();
        RString kubun = panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().
                getTplKyotakuKeikakuTodokedeDetailRireki().getKyotakuKeikakuTodokedeMeisai().getTxtTodokedeKubun().getValue();
        ControlGenerator cg;
        if (new RString("新規").equals(kubun)) {
            cg = new ControlGenerator(getYaml().get(2));
        } else {
            cg = new ControlGenerator(getYaml().get(3));
        }
        add履歴(panel, create履歴(
                btn,
                cg.getAsRString("状態"),
                cg.getAsRString("計画適用期間開始日"),
                cg.getAsRString("計画適用期間終了日"),
                cg.getAsRString("届出日"),
                kubun,
                cg.getAsRString("計画依頼事業者")));
        response.data = panel;
        return response;
    }

    /**
     * 届出明細を訂正するボタン押下時の処理
     *
     * @param panel panel
     * @return KyotakuKeikakuTodokedeDetailDiv
     */
    public ResponseData onClickTodokedeTeisei(KyotakuKeikakuTodokedeDetailDiv panel) {
        ResponseData<KyotakuKeikakuTodokedeDetailDiv> response = new ResponseData<>();
        int index = Integer.valueOf(panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().
                getTplKyotakuKeikakuTodokedeDetailRireki().getKyotakuKeikakuTodokedeMeisai().getTxtRirekiListSelectIndex().getValue().toString());
        modify履歴(panel, index, 修正削除.修正);

        response.data = panel;
        return response;
    }

    /**
     * 計画作成区分の選択を変更したときに委託先事業者の表示を切り替える。
     *
     * @param panel panel
     * @return KyotakuKeikakuTodokedeDetailDiv
     */
    public ResponseData onChangeRadKeikakuSakuseiKubun(KyotakuKeikakuTodokedeDetailDiv panel) {
        ResponseData<KyotakuKeikakuTodokedeDetailDiv> response = new ResponseData<>();
        KyotakuKeikakuTodokedeJigyoshaDiv jigyosha = panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().
                getTplKyotakuKeikakuTodokedeDetailRireki().getKyotakuKeikakuTodokedeMeisai().getKyotakuKeikakuTodokedeJigyosha();
        RadioButton rad = jigyosha.getRadKeikakuSakuseiKubun();
        if (rad.getSelectedItem().equals(new RString("key0"))) {
            jigyosha.getTxtItakuJigyoshaCode().setVisible(false);
            jigyosha.getTxtItakuJigyoshaCode().setDisplayNone(true);
            jigyosha.getBtnItakuJigyosha().setVisible(false);
            jigyosha.getBtnItakuJigyosha().setDisplayNone(true);
            jigyosha.getTxtItakuJigyoshaName().setVisible(false);
            jigyosha.getTxtItakuJigyoshaName().setDisplayNone(true);
        } else {
            jigyosha.getTxtItakuJigyoshaCode().setVisible(true);
            jigyosha.getTxtItakuJigyoshaCode().setDisplayNone(false);
            jigyosha.getBtnItakuJigyosha().setVisible(true);
            jigyosha.getBtnItakuJigyosha().setDisplayNone(false);
            jigyosha.getTxtItakuJigyoshaName().setVisible(true);
            jigyosha.getTxtItakuJigyoshaName().setDisplayNone(false);
        }
        response.data = panel;
        return response;
    }

    /**
     * ボタン表示の有効化処理
     *
     */
    private void btnVisible(Button btn) {
        btn.setVisible(true);
        btn.setDisplayNone(false);
    }

    /**
     * ボタン表示の無効化処理
     *
     */
    private void btnInvisible(Button btn) {
        btn.setVisible(false);
        btn.setDisplayNone(true);
    }

    /**
     * 計画届出明細の表示設定
     *
     * @param panel panel
     * @param pattern pattern
     */
    private void showMeisai(KyotakuKeikakuTodokedeDetailDiv panel, 画面表示 pattern) {

        KyotakuKeikakuTodokedeMeisaiDiv meisai = panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().
                getTplKyotakuKeikakuTodokedeDetailRireki().getKyotakuKeikakuTodokedeMeisai();
        DataGrid<dgKyotakuKeikakuTodokedeRirekiList_Row> rirekiList = panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().
                getTplKyotakuKeikakuTodokedeDetailRireki().getKyotakuKeikakuTodokedeRirekiList().getDgKyotakuKeikakuTodokedeRirekiList();
        dgKyotakuKeikakuTodokedeRirekiList_Row selectRow = rirekiList.getClickedItem();

        KyotakuKeikakuTodokedeshaDiv todokedesha = meisai.getKyotakuKeikakuTodokedesha();
        KyotakuKeikakuTodokedeJigyoshaDiv jigyosha = meisai.getKyotakuKeikakuTodokedeJigyosha();
        KyotakuKeikakuTodokedeHenkoNaiyoDiv henkoNaiyo = meisai.getKyotakuKeikakuTodokedeHenkoNaiyo();

//        initMeisai(panel);
//        if (pattern.equals(画面表示.初期表示)) {
//            meisai.getTxtTodokedeKubun().clearValue();
//        } else
        if (pattern.equals(画面表示.新規届出)) {
            btnVisible(meisai.getBtnTodokedeKakutei());
            btnVisible(meisai.getBtnTodokedeClear());
            btnInvisible(meisai.getBtnTodokedeDelete());
            btnInvisible(meisai.getBtnTodokedeTeisei());
            henkoNaiyo.setVisible(false);
            henkoNaiyo.setDisplayNone(true);
        } else if (pattern.equals(画面表示.変更届出)) {
            btnVisible(meisai.getBtnTodokedeKakutei());
            btnVisible(meisai.getBtnTodokedeClear());
            btnInvisible(meisai.getBtnTodokedeDelete());
            btnInvisible(meisai.getBtnTodokedeTeisei());
            henkoNaiyo.setVisible(true);
            henkoNaiyo.setDisplayNone(false);
        } else if (pattern.equals(画面表示.届出内容修正)) {
            btnInvisible(meisai.getBtnTodokedeKakutei());
            btnInvisible(meisai.getBtnTodokedeClear());
            btnVisible(meisai.getBtnTodokedeDelete());
            btnVisible(meisai.getBtnTodokedeTeisei());
            if (selectRow.getTxtTodokedeKubun().equals(new RString("新規"))) {
                henkoNaiyo.setVisible(false);
                henkoNaiyo.setDisplayNone(true);
            } else {
                henkoNaiyo.setVisible(true);
                henkoNaiyo.setDisplayNone(false);
            }
        }

        if (pattern.equals(画面表示.新規届出)
                || pattern.equals(画面表示.変更届出)
                || pattern.equals(画面表示.届出内容修正)) {

//            todokedesha.getTxtTodokedeshaName().setValue(new RString("電算　太郎"));
//            todokedesha.getTxtTodokedeshaKana().setValue(new RString("ﾃﾞﾝｻﾝ ﾀﾛｳ"));
//            todokedesha.getTxtTodokedeshaTelNo().setValue(new RString("123-456-7890"));
//            todokedesha.getTxtTodokedeshaYubinNo().setValue(new YubinNo("381-0001"));
//            todokedesha.getTxtTodokedeshaJusho().setValue(new RString("長野市七瀬中町1111-11"));
//
//            jigyosha.getRadKeikakuSakuseiKubun().setSelectedItem(new RString("key0"));
            jigyosha.getTxtItakuJigyoshaCode().setVisible(false);
            jigyosha.getTxtItakuJigyoshaCode().setDisplayNone(true);
            jigyosha.getBtnItakuJigyosha().setVisible(false);
            jigyosha.getBtnItakuJigyosha().setDisplayNone(true);
            jigyosha.getTxtItakuJigyoshaName().setVisible(false);
            jigyosha.getTxtItakuJigyoshaName().setDisplayNone(true);
//            jigyosha.getTxtServiceShurui1().setValue(new RString("居宅介護"));
//            jigyosha.getTxtServiceShurui2().setValue(new RString("小規模介護"));

//            if (pattern.equals(画面表示.新規届出)) {
//                meisai.getTxtTodokedeYMD().setValue(new RDate("20140601"));
//                meisai.getTxtTekiyoKikan().setFromValue(new RDate("20140601"));
//
//                jigyosha.getTxtJigyoshaCode().setValue(new RString("1111111111"));
//                jigyosha.getTxtJigyoshaName().setValue(new RString("電算介護調査センター"));
//                jigyosha.getTxtJigyoshaYubinNo().setValue(new YubinNo("381-0001"));
//                jigyosha.getTxtJigyoshaJusho().setValue(new RString("長野市緑町３丁目14-15"));
//                jigyosha.getTxtKanrishaName().setValue(new RString("電算　次郎"));
//                jigyosha.getTxtJigyoshaTelNo().setValue(new RString("123-456-7899"));
//                jigyosha.getTxtItakuJigyoshaCode().setValue(new RString("7777777777"));
//                jigyosha.getTxtItakuJigyoshaName().setValue(new RString("電算介護サービスセンター"));
//            } else if (pattern.equals(画面表示.変更届出)) {
//                meisai.getTxtTodokedeYMD().setValue(new RDate("20140701"));
//                meisai.getTxtTekiyoKikan().setFromValue(new RDate("20140701"));
//
//                jigyosha.getTxtJigyoshaCode().setValue(new RString("3333333333"));
//                jigyosha.getTxtJigyoshaName().setValue(new RString("県町介護調査センター"));
//                jigyosha.getTxtJigyoshaYubinNo().setValue(new YubinNo("381-0028"));
//                jigyosha.getTxtJigyoshaJusho().setValue(new RString("長野市県町15-3"));
//                jigyosha.getTxtKanrishaName().setValue(new RString("県町　太郎"));
//                jigyosha.getTxtJigyoshaTelNo().setValue(new RString("123-456-8888"));
//                jigyosha.getTxtItakuJigyoshaCode().setValue(new RString("8888888888"));
//                jigyosha.getTxtItakuJigyoshaName().setValue(new RString("県町介護サービスセンター"));
//            } else if (pattern.equals(画面表示.届出内容修正)) {
//                meisai.getTxtTodokedeYMD().setValue(new RDate("20130601"));
//                meisai.getTxtTekiyoKikan().setFromValue(new RDate("20130601"));
//                meisai.getTxtTekiyoKikan().setToValue(new RDate("20140531"));
//
//                jigyosha.getTxtJigyoshaCode().setValue(new RString("2222222222"));
//                jigyosha.getTxtJigyoshaName().setValue(new RString("新町介護調査センター"));
//                jigyosha.getTxtJigyoshaYubinNo().setValue(new YubinNo("391-0012"));
//                jigyosha.getTxtJigyoshaJusho().setValue(new RString("長野市新町大字乙1-7"));
//                jigyosha.getTxtKanrishaName().setValue(new RString("新町　太郎"));
//                jigyosha.getTxtJigyoshaTelNo().setValue(new RString("123-498-9999"));
//                jigyosha.getTxtItakuJigyoshaCode().setValue(new RString("9999999999"));
//                jigyosha.getTxtItakuJigyoshaName().setValue(new RString("新町介護サービスセンター"));
//            }
        }

    }

    /**
     * 計画届出明細のデータ設定
     *
     * @param panel panel
     * @param pattern pattern
     */
    private void setMeisaiData(KyotakuKeikakuTodokedeDetailDiv panel, 画面表示 pattern) {

        KyotakuKeikakuTodokedeMeisaiDiv meisai = panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().
                getTplKyotakuKeikakuTodokedeDetailRireki().getKyotakuKeikakuTodokedeMeisai();
        DataGrid<dgKyotakuKeikakuTodokedeRirekiList_Row> rirekiList = panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().
                getTplKyotakuKeikakuTodokedeDetailRireki().getKyotakuKeikakuTodokedeRirekiList().getDgKyotakuKeikakuTodokedeRirekiList();
        dgKyotakuKeikakuTodokedeRirekiList_Row selectRow = rirekiList.getClickedItem();

        KyotakuKeikakuTodokedeshaDiv todokedesha = meisai.getKyotakuKeikakuTodokedesha();
        KyotakuKeikakuTodokedeJigyoshaDiv jigyosha = meisai.getKyotakuKeikakuTodokedeJigyosha();
        KyotakuKeikakuTodokedeHenkoNaiyoDiv henkoNaiyo = meisai.getKyotakuKeikakuTodokedeHenkoNaiyo();

        initMeisai(panel);
        if (pattern.equals(画面表示.初期表示)) {
            meisai.getTxtTodokedeKubun().clearValue();
        } else if (pattern.equals(画面表示.新規届出)) {
//            btnVisible(meisai.getBtnTodokedeKakutei());
//            btnVisible(meisai.getBtnTodokedeClear());
//            btnInvisible(meisai.getBtnTodokedeDelete());
//            btnInvisible(meisai.getBtnTodokedeTeisei());
//            henkoNaiyo.setVisible(false);
//            henkoNaiyo.setDisplayNone(true);
            meisai.getTxtTodokedeKubun().setValue(new RString("新規"));
        } else if (pattern.equals(画面表示.変更届出)) {
//            btnVisible(meisai.getBtnTodokedeKakutei());
//            btnVisible(meisai.getBtnTodokedeClear());
//            btnInvisible(meisai.getBtnTodokedeDelete());
//            btnInvisible(meisai.getBtnTodokedeTeisei());
//            henkoNaiyo.setVisible(true);
//            henkoNaiyo.setDisplayNone(false);
            meisai.getTxtTodokedeKubun().setValue(new RString("変更"));
            henkoNaiyo.getTxtHenkoYMD().setValue(new RDate("20140701"));
            henkoNaiyo.getTxtHenkoJiyu().setValue(new RString("介護者の希望により変更する。"));
        } else if (pattern.equals(画面表示.届出内容修正)) {
//            btnInvisible(meisai.getBtnTodokedeKakutei());
//            btnInvisible(meisai.getBtnTodokedeClear());
//            btnVisible(meisai.getBtnTodokedeDelete());
//            btnVisible(meisai.getBtnTodokedeTeisei());
            meisai.getTxtTodokedeKubun().setValue(selectRow.getTxtTodokedeKubun());
            if (!selectRow.getTxtTodokedeKubun().equals(new RString("新規"))) {
//                henkoNaiyo.setVisible(false);
//                henkoNaiyo.setDisplayNone(true);
//            } else {
//                henkoNaiyo.setVisible(true);
//                henkoNaiyo.setDisplayNone(false);
                henkoNaiyo.getTxtHenkoYMD().setValue(new RDate("20140701"));
                henkoNaiyo.getTxtHenkoJiyu().setValue(new RString("介護者の希望により変更する。"));
            }
        }

        if (pattern.equals(画面表示.新規届出)
                || pattern.equals(画面表示.変更届出)
                || pattern.equals(画面表示.届出内容修正)) {

            todokedesha.getTxtTodokedeshaName().setValue(new RString("電算　太郎"));
            todokedesha.getTxtTodokedeshaKana().setValue(new RString("ﾃﾞﾝｻﾝ ﾀﾛｳ"));
            todokedesha.getTxtTodokedeshaTelNo().setValue(new RString("123-456-7890"));
            todokedesha.getTxtTodokedeshaYubinNo().setValue(new YubinNo("381-0001"));
            todokedesha.getTxtTodokedeshaJusho().setValue(new RString("長野市七瀬中町1111-11"));

            jigyosha.getRadKeikakuSakuseiKubun().setSelectedItem(new RString("key0"));
//            jigyosha.getTxtItakuJigyoshaCode().setVisible(false);
//            jigyosha.getTxtItakuJigyoshaCode().setDisplayNone(true);
//            jigyosha.getBtnItakuJigyosha().setVisible(false);
//            jigyosha.getBtnItakuJigyosha().setDisplayNone(true);
//            jigyosha.getTxtItakuJigyoshaName().setVisible(false);
//            jigyosha.getTxtItakuJigyoshaName().setDisplayNone(true);
            jigyosha.getTxtServiceShurui1().setValue(new RString("居宅介護"));
            jigyosha.getTxtServiceShurui2().setValue(new RString("小規模介護"));

            if (pattern.equals(画面表示.新規届出)) {
                meisai.getTxtTodokedeYMD().setValue(new RDate("20140601"));
                meisai.getTxtTekiyoKikan().setFromValue(new RDate("20140601"));

                jigyosha.getTxtJigyoshaCode().setValue(new RString("1111111111"));
                jigyosha.getTxtJigyoshaName().setValue(new RString("電算介護調査センター"));
                jigyosha.getTxtJigyoshaYubinNo().setValue(new YubinNo("381-0001"));
                jigyosha.getTxtJigyoshaJusho().setValue(new RString("長野市緑町３丁目14-15"));
                jigyosha.getTxtKanrishaName().setValue(new RString("電算　次郎"));
                jigyosha.getTxtJigyoshaTelNo().setValue(new RString("123-456-7899"));
                jigyosha.getTxtItakuJigyoshaCode().setValue(new RString("7777777777"));
                jigyosha.getTxtItakuJigyoshaName().setValue(new RString("電算介護サービスセンター"));
            } else if (pattern.equals(画面表示.変更届出)) {
                meisai.getTxtTodokedeYMD().setValue(new RDate("20140701"));
                meisai.getTxtTekiyoKikan().setFromValue(new RDate("20140701"));

                jigyosha.getTxtJigyoshaCode().setValue(new RString("3333333333"));
                jigyosha.getTxtJigyoshaName().setValue(new RString("県町介護調査センター"));
                jigyosha.getTxtJigyoshaYubinNo().setValue(new YubinNo("381-0028"));
                jigyosha.getTxtJigyoshaJusho().setValue(new RString("長野市県町15-3"));
                jigyosha.getTxtKanrishaName().setValue(new RString("県町　太郎"));
                jigyosha.getTxtJigyoshaTelNo().setValue(new RString("123-456-8888"));
                jigyosha.getTxtItakuJigyoshaCode().setValue(new RString("8888888888"));
                jigyosha.getTxtItakuJigyoshaName().setValue(new RString("県町介護サービスセンター"));
            } else if (pattern.equals(画面表示.届出内容修正)) {
                meisai.getTxtTodokedeYMD().setValue(new RDate("20130601"));
                meisai.getTxtTekiyoKikan().setFromValue(new RDate("20130601"));
                meisai.getTxtTekiyoKikan().setToValue(new RDate("20140531"));

                jigyosha.getTxtJigyoshaCode().setValue(new RString("2222222222"));
                jigyosha.getTxtJigyoshaName().setValue(new RString("新町介護調査センター"));
                jigyosha.getTxtJigyoshaYubinNo().setValue(new YubinNo("391-0012"));
                jigyosha.getTxtJigyoshaJusho().setValue(new RString("長野市新町大字乙1-7"));
                jigyosha.getTxtKanrishaName().setValue(new RString("新町　太郎"));
                jigyosha.getTxtJigyoshaTelNo().setValue(new RString("123-498-9999"));
                jigyosha.getTxtItakuJigyoshaCode().setValue(new RString("9999999999"));
                jigyosha.getTxtItakuJigyoshaName().setValue(new RString("新町介護サービスセンター"));
            }
        }
    }

    /**
     * 計画届出明細の内容を初期化する(ただし届出区分については初期化しない)。
     *
     * @param panel panel
     */
    private void initMeisai(KyotakuKeikakuTodokedeDetailDiv panel) {
        KyotakuKeikakuTodokedeMeisaiDiv meisai = panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().
                getTplKyotakuKeikakuTodokedeDetailRireki().getKyotakuKeikakuTodokedeMeisai();

        KyotakuKeikakuTodokedeshaDiv todokedesha = meisai.getKyotakuKeikakuTodokedesha();
        KyotakuKeikakuTodokedeJigyoshaDiv jigyosha = meisai.getKyotakuKeikakuTodokedeJigyosha();
        KyotakuKeikakuTodokedeHenkoNaiyoDiv henkoNaiyo = meisai.getKyotakuKeikakuTodokedeHenkoNaiyo();

        meisai.getTxtTodokedeYMD().clearValue();
        meisai.getTxtTekiyoKikan().clearFromValue();
        meisai.getTxtTekiyoKikan().clearToValue();

        todokedesha.getTxtTodokedeshaName().clearValue();
        todokedesha.getTxtTodokedeshaKana().clearValue();
        todokedesha.getTxtTodokedeshaTelNo().clearValue();
        todokedesha.getTxtTodokedeshaYubinNo().clearValue();
        todokedesha.getTxtTodokedeshaJusho().clearValue();

        jigyosha.getTxtJigyoshaCode().clearValue();
        jigyosha.getTxtJigyoshaName().clearValue();
        jigyosha.getRadKeikakuSakuseiKubun().setSelectedItem(new RString(""));
        jigyosha.getTxtServiceShurui1().clearValue();
        jigyosha.getTxtServiceShurui2().clearValue();
        jigyosha.getTxtJigyoshaYubinNo().clearValue();
        jigyosha.getTxtJigyoshaJusho().clearValue();
        jigyosha.getTxtKanrishaName().clearValue();
        jigyosha.getTxtJigyoshaTelNo().clearValue();
        jigyosha.getTxtItakuJigyoshaCode().clearValue();
        jigyosha.getTxtItakuJigyoshaName().clearValue();

        henkoNaiyo.getTxtHenkoYMD().clearValue();
        henkoNaiyo.getTxtHenkoJiyu().clearValue();
    }
}
