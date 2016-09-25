/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180030;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180020.DBC180020_IdoRiyoshaFutanwariaiHanteiParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 異動分利用者負担割合判定（過年度）バッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-4940-030 wangrenze
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC180030_KanendoRiyoshaFutanwariaiHanteiParameter extends BatchParameterBase {

    private static final String KEY_対象年度 = "対象年度";
    private static final String KEY_基準日 = "市町村コード";
    private static final String KEY_抽出開始日時 = "抽出開始日時";
    private static final String KEY_抽出終了日時 = "抽出終了日時";
    private static final String KEY_年度終了年月日 = "年度終了年月日";
    private static final String KEY_処理日時 = "処理日時";
    private static final String KEY_抽出回数 = "抽出回数";
    private static final RString 異動 = new RString("2");
    private static final RString 過年度 = new RString("3");
    private static final int INT_5 = 5;
    private static final FlexibleYear 年度 = new FlexibleYear("2015");
    @BatchParameter(key = KEY_対象年度, name = "対象年度")
    private FlexibleYear 対象年度;
    @BatchParameter(key = KEY_基準日, name = "基準日")
    private RDate 基準日;
    @BatchParameter(key = KEY_抽出開始日時, name = "抽出開始日時")
    private RDateTime 抽出開始日時;
    @BatchParameter(key = KEY_抽出終了日時, name = "抽出終了日時")
    private RDateTime 抽出終了日時;
    @BatchParameter(key = KEY_年度終了年月日, name = "年度終了年月日")
    private FlexibleDate 年度終了年月日;
    @BatchParameter(key = KEY_処理日時, name = "処理日時")
    private RDateTime 処理日時;
    @BatchParameter(key = KEY_抽出回数, name = "抽出回数")
    private int 抽出回数;

    /**
     * コンストラクタです。
     */
    public DBC180030_KanendoRiyoshaFutanwariaiHanteiParameter() {
    }

    /**
     * processのパラメータを生成します。
     *
     * @return parameter DBC180020_IdoRiyoshaFutanwariaiHanteiParameter
     */
    public DBC180020_IdoRiyoshaFutanwariaiHanteiParameter toIdoDateTyuushutuKyoutsuuParameter() {
        DBC180020_IdoRiyoshaFutanwariaiHanteiParameter parameter = new DBC180020_IdoRiyoshaFutanwariaiHanteiParameter();
        parameter.setTaishoNendo(対象年度.minusYear(抽出回数));
        if (抽出回数 == 1) {
            parameter.setKijunbi(new FlexibleDate(基準日.toDateString()));
        }
        if (1 < 抽出回数) {
            RString 前回終了date = 対象年度.minusYear(抽出回数 - 1).toDateString().concat(new RString("0731"));
            parameter.setKijunbi(new FlexibleDate(前回終了date));
        }
        parameter.setShoriKubun(異動);
        parameter.setChushutsuKaishiNichiji(抽出開始日時);
        parameter.setChushutsuShuryonichiNichiji(抽出終了日時);
        parameter.setTestMode(true);
        parameter.setNendoShuryoNengappi(年度終了年月日);
        parameter.setShoriNichiji(処理日時);
        parameter.setChushutuKaisu(抽出回数);
        return parameter;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return parameter DBC180020_IdoRiyoshaFutanwariaiHanteiParameter
     */
    public DBC180020_IdoRiyoshaFutanwariaiHanteiParameter toRiyoshaFutanwariaiHanteiCommonFlowParameter() {
        DBC180020_IdoRiyoshaFutanwariaiHanteiParameter parameter = new DBC180020_IdoRiyoshaFutanwariaiHanteiParameter();
        parameter.setTaishoNendo(対象年度.minusYear(抽出回数));
        if (抽出回数 == 1) {
            parameter.setKijunbi(new FlexibleDate(基準日.toDateString()));
        }
        if (1 < 抽出回数) {
            parameter.setKijunbi(get基準日(抽出回数));
        }
        parameter.setShoriKubun(異動);
        parameter.setTestMode(true);
        parameter.setChushutuKaisu(抽出回数);
        return parameter;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return parameter DBC180020_IdoRiyoshaFutanwariaiHanteiParameter
     */
    public DBC180020_IdoRiyoshaFutanwariaiHanteiParameter toFutanWariaiIchiranFlowParameter() {
        DBC180020_IdoRiyoshaFutanwariaiHanteiParameter parameter = new DBC180020_IdoRiyoshaFutanwariaiHanteiParameter();
        parameter.setTaishoNendo(対象年度);
        parameter.setShoriKubun(過年度);
        parameter.setNendoShuryoNengappi(年度終了年月日);
        parameter.setShoriNichiji(処理日時);
        return parameter;
    }

    /**
     * 最大ループ回数を設定します。
     *
     * @return 最大ループ回数 最大ループ回数
     */
    public int get最大ループ回数() {
        if (対象年度.compareTo(年度) < INT_5) {
            return 対象年度.getYearValue() - 年度.getYearValue();
        }
        return INT_5;
    }

    private FlexibleDate get基準日(int ループ回数) {
        return new FlexibleDate(対象年度.minusYear(ループ回数).toDateString().concat(new RString("0731")));
    }
}
