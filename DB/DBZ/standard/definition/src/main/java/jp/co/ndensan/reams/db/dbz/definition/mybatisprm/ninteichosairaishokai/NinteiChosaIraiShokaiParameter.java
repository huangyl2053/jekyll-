/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ninteichosairaishokai;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査情報を取得するのParameterクラスです。
 *
 * @reamsid_L DBE-0200-020 zhangguopeng
 */
public final class NinteiChosaIraiShokaiParameter {

    private final RString shinseishoKanriNo;
    private final RString tujou;
    private final RString enki;

    private NinteiChosaIraiShokaiParameter(RString shinseishoKanriNo, RString tujou, RString enki) {
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.tujou = tujou;
        this.enki = enki;
    }

    /**
     * パラメータ設定です
     *
     * @param shinseishoKanriNo
     * @return NinteiChosaIraiShokaiParameter
     */
    public static NinteiChosaIraiShokaiParameter createParam(RString shinseishoKanriNo) {
        return new NinteiChosaIraiShokaiParameter(shinseishoKanriNo,
                ShoriJotaiKubun.通常.getコード(),
                ShoriJotaiKubun.延期.getコード());
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public RString getHihokenshaNo() {
        return shinseishoKanriNo;
    }

    /**
     * 処理状態区分（通常）を返します。
     *
     * @return 処理状態区分（通常）
     */
    public RString getTujou() {
        return tujou;
    }

    /**
     * 処理状態区分（延期）を返します。
     *
     * @return 処理状態区分（延期）
     */
    public RString getEnki() {
        return enki;
    }
}
