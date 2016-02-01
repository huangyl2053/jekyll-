/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.entity.report.shikakushutokuidososhitsu;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 被保険者基本情報Entityクラスです。
 */
public class HihokenshaKihonEntity {
    
    public RString getフリガナ() {
        return new RString("フリガナ");
    }

    public RString get被保険者氏名() {
        return new RString("氏名");
    }

    public RString get保険者番号() {
        return new RString("010102");
    }

    public RString get保険者名称() {
        return new RString("保険者名称");
    }

    public RString get被保険者番号() {
        return new RString("010102");
    }

    public FlexibleDate get生年月日() {
        return new FlexibleDate(new RString("19920101"));
    }

    public RString get性別() {
        return new RString("男");
    }

    public RString get続柄() {
        return new RString("続柄");
    }

    public RString get郵便番号() {
        return new RString("010102");
    }

    public RString get電話番号() {
        return new RString("010102");
    }

    public RString get住所() {
        return new RString("住所");
    }

    public RString get住民種別コード() {
        return new RString("1");
    }

    public RString get世帯主氏名() {
        return new RString("世帯主氏名");
    }

    public boolean is生年月日不詳区分() {
        return false;
    }
    
    
}
