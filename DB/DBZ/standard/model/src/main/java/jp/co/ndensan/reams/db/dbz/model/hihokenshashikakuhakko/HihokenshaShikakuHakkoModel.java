/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証資格者証発行画面の表示情報を保持するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class HihokenshaShikakuHakkoModel implements Serializable {

    private FlexibleDate 有効期限;
    private FlexibleDate 交付日;
    private HokenshaNo 保険者番号;
    private RString 保険者名称;
    private RString 保険者表示;

    public HihokenshaShikakuHakkoModel() {
    }

    /**
     * @return the 有効期限
     */
    public FlexibleDate get有効期限() {
        return 有効期限;
    }

    /**
     * @param 有効期限 the 有効期限 to set
     */
    public void set有効期限(FlexibleDate 有効期限) {
        this.有効期限 = 有効期限;
    }

    /**
     * @return the 交付日
     */
    public FlexibleDate get交付日() {
        return 交付日;
    }

    /**
     * @param 交付日 the 交付日 to set
     */
    public void set交付日(FlexibleDate 交付日) {
        this.交付日 = 交付日;
    }

    /**
     * @return the 保険者番号
     */
    public HokenshaNo get保険者番号() {
        return 保険者番号;
    }

    /**
     * @param 保険者番号 the 保険者番号 to set
     */
    public void set保険者番号(HokenshaNo 保険者番号) {
        this.保険者番号 = 保険者番号;
    }

    /**
     * @return the 保険者名称
     */
    public RString get保険者名称() {
        return 保険者名称;
    }

    /**
     * @param 保険者名称 the 保険者名称 to set
     */
    public void set保険者名称(RString 保険者名称) {
        this.保険者名称 = 保険者名称;
    }

    /**
     * @return the 保険者表示
     */
    public RString get保険者表示() {
        return 保険者表示;
    }

    /**
     * @param 保険者表示 the 保険者表示 to set
     */
    public void set保険者表示(RString 保険者表示) {
        this.保険者表示 = 保険者表示;
    }

}
