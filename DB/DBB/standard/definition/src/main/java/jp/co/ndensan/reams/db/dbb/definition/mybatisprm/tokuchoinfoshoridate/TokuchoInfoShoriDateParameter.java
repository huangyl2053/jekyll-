/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoinfoshoridate;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 前回の処理日付取得MybatisParameter
 *
 * @reamsid_L DBB-4240-010 chenhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoInfoShoriDateParameter implements IMyBatisParameter {

    private FlexibleYear 調定年度;
    private RString 年度内連番;
    private RString 処理名;
    private List<RString> 市町村識別IDList;

    /**
     * コンストラクタです。
     */
    public TokuchoInfoShoriDateParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param 調定年度 FlexibleYear
     * @param 年度内連番 RString
     * @param 処理名 RString
     * @param 市町村識別IDList List<RString>
     */
    TokuchoInfoShoriDateParameter(
            FlexibleYear 調定年度,
            RString 年度内連番,
            RString 処理名,
            List<RString> 市町村識別IDList) {
        this.調定年度 = 調定年度;
        this.年度内連番 = 年度内連番;
        this.処理名 = 処理名;
        this.市町村識別IDList = 市町村識別IDList;
    }
}
