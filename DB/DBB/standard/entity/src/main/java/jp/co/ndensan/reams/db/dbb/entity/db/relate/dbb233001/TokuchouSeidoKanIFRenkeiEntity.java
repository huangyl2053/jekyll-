/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb233001;

import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaCode;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBB233001_特徴制度間Ｉ／Ｆ連携　の作成です。
 *
 * @reamsid_L DBB-1810-040 dengjiajia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchouSeidoKanIFRenkeiEntity {

    private RString dt市町村コード;
    private TokubetsuChoshuGimushaCode dt特別徴収義務者コード;
    private RString dt特別徴収制度コード;
    private TsuchiNaiyoCode dt通知内容コード;
    private RString dt作成年月日;
    private RString dt基礎年金番号;
    private RString dt年金コード;
    private RString dt生年月日;
    private RString dt性別;
    private RString dtカナ氏名;
    private RString dtシフトコード1;
    private RString dt漢字氏名;
    private RString dtシフトコード2;
    private RString dt郵便番号;
    private RString dtカナ住民;
    private RString dtシフトコード3;
    private RString dt漢字住所;
    private RString dtシフトコード4;
    private RString dt各種区分;
    private RString dt処理結果;
    private RString dt各種年月日;
    private RString dt各種金額欄1;
    private RString dt各種金額欄2;
    private RString dt各種金額欄3;
    private RString dt共済年金証記号番号;
    private RString dt後期移管コード;
    private RString dt予備1;
    private RString dt予備2;
    private RString 介護保険被保険者番号;
    private RString 個人コード区分;
    private RString 個人コード;
    private RString 介護保険住所地特例区分;
    private RString 捕捉年月日;
    private RString 待機フラグ;

}
