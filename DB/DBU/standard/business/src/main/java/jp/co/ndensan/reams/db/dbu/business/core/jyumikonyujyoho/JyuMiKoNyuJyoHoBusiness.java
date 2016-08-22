/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.jyumikonyujyoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jyumikonyujyoho.JyuMiKoNyuJyoHoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoGaitosha;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBU0600051_総合照会_住民固有情報Entity。
 *
 * @reamsid_L DBU-4100-060 houtianpeng
 */
public class JyuMiKoNyuJyoHoBusiness implements Serializable {

    private final JyuMiKoNyuJyoHoEntity entity;

    /**
     * コンストラクタです。<br/>
     * 対象者一覧に使用します。
     *
     * @param entity JyuMiKoNyuJyoHoEntity
     */
    public JyuMiKoNyuJyoHoBusiness(JyuMiKoNyuJyoHoEntity entity) {
        this.entity = entity;
    }

    /**
     * 受給開始日を取得します。
     *
     * @return 受給開始日
     */
    public FlexibleDate get受給開始日() {
        return entity.getJukyuKaishiYMD();
    }

    /**
     * 受給廃止日を取得します。
     *
     * @return 受給廃止日
     */
    public FlexibleDate get受給廃止日() {
        return entity.getJukyuHaishiYMD();
    }

    /**
     * 受給停止開始日を取得します。
     *
     * @return 受給停止開始日
     */
    public FlexibleDate get受給停止開始日() {
        return entity.getJukyuTeishiKaishiYMD();
    }

    /**
     * 受給停止終了日を取得します。
     *
     * @return 受給停止終了日
     */
    public FlexibleDate get受給停止終了日() {
        return entity.getJukyuTeishiShuryoYMD();
    }

    /**
     * 適用開始年月を取得します。
     *
     * @return 適用開始年月
     */
    public FlexibleYearMonth get適用開始年月() {
        return entity.getTekiyoKaishiYM();
    }

    /**
     * 保険料納付減額後保険料段階を取得します。
     *
     * @return 保険料納付減額後保険料段階
     */
    public RString get保険料納付減額後保険料段階() {
        return entity.getGengakuGoHokenryoDankai();
    }

    /**
     * 保険料納付減額後保険料段階を取得します。
     *
     * @return 保険料納付減額後保険料段階
     */
    public KyokaisoGaitosha get境界層該当者() {
        return new KyokaisoGaitosha(entity.get境界層該当者Entity());
    }
}
