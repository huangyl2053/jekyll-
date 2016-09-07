/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.furikaego;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業合算・事業分振込明細書作成（一括）Entity
 *
 * @reamsid_L DBC-4870-060 lijian
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FurikaeGoMeisaiEntity {

    private RString 支払方法;
    private RString 抽出範囲;
    private FlexibleDate 作成日;
    private FlexibleDate 依頼日;
    private FlexibleDate 振込指定日;
    private int 頁;
    private FlexibleDate 作成年月日と時間;
    private LasdecCode 市町村コード;
    private RString 市町村名;
    private RString 並び順１;
    private RString 並び順２;
    private RString 並び順３;
    private RString 並び順４;
    private RString 並び順５;
    private HihokenshaNo 被保険者番号;
    private AtenaMeisho 被保険者氏名;
    private RString 支給申請書整理番号;
    private FlexibleDate 申請年月日;
    private RString 申請種類;
    private FlexibleDate 認定有効期間開始;
    private Decimal 自己負担総額円;
    private RString 上段;
    private FlexibleYear 対象年度;
    private RString 住所;
    private FlexibleDate 計算対象期間;
    private FlexibleDate 決定年月日;
    private RString 要介護度;
    private FlexibleDate 認定有効期間終了;
    private Decimal 支給額円;
    private RString 下段;
    private RString 番号;
    private RString 名寄せ;
    private int 頁計人数;
    private Decimal 頁計金額;
    private int 総合計要支援人数;
    private Decimal 総合計要支援金額;
    private int 総合計事業対象人数;
    private Decimal 総合計事業対象金額;
    private int 総合計不明人数;
    private Decimal 総合計不明金額;
    private int 総合計人数;
    private Decimal 総合計金額;

}
