/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE233001;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.ShujiiUpdateMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書督促状発行更新_バッチ処理クラスパラメータクラスです。
 *
 * @reamsid_L DBE-0060-040 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShujiiUpdateProcessParameter implements IBatchProcessParameter {

    private List<RString> 申請書管理番号List;
    private RString temp_督促日;
    private RString temp_督促方法;
    private RString temp_督促メモ;

    /**
     * 主治医意見書督促状発行更新のMybatisパラメータを作成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 主治医意見書督促状発行更新のMybatisパラメータ
     */
    public ShujiiUpdateMybatisParameter toShujiiUpdateMybatisParameter(RString 申請書管理番号) {
        return new ShujiiUpdateMybatisParameter(申請書管理番号,
                this.temp_督促日,
                this.temp_督促方法,
                this.temp_督促メモ);
    }
}
