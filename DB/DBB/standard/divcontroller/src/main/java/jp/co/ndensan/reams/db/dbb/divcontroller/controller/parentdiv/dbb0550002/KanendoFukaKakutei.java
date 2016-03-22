/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.dbb0550002;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.honsanteiidokanendofukakakutei.KanendoIdoFukaKakutei;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbInformationMessages;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbQuestionMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550002.KanendoFukaKakuteiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0550002.KanendoFukaKakuteiHandler;
import jp.co.ndensan.reams.db.dbb.service.honsanteiidokanendofukakakutei.HonsanteiIdoKanendoFukaKakutei;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBB;
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
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 本算定異動（過年度）賦課確定（削除込)
 */
public class KanendoFukaKakutei {

    private static final RString 確定処理 = new RString("btnKakutei");
    private static final RString 賦課対象外を削除 = new RString("btnDeleteTaishoGai");

    /**
     * コントロールdivが「生成」された際の処理です。(オンロード)<br/>
     *
     * @param div コントロールdiv
     * @return ResponseData
     */
    public ResponseData<KanendoFukaKakuteiDiv> onLoad(KanendoFukaKakuteiDiv div) {
        HonsanteiIdoKanendoFukaKakutei fukaKakutei = InstanceProvider.create(HonsanteiIdoKanendoFukaKakutei.class);
        RString choteiNendo = DbBusinessConifg.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        div.getTxtChoteiNendo().setDomain(new FlexibleYear(choteiNendo.toString()));
        ShoriDateKanri 異動処理日付 = fukaKakutei.getIdoKijunbi(div.getTxtChoteiNendo().getDomain());
        if (異動処理日付 == null) {
            throw new ApplicationException(DbzErrorMessages.理由付き確定不可.getMessage()
                    .replace("過年度異動賦課のデータがない"));
        } else {
            return initialize(fukaKakutei, div, 異動処理日付);
        }
    }

    /**
     * initialize
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
        } else {
            if (異動処理日付.get基準日時().isBefore(確定処理日付.get基準日時())) {
                throw new ApplicationException(DbzErrorMessages.理由付き確定不可.getMessage()
                        .replace("過年度異動賦課のデータがない"));
            } else {
                getKanendoFukaKakuteiHandler(div).setヘッダ(異動処理日付);
            }
        }
        List<KanendoIdoFukaKakutei> 異動賦課対象List = fukaKakutei.getIdoFukaTaisho(異動処理日付.get基準日時());
        if (!異動賦課対象List.isEmpty() && 異動賦課対象List.size() > 0) {
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
     * 確定処理を実行する
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
     * チェックボックス制御を実行する
     *
     * @param div KanendoFukaKakuteiDiv
     * @return ResponseData<KanendoFukaKakuteiDiv>
     */
    public ResponseData<KanendoFukaKakuteiDiv> onChange_dgKanendoFukaIchiran(KanendoFukaKakuteiDiv div) {
        getKanendoFukaKakuteiHandler(div).onChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択」ボタンを実行する
     *
     * @param div KanendoFukaKakuteiDiv
     * @return ResponseData<KanendoFukaKakuteiDiv>
     */
    public ResponseData<KanendoFukaKakuteiDiv> onClick_dgKanendoFukaIchiran(KanendoFukaKakuteiDiv div) {
        // 介護保険料賦課比較画面（DBB0320005）画面へ遷移する
        getKanendoFukaKakuteiHandler(div).setViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 賦課対象外の削除を実行する
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

    /**
     * handlerの取得を実行する
     *
     * @param div KanendoFukaKakuteiDiv
     * @return KanendoFukaKakuteiHandler
     */
    private KanendoFukaKakuteiHandler getKanendoFukaKakuteiHandler(KanendoFukaKakuteiDiv div) {
        return new KanendoFukaKakuteiHandler(div);
    }
}
