/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteitsuchishohakko;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特徴仮算定通知書一括発行（バッチ）する用MybatisParameterクラスです。
 *
 * @reamsid_L DBB-0790-030 chenaoqi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoKaishiTsuchishoMybatisParameter implements IMyBatisParameter {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private FlexibleDate 発行日;
    private YMDHMS 帳票作成日時;
    private KarisanteiBatchEntity 出力帳票一覧Entity;
    private RString 出力対象;
    private boolean 一括発行起動フラグ;
    private FlexibleYear 調定年度minus1;
    private RString 出力順;
    private RString 科目コード;
    private RString 処理日;

    /**
     * コンストラクタ
     */
    public TokuchoKaishiTsuchishoMybatisParameter() {
    }

    /**
     * コンストラクタ
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 発行日 FlexibleDate
     * @param 帳票作成日時 YMDHMS
     * @param 出力帳票一覧Entity KarisanteiBatchEntity
     * @param 出力対象 RString
     * @param 一括発行起動フラグ boolean
     * @param 調定年度minus1 FlexibleYear
     * @param 科目コード RString
     * @param 処理日 RString
     */
    public TokuchoKaishiTsuchishoMybatisParameter(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            FlexibleDate 発行日,
            YMDHMS 帳票作成日時,
            KarisanteiBatchEntity 出力帳票一覧Entity,
            RString 出力対象,
            boolean 一括発行起動フラグ,
            FlexibleYear 調定年度minus1,
            RString 科目コード,
            RString 処理日) {
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.発行日 = 発行日;
        this.帳票作成日時 = 帳票作成日時;
        this.出力帳票一覧Entity = 出力帳票一覧Entity;
        this.出力対象 = 出力対象;
        this.一括発行起動フラグ = 一括発行起動フラグ;
        this.調定年度minus1 = 調定年度minus1;
        this.科目コード = 科目コード;
        this.処理日 = 処理日;
    }
}
