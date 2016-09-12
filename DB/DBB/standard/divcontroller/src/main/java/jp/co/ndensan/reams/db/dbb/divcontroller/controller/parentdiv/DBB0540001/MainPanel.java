/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0540001;

import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.choshuhoho.ChoshuHohoResult;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0540001.DBB0540001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0540001.MainPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0540001.MainPanelHandler;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.ChosyuHohoHenko;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 徴収方法変更のクラスです。
 *
 * @reamsid_L DBB-1760-010 sunhui
 */
public class MainPanel {

    private static final RString 処理名 = new RString("徴収方法変更");

    /**
     * 画面初期化
     *
     * @param div MainPanelDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onLoad(MainPanelDiv div) {

        FukaTaishoshaKey 賦課対象者 = ViewStateHolder.get(ViewStateKeys.賦課対象者, FukaTaishoshaKey.class);
        ShikibetsuCode 識別コード = 賦課対象者.get識別コード();
        HihokenshaNo 被保険者番号 = 賦課対象者.get被保険者番号();
        FlexibleYear 賦課年度 = 賦課対象者.get賦課年度();
        KaigoFukaKihonSearchKey key = new KaigoFukaKihonSearchKey.Builder(
                賦課対象者.get通知書番号(), 賦課年度, 賦課対象者.get市町村コード(), 識別コード).build();
        MainPanelHandler handler = new MainPanelHandler(div);
        handler.setヘッダエリア(識別コード, key);
        ChoshuHohoResult serviceResult = ChosyuHohoHenko.createInstance()
                .getChosyuHoho(賦課年度, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.徴収方法データ, serviceResult.getHoho());
        ViewStateHolder.put(ViewStateKeys.特別徴収停止日時, serviceResult.getHoho().get特別徴収停止日時());
        ViewStateHolder.put(ViewStateKeys.特別徴収停止事由コード, serviceResult.getHoho().get特別徴収停止事由コード());
        handler.set世帯所得情報一覧エリア(賦課年度, 被保険者番号, serviceResult);
        AccessLogger.log(AccessLogType.照会, PersonalData.withKojinNo(識別コード));
        return ResponseData.of(div).respond();
    }

    /**
     * 普通徴収に切り替える月DDLはonChange
     *
     * @param div ChoshuInfoDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onChange(MainPanelDiv div) {
        MainPanelHandler handler = new MainPanelHandler(div);
        handler.change普通徴収に切り替える月DDL();
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンを押下
     *
     * @param div ChoshuInfoDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onClick_btnUpdate(MainPanelDiv div) {
        FukaTaishoshaKey 賦課対象者 = ViewStateHolder.get(ViewStateKeys.賦課対象者, FukaTaishoshaKey.class);
        MainPanelHandler handler = new MainPanelHandler(div);
        FlexibleYear 賦課年度 = 賦課対象者.get賦課年度();
        HihokenshaNo 被保険者番号 = 賦課対象者.get被保険者番号();
        try {
            ChoshuHoho 徴収方法データ = ViewStateHolder.
                    get(ViewStateKeys.徴収方法データ, ChoshuHoho.class);
            YMDHMS 停止日時 = ViewStateHolder.get(ViewStateKeys.特別徴収停止日時, YMDHMS.class);
            RString 停止事由コード = ViewStateHolder.get(ViewStateKeys.特別徴収停止事由コード, RString.class);
            handler.saveボタンを押下(賦課年度, 被保険者番号, 徴収方法データ, 停止日時, 停止事由コード);
            div.getKanryoMessage().getCcdKaigoKanryoMessage().setMessage(処理名,
                    賦課対象者.get識別コード().value(),
                    div.getAtenaInfo().getKiagoAtenaInfo().get氏名漢字(), true);
            return ResponseData.of(div).setState(DBB0540001StateName.完了状態);
        } catch (Exception e) {
            div.getKanryoMessage().getCcdKaigoKanryoMessage().setMessage(処理名,
                    賦課対象者.get識別コード().value(),
                    div.getAtenaInfo().getKiagoAtenaInfo().get氏名漢字(), false);
            return ResponseData.of(div).setState(DBB0540001StateName.完了状態);
        }
    }
}
