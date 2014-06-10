/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBC4200011.ShikyuGendogakuKyotakuServiceDetailPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBC4200011.ShikyuGendogakuKyotakuServiceListPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBC4200011.dgShikyuGendogakuKyotakuService_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author n8223
 */
public class ShikyuGendogakuKyotakuServiceListPanel {

    final static String AddedFlg = "追加";
    final static String ModifiedFlg = "修正";
    final static String DeletedFlg = "削除";
    final static String UnchangedFlg = "変更無し";

    /**
     * 支給限度額登録（居宅サービス費）　支給限度額の入力を確定するボタン押下後、支給限度額一覧の情報を表示する
     *
     * @author n8223
     */
    public ResponseData<ShikyuGendogakuKyotakuServiceListPanelDiv> onClick_btnSettle(ShikyuGendogakuKyotakuServiceListPanelDiv panel) {
        ResponseData<ShikyuGendogakuKyotakuServiceListPanelDiv> response = new ResponseData<>();

        //支給限度額一覧の情報を設定する。
        List<dgShikyuGendogakuKyotakuService_Row> arraydata = setShikyuGendogakuKyotakuServiceList(panel);
        DataGrid<dgShikyuGendogakuKyotakuService_Row> grid = panel.getDgShikyuGendogakuKyotakuService();

        int index = grid.getClickedRowId();
        
        System.out.println("++++ index +++  " + index);
        
        if(index != -1 ) {
             grid.getDataSource().get(index).setRowState(RowState.Added);
            
           //  grid.getDataSource().add(index, arraydata.get(index));
        }  else {
            
             if(grid.getDataSource().isEmpty()) {
                 
                  grid.getDataSource().add(0, arraydata.get(0));
             } else {
                 
                 System.out.println("+++ grid.getDataSource().size() +++" + grid.getDataSource().size());
                 index = grid.getDataSource().size() ;
                 grid.getDataSource().add(index, arraydata.get(0));
             }
            
        }
        
//       
//        grid.setDataSource(arraydata);
//        
//        grid.getDataSource().addAll(arraydata);
        
        //grid.setDataSource(arraydata);

        response.data = panel;
        return response;
    }

    private List<dgShikyuGendogakuKyotakuService_Row> setShikyuGendogakuKyotakuServiceList(ShikyuGendogakuKyotakuServiceListPanelDiv panel) {

        List<dgShikyuGendogakuKyotakuService_Row> arrayData = new ArrayList<>();
        dgShikyuGendogakuKyotakuService_Row item;

        //VIEWGET
        RString gubun = (RString) ViewStateHolder.get("GUBUN", RString.class);
        RString flg = (RString) ViewStateHolder.get("FLG", RString.class);

        //VIEWGET
        RString radIdoKubun = (RString) ViewStateHolder.get("RADIOKUBUN", RString.class);
      //  RString idoJiyu = (RString) ViewStateHolder.get("IDOJIYU", RString.class);

        RString yukoDateRangeFromValue = (RString) ViewStateHolder.get("YUKODATERANGEFROMVALUE", RString.class);
        //RString yukoDateRangeToValue = (RString) ViewStateHolder.get("YUKODATERANGETOVALUE", RString.class);

        //追加 区分支給限
        if (flg.toString().equals(AddedFlg)) {

            item = createRowShikyuGendogakuKyotakuListData(
                    flg.toString(),
                    gubun.toString(),
                    yukoDateRangeFromValue.toString(),
                   // yukoDateRangeToValue.toString(),
                    radIdoKubun.toString()
            );
            arrayData.add(item);
        }
        //修正 区分支給限
        if (flg.toString().equals(ModifiedFlg)) {

            item = createRowShikyuGendogakuKyotakuListData(
                    flg.toString(),
                    gubun.toString(),
                    yukoDateRangeFromValue.toString(),
                  // yukoDateRangeToValue.toString(),
                    radIdoKubun.toString()
            );
            arrayData.add(item);
        }

        //削除
        return arrayData;
    }

    private dgShikyuGendogakuKyotakuService_Row createRowShikyuGendogakuKyotakuListData(
            String 状況,
            String 限度額の分類,
            String 開始年月,
           // String 終了年月,
            String 異動区分
    ) {
        dgShikyuGendogakuKyotakuService_Row rowShikyuGendogakuKyotakuListData;
        rowShikyuGendogakuKyotakuListData = new dgShikyuGendogakuKyotakuService_Row(
                new Button(),
                new Button(),
                RString.EMPTY,
                new TextBoxDate(),
                new TextBoxDate(),
                RString.EMPTY
        );

        rowShikyuGendogakuKyotakuListData.getTxtYukoKaishiDate().setDisabled(true);
        rowShikyuGendogakuKyotakuListData.getTxtYukoShuryoDate().setDisabled(true);
        rowShikyuGendogakuKyotakuListData.setTxtKubunOrShurui(new RString(限度額の分類));
        rowShikyuGendogakuKyotakuListData.getTxtYukoKaishiDate().setValue(new RDate(開始年月));
        //rowShikyuGendogakuKyotakuListData.getTxtYukoShuryoDate().setValue(new RDate(終了年月));
        rowShikyuGendogakuKyotakuListData.setTxtIdoKubun(new RString(異動区分));

        switch (状況) {
            case AddedFlg:
                rowShikyuGendogakuKyotakuListData.setRowState(RowState.Added);
                break;
            case ModifiedFlg:
                 rowShikyuGendogakuKyotakuListData.setRowState(RowState.Added);
                //wShikyuGendogakuKyotakuListData.setRowState(RowState.Modified);
                break;
            case DeletedFlg:
                rowShikyuGendogakuKyotakuListData.setRowState(RowState.Deleted);
                break;
            case UnchangedFlg:
                rowShikyuGendogakuKyotakuListData.setRowState(RowState.Unchanged);
                break;
        }

        return rowShikyuGendogakuKyotakuListData;
    }



}
