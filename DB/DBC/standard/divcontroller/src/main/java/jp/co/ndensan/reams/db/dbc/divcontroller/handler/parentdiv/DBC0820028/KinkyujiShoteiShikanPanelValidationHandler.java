/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820028;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820028.KinkyujiShoteiShikanPanelDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患）画面のハンドラクラスです
 *
 * @reamsid_L DBC-1030-050 xupeng
 */
public class KinkyujiShoteiShikanPanelValidationHandler {

    private final KinkyujiShoteiShikanPanelDiv div;
    private static final RString 所定疾患傷病名_ONE = new RString("所定疾患傷病名①");
    private static final RString 所定疾患傷病名_TWO = new RString("所定疾患傷病名②");
    private static final RString 所定疾患傷病名_THREE = new RString("所定疾患傷病名③");
    private static final RString 緊急時傷病名_ONE = new RString("緊急時傷病名①");
    private static final RString 緊急時傷病名_TWO = new RString("緊急時傷病名②");
    private static final RString 緊急時傷病名_THREE = new RString("緊急時傷病名③");
    private static final RString 所定疾患療養開始日_ONE = new RString("所定疾患療養開始日①");
    private static final RString 所定疾患療養開始日_TWO = new RString("所定疾患療養開始日②");
    private static final RString 所定疾患療養開始日_THREE = new RString("所定疾患療養開始日③");
    private static final RString 緊急時治療開始日_ONE = new RString("緊急時治療開始日①");
    private static final RString 緊急時治療開始日_TWO = new RString("緊急時治療開始日②");
    private static final RString 緊急時治療開始日_THREE = new RString("緊急時治療開始日③");
    private static final RString 往診日数 = new RString("往診日数");
    private static final RString 往診医療機関名 = new RString("往診医療機関名");
    private static final RString 通院日数 = new RString("通院日数");
    private static final RString 通院医療機関名 = new RString("通院医療機関名");
    private static final RString 特定疾患施設療養費単位 = new RString("特定疾患施設療養費単位");
    private static final RString 特定疾患施設療養費日数 = new RString("特定疾患施設療養費日数");
    private static final RString 緊急時治療管理単位数 = new RString("緊急時治療管理単位数");
    private static final RString 緊急時治療管理日数 = new RString("緊急時治療管理日数");
    private static final RString リハビリテーション = new RString("リハビリテーション");
    private static final RString 手術 = new RString("手術");
    private static final RString 放射線治療 = new RString("放射線治療");
    private static final RString 処置 = new RString("処置");
    private static final RString 麻酔 = new RString("麻酔");

    /**
     * 初期化
     *
     * @param div KinkyujiShoteiShikanPanelDiv
     */
    public KinkyujiShoteiShikanPanelValidationHandler(KinkyujiShoteiShikanPanelDiv div) {
        this.div = div;
    }

    /**
     * 入力チェック
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check入力() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if ((div.getPanelDetail().getTxtShoteiShikkanShobyoName1().getValue() == null
                || (div.getPanelDetail().getTxtShoteiShikkanShobyoName1().getValue().isEmpty()))
                && div.getPanelDetail().getTxtShoteiShikkanShobyoKaishiYMD1().getValue() != null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 所定疾患傷病名_ONE.toString())));
        }
        if ((div.getPanelDetail().getTxtShoteiShikkanShobyoName1().getValue() != null
                && !(div.getPanelDetail().getTxtShoteiShikkanShobyoName1().getValue().isEmpty()))
                && div.getPanelDetail().getTxtShoteiShikkanShobyoKaishiYMD1().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 所定疾患療養開始日_ONE.toString())));
        }
        if ((div.getPanelDetail().getTxtShoteiShikkanShobyoName2().getValue() == null
                || (div.getPanelDetail().getTxtShoteiShikkanShobyoName2().getValue().isEmpty()))
                && div.getPanelDetail().getTxtShoteiShikkanShobyoKaishiYMD2().getValue() != null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 所定疾患傷病名_TWO.toString())));
        }
        if ((div.getPanelDetail().getTxtShoteiShikkanShobyoName2().getValue() != null
                && !(div.getPanelDetail().getTxtShoteiShikkanShobyoName2().getValue().isEmpty()))
                && div.getPanelDetail().getTxtShoteiShikkanShobyoKaishiYMD2().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 所定疾患療養開始日_TWO.toString())));
        }
        if ((div.getPanelDetail().getTxtShoteiShikkanShobyoName3().getValue() == null
                || (div.getPanelDetail().getTxtShoteiShikkanShobyoName3().getValue().isEmpty()))
                && div.getPanelDetail().getTxtShoteiShikkanShobyoKaishiYMD3().getValue() != null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 所定疾患傷病名_THREE.toString())));
        }
        if ((div.getPanelDetail().getTxtShoteiShikkanShobyoName3().getValue() != null
                && !(div.getPanelDetail().getTxtShoteiShikkanShobyoName3().getValue().isEmpty()))
                && div.getPanelDetail().getTxtShoteiShikkanShobyoKaishiYMD3().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 所定疾患療養開始日_THREE.toString())));
        }
        check入力_one(validPairs);
        return validPairs;
    }

    private ValidationMessageControlPairs check入力_one(ValidationMessageControlPairs validPairs) {
        if ((div.getPanelDetail().getTxtKinkyuShobyoName1().getValue() == null
                || (div.getPanelDetail().getTxtKinkyuShobyoName1().getValue().isEmpty()))
                && div.getPanelDetail().getTxtKinkyuChiryoKaishiYMD1().getValue() != null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 緊急時傷病名_ONE.toString())));
        }
        if ((div.getPanelDetail().getTxtKinkyuShobyoName1().getValue() != null
                && !(div.getPanelDetail().getTxtKinkyuShobyoName1().getValue().isEmpty()))
                && div.getPanelDetail().getTxtKinkyuChiryoKaishiYMD1().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 緊急時治療開始日_ONE.toString())));
        }
        if ((div.getPanelDetail().getTxtKinkyuShobyoName2().getValue() == null
                || (div.getPanelDetail().getTxtKinkyuShobyoName2().getValue().isEmpty()))
                && div.getPanelDetail().getTxtKinkyuChiryoKaishiYMD2().getValue() != null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 緊急時傷病名_TWO.toString())));
        }
        if ((div.getPanelDetail().getTxtKinkyuShobyoName2().getValue() != null
                && !(div.getPanelDetail().getTxtKinkyuShobyoName2().getValue().isEmpty()))
                && div.getPanelDetail().getTxtKinkyuChiryoKaishiYMD2().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 緊急時治療開始日_TWO.toString())));
        }
        if ((div.getPanelDetail().getTxtKinkyuShobyoName3().getValue() == null
                || (div.getPanelDetail().getTxtKinkyuShobyoName3().getValue().isEmpty()))
                && div.getPanelDetail().getTxtKinkyuChiryoKaishiYMD3().getValue() != null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 緊急時傷病名_THREE.toString())));
        }
        if (((div.getPanelDetail().getTxtKinkyuShobyoName3().getValue() != null
                && !(div.getPanelDetail().getTxtKinkyuShobyoName3().getValue().isEmpty()))
                && div.getPanelDetail().getTxtKinkyuChiryoKaishiYMD3().getValue() == null)) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 緊急時治療開始日_THREE.toString())));
        }
        check入力_two(validPairs);
        return validPairs;
    }

    private ValidationMessageControlPairs check入力_two(ValidationMessageControlPairs validPairs) {
        if (div.getPanelDetail().getTxtOshinNissu().getValue() == null
                && (div.getPanelDetail().getTxtOshinIryoKikanName().getValue() != null
                && !div.getPanelDetail().getTxtOshinIryoKikanName().getValue().isEmpty())) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 往診日数.toString())));
        }
        if (div.getPanelDetail().getTxtOshinNissu().getValue() != null
                && (div.getPanelDetail().getTxtOshinIryoKikanName().getValue() == null
                || div.getPanelDetail().getTxtOshinIryoKikanName().getValue().isEmpty())) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 往診医療機関名.toString())));
        }
        if (div.getPanelDetail().getTxtTsuyinNissu().getValue() == null
                && (div.getPanelDetail().getTxtTsuinKikanName().getValue() != null
                && !div.getPanelDetail().getTxtTsuinKikanName().getValue().isEmpty())) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 通院日数.toString())));
        }
        if (div.getPanelDetail().getTxtTsuyinNissu().getValue() != null
                && (div.getPanelDetail().getTxtTsuinKikanName().getValue() == null
                || div.getPanelDetail().getTxtTsuinKikanName().getValue().isEmpty())) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 通院医療機関名.toString())));
        }
        if (div.getPanelDetail().getTxtShoteiShikkanTanisu().getValue() == null
                && div.getPanelDetail().getTxtShoteiShikkanNissu().getValue() != null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 特定疾患施設療養費単位.toString())));
        }
        if (div.getPanelDetail().getTxtShoteiShikkanTanisu().getValue() != null
                && div.getPanelDetail().getTxtShoteiShikkanNissu().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 特定疾患施設療養費日数.toString())));
        }
        check入力_three(validPairs);
        return validPairs;
    }

    private ValidationMessageControlPairs check入力_three(ValidationMessageControlPairs validPairs) {
        if (div.getPanelDetail().getTxtKinkyuChiryoKanriTanisu().getValue() == null
                && div.getPanelDetail().getTxtKinkyuChiryoKanriNissu().getValue() != null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 緊急時治療管理単位数.toString())));
        }
        if (div.getPanelDetail().getTxtKinkyuChiryoKanriTanisu().getValue() != null
                && div.getPanelDetail().getTxtKinkyuChiryoKanriNissu().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 緊急時治療管理日数.toString())));
        }
        if (div.getPanelDetail().getTxtRehabilitationTanisu().getValue() == null
                && div.getPanelDetail().getTxtShujutsuTanisu().getValue() != null
                && div.getPanelDetail().getTxtHoshasenChiryoTanisu().getValue() != null
                && div.getPanelDetail().getTxtShochiTanisu().getValue() != null
                && div.getPanelDetail().getTxtMasuiTanisu().getValue() != null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, リハビリテーション.toString())));
        }
        if (div.getPanelDetail().getTxtRehabilitationTanisu().getValue() != null
                && div.getPanelDetail().getTxtShujutsuTanisu().getValue() == null
                && div.getPanelDetail().getTxtHoshasenChiryoTanisu().getValue() != null
                && div.getPanelDetail().getTxtShochiTanisu().getValue() != null
                && div.getPanelDetail().getTxtMasuiTanisu().getValue() != null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 手術.toString())));
        }
        check入力_four(validPairs);
        return validPairs;
    }

    private ValidationMessageControlPairs check入力_four(ValidationMessageControlPairs validPairs) {
        if (div.getPanelDetail().getTxtRehabilitationTanisu().getValue() != null
                && div.getPanelDetail().getTxtShujutsuTanisu().getValue() != null
                && div.getPanelDetail().getTxtHoshasenChiryoTanisu().getValue() == null
                && div.getPanelDetail().getTxtShochiTanisu().getValue() != null
                && div.getPanelDetail().getTxtMasuiTanisu().getValue() != null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 放射線治療.toString())));
        }
        if (div.getPanelDetail().getTxtRehabilitationTanisu().getValue() != null
                && div.getPanelDetail().getTxtShujutsuTanisu().getValue() != null
                && div.getPanelDetail().getTxtHoshasenChiryoTanisu().getValue() != null
                && div.getPanelDetail().getTxtShochiTanisu().getValue() == null
                && div.getPanelDetail().getTxtMasuiTanisu().getValue() != null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 処置.toString())));
        }
        if (div.getPanelDetail().getTxtRehabilitationTanisu().getValue() != null
                && div.getPanelDetail().getTxtShujutsuTanisu().getValue() != null
                && div.getPanelDetail().getTxtHoshasenChiryoTanisu().getValue() != null
                && div.getPanelDetail().getTxtShochiTanisu().getValue() != null
                && div.getPanelDetail().getTxtMasuiTanisu().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(
                    new KinkyujiShoteiShikanPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 麻酔.toString())));
        }
        return validPairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
