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
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0110000.tplKyotakuJikoTodokedeDetailRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishukirokukanri.ShoKaishuKirokuKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishukirokukanri.dgShoKaishuJokyo_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.ura.divcontroller.controller.AtenaShokaiSimple;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

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
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(KyotakuJikoTodokedeDetailDiv panel) {
        ResponseData<KyotakuJikoTodokedeDetailDiv> response = new ResponseData<>();
        setAtenaData(panel);
        setKihonData(panel);
        setRirekiList(panel);
        setMeisaiDefaultData(panel);
        setShoKaishuJokyoListData(panel);
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

    private void setRirekiList(KyotakuJikoTodokedeDetailDiv panel) {
        Button btn = new Button();
        for (int i = 3; i < 5; i++) {
            ControlGenerator cg = new ControlGenerator(getYaml().get(i));
            add履歴(panel, create履歴(
                    btn,
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
        KyotakuJikoTodokedeRirekiListDiv rirekiList = panel.getTabKyotakuServiceJikoSakuseiTodokede()
                .getTplKyotakuJikoTodokedeDetailRireki().getKyotakuJikoTodokedeRirekiList();
        List<dgKyotakuJikoTodokedeRirekiList_Row> dgList = rirekiList.getDgKyotakuJikoTodokedeRirekiList().getDataSource();
        dgList.add(addRow);
        Collections.sort(dgList, new DateComparator());
        rirekiList.getDgKyotakuJikoTodokedeRirekiList().setDataSource(dgList);
    }

    private void modify履歴(KyotakuJikoTodokedeDetailDiv panel, int index, 修正削除 kubun) {
        KyotakuJikoTodokedeRirekiListDiv rirekiList = panel.getTabKyotakuServiceJikoSakuseiTodokede()
                .getTplKyotakuJikoTodokedeDetailRireki().getKyotakuJikoTodokedeRirekiList();
        List<dgKyotakuJikoTodokedeRirekiList_Row> dgList = rirekiList.getDgKyotakuJikoTodokedeRirekiList().getDataSource();
        dgKyotakuJikoTodokedeRirekiList_Row currentRow = dgList.get(index);
        KyotakuJikoTodokedeMeisaiDiv meisai = panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getTplKyotakuJikoTodokedeDetailRireki().getKyotakuJikoTodokedeMeisai();
        dgKyotakuJikoTodokedeRirekiList_Row row;

        RString 計画適用期間開始日;
        RString 計画適用期間終了日;
        RString 届出日;
        try {
            計画適用期間開始日 = new FlexibleDate(meisai.getTxtTekiyoKikan().getFromValue().toDateString()).wareki().toDateString();
        } catch (Throwable e) {
            計画適用期間開始日 = RString.EMPTY;
        }
        try {
            計画適用期間終了日 = new FlexibleDate(meisai.getTxtTekiyoKikan().getToValue().toDateString()).wareki().toDateString();
        } catch (Throwable e) {
            計画適用期間終了日 = RString.EMPTY;
        }
        try {
            届出日 = new FlexibleDate(meisai.getTxtTodokedeYMD().getValue().toDateString()).wareki().toDateString();
        } catch (Throwable e) {
            届出日 = RString.EMPTY;
        }
        row = create履歴(
                currentRow.getBtnSelect(),
                計画適用期間開始日,
                計画適用期間終了日,
                届出日,
                currentRow.getTxtTodokedeKubun());
        if (kubun.equals(修正削除.修正)) {
            row.setRowState(RowState.Modified);
        } else {
            row.setRowState(RowState.Deleted);
        }

        dgList.remove(index);
        dgList.add(index, row);
        Collections.sort(dgList, new DateComparator());

        rirekiList.getDgKyotakuJikoTodokedeRirekiList().setDataSource(dgList);
    }

    private dgKyotakuJikoTodokedeRirekiList_Row create履歴(
            Button btn,
            RString txtKeikakuTekiyoKaishiYMD,
            RString txtKeikakuTekiyoShuryoYMD,
            RString txtTodokedeYMD,
            RString txtTodokedeKubun) {
        return new dgKyotakuJikoTodokedeRirekiList_Row(
                btn,
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
        initMeisai(panel);
        setMeisaiData(panel, 画面表示.初期表示);
        showMeisai(panel, 画面表示.初期表示);
    }

    /**
     * 新規届出を追加するボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickTodokedeNew(KyotakuJikoTodokedeDetailDiv panel) {
        ResponseData<KyotakuJikoTodokedeDetailDiv> response = new ResponseData<>();
        initMeisai(panel);
        setMeisaiData(panel, 画面表示.新規届出);
        showMeisai(panel, 画面表示.新規届出);
        response.data = panel;
        return response;
    }

    /**
     * 変更届出を追加するボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickTodokedeModify(KyotakuJikoTodokedeDetailDiv panel) {
        ResponseData<KyotakuJikoTodokedeDetailDiv> response = new ResponseData<>();
        initMeisai(panel);
        setMeisaiData(panel, 画面表示.変更届出);
        showMeisai(panel, 画面表示.変更届出);
        response.data = panel;
        return response;
    }

    /**
     * 履歴一覧で選択ボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickTodokedeSelect(KyotakuJikoTodokedeDetailDiv panel) {
        ResponseData<KyotakuJikoTodokedeDetailDiv> response = new ResponseData<>();
        int selectRowindex = panel.getTabKyotakuServiceJikoSakuseiTodokede().getTplKyotakuJikoTodokedeDetailRireki().
                getKyotakuJikoTodokedeRirekiList().getDgKyotakuJikoTodokedeRirekiList().getClickedRowId();
        RString index = new RString(String.valueOf(selectRowindex));
        panel.getTabKyotakuServiceJikoSakuseiTodokede().getTplKyotakuJikoTodokedeDetailRireki().
                getKyotakuJikoTodokedeMeisai().getTxtRirekiListSelectIndex().setValue(index);
        setMeisaiData(panel, 画面表示.届出内容修正);
        showMeisai(panel, 画面表示.届出内容修正);
        tplKyotakuJikoTodokedeDetailRirekiDiv div = panel.getTabKyotakuServiceJikoSakuseiTodokede().getTplKyotakuJikoTodokedeDetailRireki();
        div.getKyotakuJikoTodokedeRirekiList().setIsOpen(false);
        div.getKyotakuJikoTodokedeMeisai().setIsOpen(true);

        response.data = panel;
        return response;
    }

    /**
     * 届出明細を削除するボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickTodokedeDelete(KyotakuJikoTodokedeDetailDiv panel) {
        ResponseData<KyotakuJikoTodokedeDetailDiv> response = new ResponseData<>();
        int index = Integer.valueOf(panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getTplKyotakuJikoTodokedeDetailRireki().getKyotakuJikoTodokedeMeisai().getTxtRirekiListSelectIndex().getValue().toString());
        modify履歴(panel, index, 修正削除.削除);
        initMeisai(panel);
        response.data = panel;
        return response;
    }

    /**
     * 届出明細をクリアするボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
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
     * @return ResponseData
     */
    public ResponseData onClickTodokedeKakutei(KyotakuJikoTodokedeDetailDiv panel) {
        ResponseData<KyotakuJikoTodokedeDetailDiv> response = new ResponseData<>();
        Button btn = new Button();
        KyotakuJikoTodokedeMeisaiDiv meisai = panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getTplKyotakuJikoTodokedeDetailRireki().getKyotakuJikoTodokedeMeisai();
        RString kubun = panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getTplKyotakuJikoTodokedeDetailRireki().getKyotakuJikoTodokedeMeisai().getTxtTodokedeKubun().getValue();
        ControlGenerator cg;
        if (new RString("新規").equals(kubun)) {
            cg = new ControlGenerator(getYaml().get(5));
        } else {
            cg = new ControlGenerator(getYaml().get(6));
        }

        RString 計画適用期間開始日;
        RString 計画適用期間終了日;
        RString 届出日;
        try {
            計画適用期間開始日 = new FlexibleDate(meisai.getTxtTekiyoKikan().getFromValue().toDateString()).wareki().toDateString();
        } catch (Throwable e) {
            計画適用期間開始日 = RString.EMPTY;
        }
        try {
            計画適用期間終了日 = new FlexibleDate(meisai.getTxtTekiyoKikan().getToValue().toDateString()).wareki().toDateString();
        } catch (Throwable e) {
            計画適用期間終了日 = RString.EMPTY;
        }
        try {
            届出日 = new FlexibleDate(meisai.getTxtTodokedeYMD().getValue().toDateString()).wareki().toDateString();
        } catch (Throwable e) {
            届出日 = RString.EMPTY;
        }

        dgKyotakuJikoTodokedeRirekiList_Row row = create履歴(
                btn,
                計画適用期間開始日,
                計画適用期間終了日,
                届出日,
                kubun);
        row.setRowState(RowState.Added);
        add履歴(panel, row);

        initMeisai(panel);
        response.data = panel;
        return response;
    }

    /**
     * 届出明細を訂正するボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickTodokedeTeisei(KyotakuJikoTodokedeDetailDiv panel) {
        ResponseData<KyotakuJikoTodokedeDetailDiv> response = new ResponseData<>();
        int index = Integer.valueOf(panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getTplKyotakuJikoTodokedeDetailRireki().getKyotakuJikoTodokedeMeisai().getTxtRirekiListSelectIndex().getValue().toString());
        modify履歴(panel, index, 修正削除.修正);
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

            if (pattern.equals(画面表示.届出内容修正)) {
                try {
                    meisai.getTxtTodokedeYMD().setValue(new RDate(selectRow.getTxtTodokedeYMD().toString()));
                } catch (Throwable e) {
                    meisai.getTxtTodokedeYMD().clearValue();
                }
                try {
                    meisai.getTxtTekiyoKikan().setFromValue(new RDate(selectRow.getTxtKeikakuTekiyoKaishiYMD().toString()));
                } catch (Throwable e) {
                    meisai.getTxtTekiyoKikan().clearFromValue();
                }
                try {
                    meisai.getTxtTekiyoKikan().setToValue(new RDate(selectRow.getTxtKeikakuTekiyoShuryoYMD().toString()));
                } catch (Throwable e) {
                    meisai.getTxtTekiyoKikan().clearToValue();
                }
                meisai.getTxtTaishoYMD().setValue(cg.getAsRDate("対象年月"));
                meisai.getTxtKeikakuSakuseiYMD().setValue(cg.getAsRDate("計画作成日"));
            } else {
                meisai.getTxtTodokedeYMD().setValue(cg.getAsRDate("届出日"));
                meisai.getTxtTekiyoKikan().setFromValue(cg.getAsRDate("適用期間開始日"));
            }

            todokedesha.getTxtTodokedeshaName().setValue(cg.getAsRString("届出者氏名"));
            todokedesha.getTxtTodokedeshaKana().setValue(cg.getAsRString("届出者カナ"));
            todokedesha.getTxtTodokedeshaTelNo().setValue(cg.getAsRString("届出者電話番号"));
            todokedesha.getTxtTodokedeshaYubinNo().setValue(cg.getAsYubinNo("届出者郵便番号"));
            todokedesha.getTxtTodokedeshaJusho().setValue(cg.getAsRString("届出者住所"));

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
        meisai.getTxtTaishoYMD().clearValue();
        meisai.getTxtKeikakuSakuseiYMD().clearValue();
        meisai.getTxtTekiyoKikan().clearFromValue();
        meisai.getTxtTekiyoKikan().clearToValue();

        todokedesha.getTxtTodokedeshaName().clearValue();
        todokedesha.getTxtTodokedeshaKana().clearValue();
        todokedesha.getTxtTodokedeshaTelNo().clearValue();
        todokedesha.getTxtTodokedeshaYubinNo().clearValue();
        todokedesha.getTxtTodokedeshaJusho().clearValue();

        henkoNaiyo.getTxtHenkoYMD().clearValue();
        henkoNaiyo.getTxtHenkoJiyu().clearValue();
    }

    /**
     * 証類交付情報をセットする。
     *
     * @param panel panel
     */
    private void setShoKaishuJokyoListData(KyotakuJikoTodokedeDetailDiv panel) {
        ShoKaishuKirokuKanriDiv kanri = panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getTplKyotakuJikoTodokedeDetailShorui().getKyotakuJikoTodokedeShoruiJyokyo();
        List<HashMap> yamlData = YamlLoader.DBC.loadAsList(new RString("dbc0100000/KyotakuKeikakuTodokedeShoKofuKaishu.yml"));
        List<dgShoKaishuJokyo_Row> dgRow = kanri.getShoKaishuJokyoList().getDgShoKaishuJokyo().getDataSource();
        dgRow.clear();
        for (int i = 0; i < 2; i++) {
            ControlGenerator cg = new ControlGenerator(yamlData.get(i));
            dgShoKaishuJokyo_Row row = new dgShoKaishuJokyo_Row(new Button(), RString.EMPTY, new TextBoxFlexibleDate(),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, new TextBoxFlexibleDate());

            row.setKofushoShurui(cg.getAsRString("証交付種類"));
            row.getKofuDate().setValue(cg.getAsFlexibleDate("交付日"));
            row.setKofuJiyu(cg.getAsRString("交付事由"));
            row.setKofuJiyuKey(cg.getAsRString("交付事由Key"));
            row.getKaishuDate().setValue(cg.getAsFlexibleDate("回収日"));
            row.setKaishuJiyu(cg.getAsRString("回収事由"));
            row.setKaishuJiyuKey(cg.getAsRString("回収事由Key"));
            row.getYukoKigen().setValue(cg.getAsFlexibleDate("有効期限"));
            dgRow.add(row);
        }
//        kanri.getShoKaishuJokyoShosai().setIsOpen(false);
    }
}
