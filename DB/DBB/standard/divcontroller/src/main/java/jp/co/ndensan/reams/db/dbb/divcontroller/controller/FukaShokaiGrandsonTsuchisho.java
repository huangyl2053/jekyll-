/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8110001.FukaShokaiGrandsonTsuchishoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8110001.JuminFukaShokaiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.KobetsuHakkoChoteiJiyuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.tblKobetsuHakkoFukakonkyoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.tblKobetsuHakkoKiwariGakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3412
 */
public class FukaShokaiGrandsonTsuchisho {
    private static final RString KOBETSU_HAKKO_FUKAKONKYO = new RString("tblKobetsuHakkoFukakonkyo.yml");
    private static final RString KOBETSU_HAKKO_KIWARIGAKU = new RString("tblKobetsuHakkoKiwariGaku.yml");
    private static final RString CHOTEI_JIYU = new RString("ChoteiJiyu.yml");
    private static final List< List<RString> > konkyo = new ArrayList<>();
    private static final List< List<RString> > kiwarigaku = new ArrayList<>();
    private static final List< List<RString> > jiyu = new ArrayList<>();
    
    public ResponseData<FukaShokaiGrandsonTsuchishoDiv> onLoad_FukaShokaiGrandsonTsuchisho(FukaShokaiGrandsonTsuchishoDiv panel, JuminFukaShokaiDiv div) {
        ResponseData<FukaShokaiGrandsonTsuchishoDiv> response = new ResponseData<>();
        jiyu.clear();
        konkyo.clear();
        kiwarigaku.clear();
        
        //staticメンバにYamlデータ登録
        set_jiyu();
        set_konkyo();
        set_kiwarigaku();
        
        panel.getTxtChoteiNendo().setValue(new RString("平26"));
        panel.getTxtFukaNendo().setValue(new RString("平26"));
        panel.getTxtKoseiYMD().setValue(konkyo.get(0).get(11));
        panel.getTxtKoseiM().setValue(konkyo.get(0).get(12));

        
        set_radKobetsuHakkoChoteiJiyu(panel.getInjiNaiyoSettei().getKobetsuHakkoChoteiJiyu());
        setAto_TblKobetsuHakkoFukakonkyo(panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo(), 0);
        setMae_TblKobetsuHakkoFukakonkyo(panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo(), 1);
        setAto_TblKobetsuHakkoKiwariGaku(panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku(), 0);
        setMae_TblKobetsuHakkoKiwariGaku(panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku(), 1);
        
        
        response.data = panel;
        return response;
    }
 
    public void set_radKobetsuHakkoChoteiJiyu(KobetsuHakkoChoteiJiyuDiv div) {       
        div.getTxtChoteiJiyu1().setValue(jiyu.get(0).get(0));
        div.getTxtChoteiJiyu2().setValue(jiyu.get(0).get(1));
        
    }      
    
    public ResponseData<FukaShokaiGrandsonTsuchishoDiv> onChange_radKobetsuHakkoChoteiJiyu(FukaShokaiGrandsonTsuchishoDiv panel, JuminFukaShokaiDiv div) {
        ResponseData<FukaShokaiGrandsonTsuchishoDiv> response = new ResponseData<>();
        
        if( panel.getInjiNaiyoSettei().getKobetsuHakkoChoteiJiyu().getRadKobetsuHakkoChoteiJiyu().getSelectedItem().contains("0") ){
            panel.getInjiNaiyoSettei().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu1().setDisabled(true);
            panel.getInjiNaiyoSettei().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu2().setDisabled(true);
            panel.getInjiNaiyoSettei().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu3().setDisabled(true);
            panel.getInjiNaiyoSettei().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu4().setDisabled(true);
            //内容を初期状態に戻す
            set_radKobetsuHakkoChoteiJiyu(panel.getInjiNaiyoSettei().getKobetsuHakkoChoteiJiyu());
        }else{
            panel.getInjiNaiyoSettei().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu1().setDisabled(false);
            panel.getInjiNaiyoSettei().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu2().setDisabled(false);
            panel.getInjiNaiyoSettei().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu3().setDisabled(false);
            panel.getInjiNaiyoSettei().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu4().setDisabled(false);            
        }
        
        response.data = panel;
        return response;
    }  
    
    public ResponseData<FukaShokaiGrandsonTsuchishoDiv> onChange_ddlInjiKouseiAto(FukaShokaiGrandsonTsuchishoDiv panel, JuminFukaShokaiDiv div) {
        ResponseData<FukaShokaiGrandsonTsuchishoDiv> response = new ResponseData<>();
        
        RString key = panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiAto().getSelectedItem();
        if( key.contains("0") ){
            setAto_TblKobetsuHakkoFukakonkyo(panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo(), 0);
            setMae_TblKobetsuHakkoFukakonkyo(panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo(), 1);
            setAto_TblKobetsuHakkoKiwariGaku (panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku(), 0);
            setMae_TblKobetsuHakkoKiwariGaku (panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku(), 1);
            panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiMae().setSelectedItem(new RString("key0"));
        }else if( key.contains("1") ){
            setAto_TblKobetsuHakkoFukakonkyo(panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo(), 1);
            setMae_TblKobetsuHakkoFukakonkyo(panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo(), 2);
            setAto_TblKobetsuHakkoKiwariGaku (panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku(), 1);
            setMae_TblKobetsuHakkoKiwariGaku (panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku(), 2);
            panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiMae().setSelectedItem(new RString("key1"));
        }else{
            setAto_TblKobetsuHakkoFukakonkyo(panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo(), 2);
            setMae_TblKobetsuHakkoFukakonkyo(panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo());
            setAto_TblKobetsuHakkoKiwariGaku (panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku(), 2);
            setMae_TblKobetsuHakkoKiwariGaku (panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku());
            panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiMae().setSelectedItem(new RString("key2"));
        }
               
        response.data = panel;
        return response;
    }

    public ResponseData<FukaShokaiGrandsonTsuchishoDiv> onChange_ddlInjiKouseiMae(FukaShokaiGrandsonTsuchishoDiv panel, JuminFukaShokaiDiv div) {
        ResponseData<FukaShokaiGrandsonTsuchishoDiv> response = new ResponseData<>();
        
        RString key = panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiMae().getSelectedItem();
        if( key.contains("0") ){
            setAto_TblKobetsuHakkoFukakonkyo(panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo(), 0);
            setMae_TblKobetsuHakkoFukakonkyo(panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo(), 1);
            setAto_TblKobetsuHakkoKiwariGaku (panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku(), 0);
            setMae_TblKobetsuHakkoKiwariGaku (panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku(), 1);
            panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiAto().setSelectedItem(new RString("key0"));
        }else if( key.contains("1") ){
            setAto_TblKobetsuHakkoFukakonkyo(panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo(), 1);
            setMae_TblKobetsuHakkoFukakonkyo(panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo(), 2);
            setAto_TblKobetsuHakkoKiwariGaku (panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku(), 1);
            setMae_TblKobetsuHakkoKiwariGaku (panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku(), 2);
            panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiAto().setSelectedItem(new RString("key1"));
        }else{
            setMae_TblKobetsuHakkoFukakonkyo(panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo());
            setMae_TblKobetsuHakkoKiwariGaku (panel.getInjiNaiyoSettei().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku());
        }       
        
        response.data = panel;
        return response;
    }    
    
    private void set_jiyu(){
        List<HashMap> demoDataList = YamlLoader.DBB.loadAsList(CHOTEI_JIYU);
        for (Iterator<HashMap> it = demoDataList.iterator(); it.hasNext();) {
            HashMap demoData = it.next();
            ControlGenerator cg = new ControlGenerator(demoData);
            List<RString> k = new ArrayList<>();
            k.clear();
            k.add(cg.getAsRString("事由1"));
            k.add(cg.getAsRString("事由2"));     
            
            jiyu.add(k);
        }          
    }
    
    private void set_konkyo(){
        List<HashMap> demoDataList = YamlLoader.DBB.loadAsList(KOBETSU_HAKKO_FUKAKONKYO);
        //List<RString> k = new ArrayList<>();
        for (Iterator<HashMap> it = demoDataList.iterator(); it.hasNext();) {
            HashMap demoData = it.next();
            ControlGenerator cg = new ControlGenerator(demoData);
            List<RString> k = new ArrayList<>();
            k.clear();
            k.add(cg.getAsRString("賦課基準日"));
            k.add(cg.getAsRString("資格取得日"));
            k.add(cg.getAsRString("資格喪失日"));
            k.add(cg.getAsRString("本人課税"));
            k.add(cg.getAsRString("世帯課税"));
            k.add(cg.getAsRString("合計所得"));
            k.add(cg.getAsRString("年金収入額"));
            k.add(cg.getAsRString("保険料段階"));
            k.add(cg.getAsRString("減免額"));
            k.add(cg.getAsRString("保険料額"));
            k.add(cg.getAsRString("通知書番号"));
            k.add(cg.getAsRString("更正日時"));
            k.add(cg.getAsRString("更正月"));
            konkyo.add(k);
        } 
    }
    
    private void set_kiwarigaku(){
        List<HashMap> demoDataList = YamlLoader.DBB.loadAsList(KOBETSU_HAKKO_KIWARIGAKU);
        for (Iterator<HashMap> it = demoDataList.iterator(); it.hasNext();) {
           // コンストラクタにMapを渡して生成。
            HashMap demoData = it.next();
            ControlGenerator cg = new ControlGenerator(demoData);
            List<RString> k = new ArrayList<>();
            k.clear();
            k.add(cg.getAsRString("特1"));
            k.add(cg.getAsRString("特2"));
            k.add(cg.getAsRString("特3"));
            k.add(cg.getAsRString("特4"));
            k.add(cg.getAsRString("特5"));
            k.add(cg.getAsRString("特6"));
            k.add(cg.getAsRString("普1"));
            k.add(cg.getAsRString("普2"));
            k.add(cg.getAsRString("普3"));
            k.add(cg.getAsRString("普4"));
            k.add(cg.getAsRString("普5"));
            k.add(cg.getAsRString("普6"));
            k.add(cg.getAsRString("普7"));
            k.add(cg.getAsRString("普8"));
            k.add(cg.getAsRString("普9"));
            k.add(cg.getAsRString("普10"));
            kiwarigaku.add(k);
        }          
    }
    
    private void setAto_TblKobetsuHakkoFukakonkyo (tblKobetsuHakkoFukakonkyoDiv tbl, int n) {     
        tbl.getLblFukankonkyoAto1().setText(konkyo.get(n).get(0));
        tbl.getLblFukankonkyoAto2().setText(konkyo.get(n).get(1));
        tbl.getLblFukankonkyoAto3().setText(konkyo.get(n).get(2));
        tbl.getLblFukankonkyoAto8().setText(konkyo.get(n).get(3));
        tbl.getLblFukankonkyoAto9().setText(konkyo.get(n).get(4));
        tbl.getLblFukankonkyoAto10().setText(konkyo.get(n).get(5));
        tbl.getLblFukankonkyoAto11().setText(konkyo.get(n).get(6));
        tbl.getLblFukankonkyoAto12().setText(konkyo.get(n).get(7));
        tbl.getLblFukankonkyoAto13().setText(konkyo.get(n).get(8));
        tbl.getLblFukankonkyoAto14().setText(konkyo.get(n).get(9));             
    }
    
    private void setMae_TblKobetsuHakkoFukakonkyo (tblKobetsuHakkoFukakonkyoDiv tbl, int n) {            
        tbl.getLblFukankonkyoMae1().setText(konkyo.get(n).get(0));
        tbl.getLblFukankonkyoMae2().setText(konkyo.get(n).get(1));
        tbl.getLblFukankonkyoMae3().setText(konkyo.get(n).get(2));
        tbl.getLblFukankonkyoMae8().setText(konkyo.get(n).get(3));
        tbl.getLblFukankonkyoMae9().setText(konkyo.get(n).get(4));
        tbl.getLblFukankonkyoMae10().setText(konkyo.get(n).get(5));
        tbl.getLblFukankonkyoMae11().setText(konkyo.get(n).get(6));
        tbl.getLblFukankonkyoMae12().setText(konkyo.get(n).get(7));
        tbl.getLblFukankonkyoMae13().setText(konkyo.get(n).get(8));
        tbl.getLblFukankonkyoMae14().setText(konkyo.get(n).get(9));             
    }
 
    private void setMae_TblKobetsuHakkoFukakonkyo (tblKobetsuHakkoFukakonkyoDiv tbl) {            
        tbl.getLblFukankonkyoMae1().setText(RString.EMPTY);
        tbl.getLblFukankonkyoMae2().setText(RString.EMPTY);
        tbl.getLblFukankonkyoMae3().setText(RString.EMPTY);
        tbl.getLblFukankonkyoMae8().setText(RString.EMPTY);
        tbl.getLblFukankonkyoMae9().setText(RString.EMPTY);
        tbl.getLblFukankonkyoMae10().setText(RString.EMPTY);
        tbl.getLblFukankonkyoMae11().setText(RString.EMPTY);
        tbl.getLblFukankonkyoMae12().setText(RString.EMPTY);
        tbl.getLblFukankonkyoMae13().setText(RString.EMPTY);
        tbl.getLblFukankonkyoMae14().setText(RString.EMPTY);             
    }    
    
    private void setAto_TblKobetsuHakkoKiwariGaku (tblKobetsuHakkoKiwariGakuDiv tbl, int n) {
        tbl.getLblZengoTokuchoAto1().setText(kiwarigaku.get(n).get(0));
        tbl.getLblZengoTokuchoAto2().setText(kiwarigaku.get(n).get(1));
        tbl.getLblZengoTokuchoAto3().setText(kiwarigaku.get(n).get(2));
        tbl.getLblZengoTokuchoAto4().setText(kiwarigaku.get(n).get(3));
        tbl.getLblZengoTokuchoAto5().setText(kiwarigaku.get(n).get(4));
        tbl.getLblZengoTokuchoAto6().setText(kiwarigaku.get(n).get(5));
        
        tbl.getLblZengoFuchoAto3().setText(kiwarigaku.get(n).get(6));
        tbl.getLblZengoFuchoAto4().setText(kiwarigaku.get(n).get(7));
        tbl.getLblZengoFuchoAto5().setText(kiwarigaku.get(n).get(8));
        tbl.getLblZengoFuchoAto6().setText(kiwarigaku.get(n).get(9));
        tbl.getLblZengoFuchoAto7().setText(kiwarigaku.get(n).get(10));
        tbl.getLblZengoFuchoAto8().setText(kiwarigaku.get(n).get(11));
        tbl.getLblZengoFuchoAto9().setText(kiwarigaku.get(n).get(12));
        tbl.getLblZengoFuchoAto10().setText(kiwarigaku.get(n).get(13));
        tbl.getLblZengoFuchoAto11().setText(kiwarigaku.get(n).get(14));
        tbl.getLblZengoFuchoAto12().setText(kiwarigaku.get(n).get(15));
        
 
    }
    
    private void setMae_TblKobetsuHakkoKiwariGaku (tblKobetsuHakkoKiwariGakuDiv tbl, int n) {
        tbl.getLblZengoTokuchoMae1().setText(kiwarigaku.get(n).get(0));
        tbl.getLblZengoTokuchoMae2().setText(kiwarigaku.get(n).get(1));
        tbl.getLblZengoTokuchoMae3().setText(kiwarigaku.get(n).get(2));
        tbl.getLblZengoTokuchoMae4().setText(kiwarigaku.get(n).get(3));
        tbl.getLblZengoTokuchoMae5().setText(kiwarigaku.get(n).get(4));
        tbl.getLblZengoTokuchoMae6().setText(kiwarigaku.get(n).get(5));
        
        tbl.getLblZengoFuchoMae3().setText(kiwarigaku.get(n).get(6));
        tbl.getLblZengoFuchoMae4().setText(kiwarigaku.get(n).get(7));
        tbl.getLblZengoFuchoMae5().setText(kiwarigaku.get(n).get(8));
        tbl.getLblZengoFuchoMae6().setText(kiwarigaku.get(n).get(9));
        tbl.getLblZengoFuchoMae7().setText(kiwarigaku.get(n).get(10));
        tbl.getLblZengoFuchoMae8().setText(kiwarigaku.get(n).get(11));
        tbl.getLblZengoFuchoMae9().setText(kiwarigaku.get(n).get(12));
        tbl.getLblZengoFuchoMae10().setText(kiwarigaku.get(n).get(13));
        tbl.getLblZengoFuchoMae11().setText(kiwarigaku.get(n).get(14));
        tbl.getLblZengoFuchoMae12().setText(kiwarigaku.get(n).get(15));
    } 
    
    private void setMae_TblKobetsuHakkoKiwariGaku (tblKobetsuHakkoKiwariGakuDiv tbl) {
        tbl.getLblZengoTokuchoMae1().setText(RString.EMPTY);
        tbl.getLblZengoTokuchoMae2().setText(RString.EMPTY);
        tbl.getLblZengoTokuchoMae3().setText(RString.EMPTY);
        tbl.getLblZengoTokuchoMae4().setText(RString.EMPTY);
        tbl.getLblZengoTokuchoMae5().setText(RString.EMPTY);
        tbl.getLblZengoTokuchoMae6().setText(RString.EMPTY);
        
        tbl.getLblZengoFuchoMae3().setText(RString.EMPTY);
        tbl.getLblZengoFuchoMae4().setText(RString.EMPTY);
        tbl.getLblZengoFuchoMae5().setText(RString.EMPTY);
        tbl.getLblZengoFuchoMae6().setText(RString.EMPTY);
        tbl.getLblZengoFuchoMae7().setText(RString.EMPTY);
        tbl.getLblZengoFuchoMae8().setText(RString.EMPTY);
        tbl.getLblZengoFuchoMae9().setText(RString.EMPTY);
        tbl.getLblZengoFuchoMae10().setText(RString.EMPTY);
        tbl.getLblZengoFuchoMae11().setText(RString.EMPTY);
        tbl.getLblZengoFuchoMae12().setText(RString.EMPTY);
    }      
    
}
