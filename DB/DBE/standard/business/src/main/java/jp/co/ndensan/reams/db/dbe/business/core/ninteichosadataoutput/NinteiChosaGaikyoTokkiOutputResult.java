/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaGaikyoTokkiDataRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaGaikyoTokkiOutputEucCsvEntity;

/**
 * 認定調査データ出力（モバイル）概況特記事項CSVEntity設定のビジネスです。
 */
public class NinteiChosaGaikyoTokkiOutputResult {

    /**
     * EucCsvEntityの設定メッソドです。
     *
     * @param entityParam NinteiChosaGaikyoTokkiDataRelateEntity
     * @return NinteiChosaGaikyoTokkiOutputEucCsvEntity
     */
    public NinteiChosaGaikyoTokkiOutputEucCsvEntity setEucCsvEntity(NinteiChosaGaikyoTokkiDataRelateEntity entityParam) {

        NinteiChosaGaikyoTokkiOutputEucCsvEntity eucCsvEntity = new NinteiChosaGaikyoTokkiOutputEucCsvEntity();
        eucCsvEntity.set申請書管理番号(entityParam.get申請書管理番号());
        eucCsvEntity.set証記載保険者番号(entityParam.get証記載保険者番号());
        eucCsvEntity.set被保険者番号(entityParam.get被保険者番号());
        eucCsvEntity.set認定申請年月日(entityParam.get認定申請年月日());
        eucCsvEntity.set概況特記事項主訴(entityParam.get概況特記事項主訴());
        eucCsvEntity.set概況特記事項家族状況(entityParam.get概況特記事項家族状況());
        eucCsvEntity.set概況特記事項居住環境(entityParam.get概況特記事項居住環境());
        eucCsvEntity.set概況特記事項機器器械(entityParam.get概況特記事項機器器械());
        return eucCsvEntity;
    }

}
