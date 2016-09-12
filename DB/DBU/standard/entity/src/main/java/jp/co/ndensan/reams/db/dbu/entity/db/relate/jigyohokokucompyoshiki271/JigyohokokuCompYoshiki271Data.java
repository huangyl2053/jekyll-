/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki271;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2-7）のデータです。
 *
 * @reamsid_L DBU-5580-040 wanghuafeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuCompYoshiki271Data {

    private RString 年報月報区分;
    private RString 作成日時;
    private RString 集計年月;
    private RString 保険者番号;
    private RString 保険者名;
    private List<DbT7021JigyoHokokuTokeiDataEntity> 事業報告統計データ;

}
