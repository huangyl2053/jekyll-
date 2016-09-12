/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchotaishoshaichiransakusei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBBBZ81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-030 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoSeidokanIFSakuseiMyBatisParameter implements IMyBatisParameter {

    private RString shoriNendo;
    private RString shoriKyoNendo;
    private RString tsuchiNaiyoCode;
    private RString hosokuTsuki;

    /**
     * TokuchoSeidokanIFSakuseiMyBatisParameterのコンストラクタです。
     */
    public TokuchoSeidokanIFSakuseiMyBatisParameter() {
    }

    /**
     * TokuchoSeidokanIFSakuseiMyBatisParameterのコンストラクタです。
     *
     * @param shoriNendo shoriNendo
     * @param tsuchiNaiyoCode tsuchiNaiyoCode
     * @param hosokuTsuki hosokuTsuki
     */
    public TokuchoSeidokanIFSakuseiMyBatisParameter(FlexibleYear shoriNendo, RString tsuchiNaiyoCode, RString hosokuTsuki) {
        this.shoriNendo = shoriNendo == null ? RString.EMPTY : shoriNendo.toDateString();
        this.tsuchiNaiyoCode = tsuchiNaiyoCode;
        this.hosokuTsuki = hosokuTsuki;
    }

    /**
     * TokuchoSeidokanIFSakuseiMyBatisParameterのコンストラクタです。
     *
     * @param 処理年度 FlexibleYear
     */
    public TokuchoSeidokanIFSakuseiMyBatisParameter(FlexibleYear 処理年度) {
        if (処理年度 == null) {
            return;
        }
        this.shoriNendo = 処理年度.toDateString();
        this.shoriKyoNendo = 処理年度.minusYear(1).toDateString();
    }
}
