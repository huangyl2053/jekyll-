/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.TokuchoIdoJohoSakuseiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * @author n3412
 */
public class TokuchoIdoJohoSakusei {

    private static final RString TOKUCHO_IDO_JOHO_SAKUSEI = new RString("TokuchoIdoJohoSakusei.yml");
    private static List< List<KeyValueDataSource>> checked = new ArrayList<>();//CheckBoxListのチェック状態を保存

    public ResponseData<TokuchoIdoJohoSakuseiDiv> onLoad_TokuchoIdoJohoSakusei(TokuchoIdoJohoSakuseiDiv panel) {
        ResponseData<TokuchoIdoJohoSakuseiDiv> response = new ResponseData<>();
        List<HashMap> demoDataList = YamlLoader.DBB.loadAsList(TOKUCHO_IDO_JOHO_SAKUSEI);

        //4月
        ControlGenerator cg04 = new ControlGenerator(demoDataList.get(0));
        panel.getTbldgTokuchoIdoJoho().getChkSentaku04().setDisabled(true);
        panel.getTbldgTokuchoIdoJoho().getLblShoriNichiji04().setText(cg04.getAsRString("処理日時"));
//        panel.getTbldgTokuchoIdoJoho().getLblTokuchotsuikaIrai04().setText(cg04.getAsRString("特徴追加依頼"));

        //5月
        ControlGenerator cg05 = new ControlGenerator(demoDataList.get(1));
        panel.getTbldgTokuchoIdoJoho().getChkSentaku05().setDisabled(true);
        panel.getTbldgTokuchoIdoJoho().getLblShoriNichiji05().setText(cg05.getAsRString("処理日時"));

        //6月
        ControlGenerator cg06 = new ControlGenerator(demoDataList.get(2));
        panel.getTbldgTokuchoIdoJoho().getChkSentaku06().setDisabled(true);
        panel.getTbldgTokuchoIdoJoho().getLblShoriNichiji06().setText(cg06.getAsRString("処理日時"));
//        panel.getTbldgTokuchoIdoJoho().getLblTokuchotsuikaIrai06().setText(cg06.getAsRString("特徴追加依頼"));

        //7月
        ControlGenerator cg07 = new ControlGenerator(demoDataList.get(3));
        panel.getTbldgTokuchoIdoJoho().getChkSentaku07().setDisabled(false);
        panel.getTbldgTokuchoIdoJoho().getLblShoriNichiji07().setText(cg07.getAsRString("処理日時"));
        //8月
        ControlGenerator cg08 = new ControlGenerator(demoDataList.get(4));
        panel.getTbldgTokuchoIdoJoho().getChkSentaku08().setDisabled(false);
        panel.getTbldgTokuchoIdoJoho().getLblShoriNichiji08().setText(cg08.getAsRString("処理日時"));
//        panel.getTbldgTokuchoIdoJoho().getLblTokuchotsuikaIrai08().setText(cg08.getAsRString("特徴追加依頼"));
        checked.add(panel.getTbldgTokuchoIdoJoho().getChkSentaku08().getSelectedItems());//チェック状態を保存
        //9月
        ControlGenerator cg09 = new ControlGenerator(demoDataList.get(5));
        panel.getTbldgTokuchoIdoJoho().getChkSentaku09().setDisabled(true);
        panel.getTbldgTokuchoIdoJoho().getLblShoriNichiji09().setText(cg09.getAsRString("処理日時"));
        //10月
        ControlGenerator cg10 = new ControlGenerator(demoDataList.get(6));
        panel.getTbldgTokuchoIdoJoho().getChkSentaku10().setDisabled(true);
        panel.getTbldgTokuchoIdoJoho().getLblShoriNichiji10().setText(cg10.getAsRString("処理日時"));
//        panel.getTbldgTokuchoIdoJoho().getLblTokuchotsuikaIrai10().setText(cg10.getAsRString("特徴追加依頼"));
        //11月
        ControlGenerator cg11 = new ControlGenerator(demoDataList.get(7));
        panel.getTbldgTokuchoIdoJoho().getChkSentaku11().setDisabled(true);
        panel.getTbldgTokuchoIdoJoho().getLblShoriNichiji11().setText(cg11.getAsRString("処理日時"));
        //12月
        ControlGenerator cg12 = new ControlGenerator(demoDataList.get(8));
        panel.getTbldgTokuchoIdoJoho().getChkSentaku12().setDisabled(true);
        panel.getTbldgTokuchoIdoJoho().getLblShoriNichiji12().setText(cg12.getAsRString("処理日時"));
//        panel.getTbldgTokuchoIdoJoho().getLblTokuchotsuikaIrai12().setText(cg12.getAsRString("特徴追加依頼"));
        //1月
        ControlGenerator cg01 = new ControlGenerator(demoDataList.get(9));
        panel.getTbldgTokuchoIdoJoho().getChkSentaku01().setDisabled(true);
        panel.getTbldgTokuchoIdoJoho().getLblShoriNichiji01().setText(cg01.getAsRString("処理日時"));

        //2月
        ControlGenerator cg02 = new ControlGenerator(demoDataList.get(10));
        panel.getTbldgTokuchoIdoJoho().getChkSentaku02().setDisabled(true);
        panel.getTbldgTokuchoIdoJoho().getLblShoriNichiji02().setText(cg02.getAsRString("処理日時"));
//        panel.getTbldgTokuchoIdoJoho().getLblTokuchotsuikaIrai02().setText(cg02.getAsRString("特徴追加依頼"));

        //3月
        ControlGenerator cg03 = new ControlGenerator(demoDataList.get(11));
        panel.getTbldgTokuchoIdoJoho().getChkSentaku03().setDisabled(true);
        panel.getTbldgTokuchoIdoJoho().getLblShoriNichiji03().setText(cg03.getAsRString("処理日時"));

        //再作成パネルの初期状態
        panel.getTokuchoIdoJohoSaiSakusei().setVisible(false);

        response.data = panel;
        return response;
    }

    public ResponseData<TokuchoIdoJohoSakuseiDiv> onClick_chkSentaku07(TokuchoIdoJohoSakuseiDiv panel) {
        ResponseData<TokuchoIdoJohoSakuseiDiv> response = new ResponseData<>();

        if (isChecked(panel.getTbldgTokuchoIdoJoho().getChkSentaku07())) {
            panel.getTokuchoIdoJohoSaiSakusei().setVisible(true);//再作成表示ON
            panel.getTbldgTokuchoIdoJoho().getChkSentaku08().setSelectedItems(Collections.EMPTY_LIST);
        } else {
            panel.getTokuchoIdoJohoSaiSakusei().setVisible(false);//再作成表示OFF
            panel.getTbldgTokuchoIdoJoho().getChkSentaku08().setSelectedItems(checked.get(0));
        }

        response.data = panel;
        return response;
    }

    public ResponseData<TokuchoIdoJohoSakuseiDiv> onClick_chkSentaku08(TokuchoIdoJohoSakuseiDiv panel) {
        ResponseData<TokuchoIdoJohoSakuseiDiv> response = new ResponseData<>();

        if (isChecked(panel.getTbldgTokuchoIdoJoho().getChkSentaku08())) {
            panel.getTokuchoIdoJohoSaiSakusei().setVisible(false);//再作成表示OFF
            panel.getTbldgTokuchoIdoJoho().getChkSentaku07().setSelectedItems(Collections.EMPTY_LIST);
        } else {
            panel.getTokuchoIdoJohoSaiSakusei().setVisible(true);//再作成表示ON
            panel.getTbldgTokuchoIdoJoho().getChkSentaku07().setSelectedItems(checked.get(0));
        }

        response.data = panel;
        return response;
    }

    private boolean isChecked(CheckBoxList chk) {
        return (!chk.getSelectedItems().isEmpty());
    }

}
