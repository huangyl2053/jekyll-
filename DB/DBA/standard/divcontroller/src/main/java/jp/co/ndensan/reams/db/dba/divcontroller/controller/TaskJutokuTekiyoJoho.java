/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.controller.helper.DemoKojin;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba203001t.IryoHokenInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba203001t.JutokuTekiyoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba203001t.dgRohukuNenkinRireki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba203001t.dgSeikatsuHogoRireki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba203001t.tplIryoHokenDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba203001t.tplRofukuNenkinDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba203001t.tplSeikatsuHogoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba203001t.tplShikakuJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba203001t.tplShisetsuNyutaishoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba203001t.TaskJutokuTekiyoJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.iryohokenrireki.dgIryoHokenRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakutokusorireki.dgShikakuShutokuRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.dgShisetsuNyutaishoRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 資格取得処理を行うDivControllerです。<br/>
 * 資格情報以外にも、医療保険や生活保護などの情報を表示し、修正や追加なども行うことができます。
 *
 * @author n8178 城間篤人
 */
public class TaskJutokuTekiyoJoho {

    private final static RString HIHOKENSHA_DAICHO_DATA = new RString("DBA203001T/shikakuTokuso.yml");
    private final static RString IRYO_HOKEN_DATA = new RString("DBA203001T/iryoHoken.yml");
    private final static RString ROFUKU_NENKIN_DATA = new RString("DBA203001T/rofukuNenkin.yml");
    private final static RString SEIKATSU_HOGO_DATA = new RString("DBA203001T/seikatsuHogo.yml");
    private final static RString SHISETSU_NYUTAISHO_DATA = new RString("DBA203001T/shisetsuNyutaisho.yml");

    private final static RString SHIKAKU_ADD = new RString("add");
    private final static RString SHIKAKU_MODIFY = new RString("modify");
    private final static RString SHIKAKU_DELETE = new RString("delete");
    private final static RString IRYO_HOKEN_ADD = new RString("add");
    private final static RString IRYO_HOKEN_MODIFY = new RString("modify");
    private final static RString IRYO_HOKEN_DELETE = new RString("delete");

    /**
     * 対象者選択で、住所地特例適用を行う個人が決定された際に実行されます。<br/>
     * 対象となる個人の、資格得喪、医療保険、生活保護、老齢福祉年金、施設入退所の情報を全て表示します。
     *
     * @param jutokuTekiyoJohoDiv 住所地特例適用情報Div
     * @return レスポンス
     */
    public ResponseData onLoad(TaskJutokuTekiyoJohoDiv jutokuTekiyoJohoDiv) {
        ResponseData<TaskJutokuTekiyoJohoDiv> response = new ResponseData<>();

        DemoKojin demoKojin = new DemoKojin("第1号");
        RString shikibetsuCode = demoKojin.getShikibetsuCode();

        setShikakuJoho(jutokuTekiyoJohoDiv, shikibetsuCode);
        setIryoHoken(jutokuTekiyoJohoDiv, shikibetsuCode);
        setRofukuNenkin(jutokuTekiyoJohoDiv, shikibetsuCode);
        setSeikatsuHogo(jutokuTekiyoJohoDiv, shikibetsuCode);
        setShisetsuNyutaisho(jutokuTekiyoJohoDiv, shikibetsuCode);

        response.data = jutokuTekiyoJohoDiv;
        return response;
    }

    /**
     * 資格に関連する情報を表示するTabに、初期表示する値を設定します。
     *
     * @param jutokuTekiyoJohoDiv 資格情報Div
     * @param shikibetsuCode 識別コード
     */
    private void setShikakuJoho(TaskJutokuTekiyoJohoDiv jutokuTekiyoJohoDiv, RString shikibetsuCode) {
        tplShikakuJohoDiv tplShikakuJoho = jutokuTekiyoJohoDiv.getTabInputs().getTplShikakuJoho();

        List<HashMap> hihokenshaDaichoDataList = YamlLoader.DBA.loadAsList(HIHOKENSHA_DAICHO_DATA);
        DataGrid<dgShikakuShutokuRireki_Row> grid = tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki();
        List<dgShikakuShutokuRireki_Row> dataSource = new ArrayList<>();
        for (HashMap hihokenshaDaichoData : hihokenshaDaichoDataList) {
            if (hihokenshaDaichoData.get("識別コード").toString().equals(shikibetsuCode.toString())) {
                dataSource = createJutokuTekiyoRirekiList((List<HashMap>) hihokenshaDaichoData.get("被保台帳"));
            }
        }
        grid.setDataSource(dataSource);

        if (dataSource.isEmpty()) {
            jutokuTekiyoJohoDiv.setShikakuInputMode(SHIKAKU_ADD);
            setShikakuJohoDisabled(tplShikakuJoho, false);
            jutokuTekiyoJohoDiv.getTabInputs().getTplShikakuJoho().getShikakuTokusoRireki()
                    .getDgShikakuShutokuRireki().getGridSetting().setIsShowDeleteButtonColumn(false);
        } else {
            jutokuTekiyoJohoDiv.setShikakuInputMode(SHIKAKU_MODIFY);
            jutokuTekiyoJohoDiv.setShikakuSelectRow(new RString("0"));
            setShikakuJohoDisabled(tplShikakuJoho, false);
            jutokuTekiyoJohoDiv.getTabInputs().getTplShikakuJoho().getShikakuTokusoRireki()
                    .getDgShikakuShutokuRireki().getGridSetting().setIsShowDeleteButtonColumn(false);
        }
    }

    private List<dgShikakuShutokuRireki_Row> createJutokuTekiyoRirekiList(List<HashMap> hihokenshaDaichoData) {
        List<dgShikakuShutokuRireki_Row> dataSource = new ArrayList<>();
        for (HashMap hihoDaichoDataRow : hihokenshaDaichoData) {
            dataSource.add(createJutokuTekiyoRirekiRowFromHashMap(hihoDaichoDataRow));
        }
        return dataSource;
    }

    private dgShikakuShutokuRireki_Row createJutokuTekiyoRirekiRowFromHashMap(HashMap hihokenshaDaichoData) {
        dgShikakuShutokuRireki_Row row = new dgShikakuShutokuRireki_Row(new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY,
                RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(),
                new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
                RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY);

        ControlGenerator generator = new ControlGenerator(hihokenshaDaichoData);
        row.getShutokuTodokedeDate().setValue(generator.getAsFlexibleDate("取得届出日"));
        row.getShutokuDate().setValue(generator.getAsFlexibleDate("取得日"));
        row.setShutokuJiyu(generator.getAsRString("取得事由"));
        row.setShutokuJiyuKey(generator.getAsRString("取得事由Key"));
        row.getSoshitsuTodokedeDate().setValue(generator.getAsFlexibleDate("喪失届出日"));
        row.getSoshitsuDate().setValue(generator.getAsFlexibleDate("喪失日"));
        row.setSoshitsuJiyu(generator.getAsRString("喪失事由"));
        row.setSoshitsuJiyuKey(generator.getAsRString("喪失事由Key"));
        row.setHihokenshaKubunKey(generator.getAsRString("被保区分Key"));
        row.setHihokenshaKubun(generator.getAsRString("被保区分"));
        row.getJutokuKaijoTodokedeDate().setValue(generator.getAsFlexibleDate("解除届出日"));
        row.getJutokuKaijoDate().setValue(generator.getAsFlexibleDate("解除日"));
        row.setJutokuKaijoJiyu(generator.getAsRString("解除事由"));
        row.setJutokuKaijoJiyuKey(generator.getAsRString("解除事由Key"));
        row.getJutokuTekiyoTodokedeDate().setValue(generator.getAsFlexibleDate("適用届出日"));
        row.getJutokuTekiyoDate().setValue(generator.getAsFlexibleDate("適用日"));
        row.setJutokuTekiyoJiyu(generator.getAsRString("適用事由"));
        row.setJutokuTekiyoJiyuKey(generator.getAsRString("適用事由Key"));
        row.getHenkoTodokedeDate().setValue(generator.getAsFlexibleDate("変更届出日"));
        row.getHenkoDate().setValue(generator.getAsFlexibleDate("変更日"));
        row.setHenkoJiyu(generator.getAsRString("変更事由"));
        row.setHenkoJiyuKey(generator.getAsRString("変更事由Key"));
        row.getNenreiTotatsuDate().setValue(generator.getAsFlexibleDate("1号年齢到達日"));
        row.setKyuHokensha(generator.getAsRString("旧保険者"));
        row.setSaikofuKubun(generator.getAsRString("再交付区分"));
        row.setSaikofuJiyu(generator.getAsRString("再交付事由"));
        row.setShikibetsuCode(generator.getAsRString("識別コード"));
        return row;
    }

    private void setShikakuJohoDisabled(tplShikakuJohoDiv tplShikakuJoho, boolean disableValue) {
        tplShikakuJoho.getJutokuTekiyoInput().setDisabled(disableValue);
        tplShikakuJoho.getBtnUpdateShikaku().setDisabled(disableValue);
    }

    /**
     * 医療保険Tabに初期表示する値を設定します。
     *
     * @param jutokuTekiyoJohoDiv 資格情報Div
     * @param shikibetsuCode 識別コード
     */
    private void setIryoHoken(TaskJutokuTekiyoJohoDiv jutokuTekiyoJohoDiv, RString shikibetsuCode) {
        tplIryoHokenDiv tplIryoHoken = jutokuTekiyoJohoDiv.getTabInputs().getTplIryoHoken();

        List<HashMap> iryoHokenDataList = YamlLoader.DBA.loadAsList(IRYO_HOKEN_DATA);
        DataGrid<dgIryoHokenRireki_Row> grid = tplIryoHoken.getIryoHokenRireki().getDgIryoHokenRireki();
        List<dgIryoHokenRireki_Row> dataSource = new ArrayList<>();
        for (HashMap iryoHokenData : iryoHokenDataList) {
            if (iryoHokenData.get("識別コード").toString().equals(shikibetsuCode.toString())) {
                dataSource = createDgIryoHokenRirekiList((List<HashMap>) iryoHokenData.get("医療保険"));
            }
        }
        grid.setDataSource(dataSource);

        if (dataSource.isEmpty()) {
            jutokuTekiyoJohoDiv.setIryoHokenInputMode(IRYO_HOKEN_ADD);
            setIryoHokenDisabled(tplIryoHoken, false);
        } else {
            setIryoHokenDisabled(tplIryoHoken, true);
        }
    }

    private List<dgIryoHokenRireki_Row> createDgIryoHokenRirekiList(List<HashMap> iryoHokenData) {
        List<dgIryoHokenRireki_Row> dataSource = new ArrayList<>();
        for (HashMap iryoHokenDataRow : iryoHokenData) {
            dataSource.add(createDgIryoHokenRirekiRowFrowHashMap(iryoHokenDataRow));
        }
        return dataSource;
    }

    private dgIryoHokenRireki_Row createDgIryoHokenRirekiRowFrowHashMap(HashMap hihokenshaDaichoData) {
        dgIryoHokenRireki_Row row = new dgIryoHokenRireki_Row(new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        ControlGenerator generator = new ControlGenerator(hihokenshaDaichoData);
        row.setHokenshaNo(generator.getAsRString("保険者番号"));
        row.setHokenshaMeisho(generator.getAsRString("保険者名称"));
        row.setHokensha(row.getHokenshaNo().concat(":").concat(row.getHokenshaMeisho()));
        row.setIryoHokenShubetsuKey(generator.getAsRString("保険者種別Key"));
        row.setIryoHokenShubetsu(generator.getAsRString("保険者種別"));
        row.getKanyuDate().setValue(generator.getAsFlexibleDate("加入日"));
        row.getDattaiDate().setValue(generator.getAsFlexibleDate("脱退日"));
        row.setKigoNo(generator.getAsRString("記号番号"));
        return row;
    }

    private void setIryoHokenDisabled(tplIryoHokenDiv tplIryoHoken, boolean disableValue) {
        tplIryoHoken.getIryoHokenInput().setDisabled(disableValue);
        tplIryoHoken.getBtnUpdateIryoHoken().setDisabled(disableValue);
    }

    /**
     * 老福年金Tabに初期表示する値を設定します。
     *
     * @param jutokuTekiyoJohoDiv 資格情報Div
     * @param shikibetsuCode 識別コード
     */
    private void setRofukuNenkin(TaskJutokuTekiyoJohoDiv jutokuTekiyoJohoDiv, RString shikibetsuCode) {
        tplRofukuNenkinDiv tplRofukuNenkin = jutokuTekiyoJohoDiv.getTabInputs().getTplRofukuNenkin();

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
        tplRofukuNenkin.getRohukuNenkin().getRohukuNenkinInput().setDisabled(disableValue);
        tplRofukuNenkin.getRohukuNenkin().getBtnUpdateRofukuNenkin().setDisabled(disableValue);
    }

    /**
     * 生活保護Tabに初期表示する値を設定します。
     *
     * @param jutokuTekiyoJohoDiv 資格情報Div
     * @param shikibetsuCode 識別コード
     */
    private void setSeikatsuHogo(TaskJutokuTekiyoJohoDiv jutokuTekiyoJohoDiv, RString shikibetsuCode) {
        tplSeikatsuHogoDiv tplSeikatsuHogo = jutokuTekiyoJohoDiv.getTabInputs().getTplSeikatsuHogo();

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
     * @param jutokuTekiyoJohoDiv 資格情報Div
     * @param shikibetsuCode 識別コード
     */
    private void setShisetsuNyutaisho(TaskJutokuTekiyoJohoDiv jutokuTekiyoJohoDiv, RString shikibetsuCode) {
        tplShisetsuNyutaishoDiv tplShisetsuNyutaisho = jutokuTekiyoJohoDiv.getTabInputs().getTplShisetsuNyutaisho();

        List<HashMap> shisetsuNyutaishoRirekiDataList = YamlLoader.DBA.loadAsList(SHISETSU_NYUTAISHO_DATA);
        DataGrid<dgShisetsuNyutaishoRireki_Row> grid = tplShisetsuNyutaisho.getShisetsuNyutaishoRirekiKanri().getDgShisetsuNyutaishoRireki();
        List<dgShisetsuNyutaishoRireki_Row> dataSource = new ArrayList<>();
        for (HashMap shisetsuNyutaishoRirekiData : shisetsuNyutaishoRirekiDataList) {
            if (shisetsuNyutaishoRirekiData.get("識別コード").toString().equals(shikibetsuCode.toString())) {
                dataSource = createShisetsuNyutaishoList((List<HashMap>) shisetsuNyutaishoRirekiData.get("異動履歴"));
            }
        }
        grid.setDataSource(dataSource);

        if (dataSource.isEmpty()) {
            setShisetsuNyutaishoDisabled(tplShisetsuNyutaisho, false);
        } else {
            setShisetsuNyutaishoDisabled(tplShisetsuNyutaisho, true);
        }

        DropDownList ddl = tplShisetsuNyutaisho.getShisetsuNyutaishoRirekiKanri().getShisetsuNyutaishoInput().getDdlTaishoJoho();
        ddl.setDataSource(ddl.getDataSource().subList(0, 2));
        RadioButton rad = tplShisetsuNyutaisho.getShisetsuNyutaishoRirekiKanri().getShisetsuNyutaishoInput().getShisetsuJoho().getRadShisetsuShurui();
        rad.setDataSource(rad.getDataSource().subList(0, 2));
    }

    private List<dgShisetsuNyutaishoRireki_Row> createShisetsuNyutaishoList(List<HashMap> shisetsuNyutaishoData) {
        List<dgShisetsuNyutaishoRireki_Row> dataSource = new ArrayList<>();
        for (HashMap shisetsuNyutaishoDataRow : shisetsuNyutaishoData) {
            dataSource.add(createShisetsuNyutaishoRowFromHashMap(shisetsuNyutaishoDataRow));
        }
        return dataSource;
    }

    private dgShisetsuNyutaishoRireki_Row createShisetsuNyutaishoRowFromHashMap(HashMap seikatsuHogoData) {
        dgShisetsuNyutaishoRireki_Row row = new dgShisetsuNyutaishoRireki_Row(new TextBoxFlexibleDate(),
                new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY);

        ControlGenerator generator = new ControlGenerator(seikatsuHogoData);
        row.getNyushoDate().setValue(generator.getAsFlexibleDate("入所日"));
        row.getTaishoDate().setValue(generator.getAsFlexibleDate("退所日"));
        row.setShisetsuCode(generator.getAsRString("施設コード"));
        row.setShisetsuMeisho(generator.getAsRString("施設名称"));
        row.setShisetsu(row.getShisetsuCode().concat(":").concat(row.getShisetsuMeisho()));
        row.setTaishoJohoKey(generator.getAsRString("対象情報Key"));
        row.setTaishoJoho(generator.getAsRString("対象情報"));
        row.setShisetsuShuruiKey(generator.getAsRString("施設種類Key"));
        row.setShisetsuShurui(generator.getAsRString("施設種類"));
        return row;
    }

    private void setShisetsuNyutaishoDisabled(tplShisetsuNyutaishoDiv tplShisetsuNyutaisho, boolean disableValue) {
        tplShisetsuNyutaisho.getShisetsuNyutaishoRirekiKanri().getShisetsuNyutaishoInput().setDisabled(disableValue);
        tplShisetsuNyutaisho.getShisetsuNyutaishoRirekiKanri().getBtnUpdateShisetsuNyutaisho().setDisabled(disableValue);
    }

    /**
     * 資格情報タブ内の処理です。グリッド内の視覚情報修正ボタンがクリックされた際に実行します。<br/>
     * 入力モードを修正モードに変更し、選択したグリッドのデータを表示します。また、確定ボタンのラベルが修正用に変更されます。
     *
     * @param jutokuTekiyoJohoDiv 資格情報Div
     * @return レスポンス
     */
    public ResponseData onSelectOfModifyButton_dgJutokuTekiyoRireki(TaskJutokuTekiyoJohoDiv jutokuTekiyoJohoDiv) {
        ResponseData<TaskJutokuTekiyoJohoDiv> response = new ResponseData<>();
        tplShikakuJohoDiv tplShikakuJoho = jutokuTekiyoJohoDiv.getTabInputs().getTplShikakuJoho();

        jutokuTekiyoJohoDiv.setShikakuInputMode(SHIKAKU_MODIFY);
        jutokuTekiyoJohoDiv.setShikakuSelectRow(
                new RString(Integer.toString(tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki().getClickedRowId())));
        setJutokuTekiyoInput(tplShikakuJoho, tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki().getClickedItem());
        setShikakuJohoDisabled(tplShikakuJoho, false);
        response.data = jutokuTekiyoJohoDiv;
        return response;
    }

    /**
     * 資格情報タブ内の処理です。グリッド内の資格情報削除ボタンがクリックされた際に実行します。<br/>
     * 入力モードを削除モードに変更し、確定ボタン以外のコントロールを編集不可状態で詳細表示します。また、確定ボタンのラベルが削除用に変更されます。
     *
     * @param jutokuTekiyoJohoDiv 資格情報Div
     * @return レスポンス
     */
    public ResponseData onSelectOfDeleteButton_dgJutokuTekiyoRireki(TaskJutokuTekiyoJohoDiv jutokuTekiyoJohoDiv) {
        ResponseData<TaskJutokuTekiyoJohoDiv> response = new ResponseData<>();
        tplShikakuJohoDiv tplShikakuJoho = jutokuTekiyoJohoDiv.getTabInputs().getTplShikakuJoho();

        jutokuTekiyoJohoDiv.setShikakuInputMode(SHIKAKU_DELETE);
        jutokuTekiyoJohoDiv.setShikakuSelectRow(new RString(Integer.toString(tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki().getClickedRowId())));
        setJutokuTekiyoInput(tplShikakuJoho, tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki().getClickedItem());
        setShikakuJohoDisabled(tplShikakuJoho, true);
        tplShikakuJoho.getBtnUpdateShikaku().setDisabled(false);
        response.data = jutokuTekiyoJohoDiv;
        return response;
    }

    /**
     * 資格情報タブ内の処理です。資格情報確定ボタンがクリックされた際に実行します。<br/>
     * 新規追加モードの場合は、行を新しく用意して、入力内容をグリッドに追加します。<br/>
     * 修正モードの場合は、選択したグリッドに入力内容を反映させます<br/>
     * 削除モードの場合は、選択しているグリッドの状態を削除に変更します。
     *
     * @param jutokuTekiyoJohoDiv 資格情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnUpdateShikaku(TaskJutokuTekiyoJohoDiv jutokuTekiyoJohoDiv) {
        ResponseData<TaskJutokuTekiyoJohoDiv> response = new ResponseData<>();
        tplShikakuJohoDiv tplShikakuJoho = jutokuTekiyoJohoDiv.getTabInputs().getTplShikakuJoho();
        int selectRowNum;
        dgShikakuShutokuRireki_Row selectRow;

        if (jutokuTekiyoJohoDiv.getShikakuInputMode().equals(SHIKAKU_ADD)) {
            dgShikakuShutokuRireki_Row row = createJutokuTekiyoRirekiRowFromInputValue(tplShikakuJoho);
            row.setRowState(RowState.Added);
            tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki().getDataSource().add(0, row);
        } else if (jutokuTekiyoJohoDiv.getShikakuInputMode().equals(SHIKAKU_MODIFY)) {
            selectRowNum = Integer.parseInt(jutokuTekiyoJohoDiv.getShikakuSelectRow().toString());
            selectRow = tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki().getDataSource().get(selectRowNum);
            setJutokuTekiyoRirekiRowFromInputValue(tplShikakuJoho, selectRow);
            if (selectRow.getRowState().equals(RowState.Added)) {
            } else {
                selectRow.setRowState(RowState.Modified);
            }
        } else if (jutokuTekiyoJohoDiv.getShikakuInputMode().equals(SHIKAKU_DELETE)) {
            selectRowNum = Integer.parseInt(jutokuTekiyoJohoDiv.getShikakuSelectRow().toString());
            selectRow = tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki().getDataSource().get(selectRowNum);
            if (selectRow.getRowState().equals(RowState.Added)) {
                tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki().getDataSource().remove(selectRowNum);
            } else {
                tplShikakuJoho.getShikakuTokusoRireki().getDgShikakuShutokuRireki().getDataSource().get(selectRowNum).setRowState(RowState.Deleted);
            }
        }

        setShikakuJohoDisabled(tplShikakuJoho, true);
        clearJutokuTekiyoInput(jutokuTekiyoJohoDiv.getTabInputs().getTplShikakuJoho());
        response.data = jutokuTekiyoJohoDiv;
        return response;
    }

    private dgShikakuShutokuRireki_Row createJutokuTekiyoRirekiRowFromInputValue(tplShikakuJohoDiv tplShikakuJoho) {
        dgShikakuShutokuRireki_Row row = new dgShikakuShutokuRireki_Row(new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY,
                RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(),
                new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
                RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY);
        setJutokuTekiyoRirekiRowFromInputValue(tplShikakuJoho, row);
        return row;
    }

    private void setJutokuTekiyoRirekiRowFromInputValue(tplShikakuJohoDiv tplShikakuJoho, dgShikakuShutokuRireki_Row row) {

        JutokuTekiyoInputDiv shutoku = tplShikakuJoho.getJutokuTekiyoInput();
        row.getJutokuTekiyoDate().setValue(shutoku.getTxtJutokuTekiyoDate().getValue());
        row.getJutokuTekiyoTodokedeDate().setValue(shutoku.getTxtJutokuTekiyoTodokedeDate().getValue());
        row.setJutokuTekiyoJiyu(shutoku.getDdlJutokuTekiyoJiyu().getSelectedValue());
        row.setJutokuTekiyoJiyuKey(shutoku.getDdlJutokuTekiyoJiyu().getSelectedItem());
    }

    private void setJutokuTekiyoInput(tplShikakuJohoDiv tplShikakuJoho, dgShikakuShutokuRireki_Row row) {
        setJutokuTekiyoJohoInput(tplShikakuJoho, row.getJutokuTekiyoJiyuKey(), row.getJutokuTekiyoDate().getValue(),
                row.getJutokuTekiyoTodokedeDate().getValue());
    }

    private void clearJutokuTekiyoInput(tplShikakuJohoDiv tplShikakuJoho) {
        setJutokuTekiyoJohoInput(tplShikakuJoho, new RString("jutokuTekiyo"), null, null);
    }

    private void setJutokuTekiyoJohoInput(tplShikakuJohoDiv tplShikakuJoho, RString ddlJutokuTekiyoJiyu, FlexibleDate tekiyoDate,
            FlexibleDate tekiyoTodokedeDate) {
        JutokuTekiyoInputDiv jutokuTekiyo = tplShikakuJoho.getJutokuTekiyoInput();
        jutokuTekiyo.getDdlJutokuTekiyoJiyu().setSelectedItem(ddlJutokuTekiyoJiyu);
        jutokuTekiyo.getTxtJutokuTekiyoDate().setValue(tekiyoDate);
        jutokuTekiyo.getTxtJutokuTekiyoTodokedeDate().setValue(tekiyoTodokedeDate);
    }

    /**
     * 医療保険タブ内の処理です。医療保険情報追加ボタンがクリックされた際に実行します。<br/>
     * 入力モードを新規追加モードに変更します。
     *
     * @param jutokuTekiyoJohoDiv 資格情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnAddIryoHoken(TaskJutokuTekiyoJohoDiv jutokuTekiyoJohoDiv) {
        ResponseData<TaskJutokuTekiyoJohoDiv> response = new ResponseData<>();
        tplIryoHokenDiv tplIryoHoken = jutokuTekiyoJohoDiv.getTabInputs().getTplIryoHoken();

        jutokuTekiyoJohoDiv.setIryoHokenInputMode(IRYO_HOKEN_ADD);
        setIryoHokenDisabled(tplIryoHoken, false);
        clearIryoHokenInput(tplIryoHoken);
        response.data = jutokuTekiyoJohoDiv;
        return response;
    }

    /**
     * 医療保険タブ内の処理です。資格情報修正ボタンがクリックされた際に実行します。<br/>
     * 入力モードを修正モードに変更します。
     *
     * @param jutokuTekiyoJohoDiv 資格情報Div
     * @return レスポンス
     */
    public ResponseData onSelectOfModifyButton_dgIryoHokenRireki(TaskJutokuTekiyoJohoDiv jutokuTekiyoJohoDiv) {
        ResponseData<TaskJutokuTekiyoJohoDiv> response = new ResponseData<>();
        tplIryoHokenDiv tplIryoHoken = jutokuTekiyoJohoDiv.getTabInputs().getTplIryoHoken();

        jutokuTekiyoJohoDiv.setIryoHokenInputMode(IRYO_HOKEN_MODIFY);
        jutokuTekiyoJohoDiv.setIryoHokenSelectRow(new RString(Integer.toString(tplIryoHoken.getIryoHokenRireki().getDgIryoHokenRireki().getClickedRowId())));
        setIryoHokenInput(tplIryoHoken, tplIryoHoken.getIryoHokenRireki().getDgIryoHokenRireki().getClickedItem());
        setIryoHokenDisabled(tplIryoHoken, false);
        response.data = jutokuTekiyoJohoDiv;
        return response;
    }

    /**
     * 医療保険タブ内の処理です。資格情報削除ボタンがクリックされた際に実行します。<br/>
     * 入力モードを削除に変更し、全てのコントロールをreadOnlyに変更します。
     *
     * @param jutokuTekiyoJohoDiv 資格情報Div
     * @return レスポンス
     */
    public ResponseData onSelectOfDeleteButton_dgIryoHokenRireki(TaskJutokuTekiyoJohoDiv jutokuTekiyoJohoDiv) {
        ResponseData<TaskJutokuTekiyoJohoDiv> response = new ResponseData<>();
        tplIryoHokenDiv tplIryoHoken = jutokuTekiyoJohoDiv.getTabInputs().getTplIryoHoken();

        jutokuTekiyoJohoDiv.setIryoHokenInputMode(IRYO_HOKEN_DELETE);
        jutokuTekiyoJohoDiv.setIryoHokenSelectRow(new RString(Integer.toString(tplIryoHoken.getIryoHokenRireki().getDgIryoHokenRireki().getClickedRowId())));
        setIryoHokenInput(tplIryoHoken, tplIryoHoken.getIryoHokenRireki().getDgIryoHokenRireki().getClickedItem());
        setIryoHokenDisabled(tplIryoHoken, true);
        tplIryoHoken.getBtnUpdateIryoHoken().setDisabled(false);
        response.data = jutokuTekiyoJohoDiv;
        return response;
    }

    /**
     * 医療保険タブ内の処理です。資格情報確定ボタンがクリックされた際に実行します。<br/>
     * 新規追加モードの場合は、行を新しく用意して、入力内容をグリッドに追加します。<br/>
     * 修正モードの場合は、選択したグリッドに入力内容を反映させます<br/>
     * 削除モードの場合は、選択しているグリッドの状態を削除に変更します。
     *
     * @param jutokuTekiyoJohoDiv 資格情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnUpdateIryoHoken(TaskJutokuTekiyoJohoDiv jutokuTekiyoJohoDiv) {
        ResponseData<TaskJutokuTekiyoJohoDiv> response = new ResponseData<>();
        tplIryoHokenDiv tplIryoHoken = jutokuTekiyoJohoDiv.getTabInputs().getTplIryoHoken();
        int selectRowNum;

        if (jutokuTekiyoJohoDiv.getIryoHokenInputMode().equals(IRYO_HOKEN_ADD)) {
            dgIryoHokenRireki_Row row = createDgIryoHokenRirekiRowFrowInputValue(tplIryoHoken);
            row.setRowState(RowState.Added);
            tplIryoHoken.getIryoHokenRireki().getDgIryoHokenRireki().getDataSource().add(0, row);
        } else if (jutokuTekiyoJohoDiv.getIryoHokenInputMode().equals(IRYO_HOKEN_MODIFY)) {
            selectRowNum = Integer.parseInt(jutokuTekiyoJohoDiv.getIryoHokenSelectRow().toString());
            dgIryoHokenRireki_Row selectRow = tplIryoHoken.getIryoHokenRireki().getDgIryoHokenRireki().getDataSource().get(selectRowNum);
            setDgIryoHokenRirekiRowFrowInputValue(tplIryoHoken, selectRow);
            if (selectRow.getRowState().equals(RowState.Added)) {
            } else {
                selectRow.setRowState(RowState.Modified);
            }
        } else if (jutokuTekiyoJohoDiv.getIryoHokenInputMode().equals(IRYO_HOKEN_DELETE)) {
            selectRowNum = Integer.parseInt(jutokuTekiyoJohoDiv.getIryoHokenSelectRow().toString());
            dgIryoHokenRireki_Row selectRow = tplIryoHoken.getIryoHokenRireki().getDgIryoHokenRireki().getDataSource().get(selectRowNum);
            if (selectRow.getRowState().equals(RowState.Added)) {
                tplIryoHoken.getIryoHokenRireki().getDgIryoHokenRireki().getDataSource().remove(selectRowNum);
            } else {
                selectRow.setRowState(RowState.Deleted);
            }
        }

        setIryoHokenDisabled(tplIryoHoken, true);
        clearIryoHokenInput(tplIryoHoken);
        response.data = jutokuTekiyoJohoDiv;
        return response;
    }

    private void setIryoHokenInput(tplIryoHokenDiv tplIryoHoken, dgIryoHokenRireki_Row row) {
        IryoHokenInputDiv iryoHokenInput = tplIryoHoken.getIryoHokenInput();
        iryoHokenInput.getTxtIryoHokenKanyuDate().setValue(row.getKanyuDate().getValue());
        iryoHokenInput.getTxtIryoHokenDattaiDate().setValue(row.getDattaiDate().getValue());
        iryoHokenInput.getTxtIryoHokenHokenshaNo().setValue(row.getHokenshaNo());
        iryoHokenInput.getTxtIryoHokenHokenshaMeisho().setValue(row.getHokenshaMeisho());
        iryoHokenInput.getDdlIryoHokenShubetsu().setSelectedItem(row.getIryoHokenShubetsuKey());
        iryoHokenInput.getTxtIryoHokenKigoNo().setValue(row.getKigoNo());
    }

    private void clearIryoHokenInput(tplIryoHokenDiv tplIryoHoken) {
        IryoHokenInputDiv iryoHokenInput = tplIryoHoken.getIryoHokenInput();
        iryoHokenInput.getDdlIryoHokenShubetsu().setSelectedItem(new RString("kyokai"));
        iryoHokenInput.getTxtIryoHokenDattaiDate().setValue(null);
        iryoHokenInput.getTxtIryoHokenHokenshaMeisho().setValue(null);
        iryoHokenInput.getTxtIryoHokenHokenshaNo().setValue(null);
        iryoHokenInput.getTxtIryoHokenKanyuDate().setValue(null);
        iryoHokenInput.getTxtIryoHokenKigoNo().setValue(null);
    }

    private dgIryoHokenRireki_Row createDgIryoHokenRirekiRowFrowInputValue(tplIryoHokenDiv tplIryoHoken) {
        dgIryoHokenRireki_Row row = new dgIryoHokenRireki_Row(new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        setDgIryoHokenRirekiRowFrowInputValue(tplIryoHoken, row);
        return row;
    }

    private dgIryoHokenRireki_Row setDgIryoHokenRirekiRowFrowInputValue(tplIryoHokenDiv tplIryoHoken, dgIryoHokenRireki_Row row) {
        IryoHokenInputDiv input = tplIryoHoken.getIryoHokenInput();
        row.setHokenshaNo(input.getTxtIryoHokenHokenshaNo().getValue());
        row.setHokenshaMeisho(input.getTxtIryoHokenHokenshaMeisho().getValue());
        row.setHokensha(row.getHokenshaNo().concat(":").concat(row.getHokenshaMeisho()));
        row.setIryoHokenShubetsuKey(input.getDdlIryoHokenShubetsu().getSelectedItem());
        row.setIryoHokenShubetsu(input.getDdlIryoHokenShubetsu().getSelectedValue());
        row.getKanyuDate().setValue(input.getTxtIryoHokenKanyuDate().getValue());
        row.getDattaiDate().setValue(input.getTxtIryoHokenDattaiDate().getValue());
        row.setKigoNo(input.getTxtIryoHokenKigoNo().getValue());
        return row;
    }
}
