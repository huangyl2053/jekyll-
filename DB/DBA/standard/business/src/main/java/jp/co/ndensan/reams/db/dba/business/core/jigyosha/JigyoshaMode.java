/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.jigyosha;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護事業者施設オブジェクトの項目定義クラスです。
 */
public class JigyoshaMode implements Serializable {

    private KaigoJigyoshaNo jigyoshaNo;
    private AtenaMeisho jigyoshaName;
    private RString jigyoshaShubetsu;
    private List<GunshiCodeJigyoshaInputGuide> gunshiCodeJigyoshaInputGuide;

    public KaigoJigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    public AtenaMeisho getJigyoshaName() {
        return jigyoshaName;
    }

    public RString getJigyoshaShubetsu() {
        return jigyoshaShubetsu;
    }

    public void setJigyoshaNo(KaigoJigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    public void setJigyoshaName(AtenaMeisho jigyoshaName) {
        this.jigyoshaName = jigyoshaName;
    }

    public void setJigyoshaShubetsu(RString jigyoshaShubetsu) {
        this.jigyoshaShubetsu = jigyoshaShubetsu;
    }

    public List<GunshiCodeJigyoshaInputGuide> getGunshiCodeJigyoshaInputGuide() {
        return gunshiCodeJigyoshaInputGuide;
    }

    public void setGunshiCodeJigyoshaInputGuide(List<GunshiCodeJigyoshaInputGuide> gunshiCodeJigyoshaInputGuide) {
        this.gunshiCodeJigyoshaInputGuide = gunshiCodeJigyoshaInputGuide;
    }
}
