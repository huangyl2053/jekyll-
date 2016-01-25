/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 決定情報登録更新MyBatisパラメータクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SyokanbaraihiShikyuShinseiKetteEntity {

    private final JigyoshaNo 事業者番号;
    private final RString 証明書コード;
    private final RString 明細番号;
    private final RString 連番;
    private final int 差額金額;
    private final RString テーブル区分;

    /**
     * コンストラクタです。
     *
     * @param 事業者番号
     * @param 証明書コード
     * @param 明細番号
     * @param 連番
     * @param 差額金額
     * @param テーブル区分
     */
    protected SyokanbaraihiShikyuShinseiKetteEntity(JigyoshaNo 事業者番号, RString 証明書コード,
            RString 明細番号, RString 連番, int 差額金額, RString テーブル区分) {
        this.事業者番号 = 事業者番号;
        this.証明書コード = 証明書コード;
        this.明細番号 = 明細番号;
        this.連番 = 連番;
        this.差額金額 = 差額金額;
        this.テーブル区分 = テーブル区分;
    }

    /**
     * コンストラクタです。
     *
     * @param 事業者番号
     * @param 証明書コード
     * @param 明細番号
     * @param 連番
     * @param 差額金額
     * @param テーブル区分
     * @return
     */
    public static SyokanbaraihiShikyuShinseiKetteEntity createSelectByKeyParam(JigyoshaNo 事業者番号,
            RString 証明書コード, RString 明細番号, RString 連番, int 差額金額, RString テーブル区分) {
        return new SyokanbaraihiShikyuShinseiKetteEntity(事業者番号, 証明書コード, 明細番号, 連番, 差額金額,
                テーブル区分);
    }
}
