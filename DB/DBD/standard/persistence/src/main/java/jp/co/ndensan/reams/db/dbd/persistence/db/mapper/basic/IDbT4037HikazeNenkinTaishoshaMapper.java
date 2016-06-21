/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4037HikazeNenkinTaishoshaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 * {@link jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4037HikazeNenkinTaishoshaEntity}のマッパーIFです。
 *
 * @author n1070 久保裕是
 */
public interface IDbT4037HikazeNenkinTaishoshaMapper {

    /**
     * 同一年金単位最新履歴を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 年度 年度
     * @return List<DbT4037HikazeNenkinTaishoshaEntity>
     */
    List<DbT4037HikazeNenkinTaishoshaEntity> select同一年金単位最新履歴(
            @Param("HihokenshaNo") RString 被保険者番号, @Param("rendo") RString 年度);
}
