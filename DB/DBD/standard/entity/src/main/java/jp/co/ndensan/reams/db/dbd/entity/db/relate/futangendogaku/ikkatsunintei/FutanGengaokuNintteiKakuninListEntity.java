/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogaku.ikkatsunintei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt22006.IsShinseiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 負担限度額認定（一括）確認リストEntityです。
 *
 * @reamsid_L DBD-3710-070 chenxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanGengaokuNintteiKakuninListEntity {

    private HihokenshaNo 被保険者番号;
    private FlexibleDate 資格取得日;
    private FlexibleDate 資格喪失日;
    private RString 住所地特例フラグ;
    private FlexibleDate 認定開始日;
    private FlexibleDate 認定終了日;
    private RString 要介護状態区分コード;
    private RString 厚労省IF識別コード;
    private boolean 旧措置;
    private LasdecCode 市町村コード;
    private UaFt200FindShikibetsuTaishoEntity atesakiEntity;
    private List<IsShinseiEntity> 利用軽減;
    private List<IsShinseiEntity> 訪問減額;
    private List<IsShinseiEntity> 社福軽減;
    private List<IsShinseiEntity> 特地減免;
    private boolean is生活保護受給者;
    private boolean is老齢福祉年金受給者;
    private Decimal 合計所得金額;
    private RString 世帯課税区分;
    private DbT4018KaigoHokenFutanGendogakuNinteiEntity 今回認定結果;
    private DbT4018KaigoHokenFutanGendogakuNinteiEntity 前回認定結果;
}
