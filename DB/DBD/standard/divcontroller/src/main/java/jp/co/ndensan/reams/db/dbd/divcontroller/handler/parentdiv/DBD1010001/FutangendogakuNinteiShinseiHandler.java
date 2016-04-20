/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.ShinseiRiyuKubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001.FutangendogakuShinseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001.dgShinseiList_Row;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.futangendogakunintei.FutangendogakuNinteiService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 負担限度額認定申請画面ハンドラクラスです。
 *
 * @reamsid_L DBD-3590-010 huangh
 */
public class FutangendogakuNinteiShinseiHandler {

    private final FutangendogakuShinseiDiv div;

    private static final RString 申請メニューID = new RString("DBDMN21001");
    private final RString 保存する = new RString("btnUpdate");
    private final RString 申請情報を追加する = new RString("申請情報を追加する");

    /**
     * コンストラクタです。
     *
     * @param div 負担限度額認定申請画面Div
     */
    public FutangendogakuNinteiShinseiHandler(FutangendogakuShinseiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @return 受給共通_被保データなし
     */
    public boolean onLoad() {
        ShikibetsuCode 識別コード = get識別コードFromViewState();
        HihokenshaNo 被保険者番号 = get被保険者番号FromViewState();
        div.getCcdAtenaInfo().onLoad(識別コード);
        div.getCcdKaigoShikakuKihon().onLoad(被保険者番号);
        List<FutanGendogakuNintei> 申請一覧情報 = get申請一覧情報(被保険者番号);
        ArrayList<FutanGendogakuNintei> 申請一覧情報ArrayList = new ArrayList<>(申請一覧情報);
        ViewStateHolder.put(ViewStateKeys.負担限度額認定申請の情報, 申請一覧情報ArrayList);
        RString メニューID = ResponseHolder.getMenuID();
        if (申請メニューID.equals(メニューID)) {
            if (被保険者番号.isEmpty()) {
                div.getBtnDispGemmenJoho().setDisabled(true);
                div.getBtnAddShinsei().setDisabled(true);
                div.getDgShinseiList().setDisabled(true);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, true);
                return false;
            } else {
                div.getBtnAddShinsei().setText(申請情報を追加する);
                List<dgShinseiList_Row> dataSourceList = getDataSource(申請一覧情報);
                div.getDgShinseiList().setDataSource(dataSourceList);
            }
        } else {
        }
        return true;
    }

    private ShikibetsuCode get識別コードFromViewState() {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        if (null == 識別コード) {
            識別コード = ShikibetsuCode.EMPTY;
        }
        return 識別コード;
    }

    private HihokenshaNo get被保険者番号FromViewState() {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        if (null == 被保険者番号) {
            被保険者番号 = HihokenshaNo.EMPTY;
        }
        return 被保険者番号;
    }

    private List<FutanGendogakuNintei> get申請一覧情報(HihokenshaNo 被保険者番号) {
        return FutangendogakuNinteiService.createInstance().load負担限度額認定申請All(被保険者番号);
    }

    private List<dgShinseiList_Row> getDataSource(List<FutanGendogakuNintei> 申請一覧情報) {
        List<dgShinseiList_Row> dataSourceList = new ArrayList<>();
        if (申請一覧情報 != null && !申請一覧情報.isEmpty()) {
            for (FutanGendogakuNintei 負担限度額認定申請情報 : 申請一覧情報) {
                dgShinseiList_Row dataSource = new dgShinseiList_Row();
                dataSource.setJotai(RString.EMPTY);
                dataSource.getTxtShinseiYMD().setValue(負担限度額認定申請情報.get申請年月日());
                dataSource.setShinseiRiyu(ShinseiRiyuKubun.toValue(負担限度額認定申請情報.get申請理由区分()).get名称());
                //配偶者課税区分

            }
        }
        return dataSourceList;
    }
}
