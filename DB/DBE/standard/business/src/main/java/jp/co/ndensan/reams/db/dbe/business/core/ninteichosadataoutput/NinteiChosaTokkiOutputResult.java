/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaTokkiDataRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaTokkiOutputEucCsvEntity;

/**
 * 認定調査データ出力（モバイル）特記事項CSVEntity設定のビジネスです。
 */
public class NinteiChosaTokkiOutputResult {

    /**
     * EucCsvEntityの設定メッソドです。
     *
     * @param entityParam NinteiChosaTokkiDataRelateEntity
     * @return NinteiChosaTokkiOutputEucCsvEntity
     */
    public NinteiChosaTokkiOutputEucCsvEntity setEucCsvEntity(NinteiChosaTokkiDataRelateEntity entityParam) {

        NinteiChosaTokkiOutputEucCsvEntity eucCsvEntity = new NinteiChosaTokkiOutputEucCsvEntity();
        eucCsvEntity.set申請書管理番号(entityParam.get申請書管理番号());
        eucCsvEntity.set証記載保険者番号(entityParam.get証記載保険者番号());
        eucCsvEntity.set被保険者番号(entityParam.get被保険者番号());
        eucCsvEntity.set認定申請年月日(entityParam.get認定申請年月日());
        eucCsvEntity.set前回今回区分(entityParam.get前回今回区分());
        eucCsvEntity.set認定調査特記事項番号(entityParam.get認定調査特記事項番号());
        eucCsvEntity.set認定調査特記事項連番(entityParam.get認定調査特記事項連番());
        eucCsvEntity.set特記事項(entityParam.get特記事項());
        return eucCsvEntity;
    }

}
