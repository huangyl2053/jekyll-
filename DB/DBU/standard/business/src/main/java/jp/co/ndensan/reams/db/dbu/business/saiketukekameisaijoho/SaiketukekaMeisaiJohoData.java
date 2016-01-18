/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.saiketukekameisaijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbu.entity.SaiketukekaMeisaiJoho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author lijia
 */
public class SaiketukekaMeisaiJohoData implements Serializable {

    private final SaiketukekaMeisaiJoho entity;

    /**
     * コンストラクタです。
     *
     * @param saiketukekaMeisaiJoho
     */
    public SaiketukekaMeisaiJohoData(SaiketukekaMeisaiJoho saiketukekaMeisaiJoho) {
        this.entity = saiketukekaMeisaiJoho;
    }

    /**
     * 弁明書作成日を返します。
     *
     * @return 弁明書作成日
     */
    public FlexibleDate get弁明書作成日() {
        return entity.get弁明書作成日();
    }
    
   /**
     * 裁決結果を返します。
     *
     * @return 裁決結果
     */
    public RString get裁決結果() {
        return entity.get裁決結果();
    }
    
   /**
     * 裁決理由を返します。
     *
     * @return 裁決理由
     */
    public RString get裁決理由() {
        return entity.get裁決理由();
    }

}
