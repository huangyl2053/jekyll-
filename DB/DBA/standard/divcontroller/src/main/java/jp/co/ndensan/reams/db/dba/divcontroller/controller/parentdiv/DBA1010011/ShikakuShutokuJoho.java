/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1010011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.controller.helper.DemoKojin;
//import static jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.DBA1010011StateName.医療保険入力;
//import static jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.DBA1010011StateName.施設入退所入力;
//import static jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.DBA1010011StateName.被保履歴入力;
//import static jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.DBA1010011StateName.資格取得情報登録;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.ShikakuShutokuJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.ShikakuShutokuSearchDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.dgRohukuNenkinRireki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.dgSeikatsuHogoRireki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.tplIryoHokenDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.tplRofukuNenkinDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.tplSeikatsuHogoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.tplShikakuJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 資格取得処理を行うDivControllerです。<br/>
 * 資格情報以外にも、医療保険や生活保護などの情報を表示し、修正や追加なども行うことができます。
 *
 * @author n8178 城間篤人
 */
public class ShikakuShutokuJoho {

//    private static final RString HIHOKENSHA_DAICHO_DATA = new RString("DBA1010011/shikakuTokuso.yml");
//    private static final RString IRYO_HOKEN_DATA = new RString("DBA1010011/iryoHoken.yml");
    private static final RString ROFUKU_NENKIN_DATA = new RString("DBA1010011/rofukuNenkin.yml");
    private static final RString SEIKATSU_HOGO_DATA = new RString("DBA1010011/seikatsuHogo.yml");
//    private static final RString SHISETSU_NYUTAISHO_DATA = new RString("DBA1010011/shisetsuNyutaisho.yml");
//    private static final RString DDL_SHUTOKU_JIYU = new RString("DBA1010011/ddlShutokuJiyu.yml");

 //   private static final RString SHIKAKU_ADD = new RString("add");
    private static final RString SHIKAKU_MODIFY = new RString("modify");
    private static final RString SHIKAKU_DELETE = new RString("delete");
    private static final RString IRYO_HOKEN_ADD = new RString("add");
    private static final RString IRYO_HOKEN_MODIFY = new RString("modify");
    private static final RString IRYO_HOKEN_DELETE = new RString("delete");

    /**
     * 対象者選択で、資格取得を行う個人が決定された際に実行されます。<br/>
     * 対象となる個人の、資格得喪、医療保険、生活保護、老齢福祉年金、施設入退所の情報を全て表示します。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param searchDiv 検索Div
     * @return レスポンス
     */
    public ResponseData onClick_btnToDecide(ShikakuShutokuJohoDiv shikakuJohoDiv, ShikakuShutokuSearchDiv searchDiv) {
        ResponseData<ShikakuShutokuJohoDiv> response = new ResponseData<>();

        DemoKojin demoKojin = new DemoKojin("第2号");
        RString shikibetsuCode = demoKojin.getShikibetsuCode();

        setShikakuJoho(shikakuJohoDiv, shikibetsuCode);
        setIryoHoken(shikakuJohoDiv, shikibetsuCode);
        setRofukuNenkin(shikakuJohoDiv, shikibetsuCode);
        setSeikatsuHogo(shikakuJohoDiv, shikibetsuCode);
        setShisetsuNyutaisho(shikakuJohoDiv, shikibetsuCode);

        setShutokuJiyu(shikakuJohoDiv.getTabInputs().getTplShikakuJoho());

        response.data = shikakuJohoDiv;
        return response;
    }

    /**
     * 資格情報Tabに初期表示する値を設定します。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param shikibetsuCode 識別コード
     */
    private void setShikakuJoho(ShikakuShutokuJohoDiv shikakuJohoDiv, RString shikibetsuCode) {
    //    tplShikakuJohoDiv tplShikakuJoho = shikakuJohoDiv.getTabInputs().getTplShikakuJoho();
//
//        List<HashMap> hihokenshaDaichoDataList = YamlLoader.DBA.loadAsList(HIHOKENSHA_DAICHO_DATA);
//        DataGrid<dgShikakuShutokuRireki_Row> grid = tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki();
//        List<dgShikakuShutokuRireki_Row> dataSource = new ArrayList<>();
//        for (HashMap hihokenshaDaichoData : hihokenshaDaichoDataList) {
//            if (hihokenshaDaichoData.get("識別コード").toString().equals(shikibetsuCode.toString())) {
//
//                shikakuJohoDiv.setDateOfBirth(new RString(hihokenshaDaichoData.get("生年月日").toString()));
//                dataSource = createShikakuShutokuRirekiList((List<HashMap>) hihokenshaDaichoData.get("被保台帳"));
//            }
//        }
//        grid.setDataSource(dataSource);
//
//        if (dataSource.isEmpty()) {
//            shikakuJohoDiv.setShikakuInputMode(SHIKAKU_ADD);
//            setShikakuJohoDisabled(tplShikakuJoho, false);
//            shikakuJohoDiv.getTabInputs().getTplShikakuJoho().getShikakuTokusoRireki()
//                    .getDgShikakuShutokuRireki().getGridSetting().setIsShowDeleteButtonColumn(false);
//        } else {
//            shikakuJohoDiv.setShikakuInputMode(SHIKAKU_MODIFY);
//            shikakuJohoDiv.setShikakuSelectRow(new RString("0"));
//            setShikakuJohoDisabled(tplShikakuJoho, false);
//        }
    }
//
//    private List<dgShikakuShutokuRireki_Row> createShikakuShutokuRirekiList(List<HashMap> hihokenshaDaichoData) {
//        List<dgShikakuShutokuRireki_Row> dataSource = new ArrayList<>();
//        for (HashMap hihoDaichoDataRow : hihokenshaDaichoData) {
//            dataSource.add(createShikakuShutokuRirekiRowFromHashMap(hihoDaichoDataRow));
//        }
//        return dataSource;
//    }
//
//    private dgShikakuShutokuRireki_Row createShikakuShutokuRirekiRowFromHashMap(HashMap hihokenshaDaichoData) {
//        dgShikakuShutokuRireki_Row row = new dgShikakuShutokuRireki_Row(new Button(), new TextBoxFlexibleDate(),
//                new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
//                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY,
//                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY,
//                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY,
//                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY,
//                new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
//
//        ControlGenerator generator = new ControlGenerator(hihokenshaDaichoData);
//        row.getShutokuTodokedeDate().setValue(generator.getAsFlexibleDate("取得届出日"));
//        row.getShutokuDate().setValue(generator.getAsFlexibleDate("取得日"));
//        row.setShutokuJiyu(generator.getAsRString("取得事由"));
//        row.setShutokuJiyuKey(generator.getAsRString("取得事由Key"));
//        row.getSoshitsuTodokedeDate().setValue(generator.getAsFlexibleDate("喪失届出日"));
//        row.getSoshitsuDate().setValue(generator.getAsFlexibleDate("喪失日"));
//        row.setSoshitsuJiyu(generator.getAsRString("喪失事由"));
//        row.setSoshitsuJiyuKey(generator.getAsRString("喪失事由Key"));
//        row.setHihokenshaKubunKey(generator.getAsRString("被保区分Key"));
//        row.setHihokenshaKubun(generator.getAsRString("被保区分"));
//        row.getJutokuKaijoTodokedeDate().setValue(generator.getAsFlexibleDate("解除届出日"));
//        row.getJutokuKaijoDate().setValue(generator.getAsFlexibleDate("解除日"));
//        row.setJutokuKaijoJiyu(generator.getAsRString("解除事由"));
//        row.setJutokuKaijoJiyuKey(generator.getAsRString("解除事由Key"));
//        row.getJutokuTekiyoTodokedeDate().setValue(generator.getAsFlexibleDate("適用届出日"));
//        row.getJutokuTekiyoDate().setValue(generator.getAsFlexibleDate("適用日"));
//        row.setJutokuTekiyoJiyu(generator.getAsRString("適用事由"));
//        row.setJutokuTekiyoJiyuKey(generator.getAsRString("適用事由Key"));
//        row.getHenkoTodokedeDate().setValue(generator.getAsFlexibleDate("変更届出日"));
//        row.getHenkoDate().setValue(generator.getAsFlexibleDate("変更日"));
//        row.setHenkoJiyu(generator.getAsRString("変更事由"));
//        row.setHenkoJiyuKey(generator.getAsRString("変更事由Key"));
//        row.getNenreiTotatsuDate().setValue(generator.getAsFlexibleDate("1号年齢到達日"));
//        row.setKyuHokensha(generator.getAsRString("旧保険者"));
//        row.setShikibetsuCode(generator.getAsRString("識別コード"));
//        return row;
//    }

    private void setShikakuJohoDisabled(tplShikakuJohoDiv tplShikakuJoho, boolean disableValue) {
        //TODO n8187久保田 画面Entiityが変更されたがコード未対応のためエラーが発生するのでコメントアウト
//        tplShikakuJoho.getShikakuShutokuInput().setDisabled(disableValue);
//        tplShikakuJoho.getBtnUpdateShikaku().setDisabled(disableValue);
    }

    /**
     * 医療保険Tabに初期表示する値を設定します。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param shikibetsuCode 識別コード
     */
    private void setIryoHoken(ShikakuShutokuJohoDiv shikakuJohoDiv, RString shikibetsuCode) {
        //TODO n8187久保田 画面Entiityが変更されたがコード未対応のためエラーが発生するのでコメントアウト
//        tplIryoHokenDiv tplIryoHoken = shikakuJohoDiv.getTabInputs().getTplIryoHoken();
//
//        List<HashMap> iryoHokenDataList = YamlLoader.DBA.loadAsList(IRYO_HOKEN_DATA);
//        DataGrid<dgIryoHokenRireki_Row> grid = tplIryoHoken.getIryoHokenRireki().getDgIryoHokenRireki();
//        List<dgIryoHokenRireki_Row> dataSource = new ArrayList<>();
//        for (HashMap iryoHokenData : iryoHokenDataList) {
//            if (iryoHokenData.get("識別コード").toString().equals(shikibetsuCode.toString())) {
//                dataSource = createDgIryoHokenRirekiList((List<HashMap>) iryoHokenData.get("医療保険"));
//            }
//        }
//        grid.setDataSource(dataSource);
//
//        if (dataSource.isEmpty()) {
//            shikakuJohoDiv.setIryoHokenInputMode(IRYO_HOKEN_ADD);
//            setIryoHokenDisabled(tplIryoHoken, false);
//
//            tplIryoHoken.getBtnAddIryoHoken().setDisabled(true);
//        } else {
//            setIryoHokenDisabled(tplIryoHoken, true);
//            tplIryoHoken.getBtnAddIryoHoken().setDisabled(false);
//        }
    }

//    private List<dgIryoHokenRireki_Row> createDgIryoHokenRirekiList(List<HashMap> iryoHokenData) {
//        List<dgIryoHokenRireki_Row> dataSource = new ArrayList<>();
//        for (HashMap iryoHokenDataRow : iryoHokenData) {
//            dataSource.add(createDgIryoHokenRirekiRowFrowHashMap(iryoHokenDataRow));
//        }
//        return dataSource;
//    }

//    private dgIryoHokenRireki_Row createDgIryoHokenRirekiRowFrowHashMap(HashMap hihokenshaDaichoData) {
//        dgIryoHokenRireki_Row row = new dgIryoHokenRireki_Row(RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY,
//                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
//
//        ControlGenerator generator = new ControlGenerator(hihokenshaDaichoData);
//        row.setHokenshaNo(generator.getAsRString("保険者番号"));
//        row.setHokenshaMeisho(generator.getAsRString("保険者名称"));
//        row.setHokensha(row.getHokenshaNo().concat(":").concat(row.getHokenshaMeisho()));
//        row.setIryoHokenShubetsuKey(generator.getAsRString("保険者種別Key"));
//        row.setIryoHokenShubetsu(generator.getAsRString("保険者種別"));
//        row.getKanyuDate().setValue(generator.getAsFlexibleDate("加入日"));
//        row.getDattaiDate().setValue(generator.getAsFlexibleDate("脱退日"));
//        row.setKigoNo(generator.getAsRString("記号番号"));
//        return row;
//    }

    private void setIryoHokenDisabled(tplIryoHokenDiv tplIryoHoken, boolean disableValue) {
        //TODO n8187久保田 画面Entiityが変更されたがコード未対応のためエラーが発生するのでコメントアウト
//        tplIryoHoken.getIryoHokenInput().setDisabled(disableValue);
//        tplIryoHoken.getBtnUpdateIryoHoken().setDisabled(disableValue);
    }

    /**
     * 老福年金Tabに初期表示する値を設定します。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param shikibetsuCode 識別コード
     */
    private void setRofukuNenkin(ShikakuShutokuJohoDiv shikakuJohoDiv, RString shikibetsuCode) {
        tplRofukuNenkinDiv tplRofukuNenkin = shikakuJohoDiv.getTabInputs().getTplRofukuNenkin();

        List<HashMap> rofukuNenkinDataList = YamlLoader.DBA.loadAsList(ROFUKU_NENKIN_DATA);
        DataGrid<dgRohukuNenkinRireki_Row> grid = tplRofukuNenkin.getRohukuNenkin().getDgRohukuNenkinRireki();
        List<dgRohukuNenkinRireki_Row> dataSource = new ArrayList<>();
        for (HashMap rofukuNenkiData : rofukuNenkinDataList) {
            if (rofukuNenkiData.get("識別コード").toString().equals(shikibetsuCode.toString())) {
                dataSource = createRofukuNenkinList((List<HashMap>) rofukuNenkiData.get("老福情報"));
            }
        }
        grid.setDataSource(dataSource);

        if (dataSource.isEmpty()) {
            setRofukuNenkinDisabled(tplRofukuNenkin, false);
        } else {
            setRofukuNenkinDisabled(tplRofukuNenkin, true);
        }
    }

    private List<dgRohukuNenkinRireki_Row> createRofukuNenkinList(List<HashMap> rofukuNenkiData) {
        List<dgRohukuNenkinRireki_Row> dataSource = new ArrayList<>();
        for (HashMap rofukuNenkiDataRow : rofukuNenkiData) {
            dataSource.add(createRofukuNenkinRowFromHashMap(rofukuNenkiDataRow));
        }
        return dataSource;
    }

    private dgRohukuNenkinRireki_Row createRofukuNenkinRowFromHashMap(HashMap rofukuNenkiData) {
        dgRohukuNenkinRireki_Row row = new dgRohukuNenkinRireki_Row(new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY);

        ControlGenerator generator = new ControlGenerator(rofukuNenkiData);
        row.setJukyushaNo(generator.getAsRString("受給者番号"));
        row.getKaishiDate().setValue(generator.getAsFlexibleDate("開始日"));
        row.getShuryoDate().setValue(generator.getAsFlexibleDate("廃止日"));
        return row;
    }

    private void setRofukuNenkinDisabled(tplRofukuNenkinDiv tplRofukuNenkin, boolean disableValue) {
        //TODO n8187久保田 画面Entiityが変更されたがコード未対応のためエラーが発生するのでコメントアウト
//        tplRofukuNenkin.getRohukuNenkin().getRohukuNenkinInput().setDisabled(disableValue);
//        tplRofukuNenkin.getRohukuNenkin().getBtnUpdateRofukuNenkin().setDisabled(disableValue);
    }

    /**
     * 生活保護Tabに初期表示する値を設定します。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param shikibetsuCode 識別コード
     */
    private void setSeikatsuHogo(ShikakuShutokuJohoDiv shikakuJohoDiv, RString shikibetsuCode) {
        tplSeikatsuHogoDiv tplSeikatsuHogo = shikakuJohoDiv.getTabInputs().getTplSeikatsuHogo();

        List<HashMap> seikatsuHogoDataList = YamlLoader.DBA.loadAsList(SEIKATSU_HOGO_DATA);
        DataGrid<dgSeikatsuHogoRireki_Row> grid = tplSeikatsuHogo.getSeikatsuHogo().getDgSeikatsuHogoRireki();
        List<dgSeikatsuHogoRireki_Row> dataSource = new ArrayList<>();
        for (HashMap seikatsuHogoData : seikatsuHogoDataList) {
            if (seikatsuHogoData.get("識別コード").toString().equals(shikibetsuCode.toString())) {
                dataSource = createSeikatsuHogoList((List<HashMap>) seikatsuHogoData.get("生保情報"));
            }
        }
        grid.setDataSource(dataSource);

        if (dataSource.isEmpty()) {
            setSeikatsuHogoDisabled(tplSeikatsuHogo, false);
        } else {
            setSeikatsuHogoDisabled(tplSeikatsuHogo, true);
        }
    }

    private List<dgSeikatsuHogoRireki_Row> createSeikatsuHogoList(List<HashMap> seikatsuHogoData) {
        List<dgSeikatsuHogoRireki_Row> dataSource = new ArrayList<>();
        for (HashMap seikatsuHogoDataRow : seikatsuHogoData) {
            dataSource.add(createSeikatsuHogoRowFromHashMap(seikatsuHogoDataRow));
        }
        return dataSource;
    }

    private dgSeikatsuHogoRireki_Row createSeikatsuHogoRowFromHashMap(HashMap seikatsuHogoData) {
        dgSeikatsuHogoRireki_Row row = new dgSeikatsuHogoRireki_Row(new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
                RString.EMPTY, RString.EMPTY, RString.EMPTY);

        ControlGenerator generator = new ControlGenerator(seikatsuHogoData);
        row.setJukyushaNo(generator.getAsRString("受給者番号"));
        row.getKaishiDate().setValue(generator.getAsFlexibleDate("開始日"));
        row.getShuryoDate().setValue(generator.getAsFlexibleDate("廃止日"));
        row.setSeihoShubetsu(generator.getAsRString("種別"));
        row.setSeihoShubetsuKey(generator.getAsRString("種別Key"));
        return row;
    }

    private void setSeikatsuHogoDisabled(tplSeikatsuHogoDiv tplSeikatsuHogo, boolean disableValue) {
        tplSeikatsuHogo.getSeikatsuHogo().getSeikatsuHogoInput().setDisabled(disableValue);
        tplSeikatsuHogo.getSeikatsuHogo().getBtnUpdataSeikatsuHogo().setDisabled(disableValue);
    }

    /**
     * 施設入退所Tabに初期表示する値を設定します。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param shikibetsuCode 識別コード
     */
    private void setShisetsuNyutaisho(ShikakuShutokuJohoDiv shikakuJohoDiv, RString shikibetsuCode) {
        //TODO n8187久保田 画面部品が変更されていたがコード未対応のためエラーが発生していたのでコメントアウト
//        tplShisetsuNyutaishoDiv tplShisetsuNyutaisho = shikakuJohoDiv.getTabInputs().getTplShisetsuNyutaisho();
//
//        List<HashMap> shisetsuNyutaishoRirekiDataList = YamlLoader.DBA.loadAsList(SHISETSU_NYUTAISHO_DATA);
//        DataGrid<dgShisetsuNyutaishoRireki_Row> grid = tplShisetsuNyutaisho.getShisetsuNyutaishoRirekiKanri().getDgShisetsuNyutaishoRireki();
//        List<dgShisetsuNyutaishoRireki_Row> dataSource = new ArrayList<>();
//        for (HashMap shisetsuNyutaishoRirekiData : shisetsuNyutaishoRirekiDataList) {
//            if (shisetsuNyutaishoRirekiData.get("識別コード").toString().equals(shikibetsuCode.toString())) {
//                dataSource = createShisetsuNyutaishoList((List<HashMap>) shisetsuNyutaishoRirekiData.get("異動履歴"));
//            }
//        }
//        grid.setDataSource(dataSource);
//
//        if (dataSource.isEmpty()) {
//            setShisetsuNyutaishoDisabled(tplShisetsuNyutaisho, false);
//        } else {
//            setShisetsuNyutaishoDisabled(tplShisetsuNyutaisho, true);
//        }

//        DropDownList ddl = tplShisetsuNyutaisho.getShisetsuNyutaishoRirekiKanri().getShisetsuNyutaishoInput().getDdlTaishoJoho();
//        ddl.setDataSource(ddl.getDataSource().subList(0, 2));
//        RadioButton rad = tplShisetsuNyutaisho.getShisetsuNyutaishoRirekiKanri().getShisetsuNyutaishoInput().getShisetsuJoho().getRadShisetsuShurui();
//        rad.setDataSource(rad.getDataSource().subList(0, 2));
    }

//    private List<dgShisetsuNyutaishoRireki_Row> createShisetsuNyutaishoList(List<HashMap> shisetsuNyutaishoData) {
//        List<dgShisetsuNyutaishoRireki_Row> dataSource = new ArrayList<>();
//        for (HashMap shisetsuNyutaishoDataRow : shisetsuNyutaishoData) {
//            dataSource.add(createShisetsuNyutaishoRowFromHashMap(shisetsuNyutaishoDataRow));
//        }
//        return dataSource;
//    }

//    private dgShisetsuNyutaishoRireki_Row createShisetsuNyutaishoRowFromHashMap(HashMap seikatsuHogoData) {
//        dgShisetsuNyutaishoRireki_Row row = new dgShisetsuNyutaishoRireki_Row(RString.EMPTY, new TextBoxFlexibleDate(),
//                new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
//                RString.EMPTY, RString.EMPTY, RString.EMPTY);
//
//        ControlGenerator generator = new ControlGenerator(seikatsuHogoData);
//        row.getNyushoDate().setValue(generator.getAsFlexibleDate("入所日"));
//        row.getTaishoDate().setValue(generator.getAsFlexibleDate("退所日"));
//        row.setShisetsuCode(generator.getAsRString("施設コード"));
//        row.setShisetsuMeisho(generator.getAsRString("施設名称"));
//        row.setShisetsu(row.getShisetsuCode().concat(":").concat(row.getShisetsuMeisho()));
////        row.setTaishoJohoKey(generator.getAsRString("対象情報Key"));
////        row.setTaishoJoho(generator.getAsRString("対象情報"));
//        row.setShisetsuShuruiKey(generator.getAsRString("施設種類Key"));
//        row.setShisetsuShurui(generator.getAsRString("施設種類"));
//        return row;
//    }

//    private void setShisetsuNyutaishoDisabled(tplShisetsuNyutaishoDiv tplShisetsuNyutaisho, boolean disableValue) {
////        tplShisetsuNyutaisho.getShisetsuNyutaishoRirekiKanri().getShisetsuNyutaishoInput().setDisabled(disableValue);
////        tplShisetsuNyutaisho.getShisetsuNyutaishoRirekiKanri().getBtnUpdateShisetsuNyutaisho().setDisabled(disableValue);
//    }

    private void setShutokuJiyu(tplShikakuJohoDiv shikakuJohoDiv) {

        //TODO n8187久保田 画面Entiityが変更されたがコード未対応のためエラーが発生するのでコメントアウト
//        DropDownList ddl = shikakuJohoDiv.getShikakuShutokuInput().getDdlShikakuShutokuJiyu();
//        ddl.setDataSource(createDdlShutokuJiyu());
//        SqlSession session = _DbSession.get(_WorkFlowSession.KEY);
//        _FlowDefinitionDac dac = new _FlowDefinitionDac(session);
//        FlowKey flowKey = dac.getFlowKey(_ControlDataHolder.getControlData().getFlowContext().getFlowInstanceId());
//
//        RString flowId = new RString(flowKey.getFlowId().getId());
//
//        if (KaigoMenuType.転入により取得.getFlowId().equals(flowId)) {
//            createPartOfDdlShutokuJiyu(ddl, "tennyu");
//        } else if (KaigoMenuType.第2号被保険者取得申請により取得.getFlowId().equals(flowId)) {
//            createPartOfDdlShutokuJiyu(ddl, "nigoShinsei");
//        } else if (KaigoMenuType.外国人申請により取得.getFlowId().equals(flowId)) {
//            createPartOfDdlShutokuJiyu(ddl, "gaikokuJin");
//        } else if (KaigoMenuType.年齢到達により取得.getFlowId().equals(flowId)) {
//            createPartOfDdlShutokuJiyu(ddl, "nenreiTotatsu");
//        } else if (KaigoMenuType.転居により取得_施設退所等.getFlowId().equals(flowId)) {
//            createPartOfDdlShutokuJiyu(ddl, "gappeinaiTenkyo");
//        } else if (KaigoMenuType.帰化により取得.getFlowId().equals(flowId)) {
//            createPartOfDdlShutokuJiyu(ddl, "kika");
//        } else if (KaigoMenuType.職権により取得.getFlowId().equals(flowId)) {
//            createPartOfDdlShutokuJiyu(ddl, "shokkenShutoku");
//        }
    }

//    private List<KeyValueDataSource> createDdlShutokuJiyu() {
//
//        HashMap<String, String> ddlSource = (HashMap) YamlLoader.DBA.loadAsMap(DDL_SHUTOKU_JIYU);
//        List<KeyValueDataSource> ddlSourceList = new ArrayList<>();
//        for (Map.Entry<String, String> ddlSourceItem : ddlSource.entrySet()) {
//            KeyValueDataSource ddlSourceListItem = new KeyValueDataSource(new RString(ddlSourceItem.getKey()),
//                    new RString(ddlSourceItem.getValue()));
//            ddlSourceList.add(ddlSourceListItem);
//        }
//        return ddlSourceList;
//    }

//    private void createPartOfDdlShutokuJiyu(DropDownList ddl, String key) {
//
//        List<KeyValueDataSource> ddlSourceList = new ArrayList<>();
//        for (KeyValueDataSource ddlSourceItem : ddl.getDataSource()) {
//            if (ddlSourceItem.getKey().toString().equals(key)) {
//                ddlSourceList.add(ddlSourceItem);
//            }
//        }
//        ddl.setDataSource(ddlSourceList);
//        ddl.setSelectedItem(new RString(key));
//    }

    /**
     * 資格情報タブ内の処理です。グリッド内の視覚情報修正ボタンがクリックされた際に実行します。<br/>
     * 入力モードを修正モードに変更し、選択したグリッドのデータを表示します。また、確定ボタンのラベルが修正用に変更されます。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param searchDiv 検索Div
     * @return レスポンス
     */
    public ResponseData onSelectOfModifyButton_dgShikakuShutokuRireki(ShikakuShutokuJohoDiv shikakuJohoDiv, ShikakuShutokuSearchDiv searchDiv) {
        ResponseData<ShikakuShutokuJohoDiv> response = new ResponseData<>();
//        tplShikakuJohoDiv tplShikakuJoho = shikakuJohoDiv.getTabInputs().getTplShikakuJoho();

        shikakuJohoDiv.setShikakuInputMode(SHIKAKU_MODIFY);
//        shikakuJohoDiv.setShikakuSelectRow(
//                //                new RString(Integer.toString(tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki().getClickedRowId())));
//                //        setShikakuJohoInput(tplShikakuJoho, tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki().getClickedItem());
//                setShikakuJohoDisabled(tplShikakuJoho, false);
        response.data = shikakuJohoDiv;
        return response;
    }

    /**
     * 資格情報タブ内の処理です。グリッド内の資格情報削除ボタンがクリックされた際に実行します。<br/>
     * 入力モードを削除モードに変更し、確定ボタン以外のコントロールを編集不可状態で詳細表示します。また、確定ボタンのラベルが削除用に変更されます。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param searchDiv 検索Div
     * @return レスポンス
     */
    public ResponseData onSelectOfDeleteButton_dgShikakuShutokuRireki(ShikakuShutokuJohoDiv shikakuJohoDiv, ShikakuShutokuSearchDiv searchDiv) {
        ResponseData<ShikakuShutokuJohoDiv> response = new ResponseData<>();
        tplShikakuJohoDiv tplShikakuJoho = shikakuJohoDiv.getTabInputs().getTplShikakuJoho();

        shikakuJohoDiv.setShikakuInputMode(SHIKAKU_DELETE);
//        shikakuJohoDiv.setShikakuSelectRow(new RString(Integer.toString(tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki().getClickedRowId())));
//        setShikakuJohoInput(tplShikakuJoho, tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki().getClickedItem());
        setShikakuJohoDisabled(tplShikakuJoho, true);
        //TODO n8187久保田 画面Entiityが変更されたがコード未対応のためエラーが発生するのでコメントアウト
//        tplShikakuJoho.getBtnUpdateShikaku().setDisabled(false);
        response.data = shikakuJohoDiv;
        return response;
    }

    /**
     * 資格情報タブ内の処理です。資格情報確定ボタンがクリックされた際に実行します。<br/>
     * 新規追加モードの場合は、行を新しく用意して、入力内容をグリッドに追加します。<br/>
     * 修正モードの場合は、選択したグリッドに入力内容を反映させます<br/>
     * 削除モードの場合は、選択しているグリッドの状態を削除に変更します。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param searchDiv 検索Div
     * @return レスポンス
     */
    public ResponseData onClick_btnUpdateShikaku(ShikakuShutokuJohoDiv shikakuJohoDiv, ShikakuShutokuSearchDiv searchDiv) {
        ResponseData<ShikakuShutokuJohoDiv> response = new ResponseData<>();
        tplShikakuJohoDiv tplShikakuJoho = shikakuJohoDiv.getTabInputs().getTplShikakuJoho();
//        int selectRowNum;
////        dgShikakuShutokuRireki_Row selectRow;
//
//        FlexibleDate dateOfBirth = new FlexibleDate(shikakuJohoDiv.getDateOfBirth());
//
//        if (shikakuJohoDiv.getShikakuInputMode().equals(SHIKAKU_ADD)) {
//            dgShikakuShutokuRireki_Row row = createShikakuShutokuRirekiRowFromInputValue(tplShikakuJoho, dateOfBirth);
//            row.setRowState(RowState.Added);
//            tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki().getDataSource().add(0, row);
//        } else if (shikakuJohoDiv.getShikakuInputMode().equals(SHIKAKU_MODIFY)) {
//            selectRowNum = Integer.parseInt(shikakuJohoDiv.getShikakuSelectRow().toString());
//            selectRow = tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki().getDataSource().get(selectRowNum);
//            setShikakuShutokuRirekiRowFromInputValue(tplShikakuJoho, selectRow, dateOfBirth);
//            if (selectRow.getRowState().equals(RowState.Added)) {
//            } else {
//                selectRow.setRowState(RowState.Modified);
//            }
//        } else if (shikakuJohoDiv.getShikakuInputMode().equals(SHIKAKU_DELETE)) {
//            selectRowNum = Integer.parseInt(shikakuJohoDiv.getShikakuSelectRow().toString());
//            selectRow = tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki().getDataSource().get(selectRowNum);
//            if (selectRow.getRowState().equals(RowState.Added)) {
//                tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki().getDataSource().remove(selectRowNum);
//            } else {
//                tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki().getDataSource().get(selectRowNum).setRowState(RowState.Deleted);
//            }
//        }

        setShikakuJohoDisabled(tplShikakuJoho, true);
        clearShikakuJohoInput(shikakuJohoDiv.getTabInputs().getTplShikakuJoho());
        response.data = shikakuJohoDiv;
        return response;
    }
//
//    private dgShikakuShutokuRireki_Row createShikakuShutokuRirekiRowFromInputValue(tplShikakuJohoDiv tplShikakuJoho, FlexibleDate dateOfBirth) {
//        dgShikakuShutokuRireki_Row row = new dgShikakuShutokuRireki_Row(new Button(), new TextBoxFlexibleDate(),
//                new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
//                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY,
//                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY,
//                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY,
//                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY,
//                new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
//
//        setShikakuShutokuRirekiRowFromInputValue(tplShikakuJoho, row, dateOfBirth);
//        return row;
//    }
//
//    private void setShikakuShutokuRirekiRowFromInputValue(tplShikakuJohoDiv tplShikakuJoho,
//            dgShikakuShutokuRireki_Row row, FlexibleDate dateOfBirth) {
//
//        ShikakuShutokuInputDiv shutoku = tplShikakuJoho.getShikakuShutokuInput();
//        row.getShutokuTodokedeDate().setValue(shutoku.getTxtShutokuTodokedeDate().getValue());
//        row.getShutokuDate().setValue(shutoku.getTxtShutokuDate().getValue());
//        row.setShutokuJiyu(shutoku.getDdlShikakuShutokuJiyu().getSelectedValue());
//        row.setShutokuJiyuKey(shutoku.getDdlShikakuShutokuJiyu().getSelectedItem());
//
//        FlexibleDate nenreiTotatsuDate = dateOfBirth.plusYear(65).minusDay(1);
//        if (nenreiTotatsuDate.isBefore(row.getShutokuDate().getValue())) {
//            row.setHihokenshaKubun(new RString("第1号"));
//            row.getNenreiTotatsuDate().setValue(nenreiTotatsuDate);
//        } else {
//            row.setHihokenshaKubun(new RString("第2号"));
//            row.getNenreiTotatsuDate().setValue(null);
//        }
//
//    }
//
//    private void setShikakuJohoInput(tplShikakuJohoDiv tplShikakuJoho, dgShikakuShutokuRireki_Row row) {
//        setShikakuShutokuJohoInput(tplShikakuJoho, row.getShutokuJiyuKey(), row.getShutokuDate().getValue(),
//                row.getShutokuTodokedeDate().getValue(), row.getHihokenshaKubunKey(), row.getNenreiTotatsuDate().getValue());
//    }

    private void clearShikakuJohoInput(tplShikakuJohoDiv tplShikakuJoho) {
        setShikakuShutokuJohoInput(tplShikakuJoho, new RString("tennyu"), null, null, new RString("dai1Go"), null);
    }

    private void setShikakuShutokuJohoInput(tplShikakuJohoDiv tplShikakuJoho, RString ddlShikakuShutokuJiyu, FlexibleDate shutokuDate,
            FlexibleDate shutokuTodokedeDate, RString ddlHihokenshaKubun, FlexibleDate nenreiTotatsuDate) {
        //TODO n8187久保田 画面Entiityが変更されたがコード未対応のためエラーが発生するのでコメントアウト
//        ShikakuShutokuInputDiv shikakuShutoku = tplShikakuJoho.getShikakuShutokuInput();
//        shikakuShutoku.getDdlShikakuShutokuJiyu().setSelectedItem(ddlShikakuShutokuJiyu);
//        shikakuShutoku.getTxtShutokuDate().setValue(ShutokuDate);
//        shikakuShutoku.getTxtShutokuTodokedeDate().setValue(ShutokuTodokedeDate);
    }

    /**
     * 医療保険タブ内の処理です。医療保険情報追加ボタンがクリックされた際に実行します。<br/>
     * 入力モードを新規追加モードに変更します。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param searchDiv 対象者検索Div
     * @return レスポンス
     */
    public ResponseData onClick_btnAddIryoHoken(ShikakuShutokuJohoDiv shikakuJohoDiv, ShikakuShutokuSearchDiv searchDiv) {
        ResponseData<ShikakuShutokuJohoDiv> response = new ResponseData<>();
        tplIryoHokenDiv tplIryoHoken = shikakuJohoDiv.getTabInputs().getTplIryoHoken();

        shikakuJohoDiv.setIryoHokenInputMode(IRYO_HOKEN_ADD);
        setIryoHokenDisabled(tplIryoHoken, false);
        clearIryoHokenInput(tplIryoHoken);
        response.data = shikakuJohoDiv;
        return response;
    }

    /**
     * 医療保険タブ内の処理です。資格情報修正ボタンがクリックされた際に実行します。<br/>
     * 入力モードを修正モードに変更します。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param searchDiv 対象者検索Div
     * @return レスポンス
     */
    public ResponseData onSelectOfModifyButton_dgIryoHokenRireki(ShikakuShutokuJohoDiv shikakuJohoDiv, ShikakuShutokuSearchDiv searchDiv) {
        ResponseData<ShikakuShutokuJohoDiv> response = new ResponseData<>();
//        tplIryoHokenDiv tplIryoHoken = shikakuJohoDiv.getTabInputs().getTplIryoHoken();

        shikakuJohoDiv.setIryoHokenInputMode(IRYO_HOKEN_MODIFY);
        //TODO n8187久保田 画面Entiityが変更されたがコード未対応のためエラーが発生するのでコメントアウト
//        shikakuJohoDiv.setIryoHokenSelectRow(new RString(Integer.toString(tplIryoHoken.getIryoHokenRireki().getDgIryoHokenRireki().getClickedRowId())));
//        setIryoHokenInput(tplIryoHoken, tplIryoHoken.getIryoHokenRireki().getDgIryoHokenRireki().getClickedItem());
//        setIryoHokenDisabled(tplIryoHoken, false);
        response.data = shikakuJohoDiv;
        return response;
    }

    /**
     * 医療保険タブ内の処理です。資格情報削除ボタンがクリックされた際に実行します。<br/>
     * 入力モードを削除に変更し、全てのコントロールをreadOnlyに変更します。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param searchDiv 対象者検索Div
     * @return レスポンス
     */
    public ResponseData onSelectOfDeleteButton_dgIryoHokenRireki(ShikakuShutokuJohoDiv shikakuJohoDiv, ShikakuShutokuSearchDiv searchDiv) {
        ResponseData<ShikakuShutokuJohoDiv> response = new ResponseData<>();
//        tplIryoHokenDiv tplIryoHoken = shikakuJohoDiv.getTabInputs().getTplIryoHoken();

        shikakuJohoDiv.setIryoHokenInputMode(IRYO_HOKEN_DELETE);
        //TODO n8187久保田 画面Entiityが変更されたがコード未対応のためエラーが発生するのでコメントアウト
//        shikakuJohoDiv.setIryoHokenSelectRow(new RString(Integer.toString(tplIryoHoken.getIryoHokenRireki().getDgIryoHokenRireki().getClickedRowId())));
//        setIryoHokenInput(tplIryoHoken, tplIryoHoken.getIryoHokenRireki().getDgIryoHokenRireki().getClickedItem());
//        setIryoHokenDisabled(tplIryoHoken, true);
//        tplIryoHoken.getBtnUpdateIryoHoken().setDisabled(false);
        response.data = shikakuJohoDiv;
        return response;
    }

    /**
     * 医療保険タブ内の処理です。資格情報確定ボタンがクリックされた際に実行します。<br/>
     * 新規追加モードの場合は、行を新しく用意して、入力内容をグリッドに追加します。<br/>
     * 修正モードの場合は、選択したグリッドに入力内容を反映させます<br/>
     * 削除モードの場合は、選択しているグリッドの状態を削除に変更します。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param searchDiv 対象者検索Div
     * @return レスポンス
     */
    public ResponseData onClick_btnUpdateIryoHoken(ShikakuShutokuJohoDiv shikakuJohoDiv, ShikakuShutokuSearchDiv searchDiv) {
        ResponseData<ShikakuShutokuJohoDiv> response = new ResponseData<>();
//        tplIryoHokenDiv tplIryoHoken = shikakuJohoDiv.getTabInputs().getTplIryoHoken();
//        int selectRowNum;

        //TODO n8187久保田 画面Entiityが変更されたがコード未対応のためエラーが発生するのでコメントアウト
//        if (shikakuJohoDiv.getIryoHokenInputMode().equals(IRYO_HOKEN_ADD)) {
//            dgIryoHokenRireki_Row row = createDgIryoHokenRirekiRowFrowInputValue(tplIryoHoken);
//            row.setRowState(RowState.Added);
//            tplIryoHoken.getIryoHokenRireki().getDgIryoHokenRireki().getDataSource().add(0, row);
//        } else if (shikakuJohoDiv.getIryoHokenInputMode().equals(IRYO_HOKEN_MODIFY)) {
//            selectRowNum = Integer.parseInt(shikakuJohoDiv.getIryoHokenSelectRow().toString());
//            dgIryoHokenRireki_Row selectRow = tplIryoHoken.getIryoHokenRireki().getDgIryoHokenRireki().getDataSource().get(selectRowNum);
//            setDgIryoHokenRirekiRowFrowInputValue(tplIryoHoken, selectRow);
//            if (selectRow.getRowState().equals(RowState.Added)) {
//            } else {
//                selectRow.setRowState(RowState.Modified);
//            }
//        } else if (shikakuJohoDiv.getIryoHokenInputMode().equals(IRYO_HOKEN_DELETE)) {
//            selectRowNum = Integer.parseInt(shikakuJohoDiv.getIryoHokenSelectRow().toString());
//            dgIryoHokenRireki_Row selectRow = tplIryoHoken.getIryoHokenRireki().getDgIryoHokenRireki().getDataSource().get(selectRowNum);
//            if (selectRow.getRowState().equals(RowState.Added)) {
//                tplIryoHoken.getIryoHokenRireki().getDgIryoHokenRireki().getDataSource().remove(selectRowNum);
//            } else {
//                selectRow.setRowState(RowState.Deleted);
//            }
//        }
//
//        setIryoHokenDisabled(tplIryoHoken, true);
//
//        tplIryoHoken.getBtnAddIryoHoken().setDisabled(false);
//        clearIryoHokenInput(tplIryoHoken);
        response.data = shikakuJohoDiv;
        return response;
    }

//    private void setIryoHokenInput(tplIryoHokenDiv tplIryoHoken, dgIryoHokenRireki_Row row) {
        //TODO n8187久保田 画面Entiityが変更されたがコード未対応のためエラーが発生するのでコメントアウト
//        IryoHokenInputDiv iryoHokenInput = tplIryoHoken.getIryoHokenInput();
//        iryoHokenInput.getTxtIryoHokenKanyuDate().setValue(row.getKanyuDate().getValue());
//        iryoHokenInput.getTxtIryoHokenDattaiDate().setValue(row.getDattaiDate().getValue());
//        iryoHokenInput.getTxtIryoHokenHokenshaNo().setValue(row.getHokenshaNo());
//        iryoHokenInput.getTxtIryoHokenHokenshaMeisho().setValue(row.getHokenshaMeisho());
//        iryoHokenInput.getDdlIryoHokenShubetsu().setSelectedItem(row.getIryoHokenShubetsuKey());
//        iryoHokenInput.getTxtIryoHokenKigoNo().setValue(row.getKigoNo());
//    }

    private void clearIryoHokenInput(tplIryoHokenDiv tplIryoHoken) {
        //TODO n8187久保田 画面Entiityが変更されたがコード未対応のためエラーが発生するのでコメントアウト
//        IryoHokenInputDiv iryoHokenInput = tplIryoHoken.getIryoHokenInput();
//        iryoHokenInput.getDdlIryoHokenShubetsu().setSelectedItem(new RString("kyokai"));
//        iryoHokenInput.getTxtIryoHokenDattaiDate().setValue(null);
//        iryoHokenInput.getTxtIryoHokenHokenshaMeisho().setValue(null);
//        iryoHokenInput.getTxtIryoHokenHokenshaNo().setValue(null);
//        iryoHokenInput.getTxtIryoHokenKanyuDate().setValue(null);
//        iryoHokenInput.getTxtIryoHokenKigoNo().setValue(null);
    }

//    private dgIryoHokenRireki_Row createDgIryoHokenRirekiRowFrowInputValue(tplIryoHokenDiv tplIryoHoken) {
//        dgIryoHokenRireki_Row row = new dgIryoHokenRireki_Row(RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY,
//                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
//
//        setDgIryoHokenRirekiRowFrowInputValue(tplIryoHoken, row);
//        return row;
//    }

//    private dgIryoHokenRireki_Row setDgIryoHokenRirekiRowFrowInputValue(tplIryoHokenDiv tplIryoHoken, dgIryoHokenRireki_Row row) {
        //TODO n8187久保田 画面Entiityが変更されたがコード未対応のためエラーが発生するのでコメントアウト
//        IryoHokenInputDiv input = tplIryoHoken.getIryoHokenInput();
//        row.setHokenshaNo(input.getTxtIryoHokenHokenshaNo().getValue());
//        row.setHokenshaMeisho(input.getTxtIryoHokenHokenshaMeisho().getValue());
//        row.setHokensha(row.getHokenshaNo().concat(":").concat(row.getHokenshaMeisho()));
//        row.setIryoHokenShubetsuKey(input.getDdlIryoHokenShubetsu().getSelectedItem());
//        row.setIryoHokenShubetsu(input.getDdlIryoHokenShubetsu().getSelectedValue());
//        row.getKanyuDate().setValue(input.getTxtIryoHokenKanyuDate().getValue());
//        row.getDattaiDate().setValue(input.getTxtIryoHokenDattaiDate().getValue());
//        row.setKigoNo(input.getTxtIryoHokenKigoNo().getValue());
//        return row;
//    }

//    /**
//     * 被保履歴タブで追加ボタン押下時の処理。
//     *
//     * @param div 資格取得情報div
//     * @return ResponseData
//     */
//    public ResponseData<ShikakuShutokuJohoDiv> onClickAddHihoRireki(ShikakuShutokuJohoDiv div) {
//        return toHihoRirekiNyuryoku(div);
//    }
//
//    /**
//     * 被保履歴タブでDataGrid選択時の処理。
//     *
//     * @param div 資格取得情報div
//     * @return ResponseData
//     */
//    public ResponseData<ShikakuShutokuJohoDiv> onSelectHihoRireki(ShikakuShutokuJohoDiv div) {
//        return toHihoRirekiNyuryoku(div);
//    }
//
//    /**
//     * 被保履歴タブで確定ボタン押下時の処理。
//     *
//     * @param div 資格取得情報div
//     * @return ResponseData
//     */
//    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnHihoRirekiKakutei(ShikakuShutokuJohoDiv div) {
//        return toShikakuShutokuJohoToroku(div);
//    }
//
//    /**
//     * 被保履歴タブで取消ボタン押下時の処理。
//     *
//     * @param div 資格取得情報div
//     * @return ResponseData
//     */
//    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnHihoRirekiTorikeshi(ShikakuShutokuJohoDiv div) {
//        return toShikakuShutokuJohoToroku(div);
//    }
//
//    /**
//     * 医療保険タブで追加ボタン押下時の処理。
//     *
//     * @param div 資格取得情報div
//     * @return ResponseData
//     */
//    public ResponseData<ShikakuShutokuJohoDiv> onClickAddIryoHokenRireki(ShikakuShutokuJohoDiv div) {
//        return toIryoHokenNyuryoku(div);
//    }
//
//    /**
//     * 医療保険タブでDataGrid選択時の処理。
//     *
//     * @param div 資格取得情報div
//     * @return ResponseData
//     */
//    public ResponseData<ShikakuShutokuJohoDiv> onSelectIryoHokenRireki(ShikakuShutokuJohoDiv div) {
//        return toIryoHokenNyuryoku(div);
//    }
//
//    /**
//     * 医療保険タブで確定ボタン押下時の処理。
//     *
//     * @param div 資格取得情報div
//     * @return ResponseData
//     */
//    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnIryoHokenKakutei(ShikakuShutokuJohoDiv div) {
//        return toShikakuShutokuJohoToroku(div);
//    }
//
//    /**
//     * 医療保険タブで取消ボタン押下時の処理。
//     *
//     * @param div 資格取得情報div
//     * @return ResponseData
//     */
//    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnIryoHokenTorikeshi(ShikakuShutokuJohoDiv div) {
//        return toShikakuShutokuJohoToroku(div);
//    }
//
//    /**
//     * 施設入退所タブで追加ボタン押下時の処理。
//     *
//     * @param div 資格取得情報div
//     * @return ResponseData
//     */
//    public ResponseData<ShikakuShutokuJohoDiv> onClickAddShisetsuNyutaisho(ShikakuShutokuJohoDiv div) {
//        return toShisetsuNyutaisho(div);
//    }
//
//    /**
//     * 施設入退所タブでDataGrid選択時の処理。
//     *
//     * @param div 資格取得情報div
//     * @return ResponseData
//     */
//    public ResponseData<ShikakuShutokuJohoDiv> onSelectShisetsuNyutaisho(ShikakuShutokuJohoDiv div) {
//        return toShisetsuNyutaisho(div);
//    }
//
//    /**
//     * 施設入退所タブで確定ボタン押下時の処理。
//     *
//     * @param div 資格取得情報div
//     * @return ResponseData
//     */
//    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnShisetsuNyutaishoKakutei(ShikakuShutokuJohoDiv div) {
//        return toShikakuShutokuJohoToroku(div);
//    }
//
//    /**
//     * 施設入退所タブで取消ボタン押下時の処理。
//     *
//     * @param div 資格取得情報div
//     * @return ResponseData
//     */
//    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnShisetsuNyutaishoTorikeshi(ShikakuShutokuJohoDiv div) {
//        return toShikakuShutokuJohoToroku(div);
//    }

//    private ResponseData<ShikakuShutokuJohoDiv> toHihoRirekiNyuryoku(ShikakuShutokuJohoDiv div) {
//        return ResponseData.of(div).setState(被保履歴入力);
//    }
//
//    private ResponseData<ShikakuShutokuJohoDiv> toIryoHokenNyuryoku(ShikakuShutokuJohoDiv div) {
//        return ResponseData.of(div).setState(医療保険入力);
//    }
//
//    private ResponseData<ShikakuShutokuJohoDiv> toShisetsuNyutaisho(ShikakuShutokuJohoDiv div) {
//        return ResponseData.of(div).setState(施設入退所入力);
//    }
//
//    public ResponseData<ShikakuShutokuJohoDiv> toShikakuShutokuJohoToroku(ShikakuShutokuJohoDiv div) {
//        return ResponseData.of(div).setState(資格取得情報登録);
//    }

}
