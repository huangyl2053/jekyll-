/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.sakuseiryoseikyuKubun;

import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.sakuseiryoSeikyuKubun.SakuseiryoSeikyuKubunParameter;

/**
 * 作成料請求区分取得のマッパーインタフェースです。
 */
public interface ISakuseiryoSeikyuKubunMapper {

    /**
     * 今回の申請日以前の申請データの中に 今回指定した主治医と同じ主治医による意見書データ件数取得します。
     *
     * @param parameter SeikatsuhogoParameter
     * @return 意見書データ件数 int
     */
    int get意見書データ(SakuseiryoSeikyuKubunParameter parameter);

    /**
     * 今回申請の「施設入所の有無」がTrueの件数を取得します。
     *
     * @param parameter SeikatsuhogoParameter
     * @return 施設入所有件数 int
     */
    int get施設入所有(SakuseiryoSeikyuKubunParameter parameter);

}
