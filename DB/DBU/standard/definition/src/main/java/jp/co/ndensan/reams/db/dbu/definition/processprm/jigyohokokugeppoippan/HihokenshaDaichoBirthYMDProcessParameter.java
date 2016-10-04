/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppoippan;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.HihokenshaDaichoBirthYMDMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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

    private static final int LENGTH集計番号 = 4;
    private final YMDHMS 処理日時;
    private final FlexibleYearMonth 集計年月;
    private final RString 作成CSVファイルID;
    private final RString 出力ファイルPATH;

    /**
     * コンストラクタです。
     *
     * @param 処理日時 YMDHMS
     * @param 集計年月 FlexibleYearMonth
     * @param 作成CSVファイルID RString
     * @param 出力ファイルPATH RString
     */
    public HihokenshaDaichoBirthYMDProcessParameter(YMDHMS 処理日時,
            FlexibleYearMonth 集計年月,
            RString 作成CSVファイルID,
            RString 出力ファイルPATH) {
        this.処理日時 = 処理日時;
        this.集計年月 = 集計年月;
        this.作成CSVファイルID = 作成CSVファイルID;
        this.出力ファイルPATH = 出力ファイルPATH;
    }

    /**
     * 被保台帳生年月日情報処理mybatisのパラメータを生成します。
     *
     * @return HihokenshaDaichoBirthYMDMybatisParameter
     */
    public HihokenshaDaichoBirthYMDMybatisParameter toHihokenshaDaichoBirthYMDMybatisParameter() {
        return new HihokenshaDaichoBirthYMDMybatisParameter(
                処理日時, 集計年月, new Code(作成CSVファイルID.substring(作成CSVファイルID.length() - LENGTH集計番号)));
    }

}
