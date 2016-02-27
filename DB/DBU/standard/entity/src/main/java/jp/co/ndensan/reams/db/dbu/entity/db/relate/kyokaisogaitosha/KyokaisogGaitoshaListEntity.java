/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * ビジネス設計_DBUMN52001_境界層管理マスタリスト_帳票データ作成クラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KyokaisogGaitoshaListEntity {

    private RString 市町村コード;
    private RString 市町村名;
    private RString 並び順;
    private RString 改頁;
    private List<KyokaisogGaitoshaRelateEntity> kyokaisokanrimasterList;

}
