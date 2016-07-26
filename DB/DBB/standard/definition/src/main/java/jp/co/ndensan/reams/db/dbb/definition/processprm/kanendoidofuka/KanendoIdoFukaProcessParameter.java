/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.kanendoidofuka;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidokanendofuka.KanendoFukaParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本算定異動（過年度）のprocessParameter
 *
 * @reamsid_L DBB-0910-010 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KanendoIdoFukaProcessParameter implements IBatchProcessParameter {

    private RString 日付関連_年度サイクル;
    private FlexibleYear 調定年度;
    private RString 処理対象;
    private RDateTime 抽出開始日時;
    private RDateTime 抽出終了日時;
    private Long 出力順ID;
    private YMDHMS システム日時;

    /**
     * コンストラクタです。
     *
     * @param 日付関連_年度サイクル RString
     * @param 調定年度 FlexibleYear
     * @param 処理対象 RString
     * @param 抽出開始日時 RDateTime
     * @param 抽出終了日時 RDateTime
     * @param 出力順ID Long
     * @param システム日時 YMDHMS
     */
    public KanendoIdoFukaProcessParameter(RString 日付関連_年度サイクル, FlexibleYear 調定年度, RString 処理対象,
            RDateTime 抽出開始日時, RDateTime 抽出終了日時, Long 出力順ID, YMDHMS システム日時) {
        this.日付関連_年度サイクル = 日付関連_年度サイクル;
        this.調定年度 = 調定年度;
        this.処理対象 = 処理対象;
        this.抽出開始日時 = 抽出開始日時;
        this.抽出終了日時 = 抽出終了日時;
        this.出力順ID = 出力順ID;
        this.システム日時 = システム日時;
    }

    /**
     * MybatisParameterのメソッドです。
     *
     * @return 本算定異動（過年度）のMybatisParameter
     */
    public KanendoFukaParameter toKanendoIdoFukaProcessParameter() {
        KanendoFukaParameter mybatisParameter = new KanendoFukaParameter();
        mybatisParameter.set調定年度(調定年度);
        mybatisParameter.set抽出開始日時(抽出開始日時);
        mybatisParameter.set抽出終了日時(抽出終了日時);
        mybatisParameter.set出力順ID(出力順ID);
        mybatisParameter.setシステム日時(システム日時);
        mybatisParameter.set日付関連_年度サイクル(日付関連_年度サイクル);
        return mybatisParameter;
    }

}
