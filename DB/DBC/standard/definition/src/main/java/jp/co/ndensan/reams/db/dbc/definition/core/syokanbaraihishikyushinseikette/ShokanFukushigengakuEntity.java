/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 社福軽減額登録更新処理MyBatisパラメータクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanFukushigengakuEntity {

    private final RString 連番;
    private final Decimal 軽減率;
    private final ServiceShuruiCode サービス種類コード;
    private final int 受領すべき利用者負担の総額;
    private final int 軽減額;
    private final int 軽減後利用者負担額;
    private final RString 備考;
    private final RString 状態;

    /**
     * コンストラクタです。
     *
     * @param 連番
     * @param 軽減率
     * @param サービス種類コード
     * @param 受領すべき利用者負担の総額
     * @param 軽減額
     * @param 軽減後利用者負担額
     * @param 備考
     * @param 状態
     */
    protected ShokanFukushigengakuEntity(RString 連番, Decimal 軽減率,
            ServiceShuruiCode サービス種類コード, int 受領すべき利用者負担の総額, int 軽減額,
            int 軽減後利用者負担額, RString 備考, RString 状態) {
        this.連番 = 連番;
        this.軽減率 = 軽減率;
        this.サービス種類コード = サービス種類コード;
        this.受領すべき利用者負担の総額 = 受領すべき利用者負担の総額;
        this.軽減額 = 軽減額;
        this.軽減後利用者負担額 = 軽減後利用者負担額;
        this.備考 = 備考;
        this.状態 = 状態;
    }

    /**
     * コンストラクタです。
     *
     * @param 連番
     * @param 軽減率
     * @param サービス種類コード
     * @param 受領すべき利用者負担の総額
     * @param 軽減額
     * @param 軽減後利用者負担額
     * @param 備考
     * @param 状態
     * @return
     */
    public static ShokanFukushigengakuEntity createSelectByKeyParam(RString 連番, Decimal 軽減率,
            ServiceShuruiCode サービス種類コード, int 受領すべき利用者負担の総額, int 軽減額, int 軽減後利用者負担額,
            RString 備考, RString 状態) {
        return new ShokanFukushigengakuEntity(連番, 軽減率, サービス種類コード,
                受領すべき利用者負担の総額, 軽減額, 軽減後利用者負担額, 備考, 状態);
    }
}
