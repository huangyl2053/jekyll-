/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1040001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuChiikiKasanGemmenViewState;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040001.TokuteiNyushoServiceHiShinseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040001.dgShinseiList_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.futanwariai.FutanwariaiKubun;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 画面設計_DBDGM21005_1_特別地域加算減免申請のハンドラークラスです。
 *
 * @reamsid_L DBD-3680-010 miaojin
 */
public class TokuteiNyushoServiceHiShinseiHandler {

    private final TokuteiNyushoServiceHiShinseiDiv div;
    private final RString 申請メニュー = new RString("DBDMN21005");
    private final RString 承認メニュー = new RString("DBDMN22005");
    private final RString 申請メニュー_タイトル = new RString("特別地域加算減免申請");
    private final RString 承認メニュー_タイトル = new RString("特別地域加算減免申請承認");
    private static final RString 申請情報を追加する = new RString("申請情報を追加する");
    private static final RString 承認情報を追加する = new RString("承認情報を追加する");
    private static final RString 申請情報 = new RString("申請情報");
    private static final RString 承認情報 = new RString("承認情報");
    private static final RString BTNUPDATE_FIELDNAME = new RString("btnUpdate");
    private static final RString 申請情報を = new RString("申請情報を");
    private static final RString 承認情報を = new RString("承認情報を");

    /**
     * コンストラクタです。
     *
     * @param div 特別地域加算減免申請のコントロールdiv
     */
    public TokuteiNyushoServiceHiShinseiHandler(TokuteiNyushoServiceHiShinseiDiv div) {
        this.div = div;
    }

    /**
     * 初期化の処理です。
     *
     * @param taishoshaKey 前画面から渡された「対象者キー」
     */
    public void initialize(TaishoshaKey taishoshaKey) {
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        div.getCcdAtenaInfo().initialize(識別コード);
        div.getCcdShinseiJoho().initialize(識別コード);
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            div.getCcdKaigoKihon().initialize(被保険者番号);
        }
        if (ResponseHolder.getMenuID().equals(申請メニュー)) {
            ResponseData.of(div).rootTitle(申請メニュー_タイトル);
            div.getShinsei().getShinseiList().getBtnAddShinsei().setText(申請情報を追加する);
            div.getShinseiDetail().setTitle(申請情報);
            CommonButtonHolder.setAdditionalTextByCommonButtonFieldName(BTNUPDATE_FIELDNAME, 申請情報を.toString());
            div.getShinsei().getShinseiDetail().setDisabled(true);
        } else if (ResponseHolder.getMenuID().equals(承認メニュー)) {
            ResponseData.of(div).rootTitle(承認メニュー_タイトル);
            div.getShinsei().getShinseiList().getBtnAddShinsei().setText(承認情報を追加する);
            div.getShinseiDetail().setTitle(承認情報);
            CommonButtonHolder.setAdditionalTextByCommonButtonFieldName(BTNUPDATE_FIELDNAME, 承認情報を.toString());
            div.getShinsei().getShinseiDetail().setDisabled(true);
        }
    }

    /**
     * 一覧エリアの初期設定です。
     *
     * @param 特別地域加算減免申請の情報List 特別地域加算減免申請の情報List
     * @param viewStateList 特別地域加算減免申請の情報のViewStateリスト
     */
    public void 申請一覧エリアの初期設定(List<TokubetsuchiikiKasanGemmen> 特別地域加算減免申請の情報List, ArrayList<TokubetsuChiikiKasanGemmenViewState> viewStateList) {
        List<dgShinseiList_Row> rowlist = new ArrayList<>();
        for (TokubetsuchiikiKasanGemmen 特別地域加算減免申請情報 : 特別地域加算減免申請の情報List) {
            dgShinseiList_Row row = new dgShinseiList_Row();
            row.getTxtShinseiYMD().setValue(特別地域加算減免申請情報.get申請年月日());
            row.setShinseiRiyu(特別地域加算減免申請情報.get申請事由());
            row.setKetteiKubun(特別地域加算減免申請情報.get決定区分());
            row.getTxtKetteiYMD().setValue(特別地域加算減免申請情報.get決定年月日());
            row.getTxtTekiyoYMD().setValue(特別地域加算減免申請情報.get適用開始年月日());
            row.getTxtYukoKigenYMD().setValue(特別地域加算減免申請情報.get適用終了年月日());
            if (特別地域加算減免申請情報.get減額率() != null) {
                row.setKeigenritsu(new RString(特別地域加算減免申請情報.get減額率().value().toString()));
            }
            rowlist.add(row);
            viewStateList.add(new TokubetsuChiikiKasanGemmenViewState(特別地域加算減免申請情報, EntityDataState.Unchanged, 特別地域加算減免申請情報.get履歴番号()));
        }
        div.getShinsei().getShinseiList().getDgShinseiList().setDataSource(rowlist);
    }

    /**
     * 一覧エリアの初期設定です。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void 前排他の設定(HihokenshaNo 被保険者番号) {
        LockingKey 排他キー = new LockingKey(GyomuCode.DB介護保険.getColumnValue()
                .concat(被保険者番号.getColumnValue()).concat(new RString("TokuchiGemmen")));
        RealInitialLocker.lock(排他キー);
    }
}
