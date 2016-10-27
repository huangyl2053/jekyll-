/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * DBB-1840-040バッチ設計_DBBBT82001_特徴送付情報作成の処理日付管理テーブル更新する用MybatisParameterクラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class UpdateTableMyBatisParameter implements IMyBatisParameter {

    private final YMDHMS 処理日時;
    private final RString 処理名;
    private final RYear 賦課年度;
    private final RString 年度内連番;

    /**
     * コンストラクタです。
     *
     * @param 処理日時 YMDHMS
     * @param 処理名 RString
     * @param 賦課年度 RYear
     * @param 年度内連番 RString
     */
    public UpdateTableMyBatisParameter(YMDHMS 処理日時,
            RString 処理名, RYear 賦課年度, RString 年度内連番) {
        this.処理日時 = 処理日時;
        this.処理名 = 処理名;
        this.賦課年度 = 賦課年度;
        this.年度内連番 = 年度内連番;
    }

}
