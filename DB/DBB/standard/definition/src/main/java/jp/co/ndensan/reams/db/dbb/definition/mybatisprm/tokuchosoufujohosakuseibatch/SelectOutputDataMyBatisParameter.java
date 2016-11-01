/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * DBB-1840-040バッチ設計_DBBBT82001_特徴送付情報作成の特徴依頼情報一覧表の発行する用MybatisParameterクラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SelectOutputDataMyBatisParameter implements IMyBatisParameter {

    private final RString 出力順;
    private final boolean 出力順Flag;
    private final RString 処理日;
    private final RString 科目コード;

    /**
     * コンストラクタです。
     *
     * @param 出力順 RString
     * @param 処理日 RString
     * @param 科目コード RString
     */
    public SelectOutputDataMyBatisParameter(RString 出力順, RString 処理日, RString 科目コード) {
        this.出力順 = 出力順;
        出力順Flag = !RString.isNullOrEmpty(出力順);
        this.処理日 = 処理日;
        this.科目コード = 科目コード;
    }

}
