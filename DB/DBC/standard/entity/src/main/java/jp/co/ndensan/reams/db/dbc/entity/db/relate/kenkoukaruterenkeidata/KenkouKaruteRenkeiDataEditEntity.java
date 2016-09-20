/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidata;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 健康かるて連携データ作成のEditEntityです。
 *
 * @reamsid_L DBC-5020-030 wangxiaodong
 */
public class KenkouKaruteRenkeiDataEditEntity {

    private final KenkouKaruteRenkeiDataEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity KenkouKaruteRenkeiDataEntity
     */
    public KenkouKaruteRenkeiDataEditEntity(KenkouKaruteRenkeiDataEntity entity) {
        this.entity = entity;
    }

    /**
     * WriteLine内容をeditします。
     *
     * @return KenkouKaruteRenkeiDATEntity
     */
    public KenkouKaruteRenkeiDATEntity getWriteLine内容() {
        KenkouKaruteRenkeiDATEntity 出力entity = new KenkouKaruteRenkeiDATEntity();
        if (RString.isNullOrEmpty(entity.get識別コード())) {
            出力entity.set個人番号(RString.HALF_SPACE);
        } else {
            出力entity.set個人番号(entity.get識別コード());
        }
        if (!RString.isNullOrEmpty(entity.get名称())) {
            出力entity.set漢字氏名_カナ氏名(entity.get名称());
        } else {
            出力entity.set漢字氏名_カナ氏名(entity.getカナ名称());
        }
        出力entity.set生年月日(get年月日(entity.get生年月日()));
        出力entity.set性別(entity.get性別());
        if (!RString.isNullOrEmpty(entity.get被保険者番号())) {
            出力entity.set被保険者番号(entity.get被保険者番号());
        } else {
            出力entity.set被保険者番号(RString.HALF_SPACE);
        }
        出力entity.set資格取得日(get年月日(entity.get資格取得年月日()));
        出力entity.set資格喪失日(get年月日(entity.get資格喪失年月日()));
        if (!RString.isNullOrEmpty(entity.get要介護認定状態区分コード())) {
            出力entity.set要介護状態区分(entity.get要介護認定状態区分コード());
        } else {
            出力entity.set要介護状態区分(RString.HALF_SPACE);
        }
        出力entity.set減額認定証受給者番号(RString.HALF_SPACE);
        出力entity.set認定年月日(get年月日(entity.get認定年月日()));
        出力entity.set認定有効期間開始日(get年月日(entity.get認定有効期間開始年月日()));
        出力entity.set認定有効期間終了日(get年月日(entity.get認定有効期間終了年月日()));
        出力entity.set終了日と作成日区切り文字(RString.HALF_SPACE);
        出力entity.set作成日(RDate.getNowDate().toDateString());
        return 出力entity;
    }

    private RString get年月日(FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.HALF_SPACE;
        }
        return new RString(年月日.toString());
    }
}
