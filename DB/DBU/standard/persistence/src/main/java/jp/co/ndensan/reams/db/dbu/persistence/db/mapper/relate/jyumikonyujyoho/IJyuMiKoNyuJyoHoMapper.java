/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jyumikonyujyoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jyumikonyujyoho.JyuMiKoNyuJyoHoParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jyumikonyujyoho.JyuMiKoNyuJyoHoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合照会_住民固有情報のMapper
 *
 * @reamsid_L DBU-4100-060 houtianpeng
 */
public interface IJyuMiKoNyuJyoHoMapper {

    /**
     * 生保受給者情報の取得。
     *
     * @param parameter JyuMiKoNyuJyoHoParameter
     * @return JyuMiKoNyuJyoHoEntity
     */
    JyuMiKoNyuJyoHoEntity get生保受給者情報(JyuMiKoNyuJyoHoParameter parameter);

    /**
     * 生活保護扶助種類TBLの取得。
     *
     * @param parameter JyuMiKoNyuJyoHoParameter
     * @return List<RString>
     */
    List<RString> get生活保護扶助種類(JyuMiKoNyuJyoHoParameter parameter);

    /**
     * 境界層管理情報取得。
     *
     * @param parameter JyuMiKoNyuJyoHoParameter
     * @return JyuMiKoNyuJyoHoEntity
     */
    JyuMiKoNyuJyoHoEntity get境界層管理情報取得(JyuMiKoNyuJyoHoParameter parameter);
}
