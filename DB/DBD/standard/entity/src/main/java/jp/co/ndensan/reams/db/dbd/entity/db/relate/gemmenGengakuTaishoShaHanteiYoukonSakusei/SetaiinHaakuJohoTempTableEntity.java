/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengakutaishoshahanteiyoukonsakusei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 世帯員把握入力entityクラスです。
 *
 * @reamsid_L DBD-3710-090 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SetaiinHaakuJohoTempTableEntity extends DbTableEntityBase<SetaiinHaakuJohoTempTableEntity> implements IDbAccessable {

    /**
     * テーブル名です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("TmpSetaiHaaku"));
    }
    @TempTableColumnOrder(1)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(2)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(3)
    private FlexibleDate kijunYMD;
    @TempTableColumnOrder(4)
    private RString jushochiTokureiFlag;
    @TempTableColumnOrder(5)
    private FlexibleYear shotokuNendo;

    /**
     * コンストラクタです。
     *
     * @param hihokenshaNo
     * @param shikibetsuCode
     * @param kijunYMD
     * @param jushochiTokureiFlag
     * @param shotokuNendo
     *
     */
    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(SetaiinHaakuJohoTempTableEntity entity) {
        this.setHihokenshaNo(entity.getHihokenshaNo());
        this.setShikibetsuCode(entity.getShikibetsuCode());
        this.setKijunYMD(entity.getKijunYMD());
        this.setJushochiTokureiFlag(entity.getJushochiTokureiFlag());
        this.setShotokuNendo(entity.getShotokuNendo());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, shikibetsuCode, kijunYMD, jushochiTokureiFlag, shotokuNendo);
    }

}
