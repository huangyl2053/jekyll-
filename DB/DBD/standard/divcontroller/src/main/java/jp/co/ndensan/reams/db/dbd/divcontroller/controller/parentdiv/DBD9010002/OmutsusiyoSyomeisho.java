/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD9010002;

import jp.co.ndensan.reams.db.dbd.definition.message.DbdQuestionMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010002.DBD9010002StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010002.OmutsusiyoSyomeishoDiv;
import jp.co.ndensan.reams.db.dbd.service.core.iryohikojokakuninsinsei.IryoHiKojoKakuninSinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * おむつ使用証明書画面のDivControllerです。
 *
 * @reamsid_L DBD-5780-010 tz_chengpeng
 */
public class OmutsusiyoSyomeisho {

    private static final RString 医療費控除証明書 = new RString("IryohiKojyoSyomeisho");
    private static final RString DB = new RString("DB");
    private static final RString 帳票分類ID = new RString("帳票分類ID");

    /**
     * 画面初期化
     *
     * @param div OmutsusiyoSyomeishoDiv
     * @return ResponseData<OmutsusiyoSyomeishoDiv>
     */
    public ResponseData<OmutsusiyoSyomeishoDiv> onLoad(OmutsusiyoSyomeishoDiv div) {
        TaishoshaKey 引き継ぎEntity = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        if (引き継ぎEntity.get被保険者番号() == null || 引き継ぎEntity.get被保険者番号().isEmpty()) {
//            return ResponseData.of(div).addMessage(DbcInformationMessage.被保険者でないデータ.getMessage());
//        }
//        RString メニューID = ResponseHolder.getMenuID();
//        RString 被保険者番号 = 引き継ぎEntity.get被保険者番号().value();
//        IryoHiKojoKakuninSinsei iryoHiKojoKakuninSinsei = IryoHiKojoKakuninSinsei.createIntance();
//        if (!iryoHiKojoKakuninSinsei.checkuJukyusha(被保険者番号)) {
//            throw new ApplicationException(DbdErrorMessages.受給共通_受給者登録なし.getMessage());
//        }
//        List<IryoHiKojo> 医療費控除リスト = iryoHiKojoKakuninSinsei.getIryohikojyo_Chohyo(被保険者番号, IryoHiKojoNaiyo.おむつ使用証明書);
//        if (医療費控除リスト.isEmpty()) {
//            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace("おむつ使用証明書"));
//        }
//        ViewStateHolder.put(IryoHiKojoNaiyo.おむつ使用証明書, 医療費控除リスト);
//        div.getPanelKakuninsho().getCcdKaigoAtenaInfo().initialize(引き継ぎEntity.get識別コード());
//        div.getPanelKakuninsho().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        // TODO 1.7 「文書番号入力」共有子Div の初期化
//        RealInitialLocker.lock(new LockingKey(DB.concat(被保険者番号).concat(医療費控除証明書)));
//        AccessLogger.log(AccessLogType.照会, PersonalData.of(引き継ぎEntity.get識別コード(),
//                ExpandedInformation.newBuilder().code(new Code("003")).name(new RString("被保険者番号")).value(被保険者番号).build()));
//         TODO 1.10 年度DDLの選択肢編集
//        List<KeyValueDataSource> 年度DDLデータ = new ArrayList<>();
//        for(IryoHiKojo 医療費控除 : 医療費控除リスト){
//            KeyValueDataSource data = new KeyValueDataSource();
//            data.setKey(医療費控除.get控除対象年());
//            data.setValue(医療費控除.get控除対象年().waki()); // 医療費控除.控除対象年を和暦変換
//
//        }
//        div.getPanelShosaiEria().getDdlTaishonen().setDataSource(年度DDLデータ);
        return ResponseData.of(div).setState(DBD9010002StateName.初期状態);
    }

    /**
     * 対象年DDLonChange
     *
     * @param div OmutsusiyoSyomeishoDiv
     * @return ResponseData<OmutsusiyoSyomeishoDiv>
     */
    public ResponseData<OmutsusiyoSyomeishoDiv> onChange_ddlTaishonen(OmutsusiyoSyomeishoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行」ボタン実行前、確認メッセージの表示
     *
     * @param div OmutsusiyoSyomeishoDiv
     * @return ResponseData<OmutsusiyoSyomeishoDiv>
     */
    public ResponseData<OmutsusiyoSyomeishoDiv> onClick_validate(OmutsusiyoSyomeishoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            RDate 前回発行日 = div.getPanelShosaiEria().getTxtZenkaiHakkouBi().getValue();
            if (前回発行日 == null) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.確認_汎用.getMessage()
                        .replace("「おむつ使用証明書」を発行します。")).respond();
            } else {
                return ResponseData.of(div).addMessage(DbdQuestionMessages.再発行確認.getMessage()
                        .replace("「おむつ使用証明書」")).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).cancelPublish().respond();
    }

    /**
     * 「発行する」ボタンonClick
     *
     * @param div OmutsusiyoSyomeishoDiv
     * @return ResponseData<OmutsusiyoSyomeishoDiv>
     */
    public ResponseData<OmutsusiyoSyomeishoDiv> onClick_btnReportPublish(OmutsusiyoSyomeishoDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード();
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        IryoHiKojoKakuninSinsei.createIntance().editomutsusiyoSyomeisho(識別コード, 帳票分類ID);
        // TODO 4.2　帳票を発行する
        AccessLogger.log(AccessLogType.照会, PersonalData.of(識別コード,
                ExpandedInformation.newBuilder().code(new Code("003")).name(new RString("被保険者番号"))
                .value(被保険者番号).build()));
        // TODO 4.4　医療費控除データの更新を行う
        // TODO 4.5　更新完了メッセージ
        return ResponseData.of(div).setState(DBD9010002StateName.完了状態);
    }

    /**
     * 「再検索する」ボタンonClick
     *
     * @param div OmutsusiyoSyomeishoDiv
     * @return ResponseData<OmutsusiyoSyomeishoDiv>
     */
    public ResponseData<OmutsusiyoSyomeishoDiv> onClick_btnReSearch(OmutsusiyoSyomeishoDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        RealInitialLocker.release(new LockingKey(DB.concat(被保険者番号.value()).concat(医療費控除証明書)));
        return ResponseData.of(div).respond();
    }
}
