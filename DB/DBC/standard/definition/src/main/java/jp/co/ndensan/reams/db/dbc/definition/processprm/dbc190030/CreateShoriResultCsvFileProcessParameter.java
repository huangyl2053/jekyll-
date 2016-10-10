/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc190030;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.taishosetaiinido.TaishoSetaiinIdoMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * ビジネス設計_DBC110065_基準収入額適用申請書_異動分作成_対象世帯員のプロセスパラメータです。
 *
 * @reamsid_L DBC-4640-080 xuzhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CreateShoriResultCsvFileProcessParameter implements IBatchProcessParameter {

    private RString 抽出条件;
    private RString 抽出対象;
    private FlexibleDate 世帯員把握基準日;
    private TaishoSetaiin 対象世帯員クラス;
    private FlexibleYear 処理年度;

    /**
     * CreateShoriResultCsvFileProcessParameterのコンストラクタです。
     *
     * @param 抽出条件 RString
     * @param 抽出対象 RString
     * @param 世帯員把握基準日 FlexibleDate
     * @param 対象世帯員クラス TaishoSetaiin
     * @param 処理年度 FlexibleYear
     */
    public CreateShoriResultCsvFileProcessParameter(RString 抽出条件,
            RString 抽出対象, FlexibleDate 世帯員把握基準日,
            TaishoSetaiin 対象世帯員クラス, FlexibleYear 処理年度) {
        this.抽出条件 = 抽出条件;
        this.抽出対象 = 抽出対象;
        this.世帯員把握基準日 = 世帯員把握基準日;
        this.対象世帯員クラス = 対象世帯員クラス;
        this.処理年度 = 処理年度;
    }

    /**
     * TaishoSetaiinIdoMybatisParameter取得です。
     *
     * @return TaishoSetaiinIdoMybatisParameter
     */
    public TaishoSetaiinIdoMybatisParameter toTaishoSetaiinIdoMybatisParameter() {
        return TaishoSetaiinIdoMybatisParameter.createMybatisParam(null, 処理年度);
    }
}
