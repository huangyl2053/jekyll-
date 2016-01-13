/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.TokeiTaishoKubun;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告集計一覧データの取得処理のMyBatisパラメタークラスです。
 *
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoHokokuNenpoParameter {

    private final FlexibleYear hokokuYSeireki;
    private boolean usehokokuYSeireki = false;
    private final LasdecCode shichosonCode;
    private boolean useshichosonCode = false;
    private final RString hokensilyakbn;
    private boolean usehokensilyakbn = false;
    private boolean usehokensilyakbnShichoson = false;
    private boolean usehokensilyakbnKyuShichoson = false;

    private JigyoHokokuNenpoParameter(FlexibleYear 年度, LasdecCode 市町村コード, RString 保険者区分) {
        usehokokuYSeireki = 年度 != null && !年度.isEmpty();
        useshichosonCode = 市町村コード != null && !市町村コード.isEmpty();
        usehokensilyakbn = 保険者区分 != null && !保険者区分.isEmpty();
        if (TokeiTaishoKubun.保険者分.getコード().equals(保険者区分) || TokeiTaishoKubun.構成市町村分.getコード().equals(保険者区分)) {
            usehokensilyakbnShichoson = true;
        }
        if (TokeiTaishoKubun.旧市町村分.getコード().equals(保険者区分)) {
            usehokensilyakbnKyuShichoson = true;
        }
        this.hokokuYSeireki = 年度;
        this.shichosonCode = 市町村コード;
        this.hokensilyakbn = 保険者区分;
    }

    /**
     * 事業報告集計一覧データの取得処理のパラメターを生成します。
     *
     * @param 年度 年度
     * @param 市町村コード 市町村コード
     * @param 保険者区分 保険者区分
     * @return JigyoHokokuNenpoParameter 事業報告集計一覧データの取得処理のパラメター
     */
    public static JigyoHokokuNenpoParameter createParameterForJigyoHokokuNenpo(FlexibleYear 年度, LasdecCode 市町村コード, RString 保険者区分) {
        return new JigyoHokokuNenpoParameter(年度, 市町村コード, 保険者区分);
    }
}
