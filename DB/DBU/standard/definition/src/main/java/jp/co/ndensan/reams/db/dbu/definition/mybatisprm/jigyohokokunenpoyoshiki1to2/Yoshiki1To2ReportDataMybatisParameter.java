/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.HyoNo;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNoyoshiki2;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 事業状況報告年報　様式１・２のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBU-5610-030 chengsanyuan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class Yoshiki1To2ReportDataMybatisParameter implements IMyBatisParameter {

    private final List<RString> 集計番号List;
    private final List<RString> 表番号List;
    private final List<RString> 市町村コードList;
    private final RString 集計年月;

    private static final RString 年月_00 = new RString("00");
    private static final RString 過去集計分市町村区分_市町村 = new RString("2");
    private static final RString 過去集計分市町村区分_旧市町村 = new RString("1");
    private static final RString 集計番号フラグ_被保険者数 = new RString("1");
    private static final RString 集計番号フラグ_所得段階 = new RString("2");
    private static final RString 集計番号フラグ_市町村特別給付件数 = new RString("3");
    private static final RString 集計番号フラグ_市町村特別給付費用額 = new RString("4");
    private static final RString 集計番号フラグ_市町村特別給付給付額 = new RString("5");

    /**
     * コンストラクタです。
     */
    private Yoshiki1To2ReportDataMybatisParameter(List<RString> 集計番号List,
            List<RString> 表番号List, List<RString> 市町村コードList, RString 集計年月) {
        this.集計番号List = 集計番号List;
        this.表番号List = 表番号List;
        this.市町村コードList = 市町村コードList;
        this.集計年月 = 集計年月;
    }

    /**
     * 事業状況報告年報　様式１・２の帳票作成のパラメータを生成します。
     *
     * @param 過去集計分市町村区分 過去集計分市町村区分
     * @param 市町村コード 市町村コード
     * @param 構成市町村コードList 構成市町村コードList
     * @param 旧市町村コードList 旧市町村コードList
     * @param 集計年度 集計年度
     * @param 集計番号フラグ 集計番号フラグ
     *
     * @return Yoshiki1To2ReportDataMybatisParameter
     */
    public static Yoshiki1To2ReportDataMybatisParameter createGetReportDataParam(
            RString 過去集計分市町村区分, RString 市町村コード, List<RString> 構成市町村コードList,
            List<RString> 旧市町村コードList, RString 集計年度, RString 集計番号フラグ) {
        List<RString> 市町村コードList = new ArrayList<>();
        List<RString> 表番号List = new ArrayList<>();
        if (RString.isNullOrEmpty(過去集計分市町村区分)) {
            市町村コードList.add(市町村コード);
            表番号List.add(HyoNo.現物_一般状況.getコード());
        } else if (過去集計分市町村区分_市町村.equals(過去集計分市町村区分) && 構成市町村コードList != null) {
            市町村コードList.addAll(構成市町村コードList);
            表番号List.add(HyoNo.現物_一般状況.getコード());
        } else if (過去集計分市町村区分_旧市町村.equals(過去集計分市町村区分) && 旧市町村コードList != null) {
            市町村コードList.addAll(旧市町村コードList);
            表番号List.add(HyoNo.現物_一般状況_旧市町村.getコード());
        }
        return new Yoshiki1To2ReportDataMybatisParameter(get集計番号List(集計番号フラグ),
                表番号List, 市町村コードList, 集計年度.concat(年月_00));
    }

    private static List<RString> get集計番号List(RString 集計番号フラグ) {
        List<RString> 集計番号List = new ArrayList<>();
        if (集計番号フラグ_被保険者数.equals(集計番号フラグ)) {
            集計番号List.add(ShukeiNo.別紙_1_第1号被保険者のいる世帯数.getコード());
            集計番号List.add(ShukeiNo.一般状況_1_第1号被保険者数.getコード());
            集計番号List.add(ShukeiNo.一般状況_2_第1号被保険者増減内訳_当月中増.getコード());
            集計番号List.add(ShukeiNo.一般状況_2_第2号被保険者増減内訳_当月中減.getコード());
        } else if (集計番号フラグ_所得段階.equals(集計番号フラグ)) {
            集計番号List.add(ShukeiNo.一般状況_4_所得段階別第１号被保険者数.getコード());
        } else if (集計番号フラグ_市町村特別給付件数.equals(集計番号フラグ)) {
            集計番号List.add(ShukeiNoyoshiki2.市町村特別給付_件数.getコード());
        } else if (集計番号フラグ_市町村特別給付費用額.equals(集計番号フラグ)) {
            集計番号List.add(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード());
        } else if (集計番号フラグ_市町村特別給付給付額.equals(集計番号フラグ)) {
            集計番号List.add(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード());
        }
        return 集計番号List;
    }
}
