/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbbbt21004;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBBBZ21004_段階別被保険者数一覧表作成BatchParameter
 *
 * @reamsid_L DBB-1820-040 dingminghao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DankaibetuHihokensyasuIchiranhyoMyBatisParameter implements IMyBatisParameter {

    private boolean 市町村コード;
    private RString 市町村コード複数;
    private FlexibleDate 資格基準日;
    private FlexibleDate 調定年月日;
}
