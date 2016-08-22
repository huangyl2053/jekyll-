/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.sofujoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 過誤申立送付情報照会のMybatisパラメータクラスです。
 *
 * @reamsid_L DBC-2950-030 jinjue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class SofujohoMybatisParameter {

    private final boolean 送付年月フラグ;
    private final boolean 保険者番号フラグ;
    private final RString 送付年月;
    private final RString 申立書区分コード;
    private final RString 市町村コード;
    private final RString 証記載保険者番号;

    /**
     * コンストラクタです。
     *
     * @param 送付年月 送付年月
     * @param 申立書区分コード 申立書区分コード
     * @param 市町村コード 市町村コード
     * @param 送付年月フラグ 送付年月フラグ
     * @param 保険者番号フラグ 保険者番号フラグ
     * @param 証記載保険者番号 証記載保険者番号
     */
    protected SofujohoMybatisParameter(RString 送付年月, RString 申立書区分コード, RString 市町村コード,
            boolean 送付年月フラグ, boolean 保険者番号フラグ, RString 証記載保険者番号) {
        this.送付年月 = 送付年月;
        this.申立書区分コード = 申立書区分コード;
        this.市町村コード = 市町村コード;
        this.送付年月フラグ = 送付年月フラグ;
        this.保険者番号フラグ = 保険者番号フラグ;
        this.証記載保険者番号 = 証記載保険者番号;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param 送付年月 送付年月
     * @param 申立書区分コード 申立書区分コード
     * @param 市町村コード 市町村コード
     * @param 送付年月フラグ 送付年月フラグ
     * @param 保険者番号フラグ 保険者番号フラグ
     * @param 証記載保険者番号 証記載保険者番号
     * @return パラメータ
     */
    public static SofujohoMybatisParameter creatParameter(RString 送付年月, RString 申立書区分コード, RString 市町村コード,
            boolean 送付年月フラグ, boolean 保険者番号フラグ, RString 証記載保険者番号) {
        return new SofujohoMybatisParameter(送付年月, 申立書区分コード, 市町村コード, 送付年月フラグ, 保険者番号フラグ, 証記載保険者番号);
    }
}
