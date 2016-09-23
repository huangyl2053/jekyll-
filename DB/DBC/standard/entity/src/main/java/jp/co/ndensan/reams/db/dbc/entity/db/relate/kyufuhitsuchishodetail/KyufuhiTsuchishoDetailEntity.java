/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhitsuchishodetail;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険給付費通知書(２ページ目以降)のEntityクラスです。
 *
 * @reamsid_L DBC-2280-050 lizhuoxuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuhiTsuchishoDetailEntity {

    private RString 被保険者氏名;
    private RString 被保険者番号;
    private RString サービス集計開始年月;
    private RString サービス集計終了年月;
    private RString サービス提供年月;
    private RString サービス事業者;
    private RString サービス種類_サービス略称;
    private RString サービス日数_回数;
    private RString 利用者負担額合計額_円;
    private RString サービス費用合計額_円;
    private RString サービス事業者1;
    private RString サービス種類_サービス略称1;
    private RString 通知文1;
    private RString 通知文2;
    private int ページ分子;
    private int ページ分母;
    private int count;
}
