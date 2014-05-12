/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.SokujiFukaKouseiMainDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgSokujiKouseiKiwariGaku_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 *
 * @author N2006
 */
public class SokujiFukaKouseiMain {
    /**
     * 画面が読み込まれた際の初期値をセットします。
     *
     * @param panel 即時賦課更正Div
     * @return 即時賦課更正Div
     */
  
    public ResponseData<SokujiFukaKouseiMainDiv> getOnLoadData(SokujiFukaKouseiMainDiv panel) {
        ResponseData<SokujiFukaKouseiMainDiv> response = new ResponseData<>();
        
        panel.getSokujiKouseiJumin().getSokujiKouseiJuminJoho().getTxtNushiShikibetsuCode().setValue(new RString("19"));
        
        setDefaultParam(panel);
        
        
        response.data = panel;
        return response;
    }
    
    /*
     初期値をセットします。
     */
    private void setDefaultParam(SokujiFukaKouseiMainDiv panel) {
        setKiwariGaku(panel);
        setSanteinoKiso(panel);
        setChoteiJiyu(panel);
    }
    /*
     期割額をセットします。
     */
    private void setKiwariGaku(SokujiFukaKouseiMainDiv panel) {        
        
        List<dgSokujiKouseiKiwariGaku_Row> arrayData = new ArrayList<>();
        dgSokujiKouseiKiwariGaku_Row item;
        item = createRowKiwariGaku("4月","1期", "10,300", "10,300", "0","","","","","");
        arrayData.add(item);
        item = createRowKiwariGaku("5月","", "", "", "","","","","","");
        arrayData.add(item);
        item = createRowKiwariGaku("6月","2期", "10,300", "10,300", "0","1期","0","0","0","平成26年6月30日");
        arrayData.add(item);
        DataGrid<dgSokujiKouseiKiwariGaku_Row> grid = panel.getTabSokujiKousei().getSokujiKoseiTab1().getSokujikouseiKiwarigaku().getDgSokujiKouseiKiwariGaku();
        grid.setDataSource(arrayData);       
    }        
    
    /*
     期割額のグリッドをセットします。
     */
    private dgSokujiKouseiKiwariGaku_Row createRowKiwariGaku(String 月 ,String 特徴期, String 特徴更正前, String 特徴更正後, String 特徴増減 ,String 普徴期, String 普徴更正前, String 普徴更正後, String 普徴増減 ,String 納期限) {

        dgSokujiKouseiKiwariGaku_Row rowKiwariGaku = new dgSokujiKouseiKiwariGaku_Row( RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxNum(), RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxNum(), RString.EMPTY,  RString.EMPTY );
        rowKiwariGaku.setTxtTsuki(new RString(月));
        rowKiwariGaku.setTxtTokuchoKi(new RString(特徴期));
        rowKiwariGaku.setTxtTokuchoMae(new RString(特徴更正前));
        rowKiwariGaku.getTxtTokuchoAto().setValue(Decimal(特徴更正後));
        rowKiwariGaku.setTxtTsuki(new RString(特徴増減));
        
        rowKiwariGaku.setTxtFuchoKi(new RString(普徴期));
        rowKiwariGaku.setTxtFuchoMae(new RString(普徴更正前));
        rowKiwariGaku.getTxtFuchoAto().setValue(Decimal(普徴更正後));
        rowKiwariGaku.setTxtFuchoZougen(new RString(普徴増減));
        rowKiwariGaku.setTxtNokugen(new RString(納期限));
        
        return rowKiwariGaku;
    }    
    
    /*
     算定の基礎の値セットします。
     */
    private void setSanteinoKiso(SokujiFukaKouseiMainDiv panel) {        
        panel.getTabSokujiKousei().getSokujiKoseiTab2().getSokujikouseiSanteinoKiso().getTblSanteinokisoMae().getLblKikanMae1().setText(new RString("平26.04～平27.03"));
        panel.getTabSokujiKousei().getSokujiKoseiTab2().getSokujikouseiSanteinoKiso().getTblSanteinokisoMae().getLblTsukisuMae1().setText(new RString("12"));
        panel.getTabSokujiKousei().getSokujiKoseiTab2().getSokujikouseiSanteinoKiso().getTblSanteinokisoMae().getLblHokenryoDankaiMae1().setText(new RString("第5段階"));
        panel.getTabSokujiKousei().getSokujiKoseiTab2().getSokujikouseiSanteinoKiso().getTblSanteinokisoMae().getLblHokenryoritsuMae1().setText(new RString("62,300"));
        panel.getTabSokujiKousei().getSokujiKoseiTab2().getSokujikouseiSanteinoKiso().getTblSanteinokisoMae().getLblHokenryoSanshutsuGakuMae1().setText(new RString("62,300"));
        panel.getTabSokujiKousei().getSokujiKoseiTab2().getSokujikouseiSanteinoKiso().getTblSanteinokisoMae().getLblHokenryoGakuMae1().setText(new RString("62,300"));

        panel.getTabSokujiKousei().getSokujiKoseiTab2().getSokujikouseiSanteinoKiso().getTblSanteinokisoAto().getLblKikanAto1().setText(new RString("平26.04～平27.03"));
        panel.getTabSokujiKousei().getSokujiKoseiTab2().getSokujikouseiSanteinoKiso().getTblSanteinokisoAto().getLblTsukisuAto1().setText(new RString("12"));
        panel.getTabSokujiKousei().getSokujiKoseiTab2().getSokujikouseiSanteinoKiso().getTblSanteinokisoAto().getLblHokenryoDankaiAto1().setText(new RString("第6段階"));
        panel.getTabSokujiKousei().getSokujiKoseiTab2().getSokujikouseiSanteinoKiso().getTblSanteinokisoAto().getLblHokenryoritsuAto1().setText(new RString("77,800"));
        panel.getTabSokujiKousei().getSokujiKoseiTab2().getSokujikouseiSanteinoKiso().getTblSanteinokisoAto().getLblHokenryoSanshutsuGakuAto1().setText(new RString("77,800"));
        panel.getTabSokujiKousei().getSokujiKoseiTab2().getSokujikouseiSanteinoKiso().getTblSanteinokisoAto().getLblHokenryoGakuAto1().setText(new RString("77,800"));
    
    }  
    /*
     調定事由の値をセットします。
     */
    private void setChoteiJiyu(SokujiFukaKouseiMainDiv panel) {        
        panel.getTabSokujiKousei().getSokujiKoseiTab2().getSokujikouseiJiyu().getTxtChoteiJiyu1().setValue(new RString("所得の更正による保険料額更正"));       
       
    }    
    
    
    private Decimal Decimal(String 金額) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
