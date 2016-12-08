/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku;

import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事業状況報告情報クラスです。
 *
 * @reamsid_L DBE-1450-100 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoJokyoHokoku {

    private RString タイトル;
    private RString 事業対象年月;
    private RString 保険者番号;
    private RString 保険者名;
    private RDateTime 発行日時;
    private RString 第1号被保険者タイトル;
    private RString 第1号被保険者_非該当;
    private RString 第1号被保険者_支援1;
    private RString 第1号被保険者_支援2;
    private RString 第1号被保険者_要介護1;
    private RString 第1号被保険者_要介護2;
    private RString 第1号被保険者_要介護3;
    private RString 第1号被保険者_要介護4;
    private RString 第1号被保険者_要介護5;
    private RString 第1号被保険者_合計;
    private RString 歳以上75歳未満タイトル;
    private RString 歳以上75歳未満_非該当;
    private RString 歳以上75歳未満_支援1;
    private RString 歳以上75歳未満_支援2;
    private RString 歳以上75歳未満_要介護1;
    private RString 歳以上75歳未満_要介護2;
    private RString 歳以上75歳未満_要介護3;
    private RString 歳以上75歳未満_要介護4;
    private RString 歳以上75歳未満_要介護5;
    private RString 歳以上75歳未満_合計;
    private RString 歳75以上タイトル;
    private RString 歳75以上_非該当;
    private RString 歳75以上_支援1;
    private RString 歳75以上_支援2;
    private RString 歳75以上_要介護1;
    private RString 歳75以上_要介護2;
    private RString 歳75以上_要介護3;
    private RString 歳75以上_要介護4;
    private RString 歳75以上_要介護5;
    private RString 歳75以上_合計;
    private RString 第2号被保険者タイトル;
    private RString 第2号被保険者_非該当;
    private RString 第2号被保険者_支援1;
    private RString 第2号被保険者_支援2;
    private RString 第2号被保険者_要介護1;
    private RString 第2号被保険者_要介護2;
    private RString 第2号被保険者_要介護3;
    private RString 第2号被保険者_要介護4;
    private RString 第2号被保険者_要介護5;
    private RString 第2号被保険者_合計;
    private RString 総数タイトル;
    private RString 総数_非該当;
    private RString 総数_支援1;
    private RString 総数_支援2;
    private RString 総数_要介護1;
    private RString 総数_要介護2;
    private RString 総数_要介護3;
    private RString 総数_要介護4;
    private RString 総数_要介護5;
    private RString 総数_合計;
}
