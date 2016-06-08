/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import lombok.Getter;
import lombok.Setter;

/**
 * 減免情報のEntityクラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgdb")
public class GemmenJyoho extends DbTableEntityBase<GemmenJyoho> implements IDbAccessable {

    private RString choteiNendo;
    private RString fukaNendo;
    private RString hokenryoDankai;
    private Decimal hokenryoDankaiKanendoNinsu;
    private Decimal hoDankaiKanendoGemmenGaku;
    private Decimal hoDankaiKanendoNinsuGoukeyi;
    private Decimal hoDankaiKanendoGemenGakuGoukei;

}
