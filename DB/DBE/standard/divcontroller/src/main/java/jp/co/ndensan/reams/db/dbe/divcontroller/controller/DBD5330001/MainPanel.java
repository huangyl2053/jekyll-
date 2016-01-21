/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.DBD5330001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChi;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe090001.YouKaiGoNinTeiKekTesuChiFlowParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChiMapperParameter;
import static jp.co.ndensan.reams.db.dbe.divcontroller.controller.DBD5330001.MainPanelHandler.対象申請者一覧;
import static jp.co.ndensan.reams.db.dbe.divcontroller.controller.DBD5330001.MainPanelHandler.希望のみ;
import static jp.co.ndensan.reams.db.dbe.divcontroller.controller.DBD5330001.MainPanelHandler.未出力のみ;
import static jp.co.ndensan.reams.db.dbe.divcontroller.controller.DBD5330001.MainPanelHandler.未出力のみフラグ;
import static jp.co.ndensan.reams.db.dbe.divcontroller.controller.DBD5330001.MainPanelHandler.未出力のみ以外;
import static jp.co.ndensan.reams.db.dbe.divcontroller.controller.DBD5330001.MainPanelHandler.申請者;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBD5330001.MainPanelDiv;
import jp.co.ndensan.reams.db.dbe.service.core.basic.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChiFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 要介護認定結果通知（主治医）Divを制御クラスです。
 *
 */
public class MainPanel {

    /**
     * 要介護認定結果通知（主治医）の初期処理を表示します。
     *
     * @param div MainPanelDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onLoad(MainPanelDiv div) {
        div.getCcdShujiiIryokikanAndShujiiInput().setReadOnly(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 要介護認定結果通知（主治医）の「検索」ボタンが押下します。
     *
     * @param div MainPanelDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onClick_btnSearch(MainPanelDiv div) {
        getHandler(div).二次判定期間の前後順チェック();
        boolean 未出力のみフラグ = false;
        boolean 希望のみフラグ = false;
        RString dateFrom = RString.EMPTY;
        RString dateTo = RString.EMPTY;  
        if (未出力のみ.equals(div.getRadPrintCondition().getSelectedKey())) {
            未出力のみフラグ = true;
        }
        if (希望のみ.equals(div.getRadPrintCondition().getSelectedKey())) {
            希望のみフラグ = true;
        }
        if (div.getTxtNijiHanteiKikan().getFromValue() != null) {
            dateFrom = div.getTxtNijiHanteiKikan().getFromValue().toDateString();
        }
        if (div.getTxtNijiHanteiKikan().getToValue() != null) {
            dateTo = div.getTxtNijiHanteiKikan().getToValue().toDateString();
        }
        
        // TODO 主治医医療機関コードと主治医コード　QA421を待ち
        List<YouKaiGoNinTeiKekTesuChi> youKaiGoNinTeiKekTesuChiBusiness = YouKaiGoNinTeiKekTesuChiFinder.createInstance()
                .get主治医選択一覧(YouKaiGoNinTeiKekTesuChiMapperParameter
                .createSelectListParam(dateFrom,
                        dateTo,
                        RString.EMPTY, RString.EMPTY, 未出力のみフラグ, 希望のみフラグ)).records();

        getHandler(div).edit主治医選択一覧情報(youKaiGoNinTeiKekTesuChiBusiness);
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医選択一覧の「選択」ボタンが押下します。
     *
     * @param div MainPanelDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onClick_SelectByButton(MainPanelDiv div) {
        boolean 未出力のみフラグ = false;
        boolean 希望のみフラグ = false;
        if (未出力のみ.equals(div.getRadPrintCondition().getSelectedKey())) {
            未出力のみフラグ = true;
        }
        if (希望のみ.equals(div.getRadPrintCondition().getSelectedKey())) {
            希望のみフラグ = true;
        }
        RString dateFrom = RString.EMPTY;
        RString dateTo = RString.EMPTY;
        if (div.getTxtNijiHanteiKikan().getFromValue() != null) {
            dateFrom = div.getTxtNijiHanteiKikan().getFromValue().toDateString();
        }
        if (div.getTxtNijiHanteiKikan().getToValue() != null) {
            dateTo = div.getTxtNijiHanteiKikan().getToValue().toDateString();
        }
        RString 主治医医療機関コード = div.getDgDoctorSelection().getActiveRow().getShujiiIryokikanCode();
        RString 主治医コード = div.getDgDoctorSelection().getActiveRow().getDoctorCode();
        List<YouKaiGoNinTeiKekTesuChi> youKaiGoNinTeiKekTesuChiBusiness = YouKaiGoNinTeiKekTesuChiFinder.createInstance()
                .get結果通知出力対象申請者一覧(YouKaiGoNinTeiKekTesuChiMapperParameter
                        .createSelectListParam(dateFrom, 
                                dateTo, 
                                主治医医療機関コード, 主治医コード, 未出力のみフラグ, 希望のみフラグ)).records();

        getHandler(div).edit結果通知出力対象申請者一覧情報(youKaiGoNinTeiKekTesuChiBusiness);
        return ResponseData.of(div).respond();
    }
    
    /**
     *「結果通知を実行する」ボタンが押下します。
     *
     * @param div MainPanelDiv
     * @return ResponseData
     */
    public ResponseData<YouKaiGoNinTeiKekTesuChiFlowParameter> onClick_btnBatchRegister(MainPanelDiv div) {
        
        ResponseData<YouKaiGoNinTeiKekTesuChiFlowParameter>  response = new ResponseData<>();
        if (div.getDgResultList().getDataSource().isEmpty()) {
        throw new ApplicationException(UrErrorMessages.対象データなし.getMessage().replace(
                        対象申請者一覧.toString()));
        }
        if (div.getDgResultList().getSelectedItems().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.選択されていない.getMessage().replace(
                        申請者.toString()));
        }
        YouKaiGoNinTeiKekTesuChiFlowParameter param = new YouKaiGoNinTeiKekTesuChiFlowParameter();
        param.setNijiHanteiYMDFrom(div.getTxtNijiHanteiKikan().getFromValue() == null 
                ? RString.EMPTY : div.getTxtNijiHanteiKikan().getFromValue().toDateString());
        param.setNijiHanteiYMDTo(div.getTxtNijiHanteiKikan().getToValue() == null 
                ? RString.EMPTY : div.getTxtNijiHanteiKikan().getToValue().toDateString());
        param.setMaDaNyuRyoKu(未出力のみ以外);
        if (未出力のみ.equals(div.getRadPrintCondition().getSelectedKey())) {
            param.setMaDaNyuRyoKu(未出力のみフラグ);
        }
        RStringBuilder builder = new RStringBuilder(div.getDgDoctorSelection().getActiveRow().getShujiiIryokikanCode());
        builder.append(div.getDgDoctorSelection().getActiveRow().getDoctorCode());
        param.setShuJiiJyouHou(builder.toRString());
        param.setNinteiJohoTeikyoYMD(div.getTxtNinteiJokyoTeikyoYMD().getValue().toDateString());
        param.setShinseishoKanriNo(div.getDgDoctorSelection().getActiveRow().getShinseishoKanriNo());
        // QA 326 支所コード  市町村セキュリティより取得した「証記載保険者番号」
        param.setShishoCode(RString.EMPTY);
        param.setShoKisaiHokenshaNo(new RString("209006"));
        response.data = param;
        return response;
    }
    

    private MainPanelHandler getHandler(MainPanelDiv div) {
        return new MainPanelHandler(div);
    }
}
