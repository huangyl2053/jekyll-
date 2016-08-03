/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.imagedisplay;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * イメージ情報表示のパラメータクラスです。
 *
 * @reamsid_L DBE-3000-280 jinjue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ImageDisplayDataModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private RString イメージ共有ファイルID;
    private RString イメージ区分;
    private RString 証記載保険者番号_被保険者番号;
}
