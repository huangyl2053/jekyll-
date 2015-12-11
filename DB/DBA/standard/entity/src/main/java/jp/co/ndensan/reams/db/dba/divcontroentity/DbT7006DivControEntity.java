/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroentity;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 老齢福祉年金情報共有子DIVのDivController
 *
 */
public class DbT7006DivControEntity {

    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private FlexibleDate jukyuKaishiYMD;
    private FlexibleDate jukyuShuryoYMD;
    private HihokenshaNo hihokenshaNo;

    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    public FlexibleDate getJukyuKaishiYMD() {
        return jukyuKaishiYMD;
    }

    public FlexibleDate getJukyuShuryoYMD() {
        return jukyuShuryoYMD;
    }

    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    public void setJukyuKaishiYMD(FlexibleDate jukyuKaishiYMD) {
        this.jukyuKaishiYMD = jukyuKaishiYMD;
    }

    public void setJukyuShuryoYMD(FlexibleDate jukyuShuryoYMD) {
        this.jukyuShuryoYMD = jukyuShuryoYMD;
    }

    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

}
