/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt21004;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBBBZ21004_段階別被保険者数一覧表作成BatchParameter
 *
 * @reamsid_L DBB-1820-040 dingminghao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DankaibetuHihokensyasuIchiranhyoProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 調定年度;
    private FlexibleDate 本算定賦課処理日;
    private RString 広域分市町村分区分;
    private List<RString> 市町村コード複数;
    private FlexibleDate 資格基準日;
    private FlexibleDate 調定基準日;
    private YMDHMS バッチ起動時処理日時;
}
