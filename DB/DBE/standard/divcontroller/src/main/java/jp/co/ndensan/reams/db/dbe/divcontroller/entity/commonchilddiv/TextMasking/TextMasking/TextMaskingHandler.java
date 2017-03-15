/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TextMasking.TextMasking;

import jp.co.ndensan.reams.db.dbe.business.core.textmasking.TextMaskingModel;
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
        TextMaskingModel 特記事項情報 = DataPassingConverter.deserialize(div.getHdnTextMasking(), TextMaskingModel.class);
        if (!RString.isNullOrEmpty(特記事項情報.get調査項目番号())) {
            div.getTxtChosaKomokuNo().setValue(特記事項情報.get調査項目番号().insert(1, "-"));
            div.getTxtChosaKomokuRenban().setValue(new Decimal(特記事項情報.get特記連番()));
        } else {
            div.getTxtChosaKomokuNo().clearValue();
            div.getTxtChosaKomokuRenban().clearValue();
        }
        div.getTxtChosaKomokuMeisho().setValue(特記事項情報.get編集タイトル());
        div.getTxtBeforeMasking().setValue(特記事項情報.get原本テキスト());
        div.getTxtAfterMasking().setValue(特記事項情報.getマスキング対象テキスト());
    }

    /**
     * 画面で編集するマスキング後の情報を保存します。
     */
    public void onClick_btnTextHozon() {
        TextMaskingModel 特記事項情報 = DataPassingConverter.deserialize(div.getHdnTextMasking(), TextMaskingModel.class);
        特記事項情報.setマスキング対象テキスト(div.getTxtAfterMasking().getValue());
        div.setHdnTextMasking(DataPassingConverter.serialize(特記事項情報));
    }
}
