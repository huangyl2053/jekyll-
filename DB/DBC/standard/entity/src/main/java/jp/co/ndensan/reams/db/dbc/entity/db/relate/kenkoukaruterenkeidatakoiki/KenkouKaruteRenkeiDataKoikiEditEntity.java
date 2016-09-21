/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidatakoiki;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidata.KenkouKaruteRenkeiDATEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 健康かるて連携データ作成（広域用）のEditEntityです。
 *
 * @reamsid_L DBC-5020-011 wangxiaodong
 */
public class KenkouKaruteRenkeiDataKoikiEditEntity {

    private final KenkoKaruteRenkeiKoikiTempTableEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity KenkoKaruteRenkeiKoikiTempTableEntity
     */
    public KenkouKaruteRenkeiDataKoikiEditEntity(KenkoKaruteRenkeiKoikiTempTableEntity entity) {
        this.entity = entity;
    }

    /**
     * WriteLine内容をeditします。
     *
     * @return KenkouKaruteRenkeiDATEntity
     */
    public KenkouKaruteRenkeiDATEntity getWriteLine内容() {
        KenkouKaruteRenkeiDATEntity 出力entity = new KenkouKaruteRenkeiDATEntity();
        if (RString.isNullOrEmpty(entity.getShikibetsuCode())) {
            出力entity.set個人番号(RString.HALF_SPACE);
        } else {
            出力entity.set個人番号(entity.getShikibetsuCode());
        }
        if (!RString.isNullOrEmpty(entity.getMeisho())) {
            出力entity.set漢字氏名_カナ氏名(entity.getMeisho());
        } else {
            出力entity.set漢字氏名_カナ氏名(entity.getKanaMeisho());
        }
        出力entity.set生年月日(get年月日(entity.getSeinengappiYMD()));
        出力entity.set性別(entity.getSeibetsuCode());
        if (!RString.isNullOrEmpty(entity.getHihokenshaNo())) {
            出力entity.set被保険者番号(entity.getHihokenshaNo());
        } else {
            出力entity.set被保険者番号(RString.HALF_SPACE);
        }
        出力entity.set資格取得日(get年月日(entity.getShikakuShutokuYMD()));
        出力entity.set資格喪失日(get年月日(entity.getShikakuSoshitsuYMD()));
        if (!RString.isNullOrEmpty(entity.getYokaigoJotaiKubunCode())) {
            出力entity.set要介護状態区分(entity.getYokaigoJotaiKubunCode());
        } else {
            出力entity.set要介護状態区分(RString.HALF_SPACE);
        }
        出力entity.set減額認定証受給者番号(RString.FULL_SPACE);
        出力entity.set認定年月日(get年月日(entity.getNinteiYMD()));
        出力entity.set認定有効期間開始日(get年月日(entity.getNinteiYukoKikanKaishiYMD()));
        出力entity.set認定有効期間終了日(get年月日(entity.getNinteiYukoKikanShuryoYMD()));
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
