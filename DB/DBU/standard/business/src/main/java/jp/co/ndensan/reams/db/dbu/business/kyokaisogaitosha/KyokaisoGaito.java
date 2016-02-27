/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.kyokaisogaitosha;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoHokenryoDankai;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoSochiShinsei;

/**
 * 境界層該当者情報を管理するビジネスです。
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyokaisoGaito {

    private List<KyokaisoGaitosha> 境界層該当者List;
    private List<KyokaisoHokenryoDankai> 境界層保険料段階List;
    private List<KyokaisoSochiShinsei> 境界層措置申請Lsit;
}
