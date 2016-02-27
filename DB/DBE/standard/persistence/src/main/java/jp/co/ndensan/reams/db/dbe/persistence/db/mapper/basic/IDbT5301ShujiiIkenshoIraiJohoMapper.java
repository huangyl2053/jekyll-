/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe233001.ShujiiUpdateMybatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成依頼情報のマッパーIFです。
 *
 */
public interface IDbT5301ShujiiIkenshoIraiJohoMapper {

    /**
     * 主治医意見書作成依頼情報を更新します。
     *
     * @param 主治医意見書依頼情報 主治医意見書依頼情報
     * @return 更新件数
     */
    int update主治医意見書依頼情報BY申請書管理番号(ShujiiUpdateMybatisParameter 主治医意見書依頼情報);

    /**
     * バッチプロセス用。
     *
     * @return List<RString>
     */
    List<RString> getListForProcess();
}
