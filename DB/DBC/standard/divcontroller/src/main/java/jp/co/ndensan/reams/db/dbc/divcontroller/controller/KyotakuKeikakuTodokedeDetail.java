/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuKeikakuTodokedeDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuKeikakuTodokedeHenkoNaiyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuKeikakuTodokedeJigyoshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuKeikakuTodokedeMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuKeikakuTodokedeRirekiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuKeikakuTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgRirekiList_Row;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
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

    /**
     * 画面ロード時の処理です。
     *
     * @param panel 居宅サービス計画作成依頼届出
     * @return ResponseData
     */
    public ResponseData getOnLoadData(KyotakuKeikakuTodokedeDetailDiv panel) {
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
        KyotakuKeikakuTodokedeRirekiListDiv rirekiList = panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().getKyotakuServiceRireki().getKyotakuKeikakuTodokedeRirekiList();
        List<dgRirekiList_Row> dgList = create履歴一覧();
        rirekiList.getDgRirekiList().setDataSource(dgList);
    }

    private List<dgRirekiList_Row> create履歴一覧() {
        List<dgRirekiList_Row> dgList = new ArrayList<>();
        dgRirekiList_Row rowItem;
        Button btn = new Button();
        rowItem = create履歴(btn, "追加", "平26.06.01", "平26.06.30", "06.01", "新規", "1111111111:事業者１");
        dgList.add(rowItem);
        rowItem = create履歴(btn, "修正", "平26.06.01", "平26.06.30", "06.01", "変更", "1111111111:事業者１");
        dgList.add(rowItem);

        return dgList;
    }

    private void add履歴(KyotakuKeikakuTodokedeDetailDiv panel, dgRirekiList_Row addRow) {
        KyotakuKeikakuTodokedeRirekiListDiv rirekiList = panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().getKyotakuServiceRireki().getKyotakuKeikakuTodokedeRirekiList();
        List<dgRirekiList_Row> dgList = rirekiList.getDgRirekiList().getDataSource();
        dgList.add(addRow);
        rirekiList.getDgRirekiList().setDataSource(dgList);
    }

    private void modify履歴(KyotakuKeikakuTodokedeDetailDiv panel, int index, 修正削除 kubun) {
        KyotakuKeikakuTodokedeRirekiListDiv rirekiList = panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().getKyotakuServiceRireki().getKyotakuKeikakuTodokedeRirekiList();
        List<dgRirekiList_Row> dgList = rirekiList.getDgRirekiList().getDataSource();
        dgRirekiList_Row currentRow = dgList.get(index);

        dgRirekiList_Row newRow = create履歴(
                currentRow.getBtnSelect(),
                kubun.toString(),
                currentRow.getTxtKeikakuTekiyoKaishiYMD().toString(),
                currentRow.getTxtKeikakuTekiyoShuryoYMD().toString(),
                currentRow.getTxtTodokedeYMD().toString(),
                currentRow.getTxtTodokedeKubun().toString(),
                currentRow.getTxtKeikakuIraiJigyosha().toString());
        dgList.remove(index);
        dgList.add(index, newRow);

        rirekiList.getDgRirekiList().setDataSource(dgList);
    }

    private dgRirekiList_Row create履歴(Button btn, String txtJotai, String txtKeikakuTekiyoKaishiYMD,
            String txtKeikakuTekiyoShuryoYMD, String txtTodokedeYMD, String txtTodokedeKubun, String txtKeikakuIraiJigyosha) {
        return new dgRirekiList_Row(
                btn,
                new RString(txtJotai),
                new RString(txtKeikakuTekiyoKaishiYMD),
                new RString(txtKeikakuTekiyoShuryoYMD),
                new RString(txtTodokedeYMD),
                new RString(txtTodokedeKubun),
                new RString(txtKeikakuIraiJigyosha));
    }

    /**
     * 計画届出明細(初期表示)のデータ設定
     *
     * @param panel
     */
    private void setMeisaiDefaultData(KyotakuKeikakuTodokedeDetailDiv panel) {
        setMeisai(panel, 画面表示.初期表示);
    }

    /**
     * 新規届出を追加するボタン押下時の処理
     *
     * @param panel
     * @return KyotakuKeikakuTodokedeDetailDiv
     */
    public ResponseData onClickTodokedeNew(KyotakuKeikakuTodokedeDetailDiv panel) {
        ResponseData<KyotakuKeikakuTodokedeDetailDiv> response = new ResponseData<>();
        setMeisai(panel, 画面表示.新規届出);
        response.data = panel;
        return response;
    }

    /**
     * 変更届出を追加するボタン押下時の処理
     *
     * @param panel
     * @return KyotakuKeikakuTodokedeDetailDiv
     */
    public ResponseData onClickTodokedeModify(KyotakuKeikakuTodokedeDetailDiv panel) {
        ResponseData<KyotakuKeikakuTodokedeDetailDiv> response = new ResponseData<>();
        setMeisai(panel, 画面表示.変更届出);
        response.data = panel;
        return response;
    }

    /**
     * 履歴一覧で選択ボタン押下時の処理
     *
     * @param panel
     * @return KyotakuKeikakuTodokedeDetailDiv
     */
    public ResponseData onClickTodokedeSelect(KyotakuKeikakuTodokedeDetailDiv panel) {
        ResponseData<KyotakuKeikakuTodokedeDetailDiv> response = new ResponseData<>();
        setMeisai(panel, 画面表示.届出内容修正);
        int selectRowindex = panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().getKyotakuServiceRireki().getKyotakuKeikakuTodokedeRirekiList().getDgRirekiList().getActiveRowId();
        String index = String.valueOf(selectRowindex);
        panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().getKyotakuServiceRireki().getKyotakuKeikakuTodokedeMeisai().getTxtRirekiListSelectIndex().setValue(new RString(index));

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
        int index = Integer.valueOf(panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().getKyotakuServiceRireki().getKyotakuKeikakuTodokedeMeisai().getTxtRirekiListSelectIndex().getValue().toString());
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
        dgRirekiList_Row rowItem;
        Button btn = new Button();
        String kubun = panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().getKyotakuServiceRireki().getKyotakuKeikakuTodokedeMeisai().getTxtTodokedeKubun().getValue().toString();
        rowItem = create履歴(btn, "追加", "平26.06.01", "平26.06.30", "06.01", kubun, "1111111111:事業者１");

        add履歴(panel, rowItem);

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
        int index = Integer.valueOf(panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().getKyotakuServiceRireki().getKyotakuKeikakuTodokedeMeisai().getTxtRirekiListSelectIndex().getValue().toString());
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
        KyotakuKeikakuTodokedeJigyoshaDiv jigyosha = panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().getKyotakuServiceRireki().getKyotakuKeikakuTodokedeMeisai().getKyotakuKeikakuTodokedeJigyosha();
        RadioButton rad = jigyosha.getRadKeikakuSakuseiKubun();
        if (rad.getSelectedItem().equals(new RString("key0"))) {
            jigyosha.getTxtItakuJigyoshaCode().setVisible(false);
            jigyosha.getTxtItakuJigyoshaCode().setDisplayNone(true);
            jigyosha.getBtnItakuJigyosha().setVisible(false);
            jigyosha.getBtnItakuJigyosha().setDisplayNone(true);
            jigyosha.getTxtItakuJigyoshaName().setVisible(false);
            jigyosha.getTxtItakuJigyoshaName().setDisplayNone(true);
            jigyosha.getTxtServiceShurui1().setValue(new RString("居宅介護"));
            jigyosha.getTxtServiceShurui2().setValue(new RString("小規模介護"));
        } else {
            jigyosha.getTxtItakuJigyoshaCode().setVisible(true);
            jigyosha.getTxtItakuJigyoshaCode().setDisplayNone(false);
            jigyosha.getBtnItakuJigyosha().setVisible(true);
            jigyosha.getBtnItakuJigyosha().setDisplayNone(false);
            jigyosha.getTxtItakuJigyoshaName().setVisible(true);
            jigyosha.getTxtItakuJigyoshaName().setDisplayNone(false);
            jigyosha.getTxtServiceShurui1().setValue(new RString("居宅支援"));
            jigyosha.getTxtServiceShurui2().setValue(new RString("小規模支援"));
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
     * 計画届出明細のデータ設定
     *
     * @param panel panel
     * @param pattern pattern
     */
    private void setMeisai(KyotakuKeikakuTodokedeDetailDiv panel, 画面表示 pattern) {

        KyotakuKeikakuTodokedeMeisaiDiv meisai = panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().getKyotakuServiceRireki().getKyotakuKeikakuTodokedeMeisai();
        DataGrid<dgRirekiList_Row> rirekiList = panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().getKyotakuServiceRireki().getKyotakuKeikakuTodokedeRirekiList().getDgRirekiList();
        dgRirekiList_Row selectRow = rirekiList.getClickedItem();

        KyotakuKeikakuTodokedeshaDiv todokedesha = meisai.getKyotakuKeikakuTodokedesha();
        KyotakuKeikakuTodokedeJigyoshaDiv jigyosha = meisai.getKyotakuKeikakuTodokedeJigyosha();
        KyotakuKeikakuTodokedeHenkoNaiyoDiv henkoNaiyo = meisai.getKyotakuKeikakuTodokedeHenkoNaiyo();

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

            meisai.getTxtTodokedeYMD().setValue(new RDate("20140601"));
            meisai.getTxtTekiyoKikan().setFromValue(new RDate("20140601"));
            meisai.getTxtTekiyoKikan().setToValue(new RDate("20140630"));

            todokedesha.getTxtTodokedeshaName().setValue(new RString("電算　太郎"));
            todokedesha.getTxtTodokedeshaKana().setValue(new RString("デンサン　タロウ"));
            todokedesha.getTxtTodokedeshaTelNo().setValue(new RString("123-456-7890"));
            todokedesha.getTxtTodokedeshaYubinNo().setValue(new YubinNo("381-0001"));
            todokedesha.getTxtTodokedeshaJusho().setValue(new RString("長野市七瀬中町1111-11"));

            jigyosha.getRadKeikakuSakuseiKubun().setSelectedItem(new RString("key0"));
            {
                jigyosha.getTxtItakuJigyoshaCode().setVisible(false);
                jigyosha.getTxtItakuJigyoshaCode().setDisplayNone(true);
                jigyosha.getBtnItakuJigyosha().setVisible(false);
                jigyosha.getBtnItakuJigyosha().setDisplayNone(true);
                jigyosha.getTxtItakuJigyoshaName().setVisible(false);
                jigyosha.getTxtItakuJigyoshaName().setDisplayNone(true);
                jigyosha.getTxtServiceShurui1().setValue(new RString("居宅介護"));
                jigyosha.getTxtServiceShurui2().setValue(new RString("小規模介護"));
            }
            jigyosha.getTxtJigyoshaCode().setValue(new RString("1111111111"));
            jigyosha.getTxtJigyoshaName().setValue(new RString("電算介護調査センター"));
            jigyosha.getTxtJigyoshaYubinNo().setValue(new YubinNo("381-0001"));
            jigyosha.getTxtJigyoshaJusho().setValue(new RString("長野市緑町３丁目14-15"));
            jigyosha.getTxtKanrishaName().setValue(new RString("電算　次郎"));
            jigyosha.getTxtJigyoshaTelNo().setValue(new RString("123-456-7899"));
            jigyosha.getTxtItakuJigyoshaCode().setValue(new RString("2222222222"));
            jigyosha.getTxtItakuJigyoshaName().setValue(new RString("電算介護サービスセンター"));
        }
    }

    /**
     * 計画届出明細の内容を初期化する(ただし届出区分については初期化しない)。
     *
     * @param panel
     */
    private void initMeisai(KyotakuKeikakuTodokedeDetailDiv panel) {
        KyotakuKeikakuTodokedeMeisaiDiv meisai = panel.getTabKyotakuServiceKeikakuSakuseiIraiTodokede().getKyotakuServiceRireki().getKyotakuKeikakuTodokedeMeisai();

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
