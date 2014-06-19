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
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0110000.KyotakuJikoTodokedeDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0110000.KyotakuJikoTodokedeHenkoNaiyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0110000.KyotakuJikoTodokedeMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0110000.KyotakuJikoTodokedeRirekiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0110000.KyotakuJikoTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0110000.dgKyotakuJikoTodokedeRirekiList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.ura.divcontroller.controller.AtenaShokaiSimple;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 居宅サービス自己作成届出をコントロールするクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyotakuJikoTodokedeDetail {

    private List<HashMap> getYaml() {
        return YamlLoader.DBC.loadAsList(new RString("dbc0100000/KyotakuKeikakuTodokedeDetail.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel 居宅サービス計画作成依頼届出
     * @return ResponseData
     */
    public ResponseData getOnLoadData(KyotakuJikoTodokedeDetailDiv panel) {
        ResponseData<KyotakuJikoTodokedeDetailDiv> response = new ResponseData<>();
        setAtenaData(panel);
        setKihonData(panel);
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

    private void setAtenaData(KyotakuJikoTodokedeDetailDiv panel) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(0));
        AtenaShokaiSimple.setData(panel.getKyotakuJikoTodokedeKihon().getKyotakuJikoTodokedeKihonAtena().getAtenaInfo(),
                new ShikibetsuCode(cg.getAsRString("識別コード")));
    }

    private void setKihonData(KyotakuJikoTodokedeDetailDiv panel) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(1));
        KaigoShikakuKihonDiv kihon = panel.getKyotakuJikoTodokedeKihon().getKyotakuJikoTodokedeKaigoKihon();
        kihon.getTxtHihokenshaNo().setValue(cg.getAsRString("被保番号"));
        kihon.getTxtShikakuJotai().setValue(cg.getAsRString("資格状態"));
        kihon.getTxtShutokuYmd().setValue(cg.getAsRDate("取得日"));
        kihon.getTxtSoshitsuYmd().setValue(cg.getAsRDate("喪失日"));
        kihon.getTxtShutokuJiyu().setValue(cg.getAsRString("取得事由"));
        kihon.getTxtSoshitsuJiyu().setValue(cg.getAsRString("喪失事由"));
        kihon.getTxtJutokuTekiyo().setValue(cg.getAsRDate("住特開始"));
        kihon.getTxtJutokuKaijo().setValue(cg.getAsRDate("住特終了"));
        kihon.getTxtYokaigoJotaiKubun().setValue(cg.getAsRString("要介護度"));
        kihon.getTxtNinteiKikan().setFromValue(cg.getAsRDate("認定開始日"));
        kihon.getTxtNinteiKikan().setToValue(cg.getAsRDate("認定終了日"));
        kihon.getTxtKyuSochiNyusho().setValue(cg.getAsRString("旧措置入所"));
    }

    /**
     * 履歴一覧のデータ設定
     */
    private void setRirekiList(KyotakuJikoTodokedeDetailDiv panel) {
        Button btn = new Button();
        for (int i = 3; i < 5; i++) {
            ControlGenerator cg = new ControlGenerator(getYaml().get(i));
            add履歴(panel, create履歴(
                    btn,
                    cg.getAsRString("状態"),
                    cg.getAsRString("計画適用期間開始日"),
                    cg.getAsRString("計画適用期間終了日"),
                    cg.getAsRString("届出日"),
                    cg.getAsRString("届出区分")));
        }
    }

    /**
     * 履歴一覧の適用開始日を降順でソートするためのクラス。
     */
    private static class DateComparator implements Comparator<dgKyotakuJikoTodokedeRirekiList_Row> {

        @Override
        public int compare(dgKyotakuJikoTodokedeRirekiList_Row o1, dgKyotakuJikoTodokedeRirekiList_Row o2) {
            return new FlexibleDate(o2.getTxtKeikakuTekiyoKaishiYMD().replace(".", "")).
                    compareTo(new FlexibleDate(o1.getTxtKeikakuTekiyoKaishiYMD().replace(".", "")));
        }
    }

    private void add履歴(KyotakuJikoTodokedeDetailDiv panel, dgKyotakuJikoTodokedeRirekiList_Row addRow) {
        KyotakuJikoTodokedeRirekiListDiv rirekiList = panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getTplKyotakuJikoTodokedeDetailRireki().getKyotakuJikoTodokedeRirekiList();
        List<dgKyotakuJikoTodokedeRirekiList_Row> dgList = rirekiList.getDgKyotakuJikoTodokedeRirekiList().getDataSource();
        dgList.add(addRow);
        Collections.sort(dgList, new DateComparator());
        rirekiList.getDgKyotakuJikoTodokedeRirekiList().setDataSource(dgList);
    }

    private void modify履歴(KyotakuJikoTodokedeDetailDiv panel, int index, 修正削除 kubun) {
        KyotakuJikoTodokedeRirekiListDiv rirekiList = panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getTplKyotakuJikoTodokedeDetailRireki().getKyotakuJikoTodokedeRirekiList();
        List<dgKyotakuJikoTodokedeRirekiList_Row> dgList = rirekiList.getDgKyotakuJikoTodokedeRirekiList().getDataSource();
        dgKyotakuJikoTodokedeRirekiList_Row currentRow = dgList.get(index);

        dgKyotakuJikoTodokedeRirekiList_Row newRow = create履歴(
                currentRow.getBtnSelect(),
                new RString(kubun.toString()),
                currentRow.getTxtKeikakuTekiyoKaishiYMD(),
                currentRow.getTxtKeikakuTekiyoShuryoYMD(),
                currentRow.getTxtTodokedeYMD(),
                currentRow.getTxtTodokedeKubun());
        dgList.remove(index);
        dgList.add(index, newRow);
        Collections.sort(dgList, new DateComparator());

        rirekiList.getDgKyotakuJikoTodokedeRirekiList().setDataSource(dgList);
    }

    private dgKyotakuJikoTodokedeRirekiList_Row create履歴(
            Button btn,
            RString txtJotai,
            RString txtKeikakuTekiyoKaishiYMD,
            RString txtKeikakuTekiyoShuryoYMD,
            RString txtTodokedeYMD,
            RString txtTodokedeKubun) {
        return new dgKyotakuJikoTodokedeRirekiList_Row(
                btn,
                txtJotai,
                txtKeikakuTekiyoKaishiYMD,
                txtKeikakuTekiyoShuryoYMD,
                txtTodokedeYMD,
                txtTodokedeKubun);
    }

    /**
     * 計画届出明細(初期表示)のデータ設定
     *
     * @param panel panel
     */
    private void setMeisaiDefaultData(KyotakuJikoTodokedeDetailDiv panel) {
        setMeisaiData(panel, 画面表示.初期表示);
        showMeisai(panel, 画面表示.初期表示);
    }

    /**
     * 新規届出を追加するボタン押下時の処理
     *
     * @param panel panel
     * @return KyotakuJikoTodokedeDetailDiv
     */
    public ResponseData onClickTodokedeNew(KyotakuJikoTodokedeDetailDiv panel) {
        ResponseData<KyotakuJikoTodokedeDetailDiv> response = new ResponseData<>();
        setMeisaiData(panel, 画面表示.新規届出);
        showMeisai(panel, 画面表示.新規届出);
        response.data = panel;
        return response;
    }

    /**
     * 変更届出を追加するボタン押下時の処理
     *
     * @param panel panel
     * @return KyotakuJikoTodokedeDetailDiv
     */
    public ResponseData onClickTodokedeModify(KyotakuJikoTodokedeDetailDiv panel) {
        ResponseData<KyotakuJikoTodokedeDetailDiv> response = new ResponseData<>();
        setMeisaiData(panel, 画面表示.変更届出);
        showMeisai(panel, 画面表示.変更届出);
        response.data = panel;
        return response;
    }

    /**
     * 履歴一覧で選択ボタン押下時の処理
     *
     * @param panel panel
     * @return KyotakuJikoTodokedeDetailDiv
     */
    public ResponseData onClickTodokedeSelect(KyotakuJikoTodokedeDetailDiv panel) {
        ResponseData<KyotakuJikoTodokedeDetailDiv> response = new ResponseData<>();
        setMeisaiData(panel, 画面表示.届出内容修正);
        showMeisai(panel, 画面表示.届出内容修正);
        int selectRowindex = panel.getTabKyotakuServiceJikoSakuseiTodokede().getTplKyotakuJikoTodokedeDetailRireki().
                getKyotakuJikoTodokedeRirekiList().getDgKyotakuJikoTodokedeRirekiList().getActiveRowId();
        RString index = new RString(String.valueOf(selectRowindex));
        panel.getTabKyotakuServiceJikoSakuseiTodokede().getTplKyotakuJikoTodokedeDetailRireki().
                getKyotakuJikoTodokedeMeisai().getTxtRirekiListSelectIndex().setValue(index);

        response.data = panel;
        return response;
    }

    /**
     * 届出明細を削除するボタン押下時の処理
     *
     * @param panel panel
     * @return KyotakuJikoTodokedeDetailDiv
     */
    public ResponseData onClickTodokedeDelete(KyotakuJikoTodokedeDetailDiv panel) {
        ResponseData<KyotakuJikoTodokedeDetailDiv> response = new ResponseData<>();
        KyotakuJikoTodokedeMeisaiDiv meisai = panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getTplKyotakuJikoTodokedeDetailRireki().getKyotakuJikoTodokedeMeisai();
        int index = Integer.valueOf(meisai.getTxtRirekiListSelectIndex().getValue().toString());
        modify履歴(panel, index, 修正削除.削除);

        meisai.getTxtTodokedeKubun().clearValue();
        initMeisai(panel);
        response.data = panel;
        return response;
    }

    /**
     * 届出明細をクリアするボタン押下時の処理
     *
     * @param panel panel
     * @return KyotakuJikoTodokedeDetailDiv
     */
    public ResponseData onClickTodokedeClear(KyotakuJikoTodokedeDetailDiv panel) {
        ResponseData<KyotakuJikoTodokedeDetailDiv> response = new ResponseData<>();
        initMeisai(panel);
        response.data = panel;
        return response;
    }

    /**
     * 届出明細を確定するボタン押下時の処理
     *
     * @param panel panel
     * @return KyotakuJikoTodokedeDetailDiv
     */
    public ResponseData onClickTodokedeKakutei(KyotakuJikoTodokedeDetailDiv panel) {
        ResponseData<KyotakuJikoTodokedeDetailDiv> response = new ResponseData<>();
        Button btn = new Button();
        KyotakuJikoTodokedeMeisaiDiv meisai = panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getTplKyotakuJikoTodokedeDetailRireki().getKyotakuJikoTodokedeMeisai();
        RString kubun = meisai.getTxtTodokedeKubun().getValue();
        ControlGenerator cg;
        if (new RString("新規").equals(kubun)) {
            cg = new ControlGenerator(getYaml().get(5));
        } else {
            cg = new ControlGenerator(getYaml().get(6));
        }
        add履歴(panel, create履歴(
                btn,
                cg.getAsRString("状態"),
                cg.getAsRString("計画適用期間開始日"),
                cg.getAsRString("計画適用期間終了日"),
                cg.getAsRString("届出日"),
                kubun));

        meisai.getTxtTodokedeKubun().clearValue();
        initMeisai(panel);
        response.data = panel;
        return response;
    }

    /**
     * 届出明細を訂正するボタン押下時の処理
     *
     * @param panel panel
     * @return KyotakuJikoTodokedeDetailDiv
     */
    public ResponseData onClickTodokedeTeisei(KyotakuJikoTodokedeDetailDiv panel) {
        ResponseData<KyotakuJikoTodokedeDetailDiv> response = new ResponseData<>();
        KyotakuJikoTodokedeMeisaiDiv meisai = panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getTplKyotakuJikoTodokedeDetailRireki().getKyotakuJikoTodokedeMeisai();
        int index = Integer.valueOf(meisai.getTxtRirekiListSelectIndex().getValue().toString());
        modify履歴(panel, index, 修正削除.修正);

        meisai.getTxtTodokedeKubun().clearValue();
        initMeisai(panel);
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
    private void showMeisai(KyotakuJikoTodokedeDetailDiv panel, 画面表示 pattern) {

        KyotakuJikoTodokedeMeisaiDiv meisai = panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getTplKyotakuJikoTodokedeDetailRireki().getKyotakuJikoTodokedeMeisai();
        DataGrid<dgKyotakuJikoTodokedeRirekiList_Row> rirekiList = panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getTplKyotakuJikoTodokedeDetailRireki().getKyotakuJikoTodokedeRirekiList().getDgKyotakuJikoTodokedeRirekiList();
        dgKyotakuJikoTodokedeRirekiList_Row selectRow = rirekiList.getClickedItem();

        KyotakuJikoTodokedeHenkoNaiyoDiv henkoNaiyo = meisai.getKyotakuJikoTodokedeHenkoNaiyo();

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

    }

    /**
     * 計画届出明細のデータ設定
     *
     * @param panel panel
     * @param pattern pattern
     */
    private void setMeisaiData(KyotakuJikoTodokedeDetailDiv panel, 画面表示 pattern) {

        KyotakuJikoTodokedeMeisaiDiv meisai = panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getTplKyotakuJikoTodokedeDetailRireki().getKyotakuJikoTodokedeMeisai();
        DataGrid<dgKyotakuJikoTodokedeRirekiList_Row> rirekiList = panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getTplKyotakuJikoTodokedeDetailRireki().getKyotakuJikoTodokedeRirekiList().getDgKyotakuJikoTodokedeRirekiList();
        dgKyotakuJikoTodokedeRirekiList_Row selectRow = rirekiList.getClickedItem();

        KyotakuJikoTodokedeshaDiv todokedesha = meisai.getKyotakuJikoTodokedesha();
        KyotakuJikoTodokedeHenkoNaiyoDiv henkoNaiyo = meisai.getKyotakuJikoTodokedeHenkoNaiyo();

        ControlGenerator cg = new ControlGenerator(getYaml().get(7));
        if (pattern.equals(画面表示.初期表示)) {
            meisai.getTxtTodokedeKubun().clearValue();
        } else if (pattern.equals(画面表示.新規届出)) {
            cg = new ControlGenerator(getYaml().get(8));
            meisai.getTxtTodokedeKubun().setValue(cg.getAsRString("届出区分"));
        } else if (pattern.equals(画面表示.変更届出)) {
            cg = new ControlGenerator(getYaml().get(9));
            meisai.getTxtTodokedeKubun().setValue(cg.getAsRString("届出区分"));
        } else if (pattern.equals(画面表示.届出内容修正)) {
            cg = new ControlGenerator(getYaml().get(10));
            meisai.getTxtTodokedeKubun().setValue(selectRow.getTxtTodokedeKubun());
        }

        if (pattern.equals(画面表示.新規届出)
                || pattern.equals(画面表示.変更届出)
                || pattern.equals(画面表示.届出内容修正)) {

            meisai.getTxtTodokedeYMD().setValue(cg.getAsRDate("届出日"));
            meisai.getTxtTekiyoKikan().setFromValue(cg.getAsRDate("適用期間開始日"));
            if (pattern.equals(画面表示.届出内容修正)) {
                meisai.getTxtTekiyoKikan().setToValue(cg.getAsRDate("適用期間終了日"));
            }

            todokedesha.getTxtName().setValue(cg.getAsRString("届出者氏名"));
            todokedesha.getTxtKana().setValue(cg.getAsRString("届出者カナ"));
            todokedesha.getTxtTelNo().setValue(cg.getAsRString("届出者電話番号"));
            todokedesha.getTxtYubinNo().setValue(cg.getAsYubinNo("届出者郵便番号"));
            todokedesha.getTxtJusho().setValue(cg.getAsRString("届出者住所"));

            if (pattern.equals(画面表示.変更届出)
                    || (pattern.equals(画面表示.届出内容修正) && !selectRow.getTxtTodokedeKubun().equals(new RString("新規")))) {
                henkoNaiyo.getTxtHenkoYMD().setValue(cg.getAsRDate("変更日"));
                henkoNaiyo.getTxtHenkoJiyu().setValue(cg.getAsRString("変更事由"));
            }
        }
    }

    /**
     * 計画届出明細の内容を初期化する(ただし届出区分については初期化しない)。
     *
     * @param panel panel
     */
    private void initMeisai(KyotakuJikoTodokedeDetailDiv panel) {
        KyotakuJikoTodokedeMeisaiDiv meisai = panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getTplKyotakuJikoTodokedeDetailRireki().getKyotakuJikoTodokedeMeisai();

        KyotakuJikoTodokedeshaDiv todokedesha = meisai.getKyotakuJikoTodokedesha();
        KyotakuJikoTodokedeHenkoNaiyoDiv henkoNaiyo = meisai.getKyotakuJikoTodokedeHenkoNaiyo();

        meisai.getTxtTodokedeYMD().clearValue();
        meisai.getTxtTekiyoKikan().clearFromValue();
        meisai.getTxtTekiyoKikan().clearToValue();
        meisai.getTxtTaishoYMD().clearValue();
        meisai.getTxtKeikakuSakuseiYMD().clearValue();

        todokedesha.getTxtName().clearValue();
        todokedesha.getTxtKana().clearValue();
        todokedesha.getTxtTelNo().clearValue();
        todokedesha.getTxtYubinNo().clearValue();
        todokedesha.getTxtJusho().clearValue();

        henkoNaiyo.getTxtHenkoYMD().clearValue();
        henkoNaiyo.getTxtHenkoJiyu().clearValue();
    }
}
