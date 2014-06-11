/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukaRirekiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuFukakijun1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuFukakijun2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuFukakijun3Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuFukakijun4Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuHokenryo3Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuHokenryo4Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuKibetsuGaku3Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuKibetsuGaku4Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuZanteiGaku1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuZanteiGaku2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuZennendo1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuZennendo2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaJohoHikakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukaShokaiGrandsonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.dgFukaRirekiFukaRireki_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.HonSantei1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.HonSantei2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.KariSantei1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.KariSantei2Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SetaiShotokuIchiran.dgSetaiShotoku_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 賦課照会比較画面
 * @author n8211 田辺 紘一
 */
public class FukaHikaku {
    public ResponseData<FukaJohoHikakuDiv> getOnLoadData(FukaJohoHikakuDiv panel) {
        ResponseData<FukaJohoHikakuDiv> response = new ResponseData<>();

        FukaShokaiGrandsonDiv  fukaShokaiDiv = (FukaShokaiGrandsonDiv) ViewStateHolder.get("賦課照会", FukaShokaiGrandsonDiv.class);
        FukaRirekiDiv rirekiDiv = (FukaRirekiDiv) ViewStateHolder.get("賦課履歴", FukaRirekiDiv.class);

        setDefaultParam(panel, fukaShokaiDiv, rirekiDiv);

        response.data = panel;
        return response;
    }

    private void setDefaultParam(
            FukaJohoHikakuDiv fukaJohoHikakuDiv
            , FukaShokaiGrandsonDiv fukaShokaiGrandsonDiv, FukaRirekiDiv rirekiDiv) {

        DataGrid<dgSetaiShotoku_Row> dataGridSetaiShotoku = fukaShokaiGrandsonDiv.getSetaiinShotoku().getSetaiShotokuIchiran().getDgSetaiShotoku();
        DataGrid<dgFukaRirekiFukaRireki_Row> dataGridFukarireki = rirekiDiv.getDgFukaRirekiFukaRireki();
        
        KariSantei1Div kariSantei1 = fukaJohoHikakuDiv.getKariSantei1();
        KariSantei2Div kariSantei2 = fukaJohoHikakuDiv.getKariSantei2();   
        
        HonSantei1Div honSantei1 = fukaJohoHikakuDiv.getHonSantei1();
        HonSantei2Div honSantei2 = fukaJohoHikakuDiv.getHonSantei2();

        kariSantei1.setDisplayNone(true);
        kariSantei2.setDisplayNone(true);
        honSantei1.setDisplayNone(true);
        honSantei2.setDisplayNone(true);

        List<dgSetaiShotoku_Row> selected = dataGridSetaiShotoku.getSelectedItems();

        List 識別コード = new ArrayList();
        List 賦課年度 = new ArrayList();
        List 調定年度 = new ArrayList();
        
        for (dgSetaiShotoku_Row item : selected) {
            if (!item.getTxtShikibetsuCode().isEmpty()) {
                 識別コード.add(item.getTxtShikibetsuCode().toString());
                 賦課年度.add(rirekiDiv.getTxtFukaNendoFukaRireki());
                 調定年度.add(fukaShokaiGrandsonDiv.getTxtChoteiNendo());
            }
        }
        
        if (識別コード.size() < 2) {
            dgFukaRirekiFukaRireki_Row clicked = dataGridFukarireki.getClickedItem();
            int clickedRowId = dataGridFukarireki.getClickedRowId();
            識別コード.add(clicked.getTxtShikibetsuCode());
            識別コード.add(clicked.getTxtShikibetsuCode());
            賦課年度.add(rirekiDiv.getTxtFukaNendoFukaRireki());
            賦課年度.add(rirekiDiv.getTxtFukaNendoFukaRireki());
            調定年度.add(clicked.getTxtChoteiNendo());
            List<dgFukaRirekiFukaRireki_Row> dataSource = dataGridFukarireki.getDataSource();
            調定年度.add(dataSource.get(clickedRowId+1).getTxtChoteiNendo());
        }
        
        setHikaku(fukaJohoHikakuDiv, 識別コード, 賦課年度, 調定年度, fukaShokaiGrandsonDiv, rirekiDiv);
    }
    
    private void setHikaku(FukaJohoHikakuDiv fukaJohoHikakuDiv, List 識別コード, List 賦課年度, List 調定年度, FukaShokaiGrandsonDiv shokaiGrandsonDiv, FukaRirekiDiv rirekiDiv) {

            for (int i = 0; i < 識別コード.size(); i++) {
                List keyList = new ArrayList();
                setHikakuParam(fukaJohoHikakuDiv, (RString)識別コード.get(i), (RString)賦課年度.get(i), (RString)調定年度.get(i), shokaiGrandsonDiv, rirekiDiv);
            }
    }
    
    private void setHikakuParam(FukaJohoHikakuDiv fukaJohoHikakuDiv, RString 識別コード, RString 賦課年度, RString 調定年度, FukaShokaiGrandsonDiv shokaiGrandsonDiv, FukaRirekiDiv rirekiDiv) {
        
        List<HashMap> fukaShokaiData = YamlLoader.DBB.loadAsList(new RString("FukaShokai.yml"));
        for (int i = 0; i <= fukaShokaiData.size(); i++) {
            if (識別コード.contains((String)fukaShokaiData.get(i).get("識別コード")) 
                    & 賦課年度.contains((String)fukaShokaiData.get(i).get("賦課年度")) & 調定年度.contains((String)fukaShokaiData.get(i).get("賦課年度"))) {
                if (fukaShokaiData.get(i).get("状態").toString().equals("仮算定")) {
//                    setKariSanteiParam(fukaJohoHikakuDiv, fukaShokaiData, i, shokaiGrandsonDiv, rirekiDiv);
                    break;
                } else if (fukaShokaiData.get(i).get("状態").toString().equals("本算定")) {
                    setHonSanteiParam(fukaJohoHikakuDiv, fukaShokaiData, i, shokaiGrandsonDiv, rirekiDiv);
                    break;
                }
            }
        }
    }

    private void setKariSanteiParam(FukaJohoHikakuDiv fukaJohoHikakuDiv, List<HashMap> fukaShokaiData, int yamlNo) {
        
        KariSantei1Div kariSantei1 = fukaJohoHikakuDiv.getKariSantei1();
        FukaHikakuFukakijun1Div fukakijunKari1 = kariSantei1.getFukaHikakuFukakijun1();
        FukaHikakuZennendo1Div zennendoKari1 = kariSantei1.getFukaHikakuZennendo1();
        FukaHikakuZanteiGaku1Div zanteiGaku1 = kariSantei1.getFukaHikakuZanteiGaku1();

        KariSantei2Div kariSantei2 = fukaJohoHikakuDiv.getKariSantei2();
        FukaHikakuFukakijun2Div fukakijunKari2 = kariSantei2.getFukaHikakuFukakijun2();
        FukaHikakuZennendo2Div zennendoKari2 = kariSantei2.getFukaHikakuZennendo2();
        FukaHikakuZanteiGaku2Div zanteiGaku2 = kariSantei2.getFukaHikakuZanteiGaku2();

        if (kariSantei1.getTxtChoteiNendo1().getValue().length() <= 0) {

            kariSantei1.setDisplayNone(false);

            String 調定年度 = (String)fukaShokaiData.get(yamlNo).get("調定年度");
            String 賦課年度 = (String)fukaShokaiData.get(yamlNo).get("賦課年度");
            String 通知書番号 = (String)fukaShokaiData.get(yamlNo).get("通知書番号");
            String 更正日時 = (String)fukaShokaiData.get(yamlNo).get("更正日時");
            String 更正月 = (String)fukaShokaiData.get(yamlNo).get("更正月");
            String 氏名 = (String)fukaShokaiData.get(yamlNo).get("氏名");

            if (調定年度 != null) kariSantei1.getTxtChoteiNendo1().setValue(new RString(調定年度));
            if (賦課年度 != null) kariSantei1.getTxtFukaNendo1().setValue(new RString(賦課年度));
            if (通知書番号 != null) kariSantei1.getTxtTsuchiNo1().setValue(new RString(通知書番号));
            if (更正日時 != null) kariSantei1.getTxtKoseiYMD1().setValue(new RString(更正日時));
            if (更正月 != null) kariSantei1.getTxtKoseiYM1().setValue(new RString(更正月));
            if (氏名 != null) kariSantei1.getTxtShimei1().setValue(new RString(氏名));

            String 資格取得日 = (String)fukaShokaiData.get(yamlNo).get("資格取得日");
            String 資格喪失日 = (String)fukaShokaiData.get(yamlNo).get("資格喪失日");

            if (資格取得日 != null) fukakijunKari1.getTxtShikakuShutokuYMD1().setValue(new RDate(資格取得日));
            if (資格喪失日 != null) fukakijunKari1.getTxtShikakuSoshitsuYMD1().setValue(new RDate(資格喪失日));

            String 保険料段階 = (String)fukaShokaiData.get(yamlNo).get("保険料段階");
            String 保険料率 = (String)fukaShokaiData.get(yamlNo).get("保険料率");
            String 年額保険料 = (String)fukaShokaiData.get(yamlNo).get("年額保険料");

            if (保険料段階 != null) zennendoKari1.getTxtHokenryoDankai1().setValue(new RString(保険料段階));
            if (保険料率 != null) zennendoKari1.getTxtHokenryoRitsu1().setValue(new RString(保険料率));
            if (年額保険料 != null) zennendoKari1.getTxtNengakuHokensryo1().setValue(new RString(年額保険料));

            String 減免額 = (String)fukaShokaiData.get(yamlNo).get("減免額");
            String 暫定保険料額合計 = (String)fukaShokaiData.get(yamlNo).get("暫定保険料額合計");

            if (減免額 != null) zanteiGaku1.getTxtGemmenGaku1().setValue(new RString(減免額));
            if (暫定保険料額合計 != null) zanteiGaku1.getTxtGemmenGaku1().setValue(new RString(暫定保険料額合計));
            
        } else {
            kariSantei2.setDisplayNone(false);
            
            String 調定年度 = (String)fukaShokaiData.get(yamlNo).get("調定年度");
            String 賦課年度 = (String)fukaShokaiData.get(yamlNo).get("賦課年度");
            String 通知書番号 = (String)fukaShokaiData.get(yamlNo).get("通知書番号");
            String 更正日時 = (String)fukaShokaiData.get(yamlNo).get("更正日時");
            String 更正月 = (String)fukaShokaiData.get(yamlNo).get("更正月");
            String 氏名 = (String)fukaShokaiData.get(yamlNo).get("氏名");

            if (調定年度 != null) kariSantei2.getTxtChoteiNendo2().setValue(new RString(調定年度));
            if (賦課年度 != null) kariSantei2.getTxtFukaNendo2().setValue(new RString(賦課年度));
            if (通知書番号 != null) kariSantei2.getTxtTsuchiNo2().setValue(new RString(通知書番号));
            if (更正日時 != null) kariSantei2.getTxtKoseiYMD2().setValue(new RString(更正日時));
            if (更正月 != null) kariSantei2.getTxtKoseiYM2().setValue(new RString(更正月));
            if (氏名 != null) kariSantei2.getTxtShimei2().setValue(new RString(氏名));

            String 資格取得日 = (String)fukaShokaiData.get(yamlNo).get("資格取得日");
            String 資格喪失日 = (String)fukaShokaiData.get(yamlNo).get("資格喪失日");

            if (資格取得日 != null) fukakijunKari2.getTxtShikakuShutokuYMD2().setValue(new RDate(資格取得日));
            if (資格喪失日 != null) fukakijunKari2.getTxtShikakuSoshitsuYMD2().setValue(new RDate(資格喪失日));

            String 保険料段階 = (String)fukaShokaiData.get(yamlNo).get("保険料段階");
            String 保険料率 = (String)fukaShokaiData.get(yamlNo).get("保険料率");
            String 年額保険料 = (String)fukaShokaiData.get(yamlNo).get("年額保険料");

            if (保険料段階 != null) zennendoKari2.getTxtHokenryoDankai2().setValue(new RString(保険料段階));
            if (保険料率 != null) zennendoKari2.getTxtHokenryoRitsu2().setValue(new RString(保険料率));
            if (年額保険料 != null) zennendoKari2.getTxtNengakuHokensryo2().setValue(new RString(年額保険料));

            String 減免額 = (String)fukaShokaiData.get(yamlNo).get("減免額");
            String 暫定保険料額合計 = (String)fukaShokaiData.get(yamlNo).get("暫定保険料額合計");

            if (減免額 != null) zanteiGaku2.getTxtGemmenGaku2().setValue(new RString(減免額));
            if (暫定保険料額合計 != null) zanteiGaku2.getTxtGemmenGaku2().setValue(new RString(暫定保険料額合計));
        }
    }

    private void setHonSanteiParam(FukaJohoHikakuDiv fukaJohoHikakuDiv, List<HashMap> fukaShokaiData, int i, FukaShokaiGrandsonDiv shokaiGrandsonDiv, FukaRirekiDiv rirekiDiv) {

        HonSantei1Div honSantei1 = fukaJohoHikakuDiv.getHonSantei1();
        FukaHikakuFukakijun3Div fukakijun3 = honSantei1.getFukaHikakuFukakijun3();
        FukaHikakuHokenryo3Div hokenryo3 = honSantei1.getFukaHikakuHokenryo3();
        FukaHikakuKibetsuGaku3Div kibetsuGaku3 = honSantei1.getFukaHikakuKibetsuGaku3();

        HonSantei2Div honSantei2 = fukaJohoHikakuDiv.getHonSantei2();     
        FukaHikakuFukakijun4Div fukakijun4 = honSantei2.getFukaHikakuFukakijun4();
        FukaHikakuHokenryo4Div hokenryo4 = honSantei2.getFukaHikakuHokenryo4();
        FukaHikakuKibetsuGaku4Div kibetsuGaku4 = honSantei2.getFukaHikakuKibetsuGaku4();
        
        if (honSantei1.getTxtChoteiNendo3().getValue().length() <= 0) {
            honSantei1.setDisplayNone(false);

            String 通知書番号 = (String)fukaShokaiData.get(i).get("通知書番号");
            String 氏名 = (String)fukaShokaiData.get(i).get("氏名");

            honSantei1.getTxtChoteiNendo3().setValue(shokaiGrandsonDiv.getTxtChoteiNendo().getValue());
            honSantei1.getTxtFukaNendo3().setValue(rirekiDiv.getTxtFukaNendoFukaRireki().getValue());
            
            if (通知書番号 != null) honSantei1.getTxtTsuchiNo3().setValue(new RString(通知書番号));
            honSantei1.getTxtKoseiYMD3().setValue(shokaiGrandsonDiv.getTxtKoseiYMD().getValue());
            honSantei1.getTxtKoseiYM3().setValue(shokaiGrandsonDiv.getTxtKoseiM().getValue());
            if (氏名 != null) honSantei1.getTxtShimei3().setValue(new RString(氏名));

            String 資格取得日 = (String)fukaShokaiData.get(i).get("資格取得日");
            String 資格喪失日 = (String)fukaShokaiData.get(i).get("資格喪失日");
            String 合計所得 = (String)fukaShokaiData.get(i).get("合計所得");
            String 年金収入額 = (String)fukaShokaiData.get(i).get("年金収入額");
            String 本人課税 = (String)fukaShokaiData.get(i).get("本課税");
            String 世帯課税 = (String)fukaShokaiData.get(i).get("世帯課税");
            
            ControlGenerator cg = new ControlGenerator(fukaShokaiData.get(i));
            
            if (資格取得日 != null) fukakijun3.getTxtShikakuShutokuYMD3().setValue(new RDate(資格取得日));
            if (資格喪失日 != null) fukakijun3.getTxtShikakusoshitsuYMD3().setValue(new RDate(資格喪失日));
            if (合計所得 != null) fukakijun3.getTxtGoukeiShotoku3().setValue(new RString(合計所得));
            if (年金収入額 != null) fukakijun3.getTxtNenkinShunyu3().setValue(new RString(年金収入額));
            if (本人課税 != null) fukakijun3.getTxtHonninKazei3().setValue(new RString(本人課税));
            if (世帯課税 != null) fukakijun3.getTxtSetaiKazei3().setValue(new RString(世帯課税));
            fukakijun3.getTxtSetaiinSu3().setValue(cg.getAsRString("世帯員数"));

            String 保険料段階 = (String)fukaShokaiData.get(i).get("保険料段階");
            String 境界層 = (String)fukaShokaiData.get(i).get("境界層");
            String 計算保険料額 = (String)fukaShokaiData.get(i).get("計算保険料額");
            String 減免額 = (String)fukaShokaiData.get(i).get("減免額");
            String 確定保険料 = (String)fukaShokaiData.get(i).get("減免額");
            String 特徴歳出還付額 = (String)fukaShokaiData.get(i).get("特徴歳出還付額");
            String 普徴歳出還付額 = (String)fukaShokaiData.get(i).get("普徴歳出還付額");

            if (保険料段階 != null) hokenryo3.getTxtHokenryoDankai3().setValue(new RString(保険料段階));
            if (境界層 != null) hokenryo3.getTxtKyokaiso3().setValue(new RString(境界層));
            if (計算保険料額 != null) hokenryo3.getTxtKeisanHokenryogaku3().setValue(new RString(計算保険料額));
            if (減免額 != null) hokenryo3.getTxtGemmenGaku3().setValue(new RString(減免額));
            if (確定保険料 != null) hokenryo3.getTxtKakuteiHokenryo3().setValue(new RString(確定保険料));
            if (特徴歳出還付額 != null) hokenryo3.getTxtTokuchoSaishutukanpu3().setValue(new RString(特徴歳出還付額));
            if (普徴歳出還付額 != null) hokenryo3.getTxtFuchoSaishutukanpu3().setValue(new RString(普徴歳出還付額));
            
            String 特徴1期 = (String)fukaShokaiData.get(i).get("特徴1期").toString();
            String 特徴2期 = (String)fukaShokaiData.get(i).get("特徴2期").toString();
            String 特徴3期 = (String)fukaShokaiData.get(i).get("特徴3期").toString();
            String 特徴4期 = (String)fukaShokaiData.get(i).get("特徴4期").toString();
            String 特徴5期 = (String)fukaShokaiData.get(i).get("特徴5期").toString();
            String 特徴6期 = (String)fukaShokaiData.get(i).get("特徴6期").toString();

            if (特徴1期 != null) kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku1().setText(new RString(特徴1期));
            if (特徴2期 != null) kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku2().setText(new RString(特徴2期));            
            if (特徴3期 != null) kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku3().setText(new RString(特徴3期));
            if (特徴4期 != null) kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku4().setText(new RString(特徴4期));            
            if (特徴5期 != null) kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku5().setText(new RString(特徴5期));
            if (特徴6期 != null) kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku6().setText(new RString(特徴6期));
            
            String 普徴1期 = (String)fukaShokaiData.get(i).get("普徴1期");
            String 普徴2期 = (String)fukaShokaiData.get(i).get("普徴2期");
            String 普徴3期 = (String)fukaShokaiData.get(i).get("普徴3期");
            String 普徴4期 = (String)fukaShokaiData.get(i).get("普徴4期");
            String 普徴5期 = (String)fukaShokaiData.get(i).get("普徴5期");
            String 普徴6期 = (String)fukaShokaiData.get(i).get("普徴6期");
            String 普徴7期 = (String)fukaShokaiData.get(i).get("普徴7期");
            String 普徴8期 = (String)fukaShokaiData.get(i).get("普徴8期");
            String 普徴9期 = (String)fukaShokaiData.get(i).get("普徴9期");
            String 普徴10期 = (String)fukaShokaiData.get(i).get("普徴10期");
            String 普徴11期 = (String)fukaShokaiData.get(i).get("普徴11期");
            String 普徴12期 = (String)fukaShokaiData.get(i).get("普徴12期");

            if (普徴1期 != null) kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku1().setText(new RString(普徴1期));
            if (普徴2期 != null) kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku1().setText(new RString(普徴2期));            
            if (普徴3期 != null) kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku1().setText(new RString(普徴3期));
            if (普徴4期 != null) kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku1().setText(new RString(普徴4期));            
            if (普徴5期 != null) kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku1().setText(new RString(普徴5期));
            if (普徴6期 != null) kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku1().setText(new RString(普徴6期));
            if (普徴7期 != null) kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku1().setText(new RString(普徴7期));
            if (普徴8期 != null) kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku1().setText(new RString(普徴8期));            
            if (普徴9期 != null) kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku1().setText(new RString(普徴9期));
            if (普徴10期 != null) kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku1().setText(new RString(普徴10期));            
            if (普徴11期 != null) kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku1().setText(new RString(普徴11期));
            if (普徴12期 != null) kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku1().setText(new RString(普徴12期));       
        } else {

            honSantei2.setDisplayNone(false);

            String 調定年度 = (String)fukaShokaiData.get(i).get("調定年度");
            String 賦課年度 = (String)fukaShokaiData.get(i).get("賦課年度");
            String 通知書番号 = (String)fukaShokaiData.get(i).get("通知書番号");
            String 更正日時 = (String)fukaShokaiData.get(i).get("更正日時");
            String 更正月 = (String)fukaShokaiData.get(i).get("更正月");
            String 氏名 = (String)fukaShokaiData.get(i).get("氏名");

            if (調定年度 != null) honSantei2.getTxtChoteiNendo4().setValue(new RString(調定年度));
            if (賦課年度 != null) honSantei2.getTxtFukaNendo4().setValue(new RString(賦課年度));
            if (通知書番号 != null) honSantei2.getTxtTsuchiNo4().setValue(new RString(通知書番号));
            if (更正日時 != null) honSantei2.getTxtKoseiYMD4().setValue(new RString(更正日時));
            if (更正月 != null) honSantei2.getTxtKoseiYM4().setValue(new RString(更正月));
            if (氏名 != null) honSantei2.getTxtShimei4().setValue(new RString(氏名));

            String 資格取得日 = (String)fukaShokaiData.get(i).get("資格取得日");
            String 資格喪失日 = (String)fukaShokaiData.get(i).get("資格喪失日");
            String 合計所得 = (String)fukaShokaiData.get(i).get("合計所得");
            String 年金収入額 = (String)fukaShokaiData.get(i).get("年金収入額");
            String 本人課税 = (String)fukaShokaiData.get(i).get("本課税");
            String 世帯課税 = (String)fukaShokaiData.get(i).get("世帯課税");

            ControlGenerator cg = new ControlGenerator(fukaShokaiData.get(i));
            
            if (資格取得日 != null) fukakijun4.getTxtShikakuShutokuYMD4().setValue(new RDate(資格取得日));
            if (資格喪失日 != null) fukakijun4.getTxtShikakuSoshitsuYMD4().setValue(new RDate(資格喪失日));
            if (合計所得 != null) fukakijun4.getTxtGoukeiShotoku4().setValue(new RString(合計所得));
            if (年金収入額 != null) fukakijun4.getTxtNenkinShunyu4().setValue(new RString(年金収入額));
            if (本人課税 != null) fukakijun4.getTxtHonninKazei4().setValue(new RString(本人課税));
            if (世帯課税 != null) fukakijun4.getTxtSetaiKazei4().setValue(new RString(世帯課税));
            fukakijun4.getTxtSetaiinSu4().setValue(cg.getAsRString("世帯員数"));

            String 保険料段階 = (String)fukaShokaiData.get(i).get("保険料段階");
            String 境界層 = (String)fukaShokaiData.get(i).get("境界層");
            String 計算保険料額 = (String)fukaShokaiData.get(i).get("計算保険料額");
            String 減免額 = (String)fukaShokaiData.get(i).get("減免額");
            String 確定保険料 = (String)fukaShokaiData.get(i).get("減免額");
            String 特徴歳出還付額 = (String)fukaShokaiData.get(i).get("特徴歳出還付額");
            String 普徴歳出還付額 = (String)fukaShokaiData.get(i).get("普徴歳出還付額");

            if (保険料段階 != null) hokenryo4.getTxtHokenryoDankai4().setValue(new RString(保険料段階));
            if (境界層 != null) hokenryo4.getTxtKyokaiso4().setValue(new RString(境界層));
            if (計算保険料額 != null) hokenryo4.getTxtKeisanHokenryogaku4().setValue(new RString(計算保険料額));
            if (減免額 != null) hokenryo4.getTxtGemmenGaku4().setValue(new RString(減免額));
            if (確定保険料 != null) hokenryo4.getTxtKakuteiHokenryo4().setValue(new RString(確定保険料));
            if (特徴歳出還付額 != null) hokenryo4.getTxtTokuchoSaishutukanpu4().setValue(new RString(特徴歳出還付額));
            if (普徴歳出還付額 != null) hokenryo4.getTxtFuchoSaishutukanpu4().setValue(new RString(普徴歳出還付額));

            String 特徴1期 = (String)fukaShokaiData.get(i).get("特徴1期").toString();
            String 特徴2期 = (String)fukaShokaiData.get(i).get("特徴2期").toString();
            String 特徴3期 = (String)fukaShokaiData.get(i).get("特徴3期").toString();
            String 特徴4期 = (String)fukaShokaiData.get(i).get("特徴4期").toString();
            String 特徴5期 = (String)fukaShokaiData.get(i).get("特徴5期").toString();
            String 特徴6期 = (String)fukaShokaiData.get(i).get("特徴6期").toString();
            
            if (特徴1期 != null) kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuKibetsuGaku1().setText(new RString(特徴1期));
            if (特徴2期 != null) kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuKibetsuGaku1().setText(new RString(特徴2期));            
            if (特徴3期 != null) kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuKibetsuGaku1().setText(new RString(特徴3期));
            if (特徴4期 != null) kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuKibetsuGaku1().setText(new RString(特徴4期));            
            if (特徴5期 != null) kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuKibetsuGaku1().setText(new RString(特徴5期));
            if (特徴6期 != null) kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuKibetsuGaku1().setText(new RString(特徴6期));
            
            String 普徴1期 = (String)fukaShokaiData.get(i).get("普徴1期").toString();
            String 普徴2期 = (String)fukaShokaiData.get(i).get("普徴2期").toString();
            String 普徴3期 = (String)fukaShokaiData.get(i).get("普徴3期").toString();
            String 普徴4期 = (String)fukaShokaiData.get(i).get("普徴4期").toString();
            String 普徴5期 = (String)fukaShokaiData.get(i).get("普徴5期").toString();
            String 普徴6期 = (String)fukaShokaiData.get(i).get("普徴6期").toString();
            String 普徴7期 = (String)fukaShokaiData.get(i).get("普徴7期").toString();
            String 普徴8期 = (String)fukaShokaiData.get(i).get("普徴8期").toString();
            String 普徴9期 = (String)fukaShokaiData.get(i).get("普徴9期").toString();
            String 普徴10期 = (String)fukaShokaiData.get(i).get("普徴10期").toString();
            String 普徴11期 = (String)fukaShokaiData.get(i).get("普徴11期").toString();
            String 普徴12期 = (String)fukaShokaiData.get(i).get("普徴12期").toString();

            if (普徴1期 != null) kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku().setText(new RString(普徴1期));
            if (普徴2期 != null) kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku().setText(new RString(普徴2期));            
            if (普徴3期 != null) kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku().setText(new RString(普徴3期));
            if (普徴4期 != null) kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku().setText(new RString(普徴4期));            
            if (普徴5期 != null) kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku().setText(new RString(普徴5期));
            if (普徴6期 != null) kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku().setText(new RString(普徴6期));
            if (普徴7期 != null) kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku().setText(new RString(普徴7期));
            if (普徴8期 != null) kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku().setText(new RString(普徴8期));            
            if (普徴9期 != null) kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku().setText(new RString(普徴9期));
            if (普徴10期 != null) kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku().setText(new RString(普徴10期));            
            if (普徴11期 != null) kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku().setText(new RString(普徴11期));
            if (普徴12期 != null) kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku().setText(new RString(普徴12期));   
        }
    }
}