/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibetsushunoritsu;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import lombok.Getter;
import lombok.Setter;

/**
 * 保険料段階別収納率一時テーブルのエンティティクラスです。
 *
 * @reamsid_L DBB-1630-020 tianshuai
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DankaibetsuShunoritsuTempEntity extends DbTableEntityBase<DankaibetsuShunoritsuTempEntity> implements IDbAccessable {

    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private int kibetsu;
    private TsuchishoNo tsuchishoNo;
    private RString taishouKubun;
    private HihokenshaNo hihokenshaNo;
    private Decimal choteigaku;
    private Decimal funougaku;
    private Decimal shunyugaku;
    private int shunoDataKubun;
    private FlexibleDate fukaYMD;
    private RString hokenryoDankai;
    private RString kamokuCode;
    private LasdecCode lasdecCode;
    private LasdecCode fukaLasdecCode;
    private RString kannnouKunbun;
}
