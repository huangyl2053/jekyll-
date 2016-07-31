/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchokarisanteitsuchishohakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoMybatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteitsuchishohakko.TsuchishoDataTempEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;

/**
 * 特徴仮算定通知書一括発行（バッチ）のMapperクラスです。
 *
 * @reamsid_L DBB-0790-040 chenaoqi
 */
public interface ITokuchoKarisanteiTsuchishoHakkoMapper {

    /**
     * 仮算定のデータを抽出
     *
     * @param parameter TokuchoKarisanteiTsuchishoHakkoParameter
     * @return TsuchishoDataTempEntity
     */
    List<TsuchishoDataTempEntity> select仮算定一括発行一時のデータ(TokuchoKaishiTsuchishoMybatisParameter parameter);

    /**
     * select前年度賦課情報
     *
     * @param parameter TokuchoKarisanteiTsuchishoHakkoParameter
     * @return List<DbT2002FukaEntity>
     */
    List<DbT2002FukaEntity> select前年度賦課情報(TokuchoKaishiTsuchishoMybatisParameter parameter);

    /**
     * update仮算定一括発行一時_前年度賦課情報
     */
    void update仮算定一括発行一時_前年度賦課情報();

    /**
     * update仮算定一括発行一時_特徴調定額
     */
    void update仮算定一括発行一時_特徴調定額();

    /**
     * update仮算定一括発行一時_被保険者区分0
     */
    void update仮算定一括発行一時_被保険者区分0();

    /**
     * update仮算定一括発行一時_被保険者区分1
     */
    void update仮算定一括発行一時_被保険者区分1();

    /**
     * update仮算定一括発行一時_被保険者区分2
     */
    void update仮算定一括発行一時_被保険者区分2();

    /**
     * select出力対象データ
     *
     * @param parameter TokuchoKaishiTsuchishoMybatisParameter
     * @return List<TsuchishoDataTempEntity>
     */
    List<TsuchishoDataTempEntity> select出力対象データ(TokuchoKaishiTsuchishoMybatisParameter parameter);

}
