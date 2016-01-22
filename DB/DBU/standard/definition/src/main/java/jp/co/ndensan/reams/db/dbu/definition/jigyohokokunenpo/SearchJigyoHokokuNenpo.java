/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告集計一覧データの取得処理のパラメタークラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SearchJigyoHokokuNenpo {

    private FlexibleYear 報告年;
    private FlexibleYear 集計対象年;
    private LasdecCode 市町村コード;
    private RString 様式種類コード;
    private Code 集計番号;

    public SearchJigyoHokokuNenpo(FlexibleYear 報告年, FlexibleYear 集計対象年, LasdecCode 市町村コード, RString 様式種類コード, Code 集計番号) {
        this.報告年 = 報告年;
        this.集計対象年 = 集計対象年;
        this.市町村コード = 市町村コード;
        this.様式種類コード = 様式種類コード;
        this.集計番号 = 集計番号;
    }
}
