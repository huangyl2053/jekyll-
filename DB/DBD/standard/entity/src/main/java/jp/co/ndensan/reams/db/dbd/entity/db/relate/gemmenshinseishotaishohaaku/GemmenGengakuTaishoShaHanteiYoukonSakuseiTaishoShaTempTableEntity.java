/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenshinseishotaishohaaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 減免減額対象者判定用根拠作成対象者一時entityクラスです。
 *
 * @reamsid_L DBD-3530-030 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity
        extends DbTableEntityBase<GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity> implements IDbAccessable {

    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("gemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTemp"));
    }
    @TempTableColumnOrder(1)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(2)
    private FlexibleDate kijunYMD;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param 基準日
     *
     */
    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity entity) {
        this.setHihokenshaNo(entity.getHihokenshaNo());
        this.setKijunYMD(entity.getKijunYMD());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, kijunYMD);
    }

}
