/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyourisutosyuturyoku;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0310KozaEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 汎用リスト出力(高額介護サービス費状況)Entityクラスです。
 *
 * @reamsid_L DBC-2820-010 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyouRisutoSyuturyokuEntity {

    private DbT3055KogakuKyufuTaishoshaGokeiEntity 給付対象者合計;
    private DbT3056KogakuShikyuShinseiEntity 支給申請;
    private DbT3057KogakuShikyuHanteiKekkaEntity 支給判定結果;
    private DbT3058KogakuShikyuShinsaKetteiEntity 支給審査決定;
    private DbT3054KogakuKyufuTaishoshaMeisaiEntity 給付対象者明細;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private UaFt250FindAtesakiEntity 宛先;
    private UaT0310KozaEntity 口座情報;

    private LasdecCode 市町村コード;
    private RString 資格取得事由コード;
    private FlexibleDate 資格取得年月日;
    private FlexibleDate 資格取得届出年月日;
    private RString 資格喪失事由コード;
    private FlexibleDate 資格喪失年月日;
    private FlexibleDate 資格喪失届出年月日;
    private RString 被保険者区分コード;
    private HihokenshaNo 被保険者番号;
    private boolean 住所地特例フラグ;
    private boolean 広域内住所地特例フラグ;
    private LasdecCode 広住特措置元市町村コード;

    private JigyoshaNo 入所施設コード;
    private FlexibleDate 入所年月日;
    private FlexibleDate 退所年月日;
    private RString 入所施設種類;

    private AtenaMeisho 事業者名称_60;
    private AtenaKanaMeisho 事業者名称カナ_60;
    private YubinNo 郵便番号_60;
    private AtenaJusho 事業者住所_60;
    private TelNo 電話番号_60;
    private TelNo fax番号_60;
    private Decimal 所属人数_60;
    private Decimal 利用者数_60;
    private FlexibleDate 有効開始日_60;
    private FlexibleDate 有効終了日_60;
    private RString サービス実施地域_60;
    private AtenaMeisho 代表者名_62;
    private AtenaKanaMeisho 代表者名カナ_62;
    private RString 代表者役職名_62;

    private AtenaMeisho 事業者名称_05;
    private AtenaKanaMeisho 事業者名称カナ_05;
    private YubinNo 郵便番号_05;
    private AtenaJusho 事業者住所_05;
    private TelNo 電話番号_05;
    private TelNo fax番号_05;
    private Decimal 所属人数;
    private Decimal 利用者数;
    private FlexibleDate 有効開始日_05;
    private FlexibleDate 有効終了日_05;
    private AtenaMeisho 代表者名_05;
    private AtenaKanaMeisho 代表者名カナ_05;
    private RString 役職_05;

    private Code 受給申請事由;
    private FlexibleDate 受給申請年月日;
    private Code 要介護認定状態区分コード;
    private FlexibleDate 認定有効期間開始日;
    private FlexibleDate 認定有効期間終了日;
    private FlexibleDate 受給認定日;
    private boolean 旧措置フラグ;
    private Code みなし要介護区分コード;
    private Code 直近異動事由コード;

}
