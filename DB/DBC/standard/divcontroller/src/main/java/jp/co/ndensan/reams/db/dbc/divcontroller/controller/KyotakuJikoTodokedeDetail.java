/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuJikoTodokedeDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuJikoTodokedeHenkoNaiyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuJikoTodokedeMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuJikoTodokedeRirekiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuJikoTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgRirekiList_Row;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * 居宅サービス自己作成届出をコントロールするクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyotakuJikoTodokedeDetail {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel 居宅サービス計画作成依頼届出
     * @return ResponseData
     */
    public ResponseData getOnLoadData(KyotakuJikoTodokedeDetailDiv panel) {
        ResponseData<KyotakuJikoTodokedeDetailDiv> response = new ResponseData<>();
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
    private void setRirekiList(KyotakuJikoTodokedeDetailDiv panel) {
        Button btn = new Button();
        add履歴(panel, create履歴(btn, "", "20130601", "平25.06.01", "平26.05.31", "平25.06.01", "変更"));
        add履歴(panel, create履歴(btn, "", "20120601", "平24.06.01", "平25.05.31", "平24.06.01", "新規"));
    }

    /**
     * 履歴一覧の適用開始日を降順でソートするためのクラス。
     */
    private static class DateComparator implements Comparator<dgRirekiList_Row> {

        @Override
        public int compare(dgRirekiList_Row o1, dgRirekiList_Row o2) {
            return o2.getTxtKeikakuTekiyoKaishiYMDInvisible().getValue().compareTo(o1.getTxtKeikakuTekiyoKaishiYMDInvisible().getValue());
        }
    }

    private void add履歴(KyotakuJikoTodokedeDetailDiv panel, dgRirekiList_Row addRow) {
        KyotakuJikoTodokedeRirekiListDiv rirekiList = panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getKyotakuServiceRireki().getKyotakuJikoTodokedeRirekiList();
        List<dgRirekiList_Row> dgList = rirekiList.getDgRirekiList().getDataSource();
        dgList.add(addRow);
        Collections.sort(dgList, new DateComparator());
        rirekiList.getDgRirekiList().setDataSource(dgList);
    }

    private void modify履歴(KyotakuJikoTodokedeDetailDiv panel, int index, 修正削除 kubun) {
        KyotakuJikoTodokedeRirekiListDiv rirekiList = panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getKyotakuServiceRireki().getKyotakuJikoTodokedeRirekiList();
        List<dgRirekiList_Row> dgList = rirekiList.getDgRirekiList().getDataSource();
        dgRirekiList_Row currentRow = dgList.get(index);

        dgRirekiList_Row newRow = create履歴(
                currentRow.getBtnSelect(),
                kubun.toString(),
                currentRow.getTxtKeikakuTekiyoKaishiYMDInvisible().getValue().toString(),
                currentRow.getTxtKeikakuTekiyoKaishiYMD().toString(),
                currentRow.getTxtKeikakuTekiyoShuryoYMD().toString(),
                currentRow.getTxtTodokedeYMD().toString(),
                currentRow.getTxtTodokedeKubun().toString());
        dgList.remove(index);
        dgList.add(index, newRow);
        Collections.sort(dgList, new DateComparator());

        rirekiList.getDgRirekiList().setDataSource(dgList);
    }

    private dgRirekiList_Row create履歴(Button btn, String txtJotai, String txtKaishiYMDInvisible, String txtKeikakuTekiyoKaishiYMD,
            String txtKeikakuTekiyoShuryoYMD, String txtTodokedeYMD, String txtTodokedeKubun) {

        TextBoxDate txtBoxDate = new TextBoxDate();
        txtBoxDate.setValue(new RDate(txtKaishiYMDInvisible));

        return new dgRirekiList_Row(
                btn,
                new RString(txtJotai),
                txtBoxDate,
                new RString(txtKeikakuTekiyoKaishiYMD),
                new RString(txtKeikakuTekiyoShuryoYMD),
                new RString(txtTodokedeYMD),
                new RString(txtTodokedeKubun)
        );
    }

    /**
     * 計画届出明細(初期表示)のデータ設定
     *
     * @param panel panel
     */
    private void setMeisaiDefaultData(KyotakuJikoTodokedeDetailDiv panel) {
        setMeisai(panel, 画面表示.初期表示);
    }

    /**
     * 新規届出を追加するボタン押下時の処理
     *
     * @param panel panel
     * @return KyotakuJikoTodokedeDetailDiv
     */
    public ResponseData onClickTodokedeNew(KyotakuJikoTodokedeDetailDiv panel) {
        ResponseData<KyotakuJikoTodokedeDetailDiv> response = new ResponseData<>();
        setMeisai(panel, 画面表示.新規届出);
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
        setMeisai(panel, 画面表示.変更届出);
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
        setMeisai(panel, 画面表示.届出内容修正);
        int selectRowindex = panel.getTabKyotakuServiceJikoSakuseiTodokede().getKyotakuServiceRireki().
                getKyotakuJikoTodokedeRirekiList().getDgRirekiList().getActiveRowId();
        RString index = new RString(String.valueOf(selectRowindex));
        panel.getTabKyotakuServiceJikoSakuseiTodokede().getKyotakuServiceRireki().
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
                getKyotakuServiceRireki().getKyotakuJikoTodokedeMeisai();
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
        KyotakuJikoTodokedeMeisaiDiv meisai = panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getKyotakuServiceRireki().getKyotakuJikoTodokedeMeisai();
        RString kubun = meisai.getTxtTodokedeKubun().getValue();
        Button btn = new Button();
        if (new RString("新規").equals(kubun)) {
            add履歴(panel, create履歴(btn, "追加", "20140601", "平26.06.01", "", "平26.06.01", kubun.toString()));
        } else {
            add履歴(panel, create履歴(btn, "追加", "20140701", "平26.07.01", "", "平26.07.01", kubun.toString()));
        }

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
                getKyotakuServiceRireki().getKyotakuJikoTodokedeMeisai();
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
     * 計画届出明細のデータ設定
     *
     * @param panel panel
     * @param pattern pattern
     */
    private void setMeisai(KyotakuJikoTodokedeDetailDiv panel, 画面表示 pattern) {

        KyotakuJikoTodokedeMeisaiDiv meisai = panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getKyotakuServiceRireki().getKyotakuJikoTodokedeMeisai();
        DataGrid<dgRirekiList_Row> rirekiList = panel.getTabKyotakuServiceJikoSakuseiTodokede().
                getKyotakuServiceRireki().getKyotakuJikoTodokedeRirekiList().getDgRirekiList();
        dgRirekiList_Row selectRow = rirekiList.getClickedItem();

        KyotakuJikoTodokedeshaDiv todokedesha = meisai.getKyotakuJikoTodokedesha();
        KyotakuJikoTodokedeHenkoNaiyoDiv henkoNaiyo = meisai.getKyotakuJikoTodokedeHenkoNaiyo();

        initMeisai(panel);
        if (pattern.equals(画面表示.初期表示)) {
            meisai.getTxtTodokedeKubun().clearValue();
        } else if (pattern.equals(画面表示.新規届出)) {
            btnVisible(meisai.getBtnTodokedeKakutei());
            btnVisible(meisai.getBtnTodokedeClear());
            btnInvisible(meisai.getBtnTodokedeDelete());
            btnInvisible(meisai.getBtnTodokedeTeisei());
            henkoNaiyo.setVisible(false);
            henkoNaiyo.setDisplayNone(true);
            meisai.getTxtTodokedeKubun().setValue(new RString("新規"));
        } else if (pattern.equals(画面表示.変更届出)) {
            btnVisible(meisai.getBtnTodokedeKakutei());
            btnVisible(meisai.getBtnTodokedeClear());
            btnInvisible(meisai.getBtnTodokedeDelete());
            btnInvisible(meisai.getBtnTodokedeTeisei());
            henkoNaiyo.setVisible(true);
            henkoNaiyo.setDisplayNone(false);
            meisai.getTxtTodokedeKubun().setValue(new RString("変更"));
            henkoNaiyo.getTxtHenkoYMD().setValue(new RDate("20140701"));
            henkoNaiyo.getTxtHenkoJiyu().setValue(new RString("介護者の希望により変更する。"));
        } else if (pattern.equals(画面表示.届出内容修正)) {
            btnInvisible(meisai.getBtnTodokedeKakutei());
            btnInvisible(meisai.getBtnTodokedeClear());
            btnVisible(meisai.getBtnTodokedeDelete());
            btnVisible(meisai.getBtnTodokedeTeisei());
            meisai.getTxtTodokedeKubun().setValue(selectRow.getTxtTodokedeKubun());
            if (selectRow.getTxtTodokedeKubun().equals(new RString("新規"))) {
                henkoNaiyo.setVisible(false);
                henkoNaiyo.setDisplayNone(true);
            } else {
                henkoNaiyo.setVisible(true);
                henkoNaiyo.setDisplayNone(false);
                henkoNaiyo.getTxtHenkoYMD().setValue(new RDate("20140701"));
                henkoNaiyo.getTxtHenkoJiyu().setValue(new RString("介護者の希望により変更する。"));
            }
        }

        if (pattern.equals(画面表示.新規届出)
                || pattern.equals(画面表示.変更届出)
                || pattern.equals(画面表示.届出内容修正)) {

            todokedesha.getTxtName().setValue(new RString("電算　太郎"));
            todokedesha.getTxtKana().setValue(new RString("ﾃﾞﾝｻﾝ ﾀﾛｳ"));
            todokedesha.getTxtTelNo().setValue(new RString("123-456-7890"));
            todokedesha.getTxtYubinNo().setValue(new YubinNo("381-0001"));
            todokedesha.getTxtJusho().setValue(new RString("長野市七瀬中町1111-11"));

            if (pattern.equals(画面表示.新規届出)) {
                meisai.getTxtTodokedeYMD().setValue(new RDate("20140601"));
                meisai.getTxtTekiyoKikan().setFromValue(new RDate("20140601"));
                meisai.getTxtTaishoYMD().setValue(new RDate("20140601"));
                meisai.getTxtKeikakuSakuseiYMD().setValue(new RDate("20140601"));

            } else if (pattern.equals(画面表示.変更届出)) {
                meisai.getTxtTodokedeYMD().setValue(new RDate("20140701"));
                meisai.getTxtTekiyoKikan().setFromValue(new RDate("20140701"));
                meisai.getTxtTaishoYMD().setValue(new RDate("20140701"));
                meisai.getTxtKeikakuSakuseiYMD().setValue(new RDate("20140701"));

            } else if (pattern.equals(画面表示.届出内容修正)) {
                meisai.getTxtTodokedeYMD().setValue(new RDate("20130601"));
                meisai.getTxtTekiyoKikan().setFromValue(new RDate("20130601"));
                meisai.getTxtTekiyoKikan().setToValue(new RDate("20140531"));
                meisai.getTxtTaishoYMD().setValue(new RDate("20130601"));
                meisai.getTxtKeikakuSakuseiYMD().setValue(new RDate("20130601"));

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
                getKyotakuServiceRireki().getKyotakuJikoTodokedeMeisai();

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
