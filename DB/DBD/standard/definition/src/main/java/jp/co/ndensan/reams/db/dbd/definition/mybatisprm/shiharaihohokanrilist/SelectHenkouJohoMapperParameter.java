/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.shiharaihohokanrilist;

import jp.co.ndensan.reams.db.dbd.definition.processprm.shiharaihohohenkolist.PublishReportProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 支払方法変更管理リスト作成用のMapper用パラメータクラスです。
 *
 * @reamsid_L DBD-3630-010 liangbc
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SelectHenkouJohoMapperParameter implements IMyBatisParameter {

    private final FlexibleDate 基準日;

    private SelectHenkouJohoMapperParameter(FlexibleDate 基準日) {
        this.基準日 = 基準日;
    }

    public static SelectHenkouJohoMapperParameter createParameter(PublishReportProcessParameter processParameter) {
        return new SelectHenkouJohoMapperParameter(processParameter.get基準日());
    }
}
