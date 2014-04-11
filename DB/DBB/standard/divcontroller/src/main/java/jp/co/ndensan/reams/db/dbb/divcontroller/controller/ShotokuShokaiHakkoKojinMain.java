/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.ShotokuShokaiHakkoKojinMainDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.SofusakiGenJushoShuseiPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgHakkoKakunin_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgShotokuShokaiHyoHakko_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgShuseiSetaiIn_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 *
 * @author N3317 塚田 萌
 */
public class ShotokuShokaiHakkoKojinMain {

    /**
     * 画面が読み込まれた際の初期値をセットします。
     *
     * @param panel 所得照会票発行個人一覧Div
     * @return 所得照会票発行個人一覧DivのResponseData
     */
    //TODO N3317 塚田 萌 住民情報等はDBアクセスが可能になった時点でデータの取得部分を差し替える。
    public ResponseData<ShotokuShokaiHakkoKojinMainDiv> getOnLoadData(ShotokuShokaiHakkoKojinMainDiv panel) {
        ResponseData<ShotokuShokaiHakkoKojinMainDiv> response = new ResponseData<>();
        setDefaultParam(panel);
        response.data = panel;
        return response;
    }

    /**
     * 「印字内容を修正前に戻す」ボタン押下により呼び出され、各項目に初期値をセットします。
     *
     * @param panel
     * @return
     */
    public ResponseData<ShotokuShokaiHakkoKojinMainDiv> onClickShuseiMaeModosu(ShotokuShokaiHakkoKojinMainDiv panel) {
        ResponseData<ShotokuShokaiHakkoKojinMainDiv> response = new ResponseData<>();
        setDefaultParam(panel);
        response.data = panel;
        return response;
    }

    /**
     * 「選択された世帯員の印字内容を修正する」ボタンで呼び出され、各項目に世帯員の情報が初期値としてセットされます。
     * 選択された世帯員内において優先度の高い世帯員の情報を初期値とする。
     * 転出先が登録されている世帯員の情報を最優先とし、いずれの世帯員も転出先が登録されていない場合は転入前の情報が登録されている世帯員とする。
     * いずれの世帯員も転出先、転入前が登録されていない場合はリスト先頭世帯員の情報を初期値とする。
     *
     * @param panel
     * @return
     */
    public ResponseData<ShotokuShokaiHakkoKojinMainDiv> onClickSentakuShusei(ShotokuShokaiHakkoKojinMainDiv panel) {
        ResponseData<ShotokuShokaiHakkoKojinMainDiv> response = new ResponseData<>();
        List<dgShuseiSetaiIn_Row> shuseiTaishoSetaiIn = new ArrayList<>();
        List<dgShotokuShokaiHyoHakko_Row> selectedSetaiIn = panel.getShotokuShokaiHyoHakkoIchiranPanel().getDgShotokuShokaiHyoHakko().getSelectedItems();
        for (dgShotokuShokaiHyoHakko_Row setaiIn : selectedSetaiIn) {
            shuseiTaishoSetaiIn.add(createRowShuseiTaishoSetaiIn(setaiIn.getTxtShikibetsuCode().toString(), setaiIn.getTxtShimei().toString()));
            panel.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel().getTxtSofusakiYubinNo().setValue(setaiIn.getTxtSoYubinNo());
            panel.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel().getTxtSofusaki01().setValue(setaiIn.getTxtSofusaki01());
            panel.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel().getTxtSofusaki02().setValue(setaiIn.getTxtSofusaki02());
            panel.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel().getTxtSofusaki03().setValue(setaiIn.getTxtSofusaki03());
            panel.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel().getTxtSofusakiOnchu().setValue(setaiIn.getTxtSofusakiOnchu());
            panel.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel().getTxtSofusakiSama().setValue(setaiIn.getTxtSofusakisama());
            if (setaiIn.getTxtTenshutsusakiJusho().isEmpty()) {
                panel.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel().getRadMaeJusho().setSelectedItem(new RString("key0"));
                panel.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel().getTxtMaeJusho().setValue(setaiIn.getTxtTennyumaeJusho());
            } else {
                panel.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel().getRadMaeJusho().setSelectedItem(new RString("key1"));
                panel.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel().getTxtMaeJusho().setValue(setaiIn.getTxtTenshutsusakiJusho());
            }
            panel.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getGenJushoNyuryokuPanel().getTxtGenJusho().setValue(setaiIn.getTxtGenJusho());
        }
        panel.getShotokuShokaihyoShuseiNyuryokuPanel().getShuseiSetaiInListPanel().getDgShuseiSetaiIn().setDataSource(shuseiTaishoSetaiIn);
        response.data = panel;
        return response;
    }

    /**
     * 世帯員個人一覧画面から所得照会票発行確認画面へ遷移した際の処理です。
     * 差出人情報修正画面及び、世帯員一覧の選択された世帯員の修正情報を元に発行前の確認情報を出力します。
     *
     * @param panel
     * @return
     */
    public ResponseData<ShotokuShokaiHakkoKojinMainDiv> onClickHakkoKakunin(ShotokuShokaiHakkoKojinMainDiv panel) {
        ResponseData<ShotokuShokaiHakkoKojinMainDiv> response = new ResponseData<>();
        List<dgHakkoKakunin_Row> kakuninList = new ArrayList<>();
        setKakuninSashidashinin(panel);
        kakuninList = setHakkoKakuninSetaiin(panel);
        panel.getHakkoKakuninPanel().getDgHakkoKakunin().setDataSource(kakuninList);
        response.data = panel;
        return response;
    }

    /**
     * 差出人の修正画面において、修正内容を破棄します。
     *
     * @param panel
     * @return
     */
    public ResponseData<ShotokuShokaiHakkoKojinMainDiv> onClickSashidashininShuseiHaki(ShotokuShokaiHakkoKojinMainDiv panel) {
        ResponseData<ShotokuShokaiHakkoKojinMainDiv> response = new ResponseData<>();
        setDefaultSashidashinin(panel);
        response.data = panel;
        return response;
    }

    /**
     * 修正入力画面において修正内容を保存して一覧画面に戻る際に呼び出されます。 修正内容を個人一覧画面に反映させます。
     *
     * @param panel
     * @return
     */
    public ResponseData<ShotokuShokaiHakkoKojinMainDiv> onClickNyuryokuNaiyoHozon(ShotokuShokaiHakkoKojinMainDiv panel) {
        ResponseData<ShotokuShokaiHakkoKojinMainDiv> response = new ResponseData<>();

        List<dgShotokuShokaiHyoHakko_Row> kojinData = panel.getShotokuShokaiHyoHakkoIchiranPanel().getDgShotokuShokaiHyoHakko().getDataSource();
        SofusakiGenJushoShuseiPanelDiv shuseiPanel = panel.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel();
        for (dgShotokuShokaiHyoHakko_Row kojin : kojinData) {
            if (kojin.getSelected()) {
                setShuseiShori(kojin, shuseiPanel);

            }
            createRowKetsugo(kojin);
        }

        panel.getShotokuShokaiHyoHakkoIchiranPanel().getDgShotokuShokaiHyoHakko().setDataSource(kojinData);
        response.data = panel;
        return response;
    }

    /*
     初期値をセットします。
     */
    private void setDefaultParam(ShotokuShokaiHakkoKojinMainDiv panel) {
        setDefaultJuminzeiNendo(panel);
        setDefaultHakkoYmd(panel);
        setSetaiKojinData(panel);
        setDefaultSashidashinin(panel);
    }

    /*
     住民税年度の初期値を設定します。
     */
    private void setDefaultJuminzeiNendo(ShotokuShokaiHakkoKojinMainDiv panel) {
        panel.getShotokuShokaiHyoHakkoIchiranPanel().getDdlJuminzeiNendo().setSelectedItem(RDate.getNowDate().getYear().wareki().eraType(EraType.KANJI_RYAKU).toDateString());
    }

    /*
     発行年月日の初期値を設定します。
     */
    private void setDefaultHakkoYmd(ShotokuShokaiHakkoKojinMainDiv panel) {
        panel.getShotokuShokaiHyoHakkoIchiranPanel().getTxtHakkoNengappi().setValue(RDate.getNowDate());
    }

    /*
     差出人情報を設定します。
     */
    private void setDefaultSashidashinin(ShotokuShokaiHakkoKojinMainDiv panel) {
        panel.getSashidashininNyuryokuPanel().getTxtYubinNo().setValue(new RString("1234567"));
        panel.getSashidashininNyuryokuPanel().getTxtShozai().setValue(new RString("長野県長野市1-2-3"));
        panel.getSashidashininNyuryokuPanel().getTxtTantoBusho().setValue(new RString("長野市役所国民健康保険課"));
        panel.getSashidashininNyuryokuPanel().getTxtTellNo().setValue(new RString("123-456-8901"));
    }

    /*
     世帯一覧の個人情報を設定します。
     */
    private void setSetaiKojinData(ShotokuShokaiHakkoKojinMainDiv panel) {

        List<dgShotokuShokaiHyoHakko_Row> arraydata = createRowSetaiTestData();
        DataGrid<dgShotokuShokaiHyoHakko_Row> grid = panel.getShotokuShokaiHyoHakkoIchiranPanel().getDgShotokuShokaiHyoHakko();
        grid.setDataSource(arraydata);
    }

    /*
     引数を元にデータグリッド内に挿入する個人データを作成します。
     */
    private dgShotokuShokaiHyoHakko_Row createRowKojinData(/*String 所得区分, */String 識別コード, String 氏名, String 種別, String 性別,
            String 続柄, String 生年月日, String 資格, String 転入前住所, String 転入日, String 転出先住所, String 転出日,
            String 現住所, String 送付先郵便番号, String 送付先1, String 送付先2, String 送付先3, String 御中, String 様) {

        dgShotokuShokaiHyoHakko_Row rowKojinData = new dgShotokuShokaiHyoHakko_Row(RString.HALF_SPACE, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new Button());
//↓引数を渡さないとそもそも情報が出力されない。引数ありのコンストラクタを使うこと
// dgShotokuShokaiHyoHakko_Row rowKojinData = new dgShotokuShokaiHyoHakko_Row();

//        rowKojinData.setTxtIchiranShotokuKubun(new RString(所得区分));
        rowKojinData.setTxtShikibetsuCode(new RString(識別コード));
        rowKojinData.setTxtShimei(new RString(氏名));
        rowKojinData.setTxtShubetsu(new RString(種別));
        rowKojinData.setTxtSeibetsu(new RString(性別));
        rowKojinData.setTxtZokugara(new RString(続柄));
        rowKojinData.getTxtSeinenGappi().setValue(new RString(生年月日));
        rowKojinData.setTxtShikaku(new RString(資格));
        rowKojinData.setTxtTennyumaeJusho(new RString(転入前住所));
        rowKojinData.getTxtTennnyubi().setValue(new RString(転入日));
        rowKojinData.setTxtTenshutsusakiJusho(new RString(転出先住所));
        rowKojinData.getTxtTenshutsubi().setValue(new RString(転出日));
        rowKojinData.setTxtGenJusho(new RString(現住所));
        rowKojinData.setTxtSoYubinNo(new RString(送付先郵便番号));
        rowKojinData.setTxtSofusaki01(new RString(送付先1));
        rowKojinData.setTxtSofusaki02(new RString(送付先2));
        rowKojinData.setTxtSofusaki03(new RString(送付先3));
        rowKojinData.setTxtSofusakiOnchu(new RString(御中));
        rowKojinData.setTxtSofusakisama(new RString(様));
        createRowKetsugo(rowKojinData);

        return rowKojinData;
    }

    /*
     修正画面において、世帯員一覧表示用の一行を作成します。
     */
    private dgShuseiSetaiIn_Row createRowShuseiTaishoSetaiIn(String 識別コード, String 氏名) {
        dgShuseiSetaiIn_Row shuseiTaishoSetaiInData = new dgShuseiSetaiIn_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY);
        shuseiTaishoSetaiInData.setTxtKetsugoShuseiYo(new RString(識別コード.concat("<br>").concat(氏名)));

        return shuseiTaishoSetaiInData;
    }

    /*
     個人情報の初期値のテストデータです。
     */
    private List<dgShotokuShokaiHyoHakko_Row> createRowSetaiTestData() {
        List<dgShotokuShokaiHyoHakko_Row> arrayData = new ArrayList<>();
        dgShotokuShokaiHyoHakko_Row item;

        item = createRowKojinData(/*"未申告",*/"000000000000001", "電算　太郎", "種別", " 男", "世帯主", "19700101", "2号", "長野県千曲市", "20100101", "長野県電算市", "20140101", "長野県長野市", "1234567", "長野県電算市", "", "", "長野県電算市役所", "電算市長");
        arrayData.add(item);
        item = createRowKojinData(/*"未申告",*/"000000000000011", "電算　花子", "種別", " 女", "妻", "19750101", "2号", "長野県千曲市", "20100101", "長野県電算市", "20140101", "長野県長野市", "1234567", "長野県電算市", "", "", "長野県電算市役所", "電算市長");
        arrayData.add(item);
        item = createRowKojinData(/*"未申告",*/"000000000000111", "電算　姫子", "種別", " 女", "子", "19950101", "", "長野県千曲市", "20100101", "長野県電算市", "20140101", "長野県長野市", "1234567", "長野県電算市", "", "", "長野県電算市役所", "電算市長");
        arrayData.add(item);
        item = createRowKojinData(/*"未申告",*/"000000000001111", "電算　次郎", "種別", " 男", "子", "19950101", "", "長野県千曲市", "20100101", "長野県電算市", "20140101", "長野県長野市", "1234567", "長野県電算市", "", "", "長野県電算市役所", "電算市長");
        arrayData.add(item);
        item = createRowKojinData(/*"未申告",*/"000000000011111", "電算　三郎", "種別", " 男", "子", "19950101", "", "長野県千曲市", "20100101", "長野県電算市", "20140101", "長野県長野市", "1234567", "長野県電算市", "", "", "長野県電算市役所", "電算市長");
        arrayData.add(item);
        item = createRowKojinData(/*"未申告",*/"000000000111111", "電算　四郎", "種別", " 男", "子", "19950101", "", "長野県千曲市", "20100101", "長野県電算市", "20140101", "長野県長野市", "1234567", "長野県電算市", "", "", "長野県電算市役所", "電算市長");
        arrayData.add(item);
        item = createRowKojinData(/*"未申告",*/"000000001111111", "電算　五郎", "種別", " 男", "子", "19950101", "", "長野県千曲市", "20100101", "長野県電算市", "20140101", "長野県長野市", "1234567", "長野県電算市", "", "", "長野県電算市役所", "電算市長");
        arrayData.add(item);

        return arrayData;
    }

    /*
     データグリッド内に挿入する際に二行として表示させるための成型メソッドです。
     */
    private void createRowKetsugo(dgShotokuShokaiHyoHakko_Row rowKojinData) {
        rowKojinData.setTxtKetsugo01(rowKojinData.getTxtShikibetsuCode().concat(new RString("<br>")).concat(rowKojinData.getTxtShimei()).concat(new RString("  ")));
        rowKojinData.setTxtKetsugo02(rowKojinData.getTxtShubetsu().concat(new RString("<br>")).concat(rowKojinData.getTxtSeibetsu()).concat(new RString("  ")));
        rowKojinData.setTxtKetsugo03(rowKojinData.getTxtZokugara().concat(new RString("<br>")).concat(new FlexibleDate(rowKojinData.getTxtSeinenGappi().getValue()).wareki().toDateString()).concat(new RString("  ")));
        rowKojinData.setTxtKetsugo04(rowKojinData.getTxtTennyumaeJusho().concat(new RString("<br>")).concat(new FlexibleDate(rowKojinData.getTxtTennnyubi().getValue()).wareki().toDateString()).concat(new RString("  ")));
        rowKojinData.setTxtKetsugo05(rowKojinData.getTxtTenshutsusakiJusho().concat(new RString("<br>")).concat(new FlexibleDate(rowKojinData.getTxtTenshutsubi().getValue()).wareki().toDateString()).concat(new RString("  ")));
    }

    private void setKakuninSashidashinin(ShotokuShokaiHakkoKojinMainDiv panel) {
        panel.getHakkoKakuninPanel().getSashidashininKakuninPanel().getTextBoxYubinNo1().setValue(panel.getSashidashininNyuryokuPanel().getTxtYubinNo().getValue());
        panel.getHakkoKakuninPanel().getSashidashininKakuninPanel().getTxtShozaiCheck().setValue(panel.getSashidashininNyuryokuPanel().getTxtShozai().getValue());
        panel.getHakkoKakuninPanel().getSashidashininKakuninPanel().getTxtTantoCheck().setValue(panel.getSashidashininNyuryokuPanel().getTxtTantoBusho().getValue());
        panel.getHakkoKakuninPanel().getSashidashininKakuninPanel().getTxtTellNoCheck().setValue(panel.getSashidashininNyuryokuPanel().getTxtTellNo().getValue());
    }

    private List<dgHakkoKakunin_Row> setHakkoKakuninSetaiin(ShotokuShokaiHakkoKojinMainDiv panel) {
        List<dgShotokuShokaiHyoHakko_Row> selectedSetaiIn = panel.getShotokuShokaiHyoHakkoIchiranPanel().getDgShotokuShokaiHyoHakko().getSelectedItems();
        List<dgHakkoKakunin_Row> returnList = new ArrayList<>();
        List<dgShotokuShokaiHyoHakko_Row> tenshutsusakiAriSetaiIn = new ArrayList<>();
        List<dgShotokuShokaiHyoHakko_Row> tenshutsuNashiTennyuAriSetaiIn = new ArrayList<>();
        List<dgShotokuShokaiHyoHakko_Row> tenshutsuAndTennyuNashiSetaiIn = new ArrayList<>();
        dgShotokuShokaiHyoHakko_Row chokuzenSetaiInAri = new dgShotokuShokaiHyoHakko_Row();
        dgShotokuShokaiHyoHakko_Row chokuzenSetaiInNashiAri = new dgShotokuShokaiHyoHakko_Row();
        dgShotokuShokaiHyoHakko_Row chokuzenSetaiInNashi = new dgShotokuShokaiHyoHakko_Row();

        for (dgShotokuShokaiHyoHakko_Row setaiIn : selectedSetaiIn) {
            if (!setaiIn.getTxtTenshutsusakiJusho().isEmpty()) {
                tenshutsusakiAriSetaiIn.add(setaiIn);
            } else if (setaiIn.getTxtTenshutsusakiJusho().isEmpty() && !setaiIn.getTxtTennyumaeJusho().isEmpty()) {
                tenshutsuNashiTennyuAriSetaiIn.add(setaiIn);
            } else {
                tenshutsuAndTennyuNashiSetaiIn.add(setaiIn);
            }
        }
        for (dgShotokuShokaiHyoHakko_Row setaiIn : tenshutsusakiAriSetaiIn) {
            if (setaiIn.getTxtShikibetsuCode().equals(chokuzenSetaiInAri.getTxtShikibetsuCode())) {
                continue;
            }
            List<dgShotokuShokaiHyoHakko_Row> leftNozokuList = getLeftSetaiInNozoku(tenshutsusakiAriSetaiIn, setaiIn.getTxtShikibetsuCode());
            tenshutsusakiAriSetaiIn = leftNozokuList;
            dgShotokuShokaiHyoHakko_Row rightSetaiIn = searchPareSetaiInTenshutsusakiAri(leftNozokuList, setaiIn);
            if (rightSetaiIn == null) {
                returnList.add(makeSigleSetaiInRow(setaiIn));
            } else {
                List<dgShotokuShokaiHyoHakko_Row> rightNozokuList = getLeftSetaiInNozoku(tenshutsusakiAriSetaiIn, rightSetaiIn.getTxtShikibetsuCode());
                tenshutsusakiAriSetaiIn = rightNozokuList;
                chokuzenSetaiInAri = rightSetaiIn;
                returnList.add(makePareSetaiInRow(setaiIn, rightSetaiIn));
            }
        }
        for (dgShotokuShokaiHyoHakko_Row setaiIn : tenshutsuNashiTennyuAriSetaiIn) {
            if (setaiIn.getTxtShikibetsuCode().equals(chokuzenSetaiInNashiAri.getTxtShikibetsuCode())) {
                continue;
            }
            List<dgShotokuShokaiHyoHakko_Row> leftNozokuList = getLeftSetaiInNozoku(tenshutsuNashiTennyuAriSetaiIn, setaiIn.getTxtShikibetsuCode());
            tenshutsuNashiTennyuAriSetaiIn = leftNozokuList;
            dgShotokuShokaiHyoHakko_Row rightSetaiIn = searchPareSetaiInTenshutsuNashiTennyuAri(leftNozokuList, setaiIn);
            if (rightSetaiIn == null) {
                returnList.add(makeSigleSetaiInRow(setaiIn));
            } else {
                List<dgShotokuShokaiHyoHakko_Row> rightNozokuList = getLeftSetaiInNozoku(tenshutsuNashiTennyuAriSetaiIn, rightSetaiIn.getTxtShikibetsuCode());
                tenshutsuNashiTennyuAriSetaiIn = rightNozokuList;
                chokuzenSetaiInNashiAri = rightSetaiIn;
                returnList.add(makePareSetaiInRow(setaiIn, rightSetaiIn));
            }
        }
        for (dgShotokuShokaiHyoHakko_Row setaiIn : tenshutsuAndTennyuNashiSetaiIn) {
            if (setaiIn.getTxtShikibetsuCode().equals(chokuzenSetaiInNashi.getTxtShikibetsuCode())) {
                continue;
            }
            List<dgShotokuShokaiHyoHakko_Row> leftNozokuList = getLeftSetaiInNozoku(tenshutsuAndTennyuNashiSetaiIn, setaiIn.getTxtShikibetsuCode());
            tenshutsuAndTennyuNashiSetaiIn = leftNozokuList;
            dgShotokuShokaiHyoHakko_Row rightSetaiIn = searchPareSetaiInTenshutsuTennyuNashi(leftNozokuList, setaiIn);
            if (rightSetaiIn == null) {
                returnList.add(makeSigleSetaiInRow(setaiIn));
            } else {
                List<dgShotokuShokaiHyoHakko_Row> rightNozokuList = getLeftSetaiInNozoku(tenshutsuAndTennyuNashiSetaiIn, rightSetaiIn.getTxtShikibetsuCode());
                tenshutsuAndTennyuNashiSetaiIn = rightNozokuList;
                chokuzenSetaiInNashi = rightSetaiIn;
                returnList.add(makePareSetaiInRow(setaiIn, rightSetaiIn));
            }
        }
        return returnList;

    }

    private List<dgShotokuShokaiHyoHakko_Row> getLeftSetaiInNozoku(List<dgShotokuShokaiHyoHakko_Row> setaiIns, RString leftShikibetsuCode) {
        List<dgShotokuShokaiHyoHakko_Row> returnList = new ArrayList<>();
        for (dgShotokuShokaiHyoHakko_Row setaiIn : setaiIns) {
            if (setaiIn.getTxtShikibetsuCode().equals(leftShikibetsuCode)) {
                continue;
            }
            returnList.add(setaiIn);
        }
        return returnList;
    }

    private dgShotokuShokaiHyoHakko_Row searchPareSetaiInTenshutsusakiAri(List<dgShotokuShokaiHyoHakko_Row> setaiIns, dgShotokuShokaiHyoHakko_Row leftSetaiIn) {
        for (dgShotokuShokaiHyoHakko_Row setaiIn : setaiIns) {
            if (setaiIn.getTxtTenshutsusakiJusho().equals(leftSetaiIn.getTxtTenshutsusakiJusho())
                    && setaiIn.getTxtSoYubinNo().equals(leftSetaiIn.getTxtSoYubinNo())) {
                return setaiIn;
            }
        }
        return null;
    }

    private dgShotokuShokaiHyoHakko_Row searchPareSetaiInTenshutsuNashiTennyuAri(List<dgShotokuShokaiHyoHakko_Row> setaiIns, dgShotokuShokaiHyoHakko_Row leftSetaiIn) {
        for (dgShotokuShokaiHyoHakko_Row setaiIn : setaiIns) {
            if (setaiIn.getTxtTennyumaeJusho().equals(leftSetaiIn.getTxtTennyumaeJusho())
                    && setaiIn.getTxtSoYubinNo().equals(leftSetaiIn.getTxtSoYubinNo())) {
                return setaiIn;
            }
        }
        return null;
    }

    private dgShotokuShokaiHyoHakko_Row searchPareSetaiInTenshutsuTennyuNashi(List<dgShotokuShokaiHyoHakko_Row> setaiIns, dgShotokuShokaiHyoHakko_Row leftSetaiIn) {
        for (dgShotokuShokaiHyoHakko_Row setaiIn : setaiIns) {
            if (setaiIn.getTxtSoYubinNo().equals(leftSetaiIn.getTxtSoYubinNo())) {
                return setaiIn;
            }
        }
        return null;
    }

    private dgHakkoKakunin_Row makeSigleSetaiInRow(dgShotokuShokaiHyoHakko_Row setaiIn) {
        dgHakkoKakunin_Row singleHakkoSetaiIn = new dgHakkoKakunin_Row(RString.EMPTY, RString.EMPTY,/* RString.EMPTY,*/ RString.HALF_SPACE, RString.EMPTY);
        singleHakkoSetaiIn.setTxtGenJusho(setaiIn.getTxtGenJusho());
        singleHakkoSetaiIn.setTxtSetaiin(setaiIn.getTxtShimei());
//        singleHakkoSetaiIn.setTxtKakuninShotokuKubun(setaiIn.getTxtIchiranShotokuKubun());
        singleHakkoSetaiIn.setTxtSofusaki(setaiIn.getTxtSoYubinNo().concat(new RString("　"))
                .concat(setaiIn.getTxtSofusaki01()).concat(setaiIn.getTxtSofusaki02()).concat(setaiIn.getTxtSofusaki03())
                .concat(new RString("<br>")).concat(setaiIn.getTxtSofusakiOnchu()).concat(new RString("御中")).concat(new RString("　"))
                .concat(setaiIn.getTxtSofusakisama()).concat(new RString("様")));
        if (setaiIn.getTxtTenshutsusakiJusho().isEmpty()) {
            singleHakkoSetaiIn.setTxtTennyuuOrTenshutsu(new RString("転入前"));
        } else {
            singleHakkoSetaiIn.setTxtTennyuuOrTenshutsu(new RString("転出先"));
        }
        return singleHakkoSetaiIn;
    }

    private dgHakkoKakunin_Row makePareSetaiInRow(dgShotokuShokaiHyoHakko_Row setaiIn1, dgShotokuShokaiHyoHakko_Row setaiIn2) {
        dgHakkoKakunin_Row singleHakkoSetaiIn = new dgHakkoKakunin_Row(RString.EMPTY, RString.EMPTY,/* RString.EMPTY,*/ RString.HALF_SPACE, RString.EMPTY);
        singleHakkoSetaiIn.setTxtGenJusho(setaiIn1.getTxtGenJusho());
        singleHakkoSetaiIn.setTxtSetaiin(setaiIn1.getTxtShimei().concat(new RString("<br>")).concat(setaiIn2.getTxtShimei()));
//        singleHakkoSetaiIn.setTxtKakuninShotokuKubun(setaiIn1.getTxtIchiranShotokuKubun().concat(new RString("<br>")).concat(setaiIn2.getTxtIchiranShotokuKubun()));
        singleHakkoSetaiIn.setTxtSofusaki(setaiIn1.getTxtSoYubinNo().concat(new RString("　"))
                .concat(setaiIn1.getTxtSofusaki01()).concat(setaiIn1.getTxtSofusaki02()).concat(setaiIn1.getTxtSofusaki03())
                .concat(new RString("<br>")).concat(setaiIn1.getTxtSofusakiOnchu()).concat(new RString("御中")).concat(new RString("　"))
                .concat(setaiIn1.getTxtSofusakisama()).concat(new RString("様")));
        if (setaiIn1.getTxtTenshutsusakiJusho().isEmpty()) {
            singleHakkoSetaiIn.setTxtTennyuuOrTenshutsu(new RString("転入前"));
        } else {
            singleHakkoSetaiIn.setTxtTennyuuOrTenshutsu(new RString("転出先"));
        }
        return singleHakkoSetaiIn;
    }

    private void setShuseiShori(dgShotokuShokaiHyoHakko_Row kojinRow, SofusakiGenJushoShuseiPanelDiv shuseiPanel) {

        kojinRow.setTxtSoYubinNo(shuseiPanel.getSofusakiNyuryokuPanel().getTxtSofusakiYubinNo().getValue());
        kojinRow.setTxtSofusaki01(shuseiPanel.getSofusakiNyuryokuPanel().getTxtSofusaki01().getValue());
        kojinRow.setTxtSofusaki02(shuseiPanel.getSofusakiNyuryokuPanel().getTxtSofusaki02().getValue());
        kojinRow.setTxtSofusaki03(shuseiPanel.getSofusakiNyuryokuPanel().getTxtSofusaki03().getValue());
        kojinRow.setTxtSofusakiOnchu(shuseiPanel.getSofusakiNyuryokuPanel().getTxtSofusakiOnchu().getValue());
        kojinRow.setTxtSofusakisama(shuseiPanel.getSofusakiNyuryokuPanel().getTxtSofusakiSama().getValue());
        if (shuseiPanel.getSofusakiNyuryokuPanel().getRadMaeJusho().getSelectedItem().equals(new RString("key0"))) {
            kojinRow.setTxtTennyumaeJusho(shuseiPanel.getSofusakiNyuryokuPanel().getTxtMaeJusho().getValue());
        } else {
            kojinRow.setTxtTenshutsusakiJusho(shuseiPanel.getSofusakiNyuryokuPanel().getTxtMaeJusho().getValue());
        }
        kojinRow.setTxtGenJusho(shuseiPanel.getGenJushoNyuryokuPanel().getTxtGenJusho().getValue());
    }

    public ResponseData<ShotokuShokaiHakkoKojinMainDiv> onClickSofusakiZenkokuJushoSet(ShotokuShokaiHakkoKojinMainDiv panel) {
        ResponseData<ShotokuShokaiHakkoKojinMainDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    public ResponseData<ShotokuShokaiHakkoKojinMainDiv> onClickGenJushoZenkokuJushoSet(ShotokuShokaiHakkoKojinMainDiv panel) {
        ResponseData<ShotokuShokaiHakkoKojinMainDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    public ResponseData<ShotokuShokaiHakkoKojinMainDiv> onClickMaeJushoZenkokuJushoSet(ShotokuShokaiHakkoKojinMainDiv panel) {
        ResponseData<ShotokuShokaiHakkoKojinMainDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    public ResponseData<ShotokuShokaiHakkoKojinMainDiv> onClickSashidashininZenkokuJushoSet(ShotokuShokaiHakkoKojinMainDiv panel) {
        ResponseData<ShotokuShokaiHakkoKojinMainDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }
}
