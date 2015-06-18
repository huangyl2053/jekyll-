/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoNinteiAtenaInfo;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.HdnShoriTypeStatus;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.HokenshaKosei;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoNinteiAtenaInfo.KaigoNinteiAtenaInfoDiv.AtenaType;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoNinteiAtenaInfo.KaigoNinteiAtenaInfoDiv.ShoriType;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TestKaigoNinteiAtenaInfo.TestKaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定宛名情報の共有子Divのエンティティに対する操作を行うクラスです。
 * @author n8223
 */
public class KaigoNinteiAtenaInfoHandler {
    
   private final KaigoNinteiAtenaInfoDiv  div;
   private final RString JUTONAI_IMAGE_PATH = new RString("/uz/uza/image/UZ_Person_Jutonai.png"); 
   private final RString JUTOGAI_IMAGE_PATH = new RString("/uz/uza/image/UZ_Person_Jutogai.png");

    /**
     * コンストラクタです。
     * @param kaigoNinteiAtenaInfoDiv 介護認定宛名情報の共有子のエンティティ
     */
    public KaigoNinteiAtenaInfoHandler(KaigoNinteiAtenaInfoDiv  kaigoNinteiAtenaInfoDiv) {
        this.div = kaigoNinteiAtenaInfoDiv;
    }
    
    /**
     * 初期化処理です。
     */
    public void initialize() {
        //隠し項目の介護導入形態の値により、宛名モードを設定する。
         if(!div.getHdnKaigoDonyuKeitai().equals(RString.EMPTY)) {
             switch(HokenshaKosei.toValue(div.getHdnKaigoDonyuKeitai())) {
                 case 単一市町村:
                 case 広域市町村:
                 case 広域保険者: 
                     div.setMode_AtenaType(AtenaType.AtenaMode);
                     break;
                 case 広域審査会:   
                     div.setMode_AtenaType(AtenaType.AtenaNonMode);
                     break; 
                 default:
                     break;
             }
         }
         
         //隠し項目の処理タイプの値により、処理タイプモードを設定する。
        if(!div.getHdnShoriType().equals(RString.EMPTY)){
             switch(HdnShoriTypeStatus.toValue(div.getHdnShoriType())) {
                 case NomalAddMode:
                     div.setMode_ShoriType(ShoriType.NormalAddMode);
                     break;
                 case NomalUpdateMode:
                     div.setMode_ShoriType(ShoriType.NormalUpdateMode);
                     break;
                 case SeihoAddMode:
                     div.setMode_ShoriType(ShoriType.SeihoAddMode);
                     break;
                 case SeihoUpdateMode:
                     div.setMode_ShoriType(ShoriType.SeihoUpdateMode);
                     break;
                 case ShokaiMode: 
                     div.setMode_ShoriType(ShoriType.ShokaiMode);
                 default:
                      break;
             } 
        }
        
   }

    /**
     * ロードする処理です。(テスト用)
     * TODO: testKaigoNinteiAtenaInfoDiv 親の画面の情報を取得するため【テスト】変更あり
     * @param testKaigoNinteiAtenaInfoDiv
     */  
    public void load(TestKaigoNinteiAtenaInfoDiv testKaigoNinteiAtenaInfoDiv) {
       set介護認定宛名情報(testKaigoNinteiAtenaInfoDiv);
    } 
    
    //テスト用  
    private void set介護認定宛名情報(TestKaigoNinteiAtenaInfoDiv testKaigoNinteiAtenaInfoDiv) {
        div.getTxtShimei().setValue(testKaigoNinteiAtenaInfoDiv.getTxtShimei().getValue());
        div.getTxtBirthYMD().setValue(testKaigoNinteiAtenaInfoDiv.getTxtBirthYMD().getValue());
        div.getTxtNenrei().setValue(testKaigoNinteiAtenaInfoDiv.getTxtNenrei().getValue());
        div.getTxtSeibetsu().setValue(testKaigoNinteiAtenaInfoDiv.getTxtSeibetsu().getValue());
        //住民種別コードの名称
        div.getTxtJuminShubetsu().setValue(testKaigoNinteiAtenaInfoDiv.getTxtJuminShubetsu().getValue());
        div.getTxtKojinNo().setValue(testKaigoNinteiAtenaInfoDiv.getTxtKojinNo().getValue());
        div.getTxtYubinNo().setValue(testKaigoNinteiAtenaInfoDiv.getTxtYubinNo().getValue());
        div.setTxtJusho(testKaigoNinteiAtenaInfoDiv.getTxtJusho());
        div.setTxtTelNo(testKaigoNinteiAtenaInfoDiv.getTxtTelNo());
        div.setTxtSetaiCode(testKaigoNinteiAtenaInfoDiv.getTxtSetaiCode());
        div.getTxtGyoseiku().setValue(testKaigoNinteiAtenaInfoDiv.getTxtGyoseiku().getValue());
        div.getTxtShikiBetsuCode().setValue(testKaigoNinteiAtenaInfoDiv.getTxtShikiBetsuCode().getValue());
        setImgJuminShubetsu(); 
    }

     //テスト用     
     private void setImgJuminShubetsu()  {
        //JuminShubetsu 日本人("1", "日本人"), 外国人("2", "外国人"),住登外個人_日本人("3", "住登外（日本人）"),法人("5", "法人"),  共有者("6", "共有者");
        // 親画面：div.getTxtJuminShubetsu().getValue()
            if(!div.getMode_AtenaType().equals(RString.EMPTY) && 
                    div.getMode_AtenaType().equals(AtenaType.AtenaMode)) {
                switch(JuminShubetsu.toValue(div.getTxtJuminShubetsu().getValue())) {
                    //住登内
                    case 日本人:
                    case 外国人:
                    case 法人:
                    case 共有者:
                        div.getImgJuminShubetsu().setSrc(JUTONAI_IMAGE_PATH);
                        break;
                    //住登外    
                    case 住登外個人_日本人:
                    case 住登外個人_外国人:
                        div.getImgJuminShubetsu().setSrc(JUTOGAI_IMAGE_PATH);
                        break;
                    default:
                        break;
                }
            }
        }


}
