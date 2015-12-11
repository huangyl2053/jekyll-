/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.SinsaSeikyusyoJohoModel;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.ShobunShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査請求書登録_一覧情報の取得処理。
 */
public class SinsaSeikyusyoJohoHandler {
    
    private final SinsaSeikyusyoPanelDiv sinsadiv;
    
     /**
     * コンストラクタです。
     *
     * @param sinsadiv
     */
    public SinsaSeikyusyoJohoHandler(SinsaSeikyusyoPanelDiv sinsadiv) {
        this.sinsadiv = sinsadiv;
    }
    
        /**
     * onLoad処理です。
     *
     * @param sinsaSeikyusyoJohoList
     */
    public void onLoad(List<SinsaSeikyusyoJohoModel> sinsaSeikyusyoJohoList) {
            
            List<grdSinsaSeikyusyoJoho_Row> dgKoufuKaishuList = new ArrayList();
                    for (SinsaSeikyusyoJohoModel jigyoshaInput : sinsaSeikyusyoJohoList) {
                    grdSinsaSeikyusyoJoho_Row dgJigyoshaItiran = new grdSinsaSeikyusyoJoho_Row();
                    dgJigyoshaItiran.getTxtShinsaSeikyuTodokeYMD().setValue(new RDate(jigyoshaInput.get審査請求届出日().toString()));
                    dgJigyoshaItiran.setTxtShinsaSeikyuJinName(new RString(jigyoshaInput.get審査請求人氏名().toString()));
                    // TODO 審査請求に係る処分 DBZのEnum.処分種類コードより、処分種類名称を取得して、表示する
                    dgJigyoshaItiran.setTxtShobunNaiyo(ShobunShuruiCode.toValue(jigyoshaInput.get処分種類コード()).get名称());
                    dgJigyoshaItiran.getTxtShobunShitaYMD().setValue(new RDate(jigyoshaInput.get処分があったことを知った日().toString()));
                    dgJigyoshaItiran.getTxtBenmeishoSakuseiYMD().setValue(new RDate(jigyoshaInput.get弁明書作成日().toString()));
                    dgJigyoshaItiran.setTxtSaiketsuKekka(jigyoshaInput.get裁決結果());
                    dgJigyoshaItiran.getTxtShinsaSeikyuToriageYMD().setValue(new RDate(jigyoshaInput.get審査請求取下日().toString()));
                    dgKoufuKaishuList.add(dgJigyoshaItiran);
                }
                sinsadiv.getGrdSinsaSeikyusyoJoho().setDataSource(dgKoufuKaishuList);
    }
}
