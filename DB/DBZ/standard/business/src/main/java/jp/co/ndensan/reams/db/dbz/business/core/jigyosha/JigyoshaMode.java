/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.jigyosha;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護事業者施設オブジェクトの項目定義クラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoshaMode implements Serializable {

    private KaigoJigyoshaNo jigyoshaNo;
    private AtenaMeisho jigyoshaName;
    private RString jigyoshaShubetsu;
    private List<GunshiCodeJigyoshaInputGuide> gunshiCodeJigyoshaInputGuide;
}
