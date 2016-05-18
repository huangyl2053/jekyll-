/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.kaigojigyoshashisetsukanrio;

import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio.KaigoJigyoshaRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 介護事業者・施設管理のBusinessクラスです。
 *
 * @reamsid_L DBA-0340-010 wanghui
 */
public class KaigoJigyoshaBusiness {

    private final KaigoJigyoshaRelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 介護事業者・施設管理Entity
     */
    public KaigoJigyoshaBusiness(KaigoJigyoshaRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 有効開始日を取得します。
     *
     * @return 有効開始日
     */
    public FlexibleDate get有効開始日() {
        return entity.getYukoKaishiYMD();
    }

    /**
     * 有効終了日を取得します。
     *
     * @return 有効終了日
     */
    public FlexibleDate get有効終了日() {
        return entity.getYukoShuryoYMD();
    }

    /**
     * 有効開始日を取得します。
     *
     * @return 有効開始日
     */
    public FlexibleDate get対象施設有効開始日() {
        return entity.getYukoKaishiYMD2();
    }

    /**
     * 対象施設有効終了日を取得します。
     *
     * @return 対象施設有効終了日
     */
    public FlexibleDate get対象施設有効終了日() {
        return entity.getYukoShuryoYMD2();
    }
}
