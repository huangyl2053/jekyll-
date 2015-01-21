/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.dba2030011;

import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.JushochiTokureiMenuType;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.KihonJohoDiv;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.ResponseDatas;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.model.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.realservice.hihokenshadaicho.HihokenshaDaichoManager;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.realservice.shikibetsutaisho.IKojinFinder;
import jp.co.ndensan.reams.ur.urz.realservice.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 住所地特例画面における、資格基本情報Divのイベントを定義したDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class KihonJoho {

    /**
     * 画面が読み込まれた際に実行します。<br/>
     * 被保険者の基本情報を設定します。
     *
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 基本情報Divを持つResponseData
     */
    public ResponseData<KihonJohoDiv> onload(KihonJohoDiv kihonDiv) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class);
        IUrControlData controlData = UrControlDataFactory.createInstance();

        kihonDiv.getCcdKaigoAtenaInfo().load(taishoshaKey.get識別コード());
        kihonDiv.getCcdKaigoShikakuKihon().load(new LasdecCode(controlData.getDonyuDantaiCode().getColumnValue()), taishoshaKey.get識別コード());

        if (isNot適用対象者(taishoshaKey, controlData)) {
            //TODO n8178 城間篤人 DBAE00004のエラーメッセージを返却するための処理を記述する。
        } else if (isNot住所地特例適用者(taishoshaKey, controlData)) {
            //TODO n8178 城間篤人 DBAE00006のエラーメッセージを返却するための処理を記述する。
        }

        return ResponseDatas.createSettingDataTo(kihonDiv);
    }

    public boolean isNot適用対象者(TaishoshaKey taishoshaKey, IUrControlData controlData) {
        JushochiTokureiMenuType menuType = JushochiTokureiMenuType.toValue(controlData.getMenuID());

        switch (menuType) {
            case DBAMN25001_届出により適用:
            case DBAMN61002_転入転出保留対象者管理:
                break;
            default:
                return false;
        }

        IKojinFinder kojinFinder = ShikibetsuTaishoService.getKojinFinder();
        IKojin kojin = kojinFinder.get個人(controlData.getGyomuCD(), taishoshaKey.get識別コード());
        switch (kojin.get住民状態()) {
            case 転出者:
            case 消除者:
            case 住登外:
                return true;
            default:
                return false;
        }
    }

    public boolean isNot住所地特例適用者(TaishoshaKey taishoshaKey, IUrControlData controlData) {
        JushochiTokureiMenuType menuType = JushochiTokureiMenuType.toValue(controlData.getMenuID());

        switch (menuType) {
            case DBAMN25002_届出により解除:
            case DBAMN25003_届出により施設変更:
            case DBAMN52002_合併前の住所地特例措置解除:
                break;
            default:
                return false;
        }

        HihokenshaDaichoManager daichoManager = new HihokenshaDaichoManager();
        Optional<HihokenshaDaichoModel> daicho = daichoManager.
                get最新被保険者台帳(new LasdecCode(controlData.getDonyuDantaiCode().getColumnValue()), taishoshaKey.get識別コード());

        return is住所地特例未適用(daicho.get()) || is住所地特例解除済み(daicho.get());
    }

    private boolean is住所地特例未適用(HihokenshaDaichoModel daicho) {
        return daicho.get住所地特例適用事由() == null
                || daicho.get適用届出年月日() == null
                || daicho.get適用年月日() == null;
    }

    private boolean is住所地特例解除済み(HihokenshaDaichoModel daicho) {
        return daicho.get住所地特例解除事由() != null
                || daicho.get解除届出年月日() != null
                || daicho.get解除年月日() != null;
    }

}
