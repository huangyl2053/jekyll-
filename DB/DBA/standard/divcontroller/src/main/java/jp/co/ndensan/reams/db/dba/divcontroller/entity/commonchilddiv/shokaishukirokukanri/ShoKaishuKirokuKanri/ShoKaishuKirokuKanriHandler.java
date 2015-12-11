/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.shokaishukirokukanri.ShoKaishuKirokuKanri;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.ShoKofuKaishuJohoModel;
import jp.co.ndensan.reams.db.dba.service.core.shoKofuKaishuJoho.ShoKofuKaishuJohoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 *
 * 証交付回収情報の取得するクラスです。
 */
public class ShoKaishuKirokuKanriHandler {

    private final ShoKaishuKirokuKanriDiv div;
    private boolean False;

    /**
     * コンストラクタです。
     *
     * @param div 証交付回収情報パネル
     */
    public ShoKaishuKirokuKanriHandler(ShoKaishuKirokuKanriDiv div) {
        this.div = div;
    }

    /**
     * 対象事業者を検索する。
     *
     * @param 状態
     * @param 被保険者番号
     */
    public void initialize(RString 状態,RString 被保険者番号) {

        if (new RString("照会").equals(状態)) {
            //div.setMode_ModeA(ShoKaishuKirokuKanriDiv.ModeA.SyoKai);
            List<ShoKofuKaishuJohoModel> shokofukaishujoho = ShoKofuKaishuJohoFinder.createInstance().getShoKofuKaishuJohoList(new HihokenshaNo(被保険者番号), False);
            List<dgKoufuKaishu_Row> dgKoufuKaishuList = new ArrayList();
            if (shokofukaishujoho != null && !shokofukaishujoho.isEmpty()) {

                for (ShoKofuKaishuJohoModel jigyoshaInput : shokofukaishujoho) {
                    dgKoufuKaishu_Row dgJigyoshaItiran = new dgKoufuKaishu_Row();
                    // TODO 李卓軒 コードマスタ取得の方法が不明
                    dgJigyoshaItiran.setKoufuType(CodeMaster.getCodeMeisho(new CodeShubetsu("0014"), new Code(jigyoshaInput.get交付証種類コード())));
                    dgJigyoshaItiran.getKoufuDate().setValue(new RDate(jigyoshaInput.get交付年月日().toString()));
                    // TODO 李卓軒 コードマスタ取得の方法が不明
                    dgJigyoshaItiran.setKoufuJiyu(CodeMaster.getCodeMeisho(new CodeShubetsu("0116"), new Code(jigyoshaInput.get交付事由コード())));
                    dgJigyoshaItiran.setKofuRiyu(jigyoshaInput.get交付理由());
                    dgJigyoshaItiran.getKaishuDate().setValue(new RDate(jigyoshaInput.get回収年月日().toString()));
                    // TODO 李卓軒 コードマスタ取得の方法が不明
                    dgJigyoshaItiran.setKaishuJiyu(CodeMaster.getCodeMeisho(new CodeShubetsu("0015"), new Code(jigyoshaInput.get回収事由コード())));
                    dgJigyoshaItiran.setYukoKigen(new RString(jigyoshaInput.get有効期限().toString()));
                    dgJigyoshaItiran.setKaishuRiyu(jigyoshaInput.get回収理由());
                    dgKoufuKaishuList.add(dgJigyoshaItiran);
                }
                div.getDgKoufuKaishu().setDataSource(dgKoufuKaishuList);
            } 
                    div.getPanelInput().setVisible(False);
                    div.getDgKoufuKaishu().getGridSetting().setIsShowDeleteButtonColumn(False);
                    div.getDgKoufuKaishu().getGridSetting().setIsShowModifyButtonColumn(False);
                    div.getDgKoufuKaishu().getGridSetting().setIsShowRowState(False);
        } else if(new RString("更新").equals(状態)){
//            div.setMode_ModeB(ShoKaishuKirokuKanriDiv.ModeB.Update);
            List<ShoKofuKaishuJohoModel> shokofukaishujoho = ShoKofuKaishuJohoFinder.createInstance().getShoKofuKaishuJohoList(new HihokenshaNo(被保険者番号), False);
            List<dgKoufuKaishu_Row> dgKoufuKaishuList = new ArrayList();
            if (shokofukaishujoho != null && !shokofukaishujoho.isEmpty()) {

                for (ShoKofuKaishuJohoModel jigyoshaInput : shokofukaishujoho) {
                    dgKoufuKaishu_Row dgJigyoshaItiran = new dgKoufuKaishu_Row();
                    // TODO 李卓軒 コードマスタ取得の方法が不明
                    //dgJigyoshaItiran.setKoufuType(CodeMaster.getCodeMeisho(new CodeShubetsu("0014"), new Code(jigyoshaInput.get交付証種類コード())));
                    dgJigyoshaItiran.getKoufuDate().setValue(new RDate(jigyoshaInput.get交付年月日().toString()));
                    // TODO 李卓軒 コードマスタ取得の方法が不明
                    //dgJigyoshaItiran.setKoufuJiyu(CodeMaster.getCodeMeisho(new CodeShubetsu("0116"), new Code(jigyoshaInput.get交付事由コード())));
                    dgJigyoshaItiran.setKofuRiyu(jigyoshaInput.get交付理由());
                    dgJigyoshaItiran.getKaishuDate().setValue(new RDate(jigyoshaInput.get回収年月日().toString()));
                    // TODO 李卓軒 コードマスタ取得の方法が不明
                    //dgJigyoshaItiran.setKaishuJiyu(CodeMaster.getCodeMeisho(new CodeShubetsu("0015"), new Code(jigyoshaInput.get回収事由コード())));
                    dgJigyoshaItiran.setYukoKigen(new RString(jigyoshaInput.get有効期限().toString()));
                    dgJigyoshaItiran.setKaishuRiyu(jigyoshaInput.get回収理由());
                    dgKoufuKaishuList.add(dgJigyoshaItiran);
                }
                div.getDgKoufuKaishu().setDataSource(dgKoufuKaishuList);
            }
            div.getDgKoufuKaishu().getGridSetting().setIsShowSelectButtonColumn(False);
        }
    }
}
