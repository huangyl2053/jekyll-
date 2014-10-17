/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hokensha;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;

/**
 * {@link IHokensha IHokensha}の実装です。
 *
 * @author N3327 三浦 凌
 */
public final class Hokensha implements IHokensha {

    private final ShoKisaiHokenshaNo hokenshaNo;
    private final AtenaJusho jusho;
    private final YubinNo yubinNo;
    private final TelNo telNo;

    /**
     * 保険者を生成します。
     *
     * @param hokenshaNo 証記載保険者番号
     * @param jusho 住所
     * @param yubinNo 郵便番号
     * @param telNo 電話番号
     */
    public Hokensha(ShoKisaiHokenshaNo hokenshaNo, AtenaJusho jusho, YubinNo yubinNo, TelNo telNo) {
        this.hokenshaNo = Objects.requireNonNull(hokenshaNo);
        this.jusho = Objects.requireNonNull(jusho);
        this.yubinNo = Objects.requireNonNull(yubinNo);
        this.telNo = Objects.requireNonNull(telNo);
    }

    @Override
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return this.hokenshaNo;
    }

    @Override
    public AtenaJusho get住所() {
        return this.jusho;
    }

    @Override
    public YubinNo get郵便番号() {
        return this.yubinNo;
    }

    @Override
    public TelNo get電話番号() {
        return this.telNo;
    }
}
