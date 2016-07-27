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
    private static final RString 照会 = new RString("照会");
    private static final RString 修正 = new RString("修正");
    private static final RString 共通ボタン = new RString("Element2");

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
     * @param 画面モード　画面モード
     */
    public void onLoad(List<FufukuMoshitate> sinsaSeikyusyoJohoList, RString 画面モード) {
        if (照会.equals(画面モード)) {
            sinsadiv.getGrdSinsaSeikyusyoJoho().setDataSource(setDataSourcre(sinsaSeikyusyoJohoList));
            sinsadiv.getSinsaSeikyusyoJohoPane1().getBtnTuika().setVisible(false);
            sinsadiv.getGrdSinsaSeikyusyoJoho().getGridSetting().setIsShowModifyButtonColumn(false);
            sinsadiv.getGrdSinsaSeikyusyoJoho().getGridSetting().setIsShowDeleteButtonColumn(false);
        }
        if (修正.equals(画面モード)) {
            sinsadiv.getGrdSinsaSeikyusyoJoho().setDataSource(setDataSourcre(sinsaSeikyusyoJohoList));
            if (UrControlDataFactory.createInstance().getMenuID().equals(new RString("DBUMN71001"))) {
                sinsadiv.getSinsaSeikyusyoJohoPane1().getBtnTuika().setVisible(true);
            } else {
                sinsadiv.getSinsaSeikyusyoJohoPane1().getBtnTuika().setVisible(false);
            }
        }
        if (UrControlDataFactory.createInstance().getMenuID().equals(new RString("DBUMN71002"))) {
            CommonButtonHolder.setVisibleByCommonButtonFieldName(共通ボタン, true);
        } else {
            CommonButtonHolder.setVisibleByCommonButtonFieldName(共通ボタン, false);
        }
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
            dgJigyoshaItiran.setTxtShobunNaiyo(jigyoshaInput.get処分種類コード() == null
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
