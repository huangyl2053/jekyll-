/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.saiketukekameisaijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 裁決結果明細データです。
 *
 * @reamsid_L DBU-1080-110 xuyue
 */
public class SaiketukekaMeisaiJohoData implements Serializable {

    private final DbT7001FufukuMoshitateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 不服審査申立情報
     */
    public SaiketukekaMeisaiJohoData(DbT7001FufukuMoshitateEntity entity) {
        this.entity = entity;
    }

    /**
     * 弁明書作成日を返します。
     *
     * @return 弁明書作成日
     */
    public FlexibleDate get弁明書作成日() {
        return entity.getBemmeishoSakuseiYMD();
    }

    /**
     * 裁決結果を返します。
     *
     * @return 裁決結果
     */
    public RString get裁決結果() {
        return entity.getSaiketsuKekka();
    }

    /**
     * 裁決理由を返します。
     *
     * @return 裁決理由
     */
    public RString get裁決理由() {
        return entity.getSaiketsuRiyu();
    }

}
