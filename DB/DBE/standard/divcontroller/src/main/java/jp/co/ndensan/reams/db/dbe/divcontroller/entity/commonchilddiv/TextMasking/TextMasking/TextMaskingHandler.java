/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TextMasking.TextMasking;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.textmasking.TextMaskingDataModel;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * テキストマスキングのHandlerクラスです。
 *
 * @reamsid_L DBE-3000-250 jinjue
 */
public class TextMaskingHandler {

    private final TextMaskingDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TextMaskingDiv
     */
    public TextMaskingHandler(TextMaskingDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化に特記事項の情報を表示します。
     */
    public void onLoad() {
        TextMaskingDataModel 特記事項情報 = DataPassingConverter.deserialize(div.getHdnTextMasking(), TextMaskingDataModel.class);
        div.getTxtChosaKomokuNo().setValue(特記事項情報.get調査項目番号().insert(1, "-"));
        div.getTxtChosaKomokuRenban().setValue(new Decimal(特記事項情報.get特記連番()));
        div.getTxtChosaKomokuMeisho().setValue(特記事項情報.get調査項目名称());
        RString 特記事項 = 特記事項情報.get特記事項_マッピング().get(GenponMaskKubun.原本.getコード());
        div.getTxtBeforeMasking().setValue(特記事項);
        RString 特記事項再び = 特記事項情報.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード());
        if (RString.isNullOrEmpty(特記事項再び)) {
            if (特記事項情報.isExistData()) {
                div.getTxtAfterMasking().setValue(特記事項再び);
            } else {
                div.getTxtAfterMasking().setValue(特記事項);
            }
        } else {
            div.getTxtAfterMasking().setValue(特記事項再び);
        }
        if (特記事項情報.get削除_マッピング().get(GenponMaskKubun.原本.getコード())) {
            div.getTxtAfterMasking().setDisabled(true);
            List<RString> chkDeleteList = new ArrayList<>();
            chkDeleteList.add(new RString("0"));
            div.getChkDelete().setSelectedItemsByKey(chkDeleteList);
            div.getChkDelete().setDisabled(true);
            div.getBtnHozon().setDisabled(true);
        } else if (特記事項情報.get削除_マッピング().get(GenponMaskKubun.マスク.getコード())) {
            div.getTxtAfterMasking().setDisabled(true);
            List<RString> chkDeleteList = new ArrayList<>();
            chkDeleteList.add(new RString("0"));
            div.getChkDelete().setSelectedItemsByKey(chkDeleteList);
        }
    }

    /**
     * 削除チェックボックスの変更処理です。
     */
    public void onChange_chkDelete() {
        if (div.getChkDelete().getSelectedItems().isEmpty()) {
            div.getTxtAfterMasking().setDisabled(false);
        } else {
            div.getTxtAfterMasking().setDisabled(true);
        }
    }

    /**
     * 画面で編集するマスキング後の情報を保存します。
     */
    public void onClick_btnHozon() {
        TextMaskingDataModel 特記事項情報 = DataPassingConverter.deserialize(div.getHdnTextMasking(), TextMaskingDataModel.class);
        特記事項情報.get特記事項_マッピング().put(GenponMaskKubun.マスク.getコード(), div.getTxtAfterMasking().getValue());
        特記事項情報.get削除_マッピング().put(GenponMaskKubun.マスク.getコード(), !div.getChkDelete().getSelectedItems().isEmpty());
        div.setHdnTextMasking(DataPassingConverter.serialize(特記事項情報));
    }
}
