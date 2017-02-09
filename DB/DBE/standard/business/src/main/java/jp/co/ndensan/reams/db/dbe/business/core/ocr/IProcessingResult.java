/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR取込での各処理の結果を保持することを表します。
 */
public interface IProcessingResult {

    /**
     * @return 処理結果の種類
     */
    IProcessingResult.Type type();

    /**
     * @return 備考
     */
    RString note();

    /**
     * @return 対象行
     */
    IOcrData ocrData();

    /**
     * 処理結果の種類を表す列挙です。
     */
    public enum Type {

        /**
         * 成功
         */
        SUCCESS("成功", 3),
        /**
         * エラー
         */
        ERROR("エラー", 1),
        /**
         * 警告
         * <p/>
         * 「警告」は、処理を継続するという点で、エラーと異なる。
         */
        WARNING("警告", 2);

        private final RString theName;
        private final int theCode;

        private Type(String name, int code) {
            this.theName = new RString(name);
            this.theCode = code;
        }

        /**
         * @return 名称
         */
        public RString getName() {
            return this.theName;
        }

        /**
         * @return {@link Type#SUCCESS}である場合、{@code true}
         */
        public boolean isSuccess() {
            return this == Type.SUCCESS;
        }

        /**
         * @return コード
         */
        public int code() {
            return this.theCode;
        }

        /**
         * @return {@link Type#ERROR}である場合、{@code true}
         */
        public boolean isError() {
            return this == ERROR;
        }

        /**
         * @return {@link Type#WARNING}である場合、{@code true}
         */
        public boolean isWarning() {
            return this == Type.WARNING;
        }
    }
}
