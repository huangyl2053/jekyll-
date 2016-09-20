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
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShobunShuruiCode;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 審査請求書登録_一覧情報の取得処理。
 *
 * @reamsid_L DBU-1080-050 lizhuoxuan
 */
public class SinsaSeikyusyoJohoHandler {

    private final SinsaSeikyusyoPanelDiv sinsadiv;
    private static final RString 発行ボタン = new RString("btnReportPublish");
    private static final RString 審査請求書登録 = new RString("DBUMN71001");
    private static final RString 弁明登録 = new RString("DBUMN71002");

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
        sinsadiv.getGrdSinsaSeikyusyoJoho().setDataSource(setDataSourcre(sinsaSeikyusyoJohoList));
        if (UrControlDataFactory.createInstance().getMenuID().equals(審査請求書登録)) {
            sinsadiv.getSinsaSeikyusyoJohoPane1().getBtnTuika().setVisible(true);
        } else {
            sinsadiv.getSinsaSeikyusyoJohoPane1().getBtnTuika().setVisible(false);
        }
        if (UrControlDataFactory.createInstance().getMenuID().equals(弁明登録)) {
            CommonButtonHolder.setVisibleByCommonButtonFieldName(発行ボタン, true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(発行ボタン, true);
        } else {
            CommonButtonHolder.setVisibleByCommonButtonFieldName(発行ボタン, false);
        }
    }
    
    /**
     * onActive処理です。
     *
     * @param sinsaSeikyusyoJohoList 審査請求書登録明細情報
     */
    public void onActive(List<FufukuMoshitate> sinsaSeikyusyoJohoList) {
        this.onLoad(sinsaSeikyusyoJohoList);
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }

    private List<grdSinsaSeikyusyoJoho_Row> setDataSourcre(List<FufukuMoshitate> sinsaSeikyusyoJohoList) {
        List<grdSinsaSeikyusyoJoho_Row> grdSinsaSeiList = new ArrayList<>();
        for (FufukuMoshitate jigyoshaInput : sinsaSeikyusyoJohoList) {
            grdSinsaSeikyusyoJoho_Row dgJigyoshaItiran = new grdSinsaSeikyusyoJoho_Row();
            dgJigyoshaItiran.getTxtShinsaSeikyuTodokeYMD().setValue(new RDate(jigyoshaInput.get審査請求届出日().toString()));
            dgJigyoshaItiran.setTxtShinsaSeikyuJinName(jigyoshaInput.get審査請求人氏名() == null ? RString.EMPTY : jigyoshaInput.get審査請求人氏名().value());
            dgJigyoshaItiran.setTxtShobunNaiyo(RString.isNullOrEmpty(jigyoshaInput.get処分種類コード())
                    ? RString.EMPTY : ShobunShuruiCode.toValue(jigyoshaInput.get処分種類コード()).get名称());
            if (jigyoshaInput.get処分があったことを知った日() != null && !jigyoshaInput.get処分があったことを知った日().isEmpty()) {
                dgJigyoshaItiran.getTxtShobunShitaYMD().setValue(new RDate(jigyoshaInput.get処分があったことを知った日().toString()));
            }
            if (jigyoshaInput.get弁明書作成日() != null && !jigyoshaInput.get弁明書作成日().isEmpty()) {
                dgJigyoshaItiran.getTxtBenmeishoSakuseiYMD().setValue(new RDate(jigyoshaInput.get弁明書作成日().toString()));
            }
            dgJigyoshaItiran.setTxtSaiketsuKekka(nullToEmpty(jigyoshaInput.get裁決結果()));
            if (jigyoshaInput.get審査請求取下日() != null && !jigyoshaInput.get審査請求取下日().isEmpty()) {
                dgJigyoshaItiran.getTxtShinsaSeikyuToriageYMD().setValue(new RDate(jigyoshaInput.get審査請求取下日().toString()));
            }
            grdSinsaSeiList.add(dgJigyoshaItiran);
        }
        return grdSinsaSeiList;
    }
}
