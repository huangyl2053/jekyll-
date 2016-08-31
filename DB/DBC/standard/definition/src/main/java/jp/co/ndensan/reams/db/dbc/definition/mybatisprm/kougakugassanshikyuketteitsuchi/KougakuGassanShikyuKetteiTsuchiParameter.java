/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakugassanshikyuketteitsuchi;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMN63003_高額合算支給決定通知書（単）のパラメータ。
 *
 * @reamsid_L DBC-2310-030 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KougakuGassanShikyuKetteiTsuchiParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private long 口座ID;
    private HihokenshaNo 被保険者番号;
    private FlexibleYear 対象年度;
    private RString 連絡票整理番号;
    private int 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param searchKey searchKey
     */
    public KougakuGassanShikyuKetteiTsuchiParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
    }
}
