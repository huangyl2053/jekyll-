/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jyumikonyujyoho;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBU0600051_総合照会_住民固有情報Entity
 *
 * @reamsid_L DBU-4100-060 houtianpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JyuMiKoNyuJyoHoEntity {

    private FlexibleDate jukyuKaishiYMD;
    private FlexibleDate jukyuHaishiYMD;
    private FlexibleDate jukyuTeishiKaishiYMD;
    private FlexibleDate jukyuTeishiShuryoYMD;
    private FlexibleYearMonth tekiyoKaishiYM;
    private RString gengakuGoHokenryoDankai;
    private DbT1006KyokaisoGaitoshaEntity 境界層該当者Entity;
}
