/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 特別地域加算減免申請（画面）のViewStateクラスです。
 *
 * @reamsid_L DBD-3680-010 miaojin
 */
public class TokubetsuChiikiKasanGemmenViewState implements Serializable {

    private final TokubetsuchiikiKasanGemmen 特別地域加算減免申請情報;
    private final EntityDataState state;
    private final int shorigoRirekiNo;

    /**
     * コンストラクタです。
     *
     * @param 特別地域加算減免申請情報 特別地域加算減免申請情報
     * @param state EntityDataState
     * @param shorigoRirekiNo 履歴番号
     */
    public TokubetsuChiikiKasanGemmenViewState(TokubetsuchiikiKasanGemmen 特別地域加算減免申請情報, EntityDataState state, int shorigoRirekiNo) {
        this.特別地域加算減免申請情報 = 特別地域加算減免申請情報;
        this.state = state;
        this.shorigoRirekiNo = shorigoRirekiNo;
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TokubetsuChiikiKasanGemmenViewStateBuilder createBuilderForEdit() {
        return new TokubetsuChiikiKasanGemmenViewStateBuilder(特別地域加算減免申請情報, state, shorigoRirekiNo);
    }

    /**
     * 業務概念「特別地域加算減免申請の情報」を取得します。
     *
     * @return 利用者負担額減額
     */
    public TokubetsuchiikiKasanGemmen getTokubetsuchiikiKasanGemmen() {
        return 特別地域加算減免申請情報;
    }

    /**
     * EntityDataStateを取得します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return state;
    }

    /**
     * 履歴番号を取得します。
     *
     * @return 履歴番号
     */
    public int getShorigoRirekiNo() {
        return shorigoRirekiNo;
    }
}
