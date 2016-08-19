/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikeikyubetsuriyojyokyo;

import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 年齢階級別利用状況作成の帳票パラメータクラスです。
 *
 * @reamsid_L DBE-3470-040 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenreiKeikyuBetsuRiyoJyokyoEntity {

    private RString 保険者番号;
    private RString 保険者名;
    private RString ページ数;
    private RDateTime 印刷日時;
    private RString 条件1;
    private RString 条件2;
    private RString サービス種類名称1;
    private RString 区分_1;
    private RString 非該当_1;
    private RString 要支援１_1;
    private RString 要支援２_1;
    private RString 経過的要支援_1;
    private RString 要介護１_1;
    private RString 要介護２_1;
    private RString 要介護３_1;
    private RString 要介護４_1;
    private RString 要介護５_1;
    private RString 合計_1;
    private RString 備考_1;
    private RString サービス種類名称2;
    private RString 区分_2;
    private RString 非該当_2;
    private RString 要支援１_2;
    private RString 要支援２_2;
    private RString 経過的要支援_2;
    private RString 要介護１_2;
    private RString 要介護２_2;
    private RString 要介護３_2;
    private RString 要介護４_2;
    private RString 要介護５_2;
    private RString 合計_2;
    private RString 備考_2;
}
