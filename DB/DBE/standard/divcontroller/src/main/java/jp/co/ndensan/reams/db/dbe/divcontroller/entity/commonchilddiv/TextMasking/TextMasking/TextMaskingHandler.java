/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TextMasking.TextMasking;

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
    private final RString 原本マスク区分 = new RString("1");
    private final RString マスク区分 = new RString("2");

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
            div.getTxtAfterMasking().setValue(特記事項);
        } else {
            div.getTxtAfterMasking().setValue(特記事項再び);
        }
    }

    /**
     * 画面で編集するマスキング後の情報を保存します。
     */
    public void onClick_btnHozon() {
        TextMaskingDataModel 特記事項情報 = DataPassingConverter.deserialize(div.getHdnTextMasking(), TextMaskingDataModel.class);
        RString 特記事項 = 特記事項情報.get特記事項_マッピング().get(GenponMaskKubun.原本.getコード());
        特記事項情報.get特記事項_マッピング().put(原本マスク区分, 特記事項);
        特記事項情報.get特記事項_マッピング().put(マスク区分, div.getTxtAfterMasking().getValue());
        div.setHdnTextMasking(DataPassingConverter.serialize(特記事項情報));
    }
}
