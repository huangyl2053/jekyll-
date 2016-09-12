/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hikazeinennkintaishousyajohotorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201.HikazeiNennkinTaishouSyaJohoListCsvResultEntity;

/**
 * 非課税年金対象者情報一覧CSV用のデータ取得のマッパーインタフェースです。
 *
 * @reamsid_L DBD-4910-030 x_lilh
 */
public interface IHikazeiNennkinTaishouSyaJohoCsvMapper {

    /**
     * 非課税年金対象者情報一覧CSV用のデータ情報を取得します．
     *
     * @return 非課税年金対象者情報一覧CSV用のデータ情報
     */
    List<HikazeiNennkinTaishouSyaJohoListCsvResultEntity> get非課税年金対象者情報一覧CSV用のデータ情報();
}
