/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppoippan;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.TokuteiNyushoshaJohoSyoriMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 特定入所者管理情報処理のProcess用パラメータクラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuteiNyushoshaJohoSyoriProcessParameter implements IBatchProcessParameter {

    private final FlexibleYearMonth 集計年月;
    private final RString 出力ファイルPATH;

    /**
     * コンストラクタです。
     *
     * @param 集計年月 FlexibleYearMonth
     * @param 出力ファイルPATH RString
     */
    public TokuteiNyushoshaJohoSyoriProcessParameter(FlexibleYearMonth 集計年月,
            RString 出力ファイルPATH) {
        this.集計年月 = 集計年月;
        this.出力ファイルPATH = 出力ファイルPATH;
    }

    /**
     * 特定入所者管理情報処理mybatisのパラメータを生成します。
     *
     * @return TokuteiNyushoshaJohoSyoriMybatisParameter
     */
    public TokuteiNyushoshaJohoSyoriMybatisParameter toTokuteiNyushoshaJohoSyoriMybatisParameter() {
        TokuteiNyushoshaJohoSyoriMybatisParameter mybatisParameter = new TokuteiNyushoshaJohoSyoriMybatisParameter();
        mybatisParameter.setSyukeiYM(集計年月);
        return mybatisParameter;
    }

}
