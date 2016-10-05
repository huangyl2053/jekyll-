/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.jukokisambitokushutoroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4023JikoKisambiKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import org.apache.ibatis.annotations.Param;

/**
 * 時効起算日管理を取得。
 *
 * @reamsid_L DBD-3820-010 huangh
 */
public interface IJukoKisambiTokushuTorokuMapper {

    /**
     * 時効起算日管理情報を取得。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 調定年度 RYear
     * @return List<DbT4023JikoKisambiKanriEntity>
     */
    List<DbT4023JikoKisambiKanriEntity> get時効起算日管理(
            @Param("被保険者番号") HihokenshaNo 被保険者番号,
            @Param("調定年度") RYear 調定年度);
}
