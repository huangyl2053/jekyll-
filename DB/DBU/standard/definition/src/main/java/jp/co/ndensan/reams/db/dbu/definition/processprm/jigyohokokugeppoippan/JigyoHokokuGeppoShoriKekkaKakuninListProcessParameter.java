/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppoippan;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.JigyoHokokuGeppoShoriKekkaKakuninListMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 一般状況1-11帳票出力のProcess用パラメータクラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoHokokuGeppoShoriKekkaKakuninListProcessParameter implements IBatchProcessParameter {

    private static final RString 選択する区分 = new RString("1");
    private final RString バッチID;
    private final RString 過去集計分旧市町村区分;
    private final RString 構成市町村区分;
    private final RString 旧市町村区分;
    private final FlexibleYearMonth 集計年月;
    private final List<RString> 構成市町村コードリスト;
    private final List<RString> 旧市町村コードリスト;
    private final YMDHMS 処理日時;

    /**
     * コンストラクタです。
     *
     * @param バッチID RString
     * @param 過去集計分旧市町村区分 RString
     * @param 構成市町村区分 RString
     * @param 旧市町村区分 RString
     * @param 集計年月 FlexibleYearMonth
     * @param 構成市町村コードリスト List<RString>
     * @param 旧市町村コードリスト List<RString>
     * @param 処理日時 YMDHMS
     */
    public JigyoHokokuGeppoShoriKekkaKakuninListProcessParameter(RString バッチID,
            RString 過去集計分旧市町村区分,
            RString 構成市町村区分,
            RString 旧市町村区分,
            FlexibleYearMonth 集計年月,
            List<RString> 構成市町村コードリスト,
            List<RString> 旧市町村コードリスト,
            YMDHMS 処理日時) {
        this.バッチID = バッチID;
        this.集計年月 = 集計年月;
        this.過去集計分旧市町村区分 = 過去集計分旧市町村区分;
        this.構成市町村区分 = 構成市町村区分;
        if (!選択する区分.equals(構成市町村区分)) {
            List<RString> list = new ArrayList<>();
            list.add(RString.EMPTY);
            this.構成市町村コードリスト = list;
        } else {
            this.構成市町村コードリスト = 構成市町村コードリスト;
        }
        this.旧市町村区分 = 旧市町村区分;
        if (!選択する区分.equals(旧市町村区分)) {
            List<RString> list = new ArrayList<>();
            list.add(RString.EMPTY);
            this.旧市町村コードリスト = list;
        } else {
            this.旧市町村コードリスト = 旧市町村コードリスト;
        }
        this.処理日時 = 処理日時;
    }

    /**
     * 事業報告統計データの帳票出力mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuGeppoIppanReportMybatisParameter
     */
    public JigyoHokokuGeppoShoriKekkaKakuninListMybatisParameter toJigyoHokokuGeppoShoriKekkaKakuninListMybatisParameter() {
        return new JigyoHokokuGeppoShoriKekkaKakuninListMybatisParameter(構成市町村区分, 旧市町村区分, 集計年月,
                構成市町村コードリスト, 旧市町村コードリスト);
    }

}
