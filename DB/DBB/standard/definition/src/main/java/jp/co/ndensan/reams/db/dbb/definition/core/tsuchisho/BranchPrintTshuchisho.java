/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ分岐通知書発行を表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 wangchao
 */
public enum BranchPrintTshuchisho {

    /**
     * コード:無 名称:発行しない 略称:発行処理する
     */
    発行処理する("発行処理する", "発行処理する"),
    /**
     * コード:無 名称:発行する 略称:発行処理しない
     */
    発行処理しない("発行処理しない", "発行処理しない");

    private final RString fullName;
    private final RString shortName;

    private BranchPrintTshuchisho(String fullname, String shortName) {
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * バッチ分岐通知書発行の名称を返します。
     *
     * @return バッチ分岐通知書発行の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * バッチ分岐通知書発行の略称を返します。
     *
     * @return バッチ分岐通知書発行の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * バッチ分岐通知書発行の名称と一致する内容を探します。
     *
     * @param fullname バッチ分岐通知書発行の名称
     * @return バッチ分岐通知書発行
     */
    public static BranchPrintTshuchisho toValue(RString fullname) {
        for (BranchPrintTshuchisho branchPrintTshuchisho : BranchPrintTshuchisho.values()) {
            if (branchPrintTshuchisho.get名称().equals(fullname)) {
                return branchPrintTshuchisho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("バッチ分岐通知書発行"));
    }
}
