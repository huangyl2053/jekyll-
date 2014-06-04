/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.security.KeyException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0020001.IdoTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0020001.dgIdoTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * @author n8211
 */
public class IdoTaishoshaIchiran {
    public ResponseData<IdoTaishoshaIchiranDiv> onLoad(IdoTaishoshaIchiranDiv idoTaishoshaIchiranPanelDiv) {
        ResponseData<IdoTaishoshaIchiranDiv> response = new ResponseData<>();

        setParam(idoTaishoshaIchiranPanelDiv);

        response.data = idoTaishoshaIchiranPanelDiv;
        return response;
    }

    private void setParam(IdoTaishoshaIchiranDiv idoTaishoshaIchiranPanelDiv) {
        List<HashMap> idoTaishoshaData = YamlLoader.FOR_DBB.loadAsList(new RString("DBB0020001/IdoTaishosha.yml"));
        
        String 最終計算処理日時 = (String) idoTaishoshaData.get(0).get("最終計算処理日時");
        
        if (最終計算処理日時 != null) idoTaishoshaIchiranPanelDiv.getTxtLastKeisanYMD().setValue(new RString(最終計算処理日時));
        
        idoTaishoshaIchiranPanelDiv.getDdlSakuseiYMD().getDataSource().clear();
        KeyValueDataSource keyValueDataSource = new KeyValueDataSource();
        keyValueDataSource.setKey(new RString("key0"));
        if (idoTaishoshaIchiranPanelDiv.getDdlTsuchishoMeisho().getSelectedValue().contains("特別徴収開始通知書")) {
            String 作成日時 = (String) idoTaishoshaData.get(0).get("作成日時_特徴");

            keyValueDataSource.setValue(new RString(作成日時));
            
            idoTaishoshaIchiranPanelDiv.getDdlSakuseiYMD().getDataSource().add(keyValueDataSource);
            
            setTokuchoKaishiTsuchisho(idoTaishoshaIchiranPanelDiv);
        } else if (idoTaishoshaIchiranPanelDiv.getDdlTsuchishoMeisho().getSelectedValue().contains("納入通知書")) {
            String 作成日時 = (String) idoTaishoshaData.get(0).get("作成日時_納入");

            keyValueDataSource.setValue(new RString(作成日時));
            
            idoTaishoshaIchiranPanelDiv.getDdlSakuseiYMD().getDataSource().add(keyValueDataSource);
            
            setNonyuTsuchisho(idoTaishoshaIchiranPanelDiv);
        } else if (idoTaishoshaIchiranPanelDiv.getDdlTsuchishoMeisho().getSelectedValue().contains("決定・変更通知書")) {
            String 作成日時 = (String) idoTaishoshaData.get(0).get("作成日時_決定変更");

            keyValueDataSource.setValue(new RString(作成日時));
            
            idoTaishoshaIchiranPanelDiv.getDdlSakuseiYMD().getDataSource().add(keyValueDataSource);
            
            setKetteiHenkoTsuchisho(idoTaishoshaIchiranPanelDiv);
        }
    }

    private void setTokuchoKaishiTsuchisho(IdoTaishoshaIchiranDiv idoTaishoshaIchiranPanelDiv) {

        List<HashMap> idoTaishoshaData = YamlLoader.FOR_DBB.loadAsList(new RString("DBB0020001/IdoTaishosha.yml"));
        
        List<dgIdoTaishoshaIchiran_Row> arrayData = new ArrayList<>();
        dgIdoTaishoshaIchiran_Row item;

        for (int i = 1; i <= Integer.parseInt(idoTaishoshaData.get(0).get("データ数").toString()); i++) {
            if (idoTaishoshaData.get(i).get("通知書種類").equals("特徴開始通知書")) {
                String 該当番号 = (String) idoTaishoshaData.get(i).get("該当番号");
                String 被保番号 = (String) idoTaishoshaData.get(i).get("被保番号");
                String 識別コード = (String) idoTaishoshaData.get(i).get("識別コード");
                String 通知書番号 = (String) idoTaishoshaData.get(i).get("通知書番号");
                String 氏名 = (String) idoTaishoshaData.get(i).get("氏名");
                String 異動日 = (String) idoTaishoshaData.get(i).get("異動日");
                String 異動事由 = (String) idoTaishoshaData.get(i).get("異動事由");
                
                item = createRowIdotaisho(該当番号, 被保番号, 識別コード, 通知書番号, 氏名, 異動日, 異動事由);
                arrayData.add(item);
            }
        }
        DataGrid<dgIdoTaishoshaIchiran_Row> grid = idoTaishoshaIchiranPanelDiv.getDgIdoTaishoshaIchiran();
        grid.setDataSource(arrayData);
    }

    private void setNonyuTsuchisho(IdoTaishoshaIchiranDiv idoTaishoshaIchiranPanelDiv) {

        List<HashMap> idoTaishoshaData = YamlLoader.FOR_DBB.loadAsList(new RString("DBB0020001/IdoTaishosha.yml"));
        
        List<dgIdoTaishoshaIchiran_Row> arrayData = new ArrayList<>();
        dgIdoTaishoshaIchiran_Row item;

        for (int i = 1; i <= Integer.parseInt(idoTaishoshaData.get(0).get("データ数").toString()); i++) {
            if (idoTaishoshaData.get(i).get("通知書種類").equals("納入通知書")) {
                String 該当番号 = (String) idoTaishoshaData.get(i).get("該当番号");
                String 被保番号 = (String) idoTaishoshaData.get(i).get("被保番号");
                String 識別コード = (String) idoTaishoshaData.get(i).get("識別コード");
                String 通知書番号 = (String) idoTaishoshaData.get(i).get("通知書番号");
                String 氏名 = (String) idoTaishoshaData.get(i).get("氏名");
                String 異動日 = (String) idoTaishoshaData.get(i).get("異動日");
                String 異動事由 = (String) idoTaishoshaData.get(i).get("異動事由");
                
                item = createRowIdotaisho(該当番号, 被保番号, 識別コード, 通知書番号, 氏名, 異動日, 異動事由);
                arrayData.add(item);
            }
        }
        DataGrid<dgIdoTaishoshaIchiran_Row> grid = idoTaishoshaIchiranPanelDiv.getDgIdoTaishoshaIchiran();
        grid.setDataSource(arrayData);
    }

    private void setKetteiHenkoTsuchisho(IdoTaishoshaIchiranDiv idoTaishoshaIchiranPanelDiv) {

        List<HashMap> idoTaishoshaData = YamlLoader.FOR_DBB.loadAsList(new RString("DBB0020001/IdoTaishosha.yml"));
        
        List<dgIdoTaishoshaIchiran_Row> arrayData = new ArrayList<>();
        dgIdoTaishoshaIchiran_Row item;

        for (int i = 1; i <= Integer.parseInt(idoTaishoshaData.get(0).get("データ数").toString()); i++) {
            if (idoTaishoshaData.get(i).get("通知書種類").equals("決定・変更通知書")) {
                String 該当番号 = (String) idoTaishoshaData.get(i).get("該当番号");
                String 被保番号 = (String) idoTaishoshaData.get(i).get("被保番号");
                String 識別コード = (String) idoTaishoshaData.get(i).get("識別コード");
                String 通知書番号 = (String) idoTaishoshaData.get(i).get("通知書番号");
                String 氏名 = (String) idoTaishoshaData.get(i).get("氏名");
                String 異動日 = (String) idoTaishoshaData.get(i).get("異動日");
                String 異動事由 = (String) idoTaishoshaData.get(i).get("異動事由");
                
                item = createRowIdotaisho(該当番号, 被保番号, 識別コード, 通知書番号, 氏名, 異動日, 異動事由);
                arrayData.add(item);
            }
        }
        DataGrid<dgIdoTaishoshaIchiran_Row> grid = idoTaishoshaIchiranPanelDiv.getDgIdoTaishoshaIchiran();
        grid.setDataSource(arrayData);
    }

    private dgIdoTaishoshaIchiran_Row createRowIdotaisho(
            String 該当番号, String 被保番号, String 識別コード, String 通知書番号, String 氏名, String 異動日, String 異動事由) {
        dgIdoTaishoshaIchiran_Row rowIdoTaishoshaData = new dgIdoTaishoshaIchiran_Row(
                RString.EMPTY, RString.EMPTY, RString.HALF_SPACE, RString.EMPTY, RString.EMPTY
                , RString.EMPTY, RString.EMPTY, new DropDownList());
                
        rowIdoTaishoshaData.setTxtGaitoRenban(new RString(該当番号));
        rowIdoTaishoshaData.setTxtHihoNo(new RString(被保番号));
        rowIdoTaishoshaData.setTxtShikibetsuCode(new RString(識別コード));
        rowIdoTaishoshaData.setTxtTsuchishoNo(new RString(通知書番号));
        rowIdoTaishoshaData.setTxtShimei(new RString(氏名));
        rowIdoTaishoshaData.setTxtIdoYMD(new RString(異動日));
        rowIdoTaishoshaData.setTxtIdoZiyu(new RString(異動事由));

        return rowIdoTaishoshaData;
    }
}
