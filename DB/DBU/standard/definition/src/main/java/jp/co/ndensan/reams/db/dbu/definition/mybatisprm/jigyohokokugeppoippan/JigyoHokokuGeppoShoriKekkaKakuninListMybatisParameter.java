/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 処理結果確認リスト帳票出力のMybatisパラメータクラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoHokokuGeppoShoriKekkaKakuninListMybatisParameter implements IMyBatisParameter {

    private RString koseiShichosonKbn;
    private RString kyuShichosonKbn;
    private List<RString> koseiShichosonList;
    private List<RString> kyuShichosonList;
    private FlexibleYearMonth syukeiYM;

    /**
     * コンストラクタです。
     *
     * @param 構成市町村区分 RString
     * @param 旧市町村区分 RString
     * @param 集計年月 FlexibleYearMonth
     * @param 構成市町村コードList List<RString>
     * @param 旧市町村コードList List<RString>
     */
    public JigyoHokokuGeppoShoriKekkaKakuninListMybatisParameter(RString 構成市町村区分,
            RString 旧市町村区分,
            FlexibleYearMonth 集計年月,
            List<RString> 構成市町村コードList,
            List<RString> 旧市町村コードList) {
        this.koseiShichosonKbn = 構成市町村区分;
        this.kyuShichosonKbn = 旧市町村区分;
        this.koseiShichosonList = 構成市町村コードList;
        this.kyuShichosonList = 旧市町村コードList;
        this.syukeiYM = 集計年月;
    }

}
