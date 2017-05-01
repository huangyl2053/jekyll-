/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.util;

import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteiKanryoJohoManager;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 調査結果登録・意見書登録で用いるユーティリティです。
 */
public final class KekkaTorokuUtil {

    private KekkaTorokuUtil() {
    }

    /**
     * {@link #checkEditable(jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo)
     * }の結果です。
     */
    public enum CheckEditableResult {

        /**
         * 編集可能であることを表します。
         */
        編集可能,
        /**
         * 一次判定完了済みのため、編集できないことを表します。
         */
        一次判定完了済み(DbeErrorMessages.完了済みのため不可.getMessage().replace("一次判定", "処理")),
        /**
         * 審査結果登録完了済みのため、編集できなことを表します。
         */
        審査会結果登録完了済み(DbeErrorMessages.完了済みのため不可.getMessage().replace("審査会結果登録", "処理"));

        private final Message message;
        private final RString messageCode;

        CheckEditableResult() {
            this.message = null;
            this.messageCode = RString.EMPTY;
        }

        private CheckEditableResult(Message message) {
            this.message = message;
            this.messageCode = new RString(this.message.getCode());
        }

        /**
         * @return {@link #編集可能} のインスタンスである場合、{@code true}.
         */
        public boolean is編集可能() {
            return this == 編集可能;
        }

        /**
         * @return エラー内容を表すメッセージ.
         * {@link #is編集可能()}が{@code true}の場合、{@code null}.
         */
        public Message getMessage() {
            return this.message;
        }

        /**
         * @return エラー内容を表すメッセージのコード.
         * {@link #is編集可能()}が{@code true}の場合、{@link RString#EMPTY}.
         */
        public RString getMessageCode() {
            return this.messageCode;
        }
    }

    /**
     * @param 申請書管理番号 申請書管理番号
     * @return 指定の申請について、編集可能かどうかを検査した結果
     */
    public static CheckEditableResult checkEditable(ShinseishoKanriNo 申請書管理番号) {
        NinteiKanryoJoho kj = NinteiKanryoJohoManager.createInstance().get要介護認定完了情報(申請書管理番号);
        if (!isNullOrEmpty(kj.get認定審査会完了年月日())) {
            return CheckEditableResult.審査会結果登録完了済み;
        }
        ShichosonSecurityJoho sj = ShichosonSecurityJohoFinder.createInstance()
                .getShichosonSecurityJoho(GyomuBunrui.介護認定);
        if (!isNullOrEmpty(kj.get要介護認定一次判定完了年月日()) && (sj == null || !sj.get市町村情報().get市町村識別ID().is広域s())) {
            return CheckEditableResult.一次判定完了済み;
        }
        return CheckEditableResult.編集可能;
    }

    private static boolean isNullOrEmpty(FlexibleDate fDate) {
        return fDate == null || fDate.isEmpty();
    }

}
