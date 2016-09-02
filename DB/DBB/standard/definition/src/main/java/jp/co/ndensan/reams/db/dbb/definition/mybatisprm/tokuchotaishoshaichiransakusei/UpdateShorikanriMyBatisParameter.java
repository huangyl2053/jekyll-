/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchotaishoshaichiransakusei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * DBB-1830-040バッチ設計_DBBBT84001_特徴制度間Ｉ／ＦのMyBatisParameterクラスです。
 *
 * @reamsid_L DBB-1830-040 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class UpdateShorikanriMyBatisParameter implements IMyBatisParameter {

    private RString 処理名;
    private RString 年度;
    private RString 年度内連番;
    private RDateTime lastUpdateTimestamp;
    private RString システム日時;

    /**
     * UpdateShorikanriMyBatisParameterのコンストラクタです。
     */
    public UpdateShorikanriMyBatisParameter() {
    }

    /**
     * UpdateShorikanriMyBatisParameterのコンストラクタです。
     *
     * @param 処理名 RString
     * @param 年度 RString
     * @param 年度内連番 RString
     * @param lastUpdateTimestamp RDateTime
     * @param システム日時 RString
     */
    public UpdateShorikanriMyBatisParameter(
            RString 処理名,
            RString 年度,
            RString 年度内連番,
            RDateTime lastUpdateTimestamp,
            RString システム日時) {
        this.処理名 = 処理名;
        this.年度 = 年度;
        this.年度内連番 = 年度内連番;
        this.lastUpdateTimestamp = lastUpdateTimestamp;
        this.システム日時 = システム日時;
    }

}
