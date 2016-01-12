/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.benmeitoroku;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 弁明登録明細情報エンティティを作成します。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class BenmeiTorokuMeisaiJohoEntity implements Serializable {

    private FlexibleDate bemmeishoSakuseiYMD;
    private RString shinsaseikyuKankeiShobunNaiyo;
    private RString bemmeiNaiyo;
    private FlexibleDate bemmeishoSakuseiTeishutsuYMD;
    private RString bemmeishaShimei;
}
