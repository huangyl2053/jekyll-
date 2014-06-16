/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShokaiIryoHokenDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShokaiPanelSelectDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShokaiRofukuNenkinDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShokaiSeikatsuHogoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShokaiSetaiShokaiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShokaiShikakuTokusoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShokaiShinseiTodokedeDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShokaiShisetsuNyutaishoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShokaiShoKofuKaishuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShokaiTaishoSearchDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.dgRoreiFukushiRireki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.dgSeikatsuHogoRireki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.dgSetaiJoho_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.dgShinseishoTodokede_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.ShisetsuNyutaishoRirekiKanri;
import jp.co.ndensan.reams.db.dbz.divcontroller.ShoKaishuKirokuKanri;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.iryohokenrireki.dgIryoHokenRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakutokusorireki.dgShikakuShutokuRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.dgShisetsuNyutaishoRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishukirokukanri.dgShoKaishuJokyo_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ModeType;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 被保険者照会画面で、表示したい情報を選択するためのパネルに対応するコントローラです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaShokaiPanelSelect {

    /**
     * 該当者一覧から、被保険者照会の対象となる個人が選択された際に実行します。<br/>
     * 選択した個人の情報を元に、照会画面で参照できる情報を設定・表示します。もし表示できる情報が存在しない場合、
     * 対象の情報を参照できないように状態遷移ボタンを非活性にします。
     *
     * @param selectDiv 照会情報選択Div
     * @param searchDiv 検索Div
     * @return レスポンス
     */
    public ResponseData onClick_btnToDecide(HihokenshaShokaiPanelSelectDiv selectDiv, HihokenshaShokaiTaishoSearchDiv searchDiv) {
        ResponseData<HihokenshaShokaiPanelSelectDiv> response = new ResponseData<>();

        setShikakuDiv(selectDiv.getHihokenshaShokaiShikakuTokuso(), searchDiv);
        setSetaiDiv(selectDiv.getHihokenshaShokaiSetaiShokai(), searchDiv);
        setSeikatsuHogoDiv(selectDiv.getHihokenshaShokaiSeikatsuHogo(), searchDiv);
        setRofukuNenkinDiv(selectDiv.getHihokenshaShokaiRofukuNenkin(), searchDiv);
        setIryoHokenDiv(selectDiv.getHihokenshaShokaiIryoHoken(), searchDiv);
        setNyutaishoDiv(selectDiv.getHihokenshaShokaiShisetsuNyutaisho(), searchDiv);
        setShoKofuKaishuDiv(selectDiv.getHihokenshaShokaiShoKofuKaishu(), searchDiv);
        setShinseiTodokedeDiv(selectDiv.getHihokenshaShokaiShinseiTodokede(), searchDiv);

        setStateButtonDisabled(selectDiv);

        ShoKaishuKirokuKanri.setMode(selectDiv.getHihokenshaShokaiShoKofuKaishu().getShoKofuKaishuKiroku(), ModeType.SHOKAI_MODE);
        ShisetsuNyutaishoRirekiKanri.setMode(selectDiv.getHihokenshaShokaiShisetsuNyutaisho().getShisetsuNyutaishoRireki(), ModeType.SHOKAI_MODE);

        response.data = selectDiv;
        return response;
    }

    private static final RString SHIKAKU_TOKUSO = new RString("DBA4010011/shikakuTokuso.yml");

    /**
     * 該当者一覧から、被保険者照会の対象となる個人が選択された際に実行します。<br/>
     * 選択した個人の被保険者番号を元に、資格得喪の情報を取得して表示します。
     *
     * @param shikakuDiv 資格得喪Div
     * @param searchDiv 検索Div
     * @return 資格得喪Div
     */
    private HihokenshaShokaiShikakuTokusoDiv setShikakuDiv(HihokenshaShokaiShikakuTokusoDiv shikakuDiv, HihokenshaShokaiTaishoSearchDiv searchDiv) {

        RString hihokenshaNo = searchDiv.getSearchResult().getDgSearchResult().getClickedItem().getHihokenshaNo();
        setShikakuTokusoJoho(shikakuDiv.getShikakuTokusoRireki().getDgShikakuShutokuRireki(), hihokenshaNo);
        return shikakuDiv;
    }

    private void setShikakuTokusoJoho(DataGrid<dgShikakuShutokuRireki_Row> dgShikakuShutokuRireki, RString hihokenshaNo) {

        List<HashMap> yamlShikakuTokusoList = YamlLoader.DBA.loadAsList(SHIKAKU_TOKUSO);
        List<HashMap> hihokenshaShikakuTokusoList = new ArrayList<>();
        for (HashMap yamlShikakuTokuso : yamlShikakuTokusoList) {
            ControlGenerator generator = new ControlGenerator(yamlShikakuTokuso);
            if (generator.getAsRString("被保番号").equals(hihokenshaNo)) {
                hihokenshaShikakuTokusoList = (List<HashMap>) generator.get("被保台帳");
            }
        }

        List<dgShikakuShutokuRireki_Row> shikakuTokusoDataSource = new ArrayList<>();
        for (HashMap shikakuTokuso : hihokenshaShikakuTokusoList) {
            shikakuTokusoDataSource.add(createShikakuTokusoRirekiRow(new ControlGenerator(shikakuTokuso)));
        }
        dgShikakuShutokuRireki.setDataSource(shikakuTokusoDataSource);
    }

    private dgShikakuShutokuRireki_Row createShikakuTokusoRirekiRow(ControlGenerator generator) {
        dgShikakuShutokuRireki_Row row = new dgShikakuShutokuRireki_Row(new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY,
                RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(),
                new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
                RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY);

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

    private static final RString SETAI_JOHO = new RString("DBA4010011/setaiJoho.yml");

    /**
     * 該当者一覧から、被保険者照会の対象となる個人が選択された際に実行します。<br/>
     * 選択した個人の識別コードを元に、世帯の情報を照会して表示します。
     *
     * @param setaiDiv 世帯照会Div
     * @param searchDiv 検索Div
     * @return 世帯照会Div
     */
    private HihokenshaShokaiSetaiShokaiDiv setSetaiDiv(HihokenshaShokaiSetaiShokaiDiv setaiDiv, HihokenshaShokaiTaishoSearchDiv searchDiv) {

        RString shikibetsuCode = searchDiv.getSearchResult().getDgSearchResult().getClickedItem().getShikibetsuCode();
        setSetaiJoho(setaiDiv.getDgSetaiJoho(), shikibetsuCode);
        return setaiDiv;
    }

    private void setSetaiJoho(DataGrid<dgSetaiJoho_Row> dgSetaiJoho, RString shikibetsuCode) {

        List<HashMap> yamlSetaiJohoList = YamlLoader.DBA.loadAsList(SETAI_JOHO);
        List<HashMap> setaiJohoList = new ArrayList<>();
        for (HashMap yamlShikakuTokuso : yamlSetaiJohoList) {
            ControlGenerator generator = new ControlGenerator(yamlShikakuTokuso);
            if (generator.getAsRString("識別コード").equals(shikibetsuCode)) {
                setaiJohoList = (List<HashMap>) generator.get("世帯情報");
            }
        }

        List<dgSetaiJoho_Row> setaiJohoDataSource = new ArrayList<>();
        for (HashMap setaiJoho : setaiJohoList) {
            setaiJohoDataSource.add(createSetaiJohoRow(new ControlGenerator(setaiJoho)));
        }
        dgSetaiJoho.setDataSource(setaiJohoDataSource);
    }

    private dgSetaiJoho_Row createSetaiJohoRow(ControlGenerator generator) {
        dgSetaiJoho_Row row = new dgSetaiJoho_Row(RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY);

        row.setShimei(generator.getAsRString("氏名"));
        row.getDateOfBirth().setValue(generator.getAsFlexibleDate("生年月日"));
        row.setAge(generator.getAsRString("年齢"));
        row.setGender(generator.getAsRString("性別"));
        row.setTsuzukigara(generator.getAsRString("続柄"));
        row.setJuminJotai(generator.getAsRString("住民状態"));
        row.setNotJuminDate(generator.getAsTextBoxFlexibleDate("住民でなくなった日"));
        row.setShikibetsuCode(generator.getAsRString("識別コード"));
        row.setKojinNo(generator.getAsRString("個人番号"));
        return row;
    }

    private static final RString SEIKATSU_HOGO = new RString("DBA4010011/seikatsuHogo.yml");

    /**
     * 該当者一覧から、被保険者照会の対象となる個人が選択された際に実行します。<br/>
     * 選択した個人の識別コードを元に、生活保護の情報を表示します。
     *
     * @param seikatsuHogoDiv 生活保護情報Div
     * @param searchDiv 検索Div
     * @return 生活保護情報Div
     */
    private HihokenshaShokaiSeikatsuHogoDiv setSeikatsuHogoDiv(HihokenshaShokaiSeikatsuHogoDiv seikatsuHogoDiv, HihokenshaShokaiTaishoSearchDiv searchDiv) {

        RString shikibetsuCode = searchDiv.getSearchResult().getDgSearchResult().getClickedItem().getShikibetsuCode();
        setSeikatsuHogoJoho(seikatsuHogoDiv.getDgSeikatsuHogoRireki(), shikibetsuCode);
        return seikatsuHogoDiv;
    }

    private void setSeikatsuHogoJoho(DataGrid<dgSeikatsuHogoRireki_Row> dgSetaiJoho, RString shikibetsuCode) {

        List<HashMap> yamlSeikatuHogoData = YamlLoader.DBA.loadAsList(SEIKATSU_HOGO);
        List<HashMap> seikatuHogoDataList = new ArrayList<>();
        for (HashMap yamlSeikatuHogo : yamlSeikatuHogoData) {
            ControlGenerator generator = new ControlGenerator(yamlSeikatuHogo);
            if (generator.getAsRString("識別コード").equals(shikibetsuCode)) {
                seikatuHogoDataList = (List<HashMap>) generator.get("生保情報");
            }
        }

        List<dgSeikatsuHogoRireki_Row> setaiJohoDataSource = new ArrayList<>();
        for (HashMap seikatuHogo : seikatuHogoDataList) {
            setaiJohoDataSource.add(createSeikatsuHogoRirekiRow(new ControlGenerator(seikatuHogo)));
        }
        dgSetaiJoho.setDataSource(setaiJohoDataSource);
    }

    private dgSeikatsuHogoRireki_Row createSeikatsuHogoRirekiRow(ControlGenerator generator) {
        dgSeikatsuHogoRireki_Row row = new dgSeikatsuHogoRireki_Row(RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY);

        row.setJukyushaNo(generator.getAsRString("受給者番号"));
        row.getHaishiYMD().setValue(generator.getAsFlexibleDate("開始日"));
        row.getKaishiYMD().setValue(generator.getAsFlexibleDate("廃止日"));
        row.setSeikatsuHogoShubetsu(generator.getAsRString("種別"));
        return row;
    }

    private static final RString ROFUKU_NENKIN = new RString("DBA4010011/rofukuNenkin.yml");

    /**
     * 該当者一覧から、被保険者照会の対象となる個人が選択された際に実行します。<br/>
     * 選択した個人の識別コードを元に、老齢福祉年金の情報を表示します。
     *
     * @param rofukuNenkinDiv 老齢福祉年金Div
     * @param searchDiv 検索Div
     * @return 老齢福祉年金Div
     */
    private HihokenshaShokaiRofukuNenkinDiv setRofukuNenkinDiv(HihokenshaShokaiRofukuNenkinDiv rofukuNenkinDiv, HihokenshaShokaiTaishoSearchDiv searchDiv) {

        RString shikibetsuCode = searchDiv.getSearchResult().getDgSearchResult().getClickedItem().getShikibetsuCode();
        setRofukuNenkinJoho(rofukuNenkinDiv.getDgRoreiFukushiRireki(), shikibetsuCode);
        return rofukuNenkinDiv;
    }

    private void setRofukuNenkinJoho(DataGrid<dgRoreiFukushiRireki_Row> dgRofukuNenkinJoho, RString shikibetsuCode) {

        List<HashMap> yamlRofukuDataList = YamlLoader.DBA.loadAsList(ROFUKU_NENKIN);
        List<HashMap> rofukuDataList = new ArrayList<>();
        for (HashMap yamlRofukuData : yamlRofukuDataList) {
            ControlGenerator generator = new ControlGenerator(yamlRofukuData);
            if (generator.getAsRString("識別コード").equals(shikibetsuCode)) {
                rofukuDataList = (List<HashMap>) generator.get("老福情報");
            }
        }

        List<dgRoreiFukushiRireki_Row> rofukuJohoDataSource = new ArrayList<>();
        for (HashMap seikatuHogo : rofukuDataList) {
            rofukuJohoDataSource.add(createRofukuNenkinRow(new ControlGenerator(seikatuHogo)));
        }
        dgRofukuNenkinJoho.setDataSource(rofukuJohoDataSource);
    }

    private dgRoreiFukushiRireki_Row createRofukuNenkinRow(ControlGenerator generator) {
        dgRoreiFukushiRireki_Row row = new dgRoreiFukushiRireki_Row(RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate());

        row.setJukyushaNo(generator.getAsRString("受給者番号"));
        row.getHaishiYMD().setValue(generator.getAsFlexibleDate("開始日"));
        row.getKaishiYMD().setValue(generator.getAsFlexibleDate("廃止日"));
        return row;
    }

    private static final RString IRYO_HOKEN = new RString("DBA4010011/iryoHoken.yml");

    /**
     * 該当者一覧から、被保険者照会の対象となる個人が選択された際に実行します。<br/>
     * 選択した個人の識別コードを元に、医療保険の情報を表示します。
     *
     * @param iryoHokenDiv 医療保険Div
     * @param searchDiv 検索Div
     * @return 医療保険Div
     */
    private HihokenshaShokaiIryoHokenDiv setIryoHokenDiv(HihokenshaShokaiIryoHokenDiv iryoHokenDiv, HihokenshaShokaiTaishoSearchDiv searchDiv) {

        RString shikibetsuCode = searchDiv.getSearchResult().getDgSearchResult().getClickedItem().getShikibetsuCode();
        setIryoHokenJoho(iryoHokenDiv.getIryoHokenRireki().getDgIryoHokenRireki(), shikibetsuCode);
        return iryoHokenDiv;
    }

    private void setIryoHokenJoho(DataGrid<dgIryoHokenRireki_Row> dgIryoHoken, RString shikibetsuCode) {

        List<HashMap> yamlIryoHokenDataList = YamlLoader.DBA.loadAsList(IRYO_HOKEN);
        List<HashMap> iryoHokenDataList = new ArrayList<>();
        for (HashMap yamlIryoHokenData : yamlIryoHokenDataList) {
            ControlGenerator generator = new ControlGenerator(yamlIryoHokenData);
            if (generator.getAsRString("識別コード").equals(shikibetsuCode)) {
                iryoHokenDataList = (List<HashMap>) generator.get("医療保険");
            }
        }

        List<dgIryoHokenRireki_Row> iryoHokenDataSource = new ArrayList<>();
        for (HashMap seikatuHogo : iryoHokenDataList) {
            iryoHokenDataSource.add(createIryoHokenRow(new ControlGenerator(seikatuHogo)));
        }
        dgIryoHoken.setDataSource(iryoHokenDataSource);
    }

    private dgIryoHokenRireki_Row createIryoHokenRow(ControlGenerator generator) {
        dgIryoHokenRireki_Row row = new dgIryoHokenRireki_Row(new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        row.setKanyuDate(generator.getAsTextBoxFlexibleDate("加入日"));
        row.setDattaiDate(generator.getAsTextBoxFlexibleDate("脱退日"));
        row.setIryoHokenShubetsuKey(generator.getAsRString("保険者種別Key"));
        row.setIryoHokenShubetsu(generator.getAsRString("保険者種別"));
        row.setHokenshaNo(generator.getAsRString("保険者番号"));
        row.setHokenshaMeisho(generator.getAsRString("保険者名称"));
        row.setHokensha(row.getHokenshaNo().concat(":").concat(row.getHokenshaMeisho()));
        row.setKigoNo(generator.getAsRString("記号番号"));
        return row;
    }

    private static final RString SHISETSU_NYUTAISHO = new RString("DBA4010011/shisetsuNyutaisho.yml");

    /**
     * 該当者一覧から、被保険者照会の対象となる個人が選択された際に実行します。<br/>
     * 選択した個人の被保険者番号を元に、施設入退所の情報を表示します。
     *
     * @param nyutaishoDiv 施設入退所Div
     * @param searchDiv 検索Div
     * @return 施設入退所Div
     */
    private HihokenshaShokaiShisetsuNyutaishoDiv setNyutaishoDiv(HihokenshaShokaiShisetsuNyutaishoDiv nyutaishoDiv, HihokenshaShokaiTaishoSearchDiv searchDiv) {

        RString hihokenshaNo = searchDiv.getSearchResult().getDgSearchResult().getClickedItem().getHihokenshaNo();
        setNyutaishoJoho(nyutaishoDiv.getShisetsuNyutaishoRireki().getDgShisetsuNyutaishoRireki(), hihokenshaNo);
        return nyutaishoDiv;
    }

    private void setNyutaishoJoho(DataGrid<dgShisetsuNyutaishoRireki_Row> dgNyutaisho, RString hihokenshaNo) {

        List<HashMap> yamlNyutaishoDataList = YamlLoader.DBA.loadAsList(SHISETSU_NYUTAISHO);
        List<HashMap> nyutaishoDataList = new ArrayList<>();
        for (HashMap yamlNyutaishoData : yamlNyutaishoDataList) {
            ControlGenerator generator = new ControlGenerator(yamlNyutaishoData);
            if (generator.getAsRString("被保番号").equals(hihokenshaNo)) {
                nyutaishoDataList = (List<HashMap>) generator.get("異動履歴");
            }
        }

        List<dgShisetsuNyutaishoRireki_Row> nyutaishoDataSource = new ArrayList<>();
        for (HashMap seikatuHogo : nyutaishoDataList) {
            nyutaishoDataSource.add(createNyutaishoRow(new ControlGenerator(seikatuHogo)));
        }
        dgNyutaisho.setDataSource(nyutaishoDataSource);
    }

    private dgShisetsuNyutaishoRireki_Row createNyutaishoRow(ControlGenerator generator) {
        dgShisetsuNyutaishoRireki_Row row = new dgShisetsuNyutaishoRireki_Row(new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        row.getNyushoDate().setValue(generator.getAsFlexibleDate("入所日"));
        row.getTaishoDate().setValue(generator.getAsFlexibleDate("退所日"));
        row.setShisetsuShuruiKey(generator.getAsRString("施設種類Key"));
        row.setShisetsuShurui(generator.getAsRString("施設種類"));
        row.setTaishoJohoKey(generator.getAsRString("対象情報Key"));
        row.setTaishoJoho(generator.getAsRString("対象情報"));
        row.setShisetsuCode(generator.getAsRString("施設コード"));
        row.setShisetsuMeisho(generator.getAsRString("施設名称"));
        row.setShisetsu(row.getShisetsuCode().concat(":").concat(row.getShisetsuMeisho()));
        return row;
    }

    private static final RString SHO_KOFU_KAISHU = new RString("DBA4010011/shoKofuKaishu.yml");

    /**
     * 該当者一覧から、被保険者照会の対象となる個人が選択された際に実行します。<br/>
     * 選択した個人の被保険者番号を元に、証類交付回収状況を表示します。
     *
     * @param nyutaishoDiv 証交付回収Div
     * @param searchDiv 検索Div
     * @return 証交付回収Div
     */
    private HihokenshaShokaiShoKofuKaishuDiv setShoKofuKaishuDiv(HihokenshaShokaiShoKofuKaishuDiv nyutaishoDiv, HihokenshaShokaiTaishoSearchDiv searchDiv) {

        RString hihokenshaNo = searchDiv.getSearchResult().getDgSearchResult().getClickedItem().getHihokenshaNo();
        setShoKofuKaishuJoho(nyutaishoDiv.getShoKofuKaishuKiroku().getShoKaishuJokyoList().getDgShoKaishuJokyo(), hihokenshaNo);
        return nyutaishoDiv;
    }

    private void setShoKofuKaishuJoho(DataGrid<dgShoKaishuJokyo_Row> dgShoKofu, RString hihokenshaNo) {

        List<HashMap> yamlShoKofuDataList = YamlLoader.DBA.loadAsList(SHO_KOFU_KAISHU);
        List<HashMap> shoKofuDataList = new ArrayList<>();
        for (HashMap yamlShoKofuData : yamlShoKofuDataList) {
            ControlGenerator generator = new ControlGenerator(yamlShoKofuData);
            if (generator.getAsRString("被保番号").equals(hihokenshaNo)) {
                shoKofuDataList = (List<HashMap>) generator.get("証交付記録");
            }
        }

        List<dgShoKaishuJokyo_Row> shoKofuDataSource = new ArrayList<>();
        for (HashMap shoKofuData : shoKofuDataList) {
            shoKofuDataSource.add(createShoKofuData(new ControlGenerator(shoKofuData)));
        }
        dgShoKofu.setDataSource(shoKofuDataSource);
    }

    private dgShoKaishuJokyo_Row createShoKofuData(ControlGenerator generator) {
        dgShoKaishuJokyo_Row row = new dgShoKaishuJokyo_Row(new Button(), RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY,
                new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate());

        row.setKofushoShurui(generator.getAsRString("証交付種類"));
        row.getKofuDate().setValue(generator.getAsFlexibleDate("交付日"));
        row.setKofuJiyu(generator.getAsRString("交付事由"));
        row.getKaishuDate().setValue(generator.getAsFlexibleDate("回収日"));
        row.setKaishuJiyu(generator.getAsRString("回収事由"));
        row.getYukoKigen().setValue(generator.getAsFlexibleDate("有効期限"));
        return row;
    }

    private static final RString SHINSEI_TODOKEDE = new RString("DBA4010011/shinseiTodokede.yml");

    /**
     * 該当者一覧から、被保険者照会の対象となる個人が選択された際に実行します。<br/>
     * 選択した個人の識別コードを元に、申請届出の情報を表示します。
     *
     * @param todokedeDiv 申請届出Div
     * @param searchDiv 検索Div
     * @return 申請届出Div
     */
    private HihokenshaShokaiShinseiTodokedeDiv setShinseiTodokedeDiv(HihokenshaShokaiShinseiTodokedeDiv todokedeDiv, HihokenshaShokaiTaishoSearchDiv searchDiv) {

        RString shikibetsuCode = searchDiv.getSearchResult().getDgSearchResult().getClickedItem().getShikibetsuCode();
        setTodokedeJoho(todokedeDiv.getDgShinseishoTodokede(), shikibetsuCode);
        return todokedeDiv;
    }

    private void setTodokedeJoho(DataGrid<dgShinseishoTodokede_Row> dgTodokede, RString shikibetsuCode) {

        List<HashMap> yamlTodokedeDataList = YamlLoader.DBA.loadAsList(SHINSEI_TODOKEDE);
        List<HashMap> todokedeDataList = new ArrayList<>();
        for (HashMap yamlTodokedeData : yamlTodokedeDataList) {
            ControlGenerator generator = new ControlGenerator(yamlTodokedeData);
            if (generator.getAsRString("識別コード").equals(shikibetsuCode)) {
                todokedeDataList = (List<HashMap>) generator.get("申請届出");
            }
        }

        List<dgShinseishoTodokede_Row> todokedeDataSource = new ArrayList<>();
        for (HashMap todokedeData : todokedeDataList) {
            todokedeDataSource.add(createTodokedeRow(new ControlGenerator(todokedeData)));
        }
        dgTodokede.setDataSource(todokedeDataSource);
    }

    private dgShinseishoTodokede_Row createTodokedeRow(ControlGenerator generator) {
        dgShinseishoTodokede_Row row = new dgShinseishoTodokede_Row(RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        row.setShinseishoKanriNo(generator.getAsRString("申請書管理番号"));
        row.getTodokedeYMD().setValue(generator.getAsFlexibleDate("届出日"));
        row.setTodokedeShubetsu(generator.getAsRString("届出種別"));
        row.setDaikoKubun(generator.getAsRString("代行区分"));
        row.setKanaShimei(generator.getAsRString("カナ氏名"));
        row.setShimei(generator.getAsRString("氏名"));
        row.setShimeiAndKanaShimei(row.getShimei());
        row.setTsuzukigara(generator.getAsRString("続柄"));
        row.setJigyoshaKubun(generator.getAsRString("事業者区分"));
        row.setJigyoshaNo(generator.getAsRString("代行事業者番号"));
        row.setJigyoshaMeisho(generator.getAsRString("代行事業者名称"));
        row.setJigyosha(row.getJigyoshaNo().concat(":").concat(row.getJigyoshaMeisho()));
        row.setYubinNo(generator.getAsRString("郵便番号"));
        row.setJusho(generator.getAsRString("住所"));
        row.setTelNo(generator.getAsRString("電話番号"));
        return row;
    }

    /**
     * 被保険者の各情報を表示するパネルにデータが入っているかどうかをチェックして、
     * 参照できるデータが無いパネルを見れないよう、遷移ボタンを非活性にします。
     *
     * @param selectDiv 照会情報選択Div
     */
    private void setStateButtonDisabled(HihokenshaShokaiPanelSelectDiv selectDiv) {
        if (isEmptyToDataGrid(selectDiv.getHihokenshaShokaiIryoHoken().getIryoHokenRireki().getDgIryoHokenRireki())) {
            selectDiv.getBtnIryoHoken().setDisabled(true);
        } else {
            selectDiv.getBtnIryoHoken().setDisabled(false);
        }
        if (isEmptyToDataGrid(selectDiv.getHihokenshaShokaiRofukuNenkin().getDgRoreiFukushiRireki())) {
            selectDiv.getBtnRofukuNenkin().setDisabled(true);
        } else {
            selectDiv.getBtnRofukuNenkin().setDisabled(false);
        }
        if (isEmptyToDataGrid(selectDiv.getHihokenshaShokaiSeikatsuHogo().getDgSeikatsuHogoRireki())) {
            selectDiv.getBtnSeikatsuHogo().setDisabled(true);
        } else {
            selectDiv.getBtnSeikatsuHogo().setDisabled(false);
        }
        if (isEmptyToDataGrid(selectDiv.getHihokenshaShokaiSetaiShokai().getDgSetaiJoho())) {
            selectDiv.getBtnSetaiShokai().setDisabled(true);
        } else {
            selectDiv.getBtnSetaiShokai().setDisabled(false);
        }
        if (isEmptyToDataGrid(selectDiv.getHihokenshaShokaiShikakuTokuso().getShikakuTokusoRireki().getDgShikakuShutokuRireki())) {
            selectDiv.getBtnShikakuTokuso().setDisabled(true);
        } else {
            selectDiv.getBtnShikakuTokuso().setDisabled(false);
        }
        if (isEmptyToDataGrid(selectDiv.getHihokenshaShokaiShinseiTodokede().getDgShinseishoTodokede())) {
            selectDiv.getBtnShinseiTodokede().setDisabled(true);
        } else {
            selectDiv.getBtnShinseiTodokede().setDisabled(false);
        }
        if (isEmptyToDataGrid(selectDiv.getHihokenshaShokaiShisetsuNyutaisho().getShisetsuNyutaishoRireki().getDgShisetsuNyutaishoRireki())) {
            selectDiv.getBtnShisetsuNyutaisho().setDisabled(true);
        } else {
            selectDiv.getBtnShisetsuNyutaisho().setDisabled(false);
        }
        if (isEmptyToDataGrid(selectDiv.getHihokenshaShokaiShoKofuKaishu().getShoKofuKaishuKiroku().getShoKaishuJokyoList().getDgShoKaishuJokyo())) {
            selectDiv.getBtnShoKofu().setDisabled(true);
        } else {
            selectDiv.getBtnShoKofu().setDisabled(false);
        }
    }

    private boolean isEmptyToDataGrid(DataGrid<? extends DataRow> grid) {
        return grid.getDataSource().isEmpty();
    }
}
