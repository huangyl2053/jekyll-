/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.IryoHokenInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.JutokuKaijoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.JutokuTekiyoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.OtherShichosonJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.ShikakuHenkoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.ShikakuJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.ShikakuShutokuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.ShikakuShutokuTaishoshaDbJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.ShikakuShutokuTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.ShikakuSoshitsuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.dgIryoHokenRireki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.dgRohukuNenkinRireki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.dgSeikatsuHogoRireki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.dgShikakuShutokuRireki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.tplIryoHokenDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.tplRofukuNenkinDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.tplSeikatsuHogoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.tplShikakuJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.tplShisetsuNyutaishoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.dgShisetsuNyutaishoRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 資格情報と、それに関連するその他の情報の表示、入力を行うDivのコントローラです。
 *
 * @author n8178 城間篤人
 */
public class ShikakuJoho {

    private final static RString HIHOKENSHA_DAICHO_DATA = new RString("DBA1010011/HihokenshaDaichoData.yml");
    private final static RString IRYO_HOKEN_DATA = new RString("DBA1010011/IryoHokenData.yml");
    private final static RString ROFUKU_NENKIN_DATA = new RString("DBA1010011/RofukuNenkinData.yml");
    private final static RString SEIKATSU_HOGO_DATA = new RString("DBA1010011/SeikatsuHogoData.yml");
    private final static RString SHISETSU_NYUTAISHO_DATA = new RString("DBA1010011/ShisetsuNyutaishoRireki.yml");

    private final static RString SHIKAKU_ADD = new RString("add");
    private final static RString SHIKAKU_MODIFY = new RString("modify");
    private final static RString SHIKAKU_DELETE = new RString("delete");
    private final static RString IRYO_HOKEN_ADD = new RString("add");
    private final static RString IRYO_HOKEN_MODIFY = new RString("modify");
    private final static RString IRYO_HOKEN_DELETE = new RString("delete");

    /**
     * ページの読み込みが行われた際に実行されます<br/>
     * タブ上に表示されるデータを全て設定します。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param taishoshaJoho 対象者情報Div
     * @return レスポンス
     */
    public ResponseData onLoad(ShikakuJohoDiv shikakuJohoDiv, ShikakuShutokuTaishoshaJohoDiv taishoshaJoho) {
        ResponseData<ShikakuJohoDiv> response = new ResponseData<>();

        RString shikibetsuCode = (RString) ViewStateHolder.get("shikibetsuCode", RString.class);
        setShikakuJoho(shikakuJohoDiv, shikibetsuCode);
        setIryoHoken(shikakuJohoDiv, shikibetsuCode);
        setRofukuNenkin(shikakuJohoDiv, shikibetsuCode);
        setSeikatsuHogo(shikakuJohoDiv, shikibetsuCode);
        setShisetsuNyutaisho(shikakuJohoDiv, shikibetsuCode);

        response.data = shikakuJohoDiv;
        return response;
    }

    /**
     * 資格情報Tabに初期表示する値を設定します。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param shikibetsuCode 識別コード
     */
    private void setShikakuJoho(ShikakuJohoDiv shikakuJohoDiv, RString shikibetsuCode) {
        tplShikakuJohoDiv tplShikakuJoho = shikakuJohoDiv.getTabInputs().getTplShikakuJoho();

        List<HashMap> hihokenshaDaichoDataList = YamlLoader.FOR_DBA.loadAsList(HIHOKENSHA_DAICHO_DATA);
        DataGrid<dgShikakuShutokuRireki_Row> grid = tplShikakuJoho.getDgShikakuShutokuRireki();
        List<dgShikakuShutokuRireki_Row> dataSource = new ArrayList<>();
        for (HashMap hihokenshaDaichoData : hihokenshaDaichoDataList) {
            if (hihokenshaDaichoData.get("識別コード").toString().equals(shikibetsuCode.toString())) {
                dataSource = createShikakuShutokuRirekiList((List<HashMap>) hihokenshaDaichoData.get("被保台帳"));
            }
        }
        grid.setDataSource(dataSource);

        if (dataSource.isEmpty()) {
            shikakuJohoDiv.setShikakuInputMode(SHIKAKU_ADD);
            setShikakuJohoDisabled(tplShikakuJoho, false);
        } else {
            shikakuJohoDiv.setShikakuInputMode(SHIKAKU_MODIFY);
            shikakuJohoDiv.setShikakuSelectRow(new RString("0"));
            setShikakuJohoDisabled(tplShikakuJoho, false);
        }
    }

    private List<dgShikakuShutokuRireki_Row> createShikakuShutokuRirekiList(List<HashMap> hihokenshaDaichoData) {
        List<dgShikakuShutokuRireki_Row> dataSource = new ArrayList<>();
        for (HashMap hihoDaichoDataRow : hihokenshaDaichoData) {
            dataSource.add(createShikakuShutokuRirekiRowFromHashMap(hihoDaichoDataRow));
        }
        return dataSource;
    }

    private dgShikakuShutokuRireki_Row createShikakuShutokuRirekiRowFromHashMap(HashMap hihokenshaDaichoData) {
        dgShikakuShutokuRireki_Row row = new dgShikakuShutokuRireki_Row(new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY,
                RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(),
                new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
                RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY);

        row.getShutokuTodokedeDate().setValue(getMapValueToFlexibleDate(hihokenshaDaichoData, "取得届出日"));
        row.getShutokuDate().setValue(getMapValueToFlexibleDate(hihokenshaDaichoData, "取得日"));
        row.setShutokuJiyu(getMapValueToRString(hihokenshaDaichoData, "取得事由"));
        row.setShutokuJiyuKey(getMapValueToRString(hihokenshaDaichoData, "取得事由Key"));
        row.getSoshitsuTodokedeDate().setValue(getMapValueToFlexibleDate(hihokenshaDaichoData, "喪失届出日"));
        row.getSoshitsuDate().setValue(getMapValueToFlexibleDate(hihokenshaDaichoData, "喪失日"));
        row.setSoshitsuJiyu(getMapValueToRString(hihokenshaDaichoData, "喪失事由"));
        row.setSoshitsuJiyuKey(getMapValueToRString(hihokenshaDaichoData, "喪失事由Key"));
        row.setHihokenshaKubunKey(getMapValueToRString(hihokenshaDaichoData, "被保区分Key"));
        row.setHihokenshaKubun(getMapValueToRString(hihokenshaDaichoData, "被保区分"));
        row.getJutokuKaijoTodokedeDate().setValue(getMapValueToFlexibleDate(hihokenshaDaichoData, "解除届出日"));
        row.getJutokuKaijoDate().setValue(getMapValueToFlexibleDate(hihokenshaDaichoData, "解除日"));
        row.setJutokuKaijoJiyu(getMapValueToRString(hihokenshaDaichoData, "解除事由"));
        row.setJutokuKaijoJiyuKey(getMapValueToRString(hihokenshaDaichoData, "解除事由Key"));
        row.getJutokuTekiyoTodokedeDate().setValue(getMapValueToFlexibleDate(hihokenshaDaichoData, "適用届出日"));
        row.getJutokuTekiyoDate().setValue(getMapValueToFlexibleDate(hihokenshaDaichoData, "適用日"));
        row.setJutokuTekiyoJiyu(getMapValueToRString(hihokenshaDaichoData, "適用事由"));
        row.setJutokuTekiyoJiyuKey(getMapValueToRString(hihokenshaDaichoData, "適用事由Key"));
        row.getHenkoTodokedeDate().setValue(getMapValueToFlexibleDate(hihokenshaDaichoData, "変更届出日"));
        row.getHenkoDate().setValue(getMapValueToFlexibleDate(hihokenshaDaichoData, "変更日"));
        row.setHenkoJiyu(getMapValueToRString(hihokenshaDaichoData, "変更事由"));
        row.setHenkoJiyuKey(getMapValueToRString(hihokenshaDaichoData, "変更事由Key"));
        row.getNenreiTotatsuDate().setValue(getMapValueToFlexibleDate(hihokenshaDaichoData, "1号年齢到達日"));
        row.setKyuHokensha(getMapValueToRString(hihokenshaDaichoData, "旧保険者"));
        row.setSaikofuKubun(getMapValueToRString(hihokenshaDaichoData, "再交付区分"));
        row.setSaikofuJiyu(getMapValueToRString(hihokenshaDaichoData, "再交付事由"));
        row.setShikibetsuCode(getMapValueToRString(hihokenshaDaichoData, "識別コード"));
        return row;
    }

    private void setShikakuJohoDisabled(tplShikakuJohoDiv tplShikakuJoho, boolean disableValue) {
        tplShikakuJoho.getShikakuShutoku().setDisabled(disableValue);
        tplShikakuJoho.getShikakuSoshitsu().setDisabled(disableValue);
        tplShikakuJoho.getJutokuTekiyo().setDisabled(disableValue);
        tplShikakuJoho.getJutokuKaijo().setDisabled(disableValue);
        tplShikakuJoho.getShikakuHenko().setDisabled(disableValue);
        tplShikakuJoho.getOtherShichosonJoho().setDisabled(disableValue);
        tplShikakuJoho.getBtnUpdateShikaku().setDisabled(disableValue);
    }

    /**
     * 医療保険Tabに初期表示する値を設定します。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param shikibetsuCode 識別コード
     */
    private void setIryoHoken(ShikakuJohoDiv shikakuJohoDiv, RString shikibetsuCode) {
        tplIryoHokenDiv tplIryoHoken = shikakuJohoDiv.getTabInputs().getTplIryoHoken();

        List<HashMap> iryoHokenDataList = YamlLoader.FOR_DBA.loadAsList(IRYO_HOKEN_DATA);
        DataGrid<dgIryoHokenRireki_Row> grid = tplIryoHoken.getDgIryoHokenRireki();
        List<dgIryoHokenRireki_Row> dataSource = new ArrayList<>();
        for (HashMap iryoHokenData : iryoHokenDataList) {
            if (iryoHokenData.get("識別コード").toString().equals(shikibetsuCode.toString())) {
                dataSource = createDgIryoHokenRirekiList((List<HashMap>) iryoHokenData.get("医療保険"));
            }
        }
        grid.setDataSource(dataSource);

        if (dataSource.isEmpty()) {
            shikakuJohoDiv.setIryoHokenInputMode(IRYO_HOKEN_ADD);
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

        row.setHokenshaNo(getMapValueToRString(hihokenshaDaichoData, "保険者番号"));
        row.setHokenshaMeisho(getMapValueToRString(hihokenshaDaichoData, "保険者名称"));
        row.setHokensha(row.getHokenshaNo().concat(":").concat(row.getHokenshaMeisho()));
        row.setIryoHokenShubetsuKey(getMapValueToRString(hihokenshaDaichoData, "保険者種別Key"));
        row.setIryoHokenShubetsu(getMapValueToRString(hihokenshaDaichoData, "保険者種別"));
        row.getKanyuDate().setValue(getMapValueToFlexibleDate(hihokenshaDaichoData, "加入日"));
        row.getDattaiDate().setValue(getMapValueToFlexibleDate(hihokenshaDaichoData, "脱退日"));
        row.setKigoNo(getMapValueToRString(hihokenshaDaichoData, "記号番号"));
        return row;
    }

    private void setIryoHokenDisabled(tplIryoHokenDiv tplIryoHoken, boolean disableValue) {
        tplIryoHoken.getIryoHokenInput().setDisabled(disableValue);
        tplIryoHoken.getBtnUpdateIryoHoken().setDisabled(disableValue);
    }

    /**
     * 老福年金Tabに初期表示する値を設定します。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param shikibetsuCode 識別コード
     */
    private void setRofukuNenkin(ShikakuJohoDiv shikakuJohoDiv, RString shikibetsuCode) {
        tplRofukuNenkinDiv tplRofukuNenkin = shikakuJohoDiv.getTabInputs().getTplRofukuNenkin();

        List<HashMap> rofukuNenkinDataList = YamlLoader.FOR_DBA.loadAsList(ROFUKU_NENKIN_DATA);
        DataGrid<dgRohukuNenkinRireki_Row> grid = tplRofukuNenkin.getRohukuNenkin().getDgRohukuNenkinRireki();
        List<dgRohukuNenkinRireki_Row> dataSource = new ArrayList<>();
        for (HashMap rofukuNenkiData : rofukuNenkinDataList) {
            if (rofukuNenkiData.get("識別コード").toString().equals(shikibetsuCode.toString())) {
                dataSource = createRofukuNenkinList((List<HashMap>) rofukuNenkiData.get("老福年金"));
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

        row.setJukyushaNo(getMapValueToRString(rofukuNenkiData, "受給者番号"));
        row.getKaishiDate().setValue(getMapValueToFlexibleDate(rofukuNenkiData, "開始日"));
        row.getShuryoDate().setValue(getMapValueToFlexibleDate(rofukuNenkiData, "終了日"));
        return row;
    }

    private void setRofukuNenkinDisabled(tplRofukuNenkinDiv tplRofukuNenkin, boolean disableValue) {
        tplRofukuNenkin.getRohukuNenkin().getRohukuNenkinInput().setDisabled(disableValue);
        tplRofukuNenkin.getRohukuNenkin().getBtnUpdateRofukuNenkin().setDisabled(disableValue);
    }

    /**
     * 生活保護Tabに初期表示する値を設定します。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param shikibetsuCode 識別コード
     */
    private void setSeikatsuHogo(ShikakuJohoDiv shikakuJohoDiv, RString shikibetsuCode) {
        tplSeikatsuHogoDiv tplSeikatsuHogo = shikakuJohoDiv.getTabInputs().getTplSeikatsuHogo();

        List<HashMap> seikatsuHogoDataList = YamlLoader.FOR_DBA.loadAsList(SEIKATSU_HOGO_DATA);
        DataGrid<dgSeikatsuHogoRireki_Row> grid = tplSeikatsuHogo.getSeikatsuHogo().getDgSeikatsuHogoRireki();
        List<dgSeikatsuHogoRireki_Row> dataSource = new ArrayList<>();
        for (HashMap seikatsuHogoData : seikatsuHogoDataList) {
            if (seikatsuHogoData.get("識別コード").toString().equals(shikibetsuCode.toString())) {
                dataSource = createSeikatsuHogoList((List<HashMap>) seikatsuHogoData.get("生活保護"));
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

        row.setJukyushaNo(getMapValueToRString(seikatsuHogoData, "受給者番号"));
        row.getKaishiDate().setValue(getMapValueToFlexibleDate(seikatsuHogoData, "開始日"));
        row.getShuryoDate().setValue(getMapValueToFlexibleDate(seikatsuHogoData, "終了日"));
        row.setSeihoShubetsu(getMapValueToRString(seikatsuHogoData, "生活保護種別"));
        row.setSeihoShubetsuKey(getMapValueToRString(seikatsuHogoData, "生活保護種別Key"));
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
    private void setShisetsuNyutaisho(ShikakuJohoDiv shikakuJohoDiv, RString shikibetsuCode) {
        tplShisetsuNyutaishoDiv tplShisetsuNyutaisho = shikakuJohoDiv.getTabInputs().getTplShisetsuNyutaisho();

        List<HashMap> shisetsuNyutaishoRirekiDataList = YamlLoader.FOR_DBA.loadAsList(SHISETSU_NYUTAISHO_DATA);
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

        row.getNyushoDate().setValue(getMapValueToFlexibleDate(seikatsuHogoData, "入所日"));
        row.getTaishoDate().setValue(getMapValueToFlexibleDate(seikatsuHogoData, "退所日"));
        row.setShisetsuCode(getMapValueToRString(seikatsuHogoData, "施設コード"));
        row.setShisetsuMeisho(getMapValueToRString(seikatsuHogoData, "施設名称"));
        row.setShisetsu(row.getShisetsuCode().concat(":").concat(row.getShisetsuMeisho()));
        row.setTaishoJohoKey(getMapValueToRString(seikatsuHogoData, "対象情報Key"));
        row.setTaishoJoho(getMapValueToRString(seikatsuHogoData, "対象情報"));
        row.setShisetsuShuruiKey(getMapValueToRString(seikatsuHogoData, "施設種類Key"));
        row.setShisetsuShurui(getMapValueToRString(seikatsuHogoData, "施設種類"));
        return row;
    }

    private void setShisetsuNyutaishoDisabled(tplShisetsuNyutaishoDiv tplShisetsuNyutaisho, boolean disableValue) {
        tplShisetsuNyutaisho.getShisetsuNyutaishoRirekiKanri().getShisetsuNyutaishoInput().setDisabled(disableValue);
        tplShisetsuNyutaisho.getShisetsuNyutaishoRirekiKanri().getBtnUpdateShisetsuNyutaisho().setDisabled(disableValue);
    }

    /**
     * 資格情報タブ内の処理です。資格情報追加ボタンがクリックされた際に実行します。<br/>
     * 入力モードを新規追加モードに変更します。また、確定ボタンのラベル追加用に変更されます。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param taishoshaJoho 対象者情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnAddShikaku(ShikakuJohoDiv shikakuJohoDiv, ShikakuShutokuTaishoshaJohoDiv taishoshaJoho) {
        ResponseData<ShikakuJohoDiv> response = new ResponseData<>();
        tplShikakuJohoDiv tplShikakuJoho = shikakuJohoDiv.getTabInputs().getTplShikakuJoho();

        shikakuJohoDiv.setShikakuInputMode(SHIKAKU_ADD);
        setShikakuJohoDisabled(tplShikakuJoho, false);
        tplShikakuJoho.getBtnUpdateShikaku().setText(new RString("追加内容を確定する"));

        clearShikakuJohoInput(shikakuJohoDiv.getTabInputs().getTplShikakuJoho());
        response.data = shikakuJohoDiv;
        return response;
    }

    /**
     * 資格情報タブ内の処理です。グリッド内の視覚情報修正ボタンがクリックされた際に実行します。<br/>
     * 入力モードを修正モードに変更し、選択したグリッドのデータを表示します。また、確定ボタンのラベルが修正用に変更されます。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param taishoshaJoho 対象者情報Div
     * @return レスポンス
     */
    public ResponseData onSelectOfModifyButton_dgShikakuShutokuRireki(ShikakuJohoDiv shikakuJohoDiv, ShikakuShutokuTaishoshaJohoDiv taishoshaJoho) {
        ResponseData<ShikakuJohoDiv> response = new ResponseData<>();
        tplShikakuJohoDiv tplShikakuJoho = shikakuJohoDiv.getTabInputs().getTplShikakuJoho();

        shikakuJohoDiv.setShikakuInputMode(SHIKAKU_MODIFY);
        shikakuJohoDiv.setShikakuSelectRow(new RString(Integer.toString(tplShikakuJoho.getDgShikakuShutokuRireki().getClickedRowId())));
        setShikakuJohoInput(tplShikakuJoho, tplShikakuJoho.getDgShikakuShutokuRireki().getClickedItem());
        setShikakuJohoDisabled(tplShikakuJoho, false);
        tplShikakuJoho.getBtnUpdateShikaku().setText(new RString("修正内容を確定する"));
        response.data = shikakuJohoDiv;
        return response;
    }

    /**
     * 資格情報タブ内の処理です。グリッド内の資格情報削除ボタンがクリックされた際に実行します。<br/>
     * 入力モードを削除モードに変更し、確定ボタン以外のコントロールを編集不可状態で詳細表示します。また、確定ボタンのラベルが削除用に変更されます。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param taishoshaJoho 対象者情報Div
     * @return レスポンス
     */
    public ResponseData onSelectOfDeleteButton_dgShikakuShutokuRireki(ShikakuJohoDiv shikakuJohoDiv, ShikakuShutokuTaishoshaJohoDiv taishoshaJoho) {
        ResponseData<ShikakuJohoDiv> response = new ResponseData<>();
        tplShikakuJohoDiv tplShikakuJoho = shikakuJohoDiv.getTabInputs().getTplShikakuJoho();

        shikakuJohoDiv.setShikakuInputMode(SHIKAKU_DELETE);
        shikakuJohoDiv.setShikakuSelectRow(new RString(Integer.toString(tplShikakuJoho.getDgShikakuShutokuRireki().getClickedRowId())));
        setShikakuJohoInput(tplShikakuJoho, tplShikakuJoho.getDgShikakuShutokuRireki().getClickedItem());
        setShikakuJohoDisabled(tplShikakuJoho, true);
        tplShikakuJoho.getBtnUpdateShikaku().setDisabled(false);
        tplShikakuJoho.getBtnUpdateShikaku().setText(new RString("削除内容を確定する"));
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
     * @param taishoshaJoho 対象者情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnUpdateShikaku(ShikakuJohoDiv shikakuJohoDiv, ShikakuShutokuTaishoshaJohoDiv taishoshaJoho) {
        ResponseData<ShikakuJohoDiv> response = new ResponseData<>();
        tplShikakuJohoDiv tplShikakuJoho = shikakuJohoDiv.getTabInputs().getTplShikakuJoho();
        int selectRowNum;
        dgShikakuShutokuRireki_Row selectRow;

        if (shikakuJohoDiv.getShikakuInputMode().equals(SHIKAKU_ADD)) {
            dgShikakuShutokuRireki_Row row = createShikakuShutokuRirekiRowFromInputValue(tplShikakuJoho, taishoshaJoho);
            row.setRowState(RowState.Added);
            tplShikakuJoho.getDgShikakuShutokuRireki().getDataSource().add(0, row);
        } else if (shikakuJohoDiv.getShikakuInputMode().equals(SHIKAKU_MODIFY)) {
            selectRowNum = Integer.parseInt(shikakuJohoDiv.getShikakuSelectRow().toString());
            selectRow = tplShikakuJoho.getDgShikakuShutokuRireki().getDataSource().get(selectRowNum);
            setShikakuShutokuRirekiRowFromInputValue(tplShikakuJoho, taishoshaJoho, selectRow);
            if (selectRow.getRowState().equals(RowState.Added)) {
            } else {
                selectRow.setRowState(RowState.Modified);
            }
        } else if (shikakuJohoDiv.getShikakuInputMode().equals(SHIKAKU_DELETE)) {
            selectRowNum = Integer.parseInt(shikakuJohoDiv.getShikakuSelectRow().toString());
            selectRow = tplShikakuJoho.getDgShikakuShutokuRireki().getDataSource().get(selectRowNum);
            if (selectRow.getRowState().equals(RowState.Added)) {
                tplShikakuJoho.getDgShikakuShutokuRireki().getDataSource().remove(selectRowNum);
            } else {
                tplShikakuJoho.getDgShikakuShutokuRireki().getDataSource().get(selectRowNum).setRowState(RowState.Deleted);
            }
        }

        setShikakuJohoDisabled(tplShikakuJoho, true);
        clearShikakuJohoInput(shikakuJohoDiv.getTabInputs().getTplShikakuJoho());
        response.data = shikakuJohoDiv;
        return response;
    }

    private dgShikakuShutokuRireki_Row createShikakuShutokuRirekiRowFromInputValue(tplShikakuJohoDiv tplShikakuJoho,
            ShikakuShutokuTaishoshaJohoDiv taishoshaJoho) {
        dgShikakuShutokuRireki_Row row = new dgShikakuShutokuRireki_Row(new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY,
                RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(),
                new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
                RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY);
        setShikakuShutokuRirekiRowFromInputValue(tplShikakuJoho, taishoshaJoho, row);
        return row;
    }

    private void setShikakuShutokuRirekiRowFromInputValue(tplShikakuJohoDiv tplShikakuJoho,
            ShikakuShutokuTaishoshaJohoDiv taishoshaJoho, dgShikakuShutokuRireki_Row row) {

        if (tplShikakuJoho.getShikakuShutoku().getTxtShutokuDate().getValue() != null) {
            ShikakuShutokuDiv shutoku = tplShikakuJoho.getShikakuShutoku();
            row.getShutokuTodokedeDate().setValue(shutoku.getTxtShutokuTodokedeDate().getValue());
            row.getShutokuDate().setValue(shutoku.getTxtShutokuDate().getValue());
            row.setShutokuJiyu(shutoku.getDdlShikakuShutokuJiyu().getSelectedValue());
            row.setShutokuJiyuKey(shutoku.getDdlShikakuShutokuJiyu().getSelectedItem());

            row.setHihokenshaKubunKey(shutoku.getDdlHihokenshaKubun().getSelectedItem());
            row.setHihokenshaKubun(shutoku.getDdlHihokenshaKubun().getSelectedValue());
            row.getNenreiTotatsuDate().setValue(shutoku.getTxtNenreiTotatsuDate().getValue());
        }

        if (tplShikakuJoho.getShikakuSoshitsu().getTxtSoshitsuDate().getValue() != null) {
            ShikakuSoshitsuDiv soshitsu = tplShikakuJoho.getShikakuSoshitsu();
            row.getSoshitsuTodokedeDate().setValue(soshitsu.getTxtSoshitsuTodokedeDate().getValue());
            row.getSoshitsuDate().setValue(soshitsu.getTxtSoshitsuDate().getValue());
            row.setSoshitsuJiyu(soshitsu.getDdlSoshitsuJiyu().getSelectedValue());
            row.setSoshitsuJiyuKey(soshitsu.getDdlSoshitsuJiyu().getSelectedItem());
        }

        if (tplShikakuJoho.getJutokuTekiyo().getTxtJutokuTekiyoDate().getValue() != null) {
            JutokuTekiyoDiv tekiyo = tplShikakuJoho.getJutokuTekiyo();
            row.getJutokuTekiyoTodokedeDate().setValue(tekiyo.getTxtJutokuTekiyoTodokedeDate().getValue());
            row.getJutokuTekiyoDate().setValue(tekiyo.getTxtJutokuTekiyoDate().getValue());
            row.setJutokuTekiyoJiyu(tekiyo.getDdlJutokuTekiyoJiyu().getSelectedValue());
            row.setJutokuTekiyoJiyuKey(tekiyo.getDdlJutokuTekiyoJiyu().getSelectedItem());
        }

        if (tplShikakuJoho.getJutokuKaijo().getTxtJutokuKaijoDate().getValue() != null) {
            JutokuKaijoDiv kaijo = tplShikakuJoho.getJutokuKaijo();
            row.getJutokuKaijoTodokedeDate().setValue(kaijo.getTxtJutokuKaijoTodokedeDate().getValue());
            row.getJutokuKaijoDate().setValue(kaijo.getTxtJutokuKaijoDate().getValue());
            row.setJutokuKaijoJiyu(kaijo.getDdlJutokuKaijoJiyu().getSelectedValue());
            row.setJutokuKaijoJiyuKey(kaijo.getDdlJutokuKaijoJiyu().getSelectedItem());
        }

        if (tplShikakuJoho.getShikakuHenko().getTxtHenkoDate().getValue() != null) {
            ShikakuHenkoDiv henko = tplShikakuJoho.getShikakuHenko();
            row.getHenkoTodokedeDate().setValue(henko.getTxtHenkoTodokedeDate().getValue());
            row.getHenkoDate().setValue(henko.getTxtHenkoDate().getValue());
            row.setHenkoJiyu(henko.getDdlHenkoJiyu().getSelectedValue());
            row.setHenkoJiyuKey(henko.getDdlHenkoJiyu().getSelectedItem());
        }

        if (tplShikakuJoho.getOtherShichosonJoho().isVisible()) {
            OtherShichosonJohoDiv other = tplShikakuJoho.getOtherShichosonJoho();
            AtenaShokaiSimpleDiv atenaJoho = taishoshaJoho.getShikakuShutokuTaishoshaCommonJoho();
            ShikakuShutokuTaishoshaDbJohoDiv dbJoho = taishoshaJoho.getShikakuShutokuTaishoshaDbJoho();
            row.setKyuHokensha(dbJoho.getTxtKyuShichoson().getValue());
            row.setSaikofuKubun(null);
            row.setSaikofuJiyu(null);
            row.setShikibetsuCode(atenaJoho.getTxtShikibetsuCode().getValue());
        }
    }

    private void setShikakuJohoInput(tplShikakuJohoDiv tplShikakuJoho, dgShikakuShutokuRireki_Row row) {
        setShikakuShutokuJohoInput(tplShikakuJoho, row.getShutokuJiyuKey(), row.getShutokuDate().getValue(),
                row.getShutokuTodokedeDate().getValue(), row.getHihokenshaKubunKey(), row.getNenreiTotatsuDate().getValue());
        setShikakuSoshitsuJohoInput(tplShikakuJoho, row.getSoshitsuJiyuKey(), row.getSoshitsuDate().getValue(),
                row.getSoshitsuTodokedeDate().getValue());
        setJutokuTekiyoJohoInput(tplShikakuJoho, row.getJutokuTekiyoJiyuKey(), row.getJutokuTekiyoDate().getValue(),
                row.getJutokuTekiyoTodokedeDate().getValue());
        setJutokuKaijoJohoInput(tplShikakuJoho, row.getJutokuKaijoJiyuKey(), row.getJutokuKaijoDate().getValue(),
                row.getJutokuKaijoTodokedeDate().getValue());
        setShikakuHenkoJohoInput(tplShikakuJoho, row.getHenkoJiyuKey(), row.getHenkoDate().getValue(),
                row.getHenkoTodokedeDate().getValue());
        setOtherShichosonJohoInput(tplShikakuJoho, row.getHokensha(), row.getKyuHokensha(), row.getSochimotoHokensha(),
                null, null, row.getShikibetsuCode());
    }

    private void clearShikakuJohoInput(tplShikakuJohoDiv tplShikakuJoho) {
        setShikakuShutokuJohoInput(tplShikakuJoho, new RString("tennyu"), null, null, new RString("dai1Go"), null);
        setShikakuSoshitsuJohoInput(tplShikakuJoho, new RString("tenshutsu"), null, null);
        setJutokuTekiyoJohoInput(tplShikakuJoho, new RString("jutokuTekiyo"), null, null);
        setJutokuKaijoJohoInput(tplShikakuJoho, new RString("jutokuKaijo"), null, null);
        setShikakuHenkoJohoInput(tplShikakuJoho, new RString("tennyu"), null, null);
        setOtherShichosonJohoInput(tplShikakuJoho, new RString("key0"), new RString("key0"), new RString("key0"), null, null, null);
    }

    private void setShikakuShutokuJohoInput(tplShikakuJohoDiv tplShikakuJoho, RString ddlShikakuShutokuJiyu, FlexibleDate ShutokuDate,
            FlexibleDate ShutokuTodokedeDate, RString ddlHihokenshaKubun, FlexibleDate nenreiTotatsuDate) {
        ShikakuShutokuDiv shikakuShutoku = tplShikakuJoho.getShikakuShutoku();
        shikakuShutoku.getDdlShikakuShutokuJiyu().setSelectedItem(ddlShikakuShutokuJiyu);
        shikakuShutoku.getTxtShutokuDate().setValue(ShutokuDate);
        shikakuShutoku.getTxtShutokuTodokedeDate().setValue(ShutokuTodokedeDate);
        shikakuShutoku.getDdlHihokenshaKubun().setSelectedItem(ddlHihokenshaKubun);
        shikakuShutoku.getTxtNenreiTotatsuDate().setValue(nenreiTotatsuDate);
    }

    private void setShikakuSoshitsuJohoInput(tplShikakuJohoDiv tplShikakuJoho, RString ddlSoshitsuJiyu, FlexibleDate soshitsuDate,
            FlexibleDate soShitsuTodokedeDate) {
        ShikakuSoshitsuDiv shikakuSoshitsu = tplShikakuJoho.getShikakuSoshitsu();
        shikakuSoshitsu.getDdlSoshitsuJiyu().setSelectedItem(ddlSoshitsuJiyu);
        shikakuSoshitsu.getTxtSoshitsuDate().setValue(soshitsuDate);
        shikakuSoshitsu.getTxtSoshitsuTodokedeDate().setValue(soShitsuTodokedeDate);
    }

    private void setJutokuTekiyoJohoInput(tplShikakuJohoDiv tplShikakuJoho, RString ddlJutokuTekiyoJiyu, FlexibleDate jutokuTekiyoDate,
            FlexibleDate jutokuTekiyoTodokedeDate) {
        JutokuTekiyoDiv jutokuTekiyo = tplShikakuJoho.getJutokuTekiyo();
        jutokuTekiyo.getDdlJutokuTekiyoJiyu().setSelectedItem(ddlJutokuTekiyoJiyu);
        jutokuTekiyo.getTxtJutokuTekiyoDate().setValue(jutokuTekiyoDate);
        jutokuTekiyo.getTxtJutokuTekiyoTodokedeDate().setValue(jutokuTekiyoTodokedeDate);
    }

    private void setJutokuKaijoJohoInput(tplShikakuJohoDiv tplShikakuJoho, RString ddlJutokuKaijoJiyu, FlexibleDate jutokuKaijoDate,
            FlexibleDate jutokuKaijoTodokedeDate) {
        JutokuKaijoDiv jutokuKaijo = tplShikakuJoho.getJutokuKaijo();
        jutokuKaijo.getDdlJutokuKaijoJiyu().setSelectedItem(ddlJutokuKaijoJiyu);
        jutokuKaijo.getTxtJutokuKaijoDate().setValue(jutokuKaijoDate);
        jutokuKaijo.getTxtJutokuKaijoTodokedeDate().setValue(jutokuKaijoTodokedeDate);
    }

    private void setShikakuHenkoJohoInput(tplShikakuJohoDiv tplShikakuJoho, RString ddlHenkoJiyu, FlexibleDate henkoDate, FlexibleDate henkoTodokedeDate) {
        ShikakuHenkoDiv shikakuHenko = tplShikakuJoho.getShikakuHenko();
        shikakuHenko.getDdlHenkoJiyu().setSelectedItem(ddlHenkoJiyu);
        shikakuHenko.getTxtHenkoDate().setValue(henkoDate);
        shikakuHenko.getTxtHenkoTodokedeDate().setValue(henkoTodokedeDate);
    }

    private void setOtherShichosonJohoInput(tplShikakuJohoDiv tplShikakuJoho, RString ddlHokensha, RString ddlKyuHokensha, RString ddlSochimotoHokensha,
            RString kyuHihokenshaNo, RString musubitsukeTaishosha, RString ShikibetsuCode) {
        OtherShichosonJohoDiv otherShichosonJoho = tplShikakuJoho.getOtherShichosonJoho();
        otherShichosonJoho.getDdlHokensha().setSelectedItem(ddlHokensha);
        otherShichosonJoho.getDdlKyuHokensha().setSelectedItem(ddlKyuHokensha);
        otherShichosonJoho.getDdlSochimotoHokensha().setSelectedItem(ddlSochimotoHokensha);
        otherShichosonJoho.getTxtKyuHihokenshaNo().setValue(kyuHihokenshaNo);
        otherShichosonJoho.getTxtMusubitsukeTaishosha().setValue(musubitsukeTaishosha);
        otherShichosonJoho.getTxtShikibetsuCode().setValue(ShikibetsuCode);
    }

    /**
     * 医療保険タブ内の処理です。医療保険情報追加ボタンがクリックされた際に実行します。<br/>
     * 入力モードを新規追加モードに変更します。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param taishoshaJoho 対象者情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnAddIryoHoken(ShikakuJohoDiv shikakuJohoDiv, ShikakuShutokuTaishoshaJohoDiv taishoshaJoho) {
        ResponseData<ShikakuJohoDiv> response = new ResponseData<>();
        tplIryoHokenDiv tplIryoHoken = shikakuJohoDiv.getTabInputs().getTplIryoHoken();

        shikakuJohoDiv.setIryoHokenInputMode(IRYO_HOKEN_ADD);
        setIryoHokenDisabled(tplIryoHoken, false);
        tplIryoHoken.getBtnUpdateIryoHoken().setText(new RString("追加内容を確定する"));
        clearIryoHokenInput(tplIryoHoken);
        response.data = shikakuJohoDiv;
        return response;
    }

    /**
     * 医療保険タブ内の処理です。資格情報修正ボタンがクリックされた際に実行します。<br/>
     * 入力モードを修正モードに変更します。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param taishoshaJoho 対象者情報Div
     * @return レスポンス
     */
    public ResponseData onSelectOfModifyButton_dgIryoHokenRireki(ShikakuJohoDiv shikakuJohoDiv, ShikakuShutokuTaishoshaJohoDiv taishoshaJoho) {
        ResponseData<ShikakuJohoDiv> response = new ResponseData<>();
        tplIryoHokenDiv tplIryoHoken = shikakuJohoDiv.getTabInputs().getTplIryoHoken();

        shikakuJohoDiv.setIryoHokenInputMode(IRYO_HOKEN_MODIFY);
        shikakuJohoDiv.setIryoHokenSelectRow(new RString(Integer.toString(tplIryoHoken.getDgIryoHokenRireki().getClickedRowId())));
        setIryoHokenInput(tplIryoHoken, tplIryoHoken.getDgIryoHokenRireki().getClickedItem());
        setIryoHokenDisabled(tplIryoHoken, false);
        tplIryoHoken.getBtnUpdateIryoHoken().setText(new RString("修正内容を確定する"));
        response.data = shikakuJohoDiv;
        return response;
    }

    /**
     * 医療保険タブ内の処理です。資格情報削除ボタンがクリックされた際に実行します。<br/>
     * 入力モードを削除に変更し、全てのコントロールをreadOnlyに変更します。
     *
     * @param shikakuJohoDiv 資格情報Div
     * @param taishoshaJoho 対象者情報Div
     * @return レスポンス
     */
    public ResponseData onSelectOfDeleteButton_dgIryoHokenRireki(ShikakuJohoDiv shikakuJohoDiv, ShikakuShutokuTaishoshaJohoDiv taishoshaJoho) {
        ResponseData<ShikakuJohoDiv> response = new ResponseData<>();
        tplIryoHokenDiv tplIryoHoken = shikakuJohoDiv.getTabInputs().getTplIryoHoken();

        shikakuJohoDiv.setIryoHokenInputMode(IRYO_HOKEN_DELETE);
        shikakuJohoDiv.setIryoHokenSelectRow(new RString(Integer.toString(tplIryoHoken.getDgIryoHokenRireki().getClickedRowId())));
        setIryoHokenInput(tplIryoHoken, tplIryoHoken.getDgIryoHokenRireki().getClickedItem());
        setIryoHokenDisabled(tplIryoHoken, true);
        tplIryoHoken.getBtnUpdateIryoHoken().setDisabled(false);
        tplIryoHoken.getBtnUpdateIryoHoken().setText(new RString("削除内容を確定する"));
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
     * @param taishoshaJoho 対象者情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnUpdateIryoHoken(ShikakuJohoDiv shikakuJohoDiv, ShikakuShutokuTaishoshaJohoDiv taishoshaJoho) {
        ResponseData<ShikakuJohoDiv> response = new ResponseData<>();
        tplIryoHokenDiv tplIryoHoken = shikakuJohoDiv.getTabInputs().getTplIryoHoken();
        int selectRowNum;

        if (shikakuJohoDiv.getIryoHokenInputMode().equals(IRYO_HOKEN_ADD)) {
            dgIryoHokenRireki_Row row = createDgIryoHokenRirekiRowFrowInputValue(tplIryoHoken, taishoshaJoho);
            row.setRowState(RowState.Added);
            tplIryoHoken.getDgIryoHokenRireki().getDataSource().add(0, row);
        } else if (shikakuJohoDiv.getIryoHokenInputMode().equals(IRYO_HOKEN_MODIFY)) {
            selectRowNum = Integer.parseInt(shikakuJohoDiv.getIryoHokenSelectRow().toString());
            dgIryoHokenRireki_Row selectRow = tplIryoHoken.getDgIryoHokenRireki().getDataSource().get(selectRowNum);
            setDgIryoHokenRirekiRowFrowInputValue(tplIryoHoken, taishoshaJoho, selectRow);
            if (selectRow.getRowState().equals(RowState.Added)) {
            } else {
                selectRow.setRowState(RowState.Modified);
            }
        } else if (shikakuJohoDiv.getIryoHokenInputMode().equals(IRYO_HOKEN_DELETE)) {
            selectRowNum = Integer.parseInt(shikakuJohoDiv.getIryoHokenSelectRow().toString());
            dgIryoHokenRireki_Row selectRow = tplIryoHoken.getDgIryoHokenRireki().getDataSource().get(selectRowNum);
            if (selectRow.getRowState().equals(RowState.Added)) {
                tplIryoHoken.getDgIryoHokenRireki().getDataSource().remove(selectRowNum);
            } else {
                selectRow.setRowState(RowState.Deleted);
            }
        }

        setIryoHokenDisabled(tplIryoHoken, true);
        clearIryoHokenInput(tplIryoHoken);
        response.data = shikakuJohoDiv;
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

    private dgIryoHokenRireki_Row createDgIryoHokenRirekiRowFrowInputValue(tplIryoHokenDiv tplIryoHoken, ShikakuShutokuTaishoshaJohoDiv taishoshaJoho) {
        dgIryoHokenRireki_Row row = new dgIryoHokenRireki_Row(new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        setDgIryoHokenRirekiRowFrowInputValue(tplIryoHoken, taishoshaJoho, row);
        return row;
    }

    private dgIryoHokenRireki_Row setDgIryoHokenRirekiRowFrowInputValue(tplIryoHokenDiv tplIryoHoken, ShikakuShutokuTaishoshaJohoDiv taishoshaJoho, dgIryoHokenRireki_Row row) {
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

    private RString getMapValueToRString(HashMap hash, String str) {
        String hashValue = (String) hash.get(str);
        if (hashValue == null) {
            return null;
        }
        return new RString(hashValue);
    }

    private FlexibleDate getMapValueToFlexibleDate(HashMap hash, String str) {
        String hashValue = (String) hash.get(str);
        if (hashValue == null) {
            return null;
        }
        return new FlexibleDate(hashValue);
    }

}
