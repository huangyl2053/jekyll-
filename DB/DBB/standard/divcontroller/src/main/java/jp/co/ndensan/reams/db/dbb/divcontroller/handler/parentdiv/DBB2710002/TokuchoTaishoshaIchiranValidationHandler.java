/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2710002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002.TokuchoTaishoshaIchiranDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBBGM81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-010 yangchenbing
 */
public class TokuchoTaishoshaIchiranValidationHandler {

    private final TokuchoTaishoshaIchiranDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面
     */
    public TokuchoTaishoshaIchiranValidationHandler(TokuchoTaishoshaIchiranDiv div) {
        this.div = div;
    }

    /**
     * 出力対象未選択のチックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate出力対象() {
        IValidationMessages message = new TokuchoTaishoshaIchiranValidator(div).出力対象validate();
        return createDictionary出力対象().check(message);
    }

    private ValidationDictionary createDictionary出力対象() {
        List<ViewControl> list = new ArrayList();
        list.add(div.getChkShutsuryokuTaisho());
        return new ValidationDictionaryBuilder().add(TokuchoTaishoshaIchiranValidationMessage.出力対象選択されていない, list).build();
    }

    /**
     * 特別徴収開始月未指定のチックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate特別徴収開始月未指定() {
        IValidationMessages message = new TokuchoTaishoshaIchiranValidator(div).特別徴収開始月validate();
        return createDictionary特別徴収開始月().check(message);
    }

    private ValidationDictionary createDictionary特別徴収開始月() {
        List<ViewControl> list = new ArrayList();
        list.add(div.getTxtKaishiYM());
        return new ValidationDictionaryBuilder().add(TokuchoTaishoshaIchiranValidationMessage.実行不可, list).build();
    }

    /**
     * 特別徴収開始月未指定のチックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate被保険者() {
        IValidationMessages message = new TokuchoTaishoshaIchiranValidator(div).被保険者validate();
        return createDictionary被保険者().check(message);
    }

    private ValidationDictionary createDictionary被保険者() {
        List<ViewControl> list = new ArrayList();
        list.add(div.getTxtHihokenshaNo());
        return new ValidationDictionaryBuilder().add(TokuchoTaishoshaIchiranValidationMessage.被保険者未選択, list).build();
    }

}
