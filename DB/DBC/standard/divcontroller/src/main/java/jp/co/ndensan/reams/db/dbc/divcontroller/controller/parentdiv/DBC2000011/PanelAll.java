/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2000011;

import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000011.PanelAllDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.message.DbQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

 /**
     * onLoad
     *
     */
public class PanelAll {
    /**
     * onload
     * @param div
     * @return 
     */
    private final RString 処理済 = new RString("処理済");
    private final RString 再処理前 = new RString("再処理前");
    private final RString 未処理 = new RString("未処理");
    //private final RDate 処理日時=new RDate("処理日時");
    private final RString ZERO = new RString("0"); 
    
    private final RString ONE = new RString("1"); 
    private final RString TWO = new RString("2");
    public ResponseData<PanelAllDiv> onLoad(PanelAllDiv div) {
        /**
         * 年度
         */
        RDate 年度 = new RDate(DbBusinessConfig.get(ConfigNameDBB.日付関連_所得年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課).toString());
        div.getTxtNendo().setValue(年度);
        /**
         *処理状態
         */
        RString 年次負担割合処理済年度 = DbBusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年次負担割合処理済年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        if(年度.equals(年次負担割合処理済年度)){
           if(ONE.equals(DbBusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年次負担割合処理状態, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課))){
                div.getTxtShoriJotai().setValue(処理済);
           }
           if(TWO.equals(DbBusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年次負担割合処理状態, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課))){
                div.getTxtShoriJotai().setValue(再処理前);
           }
        }else  {
            div.getTxtShoriJotai().setValue(未処理);
        }
        /**
         * 基準日
         */
        RDate 基準日 =new RDate(DbBusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年度終了月日,RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課).toString());       
        基準日=基準日.plusYear(1);
        div.getTxtNendo().setValue(基準日);       
        return ResponseData.of(div).respond();
    }
    /**
     * onClick
     */

     public ResponseData<NenjiRiyoshaFutanwariaiHanteiParameter> onClick_Batch(PanelAllDiv div) {
     
        
         NenjiRiyoshaFutanwariaiHanteiParameter parameter =new NenjiRiyoshaFutanwariaiHanteiParameter();
         RDate 対象年度=div.getTxtNendo().getValue();
         RString 処理状態=div.getTxtShoriJotai().getValue();
         RDate 基準日=div.getTxtKijunbi().getValue();
         基準日=基準日.plusDay(1);
         SaiShoriKubun  処理区分=SaiShoriKubun.toValue(ONE);;
         boolean テストモード=false;
         RString 年=div.getTxtNendo().getValue().plusYear(1).toDateString();
         RString 月日= DbBusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年度終了月日, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
         RString 年度終了年月日=年.concat(月日);
         RDate 処理日時 = RDate.getNowDate();
         
             
         
      if (処理状態.equals(ZERO)) {
            QuestionMessage message = new QuestionMessage(DbQuestionMessages.処理実行の確認.getMessage().getCode(),
                    DbQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(parameter).addMessage(message).respond();
        }
        if (処理状態.equals(TWO)){
             QuestionMessage message = new QuestionMessage(DbcQuestionMessages.年次負担割合再処理.getMessage().getCode(),
                    DbcQuestionMessages.年次負担割合再処理.getMessage().evaluate());
            return ResponseData.of(parameter).addMessage(message).respond();
           
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
           QuestionMessage message = new QuestionMessage(DbQuestionMessages.処理実行の確認.getMessage().getCode(),
                    DbQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(parameter).addMessage(message).respond();
        }

       
         
         return ResponseData.of(parameter).respond();
    }
   
}
