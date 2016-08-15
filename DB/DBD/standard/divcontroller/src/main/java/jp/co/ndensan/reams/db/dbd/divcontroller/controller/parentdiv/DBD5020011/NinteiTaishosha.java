/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5020011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigoninteiinterface.YokaigoNinteiInterface;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020011.DBD5020011StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020011.DBD5020011TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020011.NinteiTaishoshaDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020011.dgNinteiTaishosha_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5020011.YokaigoNinteiTaishoshaListHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 要介護認定処理対象者一覧画面のDivControllerです。
 *
 * @reamsid_L DBD-1531-010 chenxin
 */
public class NinteiTaishosha {

    private LockingKey 排他キー;

    /**
     * 画面初期化
     *
     * @param div NinteiTaishoshaDiv
     * @return ResponseData
     */
    public ResponseData<NinteiTaishoshaDiv> onLoad(NinteiTaishoshaDiv div) {
        List<dgNinteiTaishosha_Row> ninteiTaishoshalist = getHandler().onLoad();

        ViewStateHolder.put(ViewStateKeys.申請書管理番号リスト, getHandler().get要介護認定インターフェース情報(ninteiTaishoshalist));

        if (ninteiTaishoshalist.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }

        div.getTxtGaitosha().setValue(new RString(ninteiTaishoshalist.size()));
        div.getDgNinteiTaishosha().setDataSource(ninteiTaishoshalist);
        //TODO アクセスログを出力する。
//        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY,
//                new ExpandedInformation(new Code("0003"),
//                        new RString("被保番号"),
//                        div.getDgNinteiTaishosha().getActiveRow().get被保険者番号()));
//        AccessLogger.log(AccessLogType.照会, personalData);
        return ResponseData.of(div).setState(DBD5020011StateName.初期表示);
    }

    /**
     * 検索結果一覧選択
     *
     * @param div NinteiTaishoshaDiv
     * @return ResponseData
     */
    public ResponseData<NinteiTaishoshaDiv> onSelectBySelectButton(NinteiTaishoshaDiv div) {
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, div.getDgNinteiTaishosha().getActiveRow().get更新key());
        ViewStateHolder.put(ViewStateKeys.被保険者番号, div.getDgNinteiTaishosha().getActiveRow().get被保険者番号());

        if (div.getDgNinteiTaishosha().getActiveRow().get申請法().equals(new RString("新規申請"))
                || div.getDgNinteiTaishosha().getActiveRow().get申請法().equals(new RString("更新申請"))) {
            return ResponseData.of(div).forwardWithEventName(DBD5020011TransitionEventName.新規更新選択).respond();
        } else {
            return ResponseData.of(div).forwardWithEventName(DBD5020011TransitionEventName.区変選択).respond();
        }
    }

    /**
     * 検索結果一覧消込
     *
     * @param div NinteiTaishoshaDiv
     * @return ResponseData
     */
    public ResponseData<NinteiTaishoshaDiv> onClick_btnKeshikomi(NinteiTaishoshaDiv div) {
        排他キー = new LockingKey(new RString("DBEShinseishoKanriNo").concat(div.getDgNinteiTaishosha().getActiveRow().get更新key()));
        RealInitialLocker.lock(排他キー);
        RString 申請書管理番号 = div.getDgNinteiTaishosha().getActiveRow().get更新key();
        ArrayList<YokaigoNinteiInterface> yokaigoNinteiInterfaceList = ViewStateHolder.get(ViewStateKeys.申請書管理番号リスト, ArrayList.class);
        getHandler().save消込(申請書管理番号, yokaigoNinteiInterfaceList);
        RealInitialLocker.release(排他キー);
        return ResponseData.of(div).setState(DBD5020011StateName.初期表示);
    }

    private YokaigoNinteiTaishoshaListHandler getHandler() {
        return new YokaigoNinteiTaishoshaListHandler();
    }
}
