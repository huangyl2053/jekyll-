/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020007;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosachikuchichoson.ChosaChikuChichosonBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosachikuchichoson.UzT0007CodeBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020007.NinteiChosaSchedule7MainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020007.dgChosaChikuChichosonList_Row;
import jp.co.ndensan.reams.db.dbe.service.core.chosachikuchichoson.ChosaChikuFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 調査地区市町村情報のバリデーションチェッククラスです。
 */
public class MainPanelValidationHandler {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private final NinteiChosaSchedule7MainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public MainPanelValidationHandler(NinteiChosaSchedule7MainDiv div) {
        this.div = div;
    }

    /**
     * 初期化とき、バリデーションチェックを行う。
     *
     * @param businessList 調査地区情報
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForOnLoad(List<UzT0007CodeBusiness> businessList) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (businessList.isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    IdocheckMessages.Validate該当データなし, div.getChosaChikuPanel().getDgChosaChikuList()));
        }
        return validPairs;
    }

    /**
     * 調査地区一覧の行クリックとき、バリデーションチェックを行う。
     *
     * @param businessList 調査地区市町村情報
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForSelectbtn(List<ChosaChikuChichosonBusiness> businessList) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (businessList.isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    IdocheckMessages.Validate該当データなし, div.getChosaChikuShichosonPanel().getDgChosaChikuChichosonList()));
        }
        return validPairs;
    }

    /**
     * 確定するボタン押下の場合、入力チェック実行します。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForKakuTeiBtn() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<dgChosaChikuChichosonList_Row> rowList = div.getChosaChikuShichosonPanel().getDgChosaChikuChichosonList().getDataSource();
        if (状態_追加.equals(div.getChosaChikuShichosoInput().getTxtJotai())) {
            if (!div.getChosaChikuShichosoInput().getTxtShichoSonCode().getValue().isNullOrEmpty()
                    && div.getChosaChikuShichosoInput().getTxtShichoSonMeisho().getValue().isNullOrEmpty()) {
                validPairs.add(new ValidationMessageControlPair(
                        IdocheckMessages.Validate合法性, div.getChosaChikuShichosoInput().getTxtShichoSonCode()));
            }
            boolean flg = ChosaChikuFinder.createInstance().checkShichosonCode(
                    new Code(div.getChosaChikuShichosonPanel().getTxtChosaChikuCode().getValue()),
                    new LasdecCode(div.getChosaChikuShichosoInput().getTxtShichoSonCode().getValue()));
            if (flg) {
                validPairs.add(new ValidationMessageControlPair(
                        IdocheckMessages.Validate既に登録済, div.getChosaChikuShichosoInput().getTxtShichoSonCode()));
            }
            for (dgChosaChikuChichosonList_Row row : rowList) {
                if (row.getCityCode().equals(div.getChosaChikuShichosoInput().getTxtShichoSonCode().getValue())) {
                    validPairs.add(new ValidationMessageControlPair(
                            IdocheckMessages.Validate既に存在, div.getChosaChikuShichosoInput().getTxtShichoSonCode()));
                }
            }
        }
        if (状態_修正.equals(div.getChosaChikuShichosoInput().getTxtJotai())
                && div.getChosaChikuShichosoInput().getHdnYusenNo().equals(
                        new RString(div.getChosaChikuShichosoInput().getTxtYusenNo().getValue().toString()))
                && div.getChosaChikuShichosoInput().getHdnJichiku().equals(
                        div.getChosaChikuShichosoInput().getRadJiChikuFlag().getSelectedKey())) {
            validPairs.add(new ValidationMessageControlPair(IdocheckMessages.Validate編集状態,
                    div.getChosaChikuShichosoInput().getTxtYusenNo(), div.getChosaChikuShichosoInput().getRadJiChikuFlag()));
        }
        return validPairs;
    }

    /**
     * 「保存する」ボタンを押下するの場合、編集状態チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor編集状態() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(IdocheckMessages.Validate編集状態,
                div.getChosaChikuShichosonPanel().getDgChosaChikuChichosonList()));
        return validPairs;
    }

    /**
     * 「保存する」ボタンを押下するの場合、削除実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateForHozonnBtn() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<dgChosaChikuChichosonList_Row> rowList = div.getChosaChikuShichosonPanel().getDgChosaChikuChichosonList().getDataSource();
        for (dgChosaChikuChichosonList_Row listRow : rowList) {
            if (状態_削除.equals(listRow.getJotai())) {
                boolean flg = ChosaChikuFinder.createInstance().getCheckResult(
                        new Code(div.getChosaChikuShichosonPanel().getTxtChosaChikuCode().getValue()),
                        new LasdecCode(listRow.getCityCode()));
                if (!flg) {
                    validPairs.add(new ValidationMessageControlPair(IdocheckMessages.Validate削除不可,
                            div.getChosaChikuShichosonPanel().getDgChosaChikuChichosonList()));
                }
            }
        }
        return validPairs;
    }

    private static enum IdocheckMessages implements IValidationMessage {

        Validate該当データなし(UrErrorMessages.該当データなし),
        Validate合法性(UrErrorMessages.入力値が不正_追加メッセージあり, "市町村コード"),
        Validate編集状態(UrErrorMessages.編集なしで更新不可),
        Validate既に登録済(UrErrorMessages.既に登録済, "市町村コード"),
        Validate既に存在(UrErrorMessages.既に存在, "市町村コード"),
        Validate削除不可(UrErrorMessages.削除不可, "市町村情報が他のDBにて使用されている");
        private final Message message;

        private IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
