/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0230011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.kaigojuminhyokobetsukoikiunyo.KaigoJuminhyoKobetsuKoikiunyo;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0230011.KobetsuJikoRenkeiInfoSakuseiKoikiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0230011.dgKobetsuJikoRenkeiInfoSakuseiKoik_Row;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護住民票個別事項連携情報作成【広域運用】画面のハンドラークラスです。
 *
 * @reamsid_L DBU-0550-010 zhangzhiming
 */
public class KaigoJyuminhyouHandler {

    private final KobetsuJikoRenkeiInfoSakuseiKoikiDiv div;
    private static final int 位置_結束 = 8;
    private static final int 数値_0 = 0;
    private static final RString 実行 = new RString("btnJikko");

    /**
     * コンストラクタです。
     *
     * @param div 介護住民票個別事項連携情報Div
     */
    public KaigoJyuminhyouHandler(KobetsuJikoRenkeiInfoSakuseiKoikiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param businessList 広域運用抽出期間情報リスト
     */
    public void load(List<KaigoJuminhyoKobetsuKoikiunyo> businessList) {
        List<dgKobetsuJikoRenkeiInfoSakuseiKoik_Row> dgRowList = new ArrayList<>();
        div.getKonkaiInfoInput().setVisible(false);
        for (KaigoJuminhyoKobetsuKoikiunyo kaigoJuminhyo : businessList) {
            dgKobetsuJikoRenkeiInfoSakuseiKoik_Row dgRow = new dgKobetsuJikoRenkeiInfoSakuseiKoik_Row();
            RStringBuilder shichoson = new RStringBuilder();
            shichoson.append(kaigoJuminhyo.getShichosonCode());
            shichoson.append(":");
            shichoson.append(kaigoJuminhyo.getShichosonMeisho());
            dgRow.getTxtSakiShichoson().setValue(shichoson.toRString());
            if (kaigoJuminhyo.getTaishoShuryoTimestamp() != null && !kaigoJuminhyo.getTaishoShuryoTimestamp().isEmpty()) {
                dgRow.getTxtKonkaiStSakuseiYMD().setValue(new RDate(kaigoJuminhyo.getTaishoShuryoTimestamp().toString().substring(数値_0, 位置_結束)));
                dgRow.getTxtKonkaiStSakuseiTime().setValue(RTime.of(kaigoJuminhyo.getTaishoShuryoTimestamp().getRDateTime().getHour(),
                        kaigoJuminhyo.getTaishoShuryoTimestamp().getRDateTime().getMinute(), kaigoJuminhyo.getTaishoShuryoTimestamp().getRDateTime().getSecond()));
                dgRow.getTxtZenkaiSakuseiEdYMD().setValue(new RDate(kaigoJuminhyo.getTaishoShuryoTimestamp().toString().substring(数値_0, 位置_結束)));
                dgRow.getTxtZenkaiSakuseiEdTime().setValue(RTime.of(kaigoJuminhyo.getTaishoShuryoTimestamp().getRDateTime().getHour(),
                        kaigoJuminhyo.getTaishoShuryoTimestamp().getRDateTime().getMinute(), kaigoJuminhyo.getTaishoShuryoTimestamp().getRDateTime().getSecond()));
            }
            if (kaigoJuminhyo.getTaishoKaishiTimestamp() != null && !kaigoJuminhyo.getTaishoKaishiTimestamp().isEmpty()) {
                dgRow.getTxtZenkaiSakuseiStYMD().setValue(new RDate(kaigoJuminhyo.getTaishoKaishiTimestamp().toString().substring(数値_0, 位置_結束)));
                dgRow.getTxtZenkaiSakuseiStTime().setValue(RTime.of(kaigoJuminhyo.getTaishoKaishiTimestamp().getRDateTime().getHour(),
                        kaigoJuminhyo.getTaishoKaishiTimestamp().getRDateTime().getMinute(), kaigoJuminhyo.getTaishoKaishiTimestamp().getRDateTime().getSecond()));
            }
            dgRow.getTxtZenkenSakusei().setValue(RString.EMPTY);
            dgRowList.add(dgRow);
        }
        div.getDgKobetsuJikoRenkeiInfoSakuseiKoik().setDataSource(dgRowList);
    }

    /**
     * 画面修正処理です。
     *
     */
    public void onClick_ModifyButton() {
        div.getKonkaiInfoInput().setVisible(true);
        div.getKonkaiInfoInput().setIsOpen(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(実行, true);
        dgKobetsuJikoRenkeiInfoSakuseiKoik_Row dgRow = div.getDgKobetsuJikoRenkeiInfoSakuseiKoik().getSelectedItems().get(数値_0);
        div.getKonkaiInfoInput().getTxtSofuShichoShon().setValue(dgRow.getTxtSakiShichoson().getValue());
        div.getKonkaiInfoInput().getTxtZenkaiChushutsuToYMD().setValue(dgRow.getTxtZenkaiSakuseiEdYMD().getValue());
        div.getKonkaiInfoInput().getTxtZenkaiChushutsuToTime().setValue(dgRow.getTxtZenkaiSakuseiEdTime().getValue());
        div.getKonkaiInfoInput().getTxtZenkaiChushutsuFromYMD().setValue(dgRow.getTxtZenkaiSakuseiStYMD().getValue());
        div.getKonkaiInfoInput().getTxtZenkaiChushutsuFromTime().setValue(dgRow.getTxtZenkaiSakuseiStTime().getValue());
        div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromYMD().setValue(dgRow.getTxtKonkaiStSakuseiYMD().getValue());
        div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromTime().setValue(dgRow.getTxtKonkaiStSakuseiTime().getValue());
        List<RString> key = new ArrayList<>();
        if (dgRow.getTxtZenkenSakusei().getValue().equals(new RString("する"))) {
            key.add(new RString("key0"));
            div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromYMD().setDisabled(true);
            div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromTime().setDisabled(true);
        } else {
            div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromYMD().setDisabled(false);
            div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromTime().setDisabled(false);
        }
        div.getKonkaiInfoInput().getChkZenken().setSelectedItemsByKey(key);
        div.getDgKobetsuJikoRenkeiInfoSakuseiKoik().getSelectedItems().get(数値_0).setModifyButtonState(DataGridButtonState.Disabled);
        div.getDgKobetsuJikoRenkeiInfoSakuseiKoik().getSelectedItems().get(数値_0).setSelectable(false);
    }

    /**
     * 画面閉じる処理です。
     *
     */
    public void onClick_CloseButton() {
        div.getKonkaiInfoInput().setIsOpen(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(実行, false);
        div.getDgKobetsuJikoRenkeiInfoSakuseiKoik().getClickedItem().setSelectable(true);
        div.getDgKobetsuJikoRenkeiInfoSakuseiKoik().getClickedItem().setModifyButtonState(DataGridButtonState.Enabled);
    }

    /**
     * 画面全件作成処理です。
     *
     */
    public void onClick_ChkZenken() {
        if (div.getKonkaiInfoInput().getChkZenken().isAllSelected()) {
            div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromYMD().clearValue();
            div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromTime().clearValue();
            div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromYMD().setDisabled(true);
            div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromTime().setDisabled(true);
        } else {
            List<dgKobetsuJikoRenkeiInfoSakuseiKoik_Row> dgRowList = div.getDgKobetsuJikoRenkeiInfoSakuseiKoik().getDataSource();
            int rowcount = div.getDgKobetsuJikoRenkeiInfoSakuseiKoik().getClickedItem().getId();
            dgKobetsuJikoRenkeiInfoSakuseiKoik_Row dgRow = dgRowList.get(rowcount);
            div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromYMD().setValue(dgRow.getTxtKonkaiStSakuseiYMD().getValue());
            div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromTime().setValue(dgRow.getTxtKonkaiStSakuseiTime().getValue());
            div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromYMD().setDisabled(false);
            div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromTime().setDisabled(false);
        }
    }

    /**
     * 確定するボタン押下の場合、入力チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateCheck() {
        return createValidationHandler(div).validateCheck();
    }

    /**
     * 画面確定処理です。
     *
     */
    public void onClick_KakuButton() {
        div.getDgKobetsuJikoRenkeiInfoSakuseiKoik().getClickedItem().setSelectable(true);
        div.getDgKobetsuJikoRenkeiInfoSakuseiKoik().getClickedItem().setModifyButtonState(DataGridButtonState.Enabled);
        div.getKonkaiInfoInput().setIsOpen(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(実行, false);
        List<dgKobetsuJikoRenkeiInfoSakuseiKoik_Row> dgRowList = div.getDgKobetsuJikoRenkeiInfoSakuseiKoik().getDataSource();
        int rowcount = div.getDgKobetsuJikoRenkeiInfoSakuseiKoik().getClickedItem().getId();
        dgKobetsuJikoRenkeiInfoSakuseiKoik_Row dgRow = dgRowList.get(rowcount);
        if (div.getKonkaiInfoInput().getChkZenken().isAllSelected()) {
            dgRow.getTxtZenkenSakusei().setValue(new RString("する"));
            dgRow.getTxtKonkaiStSakuseiYMD().clearValue();
            dgRow.getTxtKonkaiStSakuseiTime().clearValue();
        } else {
            dgRow.getTxtZenkenSakusei().setValue(RString.EMPTY);
            dgRow.getTxtKonkaiStSakuseiYMD().setValue(div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromYMD().getValue());
            dgRow.getTxtKonkaiStSakuseiTime().setValue(div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromTime().getValue());
        }
        dgRowList.set(rowcount, dgRow);
        div.getDgKobetsuJikoRenkeiInfoSakuseiKoik().setDataSource(dgRowList);
    }

    private KaigoJyuminValidationHandler createValidationHandler(KobetsuJikoRenkeiInfoSakuseiKoikiDiv div) {
        return new KaigoJyuminValidationHandler(div);
    }
}
