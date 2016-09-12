/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.batchprm.seigoseichekkurisutosakusei;

import jp.co.ndensan.reams.db.dbz.definition.processprm.seigoseichekkurisutosakusei.SeigoseiChekkuProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 整合性チェックリストのバッチパラメータクラスです。
 *
 * @reamsid_L DBA-5800-010 zhangzhiming
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeigoseiChekkuBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = -9030429096189983750L;
    private static final String STANDARDYMD = "年齢到達の設定日";
    @BatchParameter(key = STANDARDYMD, name = "年齢到達の設定日")
    private FlexibleDate 年齢到達の設定日;

    /**
     * コンストラクタです。
     */
    public SeigoseiChekkuBatchParameter() {
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 年齢到達の設定日 年齢到達の設定日
     */
    public SeigoseiChekkuBatchParameter(FlexibleDate 年齢到達の設定日) {
        this.年齢到達の設定日 = 年齢到達の設定日;
    }

    /**
     * 整合性チェックリストプロセスパラメータークラス作成
     *
     * @return 整合性チェックリストプロセスパラメータークラス
     */
    public SeigoseiChekkuProcessParamter toSeigoseiBatchProcessParamter() {
        return new SeigoseiChekkuProcessParamter(年齢到達の設定日);
    }
}
