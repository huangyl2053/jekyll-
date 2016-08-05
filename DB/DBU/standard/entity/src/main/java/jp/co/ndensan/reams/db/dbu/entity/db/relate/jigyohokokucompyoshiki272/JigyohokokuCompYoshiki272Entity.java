/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki272;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事業報告月報様式_02のデータです。
 *
 * @reamsid_L DBU-5590-050 wanghuafeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuCompYoshiki272Entity {

    private RString 作成日時;
    private RString 年報月報区分;
    private List<DbT7021JigyoHokokuTokeiDataEntity> 事業報告統計データ;
    private RString 集計年月;
    private RString 集計年度;
    private RString 集計期間FROM;
    private RString 集計期間TO;
    private RString 保険者番号;
    private RString 保険者名;
}
