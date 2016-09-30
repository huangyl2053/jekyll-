/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1310001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1310001.JukyushaDaichoDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBDGM13003_汎用リスト出力(受給者台帳)のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-1800-010 liwul
 */
public class JukyushaDaichoPanelValidationHandler {

    private final JukyushaDaichoDiv div;

    /**
     * コンストラクタです
     *
     * @param div ドメインオブジェクトを取り出したい{@link JukyushaDaichoDiv}
     */
    public JukyushaDaichoPanelValidationHandler(JukyushaDaichoDiv div) {
        this.div = div;
    }

    /**
     * 画面設計_DBDGM13003_汎用リスト出力(受給者台帳)のバリデーション。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        _JukyushaDaichoPanelValidator validator = new _JukyushaDaichoPanelValidator(div);
        validateResult.add(createDictionary().check(validator.validate()));
        return validateResult;

    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(JukyushaDaichoPanelValidationMessage.実行するボタンクリック1, div.getTxtKijyunYmd())
                .add(JukyushaDaichoPanelValidationMessage.実行するボタンクリック2, div.getTxtNinteiYmdHani())
                .add(JukyushaDaichoPanelValidationMessage.実行するボタンクリック3, div.getTxtNinteiYmdHani())
                .add(JukyushaDaichoPanelValidationMessage.実行するボタンクリック4, div.getCcdAtenaJoken().get宛名抽出条件子Div().getTxtNenrei())
                .add(JukyushaDaichoPanelValidationMessage.実行するボタンクリック5, div.getCcdAtenaJoken().get宛名抽出条件子Div().getTxtNenrei())
                .add(JukyushaDaichoPanelValidationMessage.実行するボタンクリック6, div.getCcdAtenaJoken().get宛名抽出条件子Div().getTxtNenreiKijunbi())
                .add(JukyushaDaichoPanelValidationMessage.実行するボタンクリック7, div.getCcdAtenaJoken().get宛名抽出条件子Div().getTxtSeinengappi())
                .add(JukyushaDaichoPanelValidationMessage.実行するボタンクリック8, div.getCcdAtenaJoken().get宛名抽出条件子Div().getTxtSeinengappi())
                .build();
    }
}
