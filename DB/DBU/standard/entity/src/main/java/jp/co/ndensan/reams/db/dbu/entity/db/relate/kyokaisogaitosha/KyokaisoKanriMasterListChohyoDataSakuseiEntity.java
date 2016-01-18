/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 境界層管理マスタリスト_帳票データ作成Entityクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KyokaisoKanriMasterListChohyoDataSakuseiEntity {

    private RString 印刷日時;
    private RString ページ数;
    private RString 市町村コード;
    private RString 市町村名;
    private RString 並び順1;
    private RString 並び順2;
    private RString 並び順3;
    private RString 並び順4;
    private RString 並び順5;
    private RString 改頁1;
    private RString 改頁2;
    private RString 改頁3;
    private RString 改頁4;
    private RString 改頁5;
    private List<HihokenshaNo> 被保険者番号;
    private List<ShikibetsuCode> 識別コード;
    private List<RString> カナ氏名;
    private List<RString> 氏名;
    private List<RString> 性別;
    private List<RString> 種別;
    private List<RString> 状態;
    private List<SetaiCode> 世帯コード;
    private List<FlexibleDate> 生年月日;
    private List<FlexibleDate> 該当申請日;
    private List<FlexibleDate> 該当開始日;
    private List<FlexibleDate> 該当終了日;
    private List<RString> 給付額減額解除;
    private List<Decimal> 標準負担減額後負担額;
    private List<RString> 居住費軽減後居室種類;
    private List<Decimal> 居住費軽減後負担額;
    private List<Decimal> 食費軽減後負担額;
    private List<Decimal> 高額ｻｰﾋﾞｽ費減額後上限額;
    private List<RString> 保険料納付減額後保険料段階;
}
