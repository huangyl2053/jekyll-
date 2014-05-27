/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuKozaInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuKozaInfoKozaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuKozaInfoMadoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShinseiInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShinseishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還支給申請登録の支給申請書情報のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class ShokanShikyuTorokuShinseisho {

    /**
     * 申請書一覧で行を選択した時の支給申請書情報パネルの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShinseishoDiv> onSelectedShinseishoList(ShokanShikyuTorokuShinseishoDiv panel) {
        setTopData(panel);
        setShinseishoData(panel);

        eraseAnotherKozaJoho(panel, 口座情報.窓口払);
        setKozaJohooEnable(panel, 口座情報.窓口払);
        setKozaJohooData(panel, 口座情報.窓口払);

        setShomeishoData(panel);

        ResponseData<ShokanShikyuTorokuShinseishoDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    private enum 口座情報 {

        窓口払,
        口座払
    }

    /**
     * 支給申請書情報の口座情報で窓口払を選択したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShinseishoDiv> onClickMado(ShokanShikyuTorokuShinseishoDiv panel) {
        eraseAnotherKozaJoho(panel, 口座情報.窓口払);
        setKozaJohooEnable(panel, 口座情報.窓口払);
        setKozaJohooData(panel, 口座情報.窓口払);
        ResponseData<ShokanShikyuTorokuShinseishoDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    /**
     * 支給申請書情報の口座情報で口座払を選択したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShinseishoDiv> onClickKoza(ShokanShikyuTorokuShinseishoDiv panel) {
        eraseAnotherKozaJoho(panel, 口座情報.口座払);
        setKozaJohooEnable(panel, 口座情報.口座払);
        setKozaJohooData(panel, 口座情報.口座払);
        ResponseData<ShokanShikyuTorokuShinseishoDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    private void setTopData(ShokanShikyuTorokuShinseishoDiv panel) {
        List<HashMap> sourceList = YamlLoader.FOR_DBC.loadAsList(new RString("ShokanShikyuTorokuShinseisho.yml"));
        panel.getTxtShinseiTeikyoYM().setValue(new RDate(sourceList.get(0).get("提供年月").toString()));
        panel.getTxtShinseiSeiriNo().setValue(new RString(sourceList.get(0).get("整理番号").toString()));
        panel.getTxtShinseiInputKubun().setValue(new RString(sourceList.get(0).get("入力区分").toString()));
    }

    private void setShinseishoData(ShokanShikyuTorokuShinseishoDiv panel) {
        ShokanShikyuTorokuShinseiInfoDiv infoDiv = panel.getTabShokanShikyuTorokuShinseisho().getShokanShikyuTorokuShinseiInfo();
        HashMap source = YamlLoader.FOR_DBC.loadAsList(new RString("ShokanShikyuTorokuShinseisho.yml")).get(1);
        infoDiv.getTxtShinseiShinseiYMD().setValue(new RDate(source.get("申請日").toString()));
        infoDiv.getTxtShinseiUketsukeYMD().setValue(new RDate(source.get("受付日").toString()));
        infoDiv.getRadShinseiShinseiKubun().setSelectedItem(new RString(source.get("申請書区分").toString()));
        infoDiv.getTxtShinseiShokisaiNo().setValue(new RString(source.get("証記載保険者番号").toString()));
        infoDiv.getTxtShinseiName().setValue(new RString(source.get("氏名").toString()));
        infoDiv.getTxtShinseiKana().setValue(new RString(source.get("カナ").toString()));
        infoDiv.getTxtShinseiTelNo().setValue(new RString(source.get("電話番号").toString()));
        infoDiv.getTxtShinseiRiyu().setValue(new RString(source.get("申請理由").toString()));
        infoDiv.getTxtShinseiShiharaiGokei().setValue(new Decimal(source.get("支払金額合計").toString()));
        infoDiv.getTxtShinseiHokenGokei().setValue(new Decimal(source.get("保険請求額合計").toString()));
        infoDiv.getTxtShinseiJikoGokei().setValue(new Decimal(source.get("自己負担額合計").toString()));
    }

    /**
     * 支給申請書情報の口座情報で窓口払・口座払を選択したとき、選択していない支払の情報を初期化する処理です。
     *
     * @param panel
     * @param kozaJoho
     */
    private void eraseAnotherKozaJoho(ShokanShikyuTorokuShinseishoDiv panel, 口座情報 kozaJoho) {
        ShokanShikyuTorokuKozaInfoDiv infoDiv = panel.getTabShokanShikyuTorokuShinseisho().getShokanShikyuTorokuKozaInfo();
        ShokanShikyuTorokuKozaInfoMadoDiv mado = infoDiv.getShokanShikyuTorokuKozaInfoMado();
        ShokanShikyuTorokuKozaInfoKozaDiv koza = infoDiv.getShokanShikyuTorokuKozaInfoKoza();
        if (kozaJoho.equals(口座情報.窓口払)) {
            koza.getTxtShinseiKinyuKikanCode().clearValue();
            koza.getTxtShinseiShitenCode().clearValue();
            koza.getTxtShinseiKozaShubetsu().clearValue();
            koza.getTxtShinseiKozaNo().clearValue();
            koza.getTxtShinseiKinyuKikanName().clearValue();
            koza.getTxtShinseiMeigininName().clearValue();
            koza.getTxtShinseiMeigininKana().clearValue();
        } else {
            mado.getTxtShinseiShiharaiBasho().clearValue();
            mado.getTxtShinseiKaishiYMD().clearValue();
            mado.getTxtShinseiKaishiH().clearValue();
            mado.getTxtShinseiKaishiM().clearValue();
            mado.getTxtShinseiShuryoYMD().clearValue();
            mado.getTxtShinseiShuryoH().clearValue();
            mado.getTxtShinseiShuryoM().clearValue();
        }
    }

    private void setKozaJohooEnable(ShokanShikyuTorokuShinseishoDiv panel, 口座情報 kozaJoho) {
        ShokanShikyuTorokuKozaInfoDiv infoDiv = panel.getTabShokanShikyuTorokuShinseisho().getShokanShikyuTorokuKozaInfo();
        ShokanShikyuTorokuKozaInfoMadoDiv mado = infoDiv.getShokanShikyuTorokuKozaInfoMado();
        ShokanShikyuTorokuKozaInfoKozaDiv koza = infoDiv.getShokanShikyuTorokuKozaInfoKoza();
        if (kozaJoho.equals(口座情報.窓口払)) {
            mado.getRadShinseiMadoBarai().setSelectedItem(new RString("key0"));
            koza.getRadShinseiKozaBarai().setSelectedItem(RString.EMPTY);
            mado.getTxtShinseiShiharaiBasho().setDisabled(false);
            mado.getTxtShinseiKaishiYMD().setDisabled(false);
            mado.getTxtShinseiKaishiH().setDisabled(false);
            mado.getTxtShinseiKaishiM().setDisabled(false);
            mado.getTxtShinseiShuryoYMD().setDisabled(false);
            mado.getTxtShinseiShuryoH().setDisabled(false);
            mado.getTxtShinseiShuryoM().setDisabled(false);
            koza.getDdlShinseiRirekiNo().setDisabled(true);
        } else {
            mado.getRadShinseiMadoBarai().setSelectedItem(RString.EMPTY);
            koza.getRadShinseiKozaBarai().setSelectedItem(new RString("key0"));
            mado.getTxtShinseiShiharaiBasho().setDisabled(true);
            mado.getTxtShinseiKaishiYMD().setDisabled(true);
            mado.getTxtShinseiKaishiH().setDisabled(true);
            mado.getTxtShinseiKaishiM().setDisabled(true);
            mado.getTxtShinseiShuryoYMD().setDisabled(true);
            mado.getTxtShinseiShuryoH().setDisabled(true);
            mado.getTxtShinseiShuryoM().setDisabled(true);
            koza.getDdlShinseiRirekiNo().setDisabled(false);
        }
    }

    private void setKozaJohooData(ShokanShikyuTorokuShinseishoDiv panel, 口座情報 kozaJoho) {
        ShokanShikyuTorokuKozaInfoDiv infoDiv = panel.getTabShokanShikyuTorokuShinseisho().getShokanShikyuTorokuKozaInfo();
        ShokanShikyuTorokuKozaInfoMadoDiv mado = infoDiv.getShokanShikyuTorokuKozaInfoMado();
        ShokanShikyuTorokuKozaInfoKozaDiv koza = infoDiv.getShokanShikyuTorokuKozaInfoKoza();

        if (kozaJoho.equals(口座情報.窓口払)) {
            HashMap source = YamlLoader.FOR_DBC.loadAsList(new RString("ShokanShikyuTorokuShinseisho.yml")).get(2);
            mado.getTxtShinseiShiharaiBasho().setValue(new RString(source.get("支払場所").toString()));
            mado.getTxtShinseiKaishiYMD().setValue(new RDate(source.get("開始日").toString()));
            mado.getTxtShinseiKaishiH().setValue(new Decimal(source.get("開始時").toString()));
            mado.getTxtShinseiKaishiM().setValue(new Decimal(source.get("開始分").toString()));
            mado.getTxtShinseiShuryoYMD().setValue(new RDate(source.get("終了日").toString()));
            mado.getTxtShinseiShuryoH().setValue(new Decimal(source.get("終了時").toString()));
            mado.getTxtShinseiShuryoM().setValue(new Decimal(source.get("終了分").toString()));
        } else {
            HashMap source = YamlLoader.FOR_DBC.loadAsList(new RString("ShokanShikyuTorokuShinseisho.yml")).get(3);
            koza.getTxtShinseiKinyuKikanCode().setValue(new RString(source.get("金融機関コード").toString()));
            koza.getTxtShinseiShitenCode().setValue(new RString(source.get("支店コード").toString()));
            koza.getTxtShinseiKozaShubetsu().setValue(new RString(source.get("口座種別").toString()));
            koza.getTxtShinseiKozaNo().setValue(new Decimal(source.get("口座番号").toString()));
            koza.getTxtShinseiKinyuKikanName().setValue(new RString(source.get("金融機関名").toString()));
            koza.getTxtShinseiMeigininName().setValue(new RString(source.get("名義人").toString()));
            koza.getTxtShinseiMeigininKana().setValue(new RString(source.get("カナ").toString()));
        }
    }

    private void setShomeishoData(ShokanShikyuTorokuShinseishoDiv panel) {
        ShokanShikyuTorokuShomeishoInfoDiv infoDiv = panel.getTabShokanShikyuTorokuShinseisho().getShokanShikyuTorokuShomeishoInfo();
        HashMap source = YamlLoader.FOR_DBC.loadAsList(new RString("ShokanShikyuTorokuShinseisho.yml")).get(4);

        infoDiv.getTxtShinseiTeikyoshoShinseiYMD().setValue(new RDate(source.get("申請日").toString()));
        infoDiv.getTxtShinseiJigyoshaCode().setValue(new RString(source.get("事業者コード").toString()));
        infoDiv.getTxtShinseiJigyoshaName().setValue(new RString(source.get("事業者名").toString()));
    }
}
