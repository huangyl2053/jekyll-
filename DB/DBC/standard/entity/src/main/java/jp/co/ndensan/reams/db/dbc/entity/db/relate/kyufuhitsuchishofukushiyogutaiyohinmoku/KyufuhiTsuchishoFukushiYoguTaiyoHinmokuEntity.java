/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhitsuchishofukushiyogutaiyohinmoku;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC100043_介護保険給付費通知書（福祉用具貸与品目）のEntityクラスです。
 *
 * @reamsid_L DBC-2280-060 lizhuoxuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity {

    private RString 被保険者氏名;
    private RString 被保険者番号;
    private RString サービス集計開始年月;
    private RString サービス集計終了年月;
    private RString 通知文1;
    private RString サービス年月;
    private RString サービス事業所;
    private RString タイコード;
    private RString 福祉用具商品名;
    private RString 費用額;
    private RString 参考資料タイトル1;
    private RString 費用額円_1;
    private RString 件数件_1;
    private RString 割合_1;
    private RString あなたの位置1;
    private RString 全国1;
    private RString 都道府県1;
    private RString 保険者1;
    private RString 参考資料タイトル2;
    private RString 費用額円_2;
    private RString 件数件_2;
    private RString 割合_2;
    private RString あなたの位置2;
    private RString 全国2;
    private RString 都道府県2;
    private RString 保険者2;
    private RString 参考資料タイトル3;
    private RString 費用額円_3;
    private RString 件数件_3;
    private RString 割合_3;
    private RString あなたの位置3;
    private RString 全国3;
    private RString 都道府県3;
    private RString 保険者3;
    private RString 通知文3;
    private int ページ分子;
    private int ページ分母;
    private int count;
}
