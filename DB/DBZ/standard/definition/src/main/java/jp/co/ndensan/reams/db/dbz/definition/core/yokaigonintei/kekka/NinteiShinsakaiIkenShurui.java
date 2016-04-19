/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定審査会意見種類を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum NinteiShinsakaiIkenShurui {

    /**
     * コード:1 名称:必要な療養への意見 略称:定義なし
     */
    必要な療養への意見("1", "必要な療養への意見"),
    /**
     * コード:2 名称:有効期間への意見 略称:定義なし
     */
    有効期間への意見("2", "有効期間への意見"),
    /**
     * コード:3 名称:サービス利用への意見 略称:定義なし
     */
    サービス利用への意見("3", "サービス利用への意見");

    private final RString code;
    private final RString fullName;

    private NinteiShinsakaiIkenShurui(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定審査会意見種類のコードを返します。
     *
     * @return 認定審査会意見種類のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認定審査会意見種類の名称を返します。
     *
     * @return 認定審査会意見種類の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定審査会意見種類のコードと一致する内容を探します。
     *
     * @param code 認定審査会意見種類のコード
     * @return {@code code} に対応する認定審査会意見種類
     */
    public static NinteiShinsakaiIkenShurui toValue(RString code) {

        for (NinteiShinsakaiIkenShurui ninteiShinsakaiIkenShurui : NinteiShinsakaiIkenShurui.values()) {
            if (ninteiShinsakaiIkenShurui.code.equals(code)) {
                return ninteiShinsakaiIkenShurui;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定審査会意見種類"));
    }
}
