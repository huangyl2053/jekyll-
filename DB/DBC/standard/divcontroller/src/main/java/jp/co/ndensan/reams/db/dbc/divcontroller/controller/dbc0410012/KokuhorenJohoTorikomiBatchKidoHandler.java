/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0410012;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.business.KokuhorenJohoTorikomi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenTorikomiJohoKey;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410012.KokuhorenJohoTorikomiBatchKidoDiv;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * {@link KokuhorenJohoTorikomiBatchKidoDiv}のHandlerクラスです。
 */
public class KokuhorenJohoTorikomiBatchKidoHandler {

    private final KokuhorenJohoTorikomiBatchKidoDiv div;
    private final RString 同月過誤分ファイル名 = new RString("01110000");
    private final RString 通常分ファイル名 = new RString("11100000");

    /**
     * コンストラクタです。
     *
     * @param div 世帯所得一覧Div
     */
    public KokuhorenJohoTorikomiBatchKidoHandler(KokuhorenJohoTorikomiBatchKidoDiv div) {
        this.div = div;
    }

    /**
     * Divの初期化を行います。
     *
     * @param panel 国保連取込情報バッチ起動画面
     * @param viewState ViewState情報
     */
    public void initialize(KokuhorenJohoTorikomiBatchKidoDiv panel, KokuhorenTorikomiJohoKey viewState) {
        setDisplay(panel, viewState);
        panel.getLblTitle().setText(viewState.get処理名());
    }

    /**
     * Divの初期化を行います。
     *
     * @param panel 国保連取込情報バッチ起動画面
     * @return バリデーションチェック結果
     */
    public ValidationMessageControlPairs validate(KokuhorenJohoTorikomiBatchKidoDiv panel) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        IValidationMessages messages = new KokuhorenJohoTorikomiValidator(panel).validate();

        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(KokuhorenJohoValidationMessage.処理対象情報が未選択, panel.getChkDogetsuKagobun(), panel.getChkTsujobun()).build().check(messages));
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(KokuhorenJohoValidationMessage.出力順序未指定, panel.getPnlShutsuryokuJun()).build().check(messages));
        return pairs;
    }

    private void setDisplay(KokuhorenJohoTorikomiBatchKidoDiv panel, KokuhorenTorikomiJohoKey viewState) {
        setVisible(viewState.get交換情報識別番号().value(), panel);
        setDisplayData(viewState, panel);
        if (viewState.get再処理区分().equals(new RString("1"))) {
            panel.getTxtSaishoriKubun().setValue(new RString("再処理"));
        }
    }

    private void setVisible(RString 交換識別番号, KokuhorenJohoTorikomiBatchKidoDiv panel) {
        switch (交換識別番号.toString()) {
            case "111":
                panel.getPnlShoritaishoJoho().setDisplayNone(false);
                break;
            case "151":
            case "152":
            case "632":
            case "741":
            case "121":
            case "122":
                panel.getPnlShutsuryokuJun().setDisplayNone(true);
            case "5C3":
            case "112":
            case "161":
            case "171":
            case "172":
            case "651":
            case "652":
            case "641":
            case "533":
            case "114":
            case "221":
            case "222":
            case "331":
            case "351":
            case "37J":
            case "37H":
            case "386":
            case "38B":
            case "38P":
            case "175":
            case "162":
                panel.getPnlShoritaishoJoho().setDisplayNone(true);
            default:
        }
    }

    private void setDisplayData(KokuhorenTorikomiJohoKey selectedrow, KokuhorenJohoTorikomiBatchKidoDiv panel) {
        KokuhorenJohoTorikomi business = new KokuhorenJohoTorikomi();
        switch (selectedrow.get交換情報識別番号().value().toString()) {
            case "111":
                if (SharedFile.searchSharedFile(同月過誤分ファイル名).isEmpty()) {
                    panel.getPnlShoritaishoJoho().getChkDogetsuKagobun().setSelectedItems(Collections.EMPTY_LIST);
                } else {
                    panel.getPnlShoritaishoJoho().getChkDogetsuKagobun().setSelectedItems(panel.getPnlShoritaishoJoho().getChkTsujobun().getDataSource());
                }
                if (SharedFile.searchSharedFile(通常分ファイル名).isEmpty()) {
                    panel.getPnlShoritaishoJoho().getChkTsujobun().setSelectedItems(Collections.EMPTY_LIST);
                } else {
                    panel.getPnlShoritaishoJoho().getChkTsujobun().setSelectedItems(panel.getPnlShoritaishoJoho().getChkTsujobun().getDataSource());
                }
            case "5C3":
            case "112":
            case "161":
            case "171":
            case "172":
            case "651":
            case "652":
            case "641":
            case "533":
            case "114":
            case "221":
            case "222":
            case "331":
            case "351":
            case "37J":
            case "37H":
            case "386":
            case "38B":
            case "38P":
            case "175":
            case "162":
                panel.getPnlShutsuryokuJun().getCcdShutsuryokuJun().load(SubGyomuCode.DBC介護給付, business.get帳票ID(selectedrow.get交換情報識別番号().value()));
            case "151":
            case "152":
            case "632":
            case "741":
            case "121":
            case "122":
                panel.getPnlChushutsuJoken().getTxtShoriJoken().setValue(new RDate(selectedrow.get処理年月().toString()));
                panel.getPnlChushutsuJoken().getTxtSaishoriKubun().setValue(business.get再処理フラグ名称(selectedrow.get再処理区分()));
                panel.getPnlChushutsuJoken().getTxtKokanShikibetsuNo().setValue(selectedrow.get交換情報識別番号().value());
            default:
        }
    }

}
