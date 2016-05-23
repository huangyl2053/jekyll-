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
 * 現年度データのEntityクラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgdb")
public class GennendoDate extends DbTableEntityBase<GennendoDate> implements IDbAccessable {

    private RString choteiNendo;
    private RString fukaNendo;
    private RString tsuchishoNo;
    private RString rirekiNo;
    private RString hihokenshaNo;
    private RString hokenryoDankai;
    private Decimal tkSaishutsuKampuGaku;
    private Decimal fuSaishutsuKampuGaku;
    private Decimal gemmenGaku;
    private RString choshuHouhou;
    private int ki;
    private RString getu;
    private RString choteiId;
    private Decimal choteigaku;
    private boolean dankaiFumeyiFlg;

}
