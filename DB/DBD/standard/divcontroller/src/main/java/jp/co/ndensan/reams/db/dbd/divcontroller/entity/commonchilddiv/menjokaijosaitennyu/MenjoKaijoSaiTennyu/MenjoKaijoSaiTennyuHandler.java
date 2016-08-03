/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.menjokaijosaitennyu.MenjoKaijoSaiTennyu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenkoBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.gengaku.ShiharaiHohoHenkoGengaku;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.TainoHanteiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.DateRoundingType;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 【共有子Div】 免除解除・再転入ダイアログのHandlerです。
 */
public class MenjoKaijoSaiTennyuHandler {

    private final MenjoKaijoSaiTennyuDiv div;

    /**
     * 一号償還払い化ダイアログキーのEnum
     */
    private enum 免除解除再転入ダイアロググキー {

        /**
         * 画面更新用情報
         */
        支払方法変更管理業務概念;
    }

    public MenjoKaijoSaiTennyuHandler(MenjoKaijoSaiTennyuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void onLoad() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = DataPassingConverter.deserialize(div.getKey_ShiharaiHohoHenkoKanri(), ShiharaiHohoHenko.class);
        ViewStateHolder.put(免除解除再転入ダイアロググキー.支払方法変更管理業務概念, 支払方法変更管理業務概念);
        List<ShiharaiHohoHenko> 支払方法変更レコード = new ArrayList();
        if (支払方法変更管理業務概念 != null
                && 支払方法変更管理業務概念.get被保険者番号().value().equals(div.getKey_HihokenshaNo())
                && 支払方法変更管理業務概念.get管理区分().equals(ShiharaiHenkoKanriKubun._１号給付額減額.getコード())
                && 支払方法変更管理業務概念.get登録区分().equals(ShiharaiHenkoTorokuKubun._１号給付額減額登録.getコード())
                && !支払方法変更管理業務概念.getShiharaiHohoHenkoGengakuList().isEmpty()) {
            支払方法変更レコード.add(支払方法変更管理業務概念);
        }
        if (支払方法変更管理業務概念 == null || 支払方法変更レコード.isEmpty() || 支払方法変更管理業務概念.getShiharaiHohoHenkoGengakuList().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象ファイルが存在しない.getMessage().replace("支払方法変更"));
        }
        initializeDisplayData(ViewStateHolder.get(免除解除再転入ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class));
    }

    /**
     * 選択アイコンです。
     */
    public void selectedItem() {
        int index = div.getDgMenjoKaijoOrSaitennyu().getClickedItem().getId();
        div.setKey_hannteiIndex(new RString(String.valueOf(index)));
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(免除解除再転入ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        div.getTxtTorokuJokyo().setValue(支払方法変更管理業務概念.get登録区分());
        div.getTxtGengakuTekiyoKikanKaishiYMD().setValue(支払方法変更管理業務概念.getShiharaiHohoHenkoGengakuList().get(index).get確定減額期間開始年月日());
        div.getTxtGengakuTekiyoKikanShuryoYMD().setValue(支払方法変更管理業務概念.getShiharaiHohoHenkoGengakuList().get(index).get確定減額期間終了年月日());
        div.getTxtChoshukenShometsuKikan().setValue(支払方法変更管理業務概念.getShiharaiHohoHenkoGengakuList().get(index).get徴収権消滅期間());
        div.getTxtNofuzumiKikan().setValue(支払方法変更管理業務概念.getShiharaiHohoHenkoGengakuList().get(index).get納付済期間());
        div.getTxtKyufugakuGengakuKikan().setValue(get給付額減額期間(div.getTxtChoshukenShometsuKikan().getValue(), div.getTxtNofuzumiKikan().getValue()));
        div.getTxtGengakuKetteiYMD().setValue(支払方法変更管理業務概念.get減額決定年月日());
        div.getTxtZenkaiKikanKaishiYMD().setValue(支払方法変更管理業務概念.getShiharaiHohoHenkoGengakuList().get(index).get確定減額期間開始年月日());
        div.getTxtZenkaiKikanShuryoYMD().setValue(支払方法変更管理業務概念.getShiharaiHohoHenkoGengakuList().get(index).get確定減額期間終了年月日());
        div.getTxtGengakuTsuchiHakkoYMD().setValue(支払方法変更管理業務概念.get減額通知書発行年月日());
        div.getTxtKonkaiKikanKaishiYMD().setValue(支払方法変更管理業務概念.getShiharaiHohoHenkoGengakuList().get(index).get確定減額期間開始年月日());
        div.getTxtKonkaiKikanShuryoYMD().setValue(支払方法変更管理業務概念.getShiharaiHohoHenkoGengakuList().get(index).get確定減額期間終了年月日());
        div.getTxtTainoJokyo().setDisabled(false);
        div.getBtnTorikeshi().setDisabled(false);
        div.getBtnKakutei().setDisabled(false);
    }

    /**
     * 「確定」ボタンを押下します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs onClick_BtnKakutei() {
        ValidationMessageControlPairs pairs = getValidationMessages();
        if (pairs.iterator().hasNext()) {
            return pairs;
        }
        update支払方法変更減額();
        div.setKey_ShiharaiHohoHenkoKanri(DataPassingConverter.serialize(ViewStateHolder.get(免除解除再転入ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class)));
        div.getDgMenjoKaijoOrSaitennyu().getClickedItem().setJotai(new RString("修正"));
        div.getBtnTorikeshi().setDisabled(true);
        div.getBtnKakutei().setDisabled(true);
        return pairs;
    }

    /**
     * 滞納状況ダイアログを開く前に実行されるイベントを設定します。
     */
    public void onBeforeOpenDialog_BtnTainoJokyo() {
        div.setHihokenshaNo(div.getKey_HihokenshaNo());
        div.setKanriKubun(ShiharaiHenkoKanriKubun._１号給付額減額.getコード());
        div.setTainoHanteiKubun(TainoHanteiKubun.給付額減額登録.getコード());
        div.setRirekiNo(RString.EMPTY);
    }

    /**
     * 「閉じる」ボタンを押す。
     */
    public void onClick_btnToJiRu() {
        div.setKey_ShiharaiHohoHenkoKanri(DataPassingConverter.serialize(ViewStateHolder.get(免除解除再転入ダイアロググキー.支払方法変更管理業務概念, ArrayList.class)));
    }

    /**
     * 「取消」ボタンの処理です。
     *
     * @return ［画面］登録状況が空(Empty)か否か
     */
    public boolean onClick_BtnTorikeshi() {
        return !div.getTxtTorokuJokyo().getValue().isEmpty();
    }

    private void initializeDisplayData(ShiharaiHohoHenko shiharaiHohoHenko) {
        div.setTitle(div.getKey_Button());
        div.getDgMenjoKaijoOrSaitennyu().setDisabled(false);
        div.getDgMenjoKaijoOrSaitennyu().setDataSource(createDateSource(shiharaiHohoHenko));
        div.getTxtTorokuJokyo().setValue(RString.EMPTY);
        div.setTxtKyufugakuGengakuKikan(null);
        div.setTxtGengakuTekiyoKikanKaishiYMD(null);
        div.setTxtGengakuTekiyoKikanShuryoYMD(null);
        div.setTxtChoshukenShometsuKikan(null);
        div.setTxtNofuzumiKikan(null);
        div.setTxtGengakuKetteiYMD(null);
        div.setTxtZenkaiKikanKaishiYMD(null);
        div.setTxtZenkaiKikanShuryoYMD(null);
        div.setTxtGengakuTsuchiHakkoYMD(null);
        div.setTxtKonkaiKikanKaishiYMD(null);
        div.setTxtKonkaiKikanShuryoYMD(null);
        div.getKyufugakuGengakuToroku().getTxtTainoJokyo().setIconNameEnum(IconName.Info);
        div.getTxtTainoJokyo().setDisabled(false);
        div.getBtnTorikeshi().setDisabled(true);
        div.getBtnKakutei().setDisabled(true);
    }

    private List<dgMenjoKaijoOrSaitennyu_Row> createDateSource(ShiharaiHohoHenko shiharaiHohoHenko) {
        List<dgMenjoKaijoOrSaitennyu_Row> rowList = new ArrayList();
        dgMenjoKaijoOrSaitennyu_Row row = new dgMenjoKaijoOrSaitennyu_Row();
        for (int i = 0; i < shiharaiHohoHenko.getShiharaiHohoHenkoGengakuList().size(); i++) {
            row.setJotai(RString.EMPTY);
            row.setGengakuTekiyoKikan(new RString(shiharaiHohoHenko.getShiharaiHohoHenkoGengakuList().get(i).get確定減額期間開始年月日()
                    .wareki(DateRoundingType.変換なし).toDateString().toString()).concat(new RString("～"))
                    .concat(new RString(shiharaiHohoHenko.getShiharaiHohoHenkoGengakuList().get(i).get確定減額期間終了年月日()
                                    .wareki(DateRoundingType.変換なし).toDateString().toString())));
            row.getTxtGengakuKetteiYMD().setValue(shiharaiHohoHenko.get減額決定年月日());
            row.setMenjoShinseiRiyu(shiharaiHohoHenko.get終了申請理由コード());
            row.getTxtMenjoShinseiUketsukeYMD().setValue(shiharaiHohoHenko.get終了申請書受付年月日());
            row.getTxtMenjoShinseiYMD().setValue(shiharaiHohoHenko.get終了申請年月日());
            row.setId(i);
            rowList.add(row);
        }
        return rowList;

    }

    private ValidationMessageControlPairs getValidationMessages() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor減額適用期間チェック(pairs, div);
        return pairs;
    }

    private MenjoKaijoSaiTennyuValidationHandler getValidationHandler() {
        return new MenjoKaijoSaiTennyuValidationHandler();
    }

    private void update支払方法変更減額() {
        int index = Integer.parseInt(div.getKey_hannteiIndex().toString());
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(免除解除再転入ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        ShiharaiHohoHenkoGengaku shiharaiHohoHenkoGengaku = 支払方法変更管理業務概念.getShiharaiHohoHenkoGengakuList().get(index);
        builder.setShiharaiHohoHenkoGengaku(shiharaiHohoHenkoGengaku.createBuilderForEdit()
                .set確定減額期間終了年月日(div.getTxtKonkaiKikanShuryoYMD().getValue())
                .set確定減額期間開始年月日(div.getTxtKonkaiKikanKaishiYMD().getValue())
                .build());
        ViewStateHolder.put(免除解除再転入ダイアロググキー.支払方法変更管理業務概念, 支払方法変更管理業務概念);
    }

    private Decimal get給付額減額期間(Decimal value, Decimal value0) {
        Decimal valueNum;
        valueNum = value.multiply(value).divide(value.add(value0)).divide(2).multiply(12);
        if (valueNum.intValue() == 0) {
            return null;
        }
        return valueNum;

    }
}
