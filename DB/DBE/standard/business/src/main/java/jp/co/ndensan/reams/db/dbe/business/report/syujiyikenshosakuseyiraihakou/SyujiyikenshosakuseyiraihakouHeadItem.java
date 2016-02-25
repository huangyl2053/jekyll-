/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 主治医意見書作成依頼発行一覧表ヘッダのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SyujiyikenshosakuseyiraihakouHeadItem {

    private final RString iraiHiFrom;
    private final RString iraiHiTo;
    private final RString syujiyiflag;

    /**
     * インスタンスを生成します。
     *
     * @param iraiHiFrom 依頼日From
     * @param iraiHiTo 依頼日To
     * @param syujiyiflag 主治医意見書作成FLG
     */
    public SyujiyikenshosakuseyiraihakouHeadItem(
            RString iraiHiFrom,
            RString iraiHiTo,
            RString syujiyiflag) {

        this.iraiHiFrom = iraiHiFrom;
        this.iraiHiTo = iraiHiTo;
        this.syujiyiflag = syujiyiflag;
    }
}
