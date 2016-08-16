/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saisinsaketeijyohou;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再審査決定情報のMybatisパラメータクラスです。
 *
 * @reamsid_L DBC-3040-010 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class TaishoshaKensakuParameter implements IMyBatisParameter {

    private final RString 取扱年月;
    private final RString 保険者区分;
    private final int 履歴番号;
    private final RString 市町村コード;
    private final boolean 履歴番号フラグ;
    private final boolean 市町村フラグ;

    /**
     * コンストラクタです。
     *
     * @param 取扱年月 取扱年月
     * @param 保険者区分 保険者区分
     * @param 履歴番号 履歴番号
     * @param 市町村コード 市町村コード
     * @param 履歴番号フラグ 履歴番号フラグ
     * @param 市町村フラグ 市町村フラグ
     */
    protected TaishoshaKensakuParameter(RString 取扱年月, RString 保険者区分, int 履歴番号, RString 市町村コード,
            boolean 履歴番号フラグ, boolean 市町村フラグ) {
        this.取扱年月 = 取扱年月;
        this.保険者区分 = 保険者区分;
        this.履歴番号 = 履歴番号;
        this.市町村コード = 市町村コード;
        this.履歴番号フラグ = 履歴番号フラグ;
        this.市町村フラグ = 市町村フラグ;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param 取扱年月 取扱年月
     * @param 保険者区分 保険者区分
     * @param 履歴番号 履歴番号
     * @param 市町村コード 市町村コード
     * @param 履歴番号フラグ 履歴番号フラグ
     * @param 市町村フラグ 市町村フラグ
     * @return TaishoshaKensakuParameter
     */
    public static TaishoshaKensakuParameter creatParameter(RString 取扱年月, RString 保険者区分, int 履歴番号, RString 市町村コード,
            boolean 履歴番号フラグ, boolean 市町村フラグ) {
        return new TaishoshaKensakuParameter(取扱年月, 保険者区分, 履歴番号, 市町村コード, 履歴番号フラグ, 市町村フラグ);
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param 取扱年月 取扱年月
     * @param 市町村コード 市町村コード
     * @param 市町村フラグ 市町村フラグ
     * @return TaishoshaKensakuParameter
     */
    public static TaishoshaKensakuParameter creatRirekiParameter(RString 取扱年月, RString 市町村コード, boolean 市町村フラグ) {
        return new TaishoshaKensakuParameter(取扱年月, RString.EMPTY, 0, 市町村コード, false, 市町村フラグ);
    }
}
