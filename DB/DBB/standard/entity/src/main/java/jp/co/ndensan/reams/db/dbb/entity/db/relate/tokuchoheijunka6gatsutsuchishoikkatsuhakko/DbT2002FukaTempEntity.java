package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6gatsutsuchishoikkatsuhakko;

import jp.co.ndensan.reams.ca.cax.entity.db.psm.CaFt703FindNokumiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt310FindKozaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護賦課一時テーブルのエンティティクラスです。
 *
 * @reamsid_L DBB-0820-040 xuyue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Setter
@Getter
public class DbT2002FukaTempEntity extends DbTableEntityBase<DbT2002FukaTempEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    // TODO TempEntity 「更正後」計算後情報の全項目
    private DbT2015KeisangoJohoEntity 更正後_計算後情報;
    // TODO TempEntity 「更正前」計算後情報の全項目
    private DbT2015KeisangoJohoEntity 更正前_計算後情報;
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
    // TODO 計算後情報の全項目
    private UaFt250FindAtesakiEntity 宛先Entity;
    private CaFt703FindNokumiEntity 納組Entity;
    private UaFt310FindKozaEntity 口座Entity;
    // TODO 「更正後」対象者（追加含む）情報
//    private UeT0511NenkinTokuchoKaifuJohoEntity 更正後対象者Entity;
    // TODO 「更正前」対象者（追加含む）情報
//    private UeT0511NenkinTokuchoKaifuJohoEntity 更正前対象者Entity;

    private RString 更正前情報有無区分;
    private RString 前年度_特徴期別金額06;
    private RString 被保険者区分;

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5();
    }

// </editor-fold>
}
