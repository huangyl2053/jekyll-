/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.source.futanwariaisho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC100065_負担割合証parameterEntity
 *
 * @reamsid_L DBC-5010-030 surun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanWariaiShoEntity {

    private FlexibleDate 交付年月日;
    private RString 被保険者番号;
    private RString 住所;
    private RString カナ氏名;
    private RString 氏名;
    private RString 生年月日;
    private RString 性別;
    private RString 負担割合１;
    private FlexibleDate 適用開始年月日１;
    private FlexibleDate 適用終了年月日１;
    private RString 負担割合２;
    private FlexibleDate 適用開始年月日２;
    private FlexibleDate 適用終了年月日２;
    private RString 保険者コード１;
    private RString 保険者コード２;
    private RString 保険者コード３;
    private RString 保険者コード４;
    private RString 保険者コード５;
    private RString 保険者コード６;
    private RString 保険者住所;
    private RString 保険者名;
    private RString 保険者電話番号;
    private RString 電子公印;
    private RString 連番;
    private RString ocr連番;

}
