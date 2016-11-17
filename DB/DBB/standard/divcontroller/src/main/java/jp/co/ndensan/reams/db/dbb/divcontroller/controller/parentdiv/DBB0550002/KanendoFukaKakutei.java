/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0550002;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteiidokanendofukakakutei.KanendoIdoFukaKakutei;
import jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbInformationMessages;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbQuestionMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320005.input.FukaHikakuInput;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550002.DBB0550002TransitionEventName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550002.KanendoFukaKakuteiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550002.dgKanendoFukaIchiran_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0550002.KanendoFukaKakuteiHandler;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidokanendofukakakutei.HonsanteiIdoKanendoFukaKakutei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 本算定異動（過年度）賦課確定（削除込)のクラスです。
 *
 * @reamsid_L DBB-0680-010 wangkanglei
 */
public class KanendoFukaKakutei {

    private static final RString 確定処理 = new RString("btnKakutei");
    private static final RString 賦課対象外を削除 = new RString("btnDeleteTaishoGai");
    private static final RString 過年度異動賦課 = new RString("過年度異動賦課のデータがない");

    /**
     * コントロールdivが「生成」された際の処理です。
     *
     * @param div コントロールdiv
     * @return ResponseData
     */
    public ResponseData<KanendoFukaKakuteiDiv> onLoad(KanendoFukaKakuteiDiv div) {
        HonsanteiIdoKanendoFukaKakutei fukaKakutei = InstanceProvider.create(HonsanteiIdoKanendoFukaKakutei.class);
        RString choteiNendo = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        div.getTxtChoteiNendo().setDomain(new FlexibleYear(choteiNendo.toString()));
        ShoriDateKanri 異動処理日付 = fukaKakutei.getIdoKijunbi(div.getTxtChoteiNendo().getDomain());
        if (異動処理日付 == null) {
            throw new ApplicationException(DbzErrorMessages.理由付き確定不可.getMessage()
                    .replace(過年度異動賦課.toString()));
        } else {
            return initialize(fukaKakutei, div, 異動処理日付);
        }
    }

    /**
     * 画面初期化のメソッドます。
     *
     * @param fukaKakutei HonsanteiIdoKanendoFukaKakutei
     * @param div KanendoFukaKakuteiDiv
     * @param 異動処理日付 ShoriDateKanri
     * @return ResponseData
     */
    private ResponseData<KanendoFukaKakuteiDiv> initialize(HonsanteiIdoKanendoFukaKakutei fukaKakutei,
            KanendoFukaKakuteiDiv div,
            ShoriDateKanri 異動処理日付) {
        ShoriDateKanri 確定処理日付 = fukaKakutei.getKakuteiKijunbi(div.getTxtChoteiNendo().getDomain());
        if (確定処理日付 == null) {
            getKanendoFukaKakuteiHandler(div).setヘッダ(異動処理日付);
        } else if (異動処理日付.get基準日時().isBefore(確定処理日付.get基準日時())) {
            throw new ApplicationException(DbzErrorMessages.理由付き確定不可.getMessage()
                    .replace(過年度異動賦課.toString()));
        } else {
            getKanendoFukaKakuteiHandler(div).setヘッダ(異動処理日付);
        }
        List<KanendoIdoFukaKakutei> 異動賦課対象List = fukaKakutei.getIdoFukaTaisho(異動処理日付.get基準日時());
        if (異動賦課対象List != null && !異動賦課対象List.isEmpty()) {
            getKanendoFukaKakuteiHandler(div).set処理対象(異動賦課対象List.get(0));
            getKanendoFukaKakuteiHandler(div).set過年度異動賦課対象一覧(異動賦課対象List);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(賦課対象外を削除, true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(確定処理, false);
        } else {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbbInformationMessages.確定対象賦課なし.getMessage()).respond();
            }
            CommonButtonHolder.setDisabledByCommonButtonFieldName(賦課対象外を削除, true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(確定処理, true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 確定処理を実行のメソッドます。
     *
     * @param div KanendoFukaKakuteiDiv
     * @return ResponseData<KanendoFukaKakuteiDiv>
     */
    public ResponseData<KanendoFukaKakuteiDiv> onClick_btnKakutei(KanendoFukaKakuteiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbbQuestionMessages.賦課データ確定確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getKanendoFukaKakuteiHandler(div).setKakutei();
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * チェックボックス制御を実行のメソッドます。
     *
     * @param div KanendoFukaKakuteiDiv
     * @return ResponseData<KanendoFukaKakuteiDiv>
     */
    public ResponseData<KanendoFukaKakuteiDiv> onChange_dgKanendoFukaIchiran(KanendoFukaKakuteiDiv div) {
        getKanendoFukaKakuteiHandler(div).onChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択」ボタンを実行のメソッドます。
     *
     * @param div KanendoFukaKakuteiDiv
     * @return ResponseData<KanendoFukaKakuteiDiv>
     */
    public ResponseData<KanendoFukaKakuteiDiv> onClick_dgKanendoFukaIchiran(KanendoFukaKakuteiDiv div) {
        dgKanendoFukaIchiran_Row row = div.getKaNendoIdoFukaIchiran().getDgKanendoFukaIchiran().getClickedItem();
        Optional<FukaShokaiKey> 後履歴 = getKanendoFukaKakuteiHandler(div).get後履歴Key(row);
        Optional<FukaShokaiKey> 前履歴 = getKanendoFukaKakuteiHandler(div).get前履歴Key(row);
        ViewStateHolder.put(ViewStateKeys.賦課比較キー, FukaHikakuInput.createFor前履歴との比較(後履歴.get(), 前履歴.get()));
        return ResponseData.of(div).forwardWithEventName(DBB0550002TransitionEventName.選択).respond();
    }

    /**
     * 賦課対象外の削除を実行のメソッドます。
     *
     * @param div KanendoFukaKakuteiDiv
     * @return ResponseData<KanendoFukaKakuteiDiv>
     */
    public ResponseData<KanendoFukaKakuteiDiv> onClick_btnDeleteTaishoGai(KanendoFukaKakuteiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbbQuestionMessages.賦課データ削除確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getKanendoFukaKakuteiHandler(div).deleteTaishoGai();
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    private KanendoFukaKakuteiHandler getKanendoFukaKakuteiHandler(KanendoFukaKakuteiDiv div) {
        return new KanendoFukaKakuteiHandler(div);
    }
}
