/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0900011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900011.SinsaSeikyusyoPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900011.grdSinsaSeikyusyoJoho_Row;
import jp.co.ndensan.reams.db.dbz.business.core.basic.FufukuMoshitate;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.ShobunShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 審査請求書登録_一覧情報の取得処理。
 */
public class SinsaSeikyusyoJohoHandler {

    private final SinsaSeikyusyoPanelDiv sinsadiv;
    private static final RString 状態_照会 = new RString("照会");
    private static final RString 状態_更新 = new RString("更新");

    /**
     * コンストラクタです。
     *
     * @param sinsadiv SinsaSeikyusyoPanelDiv
     */
    public SinsaSeikyusyoJohoHandler(SinsaSeikyusyoPanelDiv sinsadiv) {
        this.sinsadiv = sinsadiv;
    }

    /**
     * onLoad処理です。
     *
     * @param sinsaSeikyusyoJohoList 審査請求書登録明細情報
     */
    public void onLoad(List<FufukuMoshitate> sinsaSeikyusyoJohoList) {

        if (状態_照会.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            List<grdSinsaSeikyusyoJoho_Row> grdSinsaSeiList = new ArrayList<>();
            if (sinsaSeikyusyoJohoList != null && !sinsaSeikyusyoJohoList.isEmpty()) {
                for (FufukuMoshitate jigyoshaInput : sinsaSeikyusyoJohoList) {
                    grdSinsaSeikyusyoJoho_Row dgJigyoshaItiran = new grdSinsaSeikyusyoJoho_Row();
                    dgJigyoshaItiran.getTxtShinsaSeikyuTodokeYMD().setValue(new RDate(jigyoshaInput.get審査請求届出日().toString()));
                    dgJigyoshaItiran.setTxtShinsaSeikyuJinName(jigyoshaInput.get審査請求人氏名() == null ? RString.EMPTY : jigyoshaInput.get審査請求人氏名().value());
                    dgJigyoshaItiran.setTxtShobunNaiyo(jigyoshaInput.get処分種類コード() == null
                            ? RString.EMPTY : ShobunShuruiCode.toValue(jigyoshaInput.get処分種類コード()).get名称());
                    dgJigyoshaItiran.getTxtShobunShitaYMD().setValue(new RDate(jigyoshaInput.get処分があったことを知った日().toString()));
                    dgJigyoshaItiran.getTxtBenmeishoSakuseiYMD().setValue(new RDate(jigyoshaInput.get弁明書作成日().toString()));
                    dgJigyoshaItiran.setTxtSaiketsuKekka(nullToEmpty(jigyoshaInput.get裁決結果()));
                    dgJigyoshaItiran.getTxtShinsaSeikyuToriageYMD().setValue(new RDate(jigyoshaInput.get審査請求取下日().toString()));
                    grdSinsaSeiList.add(dgJigyoshaItiran);
                }
            }
            sinsadiv.getGrdSinsaSeikyusyoJoho().setDataSource(grdSinsaSeiList);
            sinsadiv.getSinsaSeikyusyoJohoPane1().getBtnTuika().setVisible(false);
            sinsadiv.getGrdSinsaSeikyusyoJoho().getGridSetting().setIsShowModifyButtonColumn(false);
            sinsadiv.getGrdSinsaSeikyusyoJoho().getGridSetting().setIsShowDeleteButtonColumn(false);
        }
        if (状態_更新.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            List<grdSinsaSeikyusyoJoho_Row> grdSinsaSeiList = new ArrayList<>();
            if (sinsaSeikyusyoJohoList != null && !sinsaSeikyusyoJohoList.isEmpty()) {
                for (FufukuMoshitate jigyoshaInput : sinsaSeikyusyoJohoList) {
                    grdSinsaSeikyusyoJoho_Row dgJigyoshaItiran = new grdSinsaSeikyusyoJoho_Row();
                    dgJigyoshaItiran.getTxtShinsaSeikyuTodokeYMD().setValue(new RDate(jigyoshaInput.get審査請求届出日().toString()));
                    dgJigyoshaItiran.setTxtShinsaSeikyuJinName(jigyoshaInput.get審査請求人氏名() == null ? RString.EMPTY : jigyoshaInput.get審査請求人氏名().value());
                    dgJigyoshaItiran.setTxtShobunNaiyo(jigyoshaInput.get処分種類コード() == null
                            ? RString.EMPTY : ShobunShuruiCode.toValue(jigyoshaInput.get処分種類コード()).get名称());
                    dgJigyoshaItiran.getTxtShobunShitaYMD().setValue(new RDate(jigyoshaInput.get処分があったことを知った日().toString()));
                    dgJigyoshaItiran.getTxtBenmeishoSakuseiYMD().setValue(new RDate(jigyoshaInput.get弁明書作成日().toString()));
                    dgJigyoshaItiran.setTxtSaiketsuKekka(nullToEmpty(jigyoshaInput.get裁決結果()));
                    dgJigyoshaItiran.getTxtShinsaSeikyuToriageYMD().setValue(new RDate(jigyoshaInput.get審査請求取下日().toString()));
                    grdSinsaSeiList.add(dgJigyoshaItiran);
                }
            }
            sinsadiv.getGrdSinsaSeikyusyoJoho().setDataSource(grdSinsaSeiList);
        }
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }
}
