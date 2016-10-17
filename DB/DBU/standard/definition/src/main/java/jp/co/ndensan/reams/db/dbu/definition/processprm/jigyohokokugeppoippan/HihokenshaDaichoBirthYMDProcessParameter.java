/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppoippan;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.HihokenshaDaichoBirthYMDMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 被保台帳生年月日情報処理のProcess用パラメータクラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaDaichoBirthYMDProcessParameter implements IBatchProcessParameter {

    private final YMDHMS 処理日時;
    private final FlexibleYearMonth 集計年月;
    private final RString 出力ファイルPATH;

    /**
     * コンストラクタです。
     *
     * @param 処理日時 YMDHMS
     * @param 集計年月 FlexibleYearMonth
     * @param 出力ファイルPATH RString
     */
    public HihokenshaDaichoBirthYMDProcessParameter(YMDHMS 処理日時,
            FlexibleYearMonth 集計年月,
            RString 出力ファイルPATH) {
        this.処理日時 = 処理日時;
        this.集計年月 = 集計年月;
        this.出力ファイルPATH = 出力ファイルPATH;
    }

    /**
     * 被保台帳生年月日情報処理mybatisのパラメータを生成します。
     *
     * @return HihokenshaDaichoBirthYMDMybatisParameter
     */
    public HihokenshaDaichoBirthYMDMybatisParameter toHihokenshaDaichoBirthYMDMybatisParameter() {
        HihokenshaDaichoBirthYMDMybatisParameter mybatisParameter = new HihokenshaDaichoBirthYMDMybatisParameter();
        mybatisParameter.setSyoriNitiji(処理日時);
        mybatisParameter.setSyukeiYM(集計年月);
        return mybatisParameter;
    }

}
