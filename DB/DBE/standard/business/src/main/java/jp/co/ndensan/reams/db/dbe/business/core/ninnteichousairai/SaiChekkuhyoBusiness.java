/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousairai.SaiChekkuhyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査票差異チェック票クラスです。
 *
 * @reamsid_L DBE-0010-010 sunhaidi
 */
public class SaiChekkuhyoBusiness {

    private final SaiChekkuhyoEntity entity;

    /**
     * 認定調査票差異チェック票を返します。
     *
     * @param entity SaiChekkuhyoEntity
     */
    public SaiChekkuhyoBusiness(SaiChekkuhyoEntity entity) {
        this.entity = entity;
    }

    /**
     * 要介護認定一次判定結果コードを返します。
     *
     * @return 要介護認定一次判定結果コード
     */
    public RString getIchijiHanteiKekkaCode() {
        return entity.getIchijiHanteiKekkaCode();
    }

    /**
     * 二次判定要介護状態区分コードを返します。
     *
     * @return 二次判定要介護状態区分コード
     */
    public RString getNijiHanteiYokaigoJotaiKubun() {
        return entity.getNijiHanteiYokaigoJotaiKubun();
    }

    /**
     * 二次判定年月日を返します。
     *
     * @return 二次判定年月日
     */
    public FlexibleDate getNijiHanteiYMD() {
        return entity.getNijiHanteiYMD();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public RString getRemban() {
        return entity.getRemban();
    }

    /**
     * 調査項目を返します。
     *
     * @return 調査項目
     */
    public RString getResearchItem() {
        return entity.getResearchItem();
    }

    /**
     * 前回認知症高齢者自立度を返します。
     *
     * @return 前回認知症高齢者自立度
     */
    public RString getNinchishoSeikatsuJiritsudo() {
        return entity.getNinchishoSeikatsuJiritsudo();
    }

    /**
     * 前回障害高齢者自立度を返します。
     *
     * @return 前回障害高齢者自立度
     */
    public RString getShogaiSeikatsuJiritsudo() {
        return entity.getShogaiSeikatsuJiritsudo();
    }
}
