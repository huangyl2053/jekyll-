///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020001.IdoTaishoshaIchiranDiv;
//import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020001.dgIdoTaishoshaIchiran_Row;
//import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
//import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
//import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
//import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
//
///**
// *
// * @author n8211
// */
//public class IdoTaishoshaIchiran {
//
//    private static final List<HashMap> IDO_TAISHO_SHADATA = YamlLoader.DBB.loadAsList(new RString("DBB0020001/IdoTaishosha.yml"));
//
//    public ResponseData<IdoTaishoshaIchiranDiv> getOnLoadData(IdoTaishoshaIchiranDiv idoTaishoshaIchiranPanelDiv) {
//        ResponseData<IdoTaishoshaIchiranDiv> response = new ResponseData<>();
//
//        setParam(idoTaishoshaIchiranPanelDiv);
//
//        response.data = idoTaishoshaIchiranPanelDiv;
//        return response;
//    }
//
//    private void setParam(IdoTaishoshaIchiranDiv idoTaishoshaIchiranPanelDiv) {
//
//        RString 最終計算処理日時 = (RString) IDO_TAISHO_SHADATA.get(0).get("最終計算処理日時");
//
//        if (最終計算処理日時 != null) {
//            idoTaishoshaIchiranPanelDiv.getTxtLastKeisanYMD().setValue(最終計算処理日時);
//        }
//
//        idoTaishoshaIchiranPanelDiv.getDdlSakuseiYMD().getDataSource().clear();
//        KeyValueDataSource keyValueDataSource = new KeyValueDataSource();
//        keyValueDataSource.setKey(new RString("key0"));
//        if (idoTaishoshaIchiranPanelDiv.getDdlTsuchishoMeisho().getSelectedValue().contains("特別徴収開始通知書")) {
//            RString 作成日時 = (RString) IDO_TAISHO_SHADATA.get(0).get("作成日時_特徴");
//
//            keyValueDataSource.setValue(作成日時);
//
//            idoTaishoshaIchiranPanelDiv.getDdlSakuseiYMD().getDataSource().add(keyValueDataSource);
//
//            setTokuchoKaishiTsuchisho(idoTaishoshaIchiranPanelDiv);
//        } else if (idoTaishoshaIchiranPanelDiv.getDdlTsuchishoMeisho().getSelectedValue().contains("納入通知書")) {
//            RString 作成日時 = (RString) IDO_TAISHO_SHADATA.get(0).get("作成日時_納入");
//
//            keyValueDataSource.setValue(作成日時);
//
//            idoTaishoshaIchiranPanelDiv.getDdlSakuseiYMD().getDataSource().add(keyValueDataSource);
//
//            setNonyuTsuchisho(idoTaishoshaIchiranPanelDiv);
//        } else if (idoTaishoshaIchiranPanelDiv.getDdlTsuchishoMeisho().getSelectedValue().contains("決定・変更通知書")) {
//            RString 作成日時 = (RString) IDO_TAISHO_SHADATA.get(0).get("作成日時_決定変更");
//
//            keyValueDataSource.setValue(作成日時);
//
//            idoTaishoshaIchiranPanelDiv.getDdlSakuseiYMD().getDataSource().add(keyValueDataSource);
//
//            setKetteiHenkoTsuchisho(idoTaishoshaIchiranPanelDiv);
//        }
//    }
//
//    private void setTokuchoKaishiTsuchisho(IdoTaishoshaIchiranDiv idoTaishoshaIchiranPanelDiv) {
//
//        List<dgIdoTaishoshaIchiran_Row> arrayData = new ArrayList<>();
//        dgIdoTaishoshaIchiran_Row item;
//
//        for (int i = 1; i <= Integer.parseInt(IDO_TAISHO_SHADATA.get(0).get("データ数").toString()); i++) {
//            if (IDO_TAISHO_SHADATA.get(i).get("通知書種類").equals("特徴開始通知書")) {
//                RString 該当番号 = (RString) IDO_TAISHO_SHADATA.get(i).get("該当番号");
//                RString 被保番号 = (RString) IDO_TAISHO_SHADATA.get(i).get("被保番号");
//                RString 識別コード = (RString) IDO_TAISHO_SHADATA.get(i).get("識別コード");
//                RString 通知書番号 = (RString) IDO_TAISHO_SHADATA.get(i).get("通知書番号");
//                RString 氏名 = (RString) IDO_TAISHO_SHADATA.get(i).get("氏名");
//                RString 異動日 = (RString) IDO_TAISHO_SHADATA.get(i).get("異動日");
//                RString 異動事由 = (RString) IDO_TAISHO_SHADATA.get(i).get("異動事由");
//
//                item = createRowIdotaisho(該当番号, 被保番号, 識別コード, 通知書番号, 氏名, 異動日, 異動事由);
//                arrayData.add(item);
//            }
//        }
//        DataGrid<dgIdoTaishoshaIchiran_Row> grid = idoTaishoshaIchiranPanelDiv.getDgIdoTaishoshaIchiran();
//        grid.setDataSource(arrayData);
//    }
//
//    private void setNonyuTsuchisho(IdoTaishoshaIchiranDiv idoTaishoshaIchiranPanelDiv) {
//
//        List<dgIdoTaishoshaIchiran_Row> arrayData = new ArrayList<>();
//        dgIdoTaishoshaIchiran_Row item;
//
//        for (int i = 1; i <= Integer.parseInt(IDO_TAISHO_SHADATA.get(0).get("データ数").toString()); i++) {
//            if (IDO_TAISHO_SHADATA.get(i).get("通知書種類").equals("納入通知書")) {
//                RString 該当番号 = (RString) IDO_TAISHO_SHADATA.get(i).get("該当番号");
//                RString 被保番号 = (RString) IDO_TAISHO_SHADATA.get(i).get("被保番号");
//                RString 識別コード = (RString) IDO_TAISHO_SHADATA.get(i).get("識別コード");
//                RString 通知書番号 = (RString) IDO_TAISHO_SHADATA.get(i).get("通知書番号");
//                RString 氏名 = (RString) IDO_TAISHO_SHADATA.get(i).get("氏名");
//                RString 異動日 = (RString) IDO_TAISHO_SHADATA.get(i).get("異動日");
//                RString 異動事由 = (RString) IDO_TAISHO_SHADATA.get(i).get("異動事由");
//
//                item = createRowIdotaisho(該当番号, 被保番号, 識別コード, 通知書番号, 氏名, 異動日, 異動事由);
//                arrayData.add(item);
//            }
//        }
//        DataGrid<dgIdoTaishoshaIchiran_Row> grid = idoTaishoshaIchiranPanelDiv.getDgIdoTaishoshaIchiran();
//        grid.setDataSource(arrayData);
//    }
//
//    private void setKetteiHenkoTsuchisho(IdoTaishoshaIchiranDiv idoTaishoshaIchiranPanelDiv) {
//
//        List<dgIdoTaishoshaIchiran_Row> arrayData = new ArrayList<>();
//        dgIdoTaishoshaIchiran_Row item;
//
//        for (int i = 1; i <= Integer.parseInt(IDO_TAISHO_SHADATA.get(0).get("データ数").toString()); i++) {
//            if (IDO_TAISHO_SHADATA.get(i).get("通知書種類").equals("決定・変更通知書")) {
//                RString 該当番号 = (RString) IDO_TAISHO_SHADATA.get(i).get("該当番号");
//                RString 被保番号 = (RString) IDO_TAISHO_SHADATA.get(i).get("被保番号");
//                RString 識別コード = (RString) IDO_TAISHO_SHADATA.get(i).get("識別コード");
//                RString 通知書番号 = (RString) IDO_TAISHO_SHADATA.get(i).get("通知書番号");
//                RString 氏名 = (RString) IDO_TAISHO_SHADATA.get(i).get("氏名");
//                RString 異動日 = (RString) IDO_TAISHO_SHADATA.get(i).get("異動日");
//                RString 異動事由 = (RString) IDO_TAISHO_SHADATA.get(i).get("異動事由");
//
//                item = createRowIdotaisho(該当番号, 被保番号, 識別コード, 通知書番号, 氏名, 異動日, 異動事由);
//                arrayData.add(item);
//            }
//        }
//        DataGrid<dgIdoTaishoshaIchiran_Row> grid = idoTaishoshaIchiranPanelDiv.getDgIdoTaishoshaIchiran();
//        grid.setDataSource(arrayData);
//    }
//
//    private dgIdoTaishoshaIchiran_Row createRowIdotaisho(
//            RString 該当番号, RString 被保番号, RString 識別コード, RString 通知書番号, RString 氏名, RString 異動日, RString 異動事由) {
//        dgIdoTaishoshaIchiran_Row rowIdoTaishoshaData = new dgIdoTaishoshaIchiran_Row(
//                RString.EMPTY, RString.EMPTY, RString.HALF_SPACE, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new DropDownList());
//
//        rowIdoTaishoshaData.setTxtGaitoRenban(該当番号);
//        rowIdoTaishoshaData.setTxtHihoNo(被保番号);
//        rowIdoTaishoshaData.setTxtShikibetsuCode(識別コード);
//        rowIdoTaishoshaData.setTxtTsuchishoNo(通知書番号);
//        rowIdoTaishoshaData.setTxtShimei(氏名);
//        rowIdoTaishoshaData.setTxtIdoYMD(異動日);
//        rowIdoTaishoshaData.setTxtIdoZiyu(異動事由);
//
//        return rowIdoTaishoshaData;
//    }
//}
