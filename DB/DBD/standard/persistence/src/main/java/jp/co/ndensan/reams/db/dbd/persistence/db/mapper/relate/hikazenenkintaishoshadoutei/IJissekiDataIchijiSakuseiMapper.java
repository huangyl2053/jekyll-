/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hikazenenkintaishoshadoutei;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 実績データ一時作成のマッパーインタフェースです。
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
public interface IJissekiDataIchijiSakuseiMapper {

    List<RString> selectData();
    // TODO 実績データ一時作成について
}
