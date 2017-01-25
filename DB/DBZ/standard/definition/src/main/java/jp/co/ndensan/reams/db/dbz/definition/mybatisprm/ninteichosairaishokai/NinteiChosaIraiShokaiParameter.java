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

    private final RString hihokenshaNo;
    private final RString shokisaiHokenshaNo;
    private final RString shinseishoKanriNo;
    private final RString tujou;
    private final RString enki;

    private NinteiChosaIraiShokaiParameter(RString hihokenshaNo, RString shokisaiHokenshaNo, RString tujou, RString enki) {
        this.hihokenshaNo = hihokenshaNo;
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
        this.shinseishoKanriNo = RString.EMPTY;
        this.tujou = tujou;
        this.enki = enki;
    }
    
    private NinteiChosaIraiShokaiParameter(RString shinseishoKanriNo, RString tujou, RString enki) {
        this.hihokenshaNo = RString.EMPTY;
        this.shokisaiHokenshaNo = RString.EMPTY;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.tujou = tujou;
        this.enki = enki;
    }

    /**
     * パラメータ設定です
     *
     * @param hihokenshaNo
     * @param shokisaiHokenshaNo
     * @return NinteiChosaIraiShokaiParameter
     */
    public static NinteiChosaIraiShokaiParameter createParam(RString hihokenshaNo, RString shokisaiHokenshaNo) {
        return new NinteiChosaIraiShokaiParameter(hihokenshaNo,
                shokisaiHokenshaNo,
                ShoriJotaiKubun.通常.getコード(),
                ShoriJotaiKubun.延期.getコード());
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
     * @return 被保険者番号
     */
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }
    
    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public RString getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }
    
    /**
     * 申請書管理番号を返します。
     *
     * @return 証記載保険者番号
     */
    public RString getShinseishoKanriNo() {
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
